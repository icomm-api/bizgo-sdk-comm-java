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
 * 알림톡 템플릿 검수 요청 본문(JSON)입니다. 템플릿 상태가 대기이고 검수 상태가 등록(<code>REG</code>)일 때 요청할 수 있습니다.
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
@JsonDeserialize(builder = AlimtalkTemplateInspectionRequest.Builder.class)
@JsonPropertyOrder({"alimtalk"})
public final class AlimtalkTemplateInspectionRequest {

    private final AlimtalkTemplateInspectionRequestAlimtalk alimtalk;

    private AlimtalkTemplateInspectionRequest(Builder builder) {
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
    public static AlimtalkTemplateInspectionRequest fromJson(String json) {
        return RequestParser.parse(json, AlimtalkTemplateInspectionRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static AlimtalkTemplateInspectionRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, AlimtalkTemplateInspectionRequest.class);
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
     * 검수 요청할 알림톡 템플릿 정보입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("alimtalk")
    public AlimtalkTemplateInspectionRequestAlimtalk getAlimtalk() {
        return alimtalk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkTemplateInspectionRequest)) {
            return false;
        }
        AlimtalkTemplateInspectionRequest other = (AlimtalkTemplateInspectionRequest) o;
        return Objects.equals(alimtalk, other.alimtalk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alimtalk);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateInspectionRequest{", "}");
        if (alimtalk != null) {
            joiner.add("alimtalk=" + alimtalk);
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateInspectionRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private AlimtalkTemplateInspectionRequestAlimtalk alimtalk;

        /** Creates an empty builder; same as {@link AlimtalkTemplateInspectionRequest#builder()}. */
        public Builder() {
        }

        /**
         * 검수 요청할 알림톡 템플릿 정보입니다.
         *
         * <p>필수
         *
         * @param alimtalk the value (null clears it)
         * @return this builder
         */
        @JsonProperty("alimtalk")
        public Builder alimtalk(AlimtalkTemplateInspectionRequestAlimtalk alimtalk) {
            this.alimtalk = alimtalk;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkTemplateInspectionRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkTemplateInspectionRequest build() {
            AlimtalkTemplateInspectionRequest built = new AlimtalkTemplateInspectionRequest(this);
            ModelValidator v = new ModelValidator("AlimtalkTemplateInspectionRequest");
            v.required("alimtalk", built.alimtalk);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkTemplateInspectionRequest buildUnvalidated() {
            return new AlimtalkTemplateInspectionRequest(this);
        }
    }
}
