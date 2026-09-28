package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ConfigurationException;

/**
 * Client-side rate limit: two token buckets per client. A request waits for its tokens before every attempt
 * (retries included).
 *
 * <ul>
 * <li><b>send</b>: <b>messages (recipients) per second</b>, default 200. A send request costs the number of its
 * {@code destinations} (at least 1; a send without a recipient list, such as a counsel message or a group send to a
 * friend group, costs 1). One 200-recipient request uses a whole second.</li>
 * <li><b>other</b>: requests per second, default 5; every request costs 1.</li>
 * </ul>
 *
 * <p>The capacity (burst) of a bucket equals its rate. A request that costs more than the capacity waits until the
 * bucket is full and leaves the rest as debt, so it never blocks forever and the average rate holds.
 *
 * <p>Only operations marked {@code x-sdk-rate: send} in the spec use the send bucket: {@code sendOmni} (and every
 * {@code send()} method, including {@code bulk}), {@code createReservation}, {@code addReservationRecipients},
 * {@code createBrandMessageGroupSend}, {@code sendCounselPlain}, {@code sendCounselRich}. See
 * {@link Operation#getRateBucket()}.
 *
 * <p><b>Per process only.</b> Bizgo limits the account (API key), not a process. With several processes or servers
 * using the same key, divide the rates between them or use a shared limiter. HTTP 429 ({@code A020}) is still
 * retried. Turn client-side limiting off with {@code Bizgo.builder().rateLimit(null)}.
 */
public final class RateLimit {

    /** Send 200 messages (recipients)/second, other 5 requests/second. */
    public static final RateLimit DEFAULT = new RateLimit(200, 5);

    private final double sendPerSecond;
    private final double otherPerSecond;

    private RateLimit(double sendPerSecond, double otherPerSecond) {
        this.sendPerSecond = sendPerSecond;
        this.otherPerSecond = otherPerSecond;
    }

    /**
     * Creates a limit. Each bucket holds up to one second of tokens (burst).
     *
     * @param sendPerSecond messages (recipients) per second for send APIs (greater than 0)
     * @param otherPerSecond requests per second for other APIs (greater than 0)
     * @return the limit
     * @throws ConfigurationException if a rate is not positive
     */
    public static RateLimit of(double sendPerSecond, double otherPerSecond) {
        if (!(sendPerSecond > 0) || !(otherPerSecond > 0) || Double.isInfinite(sendPerSecond)
                || Double.isInfinite(otherPerSecond)) {
            throw new ConfigurationException("rateLimit 값은 0보다 큰 유한한 수여야 합니다");
        }
        return new RateLimit(sendPerSecond, otherPerSecond);
    }

    /**
     * Send bucket rate.
     *
     * @return requests per second
     */
    public double getSendPerSecond() {
        return sendPerSecond;
    }

    /**
     * Other bucket rate.
     *
     * @return requests per second
     */
    public double getOtherPerSecond() {
        return otherPerSecond;
    }

    @Override
    public String toString() {
        return "RateLimit{send=" + sendPerSecond + "/s, other=" + otherPerSecond + "/s}";
    }
}
