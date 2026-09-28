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
 * 알림톡 템플릿 이미지·아이템 하이라이트 이미지 업로드 결과입니다.
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
@JsonPropertyOrder({"imgUrl", "fileName"})
public final class AlimtalkTemplateImageUploadResult {

    private final String imgUrl;
    private final String fileName;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private AlimtalkTemplateImageUploadResult(
            @JsonProperty("imgUrl") String imgUrl,
            @JsonProperty("fileName") String fileName) {
        this.imgUrl = imgUrl;
        this.fileName = fileName;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private AlimtalkTemplateImageUploadResult(Builder builder) {
        this(builder.imgUrl, builder.fileName);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.imgUrl = this.imgUrl;
        builder.fileName = this.fileName;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 업로드된 이미지 URL입니다. 템플릿 등록의 <code>imgUrl</code>에 씁니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgUrl")
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 업로드된 이미지 파일 이름입니다.
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
        if (!(o instanceof AlimtalkTemplateImageUploadResult)) {
            return false;
        }
        AlimtalkTemplateImageUploadResult other = (AlimtalkTemplateImageUploadResult) o;
        return Objects.equals(imgUrl, other.imgUrl)
                && Objects.equals(fileName, other.fileName)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgUrl, fileName, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateImageUploadResult{", "}");
        if (imgUrl != null) {
            joiner.add("imgUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imgUrl));
        }
        if (fileName != null) {
            joiner.add("fileName=" + io.github.icommapi.bizgo.internal.Masking.length(fileName));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateImageUploadResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String imgUrl;
        private String fileName;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link AlimtalkTemplateImageUploadResult#builder()}. */
        public Builder() {
        }

        /**
         * 업로드된 이미지 URL입니다. 템플릿 등록의 <code>imgUrl</code>에 씁니다.
         *
         * @param imgUrl the value (null clears it)
         * @return this builder
         */
        public Builder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        /**
         * 업로드된 이미지 파일 이름입니다.
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
         * @return a new immutable {@code AlimtalkTemplateImageUploadResult}
         */
        public AlimtalkTemplateImageUploadResult build() {
            return new AlimtalkTemplateImageUploadResult(this);
        }
    }
}
