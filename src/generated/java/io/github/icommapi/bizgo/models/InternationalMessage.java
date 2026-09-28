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
 * 국제메시지(해외 수신자 대상 문자)입니다. <code>messageFlow[].international</code> 객체로 보냅니다. 본문은 UTF-8을 지원하며, 실제 단말 전달 여부와 무관하게 접수 기준으로 과금됩니다.
 * <p>수신번호 규칙(<code>destinations[].to</code>): 국가번호를 포함한 E.164 형식에서 <code>+</code>를 뺀 숫자로 입력합니다 (예: <code>821000000000</code>, 길이 8~15자리). 국가번호 목록이나 국가별 길이·세그먼트(분할) 규칙은 원문에 없습니다.
 * <p>국제문자에서는 <code>title</code>, <code>fileKey</code>를 쓸 수 없습니다(접수코드 A321).
 *
 * <p>Sent as {@code messageFlow[].international}.
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
@JsonDeserialize(builder = InternationalMessage.Builder.class)
@JsonPropertyOrder({"from", "text", "ttl", "clientSubId"})
public final class InternationalMessage implements ChannelMessage {

    /** {@code messageFlow} channel key of this message. */
    public static final String CHANNEL_KEY = "international";

    private final String from;
    private final String text;
    private final String ttl;
    private final String clientSubId;

    private InternationalMessage(Builder builder) {
        this.from = builder.from;
        this.text = builder.text;
        this.ttl = builder.ttl;
        this.clientSubId = builder.clientSubId;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.from = this.from;
        builder.text = this.text;
        builder.ttl = this.ttl;
        builder.clientSubId = this.clientSubId;
        return builder;
    }

    @Override
    public String channelKey() {
        return CHANNEL_KEY;
    }

    /**
     * 발신번호입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * 국제메시지 본문입니다. 최대 1,000자이며 UTF-8로 인코딩됩니다(글자 수 기준, 바이트 제한 아님).
     *
     * <p>필수 · 최대 1000자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 메시지 유효 시간(초)입니다. 생략하면 86400(24시간)입니다.
     *
     * <p>서버 기본값 <code>86400</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ttl")
    public String getTtl() {
        return ttl;
    }

    /**
     * Sender ID, 메시지 서명을 복수로 지정하기 위한 구분자입니다. 최대 20자입니다.
     *
     * <p>최대 20자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("clientSubId")
    public String getClientSubId() {
        return clientSubId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InternationalMessage)) {
            return false;
        }
        InternationalMessage other = (InternationalMessage) o;
        return Objects.equals(from, other.from)
                && Objects.equals(text, other.text)
                && Objects.equals(ttl, other.ttl)
                && Objects.equals(clientSubId, other.clientSubId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, text, ttl, clientSubId);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "InternationalMessage{", "}");
        if (from != null) {
            joiner.add("from=" + io.github.icommapi.bizgo.internal.Masking.phone(from));
        }
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
        }
        if (ttl != null) {
            joiner.add("ttl=" + io.github.icommapi.bizgo.internal.Masking.length(ttl));
        }
        if (clientSubId != null) {
            joiner.add("clientSubId=" + io.github.icommapi.bizgo.internal.Masking.length(clientSubId));
        }
        return joiner.toString();
    }

    /** Builder for {@link InternationalMessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String from;
        private String text;
        private String ttl;
        private String clientSubId;

        /** Creates an empty builder; same as {@link InternationalMessage#builder()}. */
        public Builder() {
        }

        /**
         * 발신번호입니다.
         *
         * <p>필수
         *
         * @param from the value (null clears it)
         * @return this builder
         */
        @JsonProperty("from")
        public Builder from(String from) {
            this.from = from;
            return this;
        }

        /**
         * 국제메시지 본문입니다. 최대 1,000자이며 UTF-8로 인코딩됩니다(글자 수 기준, 바이트 제한 아님).
         *
         * <p>필수 · 최대 1000자
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
         * 메시지 유효 시간(초)입니다. 생략하면 86400(24시간)입니다.
         *
         * <p>서버 기본값 <code>86400</code>(설정하지 않으면 보내지 않음)
         *
         * @param ttl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("ttl")
        public Builder ttl(String ttl) {
            this.ttl = ttl;
            return this;
        }

        /**
         * Sender ID, 메시지 서명을 복수로 지정하기 위한 구분자입니다. 최대 20자입니다.
         *
         * <p>최대 20자
         *
         * @param clientSubId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("clientSubId")
        public Builder clientSubId(String clientSubId) {
            this.clientSubId = clientSubId;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code InternationalMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public InternationalMessage build() {
            InternationalMessage built = new InternationalMessage(this);
            ModelValidator v = new ModelValidator("InternationalMessage");
            v.required("from", built.from);
            v.required("text", built.text);
            v.maxLength("text", built.text, 1000);
            v.maxLength("clientSubId", built.clientSubId, 20);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        InternationalMessage buildUnvalidated() {
            return new InternationalMessage(this);
        }
    }
}
