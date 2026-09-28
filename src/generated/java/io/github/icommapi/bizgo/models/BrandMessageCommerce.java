// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 브랜드메시지 커머스 요소입니다(FM, 캐러셀 커머스 FA).
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
@JsonDeserialize(builder = BrandMessageCommerce.Builder.class)
@JsonPropertyOrder({"title", "regularPrice", "discountPrice", "discountRate", "discountFixed", "regularPriceName", "discountPriceName", "discountRateName", "discountFixedName"})
public final class BrandMessageCommerce {

    private final String title;
    private final Integer regularPrice;
    private final Integer discountPrice;
    private final Integer discountRate;
    private final Integer discountFixed;
    private final String regularPriceName;
    private final String discountPriceName;
    private final String discountRateName;
    private final String discountFixedName;

    private BrandMessageCommerce(Builder builder) {
        this.title = builder.title;
        this.regularPrice = builder.regularPrice;
        this.discountPrice = builder.discountPrice;
        this.discountRate = builder.discountRate;
        this.discountFixed = builder.discountFixed;
        this.regularPriceName = builder.regularPriceName;
        this.discountPriceName = builder.discountPriceName;
        this.discountRateName = builder.discountRateName;
        this.discountFixedName = builder.discountFixedName;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.title = this.title;
        builder.regularPrice = this.regularPrice;
        builder.discountPrice = this.discountPrice;
        builder.discountRate = this.discountRate;
        builder.discountFixed = this.discountFixed;
        builder.regularPriceName = this.regularPriceName;
        builder.discountPriceName = this.discountPriceName;
        builder.discountRateName = this.discountRateName;
        builder.discountFixedName = this.discountFixedName;
        return builder;
    }

    /**
     * 상품명입니다. 최대 30자입니다.
     *
     * <p>필수 · 최대 30자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 정가입니다. 0~99,999,999입니다.
     *
     * <p>필수 · 범위 0~99999999
     *
     * @return the value, or null if not set
     */
    @JsonProperty("regularPrice")
    public Integer getRegularPrice() {
        return regularPrice;
    }

    /**
     * 할인가입니다. 0~99,999,999입니다.
     *
     * <p>범위 0~99999999
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountPrice")
    public Integer getDiscountPrice() {
        return discountPrice;
    }

    /**
     * 할인율(%)입니다. <code>discountPrice</code>와 함께 씁니다. 허용 범위는 1~100입니다. 2026년 8월 4일부터 <code>0</code>이면 템플릿 등록·발송 요청이 실패하므로, 할인율을 쓰지 않을 때는 <code>0</code> 대신 <code>null</code>로 보냅니다.
     *
     * <p>범위 1~100
     *
     * <p><b>확인 필요:</b> Part B 필드 표는 0~100으로 적혀 있으나 Part A 안내(1~100, 0 금지)를 따릅니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountRate")
    public Integer getDiscountRate() {
        return discountRate;
    }

    /**
     * 정액 할인금액입니다. <code>discountPrice</code>와 함께 씁니다. 0~999,999입니다.
     *
     * <p>범위 0~999999
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountFixed")
    public Integer getDiscountFixed() {
        return discountFixed;
    }

    /**
     * 정상 가격명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("regularPriceName")
    public String getRegularPriceName() {
        return regularPriceName;
    }

    /**
     * 할인 후 가격명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountPriceName")
    public String getDiscountPriceName() {
        return discountPriceName;
    }

    /**
     * 할인율명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountRateName")
    public String getDiscountRateName() {
        return discountRateName;
    }

    /**
     * 정액 할인금액명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountFixedName")
    public String getDiscountFixedName() {
        return discountFixedName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageCommerce)) {
            return false;
        }
        BrandMessageCommerce other = (BrandMessageCommerce) o;
        return Objects.equals(title, other.title)
                && Objects.equals(regularPrice, other.regularPrice)
                && Objects.equals(discountPrice, other.discountPrice)
                && Objects.equals(discountRate, other.discountRate)
                && Objects.equals(discountFixed, other.discountFixed)
                && Objects.equals(regularPriceName, other.regularPriceName)
                && Objects.equals(discountPriceName, other.discountPriceName)
                && Objects.equals(discountRateName, other.discountRateName)
                && Objects.equals(discountFixedName, other.discountFixedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, regularPrice, discountPrice, discountRate, discountFixed, regularPriceName, discountPriceName, discountRateName, discountFixedName);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCommerce{", "}");
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (regularPrice != null) {
            joiner.add("regularPrice=***");
        }
        if (discountPrice != null) {
            joiner.add("discountPrice=***");
        }
        if (discountRate != null) {
            joiner.add("discountRate=***");
        }
        if (discountFixed != null) {
            joiner.add("discountFixed=***");
        }
        if (regularPriceName != null) {
            joiner.add("regularPriceName=" + io.github.icommapi.bizgo.internal.Masking.length(regularPriceName));
        }
        if (discountPriceName != null) {
            joiner.add("discountPriceName=" + io.github.icommapi.bizgo.internal.Masking.length(discountPriceName));
        }
        if (discountRateName != null) {
            joiner.add("discountRateName=" + io.github.icommapi.bizgo.internal.Masking.length(discountRateName));
        }
        if (discountFixedName != null) {
            joiner.add("discountFixedName=" + io.github.icommapi.bizgo.internal.Masking.length(discountFixedName));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCommerce}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String title;
        private Integer regularPrice;
        private Integer discountPrice;
        private Integer discountRate;
        private Integer discountFixed;
        private String regularPriceName;
        private String discountPriceName;
        private String discountRateName;
        private String discountFixedName;

        /** Creates an empty builder; same as {@link BrandMessageCommerce#builder()}. */
        public Builder() {
        }

