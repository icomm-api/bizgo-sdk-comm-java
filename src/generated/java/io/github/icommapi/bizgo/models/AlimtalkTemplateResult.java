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
 * 템플릿 조회·등록·수정 응답 데이터입니다.
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
@JsonPropertyOrder({"alimtalk"})
public final class AlimtalkTemplateResult {

    private final AlimtalkTemplate alimtalk;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private AlimtalkTemplateResult(
            @JsonProperty("alimtalk") AlimtalkTemplate alimtalk) {
        this.alimtalk = alimtalk;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private AlimtalkTemplateResult(Builder builder) {
        this(builder.alimtalk);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.alimtalk = this.alimtalk;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * {@code alimtalk}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("alimtalk")
    public AlimtalkTemplate getAlimtalk() {
        return alimtalk;
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
        if (!(o instanceof AlimtalkTemplateResult)) {
            return false;
        }
        AlimtalkTemplateResult other = (AlimtalkTemplateResult) o;
        return Objects.equals(alimtalk, other.alimtalk)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alimtalk, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateResult{", "}");
        if (alimtalk != null) {
            joiner.add("alimtalk=" + alimtalk);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private AlimtalkTemplate alimtalk;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link AlimtalkTemplateResult#builder()}. */
        public Builder() {
        }

        /**
         * {@code alimtalk}.
         *
         * @param alimtalk the value (null clears it)
         * @return this builder
         */
        public Builder alimtalk(AlimtalkTemplate alimtalk) {
            this.alimtalk = alimtalk;
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
         * @return a new immutable {@code AlimtalkTemplateResult}
         */
        public AlimtalkTemplateResult build() {
            return new AlimtalkTemplateResult(this);
        }
    }
}
