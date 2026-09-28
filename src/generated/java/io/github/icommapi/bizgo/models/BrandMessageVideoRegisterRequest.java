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
 * 기존 동영상 등록 요청입니다. 카카오톡 채널에 이미 올라가 있는 <code>PUBLIC</code> 또는 <code>PRIVATE</code> 상태의 동영상을 재업로드 없이 등록합니다.
 *
 * <p><b>확인 필요(x-unverified):</b> Part A는 <code>vid</code>·<code>videoUrl</code> 중 정확히 하나만 입력해야 하며 둘 다 입력하거나 비우면 <code>A502</code>라고 하나, Part B 규칙 설명은 '하나 이상, 둘 다 입력 시 videoUrl 우선'이라고 합니다. Part A를 따릅니다.
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
@JsonDeserialize(builder = BrandMessageVideoRegisterRequest.Builder.class)
@JsonPropertyOrder({"senderKey", "vid", "videoUrl"})
public final class BrandMessageVideoRegisterRequest {

    private final String senderKey;
    private final String vid;
    private final String videoUrl;

    private BrandMessageVideoRegisterRequest(Builder builder) {
        this.senderKey = builder.senderKey;
        this.vid = builder.vid;
        this.videoUrl = builder.videoUrl;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.vid = this.vid;
        builder.videoUrl = this.videoUrl;
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
    public static BrandMessageVideoRegisterRequest fromJson(String json) {
        return RequestParser.parse(json, BrandMessageVideoRegisterRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageVideoRegisterRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, BrandMessageVideoRegisterRequest.class);
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
     * 등록할 동영상 식별자입니다. <code>videoUrl</code>과 함께 사용할 수 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("vid")
    public String getVid() {
        return vid;
    }

    /**
     * 등록할 채널 동영상 URL입니다. 형식: <code>https://business.kakao.com/&#123;채널식별자&#125;/videos/&#123;vid&#125;</code>. <code>vid</code>와 함께 사용할 수 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("videoUrl")
    public String getVideoUrl() {
        return videoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageVideoRegisterRequest)) {
            return false;
        }
        BrandMessageVideoRegisterRequest other = (BrandMessageVideoRegisterRequest) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(vid, other.vid)
                && Objects.equals(videoUrl, other.videoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, vid, videoUrl);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageVideoRegisterRequest{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (vid != null) {
            joiner.add("vid=" + io.github.icommapi.bizgo.internal.Masking.length(vid));
        }
        if (videoUrl != null) {
            joiner.add("videoUrl=" + io.github.icommapi.bizgo.internal.Masking.length(videoUrl));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageVideoRegisterRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String vid;
        private String videoUrl;

        /** Creates an empty builder; same as {@link BrandMessageVideoRegisterRequest#builder()}. */
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
         * 등록할 동영상 식별자입니다. <code>videoUrl</code>과 함께 사용할 수 없습니다.
         *
         * @param vid the value (null clears it)
         * @return this builder
         */
        @JsonProperty("vid")
        public Builder vid(String vid) {
            this.vid = vid;
            return this;
        }

        /**
         * 등록할 채널 동영상 URL입니다. 형식: <code>https://business.kakao.com/&#123;채널식별자&#125;/videos/&#123;vid&#125;</code>. <code>vid</code>와 함께 사용할 수 없습니다.
         *
         * @param videoUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("videoUrl")
        public Builder videoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageVideoRegisterRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageVideoRegisterRequest build() {
            BrandMessageVideoRegisterRequest built = new BrandMessageVideoRegisterRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageVideoRegisterRequest");
            v.required("senderKey", built.senderKey);
            v.maxLength("senderKey", built.senderKey, 40);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageVideoRegisterRequest buildUnvalidated() {
            return new BrandMessageVideoRegisterRequest(this);
        }
    }
}
