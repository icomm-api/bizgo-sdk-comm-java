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
 * 브랜드메시지 그룹태그입니다.
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
@JsonPropertyOrder({"groupTagKey", "groupTagName"})
public final class BrandMessageGroupTag {

    private final String groupTagKey;
    private final String groupTagName;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageGroupTag(
            @JsonProperty("groupTagKey") String groupTagKey,
            @JsonProperty("groupTagName") String groupTagName) {
        this.groupTagKey = groupTagKey;
        this.groupTagName = groupTagName;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageGroupTag(Builder builder) {
        this(builder.groupTagKey, builder.groupTagName);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.groupTagKey = this.groupTagKey;
        builder.groupTagName = this.groupTagName;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 그룹태그 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupTagKey")
    public String getGroupTagKey() {
        return groupTagKey;
    }

    /**
     * 그룹태그 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupTagName")
    public String getGroupTagName() {
        return groupTagName;
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
        if (!(o instanceof BrandMessageGroupTag)) {
            return false;
        }
        BrandMessageGroupTag other = (BrandMessageGroupTag) o;
        return Objects.equals(groupTagKey, other.groupTagKey)
                && Objects.equals(groupTagName, other.groupTagName)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupTagKey, groupTagName, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageGroupTag{", "}");
        if (groupTagKey != null) {
            joiner.add("groupTagKey=" + io.github.icommapi.bizgo.internal.Masking.length(groupTagKey));
        }
        if (groupTagName != null) {
            joiner.add("groupTagName=" + io.github.icommapi.bizgo.internal.Masking.length(groupTagName));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageGroupTag}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String groupTagKey;
        private String groupTagName;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageGroupTag#builder()}. */
        public Builder() {
        }

        /**
         * 그룹태그 키입니다.
         *
         * @param groupTagKey the value (null clears it)
         * @return this builder
         */
        public Builder groupTagKey(String groupTagKey) {
            this.groupTagKey = groupTagKey;
            return this;
        }

        /**
         * 그룹태그 이름입니다.
         *
         * @param groupTagName the value (null clears it)
         * @return this builder
         */
        public Builder groupTagName(String groupTagName) {
            this.groupTagName = groupTagName;
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
         * @return a new immutable {@code BrandMessageGroupTag}
         */
        public BrandMessageGroupTag build() {
            return new BrandMessageGroupTag(this);
        }
    }
}
