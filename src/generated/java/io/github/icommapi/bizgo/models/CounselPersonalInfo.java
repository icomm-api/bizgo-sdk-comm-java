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
 * 사용자가 수집에 동의한 개인정보입니다. 저장·로그 출력에 주의하고 목적 외로 쓰지 않습니다.
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
@JsonPropertyOrder({"phone_number", "nickname"})
public final class CounselPersonalInfo {

    private final String phone_number;
    private final String nickname;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselPersonalInfo(
            @JsonProperty("phone_number") String phone_number,
            @JsonProperty("nickname") String nickname) {
        this.phone_number = phone_number;
        this.nickname = nickname;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselPersonalInfo(Builder builder) {
        this(builder.phone_number, builder.nickname);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.phone_number = this.phone_number;
        builder.nickname = this.nickname;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 카카오 계정 전화번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("phone_number")
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * 카카오 프로필 닉네임입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
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
        if (!(o instanceof CounselPersonalInfo)) {
            return false;
        }
        CounselPersonalInfo other = (CounselPersonalInfo) o;
        return Objects.equals(phone_number, other.phone_number)
                && Objects.equals(nickname, other.nickname)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone_number, nickname, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselPersonalInfo{", "}");
        if (phone_number != null) {
            joiner.add("phone_number=" + io.github.icommapi.bizgo.internal.Masking.phone(phone_number));
        }
        if (nickname != null) {
            joiner.add("nickname=" + io.github.icommapi.bizgo.internal.Masking.person(nickname));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselPersonalInfo}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String phone_number;
        private String nickname;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselPersonalInfo#builder()}. */
        public Builder() {
        }

        /**
         * 카카오 계정 전화번호입니다.
         *
         * @param phone_number the value (null clears it)
         * @return this builder
         */
        public Builder phone_number(String phone_number) {
            this.phone_number = phone_number;
            return this;
        }

        /**
         * 카카오 프로필 닉네임입니다.
         *
         * @param nickname the value (null clears it)
         * @return this builder
         */
        public Builder nickname(String nickname) {
            this.nickname = nickname;
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
         * @return a new immutable {@code CounselPersonalInfo}
         */
        public CounselPersonalInfo build() {
            return new CounselPersonalInfo(this);
        }
    }
}
