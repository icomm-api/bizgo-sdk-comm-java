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
 * 상담톡 바로연결입니다.
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
@JsonDeserialize(builder = CounselQuickReply.Builder.class)
@JsonPropertyOrder({"type", "name", "urlPc", "urlMobile", "schemeIos", "schemeAndroid", "urlTarget", "extra", "chatEvent"})
public final class CounselQuickReply {

    private final String type;
    private final String name;
    private final String urlPc;
    private final String urlMobile;
    private final String schemeIos;
    private final String schemeAndroid;
    private final String urlTarget;
    private final String extra;
    private final String chatEvent;

    private CounselQuickReply(Builder builder) {
        this.type = builder.type;
        this.name = builder.name;
        this.urlPc = builder.urlPc;
        this.urlMobile = builder.urlMobile;
        this.schemeIos = builder.schemeIos;
        this.schemeAndroid = builder.schemeAndroid;
        this.urlTarget = builder.urlTarget;
        this.extra = builder.extra;
        this.chatEvent = builder.chatEvent;
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
        builder.urlTarget = this.urlTarget;
        builder.extra = this.extra;
        builder.chatEvent = this.chatEvent;
        return builder;
    }

    /**
     * 카카오 바로연결 타입 코드입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 바로연결 타입 코드 목록이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 바로연결 제목입니다. 최대 14자입니다.
     *
     * <p>필수 · 최대 14자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
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
     * 모바일 환경에서 버튼 클릭 시 이동할 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
    }

    /**
     * iOS 환경에서 버튼 클릭 시 실행할 커스텀 스킴입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("schemeIos")
    public String getSchemeIos() {
        return schemeIos;
    }

    /**
     * Android 환경에서 버튼 클릭 시 실행할 커스텀 스킴입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("schemeAndroid")
    public String getSchemeAndroid() {
        return schemeAndroid;
    }

    /**
     * 외부 브라우저로 열려면 <code>out</code>을 입력합니다.
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
     * BK 버튼 발송 또는 상담톡/챗봇 전환 시 전달할 메타 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("extra")
    public String getExtra() {
        return extra;
    }

    /**
     * 봇 전환 시 연결할 봇 이벤트명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatEvent")
    public String getChatEvent() {
        return chatEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselQuickReply)) {
            return false;
        }
        CounselQuickReply other = (CounselQuickReply) o;
        return Objects.equals(type, other.type)
                && Objects.equals(name, other.name)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(schemeIos, other.schemeIos)
                && Objects.equals(schemeAndroid, other.schemeAndroid)
                && Objects.equals(urlTarget, other.urlTarget)
                && Objects.equals(extra, other.extra)
                && Objects.equals(chatEvent, other.chatEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, urlPc, urlMobile, schemeIos, schemeAndroid, urlTarget, extra, chatEvent);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselQuickReply{", "}");
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
        if (urlTarget != null) {
            joiner.add("urlTarget=" + io.github.icommapi.bizgo.internal.Masking.length(urlTarget));
        }
        if (extra != null) {
            joiner.add("extra=" + io.github.icommapi.bizgo.internal.Masking.length(extra));
        }
        if (chatEvent != null) {
            joiner.add("chatEvent=" + io.github.icommapi.bizgo.internal.Masking.length(chatEvent));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselQuickReply}. */
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
        private String urlTarget;
        private String extra;
        private String chatEvent;

        /** Creates an empty builder; same as {@link CounselQuickReply#builder()}. */
        public Builder() {
        }

        /**
         * 카카오 바로연결 타입 코드입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 바로연결 타입 코드 목록이 문서에 없습니다.
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
         * 바로연결 제목입니다. 최대 14자입니다.
         *
         * <p>필수 · 최대 14자
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
         * iOS 환경에서 버튼 클릭 시 실행할 커스텀 스킴입니다.
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
         * Android 환경에서 버튼 클릭 시 실행할 커스텀 스킴입니다.
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
         * 외부 브라우저로 열려면 <code>out</code>을 입력합니다.
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
         * BK 버튼 발송 또는 상담톡/챗봇 전환 시 전달할 메타 정보입니다.
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
         * 봇 전환 시 연결할 봇 이벤트명입니다.
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
         * Builds the object.
         *
         * @return a new immutable {@code CounselQuickReply}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselQuickReply build() {
            CounselQuickReply built = new CounselQuickReply(this);
            ModelValidator v = new ModelValidator("CounselQuickReply");
            v.required("type", built.type);
            v.required("name", built.name);
            v.maxLength("name", built.name, 14);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselQuickReply buildUnvalidated() {
            return new CounselQuickReply(this);
        }
    }
}
