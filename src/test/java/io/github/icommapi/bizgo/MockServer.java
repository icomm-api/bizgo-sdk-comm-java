package io.github.icommapi.bizgo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Local HTTP server for offline tests. Routes match the method and the raw (still encoded) path. A route answers
 * with its replies in order and repeats the last one.
 */
final class MockServer implements AutoCloseable {

    static final ObjectMapper JSON = new ObjectMapper();

    /** A recorded request. */
    record Request(String method, String rawPath, String rawQuery, Map<String, List<String>> headers, byte[] body) {

        String header(String name) {
            for (Map.Entry<String, List<String>> e : headers.entrySet()) {
                if (e.getKey().equalsIgnoreCase(name)) {
                    return e.getValue().get(0);
                }
            }
            return null;
        }

        Map<String, String> query() {
            Map<String, String> params = new LinkedHashMap<>();
            if (rawQuery == null || rawQuery.isEmpty()) {
                return params;
            }
            for (String pair : rawQuery.split("&")) {
                int eq = pair.indexOf('=');
                params.put(URLDecoder.decode(pair.substring(0, eq), StandardCharsets.UTF_8),
                        URLDecoder.decode(pair.substring(eq + 1), StandardCharsets.UTF_8));
            }
            return params;
        }

        String text() {
            return new String(body, StandardCharsets.UTF_8);
        }

        JsonNode json() {
            try {
                return JSON.readTree(body);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

    /** How to answer. */
    interface Reply {
        void send(HttpExchange exchange) throws IOException;
    }

    /** One route. */
    static final class Route {
        private final List<Reply> replies = new ArrayList<>();
        final List<Request> calls = new CopyOnWriteArrayList<>();

        Route reply(Reply... replies) {
            Collections.addAll(this.replies, replies);
            return this;
        }

        synchronized Reply next() {
            int index = Math.min(calls.size() - 1, replies.size() - 1);
            return replies.isEmpty() ? json(200, TestSupport.envelope(null)) : replies.get(Math.max(index, 0));
        }

        int count() {
            return calls.size();
        }

        Request last() {
            return calls.get(calls.size() - 1);
        }
    }

    private final HttpServer server;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final Map<String, Route> routes = new LinkedHashMap<>();
    final List<Request> requests = new CopyOnWriteArrayList<>();

    MockServer() {
        try {
            server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        server.setExecutor(executor);
        server.createContext("/", this::handle);
        server.start();
    }

    String baseUrl() {
        return "http://127.0.0.1:" + server.getAddress().getPort();
    }

    synchronized Route route(String method, String rawPath) {
        return routes.computeIfAbsent(method + " " + rawPath, k -> new Route());
    }

    private void handle(HttpExchange exchange) throws IOException {
        byte[] body;
        try (InputStream in = exchange.getRequestBody()) {
            body = in.readAllBytes();
        }
        Map<String, List<String>> headers = new LinkedHashMap<>();
        exchange.getRequestHeaders().forEach((k, v) -> headers.put(k, List.copyOf(v)));
        Request request = new Request(exchange.getRequestMethod(), exchange.getRequestURI().getRawPath(),
                exchange.getRequestURI().getRawQuery(), headers, body);
        requests.add(request);
        Route route;
        synchronized (this) {
            route = routes.get(request.method() + " " + request.rawPath());
        }
        if (route == null) {
            json(404, Map.of("common", Map.of("authCode", "A404", "authResult", "Not Found"))).send(exchange);
            return;
        }
        route.calls.add(request);
        route.next().send(exchange);
    }

    static Reply json(int status, Object body) {
        return json(status, body, Map.of());
    }

    static Reply json(int status, Object body, Map<String, String> headers) {
        return exchange -> {
            byte[] bytes = JSON.writeValueAsBytes(body);
            headers.forEach((k, v) -> exchange.getResponseHeaders().set(k, v));
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            write(exchange, status, bytes);
        };
    }

    static Reply text(int status, String body) {
        return exchange -> {
            exchange.getResponseHeaders().set("Content-Type", "text/html");
            write(exchange, status, body.getBytes(StandardCharsets.UTF_8));
        };
    }

    /** Closes the connection without an answer (the client sees an IOException). */
    static Reply disconnect() {
        return exchange -> {
            throw new IOException("mock: connection dropped");
        };
    }

    /** Answers after a delay (use a client timeout shorter than the delay to simulate a timeout). */
    static Reply delayed(Duration delay, Reply reply) {
        return exchange -> {
            try {
                Thread.sleep(delay.toMillis());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            try {
                reply.send(exchange);
            } catch (IOException ignored) {
                // the client gave up already
            }
        };
    }

    private static void write(HttpExchange exchange, int status, byte[] bytes) throws IOException {
        exchange.sendResponseHeaders(status, bytes.length == 0 ? -1 : bytes.length);
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bytes);
        }
    }

    @Override
    public void close() {
        server.stop(0);
        executor.shutdownNow();
    }
}
