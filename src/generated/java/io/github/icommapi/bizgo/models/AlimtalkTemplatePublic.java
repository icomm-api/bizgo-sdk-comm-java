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
 * 카카오가 제공하는 공용템플릿 1건입니다.
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
@JsonPropertyOrder({"templateName", "templateCode", "status", "categoryCode", "releaseDate", "previewImageUrl"})
public final class AlimtalkTemplatePublic {

    private final String templateName;
    private final String templateCode;
    private final String status;
    private final String categoryCode;
    private final String releaseDate;
    private final String previewImageUrl;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private AlimtalkTemplatePublic(
            @JsonProperty("templateName") String templateName,
            @JsonProperty("templateCode") String templateCode,
            @JsonProperty("status") String status,
            @JsonProperty("categoryCode") String categoryCode,
            @JsonProperty("releaseDate") String releaseDate,
            @JsonProperty("previewImageUrl") String previewImageUrl) {
        this.templateName = templateName;
        this.templateCode = templateCode;
        this.status = status;
        this.categoryCode = categoryCode;
        this.releaseDate = releaseDate;
        this.previewImageUrl = previewImageUrl;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private AlimtalkTemplatePublic(Builder builder) {
        this(builder.templateName, builder.templateCode, builder.status, builder.categoryCode, builder.releaseDate, builder.previewImageUrl);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.templateName = this.templateName;
        builder.templateCode = this.templateCode;
        builder.status = this.status;
        builder.categoryCode = this.categoryCode;
        builder.releaseDate = this.releaseDate;
        builder.previewImageUrl = this.previewImageUrl;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 공용 템플릿 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateName")
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 공용 템플릿 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 공용 템플릿 상태입니다. 문서 예시 값은 <code>APR</code>입니다.
     *
     * <p>알려진 값 <code>APR</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 카테고리 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categoryCode")
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 공용 템플릿 배포 일시(yyyy-MM-dd HH:mm:ss)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * 미리보기 이미지 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("previewImageUrl")
    public String getPreviewImageUrl() {
        return previewImageUrl;
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
        if (!(o instanceof AlimtalkTemplatePublic)) {
            return false;
        }
        AlimtalkTemplatePublic other = (AlimtalkTemplatePublic) o;
        return Objects.equals(templateName, other.templateName)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(status, other.status)
                && Objects.equals(categoryCode, other.categoryCode)
                && Objects.equals(releaseDate, other.releaseDate)
                && Objects.equals(previewImageUrl, other.previewImageUrl)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templateName, templateCode, status, categoryCode, releaseDate, previewImageUrl, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplatePublic{", "}");
        if (templateName != null) {
            joiner.add("templateName=" + io.github.icommapi.bizgo.internal.Masking.length(templateName));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (categoryCode != null) {
            joiner.add("categoryCode=" + io.github.icommapi.bizgo.internal.Masking.length(categoryCode));
        }
        if (releaseDate != null) {
            joiner.add("releaseDate=" + io.github.icommapi.bizgo.internal.Masking.length(releaseDate));
        }
        if (previewImageUrl != null) {
            joiner.add("previewImageUrl=" + io.github.icommapi.bizgo.internal.Masking.length(previewImageUrl));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplatePublic}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String templateName;
        private String templateCode;
        private String status;
        private String categoryCode;
        private String releaseDate;
        private String previewImageUrl;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link AlimtalkTemplatePublic#builder()}. */
        public Builder() {
        }

        /**
         * 공용 템플릿 이름입니다.
         *
         * @param templateName the value (null clears it)
         * @return this builder
         */
        public Builder templateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        /**
         * 공용 템플릿 코드입니다.
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * 공용 템플릿 상태입니다. 문서 예시 값은 <code>APR</code>입니다.
         *
         * <p>알려진 값 <code>APR</code>
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 카테고리 코드입니다.
         *
         * @param categoryCode the value (null clears it)
         * @return this builder
         */
        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        /**
         * 공용 템플릿 배포 일시(yyyy-MM-dd HH:mm:ss)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param releaseDate the value (null clears it)
         * @return this builder
         */
        public Builder releaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        /**
         * 미리보기 이미지 URL입니다.
         *
         * @param previewImageUrl the value (null clears it)
         * @return this builder
         */
        public Builder previewImageUrl(String previewImageUrl) {
            this.previewImageUrl = previewImageUrl;
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
         * @return a new immutable {@code AlimtalkTemplatePublic}
         */
        public AlimtalkTemplatePublic build() {
            return new AlimtalkTemplatePublic(this);
        }
    }
}