        /**
         * 상품명입니다. 최대 30자입니다.
         *
         * <p>필수 · 최대 30자
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        @JsonProperty("title")
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 정가입니다. 0~99,999,999입니다.
         *
         * <p>필수 · 범위 0~99999999
         *
         * @param regularPrice the value (null clears it)
         * @return this builder
         */
        @JsonProperty("regularPrice")
        public Builder regularPrice(Integer regularPrice) {
            this.regularPrice = regularPrice;
            return this;
        }

        /**
         * 할인가입니다. 0~99,999,999입니다.
         *
         * <p>범위 0~99999999
         *
         * @param discountPrice the value (null clears it)
         * @return this builder
         */
        @JsonProperty("discountPrice")
        public Builder discountPrice(Integer discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }

        /**
         * 할인율(%)입니다. <code>discountPrice</code>와 함께 씁니다. 허용 범위는 1~100입니다. 2026년 8월 4일부터 <code>0</code>이면 템플릿 등록·발송 요청이 실패하므로, 할인율을 쓰지 않을 때는 <code>0</code> 대신 <code>null</code>로 보냅니다.
         *
         * <p>범위 1~100
         *
         * <p><b>확인 필요:</b> Part B 필드 표는 0~100으로 적혀 있으나 Part A 안내(1~100, 0 금지)를 따릅니다.
         *
         * @param discountRate the value (null clears it)
         * @return this builder
         */
        @JsonProperty("discountRate")
        public Builder discountRate(Integer discountRate) {
            this.discountRate = discountRate;
            return this;
        }

        /**
         * 정액 할인금액입니다. <code>discountPrice</code>와 함께 씁니다. 0~999,999입니다.
         *
         * <p>범위 0~999999
         *
         * @param discountFixed the value (null clears it)
         * @return this builder
         */
        @JsonProperty("discountFixed")
        public Builder discountFixed(Integer discountFixed) {
            this.discountFixed = discountFixed;
            return this;
        }

        /**
         * 정상 가격명입니다.
         *
         * @param regularPriceName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("regularPriceName")
        public Builder regularPriceName(String regularPriceName) {
            this.regularPriceName = regularPriceName;
            return this;
        }

        /**
         * 할인 후 가격명입니다.
         *
         * @param discountPriceName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("discountPriceName")
        public Builder discountPriceName(String discountPriceName) {
            this.discountPriceName = discountPriceName;
            return this;
        }

        /**
         * 할인율명입니다.
         *
         * @param discountRateName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("discountRateName")
        public Builder discountRateName(String discountRateName) {
            this.discountRateName = discountRateName;
            return this;
        }

        /**
         * 정액 할인금액명입니다.
         *
         * @param discountFixedName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("discountFixedName")
        public Builder discountFixedName(String discountFixedName) {
            this.discountFixedName = discountFixedName;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageCommerce}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCommerce build() {
            BrandMessageCommerce built = new BrandMessageCommerce(this);
            ModelValidator v = new ModelValidator("BrandMessageCommerce");
            v.required("title", built.title);
            v.maxLength("title", built.title, 30);
            v.required("regularPrice", built.regularPrice);
            v.range("regularPrice", built.regularPrice, 0L, 99999999L);
            v.range("discountPrice", built.discountPrice, 0L, 99999999L);
            v.range("discountRate", built.discountRate, 1L, 100L);
            v.range("discountFixed", built.discountFixed, 0L, 999999L);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCommerce buildUnvalidated() {
            return new BrandMessageCommerce(this);
        }
    }
}
