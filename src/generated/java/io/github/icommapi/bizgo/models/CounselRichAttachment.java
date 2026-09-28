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
 * Rich 메시지 첨부 정보입니다.
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
@JsonDeserialize(builder = CounselRichAttachment.Builder.class)
@JsonPropertyOrder({"image", "buttons", "quickReplies", "coupon", "item"})
public final class CounselRichAttachment {

    private final CounselImage image;
    private final List<CounselButton> buttons;
    private final List<CounselQuickReply> quickReplies;
    private final CounselCoupon coupon;
    private final CounselItem item;

    private CounselRichAttachment(Builder builder) {
        this.image = builder.image;
        this.buttons = builder.buttons == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.buttons));
        this.quickReplies = builder.quickReplies == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.quickReplies));
        this.coupon = builder.coupon;
        this.item = builder.item;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.image = this.image;
        builder.buttons = this.buttons;
        builder.quickReplies = this.quickReplies;
        builder.coupon = this.coupon;
        builder.item = this.item;
        return builder;
    }

    /**
     * {@code image}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("image")
    public CounselImage getImage() {
        return image;
    }

    /**
     * 버튼 목록입니다. TEXT, IMAGE, ITEM_LIST는 쿠폰 적용 시 최대 4개, 그 외 최대 5개이며 WIDE, WIDE_ITEM_LIST, CAROUSEL_FEED는 최대 2개입니다.
     *
     * <p>항목 수 0~5
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttons")
    public List<CounselButton> getButtons() {
        return buttons;
    }

    /**
     * 바로연결 목록입니다. 최대 10개입니다.
     *
     * <p>항목 수 0~10
     *
     * @return the value, or null if not set
     */
    @JsonProperty("quickReplies")
    public List<CounselQuickReply> getQuickReplies() {
        return quickReplies;
    }

    /**
     * {@code coupon}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("coupon")
    public CounselCoupon getCoupon() {
        return coupon;
    }

    /**
     * {@code item}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("item")
    public CounselItem getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselRichAttachment)) {
            return false;
        }
        CounselRichAttachment other = (CounselRichAttachment) o;
        return Objects.equals(image, other.image)
                && Objects.equals(buttons, other.buttons)
                && Objects.equals(quickReplies, other.quickReplies)
                && Objects.equals(coupon, other.coupon)
                && Objects.equals(item, other.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, buttons, quickReplies, coupon, item);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselRichAttachment{", "}");
        if (image != null) {
            joiner.add("image=" + image);
        }
        if (buttons != null) {
            joiner.add("buttons=" + buttons);
        }
        if (quickReplies != null) {
            joiner.add("quickReplies=" + quickReplies);
        }
        if (coupon != null) {
            joiner.add("coupon=" + coupon);
        }
        if (item != null) {
            joiner.add("item=" + item);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselRichAttachment}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private CounselImage image;
        private List<CounselButton> buttons;
        private List<CounselQuickReply> quickReplies;
        private CounselCoupon coupon;
        private CounselItem item;

        /** Creates an empty builder; same as {@link CounselRichAttachment#builder()}. */
        public Builder() {
        }

        /**
         * {@code image}.
         *
         * @param image the value (null clears it)
         * @return this builder
         */
        @JsonProperty("image")
        public Builder image(CounselImage image) {
            this.image = image;
            return this;
        }

        /**
         * 버튼 목록입니다. TEXT, IMAGE, ITEM_LIST는 쿠폰 적용 시 최대 4개, 그 외 최대 5개이며 WIDE, WIDE_ITEM_LIST, CAROUSEL_FEED는 최대 2개입니다.
         *
         * <p>항목 수 0~5
         *
         * @param buttons the value (null clears it)
         * @return this builder
         */
        @JsonProperty("buttons")
        public Builder buttons(List<CounselButton> buttons) {
            this.buttons = buttons;
            return this;
        }

        /**
         * Varargs form of {@link #buttons(List)}.
         *
         * @param buttons values
         * @return this builder
         */
        public Builder buttons(CounselButton... buttons) {
            this.buttons = buttons == null ? null : Arrays.asList(buttons);
            return this;
        }

        /**
         * 바로연결 목록입니다. 최대 10개입니다.
         *
         * <p>항목 수 0~10
         *
         * @param quickReplies the value (null clears it)
         * @return this builder
         */
        @JsonProperty("quickReplies")
        public Builder quickReplies(List<CounselQuickReply> quickReplies) {
            this.quickReplies = quickReplies;
            return this;
        }

        /**
         * Varargs form of {@link #quickReplies(List)}.
         *
         * @param quickReplies values
         * @return this builder
         */
        public Builder quickReplies(CounselQuickReply... quickReplies) {
            this.quickReplies = quickReplies == null ? null : Arrays.asList(quickReplies);
            return this;
        }

        /**
         * {@code coupon}.
         *
         * @param coupon the value (null clears it)
         * @return this builder
         */
        @JsonProperty("coupon")
        public Builder coupon(CounselCoupon coupon) {
            this.coupon = coupon;
            return this;
        }

        /**
         * {@code item}.
         *
         * @param item the value (null clears it)
         * @return this builder
         */
        @JsonProperty("item")
        public Builder item(CounselItem item) {
            this.item = item;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselRichAttachment}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselRichAttachment build() {
            CounselRichAttachment built = new CounselRichAttachment(this);
            ModelValidator v = new ModelValidator("CounselRichAttachment");
            v.items("buttons", built.buttons, -1, 5);
            v.items("quickReplies", built.quickReplies, -1, 10);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselRichAttachment buildUnvalidated() {
            return new CounselRichAttachment(this);
        }
    }
}
