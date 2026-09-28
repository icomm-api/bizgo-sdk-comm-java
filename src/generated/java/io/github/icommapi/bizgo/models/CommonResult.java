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
 * API Gateway 공통 결과(인증·권한·요청 형식 검증)입니다.
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
@JsonPropertyOrder({"authCode", "authResult", "infobankTrId"})
public final class CommonResult {

    private final String authCode;
    private final String authResult;
    private final String infobankTrId;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CommonResult(
            @JsonProperty("authCode") String authCode,
            @JsonProperty("authResult") String authResult,
            @JsonProperty("infobankTrId") String infobankTrId) {
        this.authCode = authCode;
        this.authResult = authResult;
        this.infobankTrId = infobankTrId;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CommonResult(Builder builder) {
        this(builder.authCode, builder.authResult, builder.infobankTrId);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.authCode = this.authCode;
        builder.authResult = this.authResult;
        builder.infobankTrId = this.infobankTrId;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 인증 결과 코드입니다. <code>A000</code>이면 성공입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("authCode")
    public String getAuthCode() {
        return authCode;
    }

    /**
     * 인증 결과 메시지입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("authResult")
    public String getAuthResult() {
        return authResult;
    }

    /**
     * 인포뱅크 트랜잭션 추적 ID입니다. 문의 시 이 값을 전달합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("infobankTrId")
    public String getInfobankTrId() {
        return infobankTrId;
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
        if (!(o instanceof CommonResult)) {
            return false;
        }
        CommonResult other = (CommonResult) o;
        return Objects.equals(authCode, other.authCode)
                && Objects.equals(authResult, other.authResult)
                && Objects.equals(infobankTrId, other.infobankTrId)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authCode, authResult, infobankTrId, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CommonResult{", "}");
        if (authCode != null) {
            joiner.add("authCode=" + authCode);
        }
        if (authResult != null) {
            joiner.add("authResult=" + authResult);
        }
        if (infobankTrId != null) {
            joiner.add("infobankTrId=" + infobankTrId);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CommonResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String authCode;
        private String authResult;
        private String infobankTrId;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CommonResult#builder()}. */
        public Builder() {
        }

        /**
         * 인증 결과 코드입니다. <code>A000</code>이면 성공입니다.
         *
         * <p>필수
         *
         * @param authCode the value (null clears it)
         * @return this builder
         */
        public Builder authCode(String authCode) {
            this.authCode = authCode;
            return this;
        }

        /**
         * 인증 결과 메시지입니다.
         *
         * <p>필수
         *
         * @param authResult the value (null clears it)
         * @return this builder
         */
        public Builder authResult(String authResult) {
            this.authResult = authResult;
            return this;
        }

        /**
         * 인포뱅크 트랜잭션 추적 ID입니다. 문의 시 이 값을 전달합니다.
         *
         * @param infobankTrId the value (null clears it)
         * @return this builder
         */
        public Builder infobankTrId(String infobankTrId) {
            this.infobankTrId = infobankTrId;
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
         * @return a new immutable {@code CommonResult}
         */
        public CommonResult build() {
            return new CommonResult(this);
        }
    }
}
