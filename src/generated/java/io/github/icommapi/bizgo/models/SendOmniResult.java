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
 * SendOmniResult.
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
@JsonPropertyOrder({"destinations"})
public final class SendOmniResult {

    private final List<SendDestinationResult> destinations;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private SendOmniResult(
            @JsonProperty("destinations") List<SendDestinationResult> destinations) {
        this.destinations = destinations == null ? null : Collections.unmodifiableList(new ArrayList<>(destinations));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private SendOmniResult(Builder builder) {
        this(builder.destinations);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.destinations = this.destinations;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 수신자별 접수 결과입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("destinations")
    public List<SendDestinationResult> getDestinations() {
        return destinations;
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
        if (!(o instanceof SendOmniResult)) {
            return false;
        }
        SendOmniResult other = (SendOmniResult) o;
        return Objects.equals(destinations, other.destinations)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "SendOmniResult{", "}");
        if (destinations != null) {
            joiner.add("destinations=" + destinations);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link SendOmniResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<SendDestinationResult> destinations;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link SendOmniResult#builder()}. */
        public Builder() {
        }

        /**
         * 수신자별 접수 결과입니다.
         *
         * @param destinations the value (null clears it)
         * @return this builder
         */
        public Builder destinations(List<SendDestinationResult> destinations) {
            this.destinations = destinations;
            return this;
        }

        /**
         * Varargs form of {@link #destinations(List)}.
         *
         * @param destinations values
         * @return this builder
         */
        public Builder destinations(SendDestinationResult... destinations) {
            this.destinations = destinations == null ? null : Arrays.asList(destinations);
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
         * @return a new immutable {@code SendOmniResult}
         */
        public SendOmniResult build() {
            return new SendOmniResult(this);
        }
    }
}
