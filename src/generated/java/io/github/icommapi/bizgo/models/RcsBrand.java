// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * RCS 브랜드 정보입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 일시 필드(registerDate, approvalDate, updateDate, chatbotDate, logoDate, messagebaseDate)의 형식이 문서화되어 있지 않습니다.
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
@JsonDeserialize(builder = RcsBrand.Builder.class)
@JsonPropertyOrder({"brandId", "name", "brandKey", "registerDate", "approvalDate", "updateDate", "status", "mediaUrl", "chatbotDate", "logoDate", "messagebaseDate", "description", "tel", "menus", "categoryId", "categoryName", "subCategoryId", "subCategoryName", "categoryOpt", "zipCode", "roadAddress", "detailAddress", "email", "webSiteUrl", "approvalReason", "brandFeedUrl", "initTab", "initFeedItems", "templateColor", "bizInfoYn", "bizInfoTitle", "bizInfoContent", "saftyStatusYn"})
public final class RcsBrand {

    private final String brandId;
    private final String name;
    private final String brandKey;
    private final String registerDate;
    private final String approvalDate;
    private final String updateDate;
    private final String status;
    private final List<RcsBrandMediaUrl> mediaUrl;
    private final String chatbotDate;
    private final String logoDate;
    private final String messagebaseDate;
    private final String description;
    private final String tel;
    private final List<RcsBrandMenu> menus;
    private final Map<String, Object> categoryId;
    private final List<Map<String, Object>> categoryName;
    private final Map<String, Object> subCategoryId;
    private final Map<String, Object> subCategoryName;
    private final Map<String, Object> categoryOpt;
    private final List<Map<String, Object>> zipCode;
    private final String roadAddress;
    private final String detailAddress;
    private final String email;
    private final String webSiteUrl;
    private final String approvalReason;
    private final String brandFeedUrl;
    private final String initTab;
    private final String initFeedItems;
    private final String templateColor;
    private final String bizInfoYn;
    private final String bizInfoTitle;
    private final String bizInfoContent;
    private final String saftyStatusYn;

