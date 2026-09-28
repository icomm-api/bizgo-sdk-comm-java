// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 캐러셀 아이템 첨부 정보입니다.
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
@JsonDeserialize(builder = BrandMessageCarouselItemAttachment.Builder.class)
@JsonPropertyOrder({"button", "image", "coupon", "commerce"})
public final class BrandMessageCarouselItemAttachment {

    private final List<BrandMessageButton> button;
    private final BrandMessageImage image;
    private final BrandMessageCoupon coupon;
    private final BrandMessageCommerce commerce;

    private BrandMessageCarouselItemAttachment(Builder builder) {
        this.button = builder.button == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.button));
        this.image = builder.image;
        this.coupon = builder.coupon;
        this.commerce = builder.commerce;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.button = this.button;
        builder.image = this.image;
        builder.coupon = this.coupon;
        builder.commerce = this.commerce;
        return builder;
    }

    /**
     * 캐러셀 아이템 버튼 목록입니다. 최대 5개이며, FC/FA 타입에 쿠폰을 함께 쓰면 최대 4개입니다.
     *
     * <p>항목 수 0~5
     *
     * @return the value, or null if not set
     */
    @JsonProperty("button")
    public List<BrandMessageButton> getButton() {
        return button;
    }

    /**
     * {@code image}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("image")
    public BrandMessageImage getImage() {
        return image;
    }

    /**
     * {@code coupon}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("coupon")
    public BrandMessageCoupon getCoupon() {
        return coupon;
    }

    /**
     * {@code commerce}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("commerce")
    public BrandMessageCommerce getCommerce() {
        return commerce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageCarouselItemAttachment)) {
            return false;
        }
        BrandMessageCarouselItemAttachment other = (BrandMessageCarouselItemAttachment) o;
        return Objects.equals(button, other.button)
                && Objects.equals(image, other.image)
                && Objects.equals(coupon, other.coupon)
                && Objects.equals(commerce, other.commerce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(button, image, coupon, commerce);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCarouselItemAttachment{", "}");
        if (button != null) {
            joiner.add("button=" + button);
        }
        if (image != null) {
            joiner.add("image=" + image);
        }
        if (coupon != null) {
            joiner.add("coupon=" + coupon);
        }
        if (commerce != null) {
            joiner.add("commerce=" + commerce);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCarouselItemAttachment}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<BrandMessageButton> button;
        private BrandMessageImage image;
        private BrandMessageCoupon coupon;
        private BrandMessageCommerce commerce;

        /** Creates an empty builder; same as {@link BrandMessageCarouselItemAttachment#builder()}. */
        public Builder() {
        }

        /**
         * 캐러셀 아이템 버튼 목록입니다. 최대 5개이며, FC/FA 타입에 쿠폰을 함께 쓰면 최대 4개입니다.
         *
         * <p>항목 수 0~5
         *
         * @param button the value (null clears it)
         * @return this builder
         */
        @JsonProperty("button")
        public Builder button(List<BrandMessageButton> button) {
            this.button = button;
            return this;
        }

        /**
         * Varargs form of {@link #button(List)}.
         *
         * @param button values
         * @return this builder
         */
        public Builder button(BrandMessageButton... button) {
            this.button = button == null ? null : Arrays.asList(button);
            return this;
        }

        /**
         * {@code image}.
         *
         * @param image the value (null clears it)
         * @return this builder
         */
        @JsonProperty("image")
        public Builder image(BrandMessageImage image) {
            this.image = image;
            return this;
        }

        /**
         * {@code coupon}.
         *
         * @param coupon the value (null clears it)
         * @return this builder
         */
        @JsonProperty("coupon")
        public Builder coupon(BrandMessageCoupon coupon) {
            this.coupon = coupon;
            return this;
        }

        /**
         * {@code commerce}.
         *
         * @param commerce the value (null clears it)
         * @return this builder
         */
        @JsonProperty("commerce")
        public Builder commerce(BrandMessageCommerce commerce) {
            this.commerce = commerce;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageCarouselItemAttachment}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCarouselItemAttachment build() {
            BrandMessageCarouselItemAttachment built = new BrandMessageCarouselItemAttachment(this);
            ModelValidator v = new ModelValidator("BrandMessageCarouselItemAttachment");
            v.items("button", built.button, -1, 5);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCarouselItemAttachment buildUnvalidated() {
            return new BrandMessageCarouselItemAttachment(this);
        }
    }
}
