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
 * 카카오 비즈메시지 발신프로필 정보입니다. 발신프로필 등록(<code>POST /account/kakao/sender</code>), uuid·senderKey 조회(<code>GET /account/kakao/sender</code>), 발신프로필 키로 조회(<code>GET /center/kakao/sender</code>) 응답에서 함께 씁니다. 엔드포인트마다 포함되는 필드가 조금씩 다릅니다.
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
@JsonPropertyOrder({"senderKey", "uuid", "name", "status", "block", "dormant", "profileStatus", "createdAt", "modifiedAt", "categoryCode", "bizchat", "brandtalk", "brandMessage", "committalCompanyName", "channelKey", "businessProfile", "businessType", "unsubscribePhoneNumber", "unsubscribeAuthNumber", "profileSpamLevel", "profileMessageSpamLevel", "clearBlockUrl"})
public final class KakaoSenderProfile {

    private final String senderKey;
    private final String uuid;
    private final String name;
    private final String status;
    private final Boolean block;
    private final Boolean dormant;
    private final String profileStatus;
    private final String createdAt;
    private final String modifiedAt;
    private final String categoryCode;
    private final Boolean bizchat;
    private final Boolean brandtalk;
    private final Boolean brandMessage;
    private final String committalCompanyName;
    private final String channelKey;
    private final Boolean businessProfile;
    private final String businessType;
    private final String unsubscribePhoneNumber;
    private final String unsubscribeAuthNumber;
    private final String profileSpamLevel;
    private final String profileMessageSpamLevel;
    private final String clearBlockUrl;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private KakaoSenderProfile(
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("uuid") String uuid,
            @JsonProperty("name") String name,
            @JsonProperty("status") String status,
            @JsonProperty("block") Boolean block,
            @JsonProperty("dormant") Boolean dormant,
            @JsonProperty("profileStatus") String profileStatus,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("modifiedAt") String modifiedAt,
            @JsonProperty("categoryCode") String categoryCode,
            @JsonProperty("bizchat") Boolean bizchat,
            @JsonProperty("brandtalk") Boolean brandtalk,
            @JsonProperty("brandMessage") Boolean brandMessage,
            @JsonProperty("committalCompanyName") String committalCompanyName,
            @JsonProperty("channelKey") String channelKey,
            @JsonProperty("businessProfile") Boolean businessProfile,
            @JsonProperty("businessType") String businessType,
            @JsonProperty("unsubscribePhoneNumber") String unsubscribePhoneNumber,
            @JsonProperty("unsubscribeAuthNumber") String unsubscribeAuthNumber,
            @JsonProperty("profileSpamLevel") String profileSpamLevel,
            @JsonProperty("profileMessageSpamLevel") String profileMessageSpamLevel,
            @JsonProperty("clearBlockUrl") String clearBlockUrl) {
        this.senderKey = senderKey;
        this.uuid = uuid;
        this.name = name;
        this.status = status;
        this.block = block;
        this.dormant = dormant;
        this.profileStatus = profileStatus;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.categoryCode = categoryCode;
        this.bizchat = bizchat;
        this.brandtalk = brandtalk;
        this.brandMessage = brandMessage;
        this.committalCompanyName = committalCompanyName;
        this.channelKey = channelKey;
        this.businessProfile = businessProfile;
        this.businessType = businessType;
        this.unsubscribePhoneNumber = unsubscribePhoneNumber;
        this.unsubscribeAuthNumber = unsubscribeAuthNumber;
        this.profileSpamLevel = profileSpamLevel;
        this.profileMessageSpamLevel = profileMessageSpamLevel;
        this.clearBlockUrl = clearBlockUrl;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private KakaoSenderProfile(Builder builder) {
        this(builder.senderKey, builder.uuid, builder.name, builder.status, builder.block, builder.dormant, builder.profileStatus, builder.createdAt, builder.modifiedAt, builder.categoryCode, builder.bizchat, builder.brandtalk, builder.brandMessage, builder.committalCompanyName, builder.channelKey, builder.businessProfile, builder.businessType, builder.unsubscribePhoneNumber, builder.unsubscribeAuthNumber, builder.profileSpamLevel, builder.profileMessageSpamLevel, builder.clearBlockUrl);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.uuid = this.uuid;
        builder.name = this.name;
        builder.status = this.status;
        builder.block = this.block;
        builder.dormant = this.dormant;
        builder.profileStatus = this.profileStatus;
        builder.createdAt = this.createdAt;
        builder.modifiedAt = this.modifiedAt;
        builder.categoryCode = this.categoryCode;
        builder.bizchat = this.bizchat;
        builder.brandtalk = this.brandtalk;
        builder.brandMessage = this.brandMessage;
        builder.committalCompanyName = this.committalCompanyName;
        builder.channelKey = this.channelKey;
        builder.businessProfile = this.businessProfile;
        builder.businessType = this.businessType;
        builder.unsubscribePhoneNumber = this.unsubscribePhoneNumber;
        builder.unsubscribeAuthNumber = this.unsubscribeAuthNumber;
        builder.profileSpamLevel = this.profileSpamLevel;
        builder.profileMessageSpamLevel = this.profileMessageSpamLevel;
        builder.clearBlockUrl = this.clearBlockUrl;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
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
     * 카카오톡 채널 아이디(uuid)입니다. <code>&#64;</code>로 시작하는 카카오톡 채널 검색용 아이디입니다.
     *
     * <p><b>확인 필요:</b> account 경로 응답 예시는 <code>&#64;</code>로 시작하는 채널 아이디, center 경로 응답 예시는 UUID 형식 문자열로 서로 다릅니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    /**
     * 카카오톡 채널 프로필명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 발신프로필 상태값입니다. 알려진 값은 <code>A</code>(정상)입니다.
     *
     * <p>알려진 값 <code>A</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 발신프로필 차단 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("block")
    public Boolean getBlock() {
        return block;
    }

    /**
     * 발신프로필 휴면 여부입니다. 휴면이면 휴면 해제(<code>POST /center/kakao/sender/recover</code>)로 복구합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("dormant")
    public Boolean getDormant() {
        return dormant;
    }

    /**
     * 카카오톡 채널 상태입니다.
     * <ul>
     * <li><code>A</code>: activated</li>
     * <li><code>C</code>: deactivated</li>
     * <li><code>B</code>: block</li>
     * <li><code>E</code>: deleting</li>
     * </ul>
     *
     * <p>허용 값 <code>A</code>, <code>C</code>, <code>B</code>, <code>E</code>
     *
     * <p><b>확인 필요:</b> 상태값 목록은 Copy Markdown(Part B)에만 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("profileStatus")
    public String getProfileStatus() {
        return profileStatus;
    }

    /**
     * 등록일입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * <p><b>확인 필요:</b> account 경로 응답 예시는 <code>yyyy-MM-dd HH:mm:ss</code>, center 경로 응답 예시는 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code> 형식으로 서로 다릅니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 최종 수정일입니다. 형식은 <code>createdAt</code>과 같습니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * <p><b>확인 필요:</b> createdAt과 같은 형식 불일치가 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("modifiedAt")
    public String getModifiedAt() {
        return modifiedAt;
    }

    /**
     * 발신프로필 카테고리 코드(11자리 숫자)입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categoryCode")
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 상담톡 사용 여부입니다. 조회 응답에만 있고 등록 응답에는 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizchat")
    public Boolean getBizchat() {
        return bizchat;
    }

    /**
     * 브랜드톡 사용 여부입니다. account 경로 응답에만 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandtalk")
    public Boolean getBrandtalk() {
        return brandtalk;
    }

    /**
     * 브랜드메시지 타겟팅 사용 여부입니다.
     *
     * <p><b>확인 필요:</b> account 경로 문서는 타겟팅 M·N·O, center 경로 문서는 M·N 사용 여부로 설명합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandMessage")
    public Boolean getBrandMessage() {
        return brandMessage;
    }

    /**
     * 상담톡 위탁사 이름입니다. 조회 응답에만 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("committalCompanyName")
    public String getCommittalCompanyName() {
        return committalCompanyName;
    }

    /**
     * 메시지 발송 결과 수신 채널키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("channelKey")
    public String getChannelKey() {
        return channelKey;
    }

    /**
     * 카카오톡 채널 비즈니스 인증 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("businessProfile")
    public Boolean getBusinessProfile() {
        return businessProfile;
    }

    /**
     * 비즈니스 유형입니다. 알려진 값은 <code>BUSINESS</code>입니다. account 경로 응답에만 있습니다.
     *
     * <p>알려진 값 <code>BUSINESS</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("businessType")
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 무료수신거부 전화번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("unsubscribePhoneNumber")
    public String getUnsubscribePhoneNumber() {
        return unsubscribePhoneNumber;
    }

    /**
     * 무료수신거부 인증번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("unsubscribeAuthNumber")
    public String getUnsubscribeAuthNumber() {
        return unsubscribeAuthNumber;
    }

    /**
     * 카카오톡 채널 스팸 상태입니다. 정상 / 경고제한(프로필 초기화, 상담·발송 가능) / 영구제한(상담·발송 불가)입니다. 문서 예시 값은 <code>정상</code>입니다.
     *
     * <p>알려진 값 <code>정상</code>
     *
     * <p><b>확인 필요:</b> 정상 외 상태의 실제 문자열 값이 문서에 없습니다(Part B 영문 설명만 있음).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("profileSpamLevel")
    public String getProfileSpamLevel() {
        return profileSpamLevel;
    }

    /**
     * 카카오톡 메시지 스팸 상태입니다. 정상 / 경고제한(상담·발송 가능) / 활동제한(상담 가능, 발송 불가)입니다. 문서 예시 값은 <code>정상</code>입니다.
     *
     * <p>알려진 값 <code>정상</code>
     *
     * <p><b>확인 필요:</b> 정상 외 상태의 실제 문자열 값이 문서에 없습니다(Part B 영문 설명만 있음).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("profileMessageSpamLevel")
    public String getProfileMessageSpamLevel() {
        return profileMessageSpamLevel;
    }

    /**
     * 알림톡 차단 해제 링크입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("clearBlockUrl")
    public String getClearBlockUrl() {
        return clearBlockUrl;
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
        if (!(o instanceof KakaoSenderProfile)) {
            return false;
        }
        KakaoSenderProfile other = (KakaoSenderProfile) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(uuid, other.uuid)
                && Objects.equals(name, other.name)
                && Objects.equals(status, other.status)
                && Objects.equals(block, other.block)
                && Objects.equals(dormant, other.dormant)
                && Objects.equals(profileStatus, other.profileStatus)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(modifiedAt, other.modifiedAt)
                && Objects.equals(categoryCode, other.categoryCode)
                && Objects.equals(bizchat, other.bizchat)
                && Objects.equals(brandtalk, other.brandtalk)
                && Objects.equals(brandMessage, other.brandMessage)
                && Objects.equals(committalCompanyName, other.committalCompanyName)
                && Objects.equals(channelKey, other.channelKey)
                && Objects.equals(businessProfile, other.businessProfile)
                && Objects.equals(businessType, other.businessType)
                && Objects.equals(unsubscribePhoneNumber, other.unsubscribePhoneNumber)
                && Objects.equals(unsubscribeAuthNumber, other.unsubscribeAuthNumber)
                && Objects.equals(profileSpamLevel, other.profileSpamLevel)
                && Objects.equals(profileMessageSpamLevel, other.profileMessageSpamLevel)
                && Objects.equals(clearBlockUrl, other.clearBlockUrl)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, uuid, name, status, block, dormant, profileStatus, createdAt, modifiedAt, categoryCode, bizchat, brandtalk, brandMessage, committalCompanyName, channelKey, businessProfile, businessType, unsubscribePhoneNumber, unsubscribeAuthNumber, profileSpamLevel, profileMessageSpamLevel, clearBlockUrl, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoSenderProfile{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (uuid != null) {
            joiner.add("uuid=" + io.github.icommapi.bizgo.internal.Masking.length(uuid));
        }
        if (name != null) {
            joiner.add("name=" + io.github.icommapi.bizgo.internal.Masking.length(name));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (block != null) {
            joiner.add("block=***");
        }
        if (dormant != null) {
            joiner.add("dormant=***");
        }
        if (profileStatus != null) {
            joiner.add("profileStatus=" + io.github.icommapi.bizgo.internal.Masking.length(profileStatus));
        }
        if (createdAt != null) {
            joiner.add("createdAt=" + io.github.icommapi.bizgo.internal.Masking.length(createdAt));
        }
        if (modifiedAt != null) {
            joiner.add("modifiedAt=" + io.github.icommapi.bizgo.internal.Masking.length(modifiedAt));
        }
        if (categoryCode != null) {
            joiner.add("categoryCode=" + io.github.icommapi.bizgo.internal.Masking.length(categoryCode));
        }
        if (bizchat != null) {
            joiner.add("bizchat=***");
        }
        if (brandtalk != null) {
            joiner.add("brandtalk=***");
        }
        if (brandMessage != null) {
            joiner.add("brandMessage=***");
        }
        if (committalCompanyName != null) {
            joiner.add("committalCompanyName=" + io.github.icommapi.bizgo.internal.Masking.length(committalCompanyName));
        }
        if (channelKey != null) {
            joiner.add("channelKey=" + io.github.icommapi.bizgo.internal.Masking.length(channelKey));
        }
        if (businessProfile != null) {
            joiner.add("businessProfile=***");
        }
        if (businessType != null) {
            joiner.add("businessType=" + io.github.icommapi.bizgo.internal.Masking.length(businessType));
        }
        if (unsubscribePhoneNumber != null) {
            joiner.add("unsubscribePhoneNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(unsubscribePhoneNumber));
        }
        if (unsubscribeAuthNumber != null) {
            joiner.add("unsubscribeAuthNumber=" + io.github.icommapi.bizgo.internal.Masking.length(unsubscribeAuthNumber));
        }
        if (profileSpamLevel != null) {
            joiner.add("profileSpamLevel=" + io.github.icommapi.bizgo.internal.Masking.length(profileSpamLevel));
        }
        if (profileMessageSpamLevel != null) {
            joiner.add("profileMessageSpamLevel=" + io.github.icommapi.bizgo.internal.Masking.length(profileMessageSpamLevel));
        }
        if (clearBlockUrl != null) {
            joiner.add("clearBlockUrl=" + io.github.icommapi.bizgo.internal.Masking.length(clearBlockUrl));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoSenderProfile}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String uuid;
        private String name;
        private String status;
        private Boolean block;
        private Boolean dormant;
        private String profileStatus;
        private String createdAt;
        private String modifiedAt;
        private String categoryCode;
        private Boolean bizchat;
        private Boolean brandtalk;
        private Boolean brandMessage;
        private String committalCompanyName;
        private String channelKey;
        private Boolean businessProfile;
        private String businessType;
        private String unsubscribePhoneNumber;
        private String unsubscribeAuthNumber;
        private String profileSpamLevel;
        private String profileMessageSpamLevel;
        private String clearBlockUrl;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link KakaoSenderProfile#builder()}. */
        public Builder() {
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
         * 카카오톡 채널 아이디(uuid)입니다. <code>&#64;</code>로 시작하는 카카오톡 채널 검색용 아이디입니다.
         *
         * <p><b>확인 필요:</b> account 경로 응답 예시는 <code>&#64;</code>로 시작하는 채널 아이디, center 경로 응답 예시는 UUID 형식 문자열로 서로 다릅니다.
         *
         * @param uuid the value (null clears it)
         * @return this builder
         */
        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        /**
         * 카카오톡 채널 프로필명입니다.
         *
         * @param name the value (null clears it)
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * 발신프로필 상태값입니다. 알려진 값은 <code>A</code>(정상)입니다.
         *
         * <p>알려진 값 <code>A</code>
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 발신프로필 차단 여부입니다.
         *
         * @param block the value (null clears it)
         * @return this builder
         */
        public Builder block(Boolean block) {
            this.block = block;
            return this;
        }

        /**
         * 발신프로필 휴면 여부입니다. 휴면이면 휴면 해제(<code>POST /center/kakao/sender/recover</code>)로 복구합니다.
         *
         * @param dormant the value (null clears it)
         * @return this builder
         */
        public Builder dormant(Boolean dormant) {
            this.dormant = dormant;
            return this;
        }

        /**
         * 카카오톡 채널 상태입니다.
         * <ul>
         * <li><code>A</code>: activated</li>
         * <li><code>C</code>: deactivated</li>
         * <li><code>B</code>: block</li>
         * <li><code>E</code>: deleting</li>
         * </ul>
         *
         * <p>허용 값 <code>A</code>, <code>C</code>, <code>B</code>, <code>E</code>
         *
         * <p><b>확인 필요:</b> 상태값 목록은 Copy Markdown(Part B)에만 있습니다.
         *
         * @param profileStatus the value (null clears it)
         * @return this builder
         */
        public Builder profileStatus(String profileStatus) {
            this.profileStatus = profileStatus;
            return this;
        }

        /**
         * 등록일입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * <p><b>확인 필요:</b> account 경로 응답 예시는 <code>yyyy-MM-dd HH:mm:ss</code>, center 경로 응답 예시는 <code>yyyy-MM-dd'T'HH:mm:ssXXX</code> 형식으로 서로 다릅니다.
         *
         * @param createdAt the value (null clears it)
         * @return this builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * 최종 수정일입니다. 형식은 <code>createdAt</code>과 같습니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * <p><b>확인 필요:</b> createdAt과 같은 형식 불일치가 있습니다.
         *
         * @param modifiedAt the value (null clears it)
         * @return this builder
         */
        public Builder modifiedAt(String modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        /**
         * 발신프로필 카테고리 코드(11자리 숫자)입니다.
         *
         * @param categoryCode the value (null clears it)
         * @return this builder
         */
        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        /**
         * 상담톡 사용 여부입니다. 조회 응답에만 있고 등록 응답에는 없습니다.
         *
         * @param bizchat the value (null clears it)
         * @return this builder
         */
        public Builder bizchat(Boolean bizchat) {
            this.bizchat = bizchat;
            return this;
        }

        /**
         * 브랜드톡 사용 여부입니다. account 경로 응답에만 있습니다.
         *
         * @param brandtalk the value (null clears it)
         * @return this builder
         */
        public Builder brandtalk(Boolean brandtalk) {
            this.brandtalk = brandtalk;
            return this;
        }

        /**
         * 브랜드메시지 타겟팅 사용 여부입니다.
         *
         * <p><b>확인 필요:</b> account 경로 문서는 타겟팅 M·N·O, center 경로 문서는 M·N 사용 여부로 설명합니다.
         *
         * @param brandMessage the value (null clears it)
         * @return this builder
         */
        public Builder brandMessage(Boolean brandMessage) {
            this.brandMessage = brandMessage;
            return this;
        }

        /**
         * 상담톡 위탁사 이름입니다. 조회 응답에만 있습니다.
         *
         * @param committalCompanyName the value (null clears it)
         * @return this builder
         */
        public Builder committalCompanyName(String committalCompanyName) {
            this.committalCompanyName = committalCompanyName;
            return this;
        }

        /**
         * 메시지 발송 결과 수신 채널키입니다.
         *
         * @param channelKey the value (null clears it)
         * @return this builder
         */
        public Builder channelKey(String channelKey) {
            this.channelKey = channelKey;
            return this;
        }

        /**
         * 카카오톡 채널 비즈니스 인증 여부입니다.
         *
         * @param businessProfile the value (null clears it)
         * @return this builder
         */
        public Builder businessProfile(Boolean businessProfile) {
            this.businessProfile = businessProfile;
            return this;
        }

        /**
         * 비즈니스 유형입니다. 알려진 값은 <code>BUSINESS</code>입니다. account 경로 응답에만 있습니다.
         *
         * <p>알려진 값 <code>BUSINESS</code>
         *
         * @param businessType the value (null clears it)
         * @return this builder
         */
        public Builder businessType(String businessType) {
            this.businessType = businessType;
            return this;
        }

        /**
         * 무료수신거부 전화번호입니다.
         *
         * @param unsubscribePhoneNumber the value (null clears it)
         * @return this builder
         */
        public Builder unsubscribePhoneNumber(String unsubscribePhoneNumber) {
            this.unsubscribePhoneNumber = unsubscribePhoneNumber;
            return this;
        }

        /**
         * 무료수신거부 인증번호입니다.
         *
         * @param unsubscribeAuthNumber the value (null clears it)
         * @return this builder
         */
        public Builder unsubscribeAuthNumber(String unsubscribeAuthNumber) {
            this.unsubscribeAuthNumber = unsubscribeAuthNumber;
            return this;
        }

        /**
         * 카카오톡 채널 스팸 상태입니다. 정상 / 경고제한(프로필 초기화, 상담·발송 가능) / 영구제한(상담·발송 불가)입니다. 문서 예시 값은 <code>정상</code>입니다.
         *
         * <p>알려진 값 <code>정상</code>
         *
         * <p><b>확인 필요:</b> 정상 외 상태의 실제 문자열 값이 문서에 없습니다(Part B 영문 설명만 있음).
         *
         * @param profileSpamLevel the value (null clears it)
         * @return this builder
         */
        public Builder profileSpamLevel(String profileSpamLevel) {
            this.profileSpamLevel = profileSpamLevel;
            return this;
        }

        /**
         * 카카오톡 메시지 스팸 상태입니다. 정상 / 경고제한(상담·발송 가능) / 활동제한(상담 가능, 발송 불가)입니다. 문서 예시 값은 <code>정상</code>입니다.
         *
         * <p>알려진 값 <code>정상</code>
         *
         * <p><b>확인 필요:</b> 정상 외 상태의 실제 문자열 값이 문서에 없습니다(Part B 영문 설명만 있음).
         *
         * @param profileMessageSpamLevel the value (null clears it)
         * @return this builder
         */
        public Builder profileMessageSpamLevel(String profileMessageSpamLevel) {
            this.profileMessageSpamLevel = profileMessageSpamLevel;
            return this;
        }

        /**
         * 알림톡 차단 해제 링크입니다.
         *
         * @param clearBlockUrl the value (null clears it)
         * @return this builder
         */
        public Builder clearBlockUrl(String clearBlockUrl) {
            this.clearBlockUrl = clearBlockUrl;
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
         * @return a new immutable {@code KakaoSenderProfile}
         */
        public KakaoSenderProfile build() {
            return new KakaoSenderProfile(this);
        }
    }
}
