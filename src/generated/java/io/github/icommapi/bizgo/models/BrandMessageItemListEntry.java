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
 * 브랜드메시지 와이드 아이템 목록의 항목 1개입니다.
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
@JsonDeserialize(builder = BrandMessageItemListEntry.Builder.class)
@JsonPropertyOrder({"title", "imgUrl", "urlMobile", "urlPc", "schemeIos", "schemeAndroid"})
public final class BrandMessageItemListEntry {

    private final String title;
    private final String imgUrl;
    private final String urlMobile;
    private final String urlPc;
    private final String schemeIos;
    private final String schemeAndroid;

    private BrandMessageItemListEntry(Builder builder) {
        this.title = builder.title;
        this.imgUrl = builder.imgUrl;
        this.urlMobile = builder.urlMobile;
        this.urlPc = builder.urlPc;
        this.schemeIos = builder.schemeIos;
        this.schemeAndroid = builder.schemeAndroid;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.title = this.title;
        builder.imgUrl = this.imgUrl;
        builder.urlMobile = this.urlMobile;
        builder.urlPc = this.urlPc;
        builder.schemeIos = this.schemeIos;
        builder.schemeAndroid = this.schemeAndroid;
        return builder;
    }

    /**
     * 아이템 제목입니다. 첫 번째 아이템은 최대 25자(줄바꿈 1회), 2~4번째 아이템은 최대 30자(줄바꿈 1회)입니다.
     *
     * <p>최대 30자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 아이템 이미지 URL입니다. 첫 번째 아이템은 와이드 리스트 첫번째 이미지 업로드, 2~4번째는 와이드 리스트 이미지 업로드로 발급받은 URL을 씁니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgUrl")
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 모바일 클릭 URL입니다. 최대 1,000자입니다.
     *
     * <p>최대 1000자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
    }

    /**
     * PC 클릭 URL입니다. 최대 1,000자입니다.
     *
     * <p>최대 1000자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlPc")
    public String getUrlPc() {
        return urlPc;
    }

    /**
     * iOS 커스텀 스킴입니다. 최대 1,000자입니다.
     *
     * <p>최대 1000자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("schemeIos")
    public String getSchemeIos() {
        return schemeIos;
    }

    /**
     * Android 커스텀 스킴입니다. 최대 1,000자입니다.
     *
     * <p>최대 1000자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("schemeAndroid")
    public String getSchemeAndroid() {
        return schemeAndroid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageItemListEntry)) {
            return false;
        }
        BrandMessageItemListEntry other = (BrandMessageItemListEntry) o;
        return Objects.equals(title, other.title)
                && Objects.equals(imgUrl, other.imgUrl)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(schemeIos, other.schemeIos)
                && Objects.equals(schemeAndroid, other.schemeAndroid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, imgUrl, urlMobile, urlPc, schemeIos, schemeAndroid);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageItemListEntry{", "}");
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (imgUrl != null) {
            joiner.add("imgUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imgUrl));
        }
        if (urlMobile != null) {
            joiner.add("urlMobile=" + io.github.icommapi.bizgo.internal.Masking.length(urlMobile));
        }
        if (urlPc != null) {
            joiner.add("urlPc=" + io.github.icommapi.bizgo.internal.Masking.length(urlPc));
        }
        if (schemeIos != null) {
            joiner.add("schemeIos=" + io.github.icommapi.bizgo.internal.Masking.length(schemeIos));
        }
        if (schemeAndroid != null) {
            joiner.add("schemeAndroid=" + io.github.icommapi.bizgo.internal.Masking.length(schemeAndroid));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageItemListEntry}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String title;
        private String imgUrl;
        private String urlMobile;
        private String urlPc;
        private String schemeIos;
        private String schemeAndroid;

        /** Creates an empty builder; same as {@link BrandMessageItemListEntry#builder()}. */
        public Builder() {
        }

        /**
         * 아이템 제목입니다. 첫 번째 아이템은 최대 25자(줄바꿈 1회), 2~4번째 아이템은 최대 30자(줄바꿈 1회)입니다.
         *
         * <p>최대 30자
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
         * 아이템 이미지 URL입니다. 첫 번째 아이템은 와이드 리스트 첫번째 이미지 업로드, 2~4번째는 와이드 리스트 이미지 업로드로 발급받은 URL을 씁니다.
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
         * 모바일 클릭 URL입니다. 최대 1,000자입니다.
         *
         * <p>최대 1000자
         *
         * @param urlMobile the value (null clears it)
         * @return this builder
         */
        @JsonProperty("urlMobile")
        public Builder urlMobile(String urlMobile) {
            this.urlMobile = urlMobile;
            return this;
        }

        /**
         * PC 클릭 URL입니다. 최대 1,000자입니다.
         *
         * <p>최대 1000자
         *
         * @param urlPc the value (null clears it)
         * @return this builder
         */
        @JsonProperty("urlPc")
        public Builder urlPc(String urlPc) {
            this.urlPc = urlPc;
            return this;
        }

        /**
         * iOS 커스텀 스킴입니다. 최대 1,000자입니다.
         *
         * <p>최대 1000자
         *
         * @param schemeIos the value (null clears it)
         * @return this builder
         */
        @JsonProperty("schemeIos")
        public Builder schemeIos(String schemeIos) {
            this.schemeIos = schemeIos;
            return this;
        }

        /**
         * Android 커스텀 스킴입니다. 최대 1,000자입니다.
         *
         * <p>최대 1000자
         *
         * @param schemeAndroid the value (null clears it)
         * @return this builder
         */
        @JsonProperty("schemeAndroid")
        public Builder schemeAndroid(String schemeAndroid) {
            this.schemeAndroid = schemeAndroid;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageItemListEntry}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageItemListEntry build() {
            BrandMessageItemListEntry built = new BrandMessageItemListEntry(this);
            ModelValidator v = new ModelValidator("BrandMessageItemListEntry");
            v.maxLength("title", built.title, 30);
            v.maxLength("urlMobile", built.urlMobile, 1000);
            v.maxLength("urlPc", built.urlPc, 1000);
            v.maxLength("schemeIos", built.schemeIos, 1000);
            v.maxLength("schemeAndroid", built.schemeAndroid, 1000);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageItemListEntry buildUnvalidated() {
            return new BrandMessageItemListEntry(this);
        }
    }
}
