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
 * 메시지(또는 캐러셀 아이템) 최하단에 노출되는 쿠폰 요소입니다.
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
@JsonDeserialize(builder = CounselCoupon.Builder.class)
@JsonPropertyOrder({"title", "description", "urlPc", "urlMobile", "schemeIos", "schemeAndroid"})
public final class CounselCoupon {

    private final String title;
    private final String description;
    private final String urlPc;
    private final String urlMobile;
    private final String schemeIos;
    private final String schemeAndroid;

    private CounselCoupon(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.urlPc = builder.urlPc;
        this.urlMobile = builder.urlMobile;
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
        builder.description = this.description;
        builder.urlPc = this.urlPc;
        builder.urlMobile = this.urlMobile;
        builder.schemeIos = this.schemeIos;
        builder.schemeAndroid = this.schemeAndroid;
        return builder;
    }

    /**
     * 쿠폰 이름입니다. 문서상 정해진 5가지 형식 중 하나여야 합니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 문서가 5가지 형식 중 하나라고만 하고 형식 목록을 싣지 않았습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 쿠폰 상세 설명입니다. WIDE, WIDE_ITEM_LIST 타입은 최대 18자, 그 외 타입은 최대 12자입니다(캐러셀 쿠폰 설명에는 PREMIUM_VIDEO도 18자로 적혀 있습니다).
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
     * PC 환경에서 쿠폰 클릭 시 이동할 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlPc")
    public String getUrlPc() {
        return urlPc;
    }

    /**
     * 모바일 환경에서 쿠폰 클릭 시 이동할 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
    }

    /**
     * iOS 환경에서 쿠폰 클릭 시 실행할 커스텀 스킴입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("schemeIos")
    public String getSchemeIos() {
        return schemeIos;
    }

    /**
     * Android 환경에서 쿠폰 클릭 시 실행할 커스텀 스킴입니다.
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
        if (!(o instanceof CounselCoupon)) {
            return false;
        }
        CounselCoupon other = (CounselCoupon) o;
        return Objects.equals(title, other.title)
                && Objects.equals(description, other.description)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(schemeIos, other.schemeIos)
                && Objects.equals(schemeAndroid, other.schemeAndroid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, urlPc, urlMobile, schemeIos, schemeAndroid);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselCoupon{", "}");
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
        if (schemeIos != null) {
            joiner.add("schemeIos=" + io.github.icommapi.bizgo.internal.Masking.length(schemeIos));
        }
        if (schemeAndroid != null) {
            joiner.add("schemeAndroid=" + io.github.icommapi.bizgo.internal.Masking.length(schemeAndroid));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselCoupon}. */
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
        private String schemeIos;
        private String schemeAndroid;

        /** Creates an empty builder; same as {@link CounselCoupon#builder()}. */
        public Builder() {
        }

        /**
         * 쿠폰 이름입니다. 문서상 정해진 5가지 형식 중 하나여야 합니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 문서가 5가지 형식 중 하나라고만 하고 형식 목록을 싣지 않았습니다.
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
         * 쿠폰 상세 설명입니다. WIDE, WIDE_ITEM_LIST 타입은 최대 18자, 그 외 타입은 최대 12자입니다(캐러셀 쿠폰 설명에는 PREMIUM_VIDEO도 18자로 적혀 있습니다).
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
         * PC 환경에서 쿠폰 클릭 시 이동할 URL입니다.
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
         * 모바일 환경에서 쿠폰 클릭 시 이동할 URL입니다.
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
         * iOS 환경에서 쿠폰 클릭 시 실행할 커스텀 스킴입니다.
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
         * Android 환경에서 쿠폰 클릭 시 실행할 커스텀 스킴입니다.
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
         * @return a new immutable {@code CounselCoupon}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselCoupon build() {
            CounselCoupon built = new CounselCoupon(this);
            ModelValidator v = new ModelValidator("CounselCoupon");
            v.required("title", built.title);
            v.required("description", built.description);
            v.maxLength("description", built.description, 18);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselCoupon buildUnvalidated() {
            return new CounselCoupon(this);
        }
    }
}
