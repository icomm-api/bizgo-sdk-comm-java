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
 * Query parameters of {@code getRcsChatbot} ({@code GET /api/comm/v1/center/rcs/chatbot}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetRcsChatbotParams {

    private final String brandId;
    private final String chatbotId;

    private GetRcsChatbotParams(Builder builder) {
        this.brandId = builder.brandId;
        this.chatbotId = builder.chatbotId;
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
        builder.brandId = brandId;
        builder.chatbotId = chatbotId;
        return builder;
    }

    /**
     * 조회할 브랜드 ID입니다.
     *
     * <p>쿼리 {@code brandId} · 필수
     *
     * @return the value, or null
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * 조회할 대화방 ID입니다.
     *
     * <p>쿼리 {@code chatbotId} · 필수
     *
     * @return the value, or null
     */
    public String getChatbotId() {
        return chatbotId;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (brandId != null) {
            query.put("brandId", brandId);
        }
        if (chatbotId != null) {
            query.put("chatbotId", chatbotId);
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
        if (!(o instanceof GetRcsChatbotParams)) {
            return false;
        }
        GetRcsChatbotParams other = (GetRcsChatbotParams) o;
        return Objects.equals(brandId, other.brandId)
                && Objects.equals(chatbotId, other.chatbotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, chatbotId);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetRcsChatbotParams{", "}");
        if (brandId != null) {
            joiner.add("brandId=***");
        }
        if (chatbotId != null) {
            joiner.add("chatbotId=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetRcsChatbotParams}. */
    public static final class Builder {
        private String brandId;
        private String chatbotId;

        private Builder() {
        }

        /**
         * 조회할 브랜드 ID입니다.
         *
         * <p>쿼리 {@code brandId} · 필수
         *
         * @param brandId the value (null clears it)
         * @return this builder
         */
        public Builder brandId(String brandId) {
            this.brandId = brandId;
            return this;
        }

        /**
         * 조회할 대화방 ID입니다.
         *
         * <p>쿼리 {@code chatbotId} · 필수
         *
         * @param chatbotId the value (null clears it)
         * @return this builder
         */
        public Builder chatbotId(String chatbotId) {
            this.chatbotId = chatbotId;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetRcsChatbotParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (brandId == null) {
                violations.add(new ValidationException.Violation("GetRcsChatbotParams.brandId", "필수 값입니다"));
            }
            if (brandId != null && brandId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetRcsChatbotParams.brandId", "제어 문자는 쓸 수 없습니다"));
            }
            if (brandId != null && brandId.isEmpty()) {
                violations.add(new ValidationException.Violation("GetRcsChatbotParams.brandId", "빈 값입니다"));
            }
            if (chatbotId == null) {
                violations.add(new ValidationException.Violation("GetRcsChatbotParams.chatbotId", "필수 값입니다"));
            }
            if (chatbotId != null && chatbotId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetRcsChatbotParams.chatbotId", "제어 문자는 쓸 수 없습니다"));
            }
            if (chatbotId != null && chatbotId.isEmpty()) {
                violations.add(new ValidationException.Violation("GetRcsChatbotParams.chatbotId", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetRcsChatbotParams(this);
        }

        GetRcsChatbotParams buildUnvalidated() {
            return new GetRcsChatbotParams(this);
        }
    }
}
