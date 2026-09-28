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
 * Query parameters of {@code getCounselSession} ({@code GET /api/comm/v1/center/cstalk/session}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetCounselSessionParams {

    private final String userKey;

    private GetCounselSessionParams(Builder builder) {
        this.userKey = builder.userKey;
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
        builder.userKey = userKey;
        return builder;
    }

    /**
     * 상담톡 사용자 키입니다. 1~20자입니다.
     *
     * <p>쿼리 {@code userKey} · 필수
     *
     * @return the value, or null
     */
    public String getUserKey() {
        return userKey;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (userKey != null) {
            query.put("userKey", userKey);
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
        if (!(o instanceof GetCounselSessionParams)) {
            return false;
        }
        GetCounselSessionParams other = (GetCounselSessionParams) o;
        return Objects.equals(userKey, other.userKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userKey);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetCounselSessionParams{", "}");
        if (userKey != null) {
            joiner.add("userKey=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetCounselSessionParams}. */
    public static final class Builder {
        private String userKey;

        private Builder() {
        }

        /**
         * 상담톡 사용자 키입니다. 1~20자입니다.
         *
         * <p>쿼리 {@code userKey} · 필수
         *
         * @param userKey the value (null clears it)
         * @return this builder
         */
        public Builder userKey(String userKey) {
            this.userKey = userKey;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetCounselSessionParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (userKey == null) {
                violations.add(new ValidationException.Violation("GetCounselSessionParams.userKey", "필수 값입니다"));
            }
            if (userKey != null && userKey.codePointCount(0, userKey.length()) > 20) {
                violations.add(new ValidationException.Violation("GetCounselSessionParams.userKey", "최대 20자입니다"));
            }
            if (userKey != null && userKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetCounselSessionParams.userKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (userKey != null && userKey.isEmpty()) {
                violations.add(new ValidationException.Violation("GetCounselSessionParams.userKey", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetCounselSessionParams(this);
        }

        GetCounselSessionParams buildUnvalidated() {
            return new GetCounselSessionParams(this);
        }
    }
}
