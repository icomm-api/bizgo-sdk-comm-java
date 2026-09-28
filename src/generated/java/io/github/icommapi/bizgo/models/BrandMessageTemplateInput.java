// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 브랜드메시지 템플릿 등록·수정 정보입니다. 이미지가 필요한 유형은 이미지 파일 관리 API로 먼저 <code>imgUrl</code>을 발급받아 씁니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 등록 요청 필드 표에 응답용으로 보이는 <code>createAt</code>·<code>modifiedAt</code>·<code>status</code>가 포함되어 있습니다(문서 그대로 옮김). 변수 객체(<code>*Variable</code>) 내부 구조도 문서에 없습니다.
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
@JsonDeserialize(builder = BrandMessageTemplateInput.Builder.class)
@JsonPropertyOrder({"senderKey", "senderKeyType", "sendType", "templateName", "msgType", "templateCode", "text", "carousel", "attachment", "header", "headerDescription", "additionalContent", "pushAlarm", "messageVariable", "buttonVariable", "couponVariable", "imageVariable", "videoVariable", "commerceVariable", "carouselVariable", "catalogVariable", "createAt", "modifiedAt", "status"})
public final class BrandMessageTemplateInput {
    private static final List<String> SEND_TYPE_VALUES = List.of("basic", "free");
    private static final List<String> PUSH_ALARM_VALUES = List.of("Y", "N");

    private final String senderKey;
    private final String senderKeyType;
    private final String sendType;
    private final String templateName;
    private final String msgType;
    private final String templateCode;
    private final String text;
    private final BrandMessageCarousel carousel;
    private final BrandMessageAttachment attachment;
    private final String header;
    private final String headerDescription;
    private final String additionalContent;
    private final String pushAlarm;
    private final Map<String, Object> messageVariable;
    private final Map<String, Object> buttonVariable;
    private final Map<String, Object> couponVariable;
    private final Map<String, Object> imageVariable;
    private final Map<String, Object> videoVariable;
    private final Map<String, Object> commerceVariable;
    private final List<BrandMessageCarouselVariable> carouselVariable;
    private final List<BrandMessageCatalogVariable> catalogVariable;
    private final String createAt;
    private final String modifiedAt;
    private final String status;

