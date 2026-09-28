package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ValidationException;

/**
 * Options of {@code client.send().bulk(...)}.
 *
 * <pre>{@code
 * BulkOptions.builder()
 *         .chunkSize(200)                         // recipients per request (1 to 200)
 *         .concurrency(4)                         // requests in flight
 *         .idempotencyKeyPrefix("campaign-0923")  // request i uses "campaign-0923-i": a rerun does not resend
 *         .build();
 * }</pre>
 */
public final class BulkOptions {

    /** Default and maximum recipients per request. */
    public static final int MAX_CHUNK_SIZE = 200;
    /** Default concurrency. */
    public static final int DEFAULT_CONCURRENCY = 4;
    /** Maximum length of a generated idempotency key. */
    public static final int MAX_KEY_LENGTH = 200;
    /** Longest prefix that always fits: the key adds {@code -<chunkSize>-<startIndex>-<hash8>} (at most 24 chars). */
    public static final int MAX_PREFIX_LENGTH = MAX_KEY_LENGTH - 24;
    /** Defaults: 200 recipients per request, 4 in flight, no idempotency key. */
    public static final BulkOptions DEFAULT = builder().build();

    private final int chunkSize;
    private final int concurrency;
    private final String idempotencyKeyPrefix;
    private final Integer idempotencyTtl;
    private final String ref;
    private final String groupKey;
    private final String paymentCode;

    private BulkOptions(Builder b) {
        this.chunkSize = b.chunkSize;
        this.concurrency = b.concurrency;
        this.idempotencyKeyPrefix = b.idempotencyKeyPrefix;
        this.idempotencyTtl = b.idempotencyTtl;
        this.ref = b.ref;
        this.groupKey = b.groupKey;
        this.paymentCode = b.paymentCode;
    }

    /**
     * Starts building options.
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Recipients per request.
     *
     * @return 1 to 200
     */
    public int getChunkSize() {
        return chunkSize;
    }

    /**
     * Maximum requests in flight.
     *
     * @return at least 1
     */
    public int getConcurrency() {
        return concurrency;
    }

    /**
     * Prefix of the per-request idempotency key ({@code <prefix>-<chunkSize>-<startIndex>-<hash8>}).
     *
     * @return prefix, or null
     */
    public String getIdempotencyKeyPrefix() {
        return idempotencyKeyPrefix;
    }

    /**
     * Idempotency key lifetime passed to every request. Null means the default 86400
     * ({@link Bizgo#DEFAULT_IDEMPOTENCY_TTL}) when {@link #getIdempotencyKeyPrefix()} is set.
     *
     * @return TTL, or null
     */
    public Integer getIdempotencyTtl() {
        return idempotencyTtl;
    }

    /**
     * Request {@code ref} passed to every request.
     *
     * @return ref, or null
     */
    public String getRef() {
        return ref;
    }

    /**
     * {@code groupKey} passed to every request.
     *
     * @return group key, or null
     */
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * {@code paymentCode} passed to every request.
     *
     * @return payment code, or null
     */
    public String getPaymentCode() {
        return paymentCode;
    }

    SendOptions sendOptions(String idempotencyKey) {
        return SendOptions.builder()
                .ref(ref)
                .groupKey(groupKey)
                .paymentCode(paymentCode)
                .idempotencyKey(idempotencyKey)
                .idempotencyTtl(idempotencyTtl)
                .build();
    }

    /**
     * The idempotency key of one chunk: {@code <prefix>-<chunkSize>-<startIndex>-<hash8>}, where {@code hash8} is
     * the first 8 hex digits of SHA-256 over the chunk's phone numbers in order, joined with {@code \n} (UTF-8).
     * Re-running the same list with the same chunk size gives the same keys (no duplicate delivery); a key is never
     * reused for a different group of recipients (SDK-DESIGN 12.3).
     *
     * @param prefix key prefix
     * @param chunkSize chunk size of the run
     * @param startIndex index of the chunk's first recipient in the whole list
     * @param numbers the chunk's phone numbers in order
     * @return key
     */
    public static String idempotencyKey(String prefix, int chunkSize, int startIndex, java.util.List<String> numbers) {
        try {
            java.security.MessageDigest sha = java.security.MessageDigest.getInstance("SHA-256");
            byte[] digest = sha.digest(String.join("\n", numbers).getBytes(java.nio.charset.StandardCharsets.UTF_8));
            String hash8 = java.util.HexFormat.of().formatHex(digest).substring(0, 8);
            return prefix + "-" + chunkSize + "-" + startIndex + "-" + hash8;
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 is not available");
        }
    }

