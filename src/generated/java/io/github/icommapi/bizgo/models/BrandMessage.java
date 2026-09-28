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
 * 카카오 브랜드메시지입니다. 카카오톡 채널 친구에게 브랜드형 메시지를 발송합니다. <code>sendType</code>으로 발송 방식을 구분합니다.
 * <pre>| sendType | 방식 | 필수 필드 |
 * | --- | --- | --- |
 * | `basic` | 기본형. 사전 승인된 템플릿으로 발송합니다. 변수 분리 방식(`messageVariable` 등 `*Variable` 필드) 또는 전문 방식(`text`, `attachment`, `carousel`)을 템플릿 구조와 `msgType`에 맞게 선택해 씁니다. Variable 필드는 변수 치환이 필요할 때만 씁니다. | `sendType`, `msgType`, `senderKey`, `templateCode`, `targeting` |
 * | `template` | 기본형 템플릿 자동 치환. 템플릿 코드와 `destinations[].replaceWords`만으로 발송하며 Bizgo API가 전문을 생성합니다. 사용 가능 필드는 `senderKey`, `templateCode`, `sendType`, `targeting`, `pushAlarm`, `originCID`, `unsubscribePhoneNumber`, `unsubscribeAuthNumber`입니다. | `sendType`, `senderKey`, `templateCode`, `targeting` (+ `destinations[].replaceWords`) |
 * | `free` | 자유형. 템플릿 없이 본문·버튼·이미지·캐러셀 등을 직접 구성합니다. `templateCode`와 `*Variable` 필드는 쓰지 않으며, `groupTagKey`·`adult`·`adFlag`는 자유형에서만 씁니다. | `sendType`, `msgType`, `senderKey` |</pre>
 * <p>위 표의 <code>sendType</code>별 필수 필드는 <code>x-sdk-required-if</code>에 있으며 SDK가 보내기 전에 검사합니다. 아래 <code>msgType</code>별 요소는 설명으로만 두고 SDK가 검사하지 않습니다(<code>msgType</code> 값 확인 전).
 * <p><code>msgType</code>별 주요 요소(문서의 필드 제약에서 정리):
 * <ul>
 * <li><code>FT</code>: 본문 최대 1,300자</li>
 * <li><code>FI</code>: <code>attachment.image</code> 필수, 본문 최대 400자</li>
 * <li><code>FW</code>: 와이드 이미지. <code>attachment.image</code> 필수, 본문 최대 76자</li>
 * <li><code>FL</code>: 와이드 리스트. <code>attachment.item</code></li>
 * <li><code>FP</code>: 동영상. <code>attachment.video</code>, 본문 최대 76자</li>
 * <li><code>FM</code>: 커머스. <code>attachment.image</code> 필수, <code>attachment.commerce</code>, <code>additionalContent</code></li>
 * <li><code>FC</code>: 캐러셀 피드. <code>carousel</code>, 아이템별 <code>header</code>·<code>message</code>·<code>attachment.image</code> 필수, <code>carousel.head</code> 사용 불가</li>
 * <li><code>FA</code>: 캐러셀 커머스. <code>carousel</code>, 아이템별 <code>attachment.image</code> 필수·<code>attachment.commerce</code>, 아이템 <code>header</code>·<code>message</code>·<code>additionalContent</code> 사용 불가</li>
 * <li><code>FG</code>: 카탈로그. <code>header</code>(헤더 타이틀)·<code>attachment.catalog</code>(아이템 3~7개) 필수, <code>headerDescription</code> 사용. 친구톡 호환 모드로는 발송할 수 없고, PC톡·맥톡에서는 노출되지 않으며 카카오톡 v25.8.0 이상에서 확인할 수 있습니다. 기본형으로 등록한 카탈로그 템플릿은 <code>targeting</code> <code>M</code>·<code>N</code>으로 발송할 수 있습니다.</li>
 * </ul>
 *
 * <p>Sent as {@code messageFlow[].brandmessage}.
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
@JsonDeserialize(builder = BrandMessage.Builder.class)
@JsonPropertyOrder({"sendType", "msgType", "senderKey", "templateCode", "targeting", "text", "header", "headerDescription", "additionalContent", "groupTagKey", "adult", "pushAlarm", "adFlag", "messageVariable", "buttonVariable", "couponVariable", "imageVariable", "videoVariable", "commerceVariable", "carouselVariable", "catalogVariable", "originCID", "unsubscribePhoneNumber", "unsubscribeAuthNumber", "attachment", "carousel"})
public final class BrandMessage implements ChannelMessage {

