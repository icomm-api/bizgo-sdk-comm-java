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
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 상담톡 Plain 메시지 발송 요청입니다. 상담 세션이 열려 있는 사용자에게만 보낼 수 있습니다. 본문(<code>message</code>)과 첨부는 최종 사용자와의 상담 내용이므로 개인정보로 취급하고 로그에 남기지 않습니다.
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
@JsonDeserialize(builder = CounselPlainMessageRequest.Builder.class)
@JsonPropertyOrder({"userKey", "senderKey", "msgType", "message", "attachment", "ref"})
public final class CounselPlainMessageRequest {
    private static final List<String> MSG_TYPE_VALUES = List.of("TEXT", "IMAGE", "VIDEO", "AUDIO", "FILE");

    private final String userKey;
    private final String senderKey;
    private final String msgType;
    private final String message;
    private final CounselPlainAttachment attachment;
    private final String ref;

    private CounselPlainMessageRequest(Builder builder) {
        this.userKey = builder.userKey;
        this.senderKey = builder.senderKey;
        this.msgType = builder.msgType;
        this.message = builder.message;
        this.attachment = builder.attachment;
        this.ref = builder.ref;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.userKey = this.userKey;
        builder.senderKey = this.senderKey;
        builder.msgType = this.msgType;
        builder.message = this.message;
        builder.attachment = this.attachment;
        builder.ref = this.ref;
        return builder;
    }

    /**
     * Parse and validate a request written with the API field names (JSON).
     * Unknown fields are rejected so that typos fail before anything is sent.
     *
     * @param json request body, for example an example from the API reference
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static CounselPlainMessageRequest fromJson(String json) {
        return RequestParser.parse(json, CounselPlainMessageRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static CounselPlainMessageRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, CounselPlainMessageRequest.class);
    }

    /**
     * The JSON body that is sent. Contains phone numbers: do not log it.
     *
     * @return JSON with only the fields that were set
     */
    public String toJson() {
        return RequestParser.toJson(this);
    }

    /**
     * 상담톡 사용자 키입니다. 카카오톡 채널별로 다르며 대소문자를 구분합니다. 1~20자이며 비어 있거나 20자를 넘으면 <code>A507</code>이 반환됩니다.
     *
     * <p>필수 · 최대 20자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("userKey")
    public String getUserKey() {
        return userKey;
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
     * 메시지 타입입니다. IMAGE는 <code>attachment.image</code>, VIDEO·AUDIO·FILE은 <code>attachment.file</code>을 사용합니다.
     *
     * <p>필수 · 허용 값 <code>TEXT</code>, <code>IMAGE</code>, <code>VIDEO</code>, <code>AUDIO</code>, <code>FILE</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 사용자에게 전달할 메시지입니다. 최대 1,000자입니다.
     *
     * <p>필수 · 최대 1000자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * {@code attachment}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public CounselPlainAttachment getAttachment() {
        return attachment;
    }

    /**
     * 참조 필드입니다. 최대 200자이며 발송 결과 웹훅(<code>cstalk/result</code>)에서 함께 반환됩니다.
     *
     * <p>최대 200자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselPlainMessageRequest)) {
            return false;
        }
        CounselPlainMessageRequest other = (CounselPlainMessageRequest) o;
        return Objects.equals(userKey, other.userKey)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(message, other.message)
                && Objects.equals(attachment, other.attachment)
                && Objects.equals(ref, other.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userKey, senderKey, msgType, message, attachment, ref);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselPlainMessageRequest{", "}");
        if (userKey != null) {
            joiner.add("userKey=" + io.github.icommapi.bizgo.internal.Masking.length(userKey));
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (message != null) {
            joiner.add("message=" + io.github.icommapi.bizgo.internal.Masking.length(message));
        }
        if (attachment != null) {
            joiner.add("attachment=" + attachment);
        }
        if (ref != null) {
            joiner.add("ref=" + io.github.icommapi.bizgo.internal.Masking.length(ref));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselPlainMessageRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String userKey;
        private String senderKey;
        private String msgType;
        private String message;
        private CounselPlainAttachment attachment;
        private String ref;

        /** Creates an empty builder; same as {@link CounselPlainMessageRequest#builder()}. */
        public Builder() {
        }

        /**
         * 상담톡 사용자 키입니다. 카카오톡 채널별로 다르며 대소문자를 구분합니다. 1~20자이며 비어 있거나 20자를 넘으면 <code>A507</code>이 반환됩니다.
         *
         * <p>필수 · 최대 20자
         *
         * @param userKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("userKey")
        public Builder userKey(String userKey) {
            this.userKey = userKey;
            return this;
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
         * 메시지 타입입니다. IMAGE는 <code>attachment.image</code>, VIDEO·AUDIO·FILE은 <code>attachment.file</code>을 사용합니다.
         *
         * <p>필수 · 허용 값 <code>TEXT</code>, <code>IMAGE</code>, <code>VIDEO</code>, <code>AUDIO</code>, <code>FILE</code>
         *
         * @param msgType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("msgType")
        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        /**
         * 사용자에게 전달할 메시지입니다. 최대 1,000자입니다.
         *
         * <p>필수 · 최대 1000자
         *
         * @param message the value (null clears it)
         * @return this builder
         */
        @JsonProperty("message")
        public Builder message(String message) {
            this.message = message;
            return this;
        }

        /**
         * {@code attachment}.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        @JsonProperty("attachment")
        public Builder attachment(CounselPlainAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * 참조 필드입니다. 최대 200자이며 발송 결과 웹훅(<code>cstalk/result</code>)에서 함께 반환됩니다.
         *
         * <p>최대 200자
         *
         * @param ref the value (null clears it)
         * @return this builder
         */
        @JsonProperty("ref")
        public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselPlainMessageRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselPlainMessageRequest build() {
            CounselPlainMessageRequest built = new CounselPlainMessageRequest(this);
            ModelValidator v = new ModelValidator("CounselPlainMessageRequest");
            v.required("userKey", built.userKey);
            v.maxLength("userKey", built.userKey, 20);
            v.required("senderKey", built.senderKey);
            v.required("msgType", built.msgType);
            v.oneOf("msgType", built.msgType, MSG_TYPE_VALUES);
            v.required("message", built.message);
            v.maxLength("message", built.message, 1000);
            v.maxLength("ref", built.ref, 200);
            RequiredIf.checkObject(v, "CounselPlainMessageRequest", built); // x-sdk-required-if
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselPlainMessageRequest buildUnvalidated() {
            return new CounselPlainMessageRequest(this);
        }
    }
}
