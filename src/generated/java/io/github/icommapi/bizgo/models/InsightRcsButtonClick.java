// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * RCS 메시지 버튼 1개의 클릭 통계입니다.
 *
 * <p>Response model: unknown JSON properties are kept in {@link #getAdditionalProperties()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({"buttonNum", "actionType", "title", "clickCount"})
public final class InsightRcsButtonClick {

    private final Long buttonNum;
    private final String actionType;
    private final String title;
    private final Long clickCount;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private InsightRcsButtonClick(
            @JsonProperty("buttonNum") Long buttonNum,
            @JsonProperty("actionType") String actionType,
            @JsonProperty("title") String title,
            @JsonProperty("clickCount") Long clickCount) {
        this.buttonNum = buttonNum;
        this.actionType = actionType;
        this.title = title;
        this.clickCount = clickCount;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private InsightRcsButtonClick(Builder builder) {
        this(builder.buttonNum, builder.actionType, builder.title, builder.clickCount);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.buttonNum = this.buttonNum;
        builder.actionType = this.actionType;
        builder.title = this.title;
        builder.clickCount = this.clickCount;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 버튼 번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttonNum")
    public Long getButtonNum() {
        return buttonNum;
    }

    /**
     * 버튼 액션 유형입니다. 알려진 값은 <code>urlAction</code>입니다(발송 규격의 action 키 이름으로 보입니다).
     *
     * <p>알려진 값 <code>urlAction</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("actionType")
    public String getActionType() {
        return actionType;
    }

    /**
     * 버튼 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 클릭 수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("clickCount")
    public Long getClickCount() {
        return clickCount;
    }

    /**
     * Properties the server sent that are not in the spec (new fields are kept instead of dropped).
     *
     * @return unmodifiable map, empty if there are none
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnySetter
    private void putAdditionalProperty(String name, Object value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InsightRcsButtonClick)) {
            return false;
        }
        InsightRcsButtonClick other = (InsightRcsButtonClick) o;
        return Objects.equals(buttonNum, other.buttonNum)
                && Objects.equals(actionType, other.actionType)
                && Objects.equals(title, other.title)
                && Objects.equals(clickCount, other.clickCount)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonNum, actionType, title, clickCount, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "InsightRcsButtonClick{", "}");
        if (buttonNum != null) {
            joiner.add("buttonNum=***");
        }
        if (actionType != null) {
            joiner.add("actionType=" + io.github.icommapi.bizgo.internal.Masking.length(actionType));
        }
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (clickCount != null) {
            joiner.add("clickCount=***");
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link InsightRcsButtonClick}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Long buttonNum;
        private String actionType;
        private String title;
        private Long clickCount;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link InsightRcsButtonClick#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 번호입니다.
         *
         * @param buttonNum the value (null clears it)
         * @return this builder
         */
        public Builder buttonNum(Long buttonNum) {
            this.buttonNum = buttonNum;
            return this;
        }

        /**
         * 버튼 액션 유형입니다. 알려진 값은 <code>urlAction</code>입니다(발송 규격의 action 키 이름으로 보입니다).
         *
         * <p>알려진 값 <code>urlAction</code>
         *
         * @param actionType the value (null clears it)
         * @return this builder
         */
        public Builder actionType(String actionType) {
            this.actionType = actionType;
            return this;
        }

        /**
         * 버튼 제목입니다.
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 클릭 수입니다.
         *
         * @param clickCount the value (null clears it)
         * @return this builder
         */
        public Builder clickCount(Long clickCount) {
            this.clickCount = clickCount;
            return this;
        }

        /**
         * Adds a property that is not in the spec.
         *
         * @param name JSON property name
         * @param value value
         * @return this builder
         */
        public Builder additionalProperty(String name, Object value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code InsightRcsButtonClick}
         */
        public InsightRcsButtonClick build() {
            return new InsightRcsButtonClick(this);
        }
    }
}