    private RcsBrand(Builder builder) {
        this.brandId = builder.brandId;
        this.name = builder.name;
        this.brandKey = builder.brandKey;
        this.registerDate = builder.registerDate;
        this.approvalDate = builder.approvalDate;
        this.updateDate = builder.updateDate;
        this.status = builder.status;
        this.mediaUrl = builder.mediaUrl == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.mediaUrl));
        this.chatbotDate = builder.chatbotDate;
        this.logoDate = builder.logoDate;
        this.messagebaseDate = builder.messagebaseDate;
        this.description = builder.description;
        this.tel = builder.tel;
        this.menus = builder.menus == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.menus));
        this.categoryId = builder.categoryId == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.categoryId));
        this.categoryName = builder.categoryName == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.categoryName));
        this.subCategoryId = builder.subCategoryId == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.subCategoryId));
        this.subCategoryName = builder.subCategoryName == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.subCategoryName));
        this.categoryOpt = builder.categoryOpt == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.categoryOpt));
        this.zipCode = builder.zipCode == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.zipCode));
        this.roadAddress = builder.roadAddress;
        this.detailAddress = builder.detailAddress;
        this.email = builder.email;
        this.webSiteUrl = builder.webSiteUrl;
        this.approvalReason = builder.approvalReason;
        this.brandFeedUrl = builder.brandFeedUrl;
        this.initTab = builder.initTab;
        this.initFeedItems = builder.initFeedItems;
        this.templateColor = builder.templateColor;
        this.bizInfoYn = builder.bizInfoYn;
        this.bizInfoTitle = builder.bizInfoTitle;
        this.bizInfoContent = builder.bizInfoContent;
        this.saftyStatusYn = builder.saftyStatusYn;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.brandId = this.brandId;
        builder.name = this.name;
        builder.brandKey = this.brandKey;
        builder.registerDate = this.registerDate;
        builder.approvalDate = this.approvalDate;
        builder.updateDate = this.updateDate;
        builder.status = this.status;
        builder.mediaUrl = this.mediaUrl;
        builder.chatbotDate = this.chatbotDate;
        builder.logoDate = this.logoDate;
        builder.messagebaseDate = this.messagebaseDate;
        builder.description = this.description;
        builder.tel = this.tel;
        builder.menus = this.menus;
        builder.categoryId = this.categoryId;
        builder.categoryName = this.categoryName;
        builder.subCategoryId = this.subCategoryId;
        builder.subCategoryName = this.subCategoryName;
        builder.categoryOpt = this.categoryOpt;
        builder.zipCode = this.zipCode;
        builder.roadAddress = this.roadAddress;
        builder.detailAddress = this.detailAddress;
        builder.email = this.email;
        builder.webSiteUrl = this.webSiteUrl;
        builder.approvalReason = this.approvalReason;
        builder.brandFeedUrl = this.brandFeedUrl;
        builder.initTab = this.initTab;
        builder.initFeedItems = this.initFeedItems;
        builder.templateColor = this.templateColor;
        builder.bizInfoYn = this.bizInfoYn;
        builder.bizInfoTitle = this.bizInfoTitle;
        builder.bizInfoContent = this.bizInfoContent;
        builder.saftyStatusYn = this.saftyStatusYn;
        return builder;
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
     * 브랜드 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 브랜드 키입니다(최대 200자).
     *
     * <p>최대 200자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandKey")
    public String getBrandKey() {
        return brandKey;
    }

    /**
     * 등록일시입니다(최대 30자).
     *
     * <p>최대 30자
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
     * 브랜드의 상태입니다(최대 1300자). 문서 예시 값은 <code>ready</code>입니다.
     *
     * <p>최대 1300자
     *
     * <p><b>확인 필요:</b> 상태 값 목록이 문서화되어 있지 않고, 길이 제한 1300자는 상태 코드로 보기에 이례적입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 이미지 파일 ID와 URL 및 사용 유형 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("mediaUrl")
    public List<RcsBrandMediaUrl> getMediaUrl() {
        return mediaUrl;
    }

    /**
     * 브랜드 내 등록된 대화방 중 가장 최근에 변경된 대화방의 일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatbotDate")
    public String getChatbotDate() {
        return chatbotDate;
    }

    /**
     * 로고 이미지 중 가장 최근에 변경된 일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("logoDate")
    public String getLogoDate() {
        return logoDate;
    }

    /**
     * 브랜드 내 등록된 템플릿 중 가장 최근에 변경된 템플릿의 일시입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messagebaseDate")
    public String getMessagebaseDate() {
        return messagebaseDate;
    }

    /**
     * 브랜드 설명에 등록된 내용입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 브랜드 홈에 노출될 전화번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("tel")
    public String getTel() {
        return tel;
    }

    /**
     * 메뉴입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("menus")
    public List<RcsBrandMenu> getMenus() {
        return menus;
    }

    /**
     * 브랜드 카테고리 ID입니다.
     *
     * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없고, ID 값이므로 문자열일 가능성이 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categoryId")
    public Map<String, Object> getCategoryId() {
        return categoryId;
    }

    /**
     * 브랜드 카테고리명입니다.
     *
     * <p><b>확인 필요:</b> 문서 타입은 Object Array이지만 하위 필드가 없고, 이름 값이므로 문자열일 가능성이 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categoryName")
    public List<Map<String, Object>> getCategoryName() {
        return categoryName;
    }

    /**
     * 브랜드 하위 카테고리 ID입니다.
     *
     * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없고, ID 값이므로 문자열일 가능성이 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("subCategoryId")
    public Map<String, Object> getSubCategoryId() {
        return subCategoryId;
    }

    /**
     * 브랜드 하위 카테고리명입니다.
     *
     * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없고, 이름 값이므로 문자열일 가능성이 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("subCategoryName")
    public Map<String, Object> getSubCategoryName() {
        return subCategoryName;
    }

    /**
     * 검색용 키워드입니다.
     *
     * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("categoryOpt")
    public Map<String, Object> getCategoryOpt() {
        return categoryOpt;
    }

    /**
     * 브랜드 홈에 표시될 우편번호입니다.
     *
     * <p><b>확인 필요:</b> 문서 타입은 Object Array이지만 하위 필드가 없고, 우편번호는 문자열일 가능성이 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("zipCode")
    public List<Map<String, Object>> getZipCode() {
        return zipCode;
    }

    /**
     * 브랜드 홈에 표시되는 도로명주소입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("roadAddress")
    public String getRoadAddress() {
        return roadAddress;
    }

    /**
     * 브랜드 홈에 표시되는 상세주소입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("detailAddress")
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 브랜드 홈에 표시되는 이메일 주소입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 브랜드 홈에 표시되는 홈페이지 주소입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("webSiteUrl")
    public String getWebSiteUrl() {
        return webSiteUrl;
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
     * 브랜드 소식 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandFeedUrl")
    public String getBrandFeedUrl() {
        return brandFeedUrl;
    }

    /**
     * 단말에 표시되는 브랜드 홈의 기본 탭입니다. 알려진 값은 <code>FEED</code>입니다.
     *
     * <p>알려진 값 <code>FEED</code>
     *
     * <p><b>확인 필요:</b> FEED 외의 탭 값이 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("initTab")
    public String getInitTab() {
        return initTab;
    }

    /**
     * <code>initTab</code>이 <code>FEED</code>인 경우 소식 탭에 표시할 메뉴입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("initFeedItems")
    public String getInitFeedItems() {
        return initFeedItems;
    }

    /**
     * 브랜드 내 등록되는 템플릿의 버튼 컬러 값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateColor")
    public String getTemplateColor() {
        return templateColor;
    }

    /**
     * 브랜드 소식 탭에 운영정보를 사용할지 여부입니다(<code>Y</code>/<code>N</code>).
     *
     * <p><b>확인 필요:</b> Y 외의 값(N 등)이 문서에 명시되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizInfoYn")
    public String getBizInfoYn() {
        return bizInfoYn;
    }

    /**
     * <code>bizInfoYn</code>이 <code>Y</code>인 경우 운영정보 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizInfoTitle")
    public String getBizInfoTitle() {
        return bizInfoTitle;
    }

    /**
     * <code>bizInfoYn</code>이 <code>Y</code>인 경우 운영정보 내용입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bizInfoContent")
    public String getBizInfoContent() {
        return bizInfoContent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsBrand)) {
            return false;
        }
        RcsBrand other = (RcsBrand) o;
        return Objects.equals(brandId, other.brandId)
                && Objects.equals(name, other.name)
                && Objects.equals(brandKey, other.brandKey)
                && Objects.equals(registerDate, other.registerDate)
                && Objects.equals(approvalDate, other.approvalDate)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(status, other.status)
                && Objects.equals(mediaUrl, other.mediaUrl)
                && Objects.equals(chatbotDate, other.chatbotDate)
                && Objects.equals(logoDate, other.logoDate)
                && Objects.equals(messagebaseDate, other.messagebaseDate)
                && Objects.equals(description, other.description)
                && Objects.equals(tel, other.tel)
                && Objects.equals(menus, other.menus)
                && Objects.equals(categoryId, other.categoryId)
                && Objects.equals(categoryName, other.categoryName)
                && Objects.equals(subCategoryId, other.subCategoryId)
                && Objects.equals(subCategoryName, other.subCategoryName)
                && Objects.equals(categoryOpt, other.categoryOpt)
                && Objects.equals(zipCode, other.zipCode)
                && Objects.equals(roadAddress, other.roadAddress)
                && Objects.equals(detailAddress, other.detailAddress)
                && Objects.equals(email, other.email)
                && Objects.equals(webSiteUrl, other.webSiteUrl)
                && Objects.equals(approvalReason, other.approvalReason)
                && Objects.equals(brandFeedUrl, other.brandFeedUrl)
                && Objects.equals(initTab, other.initTab)
                && Objects.equals(initFeedItems, other.initFeedItems)
                && Objects.equals(templateColor, other.templateColor)
                && Objects.equals(bizInfoYn, other.bizInfoYn)
                && Objects.equals(bizInfoTitle, other.bizInfoTitle)
                && Objects.equals(bizInfoContent, other.bizInfoContent)
                && Objects.equals(saftyStatusYn, other.saftyStatusYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, name, brandKey, registerDate, approvalDate, updateDate, status, mediaUrl, chatbotDate, logoDate, messagebaseDate, description, tel, menus, categoryId, categoryName, subCategoryId, subCategoryName, categoryOpt, zipCode, roadAddress, detailAddress, email, webSiteUrl, approvalReason, brandFeedUrl, initTab, initFeedItems, templateColor, bizInfoYn, bizInfoTitle, bizInfoContent, saftyStatusYn);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsBrand{", "}");
        if (brandId != null) {
            joiner.add("brandId=" + io.github.icommapi.bizgo.internal.Masking.length(brandId));
        }
        if (name != null) {
            joiner.add("name=" + io.github.icommapi.bizgo.internal.Masking.length(name));
        }
        if (brandKey != null) {
            joiner.add("brandKey=" + io.github.icommapi.bizgo.internal.Masking.length(brandKey));
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
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (mediaUrl != null) {
            joiner.add("mediaUrl=" + mediaUrl);
        }
        if (chatbotDate != null) {
            joiner.add("chatbotDate=" + io.github.icommapi.bizgo.internal.Masking.length(chatbotDate));
        }
        if (logoDate != null) {
            joiner.add("logoDate=" + io.github.icommapi.bizgo.internal.Masking.length(logoDate));
        }
        if (messagebaseDate != null) {
            joiner.add("messagebaseDate=" + io.github.icommapi.bizgo.internal.Masking.length(messagebaseDate));
        }
        if (description != null) {
            joiner.add("description=" + io.github.icommapi.bizgo.internal.Masking.length(description));
        }
        if (tel != null) {
            joiner.add("tel=" + io.github.icommapi.bizgo.internal.Masking.phone(tel));
        }
        if (menus != null) {
            joiner.add("menus=" + menus);
        }
        if (categoryId != null) {
            joiner.add("categoryId=***");
        }
        if (categoryName != null) {
            joiner.add("categoryName=***");
        }
        if (subCategoryId != null) {
            joiner.add("subCategoryId=***");
        }
        if (subCategoryName != null) {
            joiner.add("subCategoryName=***");
        }
        if (categoryOpt != null) {
            joiner.add("categoryOpt=***");
        }
        if (zipCode != null) {
            joiner.add("zipCode=***");
        }
        if (roadAddress != null) {
            joiner.add("roadAddress=" + io.github.icommapi.bizgo.internal.Masking.length(roadAddress));
        }
        if (detailAddress != null) {
            joiner.add("detailAddress=" + io.github.icommapi.bizgo.internal.Masking.length(detailAddress));
        }
        if (email != null) {
            joiner.add("email=" + io.github.icommapi.bizgo.internal.Masking.person(email));
        }
        if (webSiteUrl != null) {
            joiner.add("webSiteUrl=" + io.github.icommapi.bizgo.internal.Masking.length(webSiteUrl));
        }
        if (approvalReason != null) {
            joiner.add("approvalReason=" + io.github.icommapi.bizgo.internal.Masking.length(approvalReason));
        }
        if (brandFeedUrl != null) {
            joiner.add("brandFeedUrl=" + io.github.icommapi.bizgo.internal.Masking.length(brandFeedUrl));
        }
        if (initTab != null) {
            joiner.add("initTab=" + io.github.icommapi.bizgo.internal.Masking.length(initTab));
        }
        if (initFeedItems != null) {
            joiner.add("initFeedItems=" + io.github.icommapi.bizgo.internal.Masking.length(initFeedItems));
        }
        if (templateColor != null) {
            joiner.add("templateColor=" + io.github.icommapi.bizgo.internal.Masking.length(templateColor));
        }
        if (bizInfoYn != null) {
            joiner.add("bizInfoYn=" + io.github.icommapi.bizgo.internal.Masking.length(bizInfoYn));
        }
        if (bizInfoTitle != null) {
            joiner.add("bizInfoTitle=" + io.github.icommapi.bizgo.internal.Masking.length(bizInfoTitle));
        }
        if (bizInfoContent != null) {
            joiner.add("bizInfoContent=" + io.github.icommapi.bizgo.internal.Masking.length(bizInfoContent));
        }
        if (saftyStatusYn != null) {
            joiner.add("saftyStatusYn=" + io.github.icommapi.bizgo.internal.Masking.length(saftyStatusYn));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsBrand}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String brandId;
        private String name;
        private String brandKey;
        private String registerDate;
        private String approvalDate;
        private String updateDate;
        private String status;
        private List<RcsBrandMediaUrl> mediaUrl;
        private String chatbotDate;
        private String logoDate;
        private String messagebaseDate;
        private String description;
        private String tel;
        private List<RcsBrandMenu> menus;
        private Map<String, Object> categoryId;
        private List<Map<String, Object>> categoryName;
        private Map<String, Object> subCategoryId;
        private Map<String, Object> subCategoryName;
        private Map<String, Object> categoryOpt;
        private List<Map<String, Object>> zipCode;
        private String roadAddress;
        private String detailAddress;
        private String email;
        private String webSiteUrl;
        private String approvalReason;
        private String brandFeedUrl;
        private String initTab;
        private String initFeedItems;
        private String templateColor;
        private String bizInfoYn;
        private String bizInfoTitle;
        private String bizInfoContent;
        private String saftyStatusYn;

        /** Creates an empty builder; same as {@link RcsBrand#builder()}. */
        public Builder() {
        }

        /**
         * 브랜드 ID입니다.
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
         * 브랜드 이름입니다.
         *
         * @param name the value (null clears it)
         * @return this builder
         */
        @JsonProperty("name")
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * 브랜드 키입니다(최대 200자).
         *
         * <p>최대 200자
         *
         * @param brandKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandKey")
        public Builder brandKey(String brandKey) {
            this.brandKey = brandKey;
            return this;
        }

        /**
         * 등록일시입니다(최대 30자).
         *
         * <p>최대 30자
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
         * 브랜드의 상태입니다(최대 1300자). 문서 예시 값은 <code>ready</code>입니다.
         *
         * <p>최대 1300자
         *
         * <p><b>확인 필요:</b> 상태 값 목록이 문서화되어 있지 않고, 길이 제한 1300자는 상태 코드로 보기에 이례적입니다.
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
         * 이미지 파일 ID와 URL 및 사용 유형 정보입니다.
         *
         * @param mediaUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("mediaUrl")
        public Builder mediaUrl(List<RcsBrandMediaUrl> mediaUrl) {
            this.mediaUrl = mediaUrl;
            return this;
        }

        /**
         * Varargs form of {@link #mediaUrl(List)}.
         *
         * @param mediaUrl values
         * @return this builder
         */
        public Builder mediaUrl(RcsBrandMediaUrl... mediaUrl) {
            this.mediaUrl = mediaUrl == null ? null : Arrays.asList(mediaUrl);
            return this;
        }

        /**
         * 브랜드 내 등록된 대화방 중 가장 최근에 변경된 대화방의 일시입니다.
         *
         * @param chatbotDate the value (null clears it)
         * @return this builder
         */
        @JsonProperty("chatbotDate")
        public Builder chatbotDate(String chatbotDate) {
            this.chatbotDate = chatbotDate;
            return this;
        }

        /**
         * 로고 이미지 중 가장 최근에 변경된 일시입니다.
         *
         * @param logoDate the value (null clears it)
         * @return this builder
         */
        @JsonProperty("logoDate")
        public Builder logoDate(String logoDate) {
            this.logoDate = logoDate;
            return this;
        }

        /**
         * 브랜드 내 등록된 템플릿 중 가장 최근에 변경된 템플릿의 일시입니다.
         *
         * @param messagebaseDate the value (null clears it)
         * @return this builder
         */
        @JsonProperty("messagebaseDate")
        public Builder messagebaseDate(String messagebaseDate) {
            this.messagebaseDate = messagebaseDate;
            return this;
        }

        /**
         * 브랜드 설명에 등록된 내용입니다.
         *
         * @param description the value (null clears it)
         * @return this builder
         */
        @JsonProperty("description")
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * 브랜드 홈에 노출될 전화번호입니다.
         *
         * @param tel the value (null clears it)
         * @return this builder
         */
        @JsonProperty("tel")
        public Builder tel(String tel) {
            this.tel = tel;
            return this;
        }

        /**
         * 메뉴입니다.
         *
         * @param menus the value (null clears it)
         * @return this builder
         */
        @JsonProperty("menus")
        public Builder menus(List<RcsBrandMenu> menus) {
            this.menus = menus;
            return this;
        }

        /**
         * Varargs form of {@link #menus(List)}.
         *
         * @param menus values
         * @return this builder
         */
        public Builder menus(RcsBrandMenu... menus) {
            this.menus = menus == null ? null : Arrays.asList(menus);
            return this;
        }

        /**
         * 브랜드 카테고리 ID입니다.
         *
         * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없고, ID 값이므로 문자열일 가능성이 있습니다.
         *
         * @param categoryId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("categoryId")
        public Builder categoryId(Map<String, Object> categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        /**
         * 브랜드 카테고리명입니다.
         *
         * <p><b>확인 필요:</b> 문서 타입은 Object Array이지만 하위 필드가 없고, 이름 값이므로 문자열일 가능성이 있습니다.
         *
         * @param categoryName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("categoryName")
        public Builder categoryName(List<Map<String, Object>> categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        /**
         * 브랜드 하위 카테고리 ID입니다.
         *
         * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없고, ID 값이므로 문자열일 가능성이 있습니다.
         *
         * @param subCategoryId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("subCategoryId")
        public Builder subCategoryId(Map<String, Object> subCategoryId) {
            this.subCategoryId = subCategoryId;
            return this;
        }

        /**
         * 브랜드 하위 카테고리명입니다.
         *
         * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없고, 이름 값이므로 문자열일 가능성이 있습니다.
         *
         * @param subCategoryName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("subCategoryName")
        public Builder subCategoryName(Map<String, Object> subCategoryName) {
            this.subCategoryName = subCategoryName;
            return this;
        }

        /**
         * 검색용 키워드입니다.
         *
         * <p><b>확인 필요:</b> 문서 타입은 Object이지만 하위 필드가 없습니다.
         *
         * @param categoryOpt the value (null clears it)
         * @return this builder
         */
        @JsonProperty("categoryOpt")
        public Builder categoryOpt(Map<String, Object> categoryOpt) {
            this.categoryOpt = categoryOpt;
            return this;
        }

        /**
         * 브랜드 홈에 표시될 우편번호입니다.
         *
         * <p><b>확인 필요:</b> 문서 타입은 Object Array이지만 하위 필드가 없고, 우편번호는 문자열일 가능성이 있습니다.
         *
         * @param zipCode the value (null clears it)
         * @return this builder
         */
        @JsonProperty("zipCode")
        public Builder zipCode(List<Map<String, Object>> zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        /**
         * 브랜드 홈에 표시되는 도로명주소입니다.
         *
         * @param roadAddress the value (null clears it)
         * @return this builder
         */
        @JsonProperty("roadAddress")
        public Builder roadAddress(String roadAddress) {
            this.roadAddress = roadAddress;
            return this;
        }

        /**
         * 브랜드 홈에 표시되는 상세주소입니다.
         *
         * @param detailAddress the value (null clears it)
         * @return this builder
         */
        @JsonProperty("detailAddress")
        public Builder detailAddress(String detailAddress) {
            this.detailAddress = detailAddress;
            return this;
        }

        /**
         * 브랜드 홈에 표시되는 이메일 주소입니다.
         *
         * @param email the value (null clears it)
         * @return this builder
         */
        @JsonProperty("email")
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * 브랜드 홈에 표시되는 홈페이지 주소입니다.
         *
         * @param webSiteUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("webSiteUrl")
        public Builder webSiteUrl(String webSiteUrl) {
            this.webSiteUrl = webSiteUrl;
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
         * 브랜드 소식 URL입니다.
         *
         * @param brandFeedUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandFeedUrl")
        public Builder brandFeedUrl(String brandFeedUrl) {
            this.brandFeedUrl = brandFeedUrl;
            return this;
        }

        /**
         * 단말에 표시되는 브랜드 홈의 기본 탭입니다. 알려진 값은 <code>FEED</code>입니다.
         *
         * <p>알려진 값 <code>FEED</code>
         *
         * <p><b>확인 필요:</b> FEED 외의 탭 값이 문서화되어 있지 않습니다.
         *
         * @param initTab the value (null clears it)
         * @return this builder
         */
        @JsonProperty("initTab")
        public Builder initTab(String initTab) {
            this.initTab = initTab;
            return this;
        }

        /**
         * <code>initTab</code>이 <code>FEED</code>인 경우 소식 탭에 표시할 메뉴입니다.
         *
         * @param initFeedItems the value (null clears it)
         * @return this builder
         */
        @JsonProperty("initFeedItems")
        public Builder initFeedItems(String initFeedItems) {
            this.initFeedItems = initFeedItems;
            return this;
        }

        /**
         * 브랜드 내 등록되는 템플릿의 버튼 컬러 값입니다.
         *
         * @param templateColor the value (null clears it)
         * @return this builder
         */
        @JsonProperty("templateColor")
        public Builder templateColor(String templateColor) {
            this.templateColor = templateColor;
            return this;
        }

        /**
         * 브랜드 소식 탭에 운영정보를 사용할지 여부입니다(<code>Y</code>/<code>N</code>).
         *
         * <p><b>확인 필요:</b> Y 외의 값(N 등)이 문서에 명시되어 있지 않습니다.
         *
         * @param bizInfoYn the value (null clears it)
         * @return this builder
         */
        @JsonProperty("bizInfoYn")
        public Builder bizInfoYn(String bizInfoYn) {
            this.bizInfoYn = bizInfoYn;
            return this;
        }

        /**
         * <code>bizInfoYn</code>이 <code>Y</code>인 경우 운영정보 제목입니다.
         *
         * @param bizInfoTitle the value (null clears it)
         * @return this builder
         */
        @JsonProperty("bizInfoTitle")
        public Builder bizInfoTitle(String bizInfoTitle) {
            this.bizInfoTitle = bizInfoTitle;
            return this;
        }

        /**
         * <code>bizInfoYn</code>이 <code>Y</code>인 경우 운영정보 내용입니다.
         *
         * @param bizInfoContent the value (null clears it)
         * @return this builder
         */
        @JsonProperty("bizInfoContent")
        public Builder bizInfoContent(String bizInfoContent) {
            this.bizInfoContent = bizInfoContent;
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
         * Builds the object.
         *
         * @return a new immutable {@code RcsBrand}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsBrand build() {
            RcsBrand built = new RcsBrand(this);
            ModelValidator v = new ModelValidator("RcsBrand");
            v.maxLength("brandKey", built.brandKey, 200);
            v.maxLength("registerDate", built.registerDate, 30);
            v.maxLength("status", built.status, 1300);
            v.items("mediaUrl", built.mediaUrl, -1, -1);
            v.items("menus", built.menus, -1, -1);
            v.mapValues("categoryId", built.categoryId, false);
            v.items("categoryName", built.categoryName, -1, -1);
            v.mapValues("subCategoryId", built.subCategoryId, false);
            v.mapValues("subCategoryName", built.subCategoryName, false);
            v.mapValues("categoryOpt", built.categoryOpt, false);
            v.items("zipCode", built.zipCode, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsBrand buildUnvalidated() {
            return new RcsBrand(this);
        }
    }
}
