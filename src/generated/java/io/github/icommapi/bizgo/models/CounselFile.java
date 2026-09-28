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

/**
 * 상담톡 파일 첨부 정보입니다(VIDEO·AUDIO·FILE 타입).
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
@JsonDeserialize(builder = CounselFile.Builder.class)
@JsonPropertyOrder({"fileUrl", "fileName", "fileSize"})
public final class CounselFile {

    private final String fileUrl;
    private final String fileName;
    private final String fileSize;

    private CounselFile(Builder builder) {
        this.fileUrl = builder.fileUrl;
        this.fileName = builder.fileName;
        this.fileSize = builder.fileSize;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.fileUrl = this.fileUrl;
        builder.fileName = this.fileName;
        builder.fileSize = this.fileSize;
        return builder;
    }

    /**
     * 상담톡 파일 업로드 API(<code>/api/comm/v1/file/cstalk</code>)로 등록한 파일 URL입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileUrl")
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 파일명입니다. <code>msgType</code>이 <code>FILE</code>이면 필수입니다(<code>CounselPlainMessageRequest</code>의 <code>x-sdk-required-if</code>).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    /**
     * 파일 크기입니다. <code>msgType</code>이 <code>FILE</code>이면 필수입니다(<code>CounselPlainMessageRequest</code>의 <code>x-sdk-required-if</code>). 문서상 타입은 문자열입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileSize")
    public String getFileSize() {
        return fileSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselFile)) {
            return false;
        }
        CounselFile other = (CounselFile) o;
        return Objects.equals(fileUrl, other.fileUrl)
                && Objects.equals(fileName, other.fileName)
                && Objects.equals(fileSize, other.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileUrl, fileName, fileSize);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselFile{", "}");
        if (fileUrl != null) {
            joiner.add("fileUrl=" + io.github.icommapi.bizgo.internal.Masking.length(fileUrl));
        }
        if (fileName != null) {
            joiner.add("fileName=" + io.github.icommapi.bizgo.internal.Masking.length(fileName));
        }
        if (fileSize != null) {
            joiner.add("fileSize=" + io.github.icommapi.bizgo.internal.Masking.length(fileSize));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselFile}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String fileUrl;
        private String fileName;
        private String fileSize;

        /** Creates an empty builder; same as {@link CounselFile#builder()}. */
        public Builder() {
        }

        /**
         * 상담톡 파일 업로드 API(<code>/api/comm/v1/file/cstalk</code>)로 등록한 파일 URL입니다.
         *
         * <p>필수
         *
         * @param fileUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fileUrl")
        public Builder fileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        /**
         * 파일명입니다. <code>msgType</code>이 <code>FILE</code>이면 필수입니다(<code>CounselPlainMessageRequest</code>의 <code>x-sdk-required-if</code>).
         *
         * @param fileName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fileName")
        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /**
         * 파일 크기입니다. <code>msgType</code>이 <code>FILE</code>이면 필수입니다(<code>CounselPlainMessageRequest</code>의 <code>x-sdk-required-if</code>). 문서상 타입은 문자열입니다.
         *
         * @param fileSize the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fileSize")
        public Builder fileSize(String fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselFile}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselFile build() {
            CounselFile built = new CounselFile(this);
            ModelValidator v = new ModelValidator("CounselFile");
            v.required("fileUrl", built.fileUrl);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselFile buildUnvalidated() {
            return new CounselFile(this);
        }
    }
}
