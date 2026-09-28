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
 * Query parameters of {@code listModifiedAlimtalkTemplates} ({@code GET /api/comm/v1/center/alimtalk/template/lastModified}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListModifiedAlimtalkTemplatesParams {

    private final String senderKey;
    private final String senderKeyType;
    private final String since;
    private final Integer page;
    private final Integer count;

    private ListModifiedAlimtalkTemplatesParams(Builder builder) {
        this.senderKey = builder.senderKey;
        this.senderKeyType = builder.senderKeyType;
        this.since = builder.since;
        this.page = builder.page;
        this.count = builder.count;
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
        builder.senderKeyType = senderKeyType;
        builder.since = since;
        builder.page = page;
        builder.count = count;
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
     * 발신키 유형입니다(<code>S</code> 발신프로필, <code>G</code> 그룹). 기본값은 <code>S</code>입니다.
     *
     * <p>쿼리 {@code senderKeyType} · 허용 값 <code>G</code>, <code>S</code> · 서버 기본값 <code>S</code>
     *
     * @return the value, or null
     */
    public String getSenderKeyType() {
        return senderKeyType;
    }

    /**
     * 조회 시작 시각(yyyy-MM-dd'T'HH:mm:ss)입니다. 예 <code>2026-04-23T09:00:00</code>.
     *
     * <p>쿼리 {@code since}
     *
     * @return the value, or null
     */
    public String getSince() {
        return since;
    }

    /**
     * 페이지 번호입니다. 기본값 1, 최소 1입니다.
     *
     * <p>쿼리 {@code page} · 범위 1~ · 서버 기본값 <code>1</code>
     *
     * @return the value, or null
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 페이지당 조회 건수입니다. 기본값 100, 최소 1입니다.
     *
     * <p>쿼리 {@code count} · 범위 1~ · 서버 기본값 <code>100</code>
     *
     * @return the value, or null
     */
    public Integer getCount() {
        return count;
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
        if (senderKeyType != null) {
            query.put("senderKeyType", senderKeyType);
        }
        if (since != null) {
            query.put("since", since);
        }
        if (page != null) {
            query.put("page", String.valueOf(page));
        }
        if (count != null) {
            query.put("count", String.valueOf(count));
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
        if (!(o instanceof ListModifiedAlimtalkTemplatesParams)) {
            return false;
        }
        ListModifiedAlimtalkTemplatesParams other = (ListModifiedAlimtalkTemplatesParams) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(senderKeyType, other.senderKeyType)
                && Objects.equals(since, other.since)
                && Objects.equals(page, other.page)
                && Objects.equals(count, other.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, senderKeyType, since, page, count);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListModifiedAlimtalkTemplatesParams{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (senderKeyType != null) {
            joiner.add("senderKeyType=" + senderKeyType);
        }
        if (since != null) {
            joiner.add("since=" + since);
        }
        if (page != null) {
            joiner.add("page=" + page);
        }
        if (count != null) {
            joiner.add("count=" + count);
        }
        return joiner.toString();
    }

    /** Builder for {@link ListModifiedAlimtalkTemplatesParams}. */
    public static final class Builder {
        private String senderKey;
        private String senderKeyType;
        private String since;
        private Integer page;
        private Integer count;

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
         * 발신키 유형입니다(<code>S</code> 발신프로필, <code>G</code> 그룹). 기본값은 <code>S</code>입니다.
         *
         * <p>쿼리 {@code senderKeyType} · 허용 값 <code>G</code>, <code>S</code> · 서버 기본값 <code>S</code>
         *
         * @param senderKeyType the value (null clears it)
         * @return this builder
         */
        public Builder senderKeyType(String senderKeyType) {
            this.senderKeyType = senderKeyType;
            return this;
        }

        /**
         * 조회 시작 시각(yyyy-MM-dd'T'HH:mm:ss)입니다. 예 <code>2026-04-23T09:00:00</code>.
         *
         * <p>쿼리 {@code since}
         *
         * @param since the value (null clears it)
         * @return this builder
         */
        public Builder since(String since) {
            this.since = since;
            return this;
        }

        /**
         * 페이지 번호입니다. 기본값 1, 최소 1입니다.
         *
         * <p>쿼리 {@code page} · 범위 1~ · 서버 기본값 <code>1</code>
         *
         * @param page the value (null clears it)
         * @return this builder
         */
        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * 페이지당 조회 건수입니다. 기본값 100, 최소 1입니다.
         *
         * <p>쿼리 {@code count} · 범위 1~ · 서버 기본값 <code>100</code>
         *
         * @param count the value (null clears it)
         * @return this builder
         */
        public Builder count(Integer count) {
            this.count = count;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public ListModifiedAlimtalkTemplatesParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("ListModifiedAlimtalkTemplatesParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.codePointCount(0, senderKey.length()) > 40) {
                violations.add(new ValidationException.Violation("ListModifiedAlimtalkTemplatesParams.senderKey", "최대 40자입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListModifiedAlimtalkTemplatesParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("ListModifiedAlimtalkTemplatesParams.senderKey", "빈 값입니다"));
            }
            if (senderKeyType != null && !List.of("G", "S").contains(senderKeyType)) {
                violations.add(new ValidationException.Violation("ListModifiedAlimtalkTemplatesParams.senderKeyType", "허용 값(G, S)이 아닙니다"));
            }
            if (senderKeyType != null && senderKeyType.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListModifiedAlimtalkTemplatesParams.senderKeyType", "제어 문자는 쓸 수 없습니다"));
            }
            if (since != null && since.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListModifiedAlimtalkTemplatesParams.since", "제어 문자는 쓸 수 없습니다"));
            }
            if (page != null && (page < 1L)) {
                violations.add(new ValidationException.Violation("ListModifiedAlimtalkTemplatesParams.page", "허용 범위(1~)를 벗어났습니다"));
            }
            if (count != null && (count < 1L)) {
                violations.add(new ValidationException.Violation("ListModifiedAlimtalkTemplatesParams.count", "허용 범위(1~)를 벗어났습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListModifiedAlimtalkTemplatesParams(this);
        }

        ListModifiedAlimtalkTemplatesParams buildUnvalidated() {
            return new ListModifiedAlimtalkTemplatesParams(this);
        }
    }
}
