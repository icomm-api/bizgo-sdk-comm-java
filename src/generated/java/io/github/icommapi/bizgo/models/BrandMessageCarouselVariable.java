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
 * 기본형 변수 분리 방식에서 캐러셀 아이템 1개에 대한 변수입니다(FC, FA).
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
@JsonDeserialize(builder = BrandMessageCarouselVariable.Builder.class)
@JsonPropertyOrder({"messageVariable", "buttonVariable", "couponVariable", "imageVariable", "commerceVariable"})
public final class BrandMessageCarouselVariable {

    private final Map<String, Object> messageVariable;
    private final Map<String, Object> buttonVariable;
    private final Map<String, Object> couponVariable;
    private final Map<String, Object> imageVariable;
    private final Map<String, Object> commerceVariable;

    private BrandMessageCarouselVariable(Builder builder) {
        this.messageVariable = builder.messageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.messageVariable));
        this.buttonVariable = builder.buttonVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.buttonVariable));
        this.couponVariable = builder.couponVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.couponVariable));
        this.imageVariable = builder.imageVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.imageVariable));
        this.commerceVariable = builder.commerceVariable == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.commerceVariable));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.messageVariable = this.messageVariable;
        builder.buttonVariable = this.buttonVariable;
        builder.couponVariable = this.couponVariable;
        builder.imageVariable = this.imageVariable;
        builder.commerceVariable = this.commerceVariable;
        return builder;
    }

    /**
     * 캐러셀 메시지 영역 변수입니다. FC, FA 캐러셀 리스트에서 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messageVariable")
    public Map<String, Object> getMessageVariable() {
        return messageVariable;
    }

    /**
     * 캐러셀 버튼 영역 변수입니다. FC, FA 타입에서 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttonVariable")
    public Map<String, Object> getButtonVariable() {
        return buttonVariable;
    }

    /**
     * 캐러셀 쿠폰 영역 변수입니다. FC, FA 캐러셀 리스트에서 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("couponVariable")
    public Map<String, Object> getCouponVariable() {
        return couponVariable;
    }

    /**
     * 캐러셀 이미지 영역 변수입니다. FC, FA 캐러셀 리스트에서 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageVariable")
    public Map<String, Object> getImageVariable() {
        return imageVariable;
    }

    /**
     * 캐러셀 커머스 영역 변수입니다. FA 캐러셀 리스트에서 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("commerceVariable")
    public Map<String, Object> getCommerceVariable() {
        return commerceVariable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageCarouselVariable)) {
            return false;
        }
        BrandMessageCarouselVariable other = (BrandMessageCarouselVariable) o;
        return Objects.equals(messageVariable, other.messageVariable)
                && Objects.equals(buttonVariable, other.buttonVariable)
                && Objects.equals(couponVariable, other.couponVariable)
                && Objects.equals(imageVariable, other.imageVariable)
                && Objects.equals(commerceVariable, other.commerceVariable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageVariable, buttonVariable, couponVariable, imageVariable, commerceVariable);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCarouselVariable{", "}");
        if (messageVariable != null) {
            joiner.add("messageVariable=***");
        }
        if (buttonVariable != null) {
            joiner.add("buttonVariable=***");
        }
        if (couponVariable != null) {
            joiner.add("couponVariable=***");
        }
        if (imageVariable != null) {
            joiner.add("imageVariable=***");
        }
        if (commerceVariable != null) {
            joiner.add("commerceVariable=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCarouselVariable}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Map<String, Object> messageVariable;
        private Map<String, Object> buttonVariable;
        private Map<String, Object> couponVariable;
        private Map<String, Object> imageVariable;
        private Map<String, Object> commerceVariable;

        /** Creates an empty builder; same as {@link BrandMessageCarouselVariable#builder()}. */
        public Builder() {
        }

        /**
         * 캐러셀 메시지 영역 변수입니다. FC, FA 캐러셀 리스트에서 사용합니다.
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
         * 캐러셀 버튼 영역 변수입니다. FC, FA 타입에서 사용합니다.
         *
         * @param buttonVariable the value (null clears it)
         * @return this builder
         */
        @JsonProperty("buttonVariable")
        public Builder buttonVariable(Map<String, Object> buttonVariable) {
            this.buttonVariable = buttonVariable;
            return this;
        }

        /**
         * 캐러셀 쿠폰 영역 변수입니다. FC, FA 캐러셀 리스트에서 사용합니다.
         *
         * @param couponVariable the value (null clears it)
         * @return this builder
         */
        @JsonProperty("couponVariable")
        public Builder couponVariable(Map<String, Object> couponVariable) {
            this.couponVariable = couponVariable;
            return this;
        }

        /**
         * 캐러셀 이미지 영역 변수입니다. FC, FA 캐러셀 리스트에서 사용합니다.
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
         * 캐러셀 커머스 영역 변수입니다. FA 캐러셀 리스트에서 사용합니다.
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
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageCarouselVariable}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCarouselVariable build() {
            BrandMessageCarouselVariable built = new BrandMessageCarouselVariable(this);
            ModelValidator v = new ModelValidator("BrandMessageCarouselVariable");
            v.mapValues("messageVariable", built.messageVariable, false);
            v.mapValues("buttonVariable", built.buttonVariable, false);
            v.mapValues("couponVariable", built.couponVariable, false);
            v.mapValues("imageVariable", built.imageVariable, false);
            v.mapValues("commerceVariable", built.commerceVariable, false);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCarouselVariable buildUnvalidated() {
            return new BrandMessageCarouselVariable(this);
        }
    }
}
