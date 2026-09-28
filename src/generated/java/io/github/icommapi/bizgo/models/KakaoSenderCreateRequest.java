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
import java.util.regex.Pattern;

/**
 * 인증 토큰으로 발신프로필을 등록하는 요청 본문입니다. 인증 토큰과 관리자 전화번호는 헤더(<code>token</code>, <code>phoneNumber</code>)로 보냅니다.
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
@JsonDeserialize(builder = KakaoSenderCreateRequest.Builder.class)
@JsonPropertyOrder({"yellowId", "categoryCode", "unsubscribePhoneNumber", "unsubscribeAuthNumber"})
public final class KakaoSenderCreateRequest {
    private static final Pattern CATEGORY_CODE_PATTERN = Pattern.compile("^[0-9]{11}$");

    private final String yellowId;
    private final String categoryCode;
    private final String unsubscribePhoneNumber;
    private final String unsubscribeAuthNumber;

    private KakaoSenderCreateRequest(Builder builder) {
        this.yellowId = builder.yellowId;
        this.categoryCode = builder.categoryCode;
        this.unsubscribePhoneNumber = builder.unsubscribePhoneNumber;
        this.unsubscribeAuthNumber = builder.unsubscribeAuthNumber;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.yellowId = this.yellowId;
        builder.categoryCode = this.categoryCode;
        builder.unsubscribePhoneNumber = this.unsubscribePhoneNumber;
        builder.unsubscribeAuthNumber = this.unsubscribeAuthNumber;
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
    public static KakaoSenderCreateRequest fromJson(String json) {
        return RequestParser.parse(json, KakaoSenderCreateRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static KakaoSenderCreateRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, KakaoSenderCreateRequest.class);
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
     * 등록할 카카오톡 채널 아이디입니다.
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
     * 발신프로필 카테고리 코드(11자리 숫자)입니다. 사용할 수 있는 코드는 카테고리 전체조회로 확인합니다.
     *
     * <p>필수 · 형식 <code>^[0-9]&#123;11&#125;$</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categoryCode")
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 무료수신거부 전화번호입니다(예 <code>080-0000-0000</code>). 브랜드메시지를 쓰는 발신프로필이 설정하며, 타겟팅 M, N, O 사용 시 필수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("unsubscribePhoneNumber")
    public String getUnsubscribePhoneNumber() {
        return unsubscribePhoneNumber;
    }

    /**
     * 무료수신거부 인증번호입니다(예 <code>12345</code>). 타겟팅 M, N, O 사용 시 필수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("unsubscribeAuthNumber")
    public String getUnsubscribeAuthNumber() {
        return unsubscribeAuthNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KakaoSenderCreateRequest)) {
            return false;
        }
        KakaoSenderCreateRequest other = (KakaoSenderCreateRequest) o;
        return Objects.equals(yellowId, other.yellowId)
                && Objects.equals(categoryCode, other.categoryCode)
                && Objects.equals(unsubscribePhoneNumber, other.unsubscribePhoneNumber)
                && Objects.equals(unsubscribeAuthNumber, other.unsubscribeAuthNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yellowId, categoryCode, unsubscribePhoneNumber, unsubscribeAuthNumber);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoSenderCreateRequest{", "}");
        if (yellowId != null) {
            joiner.add("yellowId=" + io.github.icommapi.bizgo.internal.Masking.length(yellowId));
        }
        if (categoryCode != null) {
            joiner.add("categoryCode=" + io.github.icommapi.bizgo.internal.Masking.length(categoryCode));
        }
        if (unsubscribePhoneNumber != null) {
            joiner.add("unsubscribePhoneNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(unsubscribePhoneNumber));
        }
        if (unsubscribeAuthNumber != null) {
            joiner.add("unsubscribeAuthNumber=" + io.github.icommapi.bizgo.internal.Masking.length(unsubscribeAuthNumber));
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoSenderCreateRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String yellowId;
        private String categoryCode;
        private String unsubscribePhoneNumber;
        private String unsubscribeAuthNumber;

        /** Creates an empty builder; same as {@link KakaoSenderCreateRequest#builder()}. */
        public Builder() {
        }

        /**
         * 등록할 카카오톡 채널 아이디입니다.
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
         * 발신프로필 카테고리 코드(11자리 숫자)입니다. 사용할 수 있는 코드는 카테고리 전체조회로 확인합니다.
         *
         * <p>필수 · 형식 <code>^[0-9]&#123;11&#125;$</code>
         *
         * @param categoryCode the value (null clears it)
         * @return this builder
         */
        @JsonProperty("categoryCode")
        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        /**
         * 무료수신거부 전화번호입니다(예 <code>080-0000-0000</code>). 브랜드메시지를 쓰는 발신프로필이 설정하며, 타겟팅 M, N, O 사용 시 필수입니다.
         *
         * @param unsubscribePhoneNumber the value (null clears it)
         * @return this builder
         */
        @JsonProperty("unsubscribePhoneNumber")
        public Builder unsubscribePhoneNumber(String unsubscribePhoneNumber) {
            this.unsubscribePhoneNumber = unsubscribePhoneNumber;
            return this;
        }

        /**
         * 무료수신거부 인증번호입니다(예 <code>12345</code>). 타겟팅 M, N, O 사용 시 필수입니다.
         *
         * @param unsubscribeAuthNumber the value (null clears it)
         * @return this builder
         */
        @JsonProperty("unsubscribeAuthNumber")
        public Builder unsubscribeAuthNumber(String unsubscribeAuthNumber) {
            this.unsubscribeAuthNumber = unsubscribeAuthNumber;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code KakaoSenderCreateRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public KakaoSenderCreateRequest build() {
            KakaoSenderCreateRequest built = new KakaoSenderCreateRequest(this);
            ModelValidator v = new ModelValidator("KakaoSenderCreateRequest");
            v.required("yellowId", built.yellowId);
            v.required("categoryCode", built.categoryCode);
            v.pattern("categoryCode", built.categoryCode, CATEGORY_CODE_PATTERN);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        KakaoSenderCreateRequest buildUnvalidated() {
            return new KakaoSenderCreateRequest(this);
        }
    }
}
