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
 * 발신프로필 그룹입니다.
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
@JsonPropertyOrder({"groupKey", "groupName"})
public final class KakaoGroup {

    private final String groupKey;
    private final String groupName;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private KakaoGroup(
            @JsonProperty("groupKey") String groupKey,
            @JsonProperty("groupName") String groupName) {
        this.groupKey = groupKey;
        this.groupName = groupName;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private KakaoGroup(Builder builder) {
        this(builder.groupKey, builder.groupName);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.groupKey = this.groupKey;
        builder.groupName = this.groupName;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 그룹 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupKey")
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * 그룹 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupName")
    public String getGroupName() {
        return groupName;
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
        if (!(o instanceof KakaoGroup)) {
            return false;
        }
        KakaoGroup other = (KakaoGroup) o;
        return Objects.equals(groupKey, other.groupKey)
                && Objects.equals(groupName, other.groupName)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupKey, groupName, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoGroup{", "}");
        if (groupKey != null) {
            joiner.add("groupKey=" + io.github.icommapi.bizgo.internal.Masking.length(groupKey));
        }
        if (groupName != null) {
            joiner.add("groupName=" + io.github.icommapi.bizgo.internal.Masking.length(groupName));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoGroup}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String groupKey;
        private String groupName;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link KakaoGroup#builder()}. */
        public Builder() {
        }

        /**
         * 그룹 키입니다.
         *
         * @param groupKey the value (null clears it)
         * @return this builder
         */
        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        /**
         * 그룹 이름입니다.
         *
         * @param groupName the value (null clears it)
         * @return this builder
         */
        public Builder groupName(String groupName) {
            this.groupName = groupName;
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
         * @return a new immutable {@code KakaoGroup}
         */
        public KakaoGroup build() {
            return new KakaoGroup(this);
        }
    }
}
