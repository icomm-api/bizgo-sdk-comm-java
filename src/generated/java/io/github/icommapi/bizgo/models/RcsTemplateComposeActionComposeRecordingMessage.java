// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 음성/영상 보내기 객체입니다.
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
@JsonDeserialize(builder = RcsTemplateComposeActionComposeRecordingMessage.Builder.class)
@JsonPropertyOrder({"phoneNumber", "type"})
public final class RcsTemplateComposeActionComposeRecordingMessage {
    private static final List<String> TYPE_VALUES = List.of("VIDEO", "AUDIO");

    private final String phoneNumber;
    private final String type;

    private RcsTemplateComposeActionComposeRecordingMessage(Builder builder) {
        this.phoneNumber = builder.phoneNumber;
        this.type = builder.type;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.phoneNumber = this.phoneNumber;
        builder.type = this.type;
        return builder;
    }

    /**
     * 전화번호입니다.
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
     * 영상(<code>VIDEO</code>) 또는 음성(<code>AUDIO</code>)입니다.
     *
     * <p>필수 · 허용 값 <code>VIDEO</code>, <code>AUDIO</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateComposeActionComposeRecordingMessage)) {
            return false;
        }
        RcsTemplateComposeActionComposeRecordingMessage other = (RcsTemplateComposeActionComposeRecordingMessage) o;
        return Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, type);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateComposeActionComposeRecordingMessage{", "}");
        if (phoneNumber != null) {
            joiner.add("phoneNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(phoneNumber));
        }
        if (type != null) {
            joiner.add("type=" + type);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateComposeActionComposeRecordingMessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String phoneNumber;
        private String type;

        /** Creates an empty builder; same as {@link RcsTemplateComposeActionComposeRecordingMessage#builder()}. */
        public Builder() {
        }

        /**
         * 전화번호입니다.
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
         * 영상(<code>VIDEO</code>) 또는 음성(<code>AUDIO</code>)입니다.
         *
         * <p>필수 · 허용 값 <code>VIDEO</code>, <code>AUDIO</code>
         *
         * @param type the value (null clears it)
         * @return this builder
         */
        @JsonProperty("type")
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateComposeActionComposeRecordingMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateComposeActionComposeRecordingMessage build() {
            RcsTemplateComposeActionComposeRecordingMessage built = new RcsTemplateComposeActionComposeRecordingMessage(this);
            ModelValidator v = new ModelValidator("RcsTemplateComposeActionComposeRecordingMessage");
            v.required("phoneNumber", built.phoneNumber);
            v.required("type", built.type);
            v.oneOf("type", built.type, TYPE_VALUES);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateComposeActionComposeRecordingMessage buildUnvalidated() {
            return new RcsTemplateComposeActionComposeRecordingMessage(this);
        }
    }
}
