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
 * 상담톡 웹훅 수신 응답입니다. 리포트·MO 웹훅(<code>&#123;"msgKey": ...&#125;</code>)과 달리 <code>code</code>/<code>result</code>를 돌려줍니다. HTTP 200과 이 규격의 응답을 받아야 정상 처리되며, 응답이 없거나 규격이 다르면 최대 3회 재시도합니다.
 *
 * <p><b>확인 필요(x-unverified):</b> code/result가 필수인지, A000 외의 code를 보내면 실패로 보고 재시도하는지 문서에 없습니다.
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
@JsonPropertyOrder({"code", "result"})
public final class CounselWebhookAck {

    private final String code;
    private final String result;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselWebhookAck(
            @JsonProperty("code") String code,
            @JsonProperty("result") String result) {
        this.code = code;
        this.result = result;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselWebhookAck(Builder builder) {
        this(builder.code, builder.result);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.code = this.code;
        builder.result = this.result;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 웹훅 처리 결과 코드입니다. 문서 예시 값은 <code>A000</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 웹훅 처리 결과 메시지입니다. 문서 예시 값은 <code>Success</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("result")
    public String getResult() {
        return result;
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
        if (!(o instanceof CounselWebhookAck)) {
            return false;
        }
        CounselWebhookAck other = (CounselWebhookAck) o;
        return Objects.equals(code, other.code)
                && Objects.equals(result, other.result)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, result, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselWebhookAck{", "}");
        if (code != null) {
            joiner.add("code=" + code);
        }
        if (result != null) {
            joiner.add("result=" + result);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselWebhookAck}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String code;
        private String result;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselWebhookAck#builder()}. */
        public Builder() {
        }

        /**
         * 웹훅 처리 결과 코드입니다. 문서 예시 값은 <code>A000</code>입니다.
         *
         * @param code the value (null clears it)
         * @return this builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * 웹훅 처리 결과 메시지입니다. 문서 예시 값은 <code>Success</code>입니다.
         *
         * @param result the value (null clears it)
         * @return this builder
         */
        public Builder result(String result) {
            this.result = result;
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
         * @return a new immutable {@code CounselWebhookAck}
         */
        public CounselWebhookAck build() {
            return new CounselWebhookAck(this);
        }
    }
}
