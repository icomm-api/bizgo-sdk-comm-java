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
 * Query parameters of {@code getRcsTemplate} ({@code GET /api/comm/v1/center/rcs/messagebase}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetRcsTemplateParams {

    private final String messagebaseId;

    private GetRcsTemplateParams(Builder builder) {
        this.messagebaseId = builder.messagebaseId;
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
        builder.messagebaseId = messagebaseId;
        return builder;
    }

    /**
     * 메시지베이스 ID입니다.
     *
     * <p>쿼리 {@code messagebaseId} · 필수
     *
     * @return the value, or null
     */
    public String getMessagebaseId() {
        return messagebaseId;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (messagebaseId != null) {
            query.put("messagebaseId", messagebaseId);
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
        if (!(o instanceof GetRcsTemplateParams)) {
            return false;
        }
        GetRcsTemplateParams other = (GetRcsTemplateParams) o;
        return Objects.equals(messagebaseId, other.messagebaseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messagebaseId);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetRcsTemplateParams{", "}");
        if (messagebaseId != null) {
            joiner.add("messagebaseId=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetRcsTemplateParams}. */
    public static final class Builder {
        private String messagebaseId;

        private Builder() {
        }

        /**
         * 메시지베이스 ID입니다.
         *
         * <p>쿼리 {@code messagebaseId} · 필수
         *
         * @param messagebaseId the value (null clears it)
         * @return this builder
         */
        public Builder messagebaseId(String messagebaseId) {
            this.messagebaseId = messagebaseId;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetRcsTemplateParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (messagebaseId == null) {
                violations.add(new ValidationException.Violation("GetRcsTemplateParams.messagebaseId", "필수 값입니다"));
            }
            if (messagebaseId != null && messagebaseId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetRcsTemplateParams.messagebaseId", "제어 문자는 쓸 수 없습니다"));
            }
            if (messagebaseId != null && messagebaseId.isEmpty()) {
                violations.add(new ValidationException.Violation("GetRcsTemplateParams.messagebaseId", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetRcsTemplateParams(this);
        }

        GetRcsTemplateParams buildUnvalidated() {
            return new GetRcsTemplateParams(this);
        }
    }
}
