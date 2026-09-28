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
import java.util.Objects;
import java.util.StringJoiner;

/**
 * RCS 버튼입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> buttons 개수와 suggestions 개수 제한이 문서화되어 있지 않습니다.
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
@JsonDeserialize(builder = RcsButton.Builder.class)
@JsonPropertyOrder({"suggestions"})
public final class RcsButton {

    private final List<RcsSuggestion> suggestions;

    private RcsButton(Builder builder) {
        this.suggestions = builder.suggestions == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.suggestions));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.suggestions = this.suggestions;
        return builder;
    }

    /**
     * 버튼 액션 정의 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("suggestions")
    public List<RcsSuggestion> getSuggestions() {
        return suggestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsButton)) {
            return false;
        }
        RcsButton other = (RcsButton) o;
        return Objects.equals(suggestions, other.suggestions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suggestions);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsButton{", "}");
        if (suggestions != null) {
            joiner.add("suggestions=" + suggestions);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsButton}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<RcsSuggestion> suggestions;

        /** Creates an empty builder; same as {@link RcsButton#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 액션 정의 목록입니다.
         *
         * @param suggestions the value (null clears it)
         * @return this builder
         */
        @JsonProperty("suggestions")
        public Builder suggestions(List<RcsSuggestion> suggestions) {
            this.suggestions = suggestions;
            return this;
        }

        /**
         * Varargs form of {@link #suggestions(List)}.
         *
         * @param suggestions values
         * @return this builder
         */
        public Builder suggestions(RcsSuggestion... suggestions) {
            this.suggestions = suggestions == null ? null : Arrays.asList(suggestions);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsButton}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsButton build() {
            RcsButton built = new RcsButton(this);
            ModelValidator v = new ModelValidator("RcsButton");
            v.items("suggestions", built.suggestions, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsButton buildUnvalidated() {
            return new RcsButton(this);
        }
    }
}
