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
 * Query parameters of {@code listKakaoSenderProfiles} ({@code GET /api/comm/v1/account/kakao/sender/profiles}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListKakaoSenderProfilesParams {

    private final String startDate;
    private final String endDate;
    private final String senderKey;
    private final Integer page;
    private final Integer rows;

    private ListKakaoSenderProfilesParams(Builder builder) {
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.senderKey = builder.senderKey;
        this.page = builder.page;
        this.rows = builder.rows;
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
        builder.startDate = startDate;
        builder.endDate = endDate;
        builder.senderKey = senderKey;
        builder.page = page;
        builder.rows = rows;
        return builder;
    }

    /**
     * 검색 시작일입니다.
     *
     * <p>쿼리 {@code startDate}
     *
     * @return the value, or null
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 검색 종료일입니다.
     *
     * <p>쿼리 {@code endDate}
     *
     * @return the value, or null
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 발신프로필 키 또는 발신프로필 그룹키입니다.
     *
     * <p>쿼리 {@code senderKey}
     *
     * @return the value, or null
     */
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 페이지 번호입니다.
     *
     * <p>쿼리 {@code page}
     *
     * @return the value, or null
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 페이지당 조회 건수입니다.
     *
     * <p>쿼리 {@code rows}
     *
     * @return the value, or null
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (startDate != null) {
            query.put("startDate", startDate);
        }
        if (endDate != null) {
            query.put("endDate", endDate);
        }
        if (senderKey != null) {
            query.put("senderKey", senderKey);
        }
        if (page != null) {
            query.put("page", String.valueOf(page));
        }
        if (rows != null) {
            query.put("rows", String.valueOf(rows));
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
        if (!(o instanceof ListKakaoSenderProfilesParams)) {
            return false;
        }
        ListKakaoSenderProfilesParams other = (ListKakaoSenderProfilesParams) o;
        return Objects.equals(startDate, other.startDate)
                && Objects.equals(endDate, other.endDate)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(page, other.page)
                && Objects.equals(rows, other.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, senderKey, page, rows);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListKakaoSenderProfilesParams{", "}");
        if (startDate != null) {
            joiner.add("startDate=" + startDate);
        }
        if (endDate != null) {
            joiner.add("endDate=" + endDate);
        }
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (page != null) {
            joiner.add("page=" + page);
        }
        if (rows != null) {
            joiner.add("rows=" + rows);
        }
        return joiner.toString();
    }

    /** Builder for {@link ListKakaoSenderProfilesParams}. */
    public static final class Builder {
        private String startDate;
        private String endDate;
        private String senderKey;
        private Integer page;
        private Integer rows;

        private Builder() {
        }

        /**
         * 검색 시작일입니다.
         *
         * <p>쿼리 {@code startDate}
         *
         * @param startDate the value (null clears it)
         * @return this builder
         */
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * 검색 종료일입니다.
         *
         * <p>쿼리 {@code endDate}
         *
         * @param endDate the value (null clears it)
         * @return this builder
         */
        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        /**
         * 발신프로필 키 또는 발신프로필 그룹키입니다.
         *
         * <p>쿼리 {@code senderKey}
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 페이지 번호입니다.
         *
         * <p>쿼리 {@code page}
         *
         * @param page the value (null clears it)
         * @return this builder
         */
        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * 페이지당 조회 건수입니다.
         *
         * <p>쿼리 {@code rows}
         *
         * @param rows the value (null clears it)
         * @return this builder
         */
        public Builder rows(Integer rows) {
            this.rows = rows;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public ListKakaoSenderProfilesParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (startDate != null && startDate.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListKakaoSenderProfilesParams.startDate", "제어 문자는 쓸 수 없습니다"));
            }
            if (endDate != null && endDate.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListKakaoSenderProfilesParams.endDate", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListKakaoSenderProfilesParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListKakaoSenderProfilesParams(this);
        }

        ListKakaoSenderProfilesParams buildUnvalidated() {
            return new ListKakaoSenderProfilesParams(this);
        }
    }
}
