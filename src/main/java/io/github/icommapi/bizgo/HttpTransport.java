package io.github.icommapi.bizgo;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The HTTP layer under the client. The default sends requests with {@link java.net.http.HttpClient}; the testing
 * module ({@code io.github.icommapi.bizgo.testing.FakeTransport}) replaces it to run your code without a network.
 *
 * <p>Retries, the response envelope, error mapping, rate limiting and hooks stay in the client: an implementation
 * only performs one HTTP exchange. It receives the {@code Authorization} header (the API key) and the full URL
 * (whose query can contain phone numbers), so it must not log them, must not follow redirects, and must use TLS
 * for real servers.
 */
@FunctionalInterface
public interface HttpTransport {

    /**
     * Performs one HTTP exchange.
     *
     * @param request the request
     * @return the response (any status)
     * @throws IOException on a network error; throw {@link java.net.http.HttpTimeoutException} for a timeout
     * @throws InterruptedException if the thread is interrupted
     */
    Response execute(Request request) throws IOException, InterruptedException;

    /** One HTTP request. {@link #toString()} shows the method and the path only. */
    final class Request {
        private final String method;
        private final URI uri;
        private final Map<String, String> headers;
        private final byte[] body;
        private final Duration timeout;

        /**
         * Creates a request.
         *
         * @param method HTTP method
         * @param uri full URL including the query string
         * @param headers request headers
         * @param body request body, empty for none
         * @param timeout total timeout of this attempt
         */
        public Request(String method, URI uri, Map<String, String> headers, byte[] body, Duration timeout) {
            this.method = Objects.requireNonNull(method, "method");
            this.uri = Objects.requireNonNull(uri, "uri");
            this.headers = Collections.unmodifiableMap(new LinkedHashMap<>(headers));
            this.body = body == null ? new byte[0] : body.clone();
            this.timeout = timeout;
        }

        /**
         * HTTP method.
         *
         * @return method in upper case
         */
        public String method() {
            return method;
        }

        /**
         * Full URL. The query can contain personal data: do not log it.
         *
         * @return URL
         */
        public URI uri() {
            return uri;
        }

        /**
         * Headers, including {@code Authorization} (the API key): do not log them.
         *
         * @return unmodifiable map
         */
        public Map<String, String> headers() {
            return headers;
        }

        /**
         * Body bytes (a copy).
         *
         * @return body, empty for none
         */
        public byte[] body() {
            return body.clone();
        }

        /**
         * Total timeout of this attempt.
         *
         * @return timeout
         */
        public Duration timeout() {
            return timeout;
        }

        /** Method and path only: no query, headers or body. */
        @Override
        public String toString() {
            return "Request{" + method + " " + uri.getRawPath() + "}";
        }
    }

    /** One HTTP response. */
    final class Response {
        private final int status;
        private final Map<String, List<String>> headers;
        private final byte[] body;

        /**
         * Creates a response.
         *
         * @param status HTTP status
         * @param headers response headers (names are matched case-insensitively)
         * @param body body bytes, may be empty
         */
        public Response(int status, Map<String, List<String>> headers, byte[] body) {
            this.status = status;
            this.headers = headers == null ? Map.of() : Collections.unmodifiableMap(new LinkedHashMap<>(headers));
            this.body = body == null ? new byte[0] : body.clone();
        }

        /**
         * HTTP status.
         *
         * @return status
         */
        public int status() {
            return status;
        }

        /**
         * Response headers.
         *
         * @return unmodifiable map
         */
        public Map<String, List<String>> headers() {
            return headers;
        }

        /**
         * First value of a header, matched case-insensitively.
         *
         * @param name header name
         * @return the value, or null
         */
        public String header(String name) {
            for (Map.Entry<String, List<String>> e : headers.entrySet()) {
                if (e.getKey() != null && e.getKey().equalsIgnoreCase(name) && e.getValue() != null
                        && !e.getValue().isEmpty()) {
                    return e.getValue().get(0);
                }
            }
            return null;
        }

        /**
         * Body bytes (a copy).
         *
         * @return body
         */
        public byte[] body() {
            return body.clone();
        }

        byte[] bodyUnsafe() {
            return body;
        }

        @Override
        public String toString() {
            return "Response{status=" + status + ", bytes=" + body.length + "}";
        }
    }
}
