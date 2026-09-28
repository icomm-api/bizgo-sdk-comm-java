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
 * 알림톡 첨부 정보(버튼, 아이템, 아이템 하이라이트)입니다.
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
@JsonDeserialize(builder = AlimtalkAttachment.Builder.class)
@JsonPropertyOrder({"button", "item", "itemHighlight"})
public final class AlimtalkAttachment {

    private final List<AlimtalkButton> button;
    private final AlimtalkItem item;
    private final AlimtalkItemHighlight itemHighlight;

    private AlimtalkAttachment(Builder builder) {
        this.button = builder.button == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.button));
        this.item = builder.item;
        this.itemHighlight = builder.itemHighlight;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.button = this.button;
        builder.item = this.item;
        builder.itemHighlight = this.itemHighlight;
        return builder;
    }

    /**
     * 버튼 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("button")
    public List<AlimtalkButton> getButton() {
        return button;
    }

    /**
     * {@code item}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("item")
    public AlimtalkItem getItem() {
        return item;
    }

    /**
     * {@code itemHighlight}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("itemHighlight")
    public AlimtalkItemHighlight getItemHighlight() {
        return itemHighlight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkAttachment)) {
            return false;
        }
        AlimtalkAttachment other = (AlimtalkAttachment) o;
        return Objects.equals(button, other.button)
                && Objects.equals(item, other.item)
                && Objects.equals(itemHighlight, other.itemHighlight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(button, item, itemHighlight);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkAttachment{", "}");
        if (button != null) {
            joiner.add("button=" + button);
        }
        if (item != null) {
            joiner.add("item=" + item);
        }
        if (itemHighlight != null) {
            joiner.add("itemHighlight=" + itemHighlight);
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkAttachment}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<AlimtalkButton> button;
        private AlimtalkItem item;
        private AlimtalkItemHighlight itemHighlight;

        /** Creates an empty builder; same as {@link AlimtalkAttachment#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 정보입니다.
         *
         * @param button the value (null clears it)
         * @return this builder
         */
        @JsonProperty("button")
        public Builder button(List<AlimtalkButton> button) {
            this.button = button;
            return this;
        }

        /**
         * Varargs form of {@link #button(List)}.
         *
         * @param button values
         * @return this builder
         */
        public Builder button(AlimtalkButton... button) {
            this.button = button == null ? null : Arrays.asList(button);
            return this;
        }

        /**
         * {@code item}.
         *
         * @param item the value (null clears it)
         * @return this builder
         */
        @JsonProperty("item")
        public Builder item(AlimtalkItem item) {
            this.item = item;
            return this;
        }

        /**
         * {@code itemHighlight}.
         *
         * @param itemHighlight the value (null clears it)
         * @return this builder
         */
        @JsonProperty("itemHighlight")
        public Builder itemHighlight(AlimtalkItemHighlight itemHighlight) {
            this.itemHighlight = itemHighlight;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkAttachment}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkAttachment build() {
            AlimtalkAttachment built = new AlimtalkAttachment(this);
            ModelValidator v = new ModelValidator("AlimtalkAttachment");
            v.items("button", built.button, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkAttachment buildUnvalidated() {
            return new AlimtalkAttachment(this);
        }
    }
}
