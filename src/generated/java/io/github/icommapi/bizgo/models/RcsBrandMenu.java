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
 * 브랜드 홈 메뉴입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> buttonType에 들어갈 수 있는 값과 applink·weblink 사용 조건이 문서화되어 있지 않습니다.
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
@JsonDeserialize(builder = RcsBrandMenu.Builder.class)
@JsonPropertyOrder({"buttonType", "applink", "weblink"})
public final class RcsBrandMenu {

    private final String buttonType;
    private final String applink;
    private final String weblink;

    private RcsBrandMenu(Builder builder) {
        this.buttonType = builder.buttonType;
        this.applink = builder.applink;
        this.weblink = builder.weblink;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.buttonType = this.buttonType;
        builder.applink = this.applink;
        builder.weblink = this.weblink;
        return builder;
    }

    /**
     * 버튼 타입입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttonType")
    public String getButtonType() {
        return buttonType;
    }

    /**
     * 앱 링크입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("applink")
    public String getApplink() {
        return applink;
    }

    /**
     * 웹 링크입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("weblink")
    public String getWeblink() {
        return weblink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsBrandMenu)) {
            return false;
        }
        RcsBrandMenu other = (RcsBrandMenu) o;
        return Objects.equals(buttonType, other.buttonType)
                && Objects.equals(applink, other.applink)
                && Objects.equals(weblink, other.weblink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonType, applink, weblink);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsBrandMenu{", "}");
        if (buttonType != null) {
            joiner.add("buttonType=" + io.github.icommapi.bizgo.internal.Masking.length(buttonType));
        }
        if (applink != null) {
            joiner.add("applink=" + io.github.icommapi.bizgo.internal.Masking.length(applink));
        }
        if (weblink != null) {
            joiner.add("weblink=" + io.github.icommapi.bizgo.internal.Masking.length(weblink));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsBrandMenu}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String buttonType;
        private String applink;
        private String weblink;

        /** Creates an empty builder; same as {@link RcsBrandMenu#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 타입입니다.
         *
         * @param buttonType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("buttonType")
        public Builder buttonType(String buttonType) {
            this.buttonType = buttonType;
            return this;
        }

        /**
         * 앱 링크입니다.
         *
         * @param applink the value (null clears it)
         * @return this builder
         */
        @JsonProperty("applink")
        public Builder applink(String applink) {
            this.applink = applink;
            return this;
        }

        /**
         * 웹 링크입니다.
         *
         * @param weblink the value (null clears it)
         * @return this builder
         */
        @JsonProperty("weblink")
        public Builder weblink(String weblink) {
            this.weblink = weblink;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsBrandMenu}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsBrandMenu build() {
            RcsBrandMenu built = new RcsBrandMenu(this);
            ModelValidator v = new ModelValidator("RcsBrandMenu");
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsBrandMenu buildUnvalidated() {
            return new RcsBrandMenu(this);
        }
    }
}
