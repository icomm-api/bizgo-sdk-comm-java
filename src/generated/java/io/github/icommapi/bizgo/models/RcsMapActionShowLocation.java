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
@JsonDeserialize(builder = RcsMapActionShowLocation.Builder.class)
@JsonPropertyOrder({"location", "fallbackUrl"})
public final class RcsMapActionShowLocation {

    private final RcsLocation location;
    private final String fallbackUrl;

    private RcsMapActionShowLocation(Builder builder) {
        this.location = builder.location;
        this.fallbackUrl = builder.fallbackUrl;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.location = this.location;
        builder.fallbackUrl = this.fallbackUrl;
        return builder;
    }

    /**
     * {@code location}.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("location")
    public RcsLocation getLocation() {
        return location;
    }

    /**
     * 위치 조회 실패 시 이동할 fallback URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fallbackUrl")
    public String getFallbackUrl() {
        return fallbackUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsMapActionShowLocation)) {
            return false;
        }
        RcsMapActionShowLocation other = (RcsMapActionShowLocation) o;
        return Objects.equals(location, other.location)
                && Objects.equals(fallbackUrl, other.fallbackUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, fallbackUrl);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsMapActionShowLocation{", "}");
        if (location != null) {
            joiner.add("location=" + location);
        }
        if (fallbackUrl != null) {
            joiner.add("fallbackUrl=" + io.github.icommapi.bizgo.internal.Masking.length(fallbackUrl));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsMapActionShowLocation}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsLocation location;
        private String fallbackUrl;

        /** Creates an empty builder; same as {@link RcsMapActionShowLocation#builder()}. */
        public Builder() {
        }

        /**
         * {@code location}.
         *
         * <p>필수
         *
         * @param location the value (null clears it)
         * @return this builder
         */
        @JsonProperty("location")
        public Builder location(RcsLocation location) {
            this.location = location;
            return this;
        }

        /**
         * 위치 조회 실패 시 이동할 fallback URL입니다.
         *
         * @param fallbackUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fallbackUrl")
        public Builder fallbackUrl(String fallbackUrl) {
            this.fallbackUrl = fallbackUrl;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsMapActionShowLocation}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsMapActionShowLocation build() {
            RcsMapActionShowLocation built = new RcsMapActionShowLocation(this);
            ModelValidator v = new ModelValidator("RcsMapActionShowLocation");
            v.required("location", built.location);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsMapActionShowLocation buildUnvalidated() {
            return new RcsMapActionShowLocation(this);
        }
    }
}
