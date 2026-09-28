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
 * 네이버 톡톡 버튼입니다.
 * <ul>
 * <li><code>WEB_LINK</code> 버튼은 <code>mobileUrl</code>이 필수입니다(접수코드 A606).</li>
 * <li><code>APP_LINK</code> 버튼은 <code>aOsAppScheme</code>과 <code>iOsAppScheme</code>이 모두 필수입니다(접수코드 A607).</li>
 * </ul>
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
@JsonDeserialize(builder = NaverTalkButton.Builder.class)
@JsonPropertyOrder({"buttonCode", "mobileUrl", "pcUrl", "aOsAppScheme", "iOsAppScheme"})
public final class NaverTalkButton {

    private final String buttonCode;
    private final String mobileUrl;
    private final String pcUrl;
    private final String aOsAppScheme;
    private final String iOsAppScheme;

    private NaverTalkButton(Builder builder) {
        this.buttonCode = builder.buttonCode;
        this.mobileUrl = builder.mobileUrl;
        this.pcUrl = builder.pcUrl;
        this.aOsAppScheme = builder.aOsAppScheme;
        this.iOsAppScheme = builder.iOsAppScheme;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.buttonCode = this.buttonCode;
        builder.mobileUrl = this.mobileUrl;
        builder.pcUrl = this.pcUrl;
        builder.aOsAppScheme = this.aOsAppScheme;
        builder.iOsAppScheme = this.iOsAppScheme;
        return builder;
    }

    /**
     * 버튼 코드입니다. 알려진 값은 <code>WEB_LINK</code>, <code>APP_LINK</code>입니다(요청 예시와 접수코드 A605~A607 기준). 전체 목록은 원문에 없습니다.
     *
     * <p>필수 · 알려진 값 <code>WEB_LINK</code>, <code>APP_LINK</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttonCode")
    public String getButtonCode() {
        return buttonCode;
    }

    /**
     * 모바일 이동 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("mobileUrl")
    public String getMobileUrl() {
        return mobileUrl;
    }

    /**
     * PC 이동 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("pcUrl")
    public String getPcUrl() {
        return pcUrl;
    }

    /**
     * Android OS 환경에서 버튼 클릭 시 이동할 앱 링크입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("aOsAppScheme")
    public String getAOsAppScheme() {
        return aOsAppScheme;
    }

    /**
     * iOS 환경에서 버튼 클릭 시 이동할 앱 링크입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("iOsAppScheme")
    public String getIOsAppScheme() {
        return iOsAppScheme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NaverTalkButton)) {
            return false;
        }
        NaverTalkButton other = (NaverTalkButton) o;
        return Objects.equals(buttonCode, other.buttonCode)
                && Objects.equals(mobileUrl, other.mobileUrl)
                && Objects.equals(pcUrl, other.pcUrl)
                && Objects.equals(aOsAppScheme, other.aOsAppScheme)
                && Objects.equals(iOsAppScheme, other.iOsAppScheme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonCode, mobileUrl, pcUrl, aOsAppScheme, iOsAppScheme);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "NaverTalkButton{", "}");
        if (buttonCode != null) {
            joiner.add("buttonCode=" + buttonCode);
        }
        if (mobileUrl != null) {
            joiner.add("mobileUrl=" + io.github.icommapi.bizgo.internal.Masking.length(mobileUrl));
        }
        if (pcUrl != null) {
            joiner.add("pcUrl=" + io.github.icommapi.bizgo.internal.Masking.length(pcUrl));
        }
        if (aOsAppScheme != null) {
            joiner.add("aOsAppScheme=" + io.github.icommapi.bizgo.internal.Masking.length(aOsAppScheme));
        }
        if (iOsAppScheme != null) {
            joiner.add("iOsAppScheme=" + io.github.icommapi.bizgo.internal.Masking.length(iOsAppScheme));
        }
        return joiner.toString();
    }

    /** Builder for {@link NaverTalkButton}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String buttonCode;
        private String mobileUrl;
        private String pcUrl;
        private String aOsAppScheme;
        private String iOsAppScheme;

        /** Creates an empty builder; same as {@link NaverTalkButton#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 코드입니다. 알려진 값은 <code>WEB_LINK</code>, <code>APP_LINK</code>입니다(요청 예시와 접수코드 A605~A607 기준). 전체 목록은 원문에 없습니다.
         *
         * <p>필수 · 알려진 값 <code>WEB_LINK</code>, <code>APP_LINK</code>
         *
         * @param buttonCode the value (null clears it)
         * @return this builder
         */
        @JsonProperty("buttonCode")
        public Builder buttonCode(String buttonCode) {
            this.buttonCode = buttonCode;
            return this;
        }

        /**
         * 모바일 이동 URL입니다.
         *
         * @param mobileUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("mobileUrl")
        public Builder mobileUrl(String mobileUrl) {
            this.mobileUrl = mobileUrl;
            return this;
        }

        /**
         * PC 이동 URL입니다.
         *
         * @param pcUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("pcUrl")
        public Builder pcUrl(String pcUrl) {
            this.pcUrl = pcUrl;
            return this;
        }

        /**
         * Android OS 환경에서 버튼 클릭 시 이동할 앱 링크입니다.
         *
         * @param aOsAppScheme the value (null clears it)
         * @return this builder
         */
        @JsonProperty("aOsAppScheme")
        public Builder aOsAppScheme(String aOsAppScheme) {
            this.aOsAppScheme = aOsAppScheme;
            return this;
        }

        /**
         * iOS 환경에서 버튼 클릭 시 이동할 앱 링크입니다.
         *
         * @param iOsAppScheme the value (null clears it)
         * @return this builder
         */
        @JsonProperty("iOsAppScheme")
        public Builder iOsAppScheme(String iOsAppScheme) {
            this.iOsAppScheme = iOsAppScheme;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code NaverTalkButton}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public NaverTalkButton build() {
            NaverTalkButton built = new NaverTalkButton(this);
            ModelValidator v = new ModelValidator("NaverTalkButton");
            v.required("buttonCode", built.buttonCode);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        NaverTalkButton buildUnvalidated() {
            return new NaverTalkButton(this);
        }
    }
}
