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
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 네이버 톡톡(네이버 스마트알림) 메시지입니다. <code>messageFlow[].navertalk</code> 객체로 보냅니다. 네이버 스마트알림 규격에 맞춘 템플릿 기반 정보성 메시지입니다.
 * <p>수신번호 규칙(<code>destinations[].to</code>): 11자리 휴대폰 번호입니다(예: <code>01000000000</code>).
 *
 * <p>Sent as {@code messageFlow[].navertalk}.
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
@JsonDeserialize(builder = NaverTalkMessage.Builder.class)
@JsonPropertyOrder({"partnerKey", "templateCode", "productCode", "userName", "text", "templateParams", "attachments", "groupKey"})
public final class NaverTalkMessage implements ChannelMessage {

    /** {@code messageFlow} channel key of this message. */
    public static final String CHANNEL_KEY = "navertalk";

    private final String partnerKey;
    private final String templateCode;
    private final String productCode;
    private final String userName;
    private final String text;
    private final Map<String, String> templateParams;
    private final NaverTalkAttachments attachments;
    private final String groupKey;

    private NaverTalkMessage(Builder builder) {
        this.partnerKey = builder.partnerKey;
        this.templateCode = builder.templateCode;
        this.productCode = builder.productCode;
        this.userName = builder.userName;
        this.text = builder.text;
        this.templateParams = builder.templateParams == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.templateParams));
        this.attachments = builder.attachments;
        this.groupKey = builder.groupKey;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.partnerKey = this.partnerKey;
        builder.templateCode = this.templateCode;
        builder.productCode = this.productCode;
        builder.userName = this.userName;
        builder.text = this.text;
        builder.templateParams = this.templateParams;
        builder.attachments = this.attachments;
        builder.groupKey = this.groupKey;
        return builder;
    }

    @Override
    public String channelKey() {
        return CHANNEL_KEY;
    }

    /**
     * 네이버 톡톡 파트너 키입니다(접수코드 A601).
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 원문 필드표는 partnerKey를 필수로 표시하지만, 리포트 코드 71005는 '파트너키나 발송그룹키(groupKey)가 반드시 있어야 합니다'로 둘 중 하나만 있어도 되는 것처럼 읽힙니다. 필드표(Part A)를 따라 필수로 둡니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("partnerKey")
    public String getPartnerKey() {
        return partnerKey;
    }

    /**
     * 네이버 톡톡 템플릿 코드입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateCode")
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 템플릿의 상품 코드입니다. 등록된 템플릿의 상품 코드와 같아야 합니다(접수코드 A602, 리포트 코드 71007). 원문 요청 예시 값은 <code>INFORMATION</code>이며, 전체 값 목록은 원문에 없습니다.
     *
     * <p>필수 · 알려진 값 <code>INFORMATION</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    /**
     * 전화번호 소유자의 실명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    /**
     * 템플릿 본문입니다. 최대 2,048자입니다.
     *
     * <p>최대 2048자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 템플릿 치환 변수입니다. 치환할 키-값 쌍을 넣습니다. 최대 150자입니다.
     *
     * <p><b>확인 필요:</b> 원문은 'max: 150 chars'만 적혀 있어 값 하나당 150자인지, 전체 합계 150자인지 불명확합니다. 값의 타입(문자열)도 원문에 명시되지 않았습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateParams")
    public Map<String, String> getTemplateParams() {
        return templateParams;
    }

    /**
     * {@code attachments}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachments")
    public NaverTalkAttachments getAttachments() {
        return attachments;
    }

    /**
     * 네이버 톡톡 발송 그룹입니다. 요청 최상위의 <code>groupKey</code>(메시지 인사이트 통계용)와는 다른 필드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupKey")
    public String getGroupKey() {
        return groupKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NaverTalkMessage)) {
            return false;
        }
        NaverTalkMessage other = (NaverTalkMessage) o;
        return Objects.equals(partnerKey, other.partnerKey)
                && Objects.equals(templateCode, other.templateCode)
                && Objects.equals(productCode, other.productCode)
                && Objects.equals(userName, other.userName)
                && Objects.equals(text, other.text)
                && Objects.equals(templateParams, other.templateParams)
                && Objects.equals(attachments, other.attachments)
                && Objects.equals(groupKey, other.groupKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerKey, templateCode, productCode, userName, text, templateParams, attachments, groupKey);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "NaverTalkMessage{", "}");
        if (partnerKey != null) {
            joiner.add("partnerKey=" + io.github.icommapi.bizgo.internal.Masking.length(partnerKey));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + templateCode);
        }
        if (productCode != null) {
            joiner.add("productCode=" + io.github.icommapi.bizgo.internal.Masking.length(productCode));
        }
        if (userName != null) {
            joiner.add("userName=" + io.github.icommapi.bizgo.internal.Masking.person(userName));
        }
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
        }
        if (templateParams != null) {
            joiner.add("templateParams=***");
        }
        if (attachments != null) {
            joiner.add("attachments=" + attachments);
        }
        if (groupKey != null) {
            joiner.add("groupKey=" + io.github.icommapi.bizgo.internal.Masking.length(groupKey));
        }
        return joiner.toString();
    }

    /** Builder for {@link NaverTalkMessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String partnerKey;
        private String templateCode;
        private String productCode;
        private String userName;
        private String text;
        private Map<String, String> templateParams;
        private NaverTalkAttachments attachments;
        private String groupKey;

        /** Creates an empty builder; same as {@link NaverTalkMessage#builder()}. */
        public Builder() {
        }

        /**
         * 네이버 톡톡 파트너 키입니다(접수코드 A601).
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 원문 필드표는 partnerKey를 필수로 표시하지만, 리포트 코드 71005는 '파트너키나 발송그룹키(groupKey)가 반드시 있어야 합니다'로 둘 중 하나만 있어도 되는 것처럼 읽힙니다. 필드표(Part A)를 따라 필수로 둡니다.
         *
         * @param partnerKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("partnerKey")
        public Builder partnerKey(String partnerKey) {
            this.partnerKey = partnerKey;
            return this;
        }

        /**
         * 네이버 톡톡 템플릿 코드입니다.
         *
         * <p>필수
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
         * 템플릿의 상품 코드입니다. 등록된 템플릿의 상품 코드와 같아야 합니다(접수코드 A602, 리포트 코드 71007). 원문 요청 예시 값은 <code>INFORMATION</code>이며, 전체 값 목록은 원문에 없습니다.
         *
         * <p>필수 · 알려진 값 <code>INFORMATION</code>
         *
         * @param productCode the value (null clears it)
         * @return this builder
         */
        @JsonProperty("productCode")
        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        /**
         * 전화번호 소유자의 실명입니다.
         *
         * @param userName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("userName")
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        /**
         * 템플릿 본문입니다. 최대 2,048자입니다.
         *
         * <p>최대 2048자
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
         * 템플릿 치환 변수입니다. 치환할 키-값 쌍을 넣습니다. 최대 150자입니다.
         *
         * <p><b>확인 필요:</b> 원문은 'max: 150 chars'만 적혀 있어 값 하나당 150자인지, 전체 합계 150자인지 불명확합니다. 값의 타입(문자열)도 원문에 명시되지 않았습니다.
         *
         * @param templateParams the value (null clears it)
         * @return this builder
         */
        @JsonProperty("templateParams")
        public Builder templateParams(Map<String, String> templateParams) {
            this.templateParams = templateParams;
            return this;
        }

        /**
         * {@code attachments}.
         *
         * @param attachments the value (null clears it)
         * @return this builder
         */
        @JsonProperty("attachments")
        public Builder attachments(NaverTalkAttachments attachments) {
            this.attachments = attachments;
            return this;
        }

        /**
         * 네이버 톡톡 발송 그룹입니다. 요청 최상위의 <code>groupKey</code>(메시지 인사이트 통계용)와는 다른 필드입니다.
         *
         * @param groupKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("groupKey")
        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code NaverTalkMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public NaverTalkMessage build() {
            NaverTalkMessage built = new NaverTalkMessage(this);
            ModelValidator v = new ModelValidator("NaverTalkMessage");
            v.required("partnerKey", built.partnerKey);
            v.required("templateCode", built.templateCode);
            v.required("productCode", built.productCode);
            v.maxLength("text", built.text, 2048);
            v.mapValues("templateParams", built.templateParams, true);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        NaverTalkMessage buildUnvalidated() {
            return new NaverTalkMessage(this);
        }
    }
}
