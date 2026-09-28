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
 * 브랜드메시지 응답 영역입니다.
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
@JsonPropertyOrder({"video"})
public final class BrandMessageVideoUploadRegisterResultBrandmessage {

    private final BrandMessageVideoUploadChannel video;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageVideoUploadRegisterResultBrandmessage(
            @JsonProperty("video") BrandMessageVideoUploadChannel video) {
        this.video = video;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageVideoUploadRegisterResultBrandmessage(Builder builder) {
        this(builder.video);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.video = this.video;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 발급된 업로드 채널 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("video")
    public BrandMessageVideoUploadChannel getVideo() {
        return video;
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
        if (!(o instanceof BrandMessageVideoUploadRegisterResultBrandmessage)) {
            return false;
        }
        BrandMessageVideoUploadRegisterResultBrandmessage other = (BrandMessageVideoUploadRegisterResultBrandmessage) o;
        return Objects.equals(video, other.video)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(video, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageVideoUploadRegisterResultBrandmessage{", "}");
        if (video != null) {
            joiner.add("video=" + video);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageVideoUploadRegisterResultBrandmessage}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessageVideoUploadChannel video;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageVideoUploadRegisterResultBrandmessage#builder()}. */
        public Builder() {
        }

        /**
         * 발급된 업로드 채널 정보입니다.
         *
         * @param video the value (null clears it)
         * @return this builder
         */
        public Builder video(BrandMessageVideoUploadChannel video) {
            this.video = video;
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
         * @return a new immutable {@code BrandMessageVideoUploadRegisterResultBrandmessage}
         */
        public BrandMessageVideoUploadRegisterResultBrandmessage build() {
            return new BrandMessageVideoUploadRegisterResultBrandmessage(this);
        }
    }
}
