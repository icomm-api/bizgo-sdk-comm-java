// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 예약 수신자 추가 요청입니다.
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
@JsonDeserialize(builder = ReservationRecipientCreateRequest.Builder.class)
@JsonPropertyOrder({"destinations"})
public final class ReservationRecipientCreateRequest {

    private final List<Destination> destinations;

    private ReservationRecipientCreateRequest(Builder builder) {
        this.destinations = builder.destinations == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.destinations));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.destinations = this.destinations;
        return builder;
    }

    /**
     * Parse and validate a request written with the API field names (JSON).
     * Unknown fields are rejected so that typos fail before anything is sent.
     *
     * @param json request body, for example an example from the API reference
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static ReservationRecipientCreateRequest fromJson(String json) {
        return RequestParser.parse(json, ReservationRecipientCreateRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static ReservationRecipientCreateRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, ReservationRecipientCreateRequest.class);
    }

    /**
     * The JSON body that is sent. Contains phone numbers: do not log it.
     *
     * @return JSON with only the fields that were set
     */
    public String toJson() {
        return RequestParser.toJson(this);
    }

    /**
     * 추가할 수신자 목록입니다. 한 번에 최대 1,000건까지 추가할 수 있습니다.
     *
     * <p>필수 · 항목 수 1~1000
     *
     * @return the value, or null if not set
     */
    @JsonProperty("destinations")
    public List<Destination> getDestinations() {
        return destinations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReservationRecipientCreateRequest)) {
            return false;
        }
        ReservationRecipientCreateRequest other = (ReservationRecipientCreateRequest) o;
        return Objects.equals(destinations, other.destinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ReservationRecipientCreateRequest{", "}");
        if (destinations != null) {
            joiner.add("destinations=" + destinations);
        }
        return joiner.toString();
    }

    /** Builder for {@link ReservationRecipientCreateRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<Destination> destinations;

        /** Creates an empty builder; same as {@link ReservationRecipientCreateRequest#builder()}. */
        public Builder() {
        }

        /**
         * 추가할 수신자 목록입니다. 한 번에 최대 1,000건까지 추가할 수 있습니다.
         *
         * <p>필수 · 항목 수 1~1000
         *
         * @param destinations the value (null clears it)
         * @return this builder
         */
        @JsonProperty("destinations")
        public Builder destinations(List<Destination> destinations) {
            this.destinations = destinations;
            return this;
        }

        /**
         * Varargs form of {@link #destinations(List)}.
         *
         * @param destinations values
         * @return this builder
         */
        public Builder destinations(Destination... destinations) {
            this.destinations = destinations == null ? null : Arrays.asList(destinations);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code ReservationRecipientCreateRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public ReservationRecipientCreateRequest build() {
            ReservationRecipientCreateRequest built = new ReservationRecipientCreateRequest(this);
            ModelValidator v = new ModelValidator("ReservationRecipientCreateRequest");
            v.required("destinations", built.destinations);
            v.items("destinations", built.destinations, 1, 1000);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        ReservationRecipientCreateRequest buildUnvalidated() {
            return new ReservationRecipientCreateRequest(this);
        }
    }
}
