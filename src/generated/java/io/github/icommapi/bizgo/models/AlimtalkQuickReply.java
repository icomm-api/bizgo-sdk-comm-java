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
 * 알림톡 바로연결 1개입니다.
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
@JsonDeserialize(builder = AlimtalkQuickReply.Builder.class)
@JsonPropertyOrder({"type", "name", "urlPc", "urlMobile", "schemeIos", "schemeAndroid", "chatExtra", "chatEvent", "bizFormId"})
public final class AlimtalkQuickReply {

    private final String type;
    private final String name;
    private final String urlPc;
    private final String urlMobile;
    private final String schemeIos;
    private final String schemeAndroid;
    private final String chatExtra;
    private final String chatEvent;
    private final String bizFormId;

    private AlimtalkQuickReply(Builder builder) {
        this.type = builder.type;
        this.name = builder.name;
        this.urlPc = builder.urlPc;
        this.urlMobile = builder.urlMobile;
        this.schemeIos = builder.schemeIos;
        this.schemeAndroid = builder.schemeAndroid;
        this.chatExtra = builder.chatExtra;
        this.chatEvent = builder.chatEvent;
        this.bizFormId = builder.bizFormId;
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
        builder.bizFormId = this.bizFormId;
        return builder;
    }

    /**
     * 바로연결 타입 코드입니다.
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
     * 바로연결 제목입니다. 템플릿 등록 규격상 최대 14자입니다.
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
     * PC 환경에서 클릭 시 이동할 URL입니다.
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
     * 봇/상담톡 전환 시 전달할 메타 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatExtra")
    public String getChatExtra() {
        return chatExtra;
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
     * 비즈폼 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizFormId")
    public String getBizFormId() {
        return bizFormId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkQuickReply)) {
            return false;
        }
        AlimtalkQuickReply other = (AlimtalkQuickReply) o;
        return Objects.equals(type, other.type)
                && Objects.equals(name, other.name)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(schemeIos, other.schemeIos)
                && Objects.equals(schemeAndroid, other.schemeAndroid)
                && Objects.equals(chatExtra, other.chatExtra)
                && Objects.equals(chatEvent, other.chatEvent)
                && Objects.equals(bizFormId, other.bizFormId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, urlPc, urlMobile, schemeIos, schemeAndroid, chatExtra, chatEvent, bizFormId);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkQuickReply{", "}");
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
        if (bizFormId != null) {
            joiner.add("bizFormId=" + io.github.icommapi.bizgo.internal.Masking.length(bizFormId));
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkQuickReply}. */
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
        private String bizFormId;

        /** Creates an empty builder; same as {@link AlimtalkQuickReply#builder()}. */
        public Builder() {
        }

        /**
         * 바로연결 타입 코드입니다.
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
         * 바로연결 제목입니다. 템플릿 등록 규격상 최대 14자입니다.
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
         * PC 환경에서 클릭 시 이동할 URL입니다.
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
         * 봇/상담톡 전환 시 전달할 메타 정보입니다.
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
         * 비즈폼 ID입니다.
         *
         * @param bizFormId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("bizFormId")
        public Builder bizFormId(String bizFormId) {
            this.bizFormId = bizFormId;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkQuickReply}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkQuickReply build() {
            AlimtalkQuickReply built = new AlimtalkQuickReply(this);
            ModelValidator v = new ModelValidator("AlimtalkQuickReply");
            v.required("type", built.type);
            v.required("name", built.name);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkQuickReply buildUnvalidated() {
            return new AlimtalkQuickReply(this);
        }
    }
}
