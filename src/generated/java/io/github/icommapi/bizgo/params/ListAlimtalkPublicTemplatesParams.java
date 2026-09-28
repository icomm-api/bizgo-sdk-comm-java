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
 * Query parameters of {@code listAlimtalkPublicTemplates} ({@code GET /api/comm/v1/center/alimtalk/public/template}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListAlimtalkPublicTemplatesParams {

    private final String since;
    private final Integer page;
    private final Integer count;

    private ListAlimtalkPublicTemplatesParams(Builder builder) {
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
        builder.since = since;
        builder.page = page;
        builder.count = count;
        return builder;
    }

    /**
     * 조회 기준 시각(yyyyMMddHHmmss)입니다. 기본값은 <code>20250708000000</code>입니다.
     *
     * <p>쿼리 {@code since} · 서버 기본값 <code>20250708000000</code>
     *
     * @return the value, or null
     */
    public String getSince() {
        return since;
    }

    /**
     * 조회 페이지 번호입니다. 기본값은 1입니다.
     *
     * <p>쿼리 {@code page} · 범위 1~ · 서버 기본값 <code>1</code>
     *
     * @return the value, or null
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 페이지당 조회 건수입니다. 기본값 100, 최대 1,000입니다.
     *
     * <p>쿼리 {@code count} · 범위 1~1000 · 서버 기본값 <code>100</code>
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
        if (!(o instanceof ListAlimtalkPublicTemplatesParams)) {
            return false;
        }
        ListAlimtalkPublicTemplatesParams other = (ListAlimtalkPublicTemplatesParams) o;
        return Objects.equals(since, other.since)
                && Objects.equals(page, other.page)
                && Objects.equals(count, other.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(since, page, count);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListAlimtalkPublicTemplatesParams{", "}");
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

    /** Builder for {@link ListAlimtalkPublicTemplatesParams}. */
    public static final class Builder {
        private String since;
        private Integer page;
        private Integer count;

        private Builder() {
        }

        /**
         * 조회 기준 시각(yyyyMMddHHmmss)입니다. 기본값은 <code>20250708000000</code>입니다.
         *
         * <p>쿼리 {@code since} · 서버 기본값 <code>20250708000000</code>
         *
         * @param since the value (null clears it)
         * @return this builder
         */
        public Builder since(String since) {
            this.since = since;
            return this;
        }

        /**
         * 조회 페이지 번호입니다. 기본값은 1입니다.
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
         * 페이지당 조회 건수입니다. 기본값 100, 최대 1,000입니다.
         *
         * <p>쿼리 {@code count} · 범위 1~1000 · 서버 기본값 <code>100</code>
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
        public ListAlimtalkPublicTemplatesParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (since != null && since.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListAlimtalkPublicTemplatesParams.since", "제어 문자는 쓸 수 없습니다"));
            }
            if (page != null && (page < 1L)) {
                violations.add(new ValidationException.Violation("ListAlimtalkPublicTemplatesParams.page", "허용 범위(1~)를 벗어났습니다"));
            }
            if (count != null && (count < 1L || count > 1000L)) {
                violations.add(new ValidationException.Violation("ListAlimtalkPublicTemplatesParams.count", "허용 범위(1~1000)를 벗어났습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListAlimtalkPublicTemplatesParams(this);
        }

        ListAlimtalkPublicTemplatesParams buildUnvalidated() {
            return new ListAlimtalkPublicTemplatesParams(this);
        }
    }
}
