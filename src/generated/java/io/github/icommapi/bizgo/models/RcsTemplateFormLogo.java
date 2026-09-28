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
 * 템플릿 양식 로고 이미지 정보입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 표에는 fileId·fileUrl·fileName이 있으나 응답 예시에는 fileUrl 대신 imageWidth·imageHeight가 있습니다.
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
@JsonPropertyOrder({"fileId", "fileUrl", "fileName"})
public final class RcsTemplateFormLogo {

    private final String fileId;
    private final String fileUrl;
    private final String fileName;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsTemplateFormLogo(
            @JsonProperty("fileId") String fileId,
            @JsonProperty("fileUrl") String fileUrl,
            @JsonProperty("fileName") String fileName) {
        this.fileId = fileId;
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsTemplateFormLogo(Builder builder) {
        this(builder.fileId, builder.fileUrl, builder.fileName);
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
        builder.fileUrl = this.fileUrl;
        builder.fileName = this.fileName;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 로고 이미지 파일 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileId")
    public String getFileId() {
        return fileId;
    }

    /**
     * 로고 이미지 파일 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileUrl")
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 로고 이미지 파일 이름입니다(최대 256자).
     *
     * <p>최대 256자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
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
        if (!(o instanceof RcsTemplateFormLogo)) {
            return false;
        }
        RcsTemplateFormLogo other = (RcsTemplateFormLogo) o;
        return Objects.equals(fileId, other.fileId)
                && Objects.equals(fileUrl, other.fileUrl)
                && Objects.equals(fileName, other.fileName)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, fileUrl, fileName, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateFormLogo{", "}");
        if (fileId != null) {
            joiner.add("fileId=" + io.github.icommapi.bizgo.internal.Masking.length(fileId));
        }
        if (fileUrl != null) {
            joiner.add("fileUrl=" + io.github.icommapi.bizgo.internal.Masking.length(fileUrl));
        }
        if (fileName != null) {
            joiner.add("fileName=" + io.github.icommapi.bizgo.internal.Masking.length(fileName));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateFormLogo}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String fileId;
        private String fileUrl;
        private String fileName;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsTemplateFormLogo#builder()}. */
        public Builder() {
        }

        /**
         * 로고 이미지 파일 ID입니다.
         *
         * @param fileId the value (null clears it)
         * @return this builder
         */
        public Builder fileId(String fileId) {
            this.fileId = fileId;
            return this;
        }

        /**
         * 로고 이미지 파일 URL입니다.
         *
         * @param fileUrl the value (null clears it)
         * @return this builder
         */
        public Builder fileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        /**
         * 로고 이미지 파일 이름입니다(최대 256자).
         *
         * <p>최대 256자
         *
         * @param fileName the value (null clears it)
         * @return this builder
         */
        public Builder fileName(String fileName) {
            this.fileName = fileName;
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
         * @return a new immutable {@code RcsTemplateFormLogo}
         */
        public RcsTemplateFormLogo build() {
            return new RcsTemplateFormLogo(this);
        }
    }
}
