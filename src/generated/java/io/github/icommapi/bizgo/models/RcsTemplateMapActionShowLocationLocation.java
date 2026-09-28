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
 * 지도 위치 정보입니다.
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
@JsonDeserialize(builder = RcsTemplateMapActionShowLocationLocation.Builder.class)
@JsonPropertyOrder({"latitude", "longitude", "label", "query"})
public final class RcsTemplateMapActionShowLocationLocation {

    private final Double latitude;
    private final Double longitude;
    private final String label;
    private final String query;

    private RcsTemplateMapActionShowLocationLocation(Builder builder) {
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.label = builder.label;
        this.query = builder.query;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.label = this.label;
        builder.query = this.query;
        return builder;
    }

    /**
     * 위도입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 경도입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 라벨입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * 검색 내용입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateMapActionShowLocationLocation)) {
            return false;
        }
        RcsTemplateMapActionShowLocationLocation other = (RcsTemplateMapActionShowLocationLocation) o;
        return Objects.equals(latitude, other.latitude)
                && Objects.equals(longitude, other.longitude)
                && Objects.equals(label, other.label)
                && Objects.equals(query, other.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, label, query);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateMapActionShowLocationLocation{", "}");
        if (latitude != null) {
            joiner.add("latitude=***");
        }
        if (longitude != null) {
            joiner.add("longitude=***");
        }
        if (label != null) {
            joiner.add("label=" + io.github.icommapi.bizgo.internal.Masking.length(label));
        }
        if (query != null) {
            joiner.add("query=" + io.github.icommapi.bizgo.internal.Masking.length(query));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateMapActionShowLocationLocation}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Double latitude;
        private Double longitude;
        private String label;
        private String query;

        /** Creates an empty builder; same as {@link RcsTemplateMapActionShowLocationLocation#builder()}. */
        public Builder() {
        }

        /**
         * 위도입니다.
         *
         * <p>필수
         *
         * @param latitude the value (null clears it)
         * @return this builder
         */
        @JsonProperty("latitude")
        public Builder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * 경도입니다.
         *
         * <p>필수
         *
         * @param longitude the value (null clears it)
         * @return this builder
         */
        @JsonProperty("longitude")
        public Builder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * 라벨입니다.
         *
         * @param label the value (null clears it)
         * @return this builder
         */
        @JsonProperty("label")
        public Builder label(String label) {
            this.label = label;
            return this;
        }

        /**
         * 검색 내용입니다.
         *
         * <p>필수
         *
         * @param query the value (null clears it)
         * @return this builder
         */
        @JsonProperty("query")
        public Builder query(String query) {
            this.query = query;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateMapActionShowLocationLocation}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateMapActionShowLocationLocation build() {
            RcsTemplateMapActionShowLocationLocation built = new RcsTemplateMapActionShowLocationLocation(this);
            ModelValidator v = new ModelValidator("RcsTemplateMapActionShowLocationLocation");
            v.required("latitude", built.latitude);
            v.required("longitude", built.longitude);
            v.required("query", built.query);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateMapActionShowLocationLocation buildUnvalidated() {
            return new RcsTemplateMapActionShowLocationLocation(this);
        }
    }
}
