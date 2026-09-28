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
 * 상담톡 이미지 업로드 결과입니다.
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
@JsonPropertyOrder({"imgUrl"})
public final class CounselImageUploadResult {

    private final String imgUrl;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselImageUploadResult(
            @JsonProperty("imgUrl") String imgUrl) {
        this.imgUrl = imgUrl;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselImageUploadResult(Builder builder) {
        this(builder.imgUrl);
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
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 업로드된 이미지 URL입니다. 발송 요청의 <code>attachment.image.imgUrl</code>에 넣습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgUrl")
    public String getImgUrl() {
        return imgUrl;
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
        if (!(o instanceof CounselImageUploadResult)) {
            return false;
        }
        CounselImageUploadResult other = (CounselImageUploadResult) o;
        return Objects.equals(imgUrl, other.imgUrl)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgUrl, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselImageUploadResult{", "}");
        if (imgUrl != null) {
            joiner.add("imgUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imgUrl));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselImageUploadResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String imgUrl;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselImageUploadResult#builder()}. */
        public Builder() {
        }

        /**
         * 업로드된 이미지 URL입니다. 발송 요청의 <code>attachment.image.imgUrl</code>에 넣습니다.
         *
         * @param imgUrl the value (null clears it)
         * @return this builder
         */
        public Builder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
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
         * @return a new immutable {@code CounselImageUploadResult}
         */
        public CounselImageUploadResult build() {
            return new CounselImageUploadResult(this);
        }
    }
}
