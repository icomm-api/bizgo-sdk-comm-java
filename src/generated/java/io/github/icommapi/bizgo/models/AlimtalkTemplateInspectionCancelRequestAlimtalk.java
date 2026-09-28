// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 검수 요청 취소 대상 템플릿 정보입니다.
 *
 * <p>Request model: immutable, created with {@link #builder()}, validated in {@link Builder#build()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonDeserialize(builder = AlimtalkTemplateInspectionCancelRequestAlimtalk.Builder.class)
@JsonPropertyOrder({"senderKey", "templateCode"})
public final class AlimtalkTemplateInspectionCancelRequestAlimtalk {

    private final String senderKey;
    private final String templateCode;

    private AlimtalkTemplateInspectionCancelRequestAlimtalk(Builder builder) {
        this.senderKey = builder.senderKey;
        this.templateCode = builder.templateCode;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.templateCode = this.templateCode;
        return builder;
    }

    /**
     * 발신프로필 키입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 템플릿 코드입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkTemplateInspectionCancelRequestAlimtalk)) {
            return false;
        }
        AlimtalkTemplateInspectionCancelRequestAlimtalk other = (AlimtalkTemplateInspectionCancelRequestAlimtalk) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(templateCode, other.templateCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, templateCode);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateInspectionCancelRequestAlimtalk{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateInspectionCancelRequestAlimtalk}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String templateCode;

        /** Creates an empty builder; same as {@link AlimtalkTemplateInspectionCancelRequestAlimtalk#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다.
         *
         * <p>필수
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("senderKey")
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 템플릿 코드입니다.
         *
         * <p>필수
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        @JsonProperty("templateCode")
        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkTemplateInspectionCancelRequestAlimtalk}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkTemplateInspectionCancelRequestAlimtalk build() {
            AlimtalkTemplateInspectionCancelRequestAlimtalk built = new AlimtalkTemplateInspectionCancelRequestAlimtalk(this);
            ModelValidator v = new ModelValidator("AlimtalkTemplateInspectionCancelRequestAlimtalk");
            v.required("senderKey", built.senderKey);
            v.required("templateCode", built.templateCode);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkTemplateInspectionCancelRequestAlimtalk buildUnvalidated() {
            return new AlimtalkTemplateInspectionCancelRequestAlimtalk(this);
        }
    }
}
