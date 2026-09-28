// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.regex.Pattern;

/**
 * 네이버 톡톡 쿠폰 정보 객체입니다(접수코드 A608).
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
@JsonDeserialize(builder = NaverTalkGift.Builder.class)
@JsonPropertyOrder({"code", "imageUrl", "endDate", "name", "publisher", "couponDescription", "label", "value"})
public final class NaverTalkGift {
    private static final Pattern END_DATE_PATTERN = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");

    private final String code;
    private final String imageUrl;
    private final String endDate;
    private final String name;
    private final String publisher;
    private final String couponDescription;
    private final String label;
    private final String value;

    private NaverTalkGift(Builder builder) {
        this.code = builder.code;
        this.imageUrl = builder.imageUrl;
        this.endDate = builder.endDate;
        this.name = builder.name;
        this.publisher = builder.publisher;
        this.couponDescription = builder.couponDescription;
        this.label = builder.label;
        this.value = builder.value;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.code = this.code;
        builder.imageUrl = this.imageUrl;
        builder.endDate = this.endDate;
        builder.name = this.name;
        builder.publisher = this.publisher;
        builder.couponDescription = this.couponDescription;
        builder.label = this.label;
        builder.value = this.value;
        return builder;
    }

    /**
     * 쿠폰 코드입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 쿠폰 이미지 URL입니다. 쿠폰을 첨부하면 반드시 필요합니다(리포트 코드 72106).
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 쿠폰 종료일입니다. 오늘 이후 날짜를 <code>YYYY-MM-DD</code> 형식으로 입력합니다(리포트 코드 72107).
     *
     * <p>필수 · 형식 <code>^[0-9]&#123;4&#125;-[0-9]&#123;2&#125;-[0-9]&#123;2&#125;$</code> · 형식 <code>YYYY-MM-DD</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    /**
     * 쿠폰 이름입니다. 생략하면 템플릿에 등록된 이름으로 발송됩니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 쿠폰 발급자입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     * 쿠폰 설명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("couponDescription")
    public String getCouponDescription() {
        return couponDescription;
    }

    /**
     * 쿠폰 라벨입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * 쿠폰 내용입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NaverTalkGift)) {
            return false;
        }
        NaverTalkGift other = (NaverTalkGift) o;
        return Objects.equals(code, other.code)
                && Objects.equals(imageUrl, other.imageUrl)
                && Objects.equals(endDate, other.endDate)
                && Objects.equals(name, other.name)
                && Objects.equals(publisher, other.publisher)
                && Objects.equals(couponDescription, other.couponDescription)
                && Objects.equals(label, other.label)
                && Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, imageUrl, endDate, name, publisher, couponDescription, label, value);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "NaverTalkGift{", "}");
        if (code != null) {
            joiner.add("code=" + code);
        }
        if (imageUrl != null) {
            joiner.add("imageUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imageUrl));
        }
        if (endDate != null) {
            joiner.add("endDate=" + io.github.icommapi.bizgo.internal.Masking.length(endDate));
        }
        if (name != null) {
            joiner.add("name=" + io.github.icommapi.bizgo.internal.Masking.length(name));
        }
        if (publisher != null) {
            joiner.add("publisher=" + io.github.icommapi.bizgo.internal.Masking.length(publisher));
        }
        if (couponDescription != null) {
            joiner.add("couponDescription=" + io.github.icommapi.bizgo.internal.Masking.length(couponDescription));
        }
        if (label != null) {
            joiner.add("label=" + io.github.icommapi.bizgo.internal.Masking.length(label));
        }
        if (value != null) {
            joiner.add("value=" + io.github.icommapi.bizgo.internal.Masking.length(value));
        }
        return joiner.toString();
    }

    /** Builder for {@link NaverTalkGift}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String code;
        private String imageUrl;
        private String endDate;
        private String name;
        private String publisher;
        private String couponDescription;
        private String label;
        private String value;

        /** Creates an empty builder; same as {@link NaverTalkGift#builder()}. */
        public Builder() {
        }

        /**
         * 쿠폰 코드입니다.
         *
         * <p>필수
         *
         * @param code the value (null clears it)
         * @return this builder
         */
        @JsonProperty("code")
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * 쿠폰 이미지 URL입니다. 쿠폰을 첨부하면 반드시 필요합니다(리포트 코드 72106).
         *
         * <p>필수
         *
         * @param imageUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imageUrl")
        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        /**
         * 쿠폰 종료일입니다. 오늘 이후 날짜를 <code>YYYY-MM-DD</code> 형식으로 입력합니다(리포트 코드 72107).
         *
         * <p>필수 · 형식 <code>^[0-9]&#123;4&#125;-[0-9]&#123;2&#125;-[0-9]&#123;2&#125;$</code> · 형식 <code>YYYY-MM-DD</code>
         *
         * @param endDate the value (null clears it)
         * @return this builder
         */
        @JsonProperty("endDate")
        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        /**
         * 쿠폰 이름입니다. 생략하면 템플릿에 등록된 이름으로 발송됩니다.
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
         * 쿠폰 발급자입니다.
         *
         * @param publisher the value (null clears it)
         * @return this builder
         */
        @JsonProperty("publisher")
        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * 쿠폰 설명입니다.
         *
         * @param couponDescription the value (null clears it)
         * @return this builder
         */
        @JsonProperty("couponDescription")
        public Builder couponDescription(String couponDescription) {
            this.couponDescription = couponDescription;
            return this;
        }

        /**
         * 쿠폰 라벨입니다.
         *
         * @param label the value (null clears it)
         * @return this builder
         */
        @JsonProperty("label")
        public Builder label(String label) {
            this.label = label;
            return this;
        }

        /**
         * 쿠폰 내용입니다.
         *
         * @param value the value (null clears it)
         * @return this builder
         */
        @JsonProperty("value")
        public Builder value(String value) {
            this.value = value;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code NaverTalkGift}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public NaverTalkGift build() {
            NaverTalkGift built = new NaverTalkGift(this);
            ModelValidator v = new ModelValidator("NaverTalkGift");
            v.required("code", built.code);
            v.required("imageUrl", built.imageUrl);
            v.required("endDate", built.endDate);
            v.pattern("endDate", built.endDate, END_DATE_PATTERN);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        NaverTalkGift buildUnvalidated() {
            return new NaverTalkGift(this);
        }
    }
}
