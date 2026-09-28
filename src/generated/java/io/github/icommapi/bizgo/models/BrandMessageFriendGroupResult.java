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
 * 친구 그룹 상세 응답 데이터입니다.
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
@JsonPropertyOrder({"friendGroup"})
public final class BrandMessageFriendGroupResult {

    private final BrandMessageFriendGroup friendGroup;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageFriendGroupResult(
            @JsonProperty("friendGroup") BrandMessageFriendGroup friendGroup) {
        this.friendGroup = friendGroup;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageFriendGroupResult(Builder builder) {
        this(builder.friendGroup);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.friendGroup = this.friendGroup;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 친구 그룹 상세 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("friendGroup")
    public BrandMessageFriendGroup getFriendGroup() {
        return friendGroup;
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
        if (!(o instanceof BrandMessageFriendGroupResult)) {
            return false;
        }
        BrandMessageFriendGroupResult other = (BrandMessageFriendGroupResult) o;
        return Objects.equals(friendGroup, other.friendGroup)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendGroup, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageFriendGroupResult{", "}");
        if (friendGroup != null) {
            joiner.add("friendGroup=" + friendGroup);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageFriendGroupResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessageFriendGroup friendGroup;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageFriendGroupResult#builder()}. */
        public Builder() {
        }

        /**
         * 친구 그룹 상세 정보입니다.
         *
         * @param friendGroup the value (null clears it)
         * @return this builder
         */
        public Builder friendGroup(BrandMessageFriendGroup friendGroup) {
            this.friendGroup = friendGroup;
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
         * @return a new immutable {@code BrandMessageFriendGroupResult}
         */
        public BrandMessageFriendGroupResult build() {
            return new BrandMessageFriendGroupResult(this);
        }
    }
}
