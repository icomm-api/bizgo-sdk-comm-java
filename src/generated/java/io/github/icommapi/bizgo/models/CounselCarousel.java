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
 * 캐러셀 정보입니다. CAROUSEL_FEED 타입에서 필수입니다.
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
@JsonDeserialize(builder = CounselCarousel.Builder.class)
@JsonPropertyOrder({"list", "tail"})
public final class CounselCarousel {

    private final List<CounselCarouselItem> list;
    private final CounselCarouselTail tail;

    private CounselCarousel(Builder builder) {
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
        builder.list = this.list;
        builder.tail = this.tail;
        return builder;
    }

    /**
     * 캐러셀 아이템 리스트입니다. 최소 2개, 최대 10개입니다.
     *
     * <p>항목 수 2~10
     *
     * @return the value, or null if not set
     */
    @JsonProperty("list")
    public List<CounselCarouselItem> getList() {
        return list;
    }

    /**
     * {@code tail}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("tail")
    public CounselCarouselTail getTail() {
        return tail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselCarousel)) {
            return false;
        }
        CounselCarousel other = (CounselCarousel) o;
        return Objects.equals(list, other.list)
                && Objects.equals(tail, other.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list, tail);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselCarousel{", "}");
        if (list != null) {
            joiner.add("list=" + list);
        }
        if (tail != null) {
            joiner.add("tail=" + tail);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselCarousel}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<CounselCarouselItem> list;
        private CounselCarouselTail tail;

        /** Creates an empty builder; same as {@link CounselCarousel#builder()}. */
        public Builder() {
        }

        /**
         * 캐러셀 아이템 리스트입니다. 최소 2개, 최대 10개입니다.
         *
         * <p>항목 수 2~10
         *
         * @param list the value (null clears it)
         * @return this builder
         */
        @JsonProperty("list")
        public Builder list(List<CounselCarouselItem> list) {
            this.list = list;
            return this;
        }

        /**
         * Varargs form of {@link #list(List)}.
         *
         * @param list values
         * @return this builder
         */
        public Builder list(CounselCarouselItem... list) {
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
        public Builder tail(CounselCarouselTail tail) {
            this.tail = tail;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselCarousel}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselCarousel build() {
            CounselCarousel built = new CounselCarousel(this);
            ModelValidator v = new ModelValidator("CounselCarousel");
            v.items("list", built.list, 2, 10);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselCarousel buildUnvalidated() {
            return new CounselCarousel(this);
        }
    }
}