    /** {@code messageFlow} channel key of this message. */
    public static final String CHANNEL_KEY = "brandmessage";
    private static final List<String> SEND_TYPE_VALUES = List.of("basic", "template", "free");
    private static final List<String> TARGETING_VALUES = List.of("M", "N", "O", "I");
    private static final List<String> ADULT_VALUES = List.of("Y", "N");
    private static final List<String> PUSH_ALARM_VALUES = List.of("Y", "N");
    private static final List<String> AD_FLAG_VALUES = List.of("Y", "N");

    private final String sendType;
    private final String msgType;
    private final String senderKey;
    private final String templateCode;
    private final String targeting;
    private final String text;
    private final String header;
    private final String headerDescription;
    private final String additionalContent;
    private final String groupTagKey;
    private final String adult;
    private final String pushAlarm;
    private final String adFlag;
    private final Map<String, Object> messageVariable;
    private final Map<String, Object> buttonVariable;
    private final Map<String, Object> couponVariable;
    private final Map<String, Object> imageVariable;
    private final Map<String, Object> videoVariable;
    private final Map<String, Object> commerceVariable;
    private final List<BrandMessageCarouselVariable> carouselVariable;
    private final List<BrandMessageCatalogVariable> catalogVariable;
    private final String originCID;
    private final String unsubscribePhoneNumber;
    private final String unsubscribeAuthNumber;
    private final BrandMessageAttachment attachment;
    private final BrandMessageCarousel carousel;

