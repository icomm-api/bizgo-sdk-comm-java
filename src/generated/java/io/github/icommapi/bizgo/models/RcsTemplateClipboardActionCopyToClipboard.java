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
 * 클립보드 복사 객체입니다.
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
@JsonDeserialize(builder = RcsTemplateClipboardActionCopyToClipboard.Builder.class)
@JsonPropertyOrder({"text"})
public final class RcsTemplateClipboardActionCopyToClipboard {

    private final String text;

    private RcsTemplateClipboardActionCopyToClipboard(Builder builder) {
        this.text = builder.text;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.text = this.text;
        return builder;
    }

    /**
     * 클립보드에 복사할 텍스트입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateClipboardActionCopyToClipboard)) {
            return false;
        }
        RcsTemplateClipboardActionCopyToClipboard other = (RcsTemplateClipboardActionCopyToClipboard) o;
        return Objects.equals(text, other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateClipboardActionCopyToClipboard{", "}");
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateClipboardActionCopyToClipboard}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String text;

        /** Creates an empty builder; same as {@link RcsTemplateClipboardActionCopyToClipboard#builder()}. */
        public Builder() {
        }

        /**
         * 클립보드에 복사할 텍스트입니다.
         *
         * <p>필수
         *
         * @param text the value (null clears it)
         * @return this builder
         */
        @JsonProperty("text")
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateClipboardActionCopyToClipboard}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateClipboardActionCopyToClipboard build() {
            RcsTemplateClipboardActionCopyToClipboard built = new RcsTemplateClipboardActionCopyToClipboard(this);
            ModelValidator v = new ModelValidator("RcsTemplateClipboardActionCopyToClipboard");
            v.required("text", built.text);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateClipboardActionCopyToClipboard buildUnvalidated() {
            return new RcsTemplateClipboardActionCopyToClipboard(this);
        }
    }
}
