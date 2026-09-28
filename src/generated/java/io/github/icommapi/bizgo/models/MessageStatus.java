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
 * 메시지 1건의 접수·발송·리포트 상태입니다. 대체발송이 일어나면 같은 msgKey로 채널별 항목이 여러 개 있습니다.
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
@JsonPropertyOrder({"msgKey", "serviceType", "msgType", "to", "fallback", "responseCode", "responseText", "requestTime", "sendTime", "reportTime", "reportType", "reportCode", "reportText", "userType", "carrier", "ref"})
public final class MessageStatus {

    private final String msgKey;
    private final String serviceType;
    private final String msgType;
    private final String to;
    private final String fallback;
    private final String responseCode;
    private final String responseText;
    private final String requestTime;
    private final String sendTime;
    private final String reportTime;
    private final String reportType;
    private final String reportCode;
    private final String reportText;
    private final String userType;
    private final String carrier;
    private final String ref;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private MessageStatus(
            @JsonProperty("msgKey") String msgKey,
            @JsonProperty("serviceType") String serviceType,
            @JsonProperty("msgType") String msgType,
            @JsonProperty("to") String to,
            @JsonProperty("fallback") String fallback,
            @JsonProperty("responseCode") String responseCode,
            @JsonProperty("responseText") String responseText,
            @JsonProperty("requestTime") String requestTime,
            @JsonProperty("sendTime") String sendTime,
            @JsonProperty("reportTime") String reportTime,
            @JsonProperty("reportType") String reportType,
            @JsonProperty("reportCode") String reportCode,
            @JsonProperty("reportText") String reportText,
            @JsonProperty("userType") String userType,
            @JsonProperty("carrier") String carrier,
            @JsonProperty("ref") String ref) {
        this.msgKey = msgKey;
        this.serviceType = serviceType;
        this.msgType = msgType;
        this.to = to;
        this.fallback = fallback;
        this.responseCode = responseCode;
        this.responseText = responseText;
        this.requestTime = requestTime;
        this.sendTime = sendTime;
        this.reportTime = reportTime;
        this.reportType = reportType;
        this.reportCode = reportCode;
        this.reportText = reportText;
        this.userType = userType;
        this.carrier = carrier;
        this.ref = ref;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private MessageStatus(Builder builder) {
        this(builder.msgKey, builder.serviceType, builder.msgType, builder.to, builder.fallback, builder.responseCode, builder.responseText, builder.requestTime, builder.sendTime, builder.reportTime, builder.reportType, builder.reportCode, builder.reportText, builder.userType, builder.carrier, builder.ref);
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
        builder.fallback = this.fallback;
        builder.responseCode = this.responseCode;
        builder.responseText = this.responseText;
        builder.requestTime = this.requestTime;
        builder.sendTime = this.sendTime;
        builder.reportTime = this.reportTime;
        builder.reportType = this.reportType;
        builder.reportCode = this.reportCode;
        builder.reportText = this.reportText;
        builder.userType = this.userType;
        builder.carrier = this.carrier;
        builder.ref = this.ref;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 메시지 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgKey")
    public String getMsgKey() {
        return msgKey;
    }

    /**
     * 서비스 타입입니다.
     *
     * <p>알려진 값 <code>SMS</code>, <code>MMS</code>, <code>RCS</code>, <code>ALIMTALK</code>, <code>BRANDMESSAGE</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 메시지 타입입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 수신번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    /**
     * 대체발송 여부입니다.
     *
     * <p>허용 값 <code>Y</code>, <code>N</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fallback")
    public String getFallback() {
        return fallback;
    }

    /**
     * 접수 결과 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("responseCode")
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * 접수 결과 메시지입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("responseText")
    public String getResponseText() {
        return responseText;
    }

    /**
     * 요청 시각(ISO 8601)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("requestTime")
    public String getRequestTime() {
        return requestTime;
    }

    /**
     * 발송 시각(ISO 8601)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendTime")
    public String getSendTime() {
        return sendTime;
    }

    /**
     * 리포트 시각(ISO 8601)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportTime")
    public String getReportTime() {
        return reportTime;
    }

    /**
     * 리포트 타입입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportType")
    public String getReportType() {
        return reportType;
    }

    /**
     * 리포트 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportCode")
    public String getReportCode() {
        return reportCode;
    }

    /**
     * 리포트 결과 메시지입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportText")
    public String getReportText() {
        return reportText;
    }

    /**
     * 채널 친구 여부입니다(브랜드메시지 전용).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("userType")
    public String getUserType() {
        return userType;
    }

    /**
     * 이통사 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("carrier")
    public String getCarrier() {
        return carrier;
    }

    /**
     * 요청 시 전달한 참조 필드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
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
        if (!(o instanceof MessageStatus)) {
            return false;
        }
        MessageStatus other = (MessageStatus) o;
        return Objects.equals(msgKey, other.msgKey)
                && Objects.equals(serviceType, other.serviceType)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(to, other.to)
                && Objects.equals(fallback, other.fallback)
                && Objects.equals(responseCode, other.responseCode)
                && Objects.equals(responseText, other.responseText)
                && Objects.equals(requestTime, other.requestTime)
                && Objects.equals(sendTime, other.sendTime)
                && Objects.equals(reportTime, other.reportTime)
                && Objects.equals(reportType, other.reportType)
                && Objects.equals(reportCode, other.reportCode)
                && Objects.equals(reportText, other.reportText)
                && Objects.equals(userType, other.userType)
                && Objects.equals(carrier, other.carrier)
                && Objects.equals(ref, other.ref)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgKey, serviceType, msgType, to, fallback, responseCode, responseText, requestTime, sendTime, reportTime, reportType, reportCode, reportText, userType, carrier, ref, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "MessageStatus{", "}");
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
        if (fallback != null) {
            joiner.add("fallback=" + fallback);
        }
        if (responseCode != null) {
            joiner.add("responseCode=" + responseCode);
        }
        if (responseText != null) {
            joiner.add("responseText=" + responseText);
        }
        if (requestTime != null) {
            joiner.add("requestTime=" + requestTime);
        }
        if (sendTime != null) {
            joiner.add("sendTime=" + sendTime);
        }
        if (reportTime != null) {
            joiner.add("reportTime=" + reportTime);
        }
        if (reportType != null) {
            joiner.add("reportType=" + reportType);
        }
        if (reportCode != null) {
            joiner.add("reportCode=" + reportCode);
        }
        if (reportText != null) {
            joiner.add("reportText=" + reportText);
        }
        if (userType != null) {
            joiner.add("userType=" + userType);
        }
        if (carrier != null) {
            joiner.add("carrier=" + carrier);
        }
        if (ref != null) {
            joiner.add("ref=" + io.github.icommapi.bizgo.internal.Masking.length(ref));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link MessageStatus}. */
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
        private String fallback;
        private String responseCode;
        private String responseText;
        private String requestTime;
        private String sendTime;
        private String reportTime;
        private String reportType;
        private String reportCode;
        private String reportText;
        private String userType;
        private String carrier;
        private String ref;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link MessageStatus#builder()}. */
        public Builder() {
        }

        /**
         * 메시지 키입니다.
         *
         * @param msgKey the value (null clears it)
         * @return this builder
         */
        public Builder msgKey(String msgKey) {
            this.msgKey = msgKey;
            return this;
        }

        /**
         * 서비스 타입입니다.
         *
         * <p>알려진 값 <code>SMS</code>, <code>MMS</code>, <code>RCS</code>, <code>ALIMTALK</code>, <code>BRANDMESSAGE</code>
         *
         * @param serviceType the value (null clears it)
         * @return this builder
         */
        public Builder serviceType(String serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        /**
         * 메시지 타입입니다.
         *
         * @param msgType the value (null clears it)
         * @return this builder
         */
        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        /**
         * 수신번호입니다.
         *
         * @param to the value (null clears it)
         * @return this builder
         */
        public Builder to(String to) {
            this.to = to;
            return this;
        }

        /**
         * 대체발송 여부입니다.
         *
         * <p>허용 값 <code>Y</code>, <code>N</code>
         *
         * @param fallback the value (null clears it)
         * @return this builder
         */
        public Builder fallback(String fallback) {
            this.fallback = fallback;
            return this;
        }

        /**
         * 접수 결과 코드입니다.
         *
         * @param responseCode the value (null clears it)
         * @return this builder
         */
        public Builder responseCode(String responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        /**
         * 접수 결과 메시지입니다.
         *
         * @param responseText the value (null clears it)
         * @return this builder
         */
        public Builder responseText(String responseText) {
            this.responseText = responseText;
            return this;
        }

        /**
         * 요청 시각(ISO 8601)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
         *
         * @param requestTime the value (null clears it)
         * @return this builder
         */
        public Builder requestTime(String requestTime) {
            this.requestTime = requestTime;
            return this;
        }

        /**
         * 발송 시각(ISO 8601)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
         *
         * @param sendTime the value (null clears it)
         * @return this builder
         */
        public Builder sendTime(String sendTime) {
            this.sendTime = sendTime;
            return this;
        }

        /**
         * 리포트 시각(ISO 8601)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code>
         *
         * @param reportTime the value (null clears it)
         * @return this builder
         */
        public Builder reportTime(String reportTime) {
            this.reportTime = reportTime;
            return this;
        }

        /**
         * 리포트 타입입니다.
         *
         * @param reportType the value (null clears it)
         * @return this builder
         */
        public Builder reportType(String reportType) {
            this.reportType = reportType;
            return this;
        }

        /**
         * 리포트 코드입니다.
         *
         * @param reportCode the value (null clears it)
         * @return this builder
         */
        public Builder reportCode(String reportCode) {
            this.reportCode = reportCode;
            return this;
        }

        /**
         * 리포트 결과 메시지입니다.
         *
         * @param reportText the value (null clears it)
         * @return this builder
         */
        public Builder reportText(String reportText) {
            this.reportText = reportText;
            return this;
        }

        /**
         * 채널 친구 여부입니다(브랜드메시지 전용).
         *
         * @param userType the value (null clears it)
         * @return this builder
         */
        public Builder userType(String userType) {
            this.userType = userType;
            return this;
        }

        /**
         * 이통사 코드입니다.
         *
         * @param carrier the value (null clears it)
         * @return this builder
         */
        public Builder carrier(String carrier) {
            this.carrier = carrier;
            return this;
        }

        /**
         * 요청 시 전달한 참조 필드입니다.
         *
         * @param ref the value (null clears it)
         * @return this builder
         */
        public Builder ref(String ref) {
            this.ref = ref;
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
         * @return a new immutable {@code MessageStatus}
         */
        public MessageStatus build() {
            return new MessageStatus(this);
        }
    }
}
