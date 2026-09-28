// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 알림톡 템플릿 등록·수정 요청의 템플릿 정보(<code>alimtalk</code>)입니다. 이미지형·아이템리스트형 템플릿은 템플릿 이미지 업로드(<code>POST /file/alimtalk/template</code>)로 받은 <code>imgUrl</code>과 이름을 <code>imgUrl</code>, <code>imgName</code>에 넣습니다. 버튼·바로연결·아이템 구조는 발송 규격의 <code>AlimtalkButton</code>, <code>AlimtalkQuickReply</code>, <code>AlimtalkItem</code> 등과 같습니다.
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
@JsonDeserialize(builder = AlimtalkTemplateBody.Builder.class)
@JsonPropertyOrder({"senderKey", "senderKeyType", "templateName", "templateCode", "templateMessageType", "templateEmphasizeType", "text", "title", "subTitle", "header", "imgName", "imgUrl", "link", "attachment", "supplement", "categoryCode", "securityFlag", "adultFlag", "previewMessage", "extra"})
public final class AlimtalkTemplateBody {
    private static final List<String> SENDER_KEY_TYPE_VALUES = List.of("G", "S");

    private final String senderKey;
    private final String senderKeyType;
    private final String templateName;
    private final String templateCode;
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

    private AlimtalkTemplateBody(Builder builder) {
        this.senderKey = builder.senderKey;
        this.senderKeyType = builder.senderKeyType;
        this.templateName = builder.templateName;
        this.templateCode = builder.templateCode;
        this.templateMessageType = builder.templateMessageType;
        this.templateEmphasizeType = builder.templateEmphasizeType;
        this.text = builder.text;
        this.title = builder.title;
        this.subTitle = builder.subTitle;
        this.header = builder.header;
        this.imgName = builder.imgName;
        this.imgUrl = builder.imgUrl;
        this.link = builder.link;
        this.attachment = builder.attachment;
        this.supplement = builder.supplement;
        this.categoryCode = builder.categoryCode;
        this.securityFlag = builder.securityFlag;
        this.adultFlag = builder.adultFlag;
        this.previewMessage = builder.previewMessage;
        this.extra = builder.extra;
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
        return builder;
    }

    /**
     * 카카오 비즈메시지 발신프로필 키입니다. <code>senderKeyType</code>이 <code>G</code>이면 그룹 키입니다.
     *
     * <p>필수
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
     * <p>허용 값 <code>G</code>, <code>S</code> · 서버 기본값 <code>S</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKeyType")
    public String getSenderKeyType() {
        return senderKeyType;
    }

    /**
     * 템플릿 이름입니다. 최대 200자입니다.
     *
     * <p>필수 · 최대 200자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateName")
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 알림톡 템플릿 코드입니다. 최대 30자입니다.
     *
     * <p>필수 · 최대 30자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 템플릿 메시지 타입입니다. 문서 예시 값은 <code>BA</code>입니다.
     *
     * <p>필수 · 알려진 값 <code>BA</code>
     *
     * <p><b>확인 필요:</b> 템플릿 메시지 타입 코드 전체 목록이 문서에 없습니다.
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
     * <p>필수 · 알려진 값 <code>NONE</code>
     *
     * <p><b>확인 필요:</b> 템플릿 강조 타입 코드 전체 목록과 타입별 필수 필드(title, imgUrl, itemHighlight 등)가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateEmphasizeType")
    public String getTemplateEmphasizeType() {
        return templateEmphasizeType;
    }

    /**
     * 알림톡 템플릿 본문입니다. 최대 1,300자이며 <code>#&#123;변수&#125;</code> 형식의 치환 변수를 쓸 수 있습니다.
     *
     * <p>필수 · 최대 1300자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 강조표기형 템플릿 제목입니다. 최대 50자입니다.
     *
     * <p>최대 50자
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
     * 템플릿 이미지 파일 이름입니다.
     *
     * <p><b>확인 필요:</b> 이미지 업로드 응답은 <code>fileName</code>을 돌려주므로 <code>imgName</code>에 그 값을 그대로 넣는지 문서에 명시되지 않았습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imgName")
    public String getImgName() {
        return imgName;
    }

    /**
     * 템플릿 이미지 URL입니다. 템플릿 이미지 업로드 응답의 <code>imgUrl</code>을 씁니다.
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
     * 템플릿 카테고리 코드입니다. 템플릿 카테고리 전체 조회로 확인합니다.
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
     * 연령 인증 설정 여부입니다. 수신자가 연령 인증을 마치기 전까지 채팅방에서 메시지가 가려지며 만 20세 이상만 볼 수 있습니다. 기본값은 <code>false</code>입니다.
     *
     * <p>서버 기본값 <code>false</code>(설정하지 않으면 보내지 않음)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlimtalkTemplateBody)) {
            return false;
        }
        AlimtalkTemplateBody other = (AlimtalkTemplateBody) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(senderKeyType, other.senderKeyType)
                && Objects.equals(templateName, other.templateName)
                && Objects.equals(templateCode, other.templateCode)
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
                && Objects.equals(extra, other.extra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, senderKeyType, templateName, templateCode, templateMessageType, templateEmphasizeType, text, title, subTitle, header, imgName, imgUrl, link, attachment, supplement, categoryCode, securityFlag, adultFlag, previewMessage, extra);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateBody{", "}");
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
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateBody}. */
    @JsonPOJOBuilder(withPrefix = "")
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

