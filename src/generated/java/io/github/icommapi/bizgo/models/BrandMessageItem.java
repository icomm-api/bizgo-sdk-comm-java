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
 * 브랜드메시지 와이드 아이템 요소입니다(와이드 리스트형, FL).
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
@JsonDeserialize(builder = BrandMessageItem.Builder.class)
@JsonPropertyOrder({"list"})
public final class BrandMessageItem {

    private final List<BrandMessageItemListEntry> list;

    private BrandMessageItem(Builder builder) {
        this.list = builder.list == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.list));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.list = this.list;
        return builder;
    }

    /**
     * 아이템 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("list")
    public List<BrandMessageItemListEntry> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageItem)) {
            return false;
        }
        BrandMessageItem other = (BrandMessageItem) o;
        return Objects.equals(list, other.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageItem{", "}");
        if (list != null) {
            joiner.add("list=" + list);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageItem}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<BrandMessageItemListEntry> list;

        /** Creates an empty builder; same as {@link BrandMessageItem#builder()}. */
        public Builder() {
        }

        /**
         * 아이템 목록입니다.
         *
         * @param list the value (null clears it)
         * @return this builder
         */
        @JsonProperty("list")
        public Builder list(List<BrandMessageItemListEntry> list) {
            this.list = list;
            return this;
        }

        /**
         * Varargs form of {@link #list(List)}.
         *
         * @param list values
         * @return this builder
         */
        public Builder list(BrandMessageItemListEntry... list) {
            this.list = list == null ? null : Arrays.asList(list);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageItem}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageItem build() {
            BrandMessageItem built = new BrandMessageItem(this);
            ModelValidator v = new ModelValidator("BrandMessageItem");
            v.items("list", built.list, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageItem buildUnvalidated() {
            return new BrandMessageItem(this);
        }
    }
}
