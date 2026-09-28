package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.WebhookVerificationException;
import io.github.icommapi.bizgo.models.MoWebhookPayload;
import io.github.icommapi.bizgo.models.ReportWebhookPayload;
import io.github.icommapi.bizgo.webhooks.WebhookReceiver;
import io.github.icommapi.bizgo.webhooks.Webhooks;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.HexFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WebhooksTest {

    private static final String SECRET = "test-webhook-secret";
    private static final byte[] SECRET_BYTES = SECRET.getBytes(StandardCharsets.UTF_8);
    private static final Instant NOW = Instant.ofEpochSecond(1743381600L);
    private static final String TIMESTAMP = "1743381600000"; // epoch ms, as in the API reference example
    private static final byte[] BODY = ("{\"msgKey\":\"KEY001\",\"serviceType\":\"SMS\",\"reportTime\":\"t\","
            + "\"reportType\":\"0\",\"reportCode\":\"10000\"}").getBytes(StandardCharsets.UTF_8);

    static byte[] sign(String timestamp, String secret) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        return mac.doFinal(timestamp.getBytes(StandardCharsets.US_ASCII));
    }

    static Stream<Arguments> encodings() {
        Function<byte[], String> hex = d -> HexFormat.of().formatHex(d);
        return Stream.of(
                Arguments.of(hex),
                Arguments.of(hex.andThen(s -> s.toUpperCase(Locale.ROOT))),
                Arguments.of((Function<byte[], String>) d -> Base64.getEncoder().encodeToString(d)),
                Arguments.of(hex.andThen(s -> " " + s + " ")));
    }

    @ParameterizedTest
    @MethodSource("encodings")
    void validSignatureEncodings(Function<byte[], String> encode) throws Exception {
        String signature = encode.apply(sign(TIMESTAMP, SECRET));
        assertDoesNotThrow(() -> Webhooks.verifySignature(SECRET_BYTES, TIMESTAMP, signature,
                Webhooks.DEFAULT_TOLERANCE, NOW));
    }

    @ParameterizedTest
    @ValueSource(strings = {"sha256=", "SHA256="})
    void prefixedSignatureIsRejected(String prefix) throws Exception {
        String signature = prefix + HexFormat.of().formatHex(sign(TIMESTAMP, SECRET));
        WebhookVerificationException e = assertThrows(WebhookVerificationException.class,
                () -> Webhooks.verifySignature(SECRET_BYTES, TIMESTAMP, signature, Webhooks.DEFAULT_TOLERANCE, NOW));
        assertTrue(e.getMessage().contains("일치하지"));
    }

    @Test
    void wrongSecretIsRejected() throws Exception {
        String signature = HexFormat.of().formatHex(sign(TIMESTAMP, "other"));
        WebhookVerificationException e = assertThrows(WebhookVerificationException.class,
                () -> Webhooks.verifySignature(SECRET_BYTES, TIMESTAMP, signature, Webhooks.DEFAULT_TOLERANCE, NOW));
        assertTrue(e.getMessage().contains("일치하지"));
        assertFalse(e.getMessage().contains(SECRET));
    }

    @Test
    void oldTimestampIsRejectedToLimitReplay() throws Exception {
        String signature = HexFormat.of().formatHex(sign(TIMESTAMP, SECRET));
        WebhookVerificationException e = assertThrows(WebhookVerificationException.class,
                () -> Webhooks.verifySignature(SECRET_BYTES, TIMESTAMP, signature, Webhooks.DEFAULT_TOLERANCE,
                        NOW.plusSeconds(301)));
        assertTrue(e.getMessage().contains("허용 범위"));
        assertDoesNotThrow(() -> Webhooks.verifySignature(SECRET_BYTES, TIMESTAMP, signature,
                Webhooks.DEFAULT_TOLERANCE, NOW.minusSeconds(300)));
        assertDoesNotThrow(() -> Webhooks.verifySignature(SECRET_BYTES, TIMESTAMP, signature, null,
                NOW.plusSeconds(100_000)));
    }

    @Test
    void secondsTimestampIsAccepted() throws Exception {
        String signature = HexFormat.of().formatHex(sign("1743381600", SECRET));
        assertDoesNotThrow(() -> Webhooks.verifySignature(SECRET_BYTES, "1743381600", signature,
                Webhooks.DEFAULT_TOLERANCE, NOW));
    }

    static Stream<Arguments> malformed() {
        return Stream.of(Arguments.of("", "x"), Arguments.of("abc", "x"), Arguments.of(TIMESTAMP, ""),
                Arguments.of("-1743381600", "x"), Arguments.of("99999999999999999999999", "x"),
                Arguments.of(TIMESTAMP, "not-hex-or-base64!"));
    }

    @ParameterizedTest
    @MethodSource("malformed")
    void missingOrMalformedHeaders(String timestamp, String signature) {
        assertThrows(WebhookVerificationException.class, () -> Webhooks.verifySignature(SECRET_BYTES, timestamp,
                signature, Webhooks.DEFAULT_TOLERANCE, NOW));
        assertThrows(WebhookVerificationException.class, () -> Webhooks.verifySignature(new byte[0], TIMESTAMP,
                "x", Webhooks.DEFAULT_TOLERANCE, NOW));
    }

    @Test
    void receiverVerifiesThenParses() throws Exception {
        WebhookReceiver receiver = new WebhookReceiver(SECRET_BYTES, Webhooks.DEFAULT_TOLERANCE,
                Clock.fixed(NOW, ZoneOffset.UTC));
        String signature = HexFormat.of().formatHex(sign(TIMESTAMP, SECRET));
        // header names are case-insensitive; list values (servlet / HttpServer style) are accepted
        Map<String, Object> headers = Map.of("x-ib-timestamp", TIMESTAMP, "X-IB-SIGNATURE", List.of(signature));
        ReportWebhookPayload report = receiver.report(headers, BODY);
        assertEquals("KEY001", report.getMsgKey());
        assertEquals(Map.of("msgKey", "KEY001"), receiver.ack(report.getMsgKey()));
        assertFalse(receiver.toString().contains(SECRET));
    }

    @Test
    void receiverRejectsUnsignedRequests() {
        WebhookReceiver receiver = new WebhookReceiver(SECRET);
        assertThrows(WebhookVerificationException.class, () -> receiver.report(Map.of(), BODY));
        assertThrows(io.github.icommapi.bizgo.errors.ConfigurationException.class, () -> new WebhookReceiver(""));
    }

    @Test
    void parseMoAndInvalidBodies() {
        MoWebhookPayload mo = Webhooks.parseMo(("{\"msgKey\":\"K\",\"serviceType\":\"MO\",\"msgType\":\"SM\","
                + "\"to\":\"#000000\",\"from\":\"01000000000\",\"carrier\":\"10001\",\"originator\":\"01000000000\","
                + "\"content\":\"투표 1\",\"occurredTime\":\"t\",\"newField\":1}").getBytes(StandardCharsets.UTF_8));
        assertEquals("01000000000", mo.getFrom());
        assertEquals("투표 1", mo.getContent());
        assertEquals(Map.of("newField", 1), mo.getAdditionalProperties());
        WebhookVerificationException e = assertThrows(WebhookVerificationException.class,
                () -> Webhooks.parseMo("not json".getBytes(StandardCharsets.UTF_8)));
        assertTrue(e.getMessage().contains("JSON"));
        assertThrows(WebhookVerificationException.class,
                () -> Webhooks.parseReport("[1,2]".getBytes(StandardCharsets.UTF_8)));
        assertThrows(WebhookVerificationException.class,
                () -> Webhooks.parseReport(new byte[Webhooks.MAX_BODY_BYTES + 1]));
    }

    @Test
    void ackShape() {
        assertEquals(Map.of("msgKey", "K"), Webhooks.ack("K"));
        assertEquals("{\"msgKey\":\"K\\\"1\"}", Webhooks.ackJson("K\"1"));
    }

    @Test
    void defaultToleranceIsFiveMinutes() {
        assertEquals(Duration.ofSeconds(300), Webhooks.DEFAULT_TOLERANCE);
    }
}
