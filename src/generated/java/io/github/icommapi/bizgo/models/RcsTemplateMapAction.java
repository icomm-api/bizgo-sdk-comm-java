// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 템플릿 버튼의 지도 액션입니다. 발송용 <code>RcsMapAction</code>과 달리 <code>showLocation</code>이 선택이고 <code>fallbackUrl</code>이 <code>mapAction</code> 바로 아래에 있으며, 위치 <code>label</code>이 문자열입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 발송 API의 mapAction(showLocation 필수, fallbackUrl이 showLocation 아래)과 구조가 다릅니다. 어느 쪽이 맞는지, requestLocationPush의 하위 필드는 무엇인지 문서화되어 있지 않습니다.
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
@JsonDeserialize(builder = RcsTemplateMapAction.Builder.class)
@JsonPropertyOrder({"showLocation", "fallbackUrl", "requestLocationPush"})
public final class RcsTemplateMapAction {

    private final RcsTemplateMapActionShowLocation showLocation;
    private final String fallbackUrl;
    private final Map<String, Object> requestLocationPush;

    private RcsTemplateMapAction(Builder builder) {
        this.showLocation = builder.showLocation;
        this.fallbackUrl = builder.fallbackUrl;
        this.requestLocationPush = builder.requestLocationPush == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.requestLocationPush));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.showLocation = this.showLocation;
        builder.fallbackUrl = this.fallbackUrl;
        builder.requestLocationPush = this.requestLocationPush;
        return builder;
    }

    /**
     * 지도 위치 표시 객체입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("showLocation")
    public RcsTemplateMapActionShowLocation getShowLocation() {
        return showLocation;
    }

    /**
     * 위치 조회 실패 시 이동할 fallback URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fallbackUrl")
    public String getFallbackUrl() {
        return fallbackUrl;
    }

    /**
     * 위치 전송 요청 객체입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("requestLocationPush")
    public Map<String, Object> getRequestLocationPush() {
        return requestLocationPush;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateMapAction)) {
            return false;
        }
        RcsTemplateMapAction other = (RcsTemplateMapAction) o;
        return Objects.equals(showLocation, other.showLocation)
                && Objects.equals(fallbackUrl, other.fallbackUrl)
                && Objects.equals(requestLocationPush, other.requestLocationPush);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showLocation, fallbackUrl, requestLocationPush);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateMapAction{", "}");
        if (showLocation != null) {
            joiner.add("showLocation=" + showLocation);
        }
        if (fallbackUrl != null) {
            joiner.add("fallbackUrl=" + io.github.icommapi.bizgo.internal.Masking.length(fallbackUrl));
        }
        if (requestLocationPush != null) {
            joiner.add("requestLocationPush=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateMapAction}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsTemplateMapActionShowLocation showLocation;
        private String fallbackUrl;
        private Map<String, Object> requestLocationPush;

        /** Creates an empty builder; same as {@link RcsTemplateMapAction#builder()}. */
        public Builder() {
        }

        /**
         * 지도 위치 표시 객체입니다.
         *
         * @param showLocation the value (null clears it)
         * @return this builder
         */
        @JsonProperty("showLocation")
        public Builder showLocation(RcsTemplateMapActionShowLocation showLocation) {
            this.showLocation = showLocation;
            return this;
        }

        /**
         * 위치 조회 실패 시 이동할 fallback URL입니다.
         *
         * @param fallbackUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fallbackUrl")
        public Builder fallbackUrl(String fallbackUrl) {
            this.fallbackUrl = fallbackUrl;
            return this;
        }

        /**
         * 위치 전송 요청 객체입니다.
         *
         * @param requestLocationPush the value (null clears it)
         * @return this builder
         */
        @JsonProperty("requestLocationPush")
        public Builder requestLocationPush(Map<String, Object> requestLocationPush) {
            this.requestLocationPush = requestLocationPush;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateMapAction}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateMapAction build() {
            RcsTemplateMapAction built = new RcsTemplateMapAction(this);
            ModelValidator v = new ModelValidator("RcsTemplateMapAction");
            v.mapValues("requestLocationPush", built.requestLocationPush, false);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateMapAction buildUnvalidated() {
            return new RcsTemplateMapAction(this);
        }
    }
}
