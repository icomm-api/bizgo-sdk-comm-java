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
 * 브랜드메시지 버튼입니다.
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
@JsonDeserialize(builder = BrandMessageButton.Builder.class)
@JsonPropertyOrder({"type", "name", "urlPc", "urlMobile", "schemeIos", "schemeAndroid", "chatExtra", "chatEvent", "bizFormKey"})
public final class BrandMessageButton {

    private final String type;
    private final String name;
    private final String urlPc;
    private final String urlMobile;
    private final String schemeIos;
    private final String schemeAndroid;
    private final String chatExtra;
    private final String chatEvent;
    private final String bizFormKey;

    private BrandMessageButton(Builder builder) {
        this.type = builder.type;
        this.name = builder.name;
        this.urlPc = builder.urlPc;
        this.urlMobile = builder.urlMobile;
        this.schemeIos = builder.schemeIos;
        this.schemeAndroid = builder.schemeAndroid;
        this.chatExtra = builder.chatExtra;
        this.chatEvent = builder.chatEvent;
        this.bizFormKey = builder.bizFormKey;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.name = this.name;
        builder.urlPc = this.urlPc;
        builder.urlMobile = this.urlMobile;
        builder.schemeIos = this.schemeIos;
        builder.schemeAndroid = this.schemeAndroid;
        builder.chatExtra = this.chatExtra;
        builder.chatEvent = this.chatEvent;
        builder.bizFormKey = this.bizFormKey;
        return builder;
    }

    /**
     * 버튼 타입입니다. 문서에 언급된 값은 <code>WL</code>, <code>AL</code>입니다.
     *
     * <p>필수 · 알려진 값 <code>WL</code>, <code>AL</code>
     *
     * <p><b>확인 필요:</b> 버튼 타입 코드 전체 목록이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 버튼명입니다. 최대 28자입니다.
     *
     * <p>최대 28자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * PC 클릭 URL입니다. <code>WL</code> 타입에서 필수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlPc")
    public String getUrlPc() {
        return urlPc;
    }

    /**
     * 모바일 클릭 URL입니다. <code>WL</code>, <code>AL</code> 타입에서 필수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
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
     * 봇/상담톡 메타데이터입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatExtra")
    public String getChatExtra() {
        return chatExtra;
    }

    /**
     * 봇/상담톡 이벤트명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatEvent")
    public String getChatEvent() {
        return chatEvent;
    }

    /**
     * 비즈폼 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizFormKey")
    public String getBizFormKey() {
        return bizFormKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageButton)) {
            return false;
        }
        BrandMessageButton other = (BrandMessageButton) o;
        return Objects.equals(type, other.type)
                && Objects.equals(name, other.name)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(schemeIos, other.schemeIos)
                && Objects.equals(schemeAndroid, other.schemeAndroid)
                && Objects.equals(chatExtra, other.chatExtra)
                && Objects.equals(chatEvent, other.chatEvent)
                && Objects.equals(bizFormKey, other.bizFormKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, urlPc, urlMobile, schemeIos, schemeAndroid, chatExtra, chatEvent, bizFormKey);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageButton{", "}");
        if (type != null) {
            joiner.add("type=" + type);
        }
        if (name != null) {
            joiner.add("name=" + io.github.icommapi.bizgo.internal.Masking.length(name));
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
        if (chatExtra != null) {
            joiner.add("chatExtra=" + io.github.icommapi.bizgo.internal.Masking.length(chatExtra));
        }
        if (chatEvent != null) {
            joiner.add("chatEvent=" + io.github.icommapi.bizgo.internal.Masking.length(chatEvent));
        }
        if (bizFormKey != null) {
            joiner.add("bizFormKey=" + io.github.icommapi.bizgo.internal.Masking.length(bizFormKey));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageButton}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String type;
        private String name;
        private String urlPc;
        private String urlMobile;
        private String schemeIos;
        private String schemeAndroid;
        private String chatExtra;
        private String chatEvent;
        private String bizFormKey;

        /** Creates an empty builder; same as {@link BrandMessageButton#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 타입입니다. 문서에 언급된 값은 <code>WL</code>, <code>AL</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>WL</code>, <code>AL</code>
         *
         * <p><b>확인 필요:</b> 버튼 타입 코드 전체 목록이 문서에 없습니다.
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
         * 버튼명입니다. 최대 28자입니다.
         *
         * <p>최대 28자
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
         * PC 클릭 URL입니다. <code>WL</code> 타입에서 필수입니다.
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
         * 모바일 클릭 URL입니다. <code>WL</code>, <code>AL</code> 타입에서 필수입니다.
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
         * 봇/상담톡 메타데이터입니다.
         *
         * @param chatExtra the value (null clears it)
         * @return this builder
         */
        @JsonProperty("chatExtra")
        public Builder chatExtra(String chatExtra) {
            this.chatExtra = chatExtra;
            return this;
        }

        /**
         * 봇/상담톡 이벤트명입니다.
         *
         * @param chatEvent the value (null clears it)
         * @return this builder
         */
        @JsonProperty("chatEvent")
        public Builder chatEvent(String chatEvent) {
            this.chatEvent = chatEvent;
            return this;
        }

        /**
         * 비즈폼 키입니다.
         *
         * @param bizFormKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("bizFormKey")
        public Builder bizFormKey(String bizFormKey) {
            this.bizFormKey = bizFormKey;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageButton}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageButton build() {
            BrandMessageButton built = new BrandMessageButton(this);
            ModelValidator v = new ModelValidator("BrandMessageButton");
            v.required("type", built.type);
            v.maxLength("name", built.name, 28);
            RequiredIf.checkObject(v, "BrandMessageButton", built); // x-sdk-required-if
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageButton buildUnvalidated() {
            return new BrandMessageButton(this);
        }
    }
}
