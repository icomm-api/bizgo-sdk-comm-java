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
 * BrandMessageMarketingAgreeUploadRequest.
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
@JsonDeserialize(builder = BrandMessageMarketingAgreeUploadRequest.Builder.class)
@JsonPropertyOrder({"senderKey", "file"})
public final class BrandMessageMarketingAgreeUploadRequest {

    private final String senderKey;
    private final FileUpload file;

    private BrandMessageMarketingAgreeUploadRequest(Builder builder) {
        this.senderKey = builder.senderKey;
        this.file = builder.file;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.file = this.file;
        return builder;
    }

    /**
     * 발신프로필 키입니다. 최대 40자입니다.
     *
     * <p>필수 · 최대 40자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 업로드할 광고성 정보 수신동의 증적자료 파일입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 허용 파일 형식·용량이 문서에 없습니다(예시는 pdf).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("file")
    public FileUpload getFile() {
        return file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageMarketingAgreeUploadRequest)) {
            return false;
        }
        BrandMessageMarketingAgreeUploadRequest other = (BrandMessageMarketingAgreeUploadRequest) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(file, other.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, file);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageMarketingAgreeUploadRequest{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (file != null) {
            joiner.add("file=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageMarketingAgreeUploadRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private FileUpload file;

        /** Creates an empty builder; same as {@link BrandMessageMarketingAgreeUploadRequest#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다. 최대 40자입니다.
         *
         * <p>필수 · 최대 40자
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
         * 업로드할 광고성 정보 수신동의 증적자료 파일입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 허용 파일 형식·용량이 문서에 없습니다(예시는 pdf).
         *
         * @param file the value (null clears it)
         * @return this builder
         */
        @JsonProperty("file")
        public Builder file(FileUpload file) {
            this.file = file;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageMarketingAgreeUploadRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageMarketingAgreeUploadRequest build() {
            BrandMessageMarketingAgreeUploadRequest built = new BrandMessageMarketingAgreeUploadRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageMarketingAgreeUploadRequest");
            v.required("senderKey", built.senderKey);
            v.maxLength("senderKey", built.senderKey, 40);
            v.required("file", built.file);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageMarketingAgreeUploadRequest buildUnvalidated() {
            return new BrandMessageMarketingAgreeUploadRequest(this);
        }
    }
}
