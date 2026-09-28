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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 카카오 비즈메시지 응답 데이터입니다.
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
@JsonPropertyOrder({"groups"})
public final class KakaoGroupListResultKakao {

    private final List<KakaoGroup> groups;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private KakaoGroupListResultKakao(
            @JsonProperty("groups") List<KakaoGroup> groups) {
        this.groups = groups == null ? null : Collections.unmodifiableList(new ArrayList<>(groups));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private KakaoGroupListResultKakao(Builder builder) {
        this(builder.groups);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.groups = this.groups;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 발신프로필 그룹 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groups")
    public List<KakaoGroup> getGroups() {
        return groups;
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
        if (!(o instanceof KakaoGroupListResultKakao)) {
            return false;
        }
        KakaoGroupListResultKakao other = (KakaoGroupListResultKakao) o;
        return Objects.equals(groups, other.groups)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groups, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoGroupListResultKakao{", "}");
        if (groups != null) {
            joiner.add("groups=" + groups);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoGroupListResultKakao}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<KakaoGroup> groups;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link KakaoGroupListResultKakao#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 그룹 목록입니다.
         *
         * @param groups the value (null clears it)
         * @return this builder
         */
        public Builder groups(List<KakaoGroup> groups) {
            this.groups = groups;
            return this;
        }

        /**
         * Varargs form of {@link #groups(List)}.
         *
         * @param groups values
         * @return this builder
         */
        public Builder groups(KakaoGroup... groups) {
            this.groups = groups == null ? null : Arrays.asList(groups);
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
         * @return a new immutable {@code KakaoGroupListResultKakao}
         */
        public KakaoGroupListResultKakao build() {
            return new KakaoGroupListResultKakao(this);
        }
    }
}
