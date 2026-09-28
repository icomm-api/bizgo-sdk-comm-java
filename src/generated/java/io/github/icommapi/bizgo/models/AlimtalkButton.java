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
 * 알림톡 버튼입니다. 버튼 타입에 따라 필요한 필드가 다릅니다.
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
@JsonDeserialize(builder = AlimtalkButton.Builder.class)
@JsonPropertyOrder({"type", "name", "urlPc", "urlMobile", "schemeIos", "schemeAndroid", "target", "chatExtra", "chatEvent", "pluginId", "relayId", "oneclickId", "productId", "bizFormKey", "bizFormId", "telNumber"})
public final class AlimtalkButton {

    private final String type;
    private final String name;
    private final String urlPc;
    private final String urlMobile;
    private final String schemeIos;
    private final String schemeAndroid;
    private final String target;
    private final String chatExtra;
    private final String chatEvent;
    private final String pluginId;
    private final String relayId;
    private final String oneclickId;
    private final String productId;
    private final String bizFormKey;
    private final String bizFormId;
    private final String telNumber;

    private AlimtalkButton(Builder builder) {
        this.type = builder.type;
        this.name = builder.name;
        this.urlPc = builder.urlPc;
        this.urlMobile = builder.urlMobile;
        this.schemeIos = builder.schemeIos;
        this.schemeAndroid = builder.schemeAndroid;
        this.target = builder.target;
        this.chatExtra = builder.chatExtra;
        this.chatEvent = builder.chatEvent;
        this.pluginId = builder.pluginId;
        this.relayId = builder.relayId;
        this.oneclickId = builder.oneclickId;
        this.productId = builder.productId;
        this.bizFormKey = builder.bizFormKey;
        this.bizFormId = builder.bizFormId;
        this.telNumber = builder.telNumber;
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
        builder.target = this.target;
        builder.chatExtra = this.chatExtra;
        builder.chatEvent = this.chatEvent;
        builder.pluginId = this.pluginId;
        builder.relayId = this.relayId;
        builder.oneclickId = this.oneclickId;
        builder.productId = this.productId;
        builder.bizFormKey = this.bizFormKey;
        builder.bizFormId = this.bizFormId;
        builder.telNumber = this.telNumber;
        return builder;
    }

