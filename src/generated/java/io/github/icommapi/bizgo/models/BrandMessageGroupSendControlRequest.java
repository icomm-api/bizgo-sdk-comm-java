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
 * 동보 발송 제어(재개·중지·종료) 요청입니다.
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
@JsonDeserialize(builder = BrandMessageGroupSendControlRequest.Builder.class)
@JsonPropertyOrder({"brandmessage"})
public final class BrandMessageGroupSendControlRequest {

    private final BrandMessageGroupSendControlRequestBrandmessage brandmessage;

    private BrandMessageGroupSendControlRequest(Builder builder) {
        this.brandmessage = builder.brandmessage;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.brandmessage = this.brandmessage;
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
    public static BrandMessageGroupSendControlRequest fromJson(String json) {
        return RequestParser.parse(json, BrandMessageGroupSendControlRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageGroupSendControlRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, BrandMessageGroupSendControlRequest.class);
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
     * 동보 발송 제어 정보입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandmessage")
    public BrandMessageGroupSendControlRequestBrandmessage getBrandmessage() {
        return brandmessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageGroupSendControlRequest)) {
            return false;
        }
        BrandMessageGroupSendControlRequest other = (BrandMessageGroupSendControlRequest) o;
        return Objects.equals(brandmessage, other.brandmessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandmessage);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageGroupSendControlRequest{", "}");
        if (brandmessage != null) {
            joiner.add("brandmessage=" + brandmessage);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageGroupSendControlRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessageGroupSendControlRequestBrandmessage brandmessage;

        /** Creates an empty builder; same as {@link BrandMessageGroupSendControlRequest#builder()}. */
        public Builder() {
        }

        /**
         * 동보 발송 제어 정보입니다.
         *
         * <p>필수
         *
         * @param brandmessage the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandmessage")
        public Builder brandmessage(BrandMessageGroupSendControlRequestBrandmessage brandmessage) {
            this.brandmessage = brandmessage;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageGroupSendControlRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageGroupSendControlRequest build() {
            BrandMessageGroupSendControlRequest built = new BrandMessageGroupSendControlRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageGroupSendControlRequest");
            v.required("brandmessage", built.brandmessage);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageGroupSendControlRequest buildUnvalidated() {
            return new BrandMessageGroupSendControlRequest(this);
        }
    }
}
