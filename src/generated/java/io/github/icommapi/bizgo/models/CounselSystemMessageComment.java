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
 * 시스템 메시지 검수 결과 또는 문의입니다.
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
@JsonPropertyOrder({"id", "content", "userName", "createdAt", "status"})
public final class CounselSystemMessageComment {

    private final String id;
    private final String content;
    private final String userName;
    private final String createdAt;
    private final String status;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselSystemMessageComment(
            @JsonProperty("id") String id,
            @JsonProperty("content") String content,
            @JsonProperty("userName") String userName,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("status") String status) {
        this.id = id;
        this.content = content;
        this.userName = userName;
        this.createdAt = createdAt;
        this.status = status;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselSystemMessageComment(Builder builder) {
        this(builder.id, builder.content, builder.userName, builder.createdAt, builder.status);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.content = this.content;
        builder.userName = this.userName;
        builder.createdAt = this.createdAt;
        builder.status = this.status;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 댓글 아이디입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 댓글 내용입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 작성자입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    /**
     * 등록일입니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 상태입니다. <code>APR</code> 승인, <code>REJ</code> 반려, <code>INQ</code> 문의입니다.
     *
     * <p>허용 값 <code>APR</code>, <code>REJ</code>, <code>INQ</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
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
        if (!(o instanceof CounselSystemMessageComment)) {
            return false;
        }
        CounselSystemMessageComment other = (CounselSystemMessageComment) o;
        return Objects.equals(id, other.id)
                && Objects.equals(content, other.content)
                && Objects.equals(userName, other.userName)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(status, other.status)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, userName, createdAt, status, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselSystemMessageComment{", "}");
        if (id != null) {
            joiner.add("id=" + io.github.icommapi.bizgo.internal.Masking.length(id));
        }
        if (content != null) {
            joiner.add("content=" + io.github.icommapi.bizgo.internal.Masking.length(content));
        }
        if (userName != null) {
            joiner.add("userName=" + io.github.icommapi.bizgo.internal.Masking.person(userName));
        }
        if (createdAt != null) {
            joiner.add("createdAt=" + io.github.icommapi.bizgo.internal.Masking.length(createdAt));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselSystemMessageComment}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String id;
        private String content;
        private String userName;
        private String createdAt;
        private String status;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselSystemMessageComment#builder()}. */
        public Builder() {
        }

        /**
         * 댓글 아이디입니다.
         *
         * @param id the value (null clears it)
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * 댓글 내용입니다.
         *
         * @param content the value (null clears it)
         * @return this builder
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }

        /**
         * 작성자입니다.
         *
         * @param userName the value (null clears it)
         * @return this builder
         */
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        /**
         * 등록일입니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param createdAt the value (null clears it)
         * @return this builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * 상태입니다. <code>APR</code> 승인, <code>REJ</code> 반려, <code>INQ</code> 문의입니다.
         *
         * <p>허용 값 <code>APR</code>, <code>REJ</code>, <code>INQ</code>
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
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
         * @return a new immutable {@code CounselSystemMessageComment}
         */
        public CounselSystemMessageComment build() {
            return new CounselSystemMessageComment(this);
        }
    }
}
