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
 * 발신프로필·템플릿 제재 정보입니다. 제재가 적용되면 발송이 불가하거나 일부 기능이 제한될 수 있습니다.
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
@JsonPropertyOrder({"restrictedAt", "senderKey", "templateCode", "groupKey", "senderKeyType", "reasonType"})
public final class KakaoSanction {

    private final String restrictedAt;
    private final String senderKey;
    private final String templateCode;
    private final String groupKey;
    private final String senderKeyType;
    private final String reasonType;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private KakaoSanction(
            @JsonProperty("restrictedAt") String restrictedAt,
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("templateCode") String templateCode,
            @JsonProperty("groupKey") String groupKey,
            @JsonProperty("senderKeyType") String senderKeyType,
            @JsonProperty("reasonType") String reasonType) {
        this.restrictedAt = restrictedAt;
        this.senderKey = senderKey;
        this.templateCode = templateCode;
        this.groupKey = groupKey;
        this.senderKeyType = senderKeyType;
        this.reasonType = reasonType;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private KakaoSanction(Builder builder) {
        this(builder.restrictedAt, builder.senderKey, builder.templateCode, builder.groupKey, builder.senderKeyType, builder.reasonType);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.restrictedAt = this.restrictedAt;
        builder.senderKey = this.senderKey;
        builder.templateCode = this.templateCode;
        builder.groupKey = this.groupKey;
        builder.senderKeyType = this.senderKeyType;
        builder.reasonType = this.reasonType;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 제재 적용 시각(yyyy-MM-dd HH:mm:ss)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("restrictedAt")
    public String getRestrictedAt() {
        return restrictedAt;
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
     * 템플릿 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 발신프로필 그룹 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupKey")
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * 발신프로필 키 타입입니다.
     * <ul>
     * <li><code>G</code>: 그룹</li>
     * <li><code>S</code>: 발신프로필</li>
     * </ul>
     *
     * <p>허용 값 <code>G</code>, <code>S</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKeyType")
    public String getSenderKeyType() {
        return senderKeyType;
    }

    /**
     * 제재 사유입니다. 알려진 값:
     * <ul>
     * <li><code>BZM</code>: 비즈메시지 운영정책 위반(스팸/어뷰징)</li>
     * <li><code>CHANNEL</code>: 채널 운영정책 위반</li>
     * </ul>
     *
     * <p>알려진 값 <code>BZM</code>, <code>CHANNEL</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reasonType")
    public String getReasonType() {
        return reasonType;
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
        if (!(o instanceof KakaoSanction)) {
            return false;
        }
        KakaoSanction other = (KakaoSanction) o;
        return Objects.equals(restrictedAt, other.restrictedAt)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(groupKey, other.groupKey)
                && Objects.equals(senderKeyType, other.senderKeyType)
                && Objects.equals(reasonType, other.reasonType)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restrictedAt, senderKey, templateCode, groupKey, senderKeyType, reasonType, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoSanction{", "}");
        if (restrictedAt != null) {
            joiner.add("restrictedAt=" + io.github.icommapi.bizgo.internal.Masking.length(restrictedAt));
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (groupKey != null) {
            joiner.add("groupKey=" + io.github.icommapi.bizgo.internal.Masking.length(groupKey));
        }
        if (senderKeyType != null) {
            joiner.add("senderKeyType=" + io.github.icommapi.bizgo.internal.Masking.length(senderKeyType));
        }
        if (reasonType != null) {
            joiner.add("reasonType=" + io.github.icommapi.bizgo.internal.Masking.length(reasonType));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoSanction}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String restrictedAt;
        private String senderKey;
        private String templateCode;
        private String groupKey;
        private String senderKeyType;
        private String reasonType;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link KakaoSanction#builder()}. */
        public Builder() {
        }

        /**
         * 제재 적용 시각(yyyy-MM-dd HH:mm:ss)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param restrictedAt the value (null clears it)
         * @return this builder
         */
        public Builder restrictedAt(String restrictedAt) {
            this.restrictedAt = restrictedAt;
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
         * 템플릿 코드입니다.
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * 발신프로필 그룹 키입니다.
         *
         * @param groupKey the value (null clears it)
         * @return this builder
         */
        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        /**
         * 발신프로필 키 타입입니다.
         * <ul>
         * <li><code>G</code>: 그룹</li>
         * <li><code>S</code>: 발신프로필</li>
         * </ul>
         *
         * <p>허용 값 <code>G</code>, <code>S</code>
         *
         * @param senderKeyType the value (null clears it)
         * @return this builder
         */
        public Builder senderKeyType(String senderKeyType) {
            this.senderKeyType = senderKeyType;
            return this;
        }

        /**
         * 제재 사유입니다. 알려진 값:
         * <ul>
         * <li><code>BZM</code>: 비즈메시지 운영정책 위반(스팸/어뷰징)</li>
         * <li><code>CHANNEL</code>: 채널 운영정책 위반</li>
         * </ul>
         *
         * <p>알려진 값 <code>BZM</code>, <code>CHANNEL</code>
         *
         * @param reasonType the value (null clears it)
         * @return this builder
         */
        public Builder reasonType(String reasonType) {
            this.reasonType = reasonType;
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
         * @return a new immutable {@code KakaoSanction}
         */
        public KakaoSanction build() {
            return new KakaoSanction(this);
        }
    }
}
