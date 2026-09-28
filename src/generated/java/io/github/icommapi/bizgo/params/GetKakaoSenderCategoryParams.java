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
 * Query parameters of {@code getKakaoSenderCategory} ({@code GET /api/comm/v1/center/kakao/sender/category}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetKakaoSenderCategoryParams {

    private final String code;

    private GetKakaoSenderCategoryParams(Builder builder) {
        this.code = builder.code;
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
        builder.code = code;
        return builder;
    }

    /**
     * 조회할 카테고리 코드입니다.
     *
     * <p>쿼리 {@code code} · 필수
     *
     * @return the value, or null
     */
    public String getCode() {
        return code;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (code != null) {
            query.put("code", code);
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
        if (!(o instanceof GetKakaoSenderCategoryParams)) {
            return false;
        }
        GetKakaoSenderCategoryParams other = (GetKakaoSenderCategoryParams) o;
        return Objects.equals(code, other.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetKakaoSenderCategoryParams{", "}");
        if (code != null) {
            joiner.add("code=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetKakaoSenderCategoryParams}. */
    public static final class Builder {
        private String code;

        private Builder() {
        }

        /**
         * 조회할 카테고리 코드입니다.
         *
         * <p>쿼리 {@code code} · 필수
         *
         * @param code the value (null clears it)
         * @return this builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetKakaoSenderCategoryParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (code == null) {
                violations.add(new ValidationException.Violation("GetKakaoSenderCategoryParams.code", "필수 값입니다"));
            }
            if (code != null && code.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetKakaoSenderCategoryParams.code", "제어 문자는 쓸 수 없습니다"));
            }
            if (code != null && code.isEmpty()) {
                violations.add(new ValidationException.Violation("GetKakaoSenderCategoryParams.code", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetKakaoSenderCategoryParams(this);
        }

        GetKakaoSenderCategoryParams buildUnvalidated() {
            return new GetKakaoSenderCategoryParams(this);
        }
    }
}
