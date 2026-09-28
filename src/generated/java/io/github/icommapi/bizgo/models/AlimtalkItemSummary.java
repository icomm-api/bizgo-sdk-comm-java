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
 * 알림톡 아이템 요약 정보입니다.
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
@JsonDeserialize(builder = AlimtalkItemSummary.Builder.class)
@JsonPropertyOrder({"title", "description"})
public final class AlimtalkItemSummary {

    private final String title;
    private final String description;

    private AlimtalkItemSummary(Builder builder) {
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
        builder.title = this.title;
        builder.description = this.description;
        return builder;
    }

    /**
     * 요약 타이틀입니다. 최대 6자입니다.
     *
     * <p>필수 · 최대 6자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 요약 가격정보입니다. 최대 14자입니다. 허용 문자: 통화 기호(유니코드 통화 기호, 元, 円, 원), 통화 코드(ISO 4217), 숫자, 쉼표, 소수점, 공백. 소수점 이하는 2자리까지 허용합니다.
     *
     * <p>필수 · 최대 14자
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
        if (!(o instanceof AlimtalkItemSummary)) {
            return false;
        }
        AlimtalkItemSummary other = (AlimtalkItemSummary) o;
        return Objects.equals(title, other.title)
                && Objects.equals(description, other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkItemSummary{", "}");
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (description != null) {
            joiner.add("description=" + io.github.icommapi.bizgo.internal.Masking.length(description));
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkItemSummary}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String title;
        private String description;

        /** Creates an empty builder; same as {@link AlimtalkItemSummary#builder()}. */
        public Builder() {
        }

        /**
         * 요약 타이틀입니다. 최대 6자입니다.
         *
         * <p>필수 · 최대 6자
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
         * 요약 가격정보입니다. 최대 14자입니다. 허용 문자: 통화 기호(유니코드 통화 기호, 元, 円, 원), 통화 코드(ISO 4217), 숫자, 쉼표, 소수점, 공백. 소수점 이하는 2자리까지 허용합니다.
         *
         * <p>필수 · 최대 14자
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
         * @return a new immutable {@code AlimtalkItemSummary}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkItemSummary build() {
            AlimtalkItemSummary built = new AlimtalkItemSummary(this);
            ModelValidator v = new ModelValidator("AlimtalkItemSummary");
            v.required("title", built.title);
            v.maxLength("title", built.title, 6);
            v.required("description", built.description);
            v.maxLength("description", built.description, 14);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkItemSummary buildUnvalidated() {
            return new AlimtalkItemSummary(this);
        }
    }
}
