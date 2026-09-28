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
 * 리포트 웹훅 본문입니다. 리포트 1건당 1회 전송됩니다.
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
@JsonPropertyOrder({"msgKey", "serviceType", "msgType", "sendTime", "reportTime", "reportType", "reportCode", "reportText", "carrier", "userType", "resCnt", "ref"})
public final class ReportWebhookPayload {

    private final String msgKey;
    private final String serviceType;
    private final String msgType;
    private final String sendTime;
    private final String reportTime;
    private final String reportType;
    private final String reportCode;
    private final String reportText;
    private final String carrier;
    private final String userType;
    private final String resCnt;
    private final String ref;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private ReportWebhookPayload(
            @JsonProperty("msgKey") String msgKey,
            @JsonProperty("serviceType") String serviceType,
            @JsonProperty("msgType") String msgType,
            @JsonProperty("sendTime") String sendTime,
            @JsonProperty("reportTime") String reportTime,
            @JsonProperty("reportType") String reportType,
            @JsonProperty("reportCode") String reportCode,
            @JsonProperty("reportText") String reportText,
            @JsonProperty("carrier") String carrier,
            @JsonProperty("userType") String userType,
            @JsonProperty("resCnt") String resCnt,
            @JsonProperty("ref") String ref) {
        this.msgKey = msgKey;
        this.serviceType = serviceType;
        this.msgType = msgType;
        this.sendTime = sendTime;
        this.reportTime = reportTime;
        this.reportType = reportType;
        this.reportCode = reportCode;
        this.reportText = reportText;
        this.carrier = carrier;
        this.userType = userType;
        this.resCnt = resCnt;
        this.ref = ref;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private ReportWebhookPayload(Builder builder) {
        this(builder.msgKey, builder.serviceType, builder.msgType, builder.sendTime, builder.reportTime, builder.reportType, builder.reportCode, builder.reportText, builder.carrier, builder.userType, builder.resCnt, builder.ref);
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
        builder.sendTime = this.sendTime;
        builder.reportTime = this.reportTime;
        builder.reportType = this.reportType;
        builder.reportCode = this.reportCode;
        builder.reportText = this.reportText;
        builder.carrier = this.carrier;
        builder.userType = this.userType;
        builder.resCnt = this.resCnt;
        builder.ref = this.ref;
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
     * 서비스 타입입니다.
     *
     * <p>필수
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
     * 전송 처리 일시입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendTime")
    public String getSendTime() {
        return sendTime;
    }

    /**
     * 리포트 수신 일시입니다.
     *
     * <p>필수 · 형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportTime")
    public String getReportTime() {
        return reportTime;
    }

    /**
     * 리포트 종류입니다.
     *
     * <p>필수
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
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportCode")
    public String getReportCode() {
        return reportCode;
    }

    /**
     * 리포트 상세 내용입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportText")
    public String getReportText() {
        return reportText;
    }

    /**
     * (문자메시지) 이통사 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("carrier")
    public String getCarrier() {
        return carrier;
    }

    /**
     * (카카오 브랜드메시지) 메시지 발송 처리 타입입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("userType")
    public String getUserType() {
        return userType;
    }

    /**
     * (국제메시지) 메시지 분할 수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resCnt")
    public String getResCnt() {
        return resCnt;
    }

    /**
     * 요청 시 입력한 참조 필드입니다.
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
        if (!(o instanceof ReportWebhookPayload)) {
            return false;
        }
        ReportWebhookPayload other = (ReportWebhookPayload) o;
        return Objects.equals(msgKey, other.msgKey)
                && Objects.equals(serviceType, other.serviceType)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(sendTime, other.sendTime)
                && Objects.equals(reportTime, other.reportTime)
                && Objects.equals(reportType, other.reportType)
                && Objects.equals(reportCode, other.reportCode)
                && Objects.equals(reportText, other.reportText)
                && Objects.equals(carrier, other.carrier)
                && Objects.equals(userType, other.userType)
                && Objects.equals(resCnt, other.resCnt)
                && Objects.equals(ref, other.ref)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgKey, serviceType, msgType, sendTime, reportTime, reportType, reportCode, reportText, carrier, userType, resCnt, ref, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ReportWebhookPayload{", "}");
        if (msgKey != null) {
            joiner.add("msgKey=" + msgKey);
        }
        if (serviceType != null) {
            joiner.add("serviceType=" + serviceType);
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
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
        if (carrier != null) {
            joiner.add("carrier=" + carrier);
        }
        if (userType != null) {
            joiner.add("userType=" + userType);
        }
        if (resCnt != null) {
            joiner.add("resCnt=" + resCnt);
        }
        if (ref != null) {
            joiner.add("ref=" + io.github.icommapi.bizgo.internal.Masking.length(ref));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link ReportWebhookPayload}. */
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
        private String sendTime;
        private String reportTime;
        private String reportType;
        private String reportCode;
        private String reportText;
        private String carrier;
        private String userType;
        private String resCnt;
        private String ref;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link ReportWebhookPayload#builder()}. */
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
         * 서비스 타입입니다.
         *
         * <p>필수
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
         * 전송 처리 일시입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
         *
         * @param sendTime the value (null clears it)
         * @return this builder
         */
        public Builder sendTime(String sendTime) {
            this.sendTime = sendTime;
            return this;
        }

        /**
         * 리포트 수신 일시입니다.
         *
         * <p>필수 · 형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
         *
         * @param reportTime the value (null clears it)
         * @return this builder
         */
        public Builder reportTime(String reportTime) {
            this.reportTime = reportTime;
            return this;
        }

        /**
         * 리포트 종류입니다.
         *
         * <p>필수
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
         * <p>필수
         *
         * @param reportCode the value (null clears it)
         * @return this builder
         */
        public Builder reportCode(String reportCode) {
            this.reportCode = reportCode;
            return this;
        }

        /**
         * 리포트 상세 내용입니다.
         *
         * @param reportText the value (null clears it)
         * @return this builder
         */
        public Builder reportText(String reportText) {
            this.reportText = reportText;
            return this;
        }

        /**
         * (문자메시지) 이통사 코드입니다.
         *
         * @param carrier the value (null clears it)
         * @return this builder
         */
        public Builder carrier(String carrier) {
            this.carrier = carrier;
            return this;
        }

        /**
         * (카카오 브랜드메시지) 메시지 발송 처리 타입입니다.
         *
         * @param userType the value (null clears it)
         * @return this builder
         */
        public Builder userType(String userType) {
            this.userType = userType;
            return this;
        }

        /**
         * (국제메시지) 메시지 분할 수입니다.
         *
         * @param resCnt the value (null clears it)
         * @return this builder
         */
        public Builder resCnt(String resCnt) {
            this.resCnt = resCnt;
            return this;
        }

        /**
         * 요청 시 입력한 참조 필드입니다.
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
         * @return a new immutable {@code ReportWebhookPayload}
         */
        public ReportWebhookPayload build() {
            return new ReportWebhookPayload(this);
        }
    }
}
