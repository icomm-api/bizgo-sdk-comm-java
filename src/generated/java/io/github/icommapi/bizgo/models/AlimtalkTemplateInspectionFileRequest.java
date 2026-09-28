// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.github.icommapi.bizgo.FileUpload;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 알림톡 템플릿 검수 요청(파일첨부, multipart/form-data)입니다. 파일 형식은 png, jpg, jpeg, gif, pdf, hwp, doc, docx입니다.
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
@JsonDeserialize(builder = AlimtalkTemplateInspectionFileRequest.Builder.class)
@JsonPropertyOrder({"senderKey", "senderKeyType", "templateCode", "comment", "attachment"})
public final class AlimtalkTemplateInspectionFileRequest {
    private static final List<String> SENDER_KEY_TYPE_VALUES = List.of("G", "S");

    private final String senderKey;
    private final String senderKeyType;
    private final String templateCode;
    private final String comment;
    private final List<FileUpload> attachment;

    private AlimtalkTemplateInspectionFileRequest(Builder builder) {
        this.senderKey = builder.senderKey;
        this.senderKeyType = builder.senderKeyType;
        this.templateCode = builder.templateCode;
        this.comment = builder.comment;
        this.attachment = builder.attachment == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.attachment));
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
        builder.attachment = this.attachment;
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
     * 검수 의견 또는 문의 사항입니다. 파일첨부 요청에서는 필수입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    /**
     * 검수 요청에 첨부할 파일입니다. <code>attachment</code> 필드를 반복해 최대 10개까지 보낼 수 있으며, 파일당 최대 50MB, 합계 최대 100MB입니다.
     *
     * <p>항목 수 0~10
     *
     * <p><b>확인 필요:</b> 한국어 페이지(Part A)는 단일 Binary로, Copy Markdown(Part B)은 최대 10개·파일당 50MB·합계 100MB로 설명합니다. 여러 파일을 같은 필드명으로 반복하는지 확인이 필요합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public List<FileUpload> getAttachment() {
        return attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkTemplateInspectionFileRequest)) {
            return false;
        }
        AlimtalkTemplateInspectionFileRequest other = (AlimtalkTemplateInspectionFileRequest) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(senderKeyType, other.senderKeyType)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(comment, other.comment)
                && Objects.equals(attachment, other.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, senderKeyType, templateCode, comment, attachment);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateInspectionFileRequest{", "}");
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
        if (attachment != null) {
            joiner.add("attachment=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateInspectionFileRequest}. */
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
        private List<FileUpload> attachment;

        /** Creates an empty builder; same as {@link AlimtalkTemplateInspectionFileRequest#builder()}. */
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
         * 검수 의견 또는 문의 사항입니다. 파일첨부 요청에서는 필수입니다.
         *
         * <p>필수
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
         * 검수 요청에 첨부할 파일입니다. <code>attachment</code> 필드를 반복해 최대 10개까지 보낼 수 있으며, 파일당 최대 50MB, 합계 최대 100MB입니다.
         *
         * <p>항목 수 0~10
         *
         * <p><b>확인 필요:</b> 한국어 페이지(Part A)는 단일 Binary로, Copy Markdown(Part B)은 최대 10개·파일당 50MB·합계 100MB로 설명합니다. 여러 파일을 같은 필드명으로 반복하는지 확인이 필요합니다.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        @JsonProperty("attachment")
        public Builder attachment(List<FileUpload> attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * Varargs form of {@link #attachment(List)}.
         *
         * @param attachment values
         * @return this builder
         */
        public Builder attachment(FileUpload... attachment) {
            this.attachment = attachment == null ? null : Arrays.asList(attachment);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkTemplateInspectionFileRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkTemplateInspectionFileRequest build() {
            AlimtalkTemplateInspectionFileRequest built = new AlimtalkTemplateInspectionFileRequest(this);
            ModelValidator v = new ModelValidator("AlimtalkTemplateInspectionFileRequest");
            v.required("senderKey", built.senderKey);
            v.oneOf("senderKeyType", built.senderKeyType, SENDER_KEY_TYPE_VALUES);
            v.required("templateCode", built.templateCode);
            v.required("comment", built.comment);
            v.items("attachment", built.attachment, -1, 10);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkTemplateInspectionFileRequest buildUnvalidated() {
            return new AlimtalkTemplateInspectionFileRequest(this);
        }
    }
}
