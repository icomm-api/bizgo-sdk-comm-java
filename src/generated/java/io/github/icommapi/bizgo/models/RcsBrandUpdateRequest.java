// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.github.icommapi.bizgo.FileUpload;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 브랜드 수정 요청(multipart/form-data)입니다. <code>regBrand</code>는 JSON 문자열 파트로 보냅니다.
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
@JsonDeserialize(builder = RcsBrandUpdateRequest.Builder.class)
@JsonPropertyOrder({"brandId", "regBrand", "brandProfile", "brandBackground", "seasonDocFile"})
public final class RcsBrandUpdateRequest {

    private final String brandId;
    private final String regBrand;
    private final FileUpload brandProfile;
    private final FileUpload brandBackground;
    private final FileUpload seasonDocFile;

    private RcsBrandUpdateRequest(Builder builder) {
        this.brandId = builder.brandId;
        this.regBrand = builder.regBrand;
        this.brandProfile = builder.brandProfile;
        this.brandBackground = builder.brandBackground;
        this.seasonDocFile = builder.seasonDocFile;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.brandId = this.brandId;
        builder.regBrand = this.regBrand;
        builder.brandProfile = this.brandProfile;
        builder.brandBackground = this.brandBackground;
        builder.seasonDocFile = this.seasonDocFile;
        return builder;
    }

    /**
     * 수정할 브랜드 ID입니다.
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
     * 브랜드 수정 정보입니다. JSON으로 직렬화해 한 파트로 보냅니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> regBrand.brandId·name이 필수로 표시되어 있으나 문서 요청 예시에는 brandId가 없습니다. 또 registerDate·approvalDate·status·approvalReason처럼 서버가 정하는 값도 요청 필드로 나열되어 있어 실제로 반영되는지 불명확합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("regBrand")
    public String getRegBrand() {
        return regBrand;
    }

    /**
     * 브랜드 프로필 이미지 파일입니다.
     *
     * <p><b>확인 필요:</b> 허용 형식·용량·크기가 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandProfile")
    public FileUpload getBrandProfile() {
        return brandProfile;
    }

    /**
     * 브랜드 배경 이미지 파일입니다.
     *
     * <p><b>확인 필요:</b> 허용 형식·용량·크기가 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandBackground")
    public FileUpload getBrandBackground() {
        return brandBackground;
    }

    /**
     * 시즌성 증빙 파일입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("seasonDocFile")
    public FileUpload getSeasonDocFile() {
        return seasonDocFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsBrandUpdateRequest)) {
            return false;
        }
        RcsBrandUpdateRequest other = (RcsBrandUpdateRequest) o;
        return Objects.equals(brandId, other.brandId)
                && Objects.equals(regBrand, other.regBrand)
                && Objects.equals(brandProfile, other.brandProfile)
                && Objects.equals(brandBackground, other.brandBackground)
                && Objects.equals(seasonDocFile, other.seasonDocFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, regBrand, brandProfile, brandBackground, seasonDocFile);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsBrandUpdateRequest{", "}");
        if (brandId != null) {
            joiner.add("brandId=" + io.github.icommapi.bizgo.internal.Masking.length(brandId));
        }
        if (regBrand != null) {
            joiner.add("regBrand=" + io.github.icommapi.bizgo.internal.Masking.length(regBrand));
        }
        if (brandProfile != null) {
            joiner.add("brandProfile=***");
        }
        if (brandBackground != null) {
            joiner.add("brandBackground=***");
        }
        if (seasonDocFile != null) {
            joiner.add("seasonDocFile=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsBrandUpdateRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String brandId;
        private String regBrand;
        private FileUpload brandProfile;
        private FileUpload brandBackground;
        private FileUpload seasonDocFile;

        /** Creates an empty builder; same as {@link RcsBrandUpdateRequest#builder()}. */
        public Builder() {
        }

        /**
         * 수정할 브랜드 ID입니다.
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
         * 브랜드 수정 정보입니다. JSON으로 직렬화해 한 파트로 보냅니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> regBrand.brandId·name이 필수로 표시되어 있으나 문서 요청 예시에는 brandId가 없습니다. 또 registerDate·approvalDate·status·approvalReason처럼 서버가 정하는 값도 요청 필드로 나열되어 있어 실제로 반영되는지 불명확합니다.
         *
         * @param regBrand the value (null clears it)
         * @return this builder
         */
        @JsonProperty("regBrand")
        public Builder regBrand(String regBrand) {
            this.regBrand = regBrand;
            return this;
        }

        /**
         * 브랜드 프로필 이미지 파일입니다.
         *
         * <p><b>확인 필요:</b> 허용 형식·용량·크기가 문서화되어 있지 않습니다.
         *
         * @param brandProfile the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandProfile")
        public Builder brandProfile(FileUpload brandProfile) {
            this.brandProfile = brandProfile;
            return this;
        }

        /**
         * 브랜드 배경 이미지 파일입니다.
         *
         * <p><b>확인 필요:</b> 허용 형식·용량·크기가 문서화되어 있지 않습니다.
         *
         * @param brandBackground the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandBackground")
        public Builder brandBackground(FileUpload brandBackground) {
            this.brandBackground = brandBackground;
            return this;
        }

        /**
         * 시즌성 증빙 파일입니다.
         *
         * @param seasonDocFile the value (null clears it)
         * @return this builder
         */
        @JsonProperty("seasonDocFile")
        public Builder seasonDocFile(FileUpload seasonDocFile) {
            this.seasonDocFile = seasonDocFile;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsBrandUpdateRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsBrandUpdateRequest build() {
            RcsBrandUpdateRequest built = new RcsBrandUpdateRequest(this);
            ModelValidator v = new ModelValidator("RcsBrandUpdateRequest");
            v.required("brandId", built.brandId);
            v.required("regBrand", built.regBrand);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsBrandUpdateRequest buildUnvalidated() {
            return new RcsBrandUpdateRequest(this);
        }
    }
}
