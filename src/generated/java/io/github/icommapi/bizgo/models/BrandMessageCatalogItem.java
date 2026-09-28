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
 * 브랜드메시지 카탈로그 아이템 1개입니다.
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
@JsonDeserialize(builder = BrandMessageCatalogItem.Builder.class)
@JsonPropertyOrder({"type", "imgUrl", "imgLink", "title", "description", "regularPrice", "discountPrice", "discountRate", "discountFixed", "regularPriceName", "discountPriceName", "regularPriceVariableName", "discountPriceVariableName", "discountRateVariableName", "discountFixedVariableName"})
public final class BrandMessageCatalogItem {

    private final String type;
    private final String imgUrl;
    private final String imgLink;
    private final String title;
    private final String description;
    private final Integer regularPrice;
    private final Integer discountPrice;
    private final Integer discountRate;
    private final Integer discountFixed;
    private final String regularPriceName;
    private final String discountPriceName;
    private final String regularPriceVariableName;
    private final String discountPriceVariableName;
    private final String discountRateVariableName;
    private final String discountFixedVariableName;

    private BrandMessageCatalogItem(Builder builder) {
        this.type = builder.type;
        this.imgUrl = builder.imgUrl;
        this.imgLink = builder.imgLink;
        this.title = builder.title;
        this.description = builder.description;
        this.regularPrice = builder.regularPrice;
        this.discountPrice = builder.discountPrice;
        this.discountRate = builder.discountRate;
        this.discountFixed = builder.discountFixed;
        this.regularPriceName = builder.regularPriceName;
        this.discountPriceName = builder.discountPriceName;
        this.regularPriceVariableName = builder.regularPriceVariableName;
        this.discountPriceVariableName = builder.discountPriceVariableName;
        this.discountRateVariableName = builder.discountRateVariableName;
        this.discountFixedVariableName = builder.discountFixedVariableName;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.imgUrl = this.imgUrl;
        builder.imgLink = this.imgLink;
        builder.title = this.title;
        builder.description = this.description;
        builder.regularPrice = this.regularPrice;
        builder.discountPrice = this.discountPrice;
        builder.discountRate = this.discountRate;
        builder.discountFixed = this.discountFixed;
        builder.regularPriceName = this.regularPriceName;
        builder.discountPriceName = this.discountPriceName;
        builder.regularPriceVariableName = this.regularPriceVariableName;
        builder.discountPriceVariableName = this.discountPriceVariableName;
        builder.discountRateVariableName = this.discountRateVariableName;
        builder.discountFixedVariableName = this.discountFixedVariableName;
        return builder;
    }

