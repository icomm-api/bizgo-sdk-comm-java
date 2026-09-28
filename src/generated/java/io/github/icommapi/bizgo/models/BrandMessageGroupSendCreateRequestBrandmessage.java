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

/**
 * 기본형 템플릿 동보 발송 정보입니다.
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
@JsonDeserialize(builder = BrandMessageGroupSendCreateRequestBrandmessage.Builder.class)
@JsonPropertyOrder({"senderKey", "templateCode", "friendGroupKey", "sendStartAt", "campaignId", "tpsLimit", "pushAlarm", "originCID"})
public final class BrandMessageGroupSendCreateRequestBrandmessage {
    private static final List<String> PUSH_ALARM_VALUES = List.of("Y", "N");

    private final String senderKey;
    private final String templateCode;
    private final String friendGroupKey;
    private final String sendStartAt;
    private final String campaignId;
    private final Integer tpsLimit;
    private final String pushAlarm;
    private final String originCID;

    private BrandMessageGroupSendCreateRequestBrandmessage(Builder builder) {
        this.senderKey = builder.senderKey;
        this.templateCode = builder.templateCode;
        this.friendGroupKey = builder.friendGroupKey;
        this.sendStartAt = builder.sendStartAt;
        this.campaignId = builder.campaignId;
        this.tpsLimit = builder.tpsLimit;
        this.pushAlarm = builder.pushAlarm;
        this.originCID = builder.originCID;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.templateCode = this.templateCode;
        builder.friendGroupKey = this.friendGroupKey;
        builder.sendStartAt = this.sendStartAt;
        builder.campaignId = this.campaignId;
        builder.tpsLimit = this.tpsLimit;
        builder.pushAlarm = this.pushAlarm;
        builder.originCID = this.originCID;
        return builder;
    }

    /**
     * 발신프로필 키입니다.
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
     * 기본형 템플릿 코드입니다. 변수가 없고 상태가 등록(<code>A</code>)인 템플릿이어야 합니다.
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
     * 친구 그룹 등록으로 발급받은 키입니다. 생략하면 전체 친구를 대상으로 합니다. 친구 그룹을 쓰면 그룹 상태가 완료이고 등록 유저 수(<code>userCount</code>)가 10 이상이어야 합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("friendGroupKey")
    public String getFriendGroupKey() {
        return friendGroupKey;
    }

    /**
     * 동보 발송 시작 일시(<code>yyyy-MM-dd HH:mm:ss</code>, KST)입니다. 요청 시점으로부터 10분 이후, 08:00~20:50 범위로 설정합니다. 20:50~익일 08:00에는 자동 중지 후 익일 08:00 이후 자동 재개됩니다.
     *
     * <p>필수 · 형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendStartAt")
    public String getSendStartAt() {
        return sendStartAt;
    }

    /**
     * 고객 캠페인 식별자입니다. 동일 캠페인의 중복 발송을 방지하는 데 사용합니다.
     *
     * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없는 필드입니다. 중복 방지 동작(같은 campaignId 재요청 시 결과)도 문서에 없습니다.
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
     * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없는 필드입니다. 허용 범위가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("tpsLimit")
    public Integer getTpsLimit() {
        return tpsLimit;
    }

    /**
     * 메시지 푸시 알림 발송 여부입니다. 기본값은 <code>Y</code>입니다.
     *
     * <p>허용 값 <code>Y</code>, <code>N</code> · 서버 기본값 <code>Y</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("pushAlarm")
    public String getPushAlarm() {
        return pushAlarm;
    }

    /**
     * 최초 발신사업자 식별코드입니다. 재판매사·특수부가통신사업자는 필수입니다. 최대 9자입니다.
     *
     * <p>최대 9자
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
        if (!(o instanceof BrandMessageGroupSendCreateRequestBrandmessage)) {
            return false;
        }
        BrandMessageGroupSendCreateRequestBrandmessage other = (BrandMessageGroupSendCreateRequestBrandmessage) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(friendGroupKey, other.friendGroupKey)
                && Objects.equals(sendStartAt, other.sendStartAt)
                && Objects.equals(campaignId, other.campaignId)
                && Objects.equals(tpsLimit, other.tpsLimit)
                && Objects.equals(pushAlarm, other.pushAlarm)
                && Objects.equals(originCID, other.originCID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, templateCode, friendGroupKey, sendStartAt, campaignId, tpsLimit, pushAlarm, originCID);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageGroupSendCreateRequestBrandmessage{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (friendGroupKey != null) {
            joiner.add("friendGroupKey=" + io.github.icommapi.bizgo.internal.Masking.length(friendGroupKey));
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
        if (originCID != null) {
            joiner.add("originCID=" + io.github.icommapi.bizgo.internal.Masking.length(originCID));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageGroupSendCreateRequestBrandmessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String templateCode;
        private String friendGroupKey;
        private String sendStartAt;
        private String campaignId;
        private Integer tpsLimit;
        private String pushAlarm;
        private String originCID;

        /** Creates an empty builder; same as {@link BrandMessageGroupSendCreateRequestBrandmessage#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다.
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
         * 기본형 템플릿 코드입니다. 변수가 없고 상태가 등록(<code>A</code>)인 템플릿이어야 합니다.
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
         * 친구 그룹 등록으로 발급받은 키입니다. 생략하면 전체 친구를 대상으로 합니다. 친구 그룹을 쓰면 그룹 상태가 완료이고 등록 유저 수(<code>userCount</code>)가 10 이상이어야 합니다.
         *
         * @param friendGroupKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("friendGroupKey")
        public Builder friendGroupKey(String friendGroupKey) {
            this.friendGroupKey = friendGroupKey;
            return this;
        }

        /**
         * 동보 발송 시작 일시(<code>yyyy-MM-dd HH:mm:ss</code>, KST)입니다. 요청 시점으로부터 10분 이후, 08:00~20:50 범위로 설정합니다. 20:50~익일 08:00에는 자동 중지 후 익일 08:00 이후 자동 재개됩니다.
         *
         * <p>필수 · 형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param sendStartAt the value (null clears it)
         * @return this builder
         */
        @JsonProperty("sendStartAt")
        public Builder sendStartAt(String sendStartAt) {
            this.sendStartAt = sendStartAt;
            return this;
        }

        /**
         * 고객 캠페인 식별자입니다. 동일 캠페인의 중복 발송을 방지하는 데 사용합니다.
         *
         * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없는 필드입니다. 중복 방지 동작(같은 campaignId 재요청 시 결과)도 문서에 없습니다.
         *
         * @param campaignId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("campaignId")
        public Builder campaignId(String campaignId) {
            this.campaignId = campaignId;
            return this;
        }

        /**
         * 초당 발송 건수 상한입니다.
         *
         * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없는 필드입니다. 허용 범위가 문서에 없습니다.
         *
         * @param tpsLimit the value (null clears it)
         * @return this builder
         */
        @JsonProperty("tpsLimit")
        public Builder tpsLimit(Integer tpsLimit) {
            this.tpsLimit = tpsLimit;
            return this;
        }

        /**
         * 메시지 푸시 알림 발송 여부입니다. 기본값은 <code>Y</code>입니다.
         *
         * <p>허용 값 <code>Y</code>, <code>N</code> · 서버 기본값 <code>Y</code>(설정하지 않으면 보내지 않음)
         *
         * @param pushAlarm the value (null clears it)
         * @return this builder
         */
        @JsonProperty("pushAlarm")
        public Builder pushAlarm(String pushAlarm) {
            this.pushAlarm = pushAlarm;
            return this;
        }

        /**
         * 최초 발신사업자 식별코드입니다. 재판매사·특수부가통신사업자는 필수입니다. 최대 9자입니다.
         *
         * <p>최대 9자
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
         * @return a new immutable {@code BrandMessageGroupSendCreateRequestBrandmessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageGroupSendCreateRequestBrandmessage build() {
            BrandMessageGroupSendCreateRequestBrandmessage built = new BrandMessageGroupSendCreateRequestBrandmessage(this);
            ModelValidator v = new ModelValidator("BrandMessageGroupSendCreateRequestBrandmessage");
            v.required("senderKey", built.senderKey);
            v.required("templateCode", built.templateCode);
            v.required("sendStartAt", built.sendStartAt);
            v.oneOf("pushAlarm", built.pushAlarm, PUSH_ALARM_VALUES);
            v.maxLength("originCID", built.originCID, 9);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageGroupSendCreateRequestBrandmessage buildUnvalidated() {
            return new BrandMessageGroupSendCreateRequestBrandmessage(this);
        }
    }
}
