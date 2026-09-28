package io.github.icommapi.bizgo.webhooks;

import io.github.icommapi.bizgo.errors.ConfigurationException;
import io.github.icommapi.bizgo.errors.WebhookVerificationException;
import io.github.icommapi.bizgo.models.MoWebhookPayload;
import io.github.icommapi.bizgo.models.ReportWebhookPayload;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Duration;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Verifies and parses webhook requests with one secret. Thread-safe.
 *
 * <pre>{@code
 * WebhookReceiver receiver = new WebhookReceiver(System.getenv("BIZGO_WEBHOOK_SECRET"));
 *
 * // in your HTTP handler
 * try {
 *     ReportWebhookPayload report = receiver.report(headers, rawBody);
 *     enqueue(report);                                   // dedupe by msgKey: the same report can arrive again
 *     return ok(Webhooks.ackJson(report.getMsgKey()));   // answer within 5 seconds
 * } catch (WebhookVerificationException e) {
 *     return status(401);
 * }
 * }</pre>
 *
 * <p>Report and MO webhooks always require a valid {@code X-IB-Signature}. The counsel (상담톡) webhooks
 * ({@code counselMessage}, {@code counselResult}, ...) carry no signature: their parsers do not check the headers
 * (signature headers, if present, are ignored) and apply only the body checks (size limit, nesting depth, types).
 * Counsel parsing needs no webhook secret: use the static parsers such as
 * {@link #parseCounselMessage(byte[]) WebhookReceiver.parseCounselMessage(rawBody)}. For a counsel endpoint, serve it
 * over HTTPS, allow only the Bizgo webhook source IPs, and deduplicate retried events.
 *
 * <p>See {@link Webhooks} for the other security notes.
 */
public final class WebhookReceiver extends GeneratedWebhookReceiver {

    private final byte[] secret;
    private final Duration tolerance;
    private final Clock clock;

    /**
     * Creates a receiver with the default tolerance of 300 seconds.
     *
     * @param secret webhook secret (request it from Bizgo)
     */
    public WebhookReceiver(String secret) {
        this(secret, Webhooks.DEFAULT_TOLERANCE);
    }

    /**
     * Creates a receiver.
     *
     * @param secret webhook secret (request it from Bizgo)
     * @param tolerance maximum age of a request; null disables the check (not recommended)
     */
    public WebhookReceiver(String secret, Duration tolerance) {
        this(secret == null ? null : secret.getBytes(StandardCharsets.UTF_8), tolerance, Clock.systemUTC());
    }

    /**
     * Creates a receiver with an explicit clock (for tests).
     *
     * @param secret webhook secret bytes (copied)
     * @param tolerance maximum age of a request; null disables the check
     * @param clock clock used for the timestamp check
     */
    public WebhookReceiver(byte[] secret, Duration tolerance, Clock clock) {
        checkTolerance(tolerance);
        this.secret = requireSecret(secret).clone();
        this.tolerance = tolerance;
        this.clock = clock == null ? Clock.systemUTC() : clock;
    }

    private static byte[] requireSecret(byte[] secret) {
        if (secret == null || new String(secret, StandardCharsets.UTF_8).isBlank()) {
            throw new ConfigurationException("웹훅 secret이 비어 있습니다(공백만 있는 값 포함). 환경변수나 시크릿 저장소에서 읽으세요");
        }
        return secret;
    }

    private static void checkTolerance(Duration tolerance) {
        if (tolerance != null && (tolerance.isZero() || tolerance.isNegative())) {
            throw new ConfigurationException("tolerance는 0보다 커야 합니다(검사를 끄려면 null)");
        }
    }

    /**
     * Starts building a receiver.
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Verifies the signature headers of a request. Header names are case-insensitive; values can be strings or
     * lists of strings (as in servlet or {@code com.sun.net.httpserver} header maps).
     *
     * @param headers request headers
     * @throws WebhookVerificationException if verification fails
     */
    public void verify(Map<String, ?> headers) {
        Webhooks.verifySignature(secret, header(headers, Webhooks.TIMESTAMP_HEADER),
                header(headers, Webhooks.SIGNATURE_HEADER), tolerance, clock.instant());
    }

    @Override
    void verifySigned(Map<String, ?> headers) {
        verify(headers);
    }

    /**
     * Verifies, then parses a delivery report webhook.
     *
     * @param headers request headers
     * @param body raw request body
     * @return the report
     * @throws WebhookVerificationException if verification or parsing fails
     */
    public ReportWebhookPayload report(Map<String, ?> headers, byte[] body) {
        verify(headers);
        return Webhooks.parseReport(body);
    }

    /**
     * Verifies, then parses an MO webhook.
     *
     * @param headers request headers
     * @param body raw request body
     * @return the MO message
     * @throws WebhookVerificationException if verification or parsing fails
     */
    public MoWebhookPayload mo(Map<String, ?> headers, byte[] body) {
        verify(headers);
        return Webhooks.parseMo(body);
    }

    /**
     * See {@link Webhooks#ack(String)}.
     *
     * @param msgKey received message key
     * @return {@code {"msgKey": msgKey}}
     */
    public Map<String, String> ack(String msgKey) {
        return Webhooks.ack(msgKey);
    }

    /**
     * See {@link Webhooks#counselAck()}.
     *
     * @return {@code {"code": "A000", "result": "Success"}}
     */
    public Map<String, String> counselAck() {
        return Webhooks.counselAck();
    }

    /** Never shows the secret. */
    @Override
    public String toString() {
        return "WebhookReceiver{tolerance=" + tolerance + "}";
    }

    static String header(Map<String, ?> headers, String name) {
        if (headers == null) {
            return "";
        }
        for (Map.Entry<String, ?> entry : headers.entrySet()) {
            if (entry.getKey() != null && entry.getKey().equalsIgnoreCase(name)) {
                Object value = entry.getValue();
                if (value instanceof Collection) {
                    Iterator<?> it = ((Collection<?>) value).iterator();
                    value = it.hasNext() ? it.next() : null;
                }
                return value == null ? "" : value.toString();
            }
        }
        return "";
    }

    /** Builder for {@link WebhookReceiver}. */
    public static final class Builder {
        private byte[] secret;
        private Duration tolerance = Webhooks.DEFAULT_TOLERANCE;
        private Clock clock = Clock.systemUTC();

        private Builder() {
        }

        /**
         * Webhook secret (required). Counsel-only endpoints need no receiver: use the static counsel parsers.
         *
         * @param secret secret (read it from the environment or a vault)
         * @return this builder
         */
        public Builder secret(String secret) {
            this.secret = secret == null ? null : secret.getBytes(StandardCharsets.UTF_8);
            return this;
        }

        /**
         * Maximum age of a signed request (default 300 seconds).
         *
         * @param tolerance tolerance; null disables the check (not recommended)
         * @return this builder
         */
        public Builder tolerance(Duration tolerance) {
            this.tolerance = tolerance;
            return this;
        }

        /**
         * Clock for the timestamp check (for tests).
         *
         * @param clock clock
         * @return this builder
         */
        public Builder clock(Clock clock) {
            this.clock = clock;
            return this;
        }

        /**
         * Creates the receiver.
         *
         * @return receiver
         * @throws ConfigurationException if the secret is missing or blank, or the tolerance is not positive
         */
        public WebhookReceiver build() {
            return new WebhookReceiver(secret, tolerance, clock);
        }
    }
}
