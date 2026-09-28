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
 * 동보 발송 예상 시간 결과입니다.
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
@JsonPropertyOrder({"estimatedFinishedAt", "duration"})
public final class BrandMessageAudienceEstimateResultBrandmessage {

    private final String estimatedFinishedAt;
    private final Long duration;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageAudienceEstimateResultBrandmessage(
            @JsonProperty("estimatedFinishedAt") String estimatedFinishedAt,
            @JsonProperty("duration") Long duration) {
        this.estimatedFinishedAt = estimatedFinishedAt;
        this.duration = duration;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageAudienceEstimateResultBrandmessage(Builder builder) {
        this(builder.estimatedFinishedAt, builder.duration);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.estimatedFinishedAt = this.estimatedFinishedAt;
        builder.duration = this.duration;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 예상 종료 시각(<code>yyyy-MM-dd'T'HH:mm:ss</code>, KST)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("estimatedFinishedAt")
    public String getEstimatedFinishedAt() {
        return estimatedFinishedAt;
    }

    /**
     * 예상 소요 시간(분)입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("duration")
    public Long getDuration() {
        return duration;
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
        if (!(o instanceof BrandMessageAudienceEstimateResultBrandmessage)) {
            return false;
        }
        BrandMessageAudienceEstimateResultBrandmessage other = (BrandMessageAudienceEstimateResultBrandmessage) o;
        return Objects.equals(estimatedFinishedAt, other.estimatedFinishedAt)
                && Objects.equals(duration, other.duration)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estimatedFinishedAt, duration, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageAudienceEstimateResultBrandmessage{", "}");
        if (estimatedFinishedAt != null) {
            joiner.add("estimatedFinishedAt=" + io.github.icommapi.bizgo.internal.Masking.length(estimatedFinishedAt));
        }
        if (duration != null) {
            joiner.add("duration=***");
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageAudienceEstimateResultBrandmessage}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String estimatedFinishedAt;
        private Long duration;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageAudienceEstimateResultBrandmessage#builder()}. */
        public Builder() {
        }

        /**
         * 예상 종료 시각(<code>yyyy-MM-dd'T'HH:mm:ss</code>, KST)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
         *
         * @param estimatedFinishedAt the value (null clears it)
         * @return this builder
         */
        public Builder estimatedFinishedAt(String estimatedFinishedAt) {
            this.estimatedFinishedAt = estimatedFinishedAt;
            return this;
        }

        /**
         * 예상 소요 시간(분)입니다.
         *
         * @param duration the value (null clears it)
         * @return this builder
         */
        public Builder duration(Long duration) {
            this.duration = duration;
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
         * @return a new immutable {@code BrandMessageAudienceEstimateResultBrandmessage}
         */
        public BrandMessageAudienceEstimateResultBrandmessage build() {
            return new BrandMessageAudienceEstimateResultBrandmessage(this);
        }
    }
}
