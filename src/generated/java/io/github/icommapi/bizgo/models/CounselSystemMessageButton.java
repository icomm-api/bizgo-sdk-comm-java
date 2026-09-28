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
 * 시스템 메시지 하단 버튼입니다.
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
@JsonDeserialize(builder = CounselSystemMessageButton.Builder.class)
@JsonPropertyOrder({"ordering", "type", "name", "urlMobile", "urlPc", "schemeIos", "schemeAndroid"})
public final class CounselSystemMessageButton {

    private final Integer ordering;
    private final String type;
    private final String name;
    private final String urlMobile;
    private final String urlPc;
    private final String schemeIos;
    private final String schemeAndroid;

    private CounselSystemMessageButton(Builder builder) {
        this.ordering = builder.ordering;
        this.type = builder.type;
        this.name = builder.name;
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
        builder.ordering = this.ordering;
        builder.type = this.type;
        builder.name = this.name;
        builder.urlMobile = this.urlMobile;
        builder.urlPc = this.urlPc;
        builder.schemeIos = this.schemeIos;
        builder.schemeAndroid = this.schemeAndroid;
        return builder;
    }

    /**
     * 버튼 노출 순서입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ordering")
    public Integer getOrdering() {
        return ordering;
    }

    /**
     * 시스템 메시지 버튼 링크 타입입니다. 문서 예시 값은 <code>WL</code>입니다.
     *
     * <p>필수 · 알려진 값 <code>WL</code>
     *
     * <p><b>확인 필요:</b> 시스템 메시지 버튼 타입 목록이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 버튼 이름입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 모바일 웹링크 주소입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
    }

    /**
     * PC 웹링크 주소입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlPc")
    public String getUrlPc() {
        return urlPc;
    }

    /**
     * iOS 앱링크 주소입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("schemeIos")
    public String getSchemeIos() {
        return schemeIos;
    }

    /**
     * Android 앱링크 주소입니다.
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
        if (!(o instanceof CounselSystemMessageButton)) {
            return false;
        }
        CounselSystemMessageButton other = (CounselSystemMessageButton) o;
        return Objects.equals(ordering, other.ordering)
                && Objects.equals(type, other.type)
                && Objects.equals(name, other.name)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(schemeIos, other.schemeIos)
                && Objects.equals(schemeAndroid, other.schemeAndroid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordering, type, name, urlMobile, urlPc, schemeIos, schemeAndroid);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselSystemMessageButton{", "}");
        if (ordering != null) {
            joiner.add("ordering=***");
        }
        if (type != null) {
            joiner.add("type=" + type);
        }
        if (name != null) {
            joiner.add("name=" + io.github.icommapi.bizgo.internal.Masking.length(name));
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

    /** Builder for {@link CounselSystemMessageButton}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Integer ordering;
        private String type;
        private String name;
        private String urlMobile;
        private String urlPc;
        private String schemeIos;
        private String schemeAndroid;

        /** Creates an empty builder; same as {@link CounselSystemMessageButton#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 노출 순서입니다.
         *
         * <p>필수
         *
         * @param ordering the value (null clears it)
         * @return this builder
         */
        @JsonProperty("ordering")
        public Builder ordering(Integer ordering) {
            this.ordering = ordering;
            return this;
        }

        /**
         * 시스템 메시지 버튼 링크 타입입니다. 문서 예시 값은 <code>WL</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>WL</code>
         *
         * <p><b>확인 필요:</b> 시스템 메시지 버튼 타입 목록이 문서에 없습니다.
         *
         * @param type the value (null clears it)
         * @return this builder
         */
        @JsonProperty("type")
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 버튼 이름입니다.
         *
         * <p>필수
         *
         * @param name the value (null clears it)
         * @return this builder
         */
        @JsonProperty("name")
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * 모바일 웹링크 주소입니다.
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
         * PC 웹링크 주소입니다.
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
         * iOS 앱링크 주소입니다.
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
         * Android 앱링크 주소입니다.
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
         * @return a new immutable {@code CounselSystemMessageButton}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselSystemMessageButton build() {
            CounselSystemMessageButton built = new CounselSystemMessageButton(this);
            ModelValidator v = new ModelValidator("CounselSystemMessageButton");
            v.required("ordering", built.ordering);
            v.required("type", built.type);
            v.required("name", built.name);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselSystemMessageButton buildUnvalidated() {
            return new CounselSystemMessageButton(this);
        }
    }
}
