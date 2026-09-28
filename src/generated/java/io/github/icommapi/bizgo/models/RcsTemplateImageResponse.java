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
 * RcsTemplateImageResponse.
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
@JsonPropertyOrder({"common", "data"})
public final class RcsTemplateImageResponse {

    private final CommonResult common;
    private final RcsTemplateImageServiceResult data;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsTemplateImageResponse(
            @JsonProperty("common") CommonResult common,
            @JsonProperty("data") RcsTemplateImageServiceResult data) {
        this.common = common;
        this.data = data;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsTemplateImageResponse(Builder builder) {
        this(builder.common, builder.data);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.common = this.common;
        builder.data = this.data;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * {@code common}.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("common")
    public CommonResult getCommon() {
        return common;
    }

    /**
     * {@code data}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("data")
    public RcsTemplateImageServiceResult getData() {
        return data;
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
        if (!(o instanceof RcsTemplateImageResponse)) {
            return false;
        }
        RcsTemplateImageResponse other = (RcsTemplateImageResponse) o;
        return Objects.equals(common, other.common)
                && Objects.equals(data, other.data)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(common, data, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateImageResponse{", "}");
        if (common != null) {
            joiner.add("common=" + common);
        }
        if (data != null) {
            joiner.add("data=" + data);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateImageResponse}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private CommonResult common;
        private RcsTemplateImageServiceResult data;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsTemplateImageResponse#builder()}. */
        public Builder() {
        }

        /**
         * {@code common}.
         *
         * <p>필수
         *
         * @param common the value (null clears it)
         * @return this builder
         */
        public Builder common(CommonResult common) {
            this.common = common;
            return this;
        }

        /**
         * {@code data}.
         *
         * @param data the value (null clears it)
         * @return this builder
         */
        public Builder data(RcsTemplateImageServiceResult data) {
            this.data = data;
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
         * @return a new immutable {@code RcsTemplateImageResponse}
         */
        public RcsTemplateImageResponse build() {
            return new RcsTemplateImageResponse(this);
        }
    }
}
