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
 * 상담 세션 정보입니다.
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
@JsonPropertyOrder({"sessionId", "senderKey", "startedType", "startedAt", "expiredType", "expiredAt"})
public final class CounselSession {

    private final Long sessionId;
    private final String senderKey;
    private final String startedType;
    private final String startedAt;
    private final String expiredType;
    private final String expiredAt;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselSession(
            @JsonProperty("sessionId") Long sessionId,
            @JsonProperty("senderKey") String senderKey,
            @JsonProperty("startedType") String startedType,
            @JsonProperty("startedAt") String startedAt,
            @JsonProperty("expiredType") String expiredType,
            @JsonProperty("expiredAt") String expiredAt) {
        this.sessionId = sessionId;
        this.senderKey = senderKey;
        this.startedType = startedType;
        this.startedAt = startedAt;
        this.expiredType = expiredType;
        this.expiredAt = expiredAt;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselSession(Builder builder) {
        this(builder.sessionId, builder.senderKey, builder.startedType, builder.startedAt, builder.expiredType, builder.expiredAt);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.sessionId = this.sessionId;
        builder.senderKey = this.senderKey;
        builder.startedType = this.startedType;
        builder.startedAt = this.startedAt;
        builder.expiredType = this.expiredType;
        builder.expiredAt = this.expiredAt;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 세션 아이디입니다.
     *
     * <p><b>확인 필요:</b> 세션 조회 응답은 Integer, 웹훅의 sessionId는 String으로 문서가 타입을 다르게 적습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sessionId")
    public Long getSessionId() {
        return sessionId;
    }

    /**
     * 발신프로필 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 세션 시작 타입입니다. 문서 예시 값은 <code>UM</code>입니다.
     *
     * <p>알려진 값 <code>UM</code>
     *
     * <p><b>확인 필요:</b> startedType·expiredType 코드 목록과 의미가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("startedType")
    public String getStartedType() {
        return startedType;
    }

    /**
     * 세션 시작 시각입니다. 문서 예시는 오프셋 없는 ISO 8601 형식(<code>2025-09-24T11:22:08.557</code>)입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSS</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("startedAt")
    public String getStartedAt() {
        return startedAt;
    }

    /**
     * 세션 종료 타입입니다. 문서 예시 값은 <code>AE</code>입니다.
     *
     * <p>알려진 값 <code>AE</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("expiredType")
    public String getExpiredType() {
        return expiredType;
    }

    /**
     * 세션 종료 시각입니다. 현재 시각보다 크면 종료 예정 시각입니다(마지막 메시지 수신 시각 기준 다음 정각으로부터 30일 후).
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
        if (!(o instanceof CounselSession)) {
            return false;
        }
        CounselSession other = (CounselSession) o;
        return Objects.equals(sessionId, other.sessionId)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(startedType, other.startedType)
                && Objects.equals(startedAt, other.startedAt)
                && Objects.equals(expiredType, other.expiredType)
                && Objects.equals(expiredAt, other.expiredAt)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, senderKey, startedType, startedAt, expiredType, expiredAt, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselSession{", "}");
        if (sessionId != null) {
            joiner.add("sessionId=***");
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (startedType != null) {
            joiner.add("startedType=" + io.github.icommapi.bizgo.internal.Masking.length(startedType));
        }
        if (startedAt != null) {
            joiner.add("startedAt=" + io.github.icommapi.bizgo.internal.Masking.length(startedAt));
        }
        if (expiredType != null) {
            joiner.add("expiredType=" + io.github.icommapi.bizgo.internal.Masking.length(expiredType));
        }
        if (expiredAt != null) {
            joiner.add("expiredAt=" + io.github.icommapi.bizgo.internal.Masking.length(expiredAt));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselSession}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Long sessionId;
        private String senderKey;
        private String startedType;
        private String startedAt;
        private String expiredType;
        private String expiredAt;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselSession#builder()}. */
        public Builder() {
        }

        /**
         * 세션 아이디입니다.
         *
         * <p><b>확인 필요:</b> 세션 조회 응답은 Integer, 웹훅의 sessionId는 String으로 문서가 타입을 다르게 적습니다.
         *
         * @param sessionId the value (null clears it)
         * @return this builder
         */
        public Builder sessionId(Long sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        /**
         * 발신프로필 키입니다.
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 세션 시작 타입입니다. 문서 예시 값은 <code>UM</code>입니다.
         *
         * <p>알려진 값 <code>UM</code>
         *
         * <p><b>확인 필요:</b> startedType·expiredType 코드 목록과 의미가 문서에 없습니다.
         *
         * @param startedType the value (null clears it)
         * @return this builder
         */
        public Builder startedType(String startedType) {
            this.startedType = startedType;
            return this;
        }

        /**
         * 세션 시작 시각입니다. 문서 예시는 오프셋 없는 ISO 8601 형식(<code>2025-09-24T11:22:08.557</code>)입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSS</code>
         *
         * @param startedAt the value (null clears it)
         * @return this builder
         */
        public Builder startedAt(String startedAt) {
            this.startedAt = startedAt;
            return this;
        }

        /**
         * 세션 종료 타입입니다. 문서 예시 값은 <code>AE</code>입니다.
         *
         * <p>알려진 값 <code>AE</code>
         *
         * @param expiredType the value (null clears it)
         * @return this builder
         */
        public Builder expiredType(String expiredType) {
            this.expiredType = expiredType;
            return this;
        }

        /**
         * 세션 종료 시각입니다. 현재 시각보다 크면 종료 예정 시각입니다(마지막 메시지 수신 시각 기준 다음 정각으로부터 30일 후).
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
         * @return a new immutable {@code CounselSession}
         */
        public CounselSession build() {
            return new CounselSession(this);
        }
    }
}
