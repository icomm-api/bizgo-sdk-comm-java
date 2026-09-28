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
 * 일정 등록 객체입니다.
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
@JsonDeserialize(builder = RcsCalendarActionCreateCalendarEvent.Builder.class)
@JsonPropertyOrder({"startTime", "endTime", "title", "description"})
public final class RcsCalendarActionCreateCalendarEvent {

    private final String startTime;
    private final String endTime;
    private final String title;
    private final String description;

    private RcsCalendarActionCreateCalendarEvent(Builder builder) {
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.title = builder.title;
        this.description = builder.description;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.startTime = this.startTime;
        builder.endTime = this.endTime;
        builder.title = this.title;
        builder.description = this.description;
        return builder;
    }

    /**
     * 시작 시간입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 시각 형식이 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * 종료 시간입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 시각 형식이 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("endTime")
    public String getEndTime() {
        return endTime;
    }

    /**
     * 일정 제목입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 일정 설명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsCalendarActionCreateCalendarEvent)) {
            return false;
        }
        RcsCalendarActionCreateCalendarEvent other = (RcsCalendarActionCreateCalendarEvent) o;
        return Objects.equals(startTime, other.startTime)
                && Objects.equals(endTime, other.endTime)
                && Objects.equals(title, other.title)
                && Objects.equals(description, other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime, title, description);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsCalendarActionCreateCalendarEvent{", "}");
        if (startTime != null) {
            joiner.add("startTime=" + io.github.icommapi.bizgo.internal.Masking.length(startTime));
        }
        if (endTime != null) {
            joiner.add("endTime=" + io.github.icommapi.bizgo.internal.Masking.length(endTime));
        }
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (description != null) {
            joiner.add("description=" + io.github.icommapi.bizgo.internal.Masking.length(description));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsCalendarActionCreateCalendarEvent}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String startTime;
        private String endTime;
        private String title;
        private String description;

        /** Creates an empty builder; same as {@link RcsCalendarActionCreateCalendarEvent#builder()}. */
        public Builder() {
        }

        /**
         * 시작 시간입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 시각 형식이 문서화되어 있지 않습니다.
         *
         * @param startTime the value (null clears it)
         * @return this builder
         */
        @JsonProperty("startTime")
        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        /**
         * 종료 시간입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 시각 형식이 문서화되어 있지 않습니다.
         *
         * @param endTime the value (null clears it)
         * @return this builder
         */
        @JsonProperty("endTime")
        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        /**
         * 일정 제목입니다.
         *
         * <p>필수
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        @JsonProperty("title")
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 일정 설명입니다.
         *
         * @param description the value (null clears it)
         * @return this builder
         */
        @JsonProperty("description")
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsCalendarActionCreateCalendarEvent}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsCalendarActionCreateCalendarEvent build() {
            RcsCalendarActionCreateCalendarEvent built = new RcsCalendarActionCreateCalendarEvent(this);
            ModelValidator v = new ModelValidator("RcsCalendarActionCreateCalendarEvent");
            v.required("startTime", built.startTime);
            v.required("endTime", built.endTime);
            v.required("title", built.title);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsCalendarActionCreateCalendarEvent buildUnvalidated() {
            return new RcsCalendarActionCreateCalendarEvent(this);
        }
    }
}