        /** Creates an empty builder; same as {@link AlimtalkTemplateBody#builder()}. */
        public Builder() {
        }

        /**
         * 카카오 비즈메시지 발신프로필 키입니다. <code>senderKeyType</code>이 <code>G</code>이면 그룹 키입니다.
         *
         * <p>필수
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("senderKey")
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
         * <p>허용 값 <code>G</code>, <code>S</code> · 서버 기본값 <code>S</code>(설정하지 않으면 보내지 않음)
         *
         * @param senderKeyType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("senderKeyType")
        public Builder senderKeyType(String senderKeyType) {
            this.senderKeyType = senderKeyType;
            return this;
        }

        /**
         * 템플릿 이름입니다. 최대 200자입니다.
         *
         * <p>필수 · 최대 200자
         *
         * @param templateName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("templateName")
        public Builder templateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        /**
         * 알림톡 템플릿 코드입니다. 최대 30자입니다.
         *
         * <p>필수 · 최대 30자
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        @JsonProperty("templateCode")
        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * 템플릿 메시지 타입입니다. 문서 예시 값은 <code>BA</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>BA</code>
         *
         * <p><b>확인 필요:</b> 템플릿 메시지 타입 코드 전체 목록이 문서에 없습니다.
         *
         * @param templateMessageType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("templateMessageType")
        public Builder templateMessageType(String templateMessageType) {
            this.templateMessageType = templateMessageType;
            return this;
        }

        /**
         * 템플릿 강조 타입입니다. 문서 예시 값은 <code>NONE</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>NONE</code>
         *
         * <p><b>확인 필요:</b> 템플릿 강조 타입 코드 전체 목록과 타입별 필수 필드(title, imgUrl, itemHighlight 등)가 문서에 없습니다.
         *
         * @param templateEmphasizeType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("templateEmphasizeType")
        public Builder templateEmphasizeType(String templateEmphasizeType) {
            this.templateEmphasizeType = templateEmphasizeType;
            return this;
        }

        /**
         * 알림톡 템플릿 본문입니다. 최대 1,300자이며 <code>#&#123;변수&#125;</code> 형식의 치환 변수를 쓸 수 있습니다.
         *
         * <p>필수 · 최대 1300자
         *
         * @param text the value (null clears it)
         * @return this builder
         */
        @JsonProperty("text")
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * 강조표기형 템플릿 제목입니다. 최대 50자입니다.
         *
         * <p>최대 50자
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        @JsonProperty("title")
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
        @JsonProperty("subTitle")
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
        @JsonProperty("header")
        public Builder header(String header) {
            this.header = header;
            return this;
        }

        /**
         * 템플릿 이미지 파일 이름입니다.
         *
         * <p><b>확인 필요:</b> 이미지 업로드 응답은 <code>fileName</code>을 돌려주므로 <code>imgName</code>에 그 값을 그대로 넣는지 문서에 명시되지 않았습니다.
         *
         * @param imgName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imgName")
        public Builder imgName(String imgName) {
            this.imgName = imgName;
            return this;
        }

        /**
         * 템플릿 이미지 URL입니다. 템플릿 이미지 업로드 응답의 <code>imgUrl</code>을 씁니다.
         *
         * @param imgUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imgUrl")
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
        @JsonProperty("link")
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
        @JsonProperty("attachment")
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
        @JsonProperty("supplement")
        public Builder supplement(AlimtalkSupplement supplement) {
            this.supplement = supplement;
            return this;
        }

        /**
         * 템플릿 카테고리 코드입니다. 템플릿 카테고리 전체 조회로 확인합니다.
         *
         * @param categoryCode the value (null clears it)
         * @return this builder
         */
        @JsonProperty("categoryCode")
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
        @JsonProperty("securityFlag")
        public Builder securityFlag(Boolean securityFlag) {
            this.securityFlag = securityFlag;
            return this;
        }

        /**
         * 연령 인증 설정 여부입니다. 수신자가 연령 인증을 마치기 전까지 채팅방에서 메시지가 가려지며 만 20세 이상만 볼 수 있습니다. 기본값은 <code>false</code>입니다.
         *
         * <p>서버 기본값 <code>false</code>(설정하지 않으면 보내지 않음)
         *
         * @param adultFlag the value (null clears it)
         * @return this builder
         */
        @JsonProperty("adultFlag")
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
        @JsonProperty("previewMessage")
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
        @JsonProperty("extra")
        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code AlimtalkTemplateBody}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public AlimtalkTemplateBody build() {
            AlimtalkTemplateBody built = new AlimtalkTemplateBody(this);
            ModelValidator v = new ModelValidator("AlimtalkTemplateBody");
            v.required("senderKey", built.senderKey);
            v.oneOf("senderKeyType", built.senderKeyType, SENDER_KEY_TYPE_VALUES);
            v.required("templateName", built.templateName);
            v.maxLength("templateName", built.templateName, 200);
            v.required("templateCode", built.templateCode);
            v.maxLength("templateCode", built.templateCode, 30);
            v.required("templateMessageType", built.templateMessageType);
            v.required("templateEmphasizeType", built.templateEmphasizeType);
            v.required("text", built.text);
            v.maxLength("text", built.text, 1300);
            v.maxLength("title", built.title, 50);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        AlimtalkTemplateBody buildUnvalidated() {
            return new AlimtalkTemplateBody(this);
        }
    }
}
