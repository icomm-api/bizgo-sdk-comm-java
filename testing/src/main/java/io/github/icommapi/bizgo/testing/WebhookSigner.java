package io.github.icommapi.bizgo.testing;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.time.Instant;
import java.util.Collections;
import java.util.HexFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Creates signed webhook requests for tests, the way Bizgo signs them ({@code X-IB-Signature =
 * hex(HmacSHA256(secret, X-IB-Timestamp))}, timestamp in epoch milliseconds), so you can feed them to
 * {@link io.github.icommapi.bizgo.webhooks.WebhookReceiver}.
 *
 * <pre>{@code
 * SignedWebhook hook = WebhookSigner.sign("test-webhook-secret", "{\"msgKey\":\"K001\"}");
 * ReportWebhookPayload report = receiver.report(hook.headers(), hook.body());
 * }</pre>
 *
 * <p>Use a placeholder secret in tests, never the real one.
 */
public final class WebhookSigner {

    private WebhookSigner() {
    }

    /**
     * Signs a payload with the current time.
     *
     * @param secret webhook secret
     * @param payloadJson JSON body
     * @return headers and body
     */
    public static SignedWebhook sign(String secret, String payloadJson) {
        return sign(secret, payloadJson, Instant.now());
    }

    /**
     * Signs a payload with a given time (for tolerance tests).
     *
     * @param secret webhook secret
     * @param payloadJson JSON body
     * @param timestamp value of {@code X-IB-Timestamp}
     * @return headers and body
     */
    public static SignedWebhook sign(String secret, String payloadJson, Instant timestamp) {
        if (secret == null || secret.isEmpty()) {
            throw new IllegalArgumentException("secret is empty");
        }
        String ts = String.valueOf(timestamp.toEpochMilli());
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-IB-Timestamp", ts);
        headers.put("X-IB-Signature", signature(secret, ts));
        return new SignedWebhook(Collections.unmodifiableMap(headers),
                payloadJson == null ? new byte[0] : payloadJson.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * A request without signature headers, as the counsel webhooks arrive (only content headers).
     *
     * @param payloadJson JSON body
     * @return headers and body
     */
    public static SignedWebhook unsigned(String payloadJson) {
        return new SignedWebhook(Map.of("Content-Type", "application/json"),
                payloadJson == null ? new byte[0] : payloadJson.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * The signature of a timestamp.
     *
     * @param secret webhook secret
     * @param timestamp {@code X-IB-Timestamp} value
     * @return lower-case hex HMAC-SHA256
     */
    public static String signature(String secret, String timestamp) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            return HexFormat.of().formatHex(mac.doFinal(timestamp.getBytes(StandardCharsets.US_ASCII)));
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("HmacSHA256 is not available");
        }
    }

    /**
     * A webhook request: headers and raw body.
     *
     * @param headers request headers
     * @param body raw body
     */
    public record SignedWebhook(Map<String, String> headers, byte[] body) {

        /**
         * Copies the body.
         *
         * @param headers request headers
         * @param body raw body
         */
        public SignedWebhook {
            body = body.clone();
        }

        @Override
        public byte[] body() {
            return body.clone();
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof SignedWebhook && ((SignedWebhook) o).headers.equals(headers)
                    && java.util.Arrays.equals(((SignedWebhook) o).body, body);
        }

        @Override
        public int hashCode() {
            return headers.hashCode() * 31 + java.util.Arrays.hashCode(body);
        }

        /** Header names only: the signature and the body are not shown. */
        @Override
        public String toString() {
            return "SignedWebhook{headers=" + headers.keySet() + ", bytes=" + body.length + "}";
        }
    }
}
