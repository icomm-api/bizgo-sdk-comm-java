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
 * 상담 종료 처리 결과 데이터입니다.
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
@JsonPropertyOrder({"msgKey"})
public final class CounselEndResult {

    private final String msgKey;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselEndResult(
            @JsonProperty("msgKey") String msgKey) {
        this.msgKey = msgKey;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselEndResult(Builder builder) {
        this(builder.msgKey);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.msgKey = this.msgKey;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 메시지 키입니다. 발송 결과 웹훅(<code>cstalk/result</code>, requestType <code>end</code>/<code>endwithbot</code>)의 <code>msgKey</code>와 대조합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgKey")
    public String getMsgKey() {
        return msgKey;
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
        if (!(o instanceof CounselEndResult)) {
            return false;
        }
        CounselEndResult other = (CounselEndResult) o;
        return Objects.equals(msgKey, other.msgKey)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgKey, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselEndResult{", "}");
        if (msgKey != null) {
            joiner.add("msgKey=" + msgKey);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselEndResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String msgKey;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselEndResult#builder()}. */
        public Builder() {
        }

        /**
         * 메시지 키입니다. 발송 결과 웹훅(<code>cstalk/result</code>, requestType <code>end</code>/<code>endwithbot</code>)의 <code>msgKey</code>와 대조합니다.
         *
         * @param msgKey the value (null clears it)
         * @return this builder
         */
        public Builder msgKey(String msgKey) {
            this.msgKey = msgKey;
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
         * @return a new immutable {@code CounselEndResult}
         */
        public CounselEndResult build() {
            return new CounselEndResult(this);
        }
    }
}
