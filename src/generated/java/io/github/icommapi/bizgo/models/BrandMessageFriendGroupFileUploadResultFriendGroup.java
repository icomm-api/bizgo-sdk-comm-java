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
 * 임시 업로드 파일 정보입니다.
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
@JsonPropertyOrder({"fileKey", "expiredAt"})
public final class BrandMessageFriendGroupFileUploadResultFriendGroup {

    private final String fileKey;
    private final String expiredAt;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageFriendGroupFileUploadResultFriendGroup(
            @JsonProperty("fileKey") String fileKey,
            @JsonProperty("expiredAt") String expiredAt) {
        this.fileKey = fileKey;
        this.expiredAt = expiredAt;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageFriendGroupFileUploadResultFriendGroup(Builder builder) {
        this(builder.fileKey, builder.expiredAt);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.fileKey = this.fileKey;
        builder.expiredAt = this.expiredAt;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 친구 그룹 등록·전화번호 추가·삭제에 쓸 임시 파일 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileKey")
    public String getFileKey() {
        return fileKey;
    }

    /**
     * 파일 키 만료 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("expiredAt")
    public String getExpiredAt() {
        return expiredAt;
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
        if (!(o instanceof BrandMessageFriendGroupFileUploadResultFriendGroup)) {
            return false;
        }
        BrandMessageFriendGroupFileUploadResultFriendGroup other = (BrandMessageFriendGroupFileUploadResultFriendGroup) o;
        return Objects.equals(fileKey, other.fileKey)
                && Objects.equals(expiredAt, other.expiredAt)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileKey, expiredAt, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageFriendGroupFileUploadResultFriendGroup{", "}");
        if (fileKey != null) {
            joiner.add("fileKey=" + fileKey);
        }
        if (expiredAt != null) {
            joiner.add("expiredAt=" + io.github.icommapi.bizgo.internal.Masking.length(expiredAt));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageFriendGroupFileUploadResultFriendGroup}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String fileKey;
        private String expiredAt;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageFriendGroupFileUploadResultFriendGroup#builder()}. */
        public Builder() {
        }

        /**
         * 친구 그룹 등록·전화번호 추가·삭제에 쓸 임시 파일 키입니다.
         *
         * @param fileKey the value (null clears it)
         * @return this builder
         */
        public Builder fileKey(String fileKey) {
            this.fileKey = fileKey;
            return this;
        }

        /**
         * 파일 키 만료 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param expiredAt the value (null clears it)
         * @return this builder
         */
        public Builder expiredAt(String expiredAt) {
            this.expiredAt = expiredAt;
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
         * @return a new immutable {@code BrandMessageFriendGroupFileUploadResultFriendGroup}
         */
        public BrandMessageFriendGroupFileUploadResultFriendGroup build() {
            return new BrandMessageFriendGroupFileUploadResultFriendGroup(this);
        }
    }
}