    private BrandMessageTemplateInput(Builder builder) {
        this.senderKey = builder.senderKey;
        this.senderKeyType = builder.senderKeyType;
        this.sendType = builder.sendType;
        this.templateName = builder.templateName;
        this.msgType = builder.msgType;
        this.templateCode = builder.templateCode;
        this.text = builder.text;
        this.carousel = builder.carousel;
        this.attachment = builder.attachment;
        this.header = builder.header;
        this.headerDescription = builder.headerDescription;
        this.additionalContent = builder.additionalContent;
        this.pushAlarm = builder.pushAlarm;
        this.messageVariable = builder.messageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.messageVariable));
        this.buttonVariable = builder.buttonVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.buttonVariable));
        this.couponVariable = builder.couponVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.couponVariable));
        this.imageVariable = builder.imageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.imageVariable));
        this.videoVariable = builder.videoVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.videoVariable));
        this.commerceVariable = builder.commerceVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.commerceVariable));
        this.carouselVariable = builder.carouselVariable == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.carouselVariable));
        this.catalogVariable = builder.catalogVariable == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.catalogVariable));
        this.createAt = builder.createAt;
        this.modifiedAt = builder.modifiedAt;
        this.status = builder.status;
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
        builder.sendType = this.sendType;
        builder.templateName = this.templateName;
        builder.msgType = this.msgType;
        builder.templateCode = this.templateCode;
        builder.text = this.text;
        builder.carousel = this.carousel;
        builder.attachment = this.attachment;
        builder.header = this.header;
        builder.headerDescription = this.headerDescription;
        builder.additionalContent = this.additionalContent;
        builder.pushAlarm = this.pushAlarm;
        builder.messageVariable = this.messageVariable;
        builder.buttonVariable = this.buttonVariable;
        builder.couponVariable = this.couponVariable;
        builder.imageVariable = this.imageVariable;
        builder.videoVariable = this.videoVariable;
        builder.commerceVariable = this.commerceVariable;
        builder.carouselVariable = this.carouselVariable;
        builder.catalogVariable = this.catalogVariable;
        builder.createAt = this.createAt;
        builder.modifiedAt = this.modifiedAt;
        builder.status = this.status;
        return builder;
    }

    /**
     * 카카오 비즈메시지 발신프로필 키입니다.
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
     * 발신프로필 키 타입입니다. 문서 예시 값은 <code>S</code>입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> Part A 필드 표는 필수로 표시하지만 요청 예시와 Part B 필드 표에는 없습니다. 값 목록도 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKeyType")
    public String getSenderKeyType() {
        return senderKeyType;
    }

    /**
     * 브랜드메시지 발송 타입입니다. <code>basic</code>(기본형) 또는 <code>free</code>(자유형)입니다.
     *
     * <p>필수 · 허용 값 <code>basic</code>, <code>free</code>
     *
     * <p><b>확인 필요:</b> <code>basic</code>/<code>free</code> 값 목록은 Part B에만 있습니다. 자유형(<code>free</code>) 템플릿의 의미가 문서에 설명되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendType")
    public String getSendType() {
        return sendType;
    }

    /**
     * 템플릿 이름입니다. 최대 200자입니다.
     *
     * <p>필수 · 최대 200자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateName")
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 브랜드메시지 메시지 타입입니다. 알려진 값: <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>(카탈로그).
     *
     * <p>필수 · 알려진 값 <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 템플릿 코드입니다. 수정 시 대상 템플릿을 지정합니다.
     *
     * <p><b>확인 필요:</b> 등록 시 직접 지정할 수 있는지(응답에서 발급되는지), 수정 시 필수인지 문서에 없습니다. 수정 요청 예시에도 templateCode가 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
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
     * 캐러셀 정보입니다(FC, FA).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("carousel")
    public BrandMessageCarousel getCarousel() {
        return carousel;
    }

    /**
     * 첨부 정보입니다. 버튼은 최대 5개, FT/FI에 쿠폰을 함께 쓰면 최대 4개입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public BrandMessageAttachment getAttachment() {
        return attachment;
    }

    /**
     * 헤더 정보입니다. 최대 20자입니다. <code>FG</code>에서는 헤더 타이틀로 씁니다.
     *
     * <p>최대 20자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * 헤더 디스크립션입니다. <code>msgType</code>이 <code>FG</code>일 때만 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("headerDescription")
    public String getHeaderDescription() {
        return headerDescription;
    }

    /**
     * 부가 정보입니다. <code>msgType</code>이 <code>FM</code>일 때 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("additionalContent")
    public String getAdditionalContent() {
        return additionalContent;
    }

    /**
     * 메시지 푸시 알림 발송 여부입니다. 기본값은 <code>Y</code>입니다.
     *
     * <p>허용 값 <code>Y</code>, <code>N</code> · 서버 기본값 <code>Y</code>(설정하지 않으면 보내지 않음)
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
     * FG(카탈로그) 전용 아이템 단위 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("catalogVariable")
    public List<BrandMessageCatalogVariable> getCatalogVariable() {
        return catalogVariable;
    }

    /**
     * 등록일입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("createAt")
    public String getCreateAt() {
        return createAt;
    }

    /**
     * 수정일입니다.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageTemplateInput)) {
            return false;
        }
        BrandMessageTemplateInput other = (BrandMessageTemplateInput) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(senderKeyType, other.senderKeyType)
                && Objects.equals(sendType, other.sendType)
                && Objects.equals(templateName, other.templateName)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(text, other.text)
                && Objects.equals(carousel, other.carousel)
                && Objects.equals(attachment, other.attachment)
                && Objects.equals(header, other.header)
                && Objects.equals(headerDescription, other.headerDescription)
                && Objects.equals(additionalContent, other.additionalContent)
                && Objects.equals(pushAlarm, other.pushAlarm)
                && Objects.equals(messageVariable, other.messageVariable)
                && Objects.equals(buttonVariable, other.buttonVariable)
                && Objects.equals(couponVariable, other.couponVariable)
                && Objects.equals(imageVariable, other.imageVariable)
                && Objects.equals(videoVariable, other.videoVariable)
                && Objects.equals(commerceVariable, other.commerceVariable)
                && Objects.equals(carouselVariable, other.carouselVariable)
                && Objects.equals(catalogVariable, other.catalogVariable)
                && Objects.equals(createAt, other.createAt)
                && Objects.equals(modifiedAt, other.modifiedAt)
                && Objects.equals(status, other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, senderKeyType, sendType, templateName, msgType, templateCode, text, carousel, attachment, header, headerDescription, additionalContent, pushAlarm, messageVariable, buttonVariable, couponVariable, imageVariable, videoVariable, commerceVariable, carouselVariable, catalogVariable, createAt, modifiedAt, status);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageTemplateInput{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (senderKeyType != null) {
            joiner.add("senderKeyType=" + io.github.icommapi.bizgo.internal.Masking.length(senderKeyType));
        }
        if (sendType != null) {
            joiner.add("sendType=" + sendType);
        }
        if (templateName != null) {
            joiner.add("templateName=" + io.github.icommapi.bizgo.internal.Masking.length(templateName));
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
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
        if (headerDescription != null) {
            joiner.add("headerDescription=" + io.github.icommapi.bizgo.internal.Masking.length(headerDescription));
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
        if (catalogVariable != null) {
            joiner.add("catalogVariable=" + catalogVariable);
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
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageTemplateInput}. */
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
        private String sendType;
        private String templateName;
        private String msgType;
        private String templateCode;
        private String text;
        private BrandMessageCarousel carousel;
        private BrandMessageAttachment attachment;
        private String header;
        private String headerDescription;
        private String additionalContent;
        private String pushAlarm;
        private Map<String, Object> messageVariable;
        private Map<String, Object> buttonVariable;
        private Map<String, Object> couponVariable;
        private Map<String, Object> imageVariable;
        private Map<String, Object> videoVariable;
        private Map<String, Object> commerceVariable;
        private List<BrandMessageCarouselVariable> carouselVariable;
        private List<BrandMessageCatalogVariable> catalogVariable;
        private String createAt;
        private String modifiedAt;
        private String status;

        /** Creates an empty builder; same as {@link BrandMessageTemplateInput#builder()}. */
        public Builder() {
        }

        /**
         * 카카오 비즈메시지 발신프로필 키입니다.
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
         * 발신프로필 키 타입입니다. 문서 예시 값은 <code>S</code>입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> Part A 필드 표는 필수로 표시하지만 요청 예시와 Part B 필드 표에는 없습니다. 값 목록도 문서에 없습니다.
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
         * 브랜드메시지 발송 타입입니다. <code>basic</code>(기본형) 또는 <code>free</code>(자유형)입니다.
         *
         * <p>필수 · 허용 값 <code>basic</code>, <code>free</code>
         *
         * <p><b>확인 필요:</b> <code>basic</code>/<code>free</code> 값 목록은 Part B에만 있습니다. 자유형(<code>free</code>) 템플릿의 의미가 문서에 설명되어 있지 않습니다.
         *
         * @param sendType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("sendType")
        public Builder sendType(String sendType) {
            this.sendType = sendType;
            return this;
        }

        /**
         * 템플릿 이름입니다. 최대 200자입니다.
         *
         * <p>필수 · 최대 200자
         *
         * @param templateName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("templateName")
        public Builder templateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        /**
         * 브랜드메시지 메시지 타입입니다. 알려진 값: <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>(카탈로그).
         *
         * <p>필수 · 알려진 값 <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>
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
         * 템플릿 코드입니다. 수정 시 대상 템플릿을 지정합니다.
         *
         * <p><b>확인 필요:</b> 등록 시 직접 지정할 수 있는지(응답에서 발급되는지), 수정 시 필수인지 문서에 없습니다. 수정 요청 예시에도 templateCode가 없습니다.
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
         * 템플릿 본문입니다.
         *
         * @param text the value (null clears it)
         * @return this builder
         */
        @JsonProperty("text")
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * 캐러셀 정보입니다(FC, FA).
         *
         * @param carousel the value (null clears it)
         * @return this builder
         */
        @JsonProperty("carousel")
        public Builder carousel(BrandMessageCarousel carousel) {
            this.carousel = carousel;
            return this;
        }

        /**
         * 첨부 정보입니다. 버튼은 최대 5개, FT/FI에 쿠폰을 함께 쓰면 최대 4개입니다.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        @JsonProperty("attachment")
        public Builder attachment(BrandMessageAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * 헤더 정보입니다. 최대 20자입니다. <code>FG</code>에서는 헤더 타이틀로 씁니다.
         *
         * <p>최대 20자
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
         * 헤더 디스크립션입니다. <code>msgType</code>이 <code>FG</code>일 때만 사용합니다.
         *
         * @param headerDescription the value (null clears it)
         * @return this builder
         */
        @JsonProperty("headerDescription")
        public Builder headerDescription(String headerDescription) {
            this.headerDescription = headerDescription;
            return this;
        }

        /**
         * 부가 정보입니다. <code>msgType</code>이 <code>FM</code>일 때 사용합니다.
         *
         * @param additionalContent the value (null clears it)
         * @return this builder
         */
        @JsonProperty("additionalContent")
        public Builder additionalContent(String additionalContent) {
            this.additionalContent = additionalContent;
            return this;
        }

        /**
         * 메시지 푸시 알림 발송 여부입니다. 기본값은 <code>Y</code>입니다.
         *
         * <p>허용 값 <code>Y</code>, <code>N</code> · 서버 기본값 <code>Y</code>(설정하지 않으면 보내지 않음)
         *
         * @param pushAlarm the value (null clears it)
         * @return this builder
         */
        @JsonProperty("pushAlarm")
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
        @JsonProperty("messageVariable")
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
        @JsonProperty("buttonVariable")
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
        @JsonProperty("couponVariable")
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
        @JsonProperty("imageVariable")
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
        @JsonProperty("videoVariable")
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
        @JsonProperty("commerceVariable")
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
        @JsonProperty("carouselVariable")
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
         * FG(카탈로그) 전용 아이템 단위 변수입니다.
         *
         * @param catalogVariable the value (null clears it)
         * @return this builder
         */
        @JsonProperty("catalogVariable")
        public Builder catalogVariable(List<BrandMessageCatalogVariable> catalogVariable) {
            this.catalogVariable = catalogVariable;
            return this;
        }

        /**
         * Varargs form of {@link #catalogVariable(List)}.
         *
         * @param catalogVariable values
         * @return this builder
         */
        public Builder catalogVariable(BrandMessageCatalogVariable... catalogVariable) {
            this.catalogVariable = catalogVariable == null ? null : Arrays.asList(catalogVariable);
            return this;
        }

        /**
         * 등록일입니다.
         *
         * @param createAt the value (null clears it)
         * @return this builder
         */
        @JsonProperty("createAt")
        public Builder createAt(String createAt) {
            this.createAt = createAt;
            return this;
        }

        /**
         * 수정일입니다.
         *
         * @param modifiedAt the value (null clears it)
         * @return this builder
         */
        @JsonProperty("modifiedAt")
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
        @JsonProperty("status")
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageTemplateInput}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageTemplateInput build() {
            BrandMessageTemplateInput built = new BrandMessageTemplateInput(this);
            ModelValidator v = new ModelValidator("BrandMessageTemplateInput");
            v.required("senderKey", built.senderKey);
            v.required("senderKeyType", built.senderKeyType);
            v.required("sendType", built.sendType);
            v.oneOf("sendType", built.sendType, SEND_TYPE_VALUES);
            v.required("templateName", built.templateName);
            v.maxLength("templateName", built.templateName, 200);
            v.required("msgType", built.msgType);
            v.maxLength("header", built.header, 20);
            v.oneOf("pushAlarm", built.pushAlarm, PUSH_ALARM_VALUES);
            v.mapValues("messageVariable", built.messageVariable, false);
            v.mapValues("buttonVariable", built.buttonVariable, false);
            v.mapValues("couponVariable", built.couponVariable, false);
            v.mapValues("imageVariable", built.imageVariable, false);
            v.mapValues("videoVariable", built.videoVariable, false);
            v.mapValues("commerceVariable", built.commerceVariable, false);
            v.items("carouselVariable", built.carouselVariable, -1, -1);
            v.items("catalogVariable", built.catalogVariable, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageTemplateInput buildUnvalidated() {
            return new BrandMessageTemplateInput(this);
        }
    }
}
