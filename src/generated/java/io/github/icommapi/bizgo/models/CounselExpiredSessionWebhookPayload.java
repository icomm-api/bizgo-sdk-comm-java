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
 * 세션 종료 수신 웹훅(<code>&#123;고객 Webhook URL&#125;/cstalk/expired_session</code>) 본문입니다.
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
@JsonPropertyOrder({"msgKey", "userKey", "senderKey", "serviceType", "msgType", "requestType", "sendTime", "reportTime", "kakaoTime", "sessionId"})
public final class CounselExpiredSessionWebhookPayload {

    private final String msgKey;
    private final String userKey;
    private final String senderKey;
    private final String serviceType;
    private final String msgType;
    private final String requestType;
    private final String sendTime;
    private final String reportTime;
    private final String kakaoTime;
    private final String sessionId;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselExpiredSessionWebhookPayload(
            @JsonProperty("msgKey") String msgKey,
            @JsonProperty("userKey") String userKey,
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("serviceType") String serviceType,
            @JsonProperty("msgType") String msgType,
            @JsonProperty("requestType") String requestType,
            @JsonProperty("sendTime") String sendTime,
            @JsonProperty("reportTime") String reportTime,
            @JsonProperty("kakaoTime") String kakaoTime,
            @JsonProperty("sessionId") String sessionId) {
        this.msgKey = msgKey;
        this.userKey = userKey;
        this.senderKey = senderKey;
        this.serviceType = serviceType;
        this.msgType = msgType;
        this.requestType = requestType;
        this.sendTime = sendTime;
        this.reportTime = reportTime;
        this.kakaoTime = kakaoTime;
        this.sessionId = sessionId;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselExpiredSessionWebhookPayload(Builder builder) {
        this(builder.msgKey, builder.userKey, builder.senderKey, builder.serviceType, builder.msgType, builder.requestType, builder.sendTime, builder.reportTime, builder.kakaoTime, builder.sessionId);
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
        builder.sessionId = this.sessionId;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 메시지 키입니다. 발송 결과(<code>result</code>)에서는 발송 API 응답의 msgKey와 같고, 수신 6종에서는 이벤트마다 새로 발급된 값이라 발송 건과 대응하지 않습니다. 재시도로 같은 이벤트가 다시 올 수 있으므로 msgKey 기준으로 멱등 처리합니다.
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
     * 메시지 타입입니다. 문서 예시 값은 <code>SESSION</code>입니다.
     *
     * <p>필수 · 알려진 값 <code>SESSION</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 요청 타입입니다. 문서 예시 값은 <code>expired_session</code>입니다.
     *
     * <p>필수 · 알려진 값 <code>expired_session</code>
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
     * 종료된 상담 세션 아이디입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
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
        if (!(o instanceof CounselExpiredSessionWebhookPayload)) {
            return false;
        }
        CounselExpiredSessionWebhookPayload other = (CounselExpiredSessionWebhookPayload) o;
        return Objects.equals(msgKey, other.msgKey)
                && Objects.equals(userKey, other.userKey)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(serviceType, other.serviceType)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(requestType, other.requestType)
                && Objects.equals(sendTime, other.sendTime)
                && Objects.equals(reportTime, other.reportTime)
                && Objects.equals(kakaoTime, other.kakaoTime)
                && Objects.equals(sessionId, other.sessionId)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgKey, userKey, senderKey, serviceType, msgType, requestType, sendTime, reportTime, kakaoTime, sessionId, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselExpiredSessionWebhookPayload{", "}");
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
        if (sessionId != null) {
            joiner.add("sessionId=" + io.github.icommapi.bizgo.internal.Masking.length(sessionId));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselExpiredSessionWebhookPayload}. */
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
        private String sessionId;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselExpiredSessionWebhookPayload#builder()}. */
        public Builder() {
        }

        /**
         * 메시지 키입니다. 발송 결과(<code>result</code>)에서는 발송 API 응답의 msgKey와 같고, 수신 6종에서는 이벤트마다 새로 발급된 값이라 발송 건과 대응하지 않습니다. 재시도로 같은 이벤트가 다시 올 수 있으므로 msgKey 기준으로 멱등 처리합니다.
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
         * 메시지 타입입니다. 문서 예시 값은 <code>SESSION</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>SESSION</code>
         *
         * @param msgType the value (null clears it)
         * @return this builder
         */
        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        /**
         * 요청 타입입니다. 문서 예시 값은 <code>expired_session</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>expired_session</code>
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
         * 종료된 상담 세션 아이디입니다.
         *
         * @param sessionId the value (null clears it)
         * @return this builder
         */
        public Builder sessionId(String sessionId) {
            this.sessionId = sessionId;
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
         * @return a new immutable {@code CounselExpiredSessionWebhookPayload}
         */
        public CounselExpiredSessionWebhookPayload build() {
            return new CounselExpiredSessionWebhookPayload(this);
        }
    }
}
