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
 * 지도 검색·보여주기·위치 전송 액션입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 문서상 showLocation이 필수로 표시되어 있어, requestLocationPush(위치 전송)만 쓰는 경우에도 showLocation이 필요한지 불명확합니다.
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
@JsonDeserialize(builder = RcsMapAction.Builder.class)
@JsonPropertyOrder({"showLocation", "requestLocationPush"})
public final class RcsMapAction {

    private final RcsMapActionShowLocation showLocation;
    private final Map<String, Object> requestLocationPush;

    private RcsMapAction(Builder builder) {
        this.showLocation = builder.showLocation;
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
        builder.requestLocationPush = this.requestLocationPush;
        return builder;
    }

    /**
     * 지도 위치 표시 객체입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("showLocation")
    public RcsMapActionShowLocation getShowLocation() {
        return showLocation;
    }

    /**
     * 위치 전송 요청 객체입니다.
     *
     * <p><b>확인 필요:</b> 하위 필드가 문서화되어 있지 않습니다.
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
        if (!(o instanceof RcsMapAction)) {
            return false;
        }
        RcsMapAction other = (RcsMapAction) o;
        return Objects.equals(showLocation, other.showLocation)
                && Objects.equals(requestLocationPush, other.requestLocationPush);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showLocation, requestLocationPush);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsMapAction{", "}");
        if (showLocation != null) {
            joiner.add("showLocation=" + showLocation);
        }
        if (requestLocationPush != null) {
            joiner.add("requestLocationPush=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsMapAction}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsMapActionShowLocation showLocation;
        private Map<String, Object> requestLocationPush;

        /** Creates an empty builder; same as {@link RcsMapAction#builder()}. */
        public Builder() {
        }

        /**
         * 지도 위치 표시 객체입니다.
         *
         * <p>필수
         *
         * @param showLocation the value (null clears it)
         * @return this builder
         */
        @JsonProperty("showLocation")
        public Builder showLocation(RcsMapActionShowLocation showLocation) {
            this.showLocation = showLocation;
            return this;
        }

        /**
         * 위치 전송 요청 객체입니다.
         *
         * <p><b>확인 필요:</b> 하위 필드가 문서화되어 있지 않습니다.
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
         * @return a new immutable {@code RcsMapAction}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsMapAction build() {
            RcsMapAction built = new RcsMapAction(this);
            ModelValidator v = new ModelValidator("RcsMapAction");
            v.required("showLocation", built.showLocation);
            v.mapValues("requestLocationPush", built.requestLocationPush, false);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsMapAction buildUnvalidated() {
            return new RcsMapAction(this);
        }
    }
}