    /**
     * 카탈로그 아이템 타입입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 카탈로그 아이템 타입 값 목록이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 아이템 이미지 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgUrl")
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 이미지 클릭 시 이동할 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgLink")
    public String getImgLink() {
        return imgLink;
    }

    /**
     * 상품명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 상품 설명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 정상 가격입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("regularPrice")
    public Integer getRegularPrice() {
        return regularPrice;
    }

    /**
     * 할인 후 가격입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountPrice")
    public Integer getDiscountPrice() {
        return discountPrice;
    }

    /**
     * 할인율입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountRate")
    public Integer getDiscountRate() {
        return discountRate;
    }

    /**
     * 정액 할인금액입니다.
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
     * 정상 가격 고정변수명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("regularPriceVariableName")
    public String getRegularPriceVariableName() {
        return regularPriceVariableName;
    }

    /**
     * 할인 후 가격 고정변수명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountPriceVariableName")
    public String getDiscountPriceVariableName() {
        return discountPriceVariableName;
    }

    /**
     * 할인율 고정변수명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountRateVariableName")
    public String getDiscountRateVariableName() {
        return discountRateVariableName;
    }

    /**
     * 정액 할인금액 고정변수명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("discountFixedVariableName")
    public String getDiscountFixedVariableName() {
        return discountFixedVariableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageCatalogItem)) {
            return false;
        }
        BrandMessageCatalogItem other = (BrandMessageCatalogItem) o;
        return Objects.equals(type, other.type)
                && Objects.equals(imgUrl, other.imgUrl)
                && Objects.equals(imgLink, other.imgLink)
                && Objects.equals(title, other.title)
                && Objects.equals(description, other.description)
                && Objects.equals(regularPrice, other.regularPrice)
                && Objects.equals(discountPrice, other.discountPrice)
                && Objects.equals(discountRate, other.discountRate)
                && Objects.equals(discountFixed, other.discountFixed)
                && Objects.equals(regularPriceName, other.regularPriceName)
                && Objects.equals(discountPriceName, other.discountPriceName)
                && Objects.equals(regularPriceVariableName, other.regularPriceVariableName)
                && Objects.equals(discountPriceVariableName, other.discountPriceVariableName)
                && Objects.equals(discountRateVariableName, other.discountRateVariableName)
                && Objects.equals(discountFixedVariableName, other.discountFixedVariableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, imgUrl, imgLink, title, description, regularPrice, discountPrice, discountRate, discountFixed, regularPriceName, discountPriceName, regularPriceVariableName, discountPriceVariableName, discountRateVariableName, discountFixedVariableName);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCatalogItem{", "}");
        if (type != null) {
            joiner.add("type=" + type);
        }
        if (imgUrl != null) {
            joiner.add("imgUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imgUrl));
        }
        if (imgLink != null) {
            joiner.add("imgLink=" + io.github.icommapi.bizgo.internal.Masking.length(imgLink));
        }
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (description != null) {
            joiner.add("description=" + io.github.icommapi.bizgo.internal.Masking.length(description));
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
        if (regularPriceVariableName != null) {
            joiner.add("regularPriceVariableName=" + io.github.icommapi.bizgo.internal.Masking.length(regularPriceVariableName));
        }
        if (discountPriceVariableName != null) {
            joiner.add("discountPriceVariableName=" + io.github.icommapi.bizgo.internal.Masking.length(discountPriceVariableName));
        }
        if (discountRateVariableName != null) {
            joiner.add("discountRateVariableName=" + io.github.icommapi.bizgo.internal.Masking.length(discountRateVariableName));
        }
        if (discountFixedVariableName != null) {
            joiner.add("discountFixedVariableName=" + io.github.icommapi.bizgo.internal.Masking.length(discountFixedVariableName));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCatalogItem}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String type;
        private String imgUrl;
        private String imgLink;
        private String title;
        private String description;
        private Integer regularPrice;
        private Integer discountPrice;
        private Integer discountRate;
        private Integer discountFixed;
        private String regularPriceName;
        private String discountPriceName;
        private String regularPriceVariableName;
        private String discountPriceVariableName;
        private String discountRateVariableName;
        private String discountFixedVariableName;

        /** Creates an empty builder; same as {@link BrandMessageCatalogItem#builder()}. */
        public Builder() {
        }

        /**
         * 카탈로그 아이템 타입입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 카탈로그 아이템 타입 값 목록이 문서에 없습니다.
         *
         * @param type the value (null clears it)
         * @return this builder
         */
        @JsonProperty("type")
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 아이템 이미지 URL입니다.
         *
         * @param imgUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imgUrl")
        public Builder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        /**
         * 이미지 클릭 시 이동할 URL입니다.
         *
         * @param imgLink the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imgLink")
        public Builder imgLink(String imgLink) {
            this.imgLink = imgLink;
            return this;
        }

        /**
         * 상품명입니다.
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
         * 상품 설명입니다.
         *
         * @param description the value (null clears it)
         * @return this builder
         */
        @JsonProperty("description")
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * 정상 가격입니다.
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
         * 할인 후 가격입니다.
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
         * 할인율입니다.
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
         * 정액 할인금액입니다.
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
         * 정상 가격 고정변수명입니다.
         *
         * @param regularPriceVariableName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("regularPriceVariableName")
        public Builder regularPriceVariableName(String regularPriceVariableName) {
            this.regularPriceVariableName = regularPriceVariableName;
            return this;
        }

        /**
         * 할인 후 가격 고정변수명입니다.
         *
         * @param discountPriceVariableName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("discountPriceVariableName")
        public Builder discountPriceVariableName(String discountPriceVariableName) {
            this.discountPriceVariableName = discountPriceVariableName;
            return this;
        }

        /**
         * 할인율 고정변수명입니다.
         *
         * @param discountRateVariableName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("discountRateVariableName")
        public Builder discountRateVariableName(String discountRateVariableName) {
            this.discountRateVariableName = discountRateVariableName;
            return this;
        }

        /**
         * 정액 할인금액 고정변수명입니다.
         *
         * @param discountFixedVariableName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("discountFixedVariableName")
        public Builder discountFixedVariableName(String discountFixedVariableName) {
            this.discountFixedVariableName = discountFixedVariableName;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageCatalogItem}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCatalogItem build() {
            BrandMessageCatalogItem built = new BrandMessageCatalogItem(this);
            ModelValidator v = new ModelValidator("BrandMessageCatalogItem");
            v.required("type", built.type);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCatalogItem buildUnvalidated() {
            return new BrandMessageCatalogItem(this);
        }
    }
}