    @Override
    public String toString() {
        return "BulkOptions{chunkSize=" + chunkSize + ", concurrency=" + concurrency + ", idempotencyKeyPrefix="
                + (idempotencyKeyPrefix == null ? "null" : "set") + "}";
    }

    /** Builder for {@link BulkOptions}. */
    public static final class Builder {
        private int chunkSize = MAX_CHUNK_SIZE;
        private int concurrency = DEFAULT_CONCURRENCY;
        private String idempotencyKeyPrefix;
        private Integer idempotencyTtl;
        private String ref;
        private String groupKey;
        private String paymentCode;

        private Builder() {
        }

        /**
         * Recipients per request (default 200, the API maximum).
         *
         * @param chunkSize 1 to 200
         * @return this builder
         */
        public Builder chunkSize(int chunkSize) {
            this.chunkSize = chunkSize;
            return this;
        }

        /**
         * Requests in flight (default 4). The client rate limit still applies.
         *
         * @param concurrency at least 1
         * @return this builder
         */
        public Builder concurrency(int concurrency) {
            this.concurrency = concurrency;
            return this;
        }

        /**
         * Makes every request idempotent with the key {@code <prefix>-<chunkSize>-<startIndex>-<hash8>} (see
         * {@link BulkOptions#idempotencyKey}): running the same list again with the same prefix and the same chunk
         * size does not send an accepted chunk twice, and timeouts are retried. At most {@value #MAX_PREFIX_LENGTH}
         * characters, so that the key stays within {@value #MAX_KEY_LENGTH}.
         *
         * @param idempotencyKeyPrefix prefix, null for none
         * @return this builder
         */
        public Builder idempotencyKeyPrefix(String idempotencyKeyPrefix) {
            this.idempotencyKeyPrefix = idempotencyKeyPrefix;
            return this;
        }

        /**
         * Idempotency key lifetime (see {@link SendOptions.Builder#idempotencyTtl(Integer)}). Default 86400
         * ({@link Bizgo#DEFAULT_IDEMPOTENCY_TTL}) when an idempotency key prefix is set; an explicit value
         * (including 0) is sent as given.
         *
         * @param idempotencyTtl TTL, null for the default
         * @return this builder
         */
        public Builder idempotencyTtl(Integer idempotencyTtl) {
            this.idempotencyTtl = idempotencyTtl;
            return this;
        }

        /**
         * Request {@code ref} for every request.
         *
         * @param ref value, null for none
         * @return this builder
         */
        public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

        /**
         * {@code groupKey} for every request.
         *
         * @param groupKey value, null for none
         * @return this builder
         */
        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        /**
         * {@code paymentCode} for every request.
         *
         * @param paymentCode value, null for none
         * @return this builder
         */
        public Builder paymentCode(String paymentCode) {
            this.paymentCode = paymentCode;
            return this;
        }

        /**
         * Builds the options.
         *
         * @return options
         * @throws ValidationException if the chunk size or the concurrency is out of range
         */
        public BulkOptions build() {
            if (chunkSize < 1 || chunkSize > MAX_CHUNK_SIZE) {
                throw new ValidationException("chunkSize", "1~200이어야 합니다");
            }
            if (concurrency < 1) {
                throw new ValidationException("concurrency", "1 이상이어야 합니다");
            }
            if (idempotencyKeyPrefix != null && idempotencyKeyPrefix.isBlank()) {
                throw new ValidationException("idempotencyKeyPrefix", "빈 값입니다");
            }
            if (idempotencyKeyPrefix != null && idempotencyKeyPrefix.length() > MAX_PREFIX_LENGTH) {
                throw new ValidationException("idempotencyKeyPrefix", "최대 " + MAX_PREFIX_LENGTH + "자입니다(생성되는 키가 "
                        + MAX_KEY_LENGTH + "자를 넘지 않도록)");
            }
            return new BulkOptions(this);
        }
    }
}
