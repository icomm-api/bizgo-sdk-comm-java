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
 * 템플릿 양식 목록 항목입니다.
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
@JsonPropertyOrder({"messagebaseformId", "formName", "bizCondition", "cardType", "bizCategory", "bizService", "registerDate", "updateDate"})
public final class RcsMessagebaseFormSummary {

    private final String messagebaseformId;
    private final String formName;
    private final String bizCondition;
    private final String cardType;
    private final String bizCategory;
    private final String bizService;
    private final String registerDate;
    private final String updateDate;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsMessagebaseFormSummary(
            @JsonProperty("messagebaseformId") String messagebaseformId,
            @JsonProperty("formName") String formName,
            @JsonProperty("bizCondition") String bizCondition,
            @JsonProperty("cardType") String cardType,
            @JsonProperty("bizCategory") String bizCategory,
            @JsonProperty("bizService") String bizService,
            @JsonProperty("registerDate") String registerDate,
            @JsonProperty("updateDate") String updateDate) {
        this.messagebaseformId = messagebaseformId;
        this.formName = formName;
        this.bizCondition = bizCondition;
        this.cardType = cardType;
        this.bizCategory = bizCategory;
        this.bizService = bizService;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsMessagebaseFormSummary(Builder builder) {
        this(builder.messagebaseformId, builder.formName, builder.bizCondition, builder.cardType, builder.bizCategory, builder.bizService, builder.registerDate, builder.updateDate);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.messagebaseformId = this.messagebaseformId;
        builder.formName = this.formName;
        builder.bizCondition = this.bizCondition;
        builder.cardType = this.cardType;
        builder.bizCategory = this.bizCategory;
        builder.bizService = this.bizService;
        builder.registerDate = this.registerDate;
        builder.updateDate = this.updateDate;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 템플릿 양식 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messagebaseformId")
    public String getMessagebaseformId() {
        return messagebaseformId;
    }

    /**
     * 템플릿 양식명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("formName")
    public String getFormName() {
        return formName;
    }

    /**
     * 양식을 사용할 수 있는 대상 업태의 목록입니다.
     *
     * <p><b>확인 필요:</b> 표에는 String으로 표기되어 있으나 응답 예시는 배열(<code>[]</code>)이고, 공통 포맷 목록의 같은 필드는 String Array입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizCondition")
    public String getBizCondition() {
        return bizCondition;
    }

    /**
     * 카드 종류입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("cardType")
    public String getCardType() {
        return cardType;
    }

    /**
     * Description, Cell의 유형 그룹입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizCategory")
    public String getBizCategory() {
        return bizCategory;
    }

    /**
     * Description, Cell의 세부 유형입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizService")
    public String getBizService() {
        return bizService;
    }

    /**
     * 등록일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("registerDate")
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * 수정일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("updateDate")
    public String getUpdateDate() {
        return updateDate;
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
        if (!(o instanceof RcsMessagebaseFormSummary)) {
            return false;
        }
        RcsMessagebaseFormSummary other = (RcsMessagebaseFormSummary) o;
        return Objects.equals(messagebaseformId, other.messagebaseformId)
                && Objects.equals(formName, other.formName)
                && Objects.equals(bizCondition, other.bizCondition)
                && Objects.equals(cardType, other.cardType)
                && Objects.equals(bizCategory, other.bizCategory)
                && Objects.equals(bizService, other.bizService)
                && Objects.equals(registerDate, other.registerDate)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messagebaseformId, formName, bizCondition, cardType, bizCategory, bizService, registerDate, updateDate, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsMessagebaseFormSummary{", "}");
        if (messagebaseformId != null) {
            joiner.add("messagebaseformId=" + io.github.icommapi.bizgo.internal.Masking.length(messagebaseformId));
        }
        if (formName != null) {
            joiner.add("formName=" + io.github.icommapi.bizgo.internal.Masking.length(formName));
        }
        if (bizCondition != null) {
            joiner.add("bizCondition=" + io.github.icommapi.bizgo.internal.Masking.length(bizCondition));
        }
        if (cardType != null) {
            joiner.add("cardType=" + io.github.icommapi.bizgo.internal.Masking.length(cardType));
        }
        if (bizCategory != null) {
            joiner.add("bizCategory=" + io.github.icommapi.bizgo.internal.Masking.length(bizCategory));
        }
        if (bizService != null) {
            joiner.add("bizService=" + io.github.icommapi.bizgo.internal.Masking.length(bizService));
        }
        if (registerDate != null) {
            joiner.add("registerDate=" + io.github.icommapi.bizgo.internal.Masking.length(registerDate));
        }
        if (updateDate != null) {
            joiner.add("updateDate=" + io.github.icommapi.bizgo.internal.Masking.length(updateDate));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsMessagebaseFormSummary}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String messagebaseformId;
        private String formName;
        private String bizCondition;
        private String cardType;
        private String bizCategory;
        private String bizService;
        private String registerDate;
        private String updateDate;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsMessagebaseFormSummary#builder()}. */
        public Builder() {
        }

        /**
         * 템플릿 양식 ID입니다.
         *
         * @param messagebaseformId the value (null clears it)
         * @return this builder
         */
        public Builder messagebaseformId(String messagebaseformId) {
            this.messagebaseformId = messagebaseformId;
            return this;
        }

        /**
         * 템플릿 양식명입니다.
         *
         * @param formName the value (null clears it)
         * @return this builder
         */
        public Builder formName(String formName) {
            this.formName = formName;
            return this;
        }

        /**
         * 양식을 사용할 수 있는 대상 업태의 목록입니다.
         *
         * <p><b>확인 필요:</b> 표에는 String으로 표기되어 있으나 응답 예시는 배열(<code>[]</code>)이고, 공통 포맷 목록의 같은 필드는 String Array입니다.
         *
         * @param bizCondition the value (null clears it)
         * @return this builder
         */
        public Builder bizCondition(String bizCondition) {
            this.bizCondition = bizCondition;
            return this;
        }

        /**
         * 카드 종류입니다.
         *
         * @param cardType the value (null clears it)
         * @return this builder
         */
        public Builder cardType(String cardType) {
            this.cardType = cardType;
            return this;
        }

        /**
         * Description, Cell의 유형 그룹입니다.
         *
         * @param bizCategory the value (null clears it)
         * @return this builder
         */
        public Builder bizCategory(String bizCategory) {
            this.bizCategory = bizCategory;
            return this;
        }

        /**
         * Description, Cell의 세부 유형입니다.
         *
         * @param bizService the value (null clears it)
         * @return this builder
         */
        public Builder bizService(String bizService) {
            this.bizService = bizService;
            return this;
        }

        /**
         * 등록일시입니다.
         *
         * @param registerDate the value (null clears it)
         * @return this builder
         */
        public Builder registerDate(String registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        /**
         * 수정일시입니다.
         *
         * @param updateDate the value (null clears it)
         * @return this builder
         */
        public Builder updateDate(String updateDate) {
            this.updateDate = updateDate;
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
         * @return a new immutable {@code RcsMessagebaseFormSummary}
         */
        public RcsMessagebaseFormSummary build() {
            return new RcsMessagebaseFormSummary(this);
        }
    }
}
