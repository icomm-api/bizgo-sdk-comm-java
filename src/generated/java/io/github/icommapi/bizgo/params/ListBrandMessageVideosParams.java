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
 * Query parameters of {@code listBrandMessageVideos} ({@code GET /api/comm/v1/center/brandmessage/video/list}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListBrandMessageVideosParams {

    private final String senderKey;
    private final String date;
    private final Integer offset;
    private final Integer limit;

    private ListBrandMessageVideosParams(Builder builder) {
        this.senderKey = builder.senderKey;
        this.date = builder.date;
        this.offset = builder.offset;
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
        builder.senderKey = senderKey;
        builder.date = date;
        builder.offset = offset;
        builder.limit = limit;
        return builder;
    }

    /**
     * 발신프로필 키입니다. 최대 40자입니다.
     *
     * <p>쿼리 {@code senderKey} · 필수
     *
     * @return the value, or null
     */
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 조회할 등록일자(<code>yyyyMMdd</code>)입니다. 생략하면 전체를 조회합니다.
     *
     * <p>쿼리 {@code date}
     *
     * @return the value, or null
     */
    public String getDate() {
        return date;
    }

    /**
     * 조회 시작 위치입니다. 음수는 쓸 수 없습니다. 기본값은 0입니다.
     *
     * <p>쿼리 {@code offset} · 범위 0~ · 서버 기본값 <code>0</code>
     *
     * @return the value, or null
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 조회 건수입니다. 기본값 100, 최대 1,000입니다.
     *
     * <p>쿼리 {@code limit} · 범위 1~1000 · 서버 기본값 <code>100</code>
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
        if (senderKey != null) {
            query.put("senderKey", senderKey);
        }
        if (date != null) {
            query.put("date", date);
        }
        if (offset != null) {
            query.put("offset", String.valueOf(offset));
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
        if (!(o instanceof ListBrandMessageVideosParams)) {
            return false;
        }
        ListBrandMessageVideosParams other = (ListBrandMessageVideosParams) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(date, other.date)
                && Objects.equals(offset, other.offset)
                && Objects.equals(limit, other.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, date, offset, limit);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListBrandMessageVideosParams{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (date != null) {
            joiner.add("date=" + date);
        }
        if (offset != null) {
            joiner.add("offset=" + offset);
        }
        if (limit != null) {
            joiner.add("limit=" + limit);
        }
        return joiner.toString();
    }

    /** Builder for {@link ListBrandMessageVideosParams}. */
    public static final class Builder {
        private String senderKey;
        private String date;
        private Integer offset;
        private Integer limit;

        private Builder() {
        }

        /**
         * 발신프로필 키입니다. 최대 40자입니다.
         *
         * <p>쿼리 {@code senderKey} · 필수
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 조회할 등록일자(<code>yyyyMMdd</code>)입니다. 생략하면 전체를 조회합니다.
         *
         * <p>쿼리 {@code date}
         *
         * @param date the value (null clears it)
         * @return this builder
         */
        public Builder date(String date) {
            this.date = date;
            return this;
        }

        /**
         * 조회 시작 위치입니다. 음수는 쓸 수 없습니다. 기본값은 0입니다.
         *
         * <p>쿼리 {@code offset} · 범위 0~ · 서버 기본값 <code>0</code>
         *
         * @param offset the value (null clears it)
         * @return this builder
         */
        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * 조회 건수입니다. 기본값 100, 최대 1,000입니다.
         *
         * <p>쿼리 {@code limit} · 범위 1~1000 · 서버 기본값 <code>100</code>
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
        public ListBrandMessageVideosParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("ListBrandMessageVideosParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.codePointCount(0, senderKey.length()) > 40) {
                violations.add(new ValidationException.Violation("ListBrandMessageVideosParams.senderKey", "최대 40자입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListBrandMessageVideosParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("ListBrandMessageVideosParams.senderKey", "빈 값입니다"));
            }
            if (date != null && date.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListBrandMessageVideosParams.date", "제어 문자는 쓸 수 없습니다"));
            }
            if (offset != null && (offset < 0L)) {
                violations.add(new ValidationException.Violation("ListBrandMessageVideosParams.offset", "허용 범위(0~)를 벗어났습니다"));
            }
            if (limit != null && (limit < 1L || limit > 1000L)) {
                violations.add(new ValidationException.Violation("ListBrandMessageVideosParams.limit", "허용 범위(1~1000)를 벗어났습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListBrandMessageVideosParams(this);
        }

        ListBrandMessageVideosParams buildUnvalidated() {
            return new ListBrandMessageVideosParams(this);
        }
    }
}
