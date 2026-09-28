package io.github.icommapi.bizgo.webhooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.icommapi.bizgo.errors.WebhookVerificationException;
import io.github.icommapi.bizgo.internal.Json;
import io.github.icommapi.bizgo.models.MoWebhookPayload;
import io.github.icommapi.bizgo.models.ReportWebhookPayload;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.HexFormat;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Verifies and parses Bizgo webhooks (delivery reports and MO messages). Most code uses {@link WebhookReceiver}.
 *
 * <p>Security notes:
 * <ul>
 * <li>The signature is {@code X-IB-Signature = HmacSHA256(secret, X-IB-Timestamp)}; it is verified together
 * with the timestamp window. As general practice, also restrict the endpoint to the Bizgo webhook source IPs, serve
 * it over HTTPS, and confirm important results with the inquiry APIs.</li>
 * <li>Bizgo retries a webhook up to 3 times when it does not get {@code {"msgKey": ...}} back within 5 seconds, so
 * deduplicate by {@code msgKey}.</li>
 * <li>The signature output encoding (hex or base64) is not confirmed yet; both are accepted (hex in any case).
 * Comparison is constant-time.</li>
 * <li>The webhook secret is obtained by requesting it from Bizgo (it is delivered separately).</li>
 * </ul>
 */
public final class Webhooks {

    /** Timestamp header name. */
    public static final String TIMESTAMP_HEADER = "X-IB-Timestamp";
    /** Signature header name. */
    public static final String SIGNATURE_HEADER = "X-IB-Signature";
    /** Default maximum age of a webhook (limits replay). */
    public static final Duration DEFAULT_TOLERANCE = Duration.ofSeconds(300);
    /** Maximum accepted body size (1 MB). */
    public static final int MAX_BODY_BYTES = 1024 * 1024;

    private Webhooks() {
    }

    /**
     * Verifies {@code X-IB-Signature} with the default tolerance of 300 seconds.
     *
     * @param secret webhook secret (request it from Bizgo; read it from the environment or a vault)
     * @param timestamp {@code X-IB-Timestamp} header value
     * @param signature {@code X-IB-Signature} header value
     * @throws WebhookVerificationException if the signature or the timestamp is not valid
     */
    public static void verifySignature(String secret, String timestamp, String signature) {
        verifySignature(secret == null ? null : secret.getBytes(StandardCharsets.UTF_8), timestamp, signature,
                DEFAULT_TOLERANCE, Instant.now());
    }

    /**
     * Verifies {@code X-IB-Signature}.
     *
     * @param secret webhook secret bytes
     * @param timestamp {@code X-IB-Timestamp} header value: epoch milliseconds (13 digits or more) or seconds
     * @param signature {@code X-IB-Signature} header value: hex (any case) or base64
     * @param tolerance maximum difference between {@code now} and the timestamp; null disables the check (not
     *     recommended)
     * @param now current time
     * @throws WebhookVerificationException if the signature or the timestamp is not valid
     */
    public static void verifySignature(byte[] secret, String timestamp, String signature, Duration tolerance,
            Instant now) {
        if (secret == null || secret.length == 0) {
            throw new WebhookVerificationException("웹훅 secret이 비어 있습니다");
        }
        if (tolerance != null && (tolerance.isZero() || tolerance.isNegative())) {
            throw new io.github.icommapi.bizgo.errors.ConfigurationException(
                    "tolerance는 0보다 커야 합니다(검사를 끄려면 null)");
        }
        if (signature == null || signature.isEmpty()) {
            throw new WebhookVerificationException("X-IB-Signature 헤더가 없습니다");
        }
        long sentAtMillis = timestampMillis(timestamp);
        if (tolerance != null) {
            long nowMillis = (now == null ? Instant.now() : now).toEpochMilli();
            if (Math.abs(nowMillis - sentAtMillis) > tolerance.toMillis()) {
                throw new WebhookVerificationException(
                        "X-IB-Timestamp가 허용 범위(" + tolerance.toSeconds() + "초)를 벗어났습니다");
            }
        }
        byte[] digest = hmacSha256(secret, timestamp.getBytes(StandardCharsets.US_ASCII));
        String received = signature.strip();
        byte[] expectedHex = HexFormat.of().formatHex(digest).getBytes(StandardCharsets.US_ASCII);
        byte[] receivedHex = received.toLowerCase(Locale.ROOT).getBytes(StandardCharsets.US_ASCII);
        byte[] decoded;
        try {
            decoded = Base64.getDecoder().decode(received);
        } catch (IllegalArgumentException e) {
            decoded = new byte[0];
        }
        // evaluate both comparisons (no short-circuit), each in constant time
        boolean hexOk = MessageDigest.isEqual(receivedHex, expectedHex);
        boolean base64Ok = MessageDigest.isEqual(decoded, digest);
        if (!(hexOk | base64Ok)) {
            throw new WebhookVerificationException("서명이 일치하지 않습니다");
        }
    }

