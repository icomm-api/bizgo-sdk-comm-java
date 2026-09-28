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
 * RCS 템플릿 상세 정보입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> approvalResult 예시가 목록 조회(approved)와 상세 조회(승인)에서 다릅니다. 일시 형식이 문서화되어 있지 않습니다. 응답에 messagebaseId·templateName·brandId·buttons가 없습니다.
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
@JsonPropertyOrder({"status", "approvalResult", "approvalReason", "registerDate", "approvalDate", "updateDate", "registerId", "updateId", "productCode", "spec", "cardType", "body", "brandKey", "formatId"})
public final class RcsTemplate {

    private final String status;
    private final String approvalResult;
    private final String approvalReason;
    private final String registerDate;
    private final String approvalDate;
    private final String updateDate;
    private final String registerId;
    private final String updateId;
    private final String productCode;
    private final String spec;
    private final String cardType;
    private final RcsTemplateDetailBody body;
    private final String brandKey;
    private final String formatId;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsTemplate(
            @JsonProperty("status") String status,
            @JsonProperty("approvalResult") String approvalResult,
            @JsonProperty("approvalReason") String approvalReason,
            @JsonProperty("registerDate") String registerDate,
            @JsonProperty("approvalDate") String approvalDate,
            @JsonProperty("updateDate") String updateDate,
            @JsonProperty("registerId") String registerId,
            @JsonProperty("updateId") String updateId,
            @JsonProperty("productCode") String productCode,
            @JsonProperty("spec") String spec,
            @JsonProperty("cardType") String cardType,
            @JsonProperty("body") RcsTemplateDetailBody body,
            @JsonProperty("brandKey") String brandKey,
            @JsonProperty("formatId") String formatId) {
        this.status = status;
        this.approvalResult = approvalResult;
        this.approvalReason = approvalReason;
        this.registerDate = registerDate;
        this.approvalDate = approvalDate;
        this.updateDate = updateDate;
        this.registerId = registerId;
        this.updateId = updateId;
        this.productCode = productCode;
        this.spec = spec;
        this.cardType = cardType;
        this.body = body;
        this.brandKey = brandKey;
        this.formatId = formatId;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsTemplate(Builder builder) {
        this(builder.status, builder.approvalResult, builder.approvalReason, builder.registerDate, builder.approvalDate, builder.updateDate, builder.registerId, builder.updateId, builder.productCode, builder.spec, builder.cardType, builder.body, builder.brandKey, builder.formatId);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.status = this.status;
        builder.approvalResult = this.approvalResult;
        builder.approvalReason = this.approvalReason;
        builder.registerDate = this.registerDate;
        builder.approvalDate = this.approvalDate;
        builder.updateDate = this.updateDate;
        builder.registerId = this.registerId;
        builder.updateId = this.updateId;
        builder.productCode = this.productCode;
        builder.spec = this.spec;
        builder.cardType = this.cardType;
        builder.body = this.body;
        builder.brandKey = this.brandKey;
        builder.formatId = this.formatId;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 템플릿 상태입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 승인 결과입니다.
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
     * 등록일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("registerDate")
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * 승인일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("approvalDate")
    public String getApprovalDate() {
        return approvalDate;
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
     * 등록 계정 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("registerId")
    public String getRegisterId() {
        return registerId;
    }

    /**
     * 수정 계정 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("updateId")
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 상품 코드입니다. 문서 예시 값은 <code>lms</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    /**
     * 템플릿 스펙입니다. 문서 예시 값은 <code>openrichcard</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("spec")
    public String getSpec() {
        return spec;
    }

    /**
     * 카드 종류입니다. 문서 예시 값은 <code>descriptionNew</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("cardType")
    public String getCardType() {
        return cardType;
    }

    /**
     * {@code body}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("body")
    public RcsTemplateDetailBody getBody() {
        return body;
    }

    /**
     * 브랜드 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandKey")
    public String getBrandKey() {
        return brandKey;
    }

    /**
     * 템플릿 양식 ID입니다. 발송 시에는 이 값을 <code>formatId</code> 필드에 넣습니다(영문 문서 기준).
     *
     * <p><b>확인 필요:</b> 영문 문서는 messagebaseId와 formatId 모두 발송 시 formatId 필드에 넣는다고 설명해 어느 값을 써야 하는지 불명확합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("formatId")
    public String getFormatId() {
        return formatId;
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
        if (!(o instanceof RcsTemplate)) {
            return false;
        }
        RcsTemplate other = (RcsTemplate) o;
        return Objects.equals(status, other.status)
                && Objects.equals(approvalResult, other.approvalResult)
                && Objects.equals(approvalReason, other.approvalReason)
                && Objects.equals(registerDate, other.registerDate)
                && Objects.equals(approvalDate, other.approvalDate)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(registerId, other.registerId)
                && Objects.equals(updateId, other.updateId)
                && Objects.equals(productCode, other.productCode)
                && Objects.equals(spec, other.spec)
                && Objects.equals(cardType, other.cardType)
                && Objects.equals(body, other.body)
                && Objects.equals(brandKey, other.brandKey)
                && Objects.equals(formatId, other.formatId)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, approvalResult, approvalReason, registerDate, approvalDate, updateDate, registerId, updateId, productCode, spec, cardType, body, brandKey, formatId, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplate{", "}");
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
        if (productCode != null) {
            joiner.add("productCode=" + io.github.icommapi.bizgo.internal.Masking.length(productCode));
        }
        if (spec != null) {
            joiner.add("spec=" + io.github.icommapi.bizgo.internal.Masking.length(spec));
        }
        if (cardType != null) {
            joiner.add("cardType=" + io.github.icommapi.bizgo.internal.Masking.length(cardType));
        }
        if (body != null) {
            joiner.add("body=" + body);
        }
        if (brandKey != null) {
            joiner.add("brandKey=" + io.github.icommapi.bizgo.internal.Masking.length(brandKey));
        }
        if (formatId != null) {
            joiner.add("formatId=" + formatId);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplate}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String status;
        private String approvalResult;
        private String approvalReason;
        private String registerDate;
        private String approvalDate;
        private String updateDate;
        private String registerId;
        private String updateId;
        private String productCode;
        private String spec;
        private String cardType;
        private RcsTemplateDetailBody body;
        private String brandKey;
        private String formatId;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsTemplate#builder()}. */
        public Builder() {
        }

        /**
         * 템플릿 상태입니다.
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 승인 결과입니다.
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
         * 승인일시입니다.
         *
         * @param approvalDate the value (null clears it)
         * @return this builder
         */
        public Builder approvalDate(String approvalDate) {
            this.approvalDate = approvalDate;
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
         * 등록 계정 ID입니다.
         *
         * @param registerId the value (null clears it)
         * @return this builder
         */
        public Builder registerId(String registerId) {
            this.registerId = registerId;
            return this;
        }

        /**
         * 수정 계정 ID입니다.
         *
         * @param updateId the value (null clears it)
         * @return this builder
         */
        public Builder updateId(String updateId) {
            this.updateId = updateId;
            return this;
        }

        /**
         * 상품 코드입니다. 문서 예시 값은 <code>lms</code>입니다.
         *
         * @param productCode the value (null clears it)
         * @return this builder
         */
        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        /**
         * 템플릿 스펙입니다. 문서 예시 값은 <code>openrichcard</code>입니다.
         *
         * @param spec the value (null clears it)
         * @return this builder
         */
        public Builder spec(String spec) {
            this.spec = spec;
            return this;
        }

        /**
         * 카드 종류입니다. 문서 예시 값은 <code>descriptionNew</code>입니다.
         *
         * @param cardType the value (null clears it)
         * @return this builder
         */
        public Builder cardType(String cardType) {
            this.cardType = cardType;
            return this;
        }

        /**
         * {@code body}.
         *
         * @param body the value (null clears it)
         * @return this builder
         */
        public Builder body(RcsTemplateDetailBody body) {
            this.body = body;
            return this;
        }

        /**
         * 브랜드 키입니다.
         *
         * @param brandKey the value (null clears it)
         * @return this builder
         */
        public Builder brandKey(String brandKey) {
            this.brandKey = brandKey;
            return this;
        }

        /**
         * 템플릿 양식 ID입니다. 발송 시에는 이 값을 <code>formatId</code> 필드에 넣습니다(영문 문서 기준).
         *
         * <p><b>확인 필요:</b> 영문 문서는 messagebaseId와 formatId 모두 발송 시 formatId 필드에 넣는다고 설명해 어느 값을 써야 하는지 불명확합니다.
         *
         * @param formatId the value (null clears it)
         * @return this builder
         */
        public Builder formatId(String formatId) {
            this.formatId = formatId;
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
         * @return a new immutable {@code RcsTemplate}
         */
        public RcsTemplate build() {
            return new RcsTemplate(this);
        }
    }
}
