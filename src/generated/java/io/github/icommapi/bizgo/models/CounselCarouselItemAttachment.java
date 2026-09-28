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
@JsonDeserialize(builder = CounselCarouselItemAttachment.Builder.class)
@JsonPropertyOrder({"buttons", "image", "coupon"})
public final class CounselCarouselItemAttachment {

    private final List<CounselButton> buttons;
    private final CounselImage image;
    private final CounselCoupon coupon;

    private CounselCarouselItemAttachment(Builder builder) {
        this.buttons = builder.buttons == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.buttons));
        this.image = builder.image;
        this.coupon = builder.coupon;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.buttons = this.buttons;
        builder.image = this.image;
        builder.coupon = this.coupon;
        return builder;
    }

    /**
     * 캐러셀 아이템 버튼 목록입니다. 쿠폰을 적용하면 최대 4개, 그 외 최대 5개입니다.
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
     * {@code image}.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("image")
    public CounselImage getImage() {
        return image;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselCarouselItemAttachment)) {
            return false;
        }
        CounselCarouselItemAttachment other = (CounselCarouselItemAttachment) o;
        return Objects.equals(buttons, other.buttons)
                && Objects.equals(image, other.image)
                && Objects.equals(coupon, other.coupon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttons, image, coupon);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselCarouselItemAttachment{", "}");
        if (buttons != null) {
            joiner.add("buttons=" + buttons);
        }
        if (image != null) {
            joiner.add("image=" + image);
        }
        if (coupon != null) {
            joiner.add("coupon=" + coupon);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselCarouselItemAttachment}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<CounselButton> buttons;
        private CounselImage image;
        private CounselCoupon coupon;

        /** Creates an empty builder; same as {@link CounselCarouselItemAttachment#builder()}. */
        public Builder() {
        }

        /**
         * 캐러셀 아이템 버튼 목록입니다. 쿠폰을 적용하면 최대 4개, 그 외 최대 5개입니다.
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
         * {@code image}.
         *
         * <p>필수
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
         * Builds the object.
         *
         * @return a new immutable {@code CounselCarouselItemAttachment}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselCarouselItemAttachment build() {
            CounselCarouselItemAttachment built = new CounselCarouselItemAttachment(this);
            ModelValidator v = new ModelValidator("CounselCarouselItemAttachment");
            v.items("buttons", built.buttons, -1, 5);
            v.required("image", built.image);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselCarouselItemAttachment buildUnvalidated() {
            return new CounselCarouselItemAttachment(this);
        }
    }
}
