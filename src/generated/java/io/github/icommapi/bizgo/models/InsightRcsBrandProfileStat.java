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
 * 브랜드 프로필 노출 일자별 통계 1건입니다.
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
@JsonPropertyOrder({"statDate", "chatbotId", "displayedCount"})
public final class InsightRcsBrandProfileStat {

    private final String statDate;
    private final String chatbotId;
    private final Long displayedCount;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private InsightRcsBrandProfileStat(
            @JsonProperty("statDate") String statDate,
            @JsonProperty("chatbotId") String chatbotId,
            @JsonProperty("displayedCount") Long displayedCount) {
        this.statDate = statDate;
        this.chatbotId = chatbotId;
        this.displayedCount = displayedCount;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private InsightRcsBrandProfileStat(Builder builder) {
        this(builder.statDate, builder.chatbotId, builder.displayedCount);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.statDate = this.statDate;
        builder.chatbotId = this.chatbotId;
        builder.displayedCount = this.displayedCount;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 통계 일자(yyyyMMdd)입니다.
     *
     * <p>형식 <code>yyyyMMdd</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("statDate")
    public String getStatDate() {
        return statDate;
    }

    /**
     * 챗봇 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatbotId")
    public String getChatbotId() {
        return chatbotId;
    }

    /**
     * 노출 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("displayedCount")
    public Long getDisplayedCount() {
        return displayedCount;
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
        if (!(o instanceof InsightRcsBrandProfileStat)) {
            return false;
        }
        InsightRcsBrandProfileStat other = (InsightRcsBrandProfileStat) o;
        return Objects.equals(statDate, other.statDate)
                && Objects.equals(chatbotId, other.chatbotId)
                && Objects.equals(displayedCount, other.displayedCount)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statDate, chatbotId, displayedCount, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "InsightRcsBrandProfileStat{", "}");
        if (statDate != null) {
            joiner.add("statDate=" + statDate);
        }
        if (chatbotId != null) {
            joiner.add("chatbotId=" + io.github.icommapi.bizgo.internal.Masking.length(chatbotId));
        }
        if (displayedCount != null) {
            joiner.add("displayedCount=***");
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link InsightRcsBrandProfileStat}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String statDate;
        private String chatbotId;
        private Long displayedCount;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link InsightRcsBrandProfileStat#builder()}. */
        public Builder() {
        }

        /**
         * 통계 일자(yyyyMMdd)입니다.
         *
         * <p>형식 <code>yyyyMMdd</code>
         *
         * @param statDate the value (null clears it)
         * @return this builder
         */
        public Builder statDate(String statDate) {
            this.statDate = statDate;
            return this;
        }

        /**
         * 챗봇 ID입니다.
         *
         * @param chatbotId the value (null clears it)
         * @return this builder
         */
        public Builder chatbotId(String chatbotId) {
            this.chatbotId = chatbotId;
            return this;
        }

        /**
         * 노출 건수입니다.
         *
         * @param displayedCount the value (null clears it)
         * @return this builder
         */
        public Builder displayedCount(Long displayedCount) {
            this.displayedCount = displayedCount;
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
         * @return a new immutable {@code InsightRcsBrandProfileStat}
         */
        public InsightRcsBrandProfileStat build() {
            return new InsightRcsBrandProfileStat(this);
        }
    }
}
