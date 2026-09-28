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
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * CounselFileUploadRequest.
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
@JsonDeserialize(builder = CounselFileUploadRequest.Builder.class)
@JsonPropertyOrder({"file", "fileKey", "imageName", "senderKey", "fileType"})
public final class CounselFileUploadRequest {
    private static final List<String> FILE_TYPE_VALUES = List.of("file", "audio", "video");

    private final FileUpload file;
    private final String fileKey;
    private final String imageName;
    private final String senderKey;
    private final String fileType;

    private CounselFileUploadRequest(Builder builder) {
        this.file = builder.file;
        this.fileKey = builder.fileKey;
        this.imageName = builder.imageName;
        this.senderKey = builder.senderKey;
        this.fileType = builder.fileType;
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
        builder.fileType = this.fileType;
        return builder;
    }

    /**
     * 업로드할 파일 바이너리입니다. 운영 환경은 최대 300MB, 샌드박스는 최대 10MB입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 용량 상한(300MB/10MB)은 한국어 페이지(Part A)에만 있고, 허용 확장자와 MB 기준(10^6/2^20 byte)이 문서에 없습니다.
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
     * 파일 타입입니다. <code>file</code>은 일반 파일, <code>audio</code>는 오디오 파일, <code>video</code>는 비디오 파일입니다.
     *
     * <p>허용 값 <code>file</code>, <code>audio</code>, <code>video</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileType")
    public String getFileType() {
        return fileType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselFileUploadRequest)) {
            return false;
        }
        CounselFileUploadRequest other = (CounselFileUploadRequest) o;
        return Objects.equals(file, other.file)
                && Objects.equals(fileKey, other.fileKey)
                && Objects.equals(imageName, other.imageName)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(fileType, other.fileType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, fileKey, imageName, senderKey, fileType);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselFileUploadRequest{", "}");
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
        if (fileType != null) {
            joiner.add("fileType=" + io.github.icommapi.bizgo.internal.Masking.length(fileType));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselFileUploadRequest}. */
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
        private String fileType;

        /** Creates an empty builder; same as {@link CounselFileUploadRequest#builder()}. */
        public Builder() {
        }

        /**
         * 업로드할 파일 바이너리입니다. 운영 환경은 최대 300MB, 샌드박스는 최대 10MB입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 용량 상한(300MB/10MB)은 한국어 페이지(Part A)에만 있고, 허용 확장자와 MB 기준(10^6/2^20 byte)이 문서에 없습니다.
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
         * 파일 타입입니다. <code>file</code>은 일반 파일, <code>audio</code>는 오디오 파일, <code>video</code>는 비디오 파일입니다.
         *
         * <p>허용 값 <code>file</code>, <code>audio</code>, <code>video</code>
         *
         * @param fileType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fileType")
        public Builder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselFileUploadRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselFileUploadRequest build() {
            CounselFileUploadRequest built = new CounselFileUploadRequest(this);
            ModelValidator v = new ModelValidator("CounselFileUploadRequest");
            v.required("file", built.file);
            v.required("senderKey", built.senderKey);
            v.oneOf("fileType", built.fileType, FILE_TYPE_VALUES);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselFileUploadRequest buildUnvalidated() {
            return new CounselFileUploadRequest(this);
        }
    }
}
