package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.github.icommapi.bizgo.internal.Json;
import io.github.icommapi.bizgo.models.SendOmniRequest;
import io.github.icommapi.bizgo.models.SmsMessage;
import io.github.icommapi.bizgo.testing.FakeTransport;
import io.github.icommapi.bizgo.testing.RecordedRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

/**
 * SDK-DESIGN 12.20: Bizgo rejects {@code idempotencyKey} without {@code idempotencyTtl} (A309, sandbox
 * 2026-09-28), so the SDK fills {@link Bizgo#DEFAULT_IDEMPOTENCY_TTL} when only the key is set.
 */
class IdempotencyTtlTest {

    private static final String PHONE = "01000000000";
    private static final SmsMessage SMS = SmsMessage.builder().from(PHONE).text("hello").build();

    @Test
    void constantIs24Hours() {
        assertEquals(86400, Bizgo.DEFAULT_IDEMPOTENCY_TTL);
    }

    private static JsonNode lastBody(FakeTransport fake) {
        List<RecordedRequest> requests = fake.requests("sendOmni");
        return requests.get(requests.size() - 1).getJsonBody();
    }

    @Test
    void keyWithoutTtlSends86400OnEverySendMethod() {
        FakeTransport fake = new FakeTransport();
        SendOptions key = SendOptions.idempotencyKey("order-1");
        try (Bizgo client = fake.client()) {
            client.send().omni(PHONE, List.of(SMS), key);
            assertEquals(86400, lastBody(fake).get("idempotencyTtl").asInt());
            client.send().sms(PHONE, PHONE, "hello", key);
            assertEquals(86400, lastBody(fake).get("idempotencyTtl").asInt());
            client.send().lms(PHONE, PHONE, "hello", "title", key);
            assertEquals(86400, lastBody(fake).get("idempotencyTtl").asInt());
            client.send().mms(PHONE, PHONE, "hello", List.of("FILE_KEY_EXAMPLE"), null, key);
            assertEquals(86400, lastBody(fake).get("idempotencyTtl").asInt());
            assertEquals("order-1", lastBody(fake).get("idempotencyKey").asText());
        }
    }

