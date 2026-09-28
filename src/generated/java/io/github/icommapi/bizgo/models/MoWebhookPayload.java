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
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * MO(인증/투표) 수신 웹훅 본문입니다.
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
@JsonPropertyOrder({"msgKey", "serviceType", "msgType", "to", "from", "carrier", "originator", "content", "occurredTime"})
public final class MoWebhookPayload {

    private final String msgKey;
    private final String serviceType;
    private final String msgType;
    private final String to;
    private final String from;
    private final String carrier;
    private final String originator;
    private final String content;
    private final String occurredTime;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private MoWebhookPayload(
            @JsonProperty("msgKey") String msgKey,
            @JsonProperty("serviceType") String serviceType,
            @JsonProperty("msgType") String msgType,
            @JsonProperty("to") String to,
            @JsonProperty("from") String from,
            @JsonProperty("carrier") String carrier,
            @JsonProperty("originator") String originator,
            @JsonProperty("content") String content,
            @JsonProperty("occurredTime") String occurredTime) {
        this.msgKey = msgKey;
        this.serviceType = serviceType;
        this.msgType = msgType;
        this.to = to;
        this.from = from;
        this.carrier = carrier;
        this.originator = originator;
        this.content = content;
        this.occurredTime = occurredTime;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private MoWebhookPayload(Builder builder) {
        this(builder.msgKey, builder.serviceType, builder.msgType, builder.to, builder.from, builder.carrier, builder.originator, builder.content, builder.occurredTime);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.msgKey = this.msgKey;
        builder.serviceType = this.serviceType;
        builder.msgType = this.msgType;
        builder.to = this.to;
        builder.from = this.from;
        builder.carrier = this.carrier;
        builder.originator = this.originator;
        builder.content = this.content;
        builder.occurredTime = this.occurredTime;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 메시지 키입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgKey")
    public String getMsgKey() {
        return msgKey;
    }

    /**
     * 서비스 타입입니다. MO로 고정입니다.
     *
     * <p>필수 · 허용 값 <code>MO</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 메시지 타입입니다. SM으로 고정입니다.
     *
     * <p>필수 · 허용 값 <code>SM</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 수신번호(MO 번호)입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    /**
     * MO 발신자가 입력한 번호입니다(기본은 단말기 번호).
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
     * 이통사 코드입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("carrier")
    public String getCarrier() {
        return carrier;
    }

    /**
     * MO 발신 단말기 번호입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("originator")
    public String getOriginator() {
        return originator;
    }

    /**
     * MO 메시지 본문입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * MO 발생 시각(ISO 8601)입니다.
     *
     * <p>필수 · 형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("occurredTime")
    public String getOccurredTime() {
        return occurredTime;
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
        if (!(o instanceof MoWebhookPayload)) {
            return false;
        }
        MoWebhookPayload other = (MoWebhookPayload) o;
        return Objects.equals(msgKey, other.msgKey)
                && Objects.equals(serviceType, other.serviceType)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(to, other.to)
                && Objects.equals(from, other.from)
                && Objects.equals(carrier, other.carrier)
                && Objects.equals(originator, other.originator)
                && Objects.equals(content, other.content)
                && Objects.equals(occurredTime, other.occurredTime)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgKey, serviceType, msgType, to, from, carrier, originator, content, occurredTime, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "MoWebhookPayload{", "}");
        if (msgKey != null) {
            joiner.add("msgKey=" + msgKey);
        }
        if (serviceType != null) {
            joiner.add("serviceType=" + serviceType);
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (to != null) {
            joiner.add("to=" + io.github.icommapi.bizgo.internal.Masking.phone(to));
        }
        if (from != null) {
            joiner.add("from=" + io.github.icommapi.bizgo.internal.Masking.phone(from));
        }
        if (carrier != null) {
            joiner.add("carrier=" + carrier);
        }
        if (originator != null) {
            joiner.add("originator=" + io.github.icommapi.bizgo.internal.Masking.phone(originator));
        }
        if (content != null) {
            joiner.add("content=" + io.github.icommapi.bizgo.internal.Masking.length(content));
        }
        if (occurredTime != null) {
            joiner.add("occurredTime=" + occurredTime);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link MoWebhookPayload}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String msgKey;
        private String serviceType;
        private String msgType;
        private String to;
        private String from;
        private String carrier;
        private String originator;
        private String content;
        private String occurredTime;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link MoWebhookPayload#builder()}. */
        public Builder() {
        }

        /**
         * 메시지 키입니다.
         *
         * <p>필수
         *
         * @param msgKey the value (null clears it)
         * @return this builder
         */
        public Builder msgKey(String msgKey) {
            this.msgKey = msgKey;
            return this;
        }

        /**
         * 서비스 타입입니다. MO로 고정입니다.
         *
         * <p>필수 · 허용 값 <code>MO</code>
         *
         * @param serviceType the value (null clears it)
         * @return this builder
         */
        public Builder serviceType(String serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        /**
         * 메시지 타입입니다. SM으로 고정입니다.
         *
         * <p>필수 · 허용 값 <code>SM</code>
         *
         * @param msgType the value (null clears it)
         * @return this builder
         */
        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        /**
         * 수신번호(MO 번호)입니다.
         *
         * <p>필수
         *
         * @param to the value (null clears it)
         * @return this builder
         */
        public Builder to(String to) {
            this.to = to;
            return this;
        }

        /**
         * MO 발신자가 입력한 번호입니다(기본은 단말기 번호).
         *
         * <p>필수
         *
         * @param from the value (null clears it)
         * @return this builder
         */
        public Builder from(String from) {
            this.from = from;
            return this;
        }

        /**
         * 이통사 코드입니다.
         *
         * <p>필수
         *
         * @param carrier the value (null clears it)
         * @return this builder
         */
        public Builder carrier(String carrier) {
            this.carrier = carrier;
            return this;
        }

        /**
         * MO 발신 단말기 번호입니다.
         *
         * <p>필수
         *
         * @param originator the value (null clears it)
         * @return this builder
         */
        public Builder originator(String originator) {
            this.originator = originator;
            return this;
        }

        /**
         * MO 메시지 본문입니다.
         *
         * <p>필수
         *
         * @param content the value (null clears it)
         * @return this builder
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }

        /**
         * MO 발생 시각(ISO 8601)입니다.
         *
         * <p>필수 · 형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
         *
         * @param occurredTime the value (null clears it)
         * @return this builder
         */
        public Builder occurredTime(String occurredTime) {
            this.occurredTime = occurredTime;
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
         * @return a new immutable {@code MoWebhookPayload}
         */
        public MoWebhookPayload build() {
            return new MoWebhookPayload(this);
        }
    }
}
