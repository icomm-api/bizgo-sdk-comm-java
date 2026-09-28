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
 * 발신프로필 목록 조회(<code>GET /account/kakao/sender/profiles</code>)의 항목 1개입니다.
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
@JsonPropertyOrder({"senderKey", "senderKeyType", "channelName", "channelId", "channelKey", "categoryCode", "status", "profileStatus", "dormant", "block", "businessProfile", "businessType", "createdAt", "regDate", "updateDate"})
public final class KakaoSenderChannel {

    private final String senderKey;
    private final String senderKeyType;
    private final String channelName;
    private final String channelId;
    private final String channelKey;
    private final String categoryCode;
    private final String status;
    private final String profileStatus;
    private final Boolean dormant;
    private final Boolean block;
    private final Boolean businessProfile;
    private final String businessType;
    private final String createdAt;
    private final String regDate;
    private final String updateDate;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private KakaoSenderChannel(
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("senderKeyType") String senderKeyType,
            @JsonProperty("channelName") String channelName,
            @JsonProperty("channelId") String channelId,
            @JsonProperty("channelKey") String channelKey,
            @JsonProperty("categoryCode") String categoryCode,
            @JsonProperty("status") String status,
            @JsonProperty("profileStatus") String profileStatus,
            @JsonProperty("dormant") Boolean dormant,
            @JsonProperty("block") Boolean block,
            @JsonProperty("businessProfile") Boolean businessProfile,
            @JsonProperty("businessType") String businessType,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("regDate") String regDate,
            @JsonProperty("updateDate") String updateDate) {
        this.senderKey = senderKey;
        this.senderKeyType = senderKeyType;
        this.channelName = channelName;
        this.channelId = channelId;
        this.channelKey = channelKey;
        this.categoryCode = categoryCode;
        this.status = status;
        this.profileStatus = profileStatus;
        this.dormant = dormant;
        this.block = block;
        this.businessProfile = businessProfile;
        this.businessType = businessType;
        this.createdAt = createdAt;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private KakaoSenderChannel(Builder builder) {
        this(builder.senderKey, builder.senderKeyType, builder.channelName, builder.channelId, builder.channelKey, builder.categoryCode, builder.status, builder.profileStatus, builder.dormant, builder.block, builder.businessProfile, builder.businessType, builder.createdAt, builder.regDate, builder.updateDate);
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
        builder.senderKeyType = this.senderKeyType;
        builder.channelName = this.channelName;
        builder.channelId = this.channelId;
        builder.channelKey = this.channelKey;
        builder.categoryCode = this.categoryCode;
        builder.status = this.status;
        builder.profileStatus = this.profileStatus;
        builder.dormant = this.dormant;
        builder.block = this.block;
        builder.businessProfile = this.businessProfile;
        builder.businessType = this.businessType;
        builder.createdAt = this.createdAt;
        builder.regDate = this.regDate;
        builder.updateDate = this.updateDate;
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
     * 발신키 유형입니다. 문서 예시 값은 <code>S</code>입니다.
     *
     * <p>알려진 값 <code>S</code>
     *
     * <p><b>확인 필요:</b> 이 응답의 senderKeyType 값 목록이 문서에 없습니다(다른 API는 S: 발신프로필, G: 그룹).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKeyType")
    public String getSenderKeyType() {
        return senderKeyType;
    }

    /**
     * 카카오톡 채널 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("channelName")
    public String getChannelName() {
        return channelName;
    }

    /**
     * 카카오톡 채널 검색용 아이디입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("channelId")
    public String getChannelId() {
        return channelId;
    }

    /**
     * 카카오톡 채널 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("channelKey")
    public String getChannelKey() {
        return channelKey;
    }

    /**
     * 발신프로필 카테고리 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categoryCode")
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 발신프로필 상태입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 카카오톡 채널 프로필 상태입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("profileStatus")
    public String getProfileStatus() {
        return profileStatus;
    }

    /**
     * 휴면 상태 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("dormant")
    public Boolean getDormant() {
        return dormant;
    }

    /**
     * 차단 상태 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("block")
    public Boolean getBlock() {
        return block;
    }

    /**
     * 비즈니스 인증 채널 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("businessProfile")
    public Boolean getBusinessProfile() {
        return businessProfile;
    }

    /**
     * 비즈니스 인증 유형입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("businessType")
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 발신프로필 생성 일시(yyyy-MM-dd HH:mm:ss)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 등록 일시(yyyy-MM-dd HH:mm:ss)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("regDate")
    public String getRegDate() {
        return regDate;
    }

    /**
     * 수정 일시(yyyy-MM-dd HH:mm:ss)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("updateDate")
    public String getUpdateDate() {
        return updateDate;
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
        if (!(o instanceof KakaoSenderChannel)) {
            return false;
        }
        KakaoSenderChannel other = (KakaoSenderChannel) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(senderKeyType, other.senderKeyType)
                && Objects.equals(channelName, other.channelName)
                && Objects.equals(channelId, other.channelId)
                && Objects.equals(channelKey, other.channelKey)
                && Objects.equals(categoryCode, other.categoryCode)
                && Objects.equals(status, other.status)
                && Objects.equals(profileStatus, other.profileStatus)
                && Objects.equals(dormant, other.dormant)
                && Objects.equals(block, other.block)
                && Objects.equals(businessProfile, other.businessProfile)
                && Objects.equals(businessType, other.businessType)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(regDate, other.regDate)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, senderKeyType, channelName, channelId, channelKey, categoryCode, status, profileStatus, dormant, block, businessProfile, businessType, createdAt, regDate, updateDate, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoSenderChannel{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (senderKeyType != null) {
            joiner.add("senderKeyType=" + io.github.icommapi.bizgo.internal.Masking.length(senderKeyType));
        }
        if (channelName != null) {
            joiner.add("channelName=" + io.github.icommapi.bizgo.internal.Masking.length(channelName));
        }
        if (channelId != null) {
            joiner.add("channelId=" + io.github.icommapi.bizgo.internal.Masking.length(channelId));
        }
        if (channelKey != null) {
            joiner.add("channelKey=" + io.github.icommapi.bizgo.internal.Masking.length(channelKey));
        }
        if (categoryCode != null) {
            joiner.add("categoryCode=" + io.github.icommapi.bizgo.internal.Masking.length(categoryCode));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (profileStatus != null) {
            joiner.add("profileStatus=" + io.github.icommapi.bizgo.internal.Masking.length(profileStatus));
        }
        if (dormant != null) {
            joiner.add("dormant=***");
        }
        if (block != null) {
            joiner.add("block=***");
        }
        if (businessProfile != null) {
            joiner.add("businessProfile=***");
        }
        if (businessType != null) {
            joiner.add("businessType=" + io.github.icommapi.bizgo.internal.Masking.length(businessType));
        }
        if (createdAt != null) {
            joiner.add("createdAt=" + io.github.icommapi.bizgo.internal.Masking.length(createdAt));
        }
        if (regDate != null) {
            joiner.add("regDate=" + io.github.icommapi.bizgo.internal.Masking.length(regDate));
        }
        if (updateDate != null) {
            joiner.add("updateDate=" + io.github.icommapi.bizgo.internal.Masking.length(updateDate));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoSenderChannel}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String senderKeyType;
        private String channelName;
        private String channelId;
        private String channelKey;
        private String categoryCode;
        private String status;
        private String profileStatus;
        private Boolean dormant;
        private Boolean block;
        private Boolean businessProfile;
        private String businessType;
        private String createdAt;
        private String regDate;
        private String updateDate;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link KakaoSenderChannel#builder()}. */
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
         * 발신키 유형입니다. 문서 예시 값은 <code>S</code>입니다.
         *
         * <p>알려진 값 <code>S</code>
         *
         * <p><b>확인 필요:</b> 이 응답의 senderKeyType 값 목록이 문서에 없습니다(다른 API는 S: 발신프로필, G: 그룹).
         *
         * @param senderKeyType the value (null clears it)
         * @return this builder
         */
        public Builder senderKeyType(String senderKeyType) {
            this.senderKeyType = senderKeyType;
            return this;
        }

        /**
         * 카카오톡 채널 이름입니다.
         *
         * @param channelName the value (null clears it)
         * @return this builder
         */
        public Builder channelName(String channelName) {
            this.channelName = channelName;
            return this;
        }

        /**
         * 카카오톡 채널 검색용 아이디입니다.
         *
         * @param channelId the value (null clears it)
         * @return this builder
         */
        public Builder channelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        /**
         * 카카오톡 채널 키입니다.
         *
         * @param channelKey the value (null clears it)
         * @return this builder
         */
        public Builder channelKey(String channelKey) {
            this.channelKey = channelKey;
            return this;
        }

        /**
         * 발신프로필 카테고리 코드입니다.
         *
         * @param categoryCode the value (null clears it)
         * @return this builder
         */
        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        /**
         * 발신프로필 상태입니다.
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 카카오톡 채널 프로필 상태입니다.
         *
         * @param profileStatus the value (null clears it)
         * @return this builder
         */
        public Builder profileStatus(String profileStatus) {
            this.profileStatus = profileStatus;
            return this;
        }

        /**
         * 휴면 상태 여부입니다.
         *
         * @param dormant the value (null clears it)
         * @return this builder
         */
        public Builder dormant(Boolean dormant) {
            this.dormant = dormant;
            return this;
        }

        /**
         * 차단 상태 여부입니다.
         *
         * @param block the value (null clears it)
         * @return this builder
         */
        public Builder block(Boolean block) {
            this.block = block;
            return this;
        }

        /**
         * 비즈니스 인증 채널 여부입니다.
         *
         * @param businessProfile the value (null clears it)
         * @return this builder
         */
        public Builder businessProfile(Boolean businessProfile) {
            this.businessProfile = businessProfile;
            return this;
        }

        /**
         * 비즈니스 인증 유형입니다.
         *
         * @param businessType the value (null clears it)
         * @return this builder
         */
        public Builder businessType(String businessType) {
            this.businessType = businessType;
            return this;
        }

        /**
         * 발신프로필 생성 일시(yyyy-MM-dd HH:mm:ss)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param createdAt the value (null clears it)
         * @return this builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * 등록 일시(yyyy-MM-dd HH:mm:ss)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param regDate the value (null clears it)
         * @return this builder
         */
        public Builder regDate(String regDate) {
            this.regDate = regDate;
            return this;
        }

        /**
         * 수정 일시(yyyy-MM-dd HH:mm:ss)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param updateDate the value (null clears it)
         * @return this builder
         */
        public Builder updateDate(String updateDate) {
            this.updateDate = updateDate;
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
         * @return a new immutable {@code KakaoSenderChannel}
         */
        public KakaoSenderChannel build() {
            return new KakaoSenderChannel(this);
        }
    }
}
