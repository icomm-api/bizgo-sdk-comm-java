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
 * 버튼 액션 객체입니다. 아래 액션 유형 객체를 넣습니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 한 action에 액션 유형을 하나만 넣어야 하는지 문서에 명시되어 있지 않습니다.
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
@JsonDeserialize(builder = RcsAction.Builder.class)
@JsonPropertyOrder({"urlAction", "dialerAction", "mapAction", "calendarAction", "composeAction"})
public final class RcsAction {

    private final RcsUrlAction urlAction;
    private final RcsDialerAction dialerAction;
    private final RcsMapAction mapAction;
    private final RcsCalendarAction calendarAction;
    private final RcsComposeAction composeAction;

    private RcsAction(Builder builder) {
        this.urlAction = builder.urlAction;
        this.dialerAction = builder.dialerAction;
        this.mapAction = builder.mapAction;
        this.calendarAction = builder.calendarAction;
        this.composeAction = builder.composeAction;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.urlAction = this.urlAction;
        builder.dialerAction = this.dialerAction;
        builder.mapAction = this.mapAction;
        builder.calendarAction = this.calendarAction;
        builder.composeAction = this.composeAction;
        return builder;
    }

    /**
     * {@code urlAction}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("urlAction")
    public RcsUrlAction getUrlAction() {
        return urlAction;
    }

    /**
     * {@code dialerAction}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("dialerAction")
    public RcsDialerAction getDialerAction() {
        return dialerAction;
    }

    /**
     * {@code mapAction}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("mapAction")
    public RcsMapAction getMapAction() {
        return mapAction;
    }

    /**
     * {@code calendarAction}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("calendarAction")
    public RcsCalendarAction getCalendarAction() {
        return calendarAction;
    }

    /**
     * {@code composeAction}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("composeAction")
    public RcsComposeAction getComposeAction() {
        return composeAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsAction)) {
            return false;
        }
        RcsAction other = (RcsAction) o;
        return Objects.equals(urlAction, other.urlAction)
                && Objects.equals(dialerAction, other.dialerAction)
                && Objects.equals(mapAction, other.mapAction)
                && Objects.equals(calendarAction, other.calendarAction)
                && Objects.equals(composeAction, other.composeAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urlAction, dialerAction, mapAction, calendarAction, composeAction);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsAction{", "}");
        if (urlAction != null) {
            joiner.add("urlAction=" + urlAction);
        }
        if (dialerAction != null) {
            joiner.add("dialerAction=" + dialerAction);
        }
        if (mapAction != null) {
            joiner.add("mapAction=" + mapAction);
        }
        if (calendarAction != null) {
            joiner.add("calendarAction=" + calendarAction);
        }
        if (composeAction != null) {
            joiner.add("composeAction=" + composeAction);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsAction}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private RcsUrlAction urlAction;
        private RcsDialerAction dialerAction;
        private RcsMapAction mapAction;
        private RcsCalendarAction calendarAction;
        private RcsComposeAction composeAction;

        /** Creates an empty builder; same as {@link RcsAction#builder()}. */
        public Builder() {
        }

        /**
         * {@code urlAction}.
         *
         * @param urlAction the value (null clears it)
         * @return this builder
         */
        @JsonProperty("urlAction")
        public Builder urlAction(RcsUrlAction urlAction) {
            this.urlAction = urlAction;
            return this;
        }

        /**
         * {@code dialerAction}.
         *
         * @param dialerAction the value (null clears it)
         * @return this builder
         */
        @JsonProperty("dialerAction")
        public Builder dialerAction(RcsDialerAction dialerAction) {
            this.dialerAction = dialerAction;
            return this;
        }

        /**
         * {@code mapAction}.
         *
         * @param mapAction the value (null clears it)
         * @return this builder
         */
        @JsonProperty("mapAction")
        public Builder mapAction(RcsMapAction mapAction) {
            this.mapAction = mapAction;
            return this;
        }

        /**
         * {@code calendarAction}.
         *
         * @param calendarAction the value (null clears it)
         * @return this builder
         */
        @JsonProperty("calendarAction")
        public Builder calendarAction(RcsCalendarAction calendarAction) {
            this.calendarAction = calendarAction;
            return this;
        }

        /**
         * {@code composeAction}.
         *
         * @param composeAction the value (null clears it)
         * @return this builder
         */
        @JsonProperty("composeAction")
        public Builder composeAction(RcsComposeAction composeAction) {
            this.composeAction = composeAction;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsAction}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsAction build() {
            RcsAction built = new RcsAction(this);
            ModelValidator v = new ModelValidator("RcsAction");
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsAction buildUnvalidated() {
            return new RcsAction(this);
        }
    }
}
