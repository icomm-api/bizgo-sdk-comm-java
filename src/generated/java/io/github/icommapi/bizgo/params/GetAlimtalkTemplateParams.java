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
 * Query parameters of {@code getAlimtalkTemplate} ({@code GET /api/comm/v1/center/alimtalk/template}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetAlimtalkTemplateParams {

    private final String senderKey;
    private final String templateCode;

    private GetAlimtalkTemplateParams(Builder builder) {
        this.senderKey = builder.senderKey;
        this.templateCode = builder.templateCode;
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
        builder.templateCode = templateCode;
        return builder;
    }

    /**
     * 발신프로필 키입니다.
     *
     * <p>쿼리 {@code senderKey} · 필수
     *
     * @return the value, or null
     */
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 템플릿 코드입니다.
     *
     * <p>쿼리 {@code templateCode} · 필수
     *
     * @return the value, or null
     */
    public String getTemplateCode() {
        return templateCode;
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
        if (templateCode != null) {
            query.put("templateCode", templateCode);
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
        if (!(o instanceof GetAlimtalkTemplateParams)) {
            return false;
        }
        GetAlimtalkTemplateParams other = (GetAlimtalkTemplateParams) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(templateCode, other.templateCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, templateCode);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetAlimtalkTemplateParams{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (templateCode != null) {
            joiner.add("templateCode=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetAlimtalkTemplateParams}. */
    public static final class Builder {
        private String senderKey;
        private String templateCode;

        private Builder() {
        }

        /**
         * 발신프로필 키입니다.
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
         * 템플릿 코드입니다.
         *
         * <p>쿼리 {@code templateCode} · 필수
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetAlimtalkTemplateParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("GetAlimtalkTemplateParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetAlimtalkTemplateParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("GetAlimtalkTemplateParams.senderKey", "빈 값입니다"));
            }
            if (templateCode == null) {
                violations.add(new ValidationException.Violation("GetAlimtalkTemplateParams.templateCode", "필수 값입니다"));
            }
            if (templateCode != null && templateCode.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetAlimtalkTemplateParams.templateCode", "제어 문자는 쓸 수 없습니다"));
            }
            if (templateCode != null && templateCode.isEmpty()) {
                violations.add(new ValidationException.Violation("GetAlimtalkTemplateParams.templateCode", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetAlimtalkTemplateParams(this);
        }

        GetAlimtalkTemplateParams buildUnvalidated() {
            return new GetAlimtalkTemplateParams(this);
        }
    }
}
