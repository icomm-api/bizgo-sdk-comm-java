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
 * 템플릿 카테고리 조회 응답 데이터입니다. <code>categoryCode</code> 없이 호출하면 <code>categories</code>(전체 목록), <code>categoryCode</code>를 주면 <code>category</code>(상세 1건)가 옵니다.
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
@JsonPropertyOrder({"categories", "category"})
public final class AlimtalkTemplateCategoryResult {

    private final List<AlimtalkTemplateCategory> categories;
    private final AlimtalkTemplateCategory category;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private AlimtalkTemplateCategoryResult(
            @JsonProperty("categories") List<AlimtalkTemplateCategory> categories,
            @JsonProperty("category") AlimtalkTemplateCategory category) {
        this.categories = categories == null ? null : Collections.unmodifiableList(new ArrayList<>(categories));
        this.category = category;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private AlimtalkTemplateCategoryResult(Builder builder) {
        this(builder.categories, builder.category);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.categories = this.categories;
        builder.category = this.category;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 템플릿 카테고리 목록입니다(전체 조회).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categories")
    public List<AlimtalkTemplateCategory> getCategories() {
        return categories;
    }

    /**
     * {@code category}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("category")
    public AlimtalkTemplateCategory getCategory() {
        return category;
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
        if (!(o instanceof AlimtalkTemplateCategoryResult)) {
            return false;
        }
        AlimtalkTemplateCategoryResult other = (AlimtalkTemplateCategoryResult) o;
        return Objects.equals(categories, other.categories)
                && Objects.equals(category, other.category)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories, category, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateCategoryResult{", "}");
        if (categories != null) {
            joiner.add("categories=" + categories);
        }
        if (category != null) {
            joiner.add("category=" + category);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateCategoryResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<AlimtalkTemplateCategory> categories;
        private AlimtalkTemplateCategory category;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link AlimtalkTemplateCategoryResult#builder()}. */
        public Builder() {
        }

        /**
         * 템플릿 카테고리 목록입니다(전체 조회).
         *
         * @param categories the value (null clears it)
         * @return this builder
         */
        public Builder categories(List<AlimtalkTemplateCategory> categories) {
            this.categories = categories;
            return this;
        }

        /**
         * Varargs form of {@link #categories(List)}.
         *
         * @param categories values
         * @return this builder
         */
        public Builder categories(AlimtalkTemplateCategory... categories) {
            this.categories = categories == null ? null : Arrays.asList(categories);
            return this;
        }

        /**
         * {@code category}.
         *
         * @param category the value (null clears it)
         * @return this builder
         */
        public Builder category(AlimtalkTemplateCategory category) {
            this.category = category;
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
         * @return a new immutable {@code AlimtalkTemplateCategoryResult}
         */
        public AlimtalkTemplateCategoryResult build() {
            return new AlimtalkTemplateCategoryResult(this);
        }
    }
}
