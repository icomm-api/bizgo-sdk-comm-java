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
 * 클립보드 복사 액션입니다.
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
@JsonDeserialize(builder = RcsTemplateClipboardAction.Builder.class)
@JsonPropertyOrder({"copyToClipboard"})
public final class RcsTemplateClipboardAction {

    private final RcsTemplateClipboardActionCopyToClipboard copyToClipboard;

    private RcsTemplateClipboardAction(Builder builder) {
        this.copyToClipboard = builder.copyToClipboard;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.copyToClipboard = this.copyToClipboard;
        return builder;
    }

    /**
     * 클립보드 복사 객체입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("copyToClipboard")
    public RcsTemplateClipboardActionCopyToClipboard getCopyToClipboard() {
        return copyToClipboard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateClipboardAction)) {
            return false;
        }
        RcsTemplateClipboardAction other = (RcsTemplateClipboardAction) o;
        return Objects.equals(copyToClipboard, other.copyToClipboard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(copyToClipboard);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateClipboardAction{", "}");
        if (copyToClipboard != null) {
            joiner.add("copyToClipboard=" + copyToClipboard);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateClipboardAction}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsTemplateClipboardActionCopyToClipboard copyToClipboard;

        /** Creates an empty builder; same as {@link RcsTemplateClipboardAction#builder()}. */
        public Builder() {
        }

        /**
         * 클립보드 복사 객체입니다.
         *
         * <p>필수
         *
         * @param copyToClipboard the value (null clears it)
         * @return this builder
         */
        @JsonProperty("copyToClipboard")
        public Builder copyToClipboard(RcsTemplateClipboardActionCopyToClipboard copyToClipboard) {
            this.copyToClipboard = copyToClipboard;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateClipboardAction}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateClipboardAction build() {
            RcsTemplateClipboardAction built = new RcsTemplateClipboardAction(this);
            ModelValidator v = new ModelValidator("RcsTemplateClipboardAction");
            v.required("copyToClipboard", built.copyToClipboard);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateClipboardAction buildUnvalidated() {
            return new RcsTemplateClipboardAction(this);
        }
    }
}
