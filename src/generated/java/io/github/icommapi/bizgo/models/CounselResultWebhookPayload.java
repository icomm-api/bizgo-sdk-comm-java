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
 * 발송 결과 수신 웹훅(<code>&#123;고객 Webhook URL&#125;/cstalk/result</code>) 본문입니다. Plain/Rich 발송과 상담 종료 요청의 처리 결과가 전달되며, <code>msgKey</code>·<code>ref</code>로 발송 건과 대조합니다.
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
@JsonPropertyOrder({"msgKey", "userKey", "senderKey", "serviceType", "msgType", "requestType", "sendTime", "reportTime", "kakaoTime", "reportCode", "reportText", "kakaoResCreatedAt", "ref"})
public final class CounselResultWebhookPayload {

    private final String msgKey;
    private final String userKey;
    private final String senderKey;
    private final String serviceType;
    private final String msgType;
    private final String requestType;
    private final String sendTime;
    private final String reportTime;
    private final String kakaoTime;
    private final String reportCode;
    private final String reportText;
    private final String kakaoResCreatedAt;
    private final String ref;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselResultWebhookPayload(
            @JsonProperty("msgKey") String msgKey,
            @JsonProperty("userKey") String userKey,
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("serviceType") String serviceType,
            @JsonProperty("msgType") String msgType,
            @JsonProperty("requestType") String requestType,
            @JsonProperty("sendTime") String sendTime,
            @JsonProperty("reportTime") String reportTime,
            @JsonProperty("kakaoTime") String kakaoTime,
            @JsonProperty("reportCode") String reportCode,
            @JsonProperty("reportText") String reportText,
            @JsonProperty("kakaoResCreatedAt") String kakaoResCreatedAt,
            @JsonProperty("ref") String ref) {
        this.msgKey = msgKey;
        this.userKey = userKey;
        this.senderKey = senderKey;
        this.serviceType = serviceType;
        this.msgType = msgType;
        this.requestType = requestType;
        this.sendTime = sendTime;
        this.reportTime = reportTime;
        this.kakaoTime = kakaoTime;
        this.reportCode = reportCode;
        this.reportText = reportText;
        this.kakaoResCreatedAt = kakaoResCreatedAt;
        this.ref = ref;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselResultWebhookPayload(Builder builder) {
        this(builder.msgKey, builder.userKey, builder.senderKey, builder.serviceType, builder.msgType, builder.requestType, builder.sendTime, builder.reportTime, builder.kakaoTime, builder.reportCode, builder.reportText, builder.kakaoResCreatedAt, builder.ref);
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
        builder.userKey = this.userKey;
        builder.senderKey = this.senderKey;
        builder.serviceType = this.serviceType;
        builder.msgType = this.msgType;
        builder.requestType = this.requestType;
        builder.sendTime = this.sendTime;
        builder.reportTime = this.reportTime;
        builder.kakaoTime = this.kakaoTime;
        builder.reportCode = this.reportCode;
        builder.reportText = this.reportText;
        builder.kakaoResCreatedAt = this.kakaoResCreatedAt;
        builder.ref = this.ref;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 발송 API 응답으로 받은 메시지 키입니다.
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
     * 상담톡 사용자 키입니다. 카카오톡 채널별로 다르며 대소문자를 구분하고, 사용자가 탈퇴 후 재가입하면 바뀝니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("userKey")
    public String getUserKey() {
        return userKey;
    }

    /**
     * 메시지를 수신한 발신프로필 키입니다.
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
     * 서비스 타입입니다. 문서 예시 값은 <code>CSTALK</code>입니다.
     *
     * <p>필수 · 알려진 값 <code>CSTALK</code>
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
     * 요청 타입입니다. <code>write</code>(메시지 발송), <code>end</code>(상담 종료), <code>endwithbot</code>(상담 종료 및 봇 전환) 중 하나입니다.
     *
     * <p>필수 · 허용 값 <code>write</code>, <code>end</code>, <code>endwithbot</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("requestType")
    public String getRequestType() {
        return requestType;
    }

    /**
     * 비즈고가 이벤트를 수신한 시각입니다.
     *
     * <p>필수 · 형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendTime")
    public String getSendTime() {
        return sendTime;
    }

    /**
     * 비즈고가 웹훅을 전송한 시각입니다.
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
     * 카카오(상담톡 서버)가 전달한 시각입니다. 사용자가 메시지를 입력한 시각이 아닙니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("kakaoTime")
    public String getKakaoTime() {
        return kakaoTime;
    }

    /**
     * 발송 결과 코드입니다. 카카오 응답 코드를 비즈고 코드로 변환한 값이며 <code>A000</code>이면 성공입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportCode")
    public String getReportCode() {
        return reportCode;
    }

    /**
     * 리포트 메시지입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportText")
    public String getReportText() {
        return reportText;
    }

    /**
     * 카카오 응답 생성 일시입니다(ISO 8601).
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
     *
     * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("kakaoResCreatedAt")
    public String getKakaoResCreatedAt() {
        return kakaoResCreatedAt;
    }

    /**
     * 발송 요청 시 전달한 참조 필드입니다.
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
        if (!(o instanceof CounselResultWebhookPayload)) {
            return false;
        }
        CounselResultWebhookPayload other = (CounselResultWebhookPayload) o;
        return Objects.equals(msgKey, other.msgKey)
                && Objects.equals(userKey, other.userKey)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(serviceType, other.serviceType)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(requestType, other.requestType)
                && Objects.equals(sendTime, other.sendTime)
                && Objects.equals(reportTime, other.reportTime)
                && Objects.equals(kakaoTime, other.kakaoTime)
                && Objects.equals(reportCode, other.reportCode)
                && Objects.equals(reportText, other.reportText)
                && Objects.equals(kakaoResCreatedAt, other.kakaoResCreatedAt)
                && Objects.equals(ref, other.ref)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgKey, userKey, senderKey, serviceType, msgType, requestType, sendTime, reportTime, kakaoTime, reportCode, reportText, kakaoResCreatedAt, ref, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselResultWebhookPayload{", "}");
        if (msgKey != null) {
            joiner.add("msgKey=" + msgKey);
        }
        if (userKey != null) {
            joiner.add("userKey=" + io.github.icommapi.bizgo.internal.Masking.length(userKey));
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (serviceType != null) {
            joiner.add("serviceType=" + serviceType);
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (requestType != null) {
            joiner.add("requestType=" + io.github.icommapi.bizgo.internal.Masking.length(requestType));
        }
        if (sendTime != null) {
            joiner.add("sendTime=" + sendTime);
        }
        if (reportTime != null) {
            joiner.add("reportTime=" + reportTime);
        }
        if (kakaoTime != null) {
            joiner.add("kakaoTime=" + io.github.icommapi.bizgo.internal.Masking.length(kakaoTime));
        }
        if (reportCode != null) {
            joiner.add("reportCode=" + reportCode);
        }
        if (reportText != null) {
            joiner.add("reportText=" + reportText);
        }
        if (kakaoResCreatedAt != null) {
            joiner.add("kakaoResCreatedAt=" + io.github.icommapi.bizgo.internal.Masking.length(kakaoResCreatedAt));
        }
        if (ref != null) {
            joiner.add("ref=" + io.github.icommapi.bizgo.internal.Masking.length(ref));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselResultWebhookPayload}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String msgKey;
        private String userKey;
        private String senderKey;
        private String serviceType;
        private String msgType;
        private String requestType;
        private String sendTime;
        private String reportTime;
        private String kakaoTime;
        private String reportCode;
        private String reportText;
        private String kakaoResCreatedAt;
        private String ref;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselResultWebhookPayload#builder()}. */
        public Builder() {
        }

        /**
         * 발송 API 응답으로 받은 메시지 키입니다.
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
         * 상담톡 사용자 키입니다. 카카오톡 채널별로 다르며 대소문자를 구분하고, 사용자가 탈퇴 후 재가입하면 바뀝니다.
         *
         * <p>필수
         *
         * @param userKey the value (null clears it)
         * @return this builder
         */
        public Builder userKey(String userKey) {
            this.userKey = userKey;
            return this;
        }

        /**
         * 메시지를 수신한 발신프로필 키입니다.
         *
         * <p>필수
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 서비스 타입입니다. 문서 예시 값은 <code>CSTALK</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>CSTALK</code>
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
         * 요청 타입입니다. <code>write</code>(메시지 발송), <code>end</code>(상담 종료), <code>endwithbot</code>(상담 종료 및 봇 전환) 중 하나입니다.
         *
         * <p>필수 · 허용 값 <code>write</code>, <code>end</code>, <code>endwithbot</code>
         *
         * @param requestType the value (null clears it)
         * @return this builder
         */
        public Builder requestType(String requestType) {
            this.requestType = requestType;
            return this;
        }

        /**
         * 비즈고가 이벤트를 수신한 시각입니다.
         *
         * <p>필수 · 형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
         *
         * @param sendTime the value (null clears it)
         * @return this builder
         */
        public Builder sendTime(String sendTime) {
            this.sendTime = sendTime;
            return this;
        }

        /**
         * 비즈고가 웹훅을 전송한 시각입니다.
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
         * 카카오(상담톡 서버)가 전달한 시각입니다. 사용자가 메시지를 입력한 시각이 아닙니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
         *
         * @param kakaoTime the value (null clears it)
         * @return this builder
         */
        public Builder kakaoTime(String kakaoTime) {
            this.kakaoTime = kakaoTime;
            return this;
        }

        /**
         * 발송 결과 코드입니다. 카카오 응답 코드를 비즈고 코드로 변환한 값이며 <code>A000</code>이면 성공입니다.
         *
         * @param reportCode the value (null clears it)
         * @return this builder
         */
        public Builder reportCode(String reportCode) {
            this.reportCode = reportCode;
            return this;
        }

        /**
         * 리포트 메시지입니다.
         *
         * @param reportText the value (null clears it)
         * @return this builder
         */
        public Builder reportText(String reportText) {
            this.reportText = reportText;
            return this;
        }

        /**
         * 카카오 응답 생성 일시입니다(ISO 8601).
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
         *
         * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없습니다.
         *
         * @param kakaoResCreatedAt the value (null clears it)
         * @return this builder
         */
        public Builder kakaoResCreatedAt(String kakaoResCreatedAt) {
            this.kakaoResCreatedAt = kakaoResCreatedAt;
            return this;
        }

        /**
         * 발송 요청 시 전달한 참조 필드입니다.
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
         * @return a new immutable {@code CounselResultWebhookPayload}
         */
        public CounselResultWebhookPayload build() {
            return new CounselResultWebhookPayload(this);
        }
    }
}
