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
 * 상담 종료 요청입니다.
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
@JsonDeserialize(builder = CounselEndRequest.Builder.class)
@JsonPropertyOrder({"userKey", "senderKey"})
public final class CounselEndRequest {

    private final String userKey;
    private final String senderKey;

    private CounselEndRequest(Builder builder) {
        this.userKey = builder.userKey;
        this.senderKey = builder.senderKey;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.userKey = this.userKey;
        builder.senderKey = this.senderKey;
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
    public static CounselEndRequest fromJson(String json) {
        return RequestParser.parse(json, CounselEndRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static CounselEndRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, CounselEndRequest.class);
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
     * 상담톡 사용자 키입니다. 1~20자입니다.
     *
     * <p>필수 · 최대 20자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("userKey")
    public String getUserKey() {
        return userKey;
    }

    /**
     * 발신프로필 키입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselEndRequest)) {
            return false;
        }
        CounselEndRequest other = (CounselEndRequest) o;
        return Objects.equals(userKey, other.userKey)
                && Objects.equals(senderKey, other.senderKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userKey, senderKey);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselEndRequest{", "}");
        if (userKey != null) {
            joiner.add("userKey=" + io.github.icommapi.bizgo.internal.Masking.length(userKey));
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselEndRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String userKey;
        private String senderKey;

        /** Creates an empty builder; same as {@link CounselEndRequest#builder()}. */
        public Builder() {
        }

        /**
         * 상담톡 사용자 키입니다. 1~20자입니다.
         *
         * <p>필수 · 최대 20자
         *
         * @param userKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("userKey")
        public Builder userKey(String userKey) {
            this.userKey = userKey;
            return this;
        }

        /**
         * 발신프로필 키입니다.
         *
         * <p>필수
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
         * Builds the object.
         *
         * @return a new immutable {@code CounselEndRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselEndRequest build() {
            CounselEndRequest built = new CounselEndRequest(this);
            ModelValidator v = new ModelValidator("CounselEndRequest");
            v.required("userKey", built.userKey);
            v.maxLength("userKey", built.userKey, 20);
            v.required("senderKey", built.senderKey);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselEndRequest buildUnvalidated() {
            return new CounselEndRequest(this);
        }
    }
}
