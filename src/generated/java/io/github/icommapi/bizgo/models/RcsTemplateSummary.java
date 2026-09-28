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
 * RCS 템플릿 목록 항목입니다.
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
@JsonPropertyOrder({"messagebaseId", "formatId", "templateName", "brandId", "status", "approvalResult", "approvalReason", "registerDate", "approvalDate", "updateDate", "registerId", "updateId"})
public final class RcsTemplateSummary {

    private final String messagebaseId;
    private final String formatId;
    private final String templateName;
    private final String brandId;
    private final String status;
    private final String approvalResult;
    private final String approvalReason;
    private final String registerDate;
    private final String approvalDate;
    private final String updateDate;
    private final String registerId;
    private final String updateId;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsTemplateSummary(
            @JsonProperty("messagebaseId") String messagebaseId,
            @JsonProperty("formatId") String formatId,
            @JsonProperty("templateName") String templateName,
            @JsonProperty("brandId") String brandId,
            @JsonProperty("status") String status,
            @JsonProperty("approvalResult") String approvalResult,
            @JsonProperty("approvalReason") String approvalReason,
            @JsonProperty("registerDate") String registerDate,
            @JsonProperty("approvalDate") String approvalDate,
            @JsonProperty("updateDate") String updateDate,
            @JsonProperty("registerId") String registerId,
            @JsonProperty("updateId") String updateId) {
        this.messagebaseId = messagebaseId;
        this.formatId = formatId;
        this.templateName = templateName;
        this.brandId = brandId;
        this.status = status;
        this.approvalResult = approvalResult;
        this.approvalReason = approvalReason;
        this.registerDate = registerDate;
        this.approvalDate = approvalDate;
        this.updateDate = updateDate;
        this.registerId = registerId;
        this.updateId = updateId;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsTemplateSummary(Builder builder) {
        this(builder.messagebaseId, builder.formatId, builder.templateName, builder.brandId, builder.status, builder.approvalResult, builder.approvalReason, builder.registerDate, builder.approvalDate, builder.updateDate, builder.registerId, builder.updateId);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.messagebaseId = this.messagebaseId;
        builder.formatId = this.formatId;
        builder.templateName = this.templateName;
        builder.brandId = this.brandId;
        builder.status = this.status;
        builder.approvalResult = this.approvalResult;
        builder.approvalReason = this.approvalReason;
        builder.registerDate = this.registerDate;
        builder.approvalDate = this.approvalDate;
        builder.updateDate = this.updateDate;
        builder.registerId = this.registerId;
        builder.updateId = this.updateId;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 메시지베이스 ID입니다. 발송 시에는 이 값을 <code>formatId</code> 필드에 넣습니다(영문 문서 기준).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messagebaseId")
    public String getMessagebaseId() {
        return messagebaseId;
    }

    /**
     * 템플릿 양식 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("formatId")
    public String getFormatId() {
        return formatId;
    }

    /**
     * 템플릿 이름입니다.
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
     * 템플릿의 상태입니다. 알려진 값(영문 문서 기준)은 <code>ready</code>(사용 중), <code>pause</code>(중지)입니다.
     *
     * <p>알려진 값 <code>ready</code>, <code>pause</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 템플릿의 승인 상태입니다. 문서 예시 값은 <code>approved</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("approvalResult")
    public String getApprovalResult() {
        return approvalResult;
    }

    /**
     * 승인 사유입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("approvalReason")
    public String getApprovalReason() {
        return approvalReason;
    }

    /**
     * 템플릿 등록일시입니다.
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
     * 템플릿 수정일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("updateDate")
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 템플릿 등록 계정 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("registerId")
    public String getRegisterId() {
        return registerId;
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
        if (!(o instanceof RcsTemplateSummary)) {
            return false;
        }
        RcsTemplateSummary other = (RcsTemplateSummary) o;
        return Objects.equals(messagebaseId, other.messagebaseId)
                && Objects.equals(formatId, other.formatId)
                && Objects.equals(templateName, other.templateName)
                && Objects.equals(brandId, other.brandId)
                && Objects.equals(status, other.status)
                && Objects.equals(approvalResult, other.approvalResult)
                && Objects.equals(approvalReason, other.approvalReason)
                && Objects.equals(registerDate, other.registerDate)
                && Objects.equals(approvalDate, other.approvalDate)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(registerId, other.registerId)
                && Objects.equals(updateId, other.updateId)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messagebaseId, formatId, templateName, brandId, status, approvalResult, approvalReason, registerDate, approvalDate, updateDate, registerId, updateId, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateSummary{", "}");
        if (messagebaseId != null) {
            joiner.add("messagebaseId=" + io.github.icommapi.bizgo.internal.Masking.length(messagebaseId));
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
        if (approvalReason != null) {
            joiner.add("approvalReason=" + io.github.icommapi.bizgo.internal.Masking.length(approvalReason));
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
        if (registerId != null) {
            joiner.add("registerId=" + io.github.icommapi.bizgo.internal.Masking.length(registerId));
        }
        if (updateId != null) {
            joiner.add("updateId=" + io.github.icommapi.bizgo.internal.Masking.length(updateId));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateSummary}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String messagebaseId;
        private String formatId;
        private String templateName;
        private String brandId;
        private String status;
        private String approvalResult;
        private String approvalReason;
        private String registerDate;
        private String approvalDate;
        private String updateDate;
        private String registerId;
        private String updateId;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsTemplateSummary#builder()}. */
        public Builder() {
        }

        /**
         * 메시지베이스 ID입니다. 발송 시에는 이 값을 <code>formatId</code> 필드에 넣습니다(영문 문서 기준).
         *
         * @param messagebaseId the value (null clears it)
         * @return this builder
         */
        public Builder messagebaseId(String messagebaseId) {
            this.messagebaseId = messagebaseId;
            return this;
        }

        /**
         * 템플릿 양식 ID입니다.
         *
         * @param formatId the value (null clears it)
         * @return this builder
         */
        public Builder formatId(String formatId) {
            this.formatId = formatId;
            return this;
        }

        /**
         * 템플릿 이름입니다.
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
         * 템플릿의 상태입니다. 알려진 값(영문 문서 기준)은 <code>ready</code>(사용 중), <code>pause</code>(중지)입니다.
         *
         * <p>알려진 값 <code>ready</code>, <code>pause</code>
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 템플릿의 승인 상태입니다. 문서 예시 값은 <code>approved</code>입니다.
         *
         * @param approvalResult the value (null clears it)
         * @return this builder
         */
        public Builder approvalResult(String approvalResult) {
            this.approvalResult = approvalResult;
            return this;
        }

        /**
         * 승인 사유입니다.
         *
         * @param approvalReason the value (null clears it)
         * @return this builder
         */
        public Builder approvalReason(String approvalReason) {
            this.approvalReason = approvalReason;
            return this;
        }

        /**
         * 템플릿 등록일시입니다.
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
         * 템플릿 수정일시입니다.
         *
         * @param updateDate the value (null clears it)
         * @return this builder
         */
        public Builder updateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        /**
         * 템플릿 등록 계정 ID입니다.
         *
         * @param registerId the value (null clears it)
         * @return this builder
         */
        public Builder registerId(String registerId) {
            this.registerId = registerId;
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
         * @return a new immutable {@code RcsTemplateSummary}
         */
        public RcsTemplateSummary build() {
            return new RcsTemplateSummary(this);
        }
    }
}
