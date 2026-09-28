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
 * 브랜드메시지 발송권한(고객사 회원 대상 발송, targeting M·N·O) 신청 요청입니다.
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
@JsonDeserialize(builder = BrandMessagePermissionApplyRequest.Builder.class)
@JsonPropertyOrder({"brandMessage"})
public final class BrandMessagePermissionApplyRequest {

    private final BrandMessagePermissionApplyRequestBrandMessage brandMessage;

    private BrandMessagePermissionApplyRequest(Builder builder) {
        this.brandMessage = builder.brandMessage;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.brandMessage = this.brandMessage;
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
    public static BrandMessagePermissionApplyRequest fromJson(String json) {
        return RequestParser.parse(json, BrandMessagePermissionApplyRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessagePermissionApplyRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, BrandMessagePermissionApplyRequest.class);
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
     * 발송 권한 신청 정보입니다. 다른 브랜드메시지 API와 달리 키 이름이 <code>brandMessage</code>(대문자 M)입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 다른 API는 <code>brandmessage</code>(소문자)를 쓰는데 이 API만 <code>brandMessage</code>로 표기되어 있습니다(Part A·B 동일). 서버가 대소문자를 구분하는지 확인이 필요합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandMessage")
    public BrandMessagePermissionApplyRequestBrandMessage getBrandMessage() {
        return brandMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessagePermissionApplyRequest)) {
            return false;
        }
        BrandMessagePermissionApplyRequest other = (BrandMessagePermissionApplyRequest) o;
        return Objects.equals(brandMessage, other.brandMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandMessage);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessagePermissionApplyRequest{", "}");
        if (brandMessage != null) {
            joiner.add("brandMessage=" + brandMessage);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessagePermissionApplyRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessagePermissionApplyRequestBrandMessage brandMessage;

        /** Creates an empty builder; same as {@link BrandMessagePermissionApplyRequest#builder()}. */
        public Builder() {
        }

        /**
         * 발송 권한 신청 정보입니다. 다른 브랜드메시지 API와 달리 키 이름이 <code>brandMessage</code>(대문자 M)입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 다른 API는 <code>brandmessage</code>(소문자)를 쓰는데 이 API만 <code>brandMessage</code>로 표기되어 있습니다(Part A·B 동일). 서버가 대소문자를 구분하는지 확인이 필요합니다.
         *
         * @param brandMessage the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandMessage")
        public Builder brandMessage(BrandMessagePermissionApplyRequestBrandMessage brandMessage) {
            this.brandMessage = brandMessage;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessagePermissionApplyRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessagePermissionApplyRequest build() {
            BrandMessagePermissionApplyRequest built = new BrandMessagePermissionApplyRequest(this);
            ModelValidator v = new ModelValidator("BrandMessagePermissionApplyRequest");
            v.required("brandMessage", built.brandMessage);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessagePermissionApplyRequest buildUnvalidated() {
            return new BrandMessagePermissionApplyRequest(this);
        }
    }
}
