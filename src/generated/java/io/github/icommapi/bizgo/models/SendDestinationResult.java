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
 * 수신자별 접수 결과입니다.
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
@JsonPropertyOrder({"to", "msgKey", "code", "result"})
public final class SendDestinationResult {

    private final String to;
    private final String msgKey;
    private final String code;
    private final String result;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private SendDestinationResult(
            @JsonProperty("to") String to,
            @JsonProperty("msgKey") String msgKey,
            @JsonProperty("code") String code,
            @JsonProperty("result") String result) {
        this.to = to;
        this.msgKey = msgKey;
        this.code = code;
        this.result = result;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private SendDestinationResult(Builder builder) {
        this(builder.to, builder.msgKey, builder.code, builder.result);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.to = this.to;
        builder.msgKey = this.msgKey;
        builder.code = this.code;
        builder.result = this.result;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 수신번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    /**
     * 메시지 키입니다. 리포트·상태 조회에 씁니다. 끝 3자리를 뺀 값이 동보 요청의 <code>requestId</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgKey")
    public String getMsgKey() {
        return msgKey;
    }

    /**
     * 수신자별 접수 코드입니다. <code>A000</code>이 아니면 해당 수신자는 접수되지 않은 것입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 수신자별 접수 결과입니다.
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
        if (!(o instanceof SendDestinationResult)) {
            return false;
        }
        SendDestinationResult other = (SendDestinationResult) o;
        return Objects.equals(to, other.to)
                && Objects.equals(msgKey, other.msgKey)
                && Objects.equals(code, other.code)
                && Objects.equals(result, other.result)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, msgKey, code, result, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "SendDestinationResult{", "}");
        if (to != null) {
            joiner.add("to=" + io.github.icommapi.bizgo.internal.Masking.phone(to));
        }
        if (msgKey != null) {
            joiner.add("msgKey=" + msgKey);
        }
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

    /** Builder for {@link SendDestinationResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String to;
        private String msgKey;
        private String code;
        private String result;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link SendDestinationResult#builder()}. */
        public Builder() {
        }

        /**
         * 수신번호입니다.
         *
         * @param to the value (null clears it)
         * @return this builder
         */
        public Builder to(String to) {
            this.to = to;
            return this;
        }

        /**
         * 메시지 키입니다. 리포트·상태 조회에 씁니다. 끝 3자리를 뺀 값이 동보 요청의 <code>requestId</code>입니다.
         *
         * @param msgKey the value (null clears it)
         * @return this builder
         */
        public Builder msgKey(String msgKey) {
            this.msgKey = msgKey;
            return this;
        }

        /**
         * 수신자별 접수 코드입니다. <code>A000</code>이 아니면 해당 수신자는 접수되지 않은 것입니다.
         *
         * @param code the value (null clears it)
         * @return this builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * 수신자별 접수 결과입니다.
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
         * @return a new immutable {@code SendDestinationResult}
         */
        public SendDestinationResult build() {
            return new SendDestinationResult(this);
        }
    }
}
