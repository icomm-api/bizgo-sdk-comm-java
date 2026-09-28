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
 * 템플릿 본문 영역의 검증 파라미터 정의입니다.
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
@JsonDeserialize(builder = RcsTemplateBodyParam.Builder.class)
@JsonPropertyOrder({"param", "isMandatory", "type", "strSize", "imageWidth", "imageHeight"})
public final class RcsTemplateBodyParam {
    private static final Pattern PARAM_PATTERN = Pattern.compile("^[A-Za-z0-9_]+$");

    private final String param;
    private final String isMandatory;
    private final String type;
    private final String strSize;
    private final String imageWidth;
    private final String imageHeight;

    private RcsTemplateBodyParam(Builder builder) {
        this.param = builder.param;
        this.isMandatory = builder.isMandatory;
        this.type = builder.type;
        this.strSize = builder.strSize;
        this.imageWidth = builder.imageWidth;
        this.imageHeight = builder.imageHeight;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.param = this.param;
        builder.isMandatory = this.isMandatory;
        builder.type = this.type;
        builder.strSize = this.strSize;
        builder.imageWidth = this.imageWidth;
        builder.imageHeight = this.imageHeight;
        return builder;
    }

    /**
     * 검증 파라미터명입니다. 영문, 숫자, <code>_</code>만 쓸 수 있습니다(영문 문서 기준).
     *
     * <p>필수 · 형식 <code>^[A-Za-z0-9_]+$</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("param")
    public String getParam() {
        return param;
    }

    /**
     * 필수 여부입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 값 형식(Y/N, true/false 등)이 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("isMandatory")
    public String getIsMandatory() {
        return isMandatory;
    }

    /**
     * 기술 검증 타입입니다.
     *
     * <p><b>확인 필요:</b> 타입 값 목록이 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 문자열 최대 크기입니다. 문서상 문자열입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("strSize")
    public String getStrSize() {
        return strSize;
    }

    /**
     * 이미지 최소 가로 크기입니다. 문서상 문자열입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageWidth")
    public String getImageWidth() {
        return imageWidth;
    }

    /**
     * 이미지 최소 세로 크기입니다. 문서상 문자열입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageHeight")
    public String getImageHeight() {
        return imageHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsTemplateBodyParam)) {
            return false;
        }
        RcsTemplateBodyParam other = (RcsTemplateBodyParam) o;
        return Objects.equals(param, other.param)
                && Objects.equals(isMandatory, other.isMandatory)
                && Objects.equals(type, other.type)
                && Objects.equals(strSize, other.strSize)
                && Objects.equals(imageWidth, other.imageWidth)
                && Objects.equals(imageHeight, other.imageHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(param, isMandatory, type, strSize, imageWidth, imageHeight);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateBodyParam{", "}");
        if (param != null) {
            joiner.add("param=" + io.github.icommapi.bizgo.internal.Masking.length(param));
        }
        if (isMandatory != null) {
            joiner.add("isMandatory=" + io.github.icommapi.bizgo.internal.Masking.length(isMandatory));
        }
        if (type != null) {
            joiner.add("type=" + type);
        }
        if (strSize != null) {
            joiner.add("strSize=" + io.github.icommapi.bizgo.internal.Masking.length(strSize));
        }
        if (imageWidth != null) {
            joiner.add("imageWidth=" + io.github.icommapi.bizgo.internal.Masking.length(imageWidth));
        }
        if (imageHeight != null) {
            joiner.add("imageHeight=" + io.github.icommapi.bizgo.internal.Masking.length(imageHeight));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateBodyParam}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String param;
        private String isMandatory;
        private String type;
        private String strSize;
        private String imageWidth;
        private String imageHeight;

        /** Creates an empty builder; same as {@link RcsTemplateBodyParam#builder()}. */
        public Builder() {
        }

        /**
         * 검증 파라미터명입니다. 영문, 숫자, <code>_</code>만 쓸 수 있습니다(영문 문서 기준).
         *
         * <p>필수 · 형식 <code>^[A-Za-z0-9_]+$</code>
         *
         * @param param the value (null clears it)
         * @return this builder
         */
        @JsonProperty("param")
        public Builder param(String param) {
            this.param = param;
            return this;
        }

        /**
         * 필수 여부입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 값 형식(Y/N, true/false 등)이 문서화되어 있지 않습니다.
         *
         * @param isMandatory the value (null clears it)
         * @return this builder
         */
        @JsonProperty("isMandatory")
        public Builder isMandatory(String isMandatory) {
            this.isMandatory = isMandatory;
            return this;
        }

        /**
         * 기술 검증 타입입니다.
         *
         * <p><b>확인 필요:</b> 타입 값 목록이 문서화되어 있지 않습니다.
         *
         * @param type the value (null clears it)
         * @return this builder
         */
        @JsonProperty("type")
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 문자열 최대 크기입니다. 문서상 문자열입니다.
         *
         * @param strSize the value (null clears it)
         * @return this builder
         */
        @JsonProperty("strSize")
        public Builder strSize(String strSize) {
            this.strSize = strSize;
            return this;
        }

        /**
         * 이미지 최소 가로 크기입니다. 문서상 문자열입니다.
         *
         * @param imageWidth the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imageWidth")
        public Builder imageWidth(String imageWidth) {
            this.imageWidth = imageWidth;
            return this;
        }

        /**
         * 이미지 최소 세로 크기입니다. 문서상 문자열입니다.
         *
         * @param imageHeight the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imageHeight")
        public Builder imageHeight(String imageHeight) {
            this.imageHeight = imageHeight;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsTemplateBodyParam}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsTemplateBodyParam build() {
            RcsTemplateBodyParam built = new RcsTemplateBodyParam(this);
            ModelValidator v = new ModelValidator("RcsTemplateBodyParam");
            v.required("param", built.param);
            v.pattern("param", built.param, PARAM_PATTERN);
            v.required("isMandatory", built.isMandatory);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsTemplateBodyParam buildUnvalidated() {
            return new RcsTemplateBodyParam(this);
        }
    }
}
