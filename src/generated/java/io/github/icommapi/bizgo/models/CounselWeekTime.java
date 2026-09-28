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
 * 요일별 상담 시간입니다.
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
@JsonDeserialize(builder = CounselWeekTime.Builder.class)
@JsonPropertyOrder({"day", "startAt", "endAt"})
public final class CounselWeekTime {
    private static final List<String> DAY_VALUES = List.of("mon", "tue", "wed", "thu", "fri", "sat", "sun");

    private final String day;
    private final String startAt;
    private final String endAt;

    private CounselWeekTime(Builder builder) {
        this.day = builder.day;
        this.startAt = builder.startAt;
        this.endAt = builder.endAt;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.day = this.day;
        builder.startAt = this.startAt;
        builder.endAt = this.endAt;
        return builder;
    }

    /**
     * 요일입니다.
     *
     * <p>필수 · 허용 값 <code>mon</code>, <code>tue</code>, <code>wed</code>, <code>thu</code>, <code>fri</code>, <code>sat</code>, <code>sun</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    /**
     * 상담 시작 시간입니다. 문서 예시는 <code>0900</code>입니다.
     *
     * <p>필수 · 형식 <code>HHmm</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("startAt")
    public String getStartAt() {
        return startAt;
    }

    /**
     * 상담 종료 시간입니다. 문서 예시는 <code>1800</code>입니다.
     *
     * <p>필수 · 형식 <code>HHmm</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("endAt")
    public String getEndAt() {
        return endAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselWeekTime)) {
            return false;
        }
        CounselWeekTime other = (CounselWeekTime) o;
        return Objects.equals(day, other.day)
                && Objects.equals(startAt, other.startAt)
                && Objects.equals(endAt, other.endAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, startAt, endAt);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselWeekTime{", "}");
        if (day != null) {
            joiner.add("day=" + io.github.icommapi.bizgo.internal.Masking.length(day));
        }
        if (startAt != null) {
            joiner.add("startAt=" + io.github.icommapi.bizgo.internal.Masking.length(startAt));
        }
        if (endAt != null) {
            joiner.add("endAt=" + io.github.icommapi.bizgo.internal.Masking.length(endAt));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselWeekTime}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String day;
        private String startAt;
        private String endAt;

        /** Creates an empty builder; same as {@link CounselWeekTime#builder()}. */
        public Builder() {
        }

        /**
         * 요일입니다.
         *
         * <p>필수 · 허용 값 <code>mon</code>, <code>tue</code>, <code>wed</code>, <code>thu</code>, <code>fri</code>, <code>sat</code>, <code>sun</code>
         *
         * @param day the value (null clears it)
         * @return this builder
         */
        @JsonProperty("day")
        public Builder day(String day) {
            this.day = day;
            return this;
        }

        /**
         * 상담 시작 시간입니다. 문서 예시는 <code>0900</code>입니다.
         *
         * <p>필수 · 형식 <code>HHmm</code>
         *
         * @param startAt the value (null clears it)
         * @return this builder
         */
        @JsonProperty("startAt")
        public Builder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }

        /**
         * 상담 종료 시간입니다. 문서 예시는 <code>1800</code>입니다.
         *
         * <p>필수 · 형식 <code>HHmm</code>
         *
         * @param endAt the value (null clears it)
         * @return this builder
         */
        @JsonProperty("endAt")
        public Builder endAt(String endAt) {
            this.endAt = endAt;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselWeekTime}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselWeekTime build() {
            CounselWeekTime built = new CounselWeekTime(this);
            ModelValidator v = new ModelValidator("CounselWeekTime");
            v.required("day", built.day);
            v.oneOf("day", built.day, DAY_VALUES);
            v.required("startAt", built.startAt);
            v.required("endAt", built.endAt);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselWeekTime buildUnvalidated() {
            return new CounselWeekTime(this);
        }
    }
}
