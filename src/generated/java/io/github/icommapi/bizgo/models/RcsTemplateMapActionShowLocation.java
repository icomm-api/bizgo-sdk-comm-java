// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 지도 위치 표시 객체입니다.
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
@JsonDeserialize(builder = RcsTemplateMapActionShowLocation.Builder.class)
@JsonPropertyOrder({"location"})
public final class RcsTemplateMapActionShowLocation {

    private final RcsTemplateMapActionShowLocationLocation location;

    private RcsTemplateMapActionShowLocation(Builder builder) {
        this.location = builder.location;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.location = this.location;
        return builder;
    }

    /**
     * 지도 위치 정보입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("location")
    public RcsTemplateMapActionShowLocationLocation getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateMapActionShowLocation)) {
            return false;
        }
        RcsTemplateMapActionShowLocation other = (RcsTemplateMapActionShowLocation) o;
        return Objects.equals(location, other.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateMapActionShowLocation{", "}");
        if (location != null) {
            joiner.add("location=" + location);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateMapActionShowLocation}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsTemplateMapActionShowLocationLocation location;

        /** Creates an empty builder; same as {@link RcsTemplateMapActionShowLocation#builder()}. */
        public Builder() {
        }

        /**
         * 지도 위치 정보입니다.
         *
         * <p>필수
         *
         * @param location the value (null clears it)
         * @return this builder
         */
        @JsonProperty("location")
        public Builder location(RcsTemplateMapActionShowLocationLocation location) {
            this.location = location;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateMapActionShowLocation}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateMapActionShowLocation build() {
            RcsTemplateMapActionShowLocation built = new RcsTemplateMapActionShowLocation(this);
            ModelValidator v = new ModelValidator("RcsTemplateMapActionShowLocation");
            v.required("location", built.location);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateMapActionShowLocation buildUnvalidated() {
            return new RcsTemplateMapActionShowLocation(this);
        }
    }
}
