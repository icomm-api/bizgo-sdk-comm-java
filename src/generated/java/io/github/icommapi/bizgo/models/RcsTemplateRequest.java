// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * RCS 템플릿 등록·수정 요청입니다.
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
@JsonDeserialize(builder = RcsTemplateRequest.Builder.class)
@JsonPropertyOrder({"rcs"})
public final class RcsTemplateRequest {

    private final RcsTemplateDefinition rcs;

    private RcsTemplateRequest(Builder builder) {
        this.rcs = builder.rcs;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.rcs = this.rcs;
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
    public static RcsTemplateRequest fromJson(String json) {
        return RequestParser.parse(json, RcsTemplateRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static RcsTemplateRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, RcsTemplateRequest.class);
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
     * {@code rcs}.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("rcs")
    public RcsTemplateDefinition getRcs() {
        return rcs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateRequest)) {
            return false;
        }
        RcsTemplateRequest other = (RcsTemplateRequest) o;
        return Objects.equals(rcs, other.rcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rcs);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateRequest{", "}");
        if (rcs != null) {
            joiner.add("rcs=" + rcs);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsTemplateDefinition rcs;

        /** Creates an empty builder; same as {@link RcsTemplateRequest#builder()}. */
        public Builder() {
        }

        /**
         * {@code rcs}.
         *
         * <p>필수
         *
         * @param rcs the value (null clears it)
         * @return this builder
         */
        @JsonProperty("rcs")
        public Builder rcs(RcsTemplateDefinition rcs) {
            this.rcs = rcs;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateRequest build() {
            RcsTemplateRequest built = new RcsTemplateRequest(this);
            ModelValidator v = new ModelValidator("RcsTemplateRequest");
            v.required("rcs", built.rcs);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateRequest buildUnvalidated() {
            return new RcsTemplateRequest(this);
        }
    }
}
