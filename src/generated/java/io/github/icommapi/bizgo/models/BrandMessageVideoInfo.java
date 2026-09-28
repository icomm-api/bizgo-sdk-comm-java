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
 * 브랜드메시지 동영상 정보입니다.
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
@JsonPropertyOrder({"vid", "status", "title", "thumbnailUrl", "videoUrl"})
public final class BrandMessageVideoInfo {

    private final String vid;
    private final String status;
    private final String title;
    private final String thumbnailUrl;
    private final String videoUrl;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageVideoInfo(
            @JsonProperty("vid") String vid,
            @JsonProperty("status") String status,
            @JsonProperty("title") String title,
            @JsonProperty("thumbnailUrl") String thumbnailUrl,
            @JsonProperty("videoUrl") String videoUrl) {
        this.vid = vid;
        this.status = status;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.videoUrl = videoUrl;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageVideoInfo(Builder builder) {
        this(builder.vid, builder.status, builder.title, builder.thumbnailUrl, builder.videoUrl);
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
        builder.status = this.status;
        builder.title = this.title;
        builder.thumbnailUrl = this.thumbnailUrl;
        builder.videoUrl = this.videoUrl;
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
     * 동영상 썸네일 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * 동영상 재생 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("videoUrl")
    public String getVideoUrl() {
        return videoUrl;
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
        if (!(o instanceof BrandMessageVideoInfo)) {
            return false;
        }
        BrandMessageVideoInfo other = (BrandMessageVideoInfo) o;
        return Objects.equals(vid, other.vid)
                && Objects.equals(status, other.status)
                && Objects.equals(title, other.title)
                && Objects.equals(thumbnailUrl, other.thumbnailUrl)
                && Objects.equals(videoUrl, other.videoUrl)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vid, status, title, thumbnailUrl, videoUrl, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageVideoInfo{", "}");
        if (vid != null) {
            joiner.add("vid=" + io.github.icommapi.bizgo.internal.Masking.length(vid));
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
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageVideoInfo}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String vid;
        private String status;
        private String title;
        private String thumbnailUrl;
        private String videoUrl;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageVideoInfo#builder()}. */
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
         * 동영상 썸네일 URL입니다.
         *
         * @param thumbnailUrl the value (null clears it)
         * @return this builder
         */
        public Builder thumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        /**
         * 동영상 재생 URL입니다.
         *
         * @param videoUrl the value (null clears it)
         * @return this builder
         */
        public Builder videoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
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
         * @return a new immutable {@code BrandMessageVideoInfo}
         */
        public BrandMessageVideoInfo build() {
            return new BrandMessageVideoInfo(this);
        }
    }
}
