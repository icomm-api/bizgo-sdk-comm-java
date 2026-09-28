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
 * 아이템 리스트 요소입니다. ITEM_LIST, WIDE_ITEM_LIST 타입에서 필수입니다.
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
@JsonDeserialize(builder = CounselItem.Builder.class)
@JsonPropertyOrder({"highlight", "list", "summary"})
public final class CounselItem {

    private final CounselItemHighlight highlight;
    private final List<CounselItemListEntry> list;
    private final CounselItemSummary summary;

    private CounselItem(Builder builder) {
        this.highlight = builder.highlight;
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
        builder.highlight = this.highlight;
        builder.list = this.list;
        builder.summary = this.summary;
        return builder;
    }

    /**
     * {@code highlight}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("highlight")
    public CounselItemHighlight getHighlight() {
        return highlight;
    }

    /**
     * 아이템 리스트입니다. ITEM_LIST는 2~10개, WIDE_ITEM_LIST는 3~4개입니다.
     *
     * <p>필수 · 항목 수 2~10
     *
     * @return the value, or null if not set
     */
    @JsonProperty("list")
    public List<CounselItemListEntry> getList() {
        return list;
    }

    /**
     * {@code summary}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("summary")
    public CounselItemSummary getSummary() {
        return summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselItem)) {
            return false;
        }
        CounselItem other = (CounselItem) o;
        return Objects.equals(highlight, other.highlight)
                && Objects.equals(list, other.list)
                && Objects.equals(summary, other.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(highlight, list, summary);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselItem{", "}");
        if (highlight != null) {
            joiner.add("highlight=" + highlight);
        }
        if (list != null) {
            joiner.add("list=" + list);
        }
        if (summary != null) {
            joiner.add("summary=" + summary);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselItem}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private CounselItemHighlight highlight;
        private List<CounselItemListEntry> list;
        private CounselItemSummary summary;

        /** Creates an empty builder; same as {@link CounselItem#builder()}. */
        public Builder() {
        }

        /**
         * {@code highlight}.
         *
         * @param highlight the value (null clears it)
         * @return this builder
         */
        @JsonProperty("highlight")
        public Builder highlight(CounselItemHighlight highlight) {
            this.highlight = highlight;
            return this;
        }

        /**
         * 아이템 리스트입니다. ITEM_LIST는 2~10개, WIDE_ITEM_LIST는 3~4개입니다.
         *
         * <p>필수 · 항목 수 2~10
         *
         * @param list the value (null clears it)
         * @return this builder
         */
        @JsonProperty("list")
        public Builder list(List<CounselItemListEntry> list) {
            this.list = list;
            return this;
        }

        /**
         * Varargs form of {@link #list(List)}.
         *
         * @param list values
         * @return this builder
         */
        public Builder list(CounselItemListEntry... list) {
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
        public Builder summary(CounselItemSummary summary) {
            this.summary = summary;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselItem}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselItem build() {
            CounselItem built = new CounselItem(this);
            ModelValidator v = new ModelValidator("CounselItem");
            v.required("list", built.list);
            v.items("list", built.list, 2, 10);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselItem buildUnvalidated() {
            return new CounselItem(this);
        }
    }
}
