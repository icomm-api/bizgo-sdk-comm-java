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
 * 친구 그룹 등록·전화번호 추가·삭제 요청의 처리 정보입니다. 처리는 비동기이며 진행 상황은 전화번호 요청 조회 API로 확인합니다.
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
@JsonPropertyOrder({"friendGroupKey", "requestId", "status", "createdAt", "modifiedAt"})
public final class BrandMessageFriendGroupProcessing {

    private final String friendGroupKey;
    private final String requestId;
    private final String status;
    private final String createdAt;
    private final String modifiedAt;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageFriendGroupProcessing(
            @JsonProperty("friendGroupKey") String friendGroupKey,
            @JsonProperty("requestId") String requestId,
            @JsonProperty("status") String status,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("modifiedAt") String modifiedAt) {
        this.friendGroupKey = friendGroupKey;
        this.requestId = requestId;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageFriendGroupProcessing(Builder builder) {
        this(builder.friendGroupKey, builder.requestId, builder.status, builder.createdAt, builder.modifiedAt);
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
        builder.status = this.status;
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
     * <p><b>확인 필요:</b> Part A는 String, Part B는 Integer로 표기합니다. 예시 값이 int64 범위의 큰 수이므로 정밀도 손실을 피하려 Part A(String)를 따릅니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("requestId")
    public String getRequestId() {
        return requestId;
    }

    /**
     * 친구 그룹 처리 상태입니다. 알려진 값: <code>IN_PROGRESS</code>, <code>COMPLETED</code>.
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
     * 생성 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
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
     * 수정 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
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
        if (!(o instanceof BrandMessageFriendGroupProcessing)) {
            return false;
        }
        BrandMessageFriendGroupProcessing other = (BrandMessageFriendGroupProcessing) o;
        return Objects.equals(friendGroupKey, other.friendGroupKey)
                && Objects.equals(requestId, other.requestId)
                && Objects.equals(status, other.status)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(modifiedAt, other.modifiedAt)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendGroupKey, requestId, status, createdAt, modifiedAt, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageFriendGroupProcessing{", "}");
        if (friendGroupKey != null) {
            joiner.add("friendGroupKey=" + io.github.icommapi.bizgo.internal.Masking.length(friendGroupKey));
        }
        if (requestId != null) {
            joiner.add("requestId=" + io.github.icommapi.bizgo.internal.Masking.length(requestId));
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
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageFriendGroupProcessing}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String friendGroupKey;
        private String requestId;
        private String status;
        private String createdAt;
        private String modifiedAt;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageFriendGroupProcessing#builder()}. */
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
         * <p><b>확인 필요:</b> Part A는 String, Part B는 Integer로 표기합니다. 예시 값이 int64 범위의 큰 수이므로 정밀도 손실을 피하려 Part A(String)를 따릅니다.
         *
         * @param requestId the value (null clears it)
         * @return this builder
         */
        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * 친구 그룹 처리 상태입니다. 알려진 값: <code>IN_PROGRESS</code>, <code>COMPLETED</code>.
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
         * 생성 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
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
         * 수정 일시(<code>yyyy-MM-dd HH:mm:ss</code>)입니다.
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
         * @return a new immutable {@code BrandMessageFriendGroupProcessing}
         */
        public BrandMessageFriendGroupProcessing build() {
            return new BrandMessageFriendGroupProcessing(this);
        }
    }
}
