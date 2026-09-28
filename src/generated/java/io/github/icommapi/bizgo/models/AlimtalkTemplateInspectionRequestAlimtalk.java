// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 검수 요청할 알림톡 템플릿 정보입니다.
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
@JsonDeserialize(builder = AlimtalkTemplateInspectionRequestAlimtalk.Builder.class)
@JsonPropertyOrder({"senderKey", "senderKeyType", "templateCode", "comment"})
public final class AlimtalkTemplateInspectionRequestAlimtalk {
    private static final List<String> SENDER_KEY_TYPE_VALUES = List.of("G", "S");

    private final String senderKey;
    private final String senderKeyType;
    private final String templateCode;
    private final String comment;

    private AlimtalkTemplateInspectionRequestAlimtalk(Builder builder) {
        this.senderKey = builder.senderKey;
        this.senderKeyType = builder.senderKeyType;
        this.templateCode = builder.templateCode;
        this.comment = builder.comment;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.senderKeyType = this.senderKeyType;
        builder.templateCode = this.templateCode;
        builder.comment = this.comment;
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
     * 발신프로필 키 타입입니다. 기본값은 <code>S</code>입니다.
     * <ul>
     * <li><code>G</code>: 그룹</li>
     * <li><code>S</code>: 발신프로필</li>
     * </ul>
     *
     * <p>허용 값 <code>G</code>, <code>S</code> · 서버 기본값 <code>S</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKeyType")
    public String getSenderKeyType() {
        return senderKeyType;
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

    /**
     * 검수 의견 또는 문의 사항입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkTemplateInspectionRequestAlimtalk)) {
            return false;
        }
        AlimtalkTemplateInspectionRequestAlimtalk other = (AlimtalkTemplateInspectionRequestAlimtalk) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(senderKeyType, other.senderKeyType)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(comment, other.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, senderKeyType, templateCode, comment);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateInspectionRequestAlimtalk{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (senderKeyType != null) {
            joiner.add("senderKeyType=" + io.github.icommapi.bizgo.internal.Masking.length(senderKeyType));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (comment != null) {
            joiner.add("comment=" + io.github.icommapi.bizgo.internal.Masking.length(comment));
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateInspectionRequestAlimtalk}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String senderKeyType;
        private String templateCode;
        private String comment;

        /** Creates an empty builder; same as {@link AlimtalkTemplateInspectionRequestAlimtalk#builder()}. */
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
         * 발신프로필 키 타입입니다. 기본값은 <code>S</code>입니다.
         * <ul>
         * <li><code>G</code>: 그룹</li>
         * <li><code>S</code>: 발신프로필</li>
         * </ul>
         *
         * <p>허용 값 <code>G</code>, <code>S</code> · 서버 기본값 <code>S</code>(설정하지 않으면 보내지 않음)
         *
         * @param senderKeyType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("senderKeyType")
        public Builder senderKeyType(String senderKeyType) {
            this.senderKeyType = senderKeyType;
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
         * 검수 의견 또는 문의 사항입니다.
         *
         * @param comment the value (null clears it)
         * @return this builder
         */
        @JsonProperty("comment")
        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkTemplateInspectionRequestAlimtalk}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkTemplateInspectionRequestAlimtalk build() {
            AlimtalkTemplateInspectionRequestAlimtalk built = new AlimtalkTemplateInspectionRequestAlimtalk(this);
            ModelValidator v = new ModelValidator("AlimtalkTemplateInspectionRequestAlimtalk");
            v.required("senderKey", built.senderKey);
            v.oneOf("senderKeyType", built.senderKeyType, SENDER_KEY_TYPE_VALUES);
            v.required("templateCode", built.templateCode);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkTemplateInspectionRequestAlimtalk buildUnvalidated() {
            return new AlimtalkTemplateInspectionRequestAlimtalk(this);
        }
    }
}
