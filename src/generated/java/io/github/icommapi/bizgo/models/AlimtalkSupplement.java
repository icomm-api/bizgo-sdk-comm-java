// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 메시지에 첨부할 바로연결 정보입니다.
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
@JsonDeserialize(builder = AlimtalkSupplement.Builder.class)
@JsonPropertyOrder({"quickReply"})
public final class AlimtalkSupplement {

    private final List<AlimtalkQuickReply> quickReply;

    private AlimtalkSupplement(Builder builder) {
        this.quickReply = builder.quickReply == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.quickReply));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.quickReply = this.quickReply;
        return builder;
    }

    /**
     * 바로연결 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("quickReply")
    public List<AlimtalkQuickReply> getQuickReply() {
        return quickReply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkSupplement)) {
            return false;
        }
        AlimtalkSupplement other = (AlimtalkSupplement) o;
        return Objects.equals(quickReply, other.quickReply);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quickReply);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkSupplement{", "}");
        if (quickReply != null) {
            joiner.add("quickReply=" + quickReply);
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkSupplement}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<AlimtalkQuickReply> quickReply;

        /** Creates an empty builder; same as {@link AlimtalkSupplement#builder()}. */
        public Builder() {
        }

        /**
         * 바로연결 정보입니다.
         *
         * @param quickReply the value (null clears it)
         * @return this builder
         */
        @JsonProperty("quickReply")
        public Builder quickReply(List<AlimtalkQuickReply> quickReply) {
            this.quickReply = quickReply;
            return this;
        }

        /**
         * Varargs form of {@link #quickReply(List)}.
         *
         * @param quickReply values
         * @return this builder
         */
        public Builder quickReply(AlimtalkQuickReply... quickReply) {
            this.quickReply = quickReply == null ? null : Arrays.asList(quickReply);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkSupplement}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkSupplement build() {
            AlimtalkSupplement built = new AlimtalkSupplement(this);
            ModelValidator v = new ModelValidator("AlimtalkSupplement");
            v.items("quickReply", built.quickReply, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkSupplement buildUnvalidated() {
            return new AlimtalkSupplement(this);
        }
    }
}
