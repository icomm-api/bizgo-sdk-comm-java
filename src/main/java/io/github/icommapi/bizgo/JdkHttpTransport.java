package io.github.icommapi.bizgo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Default {@link HttpTransport} on {@link HttpClient}. The response body is limited to
 * {@link Transport#MAX_RESPONSE_BYTES}. Exceptions are rethrown without their message (it can contain the URL).
 */
final class JdkHttpTransport implements HttpTransport, AutoCloseable {

    private final HttpClient client;
    private final boolean owns;

    JdkHttpTransport(HttpClient client, boolean owns) {
        this.client = client;
        this.owns = owns;
    }

    @Override
    public Response execute(Request request) throws IOException, InterruptedException {
        HttpRequest.Builder builder = HttpRequest.newBuilder(request.uri()).timeout(request.timeout());
        request.headers().forEach(builder::header);
        byte[] body = request.body();
        builder.method(request.method(), body.length == 0 && !request.headers().containsKey("Content-Type")
                ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofByteArray(body));
        CompletableFuture<HttpResponse<byte[]>> future = client.sendAsync(builder.build(), info -> new LimitedBody());
        HttpResponse<byte[]> response;
        try {
            response = future.get(request.timeout().toMillis(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
            throw new HttpTimeoutException("TimeoutException");
        } catch (InterruptedException e) {
            future.cancel(true);
            throw e;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            while (cause instanceof CompletionException && cause.getCause() != null) {
                cause = cause.getCause();
            }
            if (cause instanceof HttpTimeoutException) {
                throw new HttpTimeoutException(cause.getClass().getSimpleName());
            }
            if (cause instanceof IOException) {
                // the message can contain the URL: keep the type, drop the message
                throw new IOException(cause.getClass().getSimpleName());
            }
            throw new IOException(cause == null ? "ExecutionException" : cause.getClass().getSimpleName());
        }
        Map<String, List<String>> headers = response.headers().map();
        return new Response(response.statusCode(), headers, response.body());
    }

    @Override
    public void close() {
        if (owns && client instanceof AutoCloseable) { // HttpClient is AutoCloseable since Java 21
            try {
                ((AutoCloseable) client).close();
            } catch (Exception ignored) {
                // nothing useful to report
            }
        }
    }

    @Override
    public String toString() {
        return "JdkHttpTransport";
    }

    /** Buffers the response body up to {@link Transport#MAX_RESPONSE_BYTES}, so a broken server cannot exhaust memory. */
    private static final class LimitedBody implements HttpResponse.BodySubscriber<byte[]> {
        private final CompletableFuture<byte[]> result = new CompletableFuture<>();
        private final ByteArrayOutputStream out = new ByteArrayOutputStream();
        private Flow.Subscription subscription;

        @Override
        public CompletionStage<byte[]> getBody() {
            return result;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            subscription.request(Long.MAX_VALUE);
        }

        @Override
        public void onNext(List<ByteBuffer> items) {
            if (result.isDone()) {
                return;
            }
            for (ByteBuffer buffer : items) {
                if ((long) out.size() + buffer.remaining() > Transport.MAX_RESPONSE_BYTES) {
                    subscription.cancel();
                    result.completeExceptionally(new IOException("response body too large"));
                    return;
                }
                byte[] chunk = new byte[buffer.remaining()];
                buffer.get(chunk);
                out.write(chunk, 0, chunk.length);
            }
        }

        @Override
        public void onError(Throwable throwable) {
            result.completeExceptionally(throwable);
        }

        @Override
        public void onComplete() {
            result.complete(out.toByteArray());
        }
    }
}
