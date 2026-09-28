// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 동영상 업로드 이력 1건입니다.
 *
 * <p>Response model: unknown JSON properties are kept in {@link #getAdditionalProperties()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({"vid", "senderKey", "fileName", "fileSize", "status", "title", "thumbnailUrl", "videoUrl", "modifiedAt", "regDate", "updateDate"})
public final class BrandMessageVideoListEntry {

    private final String vid;
    private final String senderKey;
    private final String fileName;
    private final Long fileSize;
    private final String status;
    private final String title;
    private final String thumbnailUrl;
    private final String videoUrl;
    private final String modifiedAt;
    private final String regDate;
    private final String updateDate;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageVideoListEntry(
            @JsonProperty("vid") String vid,
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("fileName") String fileName,
            @JsonProperty("fileSize") Long fileSize,
            @JsonProperty("status") String status,
            @JsonProperty("title") String title,
            @JsonProperty("thumbnailUrl") String thumbnailUrl,
            @JsonProperty("videoUrl") String videoUrl,
            @JsonProperty("modifiedAt") String modifiedAt,
            @JsonProperty("regDate") String regDate,
            @JsonProperty("updateDate") String updateDate) {
        this.vid = vid;
        this.senderKey = senderKey;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.status = status;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.videoUrl = videoUrl;
        this.modifiedAt = modifiedAt;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageVideoListEntry(Builder builder) {
        this(builder.vid, builder.senderKey, builder.fileName, builder.fileSize, builder.status, builder.title, builder.thumbnailUrl, builder.videoUrl, builder.modifiedAt, builder.regDate, builder.updateDate);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.vid = this.vid;
        builder.senderKey = this.senderKey;
        builder.fileName = this.fileName;
        builder.fileSize = this.fileSize;
        builder.status = this.status;
        builder.title = this.title;
        builder.thumbnailUrl = this.thumbnailUrl;
        builder.videoUrl = this.videoUrl;
        builder.modifiedAt = this.modifiedAt;
        builder.regDate = this.regDate;
        builder.updateDate = this.updateDate;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 동영상 식별자입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("vid")
    public String getVid() {
        return vid;
    }

    /**
     * 발신프로필 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 업로드한 파일 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    /**
     * 업로드한 파일 크기(byte)입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileSize")
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * 동영상 처리 상태입니다. 알려진 값: <code>REGISTERED</code>(업로드 등록됨), <code>ENCODING</code>(인코딩 중), <code>PUBLIC</code>(공개, 발송·템플릿 등록 가능), <code>PRIVATE</code>(비공개, 템플릿 등록만 가능), <code>VIOLATED</code>(정책 위반), <code>ILLEGAL</code>(불법촬영물), <code>DELETED</code>(삭제됨), <code>ERROR</code>(업로드·인코딩 오류).
     *
     * <p>알려진 값 <code>REGISTERED</code>, <code>ENCODING</code>, <code>PUBLIC</code>, <code>PRIVATE</code>, <code>VIOLATED</code>, <code>ILLEGAL</code>, <code>DELETED</code>, <code>ERROR</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 동영상 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 동영상 썸네일 URL입니다. 처리 실패 시 빈 값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * 동영상 재생 URL입니다. 처리 실패 시 빈 값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("videoUrl")
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 카카오 기준 최종 변경 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다. 처리 실패 시 반환되지 않습니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("modifiedAt")
    public String getModifiedAt() {
        return modifiedAt;
    }

    /**
     * 업로드 등록 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("regDate")
    public String getRegDate() {
        return regDate;
    }

    /**
     * 최종 갱신 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("updateDate")
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * Properties the server sent that are not in the spec (new fields are kept instead of dropped).
     *
     * @return unmodifiable map, empty if there are none
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnySetter
    private void putAdditionalProperty(String name, Object value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageVideoListEntry)) {
            return false;
        }
        BrandMessageVideoListEntry other = (BrandMessageVideoListEntry) o;
        return Objects.equals(vid, other.vid)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(fileName, other.fileName)
                && Objects.equals(fileSize, other.fileSize)
                && Objects.equals(status, other.status)
                && Objects.equals(title, other.title)
                && Objects.equals(thumbnailUrl, other.thumbnailUrl)
                && Objects.equals(videoUrl, other.videoUrl)
                && Objects.equals(modifiedAt, other.modifiedAt)
                && Objects.equals(regDate, other.regDate)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vid, senderKey, fileName, fileSize, status, title, thumbnailUrl, videoUrl, modifiedAt, regDate, updateDate, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageVideoListEntry{", "}");
        if (vid != null) {
            joiner.add("vid=" + io.github.icommapi.bizgo.internal.Masking.length(vid));
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (fileName != null) {
            joiner.add("fileName=" + io.github.icommapi.bizgo.internal.Masking.length(fileName));
        }
        if (fileSize != null) {
            joiner.add("fileSize=***");
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (thumbnailUrl != null) {
            joiner.add("thumbnailUrl=" + io.github.icommapi.bizgo.internal.Masking.length(thumbnailUrl));
        }
        if (videoUrl != null) {
            joiner.add("videoUrl=" + io.github.icommapi.bizgo.internal.Masking.length(videoUrl));
        }
        if (modifiedAt != null) {
            joiner.add("modifiedAt=" + io.github.icommapi.bizgo.internal.Masking.length(modifiedAt));
        }
        if (regDate != null) {
            joiner.add("regDate=" + io.github.icommapi.bizgo.internal.Masking.length(regDate));
        }
        if (updateDate != null) {
            joiner.add("updateDate=" + io.github.icommapi.bizgo.internal.Masking.length(updateDate));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageVideoListEntry}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String vid;
        private String senderKey;
        private String fileName;
        private Long fileSize;
        private String status;
        private String title;
        private String thumbnailUrl;
        private String videoUrl;
        private String modifiedAt;
        private String regDate;
        private String updateDate;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageVideoListEntry#builder()}. */
        public Builder() {
        }

        /**
         * 동영상 식별자입니다.
         *
         * @param vid the value (null clears it)
         * @return this builder
         */
        public Builder vid(String vid) {
            this.vid = vid;
            return this;
        }

        /**
         * 발신프로필 키입니다.
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 업로드한 파일 이름입니다.
         *
         * @param fileName the value (null clears it)
         * @return this builder
         */
        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /**
         * 업로드한 파일 크기(byte)입니다.
         *
         * @param fileSize the value (null clears it)
         * @return this builder
         */
        public Builder fileSize(Long fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        /**
         * 동영상 처리 상태입니다. 알려진 값: <code>REGISTERED</code>(업로드 등록됨), <code>ENCODING</code>(인코딩 중), <code>PUBLIC</code>(공개, 발송·템플릿 등록 가능), <code>PRIVATE</code>(비공개, 템플릿 등록만 가능), <code>VIOLATED</code>(정책 위반), <code>ILLEGAL</code>(불법촬영물), <code>DELETED</code>(삭제됨), <code>ERROR</code>(업로드·인코딩 오류).
         *
         * <p>알려진 값 <code>REGISTERED</code>, <code>ENCODING</code>, <code>PUBLIC</code>, <code>PRIVATE</code>, <code>VIOLATED</code>, <code>ILLEGAL</code>, <code>DELETED</code>, <code>ERROR</code>
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 동영상 제목입니다.
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 동영상 썸네일 URL입니다. 처리 실패 시 빈 값입니다.
         *
         * @param thumbnailUrl the value (null clears it)
         * @return this builder
         */
        public Builder thumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        /**
         * 동영상 재생 URL입니다. 처리 실패 시 빈 값입니다.
         *
         * @param videoUrl the value (null clears it)
         * @return this builder
         */
        public Builder videoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        /**
         * 카카오 기준 최종 변경 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다. 처리 실패 시 반환되지 않습니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param modifiedAt the value (null clears it)
         * @return this builder
         */
        public Builder modifiedAt(String modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        /**
         * 업로드 등록 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param regDate the value (null clears it)
         * @return this builder
         */
        public Builder regDate(String regDate) {
            this.regDate = regDate;
            return this;
        }

        /**
         * 최종 갱신 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param updateDate the value (null clears it)
         * @return this builder
         */
        public Builder updateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        /**
         * Adds a property that is not in the spec.
         *
         * @param name JSON property name
         * @param value value
         * @return this builder
         */
        public Builder additionalProperty(String name, Object value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageVideoListEntry}
         */
        public BrandMessageVideoListEntry build() {
            return new BrandMessageVideoListEntry(this);
        }
    }
}
