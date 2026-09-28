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
 * 템플릿 심사 의견 1건입니다.
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
@JsonPropertyOrder({"id", "userName", "createdAt", "status", "attachment"})
public final class AlimtalkTemplateComment {

    private final Long id;
    private final String userName;
    private final String createdAt;
    private final String status;
    private final List<Map<String, Object>> attachment;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private AlimtalkTemplateComment(
            @JsonProperty("id") Long id,
            @JsonProperty("userName") String userName,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("status") String status,
            @JsonProperty("attachment") List<Map<String, Object>> attachment) {
        this.id = id;
        this.userName = userName;
        this.createdAt = createdAt;
        this.status = status;
        this.attachment = attachment == null ? null : Collections.unmodifiableList(new ArrayList<>(attachment));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private AlimtalkTemplateComment(Builder builder) {
        this(builder.id, builder.userName, builder.createdAt, builder.status, builder.attachment);
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
        builder.userName = this.userName;
        builder.createdAt = this.createdAt;
        builder.status = this.status;
        builder.attachment = this.attachment;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 심사 의견 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * 심사 의견을 남긴 담당자명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    /**
     * 심사 의견 등록일입니다.
     *
     * <p><b>확인 필요:</b> 날짜 형식이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 해당 의견 시점의 심사 상태입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 심사 의견에 첨부된 파일 목록입니다.
     *
     * <p><b>확인 필요:</b> 첨부 파일 항목의 하위 필드가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("attachment")
    public List<Map<String, Object>> getAttachment() {
        return attachment;
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
        if (!(o instanceof AlimtalkTemplateComment)) {
            return false;
        }
        AlimtalkTemplateComment other = (AlimtalkTemplateComment) o;
        return Objects.equals(id, other.id)
                && Objects.equals(userName, other.userName)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(status, other.status)
                && Objects.equals(attachment, other.attachment)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, createdAt, status, attachment, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateComment{", "}");
        if (id != null) {
            joiner.add("id=***");
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
        if (attachment != null) {
            joiner.add("attachment=***");
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateComment}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Long id;
        private String userName;
        private String createdAt;
        private String status;
        private List<Map<String, Object>> attachment;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link AlimtalkTemplateComment#builder()}. */
        public Builder() {
        }

        /**
         * 심사 의견 ID입니다.
         *
         * @param id the value (null clears it)
         * @return this builder
         */
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 심사 의견을 남긴 담당자명입니다.
         *
         * @param userName the value (null clears it)
         * @return this builder
         */
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        /**
         * 심사 의견 등록일입니다.
         *
         * <p><b>확인 필요:</b> 날짜 형식이 문서에 없습니다.
         *
         * @param createdAt the value (null clears it)
         * @return this builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * 해당 의견 시점의 심사 상태입니다.
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 심사 의견에 첨부된 파일 목록입니다.
         *
         * <p><b>확인 필요:</b> 첨부 파일 항목의 하위 필드가 문서에 없습니다.
         *
         * @param attachment the value (null clears it)
         * @return this builder
         */
        public Builder attachment(List<Map<String, Object>> attachment) {
            this.attachment = attachment;
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
         * @return a new immutable {@code AlimtalkTemplateComment}
         */
        public AlimtalkTemplateComment build() {
            return new AlimtalkTemplateComment(this);
        }
    }
}
