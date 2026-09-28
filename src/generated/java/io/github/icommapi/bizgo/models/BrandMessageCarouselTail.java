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
 * 캐러셀 더보기 버튼 정보입니다.
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
@JsonDeserialize(builder = BrandMessageCarouselTail.Builder.class)
@JsonPropertyOrder({"urlMobile", "urlPc", "schemeIos", "schemeAndroid"})
public final class BrandMessageCarouselTail {

    private final String urlMobile;
    private final String urlPc;
    private final String schemeIos;
    private final String schemeAndroid;

    private BrandMessageCarouselTail(Builder builder) {
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
        builder.urlMobile = this.urlMobile;
        builder.urlPc = this.urlPc;
        builder.schemeIos = this.schemeIos;
        builder.schemeAndroid = this.schemeAndroid;
        return builder;
    }

    /**
     * 모바일 클릭 URL입니다. 최대 1,000자입니다.
     *
     * <p>필수 · 최대 1000자
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
        if (!(o instanceof BrandMessageCarouselTail)) {
            return false;
        }
        BrandMessageCarouselTail other = (BrandMessageCarouselTail) o;
        return Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(schemeIos, other.schemeIos)
                && Objects.equals(schemeAndroid, other.schemeAndroid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urlMobile, urlPc, schemeIos, schemeAndroid);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCarouselTail{", "}");
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

    /** Builder for {@link BrandMessageCarouselTail}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String urlMobile;
        private String urlPc;
        private String schemeIos;
        private String schemeAndroid;

        /** Creates an empty builder; same as {@link BrandMessageCarouselTail#builder()}. */
        public Builder() {
        }

        /**
         * 모바일 클릭 URL입니다. 최대 1,000자입니다.
         *
         * <p>필수 · 최대 1000자
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
         * @return a new immutable {@code BrandMessageCarouselTail}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCarouselTail build() {
            BrandMessageCarouselTail built = new BrandMessageCarouselTail(this);
            ModelValidator v = new ModelValidator("BrandMessageCarouselTail");
            v.required("urlMobile", built.urlMobile);
            v.maxLength("urlMobile", built.urlMobile, 1000);
            v.maxLength("urlPc", built.urlPc, 1000);
            v.maxLength("schemeIos", built.schemeIos, 1000);
            v.maxLength("schemeAndroid", built.schemeAndroid, 1000);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCarouselTail buildUnvalidated() {
            return new BrandMessageCarouselTail(this);
        }
    }
}