    /** Maximum digits of {@code X-IB-Timestamp} (epoch milliseconds have 13; SDK-DESIGN 12.7). */
    public static final int MAX_TIMESTAMP_DIGITS = 16;

    private static long timestampMillis(String timestamp) {
        // ASCII digits only (Character.isDigit would accept full-width digits), 1 to 16 of them: no overflow
        if (timestamp == null || timestamp.isEmpty() || timestamp.length() > MAX_TIMESTAMP_DIGITS
                || !timestamp.chars().allMatch(c -> c >= '0' && c <= '9')) {
            throw new WebhookVerificationException("X-IB-Timestamp는 ASCII 숫자 1~" + MAX_TIMESTAMP_DIGITS + "자리여야 합니다");
        }
        long value = Long.parseLong(timestamp);
        // epoch milliseconds (documented example) or seconds
        return timestamp.length() >= 13 ? value : Math.multiplyExact(value, 1000L);
    }

    private static byte[] hmacSha256(byte[] key, byte[] message) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key, "HmacSHA256"));
            return mac.doFinal(message);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalStateException("HmacSHA256를 사용할 수 없습니다", e);
        }
    }

    /**
     * Parses a report webhook body. Does not verify the signature; use {@link WebhookReceiver} for that.
     *
     * @param body raw request body (UTF-8 JSON)
     * @return payload
     * @throws WebhookVerificationException if the body is too large or not a JSON object
     */
    public static ReportWebhookPayload parseReport(byte[] body) {
        return parse(body, ReportWebhookPayload.class);
    }

    /**
     * Parses an MO webhook body. Does not verify the signature.
     *
     * @param body raw request body (UTF-8 JSON)
     * @return payload
     * @throws WebhookVerificationException if the body is too large or not a JSON object
     */
    public static MoWebhookPayload parseMo(byte[] body) {
        return parse(body, MoWebhookPayload.class);
    }

    static <T> T parse(byte[] body, Class<T> type) {
        if (body == null) {
            throw new WebhookVerificationException("웹훅 본문이 없습니다");
        }
        if (body.length > MAX_BODY_BYTES) {
            throw new WebhookVerificationException("웹훅 본문이 너무 큽니다");
        }
        JsonNode node;
        try {
            node = Json.readTree(body);
        } catch (IOException e) {
            throw new WebhookVerificationException("웹훅 본문이 JSON이 아닙니다");
        }
        if (node == null || !node.isObject()) {
            throw new WebhookVerificationException("웹훅 본문이 JSON 객체가 아닙니다");
        }
        try {
            return Json.treeToValue(node, type);
        } catch (JsonProcessingException | IllegalArgumentException e) {
            throw new WebhookVerificationException("웹훅 본문 형식이 문서와 다릅니다");
        }
    }

    /**
     * The response body Bizgo expects: {@code {"msgKey": "<received msgKey>"}}.
     *
     * @param msgKey received message key
     * @return map to serialize as JSON
     */
    public static Map<String, String> ack(String msgKey) {
        return Map.of("msgKey", msgKey == null ? "" : msgKey);
    }

    /**
     * The response body the counsel (상담톡) webhooks expect: {@code {"code": "A000", "result": "Success"}}. Bizgo
     * retries up to 3 times without it (5-second timeout), so deduplicate events.
     *
     * @return map to serialize as JSON
     */
    public static Map<String, String> counselAck() {
        Map<String, String> ack = new java.util.LinkedHashMap<>();
        ack.put("code", "A000");
        ack.put("result", "Success");
        return java.util.Collections.unmodifiableMap(ack);
    }

    /**
     * {@link #counselAck()} as JSON.
     *
     * @return {@code {"code":"A000","result":"Success"}}
     */
    public static String counselAckJson() {
        return "{\"code\":\"A000\",\"result\":\"Success\"}";
    }

    /**
     * {@link #ack(String)} as a JSON string, correctly escaped.
     *
     * @param msgKey received message key
     * @return JSON such as {@code {"msgKey":"K001"}}
     */
    public static String ackJson(String msgKey) {
        try {
            return Json.write(ack(msgKey));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("응답을 만들 수 없습니다");
        }
    }
}
