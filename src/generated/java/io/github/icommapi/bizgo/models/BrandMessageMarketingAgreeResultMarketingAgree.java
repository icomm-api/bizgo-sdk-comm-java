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
 * 업로드된 증적자료 정보입니다.
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
@JsonPropertyOrder({"fileKey", "fileUrl"})
public final class BrandMessageMarketingAgreeResultMarketingAgree {

    private final String fileKey;
    private final String fileUrl;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageMarketingAgreeResultMarketingAgree(
            @JsonProperty("fileKey") String fileKey,
            @JsonProperty("fileUrl") String fileUrl) {
        this.fileKey = fileKey;
        this.fileUrl = fileUrl;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageMarketingAgreeResultMarketingAgree(Builder builder) {
        this(builder.fileKey, builder.fileUrl);
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
        builder.fileUrl = this.fileUrl;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 업로드된 파일의 식별 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileKey")
    public String getFileKey() {
        return fileKey;
    }

    /**
     * 업로드된 파일의 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileUrl")
    public String getFileUrl() {
        return fileUrl;
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
        if (!(o instanceof BrandMessageMarketingAgreeResultMarketingAgree)) {
            return false;
        }
        BrandMessageMarketingAgreeResultMarketingAgree other = (BrandMessageMarketingAgreeResultMarketingAgree) o;
        return Objects.equals(fileKey, other.fileKey)
                && Objects.equals(fileUrl, other.fileUrl)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileKey, fileUrl, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageMarketingAgreeResultMarketingAgree{", "}");
        if (fileKey != null) {
            joiner.add("fileKey=" + fileKey);
        }
        if (fileUrl != null) {
            joiner.add("fileUrl=" + io.github.icommapi.bizgo.internal.Masking.length(fileUrl));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageMarketingAgreeResultMarketingAgree}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String fileKey;
        private String fileUrl;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageMarketingAgreeResultMarketingAgree#builder()}. */
        public Builder() {
        }

        /**
         * 업로드된 파일의 식별 키입니다.
         *
         * @param fileKey the value (null clears it)
         * @return this builder
         */
        public Builder fileKey(String fileKey) {
            this.fileKey = fileKey;
            return this;
        }

        /**
         * 업로드된 파일의 URL입니다.
         *
         * @param fileUrl the value (null clears it)
         * @return this builder
         */
        public Builder fileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
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
         * @return a new immutable {@code BrandMessageMarketingAgreeResultMarketingAgree}
         */
        public BrandMessageMarketingAgreeResultMarketingAgree build() {
            return new BrandMessageMarketingAgreeResultMarketingAgree(this);
        }
    }
}
