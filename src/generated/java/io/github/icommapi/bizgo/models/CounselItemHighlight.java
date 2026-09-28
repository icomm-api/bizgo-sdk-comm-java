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
 * ITEM_LIST 타입의 아이템 하이라이트 영역입니다.
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
@JsonDeserialize(builder = CounselItemHighlight.Builder.class)
@JsonPropertyOrder({"title", "description", "imgUrl"})
public final class CounselItemHighlight {

    private final String title;
    private final String description;
    private final String imgUrl;

    private CounselItemHighlight(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.imgUrl = builder.imgUrl;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.title = this.title;
        builder.description = this.description;
        builder.imgUrl = this.imgUrl;
        return builder;
    }

    /**
     * 하이라이트 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 하이라이트 추가 설명입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 하이라이트 이미지 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgUrl")
    public String getImgUrl() {
        return imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselItemHighlight)) {
            return false;
        }
        CounselItemHighlight other = (CounselItemHighlight) o;
        return Objects.equals(title, other.title)
                && Objects.equals(description, other.description)
                && Objects.equals(imgUrl, other.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, imgUrl);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselItemHighlight{", "}");
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (description != null) {
            joiner.add("description=" + io.github.icommapi.bizgo.internal.Masking.length(description));
        }
        if (imgUrl != null) {
            joiner.add("imgUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imgUrl));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselItemHighlight}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String title;
        private String description;
        private String imgUrl;

        /** Creates an empty builder; same as {@link CounselItemHighlight#builder()}. */
        public Builder() {
        }

        /**
         * 하이라이트 제목입니다.
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        @JsonProperty("title")
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 하이라이트 추가 설명입니다.
         *
         * <p>필수
         *
         * @param description the value (null clears it)
         * @return this builder
         */
        @JsonProperty("description")
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * 하이라이트 이미지 URL입니다.
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
         * Builds the object.
         *
         * @return a new immutable {@code CounselItemHighlight}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselItemHighlight build() {
            CounselItemHighlight built = new CounselItemHighlight(this);
            ModelValidator v = new ModelValidator("CounselItemHighlight");
            v.required("description", built.description);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselItemHighlight buildUnvalidated() {
            return new CounselItemHighlight(this);
        }
    }
}
