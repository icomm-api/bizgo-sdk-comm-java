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
 * 전화 걸기 객체입니다.
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
@JsonDeserialize(builder = RcsDialerActionDialPhoneNumber.Builder.class)
@JsonPropertyOrder({"phoneNumber"})
public final class RcsDialerActionDialPhoneNumber {

    private final String phoneNumber;

    private RcsDialerActionDialPhoneNumber(Builder builder) {
        this.phoneNumber = builder.phoneNumber;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.phoneNumber = this.phoneNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsDialerActionDialPhoneNumber)) {
            return false;
        }
        RcsDialerActionDialPhoneNumber other = (RcsDialerActionDialPhoneNumber) o;
        return Objects.equals(phoneNumber, other.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsDialerActionDialPhoneNumber{", "}");
        if (phoneNumber != null) {
            joiner.add("phoneNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(phoneNumber));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsDialerActionDialPhoneNumber}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String phoneNumber;

        /** Creates an empty builder; same as {@link RcsDialerActionDialPhoneNumber#builder()}. */
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
         * Builds the object.
         *
         * @return a new immutable {@code RcsDialerActionDialPhoneNumber}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsDialerActionDialPhoneNumber build() {
            RcsDialerActionDialPhoneNumber built = new RcsDialerActionDialPhoneNumber(this);
            ModelValidator v = new ModelValidator("RcsDialerActionDialPhoneNumber");
            v.required("phoneNumber", built.phoneNumber);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsDialerActionDialPhoneNumber buildUnvalidated() {
            return new RcsDialerActionDialPhoneNumber(this);
        }
    }
}
