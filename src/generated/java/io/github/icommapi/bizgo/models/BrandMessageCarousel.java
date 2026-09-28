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
 * 브랜드메시지 캐러셀 객체입니다(FC 캐러셀 피드, FA 캐러셀 커머스).
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
@JsonDeserialize(builder = BrandMessageCarousel.Builder.class)
@JsonPropertyOrder({"head", "list", "tail"})
public final class BrandMessageCarousel {

    private final BrandMessageCarouselHead head;
    private final List<BrandMessageCarouselItem> list;
    private final BrandMessageCarouselTail tail;

    private BrandMessageCarousel(Builder builder) {
        this.head = builder.head;
        this.list = builder.list == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.list));
        this.tail = builder.tail;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.head = this.head;
        builder.list = this.list;
        builder.tail = this.tail;
        return builder;
    }

    /**
     * {@code head}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("head")
    public BrandMessageCarouselHead getHead() {
        return head;
    }

    /**
     * 캐러셀 아이템 목록입니다. 최소 2개, 최대 10개입니다.
     *
     * <p>항목 수 2~10
     *
     * @return the value, or null if not set
     */
    @JsonProperty("list")
    public List<BrandMessageCarouselItem> getList() {
        return list;
    }

    /**
     * {@code tail}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("tail")
    public BrandMessageCarouselTail getTail() {
        return tail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageCarousel)) {
            return false;
        }
        BrandMessageCarousel other = (BrandMessageCarousel) o;
        return Objects.equals(head, other.head)
                && Objects.equals(list, other.list)
                && Objects.equals(tail, other.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, list, tail);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCarousel{", "}");
        if (head != null) {
            joiner.add("head=" + head);
        }
        if (list != null) {
            joiner.add("list=" + list);
        }
        if (tail != null) {
            joiner.add("tail=" + tail);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCarousel}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessageCarouselHead head;
        private List<BrandMessageCarouselItem> list;
        private BrandMessageCarouselTail tail;

        /** Creates an empty builder; same as {@link BrandMessageCarousel#builder()}. */
        public Builder() {
        }

        /**
         * {@code head}.
         *
         * @param head the value (null clears it)
         * @return this builder
         */
        @JsonProperty("head")
        public Builder head(BrandMessageCarouselHead head) {
            this.head = head;
            return this;
        }

        /**
         * 캐러셀 아이템 목록입니다. 최소 2개, 최대 10개입니다.
         *
         * <p>항목 수 2~10
         *
         * @param list the value (null clears it)
         * @return this builder
         */
        @JsonProperty("list")
        public Builder list(List<BrandMessageCarouselItem> list) {
            this.list = list;
            return this;
        }

        /**
         * Varargs form of {@link #list(List)}.
         *
         * @param list values
         * @return this builder
         */
        public Builder list(BrandMessageCarouselItem... list) {
            this.list = list == null ? null : Arrays.asList(list);
            return this;
        }

        /**
         * {@code tail}.
         *
         * @param tail the value (null clears it)
         * @return this builder
         */
        @JsonProperty("tail")
        public Builder tail(BrandMessageCarouselTail tail) {
            this.tail = tail;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageCarousel}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCarousel build() {
            BrandMessageCarousel built = new BrandMessageCarousel(this);
            ModelValidator v = new ModelValidator("BrandMessageCarousel");
            v.items("list", built.list, 2, 10);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCarousel buildUnvalidated() {
            return new BrandMessageCarousel(this);
        }
    }
}
