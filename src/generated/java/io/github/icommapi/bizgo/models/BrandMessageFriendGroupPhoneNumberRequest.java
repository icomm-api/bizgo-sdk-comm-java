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
 * 친구 그룹 전화번호 추가·삭제 요청 1건의 처리 상태입니다.
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
@JsonPropertyOrder({"friendGroupKey", "requestId", "type", "status", "processedCount", "createdAt", "modifiedAt"})
public final class BrandMessageFriendGroupPhoneNumberRequest {

    private final String friendGroupKey;
    private final String requestId;
    private final String type;
    private final String status;
    private final Long processedCount;
    private final String createdAt;
    private final String modifiedAt;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageFriendGroupPhoneNumberRequest(
            @JsonProperty("friendGroupKey") String friendGroupKey,
            @JsonProperty("requestId") String requestId,
            @JsonProperty("type") String type,
            @JsonProperty("status") String status,
            @JsonProperty("processedCount") Long processedCount,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("modifiedAt") String modifiedAt) {
        this.friendGroupKey = friendGroupKey;
        this.requestId = requestId;
        this.type = type;
        this.status = status;
        this.processedCount = processedCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageFriendGroupPhoneNumberRequest(Builder builder) {
        this(builder.friendGroupKey, builder.requestId, builder.type, builder.status, builder.processedCount, builder.createdAt, builder.modifiedAt);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.friendGroupKey = this.friendGroupKey;
        builder.requestId = this.requestId;
        builder.type = this.type;
        builder.status = this.status;
        builder.processedCount = this.processedCount;
        builder.createdAt = this.createdAt;
        builder.modifiedAt = this.modifiedAt;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 친구 그룹 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("friendGroupKey")
    public String getFriendGroupKey() {
        return friendGroupKey;
    }

    /**
     * 요청 아이디입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("requestId")
    public String getRequestId() {
        return requestId;
    }

    /**
     * 요청 유형입니다. 문서 예시 값은 <code>ADD</code>입니다.
     *
     * <p>알려진 값 <code>ADD</code>
     *
     * <p><b>확인 필요:</b> 요청 유형 값 목록이 문서에 없습니다(예시는 <code>ADD</code>만 있음. 삭제 요청의 값은 미확인).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 요청 처리 상태입니다. 문서 예시 값은 <code>COMPLETED</code>입니다.
     *
     * <p>알려진 값 <code>IN_PROGRESS</code>, <code>COMPLETED</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 처리된 전화번호 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("processedCount")
    public Long getProcessedCount() {
        return processedCount;
    }

    /**
     * 요청 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
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
     * 상태 변경 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
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
        if (!(o instanceof BrandMessageFriendGroupPhoneNumberRequest)) {
            return false;
        }
        BrandMessageFriendGroupPhoneNumberRequest other = (BrandMessageFriendGroupPhoneNumberRequest) o;
        return Objects.equals(friendGroupKey, other.friendGroupKey)
                && Objects.equals(requestId, other.requestId)
                && Objects.equals(type, other.type)
                && Objects.equals(status, other.status)
                && Objects.equals(processedCount, other.processedCount)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(modifiedAt, other.modifiedAt)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendGroupKey, requestId, type, status, processedCount, createdAt, modifiedAt, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageFriendGroupPhoneNumberRequest{", "}");
        if (friendGroupKey != null) {
            joiner.add("friendGroupKey=" + io.github.icommapi.bizgo.internal.Masking.length(friendGroupKey));
        }
        if (requestId != null) {
            joiner.add("requestId=" + io.github.icommapi.bizgo.internal.Masking.length(requestId));
        }
        if (type != null) {
            joiner.add("type=" + type);
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (processedCount != null) {
            joiner.add("processedCount=***");
        }
        if (createdAt != null) {
            joiner.add("createdAt=" + io.github.icommapi.bizgo.internal.Masking.length(createdAt));
        }
        if (modifiedAt != null) {
            joiner.add("modifiedAt=" + io.github.icommapi.bizgo.internal.Masking.length(modifiedAt));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageFriendGroupPhoneNumberRequest}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String friendGroupKey;
        private String requestId;
        private String type;
        private String status;
        private Long processedCount;
        private String createdAt;
        private String modifiedAt;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageFriendGroupPhoneNumberRequest#builder()}. */
        public Builder() {
        }

        /**
         * 친구 그룹 키입니다.
         *
         * @param friendGroupKey the value (null clears it)
         * @return this builder
         */
        public Builder friendGroupKey(String friendGroupKey) {
            this.friendGroupKey = friendGroupKey;
            return this;
        }

        /**
         * 요청 아이디입니다.
         *
         * @param requestId the value (null clears it)
         * @return this builder
         */
        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * 요청 유형입니다. 문서 예시 값은 <code>ADD</code>입니다.
         *
         * <p>알려진 값 <code>ADD</code>
         *
         * <p><b>확인 필요:</b> 요청 유형 값 목록이 문서에 없습니다(예시는 <code>ADD</code>만 있음. 삭제 요청의 값은 미확인).
         *
         * @param type the value (null clears it)
         * @return this builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 요청 처리 상태입니다. 문서 예시 값은 <code>COMPLETED</code>입니다.
         *
         * <p>알려진 값 <code>IN_PROGRESS</code>, <code>COMPLETED</code>
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 처리된 전화번호 건수입니다.
         *
         * @param processedCount the value (null clears it)
         * @return this builder
         */
        public Builder processedCount(Long processedCount) {
            this.processedCount = processedCount;
            return this;
        }

        /**
         * 요청 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
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
         * 상태 변경 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
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
         * @return a new immutable {@code BrandMessageFriendGroupPhoneNumberRequest}
         */
        public BrandMessageFriendGroupPhoneNumberRequest build() {
            return new BrandMessageFriendGroupPhoneNumberRequest(this);
        }
    }
}