    private BrandMessage(Builder builder) {
        this.sendType = builder.sendType;
        this.msgType = builder.msgType;
        this.senderKey = builder.senderKey;
        this.templateCode = builder.templateCode;
        this.targeting = builder.targeting;
        this.text = builder.text;
        this.header = builder.header;
        this.headerDescription = builder.headerDescription;
        this.additionalContent = builder.additionalContent;
        this.groupTagKey = builder.groupTagKey;
        this.adult = builder.adult;
        this.pushAlarm = builder.pushAlarm;
        this.adFlag = builder.adFlag;
        this.messageVariable = builder.messageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.messageVariable));
        this.buttonVariable = builder.buttonVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.buttonVariable));
        this.couponVariable = builder.couponVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.couponVariable));
        this.imageVariable = builder.imageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.imageVariable));
        this.videoVariable = builder.videoVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.videoVariable));
        this.commerceVariable = builder.commerceVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.commerceVariable));
        this.carouselVariable = builder.carouselVariable == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.carouselVariable));
        this.catalogVariable = builder.catalogVariable == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.catalogVariable));
        this.originCID = builder.originCID;
        this.unsubscribePhoneNumber = builder.unsubscribePhoneNumber;
        this.unsubscribeAuthNumber = builder.unsubscribeAuthNumber;
        this.attachment = builder.attachment;
        this.carousel = builder.carousel;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.sendType = this.sendType;
        builder.msgType = this.msgType;
        builder.senderKey = this.senderKey;
        builder.templateCode = this.templateCode;
        builder.targeting = this.targeting;
        builder.text = this.text;
        builder.header = this.header;
        builder.headerDescription = this.headerDescription;
        builder.additionalContent = this.additionalContent;
        builder.groupTagKey = this.groupTagKey;
        builder.adult = this.adult;
        builder.pushAlarm = this.pushAlarm;
        builder.adFlag = this.adFlag;
        builder.messageVariable = this.messageVariable;
        builder.buttonVariable = this.buttonVariable;
        builder.couponVariable = this.couponVariable;
        builder.imageVariable = this.imageVariable;
        builder.videoVariable = this.videoVariable;
        builder.commerceVariable = this.commerceVariable;
        builder.carouselVariable = this.carouselVariable;
        builder.catalogVariable = this.catalogVariable;
        builder.originCID = this.originCID;
        builder.unsubscribePhoneNumber = this.unsubscribePhoneNumber;
        builder.unsubscribeAuthNumber = this.unsubscribeAuthNumber;
        builder.attachment = this.attachment;
        builder.carousel = this.carousel;
        return builder;
    }

    @Override
    public String channelKey() {
        return CHANNEL_KEY;
    }

    /**
     * 브랜드메시지 발송 타입입니다.
     * <ul>
     * <li><code>basic</code>: 기본형 발송</li>
     * <li><code>template</code>: 기본형 템플릿 자동 치환 발송</li>
     * <li><code>free</code>: 자유형 발송</li>
     * </ul>
     *
     * <p>필수 · 허용 값 <code>basic</code>, <code>template</code>, <code>free</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendType")
    public String getSendType() {
        return sendType;
    }

    /**
     * 카카오 비즈메시지(브랜드메시지) 타입입니다. <code>basic</code>, <code>free</code> 발송 시 필수입니다(<code>template</code>에서는 생략). 카카오 원본 chatBubbleType으로 변환됩니다. 알려진 값은 <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>입니다.
     *
     * <p>알려진 값 <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>
     *
     * <p><b>확인 필요:</b> 문서의 요청 예시는 msgType에 <code>TEXT</code>를 쓰지만 필드 설명·템플릿 규격은 <code>FT</code> 등 2자리 코드를 씁니다. 각 코드의 명칭(와이드/커머스 등)은 필드 제약과 이미지 업로드 API 이름에서 추정한 것입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
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
     * 브랜드메시지 템플릿 코드입니다. <code>basic</code>, <code>template</code> 발송 시 필수이며 <code>free</code>에서는 쓰지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 고객사의 광고성 정보 수신동의 회원 대상 타겟팅입니다. <code>basic</code>, <code>template</code> 발송 시 필수, <code>free</code>에서는 선택입니다. 허용된(allowlist) 발신프로필만 사용할 수 있습니다.
     * <ul>
     * <li><code>M</code>: 광고성 정보 수신동의 회원</li>
     * <li><code>N</code>: 광고성 정보 수신동의 회원 − 채널 친구</li>
     * <li><code>O</code>: 광고성 정보 수신동의 회원 ∩ 채널 친구 (수신거부 방식: 080 번호 안내)</li>
     * <li><code>I</code>: 광고성 정보 수신동의 회원 ∩ 채널 친구 (수신거부 방식: 채널 차단 안내)</li>
     * </ul>
     *
     * <p>허용 값 <code>M</code>, <code>N</code>, <code>O</code>, <code>I</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("targeting")
    public String getTargeting() {
        return targeting;
    }

    /**
     * 브랜드메시지 본문입니다. 최대 글자 수는 <code>msgType</code>에 따라 다릅니다(FT 1,300자, FI 400자, FW/FP 76자).
     *
     * <p>최대 1300자
     *
     * <p><b>확인 필요:</b> 자유형 발송 요청 예시는 본문을 <code>text</code>가 아닌 <code>content</code> 필드로 보냅니다. 필드 표(Part A)의 <code>text</code>를 따릅니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 헤더 정보입니다. 최대 20자입니다. <code>FG</code>(카탈로그)에서는 헤더 타이틀로 필수입니다.
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
     * 부가 정보입니다. <code>FM</code> 타입 전용이며 최대 34자입니다.
     *
     * <p>최대 34자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("additionalContent")
    public String getAdditionalContent() {
        return additionalContent;
    }

    /**
     * 그룹태그 등록으로 발급받은 키입니다. 자유형(<code>free</code>) 발송에서 씁니다. 최대 40자입니다.
     *
     * <p>최대 40자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupTagKey")
    public String getGroupTagKey() {
        return groupTagKey;
    }

    /**
     * 성인 대상 메시지 여부입니다. 자유형(<code>free</code>) 발송에서 씁니다. 기본값은 <code>N</code>입니다.
     *
     * <p>허용 값 <code>Y</code>, <code>N</code> · 서버 기본값 <code>N</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("adult")
    public String getAdult() {
        return adult;
    }

    /**
     * 메시지 도착 시 푸시 알림 발송 여부입니다. 기본값은 <code>Y</code>입니다.
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
     * 광고성 메시지 필수 표기 사항 노출 여부입니다. 자유형(<code>free</code>) 발송에서 씁니다. 기본값은 <code>Y</code>이며, <code>msgType</code>이 <code>FL</code>, <code>FC</code>, <code>FA</code>이면 <code>Y</code>로만 발송할 수 있습니다.
     *
     * <p>허용 값 <code>Y</code>, <code>N</code> · 서버 기본값 <code>Y</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("adFlag")
    public String getAdFlag() {
        return adFlag;
    }

    /**
     * 메시지 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FT, FI, FW, FL, FP, FM 타입에서 사용합니다.
     *
     * <p><b>확인 필요:</b> 변수 객체의 내부 구조(키·값 형식)가 문서에 없습니다. 기본형 요청 예시는 <code>messageVariable</code>을 <code>destinations[]</code> 안에 넣고 있어 위치도 불명확합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messageVariable")
    public Map<String, Object> getMessageVariable() {
        return messageVariable;
    }

    /**
     * 버튼 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FT, FI, FW, FL, FP, FM 타입에서 사용합니다.
     *
     * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttonVariable")
    public Map<String, Object> getButtonVariable() {
        return buttonVariable;
    }

    /**
     * 쿠폰 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FT, FI, FW, FL, FP, FM 타입에서 사용합니다.
     *
     * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("couponVariable")
    public Map<String, Object> getCouponVariable() {
        return couponVariable;
    }

    /**
     * 이미지 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FI, FW, FL, FM 타입에서 사용합니다.
     *
     * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageVariable")
    public Map<String, Object> getImageVariable() {
        return imageVariable;
    }

    /**
     * 비디오 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FP 타입에서 사용합니다.
     *
     * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("videoVariable")
    public Map<String, Object> getVideoVariable() {
        return videoVariable;
    }

    /**
     * 커머스 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FM 타입에서 사용합니다.
     *
     * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("commerceVariable")
    public Map<String, Object> getCommerceVariable() {
        return commerceVariable;
    }

    /**
     * 캐러셀 영역 변수 목록입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FC, FA 타입에서 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("carouselVariable")
    public List<BrandMessageCarouselVariable> getCarouselVariable() {
        return carouselVariable;
    }

    /**
     * FG(카탈로그) 전용 아이템 단위 변수입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("catalogVariable")
    public List<BrandMessageCatalogVariable> getCatalogVariable() {
        return catalogVariable;
    }

    /**
     * 최초 발신사업자 식별코드(최대 9자)입니다. 재판매사·특수부가통신사업자는 필수입니다.
     *
     * <p>최대 9자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("originCID")
    public String getOriginCID() {
        return originCID;
    }

    /**
     * 무료 수신거부 전화번호입니다. 최대 13자입니다.
     *
     * <p>최대 13자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("unsubscribePhoneNumber")
    public String getUnsubscribePhoneNumber() {
        return unsubscribePhoneNumber;
    }

    /**
     * 무료 수신거부 인증번호입니다. 최대 10자입니다.
     *
     * <p>최대 10자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("unsubscribeAuthNumber")
    public String getUnsubscribeAuthNumber() {
        return unsubscribeAuthNumber;
    }

    /**
     * {@code attachment}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public BrandMessageAttachment getAttachment() {
        return attachment;
    }

    /**
     * {@code carousel}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("carousel")
    public BrandMessageCarousel getCarousel() {
        return carousel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessage)) {
            return false;
        }
        BrandMessage other = (BrandMessage) o;
        return Objects.equals(sendType, other.sendType)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(targeting, other.targeting)
                && Objects.equals(text, other.text)
                && Objects.equals(header, other.header)
                && Objects.equals(headerDescription, other.headerDescription)
                && Objects.equals(additionalContent, other.additionalContent)
                && Objects.equals(groupTagKey, other.groupTagKey)
                && Objects.equals(adult, other.adult)
                && Objects.equals(pushAlarm, other.pushAlarm)
                && Objects.equals(adFlag, other.adFlag)
                && Objects.equals(messageVariable, other.messageVariable)
                && Objects.equals(buttonVariable, other.buttonVariable)
                && Objects.equals(couponVariable, other.couponVariable)
                && Objects.equals(imageVariable, other.imageVariable)
                && Objects.equals(videoVariable, other.videoVariable)
                && Objects.equals(commerceVariable, other.commerceVariable)
                && Objects.equals(carouselVariable, other.carouselVariable)
                && Objects.equals(catalogVariable, other.catalogVariable)
                && Objects.equals(originCID, other.originCID)
                && Objects.equals(unsubscribePhoneNumber, other.unsubscribePhoneNumber)
                && Objects.equals(unsubscribeAuthNumber, other.unsubscribeAuthNumber)
                && Objects.equals(attachment, other.attachment)
                && Objects.equals(carousel, other.carousel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sendType, msgType, senderKey, templateCode, targeting, text, header, headerDescription, additionalContent, groupTagKey, adult, pushAlarm, adFlag, messageVariable, buttonVariable, couponVariable, imageVariable, videoVariable, commerceVariable, carouselVariable, catalogVariable, originCID, unsubscribePhoneNumber, unsubscribeAuthNumber, attachment, carousel);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessage{", "}");
        if (sendType != null) {
            joiner.add("sendType=" + sendType);
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (targeting != null) {
            joiner.add("targeting=" + targeting);
        }
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
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
        if (groupTagKey != null) {
            joiner.add("groupTagKey=" + io.github.icommapi.bizgo.internal.Masking.length(groupTagKey));
        }
        if (adult != null) {
            joiner.add("adult=" + io.github.icommapi.bizgo.internal.Masking.length(adult));
        }
        if (pushAlarm != null) {
            joiner.add("pushAlarm=" + io.github.icommapi.bizgo.internal.Masking.length(pushAlarm));
        }
        if (adFlag != null) {
            joiner.add("adFlag=" + io.github.icommapi.bizgo.internal.Masking.length(adFlag));
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
        if (originCID != null) {
            joiner.add("originCID=" + io.github.icommapi.bizgo.internal.Masking.length(originCID));
        }
        if (unsubscribePhoneNumber != null) {
            joiner.add("unsubscribePhoneNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(unsubscribePhoneNumber));
        }
        if (unsubscribeAuthNumber != null) {
            joiner.add("unsubscribeAuthNumber=" + io.github.icommapi.bizgo.internal.Masking.length(unsubscribeAuthNumber));
        }
        if (attachment != null) {
            joiner.add("attachment=" + attachment);
        }
        if (carousel != null) {
            joiner.add("carousel=" + carousel);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String sendType;
        private String msgType;
        private String senderKey;
        private String templateCode;
        private String targeting;
        private String text;
        private String header;
        private String headerDescription;
        private String additionalContent;
        private String groupTagKey;
        private String adult;
        private String pushAlarm;
        private String adFlag;
        private Map<String, Object> messageVariable;
        private Map<String, Object> buttonVariable;
        private Map<String, Object> couponVariable;
        private Map<String, Object> imageVariable;
        private Map<String, Object> videoVariable;
        private Map<String, Object> commerceVariable;
        private List<BrandMessageCarouselVariable> carouselVariable;
        private List<BrandMessageCatalogVariable> catalogVariable;
        private String originCID;
        private String unsubscribePhoneNumber;
        private String unsubscribeAuthNumber;
        private BrandMessageAttachment attachment;
        private BrandMessageCarousel carousel;

        /** Creates an empty builder; same as {@link BrandMessage#builder()}. */
        public Builder() {
        }

        /**
         * 브랜드메시지 발송 타입입니다.
         * <ul>
         * <li><code>basic</code>: 기본형 발송</li>
         * <li><code>template</code>: 기본형 템플릿 자동 치환 발송</li>
         * <li><code>free</code>: 자유형 발송</li>
         * </ul>
         *
         * <p>필수 · 허용 값 <code>basic</code>, <code>template</code>, <code>free</code>
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
         * 카카오 비즈메시지(브랜드메시지) 타입입니다. <code>basic</code>, <code>free</code> 발송 시 필수입니다(<code>template</code>에서는 생략). 카카오 원본 chatBubbleType으로 변환됩니다. 알려진 값은 <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>입니다.
         *
         * <p>알려진 값 <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>
         *
         * <p><b>확인 필요:</b> 문서의 요청 예시는 msgType에 <code>TEXT</code>를 쓰지만 필드 설명·템플릿 규격은 <code>FT</code> 등 2자리 코드를 씁니다. 각 코드의 명칭(와이드/커머스 등)은 필드 제약과 이미지 업로드 API 이름에서 추정한 것입니다.
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
         * 브랜드메시지 템플릿 코드입니다. <code>basic</code>, <code>template</code> 발송 시 필수이며 <code>free</code>에서는 쓰지 않습니다.
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
         * 고객사의 광고성 정보 수신동의 회원 대상 타겟팅입니다. <code>basic</code>, <code>template</code> 발송 시 필수, <code>free</code>에서는 선택입니다. 허용된(allowlist) 발신프로필만 사용할 수 있습니다.
         * <ul>
         * <li><code>M</code>: 광고성 정보 수신동의 회원</li>
         * <li><code>N</code>: 광고성 정보 수신동의 회원 − 채널 친구</li>
         * <li><code>O</code>: 광고성 정보 수신동의 회원 ∩ 채널 친구 (수신거부 방식: 080 번호 안내)</li>
         * <li><code>I</code>: 광고성 정보 수신동의 회원 ∩ 채널 친구 (수신거부 방식: 채널 차단 안내)</li>
         * </ul>
         *
         * <p>허용 값 <code>M</code>, <code>N</code>, <code>O</code>, <code>I</code>
         *
         * @param targeting the value (null clears it)
         * @return this builder
         */
        @JsonProperty("targeting")
        public Builder targeting(String targeting) {
            this.targeting = targeting;
            return this;
        }

        /**
         * 브랜드메시지 본문입니다. 최대 글자 수는 <code>msgType</code>에 따라 다릅니다(FT 1,300자, FI 400자, FW/FP 76자).
         *
         * <p>최대 1300자
         *
         * <p><b>확인 필요:</b> 자유형 발송 요청 예시는 본문을 <code>text</code>가 아닌 <code>content</code> 필드로 보냅니다. 필드 표(Part A)의 <code>text</code>를 따릅니다.
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
         * 헤더 정보입니다. 최대 20자입니다. <code>FG</code>(카탈로그)에서는 헤더 타이틀로 필수입니다.
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
         * 부가 정보입니다. <code>FM</code> 타입 전용이며 최대 34자입니다.
         *
         * <p>최대 34자
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
         * 그룹태그 등록으로 발급받은 키입니다. 자유형(<code>free</code>) 발송에서 씁니다. 최대 40자입니다.
         *
         * <p>최대 40자
         *
         * @param groupTagKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("groupTagKey")
        public Builder groupTagKey(String groupTagKey) {
            this.groupTagKey = groupTagKey;
            return this;
        }

        /**
         * 성인 대상 메시지 여부입니다. 자유형(<code>free</code>) 발송에서 씁니다. 기본값은 <code>N</code>입니다.
         *
         * <p>허용 값 <code>Y</code>, <code>N</code> · 서버 기본값 <code>N</code>(설정하지 않으면 보내지 않음)
         *
         * @param adult the value (null clears it)
         * @return this builder
         */
        @JsonProperty("adult")
        public Builder adult(String adult) {
            this.adult = adult;
            return this;
        }

        /**
         * 메시지 도착 시 푸시 알림 발송 여부입니다. 기본값은 <code>Y</code>입니다.
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
         * 광고성 메시지 필수 표기 사항 노출 여부입니다. 자유형(<code>free</code>) 발송에서 씁니다. 기본값은 <code>Y</code>이며, <code>msgType</code>이 <code>FL</code>, <code>FC</code>, <code>FA</code>이면 <code>Y</code>로만 발송할 수 있습니다.
         *
         * <p>허용 값 <code>Y</code>, <code>N</code> · 서버 기본값 <code>Y</code>(설정하지 않으면 보내지 않음)
         *
         * @param adFlag the value (null clears it)
         * @return this builder
         */
        @JsonProperty("adFlag")
        public Builder adFlag(String adFlag) {
            this.adFlag = adFlag;
            return this;
        }

        /**
         * 메시지 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FT, FI, FW, FL, FP, FM 타입에서 사용합니다.
         *
         * <p><b>확인 필요:</b> 변수 객체의 내부 구조(키·값 형식)가 문서에 없습니다. 기본형 요청 예시는 <code>messageVariable</code>을 <code>destinations[]</code> 안에 넣고 있어 위치도 불명확합니다.
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
         * 버튼 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FT, FI, FW, FL, FP, FM 타입에서 사용합니다.
         *
         * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
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
         * 쿠폰 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FT, FI, FW, FL, FP, FM 타입에서 사용합니다.
         *
         * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
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
         * 이미지 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FI, FW, FL, FM 타입에서 사용합니다.
         *
         * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
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
         * 비디오 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FP 타입에서 사용합니다.
         *
         * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
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
         * 커머스 영역 변수 정의입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FM 타입에서 사용합니다.
         *
         * <p><b>확인 필요:</b> 변수 객체의 내부 구조가 문서에 없습니다.
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
         * 캐러셀 영역 변수 목록입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다. FC, FA 타입에서 사용합니다.
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
         * FG(카탈로그) 전용 아이템 단위 변수입니다. 기본형(<code>basic</code>) 변수 분리 방식에서 씁니다.
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
         * 최초 발신사업자 식별코드(최대 9자)입니다. 재판매사·특수부가통신사업자는 필수입니다.
         *
         * <p>최대 9자
         *
         * @param originCID the value (null clears it)
         * @return this builder
         */
        @JsonProperty("originCID")
        public Builder originCID(String originCID) {
            this.originCID = originCID;
            return this;
        }

        /**
         * 무료 수신거부 전화번호입니다. 최대 13자입니다.
         *
         * <p>최대 13자
         *
         * @param unsubscribePhoneNumber the value (null clears it)
         * @return this builder
         */
        @JsonProperty("unsubscribePhoneNumber")
        public Builder unsubscribePhoneNumber(String unsubscribePhoneNumber) {
            this.unsubscribePhoneNumber = unsubscribePhoneNumber;
            return this;
        }

        /**
         * 무료 수신거부 인증번호입니다. 최대 10자입니다.
         *
         * <p>최대 10자
         *
         * @param unsubscribeAuthNumber the value (null clears it)
         * @return this builder
         */
        @JsonProperty("unsubscribeAuthNumber")
        public Builder unsubscribeAuthNumber(String unsubscribeAuthNumber) {
            this.unsubscribeAuthNumber = unsubscribeAuthNumber;
            return this;
        }

        /**
         * {@code attachment}.
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
         * {@code carousel}.
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
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessage build() {
            BrandMessage built = new BrandMessage(this);
            ModelValidator v = new ModelValidator("BrandMessage");
            v.required("sendType", built.sendType);
            v.oneOf("sendType", built.sendType, SEND_TYPE_VALUES);
            v.required("senderKey", built.senderKey);
            v.oneOf("targeting", built.targeting, TARGETING_VALUES);
            v.maxLength("text", built.text, 1300);
            v.maxLength("header", built.header, 20);
            v.maxLength("additionalContent", built.additionalContent, 34);
            v.maxLength("groupTagKey", built.groupTagKey, 40);
            v.oneOf("adult", built.adult, ADULT_VALUES);
            v.oneOf("pushAlarm", built.pushAlarm, PUSH_ALARM_VALUES);
            v.oneOf("adFlag", built.adFlag, AD_FLAG_VALUES);
            v.mapValues("messageVariable", built.messageVariable, false);
            v.mapValues("buttonVariable", built.buttonVariable, false);
            v.mapValues("couponVariable", built.couponVariable, false);
            v.mapValues("imageVariable", built.imageVariable, false);
            v.mapValues("videoVariable", built.videoVariable, false);
            v.mapValues("commerceVariable", built.commerceVariable, false);
            v.items("carouselVariable", built.carouselVariable, -1, -1);
            v.items("catalogVariable", built.catalogVariable, -1, -1);
            v.maxLength("originCID", built.originCID, 9);
            v.maxLength("unsubscribePhoneNumber", built.unsubscribePhoneNumber, 13);
            v.maxLength("unsubscribeAuthNumber", built.unsubscribeAuthNumber, 10);
            RequiredIf.checkObject(v, "BrandMessage", built); // x-sdk-required-if
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessage buildUnvalidated() {
            return new BrandMessage(this);
        }
    }
}
