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
 * 브랜드메시지 기본형 템플릿 동보 발송 요청입니다.
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
@JsonDeserialize(builder = BrandMessageGroupSendCreateRequest.Builder.class)
@JsonPropertyOrder({"brandmessage", "paymentCode"})
public final class BrandMessageGroupSendCreateRequest {

    private final BrandMessageGroupSendCreateRequestBrandmessage brandmessage;
    private final String paymentCode;

    private BrandMessageGroupSendCreateRequest(Builder builder) {
        this.brandmessage = builder.brandmessage;
        this.paymentCode = builder.paymentCode;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.brandmessage = this.brandmessage;
        builder.paymentCode = this.paymentCode;
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
    public static BrandMessageGroupSendCreateRequest fromJson(String json) {
        return RequestParser.parse(json, BrandMessageGroupSendCreateRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageGroupSendCreateRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, BrandMessageGroupSendCreateRequest.class);
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
     * 기본형 템플릿 동보 발송 정보입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandmessage")
    public BrandMessageGroupSendCreateRequestBrandmessage getBrandmessage() {
        return brandmessage;
    }

    /**
     * 정산용 부서 코드입니다. 최대 20자입니다.
     *
     * <p>최대 20자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("paymentCode")
    public String getPaymentCode() {
        return paymentCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageGroupSendCreateRequest)) {
            return false;
        }
        BrandMessageGroupSendCreateRequest other = (BrandMessageGroupSendCreateRequest) o;
        return Objects.equals(brandmessage, other.brandmessage)
                && Objects.equals(paymentCode, other.paymentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandmessage, paymentCode);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageGroupSendCreateRequest{", "}");
        if (brandmessage != null) {
            joiner.add("brandmessage=" + brandmessage);
        }
        if (paymentCode != null) {
            joiner.add("paymentCode=" + io.github.icommapi.bizgo.internal.Masking.length(paymentCode));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageGroupSendCreateRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessageGroupSendCreateRequestBrandmessage brandmessage;
        private String paymentCode;

        /** Creates an empty builder; same as {@link BrandMessageGroupSendCreateRequest#builder()}. */
        public Builder() {
        }

        /**
         * 기본형 템플릿 동보 발송 정보입니다.
         *
         * <p>필수
         *
         * @param brandmessage the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandmessage")
        public Builder brandmessage(BrandMessageGroupSendCreateRequestBrandmessage brandmessage) {
            this.brandmessage = brandmessage;
            return this;
        }

        /**
         * 정산용 부서 코드입니다. 최대 20자입니다.
         *
         * <p>최대 20자
         *
         * @param paymentCode the value (null clears it)
         * @return this builder
         */
        @JsonProperty("paymentCode")
        public Builder paymentCode(String paymentCode) {
            this.paymentCode = paymentCode;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageGroupSendCreateRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageGroupSendCreateRequest build() {
            BrandMessageGroupSendCreateRequest built = new BrandMessageGroupSendCreateRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageGroupSendCreateRequest");
            v.required("brandmessage", built.brandmessage);
            v.maxLength("paymentCode", built.paymentCode, 20);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageGroupSendCreateRequest buildUnvalidated() {
            return new BrandMessageGroupSendCreateRequest(this);
        }
    }
}
