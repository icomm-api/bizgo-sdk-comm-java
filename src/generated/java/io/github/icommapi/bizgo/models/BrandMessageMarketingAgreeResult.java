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
 * 업로드 결과 데이터입니다.
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
@JsonPropertyOrder({"marketingAgree"})
public final class BrandMessageMarketingAgreeResult {

    private final BrandMessageMarketingAgreeResultMarketingAgree marketingAgree;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageMarketingAgreeResult(
            @JsonProperty("marketingAgree") BrandMessageMarketingAgreeResultMarketingAgree marketingAgree) {
        this.marketingAgree = marketingAgree;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageMarketingAgreeResult(Builder builder) {
        this(builder.marketingAgree);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.marketingAgree = this.marketingAgree;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 업로드된 증적자료 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("marketingAgree")
    public BrandMessageMarketingAgreeResultMarketingAgree getMarketingAgree() {
        return marketingAgree;
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
        if (!(o instanceof BrandMessageMarketingAgreeResult)) {
            return false;
        }
        BrandMessageMarketingAgreeResult other = (BrandMessageMarketingAgreeResult) o;
        return Objects.equals(marketingAgree, other.marketingAgree)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marketingAgree, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageMarketingAgreeResult{", "}");
        if (marketingAgree != null) {
            joiner.add("marketingAgree=" + marketingAgree);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageMarketingAgreeResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessageMarketingAgreeResultMarketingAgree marketingAgree;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageMarketingAgreeResult#builder()}. */
        public Builder() {
        }

        /**
         * 업로드된 증적자료 정보입니다.
         *
         * @param marketingAgree the value (null clears it)
         * @return this builder
         */
        public Builder marketingAgree(BrandMessageMarketingAgreeResultMarketingAgree marketingAgree) {
            this.marketingAgree = marketingAgree;
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
         * @return a new immutable {@code BrandMessageMarketingAgreeResult}
         */
        public BrandMessageMarketingAgreeResult build() {
            return new BrandMessageMarketingAgreeResult(this);
        }
    }
}
