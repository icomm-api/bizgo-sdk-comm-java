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
 * 브랜드메시지 동영상 요소입니다(FP).
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
@JsonDeserialize(builder = BrandMessageVideo.Builder.class)
@JsonPropertyOrder({"videoUrl", "thumbnailUrl"})
public final class BrandMessageVideo {

    private final String videoUrl;
    private final String thumbnailUrl;

    private BrandMessageVideo(Builder builder) {
        this.videoUrl = builder.videoUrl;
        this.thumbnailUrl = builder.thumbnailUrl;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.videoUrl = this.videoUrl;
        builder.thumbnailUrl = this.thumbnailUrl;
        return builder;
    }

    /**
     * 카카오TV 동영상 URL입니다. 최대 500자입니다.
     *
     * <p>필수 · 최대 500자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("videoUrl")
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 동영상 썸네일 URL입니다. 비공개 동영상이면 필수입니다. 최대 500자입니다.
     *
     * <p>최대 500자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageVideo)) {
            return false;
        }
        BrandMessageVideo other = (BrandMessageVideo) o;
        return Objects.equals(videoUrl, other.videoUrl)
                && Objects.equals(thumbnailUrl, other.thumbnailUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoUrl, thumbnailUrl);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageVideo{", "}");
        if (videoUrl != null) {
            joiner.add("videoUrl=" + io.github.icommapi.bizgo.internal.Masking.length(videoUrl));
        }
        if (thumbnailUrl != null) {
            joiner.add("thumbnailUrl=" + io.github.icommapi.bizgo.internal.Masking.length(thumbnailUrl));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageVideo}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String videoUrl;
        private String thumbnailUrl;

        /** Creates an empty builder; same as {@link BrandMessageVideo#builder()}. */
        public Builder() {
        }

        /**
         * 카카오TV 동영상 URL입니다. 최대 500자입니다.
         *
         * <p>필수 · 최대 500자
         *
         * @param videoUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("videoUrl")
        public Builder videoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        /**
         * 동영상 썸네일 URL입니다. 비공개 동영상이면 필수입니다. 최대 500자입니다.
         *
         * <p>최대 500자
         *
         * @param thumbnailUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("thumbnailUrl")
        public Builder thumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageVideo}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageVideo build() {
            BrandMessageVideo built = new BrandMessageVideo(this);
            ModelValidator v = new ModelValidator("BrandMessageVideo");
            v.required("videoUrl", built.videoUrl);
            v.maxLength("videoUrl", built.videoUrl, 500);
            v.maxLength("thumbnailUrl", built.thumbnailUrl, 500);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageVideo buildUnvalidated() {
            return new BrandMessageVideo(this);
        }
    }
}
