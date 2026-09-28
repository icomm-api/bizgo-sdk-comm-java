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
 * 브랜드메시지 첨부 정보(버튼, 이미지, 와이드 아이템, 쿠폰, 커머스, 동영상, 카탈로그)입니다.
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
@JsonDeserialize(builder = BrandMessageAttachment.Builder.class)
@JsonPropertyOrder({"button", "image", "item", "coupon", "commerce", "video", "catalog"})
public final class BrandMessageAttachment {

    private final List<BrandMessageButton> button;
    private final BrandMessageImage image;
    private final BrandMessageItem item;
    private final BrandMessageCoupon coupon;
    private final BrandMessageCommerce commerce;
    private final BrandMessageVideo video;
    private final BrandMessageCatalog catalog;

    private BrandMessageAttachment(Builder builder) {
        this.button = builder.button == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.button));
        this.image = builder.image;
        this.item = builder.item;
        this.coupon = builder.coupon;
        this.commerce = builder.commerce;
        this.video = builder.video;
        this.catalog = builder.catalog;
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
        builder.item = this.item;
        builder.coupon = this.coupon;
        builder.commerce = this.commerce;
        builder.video = this.video;
        builder.catalog = this.catalog;
        return builder;
    }

    /**
     * 버튼 목록입니다. 최대 5개이며, FT/FI 타입에 쿠폰을 함께 쓰면 최대 4개입니다.
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
     * {@code item}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("item")
    public BrandMessageItem getItem() {
        return item;
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

    /**
     * {@code video}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("video")
    public BrandMessageVideo getVideo() {
        return video;
    }

    /**
     * {@code catalog}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("catalog")
    public BrandMessageCatalog getCatalog() {
        return catalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageAttachment)) {
            return false;
        }
        BrandMessageAttachment other = (BrandMessageAttachment) o;
        return Objects.equals(button, other.button)
                && Objects.equals(image, other.image)
                && Objects.equals(item, other.item)
                && Objects.equals(coupon, other.coupon)
                && Objects.equals(commerce, other.commerce)
                && Objects.equals(video, other.video)
                && Objects.equals(catalog, other.catalog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(button, image, item, coupon, commerce, video, catalog);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageAttachment{", "}");
        if (button != null) {
            joiner.add("button=" + button);
        }
        if (image != null) {
            joiner.add("image=" + image);
        }
        if (item != null) {
            joiner.add("item=" + item);
        }
        if (coupon != null) {
            joiner.add("coupon=" + coupon);
        }
        if (commerce != null) {
            joiner.add("commerce=" + commerce);
        }
        if (video != null) {
            joiner.add("video=" + video);
        }
        if (catalog != null) {
            joiner.add("catalog=" + catalog);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageAttachment}. */
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
        private BrandMessageItem item;
        private BrandMessageCoupon coupon;
        private BrandMessageCommerce commerce;
        private BrandMessageVideo video;
        private BrandMessageCatalog catalog;

        /** Creates an empty builder; same as {@link BrandMessageAttachment#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 목록입니다. 최대 5개이며, FT/FI 타입에 쿠폰을 함께 쓰면 최대 4개입니다.
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
         * {@code item}.
         *
         * @param item the value (null clears it)
         * @return this builder
         */
        @JsonProperty("item")
        public Builder item(BrandMessageItem item) {
            this.item = item;
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
         * {@code video}.
         *
         * @param video the value (null clears it)
         * @return this builder
         */
        @JsonProperty("video")
        public Builder video(BrandMessageVideo video) {
            this.video = video;
            return this;
        }

        /**
         * {@code catalog}.
         *
         * @param catalog the value (null clears it)
         * @return this builder
         */
        @JsonProperty("catalog")
        public Builder catalog(BrandMessageCatalog catalog) {
            this.catalog = catalog;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageAttachment}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageAttachment build() {
            BrandMessageAttachment built = new BrandMessageAttachment(this);
            ModelValidator v = new ModelValidator("BrandMessageAttachment");
            v.items("button", built.button, -1, 5);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageAttachment buildUnvalidated() {
            return new BrandMessageAttachment(this);
        }
    }
}
