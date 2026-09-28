// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 친구 그룹 등록, 전화번호 추가·삭제 요청입니다. 전화번호는 <code>fileKey</code> 또는 <code>phoneNumbers</code>로 전달합니다.
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
@JsonDeserialize(builder = BrandMessageFriendGroupRequest.Builder.class)
@JsonPropertyOrder({"friendGroup"})
public final class BrandMessageFriendGroupRequest {

    private final BrandMessageFriendGroupRequestFriendGroup friendGroup;

    private BrandMessageFriendGroupRequest(Builder builder) {
        this.friendGroup = builder.friendGroup;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.friendGroup = this.friendGroup;
        return builder;
    }

    /**
     * Parse and validate a request written with the API field names (JSON).
     * Unknown fields are rejected so that typos fail before anything is sent.
     *
     * @param json request body, for example an example from the API reference
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageFriendGroupRequest fromJson(String json) {
        return RequestParser.parse(json, BrandMessageFriendGroupRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageFriendGroupRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, BrandMessageFriendGroupRequest.class);
    }

    /**
     * The JSON body that is sent. Contains phone numbers: do not log it.
     *
     * @return JSON with only the fields that were set
     */
    public String toJson() {
        return RequestParser.toJson(this);
    }

    /**
     * 친구 그룹 정보입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> <code>fileKey</code>와 <code>phoneNumbers</code>를 둘 다 보내거나 둘 다 생략할 때의 동작이 문서에 없습니다. 친구 그룹 등록 시 <code>friendGroupKey</code>를 고객이 정하는지(요청 필수)만 명시되어 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("friendGroup")
    public BrandMessageFriendGroupRequestFriendGroup getFriendGroup() {
        return friendGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageFriendGroupRequest)) {
            return false;
        }
        BrandMessageFriendGroupRequest other = (BrandMessageFriendGroupRequest) o;
        return Objects.equals(friendGroup, other.friendGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendGroup);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageFriendGroupRequest{", "}");
        if (friendGroup != null) {
            joiner.add("friendGroup=" + friendGroup);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageFriendGroupRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessageFriendGroupRequestFriendGroup friendGroup;

        /** Creates an empty builder; same as {@link BrandMessageFriendGroupRequest#builder()}. */
        public Builder() {
        }

        /**
         * 친구 그룹 정보입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> <code>fileKey</code>와 <code>phoneNumbers</code>를 둘 다 보내거나 둘 다 생략할 때의 동작이 문서에 없습니다. 친구 그룹 등록 시 <code>friendGroupKey</code>를 고객이 정하는지(요청 필수)만 명시되어 있습니다.
         *
         * @param friendGroup the value (null clears it)
         * @return this builder
         */
        @JsonProperty("friendGroup")
        public Builder friendGroup(BrandMessageFriendGroupRequestFriendGroup friendGroup) {
            this.friendGroup = friendGroup;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageFriendGroupRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageFriendGroupRequest build() {
            BrandMessageFriendGroupRequest built = new BrandMessageFriendGroupRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageFriendGroupRequest");
            v.required("friendGroup", built.friendGroup);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageFriendGroupRequest buildUnvalidated() {
            return new BrandMessageFriendGroupRequest(this);
        }
    }
}
