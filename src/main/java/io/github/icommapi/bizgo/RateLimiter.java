package io.github.icommapi.bizgo;

import java.time.Duration;
import java.util.function.LongSupplier;

/** The two token buckets of one client. Thread-safe; waiting happens outside the lock. */
final class RateLimiter {

    private final Bucket send;
    private final Bucket other;
    private final Sleeper sleeper;

    RateLimiter(RateLimit limit, LongSupplier nanoClock, Sleeper sleeper) {
        this.send = new Bucket(limit.getSendPerSecond(), nanoClock);
        this.other = new Bucket(limit.getOtherPerSecond(), nanoClock);
        this.sleeper = sleeper;
    }

    /** Takes {@code cost} tokens (recipients for the send bucket, 1 otherwise), waiting if needed. */
    void acquire(Operation.RateBucket bucket, int cost) throws InterruptedException {
        long waitNanos = (bucket == Operation.RateBucket.SEND ? send : other).reserve(cost);
        if (waitNanos > 0) {
            sleeper.sleep(Duration.ofNanos(waitNanos));
        }
    }

    /**
     * Token bucket with reservations: a caller takes its tokens even when not enough are left (the balance goes
     * negative) and waits until they would have been refilled, so callers queue fairly without holding a lock. The
     * capacity (burst) equals the per-second rate. A cost above the capacity waits until the bucket is full and
     * leaves the rest as debt: it never deadlocks and the average rate still holds.
     */
    static final class Bucket {
        private final double ratePerNano;
        private final double capacity;
        private final LongSupplier clock;
        private double tokens;
        private long last;

        Bucket(double perSecond, LongSupplier clock) {
            this.ratePerNano = perSecond / 1_000_000_000.0;
            this.capacity = perSecond;
            this.clock = clock;
            this.tokens = capacity;
            this.last = clock.getAsLong();
        }

        synchronized long reserve() {
            return reserve(1);
        }

        /** Takes {@code cost} tokens (at least 1) and returns how long the caller must wait, in nanoseconds. */
        synchronized long reserve(double cost) {
            double take = Math.max(1.0, cost);
            long now = clock.getAsLong();
            tokens = Math.min(capacity, tokens + (now - last) * ratePerNano);
            last = now;
            double need = Math.min(take, capacity);
            long wait = need <= tokens ? 0 : (long) Math.ceil((need - tokens) / ratePerNano);
            tokens -= take;
            return wait;
        }
    }
}
