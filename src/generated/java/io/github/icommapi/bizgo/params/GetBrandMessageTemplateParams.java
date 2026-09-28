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
 * Query parameters of {@code getBrandMessageTemplate} ({@code GET /api/comm/v1/center/brandmessage/template}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetBrandMessageTemplateParams {

    private final String senderKey;
    private final String templateCode;
    private final String sendType;

    private GetBrandMessageTemplateParams(Builder builder) {
        this.senderKey = builder.senderKey;
        this.templateCode = builder.templateCode;
        this.sendType = builder.sendType;
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
        builder.sendType = sendType;
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
     * 브랜드메시지 발송 타입입니다. <code>basic</code>(기본형) 또는 <code>free</code>(자유형)입니다.
     *
     * <p>쿼리 {@code sendType} · 허용 값 <code>basic</code>, <code>free</code>
     *
     * @return the value, or null
     */
    public String getSendType() {
        return sendType;
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
        if (sendType != null) {
            query.put("sendType", sendType);
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
        if (!(o instanceof GetBrandMessageTemplateParams)) {
            return false;
        }
        GetBrandMessageTemplateParams other = (GetBrandMessageTemplateParams) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(sendType, other.sendType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, templateCode, sendType);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetBrandMessageTemplateParams{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (templateCode != null) {
            joiner.add("templateCode=***");
        }
        if (sendType != null) {
            joiner.add("sendType=" + sendType);
        }
        return joiner.toString();
    }

    /** Builder for {@link GetBrandMessageTemplateParams}. */
    public static final class Builder {
        private String senderKey;
        private String templateCode;
        private String sendType;

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
         * 브랜드메시지 발송 타입입니다. <code>basic</code>(기본형) 또는 <code>free</code>(자유형)입니다.
         *
         * <p>쿼리 {@code sendType} · 허용 값 <code>basic</code>, <code>free</code>
         *
         * @param sendType the value (null clears it)
         * @return this builder
         */
        public Builder sendType(String sendType) {
            this.sendType = sendType;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetBrandMessageTemplateParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("GetBrandMessageTemplateParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageTemplateParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("GetBrandMessageTemplateParams.senderKey", "빈 값입니다"));
            }
            if (templateCode == null) {
                violations.add(new ValidationException.Violation("GetBrandMessageTemplateParams.templateCode", "필수 값입니다"));
            }
            if (templateCode != null && templateCode.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageTemplateParams.templateCode", "제어 문자는 쓸 수 없습니다"));
            }
            if (templateCode != null && templateCode.isEmpty()) {
                violations.add(new ValidationException.Violation("GetBrandMessageTemplateParams.templateCode", "빈 값입니다"));
            }
            if (sendType != null && !List.of("basic", "free").contains(sendType)) {
                violations.add(new ValidationException.Violation("GetBrandMessageTemplateParams.sendType", "허용 값(basic, free)이 아닙니다"));
            }
            if (sendType != null && sendType.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageTemplateParams.sendType", "제어 문자는 쓸 수 없습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetBrandMessageTemplateParams(this);
        }

        GetBrandMessageTemplateParams buildUnvalidated() {
            return new GetBrandMessageTemplateParams(this);
        }
    }
}
