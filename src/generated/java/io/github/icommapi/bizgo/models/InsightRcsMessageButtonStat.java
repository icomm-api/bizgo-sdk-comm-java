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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * RCS 메시지 버튼 클릭 일자별 통계 1건(카드 단위)입니다.
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
@JsonPropertyOrder({"statDate", "corpId", "corpRegNum", "brandId", "chatbotId", "groupId", "messagebaseId", "reactionType", "cardNum", "buttonList"})
public final class InsightRcsMessageButtonStat {

    private final String statDate;
    private final String corpId;
    private final String corpRegNum;
    private final String brandId;
    private final String chatbotId;
    private final String groupId;
    private final String messagebaseId;
    private final String reactionType;
    private final Long cardNum;
    private final List<InsightRcsButtonClick> buttonList;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private InsightRcsMessageButtonStat(
            @JsonProperty("statDate") String statDate,
            @JsonProperty("corpId") String corpId,
            @JsonProperty("corpRegNum") String corpRegNum,
            @JsonProperty("brandId") String brandId,
            @JsonProperty("chatbotId") String chatbotId,
            @JsonProperty("groupId") String groupId,
            @JsonProperty("messagebaseId") String messagebaseId,
            @JsonProperty("reactionType") String reactionType,
            @JsonProperty("cardNum") Long cardNum,
            @JsonProperty("buttonList") List<InsightRcsButtonClick> buttonList) {
        this.statDate = statDate;
        this.corpId = corpId;
        this.corpRegNum = corpRegNum;
        this.brandId = brandId;
        this.chatbotId = chatbotId;
        this.groupId = groupId;
        this.messagebaseId = messagebaseId;
        this.reactionType = reactionType;
        this.cardNum = cardNum;
        this.buttonList = buttonList == null ? null : Collections.unmodifiableList(new ArrayList<>(buttonList));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private InsightRcsMessageButtonStat(Builder builder) {
        this(builder.statDate, builder.corpId, builder.corpRegNum, builder.brandId, builder.chatbotId, builder.groupId, builder.messagebaseId, builder.reactionType, builder.cardNum, builder.buttonList);
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
        builder.reactionType = this.reactionType;
        builder.cardNum = this.cardNum;
        builder.buttonList = this.buttonList;
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
     * 그룹 ID입니다.
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
     * 반응 유형입니다. 알려진 값은 <code>button</code>입니다.
     *
     * <p>알려진 값 <code>button</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reactionType")
    public String getReactionType() {
        return reactionType;
    }

    /**
     * 카드 번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("cardNum")
    public Long getCardNum() {
        return cardNum;
    }

    /**
     * 버튼별 클릭 상세입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttonList")
    public List<InsightRcsButtonClick> getButtonList() {
        return buttonList;
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
        if (!(o instanceof InsightRcsMessageButtonStat)) {
            return false;
        }
        InsightRcsMessageButtonStat other = (InsightRcsMessageButtonStat) o;
        return Objects.equals(statDate, other.statDate)
                && Objects.equals(corpId, other.corpId)
                && Objects.equals(corpRegNum, other.corpRegNum)
                && Objects.equals(brandId, other.brandId)
                && Objects.equals(chatbotId, other.chatbotId)
                && Objects.equals(groupId, other.groupId)
                && Objects.equals(messagebaseId, other.messagebaseId)
                && Objects.equals(reactionType, other.reactionType)
                && Objects.equals(cardNum, other.cardNum)
                && Objects.equals(buttonList, other.buttonList)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statDate, corpId, corpRegNum, brandId, chatbotId, groupId, messagebaseId, reactionType, cardNum, buttonList, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "InsightRcsMessageButtonStat{", "}");
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
        if (reactionType != null) {
            joiner.add("reactionType=" + io.github.icommapi.bizgo.internal.Masking.length(reactionType));
        }
        if (cardNum != null) {
            joiner.add("cardNum=***");
        }
        if (buttonList != null) {
            joiner.add("buttonList=" + buttonList);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link InsightRcsMessageButtonStat}. */
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
        private String reactionType;
        private Long cardNum;
        private List<InsightRcsButtonClick> buttonList;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link InsightRcsMessageButtonStat#builder()}. */
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
         * 그룹 ID입니다.
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
         * 반응 유형입니다. 알려진 값은 <code>button</code>입니다.
         *
         * <p>알려진 값 <code>button</code>
         *
         * @param reactionType the value (null clears it)
         * @return this builder
         */
        public Builder reactionType(String reactionType) {
            this.reactionType = reactionType;
            return this;
        }

        /**
         * 카드 번호입니다.
         *
         * @param cardNum the value (null clears it)
         * @return this builder
         */
        public Builder cardNum(Long cardNum) {
            this.cardNum = cardNum;
            return this;
        }

        /**
         * 버튼별 클릭 상세입니다.
         *
         * @param buttonList the value (null clears it)
         * @return this builder
         */
        public Builder buttonList(List<InsightRcsButtonClick> buttonList) {
            this.buttonList = buttonList;
            return this;
        }

        /**
         * Varargs form of {@link #buttonList(List)}.
         *
         * @param buttonList values
         * @return this builder
         */
        public Builder buttonList(InsightRcsButtonClick... buttonList) {
            this.buttonList = buttonList == null ? null : Arrays.asList(buttonList);
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
         * @return a new immutable {@code InsightRcsMessageButtonStat}
         */
        public InsightRcsMessageButtonStat build() {
            return new InsightRcsMessageButtonStat(this);
        }
    }
}
