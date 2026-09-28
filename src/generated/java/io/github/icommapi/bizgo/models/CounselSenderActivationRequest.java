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
 * 상담톡 이용 활성화·비활성화 요청입니다.
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
@JsonDeserialize(builder = CounselSenderActivationRequest.Builder.class)
@JsonPropertyOrder({"cstalk"})
public final class CounselSenderActivationRequest {

    private final CounselSenderActivation cstalk;

    private CounselSenderActivationRequest(Builder builder) {
        this.cstalk = builder.cstalk;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.cstalk = this.cstalk;
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
    public static CounselSenderActivationRequest fromJson(String json) {
        return RequestParser.parse(json, CounselSenderActivationRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static CounselSenderActivationRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, CounselSenderActivationRequest.class);
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
     * {@code cstalk}.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("cstalk")
    public CounselSenderActivation getCstalk() {
        return cstalk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselSenderActivationRequest)) {
            return false;
        }
        CounselSenderActivationRequest other = (CounselSenderActivationRequest) o;
        return Objects.equals(cstalk, other.cstalk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cstalk);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselSenderActivationRequest{", "}");
        if (cstalk != null) {
            joiner.add("cstalk=" + cstalk);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselSenderActivationRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private CounselSenderActivation cstalk;

        /** Creates an empty builder; same as {@link CounselSenderActivationRequest#builder()}. */
        public Builder() {
        }

        /**
         * {@code cstalk}.
         *
         * <p>필수
         *
         * @param cstalk the value (null clears it)
         * @return this builder
         */
        @JsonProperty("cstalk")
        public Builder cstalk(CounselSenderActivation cstalk) {
            this.cstalk = cstalk;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselSenderActivationRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselSenderActivationRequest build() {
            CounselSenderActivationRequest built = new CounselSenderActivationRequest(this);
            ModelValidator v = new ModelValidator("CounselSenderActivationRequest");
            v.required("cstalk", built.cstalk);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselSenderActivationRequest buildUnvalidated() {
            return new CounselSenderActivationRequest(this);
        }
    }
}
