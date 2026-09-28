// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 동영상 업로드 등록(업로드 채널 발급) 요청입니다.
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
@JsonDeserialize(builder = BrandMessageVideoUploadRegisterRequest.Builder.class)
@JsonPropertyOrder({"senderKey", "fileName", "fileSize"})
public final class BrandMessageVideoUploadRegisterRequest {

    private final String senderKey;
    private final String fileName;
    private final Long fileSize;

    private BrandMessageVideoUploadRegisterRequest(Builder builder) {
        this.senderKey = builder.senderKey;
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
        builder.senderKey = this.senderKey;
        builder.fileName = this.fileName;
        builder.fileSize = this.fileSize;
        return builder;
    }

    /**
     * Parse and validate a request written with the API field names (JSON).
     * Unknown fields are rejected so that typos fail before anything is sent.
     *
     * @param json request body, for example an example from the API reference
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageVideoUploadRegisterRequest fromJson(String json) {
        return RequestParser.parse(json, BrandMessageVideoUploadRegisterRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageVideoUploadRegisterRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, BrandMessageVideoUploadRegisterRequest.class);
    }

    /**
     * The JSON body that is sent. Contains phone numbers: do not log it.
     *
     * @return JSON with only the fields that were set
     */
    public String toJson() {
        return RequestParser.toJson(this);
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
     * 업로드할 동영상 파일 이름입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    /**
     * 업로드할 동영상 파일 크기(byte)입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 문서 타입이 Number로만 표기되어 정수 여부와 최대 용량을 알 수 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileSize")
    public Long getFileSize() {
        return fileSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageVideoUploadRegisterRequest)) {
            return false;
        }
        BrandMessageVideoUploadRegisterRequest other = (BrandMessageVideoUploadRegisterRequest) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(fileName, other.fileName)
                && Objects.equals(fileSize, other.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, fileName, fileSize);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageVideoUploadRegisterRequest{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (fileName != null) {
            joiner.add("fileName=" + io.github.icommapi.bizgo.internal.Masking.length(fileName));
        }
        if (fileSize != null) {
            joiner.add("fileSize=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageVideoUploadRegisterRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String fileName;
        private Long fileSize;

        /** Creates an empty builder; same as {@link BrandMessageVideoUploadRegisterRequest#builder()}. */
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
         * 업로드할 동영상 파일 이름입니다.
         *
         * <p>필수
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
         * 업로드할 동영상 파일 크기(byte)입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 문서 타입이 Number로만 표기되어 정수 여부와 최대 용량을 알 수 없습니다.
         *
         * @param fileSize the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fileSize")
        public Builder fileSize(Long fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageVideoUploadRegisterRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageVideoUploadRegisterRequest build() {
            BrandMessageVideoUploadRegisterRequest built = new BrandMessageVideoUploadRegisterRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageVideoUploadRegisterRequest");
            v.required("senderKey", built.senderKey);
            v.maxLength("senderKey", built.senderKey, 40);
            v.required("fileName", built.fileName);
            v.required("fileSize", built.fileSize);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageVideoUploadRegisterRequest buildUnvalidated() {
            return new BrandMessageVideoUploadRegisterRequest(this);
        }
    }
}
