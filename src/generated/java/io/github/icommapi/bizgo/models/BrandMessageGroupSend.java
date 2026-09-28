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
 * 동보 발송 요청 정보입니다.
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
@JsonPropertyOrder({"requestId", "status", "sendStartAt", "campaignId", "tpsLimit", "pushAlarm", "expectedCount", "sendCount", "senderKey", "msgType", "templateCode", "friendGroupKey"})
public final class BrandMessageGroupSend {

    private final String requestId;
    private final String status;
    private final String sendStartAt;
    private final String campaignId;
    private final Long tpsLimit;
    private final String pushAlarm;
    private final Long expectedCount;
    private final Long sendCount;
    private final String senderKey;
    private final String msgType;
    private final String templateCode;
    private final String friendGroupKey;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageGroupSend(
            @JsonProperty("requestId") String requestId,
            @JsonProperty("status") String status,
            @JsonProperty("sendStartAt") String sendStartAt,
            @JsonProperty("campaignId") String campaignId,
            @JsonProperty("tpsLimit") Long tpsLimit,
            @JsonProperty("pushAlarm") String pushAlarm,
            @JsonProperty("expectedCount") Long expectedCount,
            @JsonProperty("sendCount") Long sendCount,
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("msgType") String msgType,
            @JsonProperty("templateCode") String templateCode,
            @JsonProperty("friendGroupKey") String friendGroupKey) {
        this.requestId = requestId;
        this.status = status;
        this.sendStartAt = sendStartAt;
        this.campaignId = campaignId;
        this.tpsLimit = tpsLimit;
        this.pushAlarm = pushAlarm;
        this.expectedCount = expectedCount;
        this.sendCount = sendCount;
        this.senderKey = senderKey;
        this.msgType = msgType;
        this.templateCode = templateCode;
        this.friendGroupKey = friendGroupKey;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageGroupSend(Builder builder) {
        this(builder.requestId, builder.status, builder.sendStartAt, builder.campaignId, builder.tpsLimit, builder.pushAlarm, builder.expectedCount, builder.sendCount, builder.senderKey, builder.msgType, builder.templateCode, builder.friendGroupKey);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.requestId = this.requestId;
        builder.status = this.status;
        builder.sendStartAt = this.sendStartAt;
        builder.campaignId = this.campaignId;
        builder.tpsLimit = this.tpsLimit;
        builder.pushAlarm = this.pushAlarm;
        builder.expectedCount = this.expectedCount;
        builder.sendCount = this.sendCount;
        builder.senderKey = this.senderKey;
        builder.msgType = this.msgType;
        builder.templateCode = this.templateCode;
        builder.friendGroupKey = this.friendGroupKey;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 동보 발송 요청 아이디입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("requestId")
    public String getRequestId() {
        return requestId;
    }

    /**
     * 동보 발송 상태입니다. 알려진 값: <code>READY</code>(발송 대기), <code>SENDING</code>(발송 중), <code>PAUSED</code>(발송 중지), <code>DONE</code>(발송 완료), <code>TERMINATED</code>(발송 종료), <code>BLOCKED</code>(발송 차단).
     *
     * <p>알려진 값 <code>READY</code>, <code>SENDING</code>, <code>PAUSED</code>, <code>DONE</code>, <code>TERMINATED</code>, <code>BLOCKED</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 동보 발송 시작 일시(<code>yyyy-MM-dd HH:mm:ss</code>, KST)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendStartAt")
    public String getSendStartAt() {
        return sendStartAt;
    }

    /**
     * 고객 캠페인 식별자입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("campaignId")
    public String getCampaignId() {
        return campaignId;
    }

    /**
     * 초당 발송 건수 상한입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("tpsLimit")
    public Long getTpsLimit() {
        return tpsLimit;
    }

    /**
     * 메시지 푸시 알림 발송 여부입니다.
     *
     * <p>허용 값 <code>Y</code>, <code>N</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("pushAlarm")
    public String getPushAlarm() {
        return pushAlarm;
    }

    /**
     * 예상 발송 수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("expectedCount")
    public Long getExpectedCount() {
        return expectedCount;
    }

    /**
     * 실제 발송 처리 수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendCount")
    public Long getSendCount() {
        return sendCount;
    }

    /**
     * 발신프로필 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 브랜드메시지 메시지 타입입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 기본형 템플릿 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 친구 그룹 키입니다. 전체 친구 대상이면 없을 수 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("friendGroupKey")
    public String getFriendGroupKey() {
        return friendGroupKey;
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
        if (!(o instanceof BrandMessageGroupSend)) {
            return false;
        }
        BrandMessageGroupSend other = (BrandMessageGroupSend) o;
        return Objects.equals(requestId, other.requestId)
                && Objects.equals(status, other.status)
                && Objects.equals(sendStartAt, other.sendStartAt)
                && Objects.equals(campaignId, other.campaignId)
                && Objects.equals(tpsLimit, other.tpsLimit)
                && Objects.equals(pushAlarm, other.pushAlarm)
                && Objects.equals(expectedCount, other.expectedCount)
                && Objects.equals(sendCount, other.sendCount)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(friendGroupKey, other.friendGroupKey)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, status, sendStartAt, campaignId, tpsLimit, pushAlarm, expectedCount, sendCount, senderKey, msgType, templateCode, friendGroupKey, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageGroupSend{", "}");
        if (requestId != null) {
            joiner.add("requestId=" + io.github.icommapi.bizgo.internal.Masking.length(requestId));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (sendStartAt != null) {
            joiner.add("sendStartAt=" + io.github.icommapi.bizgo.internal.Masking.length(sendStartAt));
        }
        if (campaignId != null) {
            joiner.add("campaignId=" + io.github.icommapi.bizgo.internal.Masking.length(campaignId));
        }
        if (tpsLimit != null) {
            joiner.add("tpsLimit=***");
        }
        if (pushAlarm != null) {
            joiner.add("pushAlarm=" + io.github.icommapi.bizgo.internal.Masking.length(pushAlarm));
        }
        if (expectedCount != null) {
            joiner.add("expectedCount=***");
        }
        if (sendCount != null) {
            joiner.add("sendCount=***");
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (friendGroupKey != null) {
            joiner.add("friendGroupKey=" + io.github.icommapi.bizgo.internal.Masking.length(friendGroupKey));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageGroupSend}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String requestId;
        private String status;
        private String sendStartAt;
        private String campaignId;
        private Long tpsLimit;
        private String pushAlarm;
        private Long expectedCount;
        private Long sendCount;
        private String senderKey;
        private String msgType;
        private String templateCode;
        private String friendGroupKey;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageGroupSend#builder()}. */
        public Builder() {
        }

        /**
         * 동보 발송 요청 아이디입니다.
         *
         * @param requestId the value (null clears it)
         * @return this builder
         */
        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * 동보 발송 상태입니다. 알려진 값: <code>READY</code>(발송 대기), <code>SENDING</code>(발송 중), <code>PAUSED</code>(발송 중지), <code>DONE</code>(발송 완료), <code>TERMINATED</code>(발송 종료), <code>BLOCKED</code>(발송 차단).
         *
         * <p>알려진 값 <code>READY</code>, <code>SENDING</code>, <code>PAUSED</code>, <code>DONE</code>, <code>TERMINATED</code>, <code>BLOCKED</code>
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 동보 발송 시작 일시(<code>yyyy-MM-dd HH:mm:ss</code>, KST)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param sendStartAt the value (null clears it)
         * @return this builder
         */
        public Builder sendStartAt(String sendStartAt) {
            this.sendStartAt = sendStartAt;
            return this;
        }

        /**
         * 고객 캠페인 식별자입니다.
         *
         * @param campaignId the value (null clears it)
         * @return this builder
         */
        public Builder campaignId(String campaignId) {
            this.campaignId = campaignId;
            return this;
        }

        /**
         * 초당 발송 건수 상한입니다.
         *
         * @param tpsLimit the value (null clears it)
         * @return this builder
         */
        public Builder tpsLimit(Long tpsLimit) {
            this.tpsLimit = tpsLimit;
            return this;
        }

        /**
         * 메시지 푸시 알림 발송 여부입니다.
         *
         * <p>허용 값 <code>Y</code>, <code>N</code>
         *
         * @param pushAlarm the value (null clears it)
         * @return this builder
         */
        public Builder pushAlarm(String pushAlarm) {
            this.pushAlarm = pushAlarm;
            return this;
        }

        /**
         * 예상 발송 수입니다.
         *
         * @param expectedCount the value (null clears it)
         * @return this builder
         */
        public Builder expectedCount(Long expectedCount) {
            this.expectedCount = expectedCount;
            return this;
        }

        /**
         * 실제 발송 처리 수입니다.
         *
         * @param sendCount the value (null clears it)
         * @return this builder
         */
        public Builder sendCount(Long sendCount) {
            this.sendCount = sendCount;
            return this;
        }

        /**
         * 발신프로필 키입니다.
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 브랜드메시지 메시지 타입입니다.
         *
         * @param msgType the value (null clears it)
         * @return this builder
         */
        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        /**
         * 기본형 템플릿 코드입니다.
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * 친구 그룹 키입니다. 전체 친구 대상이면 없을 수 있습니다.
         *
         * @param friendGroupKey the value (null clears it)
         * @return this builder
         */
        public Builder friendGroupKey(String friendGroupKey) {
            this.friendGroupKey = friendGroupKey;
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
         * @return a new immutable {@code BrandMessageGroupSend}
         */
        public BrandMessageGroupSend build() {
            return new BrandMessageGroupSend(this);
        }
    }
}
