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
 * 공통 포맷 또는 템플릿 양식의 상세 정보입니다. 공통 포맷 상세 조회는 모든 필드를, 템플릿 양식 상세 조회는 그중 일부(formatId, templateName, body, buttons, agencyId, brandId, messagebaseformId, policyInfo.maxButtonCount/maxMediaSize, registerDate, updateDate, productCode, spec, cardType)를 문서화합니다.
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
@JsonPropertyOrder({"formatId", "templateName", "body", "buttons", "agencyId", "brandId", "messagebaseformId", "policyInfo", "status", "approvalResult", "registerDate", "approvalDate", "updateDate", "updateId", "productCode", "spec", "cardType"})
public final class RcsMessagebaseFormDetail {

    private final String formatId;
    private final String templateName;
    private final List<RcsTemplateBodyParam> body;
    private final RcsTemplateButton buttons;
    private final String agencyId;
    private final String brandId;
    private final String messagebaseformId;
    private final RcsMessagebasePolicyInfo policyInfo;
    private final String status;
    private final String approvalResult;
    private final String registerDate;
    private final String approvalDate;
    private final String updateDate;
    private final String updateId;
    private final String productCode;
    private final String spec;
    private final String cardType;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsMessagebaseFormDetail(
            @JsonProperty("formatId") String formatId,
            @JsonProperty("templateName") String templateName,
            @JsonProperty("body") List<RcsTemplateBodyParam> body,
            @JsonProperty("buttons") RcsTemplateButton buttons,
            @JsonProperty("agencyId") String agencyId,
            @JsonProperty("brandId") String brandId,
            @JsonProperty("messagebaseformId") String messagebaseformId,
            @JsonProperty("policyInfo") RcsMessagebasePolicyInfo policyInfo,
            @JsonProperty("status") String status,
            @JsonProperty("approvalResult") String approvalResult,
            @JsonProperty("registerDate") String registerDate,
            @JsonProperty("approvalDate") String approvalDate,
            @JsonProperty("updateDate") String updateDate,
            @JsonProperty("updateId") String updateId,
            @JsonProperty("productCode") String productCode,
            @JsonProperty("spec") String spec,
            @JsonProperty("cardType") String cardType) {
        this.formatId = formatId;
        this.templateName = templateName;
        this.body = body == null ? null : Collections.unmodifiableList(new ArrayList<>(body));
        this.buttons = buttons;
        this.agencyId = agencyId;
        this.brandId = brandId;
        this.messagebaseformId = messagebaseformId;
        this.policyInfo = policyInfo;
        this.status = status;
        this.approvalResult = approvalResult;
        this.registerDate = registerDate;
        this.approvalDate = approvalDate;
        this.updateDate = updateDate;
        this.updateId = updateId;
        this.productCode = productCode;
        this.spec = spec;
        this.cardType = cardType;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsMessagebaseFormDetail(Builder builder) {
        this(builder.formatId, builder.templateName, builder.body, builder.buttons, builder.agencyId, builder.brandId, builder.messagebaseformId, builder.policyInfo, builder.status, builder.approvalResult, builder.registerDate, builder.approvalDate, builder.updateDate, builder.updateId, builder.productCode, builder.spec, builder.cardType);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.formatId = this.formatId;
        builder.templateName = this.templateName;
        builder.body = this.body;
        builder.buttons = this.buttons;
        builder.agencyId = this.agencyId;
        builder.brandId = this.brandId;
        builder.messagebaseformId = this.messagebaseformId;
        builder.policyInfo = this.policyInfo;
        builder.status = this.status;
        builder.approvalResult = this.approvalResult;
        builder.registerDate = this.registerDate;
        builder.approvalDate = this.approvalDate;
        builder.updateDate = this.updateDate;
        builder.updateId = this.updateId;
        builder.productCode = this.productCode;
        builder.spec = this.spec;
        builder.cardType = this.cardType;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
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
     * body 정의입니다.
     *
     * <p><b>확인 필요:</b> 템플릿 양식 상세 조회 문서에는 body 항목의 하위 필드가 없습니다(공통 포맷 상세와 같은 구조로 가정).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("body")
    public List<RcsTemplateBodyParam> getBody() {
        return body;
    }

    /**
     * {@code buttons}.
     *
     * <p><b>확인 필요:</b> 표에는 Object(suggestions 배열 포함)로 표기되어 있으나 템플릿 양식 상세 응답 예시는 배열(<code>[]</code>)이고, 템플릿 등록 요청의 buttons는 Object Array입니다. suggestions 항목의 하위 필드도 조회 응답에는 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttons")
    public RcsTemplateButton getButtons() {
        return buttons;
    }

    /**
     * 대행사 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("agencyId")
    public String getAgencyId() {
        return agencyId;
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
     * 템플릿의 원형인 템플릿 양식 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messagebaseformId")
    public String getMessagebaseformId() {
        return messagebaseformId;
    }

    /**
     * {@code policyInfo}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("policyInfo")
    public RcsMessagebasePolicyInfo getPolicyInfo() {
        return policyInfo;
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
     * 템플릿 수정 계정 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("updateId")
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 메시지 상품 종류입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    /**
     * 레이아웃 구조입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("spec")
    public String getSpec() {
        return spec;
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
        if (!(o instanceof RcsMessagebaseFormDetail)) {
            return false;
        }
        RcsMessagebaseFormDetail other = (RcsMessagebaseFormDetail) o;
        return Objects.equals(formatId, other.formatId)
                && Objects.equals(templateName, other.templateName)
                && Objects.equals(body, other.body)
                && Objects.equals(buttons, other.buttons)
                && Objects.equals(agencyId, other.agencyId)
                && Objects.equals(brandId, other.brandId)
                && Objects.equals(messagebaseformId, other.messagebaseformId)
                && Objects.equals(policyInfo, other.policyInfo)
                && Objects.equals(status, other.status)
                && Objects.equals(approvalResult, other.approvalResult)
                && Objects.equals(registerDate, other.registerDate)
                && Objects.equals(approvalDate, other.approvalDate)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(updateId, other.updateId)
                && Objects.equals(productCode, other.productCode)
                && Objects.equals(spec, other.spec)
                && Objects.equals(cardType, other.cardType)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formatId, templateName, body, buttons, agencyId, brandId, messagebaseformId, policyInfo, status, approvalResult, registerDate, approvalDate, updateDate, updateId, productCode, spec, cardType, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsMessagebaseFormDetail{", "}");
        if (formatId != null) {
            joiner.add("formatId=" + formatId);
        }
        if (templateName != null) {
            joiner.add("templateName=" + io.github.icommapi.bizgo.internal.Masking.length(templateName));
        }
        if (body != null) {
            joiner.add("body=" + body);
        }
        if (buttons != null) {
            joiner.add("buttons=" + buttons);
        }
        if (agencyId != null) {
            joiner.add("agencyId=" + io.github.icommapi.bizgo.internal.Masking.length(agencyId));
        }
        if (brandId != null) {
            joiner.add("brandId=" + io.github.icommapi.bizgo.internal.Masking.length(brandId));
        }
        if (messagebaseformId != null) {
            joiner.add("messagebaseformId=" + io.github.icommapi.bizgo.internal.Masking.length(messagebaseformId));
        }
        if (policyInfo != null) {
            joiner.add("policyInfo=" + policyInfo);
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (approvalResult != null) {
            joiner.add("approvalResult=" + io.github.icommapi.bizgo.internal.Masking.length(approvalResult));
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
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsMessagebaseFormDetail}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String formatId;
        private String templateName;
        private List<RcsTemplateBodyParam> body;
        private RcsTemplateButton buttons;
        private String agencyId;
        private String brandId;
        private String messagebaseformId;
        private RcsMessagebasePolicyInfo policyInfo;
        private String status;
        private String approvalResult;
        private String registerDate;
        private String approvalDate;
        private String updateDate;
        private String updateId;
        private String productCode;
        private String spec;
        private String cardType;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsMessagebaseFormDetail#builder()}. */
        public Builder() {
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
         * body 정의입니다.
         *
         * <p><b>확인 필요:</b> 템플릿 양식 상세 조회 문서에는 body 항목의 하위 필드가 없습니다(공통 포맷 상세와 같은 구조로 가정).
         *
         * @param body the value (null clears it)
         * @return this builder
         */
        public Builder body(List<RcsTemplateBodyParam> body) {
            this.body = body;
            return this;
        }

        /**
         * Varargs form of {@link #body(List)}.
         *
         * @param body values
         * @return this builder
         */
        public Builder body(RcsTemplateBodyParam... body) {
            this.body = body == null ? null : Arrays.asList(body);
            return this;
        }

        /**
         * {@code buttons}.
         *
         * <p><b>확인 필요:</b> 표에는 Object(suggestions 배열 포함)로 표기되어 있으나 템플릿 양식 상세 응답 예시는 배열(<code>[]</code>)이고, 템플릿 등록 요청의 buttons는 Object Array입니다. suggestions 항목의 하위 필드도 조회 응답에는 문서화되어 있지 않습니다.
         *
         * @param buttons the value (null clears it)
         * @return this builder
         */
        public Builder buttons(RcsTemplateButton buttons) {
            this.buttons = buttons;
            return this;
        }

        /**
         * 대행사 ID입니다.
         *
         * @param agencyId the value (null clears it)
         * @return this builder
         */
        public Builder agencyId(String agencyId) {
            this.agencyId = agencyId;
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
         * {@code policyInfo}.
         *
         * @param policyInfo the value (null clears it)
         * @return this builder
         */
        public Builder policyInfo(RcsMessagebasePolicyInfo policyInfo) {
            this.policyInfo = policyInfo;
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
         * 메시지 상품 종류입니다.
         *
         * @param productCode the value (null clears it)
         * @return this builder
         */
        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        /**
         * 레이아웃 구조입니다.
         *
         * @param spec the value (null clears it)
         * @return this builder
         */
        public Builder spec(String spec) {
            this.spec = spec;
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
         * @return a new immutable {@code RcsMessagebaseFormDetail}
         */
        public RcsMessagebaseFormDetail build() {
            return new RcsMessagebaseFormDetail(this);
        }
    }
}
