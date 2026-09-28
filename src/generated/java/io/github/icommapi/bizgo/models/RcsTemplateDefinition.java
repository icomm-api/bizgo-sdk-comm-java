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

/**
 * 등록·수정할 RCS 템플릿 정보입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 템플릿 양식(messagebaseformId/formatId)을 지정하는 필드와, 수정 시 대상 템플릿(messagebaseId)을 지정하는 필드가 문서에 없습니다.
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
@JsonDeserialize(builder = RcsTemplateDefinition.Builder.class)
@JsonPropertyOrder({"brandId", "templateName", "body", "buttons"})
public final class RcsTemplateDefinition {

    private final String brandId;
    private final String templateName;
    private final List<RcsTemplateBodyParam> body;
    private final List<RcsTemplateButton> buttons;

    private RcsTemplateDefinition(Builder builder) {
        this.brandId = builder.brandId;
        this.templateName = builder.templateName;
        this.body = builder.body == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.body));
        this.buttons = builder.buttons == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.buttons));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.brandId = this.brandId;
        builder.templateName = this.templateName;
        builder.body = this.body;
        builder.buttons = this.buttons;
        return builder;
    }

    /**
     * 브랜드 ID입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandId")
    public String getBrandId() {
        return brandId;
    }

    /**
     * 템플릿 이름입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("templateName")
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 본문 영역 정의입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("body")
    public List<RcsTemplateBodyParam> getBody() {
        return body;
    }

    /**
     * 버튼 정의입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttons")
    public List<RcsTemplateButton> getButtons() {
        return buttons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateDefinition)) {
            return false;
        }
        RcsTemplateDefinition other = (RcsTemplateDefinition) o;
        return Objects.equals(brandId, other.brandId)
                && Objects.equals(templateName, other.templateName)
                && Objects.equals(body, other.body)
                && Objects.equals(buttons, other.buttons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, templateName, body, buttons);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateDefinition{", "}");
        if (brandId != null) {
            joiner.add("brandId=" + io.github.icommapi.bizgo.internal.Masking.length(brandId));
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
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateDefinition}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String brandId;
        private String templateName;
        private List<RcsTemplateBodyParam> body;
        private List<RcsTemplateButton> buttons;

        /** Creates an empty builder; same as {@link RcsTemplateDefinition#builder()}. */
        public Builder() {
        }

        /**
         * 브랜드 ID입니다.
         *
         * <p>필수
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
         * 템플릿 이름입니다.
         *
         * <p>필수
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
         * 본문 영역 정의입니다.
         *
         * <p>필수
         *
         * @param body the value (null clears it)
         * @return this builder
         */
        @JsonProperty("body")
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
         * 버튼 정의입니다.
         *
         * <p>필수
         *
         * @param buttons the value (null clears it)
         * @return this builder
         */
        @JsonProperty("buttons")
        public Builder buttons(List<RcsTemplateButton> buttons) {
            this.buttons = buttons;
            return this;
        }

        /**
         * Varargs form of {@link #buttons(List)}.
         *
         * @param buttons values
         * @return this builder
         */
        public Builder buttons(RcsTemplateButton... buttons) {
            this.buttons = buttons == null ? null : Arrays.asList(buttons);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateDefinition}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateDefinition build() {
            RcsTemplateDefinition built = new RcsTemplateDefinition(this);
            ModelValidator v = new ModelValidator("RcsTemplateDefinition");
            v.required("brandId", built.brandId);
            v.required("templateName", built.templateName);
            v.required("body", built.body);
            v.items("body", built.body, -1, -1);
            v.required("buttons", built.buttons);
            v.items("buttons", built.buttons, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateDefinition buildUnvalidated() {
            return new RcsTemplateDefinition(this);
        }
    }
}
