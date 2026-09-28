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
 * 전화 걸기 액션입니다.
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
@JsonDeserialize(builder = RcsDialerAction.Builder.class)
@JsonPropertyOrder({"dialPhoneNumber"})
public final class RcsDialerAction {

    private final RcsDialerActionDialPhoneNumber dialPhoneNumber;

    private RcsDialerAction(Builder builder) {
        this.dialPhoneNumber = builder.dialPhoneNumber;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.dialPhoneNumber = this.dialPhoneNumber;
        return builder;
    }

    /**
     * 전화 걸기 객체입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("dialPhoneNumber")
    public RcsDialerActionDialPhoneNumber getDialPhoneNumber() {
        return dialPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsDialerAction)) {
            return false;
        }
        RcsDialerAction other = (RcsDialerAction) o;
        return Objects.equals(dialPhoneNumber, other.dialPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dialPhoneNumber);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsDialerAction{", "}");
        if (dialPhoneNumber != null) {
            joiner.add("dialPhoneNumber=" + dialPhoneNumber);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsDialerAction}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsDialerActionDialPhoneNumber dialPhoneNumber;

        /** Creates an empty builder; same as {@link RcsDialerAction#builder()}. */
        public Builder() {
        }

        /**
         * 전화 걸기 객체입니다.
         *
         * <p>필수
         *
         * @param dialPhoneNumber the value (null clears it)
         * @return this builder
         */
        @JsonProperty("dialPhoneNumber")
        public Builder dialPhoneNumber(RcsDialerActionDialPhoneNumber dialPhoneNumber) {
            this.dialPhoneNumber = dialPhoneNumber;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsDialerAction}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsDialerAction build() {
            RcsDialerAction built = new RcsDialerAction(this);
            ModelValidator v = new ModelValidator("RcsDialerAction");
            v.required("dialPhoneNumber", built.dialPhoneNumber);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsDialerAction buildUnvalidated() {
            return new RcsDialerAction(this);
        }
    }
}
