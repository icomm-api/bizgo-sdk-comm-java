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
import java.util.regex.Pattern;

/**
 * SMS(단문) 메시지입니다. 제목 필드는 없습니다.
 *
 * <p>Sent as {@code messageFlow[].sms}.
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
@JsonDeserialize(builder = SmsMessage.Builder.class)
@JsonPropertyOrder({"from", "text", "ttl", "originCID"})
public final class SmsMessage implements ChannelMessage {

    /** {@code messageFlow} channel key of this message. */
    public static final String CHANNEL_KEY = "sms";
    private static final Pattern TTL_PATTERN = Pattern.compile("^[0-9]+$");

    private final String from;
    private final String text;
    private final String ttl;
    private final String originCID;

    private SmsMessage(Builder builder) {
        this.from = builder.from;
        this.text = builder.text;
        this.ttl = builder.ttl;
        this.originCID = builder.originCID;
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
        builder.originCID = this.originCID;
        return builder;
    }

    @Override
    public String channelKey() {
        return CHANNEL_KEY;
    }

    /**
     * 발신번호입니다. 비즈고에 미리 등록한 번호여야 합니다.
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
     * SMS 본문입니다. 최대 90byte이며, 이통사 규격상 EUC-KR 범위 밖 문자는 접수 오류가 날 수 있습니다.
     *
     * <p>필수 · 최대 90byte(EUC-KR)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 이통사 전달까지 유효한 최대 시간(초)입니다. 시간이 지나면 실패 처리됩니다.
     *
     * <p>형식 <code>^[0-9]+$</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ttl")
    public String getTtl() {
        return ttl;
    }

    /**
     * 최초 발신사업자 식별코드(9자리)입니다. 일반 고객은 입력하지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("originCID")
    public String getOriginCID() {
        return originCID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SmsMessage)) {
            return false;
        }
        SmsMessage other = (SmsMessage) o;
        return Objects.equals(from, other.from)
                && Objects.equals(text, other.text)
                && Objects.equals(ttl, other.ttl)
                && Objects.equals(originCID, other.originCID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, text, ttl, originCID);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "SmsMessage{", "}");
        if (from != null) {
            joiner.add("from=" + io.github.icommapi.bizgo.internal.Masking.phone(from));
        }
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
        }
        if (ttl != null) {
            joiner.add("ttl=" + io.github.icommapi.bizgo.internal.Masking.length(ttl));
        }
        if (originCID != null) {
            joiner.add("originCID=" + io.github.icommapi.bizgo.internal.Masking.length(originCID));
        }
        return joiner.toString();
    }

    /** Builder for {@link SmsMessage}. */
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
        private String originCID;

        /** Creates an empty builder; same as {@link SmsMessage#builder()}. */
        public Builder() {
        }

        /**
         * 발신번호입니다. 비즈고에 미리 등록한 번호여야 합니다.
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
         * SMS 본문입니다. 최대 90byte이며, 이통사 규격상 EUC-KR 범위 밖 문자는 접수 오류가 날 수 있습니다.
         *
         * <p>필수 · 최대 90byte(EUC-KR)
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
         * 이통사 전달까지 유효한 최대 시간(초)입니다. 시간이 지나면 실패 처리됩니다.
         *
         * <p>형식 <code>^[0-9]+$</code>
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
         * 최초 발신사업자 식별코드(9자리)입니다. 일반 고객은 입력하지 않습니다.
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
         * Builds the object.
         *
         * @return a new immutable {@code SmsMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public SmsMessage build() {
            SmsMessage built = new SmsMessage(this);
            ModelValidator v = new ModelValidator("SmsMessage");
            v.required("from", built.from);
            v.required("text", built.text);
            v.maxBytes("text", built.text, 90, "EUC-KR");
            v.pattern("ttl", built.ttl, TTL_PATTERN);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        SmsMessage buildUnvalidated() {
            return new SmsMessage(this);
        }
    }
}
