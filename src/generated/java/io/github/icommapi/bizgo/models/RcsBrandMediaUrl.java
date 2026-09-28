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
 * 브랜드 이미지의 파일 ID, URL, 사용 유형 정보입니다.
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
@JsonDeserialize(builder = RcsBrandMediaUrl.Builder.class)
@JsonPropertyOrder({"fileId", "url", "typeName", "fileName"})
public final class RcsBrandMediaUrl {

    private final String fileId;
    private final String url;
    private final String typeName;
    private final String fileName;

    private RcsBrandMediaUrl(Builder builder) {
        this.fileId = builder.fileId;
        this.url = builder.url;
        this.typeName = builder.typeName;
        this.fileName = builder.fileName;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.fileId = this.fileId;
        builder.url = this.url;
        builder.typeName = this.typeName;
        builder.fileName = this.fileName;
        return builder;
    }

    /**
     * 파일 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileId")
    public String getFileId() {
        return fileId;
    }

    /**
     * 파일 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 이미지의 사용 유형입니다. 알려진 값(영문 문서 기준): <code>icon</code>(템플릿 양식 아이콘 이미지), <code>profile</code>(브랜드 프로필 이미지), <code>background</code>(브랜드 배경 이미지).
     *
     * <p>알려진 값 <code>icon</code>, <code>profile</code>, <code>background</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("typeName")
    public String getTypeName() {
        return typeName;
    }

    /**
     * 등록한 파일의 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsBrandMediaUrl)) {
            return false;
        }
        RcsBrandMediaUrl other = (RcsBrandMediaUrl) o;
        return Objects.equals(fileId, other.fileId)
                && Objects.equals(url, other.url)
                && Objects.equals(typeName, other.typeName)
                && Objects.equals(fileName, other.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, url, typeName, fileName);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsBrandMediaUrl{", "}");
        if (fileId != null) {
            joiner.add("fileId=" + io.github.icommapi.bizgo.internal.Masking.length(fileId));
        }
        if (url != null) {
            joiner.add("url=" + io.github.icommapi.bizgo.internal.Masking.length(url));
        }
        if (typeName != null) {
            joiner.add("typeName=" + io.github.icommapi.bizgo.internal.Masking.length(typeName));
        }
        if (fileName != null) {
            joiner.add("fileName=" + io.github.icommapi.bizgo.internal.Masking.length(fileName));
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsBrandMediaUrl}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String fileId;
        private String url;
        private String typeName;
        private String fileName;

        /** Creates an empty builder; same as {@link RcsBrandMediaUrl#builder()}. */
        public Builder() {
        }

        /**
         * 파일 ID입니다.
         *
         * @param fileId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fileId")
        public Builder fileId(String fileId) {
            this.fileId = fileId;
            return this;
        }

        /**
         * 파일 URL입니다.
         *
         * @param url the value (null clears it)
         * @return this builder
         */
        @JsonProperty("url")
        public Builder url(String url) {
            this.url = url;
            return this;
        }

        /**
         * 이미지의 사용 유형입니다. 알려진 값(영문 문서 기준): <code>icon</code>(템플릿 양식 아이콘 이미지), <code>profile</code>(브랜드 프로필 이미지), <code>background</code>(브랜드 배경 이미지).
         *
         * <p>알려진 값 <code>icon</code>, <code>profile</code>, <code>background</code>
         *
         * @param typeName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("typeName")
        public Builder typeName(String typeName) {
            this.typeName = typeName;
            return this;
        }

        /**
         * 등록한 파일의 이름입니다.
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
         * Builds the object.
         *
         * @return a new immutable {@code RcsBrandMediaUrl}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsBrandMediaUrl build() {
            RcsBrandMediaUrl built = new RcsBrandMediaUrl(this);
            ModelValidator v = new ModelValidator("RcsBrandMediaUrl");
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsBrandMediaUrl buildUnvalidated() {
            return new RcsBrandMediaUrl(this);
        }
    }
}
