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
 * CounselImageUploadRequest.
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
@JsonDeserialize(builder = CounselImageUploadRequest.Builder.class)
@JsonPropertyOrder({"file", "fileKey", "imageName", "senderKey", "imageType"})
public final class CounselImageUploadRequest {

    private final FileUpload file;
    private final String fileKey;
    private final String imageName;
    private final String senderKey;
    private final String imageType;

    private CounselImageUploadRequest(Builder builder) {
        this.file = builder.file;
        this.fileKey = builder.fileKey;
        this.imageName = builder.imageName;
        this.senderKey = builder.senderKey;
        this.imageType = builder.imageType;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.file = this.file;
        builder.fileKey = this.fileKey;
        builder.imageName = this.imageName;
        builder.senderKey = this.senderKey;
        builder.imageType = this.imageType;
        return builder;
    }

    /**
     * 업로드할 상담톡 이미지 파일입니다. jpg, png, gif 형식, 최대 5MB입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("file")
    public FileUpload getFile() {
        return file;
    }

    /**
     * 업로드 파일을 식별하는 키입니다. 생략하면 서버가 자동으로 생성합니다.
     *
     * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없는 필드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileKey")
    public String getFileKey() {
        return fileKey;
    }

    /**
     * 업로드 파일의 이름입니다. 생략하면 확장자를 제외한 파일명을 사용합니다.
     *
     * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없는 필드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageName")
    public String getImageName() {
        return imageName;
    }

    /**
     * 카카오 비즈메시지 발신프로필 키입니다.
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
     * 이미지 타입입니다. Rich 메시지 이미지 업로드 시 <code>rich</code>를 입력합니다.
     *
     * <p>알려진 값 <code>rich</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageType")
    public String getImageType() {
        return imageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselImageUploadRequest)) {
            return false;
        }
        CounselImageUploadRequest other = (CounselImageUploadRequest) o;
        return Objects.equals(file, other.file)
                && Objects.equals(fileKey, other.fileKey)
                && Objects.equals(imageName, other.imageName)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(imageType, other.imageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, fileKey, imageName, senderKey, imageType);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselImageUploadRequest{", "}");
        if (file != null) {
            joiner.add("file=***");
        }
        if (fileKey != null) {
            joiner.add("fileKey=" + fileKey);
        }
        if (imageName != null) {
            joiner.add("imageName=" + io.github.icommapi.bizgo.internal.Masking.length(imageName));
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (imageType != null) {
            joiner.add("imageType=" + io.github.icommapi.bizgo.internal.Masking.length(imageType));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselImageUploadRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private FileUpload file;
        private String fileKey;
        private String imageName;
        private String senderKey;
        private String imageType;

        /** Creates an empty builder; same as {@link CounselImageUploadRequest#builder()}. */
        public Builder() {
        }

        /**
         * 업로드할 상담톡 이미지 파일입니다. jpg, png, gif 형식, 최대 5MB입니다.
         *
         * <p>필수
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
         * 업로드 파일을 식별하는 키입니다. 생략하면 서버가 자동으로 생성합니다.
         *
         * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없는 필드입니다.
         *
         * @param fileKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fileKey")
        public Builder fileKey(String fileKey) {
            this.fileKey = fileKey;
            return this;
        }

        /**
         * 업로드 파일의 이름입니다. 생략하면 확장자를 제외한 파일명을 사용합니다.
         *
         * <p><b>확인 필요:</b> 한국어 페이지(Part A)에만 있고 Copy Markdown(Part B)에는 없는 필드입니다.
         *
         * @param imageName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imageName")
        public Builder imageName(String imageName) {
            this.imageName = imageName;
            return this;
        }

        /**
         * 카카오 비즈메시지 발신프로필 키입니다.
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
         * 이미지 타입입니다. Rich 메시지 이미지 업로드 시 <code>rich</code>를 입력합니다.
         *
         * <p>알려진 값 <code>rich</code>
         *
         * @param imageType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imageType")
        public Builder imageType(String imageType) {
            this.imageType = imageType;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselImageUploadRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselImageUploadRequest build() {
            CounselImageUploadRequest built = new CounselImageUploadRequest(this);
            ModelValidator v = new ModelValidator("CounselImageUploadRequest");
            v.required("file", built.file);
            v.required("senderKey", built.senderKey);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselImageUploadRequest buildUnvalidated() {
            return new CounselImageUploadRequest(this);
        }
    }
}
