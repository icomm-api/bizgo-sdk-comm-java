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
 * Plain 메시지 첨부 객체입니다. IMAGE는 <code>image</code>, VIDEO·AUDIO·FILE은 <code>file</code>을 사용합니다.
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
@JsonDeserialize(builder = CounselPlainAttachment.Builder.class)
@JsonPropertyOrder({"image", "file"})
public final class CounselPlainAttachment {

    private final CounselImage image;
    private final CounselFile file;

    private CounselPlainAttachment(Builder builder) {
        this.image = builder.image;
        this.file = builder.file;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.image = this.image;
        builder.file = this.file;
        return builder;
    }

    /**
     * {@code image}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("image")
    public CounselImage getImage() {
        return image;
    }

    /**
     * {@code file}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("file")
    public CounselFile getFile() {
        return file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselPlainAttachment)) {
            return false;
        }
        CounselPlainAttachment other = (CounselPlainAttachment) o;
        return Objects.equals(image, other.image)
                && Objects.equals(file, other.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, file);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselPlainAttachment{", "}");
        if (image != null) {
            joiner.add("image=" + image);
        }
        if (file != null) {
            joiner.add("file=" + file);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselPlainAttachment}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private CounselImage image;
        private CounselFile file;

        /** Creates an empty builder; same as {@link CounselPlainAttachment#builder()}. */
        public Builder() {
        }

        /**
         * {@code image}.
         *
         * @param image the value (null clears it)
         * @return this builder
         */
        @JsonProperty("image")
        public Builder image(CounselImage image) {
            this.image = image;
            return this;
        }

        /**
         * {@code file}.
         *
         * @param file the value (null clears it)
         * @return this builder
         */
        @JsonProperty("file")
        public Builder file(CounselFile file) {
            this.file = file;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselPlainAttachment}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselPlainAttachment build() {
            CounselPlainAttachment built = new CounselPlainAttachment(this);
            ModelValidator v = new ModelValidator("CounselPlainAttachment");
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselPlainAttachment buildUnvalidated() {
            return new CounselPlainAttachment(this);
        }
    }
}
