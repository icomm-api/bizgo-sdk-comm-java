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
 * Query parameters of {@code listAlimtalkTemplateCategories} ({@code GET /api/comm/v1/center/alimtalk/category}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListAlimtalkTemplateCategoriesParams {

    private final String categoryCode;

    private ListAlimtalkTemplateCategoriesParams(Builder builder) {
        this.categoryCode = builder.categoryCode;
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
        builder.categoryCode = categoryCode;
        return builder;
    }

    /**
     * 조회할 템플릿 카테고리 코드입니다. 넣으면 상세 조회, 생략하면 전체 조회입니다(상세 조회 문서에서는 필수).
     *
     * <p>쿼리 {@code categoryCode}
     *
     * @return the value, or null
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (categoryCode != null) {
            query.put("categoryCode", categoryCode);
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
        if (!(o instanceof ListAlimtalkTemplateCategoriesParams)) {
            return false;
        }
        ListAlimtalkTemplateCategoriesParams other = (ListAlimtalkTemplateCategoriesParams) o;
        return Objects.equals(categoryCode, other.categoryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryCode);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListAlimtalkTemplateCategoriesParams{", "}");
        if (categoryCode != null) {
            joiner.add("categoryCode=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link ListAlimtalkTemplateCategoriesParams}. */
    public static final class Builder {
        private String categoryCode;

        private Builder() {
        }

        /**
         * 조회할 템플릿 카테고리 코드입니다. 넣으면 상세 조회, 생략하면 전체 조회입니다(상세 조회 문서에서는 필수).
         *
         * <p>쿼리 {@code categoryCode}
         *
         * @param categoryCode the value (null clears it)
         * @return this builder
         */
        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public ListAlimtalkTemplateCategoriesParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (categoryCode != null && categoryCode.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListAlimtalkTemplateCategoriesParams.categoryCode", "제어 문자는 쓸 수 없습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListAlimtalkTemplateCategoriesParams(this);
        }

        ListAlimtalkTemplateCategoriesParams buildUnvalidated() {
            return new ListAlimtalkTemplateCategoriesParams(this);
        }
    }
}
