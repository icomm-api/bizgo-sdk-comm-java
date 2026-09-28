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
import java.util.regex.Pattern;

/**
 * 카카오 알림톡 메시지입니다. 카카오가 승인한 템플릿을 기반으로 정보성 메시지를 발송합니다.
 * <p>발송 방식은 2가지입니다.
 * <ul>
 * <li><b>전문 발송</b>: <code>msgType</code>(AT/AI), <code>text</code> 등 템플릿 전문을 본문에 직접 넣습니다. 이때 <code>msgType</code>과 <code>text</code>는 필수입니다.</li>
 * <li><b>템플릿 자동 치환 발송</b>: <code>sendType</code>을 <code>template</code>으로 두고 <code>senderKey</code>, <code>templateCode</code>만 보냅니다. Bizgo API가 템플릿 코드에 맞는 전문을 만든 뒤 <code>destinations[].replaceWords</code> 값을 치환합니다. 이 방식에서는 <code>destinations[].replaceWords</code>가 필수이며, <code>msgType</code>·<code>text</code>·<code>attachment</code> 등 전문 필드는 문서에 없습니다.</li>
 * </ul>
 * <p>두 방식의 조건부 필수 필드는 <code>x-sdk-required-if</code>에 있습니다. SDK는 보내기 전에 이 규칙을 검사합니다.
 *
 * <p>Sent as {@code messageFlow[].alimtalk}.
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
@JsonDeserialize(builder = AlimtalkMessage.Builder.class)
@JsonPropertyOrder({"msgType", "senderKey", "templateCode", "sendType", "responseMethod", "timeout", "text", "title", "header", "link", "attachment", "supplement", "price", "currencyType"})
public final class AlimtalkMessage implements ChannelMessage {

    /** {@code messageFlow} channel key of this message. */
    public static final String CHANNEL_KEY = "alimtalk";
    private static final List<String> MSG_TYPE_VALUES = List.of("AT", "AI");
    private static final List<String> SEND_TYPE_VALUES = List.of("template");
    private static final List<String> RESPONSE_METHOD_VALUES = List.of("push", "polling");
    private static final Pattern TIMEOUT_PATTERN = Pattern.compile("^[0-9]+$");

    private final String msgType;
    private final String senderKey;
    private final String templateCode;
    private final String sendType;
    private final String responseMethod;
    private final String timeout;
    private final String text;
    private final String title;
    private final String header;
    private final AlimtalkLink link;
    private final AlimtalkAttachment attachment;
    private final AlimtalkSupplement supplement;
    private final String price;
    private final String currencyType;

    private AlimtalkMessage(Builder builder) {
        this.msgType = builder.msgType;
        this.senderKey = builder.senderKey;
        this.templateCode = builder.templateCode;
        this.sendType = builder.sendType;
        this.responseMethod = builder.responseMethod;
        this.timeout = builder.timeout;
        this.text = builder.text;
        this.title = builder.title;
        this.header = builder.header;
        this.link = builder.link;
        this.attachment = builder.attachment;
        this.supplement = builder.supplement;
        this.price = builder.price;
        this.currencyType = builder.currencyType;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.msgType = this.msgType;
        builder.senderKey = this.senderKey;
        builder.templateCode = this.templateCode;
        builder.sendType = this.sendType;
        builder.responseMethod = this.responseMethod;
        builder.timeout = this.timeout;
        builder.text = this.text;
        builder.title = this.title;
        builder.header = this.header;
        builder.link = this.link;
        builder.attachment = this.attachment;
        builder.supplement = this.supplement;
        builder.price = this.price;
        builder.currencyType = this.currencyType;
        return builder;
    }

    @Override
    public String channelKey() {
        return CHANNEL_KEY;
    }

    /**
     * 카카오 비즈메시지 타입입니다. 전문 발송(<code>sendType</code>이 <code>template</code>이 아님) 시 필수이며, 빠지면 서버가 A523으로 거절합니다(템플릿 자동 치환 발송에서는 생략).
     * <ul>
     * <li><code>AT</code>: 텍스트형</li>
     * <li><code>AI</code>: 이미지형</li>
     * </ul>
     *
     * <p>허용 값 <code>AT</code>, <code>AI</code>
     *
     * <p><b>확인 필요:</b> 이미지형(AI) 발송 시 이미지를 지정하는 발송 필드가 문서에 없습니다. 템플릿에 등록된 이미지를 쓰는 것으로 추정됩니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
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
     * 알림톡 템플릿 코드입니다.
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
     * 템플릿 변수 자동 치환 발송 타입입니다. 템플릿 자동 치환 발송 시 필수이며 <code>template</code>을 입력합니다. 전문 발송에서는 생략합니다.
     *
     * <p>허용 값 <code>template</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendType")
    public String getSendType() {
        return sendType;
    }

    /**
     * 카카오 응답 방식입니다. 기본값은 <code>push</code>입니다.
     * <ul>
     * <li><code>push</code>(권장): 활성 사용자 조건에 해당하면 ACK 수신 여부를 확인하지 않고 성공 처리합니다. 조건을 만족하지 않으면 <code>NoSendAvailableException</code> 오류를 응답합니다.</li>
     * <li><code>polling</code>: <code>timeout</code> 안에 수신 결과가 도착하면 성공(<code>MS03</code>), 나머지는 성공불확실(<code>ME09</code>)로 처리합니다.</li>
     * </ul>
     *
     * <p>허용 값 <code>push</code>, <code>polling</code> · 서버 기본값 <code>push</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("responseMethod")
    public String getResponseMethod() {
        return responseMethod;
    }

    /**
     * polling 발송 시 수신 결과를 기다리는 시간(초)입니다. 10~86,400초이며 기본값은 180초입니다.
     *
     * <p>형식 <code>^[0-9]+$</code> · 서버 기본값 <code>180</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * 알림톡 본문입니다. 전문 발송(<code>sendType</code>이 <code>template</code>이 아님) 시 필수입니다. 최대 1,300자입니다.
     *
     * <p>최대 1300자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 알림톡 제목입니다(강조표기형 템플릿). 최대 50자입니다.
     *
     * <p>최대 50자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 메시지 상단에 표기할 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * {@code link}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("link")
    public AlimtalkLink getLink() {
        return link;
    }

    /**
     * {@code attachment}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public AlimtalkAttachment getAttachment() {
        return attachment;
    }

    /**
     * {@code supplement}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("supplement")
    public AlimtalkSupplement getSupplement() {
        return supplement;
    }

    /**
     * 메시지에 포함된 가격/금액/결제금액입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    /**
     * 가격/금액/결제금액의 통화 단위입니다. 알려진 값은 <code>KRW</code>, <code>USD</code>, <code>EUR</code>입니다.
     *
     * <p>알려진 값 <code>KRW</code>, <code>USD</code>, <code>EUR</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("currencyType")
    public String getCurrencyType() {
        return currencyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkMessage)) {
            return false;
        }
        AlimtalkMessage other = (AlimtalkMessage) o;
        return Objects.equals(msgType, other.msgType)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(sendType, other.sendType)
                && Objects.equals(responseMethod, other.responseMethod)
                && Objects.equals(timeout, other.timeout)
                && Objects.equals(text, other.text)
                && Objects.equals(title, other.title)
                && Objects.equals(header, other.header)
                && Objects.equals(link, other.link)
                && Objects.equals(attachment, other.attachment)
                && Objects.equals(supplement, other.supplement)
                && Objects.equals(price, other.price)
                && Objects.equals(currencyType, other.currencyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgType, senderKey, templateCode, sendType, responseMethod, timeout, text, title, header, link, attachment, supplement, price, currencyType);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkMessage{", "}");
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (sendType != null) {
            joiner.add("sendType=" + sendType);
        }
        if (responseMethod != null) {
            joiner.add("responseMethod=" + responseMethod);
        }
        if (timeout != null) {
            joiner.add("timeout=" + io.github.icommapi.bizgo.internal.Masking.length(timeout));
        }
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
        }
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (header != null) {
            joiner.add("header=" + io.github.icommapi.bizgo.internal.Masking.length(header));
        }
        if (link != null) {
            joiner.add("link=" + link);
        }
        if (attachment != null) {
            joiner.add("attachment=" + attachment);
        }
        if (supplement != null) {
            joiner.add("supplement=" + supplement);
        }
        if (price != null) {
            joiner.add("price=" + io.github.icommapi.bizgo.internal.Masking.length(price));
        }
        if (currencyType != null) {
            joiner.add("currencyType=" + io.github.icommapi.bizgo.internal.Masking.length(currencyType));
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkMessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String msgType;
        private String senderKey;
        private String templateCode;
        private String sendType;
        private String responseMethod;
        private String timeout;
        private String text;
        private String title;
        private String header;
        private AlimtalkLink link;
        private AlimtalkAttachment attachment;
        private AlimtalkSupplement supplement;
        private String price;
        private String currencyType;

        /** Creates an empty builder; same as {@link AlimtalkMessage#builder()}. */
        public Builder() {
        }

        /**
         * 카카오 비즈메시지 타입입니다. 전문 발송(<code>sendType</code>이 <code>template</code>이 아님) 시 필수이며, 빠지면 서버가 A523으로 거절합니다(템플릿 자동 치환 발송에서는 생략).
         * <ul>
         * <li><code>AT</code>: 텍스트형</li>
         * <li><code>AI</code>: 이미지형</li>
         * </ul>
         *
         * <p>허용 값 <code>AT</code>, <code>AI</code>
         *
         * <p><b>확인 필요:</b> 이미지형(AI) 발송 시 이미지를 지정하는 발송 필드가 문서에 없습니다. 템플릿에 등록된 이미지를 쓰는 것으로 추정됩니다.
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
         * 알림톡 템플릿 코드입니다.
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
         * 템플릿 변수 자동 치환 발송 타입입니다. 템플릿 자동 치환 발송 시 필수이며 <code>template</code>을 입력합니다. 전문 발송에서는 생략합니다.
         *
         * <p>허용 값 <code>template</code>
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
         * 카카오 응답 방식입니다. 기본값은 <code>push</code>입니다.
         * <ul>
         * <li><code>push</code>(권장): 활성 사용자 조건에 해당하면 ACK 수신 여부를 확인하지 않고 성공 처리합니다. 조건을 만족하지 않으면 <code>NoSendAvailableException</code> 오류를 응답합니다.</li>
         * <li><code>polling</code>: <code>timeout</code> 안에 수신 결과가 도착하면 성공(<code>MS03</code>), 나머지는 성공불확실(<code>ME09</code>)로 처리합니다.</li>
         * </ul>
         *
         * <p>허용 값 <code>push</code>, <code>polling</code> · 서버 기본값 <code>push</code>(설정하지 않으면 보내지 않음)
         *
         * @param responseMethod the value (null clears it)
         * @return this builder
         */
        @JsonProperty("responseMethod")
        public Builder responseMethod(String responseMethod) {
            this.responseMethod = responseMethod;
            return this;
        }

        /**
         * polling 발송 시 수신 결과를 기다리는 시간(초)입니다. 10~86,400초이며 기본값은 180초입니다.
         *
         * <p>형식 <code>^[0-9]+$</code> · 서버 기본값 <code>180</code>(설정하지 않으면 보내지 않음)
         *
         * @param timeout the value (null clears it)
         * @return this builder
         */
        @JsonProperty("timeout")
        public Builder timeout(String timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * 알림톡 본문입니다. 전문 발송(<code>sendType</code>이 <code>template</code>이 아님) 시 필수입니다. 최대 1,300자입니다.
         *
         * <p>최대 1300자
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
         * 알림톡 제목입니다(강조표기형 템플릿). 최대 50자입니다.
         *
         * <p>최대 50자
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        @JsonProperty("title")
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 메시지 상단에 표기할 제목입니다.
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
         * {@code link}.
         *
         * @param link the value (null clears it)
         * @return this builder
         */
        @JsonProperty("link")
        public Builder link(AlimtalkLink link) {
            this.link = link;
            return this;
        }

        /**
         * {@code attachment}.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        @JsonProperty("attachment")
        public Builder attachment(AlimtalkAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * {@code supplement}.
         *
         * @param supplement the value (null clears it)
         * @return this builder
         */
        @JsonProperty("supplement")
        public Builder supplement(AlimtalkSupplement supplement) {
            this.supplement = supplement;
            return this;
        }

        /**
         * 메시지에 포함된 가격/금액/결제금액입니다.
         *
         * @param price the value (null clears it)
         * @return this builder
         */
        @JsonProperty("price")
        public Builder price(String price) {
            this.price = price;
            return this;
        }

        /**
         * 가격/금액/결제금액의 통화 단위입니다. 알려진 값은 <code>KRW</code>, <code>USD</code>, <code>EUR</code>입니다.
         *
         * <p>알려진 값 <code>KRW</code>, <code>USD</code>, <code>EUR</code>
         *
         * @param currencyType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("currencyType")
        public Builder currencyType(String currencyType) {
            this.currencyType = currencyType;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkMessage build() {
            AlimtalkMessage built = new AlimtalkMessage(this);
            ModelValidator v = new ModelValidator("AlimtalkMessage");
            v.oneOf("msgType", built.msgType, MSG_TYPE_VALUES);
            v.required("senderKey", built.senderKey);
            v.required("templateCode", built.templateCode);
            v.oneOf("sendType", built.sendType, SEND_TYPE_VALUES);
            v.oneOf("responseMethod", built.responseMethod, RESPONSE_METHOD_VALUES);
            v.pattern("timeout", built.timeout, TIMEOUT_PATTERN);
            v.maxLength("text", built.text, 1300);
            v.maxLength("title", built.title, 50);
            RequiredIf.checkObject(v, "AlimtalkMessage", built); // x-sdk-required-if
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkMessage buildUnvalidated() {
            return new AlimtalkMessage(this);
        }
    }
}