    @Test
    void explicitTtlIsKeptIncludingZero() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            client.send().sms(PHONE, PHONE, "hello",
                    SendOptions.builder().idempotencyKey("order-1").idempotencyTtl(600).build());
            assertEquals(600, lastBody(fake).get("idempotencyTtl").asInt());
            client.send().sms(PHONE, PHONE, "hello",
                    SendOptions.builder().idempotencyKey("order-2").idempotencyTtl(0).build());
            assertTrue(lastBody(fake).get("idempotencyTtl").isNumber());
            assertEquals(0, lastBody(fake).get("idempotencyTtl").asInt());
        }
    }

    @Test
    void noKeyNoTtl() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            client.send().sms(PHONE, PHONE, "hello");
            assertFalse(lastBody(fake).has("idempotencyTtl"));
            assertFalse(lastBody(fake).has("idempotencyKey"));
            // a TTL without a key is sent as given (nothing added or removed)
            client.send().sms(PHONE, PHONE, "hello", SendOptions.builder().idempotencyTtl(60).build());
            assertEquals(60, lastBody(fake).get("idempotencyTtl").asInt());
            assertFalse(lastBody(fake).has("idempotencyKey"));
        }
    }

    @Test
    void preparedRequestIsNotChanged() {
        FakeTransport fake = new FakeTransport();
        SendOmniRequest request = SendOmniRequest.fromJson("{\"destinations\":[{\"to\":\"01000000000\"}],"
                + "\"messageFlow\":[{\"sms\":{\"from\":\"01000000000\",\"text\":\"hello\"}}],"
                + "\"idempotencyKey\":\"order-1\"}");
        try (Bizgo client = fake.client()) {
            client.send().request(request);
        }
        assertEquals(86400, lastBody(fake).get("idempotencyTtl").asInt());
        assertEquals(null, request.getIdempotencyTtl());
    }

    @Test
    void rawMapBodyGetsDefaultWithoutMutatingInput() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("destinations", List.of(Map.of("to", PHONE)));
        body.put("messageFlow", List.of(Map.of("sms", Map.of("from", PHONE, "text", "hello"))));
        body.put("idempotencyKey", "order-1");
        Map<String, Object> before = new LinkedHashMap<>(body);

        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            client.send().request(SendOmniRequest.fromMap(body));
        }
        assertEquals(86400, lastBody(fake).get("idempotencyTtl").asInt());
        assertEquals(before, body);
        assertFalse(body.containsKey("idempotencyTtl"));
    }

    @Test
    void helperOnMapsAndTreesNeverMutatesInput() throws IOException {
        Map<String, Object> map = new TreeMap<>(Map.of("idempotencyKey", "k"));
        JsonNode sent = Json.readTree(Transport.Body.jsonWithDefaultTtl(map).bytes());
        assertEquals(86400, sent.get("idempotencyTtl").asInt());
        assertEquals(Map.of("idempotencyKey", "k"), map);

        ObjectNode tree = (ObjectNode) Json.readTree("{\"idempotencyKey\":\"k\",\"idempotencyTtl\":null}");
        sent = Json.readTree(Transport.Body.jsonWithDefaultTtl(tree).bytes());
        assertEquals(86400, sent.get("idempotencyTtl").asInt());
        assertTrue(tree.get("idempotencyTtl").isNull(), "the caller's JsonNode is not changed");

        sent = Json.readTree(Transport.Body.jsonWithDefaultTtl(Map.of("idempotencyKey", "k", "idempotencyTtl", 0))
                .bytes());
        assertEquals(0, sent.get("idempotencyTtl").asInt());
        sent = Json.readTree(Transport.Body.jsonWithDefaultTtl(Map.of("ref", "r")).bytes());
        assertFalse(sent.has("idempotencyTtl"));
    }

    @Test
    void bulkChunksWithPrefixGetDefaultOrExplicitTtl() {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            numbers.add(String.format("0100000%04d", i));
        }
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            client.send().bulk(numbers, List.of(SMS), BulkOptions.builder().idempotencyKeyPrefix("campaign").build());
        }
        List<RecordedRequest> requests = fake.requests("sendOmni");
        assertEquals(2, requests.size());
        for (RecordedRequest r : requests) {
            assertTrue(r.getJsonBody().hasNonNull("idempotencyKey"));
            assertEquals(86400, r.getJsonBody().get("idempotencyTtl").asInt());
        }

        FakeTransport explicit = new FakeTransport();
        try (Bizgo client = explicit.client()) {
            client.send().bulk(numbers, List.of(SMS),
                    BulkOptions.builder().idempotencyKeyPrefix("campaign").idempotencyTtl(0).build());
        }
        for (RecordedRequest r : explicit.requests("sendOmni")) {
            assertEquals(0, r.getJsonBody().get("idempotencyTtl").asInt());
        }

        FakeTransport none = new FakeTransport();
        try (Bizgo client = none.client()) {
            client.send().bulk(numbers, List.of(SMS), BulkOptions.DEFAULT);
        }
        for (RecordedRequest r : none.requests("sendOmni")) {
            assertFalse(r.getJsonBody().has("idempotencyKey"));
            assertFalse(r.getJsonBody().has("idempotencyTtl"));
        }
    }

    /** Generated operations whose request body has both fields must use the defaulting body helper. */
    @Test
    void generatedOperationsWithBothFieldsUseTheDefault() throws IOException {
        JsonNode spec = new ObjectMapper(new YAMLFactory()).readTree(Path.of("spec/openapi.yaml").toFile());
        JsonNode schemas = spec.at("/components/schemas");
        StringBuilder generated = new StringBuilder();
        try (var files = Files.list(Path.of("src/generated/java/io/github/icommapi/bizgo"))) {
            for (Path file : (Iterable<Path>) files.filter(p -> p.toString().endsWith("Service.java"))::iterator) {
                generated.append(Files.readString(file));
            }
        }
        List<String> both = new ArrayList<>();
        spec.path("paths").forEach(path -> path.forEach(op -> {
            JsonNode ref = op.at("/requestBody/content/application~1json/schema/$ref");
            if (ref.isTextual()) {
                String name = ref.asText().substring(ref.asText().lastIndexOf('/') + 1);
                Map<String, JsonNode> props = new LinkedHashMap<>();
                collect(schemas, schemas.path(name), props);
                if (props.containsKey("idempotencyKey") && props.containsKey("idempotencyTtl")) {
                    both.add(op.path("operationId").asText());
                }
            }
        }));
        assertTrue(both.contains("sendOmni"), "the send schema has both fields");
        for (String id : both) {
            if (id.equals("sendOmni")) {
                continue; // hand-written: SendService.request uses the same helper (tested above)
            }
            String constant = id.replaceAll("([a-z0-9])([A-Z])", "$1_$2").toUpperCase(java.util.Locale.ROOT);
            int at = generated.indexOf("Operations." + constant + ",");
            assertTrue(at >= 0, id);
            assertTrue(generated.substring(at, generated.indexOf(";", at)).contains("jsonWithDefaultTtl"), id);
        }
    }

    private static void collect(JsonNode schemas, JsonNode schema, Map<String, JsonNode> props) {
        for (JsonNode part : schema.path("allOf")) {
            JsonNode ref = part.path("$ref");
            collect(schemas, ref.isTextual() ? schemas.path(ref.asText().substring(ref.asText().lastIndexOf('/') + 1))
                    : part, props);
        }
        schema.path("properties").fieldNames().forEachRemaining(n -> props.put(n, schema.path("properties").get(n)));
    }
}
