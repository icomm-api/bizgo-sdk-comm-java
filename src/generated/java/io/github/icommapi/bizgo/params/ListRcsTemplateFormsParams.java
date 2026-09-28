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
 * Query parameters of {@code listRcsTemplateForms} ({@code GET /api/comm/v1/center/rcs/messagebase/messagebaseform/list}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListRcsTemplateFormsParams {

    private final Integer offset;
    private final Integer limit;

    private ListRcsTemplateFormsParams(Builder builder) {
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
        builder.offset = offset;
        builder.limit = limit;
        return builder;
    }

    /**
     * 조회 시작 위치입니다. 기본값 0(영문 문서 기준).
     *
     * <p>쿼리 {@code offset} · 서버 기본값 <code>0</code>
     *
     * @return the value, or null
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 조회 최대 건수입니다. 최소 100, 최대 1000, 기본값 100(영문 문서 기준).
     *
     * <p>쿼리 {@code limit} · 범위 100~1000 · 서버 기본값 <code>100</code>
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
        if (!(o instanceof ListRcsTemplateFormsParams)) {
            return false;
        }
        ListRcsTemplateFormsParams other = (ListRcsTemplateFormsParams) o;
        return Objects.equals(offset, other.offset)
                && Objects.equals(limit, other.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset, limit);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListRcsTemplateFormsParams{", "}");
        if (offset != null) {
            joiner.add("offset=" + offset);
        }
        if (limit != null) {
            joiner.add("limit=" + limit);
        }
        return joiner.toString();
    }

    /** Builder for {@link ListRcsTemplateFormsParams}. */
    public static final class Builder {
        private Integer offset;
        private Integer limit;

        private Builder() {
        }

        /**
         * 조회 시작 위치입니다. 기본값 0(영문 문서 기준).
         *
         * <p>쿼리 {@code offset} · 서버 기본값 <code>0</code>
         *
         * @param offset the value (null clears it)
         * @return this builder
         */
        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * 조회 최대 건수입니다. 최소 100, 최대 1000, 기본값 100(영문 문서 기준).
         *
         * <p>쿼리 {@code limit} · 범위 100~1000 · 서버 기본값 <code>100</code>
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
        public ListRcsTemplateFormsParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (limit != null && (limit < 100L || limit > 1000L)) {
                violations.add(new ValidationException.Violation("ListRcsTemplateFormsParams.limit", "허용 범위(100~1000)를 벗어났습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListRcsTemplateFormsParams(this);
        }

        ListRcsTemplateFormsParams buildUnvalidated() {
            return new ListRcsTemplateFormsParams(this);
        }
    }
}
