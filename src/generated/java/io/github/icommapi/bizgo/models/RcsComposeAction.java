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
 * 문자 보내기 또는 영상/음성 보내기 액션입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 문서상 composeTextMessage가 필수로 표시되어 있어, composeRecordingMessage만 쓰는 경우에도 composeTextMessage가 필요한지 불명확합니다.
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
@JsonDeserialize(builder = RcsComposeAction.Builder.class)
@JsonPropertyOrder({"composeTextMessage", "composeRecordingMessage"})
public final class RcsComposeAction {

    private final RcsComposeActionComposeTextMessage composeTextMessage;
    private final RcsComposeActionComposeRecordingMessage composeRecordingMessage;

    private RcsComposeAction(Builder builder) {
        this.composeTextMessage = builder.composeTextMessage;
        this.composeRecordingMessage = builder.composeRecordingMessage;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.composeTextMessage = this.composeTextMessage;
        builder.composeRecordingMessage = this.composeRecordingMessage;
        return builder;
    }

    /**
     * 문자 보내기 객체입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("composeTextMessage")
    public RcsComposeActionComposeTextMessage getComposeTextMessage() {
        return composeTextMessage;
    }

    /**
     * 영상/음성 보내기 객체입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("composeRecordingMessage")
    public RcsComposeActionComposeRecordingMessage getComposeRecordingMessage() {
        return composeRecordingMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsComposeAction)) {
            return false;
        }
        RcsComposeAction other = (RcsComposeAction) o;
        return Objects.equals(composeTextMessage, other.composeTextMessage)
                && Objects.equals(composeRecordingMessage, other.composeRecordingMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(composeTextMessage, composeRecordingMessage);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsComposeAction{", "}");
        if (composeTextMessage != null) {
            joiner.add("composeTextMessage=" + composeTextMessage);
        }
        if (composeRecordingMessage != null) {
            joiner.add("composeRecordingMessage=" + composeRecordingMessage);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsComposeAction}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsComposeActionComposeTextMessage composeTextMessage;
        private RcsComposeActionComposeRecordingMessage composeRecordingMessage;

        /** Creates an empty builder; same as {@link RcsComposeAction#builder()}. */
        public Builder() {
        }

        /**
         * 문자 보내기 객체입니다.
         *
         * <p>필수
         *
         * @param composeTextMessage the value (null clears it)
         * @return this builder
         */
        @JsonProperty("composeTextMessage")
        public Builder composeTextMessage(RcsComposeActionComposeTextMessage composeTextMessage) {
            this.composeTextMessage = composeTextMessage;
            return this;
        }

        /**
         * 영상/음성 보내기 객체입니다.
         *
         * @param composeRecordingMessage the value (null clears it)
         * @return this builder
         */
        @JsonProperty("composeRecordingMessage")
        public Builder composeRecordingMessage(RcsComposeActionComposeRecordingMessage composeRecordingMessage) {
            this.composeRecordingMessage = composeRecordingMessage;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsComposeAction}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsComposeAction build() {
            RcsComposeAction built = new RcsComposeAction(this);
            ModelValidator v = new ModelValidator("RcsComposeAction");
            v.required("composeTextMessage", built.composeTextMessage);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsComposeAction buildUnvalidated() {
            return new RcsComposeAction(this);
        }
    }
}
