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
 * 알림톡 아이템 정보입니다.
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
@JsonDeserialize(builder = AlimtalkItem.Builder.class)
@JsonPropertyOrder({"list", "summary"})
public final class AlimtalkItem {

    private final List<AlimtalkItemListEntry> list;
    private final AlimtalkItemSummary summary;

    private AlimtalkItem(Builder builder) {
        this.list = builder.list == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.list));
        this.summary = builder.summary;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.list = this.list;
        builder.summary = this.summary;
        return builder;
    }

    /**
     * 아이템 리스트입니다. 최소 2개, 최대 10개입니다.
     *
     * <p>항목 수 2~10
     *
     * @return the value, or null if not set
     */
    @JsonProperty("list")
    public List<AlimtalkItemListEntry> getList() {
        return list;
    }

    /**
     * {@code summary}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("summary")
    public AlimtalkItemSummary getSummary() {
        return summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkItem)) {
            return false;
        }
        AlimtalkItem other = (AlimtalkItem) o;
        return Objects.equals(list, other.list)
                && Objects.equals(summary, other.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list, summary);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkItem{", "}");
        if (list != null) {
            joiner.add("list=" + list);
        }
        if (summary != null) {
            joiner.add("summary=" + summary);
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkItem}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<AlimtalkItemListEntry> list;
        private AlimtalkItemSummary summary;

        /** Creates an empty builder; same as {@link AlimtalkItem#builder()}. */
        public Builder() {
        }

        /**
         * 아이템 리스트입니다. 최소 2개, 최대 10개입니다.
         *
         * <p>항목 수 2~10
         *
         * @param list the value (null clears it)
         * @return this builder
         */
        @JsonProperty("list")
        public Builder list(List<AlimtalkItemListEntry> list) {
            this.list = list;
            return this;
        }

        /**
         * Varargs form of {@link #list(List)}.
         *
         * @param list values
         * @return this builder
         */
        public Builder list(AlimtalkItemListEntry... list) {
            this.list = list == null ? null : Arrays.asList(list);
            return this;
        }

        /**
         * {@code summary}.
         *
         * @param summary the value (null clears it)
         * @return this builder
         */
        @JsonProperty("summary")
        public Builder summary(AlimtalkItemSummary summary) {
            this.summary = summary;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkItem}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkItem build() {
            AlimtalkItem built = new AlimtalkItem(this);
            ModelValidator v = new ModelValidator("AlimtalkItem");
            v.items("list", built.list, 2, 10);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkItem buildUnvalidated() {
            return new AlimtalkItem(this);
        }
    }
}
