package io.github.icommapi.bizgo.testing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.HttpTransport;
import io.github.icommapi.bizgo.Operation;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * An in-memory {@link HttpTransport} for testing code that uses the SDK, without a network or an API key.
 *
 * <pre>{@code
 * FakeTransport fake = new FakeTransport();
 * Bizgo client = fake.client();                        // placeholder key, no rate limit, never connects
 *
 * client.send().sms("01000000000", "01000000000", "hello");   // default: every recipient accepted (A000)
 * assertEquals("sendOmni", fake.lastRequest().getOperationId());
 *
 * fake.on("sendOmni").thenFail(ErrorLayer.SERVICE, 200, "A020");    // next call: rate limited
 * fake.on("sendOmni").thenSendResult("A000", "A306");               // then: second recipient rejected
 * fake.on("sendOmni").thenSendResult("A000", "A301");               // second recipient already accepted (duplicate)
 * fake.on("sendOmni").thenDuplicateSendResult();                    // same idempotencyKey again: all A301
 * }</pre>
 *
 * <p>Every request is recorded ({@link #requests()}) with its operation, method, path, query and JSON body. Header
 * values (including the API key) are not recorded. Without a stub, an operation answers with a success envelope:
 * sends ({@code sendOmni}, {@code createReservation}, {@code addReservationRecipients}) return {@code A000} and a
 * fake {@code msgKey} per recipient, uploads return a fake {@code fileKey}/{@code media}/{@code imgUrl}, other
 * operations return {@code data.data = {}} (empty lists, no next page).
 * An unknown path answers HTTP 404. Thread-safe.
 */
public final class FakeTransport implements HttpTransport {

    /** The placeholder API key {@link #client()} uses. */
    public static final String FAKE_API_KEY = "test-api-key-not-real";

    static final ObjectMapper JSON = new ObjectMapper();

    private final List<RecordedRequest> requests = new ArrayList<>();
    private final Map<String, Deque<Reply>> stubs = new HashMap<>();
    private long msgKeySequence;
    private long uploadSequence;

    /** Creates a fake with no stubs. */
    public FakeTransport() {
    }

    /**
     * A client that talks to this fake: placeholder key, client-side rate limit off.
     *
     * @return a new client
     */
    public Bizgo client() {
        return clientBuilder().build();
    }

    /**
     * A client builder preset for this fake, so you can change other settings ({@code maxRetries}, hooks, ...).
     *
     * @return builder
     */
    public Bizgo.Builder clientBuilder() {
        return Bizgo.builder().apiKey(FAKE_API_KEY).httpTransport(this).rateLimit(null);
    }

    /**
     * Stubs the responses of an operation. Responses are used in order; the last one repeats.
     *
     * @param operationId for example {@code sendOmni} or {@code listAlimtalkTemplates}
     * @return the stub to add responses to
     * @throws IllegalArgumentException if the spec has no such operation
     */
    public Stub on(String operationId) {
        Operation.find(operationId).orElseThrow(() -> new IllegalArgumentException("unknown operation: " + operationId));
        return new Stub(operationId);
    }

    /**
     * Stubs the responses of an operation given by HTTP method and path template.
     *
     * @param httpMethod {@code GET}, {@code POST}, ...
     * @param pathTemplate for example {@code /api/comm/v1/report/inquiry/{msgKey}}
     * @return the stub
     * @throws IllegalArgumentException if the spec has no such operation
     */
    public Stub on(String httpMethod, String pathTemplate) {
        for (Operation op : Operation.all()) {
            if (op.getHttpMethod().equalsIgnoreCase(httpMethod) && op.getPathTemplate().equals(pathTemplate)) {
                return new Stub(op.getOperationId());
            }
        }
        throw new IllegalArgumentException("unknown operation: " + httpMethod + " " + pathTemplate);
    }

    /**
     * Every request received, in order.
     *
     * @return a snapshot
     */
    public synchronized List<RecordedRequest> requests() {
        return List.copyOf(requests);
    }

    /**
     * Requests of one operation.
     *
     * @param operationId operation id
     * @return a snapshot, in order
     */
    public synchronized List<RecordedRequest> requests(String operationId) {
        return requests.stream().filter(r -> operationId.equals(r.getOperationId())).collect(Collectors.toList());
    }

    /**
     * The last request.
     *
     * @return the request
     * @throws IllegalStateException if there was none
     */
    public synchronized RecordedRequest lastRequest() {
        if (requests.isEmpty()) {
            throw new IllegalStateException("no request was made");
        }
        return requests.get(requests.size() - 1);
    }

    /** Forgets the recorded requests and all stubs. */
    public synchronized void reset() {
        requests.clear();
        stubs.clear();
        msgKeySequence = 0;
        uploadSequence = 0;
    }

    @Override
    public Response execute(Request request) throws IOException {
        String path = request.uri().getRawPath();
        Operation op = Operation.match(request.method(), path).orElse(null);
        String contentType = request.headers().getOrDefault("Content-Type", null);
        byte[] body = request.body();
        JsonNode json = null;
        if (contentType != null && contentType.startsWith("application/json") && body.length > 0) {
            json = JSON.readTree(body);
        }
        RecordedRequest recorded = new RecordedRequest(op, request.method(), path, query(request.uri().getRawQuery()),
                json, contentType, body);
        Reply reply;
        synchronized (this) {
            requests.add(recorded);
            reply = op == null ? null : next(op.getOperationId());
        }
        if (op == null) {
            return json(404, errorEnvelope(ErrorLayer.GATEWAY, "A404", "Not Found"), Map.of());
        }
        if (reply == null) {
            return json(200, defaultBody(op, json), Map.of());
        }
        return reply.respond(this, recorded);
    }

    private Reply next(String operationId) {
        Deque<Reply> queue = stubs.get(operationId);
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        return queue.size() > 1 ? queue.pollFirst() : queue.peekFirst();
    }

    private static Map<String, String> query(String raw) {
        Map<String, String> params = new LinkedHashMap<>();
        if (raw == null || raw.isEmpty()) {
            return Collections.unmodifiableMap(params);
        }
        for (String pair : raw.split("&")) {
            int eq = pair.indexOf('=');
            String key = eq < 0 ? pair : pair.substring(0, eq);
            String value = eq < 0 ? "" : pair.substring(eq + 1);
            params.put(URLDecoder.decode(key, StandardCharsets.UTF_8), URLDecoder.decode(value, StandardCharsets.UTF_8));
        }
        return Collections.unmodifiableMap(params);
    }

    private ObjectNode defaultBody(Operation op, JsonNode request) {
        switch (op.getOperationId()) {
            case "sendOmni":
            case "createReservation":
            case "addReservationRecipients":
                List<String> codes = new ArrayList<>();
                JsonNode destinations = request == null ? null : request.get("destinations");
                int count = destinations != null && destinations.isArray() ? destinations.size() : 1;
                for (int i = 0; i < count; i++) {
                    codes.add("A000");
                }
                ObjectNode sent = sendBody(request, codes);
                if ("createReservation".equals(op.getOperationId())) {
                    // the reservation key sits next to data.data (data.resvKey)
                    ((ObjectNode) sent.get("data")).put("resvKey", "FAKE-RESVKEY-000001");
                }
                return sent;
            default:
                if (op.getMethod().startsWith("upload")) {
                    // uploads: a fake key for every upload response model (unknown fields are kept by the models)
                    ObjectNode file = JSON.createObjectNode();
                    long n = nextUpload();
                    file.put("fileKey", String.format(Locale.ROOT, "FAKE-FILEKEY-%06d", n));
                    file.put("media", String.format(Locale.ROOT, "maapfile://FAKE-MEDIA-%06d", n));
                    file.put("imgUrl", String.format(Locale.ROOT, "https://example.invalid/fake-image-%06d.jpg", n));
                    file.put("expired", "2099-12-31 23:59:59");
                    return FakeResponses.successNode(file);
                }
                return FakeResponses.successNode(JSON.createObjectNode());
        }
    }

    private synchronized long nextUpload() {
        return ++uploadSequence;
    }

    synchronized ObjectNode sendBody(JsonNode request, List<String> codes) {
        ArrayNode list = JSON.createArrayNode();
        JsonNode destinations = request == null ? null : request.get("destinations");
        for (int i = 0; i < codes.size(); i++) {
            ObjectNode d = list.addObject();
            JsonNode given = destinations != null && destinations.has(i) ? destinations.get(i) : null;
            if (given != null && given.hasNonNull("to")) {
                d.set("to", given.get("to"));
            }
            if (given != null && given.hasNonNull("ref")) {
                d.set("ref", given.get("ref"));
            }
            d.put("msgKey", String.format(Locale.ROOT, "FAKE-MSGKEY-%06d", ++msgKeySequence));
            d.put("code", codes.get(i));
            String code = codes.get(i);
            d.put("result", "A000".equals(code) ? "Success" : "A301".equals(code) ? "Duplicated" : "Failed");
        }
        ObjectNode data = JSON.createObjectNode();
        data.set("destinations", list);
        ObjectNode body = FakeResponses.successNode(data);
        if (request != null && request.hasNonNull("ref")) {
            ((ObjectNode) body.get("data")).set("ref", request.get("ref"));
        }
        return body;
    }

    static ObjectNode errorEnvelope(ErrorLayer layer, String code, String message) {
        ObjectNode body = JSON.createObjectNode();
        ObjectNode common = body.putObject("common");
        if (layer == ErrorLayer.GATEWAY) {
            common.put("authCode", code);
            common.put("authResult", message);
            common.put("infobankTrId", "FAKE-TR-ID");
        } else {
            common.put("authCode", "A000");
            common.put("authResult", "Success");
            common.put("infobankTrId", "FAKE-TR-ID");
            ObjectNode data = body.putObject("data");
            data.put("code", code);
            data.put("result", message);
        }
        return body;
    }

    static Response json(int status, JsonNode body, Map<String, String> headers) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        map.put("Content-Type", List.of("application/json"));
        headers.forEach((k, v) -> map.put(k, List.of(v)));
        try {
            return new Response(status, map, JSON.writeValueAsBytes(body));
        } catch (IOException e) {
            throw new IllegalStateException("cannot serialize a fake response");
        }
    }

    @Override
    public synchronized String toString() {
        return "FakeTransport{requests=" + requests.size() + "}";
    }

    /** One stubbed response. */
    @FunctionalInterface
    interface Reply {
        Response respond(FakeTransport fake, RecordedRequest request) throws IOException;
    }

    /**
     * Responses for one operation. Each {@code then...} call adds one response; the last one repeats.
     */
    public final class Stub {
        private final String operationId;

        private Stub(String operationId) {
            this.operationId = operationId;
        }

        private Stub add(Reply reply) {
            synchronized (FakeTransport.this) {
                stubs.computeIfAbsent(operationId, k -> new ArrayDeque<>()).addLast(reply);
            }
            return this;
        }

        /**
         * Answers with a raw status and JSON body.
         *
         * @param status HTTP status
         * @param json response body
         * @return this stub
         */
        public Stub thenRespond(int status, String json) {
            JsonNode node;
            try {
                node = JSON.readTree(json);
            } catch (IOException e) {
                throw new IllegalArgumentException("not JSON");
            }
            return add((fake, request) -> FakeTransport.json(status, node, Map.of()));
        }

        /**
         * Answers HTTP 200 with a success envelope around {@code data} ({@code data.data}).
         *
         * @param dataJson JSON of {@code data.data}
         * @return this stub
         */
        public Stub thenData(String dataJson) {
            return thenRespond(200, FakeResponses.success(dataJson));
        }

        /**
         * Answers a send with one result per code, for example {@code thenSendResult("A000", "A306")}. Use
         * {@code A301} for a recipient already accepted with the same idempotency key (it ends up in
         * {@code getDuplicates()}).
         *
         * @param codes per-recipient codes
         * @return this stub
         */
        public Stub thenSendResult(String... codes) {
            List<String> list = List.of(codes);
            return add((fake, request) -> FakeTransport.json(200, fake.sendBody(request.getJsonBody(), list),
                    Map.of()));
        }

        /**
         * Answers a send as a repeat of an already accepted request: HTTP 200 and per-recipient code {@code A301}
         * for every recipient of the request (what Bizgo returns for a reused {@code idempotencyKey}).
         *
         * @return this stub
         */
        public Stub thenDuplicateSendResult() {
            return add((fake, request) -> {
                JsonNode body = request.getJsonBody();
                JsonNode destinations = body == null ? null : body.get("destinations");
                int count = destinations != null && destinations.isArray() ? destinations.size() : 1;
                return FakeTransport.json(200, fake.sendBody(body, java.util.Collections.nCopies(count, "A301")),
                        Map.of());
            });
        }

        /**
         * Answers with an API error. A gateway error is {@code common.authCode}; a service error is
         * {@code data.code}. Retryable statuses (429, 5xx) carry {@code Retry-After: 0} so tests do not wait.
         *
         * @param layer {@link ErrorLayer#GATEWAY} or {@link ErrorLayer#SERVICE}
         * @param status HTTP status (service errors are often reported with 200)
         * @param code result code, for example {@code A020}, {@code A401}, {@code A306}
         * @return this stub
         */
        public Stub thenFail(ErrorLayer layer, int status, String code) {
            ObjectNode body = errorEnvelope(layer, code, "Fake error " + code);
            Map<String, String> headers = status == 429 || status >= 500 ? Map.of("Retry-After", "0") : Map.of();
            return add((fake, request) -> FakeTransport.json(status, body, headers));
        }

        /**
         * Simulates a network error (the client throws {@code ApiConnectionException}, or retries safe calls).
         *
         * @return this stub
         */
        public Stub thenNetworkError() {
            return add((fake, request) -> {
                throw new IOException("fake network error");
            });
        }

        /**
         * Simulates a timeout ({@code ApiTimeoutException}).
         *
         * @return this stub
         */
        public Stub thenTimeout() {
            return add((fake, request) -> {
                throw new java.net.http.HttpTimeoutException("fake timeout");
            });
        }

        /**
         * Goes back to the default success response after the stubbed ones.
         *
         * @return this stub
         */
        public Stub thenDefault() {
            return add((fake, request) -> FakeTransport.json(200,
                    fake.defaultBody(request.getOperation(), request.getJsonBody()), Map.of()));
        }
    }
}
