package io.github.icommapi.bizgo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/** Shared fixtures: a mock server, a client pointing at it, and recorded retry delays (no real sleeping). */
abstract class TestSupport {

    static final String API_KEY = "test-api-key-not-real";
    static final String PHONE = "01000000000";
    static final String OTHER_PHONE = "01000001234";

    MockServer server;
    Bizgo client;
    final List<Duration> delays = new CopyOnWriteArrayList<>();

    @BeforeEach
    void startServer() {
        server = new MockServer();
        client = clientBuilder().build();
    }

    @AfterEach
    void stopServer() {
        client.close();
        server.close();
    }

    Bizgo.Builder clientBuilder() {
        return Bizgo.builder()
                .apiKey(API_KEY)
                .baseUrl(server.baseUrl())
                .env(name -> null)
                .sleeper(delays::add)
                .rateLimit(null);
    }

    static Map<String, Object> envelope(Object data) {
        return envelope(data, "A000", null);
    }

    static Map<String, Object> envelope(Object data, String code, String ref) {
        Map<String, Object> inner = new LinkedHashMap<>();
        inner.put("code", code);
        inner.put("result", "A000".equals(code) ? "Success" : "Failed");
        if (data != null) {
            inner.put("data", data);
        }
        if (ref != null) {
            inner.put("ref", ref);
        }
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("common", Map.of("authCode", "A000", "authResult", "Success", "infobankTrId", "TR-TEST"));
        body.put("data", inner);
        return body;
    }

    static Map<String, Object> accepted(String... codes) {
        List<Map<String, Object>> destinations = new ArrayList<>();
        for (int i = 0; i < codes.length; i++) {
            destinations.add(Map.of("to", PHONE, "msgKey", String.format("KEY%03d", i), "code", codes[i],
                    "result", "r"));
        }
        return envelope(Map.of("destinations", destinations), "A000", "ref-1");
    }
}
