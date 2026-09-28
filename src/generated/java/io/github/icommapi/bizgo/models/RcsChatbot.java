// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * RCS 대화방(챗봇) 정보입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 일시 필드(approvalDate, registerDate, updateDate)의 형식이 문서화되어 있지 않습니다(예시는 <code>yyyy-MM-dd HH:mm:ss</code>). service·display·inputField·rcsReply·searchWeight·status·approvalResult 값 목록도 없습니다.
 *
 * <p>Request model: immutable, created with {@link #builder()}, validated in {@link Builder#build()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonDeserialize(builder = RcsChatbot.Builder.class)
@JsonPropertyOrder({"chatbotId", "brandId", "groupId", "mdn", "subNum", "isMainNum", "subTitle", "subDescr", "service", "display", "inputField", "botAgencyId", "saftyStatusYn", "psMenuUse", "persistentMenu", "rcsReply", "webhook", "searchWeight", "botTcPage", "mediaUrl", "status", "approvalResult", "approvalReason", "approvalDate", "registerDate", "registerId", "updateDate", "updateId"})
public final class RcsChatbot {
    private static final List<String> IS_MAIN_NUM_VALUES = List.of("Y", "N");
    private static final List<String> PS_MENU_USE_VALUES = List.of("Y", "N");

    private final String chatbotId;
    private final String brandId;
    private final String groupId;
    private final String mdn;
    private final String subNum;
    private final String isMainNum;
    private final String subTitle;
    private final String subDescr;
    private final String service;
    private final String display;
    private final Integer inputField;
    private final String botAgencyId;
    private final String saftyStatusYn;
    private final String psMenuUse;
    private final Map<String, Object> persistentMenu;
    private final String rcsReply;
    private final String webhook;
    private final String searchWeight;
    private final String botTcPage;
    private final Map<String, Object> mediaUrl;
    private final String status;
    private final String approvalResult;
    private final String approvalReason;
    private final String approvalDate;
    private final String registerDate;
    private final String registerId;
    private final String updateDate;
    private final String updateId;

    private RcsChatbot(Builder builder) {
        this.chatbotId = builder.chatbotId;
        this.brandId = builder.brandId;
        this.groupId = builder.groupId;
        this.mdn = builder.mdn;
        this.subNum = builder.subNum;
        this.isMainNum = builder.isMainNum;
        this.subTitle = builder.subTitle;
        this.subDescr = builder.subDescr;
        this.service = builder.service;
        this.display = builder.display;
        this.inputField = builder.inputField;
        this.botAgencyId = builder.botAgencyId;
        this.saftyStatusYn = builder.saftyStatusYn;
        this.psMenuUse = builder.psMenuUse;
        this.persistentMenu = builder.persistentMenu == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.persistentMenu));
        this.rcsReply = builder.rcsReply;
        this.webhook = builder.webhook;
        this.searchWeight = builder.searchWeight;
        this.botTcPage = builder.botTcPage;
        this.mediaUrl = builder.mediaUrl == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.mediaUrl));
        this.status = builder.status;
        this.approvalResult = builder.approvalResult;
        this.approvalReason = builder.approvalReason;
        this.approvalDate = builder.approvalDate;
        this.registerDate = builder.registerDate;
        this.registerId = builder.registerId;
        this.updateDate = builder.updateDate;
        this.updateId = builder.updateId;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.chatbotId = this.chatbotId;
        builder.brandId = this.brandId;
        builder.groupId = this.groupId;
        builder.mdn = this.mdn;
        builder.subNum = this.subNum;
        builder.isMainNum = this.isMainNum;
        builder.subTitle = this.subTitle;
        builder.subDescr = this.subDescr;
        builder.service = this.service;
        builder.display = this.display;
        builder.inputField = this.inputField;
        builder.botAgencyId = this.botAgencyId;
        builder.saftyStatusYn = this.saftyStatusYn;
        builder.psMenuUse = this.psMenuUse;
        builder.persistentMenu = this.persistentMenu;
        builder.rcsReply = this.rcsReply;
        builder.webhook = this.webhook;
        builder.searchWeight = this.searchWeight;
        builder.botTcPage = this.botTcPage;
        builder.mediaUrl = this.mediaUrl;
        builder.status = this.status;
        builder.approvalResult = this.approvalResult;
        builder.approvalReason = this.approvalReason;
        builder.approvalDate = this.approvalDate;
        builder.registerDate = this.registerDate;
        builder.registerId = this.registerId;
        builder.updateDate = this.updateDate;
        builder.updateId = this.updateId;
        return builder;
    }

    /**
     * 대화방 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatbotId")
    public String getChatbotId() {
        return chatbotId;
    }

    /**
     * 대화방이 속한 브랜드 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandId")
    public String getBrandId() {
        return brandId;
    }

    /**
     * 대화방이 속한 그룹 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupId")
    public String getGroupId() {
        return groupId;
    }

    /**
     * 대화방에 연결된 발신번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("mdn")
    public String getMdn() {
        return mdn;
    }

    /**
     * 대화방에 연결된 부가번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("subNum")
    public String getSubNum() {
        return subNum;
    }

    /**
     * 대표번호 여부입니다. <code>Y</code> 대표번호, <code>N</code> 부가번호입니다(영문 문서 기준).
     *
     * <p>허용 값 <code>Y</code>, <code>N</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("isMainNum")
    public String getIsMainNum() {
        return isMainNum;
    }

    /**
     * 대화방 부제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("subTitle")
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 대화방 부가 설명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("subDescr")
    public String getSubDescr() {
        return subDescr;
    }

    /**
     * 대화방의 서비스 구분 값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("service")
    public String getService() {
        return service;
    }

    /**
     * 대화방 노출 설정 값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("display")
    public String getDisplay() {
        return display;
    }

    /**
     * 대화방 입력창 사용 설정 값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("inputField")
    public Integer getInputField() {
        return inputField;
    }

    /**
     * 대화방을 등록한 대행사 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("botAgencyId")
    public String getBotAgencyId() {
        return botAgencyId;
    }

    /**
     * 안심마크 지정 기업 여부입니다. 필드명은 문서 표기(<code>safty</code>)를 따릅니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("saftyStatusYn")
    public String getSaftyStatusYn() {
        return saftyStatusYn;
    }

    /**
     * 고정 메뉴 사용 여부입니다. <code>Y</code> 사용, <code>N</code> 미사용입니다(영문 문서 기준).
     *
     * <p>허용 값 <code>Y</code>, <code>N</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("psMenuUse")
    public String getPsMenuUse() {
        return psMenuUse;
    }

    /**
     * 대화방 고정 메뉴 구성 정보입니다.
     *
     * <p><b>확인 필요:</b> 하위 필드가 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("persistentMenu")
    public Map<String, Object> getPersistentMenu() {
        return persistentMenu;
    }

    /**
     * 대화방 응답 설정 값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("rcsReply")
    public String getRcsReply() {
        return rcsReply;
    }

    /**
     * 대화방 이벤트를 수신할 웹훅 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("webhook")
    public String getWebhook() {
        return webhook;
    }

    /**
     * 대화방 검색 가중치입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("searchWeight")
    public String getSearchWeight() {
        return searchWeight;
    }

    /**
     * 대화방 이용약관 페이지 주소입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("botTcPage")
    public String getBotTcPage() {
        return botTcPage;
    }

    /**
     * 대화방 이미지 파일 ID와 URL 및 사용 유형 정보입니다.
     *
     * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없습니다. 브랜드의 mediaUrl은 Object Array(fileId/url/typeName/fileName)라서 같은 구조의 배열일 가능성이 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("mediaUrl")
    public Map<String, Object> getMediaUrl() {
        return mediaUrl;
    }

    /**
     * 대화방의 상태입니다. 문서 예시 값은 <code>ready</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 대화방 승인 결과입니다. 문서 예시 값은 <code>approved</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("approvalResult")
    public String getApprovalResult() {
        return approvalResult;
    }

    /**
     * 검수 시 반려 사유입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("approvalReason")
    public String getApprovalReason() {
        return approvalReason;
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
     * 등록일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("registerDate")
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * 등록자 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("registerId")
    public String getRegisterId() {
        return registerId;
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
     * 수정자 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("updateId")
    public String getUpdateId() {
        return updateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsChatbot)) {
            return false;
        }
        RcsChatbot other = (RcsChatbot) o;
        return Objects.equals(chatbotId, other.chatbotId)
                && Objects.equals(brandId, other.brandId)
                && Objects.equals(groupId, other.groupId)
                && Objects.equals(mdn, other.mdn)
                && Objects.equals(subNum, other.subNum)
                && Objects.equals(isMainNum, other.isMainNum)
                && Objects.equals(subTitle, other.subTitle)
                && Objects.equals(subDescr, other.subDescr)
                && Objects.equals(service, other.service)
                && Objects.equals(display, other.display)
                && Objects.equals(inputField, other.inputField)
                && Objects.equals(botAgencyId, other.botAgencyId)
                && Objects.equals(saftyStatusYn, other.saftyStatusYn)
                && Objects.equals(psMenuUse, other.psMenuUse)
                && Objects.equals(persistentMenu, other.persistentMenu)
                && Objects.equals(rcsReply, other.rcsReply)
                && Objects.equals(webhook, other.webhook)
                && Objects.equals(searchWeight, other.searchWeight)
                && Objects.equals(botTcPage, other.botTcPage)
                && Objects.equals(mediaUrl, other.mediaUrl)
                && Objects.equals(status, other.status)
                && Objects.equals(approvalResult, other.approvalResult)
                && Objects.equals(approvalReason, other.approvalReason)
                && Objects.equals(approvalDate, other.approvalDate)
                && Objects.equals(registerDate, other.registerDate)
                && Objects.equals(registerId, other.registerId)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(updateId, other.updateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatbotId, brandId, groupId, mdn, subNum, isMainNum, subTitle, subDescr, service, display, inputField, botAgencyId, saftyStatusYn, psMenuUse, persistentMenu, rcsReply, webhook, searchWeight, botTcPage, mediaUrl, status, approvalResult, approvalReason, approvalDate, registerDate, registerId, updateDate, updateId);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsChatbot{", "}");
        if (chatbotId != null) {
            joiner.add("chatbotId=" + io.github.icommapi.bizgo.internal.Masking.length(chatbotId));
        }
        if (brandId != null) {
            joiner.add("brandId=" + io.github.icommapi.bizgo.internal.Masking.length(brandId));
        }
        if (groupId != null) {
            joiner.add("groupId=" + io.github.icommapi.bizgo.internal.Masking.length(groupId));
        }
        if (mdn != null) {
            joiner.add("mdn=" + io.github.icommapi.bizgo.internal.Masking.length(mdn));
        }
        if (subNum != null) {
            joiner.add("subNum=" + io.github.icommapi.bizgo.internal.Masking.length(subNum));
        }
        if (isMainNum != null) {
            joiner.add("isMainNum=" + io.github.icommapi.bizgo.internal.Masking.length(isMainNum));
        }
        if (subTitle != null) {
            joiner.add("subTitle=" + io.github.icommapi.bizgo.internal.Masking.length(subTitle));
        }
        if (subDescr != null) {
            joiner.add("subDescr=" + io.github.icommapi.bizgo.internal.Masking.length(subDescr));
        }
        if (service != null) {
            joiner.add("service=" + io.github.icommapi.bizgo.internal.Masking.length(service));
        }
        if (display != null) {
            joiner.add("display=" + io.github.icommapi.bizgo.internal.Masking.length(display));
        }
        if (inputField != null) {
            joiner.add("inputField=***");
        }
        if (botAgencyId != null) {
            joiner.add("botAgencyId=" + io.github.icommapi.bizgo.internal.Masking.length(botAgencyId));
        }
        if (saftyStatusYn != null) {
            joiner.add("saftyStatusYn=" + io.github.icommapi.bizgo.internal.Masking.length(saftyStatusYn));
        }
        if (psMenuUse != null) {
            joiner.add("psMenuUse=" + io.github.icommapi.bizgo.internal.Masking.length(psMenuUse));
        }
        if (persistentMenu != null) {
            joiner.add("persistentMenu=***");
        }
        if (rcsReply != null) {
            joiner.add("rcsReply=" + io.github.icommapi.bizgo.internal.Masking.length(rcsReply));
        }
        if (webhook != null) {
            joiner.add("webhook=" + io.github.icommapi.bizgo.internal.Masking.length(webhook));
        }
        if (searchWeight != null) {
            joiner.add("searchWeight=" + io.github.icommapi.bizgo.internal.Masking.length(searchWeight));
        }
        if (botTcPage != null) {
            joiner.add("botTcPage=" + io.github.icommapi.bizgo.internal.Masking.length(botTcPage));
        }
        if (mediaUrl != null) {
            joiner.add("mediaUrl=***");
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
        if (approvalDate != null) {
            joiner.add("approvalDate=" + io.github.icommapi.bizgo.internal.Masking.length(approvalDate));
        }
        if (registerDate != null) {
            joiner.add("registerDate=" + io.github.icommapi.bizgo.internal.Masking.length(registerDate));
        }
        if (registerId != null) {
            joiner.add("registerId=" + io.github.icommapi.bizgo.internal.Masking.length(registerId));
        }
        if (updateDate != null) {
            joiner.add("updateDate=" + io.github.icommapi.bizgo.internal.Masking.length(updateDate));
        }
        if (updateId != null) {
            joiner.add("updateId=" + io.github.icommapi.bizgo.internal.Masking.length(updateId));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsChatbot}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String chatbotId;
        private String brandId;
        private String groupId;
        private String mdn;
        private String subNum;
        private String isMainNum;
        private String subTitle;
        private String subDescr;
        private String service;
        private String display;
        private Integer inputField;
        private String botAgencyId;
        private String saftyStatusYn;
        private String psMenuUse;
        private Map<String, Object> persistentMenu;
        private String rcsReply;
        private String webhook;
        private String searchWeight;
        private String botTcPage;
        private Map<String, Object> mediaUrl;
        private String status;
        private String approvalResult;
        private String approvalReason;
        private String approvalDate;
        private String registerDate;
        private String registerId;
        private String updateDate;
        private String updateId;

        /** Creates an empty builder; same as {@link RcsChatbot#builder()}. */
        public Builder() {
        }

        /**
         * 대화방 ID입니다.
         *
         * @param chatbotId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("chatbotId")
        public Builder chatbotId(String chatbotId) {
            this.chatbotId = chatbotId;
            return this;
        }

        /**
         * 대화방이 속한 브랜드 ID입니다.
         *
         * @param brandId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandId")
        public Builder brandId(String brandId) {
            this.brandId = brandId;
            return this;
        }

        /**
         * 대화방이 속한 그룹 ID입니다.
         *
         * @param groupId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("groupId")
        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        /**
         * 대화방에 연결된 발신번호입니다.
         *
         * @param mdn the value (null clears it)
         * @return this builder
         */
        @JsonProperty("mdn")
        public Builder mdn(String mdn) {
            this.mdn = mdn;
            return this;
        }

        /**
         * 대화방에 연결된 부가번호입니다.
         *
         * @param subNum the value (null clears it)
         * @return this builder
         */
        @JsonProperty("subNum")
        public Builder subNum(String subNum) {
            this.subNum = subNum;
            return this;
        }

        /**
         * 대표번호 여부입니다. <code>Y</code> 대표번호, <code>N</code> 부가번호입니다(영문 문서 기준).
         *
         * <p>허용 값 <code>Y</code>, <code>N</code>
         *
         * @param isMainNum the value (null clears it)
         * @return this builder
         */
        @JsonProperty("isMainNum")
        public Builder isMainNum(String isMainNum) {
            this.isMainNum = isMainNum;
            return this;
        }

        /**
         * 대화방 부제목입니다.
         *
         * @param subTitle the value (null clears it)
         * @return this builder
         */
        @JsonProperty("subTitle")
        public Builder subTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        /**
         * 대화방 부가 설명입니다.
         *
         * @param subDescr the value (null clears it)
         * @return this builder
         */
        @JsonProperty("subDescr")
        public Builder subDescr(String subDescr) {
            this.subDescr = subDescr;
            return this;
        }

        /**
         * 대화방의 서비스 구분 값입니다.
         *
         * @param service the value (null clears it)
         * @return this builder
         */
        @JsonProperty("service")
        public Builder service(String service) {
            this.service = service;
            return this;
        }

        /**
         * 대화방 노출 설정 값입니다.
         *
         * @param display the value (null clears it)
         * @return this builder
         */
        @JsonProperty("display")
        public Builder display(String display) {
            this.display = display;
            return this;
        }

        /**
         * 대화방 입력창 사용 설정 값입니다.
         *
         * @param inputField the value (null clears it)
         * @return this builder
         */
        @JsonProperty("inputField")
        public Builder inputField(Integer inputField) {
            this.inputField = inputField;
            return this;
        }

        /**
         * 대화방을 등록한 대행사 ID입니다.
         *
         * @param botAgencyId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("botAgencyId")
        public Builder botAgencyId(String botAgencyId) {
            this.botAgencyId = botAgencyId;
            return this;
        }

        /**
         * 안심마크 지정 기업 여부입니다. 필드명은 문서 표기(<code>safty</code>)를 따릅니다.
         *
         * @param saftyStatusYn the value (null clears it)
         * @return this builder
         */
        @JsonProperty("saftyStatusYn")
        public Builder saftyStatusYn(String saftyStatusYn) {
            this.saftyStatusYn = saftyStatusYn;
            return this;
        }

        /**
         * 고정 메뉴 사용 여부입니다. <code>Y</code> 사용, <code>N</code> 미사용입니다(영문 문서 기준).
         *
         * <p>허용 값 <code>Y</code>, <code>N</code>
         *
         * @param psMenuUse the value (null clears it)
         * @return this builder
         */
        @JsonProperty("psMenuUse")
        public Builder psMenuUse(String psMenuUse) {
            this.psMenuUse = psMenuUse;
            return this;
        }

        /**
         * 대화방 고정 메뉴 구성 정보입니다.
         *
         * <p><b>확인 필요:</b> 하위 필드가 문서화되어 있지 않습니다.
         *
         * @param persistentMenu the value (null clears it)
         * @return this builder
         */
        @JsonProperty("persistentMenu")
        public Builder persistentMenu(Map<String, Object> persistentMenu) {
            this.persistentMenu = persistentMenu;
            return this;
        }

        /**
         * 대화방 응답 설정 값입니다.
         *
         * @param rcsReply the value (null clears it)
         * @return this builder
         */
        @JsonProperty("rcsReply")
        public Builder rcsReply(String rcsReply) {
            this.rcsReply = rcsReply;
            return this;
        }

        /**
         * 대화방 이벤트를 수신할 웹훅 URL입니다.
         *
         * @param webhook the value (null clears it)
         * @return this builder
         */
        @JsonProperty("webhook")
        public Builder webhook(String webhook) {
            this.webhook = webhook;
            return this;
        }

        /**
         * 대화방 검색 가중치입니다.
         *
         * @param searchWeight the value (null clears it)
         * @return this builder
         */
        @JsonProperty("searchWeight")
        public Builder searchWeight(String searchWeight) {
            this.searchWeight = searchWeight;
            return this;
        }

        /**
         * 대화방 이용약관 페이지 주소입니다.
         *
         * @param botTcPage the value (null clears it)
         * @return this builder
         */
        @JsonProperty("botTcPage")
        public Builder botTcPage(String botTcPage) {
            this.botTcPage = botTcPage;
            return this;
        }

        /**
         * 대화방 이미지 파일 ID와 URL 및 사용 유형 정보입니다.
         *
         * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없습니다. 브랜드의 mediaUrl은 Object Array(fileId/url/typeName/fileName)라서 같은 구조의 배열일 가능성이 있습니다.
         *
         * @param mediaUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("mediaUrl")
        public Builder mediaUrl(Map<String, Object> mediaUrl) {
            this.mediaUrl = mediaUrl;
            return this;
        }

        /**
         * 대화방의 상태입니다. 문서 예시 값은 <code>ready</code>입니다.
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        @JsonProperty("status")
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 대화방 승인 결과입니다. 문서 예시 값은 <code>approved</code>입니다.
         *
         * @param approvalResult the value (null clears it)
         * @return this builder
         */
        @JsonProperty("approvalResult")
        public Builder approvalResult(String approvalResult) {
            this.approvalResult = approvalResult;
            return this;
        }

        /**
         * 검수 시 반려 사유입니다.
         *
         * @param approvalReason the value (null clears it)
         * @return this builder
         */
        @JsonProperty("approvalReason")
        public Builder approvalReason(String approvalReason) {
            this.approvalReason = approvalReason;
            return this;
        }

        /**
         * 승인일시입니다.
         *
         * @param approvalDate the value (null clears it)
         * @return this builder
         */
        @JsonProperty("approvalDate")
        public Builder approvalDate(String approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        /**
         * 등록일시입니다.
         *
         * @param registerDate the value (null clears it)
         * @return this builder
         */
        @JsonProperty("registerDate")
        public Builder registerDate(String registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        /**
         * 등록자 ID입니다.
         *
         * @param registerId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("registerId")
        public Builder registerId(String registerId) {
            this.registerId = registerId;
            return this;
        }

        /**
         * 수정일시입니다.
         *
         * @param updateDate the value (null clears it)
         * @return this builder
         */
        @JsonProperty("updateDate")
        public Builder updateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        /**
         * 수정자 ID입니다.
         *
         * @param updateId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("updateId")
        public Builder updateId(String updateId) {
            this.updateId = updateId;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsChatbot}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsChatbot build() {
            RcsChatbot built = new RcsChatbot(this);
            ModelValidator v = new ModelValidator("RcsChatbot");
            v.oneOf("isMainNum", built.isMainNum, IS_MAIN_NUM_VALUES);
            v.oneOf("psMenuUse", built.psMenuUse, PS_MENU_USE_VALUES);
            v.mapValues("persistentMenu", built.persistentMenu, false);
            v.mapValues("mediaUrl", built.mediaUrl, false);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsChatbot buildUnvalidated() {
            return new RcsChatbot(this);
        }
    }
}
