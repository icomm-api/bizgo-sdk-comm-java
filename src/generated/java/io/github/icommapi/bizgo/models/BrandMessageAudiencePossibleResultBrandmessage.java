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
 * 동보 발송 가능 수 결과입니다.
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
@JsonPropertyOrder({"possible"})
public final class BrandMessageAudiencePossibleResultBrandmessage {

    private final Long possible;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageAudiencePossibleResultBrandmessage(
            @JsonProperty("possible") Long possible) {
        this.possible = possible;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageAudiencePossibleResultBrandmessage(Builder builder) {
        this(builder.possible);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.possible = this.possible;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 예상 발송 수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("possible")
    public Long getPossible() {
        return possible;
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
        if (!(o instanceof BrandMessageAudiencePossibleResultBrandmessage)) {
            return false;
        }
        BrandMessageAudiencePossibleResultBrandmessage other = (BrandMessageAudiencePossibleResultBrandmessage) o;
        return Objects.equals(possible, other.possible)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(possible, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageAudiencePossibleResultBrandmessage{", "}");
        if (possible != null) {
            joiner.add("possible=***");
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageAudiencePossibleResultBrandmessage}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Long possible;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageAudiencePossibleResultBrandmessage#builder()}. */
        public Builder() {
        }

        /**
         * 예상 발송 수입니다.
         *
         * @param possible the value (null clears it)
         * @return this builder
         */
        public Builder possible(Long possible) {
            this.possible = possible;
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
         * @return a new immutable {@code BrandMessageAudiencePossibleResultBrandmessage}
         */
        public BrandMessageAudiencePossibleResultBrandmessage build() {
            return new BrandMessageAudiencePossibleResultBrandmessage(this);
        }
    }
}
