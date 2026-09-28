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
 * 웹 링크 연결 객체입니다.
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
@JsonDeserialize(builder = RcsUrlActionOpenUrl.Builder.class)
@JsonPropertyOrder({"url"})
public final class RcsUrlActionOpenUrl {

    private final String url;

    private RcsUrlActionOpenUrl(Builder builder) {
        this.url = builder.url;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        return builder;
    }

    /**
     * 웹 링크 URL입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsUrlActionOpenUrl)) {
            return false;
        }
        RcsUrlActionOpenUrl other = (RcsUrlActionOpenUrl) o;
        return Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsUrlActionOpenUrl{", "}");
        if (url != null) {
            joiner.add("url=" + io.github.icommapi.bizgo.internal.Masking.length(url));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsUrlActionOpenUrl}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String url;

        /** Creates an empty builder; same as {@link RcsUrlActionOpenUrl#builder()}. */
        public Builder() {
        }

        /**
         * 웹 링크 URL입니다.
         *
         * <p>필수
         *
         * @param url the value (null clears it)
         * @return this builder
         */
        @JsonProperty("url")
        public Builder url(String url) {
            this.url = url;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsUrlActionOpenUrl}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsUrlActionOpenUrl build() {
            RcsUrlActionOpenUrl built = new RcsUrlActionOpenUrl(this);
            ModelValidator v = new ModelValidator("RcsUrlActionOpenUrl");
            v.required("url", built.url);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsUrlActionOpenUrl buildUnvalidated() {
            return new RcsUrlActionOpenUrl(this);
        }
    }
}
