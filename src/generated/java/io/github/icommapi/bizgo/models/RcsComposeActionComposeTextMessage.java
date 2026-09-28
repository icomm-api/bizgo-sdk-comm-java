// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 문자 보내기 객체입니다.
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
@JsonDeserialize(builder = RcsComposeActionComposeTextMessage.Builder.class)
@JsonPropertyOrder({"phoneNumber", "text"})
public final class RcsComposeActionComposeTextMessage {

    private final String phoneNumber;
    private final String text;

    private RcsComposeActionComposeTextMessage(Builder builder) {
        this.phoneNumber = builder.phoneNumber;
        this.text = builder.text;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.phoneNumber = this.phoneNumber;
        builder.text = this.text;
        return builder;
    }

    /**
     * 전화 번호입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 문자(SMS/LMS/MMS) 내용입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsComposeActionComposeTextMessage)) {
            return false;
        }
        RcsComposeActionComposeTextMessage other = (RcsComposeActionComposeTextMessage) o;
        return Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(text, other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, text);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsComposeActionComposeTextMessage{", "}");
        if (phoneNumber != null) {
            joiner.add("phoneNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(phoneNumber));
        }
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsComposeActionComposeTextMessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String phoneNumber;
        private String text;

        /** Creates an empty builder; same as {@link RcsComposeActionComposeTextMessage#builder()}. */
        public Builder() {
        }

        /**
         * 전화 번호입니다.
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
         * 문자(SMS/LMS/MMS) 내용입니다.
         *
         * @param text the value (null clears it)
         * @return this builder
         */
        @JsonProperty("text")
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsComposeActionComposeTextMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsComposeActionComposeTextMessage build() {
            RcsComposeActionComposeTextMessage built = new RcsComposeActionComposeTextMessage(this);
            ModelValidator v = new ModelValidator("RcsComposeActionComposeTextMessage");
            v.required("phoneNumber", built.phoneNumber);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsComposeActionComposeTextMessage buildUnvalidated() {
            return new RcsComposeActionComposeTextMessage(this);
        }
    }
}
