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
 * 알림톡 대표 링크 정보입니다.
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
@JsonDeserialize(builder = AlimtalkLink.Builder.class)
@JsonPropertyOrder({"urlPc", "urlMobile", "schemeAndroid", "schemeIos"})
public final class AlimtalkLink {

    private final String urlPc;
    private final String urlMobile;
    private final String schemeAndroid;
    private final String schemeIos;

    private AlimtalkLink(Builder builder) {
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
        builder.urlPc = this.urlPc;
        builder.urlMobile = this.urlMobile;
        builder.schemeAndroid = this.schemeAndroid;
        builder.schemeIos = this.schemeIos;
        return builder;
    }

    /**
     * PC 환경에서 클릭 시 이동할 URL입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlPc")
    public String getUrlPc() {
        return urlPc;
    }

    /**
     * 모바일 환경에서 클릭 시 이동할 URL입니다.
     *
     * <p>필수
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
        if (!(o instanceof AlimtalkLink)) {
            return false;
        }
        AlimtalkLink other = (AlimtalkLink) o;
        return Objects.equals(urlPc, other.urlPc)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(schemeAndroid, other.schemeAndroid)
                && Objects.equals(schemeIos, other.schemeIos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urlPc, urlMobile, schemeAndroid, schemeIos);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkLink{", "}");
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

    /** Builder for {@link AlimtalkLink}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String urlPc;
        private String urlMobile;
        private String schemeAndroid;
        private String schemeIos;

        /** Creates an empty builder; same as {@link AlimtalkLink#builder()}. */
        public Builder() {
        }

        /**
         * PC 환경에서 클릭 시 이동할 URL입니다.
         *
         * <p>필수
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
         * 모바일 환경에서 클릭 시 이동할 URL입니다.
         *
         * <p>필수
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
         * @return a new immutable {@code AlimtalkLink}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkLink build() {
            AlimtalkLink built = new AlimtalkLink(this);
            ModelValidator v = new ModelValidator("AlimtalkLink");
            v.required("urlPc", built.urlPc);
            v.required("urlMobile", built.urlMobile);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkLink buildUnvalidated() {
            return new AlimtalkLink(this);
        }
    }
}
