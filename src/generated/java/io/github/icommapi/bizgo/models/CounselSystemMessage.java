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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 등록된 시스템 메시지입니다.
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
@JsonPropertyOrder({"id", "name", "status", "createdAt", "modifiedAt", "inspectStatus", "inspectRequestAt", "inspectedAt", "messages", "comments"})
public final class CounselSystemMessage {

    private final String id;
    private final String name;
    private final String status;
    private final String createdAt;
    private final String modifiedAt;
    private final String inspectStatus;
    private final String inspectRequestAt;
    private final String inspectedAt;
    private final List<CounselSystemMessageContent> messages;
    private final List<CounselSystemMessageComment> comments;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselSystemMessage(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("status") String status,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("modifiedAt") String modifiedAt,
            @JsonProperty("inspectStatus") String inspectStatus,
            @JsonProperty("inspectRequestAt") String inspectRequestAt,
            @JsonProperty("inspectedAt") String inspectedAt,
            @JsonProperty("messages") List<CounselSystemMessageContent> messages,
            @JsonProperty("comments") List<CounselSystemMessageComment> comments) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.inspectStatus = inspectStatus;
        this.inspectRequestAt = inspectRequestAt;
        this.inspectedAt = inspectedAt;
        this.messages = messages == null ? null : Collections.unmodifiableList(new ArrayList<>(messages));
        this.comments = comments == null ? null : Collections.unmodifiableList(new ArrayList<>(comments));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselSystemMessage(Builder builder) {
        this(builder.id, builder.name, builder.status, builder.createdAt, builder.modifiedAt, builder.inspectStatus, builder.inspectRequestAt, builder.inspectedAt, builder.messages, builder.comments);
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
        builder.name = this.name;
        builder.status = this.status;
        builder.createdAt = this.createdAt;
        builder.modifiedAt = this.modifiedAt;
        builder.inspectStatus = this.inspectStatus;
        builder.inspectRequestAt = this.inspectRequestAt;
        builder.inspectedAt = this.inspectedAt;
        builder.messages = this.messages;
        builder.comments = this.comments;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 시스템 메시지 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 시스템 메시지 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 시스템 메시지 상태입니다. 문서 예시 값은 <code>A</code>입니다.
     *
     * <p>알려진 값 <code>A</code>
     *
     * <p><b>확인 필요:</b> status·inspectStatus 코드 목록이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
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
     * 수정일입니다.
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
     * 검수 상태입니다. 문서 예시 값은 <code>REG</code>입니다.
     *
     * <p>알려진 값 <code>REG</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("inspectStatus")
    public String getInspectStatus() {
        return inspectStatus;
    }

    /**
     * 검수 요청일입니다. 값이 없으면 빈 문자열일 수 있습니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("inspectRequestAt")
    public String getInspectRequestAt() {
        return inspectRequestAt;
    }

    /**
     * 검수일입니다. 값이 없으면 빈 문자열일 수 있습니다.
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("inspectedAt")
    public String getInspectedAt() {
        return inspectedAt;
    }

    /**
     * 시스템 메시지 배열입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messages")
    public List<CounselSystemMessageContent> getMessages() {
        return messages;
    }

    /**
     * 검수 결과 및 문의 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("comments")
    public List<CounselSystemMessageComment> getComments() {
        return comments;
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
        if (!(o instanceof CounselSystemMessage)) {
            return false;
        }
        CounselSystemMessage other = (CounselSystemMessage) o;
        return Objects.equals(id, other.id)
                && Objects.equals(name, other.name)
                && Objects.equals(status, other.status)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(modifiedAt, other.modifiedAt)
                && Objects.equals(inspectStatus, other.inspectStatus)
                && Objects.equals(inspectRequestAt, other.inspectRequestAt)
                && Objects.equals(inspectedAt, other.inspectedAt)
                && Objects.equals(messages, other.messages)
                && Objects.equals(comments, other.comments)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, createdAt, modifiedAt, inspectStatus, inspectRequestAt, inspectedAt, messages, comments, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselSystemMessage{", "}");
        if (id != null) {
            joiner.add("id=" + io.github.icommapi.bizgo.internal.Masking.length(id));
        }
        if (name != null) {
            joiner.add("name=" + io.github.icommapi.bizgo.internal.Masking.length(name));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (createdAt != null) {
            joiner.add("createdAt=" + io.github.icommapi.bizgo.internal.Masking.length(createdAt));
        }
        if (modifiedAt != null) {
            joiner.add("modifiedAt=" + io.github.icommapi.bizgo.internal.Masking.length(modifiedAt));
        }
        if (inspectStatus != null) {
            joiner.add("inspectStatus=" + io.github.icommapi.bizgo.internal.Masking.length(inspectStatus));
        }
        if (inspectRequestAt != null) {
            joiner.add("inspectRequestAt=" + io.github.icommapi.bizgo.internal.Masking.length(inspectRequestAt));
        }
        if (inspectedAt != null) {
            joiner.add("inspectedAt=" + io.github.icommapi.bizgo.internal.Masking.length(inspectedAt));
        }
        if (messages != null) {
            joiner.add("messages=" + messages);
        }
        if (comments != null) {
            joiner.add("comments=" + comments);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselSystemMessage}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String id;
        private String name;
        private String status;
        private String createdAt;
        private String modifiedAt;
        private String inspectStatus;
        private String inspectRequestAt;
        private String inspectedAt;
        private List<CounselSystemMessageContent> messages;
        private List<CounselSystemMessageComment> comments;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselSystemMessage#builder()}. */
        public Builder() {
        }

        /**
         * 시스템 메시지 ID입니다.
         *
         * @param id the value (null clears it)
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * 시스템 메시지 이름입니다.
         *
         * @param name the value (null clears it)
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * 시스템 메시지 상태입니다. 문서 예시 값은 <code>A</code>입니다.
         *
         * <p>알려진 값 <code>A</code>
         *
         * <p><b>확인 필요:</b> status·inspectStatus 코드 목록이 문서에 없습니다.
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
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
         * 수정일입니다.
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
         * 검수 상태입니다. 문서 예시 값은 <code>REG</code>입니다.
         *
         * <p>알려진 값 <code>REG</code>
         *
         * @param inspectStatus the value (null clears it)
         * @return this builder
         */
        public Builder inspectStatus(String inspectStatus) {
            this.inspectStatus = inspectStatus;
            return this;
        }

        /**
         * 검수 요청일입니다. 값이 없으면 빈 문자열일 수 있습니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param inspectRequestAt the value (null clears it)
         * @return this builder
         */
        public Builder inspectRequestAt(String inspectRequestAt) {
            this.inspectRequestAt = inspectRequestAt;
            return this;
        }

        /**
         * 검수일입니다. 값이 없으면 빈 문자열일 수 있습니다.
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param inspectedAt the value (null clears it)
         * @return this builder
         */
        public Builder inspectedAt(String inspectedAt) {
            this.inspectedAt = inspectedAt;
            return this;
        }

        /**
         * 시스템 메시지 배열입니다.
         *
         * @param messages the value (null clears it)
         * @return this builder
         */
        public Builder messages(List<CounselSystemMessageContent> messages) {
            this.messages = messages;
            return this;
        }

        /**
         * Varargs form of {@link #messages(List)}.
         *
         * @param messages values
         * @return this builder
         */
        public Builder messages(CounselSystemMessageContent... messages) {
            this.messages = messages == null ? null : Arrays.asList(messages);
            return this;
        }

        /**
         * 검수 결과 및 문의 목록입니다.
         *
         * @param comments the value (null clears it)
         * @return this builder
         */
        public Builder comments(List<CounselSystemMessageComment> comments) {
            this.comments = comments;
            return this;
        }

        /**
         * Varargs form of {@link #comments(List)}.
         *
         * @param comments values
         * @return this builder
         */
        public Builder comments(CounselSystemMessageComment... comments) {
            this.comments = comments == null ? null : Arrays.asList(comments);
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
         * @return a new immutable {@code CounselSystemMessage}
         */
        public CounselSystemMessage build() {
            return new CounselSystemMessage(this);
        }
    }
}
