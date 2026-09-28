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
 * 템플릿 버튼의 문자/음성/영상 보내기 액션입니다. 발송용 <code>RcsComposeAction</code>과 달리 <code>composeTextMessage</code>가 선택입니다.
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
@JsonDeserialize(builder = RcsTemplateComposeAction.Builder.class)
@JsonPropertyOrder({"composeTextMessage", "composeRecordingMessage"})
public final class RcsTemplateComposeAction {

    private final RcsTemplateComposeActionComposeTextMessage composeTextMessage;
    private final RcsTemplateComposeActionComposeRecordingMessage composeRecordingMessage;

    private RcsTemplateComposeAction(Builder builder) {
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
     * @return the value, or null if not set
     */
    @JsonProperty("composeTextMessage")
    public RcsTemplateComposeActionComposeTextMessage getComposeTextMessage() {
        return composeTextMessage;
    }

    /**
     * 음성/영상 보내기 객체입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("composeRecordingMessage")
    public RcsTemplateComposeActionComposeRecordingMessage getComposeRecordingMessage() {
        return composeRecordingMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateComposeAction)) {
            return false;
        }
        RcsTemplateComposeAction other = (RcsTemplateComposeAction) o;
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
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateComposeAction{", "}");
        if (composeTextMessage != null) {
            joiner.add("composeTextMessage=" + composeTextMessage);
        }
        if (composeRecordingMessage != null) {
            joiner.add("composeRecordingMessage=" + composeRecordingMessage);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateComposeAction}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsTemplateComposeActionComposeTextMessage composeTextMessage;
        private RcsTemplateComposeActionComposeRecordingMessage composeRecordingMessage;

        /** Creates an empty builder; same as {@link RcsTemplateComposeAction#builder()}. */
        public Builder() {
        }

        /**
         * 문자 보내기 객체입니다.
         *
         * @param composeTextMessage the value (null clears it)
         * @return this builder
         */
        @JsonProperty("composeTextMessage")
        public Builder composeTextMessage(RcsTemplateComposeActionComposeTextMessage composeTextMessage) {
            this.composeTextMessage = composeTextMessage;
            return this;
        }

        /**
         * 음성/영상 보내기 객체입니다.
         *
         * @param composeRecordingMessage the value (null clears it)
         * @return this builder
         */
        @JsonProperty("composeRecordingMessage")
        public Builder composeRecordingMessage(RcsTemplateComposeActionComposeRecordingMessage composeRecordingMessage) {
            this.composeRecordingMessage = composeRecordingMessage;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateComposeAction}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateComposeAction build() {
            RcsTemplateComposeAction built = new RcsTemplateComposeAction(this);
            ModelValidator v = new ModelValidator("RcsTemplateComposeAction");
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateComposeAction buildUnvalidated() {
            return new RcsTemplateComposeAction(this);
        }
    }
}
