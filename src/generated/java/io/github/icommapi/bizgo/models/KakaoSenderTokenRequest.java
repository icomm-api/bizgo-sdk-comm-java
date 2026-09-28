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
 * 카카오 채널 인증 토큰 요청 본문입니다.
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
@JsonDeserialize(builder = KakaoSenderTokenRequest.Builder.class)
@JsonPropertyOrder({"yellowId", "phoneNumber"})
public final class KakaoSenderTokenRequest {

    private final String yellowId;
    private final String phoneNumber;

    private KakaoSenderTokenRequest(Builder builder) {
        this.yellowId = builder.yellowId;
        this.phoneNumber = builder.phoneNumber;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.yellowId = this.yellowId;
        builder.phoneNumber = this.phoneNumber;
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
    public static KakaoSenderTokenRequest fromJson(String json) {
        return RequestParser.parse(json, KakaoSenderTokenRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static KakaoSenderTokenRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, KakaoSenderTokenRequest.class);
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
     * 카카오톡 채널 아이디입니다(<code>&#64;</code>로 시작).
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("yellowId")
    public String getYellowId() {
        return yellowId;
    }

    /**
     * 카카오톡 채널 알림을 받는 관리자 전화번호입니다. 이 번호에 연결된 카카오톡이 채널을 차단하지 않았으면 인증 토큰이 발송됩니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KakaoSenderTokenRequest)) {
            return false;
        }
        KakaoSenderTokenRequest other = (KakaoSenderTokenRequest) o;
        return Objects.equals(yellowId, other.yellowId)
                && Objects.equals(phoneNumber, other.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yellowId, phoneNumber);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoSenderTokenRequest{", "}");
        if (yellowId != null) {
            joiner.add("yellowId=" + io.github.icommapi.bizgo.internal.Masking.length(yellowId));
        }
        if (phoneNumber != null) {
            joiner.add("phoneNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(phoneNumber));
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoSenderTokenRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String yellowId;
        private String phoneNumber;

        /** Creates an empty builder; same as {@link KakaoSenderTokenRequest#builder()}. */
        public Builder() {
        }

        /**
         * 카카오톡 채널 아이디입니다(<code>&#64;</code>로 시작).
         *
         * <p>필수
         *
         * @param yellowId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("yellowId")
        public Builder yellowId(String yellowId) {
            this.yellowId = yellowId;
            return this;
        }

        /**
         * 카카오톡 채널 알림을 받는 관리자 전화번호입니다. 이 번호에 연결된 카카오톡이 채널을 차단하지 않았으면 인증 토큰이 발송됩니다.
         *
         * <p>필수
         *
         * @param phoneNumber the value (null clears it)
         * @return this builder
         */
        @JsonProperty("phoneNumber")
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code KakaoSenderTokenRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public KakaoSenderTokenRequest build() {
            KakaoSenderTokenRequest built = new KakaoSenderTokenRequest(this);
            ModelValidator v = new ModelValidator("KakaoSenderTokenRequest");
            v.required("yellowId", built.yellowId);
            v.required("phoneNumber", built.phoneNumber);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        KakaoSenderTokenRequest buildUnvalidated() {
            return new KakaoSenderTokenRequest(this);
        }
    }
}
