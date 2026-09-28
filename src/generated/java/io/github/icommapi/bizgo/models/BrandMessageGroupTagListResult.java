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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 그룹태그 응답 데이터입니다.
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
@JsonPropertyOrder({"groupTags"})
public final class BrandMessageGroupTagListResult {

    private final List<BrandMessageGroupTag> groupTags;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageGroupTagListResult(
            @JsonProperty("groupTags") List<BrandMessageGroupTag> groupTags) {
        this.groupTags = groupTags == null ? null : Collections.unmodifiableList(new ArrayList<>(groupTags));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageGroupTagListResult(Builder builder) {
        this(builder.groupTags);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.groupTags = this.groupTags;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 그룹태그 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupTags")
    public List<BrandMessageGroupTag> getGroupTags() {
        return groupTags;
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
        if (!(o instanceof BrandMessageGroupTagListResult)) {
            return false;
        }
        BrandMessageGroupTagListResult other = (BrandMessageGroupTagListResult) o;
        return Objects.equals(groupTags, other.groupTags)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupTags, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageGroupTagListResult{", "}");
        if (groupTags != null) {
            joiner.add("groupTags=" + groupTags);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageGroupTagListResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<BrandMessageGroupTag> groupTags;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageGroupTagListResult#builder()}. */
        public Builder() {
        }

        /**
         * 그룹태그 목록입니다.
         *
         * @param groupTags the value (null clears it)
         * @return this builder
         */
        public Builder groupTags(List<BrandMessageGroupTag> groupTags) {
            this.groupTags = groupTags;
            return this;
        }

        /**
         * Varargs form of {@link #groupTags(List)}.
         *
         * @param groupTags values
         * @return this builder
         */
        public Builder groupTags(BrandMessageGroupTag... groupTags) {
            this.groupTags = groupTags == null ? null : Arrays.asList(groupTags);
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
         * @return a new immutable {@code BrandMessageGroupTagListResult}
         */
        public BrandMessageGroupTagListResult build() {
            return new BrandMessageGroupTagListResult(this);
        }
    }
}
