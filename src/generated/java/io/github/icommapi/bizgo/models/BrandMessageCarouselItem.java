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
 * 캐러셀 아이템 1개입니다.
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
@JsonDeserialize(builder = BrandMessageCarouselItem.Builder.class)
@JsonPropertyOrder({"header", "message", "additionalContent", "attachment"})
public final class BrandMessageCarouselItem {

    private final String header;
    private final String message;
    private final String additionalContent;
    private final BrandMessageCarouselItemAttachment attachment;

    private BrandMessageCarouselItem(Builder builder) {
        this.header = builder.header;
        this.message = builder.message;
        this.additionalContent = builder.additionalContent;
        this.attachment = builder.attachment;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.message = this.message;
        builder.additionalContent = this.additionalContent;
        builder.attachment = this.attachment;
        return builder;
    }

    /**
     * 캐러셀 아이템 제목입니다. FC 타입에서 필수, FA 타입에서는 사용할 수 없습니다. 줄바꿈 불가, 최대 20자입니다.
     *
     * <p>최대 20자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * 캐러셀 아이템 본문입니다. FC 타입에서 필수, FA 타입에서는 사용할 수 없습니다. 줄바꿈 최대 2회, 최대 180자입니다.
     *
     * <p>최대 180자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * 부가 정보입니다. FA 타입에서는 사용할 수 없습니다. 줄바꿈 최대 1회, 최대 34자입니다.
     *
     * <p>최대 34자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("additionalContent")
    public String getAdditionalContent() {
        return additionalContent;
    }

    /**
     * {@code attachment}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public BrandMessageCarouselItemAttachment getAttachment() {
        return attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageCarouselItem)) {
            return false;
        }
        BrandMessageCarouselItem other = (BrandMessageCarouselItem) o;
        return Objects.equals(header, other.header)
                && Objects.equals(message, other.message)
                && Objects.equals(additionalContent, other.additionalContent)
                && Objects.equals(attachment, other.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, message, additionalContent, attachment);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCarouselItem{", "}");
        if (header != null) {
            joiner.add("header=" + io.github.icommapi.bizgo.internal.Masking.length(header));
        }
        if (message != null) {
            joiner.add("message=" + io.github.icommapi.bizgo.internal.Masking.length(message));
        }
        if (additionalContent != null) {
            joiner.add("additionalContent=" + io.github.icommapi.bizgo.internal.Masking.length(additionalContent));
        }
        if (attachment != null) {
            joiner.add("attachment=" + attachment);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCarouselItem}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String header;
        private String message;
        private String additionalContent;
        private BrandMessageCarouselItemAttachment attachment;

        /** Creates an empty builder; same as {@link BrandMessageCarouselItem#builder()}. */
        public Builder() {
        }

        /**
         * 캐러셀 아이템 제목입니다. FC 타입에서 필수, FA 타입에서는 사용할 수 없습니다. 줄바꿈 불가, 최대 20자입니다.
         *
         * <p>최대 20자
         *
         * @param header the value (null clears it)
         * @return this builder
         */
        @JsonProperty("header")
        public Builder header(String header) {
            this.header = header;
            return this;
        }

        /**
         * 캐러셀 아이템 본문입니다. FC 타입에서 필수, FA 타입에서는 사용할 수 없습니다. 줄바꿈 최대 2회, 최대 180자입니다.
         *
         * <p>최대 180자
         *
         * @param message the value (null clears it)
         * @return this builder
         */
        @JsonProperty("message")
        public Builder message(String message) {
            this.message = message;
            return this;
        }

        /**
         * 부가 정보입니다. FA 타입에서는 사용할 수 없습니다. 줄바꿈 최대 1회, 최대 34자입니다.
         *
         * <p>최대 34자
         *
         * @param additionalContent the value (null clears it)
         * @return this builder
         */
        @JsonProperty("additionalContent")
        public Builder additionalContent(String additionalContent) {
            this.additionalContent = additionalContent;
            return this;
        }

        /**
         * {@code attachment}.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        @JsonProperty("attachment")
        public Builder attachment(BrandMessageCarouselItemAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageCarouselItem}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCarouselItem build() {
            BrandMessageCarouselItem built = new BrandMessageCarouselItem(this);
            ModelValidator v = new ModelValidator("BrandMessageCarouselItem");
            v.maxLength("header", built.header, 20);
            v.maxLength("message", built.message, 180);
            v.maxLength("additionalContent", built.additionalContent, 34);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCarouselItem buildUnvalidated() {
            return new BrandMessageCarouselItem(this);
        }
    }
}
