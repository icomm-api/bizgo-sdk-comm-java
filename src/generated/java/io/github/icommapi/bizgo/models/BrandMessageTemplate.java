// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 브랜드메시지 템플릿 상세 정보입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 응답 필드 표에 <code>templateName</code>, <code>headerDescription</code>, <code>catalogVariable</code>, 카탈로그(<code>attachment.catalog</code>)가 없어 응답에 포함되는지 알 수 없습니다. 첨부 스키마는 발송용 스키마를 재사용하므로 발송 규격의 필수 표시가 응답에도 적용되는지는 확인이 필요합니다.
 *
 * <p>Response model: unknown JSON properties are kept in {@link #getAdditionalProperties()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({"senderKey", "sendType", "templateCode", "msgType", "text", "carousel", "attachment", "header", "additionalContent", "pushAlarm", "messageVariable", "buttonVariable", "couponVariable", "imageVariable", "videoVariable", "commerceVariable", "carouselVariable", "createAt", "modifiedAt", "status"})
public final class BrandMessageTemplate {

    private final String senderKey;
    private final String sendType;
    private final String templateCode;
    private final String msgType;
    private final String text;
    private final BrandMessageCarousel carousel;
    private final BrandMessageAttachment attachment;
    private final String header;
    private final String additionalContent;
    private final String pushAlarm;
    private final Map<String, Object> messageVariable;
    private final Map<String, Object> buttonVariable;
    private final Map<String, Object> couponVariable;
    private final Map<String, Object> imageVariable;
    private final Map<String, Object> videoVariable;
    private final Map<String, Object> commerceVariable;
    private final List<BrandMessageCarouselVariable> carouselVariable;
    private final String createAt;
    private final String modifiedAt;
    private final String status;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageTemplate(
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("sendType") String sendType,
            @JsonProperty("templateCode") String templateCode,
            @JsonProperty("msgType") String msgType,
            @JsonProperty("text") String text,
            @JsonProperty("carousel") BrandMessageCarousel carousel,
            @JsonProperty("attachment") BrandMessageAttachment attachment,
            @JsonProperty("header") String header,
            @JsonProperty("additionalContent") String additionalContent,
            @JsonProperty("pushAlarm") String pushAlarm,
            @JsonProperty("messageVariable") Map<String, Object> messageVariable,
            @JsonProperty("buttonVariable") Map<String, Object> buttonVariable,
            @JsonProperty("couponVariable") Map<String, Object> couponVariable,
            @JsonProperty("imageVariable") Map<String, Object> imageVariable,
            @JsonProperty("videoVariable") Map<String, Object> videoVariable,
            @JsonProperty("commerceVariable") Map<String, Object> commerceVariable,
            @JsonProperty("carouselVariable") List<BrandMessageCarouselVariable> carouselVariable,
            @JsonProperty("createAt") String createAt,
            @JsonProperty("modifiedAt") String modifiedAt,
            @JsonProperty("status") String status) {
        this.senderKey = senderKey;
        this.sendType = sendType;
        this.templateCode = templateCode;
        this.msgType = msgType;
        this.text = text;
        this.carousel = carousel;
        this.attachment = attachment;
        this.header = header;
        this.additionalContent = additionalContent;
        this.pushAlarm = pushAlarm;
        this.messageVariable = messageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(messageVariable));
        this.buttonVariable = buttonVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(buttonVariable));
        this.couponVariable = couponVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(couponVariable));
        this.imageVariable = imageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(imageVariable));
        this.videoVariable = videoVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(videoVariable));
        this.commerceVariable = commerceVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(commerceVariable));
        this.carouselVariable = carouselVariable == null ? null : Collections.unmodifiableList(new ArrayList<>(carouselVariable));
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.status = status;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageTemplate(Builder builder) {
        this(builder.senderKey, builder.sendType, builder.templateCode, builder.msgType, builder.text, builder.carousel, builder.attachment, builder.header, builder.additionalContent, builder.pushAlarm, builder.messageVariable, builder.buttonVariable, builder.couponVariable, builder.imageVariable, builder.videoVariable, builder.commerceVariable, builder.carouselVariable, builder.createAt, builder.modifiedAt, builder.status);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.sendType = this.sendType;
        builder.templateCode = this.templateCode;
        builder.msgType = this.msgType;
        builder.text = this.text;
        builder.carousel = this.carousel;
        builder.attachment = this.attachment;
        builder.header = this.header;
        builder.additionalContent = this.additionalContent;
        builder.pushAlarm = this.pushAlarm;
        builder.messageVariable = this.messageVariable;
        builder.buttonVariable = this.buttonVariable;
        builder.couponVariable = this.couponVariable;
        builder.imageVariable = this.imageVariable;
        builder.videoVariable = this.videoVariable;
        builder.commerceVariable = this.commerceVariable;
        builder.carouselVariable = this.carouselVariable;
        builder.createAt = this.createAt;
        builder.modifiedAt = this.modifiedAt;
        builder.status = this.status;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 발신프로필 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 브랜드메시지 발송 타입입니다(<code>basic</code>, <code>free</code>).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendType")
    public String getSendType() {
        return sendType;
    }

    /**
     * 템플릿 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 브랜드메시지 메시지 타입입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 템플릿 본문입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 캐러셀 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("carousel")
    public BrandMessageCarousel getCarousel() {
        return carousel;
    }

    /**
     * 첨부 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public BrandMessageAttachment getAttachment() {
        return attachment;
    }

    /**
     * 헤더 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * 부가 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("additionalContent")
    public String getAdditionalContent() {
        return additionalContent;
    }

    /**
     * 메시지 푸시 알림 발송 여부입니다.
     *
     * <p>허용 값 <code>Y</code>, <code>N</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("pushAlarm")
    public String getPushAlarm() {
        return pushAlarm;
    }

    /**
     * 메시지 영역 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messageVariable")
    public Map<String, Object> getMessageVariable() {
        return messageVariable;
    }

    /**
     * 버튼 영역 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttonVariable")
    public Map<String, Object> getButtonVariable() {
        return buttonVariable;
    }

    /**
     * 쿠폰 영역 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("couponVariable")
    public Map<String, Object> getCouponVariable() {
        return couponVariable;
    }

    /**
     * 이미지 영역 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageVariable")
    public Map<String, Object> getImageVariable() {
        return imageVariable;
    }

    /**
     * 비디오 영역 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("videoVariable")
    public Map<String, Object> getVideoVariable() {
        return videoVariable;
    }

    /**
     * 커머스 영역 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("commerceVariable")
    public Map<String, Object> getCommerceVariable() {
        return commerceVariable;
    }

    /**
     * 캐러셀 영역 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("carouselVariable")
    public List<BrandMessageCarouselVariable> getCarouselVariable() {
        return carouselVariable;
    }

    /**
     * 등록일(<code>yyyy-MM-dd'T'HH:mm:ssXXX</code>)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("createAt")
    public String getCreateAt() {
        return createAt;
    }

    /**
     * 수정일(<code>yyyy-MM-dd'T'HH:mm:ssXXX</code>)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("modifiedAt")
    public String getModifiedAt() {
        return modifiedAt;
    }

    /**
     * 템플릿 상태입니다. 알려진 값: <code>A</code>(등록), <code>S</code>(차단).
     *
     * <p>알려진 값 <code>A</code>, <code>S</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Properties the server sent that are not in the spec (new fields are kept instead of dropped).
     *
     * @return unmodifiable map, empty if there are none
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnySetter
    private void putAdditionalProperty(String name, Object value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageTemplate)) {
            return false;
        }
        BrandMessageTemplate other = (BrandMessageTemplate) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(sendType, other.sendType)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(text, other.text)
                && Objects.equals(carousel, other.carousel)
                && Objects.equals(attachment, other.attachment)
                && Objects.equals(header, other.header)
                && Objects.equals(additionalContent, other.additionalContent)
                && Objects.equals(pushAlarm, other.pushAlarm)
                && Objects.equals(messageVariable, other.messageVariable)
                && Objects.equals(buttonVariable, other.buttonVariable)
                && Objects.equals(couponVariable, other.couponVariable)
                && Objects.equals(imageVariable, other.imageVariable)
                && Objects.equals(videoVariable, other.videoVariable)
                && Objects.equals(commerceVariable, other.commerceVariable)
                && Objects.equals(carouselVariable, other.carouselVariable)
                && Objects.equals(createAt, other.createAt)
                && Objects.equals(modifiedAt, other.modifiedAt)
                && Objects.equals(status, other.status)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, sendType, templateCode, msgType, text, carousel, attachment, header, additionalContent, pushAlarm, messageVariable, buttonVariable, couponVariable, imageVariable, videoVariable, commerceVariable, carouselVariable, createAt, modifiedAt, status, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageTemplate{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (sendType != null) {
            joiner.add("sendType=" + sendType);
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
        }
        if (carousel != null) {
            joiner.add("carousel=" + carousel);
        }
        if (attachment != null) {
            joiner.add("attachment=" + attachment);
        }
        if (header != null) {
            joiner.add("header=" + io.github.icommapi.bizgo.internal.Masking.length(header));
        }
        if (additionalContent != null) {
            joiner.add("additionalContent=" + io.github.icommapi.bizgo.internal.Masking.length(additionalContent));
        }
        if (pushAlarm != null) {
            joiner.add("pushAlarm=" + io.github.icommapi.bizgo.internal.Masking.length(pushAlarm));
        }
        if (messageVariable != null) {
            joiner.add("messageVariable=***");
        }
        if (buttonVariable != null) {
            joiner.add("buttonVariable=***");
        }
        if (couponVariable != null) {
            joiner.add("couponVariable=***");
        }
        if (imageVariable != null) {
            joiner.add("imageVariable=***");
        }
        if (videoVariable != null) {
            joiner.add("videoVariable=***");
        }
        if (commerceVariable != null) {
            joiner.add("commerceVariable=***");
        }
        if (carouselVariable != null) {
            joiner.add("carouselVariable=" + carouselVariable);
        }
        if (createAt != null) {
            joiner.add("createAt=" + io.github.icommapi.bizgo.internal.Masking.length(createAt));
        }
        if (modifiedAt != null) {
            joiner.add("modifiedAt=" + io.github.icommapi.bizgo.internal.Masking.length(modifiedAt));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageTemplate}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String sendType;
        private String templateCode;
        private String msgType;
        private String text;
        private BrandMessageCarousel carousel;
        private BrandMessageAttachment attachment;
        private String header;
        private String additionalContent;
        private String pushAlarm;
        private Map<String, Object> messageVariable;
        private Map<String, Object> buttonVariable;
        private Map<String, Object> couponVariable;
        private Map<String, Object> imageVariable;
        private Map<String, Object> videoVariable;
        private Map<String, Object> commerceVariable;
        private List<BrandMessageCarouselVariable> carouselVariable;
        private String createAt;
        private String modifiedAt;
        private String status;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageTemplate#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다.
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 브랜드메시지 발송 타입입니다(<code>basic</code>, <code>free</code>).
         *
         * @param sendType the value (null clears it)
         * @return this builder
         */
        public Builder sendType(String sendType) {
            this.sendType = sendType;
            return this;
        }

        /**
         * 템플릿 코드입니다.
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * 브랜드메시지 메시지 타입입니다.
         *
         * @param msgType the value (null clears it)
         * @return this builder
         */
        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        /**
         * 템플릿 본문입니다.
         *
         * @param text the value (null clears it)
         * @return this builder
         */
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * 캐러셀 정보입니다.
         *
         * @param carousel the value (null clears it)
         * @return this builder
         */
        public Builder carousel(BrandMessageCarousel carousel) {
            this.carousel = carousel;
            return this;
        }

        /**
         * 첨부 정보입니다.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        public Builder attachment(BrandMessageAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * 헤더 정보입니다.
         *
         * @param header the value (null clears it)
         * @return this builder
         */
        public Builder header(String header) {
            this.header = header;
            return this;
        }

        /**
         * 부가 정보입니다.
         *
         * @param additionalContent the value (null clears it)
         * @return this builder
         */
        public Builder additionalContent(String additionalContent) {
            this.additionalContent = additionalContent;
            return this;
        }

        /**
         * 메시지 푸시 알림 발송 여부입니다.
         *
         * <p>허용 값 <code>Y</code>, <code>N</code>
         *
         * @param pushAlarm the value (null clears it)
         * @return this builder
         */
        public Builder pushAlarm(String pushAlarm) {
            this.pushAlarm = pushAlarm;
            return this;
        }

        /**
         * 메시지 영역 변수입니다.
         *
         * @param messageVariable the value (null clears it)
         * @return this builder
         */
        public Builder messageVariable(Map<String, Object> messageVariable) {
            this.messageVariable = messageVariable;
            return this;
        }

        /**
         * 버튼 영역 변수입니다.
         *
         * @param buttonVariable the value (null clears it)
         * @return this builder
         */
        public Builder buttonVariable(Map<String, Object> buttonVariable) {
            this.buttonVariable = buttonVariable;
            return this;
        }

        /**
         * 쿠폰 영역 변수입니다.
         *
         * @param couponVariable the value (null clears it)
         * @return this builder
         */
        public Builder couponVariable(Map<String, Object> couponVariable) {
            this.couponVariable = couponVariable;
            return this;
        }

        /**
         * 이미지 영역 변수입니다.
         *
         * @param imageVariable the value (null clears it)
         * @return this builder
         */
        public Builder imageVariable(Map<String, Object> imageVariable) {
            this.imageVariable = imageVariable;
            return this;
        }

        /**
         * 비디오 영역 변수입니다.
         *
         * @param videoVariable the value (null clears it)
         * @return this builder
         */
        public Builder videoVariable(Map<String, Object> videoVariable) {
            this.videoVariable = videoVariable;
            return this;
        }

        /**
         * 커머스 영역 변수입니다.
         *
         * @param commerceVariable the value (null clears it)
         * @return this builder
         */
        public Builder commerceVariable(Map<String, Object> commerceVariable) {
            this.commerceVariable = commerceVariable;
            return this;
        }

        /**
         * 캐러셀 영역 변수입니다.
         *
         * @param carouselVariable the value (null clears it)
         * @return this builder
         */
        public Builder carouselVariable(List<BrandMessageCarouselVariable> carouselVariable) {
            this.carouselVariable = carouselVariable;
            return this;
        }

        /**
         * Varargs form of {@link #carouselVariable(List)}.
         *
         * @param carouselVariable values
         * @return this builder
         */
        public Builder carouselVariable(BrandMessageCarouselVariable... carouselVariable) {
            this.carouselVariable = carouselVariable == null ? null : Arrays.asList(carouselVariable);
            return this;
        }

        /**
         * 등록일(<code>yyyy-MM-dd'T'HH:mm:ssXXX</code>)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
         *
         * @param createAt the value (null clears it)
         * @return this builder
         */
        public Builder createAt(String createAt) {
            this.createAt = createAt;
            return this;
        }

        /**
         * 수정일(<code>yyyy-MM-dd'T'HH:mm:ssXXX</code>)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
         *
         * @param modifiedAt the value (null clears it)
         * @return this builder
         */
        public Builder modifiedAt(String modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        /**
         * 템플릿 상태입니다. 알려진 값: <code>A</code>(등록), <code>S</code>(차단).
         *
         * <p>알려진 값 <code>A</code>, <code>S</code>
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Adds a property that is not in the spec.
         *
         * @param name JSON property name
         * @param value value
         * @return this builder
         */
        public Builder additionalProperty(String name, Object value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageTemplate}
         */
        public BrandMessageTemplate build() {
            return new BrandMessageTemplate(this);
        }
    }
}
