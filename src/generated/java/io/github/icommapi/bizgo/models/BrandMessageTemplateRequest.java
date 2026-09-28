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
 * 브랜드메시지 템플릿 등록·수정 요청입니다.
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
@JsonDeserialize(builder = BrandMessageTemplateRequest.Builder.class)
@JsonPropertyOrder({"brandmessage"})
public final class BrandMessageTemplateRequest {

    private final BrandMessageTemplateInput brandmessage;

    private BrandMessageTemplateRequest(Builder builder) {
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
    public static BrandMessageTemplateRequest fromJson(String json) {
        return RequestParser.parse(json, BrandMessageTemplateRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageTemplateRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, BrandMessageTemplateRequest.class);
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
     * 브랜드메시지 템플릿 정보입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandmessage")
    public BrandMessageTemplateInput getBrandmessage() {
        return brandmessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageTemplateRequest)) {
            return false;
        }
        BrandMessageTemplateRequest other = (BrandMessageTemplateRequest) o;
        return Objects.equals(brandmessage, other.brandmessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandmessage);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageTemplateRequest{", "}");
        if (brandmessage != null) {
            joiner.add("brandmessage=" + brandmessage);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageTemplateRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessageTemplateInput brandmessage;

        /** Creates an empty builder; same as {@link BrandMessageTemplateRequest#builder()}. */
        public Builder() {
        }

        /**
         * 브랜드메시지 템플릿 정보입니다.
         *
         * <p>필수
         *
         * @param brandmessage the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandmessage")
        public Builder brandmessage(BrandMessageTemplateInput brandmessage) {
            this.brandmessage = brandmessage;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageTemplateRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageTemplateRequest build() {
            BrandMessageTemplateRequest built = new BrandMessageTemplateRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageTemplateRequest");
            v.required("brandmessage", built.brandmessage);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageTemplateRequest buildUnvalidated() {
            return new BrandMessageTemplateRequest(this);
        }
    }
}
