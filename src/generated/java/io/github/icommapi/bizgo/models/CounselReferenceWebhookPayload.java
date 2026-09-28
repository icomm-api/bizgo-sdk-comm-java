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
 * 사용자 메타 정보 수신 웹훅(<code>&#123;고객 Webhook URL&#125;/cstalk/reference</code>) 본문입니다. 사용자가 상담 연결을 요청한 시점의 메타 정보가 담깁니다.
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
@JsonPropertyOrder({"msgKey", "userKey", "senderKey", "serviceType", "msgType", "requestType", "sendTime", "reportTime", "kakaoTime", "appUserId", "sessionId", "reference", "lastReference"})
public final class CounselReferenceWebhookPayload {

    private final String msgKey;
    private final String userKey;
    private final String senderKey;
    private final String serviceType;
    private final String msgType;
    private final String requestType;
    private final String sendTime;
    private final String reportTime;
    private final String kakaoTime;
    private final Long appUserId;
    private final String sessionId;
    private final CounselReference reference;
    private final CounselLastReference lastReference;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselReferenceWebhookPayload(
            @JsonProperty("msgKey") String msgKey,
            @JsonProperty("userKey") String userKey,
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("serviceType") String serviceType,
            @JsonProperty("msgType") String msgType,
            @JsonProperty("requestType") String requestType,
            @JsonProperty("sendTime") String sendTime,
            @JsonProperty("reportTime") String reportTime,
            @JsonProperty("kakaoTime") String kakaoTime,
            @JsonProperty("appUserId") Long appUserId,
            @JsonProperty("sessionId") String sessionId,
            @JsonProperty("reference") CounselReference reference,
            @JsonProperty("lastReference") CounselLastReference lastReference) {
        this.msgKey = msgKey;
        this.userKey = userKey;
        this.senderKey = senderKey;
        this.serviceType = serviceType;
        this.msgType = msgType;
        this.requestType = requestType;
        this.sendTime = sendTime;
        this.reportTime = reportTime;
        this.kakaoTime = kakaoTime;
        this.appUserId = appUserId;
        this.sessionId = sessionId;
        this.reference = reference;
        this.lastReference = lastReference;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselReferenceWebhookPayload(Builder builder) {
        this(builder.msgKey, builder.userKey, builder.senderKey, builder.serviceType, builder.msgType, builder.requestType, builder.sendTime, builder.reportTime, builder.kakaoTime, builder.appUserId, builder.sessionId, builder.reference, builder.lastReference);
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
        builder.appUserId = this.appUserId;
        builder.sessionId = this.sessionId;
        builder.reference = this.reference;
        builder.lastReference = this.lastReference;
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
     * 메시지 타입입니다. 문서 예시 값은 <code>REFERENCE</code>입니다.
     *
     * <p>필수 · 알려진 값 <code>REFERENCE</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 요청 타입입니다. 문서 예시 값은 <code>reference</code>입니다.
     *
     * <p>필수 · 알려진 값 <code>reference</code>
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
     * 카카오톡 앱 사용자 ID입니다. 개인 식별자이므로 로그에 남기지 않습니다.
     *
     * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없습니다. 문서상 타입은 Number입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("appUserId")
    public Long getAppUserId() {
        return appUserId;
    }

    /**
     * 상담 세션 아이디입니다. 세션이 생성된 상태에서만 상담원이 메시지를 보낼 수 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    /**
     * {@code reference}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reference")
    public CounselReference getReference() {
        return reference;
    }

    /**
     * {@code lastReference}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("lastReference")
    public CounselLastReference getLastReference() {
        return lastReference;
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
        if (!(o instanceof CounselReferenceWebhookPayload)) {
            return false;
        }
        CounselReferenceWebhookPayload other = (CounselReferenceWebhookPayload) o;
        return Objects.equals(msgKey, other.msgKey)
                && Objects.equals(userKey, other.userKey)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(serviceType, other.serviceType)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(requestType, other.requestType)
                && Objects.equals(sendTime, other.sendTime)
                && Objects.equals(reportTime, other.reportTime)
                && Objects.equals(kakaoTime, other.kakaoTime)
                && Objects.equals(appUserId, other.appUserId)
                && Objects.equals(sessionId, other.sessionId)
                && Objects.equals(reference, other.reference)
                && Objects.equals(lastReference, other.lastReference)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgKey, userKey, senderKey, serviceType, msgType, requestType, sendTime, reportTime, kakaoTime, appUserId, sessionId, reference, lastReference, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselReferenceWebhookPayload{", "}");
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
        if (appUserId != null) {
            joiner.add("appUserId=***");
        }
        if (sessionId != null) {
            joiner.add("sessionId=" + io.github.icommapi.bizgo.internal.Masking.length(sessionId));
        }
        if (reference != null) {
            joiner.add("reference=" + reference);
        }
        if (lastReference != null) {
            joiner.add("lastReference=" + lastReference);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselReferenceWebhookPayload}. */
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
        private Long appUserId;
        private String sessionId;
        private CounselReference reference;
        private CounselLastReference lastReference;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselReferenceWebhookPayload#builder()}. */
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
         * 메시지 타입입니다. 문서 예시 값은 <code>REFERENCE</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>REFERENCE</code>
         *
         * @param msgType the value (null clears it)
         * @return this builder
         */
        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        /**
         * 요청 타입입니다. 문서 예시 값은 <code>reference</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>reference</code>
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
         * 카카오톡 앱 사용자 ID입니다. 개인 식별자이므로 로그에 남기지 않습니다.
         *
         * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없습니다. 문서상 타입은 Number입니다.
         *
         * @param appUserId the value (null clears it)
         * @return this builder
         */
        public Builder appUserId(Long appUserId) {
            this.appUserId = appUserId;
            return this;
        }

        /**
         * 상담 세션 아이디입니다. 세션이 생성된 상태에서만 상담원이 메시지를 보낼 수 있습니다.
         *
         * @param sessionId the value (null clears it)
         * @return this builder
         */
        public Builder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        /**
         * {@code reference}.
         *
         * @param reference the value (null clears it)
         * @return this builder
         */
        public Builder reference(CounselReference reference) {
            this.reference = reference;
            return this;
        }

        /**
         * {@code lastReference}.
         *
         * @param lastReference the value (null clears it)
         * @return this builder
         */
        public Builder lastReference(CounselLastReference lastReference) {
            this.lastReference = lastReference;
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
         * @return a new immutable {@code CounselReferenceWebhookPayload}
         */
        public CounselReferenceWebhookPayload build() {
            return new CounselReferenceWebhookPayload(this);
        }
    }
}
