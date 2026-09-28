package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.icommapi.bizgo.errors.ApiConnectionException;
import io.github.icommapi.bizgo.errors.ApiTimeoutException;
import io.github.icommapi.bizgo.errors.DuplicateRequestException;
import io.github.icommapi.bizgo.errors.InternalServerException;
import io.github.icommapi.bizgo.errors.RateLimitException;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.models.AlimtalkMessage;
import io.github.icommapi.bizgo.models.Destination;
import io.github.icommapi.bizgo.models.MmsMessage;
import io.github.icommapi.bizgo.models.RcsButton;
import io.github.icommapi.bizgo.models.RcsAction;
import io.github.icommapi.bizgo.models.RcsBody;
import io.github.icommapi.bizgo.models.RcsMessage;
import io.github.icommapi.bizgo.models.RcsSuggestion;
import io.github.icommapi.bizgo.models.RcsUrlAction;
import io.github.icommapi.bizgo.models.RcsUrlActionOpenUrl;
import io.github.icommapi.bizgo.models.SendOmniRequest;
import io.github.icommapi.bizgo.models.SendResult;
import io.github.icommapi.bizgo.models.SmsMessage;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SendTest extends TestSupport {

    private static final String PATH = "/api/comm/v1/send/omni";

    @Test
    void smsRequestBodyAndHeaders() throws Exception {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        SendResult result = client.send().sms(PHONE, PHONE, "인증번호는 123456 입니다.",
                SendOptions.builder().ref("ref-1").build());

        MockServer.Request request = route.last();
        assertEquals(API_KEY, request.header("Authorization"), "raw key, no prefix (verified on sandbox)");
        assertTrue(request.header("User-Agent").startsWith("bizgo-sdk-comm-java/" + Bizgo.VERSION + " java/"));
        assertEquals("application/json", request.header("Accept"));
        assertEquals("application/json", request.header("Content-Type"));
        assertEquals(MockServer.JSON.readTree("{\"destinations\":[{\"to\":\"01000000000\"}],"
                + "\"messageFlow\":[{\"sms\":{\"from\":\"01000000000\",\"text\":\"인증번호는 123456 입니다.\"}}],"
                + "\"ref\":\"ref-1\"}"), request.json());
        assertEquals(List.of("KEY000"), result.getMsgKeys());
        assertTrue(result.getFailed().isEmpty());
        assertEquals("ref-1", result.getRef());
        assertEquals("TR-TEST", result.getTrackingId());
    }

    @Test
    void fallbackFlowKeepsOrderAndOmitsUnsetDefaults() {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        client.send().omni(
                List.of(Destination.builder().to(PHONE).replaceWords(Map.of("name", "홍길동")).build()),
                List.of(
                        AlimtalkMessage.builder().senderKey("SENDER_KEY_EXAMPLE").templateCode("TEMPLATE_CODE_EXAMPLE")
                                .msgType("AT").text("#{name}님 주문 완료").build(),
                        SmsMessage.builder().from(PHONE).text("#{name}님 주문 완료").build()),
                SendOptions.idempotencyKey("order-1"));
        JsonNode body = route.last().json();
        assertEquals("alimtalk", body.get("messageFlow").get(0).fieldNames().next());
        assertEquals("sms", body.get("messageFlow").get(1).fieldNames().next());
        JsonNode alimtalk = body.get("messageFlow").get(0).get("alimtalk");
        // responseMethod / timeout have spec defaults but are not sent
        assertEquals(List.of("msgType", "senderKey", "templateCode", "text"), names(alimtalk));
        assertEquals("홍길동", body.get("destinations").get(0).get("replaceWords").get("name").asText());
        assertEquals("order-1", body.get("idempotencyKey").asText());
    }

    private static List<String> names(JsonNode node) {
        List<String> names = new ArrayList<>();
        node.fieldNames().forEachRemaining(names::add);
        return names;
    }

    @Test
    void partialFailureIsReportedPerRecipient() {
        server.route("POST", PATH).reply(MockServer.json(200, accepted("A000", "A306")));
        SendResult result = client.send().sms(List.of(PHONE, OTHER_PHONE), PHONE, "x", null);
        assertEquals(List.of("A306"), result.getFailed().stream().map(d -> d.getCode()).toList());
        assertEquals(1, result.getSucceeded().size());
    }

    @Test
    void mmsAndLms() {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        client.send().mms(PHONE, PHONE, "본문", List.of("FILE_KEY_001"), "제목", null);
        JsonNode mms = route.last().json().get("messageFlow").get(0).get("mms");
        assertEquals("FILE_KEY_001", mms.get("fileKey").get(0).asText());
        assertEquals("제목", mms.get("title").asText());
        client.send().lms(PHONE, PHONE, "본문");
        assertFalse(route.last().json().get("messageFlow").get(0).get("mms").has("fileKey"));
    }

    @Test
    void rcsButtonsAreSerialized() {
        // v1 silently dropped RCS buttons
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        RcsMessage rcs = RcsMessage.builder().from(PHONE).formatId("RCS_FORMAT_ID").brandKey("RCS_BRAND_KEY")
                .body(RcsBody.builder().description("본문").build())
                .buttons(RcsButton.builder().suggestions(RcsSuggestion.builder().displayText("열기")
                        .action(RcsAction.builder().urlAction(RcsUrlAction.builder()
                                .openUrl(RcsUrlActionOpenUrl.builder().url("https://example.com").build()).build())
                                .build())
                        .build()).build())
                .build();
        client.send().omni(PHONE, rcs);
        JsonNode suggestion = route.last().json().at("/messageFlow/0/rcs/buttons/0/suggestions/0");
        assertEquals("열기", suggestion.get("displayText").asText());
        assertEquals("https://example.com", suggestion.at("/action/urlAction/openUrl/url").asText());
    }

    static Stream<Arguments> tooLongOrUnencodable() {
        return Stream.of(Arguments.of("가".repeat(46), "최대 90byte인데 92byte"), Arguments.of("안녕😀", "EUC-KR"));
    }

    @ParameterizedTest
    @MethodSource("tooLongOrUnencodable")
    void smsByteLimitIsCheckedBeforeSending(String text, String message) {
        MockServer.Route route = server.route("POST", PATH);
        ValidationException e = assertThrows(ValidationException.class, () -> client.send().sms(PHONE, PHONE, text));
        assertTrue(e.getMessage().contains(message), e.getMessage());
        assertEquals(0, route.count());
    }

    @Test
    void smsLimitCountsBytesNotCharacters() {
        SmsMessage.builder().from(PHONE).text("가".repeat(45)).build(); // 90 bytes: ok
        SmsMessage.builder().from(PHONE).text("a".repeat(90)).build();
        MmsMessage.builder().from(PHONE).text("가".repeat(1000)).build(); // 2,000 bytes: ok
        assertThrows(ValidationException.class, () -> MmsMessage.builder().from(PHONE).text("가".repeat(1001)).build());
        assertThrows(ValidationException.class, () -> SmsMessage.builder().from(PHONE).text("a".repeat(91)).build());
    }

    @Test
    void unknownFieldsAreRejected() {
        ValidationException e = assertThrows(ValidationException.class, () -> SendOmniRequest.fromJson(
                "{\"destinations\":[{\"to\":\"01000000000\"}],\"messageFlow\":[{\"alimtalk\":"
                        + "{\"senderKey\":\"S\",\"templateCode\":\"T\",\"templatecode\":\"typo\"}}]}"));
        assertTrue(e.getMessage().contains("알 수 없는 필드"), e.getMessage());
        assertTrue(e.getMessage().contains("messageFlow[0].alimtalk.templatecode"), e.getMessage());
    }

    @Test
    void moreThan200RecipientsAreRejected() {
        List<String> to = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            to.add(String.format("010%08d", i));
        }
        ValidationException e = assertThrows(ValidationException.class, () -> client.send().sms(to, PHONE, "x", null));
        assertTrue(e.getMessage().contains("SendOmniRequest.destinations"), e.getMessage());
        assertEquals(0, server.requests.size());
    }

    @Test
    void messageFlowItemNeedsExactlyOneChannel() {
        ValidationException e = assertThrows(ValidationException.class, () -> SendOmniRequest.fromMap(Map.of(
                "destinations", List.of(Map.of("to", PHONE)),
                "messageFlow", List.of(Map.of("sms", Map.of("from", "1", "text", "x"),
                        "mms", Map.of("from", "1", "text", "x"))))));
        assertTrue(e.getMessage().contains("정확히 하나"), e.getMessage());
        assertThrows(ValidationException.class, () -> SendOmniRequest.fromJson(
                "{\"destinations\":[{\"to\":\"01000000000\"}],\"messageFlow\":[{}]}"));
    }

    @Test
    void validationErrorsDoNotEchoInput() {
        ValidationException e = assertThrows(ValidationException.class,
                () -> client.send().sms(OTHER_PHONE, PHONE, "😀"));
        assertFalse(e.getMessage().contains(OTHER_PHONE));
        assertFalse(e.getMessage().contains("😀"));
        ValidationException typed = assertThrows(ValidationException.class, () -> SendOmniRequest.fromJson(
                "{\"destinations\":[{\"to\":1000001234}],\"messageFlow\":[{\"sms\":{\"from\":\"1\",\"text\":\"x\"}}]}"));
        assertFalse(typed.getMessage().contains("1000001234"), typed.getMessage());
        assertTrue(typed.getMessage().contains("destinations[0].to"), typed.getMessage());
    }

    @Test
    void emptyMessagesAreRejected() {
        assertThrows(ValidationException.class, () -> client.send().omni(PHONE));
        assertThrows(ValidationException.class, () -> client.send().omni(PHONE, (SmsMessage) null));
    }

    @Test
    void sendWithoutIdempotencyKeyIsNotRetriedAfterTimeout() {
        try (Bizgo fast = clientBuilder().timeout(Duration.ofMillis(300)).build()) {
            MockServer.Route route = server.route("POST", PATH)
                    .reply(MockServer.delayed(Duration.ofSeconds(2), MockServer.json(200, accepted("A000"))));
            assertThrows(ApiTimeoutException.class, () -> fast.send().sms(PHONE, PHONE, "x"));
            assertEquals(1, route.count());
        }
    }

    @Test
    void sendWithIdempotencyKeyIsRetriedAfterTimeout() {
        try (Bizgo fast = clientBuilder().timeout(Duration.ofMillis(300)).build()) {
            MockServer.Route route = server.route("POST", PATH).reply(
                    MockServer.delayed(Duration.ofSeconds(2), MockServer.json(200, accepted("A000"))),
                    MockServer.json(200, accepted("A000")));
            SendResult result = fast.send().sms(PHONE, PHONE, "x", SendOptions.idempotencyKey("k-1"));
            assertEquals(2, route.count());
            assertEquals(List.of("KEY000"), result.getMsgKeys());
        }
    }

    @Test
    void sendWithoutIdempotencyKeyIsNotRetriedOnServerError() {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.text(503, "unavailable"));
        assertThrows(InternalServerException.class, () -> client.send().sms(PHONE, PHONE, "x"));
        assertEquals(1, route.count());
    }

    @Test
    void sendWithoutIdempotencyKeyIsNotRetriedAfterConnectionError() {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.disconnect());
        assertThrows(ApiConnectionException.class, () -> client.send().sms(PHONE, PHONE, "x"));
        assertEquals(1, route.count());
    }

    @Test
    void duplicateAfterLostResponseExplainsWhatHappened() {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.disconnect(),
                MockServer.json(200, envelope(null, "A301", null)));
        DuplicateRequestException e = assertThrows(DuplicateRequestException.class,
                () -> client.send().sms(PHONE, PHONE, "x", SendOptions.idempotencyKey("k-1")));
        assertTrue(e.getMessage().contains("이미 접수"), e.getMessage());
        assertEquals(2, route.count());
    }

    @Test
    void rateLimitIsRetriedWithRetryAfter() {
        MockServer.Route route = server.route("POST", PATH).reply(
                MockServer.json(429, Map.of("common", Map.of("authCode", "A020", "authResult", "Ratelimit")),
                        Map.of("Retry-After", "2")),
                MockServer.json(200, accepted("A000")));
        client.send().sms(PHONE, PHONE, "x");
        assertEquals(2, route.count());
        assertEquals(List.of(Duration.ofSeconds(2)), delays);
    }

    @Test
    void rateLimitGivesUpAfterMaxRetries() {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.json(429,
                Map.of("data", Map.of("code", "A020", "result", "Number of 'Ratelimit' exceeded"))));
        RateLimitException e = assertThrows(RateLimitException.class, () -> client.send().sms(PHONE, PHONE, "x"));
        assertEquals(3, route.count(), "1 + maxRetries(2)");
        assertTrue(e.getRetryAfter().isEmpty());
        assertEquals(2, delays.size());
        // exponential backoff with jitter: 0.5s * 2^attempt * (0.75..1.25)
        assertTrue(delays.get(0).toMillis() >= 375 && delays.get(0).toMillis() <= 625, delays.toString());
        assertTrue(delays.get(1).toMillis() >= 750 && delays.get(1).toMillis() <= 1250, delays.toString());
    }

    @Test
    void clientsKeepTheirOwnKeysConcurrently() throws Exception {
        // 1.1.x shared a static token between clients; each 1.2.0 client sends its own key
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        try (Bizgo other = clientBuilder().apiKey("second-test-key-not-real").build()) {
            ExecutorService pool = Executors.newFixedThreadPool(8);
            try {
                List<Future<?>> futures = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    Bizgo c = i % 2 == 0 ? client : other;
                    futures.add(pool.submit(() -> c.send().sms(PHONE, PHONE, "x")));
                }
                for (Future<?> f : futures) {
                    f.get();
                }
            } finally {
                pool.shutdownNow();
            }
        }
        long first = route.calls.stream().filter(r -> API_KEY.equals(r.header("Authorization"))).count();
        long second = route.calls.stream().filter(r -> "second-test-key-not-real".equals(r.header("Authorization")))
                .count();
        assertEquals(10, first);
        assertEquals(10, second);
    }

    @Test
    void requestFromJsonIsSentAsIs() throws Exception {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        String json = "{\"destinations\":[{\"to\":\"01000000000\"}],"
                + "\"messageFlow\":[{\"sms\":{\"from\":\"01000000000\",\"text\":\"x\"}}],\"idempotencyTtl\":60}";
        client.send().request(SendOmniRequest.fromJson(json));
        assertEquals(MockServer.JSON.readTree(json), route.last().json());
    }
}
