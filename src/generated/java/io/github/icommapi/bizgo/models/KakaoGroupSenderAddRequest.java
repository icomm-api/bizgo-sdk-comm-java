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
 * 그룹에 발신프로필 등록 요청 본문입니다.
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
@JsonDeserialize(builder = KakaoGroupSenderAddRequest.Builder.class)
@JsonPropertyOrder({"groupKey", "senderKey", "groupName"})
public final class KakaoGroupSenderAddRequest {

    private final String groupKey;
    private final String senderKey;
    private final String groupName;

    private KakaoGroupSenderAddRequest(Builder builder) {
        this.groupKey = builder.groupKey;
        this.senderKey = builder.senderKey;
        this.groupName = builder.groupName;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.groupKey = this.groupKey;
        builder.senderKey = this.senderKey;
        builder.groupName = this.groupName;
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
    public static KakaoGroupSenderAddRequest fromJson(String json) {
        return RequestParser.parse(json, KakaoGroupSenderAddRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static KakaoGroupSenderAddRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, KakaoGroupSenderAddRequest.class);
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
     * 발신프로필을 등록할 그룹 키입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupKey")
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * 등록할 발신프로필 키입니다. 최대 40자입니다.
     *
     * <p>필수 · 최대 40자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 그룹 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupName")
    public String getGroupName() {
        return groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KakaoGroupSenderAddRequest)) {
            return false;
        }
        KakaoGroupSenderAddRequest other = (KakaoGroupSenderAddRequest) o;
        return Objects.equals(groupKey, other.groupKey)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(groupName, other.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupKey, senderKey, groupName);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoGroupSenderAddRequest{", "}");
        if (groupKey != null) {
            joiner.add("groupKey=" + io.github.icommapi.bizgo.internal.Masking.length(groupKey));
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (groupName != null) {
            joiner.add("groupName=" + io.github.icommapi.bizgo.internal.Masking.length(groupName));
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoGroupSenderAddRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String groupKey;
        private String senderKey;
        private String groupName;

        /** Creates an empty builder; same as {@link KakaoGroupSenderAddRequest#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필을 등록할 그룹 키입니다.
         *
         * <p>필수
         *
         * @param groupKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("groupKey")
        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        /**
         * 등록할 발신프로필 키입니다. 최대 40자입니다.
         *
         * <p>필수 · 최대 40자
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("senderKey")
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 그룹 이름입니다.
         *
         * @param groupName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("groupName")
        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code KakaoGroupSenderAddRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public KakaoGroupSenderAddRequest build() {
            KakaoGroupSenderAddRequest built = new KakaoGroupSenderAddRequest(this);
            ModelValidator v = new ModelValidator("KakaoGroupSenderAddRequest");
            v.required("groupKey", built.groupKey);
            v.required("senderKey", built.senderKey);
            v.maxLength("senderKey", built.senderKey, 40);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        KakaoGroupSenderAddRequest buildUnvalidated() {
            return new KakaoGroupSenderAddRequest(this);
        }
    }
}
