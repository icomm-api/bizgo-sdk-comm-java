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
 * 브랜드메시지 쿠폰 요소입니다.
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
@JsonDeserialize(builder = BrandMessageCoupon.Builder.class)
@JsonPropertyOrder({"title", "description", "urlPc", "urlMobile", "schemeAndroid", "schemeIos"})
public final class BrandMessageCoupon {

    private final String title;
    private final String description;
    private final String urlPc;
    private final String urlMobile;
    private final String schemeAndroid;
    private final String schemeIos;

    private BrandMessageCoupon(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.urlPc = builder.urlPc;
        this.urlMobile = builder.urlMobile;
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
        builder.title = this.title;
        builder.description = this.description;
        builder.urlPc = this.urlPc;
        builder.urlMobile = this.urlMobile;
        builder.schemeAndroid = this.schemeAndroid;
        builder.schemeIos = this.schemeIos;
        return builder;
    }

    /**
     * 쿠폰명입니다. <code>$&#123;n&#125;원 할인</code>, <code>$&#123;n&#125;% 할인</code>, <code>배송비 할인</code>, <code>$&#123;7자 이내&#125; 무료</code>, <code>$&#123;7자 이내&#125; UP</code> 형식을 지원합니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 쿠폰 상세 정보입니다. 와이드(FW)·와이드 리스트(FL)·프리미엄 동영상(FP)은 최대 18자, 그 외(캐러셀 아이템 포함)는 최대 12자입니다.
     *
     * <p>필수 · 최대 18자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * PC 클릭 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlPc")
    public String getUrlPc() {
        return urlPc;
    }

    /**
     * 모바일 클릭 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
    }

    /**
     * Android 커스텀 스킴입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("schemeAndroid")
    public String getSchemeAndroid() {
        return schemeAndroid;
    }

    /**
     * iOS 커스텀 스킴입니다.
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
        if (!(o instanceof BrandMessageCoupon)) {
            return false;
        }
        BrandMessageCoupon other = (BrandMessageCoupon) o;
        return Objects.equals(title, other.title)
                && Objects.equals(description, other.description)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(schemeAndroid, other.schemeAndroid)
                && Objects.equals(schemeIos, other.schemeIos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, urlPc, urlMobile, schemeAndroid, schemeIos);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCoupon{", "}");
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (description != null) {
            joiner.add("description=" + io.github.icommapi.bizgo.internal.Masking.length(description));
        }
        if (urlPc != null) {
            joiner.add("urlPc=" + io.github.icommapi.bizgo.internal.Masking.length(urlPc));
        }
        if (urlMobile != null) {
            joiner.add("urlMobile=" + io.github.icommapi.bizgo.internal.Masking.length(urlMobile));
        }
        if (schemeAndroid != null) {
            joiner.add("schemeAndroid=" + io.github.icommapi.bizgo.internal.Masking.length(schemeAndroid));
        }
        if (schemeIos != null) {
            joiner.add("schemeIos=" + io.github.icommapi.bizgo.internal.Masking.length(schemeIos));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCoupon}. */
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
        private String urlPc;
        private String urlMobile;
        private String schemeAndroid;
        private String schemeIos;

        /** Creates an empty builder; same as {@link BrandMessageCoupon#builder()}. */
        public Builder() {
        }

        /**
         * 쿠폰명입니다. <code>$&#123;n&#125;원 할인</code>, <code>$&#123;n&#125;% 할인</code>, <code>배송비 할인</code>, <code>$&#123;7자 이내&#125; 무료</code>, <code>$&#123;7자 이내&#125; UP</code> 형식을 지원합니다.
         *
         * <p>필수
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
         * 쿠폰 상세 정보입니다. 와이드(FW)·와이드 리스트(FL)·프리미엄 동영상(FP)은 최대 18자, 그 외(캐러셀 아이템 포함)는 최대 12자입니다.
         *
         * <p>필수 · 최대 18자
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
         * PC 클릭 URL입니다.
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
         * 모바일 클릭 URL입니다.
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
         * Android 커스텀 스킴입니다.
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
         * iOS 커스텀 스킴입니다.
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
         * @return a new immutable {@code BrandMessageCoupon}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCoupon build() {
            BrandMessageCoupon built = new BrandMessageCoupon(this);
            ModelValidator v = new ModelValidator("BrandMessageCoupon");
            v.required("title", built.title);
            v.required("description", built.description);
            v.maxLength("description", built.description, 18);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCoupon buildUnvalidated() {
            return new BrandMessageCoupon(this);
        }
    }
}
