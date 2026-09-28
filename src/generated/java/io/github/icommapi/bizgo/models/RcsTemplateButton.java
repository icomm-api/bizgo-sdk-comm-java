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
 * 템플릿 버튼 정의입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> buttons·suggestions 개수 제한이 문서화되어 있지 않습니다(양식별 policyInfo.maxButtonCount 참고).
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
@JsonDeserialize(builder = RcsTemplateButton.Builder.class)
@JsonPropertyOrder({"suggestions"})
public final class RcsTemplateButton {

    private final List<RcsTemplateSuggestion> suggestions;

    private RcsTemplateButton(Builder builder) {
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
     * 버튼 액션 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("suggestions")
    public List<RcsTemplateSuggestion> getSuggestions() {
        return suggestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateButton)) {
            return false;
        }
        RcsTemplateButton other = (RcsTemplateButton) o;
        return Objects.equals(suggestions, other.suggestions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suggestions);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateButton{", "}");
        if (suggestions != null) {
            joiner.add("suggestions=" + suggestions);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateButton}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<RcsTemplateSuggestion> suggestions;

        /** Creates an empty builder; same as {@link RcsTemplateButton#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 액션 목록입니다.
         *
         * @param suggestions the value (null clears it)
         * @return this builder
         */
        @JsonProperty("suggestions")
        public Builder suggestions(List<RcsTemplateSuggestion> suggestions) {
            this.suggestions = suggestions;
            return this;
        }

        /**
         * Varargs form of {@link #suggestions(List)}.
         *
         * @param suggestions values
         * @return this builder
         */
        public Builder suggestions(RcsTemplateSuggestion... suggestions) {
            this.suggestions = suggestions == null ? null : Arrays.asList(suggestions);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateButton}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateButton build() {
            RcsTemplateButton built = new RcsTemplateButton(this);
            ModelValidator v = new ModelValidator("RcsTemplateButton");
            v.items("suggestions", built.suggestions, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateButton buildUnvalidated() {
            return new RcsTemplateButton(this);
        }
    }
}
