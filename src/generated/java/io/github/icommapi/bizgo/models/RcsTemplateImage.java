// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 템플릿 이미지 정보입니다.
 *
 * <p>Response model: unknown JSON properties are kept in {@link #getAdditionalProperties()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({"fileId", "fileName", "imageWidth", "imageHeight"})
public final class RcsTemplateImage {

    private final String fileId;
    private final String fileName;
    private final Long imageWidth;
    private final Long imageHeight;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsTemplateImage(
            @JsonProperty("fileId") String fileId,
            @JsonProperty("fileName") String fileName,
            @JsonProperty("imageWidth") Long imageWidth,
            @JsonProperty("imageHeight") Long imageHeight) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsTemplateImage(Builder builder) {
        this(builder.fileId, builder.fileName, builder.imageWidth, builder.imageHeight);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.fileId = this.fileId;
        builder.fileName = this.fileName;
        builder.imageWidth = this.imageWidth;
        builder.imageHeight = this.imageHeight;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 템플릿 파일 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileId")
    public String getFileId() {
        return fileId;
    }

    /**
     * 파일 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    /**
     * 이미지 가로 크기입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageWidth")
    public Long getImageWidth() {
        return imageWidth;
    }

    /**
     * 이미지 세로 크기입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageHeight")
    public Long getImageHeight() {
        return imageHeight;
    }

    /**
     * Properties the server sent that are not in the spec (new fields are kept instead of dropped).
     *
     * @return unmodifiable map, empty if there are none
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnySetter
    private void putAdditionalProperty(String name, Object value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateImage)) {
            return false;
        }
        RcsTemplateImage other = (RcsTemplateImage) o;
        return Objects.equals(fileId, other.fileId)
                && Objects.equals(fileName, other.fileName)
                && Objects.equals(imageWidth, other.imageWidth)
                && Objects.equals(imageHeight, other.imageHeight)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, fileName, imageWidth, imageHeight, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateImage{", "}");
        if (fileId != null) {
            joiner.add("fileId=" + io.github.icommapi.bizgo.internal.Masking.length(fileId));
        }
        if (fileName != null) {
            joiner.add("fileName=" + io.github.icommapi.bizgo.internal.Masking.length(fileName));
        }
        if (imageWidth != null) {
            joiner.add("imageWidth=***");
        }
        if (imageHeight != null) {
            joiner.add("imageHeight=***");
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateImage}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String fileId;
        private String fileName;
        private Long imageWidth;
        private Long imageHeight;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsTemplateImage#builder()}. */
        public Builder() {
        }

        /**
         * 템플릿 파일 ID입니다.
         *
         * @param fileId the value (null clears it)
         * @return this builder
         */
        public Builder fileId(String fileId) {
            this.fileId = fileId;
            return this;
        }

        /**
         * 파일 이름입니다.
         *
         * @param fileName the value (null clears it)
         * @return this builder
         */
        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /**
         * 이미지 가로 크기입니다.
         *
         * @param imageWidth the value (null clears it)
         * @return this builder
         */
        public Builder imageWidth(Long imageWidth) {
            this.imageWidth = imageWidth;
            return this;
        }

        /**
         * 이미지 세로 크기입니다.
         *
         * @param imageHeight the value (null clears it)
         * @return this builder
         */
        public Builder imageHeight(Long imageHeight) {
            this.imageHeight = imageHeight;
            return this;
        }

        /**
         * Adds a property that is not in the spec.
         *
         * @param name JSON property name
         * @param value value
         * @return this builder
         */
        public Builder additionalProperty(String name, Object value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateImage}
         */
        public RcsTemplateImage build() {
            return new RcsTemplateImage(this);
        }
    }
}
