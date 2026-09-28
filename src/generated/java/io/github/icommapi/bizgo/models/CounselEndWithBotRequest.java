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
 * 상담 종료 및 봇 전환 요청입니다.
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
@JsonDeserialize(builder = CounselEndWithBotRequest.Builder.class)
@JsonPropertyOrder({"userKey", "senderKey", "botEvent"})
public final class CounselEndWithBotRequest {

    private final String userKey;
    private final String senderKey;
    private final String botEvent;

    private CounselEndWithBotRequest(Builder builder) {
        this.userKey = builder.userKey;
        this.senderKey = builder.senderKey;
        this.botEvent = builder.botEvent;
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
        builder.botEvent = this.botEvent;
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
    public static CounselEndWithBotRequest fromJson(String json) {
        return RequestParser.parse(json, CounselEndWithBotRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static CounselEndWithBotRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, CounselEndWithBotRequest.class);
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

    /**
     * 상담 종료 후 실행할 봇 이벤트(말블록)명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("botEvent")
    public String getBotEvent() {
        return botEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselEndWithBotRequest)) {
            return false;
        }
        CounselEndWithBotRequest other = (CounselEndWithBotRequest) o;
        return Objects.equals(userKey, other.userKey)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(botEvent, other.botEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userKey, senderKey, botEvent);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselEndWithBotRequest{", "}");
        if (userKey != null) {
            joiner.add("userKey=" + io.github.icommapi.bizgo.internal.Masking.length(userKey));
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (botEvent != null) {
            joiner.add("botEvent=" + io.github.icommapi.bizgo.internal.Masking.length(botEvent));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselEndWithBotRequest}. */
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
        private String botEvent;

        /** Creates an empty builder; same as {@link CounselEndWithBotRequest#builder()}. */
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
         * 상담 종료 후 실행할 봇 이벤트(말블록)명입니다.
         *
         * @param botEvent the value (null clears it)
         * @return this builder
         */
        @JsonProperty("botEvent")
        public Builder botEvent(String botEvent) {
            this.botEvent = botEvent;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselEndWithBotRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselEndWithBotRequest build() {
            CounselEndWithBotRequest built = new CounselEndWithBotRequest(this);
            ModelValidator v = new ModelValidator("CounselEndWithBotRequest");
            v.required("userKey", built.userKey);
            v.maxLength("userKey", built.userKey, 20);
            v.required("senderKey", built.senderKey);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselEndWithBotRequest buildUnvalidated() {
            return new CounselEndWithBotRequest(this);
        }
    }
}
