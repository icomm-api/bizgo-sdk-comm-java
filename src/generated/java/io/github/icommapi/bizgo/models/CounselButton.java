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
 * 상담톡 Rich 메시지·캐러셀 버튼입니다. 버튼 타입에 따라 필요한 필드가 다릅니다.
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
@JsonDeserialize(builder = CounselButton.Builder.class)
@JsonPropertyOrder({"type", "name", "urlMobile", "urlPc", "schemeIos", "schemeAndroid", "urlTarget", "extra", "chatEvent", "startType", "bizFormKey"})
public final class CounselButton {

    private final String type;
    private final String name;
    private final String urlMobile;
    private final String urlPc;
    private final String schemeIos;
    private final String schemeAndroid;
    private final String urlTarget;
    private final String extra;
    private final String chatEvent;
    private final String startType;
    private final String bizFormKey;

    private CounselButton(Builder builder) {
        this.type = builder.type;
        this.name = builder.name;
        this.urlMobile = builder.urlMobile;
        this.urlPc = builder.urlPc;
        this.schemeIos = builder.schemeIos;
        this.schemeAndroid = builder.schemeAndroid;
        this.urlTarget = builder.urlTarget;
        this.extra = builder.extra;
        this.chatEvent = builder.chatEvent;
        this.startType = builder.startType;
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
        builder.urlMobile = this.urlMobile;
        builder.urlPc = this.urlPc;
        builder.schemeIos = this.schemeIos;
        builder.schemeAndroid = this.schemeAndroid;
        builder.urlTarget = this.urlTarget;
        builder.extra = this.extra;
        builder.chatEvent = this.chatEvent;
        builder.startType = this.startType;
        builder.bizFormKey = this.bizFormKey;
        return builder;
    }

    /**
     * 카카오 버튼 타입 코드입니다. 문서에 나온 값은 <code>WL</code>(웹 링크, 예시)과 <code>BF</code>(비즈폼)입니다.
     *
     * <p>필수 · 알려진 값 <code>WL</code>, <code>BF</code>
     *
     * <p><b>확인 필요:</b> 버튼 타입 코드 전체 목록과 타입별 필수 필드가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 버튼명입니다.
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
     * 모바일 환경에서 버튼 클릭 시 이동할 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
    }

    /**
     * PC 환경에서 버튼 클릭 시 이동할 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlPc")
    public String getUrlPc() {
        return urlPc;
    }

    /**
     * iOS 환경에서 버튼 클릭 시 실행할 application custom scheme입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("schemeIos")
    public String getSchemeIos() {
        return schemeIos;
    }

    /**
     * Android 환경에서 버튼 클릭 시 실행할 application custom scheme입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("schemeAndroid")
    public String getSchemeAndroid() {
        return schemeAndroid;
    }

    /**
     * WL 타입에서 외부 브라우저로 열려면 <code>out</code>을 입력합니다.
     *
     * <p>알려진 값 <code>out</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlTarget")
    public String getUrlTarget() {
        return urlTarget;
    }

    /**
     * 봇/상담톡 전환 시 전달할 메타 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("extra")
    public String getExtra() {
        return extra;
    }

    /**
     * 봇/상담톡 전환 시 연결할 이벤트명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatEvent")
    public String getChatEvent() {
        return chatEvent;
    }

    /**
     * 상담 시작 타입입니다.
     *
     * <p><b>확인 필요:</b> startType 값 목록이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("startType")
    public String getStartType() {
        return startType;
    }

    /**
     * 비즈폼 키입니다. BF 타입에서 사용합니다.
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
        if (!(o instanceof CounselButton)) {
            return false;
        }
        CounselButton other = (CounselButton) o;
        return Objects.equals(type, other.type)
                && Objects.equals(name, other.name)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(schemeIos, other.schemeIos)
                && Objects.equals(schemeAndroid, other.schemeAndroid)
                && Objects.equals(urlTarget, other.urlTarget)
                && Objects.equals(extra, other.extra)
                && Objects.equals(chatEvent, other.chatEvent)
                && Objects.equals(startType, other.startType)
                && Objects.equals(bizFormKey, other.bizFormKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, urlMobile, urlPc, schemeIos, schemeAndroid, urlTarget, extra, chatEvent, startType, bizFormKey);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselButton{", "}");
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
        if (urlTarget != null) {
            joiner.add("urlTarget=" + io.github.icommapi.bizgo.internal.Masking.length(urlTarget));
        }
        if (extra != null) {
            joiner.add("extra=" + io.github.icommapi.bizgo.internal.Masking.length(extra));
        }
        if (chatEvent != null) {
            joiner.add("chatEvent=" + io.github.icommapi.bizgo.internal.Masking.length(chatEvent));
        }
        if (startType != null) {
            joiner.add("startType=" + io.github.icommapi.bizgo.internal.Masking.length(startType));
        }
        if (bizFormKey != null) {
            joiner.add("bizFormKey=" + io.github.icommapi.bizgo.internal.Masking.length(bizFormKey));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselButton}. */
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
        private String urlMobile;
        private String urlPc;
        private String schemeIos;
        private String schemeAndroid;
        private String urlTarget;
        private String extra;
        private String chatEvent;
        private String startType;
        private String bizFormKey;

        /** Creates an empty builder; same as {@link CounselButton#builder()}. */
        public Builder() {
        }

        /**
         * 카카오 버튼 타입 코드입니다. 문서에 나온 값은 <code>WL</code>(웹 링크, 예시)과 <code>BF</code>(비즈폼)입니다.
         *
         * <p>필수 · 알려진 값 <code>WL</code>, <code>BF</code>
         *
         * <p><b>확인 필요:</b> 버튼 타입 코드 전체 목록과 타입별 필수 필드가 문서에 없습니다.
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
         * 버튼명입니다.
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
         * 모바일 환경에서 버튼 클릭 시 이동할 URL입니다.
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
         * PC 환경에서 버튼 클릭 시 이동할 URL입니다.
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
         * iOS 환경에서 버튼 클릭 시 실행할 application custom scheme입니다.
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
         * Android 환경에서 버튼 클릭 시 실행할 application custom scheme입니다.
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
         * WL 타입에서 외부 브라우저로 열려면 <code>out</code>을 입력합니다.
         *
         * <p>알려진 값 <code>out</code>
         *
         * @param urlTarget the value (null clears it)
         * @return this builder
         */
        @JsonProperty("urlTarget")
        public Builder urlTarget(String urlTarget) {
            this.urlTarget = urlTarget;
            return this;
        }

        /**
         * 봇/상담톡 전환 시 전달할 메타 정보입니다.
         *
         * @param extra the value (null clears it)
         * @return this builder
         */
        @JsonProperty("extra")
        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        /**
         * 봇/상담톡 전환 시 연결할 이벤트명입니다.
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
         * 상담 시작 타입입니다.
         *
         * <p><b>확인 필요:</b> startType 값 목록이 문서에 없습니다.
         *
         * @param startType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("startType")
        public Builder startType(String startType) {
            this.startType = startType;
            return this;
        }

        /**
         * 비즈폼 키입니다. BF 타입에서 사용합니다.
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
         * @return a new immutable {@code CounselButton}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselButton build() {
            CounselButton built = new CounselButton(this);
            ModelValidator v = new ModelValidator("CounselButton");
            v.required("type", built.type);
            v.required("name", built.name);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselButton buildUnvalidated() {
            return new CounselButton(this);
        }
    }
}
