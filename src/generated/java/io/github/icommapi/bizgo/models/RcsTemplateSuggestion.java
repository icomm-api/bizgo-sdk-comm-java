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
 * 템플릿 버튼 액션 정의(버튼 1개)입니다.
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
@JsonDeserialize(builder = RcsTemplateSuggestion.Builder.class)
@JsonPropertyOrder({"action"})
public final class RcsTemplateSuggestion {

    private final RcsTemplateAction action;

    private RcsTemplateSuggestion(Builder builder) {
        this.action = builder.action;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.action = this.action;
        return builder;
    }

    /**
     * {@code action}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("action")
    public RcsTemplateAction getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateSuggestion)) {
            return false;
        }
        RcsTemplateSuggestion other = (RcsTemplateSuggestion) o;
        return Objects.equals(action, other.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateSuggestion{", "}");
        if (action != null) {
            joiner.add("action=" + action);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateSuggestion}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsTemplateAction action;

        /** Creates an empty builder; same as {@link RcsTemplateSuggestion#builder()}. */
        public Builder() {
        }

        /**
         * {@code action}.
         *
         * @param action the value (null clears it)
         * @return this builder
         */
        @JsonProperty("action")
        public Builder action(RcsTemplateAction action) {
            this.action = action;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateSuggestion}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateSuggestion build() {
            RcsTemplateSuggestion built = new RcsTemplateSuggestion(this);
            ModelValidator v = new ModelValidator("RcsTemplateSuggestion");
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateSuggestion buildUnvalidated() {
            return new RcsTemplateSuggestion(this);
        }
    }
}
