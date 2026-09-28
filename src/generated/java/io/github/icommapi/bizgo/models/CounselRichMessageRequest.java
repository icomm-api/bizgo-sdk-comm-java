// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 상담톡 Rich 메시지 발송 요청입니다. 상담 세션이 열려 있는 사용자에게만 보낼 수 있습니다. 본문과 첨부는 최종 사용자와의 상담 내용이므로 개인정보로 취급하고 로그에 남기지 않습니다.
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
@JsonDeserialize(builder = CounselRichMessageRequest.Builder.class)
@JsonPropertyOrder({"userKey", "senderKey", "msgType", "message", "description", "header", "attachment", "carousel", "autoAnswer", "lock", "certExpiry", "ref"})
public final class CounselRichMessageRequest {

    private final String userKey;
    private final String senderKey;
    private final String msgType;
    private final String message;
    private final String description;
    private final String header;
    private final CounselRichAttachment attachment;
    private final CounselCarousel carousel;
    private final String autoAnswer;
    private final Boolean lock;
    private final Integer certExpiry;
    private final String ref;

    private CounselRichMessageRequest(Builder builder) {
        this.userKey = builder.userKey;
        this.senderKey = builder.senderKey;
        this.msgType = builder.msgType;
        this.message = builder.message;
        this.description = builder.description;
        this.header = builder.header;
        this.attachment = builder.attachment;
        this.carousel = builder.carousel;
        this.autoAnswer = builder.autoAnswer;
        this.lock = builder.lock;
        this.certExpiry = builder.certExpiry;
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
        builder.description = this.description;
        builder.header = this.header;
        builder.attachment = this.attachment;
        builder.carousel = this.carousel;
        builder.autoAnswer = this.autoAnswer;
        builder.lock = this.lock;
        builder.certExpiry = this.certExpiry;
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
    public static CounselRichMessageRequest fromJson(String json) {
        return RequestParser.parse(json, CounselRichMessageRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static CounselRichMessageRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, CounselRichMessageRequest.class);
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
     * 메시지 풍선 타입입니다. 문서가 지원 타입으로 나열한 값은 TEXT, IMAGE, WIDE, ITEM_LIST, WIDE_ITEM_LIST, CAROUSEL_FEED, PERSONAL이며, 본인인증 요청은 <code>KAKAO_CERT</code>입니다. <code>KAKAO_CERT</code>는 해당 채널이 본인인증 화이트리스트에 사전 등록되어 있어야 합니다 (이용문의 또는 영업담당자를 통해 신청하며, CI 활용 여부 증적 자료와 채널 정보를 제출합니다).
     *
     * <p>필수 · 알려진 값 <code>TEXT</code>, <code>IMAGE</code>, <code>WIDE</code>, <code>ITEM_LIST</code>, <code>WIDE_ITEM_LIST</code>, <code>CAROUSEL_FEED</code>, <code>PERSONAL</code>, <code>KAKAO_CERT</code>
     *
     * <p><b>확인 필요:</b> KAKAO_CERT는 한국어 페이지(Part A)의 안내 박스에만 있고 지원 타입 목록에는 없습니다. PERSONAL 타입에 필요한 요청 필드도 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 사용자에게 전달할 메시지입니다.
     *
     * <p><b>확인 필요:</b> Rich 메시지 본문의 최대 길이가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * 사용자에게 전달할 부가 메시지입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 헤더입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * {@code attachment}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public CounselRichAttachment getAttachment() {
        return attachment;
    }

    /**
     * {@code carousel}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("carousel")
    public CounselCarousel getCarousel() {
        return carousel;
    }

    /**
     * 시스템 자동 응답 메시지입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("autoAnswer")
    public String getAutoAnswer() {
        return autoAnswer;
    }

    /**
     * 보안 메시지 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("lock")
    public Boolean getLock() {
        return lock;
    }

    /**
     * 본인인증 유효 시간(분)입니다. <code>msgType</code>이 <code>KAKAO_CERT</code>일 때 필수입니다.
     *
     * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없습니다. 허용 범위가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("certExpiry")
    public Integer getCertExpiry() {
        return certExpiry;
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
        if (!(o instanceof CounselRichMessageRequest)) {
            return false;
        }
        CounselRichMessageRequest other = (CounselRichMessageRequest) o;
        return Objects.equals(userKey, other.userKey)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(message, other.message)
                && Objects.equals(description, other.description)
                && Objects.equals(header, other.header)
                && Objects.equals(attachment, other.attachment)
                && Objects.equals(carousel, other.carousel)
                && Objects.equals(autoAnswer, other.autoAnswer)
                && Objects.equals(lock, other.lock)
                && Objects.equals(certExpiry, other.certExpiry)
                && Objects.equals(ref, other.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userKey, senderKey, msgType, message, description, header, attachment, carousel, autoAnswer, lock, certExpiry, ref);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselRichMessageRequest{", "}");
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
        if (description != null) {
            joiner.add("description=" + io.github.icommapi.bizgo.internal.Masking.length(description));
        }
        if (header != null) {
            joiner.add("header=" + io.github.icommapi.bizgo.internal.Masking.length(header));
        }
        if (attachment != null) {
            joiner.add("attachment=" + attachment);
        }
        if (carousel != null) {
            joiner.add("carousel=" + carousel);
        }
        if (autoAnswer != null) {
            joiner.add("autoAnswer=" + io.github.icommapi.bizgo.internal.Masking.length(autoAnswer));
        }
        if (lock != null) {
            joiner.add("lock=***");
        }
        if (certExpiry != null) {
            joiner.add("certExpiry=***");
        }
        if (ref != null) {
            joiner.add("ref=" + io.github.icommapi.bizgo.internal.Masking.length(ref));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselRichMessageRequest}. */
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
        private String description;
        private String header;
        private CounselRichAttachment attachment;
        private CounselCarousel carousel;
        private String autoAnswer;
        private Boolean lock;
        private Integer certExpiry;
        private String ref;

        /** Creates an empty builder; same as {@link CounselRichMessageRequest#builder()}. */
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
         * 메시지 풍선 타입입니다. 문서가 지원 타입으로 나열한 값은 TEXT, IMAGE, WIDE, ITEM_LIST, WIDE_ITEM_LIST, CAROUSEL_FEED, PERSONAL이며, 본인인증 요청은 <code>KAKAO_CERT</code>입니다. <code>KAKAO_CERT</code>는 해당 채널이 본인인증 화이트리스트에 사전 등록되어 있어야 합니다 (이용문의 또는 영업담당자를 통해 신청하며, CI 활용 여부 증적 자료와 채널 정보를 제출합니다).
         *
         * <p>필수 · 알려진 값 <code>TEXT</code>, <code>IMAGE</code>, <code>WIDE</code>, <code>ITEM_LIST</code>, <code>WIDE_ITEM_LIST</code>, <code>CAROUSEL_FEED</code>, <code>PERSONAL</code>, <code>KAKAO_CERT</code>
         *
         * <p><b>확인 필요:</b> KAKAO_CERT는 한국어 페이지(Part A)의 안내 박스에만 있고 지원 타입 목록에는 없습니다. PERSONAL 타입에 필요한 요청 필드도 문서에 없습니다.
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
         * 사용자에게 전달할 메시지입니다.
         *
         * <p><b>확인 필요:</b> Rich 메시지 본문의 최대 길이가 문서에 없습니다.
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
         * 사용자에게 전달할 부가 메시지입니다.
         *
         * @param description the value (null clears it)
         * @return this builder
         */
        @JsonProperty("description")
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * 헤더입니다.
         *
         * @param header the value (null clears it)
         * @return this builder
         */
        @JsonProperty("header")
        public Builder header(String header) {
            this.header = header;
            return this;
        }

        /**
         * {@code attachment}.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        @JsonProperty("attachment")
        public Builder attachment(CounselRichAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * {@code carousel}.
         *
         * @param carousel the value (null clears it)
         * @return this builder
         */
        @JsonProperty("carousel")
        public Builder carousel(CounselCarousel carousel) {
            this.carousel = carousel;
            return this;
        }

        /**
         * 시스템 자동 응답 메시지입니다.
         *
         * @param autoAnswer the value (null clears it)
         * @return this builder
         */
        @JsonProperty("autoAnswer")
        public Builder autoAnswer(String autoAnswer) {
            this.autoAnswer = autoAnswer;
            return this;
        }

        /**
         * 보안 메시지 여부입니다.
         *
         * @param lock the value (null clears it)
         * @return this builder
         */
        @JsonProperty("lock")
        public Builder lock(Boolean lock) {
            this.lock = lock;
            return this;
        }

        /**
         * 본인인증 유효 시간(분)입니다. <code>msgType</code>이 <code>KAKAO_CERT</code>일 때 필수입니다.
         *
         * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없습니다. 허용 범위가 문서에 없습니다.
         *
         * @param certExpiry the value (null clears it)
         * @return this builder
         */
        @JsonProperty("certExpiry")
        public Builder certExpiry(Integer certExpiry) {
            this.certExpiry = certExpiry;
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
         * @return a new immutable {@code CounselRichMessageRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselRichMessageRequest build() {
            CounselRichMessageRequest built = new CounselRichMessageRequest(this);
            ModelValidator v = new ModelValidator("CounselRichMessageRequest");
            v.required("userKey", built.userKey);
            v.maxLength("userKey", built.userKey, 20);
            v.required("senderKey", built.senderKey);
            v.required("msgType", built.msgType);
            v.maxLength("ref", built.ref, 200);
            RequiredIf.checkObject(v, "CounselRichMessageRequest", built); // x-sdk-required-if
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselRichMessageRequest buildUnvalidated() {
            return new CounselRichMessageRequest(this);
        }
    }
}
