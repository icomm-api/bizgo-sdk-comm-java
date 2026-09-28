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
 * 상담톡 이미지 요소입니다.
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
@JsonDeserialize(builder = CounselImage.Builder.class)
@JsonPropertyOrder({"imgUrl", "imgLink"})
public final class CounselImage {

    private final String imgUrl;
    private final String imgLink;

    private CounselImage(Builder builder) {
        this.imgUrl = builder.imgUrl;
        this.imgLink = builder.imgLink;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.imgUrl = this.imgUrl;
        builder.imgLink = this.imgLink;
        return builder;
    }

    /**
     * 상담톡 이미지 업로드 API(<code>/api/comm/v1/file/cstalk/image</code>)로 등록한 이미지 URL입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgUrl")
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 이미지 클릭 시 이동할 URL입니다. 설정하지 않으면 카카오톡 내 이미지 뷰어를 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgLink")
    public String getImgLink() {
        return imgLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselImage)) {
            return false;
        }
        CounselImage other = (CounselImage) o;
        return Objects.equals(imgUrl, other.imgUrl)
                && Objects.equals(imgLink, other.imgLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgUrl, imgLink);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselImage{", "}");
        if (imgUrl != null) {
            joiner.add("imgUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imgUrl));
        }
        if (imgLink != null) {
            joiner.add("imgLink=" + io.github.icommapi.bizgo.internal.Masking.length(imgLink));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselImage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String imgUrl;
        private String imgLink;

        /** Creates an empty builder; same as {@link CounselImage#builder()}. */
        public Builder() {
        }

        /**
         * 상담톡 이미지 업로드 API(<code>/api/comm/v1/file/cstalk/image</code>)로 등록한 이미지 URL입니다.
         *
         * <p>필수
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
         * 이미지 클릭 시 이동할 URL입니다. 설정하지 않으면 카카오톡 내 이미지 뷰어를 사용합니다.
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
         * Builds the object.
         *
         * @return a new immutable {@code CounselImage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselImage build() {
            CounselImage built = new CounselImage(this);
            ModelValidator v = new ModelValidator("CounselImage");
            v.required("imgUrl", built.imgUrl);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselImage buildUnvalidated() {
            return new CounselImage(this);
        }
    }
}
