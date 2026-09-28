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
 * 알림톡 템플릿 검수 요청 취소 본문입니다.
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
@JsonDeserialize(builder = AlimtalkTemplateInspectionCancelRequest.Builder.class)
@JsonPropertyOrder({"alimtalk"})
public final class AlimtalkTemplateInspectionCancelRequest {

    private final AlimtalkTemplateInspectionCancelRequestAlimtalk alimtalk;

    private AlimtalkTemplateInspectionCancelRequest(Builder builder) {
        this.alimtalk = builder.alimtalk;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.alimtalk = this.alimtalk;
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
    public static AlimtalkTemplateInspectionCancelRequest fromJson(String json) {
        return RequestParser.parse(json, AlimtalkTemplateInspectionCancelRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static AlimtalkTemplateInspectionCancelRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, AlimtalkTemplateInspectionCancelRequest.class);
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
     * 검수 요청 취소 대상 템플릿 정보입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("alimtalk")
    public AlimtalkTemplateInspectionCancelRequestAlimtalk getAlimtalk() {
        return alimtalk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkTemplateInspectionCancelRequest)) {
            return false;
        }
        AlimtalkTemplateInspectionCancelRequest other = (AlimtalkTemplateInspectionCancelRequest) o;
        return Objects.equals(alimtalk, other.alimtalk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alimtalk);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateInspectionCancelRequest{", "}");
        if (alimtalk != null) {
            joiner.add("alimtalk=" + alimtalk);
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateInspectionCancelRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private AlimtalkTemplateInspectionCancelRequestAlimtalk alimtalk;

        /** Creates an empty builder; same as {@link AlimtalkTemplateInspectionCancelRequest#builder()}. */
        public Builder() {
        }

        /**
         * 검수 요청 취소 대상 템플릿 정보입니다.
         *
         * <p>필수
         *
         * @param alimtalk the value (null clears it)
         * @return this builder
         */
        @JsonProperty("alimtalk")
        public Builder alimtalk(AlimtalkTemplateInspectionCancelRequestAlimtalk alimtalk) {
            this.alimtalk = alimtalk;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkTemplateInspectionCancelRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkTemplateInspectionCancelRequest build() {
            AlimtalkTemplateInspectionCancelRequest built = new AlimtalkTemplateInspectionCancelRequest(this);
            ModelValidator v = new ModelValidator("AlimtalkTemplateInspectionCancelRequest");
            v.required("alimtalk", built.alimtalk);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkTemplateInspectionCancelRequest buildUnvalidated() {
            return new AlimtalkTemplateInspectionCancelRequest(this);
        }
    }
}
