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
 * 캐러셀 인트로 정보입니다. FC 타입에서는 사용할 수 없습니다.
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
@JsonDeserialize(builder = BrandMessageCarouselHead.Builder.class)
@JsonPropertyOrder({"header", "content", "imageUrl", "urlMobile", "urlPc", "schemeAndroid", "schemeIos"})
public final class BrandMessageCarouselHead {

    private final String header;
    private final String content;
    private final String imageUrl;
    private final String urlMobile;
    private final String urlPc;
    private final String schemeAndroid;
    private final String schemeIos;

    private BrandMessageCarouselHead(Builder builder) {
        this.header = builder.header;
        this.content = builder.content;
        this.imageUrl = builder.imageUrl;
        this.urlMobile = builder.urlMobile;
        this.urlPc = builder.urlPc;
        this.schemeAndroid = builder.schemeAndroid;
        this.schemeIos = builder.schemeIos;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.content = this.content;
        builder.imageUrl = this.imageUrl;
        builder.urlMobile = this.urlMobile;
        builder.urlPc = this.urlPc;
        builder.schemeAndroid = this.schemeAndroid;
        builder.schemeIos = this.schemeIos;
        return builder;
    }

    /**
     * 캐러셀 인트로 헤더입니다. 줄바꿈 불가, 최대 20자입니다.
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
     * 캐러셀 인트로 내용입니다. 줄바꿈 최대 2회, 최대 50자입니다.
     *
     * <p>최대 50자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 캐러셀 인트로 이미지 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 모바일 클릭 URL입니다. URL 또는 스킴 중 하나라도 입력하면 필수입니다. 최대 1,000자입니다.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageCarouselHead)) {
            return false;
        }
        BrandMessageCarouselHead other = (BrandMessageCarouselHead) o;
        return Objects.equals(header, other.header)
                && Objects.equals(content, other.content)
                && Objects.equals(imageUrl, other.imageUrl)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(schemeAndroid, other.schemeAndroid)
                && Objects.equals(schemeIos, other.schemeIos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, content, imageUrl, urlMobile, urlPc, schemeAndroid, schemeIos);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCarouselHead{", "}");
        if (header != null) {
            joiner.add("header=" + io.github.icommapi.bizgo.internal.Masking.length(header));
        }
        if (content != null) {
            joiner.add("content=" + io.github.icommapi.bizgo.internal.Masking.length(content));
        }
        if (imageUrl != null) {
            joiner.add("imageUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imageUrl));
        }
        if (urlMobile != null) {
            joiner.add("urlMobile=" + io.github.icommapi.bizgo.internal.Masking.length(urlMobile));
        }
        if (urlPc != null) {
            joiner.add("urlPc=" + io.github.icommapi.bizgo.internal.Masking.length(urlPc));
        }
        if (schemeAndroid != null) {
            joiner.add("schemeAndroid=" + io.github.icommapi.bizgo.internal.Masking.length(schemeAndroid));
        }
        if (schemeIos != null) {
            joiner.add("schemeIos=" + io.github.icommapi.bizgo.internal.Masking.length(schemeIos));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCarouselHead}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String header;
        private String content;
        private String imageUrl;
        private String urlMobile;
        private String urlPc;
        private String schemeAndroid;
        private String schemeIos;

        /** Creates an empty builder; same as {@link BrandMessageCarouselHead#builder()}. */
        public Builder() {
        }

        /**
         * 캐러셀 인트로 헤더입니다. 줄바꿈 불가, 최대 20자입니다.
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
         * 캐러셀 인트로 내용입니다. 줄바꿈 최대 2회, 최대 50자입니다.
         *
         * <p>최대 50자
         *
         * @param content the value (null clears it)
         * @return this builder
         */
        @JsonProperty("content")
        public Builder content(String content) {
            this.content = content;
            return this;
        }

        /**
         * 캐러셀 인트로 이미지 URL입니다.
         *
         * @param imageUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imageUrl")
        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        /**
         * 모바일 클릭 URL입니다. URL 또는 스킴 중 하나라도 입력하면 필수입니다. 최대 1,000자입니다.
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
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageCarouselHead}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCarouselHead build() {
            BrandMessageCarouselHead built = new BrandMessageCarouselHead(this);
            ModelValidator v = new ModelValidator("BrandMessageCarouselHead");
            v.maxLength("header", built.header, 20);
            v.maxLength("content", built.content, 50);
            v.maxLength("urlMobile", built.urlMobile, 1000);
            v.maxLength("urlPc", built.urlPc, 1000);
            v.maxLength("schemeAndroid", built.schemeAndroid, 1000);
            v.maxLength("schemeIos", built.schemeIos, 1000);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCarouselHead buildUnvalidated() {
            return new BrandMessageCarouselHead(this);
        }
    }
}
