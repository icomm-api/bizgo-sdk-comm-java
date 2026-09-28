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
 * 사용자가 전송한 메시지 데이터 1건입니다.
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
@JsonPropertyOrder({"url", "comment"})
public final class CounselMessageContent {

    private final String url;
    private final String comment;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselMessageContent(
            @JsonProperty("url") String url,
            @JsonProperty("comment") String comment) {
        this.url = url;
        this.comment = comment;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselMessageContent(Builder builder) {
        this(builder.url, builder.comment);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.comment = this.comment;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 이미지, 파일 등 데이터 경로입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 사용자가 입력한 문구입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("comment")
    public String getComment() {
        return comment;
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
        if (!(o instanceof CounselMessageContent)) {
            return false;
        }
        CounselMessageContent other = (CounselMessageContent) o;
        return Objects.equals(url, other.url)
                && Objects.equals(comment, other.comment)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, comment, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselMessageContent{", "}");
        if (url != null) {
            joiner.add("url=" + io.github.icommapi.bizgo.internal.Masking.length(url));
        }
        if (comment != null) {
            joiner.add("comment=" + io.github.icommapi.bizgo.internal.Masking.length(comment));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselMessageContent}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String url;
        private String comment;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselMessageContent#builder()}. */
        public Builder() {
        }

        /**
         * 이미지, 파일 등 데이터 경로입니다.
         *
         * @param url the value (null clears it)
         * @return this builder
         */
        public Builder url(String url) {
            this.url = url;
            return this;
        }

        /**
         * 사용자가 입력한 문구입니다.
         *
         * @param comment the value (null clears it)
         * @return this builder
         */
        public Builder comment(String comment) {
            this.comment = comment;
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
         * @return a new immutable {@code CounselMessageContent}
         */
        public CounselMessageContent build() {
            return new CounselMessageContent(this);
        }
    }
}