    /**
     * 카카오 버튼 타입 코드입니다. 문서 예시에 나온 값은 <code>WL</code>(웹 링크)입니다.
     *
     * <p>필수 · 알려진 값 <code>WL</code>
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
     * 카카오 버튼명입니다.
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
     * 웹 링크 버튼의 target 값입니다. <code>type</code>이 <code>WL</code>이고 <code>target</code>이 <code>out</code>이면 아웃링크로 동작합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("target")
    public String getTarget() {
        return target;
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
     * 비즈플러그인 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("pluginId")
    public String getPluginId() {
        return pluginId;
    }

    /**
     * 비즈플러그인 relay ID입니다. 비즈플러그인 실행 시 <code>X-Kakao-Plugin-Relay-Id</code> 헤더로 전달됩니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("relayId")
    public String getRelayId() {
        return relayId;
    }

    /**
     * 원클릭 결제 정보 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("oneclickId")
    public String getOneclickId() {
        return oneclickId;
    }

    /**
     * 원클릭 결제 상품 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("productId")
    public String getProductId() {
        return productId;
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

    /**
     * 비즈폼 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizFormId")
    public String getBizFormId() {
        return bizFormId;
    }

    /**
     * 전화번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("telNumber")
    public String getTelNumber() {
        return telNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkButton)) {
            return false;
        }
        AlimtalkButton other = (AlimtalkButton) o;
        return Objects.equals(type, other.type)
                && Objects.equals(name, other.name)
                && Objects.equals(urlPc, other.urlPc)
                && Objects.equals(urlMobile, other.urlMobile)
                && Objects.equals(schemeIos, other.schemeIos)
                && Objects.equals(schemeAndroid, other.schemeAndroid)
                && Objects.equals(target, other.target)
                && Objects.equals(chatExtra, other.chatExtra)
                && Objects.equals(chatEvent, other.chatEvent)
                && Objects.equals(pluginId, other.pluginId)
                && Objects.equals(relayId, other.relayId)
                && Objects.equals(oneclickId, other.oneclickId)
                && Objects.equals(productId, other.productId)
                && Objects.equals(bizFormKey, other.bizFormKey)
                && Objects.equals(bizFormId, other.bizFormId)
                && Objects.equals(telNumber, other.telNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, urlPc, urlMobile, schemeIos, schemeAndroid, target, chatExtra, chatEvent, pluginId, relayId, oneclickId, productId, bizFormKey, bizFormId, telNumber);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkButton{", "}");
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
        if (target != null) {
            joiner.add("target=" + io.github.icommapi.bizgo.internal.Masking.length(target));
        }
        if (chatExtra != null) {
            joiner.add("chatExtra=" + io.github.icommapi.bizgo.internal.Masking.length(chatExtra));
        }
        if (chatEvent != null) {
            joiner.add("chatEvent=" + io.github.icommapi.bizgo.internal.Masking.length(chatEvent));
        }
        if (pluginId != null) {
            joiner.add("pluginId=" + io.github.icommapi.bizgo.internal.Masking.length(pluginId));
        }
        if (relayId != null) {
            joiner.add("relayId=" + io.github.icommapi.bizgo.internal.Masking.length(relayId));
        }
        if (oneclickId != null) {
            joiner.add("oneclickId=" + io.github.icommapi.bizgo.internal.Masking.length(oneclickId));
        }
        if (productId != null) {
            joiner.add("productId=" + io.github.icommapi.bizgo.internal.Masking.length(productId));
        }
        if (bizFormKey != null) {
            joiner.add("bizFormKey=" + io.github.icommapi.bizgo.internal.Masking.length(bizFormKey));
        }
        if (bizFormId != null) {
            joiner.add("bizFormId=" + io.github.icommapi.bizgo.internal.Masking.length(bizFormId));
        }
        if (telNumber != null) {
            joiner.add("telNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(telNumber));
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkButton}. */
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
        private String target;
        private String chatExtra;
        private String chatEvent;
        private String pluginId;
        private String relayId;
        private String oneclickId;
        private String productId;
        private String bizFormKey;
        private String bizFormId;
        private String telNumber;

        /** Creates an empty builder; same as {@link AlimtalkButton#builder()}. */
        public Builder() {
        }

        /**
         * 카카오 버튼 타입 코드입니다. 문서 예시에 나온 값은 <code>WL</code>(웹 링크)입니다.
         *
         * <p>필수 · 알려진 값 <code>WL</code>
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
         * 카카오 버튼명입니다.
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
         * 웹 링크 버튼의 target 값입니다. <code>type</code>이 <code>WL</code>이고 <code>target</code>이 <code>out</code>이면 아웃링크로 동작합니다.
         *
         * @param target the value (null clears it)
         * @return this builder
         */
        @JsonProperty("target")
        public Builder target(String target) {
            this.target = target;
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
         * 비즈플러그인 ID입니다.
         *
         * @param pluginId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("pluginId")
        public Builder pluginId(String pluginId) {
            this.pluginId = pluginId;
            return this;
        }

        /**
         * 비즈플러그인 relay ID입니다. 비즈플러그인 실행 시 <code>X-Kakao-Plugin-Relay-Id</code> 헤더로 전달됩니다.
         *
         * @param relayId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("relayId")
        public Builder relayId(String relayId) {
            this.relayId = relayId;
            return this;
        }

        /**
         * 원클릭 결제 정보 ID입니다.
         *
         * @param oneclickId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("oneclickId")
        public Builder oneclickId(String oneclickId) {
            this.oneclickId = oneclickId;
            return this;
        }

        /**
         * 원클릭 결제 상품 ID입니다.
         *
         * @param productId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("productId")
        public Builder productId(String productId) {
            this.productId = productId;
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
         * 전화번호입니다.
         *
         * @param telNumber the value (null clears it)
         * @return this builder
         */
        @JsonProperty("telNumber")
        public Builder telNumber(String telNumber) {
            this.telNumber = telNumber;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkButton}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkButton build() {
            AlimtalkButton built = new AlimtalkButton(this);
            ModelValidator v = new ModelValidator("AlimtalkButton");
            v.required("type", built.type);
            v.required("name", built.name);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkButton buildUnvalidated() {
            return new AlimtalkButton(this);
        }
    }
}
