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
 * 공통 포맷 목록 항목입니다.
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
@JsonPropertyOrder({"messagebaseformId", "formName", "bizCondition", "cardType", "formatId", "templateName", "brandId", "status", "approvalResult", "updateId", "registerDate", "approvalDate", "updateDate"})
public final class RcsMessagebaseCommonSummary {

    private final String messagebaseformId;
    private final String formName;
    private final List<String> bizCondition;
    private final String cardType;
    private final String formatId;
    private final String templateName;
    private final String brandId;
    private final String status;
    private final String approvalResult;
    private final String updateId;
    private final String registerDate;
    private final String approvalDate;
    private final String updateDate;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsMessagebaseCommonSummary(
            @JsonProperty("messagebaseformId") String messagebaseformId,
            @JsonProperty("formName") String formName,
            @JsonProperty("bizCondition") List<String> bizCondition,
            @JsonProperty("cardType") String cardType,
            @JsonProperty("formatId") String formatId,
            @JsonProperty("templateName") String templateName,
            @JsonProperty("brandId") String brandId,
            @JsonProperty("status") String status,
            @JsonProperty("approvalResult") String approvalResult,
            @JsonProperty("updateId") String updateId,
            @JsonProperty("registerDate") String registerDate,
            @JsonProperty("approvalDate") String approvalDate,
            @JsonProperty("updateDate") String updateDate) {
        this.messagebaseformId = messagebaseformId;
        this.formName = formName;
        this.bizCondition = bizCondition == null ? null : Collections.unmodifiableList(new ArrayList<>(bizCondition));
        this.cardType = cardType;
        this.formatId = formatId;
        this.templateName = templateName;
        this.brandId = brandId;
        this.status = status;
        this.approvalResult = approvalResult;
        this.updateId = updateId;
        this.registerDate = registerDate;
        this.approvalDate = approvalDate;
        this.updateDate = updateDate;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsMessagebaseCommonSummary(Builder builder) {
        this(builder.messagebaseformId, builder.formName, builder.bizCondition, builder.cardType, builder.formatId, builder.templateName, builder.brandId, builder.status, builder.approvalResult, builder.updateId, builder.registerDate, builder.approvalDate, builder.updateDate);
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
        builder.formatId = this.formatId;
        builder.templateName = this.templateName;
        builder.brandId = this.brandId;
        builder.status = this.status;
        builder.approvalResult = this.approvalResult;
        builder.updateId = this.updateId;
        builder.registerDate = this.registerDate;
        builder.approvalDate = this.approvalDate;
        builder.updateDate = this.updateDate;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 템플릿의 원형인 템플릿 양식 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messagebaseformId")
    public String getMessagebaseformId() {
        return messagebaseformId;
    }

    /**
     * 포맷 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("formName")
    public String getFormName() {
        return formName;
    }

    /**
     * 비즈 조건 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizCondition")
    public List<String> getBizCondition() {
        return bizCondition;
    }

    /**
     * 카드 유형입니다. 문서 예시 값은 <code>standalone media top</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("cardType")
    public String getCardType() {
        return cardType;
    }

    /**
     * 템플릿 포맷 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("formatId")
    public String getFormatId() {
        return formatId;
    }

    /**
     * 템플릿 등록 시 입력된 템플릿 명칭입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateName")
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 브랜드 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandId")
    public String getBrandId() {
        return brandId;
    }

    /**
     * 템플릿의 상태입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 템플릿의 승인 상태입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("approvalResult")
    public String getApprovalResult() {
        return approvalResult;
    }

    /**
     * 템플릿 수정 계정 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("updateId")
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 템플릿 등록일시입니다. 문서 예시는 <code>yyyy-MM-dd'T'HH:mm:ss</code> 형식입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("registerDate")
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * 템플릿 승인일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("approvalDate")
    public String getApprovalDate() {
        return approvalDate;
    }

    /**
     * 템플릿 수정일시입니다. 문서 예시는 <code>yyyy-MM-dd'T'HH:mm:ss</code> 형식입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
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
        if (!(o instanceof RcsMessagebaseCommonSummary)) {
            return false;
        }
        RcsMessagebaseCommonSummary other = (RcsMessagebaseCommonSummary) o;
        return Objects.equals(messagebaseformId, other.messagebaseformId)
                && Objects.equals(formName, other.formName)
                && Objects.equals(bizCondition, other.bizCondition)
                && Objects.equals(cardType, other.cardType)
                && Objects.equals(formatId, other.formatId)
                && Objects.equals(templateName, other.templateName)
                && Objects.equals(brandId, other.brandId)
                && Objects.equals(status, other.status)
                && Objects.equals(approvalResult, other.approvalResult)
                && Objects.equals(updateId, other.updateId)
                && Objects.equals(registerDate, other.registerDate)
                && Objects.equals(approvalDate, other.approvalDate)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messagebaseformId, formName, bizCondition, cardType, formatId, templateName, brandId, status, approvalResult, updateId, registerDate, approvalDate, updateDate, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsMessagebaseCommonSummary{", "}");
        if (messagebaseformId != null) {
            joiner.add("messagebaseformId=" + io.github.icommapi.bizgo.internal.Masking.length(messagebaseformId));
        }
        if (formName != null) {
            joiner.add("formName=" + io.github.icommapi.bizgo.internal.Masking.length(formName));
        }
        if (bizCondition != null) {
            joiner.add("bizCondition=***");
        }
        if (cardType != null) {
            joiner.add("cardType=" + io.github.icommapi.bizgo.internal.Masking.length(cardType));
        }
        if (formatId != null) {
            joiner.add("formatId=" + formatId);
        }
        if (templateName != null) {
            joiner.add("templateName=" + io.github.icommapi.bizgo.internal.Masking.length(templateName));
        }
        if (brandId != null) {
            joiner.add("brandId=" + io.github.icommapi.bizgo.internal.Masking.length(brandId));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (approvalResult != null) {
            joiner.add("approvalResult=" + io.github.icommapi.bizgo.internal.Masking.length(approvalResult));
        }
        if (updateId != null) {
            joiner.add("updateId=" + io.github.icommapi.bizgo.internal.Masking.length(updateId));
        }
        if (registerDate != null) {
            joiner.add("registerDate=" + io.github.icommapi.bizgo.internal.Masking.length(registerDate));
        }
        if (approvalDate != null) {
            joiner.add("approvalDate=" + io.github.icommapi.bizgo.internal.Masking.length(approvalDate));
        }
        if (updateDate != null) {
            joiner.add("updateDate=" + io.github.icommapi.bizgo.internal.Masking.length(updateDate));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsMessagebaseCommonSummary}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String messagebaseformId;
        private String formName;
        private List<String> bizCondition;
        private String cardType;
        private String formatId;
        private String templateName;
        private String brandId;
        private String status;
        private String approvalResult;
        private String updateId;
        private String registerDate;
        private String approvalDate;
        private String updateDate;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsMessagebaseCommonSummary#builder()}. */
        public Builder() {
        }

        /**
         * 템플릿의 원형인 템플릿 양식 ID입니다.
         *
         * @param messagebaseformId the value (null clears it)
         * @return this builder
         */
        public Builder messagebaseformId(String messagebaseformId) {
            this.messagebaseformId = messagebaseformId;
            return this;
        }

        /**
         * 포맷 이름입니다.
         *
         * @param formName the value (null clears it)
         * @return this builder
         */
        public Builder formName(String formName) {
            this.formName = formName;
            return this;
        }

        /**
         * 비즈 조건 목록입니다.
         *
         * @param bizCondition the value (null clears it)
         * @return this builder
         */
        public Builder bizCondition(List<String> bizCondition) {
            this.bizCondition = bizCondition;
            return this;
        }

        /**
         * Varargs form of {@link #bizCondition(List)}.
         *
         * @param bizCondition values
         * @return this builder
         */
        public Builder bizCondition(String... bizCondition) {
            this.bizCondition = bizCondition == null ? null : Arrays.asList(bizCondition);
            return this;
        }

        /**
         * 카드 유형입니다. 문서 예시 값은 <code>standalone media top</code>입니다.
         *
         * @param cardType the value (null clears it)
         * @return this builder
         */
        public Builder cardType(String cardType) {
            this.cardType = cardType;
            return this;
        }

        /**
         * 템플릿 포맷 ID입니다.
         *
         * @param formatId the value (null clears it)
         * @return this builder
         */
        public Builder formatId(String formatId) {
            this.formatId = formatId;
            return this;
        }

        /**
         * 템플릿 등록 시 입력된 템플릿 명칭입니다.
         *
         * @param templateName the value (null clears it)
         * @return this builder
         */
        public Builder templateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        /**
         * 브랜드 ID입니다.
         *
         * @param brandId the value (null clears it)
         * @return this builder
         */
        public Builder brandId(String brandId) {
            this.brandId = brandId;
            return this;
        }

        /**
         * 템플릿의 상태입니다.
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 템플릿의 승인 상태입니다.
         *
         * @param approvalResult the value (null clears it)
         * @return this builder
         */
        public Builder approvalResult(String approvalResult) {
            this.approvalResult = approvalResult;
            return this;
        }

        /**
         * 템플릿 수정 계정 ID입니다.
         *
         * @param updateId the value (null clears it)
         * @return this builder
         */
        public Builder updateId(String updateId) {
            this.updateId = updateId;
            return this;
        }

        /**
         * 템플릿 등록일시입니다. 문서 예시는 <code>yyyy-MM-dd'T'HH:mm:ss</code> 형식입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
         *
         * @param registerDate the value (null clears it)
         * @return this builder
         */
        public Builder registerDate(String registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        /**
         * 템플릿 승인일시입니다.
         *
         * @param approvalDate the value (null clears it)
         * @return this builder
         */
        public Builder approvalDate(String approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        /**
         * 템플릿 수정일시입니다. 문서 예시는 <code>yyyy-MM-dd'T'HH:mm:ss</code> 형식입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
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
         * @return a new immutable {@code RcsMessagebaseCommonSummary}
         */
        public RcsMessagebaseCommonSummary build() {
            return new RcsMessagebaseCommonSummary(this);
        }
    }
}
