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
 * 버튼 액션 정의(버튼 1개)입니다.
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
@JsonDeserialize(builder = RcsSuggestion.Builder.class)
@JsonPropertyOrder({"action", "displayText"})
public final class RcsSuggestion {

    private final RcsAction action;
    private final String displayText;

    private RcsSuggestion(Builder builder) {
        this.action = builder.action;
        this.displayText = builder.displayText;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.action = this.action;
        builder.displayText = this.displayText;
        return builder;
    }

    /**
     * {@code action}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("action")
    public RcsAction getAction() {
        return action;
    }

    /**
     * 버튼 명입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("displayText")
    public String getDisplayText() {
        return displayText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsSuggestion)) {
            return false;
        }
        RcsSuggestion other = (RcsSuggestion) o;
        return Objects.equals(action, other.action)
                && Objects.equals(displayText, other.displayText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, displayText);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsSuggestion{", "}");
        if (action != null) {
            joiner.add("action=" + action);
        }
        if (displayText != null) {
            joiner.add("displayText=" + io.github.icommapi.bizgo.internal.Masking.length(displayText));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsSuggestion}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsAction action;
        private String displayText;

        /** Creates an empty builder; same as {@link RcsSuggestion#builder()}. */
        public Builder() {
        }

        /**
         * {@code action}.
         *
         * @param action the value (null clears it)
         * @return this builder
         */
        @JsonProperty("action")
        public Builder action(RcsAction action) {
            this.action = action;
            return this;
        }

        /**
         * 버튼 명입니다.
         *
         * <p>필수
         *
         * @param displayText the value (null clears it)
         * @return this builder
         */
        @JsonProperty("displayText")
        public Builder displayText(String displayText) {
            this.displayText = displayText;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsSuggestion}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsSuggestion build() {
            RcsSuggestion built = new RcsSuggestion(this);
            ModelValidator v = new ModelValidator("RcsSuggestion");
            v.required("displayText", built.displayText);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsSuggestion buildUnvalidated() {
            return new RcsSuggestion(this);
        }
    }
}
