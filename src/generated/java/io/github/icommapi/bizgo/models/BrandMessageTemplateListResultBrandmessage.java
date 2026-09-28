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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 브랜드메시지 템플릿 결과 영역입니다.
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
@JsonPropertyOrder({"templates"})
public final class BrandMessageTemplateListResultBrandmessage {

    private final List<BrandMessageTemplateSummary> templates;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageTemplateListResultBrandmessage(
            @JsonProperty("templates") List<BrandMessageTemplateSummary> templates) {
        this.templates = templates == null ? null : Collections.unmodifiableList(new ArrayList<>(templates));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageTemplateListResultBrandmessage(Builder builder) {
        this(builder.templates);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.templates = this.templates;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 조회한 템플릿 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templates")
    public List<BrandMessageTemplateSummary> getTemplates() {
        return templates;
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
        if (!(o instanceof BrandMessageTemplateListResultBrandmessage)) {
            return false;
        }
        BrandMessageTemplateListResultBrandmessage other = (BrandMessageTemplateListResultBrandmessage) o;
        return Objects.equals(templates, other.templates)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templates, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageTemplateListResultBrandmessage{", "}");
        if (templates != null) {
            joiner.add("templates=" + templates);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageTemplateListResultBrandmessage}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<BrandMessageTemplateSummary> templates;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageTemplateListResultBrandmessage#builder()}. */
        public Builder() {
        }

        /**
         * 조회한 템플릿 목록입니다.
         *
         * @param templates the value (null clears it)
         * @return this builder
         */
        public Builder templates(List<BrandMessageTemplateSummary> templates) {
            this.templates = templates;
            return this;
        }

        /**
         * Varargs form of {@link #templates(List)}.
         *
         * @param templates values
         * @return this builder
         */
        public Builder templates(BrandMessageTemplateSummary... templates) {
            this.templates = templates == null ? null : Arrays.asList(templates);
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
         * @return a new immutable {@code BrandMessageTemplateListResultBrandmessage}
         */
        public BrandMessageTemplateListResultBrandmessage build() {
            return new BrandMessageTemplateListResultBrandmessage(this);
        }
    }
}
