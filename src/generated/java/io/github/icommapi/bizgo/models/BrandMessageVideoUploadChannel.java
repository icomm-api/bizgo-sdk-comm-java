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
 * 발급된 카카오 업로드 채널 정보입니다. <code>uploadUrl</code>과 <code>token</code>은 발급 후 5분간만 유효합니다. 파일은 <code>POST &#123;uploadUrl&#125;</code>에 <code>x-kamp-upload-token: &#123;token&#125;</code> 헤더와 multipart <code>file</code> 필드로 직접 전송합니다(비즈고 API를 거치지 않음).
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
@JsonPropertyOrder({"vid", "uploadUrl", "token"})
public final class BrandMessageVideoUploadChannel {

    private final String vid;
    private final String uploadUrl;
    private final String token;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageVideoUploadChannel(
            @JsonProperty("vid") String vid,
            @JsonProperty("uploadUrl") String uploadUrl,
            @JsonProperty("token") String token) {
        this.vid = vid;
        this.uploadUrl = uploadUrl;
        this.token = token;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageVideoUploadChannel(Builder builder) {
        this(builder.vid, builder.uploadUrl, builder.token);
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
        builder.uploadUrl = this.uploadUrl;
        builder.token = this.token;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 동영상 식별자입니다. 이후 조회 API에서 사용합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("vid")
    public String getVid() {
        return vid;
    }

    /**
     * 동영상 파일을 전송할 카카오 업로드 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("uploadUrl")
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     * 업로드 요청 시 <code>x-kamp-upload-token</code> 헤더로 보낼 인증 토큰(JWT)입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
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
        if (!(o instanceof BrandMessageVideoUploadChannel)) {
            return false;
        }
        BrandMessageVideoUploadChannel other = (BrandMessageVideoUploadChannel) o;
        return Objects.equals(vid, other.vid)
                && Objects.equals(uploadUrl, other.uploadUrl)
                && Objects.equals(token, other.token)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vid, uploadUrl, token, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageVideoUploadChannel{", "}");
        if (vid != null) {
            joiner.add("vid=" + io.github.icommapi.bizgo.internal.Masking.length(vid));
        }
        if (uploadUrl != null) {
            joiner.add("uploadUrl=" + io.github.icommapi.bizgo.internal.Masking.length(uploadUrl));
        }
        if (token != null) {
            joiner.add("token=" + io.github.icommapi.bizgo.internal.Masking.length(token));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageVideoUploadChannel}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String vid;
        private String uploadUrl;
        private String token;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageVideoUploadChannel#builder()}. */
        public Builder() {
        }

        /**
         * 동영상 식별자입니다. 이후 조회 API에서 사용합니다.
         *
         * @param vid the value (null clears it)
         * @return this builder
         */
        public Builder vid(String vid) {
            this.vid = vid;
            return this;
        }

        /**
         * 동영상 파일을 전송할 카카오 업로드 URL입니다.
         *
         * @param uploadUrl the value (null clears it)
         * @return this builder
         */
        public Builder uploadUrl(String uploadUrl) {
            this.uploadUrl = uploadUrl;
            return this;
        }

        /**
         * 업로드 요청 시 <code>x-kamp-upload-token</code> 헤더로 보낼 인증 토큰(JWT)입니다.
         *
         * @param token the value (null clears it)
         * @return this builder
         */
        public Builder token(String token) {
            this.token = token;
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
         * @return a new immutable {@code BrandMessageVideoUploadChannel}
         */
        public BrandMessageVideoUploadChannel build() {
            return new BrandMessageVideoUploadChannel(this);
        }
    }
}
