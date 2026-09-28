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
 * 전화번호 요청 목록 응답 데이터입니다.
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
@JsonPropertyOrder({"friendGroups", "hasNext"})
public final class BrandMessageFriendGroupPhoneNumberRequestListResult {

    private final List<BrandMessageFriendGroupPhoneNumberRequest> friendGroups;
    private final Boolean hasNext;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageFriendGroupPhoneNumberRequestListResult(
            @JsonProperty("friendGroups") List<BrandMessageFriendGroupPhoneNumberRequest> friendGroups,
            @JsonProperty("hasNext") Boolean hasNext) {
        this.friendGroups = friendGroups == null ? null : Collections.unmodifiableList(new ArrayList<>(friendGroups));
        this.hasNext = hasNext;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageFriendGroupPhoneNumberRequestListResult(Builder builder) {
        this(builder.friendGroups, builder.hasNext);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.friendGroups = this.friendGroups;
        builder.hasNext = this.hasNext;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 전화번호 추가·삭제 요청 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("friendGroups")
    public List<BrandMessageFriendGroupPhoneNumberRequest> getFriendGroups() {
        return friendGroups;
    }

    /**
     * 다음 페이지 존재 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("hasNext")
    public Boolean getHasNext() {
        return hasNext;
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
        if (!(o instanceof BrandMessageFriendGroupPhoneNumberRequestListResult)) {
            return false;
        }
        BrandMessageFriendGroupPhoneNumberRequestListResult other = (BrandMessageFriendGroupPhoneNumberRequestListResult) o;
        return Objects.equals(friendGroups, other.friendGroups)
                && Objects.equals(hasNext, other.hasNext)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendGroups, hasNext, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageFriendGroupPhoneNumberRequestListResult{", "}");
        if (friendGroups != null) {
            joiner.add("friendGroups=" + friendGroups);
        }
        if (hasNext != null) {
            joiner.add("hasNext=" + hasNext);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageFriendGroupPhoneNumberRequestListResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<BrandMessageFriendGroupPhoneNumberRequest> friendGroups;
        private Boolean hasNext;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageFriendGroupPhoneNumberRequestListResult#builder()}. */
        public Builder() {
        }

        /**
         * 전화번호 추가·삭제 요청 목록입니다.
         *
         * @param friendGroups the value (null clears it)
         * @return this builder
         */
        public Builder friendGroups(List<BrandMessageFriendGroupPhoneNumberRequest> friendGroups) {
            this.friendGroups = friendGroups;
            return this;
        }

        /**
         * Varargs form of {@link #friendGroups(List)}.
         *
         * @param friendGroups values
         * @return this builder
         */
        public Builder friendGroups(BrandMessageFriendGroupPhoneNumberRequest... friendGroups) {
            this.friendGroups = friendGroups == null ? null : Arrays.asList(friendGroups);
            return this;
        }

        /**
         * 다음 페이지 존재 여부입니다.
         *
         * @param hasNext the value (null clears it)
         * @return this builder
         */
        public Builder hasNext(Boolean hasNext) {
            this.hasNext = hasNext;
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
         * @return a new immutable {@code BrandMessageFriendGroupPhoneNumberRequestListResult}
         */
        public BrandMessageFriendGroupPhoneNumberRequestListResult build() {
            return new BrandMessageFriendGroupPhoneNumberRequestListResult(this);
        }
    }
}
