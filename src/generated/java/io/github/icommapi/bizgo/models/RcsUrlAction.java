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
 * 웹 링크 연결 액션입니다.
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
@JsonDeserialize(builder = RcsUrlAction.Builder.class)
@JsonPropertyOrder({"openUrl"})
public final class RcsUrlAction {

    private final RcsUrlActionOpenUrl openUrl;

    private RcsUrlAction(Builder builder) {
        this.openUrl = builder.openUrl;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.openUrl = this.openUrl;
        return builder;
    }

    /**
     * 웹 링크 연결 객체입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("openUrl")
    public RcsUrlActionOpenUrl getOpenUrl() {
        return openUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsUrlAction)) {
            return false;
        }
        RcsUrlAction other = (RcsUrlAction) o;
        return Objects.equals(openUrl, other.openUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openUrl);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsUrlAction{", "}");
        if (openUrl != null) {
            joiner.add("openUrl=" + openUrl);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsUrlAction}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsUrlActionOpenUrl openUrl;

        /** Creates an empty builder; same as {@link RcsUrlAction#builder()}. */
        public Builder() {
        }

        /**
         * 웹 링크 연결 객체입니다.
         *
         * <p>필수
         *
         * @param openUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("openUrl")
        public Builder openUrl(RcsUrlActionOpenUrl openUrl) {
            this.openUrl = openUrl;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsUrlAction}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsUrlAction build() {
            RcsUrlAction built = new RcsUrlAction(this);
            ModelValidator v = new ModelValidator("RcsUrlAction");
            v.required("openUrl", built.openUrl);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsUrlAction buildUnvalidated() {
            return new RcsUrlAction(this);
        }
    }
}
