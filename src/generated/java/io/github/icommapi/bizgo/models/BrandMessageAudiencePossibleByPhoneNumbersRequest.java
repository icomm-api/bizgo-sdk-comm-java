// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 전화번호 명단 기반 발송 예상 모수 확인 요청입니다.
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
@JsonDeserialize(builder = BrandMessageAudiencePossibleByPhoneNumbersRequest.Builder.class)
@JsonPropertyOrder({"senderKey", "phoneNumbers"})
public final class BrandMessageAudiencePossibleByPhoneNumbersRequest {

    private final String senderKey;
    private final List<String> phoneNumbers;

    private BrandMessageAudiencePossibleByPhoneNumbersRequest(Builder builder) {
        this.senderKey = builder.senderKey;
        this.phoneNumbers = builder.phoneNumbers == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.phoneNumbers));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.phoneNumbers = this.phoneNumbers;
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
    public static BrandMessageAudiencePossibleByPhoneNumbersRequest fromJson(String json) {
        return RequestParser.parse(json, BrandMessageAudiencePossibleByPhoneNumbersRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageAudiencePossibleByPhoneNumbersRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, BrandMessageAudiencePossibleByPhoneNumbersRequest.class);
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
     * 발송 가능 여부를 확인할 전화번호 목록입니다. 최소 10건이며, 하나라도 형식이 잘못되면 요청 전체가 거부됩니다. 국가코드는 자동 정규화됩니다(010 / +82 / 82 → 82).
     *
     * <p>필수 · 항목 수 10~
     *
     * @return the value, or null if not set
     */
    @JsonProperty("phoneNumbers")
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageAudiencePossibleByPhoneNumbersRequest)) {
            return false;
        }
        BrandMessageAudiencePossibleByPhoneNumbersRequest other = (BrandMessageAudiencePossibleByPhoneNumbersRequest) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(phoneNumbers, other.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, phoneNumbers);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageAudiencePossibleByPhoneNumbersRequest{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (phoneNumbers != null) {
            joiner.add("phoneNumbers=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageAudiencePossibleByPhoneNumbersRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private List<String> phoneNumbers;

        /** Creates an empty builder; same as {@link BrandMessageAudiencePossibleByPhoneNumbersRequest#builder()}. */
        public Builder() {
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
         * 발송 가능 여부를 확인할 전화번호 목록입니다. 최소 10건이며, 하나라도 형식이 잘못되면 요청 전체가 거부됩니다. 국가코드는 자동 정규화됩니다(010 / +82 / 82 → 82).
         *
         * <p>필수 · 항목 수 10~
         *
         * @param phoneNumbers the value (null clears it)
         * @return this builder
         */
        @JsonProperty("phoneNumbers")
        public Builder phoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        /**
         * Varargs form of {@link #phoneNumbers(List)}.
         *
         * @param phoneNumbers values
         * @return this builder
         */
        public Builder phoneNumbers(String... phoneNumbers) {
            this.phoneNumbers = phoneNumbers == null ? null : Arrays.asList(phoneNumbers);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageAudiencePossibleByPhoneNumbersRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageAudiencePossibleByPhoneNumbersRequest build() {
            BrandMessageAudiencePossibleByPhoneNumbersRequest built = new BrandMessageAudiencePossibleByPhoneNumbersRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageAudiencePossibleByPhoneNumbersRequest");
            v.required("senderKey", built.senderKey);
            v.required("phoneNumbers", built.phoneNumbers);
            v.items("phoneNumbers", built.phoneNumbers, 10, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageAudiencePossibleByPhoneNumbersRequest buildUnvalidated() {
            return new BrandMessageAudiencePossibleByPhoneNumbersRequest(this);
        }
    }
}
