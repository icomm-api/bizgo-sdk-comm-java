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
 * RCS 응답 정보입니다.
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
@JsonPropertyOrder({"pagination", "templates"})
public final class RcsTemplateListResultRcs {

    private final RcsMessagebasePagination pagination;
    private final List<RcsTemplateSummary> templates;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsTemplateListResultRcs(
            @JsonProperty("pagination") RcsMessagebasePagination pagination,
            @JsonProperty("templates") List<RcsTemplateSummary> templates) {
        this.pagination = pagination;
        this.templates = templates == null ? null : Collections.unmodifiableList(new ArrayList<>(templates));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsTemplateListResultRcs(Builder builder) {
        this(builder.pagination, builder.templates);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.pagination = this.pagination;
        builder.templates = this.templates;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * {@code pagination}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("pagination")
    public RcsMessagebasePagination getPagination() {
        return pagination;
    }

    /**
     * 템플릿 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templates")
    public List<RcsTemplateSummary> getTemplates() {
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
        if (!(o instanceof RcsTemplateListResultRcs)) {
            return false;
        }
        RcsTemplateListResultRcs other = (RcsTemplateListResultRcs) o;
        return Objects.equals(pagination, other.pagination)
                && Objects.equals(templates, other.templates)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, templates, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateListResultRcs{", "}");
        if (pagination != null) {
            joiner.add("pagination=" + pagination);
        }
        if (templates != null) {
            joiner.add("templates=" + templates);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateListResultRcs}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsMessagebasePagination pagination;
        private List<RcsTemplateSummary> templates;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsTemplateListResultRcs#builder()}. */
        public Builder() {
        }

        /**
         * {@code pagination}.
         *
         * @param pagination the value (null clears it)
         * @return this builder
         */
        public Builder pagination(RcsMessagebasePagination pagination) {
            this.pagination = pagination;
            return this;
        }

        /**
         * 템플릿 목록입니다.
         *
         * @param templates the value (null clears it)
         * @return this builder
         */
        public Builder templates(List<RcsTemplateSummary> templates) {
            this.templates = templates;
            return this;
        }

        /**
         * Varargs form of {@link #templates(List)}.
         *
         * @param templates values
         * @return this builder
         */
        public Builder templates(RcsTemplateSummary... templates) {
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
         * @return a new immutable {@code RcsTemplateListResultRcs}
         */
        public RcsTemplateListResultRcs build() {
            return new RcsTemplateListResultRcs(this);
        }
    }
}
