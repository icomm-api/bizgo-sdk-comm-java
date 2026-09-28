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
 * RCS 메시지 발송·노출 일자별 통계 1건입니다.
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
@JsonPropertyOrder({"statDate", "corpId", "corpRegNum", "brandId", "chatbotId", "groupId", "messagebaseId", "deliveredCount", "displayedCount"})
public final class InsightRcsMessageStat {

    private final String statDate;
    private final String corpId;
    private final String corpRegNum;
    private final String brandId;
    private final String chatbotId;
    private final String groupId;
    private final String messagebaseId;
    private final Long deliveredCount;
    private final Long displayedCount;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private InsightRcsMessageStat(
            @JsonProperty("statDate") String statDate,
            @JsonProperty("corpId") String corpId,
            @JsonProperty("corpRegNum") String corpRegNum,
            @JsonProperty("brandId") String brandId,
            @JsonProperty("chatbotId") String chatbotId,
            @JsonProperty("groupId") String groupId,
            @JsonProperty("messagebaseId") String messagebaseId,
            @JsonProperty("deliveredCount") Long deliveredCount,
            @JsonProperty("displayedCount") Long displayedCount) {
        this.statDate = statDate;
        this.corpId = corpId;
        this.corpRegNum = corpRegNum;
        this.brandId = brandId;
        this.chatbotId = chatbotId;
        this.groupId = groupId;
        this.messagebaseId = messagebaseId;
        this.deliveredCount = deliveredCount;
        this.displayedCount = displayedCount;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private InsightRcsMessageStat(Builder builder) {
        this(builder.statDate, builder.corpId, builder.corpRegNum, builder.brandId, builder.chatbotId, builder.groupId, builder.messagebaseId, builder.deliveredCount, builder.displayedCount);
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
        builder.corpId = this.corpId;
        builder.corpRegNum = this.corpRegNum;
        builder.brandId = this.brandId;
        builder.chatbotId = this.chatbotId;
        builder.groupId = this.groupId;
        builder.messagebaseId = this.messagebaseId;
        builder.deliveredCount = this.deliveredCount;
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
     * 기업 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("corpId")
    public String getCorpId() {
        return corpId;
    }

    /**
     * 사업자등록번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("corpRegNum")
    public String getCorpRegNum() {
        return corpRegNum;
    }

    /**
     * RCS 브랜드 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandId")
    public String getBrandId() {
        return brandId;
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
     * 그룹 ID입니다. 발송 요청의 <code>messageFlow[].rcs.groupId</code> 값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupId")
    public String getGroupId() {
        return groupId;
    }

    /**
     * 메시지베이스 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messagebaseId")
    public String getMessagebaseId() {
        return messagebaseId;
    }

    /**
     * 발송 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("deliveredCount")
    public Long getDeliveredCount() {
        return deliveredCount;
    }

    /**
     * 노출(읽음) 건수입니다.
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
        if (!(o instanceof InsightRcsMessageStat)) {
            return false;
        }
        InsightRcsMessageStat other = (InsightRcsMessageStat) o;
        return Objects.equals(statDate, other.statDate)
                && Objects.equals(corpId, other.corpId)
                && Objects.equals(corpRegNum, other.corpRegNum)
                && Objects.equals(brandId, other.brandId)
                && Objects.equals(chatbotId, other.chatbotId)
                && Objects.equals(groupId, other.groupId)
                && Objects.equals(messagebaseId, other.messagebaseId)
                && Objects.equals(deliveredCount, other.deliveredCount)
                && Objects.equals(displayedCount, other.displayedCount)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statDate, corpId, corpRegNum, brandId, chatbotId, groupId, messagebaseId, deliveredCount, displayedCount, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "InsightRcsMessageStat{", "}");
        if (statDate != null) {
            joiner.add("statDate=" + statDate);
        }
        if (corpId != null) {
            joiner.add("corpId=" + io.github.icommapi.bizgo.internal.Masking.length(corpId));
        }
        if (corpRegNum != null) {
            joiner.add("corpRegNum=" + io.github.icommapi.bizgo.internal.Masking.length(corpRegNum));
        }
        if (brandId != null) {
            joiner.add("brandId=" + io.github.icommapi.bizgo.internal.Masking.length(brandId));
        }
        if (chatbotId != null) {
            joiner.add("chatbotId=" + io.github.icommapi.bizgo.internal.Masking.length(chatbotId));
        }
        if (groupId != null) {
            joiner.add("groupId=" + io.github.icommapi.bizgo.internal.Masking.length(groupId));
        }
        if (messagebaseId != null) {
            joiner.add("messagebaseId=" + io.github.icommapi.bizgo.internal.Masking.length(messagebaseId));
        }
        if (deliveredCount != null) {
            joiner.add("deliveredCount=***");
        }
        if (displayedCount != null) {
            joiner.add("displayedCount=***");
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link InsightRcsMessageStat}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String statDate;
        private String corpId;
        private String corpRegNum;
        private String brandId;
        private String chatbotId;
        private String groupId;
        private String messagebaseId;
        private Long deliveredCount;
        private Long displayedCount;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link InsightRcsMessageStat#builder()}. */
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
         * 기업 ID입니다.
         *
         * @param corpId the value (null clears it)
         * @return this builder
         */
        public Builder corpId(String corpId) {
            this.corpId = corpId;
            return this;
        }

        /**
         * 사업자등록번호입니다.
         *
         * @param corpRegNum the value (null clears it)
         * @return this builder
         */
        public Builder corpRegNum(String corpRegNum) {
            this.corpRegNum = corpRegNum;
            return this;
        }

        /**
         * RCS 브랜드 ID입니다.
         *
         * @param brandId the value (null clears it)
         * @return this builder
         */
        public Builder brandId(String brandId) {
            this.brandId = brandId;
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
         * 그룹 ID입니다. 발송 요청의 <code>messageFlow[].rcs.groupId</code> 값입니다.
         *
         * @param groupId the value (null clears it)
         * @return this builder
         */
        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        /**
         * 메시지베이스 ID입니다.
         *
         * @param messagebaseId the value (null clears it)
         * @return this builder
         */
        public Builder messagebaseId(String messagebaseId) {
            this.messagebaseId = messagebaseId;
            return this;
        }

        /**
         * 발송 건수입니다.
         *
         * @param deliveredCount the value (null clears it)
         * @return this builder
         */
        public Builder deliveredCount(Long deliveredCount) {
            this.deliveredCount = deliveredCount;
            return this;
        }

        /**
         * 노출(읽음) 건수입니다.
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
         * @return a new immutable {@code InsightRcsMessageStat}
         */
        public InsightRcsMessageStat build() {
            return new InsightRcsMessageStat(this);
        }
    }
}
