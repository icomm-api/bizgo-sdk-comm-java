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
 * 상담톡 파일 업로드 결과입니다.
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
@JsonPropertyOrder({"fileUrl", "fileName", "size"})
public final class CounselFileUploadResult {

    private final String fileUrl;
    private final String fileName;
    private final String size;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselFileUploadResult(
            @JsonProperty("fileUrl") String fileUrl,
            @JsonProperty("fileName") String fileName,
            @JsonProperty("size") String size) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.size = size;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselFileUploadResult(Builder builder) {
        this(builder.fileUrl, builder.fileName, builder.size);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.fileUrl = this.fileUrl;
        builder.fileName = this.fileName;
        builder.size = this.size;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 업로드된 파일 URL입니다. 발송 요청의 <code>attachment.file.fileUrl</code>에 넣습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileUrl")
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 업로드된 파일 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    /**
     * 업로드된 파일 용량입니다. 문서 예시는 byte 단위 문자열(<code>102400</code>)입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("size")
    public String getSize() {
        return size;
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
        if (!(o instanceof CounselFileUploadResult)) {
            return false;
        }
        CounselFileUploadResult other = (CounselFileUploadResult) o;
        return Objects.equals(fileUrl, other.fileUrl)
                && Objects.equals(fileName, other.fileName)
                && Objects.equals(size, other.size)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileUrl, fileName, size, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselFileUploadResult{", "}");
        if (fileUrl != null) {
            joiner.add("fileUrl=" + io.github.icommapi.bizgo.internal.Masking.length(fileUrl));
        }
        if (fileName != null) {
            joiner.add("fileName=" + io.github.icommapi.bizgo.internal.Masking.length(fileName));
        }
        if (size != null) {
            joiner.add("size=" + io.github.icommapi.bizgo.internal.Masking.length(size));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselFileUploadResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String fileUrl;
        private String fileName;
        private String size;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselFileUploadResult#builder()}. */
        public Builder() {
        }

        /**
         * 업로드된 파일 URL입니다. 발송 요청의 <code>attachment.file.fileUrl</code>에 넣습니다.
         *
         * @param fileUrl the value (null clears it)
         * @return this builder
         */
        public Builder fileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        /**
         * 업로드된 파일 이름입니다.
         *
         * @param fileName the value (null clears it)
         * @return this builder
         */
        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /**
         * 업로드된 파일 용량입니다. 문서 예시는 byte 단위 문자열(<code>102400</code>)입니다.
         *
         * @param size the value (null clears it)
         * @return this builder
         */
        public Builder size(String size) {
            this.size = size;
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
         * @return a new immutable {@code CounselFileUploadResult}
         */
        public CounselFileUploadResult build() {
            return new CounselFileUploadResult(this);
        }
    }
}
