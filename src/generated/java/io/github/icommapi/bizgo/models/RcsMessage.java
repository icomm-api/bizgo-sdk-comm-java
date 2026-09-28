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
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.regex.Pattern;

/**
 * RCS 메시지입니다. 같은 <code>rcs</code> 키로 <b>통합 RCS</b>(iOS·안드로이드 동시 지원, 신규 연동 권장)와 <b>안드로이드 RCS</b>(기존 안드로이드 채팅+ 연동 규격 유지용)를 모두 발송합니다. <code>copyAllowed</code>, <code>header</code>, <code>footer</code>는 안드로이드 RCS 발송 문서에만 있는 필드입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 통합 RCS와 안드로이드 RCS를 요청에서 어떻게 구분하는지(formatId 등) 문서에 명시되어 있지 않습니다. copyAllowed/header/footer를 통합 RCS에 보냈을 때의 동작도 문서화되어 있지 않습니다.
 *
 * <p>Sent as {@code messageFlow[].rcs}.
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
@JsonDeserialize(builder = RcsMessage.Builder.class)
@JsonPropertyOrder({"from", "formatId", "brandKey", "body", "buttons", "brandId", "groupId", "expiryOption", "copyAllowed", "header", "footer", "agencyId", "agencyKey", "ttl"})
public final class RcsMessage implements ChannelMessage {

    /** {@code messageFlow} channel key of this message. */
    public static final String CHANNEL_KEY = "rcs";
    private static final List<String> EXPIRY_OPTION_VALUES = List.of("1", "2", "3", "4");
    private static final List<String> COPY_ALLOWED_VALUES = List.of("0", "1");
    private static final List<String> HEADER_VALUES = List.of("0", "1");
    private static final Pattern TTL_PATTERN = Pattern.compile("^[0-9]+$");

    private final String from;
    private final String formatId;
    private final String brandKey;
    private final RcsBody body;
    private final List<RcsButton> buttons;
    private final String brandId;
    private final String groupId;
    private final String expiryOption;
    private final String copyAllowed;
    private final String header;
    private final String footer;
    private final String agencyId;
    private final String agencyKey;
    private final String ttl;

    private RcsMessage(Builder builder) {
        this.from = builder.from;
        this.formatId = builder.formatId;
        this.brandKey = builder.brandKey;
        this.body = builder.body;
        this.buttons = builder.buttons == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.buttons));
        this.brandId = builder.brandId;
        this.groupId = builder.groupId;
        this.expiryOption = builder.expiryOption;
        this.copyAllowed = builder.copyAllowed;
        this.header = builder.header;
        this.footer = builder.footer;
        this.agencyId = builder.agencyId;
        this.agencyKey = builder.agencyKey;
        this.ttl = builder.ttl;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.from = this.from;
        builder.formatId = this.formatId;
        builder.brandKey = this.brandKey;
        builder.body = this.body;
        builder.buttons = this.buttons;
        builder.brandId = this.brandId;
        builder.groupId = this.groupId;
        builder.expiryOption = this.expiryOption;
        builder.copyAllowed = this.copyAllowed;
        builder.header = this.header;
        builder.footer = this.footer;
        builder.agencyId = this.agencyId;
        builder.agencyKey = this.agencyKey;
        builder.ttl = this.ttl;
        return builder;
    }

    @Override
    public String channelKey() {
        return CHANNEL_KEY;
    }

    /**
     * 발신번호입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * RCS 메시지 포맷(템플릿) ID입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("formatId")
    public String getFormatId() {
        return formatId;
    }

    /**
     * RCS 브랜드 식별 키입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandKey")
    public String getBrandKey() {
        return brandKey;
    }

    /**
     * {@code body}.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("body")
    public RcsBody getBody() {
        return body;
    }

    /**
     * RCS 버튼 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttons")
    public List<RcsButton> getButtons() {
        return buttons;
    }

    /**
     * RCS 브랜드 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandId")
    public String getBrandId() {
        return brandId;
    }

    /**
     * RCS 메시지 그룹 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupId")
    public String getGroupId() {
        return groupId;
    }

    /**
     * 전송 타임아웃 설정입니다. 기본값은 <code>1</code>입니다.
     * <ul>
     * <li><code>1</code>: 24시간</li>
     * <li><code>2</code>: 40초</li>
     * <li><code>3</code>: 3분 10초</li>
     * <li><code>4</code>: 1시간</li>
     * </ul>
     *
     * <p>허용 값 <code>1</code>, <code>2</code>, <code>3</code>, <code>4</code> · 서버 기본값 <code>1</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("expiryOption")
    public String getExpiryOption() {
        return expiryOption;
    }

    /**
     * (안드로이드 RCS) 메시지 복사 허용 여부입니다. <code>0</code>=허용 안 함, <code>1</code>=허용. 기본값은 <code>0</code>입니다.
     *
     * <p>허용 값 <code>0</code>, <code>1</code> · 서버 기본값 <code>0</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("copyAllowed")
    public String getCopyAllowed() {
        return copyAllowed;
    }

    /**
     * (안드로이드 RCS) 광고 표시 레이블 여부입니다. <code>0</code>=표시 안 함, <code>1</code>=표시. 기본값은 <code>0</code>입니다.
     *
     * <p>허용 값 <code>0</code>, <code>1</code> · 서버 기본값 <code>0</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * (안드로이드 RCS) 수신거부 번호입니다. <code>header</code>가 <code>1</code>이면 필수이며 최대 100자입니다.
     *
     * <p>최대 100자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("footer")
    public String getFooter() {
        return footer;
    }

    /**
     * 대행사 ID입니다. 기본값은 <code>infobank</code>입니다.
     *
     * <p>서버 기본값 <code>infobank</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("agencyId")
    public String getAgencyId() {
        return agencyId;
    }

    /**
     * 대행사 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("agencyKey")
    public String getAgencyKey() {
        return agencyKey;
    }

    /**
     * 메시지 유효 시간(초)입니다. 기본값은 <code>86400</code>입니다.
     *
     * <p>형식 <code>^[0-9]+$</code> · 서버 기본값 <code>86400</code>(설정하지 않으면 보내지 않음)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ttl")
    public String getTtl() {
        return ttl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsMessage)) {
            return false;
        }
        RcsMessage other = (RcsMessage) o;
        return Objects.equals(from, other.from)
                && Objects.equals(formatId, other.formatId)
                && Objects.equals(brandKey, other.brandKey)
                && Objects.equals(body, other.body)
                && Objects.equals(buttons, other.buttons)
                && Objects.equals(brandId, other.brandId)
                && Objects.equals(groupId, other.groupId)
                && Objects.equals(expiryOption, other.expiryOption)
                && Objects.equals(copyAllowed, other.copyAllowed)
                && Objects.equals(header, other.header)
                && Objects.equals(footer, other.footer)
                && Objects.equals(agencyId, other.agencyId)
                && Objects.equals(agencyKey, other.agencyKey)
                && Objects.equals(ttl, other.ttl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, formatId, brandKey, body, buttons, brandId, groupId, expiryOption, copyAllowed, header, footer, agencyId, agencyKey, ttl);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsMessage{", "}");
        if (from != null) {
            joiner.add("from=" + io.github.icommapi.bizgo.internal.Masking.phone(from));
        }
        if (formatId != null) {
            joiner.add("formatId=" + formatId);
        }
        if (brandKey != null) {
            joiner.add("brandKey=" + io.github.icommapi.bizgo.internal.Masking.length(brandKey));
        }
        if (body != null) {
            joiner.add("body=" + body);
        }
        if (buttons != null) {
            joiner.add("buttons=" + buttons);
        }
        if (brandId != null) {
            joiner.add("brandId=" + io.github.icommapi.bizgo.internal.Masking.length(brandId));
        }
        if (groupId != null) {
            joiner.add("groupId=" + io.github.icommapi.bizgo.internal.Masking.length(groupId));
        }
        if (expiryOption != null) {
            joiner.add("expiryOption=" + expiryOption);
        }
        if (copyAllowed != null) {
            joiner.add("copyAllowed=" + io.github.icommapi.bizgo.internal.Masking.length(copyAllowed));
        }
        if (header != null) {
            joiner.add("header=" + io.github.icommapi.bizgo.internal.Masking.length(header));
        }
        if (footer != null) {
            joiner.add("footer=" + io.github.icommapi.bizgo.internal.Masking.length(footer));
        }
        if (agencyId != null) {
            joiner.add("agencyId=" + io.github.icommapi.bizgo.internal.Masking.length(agencyId));
        }
        if (agencyKey != null) {
            joiner.add("agencyKey=" + io.github.icommapi.bizgo.internal.Masking.length(agencyKey));
        }
        if (ttl != null) {
            joiner.add("ttl=" + io.github.icommapi.bizgo.internal.Masking.length(ttl));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsMessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String from;
        private String formatId;
        private String brandKey;
        private RcsBody body;
        private List<RcsButton> buttons;
        private String brandId;
        private String groupId;
        private String expiryOption;
        private String copyAllowed;
        private String header;
        private String footer;
        private String agencyId;
        private String agencyKey;
        private String ttl;

        /** Creates an empty builder; same as {@link RcsMessage#builder()}. */
        public Builder() {
        }

        /**
         * 발신번호입니다.
         *
         * <p>필수
         *
         * @param from the value (null clears it)
         * @return this builder
         */
        @JsonProperty("from")
        public Builder from(String from) {
            this.from = from;
            return this;
        }

        /**
         * RCS 메시지 포맷(템플릿) ID입니다.
         *
         * <p>필수
         *
         * @param formatId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("formatId")
        public Builder formatId(String formatId) {
            this.formatId = formatId;
            return this;
        }

        /**
         * RCS 브랜드 식별 키입니다.
         *
         * <p>필수
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
         * {@code body}.
         *
         * <p>필수
         *
         * @param body the value (null clears it)
         * @return this builder
         */
        @JsonProperty("body")
        public Builder body(RcsBody body) {
            this.body = body;
            return this;
        }

        /**
         * RCS 버튼 목록입니다.
         *
         * @param buttons the value (null clears it)
         * @return this builder
         */
        @JsonProperty("buttons")
        public Builder buttons(List<RcsButton> buttons) {
            this.buttons = buttons;
            return this;
        }

        /**
         * Varargs form of {@link #buttons(List)}.
         *
         * @param buttons values
         * @return this builder
         */
        public Builder buttons(RcsButton... buttons) {
            this.buttons = buttons == null ? null : Arrays.asList(buttons);
            return this;
        }

        /**
         * RCS 브랜드 ID입니다.
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
         * RCS 메시지 그룹 ID입니다.
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
         * 전송 타임아웃 설정입니다. 기본값은 <code>1</code>입니다.
         * <ul>
         * <li><code>1</code>: 24시간</li>
         * <li><code>2</code>: 40초</li>
         * <li><code>3</code>: 3분 10초</li>
         * <li><code>4</code>: 1시간</li>
         * </ul>
         *
         * <p>허용 값 <code>1</code>, <code>2</code>, <code>3</code>, <code>4</code> · 서버 기본값 <code>1</code>(설정하지 않으면 보내지 않음)
         *
         * @param expiryOption the value (null clears it)
         * @return this builder
         */
        @JsonProperty("expiryOption")
        public Builder expiryOption(String expiryOption) {
            this.expiryOption = expiryOption;
            return this;
        }

        /**
         * (안드로이드 RCS) 메시지 복사 허용 여부입니다. <code>0</code>=허용 안 함, <code>1</code>=허용. 기본값은 <code>0</code>입니다.
         *
         * <p>허용 값 <code>0</code>, <code>1</code> · 서버 기본값 <code>0</code>(설정하지 않으면 보내지 않음)
         *
         * @param copyAllowed the value (null clears it)
         * @return this builder
         */
        @JsonProperty("copyAllowed")
        public Builder copyAllowed(String copyAllowed) {
            this.copyAllowed = copyAllowed;
            return this;
        }

        /**
         * (안드로이드 RCS) 광고 표시 레이블 여부입니다. <code>0</code>=표시 안 함, <code>1</code>=표시. 기본값은 <code>0</code>입니다.
         *
         * <p>허용 값 <code>0</code>, <code>1</code> · 서버 기본값 <code>0</code>(설정하지 않으면 보내지 않음)
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
         * (안드로이드 RCS) 수신거부 번호입니다. <code>header</code>가 <code>1</code>이면 필수이며 최대 100자입니다.
         *
         * <p>최대 100자
         *
         * @param footer the value (null clears it)
         * @return this builder
         */
        @JsonProperty("footer")
        public Builder footer(String footer) {
            this.footer = footer;
            return this;
        }

        /**
         * 대행사 ID입니다. 기본값은 <code>infobank</code>입니다.
         *
         * <p>서버 기본값 <code>infobank</code>(설정하지 않으면 보내지 않음)
         *
         * @param agencyId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("agencyId")
        public Builder agencyId(String agencyId) {
            this.agencyId = agencyId;
            return this;
        }

        /**
         * 대행사 키입니다.
         *
         * @param agencyKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("agencyKey")
        public Builder agencyKey(String agencyKey) {
            this.agencyKey = agencyKey;
            return this;
        }

        /**
         * 메시지 유효 시간(초)입니다. 기본값은 <code>86400</code>입니다.
         *
         * <p>형식 <code>^[0-9]+$</code> · 서버 기본값 <code>86400</code>(설정하지 않으면 보내지 않음)
         *
         * @param ttl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("ttl")
        public Builder ttl(String ttl) {
            this.ttl = ttl;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsMessage build() {
            RcsMessage built = new RcsMessage(this);
            ModelValidator v = new ModelValidator("RcsMessage");
            v.required("from", built.from);
            v.required("formatId", built.formatId);
            v.required("brandKey", built.brandKey);
            v.required("body", built.body);
            v.items("buttons", built.buttons, -1, -1);
            v.oneOf("expiryOption", built.expiryOption, EXPIRY_OPTION_VALUES);
            v.oneOf("copyAllowed", built.copyAllowed, COPY_ALLOWED_VALUES);
            v.oneOf("header", built.header, HEADER_VALUES);
            v.maxLength("footer", built.footer, 100);
            v.pattern("ttl", built.ttl, TTL_PATTERN);
            RequiredIf.checkObject(v, "RcsMessage", built); // x-sdk-required-if
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsMessage buildUnvalidated() {
            return new RcsMessage(this);
        }
    }
}
