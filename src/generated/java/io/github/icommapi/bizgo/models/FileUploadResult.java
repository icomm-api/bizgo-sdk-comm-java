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
 * FileUploadResult.
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
@JsonPropertyOrder({"fileKey", "expired"})
public final class FileUploadResult {

    private final String fileKey;
    private final String expired;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private FileUploadResult(
            @JsonProperty("fileKey") String fileKey,
            @JsonProperty("expired") String expired) {
        this.fileKey = fileKey;
        this.expired = expired;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private FileUploadResult(Builder builder) {
        this(builder.fileKey, builder.expired);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.fileKey = this.fileKey;
        builder.expired = this.expired;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 업로드 후 발급된 파일 키입니다. 메시지 본문의 <code>fileKey</code>에 씁니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileKey")
    public String getFileKey() {
        return fileKey;
    }

    /**
     * 파일 키 만료 일시(ISO 8601)입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("expired")
    public String getExpired() {
        return expired;
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
        if (!(o instanceof FileUploadResult)) {
            return false;
        }
        FileUploadResult other = (FileUploadResult) o;
        return Objects.equals(fileKey, other.fileKey)
                && Objects.equals(expired, other.expired)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileKey, expired, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "FileUploadResult{", "}");
        if (fileKey != null) {
            joiner.add("fileKey=" + fileKey);
        }
        if (expired != null) {
            joiner.add("expired=" + expired);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link FileUploadResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String fileKey;
        private String expired;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link FileUploadResult#builder()}. */
        public Builder() {
        }

        /**
         * 업로드 후 발급된 파일 키입니다. 메시지 본문의 <code>fileKey</code>에 씁니다.
         *
         * @param fileKey the value (null clears it)
         * @return this builder
         */
        public Builder fileKey(String fileKey) {
            this.fileKey = fileKey;
            return this;
        }

        /**
         * 파일 키 만료 일시(ISO 8601)입니다.
         *
         * @param expired the value (null clears it)
         * @return this builder
         */
        public Builder expired(String expired) {
            this.expired = expired;
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
         * @return a new immutable {@code FileUploadResult}
         */
        public FileUploadResult build() {
            return new FileUploadResult(this);
        }
    }
}
