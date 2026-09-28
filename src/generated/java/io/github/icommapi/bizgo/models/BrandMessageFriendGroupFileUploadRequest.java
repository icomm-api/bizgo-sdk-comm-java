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
 * BrandMessageFriendGroupFileUploadRequest.
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
@JsonDeserialize(builder = BrandMessageFriendGroupFileUploadRequest.Builder.class)
@JsonPropertyOrder({"senderKey", "file"})
public final class BrandMessageFriendGroupFileUploadRequest {

    private final String senderKey;
    private final FileUpload file;

    private BrandMessageFriendGroupFileUploadRequest(Builder builder) {
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
     * 발신프로필 키입니다.
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
     * 업로드할 전화번호 목록 파일입니다. 줄바꿈으로 구분한 전화번호 파일이며 txt, csv만 허용됩니다.
     *
     * <p>필수
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
        if (!(o instanceof BrandMessageFriendGroupFileUploadRequest)) {
            return false;
        }
        BrandMessageFriendGroupFileUploadRequest other = (BrandMessageFriendGroupFileUploadRequest) o;
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
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageFriendGroupFileUploadRequest{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (file != null) {
            joiner.add("file=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageFriendGroupFileUploadRequest}. */
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

        /** Creates an empty builder; same as {@link BrandMessageFriendGroupFileUploadRequest#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다.
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
         * 업로드할 전화번호 목록 파일입니다. 줄바꿈으로 구분한 전화번호 파일이며 txt, csv만 허용됩니다.
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
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageFriendGroupFileUploadRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageFriendGroupFileUploadRequest build() {
            BrandMessageFriendGroupFileUploadRequest built = new BrandMessageFriendGroupFileUploadRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageFriendGroupFileUploadRequest");
            v.required("senderKey", built.senderKey);
            v.required("file", built.file);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageFriendGroupFileUploadRequest buildUnvalidated() {
            return new BrandMessageFriendGroupFileUploadRequest(this);
        }
    }
}
