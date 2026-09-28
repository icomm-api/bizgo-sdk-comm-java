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
 * 일정 등록 액션입니다.
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
@JsonDeserialize(builder = RcsCalendarAction.Builder.class)
@JsonPropertyOrder({"createCalendarEvent"})
public final class RcsCalendarAction {

    private final RcsCalendarActionCreateCalendarEvent createCalendarEvent;

    private RcsCalendarAction(Builder builder) {
        this.createCalendarEvent = builder.createCalendarEvent;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.createCalendarEvent = this.createCalendarEvent;
        return builder;
    }

    /**
     * 일정 등록 객체입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("createCalendarEvent")
    public RcsCalendarActionCreateCalendarEvent getCreateCalendarEvent() {
        return createCalendarEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsCalendarAction)) {
            return false;
        }
        RcsCalendarAction other = (RcsCalendarAction) o;
        return Objects.equals(createCalendarEvent, other.createCalendarEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createCalendarEvent);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsCalendarAction{", "}");
        if (createCalendarEvent != null) {
            joiner.add("createCalendarEvent=" + createCalendarEvent);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsCalendarAction}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsCalendarActionCreateCalendarEvent createCalendarEvent;

        /** Creates an empty builder; same as {@link RcsCalendarAction#builder()}. */
        public Builder() {
        }

        /**
         * 일정 등록 객체입니다.
         *
         * <p>필수
         *
         * @param createCalendarEvent the value (null clears it)
         * @return this builder
         */
        @JsonProperty("createCalendarEvent")
        public Builder createCalendarEvent(RcsCalendarActionCreateCalendarEvent createCalendarEvent) {
            this.createCalendarEvent = createCalendarEvent;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsCalendarAction}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsCalendarAction build() {
            RcsCalendarAction built = new RcsCalendarAction(this);
            ModelValidator v = new ModelValidator("RcsCalendarAction");
            v.required("createCalendarEvent", built.createCalendarEvent);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsCalendarAction buildUnvalidated() {
            return new RcsCalendarAction(this);
        }
    }
}
