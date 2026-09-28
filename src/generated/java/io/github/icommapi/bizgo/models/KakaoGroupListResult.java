// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 발신프로필 그룹 조회 응답 데이터입니다.
 *
 * <p>Response model: unknown JSON properties are kept in {@link #getAdditionalProperties()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({"kakao"})
public final class KakaoGroupListResult {

    private final KakaoGroupListResultKakao kakao;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private KakaoGroupListResult(
            @JsonProperty("kakao") KakaoGroupListResultKakao kakao) {
        this.kakao = kakao;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private KakaoGroupListResult(Builder builder) {
        this(builder.kakao);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.kakao = this.kakao;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 카카오 비즈메시지 응답 데이터입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("kakao")
    public KakaoGroupListResultKakao getKakao() {
        return kakao;
    }

    /**
     * Properties the server sent that are not in the spec (new fields are kept instead of dropped).
     *
     * @return unmodifiable map, empty if there are none
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnySetter
    private void putAdditionalProperty(String name, Object value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KakaoGroupListResult)) {
            return false;
        }
        KakaoGroupListResult other = (KakaoGroupListResult) o;
        return Objects.equals(kakao, other.kakao)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kakao, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoGroupListResult{", "}");
        if (kakao != null) {
            joiner.add("kakao=" + kakao);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoGroupListResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private KakaoGroupListResultKakao kakao;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link KakaoGroupListResult#builder()}. */
        public Builder() {
        }

        /**
         * 카카오 비즈메시지 응답 데이터입니다.
         *
         * @param kakao the value (null clears it)
         * @return this builder
         */
        public Builder kakao(KakaoGroupListResultKakao kakao) {
            this.kakao = kakao;
            return this;
        }

        /**
         * Adds a property that is not in the spec.
         *
         * @param name JSON property name
         * @param value value
         * @return this builder
         */
        public Builder additionalProperty(String name, Object value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code KakaoGroupListResult}
         */
        public KakaoGroupListResult build() {
            return new KakaoGroupListResult(this);
        }
    }
}
