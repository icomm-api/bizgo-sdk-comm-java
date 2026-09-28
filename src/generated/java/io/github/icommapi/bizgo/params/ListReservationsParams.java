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
 * Query parameters of {@code listReservations} ({@code GET /api/comm/v1/reservation/list}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListReservationsParams {

    private final String resvSendTime;
    private final String paymentCode;
    private final Long lastSeq;
    private final Integer limit;

    private ListReservationsParams(Builder builder) {
        this.resvSendTime = builder.resvSendTime;
        this.paymentCode = builder.paymentCode;
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
        builder.resvSendTime = resvSendTime;
        builder.paymentCode = paymentCode;
        builder.lastSeq = lastSeq;
        builder.limit = limit;
        return builder;
    }

    /**
     * 조회 기준 예약 발송 시각입니다. <code>yyyy-MM-dd HH:mm:ss</code> 형식만 쓸 수 있습니다.
     *
     * <p>쿼리 {@code resvSendTime} · 필수
     *
     * @return the value, or null
     */
    public String getResvSendTime() {
        return resvSendTime;
    }

    /**
     * 정산 코드로 조회 대상을 거릅니다.
     *
     * <p>쿼리 {@code paymentCode}
     *
     * @return the value, or null
     */
    public String getPaymentCode() {
        return paymentCode;
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
        if (resvSendTime != null) {
            query.put("resvSendTime", resvSendTime);
        }
        if (paymentCode != null) {
            query.put("paymentCode", paymentCode);
        }
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
        if (!(o instanceof ListReservationsParams)) {
            return false;
        }
        ListReservationsParams other = (ListReservationsParams) o;
        return Objects.equals(resvSendTime, other.resvSendTime)
                && Objects.equals(paymentCode, other.paymentCode)
                && Objects.equals(lastSeq, other.lastSeq)
                && Objects.equals(limit, other.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resvSendTime, paymentCode, lastSeq, limit);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListReservationsParams{", "}");
        if (resvSendTime != null) {
            joiner.add("resvSendTime=***");
        }
        if (paymentCode != null) {
            joiner.add("paymentCode=***");
        }
        if (lastSeq != null) {
            joiner.add("lastSeq=" + lastSeq);
        }
        if (limit != null) {
            joiner.add("limit=" + limit);
        }
        return joiner.toString();
    }

    /** Builder for {@link ListReservationsParams}. */
    public static final class Builder {
        private String resvSendTime;
        private String paymentCode;
        private Long lastSeq;
        private Integer limit;

        private Builder() {
        }

        /**
         * 조회 기준 예약 발송 시각입니다. <code>yyyy-MM-dd HH:mm:ss</code> 형식만 쓸 수 있습니다.
         *
         * <p>쿼리 {@code resvSendTime} · 필수
         *
         * @param resvSendTime the value (null clears it)
         * @return this builder
         */
        public Builder resvSendTime(String resvSendTime) {
            this.resvSendTime = resvSendTime;
            return this;
        }

        /**
         * 정산 코드로 조회 대상을 거릅니다.
         *
         * <p>쿼리 {@code paymentCode}
         *
         * @param paymentCode the value (null clears it)
         * @return this builder
         */
        public Builder paymentCode(String paymentCode) {
            this.paymentCode = paymentCode;
            return this;
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
        public ListReservationsParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (resvSendTime == null) {
                violations.add(new ValidationException.Violation("ListReservationsParams.resvSendTime", "필수 값입니다"));
            }
            if (resvSendTime != null && resvSendTime.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListReservationsParams.resvSendTime", "제어 문자는 쓸 수 없습니다"));
            }
            if (resvSendTime != null && resvSendTime.isEmpty()) {
                violations.add(new ValidationException.Violation("ListReservationsParams.resvSendTime", "빈 값입니다"));
            }
            if (paymentCode != null && paymentCode.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListReservationsParams.paymentCode", "제어 문자는 쓸 수 없습니다"));
            }
            if (limit != null && (limit < 1L)) {
                violations.add(new ValidationException.Violation("ListReservationsParams.limit", "허용 범위(1~)를 벗어났습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListReservationsParams(this);
        }

        ListReservationsParams buildUnvalidated() {
            return new ListReservationsParams(this);
        }
    }
}
