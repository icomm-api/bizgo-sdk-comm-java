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
 * 조회·등록·수정 응답의 알림톡 템플릿 정보입니다. 응답에는 요청 필드 외에 검수 상태, 차단·휴면 여부, 심사 의견 등이 더해집니다. 응답에 따라 일부 필드만 올 수 있습니다.
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
@JsonPropertyOrder({"senderKey", "senderKeyType", "templateName", "templateCode", "msgType", "templateMessageType", "templateEmphasizeType", "text", "title", "subTitle", "header", "imgName", "imgUrl", "link", "attachment", "supplement", "categoryCode", "securityFlag", "adultFlag", "previewMessage", "extra", "inspectionStatus", "status", "block", "dormant", "createdAt", "modifiedAt", "comments"})
public final class AlimtalkTemplate {

    private final String senderKey;
    private final String senderKeyType;
    private final String templateName;
    private final String templateCode;
    private final String msgType;
    private final String templateMessageType;
    private final String templateEmphasizeType;
    private final String text;
    private final String title;
    private final String subTitle;
    private final String header;
    private final String imgName;
    private final String imgUrl;
    private final AlimtalkLink link;
    private final AlimtalkAttachment attachment;
    private final AlimtalkSupplement supplement;
    private final String categoryCode;
    private final Boolean securityFlag;
    private final Boolean adultFlag;
    private final String previewMessage;
    private final String extra;
    private final String inspectionStatus;
    private final String status;
    private final String block;
    private final String dormant;
    private final String createdAt;
    private final String modifiedAt;
    private final List<AlimtalkTemplateComment> comments;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private AlimtalkTemplate(
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("senderKeyType") String senderKeyType,
            @JsonProperty("templateName") String templateName,
            @JsonProperty("templateCode") String templateCode,
            @JsonProperty("msgType") String msgType,
            @JsonProperty("templateMessageType") String templateMessageType,
            @JsonProperty("templateEmphasizeType") String templateEmphasizeType,
            @JsonProperty("text") String text,
            @JsonProperty("title") String title,
            @JsonProperty("subTitle") String subTitle,
            @JsonProperty("header") String header,
            @JsonProperty("imgName") String imgName,
            @JsonProperty("imgUrl") String imgUrl,
            @JsonProperty("link") AlimtalkLink link,
            @JsonProperty("attachment") AlimtalkAttachment attachment,
            @JsonProperty("supplement") AlimtalkSupplement supplement,
            @JsonProperty("categoryCode") String categoryCode,
            @JsonProperty("securityFlag") Boolean securityFlag,
            @JsonProperty("adultFlag") Boolean adultFlag,
            @JsonProperty("previewMessage") String previewMessage,
            @JsonProperty("extra") String extra,
            @JsonProperty("inspectionStatus") String inspectionStatus,
            @JsonProperty("status") String status,
            @JsonProperty("block") String block,
            @JsonProperty("dormant") String dormant,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("modifiedAt") String modifiedAt,
            @JsonProperty("comments") List<AlimtalkTemplateComment> comments) {
        this.senderKey = senderKey;
        this.senderKeyType = senderKeyType;
        this.templateName = templateName;
        this.templateCode = templateCode;
        this.msgType = msgType;
        this.templateMessageType = templateMessageType;
        this.templateEmphasizeType = templateEmphasizeType;
        this.text = text;
        this.title = title;
        this.subTitle = subTitle;
        this.header = header;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.link = link;
        this.attachment = attachment;
        this.supplement = supplement;
        this.categoryCode = categoryCode;
        this.securityFlag = securityFlag;
        this.adultFlag = adultFlag;
        this.previewMessage = previewMessage;
        this.extra = extra;
        this.inspectionStatus = inspectionStatus;
        this.status = status;
        this.block = block;
        this.dormant = dormant;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.comments = comments == null ? null : Collections.unmodifiableList(new ArrayList<>(comments));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private AlimtalkTemplate(Builder builder) {
        this(builder.senderKey, builder.senderKeyType, builder.templateName, builder.templateCode, builder.msgType, builder.templateMessageType, builder.templateEmphasizeType, builder.text, builder.title, builder.subTitle, builder.header, builder.imgName, builder.imgUrl, builder.link, builder.attachment, builder.supplement, builder.categoryCode, builder.securityFlag, builder.adultFlag, builder.previewMessage, builder.extra, builder.inspectionStatus, builder.status, builder.block, builder.dormant, builder.createdAt, builder.modifiedAt, builder.comments);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.senderKeyType = this.senderKeyType;
        builder.templateName = this.templateName;
        builder.templateCode = this.templateCode;
        builder.msgType = this.msgType;
        builder.templateMessageType = this.templateMessageType;
        builder.templateEmphasizeType = this.templateEmphasizeType;
        builder.text = this.text;
        builder.title = this.title;
        builder.subTitle = this.subTitle;
        builder.header = this.header;
        builder.imgName = this.imgName;
        builder.imgUrl = this.imgUrl;
        builder.link = this.link;
        builder.attachment = this.attachment;
        builder.supplement = this.supplement;
        builder.categoryCode = this.categoryCode;
        builder.securityFlag = this.securityFlag;
        builder.adultFlag = this.adultFlag;
        builder.previewMessage = this.previewMessage;
        builder.extra = this.extra;
        builder.inspectionStatus = this.inspectionStatus;
        builder.status = this.status;
        builder.block = this.block;
        builder.dormant = this.dormant;
        builder.createdAt = this.createdAt;
        builder.modifiedAt = this.modifiedAt;
        builder.comments = this.comments;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 발신프로필 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 발신프로필 키 타입입니다. 기본값은 <code>S</code>입니다.
     * <ul>
     * <li><code>G</code>: 그룹</li>
     * <li><code>S</code>: 발신프로필</li>
     * </ul>
     *
     * <p>허용 값 <code>G</code>, <code>S</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKeyType")
    public String getSenderKeyType() {
        return senderKeyType;
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
     * 템플릿 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 이 템플릿으로 발송할 때 쓰는 카카오 비즈메시지 타입입니다(<code>AT</code> 텍스트형, <code>AI</code> 이미지형). 전문 발송의 <code>AlimtalkMessage.msgType</code>에 그대로 넣습니다. 필드 표에는 없지만 응답에 옵니다(2026-09-28 sandbox 확인).
     *
     * <p>알려진 값 <code>AT</code>, <code>AI</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }

    /**
     * 템플릿 메시지 타입입니다. 문서 예시 값은 <code>BA</code>입니다.
     *
     * <p>알려진 값 <code>BA</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateMessageType")
    public String getTemplateMessageType() {
        return templateMessageType;
    }

    /**
     * 템플릿 강조 타입입니다. 문서 예시 값은 <code>NONE</code>입니다.
     *
     * <p>알려진 값 <code>NONE</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateEmphasizeType")
    public String getTemplateEmphasizeType() {
        return templateEmphasizeType;
    }

    /**
     * 템플릿 본문입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 강조표기형 템플릿 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 강조 표기 보조 문구입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("subTitle")
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 메시지 상단에 표시할 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * 이미지 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgName")
    public String getImgName() {
        return imgName;
    }

    /**
     * 이미지 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgUrl")
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * {@code link}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("link")
    public AlimtalkLink getLink() {
        return link;
    }

    /**
     * {@code attachment}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public AlimtalkAttachment getAttachment() {
        return attachment;
    }

    /**
     * {@code supplement}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("supplement")
    public AlimtalkSupplement getSupplement() {
        return supplement;
    }

    /**
     * 템플릿 카테고리 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categoryCode")
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 보안 템플릿 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("securityFlag")
    public Boolean getSecurityFlag() {
        return securityFlag;
    }

    /**
     * 연령 인증 설정 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("adultFlag")
    public Boolean getAdultFlag() {
        return adultFlag;
    }

    /**
     * 템플릿 미리보기 메시지입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("previewMessage")
    public String getPreviewMessage() {
        return previewMessage;
    }

    /**
     * 부가 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("extra")
    public String getExtra() {
        return extra;
    }

    /**
     * 검수 상태입니다.
     * <ul>
     * <li><code>REG</code>: 등록</li>
     * <li><code>REQ</code>: 검수 요청</li>
     * <li><code>APR</code>: 승인</li>
     * <li><code>REJ</code>: 반려</li>
     * </ul>
     *
     * <p>허용 값 <code>REG</code>, <code>REQ</code>, <code>APR</code>, <code>REJ</code>
     *
     * <p><b>확인 필요:</b> 검수 상태 값 목록은 Copy Markdown(Part B)에만 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("inspectionStatus")
    public String getInspectionStatus() {
        return inspectionStatus;
    }

    /**
     * 템플릿 상태입니다. 목록 조회·최근 변경 템플릿 조회 응답에 있습니다.
     *
     * <p><b>확인 필요:</b> 값 목록이 문서에 없고, 목록 조회 예시는 <code>A</code>, 최근 변경 조회 예시는 <code>APR</code>로 서로 다릅니다. 검수 요청 문서는 '템플릿 상태가 대기'일 때 요청 가능하다고 하나 대기에 해당하는 코드가 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 템플릿 차단 여부입니다. <code>true</code> 또는 <code>false</code> 문자열입니다.
     *
     * <p>알려진 값 <code>true</code>, <code>false</code>
     *
     * <p><b>확인 필요:</b> 문서상 타입이 Boolean이 아닌 String입니다(발신프로필의 block은 Boolean).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("block")
    public String getBlock() {
        return block;
    }

    /**
     * 템플릿 휴면 여부입니다. <code>true</code> 또는 <code>false</code> 문자열입니다.
     *
     * <p>알려진 값 <code>true</code>, <code>false</code>
     *
     * <p><b>확인 필요:</b> 문서상 타입이 Boolean이 아닌 String입니다(발신프로필의 dormant는 Boolean).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("dormant")
    public String getDormant() {
        return dormant;
    }

    /**
     * 생성일입니다.
     *
     * <p><b>확인 필요:</b> 날짜 형식이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 수정일입니다.
     *
     * <p><b>확인 필요:</b> 날짜 형식이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("modifiedAt")
    public String getModifiedAt() {
        return modifiedAt;
    }

    /**
     * 템플릿 심사 의견 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("comments")
    public List<AlimtalkTemplateComment> getComments() {
        return comments;
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
        if (!(o instanceof AlimtalkTemplate)) {
            return false;
        }
        AlimtalkTemplate other = (AlimtalkTemplate) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(senderKeyType, other.senderKeyType)
                && Objects.equals(templateName, other.templateName)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(templateMessageType, other.templateMessageType)
                && Objects.equals(templateEmphasizeType, other.templateEmphasizeType)
                && Objects.equals(text, other.text)
                && Objects.equals(title, other.title)
                && Objects.equals(subTitle, other.subTitle)
                && Objects.equals(header, other.header)
                && Objects.equals(imgName, other.imgName)
                && Objects.equals(imgUrl, other.imgUrl)
                && Objects.equals(link, other.link)
                && Objects.equals(attachment, other.attachment)
                && Objects.equals(supplement, other.supplement)
                && Objects.equals(categoryCode, other.categoryCode)
                && Objects.equals(securityFlag, other.securityFlag)
                && Objects.equals(adultFlag, other.adultFlag)
                && Objects.equals(previewMessage, other.previewMessage)
                && Objects.equals(extra, other.extra)
                && Objects.equals(inspectionStatus, other.inspectionStatus)
                && Objects.equals(status, other.status)
                && Objects.equals(block, other.block)
                && Objects.equals(dormant, other.dormant)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(modifiedAt, other.modifiedAt)
                && Objects.equals(comments, other.comments)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, senderKeyType, templateName, templateCode, msgType, templateMessageType, templateEmphasizeType, text, title, subTitle, header, imgName, imgUrl, link, attachment, supplement, categoryCode, securityFlag, adultFlag, previewMessage, extra, inspectionStatus, status, block, dormant, createdAt, modifiedAt, comments, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplate{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (senderKeyType != null) {
            joiner.add("senderKeyType=" + io.github.icommapi.bizgo.internal.Masking.length(senderKeyType));
        }
        if (templateName != null) {
            joiner.add("templateName=" + io.github.icommapi.bizgo.internal.Masking.length(templateName));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (templateMessageType != null) {
            joiner.add("templateMessageType=" + io.github.icommapi.bizgo.internal.Masking.length(templateMessageType));
        }
        if (templateEmphasizeType != null) {
            joiner.add("templateEmphasizeType=" + io.github.icommapi.bizgo.internal.Masking.length(templateEmphasizeType));
        }
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
        }
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (subTitle != null) {
            joiner.add("subTitle=" + io.github.icommapi.bizgo.internal.Masking.length(subTitle));
        }
        if (header != null) {
            joiner.add("header=" + io.github.icommapi.bizgo.internal.Masking.length(header));
        }
        if (imgName != null) {
            joiner.add("imgName=" + io.github.icommapi.bizgo.internal.Masking.length(imgName));
        }
        if (imgUrl != null) {
            joiner.add("imgUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imgUrl));
        }
        if (link != null) {
            joiner.add("link=" + link);
        }
        if (attachment != null) {
            joiner.add("attachment=" + attachment);
        }
        if (supplement != null) {
            joiner.add("supplement=" + supplement);
        }
        if (categoryCode != null) {
            joiner.add("categoryCode=" + io.github.icommapi.bizgo.internal.Masking.length(categoryCode));
        }
        if (securityFlag != null) {
            joiner.add("securityFlag=***");
        }
        if (adultFlag != null) {
            joiner.add("adultFlag=***");
        }
        if (previewMessage != null) {
            joiner.add("previewMessage=" + io.github.icommapi.bizgo.internal.Masking.length(previewMessage));
        }
        if (extra != null) {
            joiner.add("extra=" + io.github.icommapi.bizgo.internal.Masking.length(extra));
        }
        if (inspectionStatus != null) {
            joiner.add("inspectionStatus=" + io.github.icommapi.bizgo.internal.Masking.length(inspectionStatus));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (block != null) {
            joiner.add("block=" + io.github.icommapi.bizgo.internal.Masking.length(block));
        }
        if (dormant != null) {
            joiner.add("dormant=" + io.github.icommapi.bizgo.internal.Masking.length(dormant));
        }
        if (createdAt != null) {
            joiner.add("createdAt=" + io.github.icommapi.bizgo.internal.Masking.length(createdAt));
        }
        if (modifiedAt != null) {
            joiner.add("modifiedAt=" + io.github.icommapi.bizgo.internal.Masking.length(modifiedAt));
        }
        if (comments != null) {
            joiner.add("comments=" + comments);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplate}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String senderKeyType;
        private String templateName;
        private String templateCode;
        private String msgType;
        private String templateMessageType;
        private String templateEmphasizeType;
        private String text;
        private String title;
        private String subTitle;
        private String header;
        private String imgName;
        private String imgUrl;
        private AlimtalkLink link;
        private AlimtalkAttachment attachment;
        private AlimtalkSupplement supplement;
        private String categoryCode;
        private Boolean securityFlag;
        private Boolean adultFlag;
        private String previewMessage;
        private String extra;
        private String inspectionStatus;
        private String status;
        private String block;
        private String dormant;
        private String createdAt;
        private String modifiedAt;
        private List<AlimtalkTemplateComment> comments;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link AlimtalkTemplate#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다.
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 발신프로필 키 타입입니다. 기본값은 <code>S</code>입니다.
         * <ul>
         * <li><code>G</code>: 그룹</li>
         * <li><code>S</code>: 발신프로필</li>
         * </ul>
         *
         * <p>허용 값 <code>G</code>, <code>S</code>
         *
         * @param senderKeyType the value (null clears it)
         * @return this builder
         */
        public Builder senderKeyType(String senderKeyType) {
            this.senderKeyType = senderKeyType;
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
         * 템플릿 코드입니다.
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * 이 템플릿으로 발송할 때 쓰는 카카오 비즈메시지 타입입니다(<code>AT</code> 텍스트형, <code>AI</code> 이미지형). 전문 발송의 <code>AlimtalkMessage.msgType</code>에 그대로 넣습니다. 필드 표에는 없지만 응답에 옵니다(2026-09-28 sandbox 확인).
         *
         * <p>알려진 값 <code>AT</code>, <code>AI</code>
         *
         * @param msgType the value (null clears it)
         * @return this builder
         */
        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        /**
         * 템플릿 메시지 타입입니다. 문서 예시 값은 <code>BA</code>입니다.
         *
         * <p>알려진 값 <code>BA</code>
         *
         * @param templateMessageType the value (null clears it)
         * @return this builder
         */
        public Builder templateMessageType(String templateMessageType) {
            this.templateMessageType = templateMessageType;
            return this;
        }

        /**
         * 템플릿 강조 타입입니다. 문서 예시 값은 <code>NONE</code>입니다.
         *
         * <p>알려진 값 <code>NONE</code>
         *
         * @param templateEmphasizeType the value (null clears it)
         * @return this builder
         */
        public Builder templateEmphasizeType(String templateEmphasizeType) {
            this.templateEmphasizeType = templateEmphasizeType;
            return this;
        }

        /**
         * 템플릿 본문입니다.
         *
         * @param text the value (null clears it)
         * @return this builder
         */
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * 강조표기형 템플릿 제목입니다.
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 강조 표기 보조 문구입니다.
         *
         * @param subTitle the value (null clears it)
         * @return this builder
         */
        public Builder subTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        /**
         * 메시지 상단에 표시할 제목입니다.
         *
         * @param header the value (null clears it)
         * @return this builder
         */
        public Builder header(String header) {
            this.header = header;
            return this;
        }

        /**
         * 이미지 이름입니다.
         *
         * @param imgName the value (null clears it)
         * @return this builder
         */
        public Builder imgName(String imgName) {
            this.imgName = imgName;
            return this;
        }

        /**
         * 이미지 URL입니다.
         *
         * @param imgUrl the value (null clears it)
         * @return this builder
         */
        public Builder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        /**
         * {@code link}.
         *
         * @param link the value (null clears it)
         * @return this builder
         */
        public Builder link(AlimtalkLink link) {
            this.link = link;
            return this;
        }

        /**
         * {@code attachment}.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        public Builder attachment(AlimtalkAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * {@code supplement}.
         *
         * @param supplement the value (null clears it)
         * @return this builder
         */
        public Builder supplement(AlimtalkSupplement supplement) {
            this.supplement = supplement;
            return this;
        }

        /**
         * 템플릿 카테고리 코드입니다.
         *
         * @param categoryCode the value (null clears it)
         * @return this builder
         */
        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        /**
         * 보안 템플릿 여부입니다.
         *
         * @param securityFlag the value (null clears it)
         * @return this builder
         */
        public Builder securityFlag(Boolean securityFlag) {
            this.securityFlag = securityFlag;
            return this;
        }

        /**
         * 연령 인증 설정 여부입니다.
         *
         * @param adultFlag the value (null clears it)
         * @return this builder
         */
        public Builder adultFlag(Boolean adultFlag) {
            this.adultFlag = adultFlag;
            return this;
        }

        /**
         * 템플릿 미리보기 메시지입니다.
         *
         * @param previewMessage the value (null clears it)
         * @return this builder
         */
        public Builder previewMessage(String previewMessage) {
            this.previewMessage = previewMessage;
            return this;
        }

        /**
         * 부가 정보입니다.
         *
         * @param extra the value (null clears it)
         * @return this builder
         */
        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        /**
         * 검수 상태입니다.
         * <ul>
         * <li><code>REG</code>: 등록</li>
         * <li><code>REQ</code>: 검수 요청</li>
         * <li><code>APR</code>: 승인</li>
         * <li><code>REJ</code>: 반려</li>
         * </ul>
         *
         * <p>허용 값 <code>REG</code>, <code>REQ</code>, <code>APR</code>, <code>REJ</code>
         *
         * <p><b>확인 필요:</b> 검수 상태 값 목록은 Copy Markdown(Part B)에만 있습니다.
         *
         * @param inspectionStatus the value (null clears it)
         * @return this builder
         */
        public Builder inspectionStatus(String inspectionStatus) {
            this.inspectionStatus = inspectionStatus;
            return this;
        }

        /**
         * 템플릿 상태입니다. 목록 조회·최근 변경 템플릿 조회 응답에 있습니다.
         *
         * <p><b>확인 필요:</b> 값 목록이 문서에 없고, 목록 조회 예시는 <code>A</code>, 최근 변경 조회 예시는 <code>APR</code>로 서로 다릅니다. 검수 요청 문서는 '템플릿 상태가 대기'일 때 요청 가능하다고 하나 대기에 해당하는 코드가 없습니다.
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 템플릿 차단 여부입니다. <code>true</code> 또는 <code>false</code> 문자열입니다.
         *
         * <p>알려진 값 <code>true</code>, <code>false</code>
         *
         * <p><b>확인 필요:</b> 문서상 타입이 Boolean이 아닌 String입니다(발신프로필의 block은 Boolean).
         *
         * @param block the value (null clears it)
         * @return this builder
         */
        public Builder block(String block) {
            this.block = block;
            return this;
        }

        /**
         * 템플릿 휴면 여부입니다. <code>true</code> 또는 <code>false</code> 문자열입니다.
         *
         * <p>알려진 값 <code>true</code>, <code>false</code>
         *
         * <p><b>확인 필요:</b> 문서상 타입이 Boolean이 아닌 String입니다(발신프로필의 dormant는 Boolean).
         *
         * @param dormant the value (null clears it)
         * @return this builder
         */
        public Builder dormant(String dormant) {
            this.dormant = dormant;
            return this;
        }

        /**
         * 생성일입니다.
         *
         * <p><b>확인 필요:</b> 날짜 형식이 문서에 없습니다.
         *
         * @param createdAt the value (null clears it)
         * @return this builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * 수정일입니다.
         *
         * <p><b>확인 필요:</b> 날짜 형식이 문서에 없습니다.
         *
         * @param modifiedAt the value (null clears it)
         * @return this builder
         */
        public Builder modifiedAt(String modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        /**
         * 템플릿 심사 의견 목록입니다.
         *
         * @param comments the value (null clears it)
         * @return this builder
         */
        public Builder comments(List<AlimtalkTemplateComment> comments) {
            this.comments = comments;
            return this;
        }

        /**
         * Varargs form of {@link #comments(List)}.
         *
         * @param comments values
         * @return this builder
         */
        public Builder comments(AlimtalkTemplateComment... comments) {
            this.comments = comments == null ? null : Arrays.asList(comments);
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
         * @return a new immutable {@code AlimtalkTemplate}
         */
        public AlimtalkTemplate build() {
            return new AlimtalkTemplate(this);
        }
    }
}
