// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.params;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Query parameters of {@code listReservationRecipients} ({@code GET /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;/destinations}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListReservationRecipientsParams {

    private final Long lastSeq;
    private final Integer limit;

    private ListReservationRecipientsParams(Builder builder) {
        this.lastSeq = builder.lastSeq;
        this.limit = builder.limit;
    }

    /**
     * Returns a new, empty builder.
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns a builder initialised with these values.
     *
     * @return builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.lastSeq = lastSeq;
        builder.limit = limit;
        return builder;
    }

    /**
     * 다음 페이지를 조회할 때 쓰는 마지막 순번입니다. 이전 응답의 <code>data.data.lastSeq</code>를 넣습니다.
     *
     * <p>쿼리 {@code lastSeq}
     *
     * @return the value, or null
     */
    public Long getLastSeq() {
        return lastSeq;
    }

    /**
     * 조회 건수입니다.
     *
     * <p>쿼리 {@code limit} · 범위 1~
     *
     * @return the value, or null
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (lastSeq != null) {
            query.put("lastSeq", String.valueOf(lastSeq));
        }
        if (limit != null) {
            query.put("limit", String.valueOf(limit));
        }
        return Collections.unmodifiableMap(query);
    }

    /**
     * Request header values. They can contain personal data: do not log them.
     *
     * @return unmodifiable map; unset headers are left out
     */
    public Map<String, String> toHeaders() {
        return Map.of();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ListReservationRecipientsParams)) {
            return false;
        }
        ListReservationRecipientsParams other = (ListReservationRecipientsParams) o;
        return Objects.equals(lastSeq, other.lastSeq)
                && Objects.equals(limit, other.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastSeq, limit);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListReservationRecipientsParams{", "}");
        if (lastSeq != null) {
            joiner.add("lastSeq=" + lastSeq);
        }
        if (limit != null) {
            joiner.add("limit=" + limit);
        }
        return joiner.toString();
    }

    /** Builder for {@link ListReservationRecipientsParams}. */
    public static final class Builder {
        private Long lastSeq;
        private Integer limit;

        private Builder() {
        }

        /**
         * 다음 페이지를 조회할 때 쓰는 마지막 순번입니다. 이전 응답의 <code>data.data.lastSeq</code>를 넣습니다.
         *
         * <p>쿼리 {@code lastSeq}
         *
         * @param lastSeq the value (null clears it)
         * @return this builder
         */
        public Builder lastSeq(Long lastSeq) {
            this.lastSeq = lastSeq;
            return this;
        }

        /**
         * 조회 건수입니다.
         *
         * <p>쿼리 {@code limit} · 범위 1~
         *
         * @param limit the value (null clears it)
         * @return this builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public ListReservationRecipientsParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (limit != null && (limit < 1L)) {
                violations.add(new ValidationException.Violation("ListReservationRecipientsParams.limit", "허용 범위(1~)를 벗어났습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListReservationRecipientsParams(this);
        }

        ListReservationRecipientsParams buildUnvalidated() {
            return new ListReservationRecipientsParams(this);
        }
    }
}
