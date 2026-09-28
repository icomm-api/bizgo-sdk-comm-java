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
 * 카카오 비즈메시지 응답 데이터입니다.
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
@JsonPropertyOrder({"categories"})
public final class KakaoCategoryListResultKakao {

    private final List<KakaoCategory> categories;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private KakaoCategoryListResultKakao(
            @JsonProperty("categories") List<KakaoCategory> categories) {
        this.categories = categories == null ? null : Collections.unmodifiableList(new ArrayList<>(categories));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private KakaoCategoryListResultKakao(Builder builder) {
        this(builder.categories);
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
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 카테고리 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categories")
    public List<KakaoCategory> getCategories() {
        return categories;
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
        if (!(o instanceof KakaoCategoryListResultKakao)) {
            return false;
        }
        KakaoCategoryListResultKakao other = (KakaoCategoryListResultKakao) o;
        return Objects.equals(categories, other.categories)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoCategoryListResultKakao{", "}");
        if (categories != null) {
            joiner.add("categories=" + categories);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoCategoryListResultKakao}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<KakaoCategory> categories;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link KakaoCategoryListResultKakao#builder()}. */
        public Builder() {
        }

        /**
         * 카테고리 목록입니다.
         *
         * @param categories the value (null clears it)
         * @return this builder
         */
        public Builder categories(List<KakaoCategory> categories) {
            this.categories = categories;
            return this;
        }

        /**
         * Varargs form of {@link #categories(List)}.
         *
         * @param categories values
         * @return this builder
         */
        public Builder categories(KakaoCategory... categories) {
            this.categories = categories == null ? null : Arrays.asList(categories);
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
         * @return a new immutable {@code KakaoCategoryListResultKakao}
         */
        public KakaoCategoryListResultKakao build() {
            return new KakaoCategoryListResultKakao(this);
        }
    }
}
