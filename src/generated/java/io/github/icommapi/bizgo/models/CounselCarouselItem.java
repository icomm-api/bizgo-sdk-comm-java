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
@JsonDeserialize(builder = CounselCarouselItem.Builder.class)
@JsonPropertyOrder({"header", "message", "attachment"})
public final class CounselCarouselItem {

    private final String header;
    private final String message;
    private final CounselCarouselItemAttachment attachment;

    private CounselCarouselItem(Builder builder) {
        this.header = builder.header;
        this.message = builder.message;
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
        builder.attachment = this.attachment;
        return builder;
    }

    /**
     * 캐러셀 아이템 제목입니다. CAROUSEL_FEED 타입에서 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * 캐러셀 아이템 메시지입니다. CAROUSEL_FEED 타입에서 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * {@code attachment}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public CounselCarouselItemAttachment getAttachment() {
        return attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselCarouselItem)) {
            return false;
        }
        CounselCarouselItem other = (CounselCarouselItem) o;
        return Objects.equals(header, other.header)
                && Objects.equals(message, other.message)
                && Objects.equals(attachment, other.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, message, attachment);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselCarouselItem{", "}");
        if (header != null) {
            joiner.add("header=" + io.github.icommapi.bizgo.internal.Masking.length(header));
        }
        if (message != null) {
            joiner.add("message=" + io.github.icommapi.bizgo.internal.Masking.length(message));
        }
        if (attachment != null) {
            joiner.add("attachment=" + attachment);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselCarouselItem}. */
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
        private CounselCarouselItemAttachment attachment;

        /** Creates an empty builder; same as {@link CounselCarouselItem#builder()}. */
        public Builder() {
        }

        /**
         * 캐러셀 아이템 제목입니다. CAROUSEL_FEED 타입에서 사용합니다.
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
         * 캐러셀 아이템 메시지입니다. CAROUSEL_FEED 타입에서 사용합니다.
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
         * {@code attachment}.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        @JsonProperty("attachment")
        public Builder attachment(CounselCarouselItemAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselCarouselItem}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselCarouselItem build() {
            CounselCarouselItem built = new CounselCarouselItem(this);
            ModelValidator v = new ModelValidator("CounselCarouselItem");
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselCarouselItem buildUnvalidated() {
            return new CounselCarouselItem(this);
        }
    }
}
