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
 * 카카오톡 인증(전자서명) 진행 상태입니다.
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
@JsonPropertyOrder({"txId", "sessionId", "signStatus", "createdAt", "viewedAt", "completedAt", "expiredAt"})
public final class CounselCert {

    private final String txId;
    private final Long sessionId;
    private final String signStatus;
    private final String createdAt;
    private final String viewedAt;
    private final String completedAt;
    private final String expiredAt;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselCert(
            @JsonProperty("txId") String txId,
            @JsonProperty("sessionId") Long sessionId,
            @JsonProperty("signStatus") String signStatus,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("viewedAt") String viewedAt,
            @JsonProperty("completedAt") String completedAt,
            @JsonProperty("expiredAt") String expiredAt) {
        this.txId = txId;
        this.sessionId = sessionId;
        this.signStatus = signStatus;
        this.createdAt = createdAt;
        this.viewedAt = viewedAt;
        this.completedAt = completedAt;
        this.expiredAt = expiredAt;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselCert(Builder builder) {
        this(builder.txId, builder.sessionId, builder.signStatus, builder.createdAt, builder.viewedAt, builder.completedAt, builder.expiredAt);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.txId = this.txId;
        builder.sessionId = this.sessionId;
        builder.signStatus = this.signStatus;
        builder.createdAt = this.createdAt;
        builder.viewedAt = this.viewedAt;
        builder.completedAt = this.completedAt;
        builder.expiredAt = this.expiredAt;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 인증 트랜잭션 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("txId")
    public String getTxId() {
        return txId;
    }

    /**
     * 세션 아이디입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sessionId")
    public Long getSessionId() {
        return sessionId;
    }

    /**
     * 서명 상태입니다. 문서 예시 값은 <code>COMPLETED</code>입니다.
     *
     * <p>알려진 값 <code>COMPLETED</code>
     *
     * <p><b>확인 필요:</b> signStatus 값 목록이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("signStatus")
    public String getSignStatus() {
        return signStatus;
    }

    /**
     * 서명 요청 시각입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 사용자가 서명 내용을 확인한 시각입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("viewedAt")
    public String getViewedAt() {
        return viewedAt;
    }

    /**
     * 서명 완료 시각입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("completedAt")
    public String getCompletedAt() {
        return completedAt;
    }

    /**
     * 서명 만료 시각입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("expiredAt")
    public String getExpiredAt() {
        return expiredAt;
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
        if (!(o instanceof CounselCert)) {
            return false;
        }
        CounselCert other = (CounselCert) o;
        return Objects.equals(txId, other.txId)
                && Objects.equals(sessionId, other.sessionId)
                && Objects.equals(signStatus, other.signStatus)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(viewedAt, other.viewedAt)
                && Objects.equals(completedAt, other.completedAt)
                && Objects.equals(expiredAt, other.expiredAt)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(txId, sessionId, signStatus, createdAt, viewedAt, completedAt, expiredAt, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselCert{", "}");
        if (txId != null) {
            joiner.add("txId=" + io.github.icommapi.bizgo.internal.Masking.length(txId));
        }
        if (sessionId != null) {
            joiner.add("sessionId=***");
        }
        if (signStatus != null) {
            joiner.add("signStatus=" + io.github.icommapi.bizgo.internal.Masking.length(signStatus));
        }
        if (createdAt != null) {
            joiner.add("createdAt=" + io.github.icommapi.bizgo.internal.Masking.length(createdAt));
        }
        if (viewedAt != null) {
            joiner.add("viewedAt=" + io.github.icommapi.bizgo.internal.Masking.length(viewedAt));
        }
        if (completedAt != null) {
            joiner.add("completedAt=" + io.github.icommapi.bizgo.internal.Masking.length(completedAt));
        }
        if (expiredAt != null) {
            joiner.add("expiredAt=" + io.github.icommapi.bizgo.internal.Masking.length(expiredAt));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselCert}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String txId;
        private Long sessionId;
        private String signStatus;
        private String createdAt;
        private String viewedAt;
        private String completedAt;
        private String expiredAt;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselCert#builder()}. */
        public Builder() {
        }

        /**
         * 인증 트랜잭션 ID입니다.
         *
         * @param txId the value (null clears it)
         * @return this builder
         */
        public Builder txId(String txId) {
            this.txId = txId;
            return this;
        }

        /**
         * 세션 아이디입니다.
         *
         * @param sessionId the value (null clears it)
         * @return this builder
         */
        public Builder sessionId(Long sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        /**
         * 서명 상태입니다. 문서 예시 값은 <code>COMPLETED</code>입니다.
         *
         * <p>알려진 값 <code>COMPLETED</code>
         *
         * <p><b>확인 필요:</b> signStatus 값 목록이 문서에 없습니다.
         *
         * @param signStatus the value (null clears it)
         * @return this builder
         */
        public Builder signStatus(String signStatus) {
            this.signStatus = signStatus;
            return this;
        }

        /**
         * 서명 요청 시각입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
         *
         * @param createdAt the value (null clears it)
         * @return this builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * 사용자가 서명 내용을 확인한 시각입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
         *
         * @param viewedAt the value (null clears it)
         * @return this builder
         */
        public Builder viewedAt(String viewedAt) {
            this.viewedAt = viewedAt;
            return this;
        }

        /**
         * 서명 완료 시각입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
         *
         * @param completedAt the value (null clears it)
         * @return this builder
         */
        public Builder completedAt(String completedAt) {
            this.completedAt = completedAt;
            return this;
        }

        /**
         * 서명 만료 시각입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss</code>
         *
         * @param expiredAt the value (null clears it)
         * @return this builder
         */
        public Builder expiredAt(String expiredAt) {
            this.expiredAt = expiredAt;
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
         * @return a new immutable {@code CounselCert}
         */
        public CounselCert build() {
            return new CounselCert(this);
        }
    }
}
