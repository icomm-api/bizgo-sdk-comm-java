package io.github.icommapi.bizgo;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Optional request-level fields of a send: {@code ref}, {@code groupKey}, {@code paymentCode},
 * {@code idempotencyKey}, {@code idempotencyTtl}. Immutable.
 *
 * <pre>{@code
 * SendOptions options = SendOptions.builder()
 *         .idempotencyKey("order-20260923-0001")   // recommended: safe to retry
 *         .ref("order-20260923-0001")              // returned in reports
 *         .build();
 * }</pre>
 */
public final class SendOptions {

    /** No options. */
    public static final SendOptions NONE = builder().build();

    private final String ref;
    private final String groupKey;
    private final String paymentCode;
    private final String idempotencyKey;
    private final Integer idempotencyTtl;

    private SendOptions(Builder builder) {
        this.ref = builder.ref;
        this.groupKey = builder.groupKey;
        this.paymentCode = builder.paymentCode;
        this.idempotencyKey = builder.idempotencyKey;
        this.idempotencyTtl = builder.idempotencyTtl;
    }

    /**
     * Starts building options.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Shortcut for options with only an idempotency key.
     *
     * @param idempotencyKey key, at most 200 characters
     * @return options
     */
    public static SendOptions idempotencyKey(String idempotencyKey) {
        return builder().idempotencyKey(idempotencyKey).build();
    }

    /**
     * Request-level reference value, returned in reports.
     *
     * @return ref, or null
     */
    public String getRef() {
        return ref;
    }

    /**
     * Groups messages in message insight statistics.
     *
     * @return group key, or null
     */
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * Department code for billing.
     *
     * @return payment code, or null
     */
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * Idempotency key.
     *
     * @return key, or null
     */
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Seconds the idempotency key is remembered. Null means the default 86400
     * ({@link Bizgo#DEFAULT_IDEMPOTENCY_TTL}) when the idempotency key is set.
     *
     * @return TTL, or null
     */
    public Integer getIdempotencyTtl() {
        return idempotencyTtl;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SendOptions)) {
            return false;
        }
        SendOptions other = (SendOptions) o;
        return Objects.equals(ref, other.ref) && Objects.equals(groupKey, other.groupKey)
                && Objects.equals(paymentCode, other.paymentCode)
                && Objects.equals(idempotencyKey, other.idempotencyKey)
                && Objects.equals(idempotencyTtl, other.idempotencyTtl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref, groupKey, paymentCode, idempotencyKey, idempotencyTtl);
    }

    /** Shows which options are set, not their values. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "SendOptions{", "}");
        if (ref != null) {
            joiner.add("ref=***");
        }
        if (groupKey != null) {
            joiner.add("groupKey=***");
        }
        if (paymentCode != null) {
            joiner.add("paymentCode=***");
        }
        if (idempotencyKey != null) {
            joiner.add("idempotencyKey=***");
        }
        if (idempotencyTtl != null) {
            joiner.add("idempotencyTtl=" + idempotencyTtl);
        }
        return joiner.toString();
    }

    /** Builder for {@link SendOptions}. */
    public static final class Builder {
        private String ref;
        private String groupKey;
        private String paymentCode;
        private String idempotencyKey;
        private Integer idempotencyTtl;

        private Builder() {
        }

        /**
         * Request-level reference value; returned in reports.
         *
         * @param ref value
         * @return this builder
         */
        public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

        /**
         * Groups messages in message insight statistics.
         *
         * @param groupKey value
         * @return this builder
         */
        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        /**
         * Department code for billing.
         *
         * @param paymentCode value
         * @return this builder
         */
        public Builder paymentCode(String paymentCode) {
            this.paymentCode = paymentCode;
            return this;
        }

        /**
         * Up to 200 characters. A resend with the same key within the TTL is rejected with
         * {@link io.github.icommapi.bizgo.errors.DuplicateRequestException} instead of being delivered twice.
         * Setting it also enables automatic retries after timeouts and 5xx responses. Without
         * {@link #idempotencyTtl(Integer)}, {@code idempotencyTtl} {@value Bizgo#DEFAULT_IDEMPOTENCY_TTL} is sent.
         *
         * @param idempotencyKey key
         * @return this builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Seconds (0 to 86,400) the idempotency key is remembered. Default 86400
         * ({@link Bizgo#DEFAULT_IDEMPOTENCY_TTL}) when the idempotency key is set: Bizgo rejects a key without a TTL
         * (A309), so the SDK sends 86400 if this is left null. An explicit value (including 0) is sent as given;
         * without a key, no TTL is added.
         *
         * @param idempotencyTtl seconds, null for the default
         * @return this builder
         */
        public Builder idempotencyTtl(Integer idempotencyTtl) {
            this.idempotencyTtl = idempotencyTtl;
            return this;
        }

        /**
         * Builds the options. Values are validated together with the request when it is sent.
         *
         * @return options
         */
        public SendOptions build() {
            return new SendOptions(this);
        }
    }
}
