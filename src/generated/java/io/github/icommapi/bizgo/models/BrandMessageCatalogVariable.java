// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 기본형 변수 분리 방식에서 카탈로그(FG) 아이템 1개에 대한 변수입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 각 변수 객체의 내부 구조(키·값 형식)가 문서에 없습니다.
 *
 * <p>Request model: immutable, created with {@link #builder()}, validated in {@link Builder#build()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonDeserialize(builder = BrandMessageCatalogVariable.Builder.class)
@JsonPropertyOrder({"messageVariable", "commerceVariable", "imageVariable"})
public final class BrandMessageCatalogVariable {

    private final Map<String, Object> messageVariable;
    private final Map<String, Object> commerceVariable;
    private final Map<String, Object> imageVariable;

    private BrandMessageCatalogVariable(Builder builder) {
        this.messageVariable = builder.messageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.messageVariable));
        this.commerceVariable = builder.commerceVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.commerceVariable));
        this.imageVariable = builder.imageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.imageVariable));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.messageVariable = this.messageVariable;
        builder.commerceVariable = this.commerceVariable;
        builder.imageVariable = this.imageVariable;
        return builder;
    }

    /**
     * 아이템 <code>title</code>·<code>description</code>의 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messageVariable")
    public Map<String, Object> getMessageVariable() {
        return messageVariable;
    }

    /**
     * 가격 관련 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("commerceVariable")
    public Map<String, Object> getCommerceVariable() {
        return commerceVariable;
    }

    /**
     * 아이템 <code>imgUrl</code>·<code>imgLink</code>의 변수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageVariable")
    public Map<String, Object> getImageVariable() {
        return imageVariable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageCatalogVariable)) {
            return false;
        }
        BrandMessageCatalogVariable other = (BrandMessageCatalogVariable) o;
        return Objects.equals(messageVariable, other.messageVariable)
                && Objects.equals(commerceVariable, other.commerceVariable)
                && Objects.equals(imageVariable, other.imageVariable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageVariable, commerceVariable, imageVariable);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCatalogVariable{", "}");
        if (messageVariable != null) {
            joiner.add("messageVariable=***");
        }
        if (commerceVariable != null) {
            joiner.add("commerceVariable=***");
        }
        if (imageVariable != null) {
            joiner.add("imageVariable=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCatalogVariable}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Map<String, Object> messageVariable;
        private Map<String, Object> commerceVariable;
        private Map<String, Object> imageVariable;

        /** Creates an empty builder; same as {@link BrandMessageCatalogVariable#builder()}. */
        public Builder() {
        }

        /**
         * 아이템 <code>title</code>·<code>description</code>의 변수입니다.
         *
         * @param messageVariable the value (null clears it)
         * @return this builder
         */
        @JsonProperty("messageVariable")
        public Builder messageVariable(Map<String, Object> messageVariable) {
            this.messageVariable = messageVariable;
            return this;
        }

        /**
         * 가격 관련 변수입니다.
         *
         * @param commerceVariable the value (null clears it)
         * @return this builder
         */
        @JsonProperty("commerceVariable")
        public Builder commerceVariable(Map<String, Object> commerceVariable) {
            this.commerceVariable = commerceVariable;
            return this;
        }

        /**
         * 아이템 <code>imgUrl</code>·<code>imgLink</code>의 변수입니다.
         *
         * @param imageVariable the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imageVariable")
        public Builder imageVariable(Map<String, Object> imageVariable) {
            this.imageVariable = imageVariable;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageCatalogVariable}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCatalogVariable build() {
            BrandMessageCatalogVariable built = new BrandMessageCatalogVariable(this);
            ModelValidator v = new ModelValidator("BrandMessageCatalogVariable");
            v.mapValues("messageVariable", built.messageVariable, false);
            v.mapValues("commerceVariable", built.commerceVariable, false);
            v.mapValues("imageVariable", built.imageVariable, false);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCatalogVariable buildUnvalidated() {
            return new BrandMessageCatalogVariable(this);
        }
    }
}
