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
 * RCS 응답 정보입니다.
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
@JsonPropertyOrder({"messagebaseId"})
public final class RcsTemplateIdResultRcs {

    private final String messagebaseId;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsTemplateIdResultRcs(
            @JsonProperty("messagebaseId") String messagebaseId) {
        this.messagebaseId = messagebaseId;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsTemplateIdResultRcs(Builder builder) {
        this(builder.messagebaseId);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.messagebaseId = this.messagebaseId;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 처리된 메시지베이스 ID입니다. 발송 시에는 이 값을 <code>formatId</code> 필드에 넣습니다(영문 문서 기준).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messagebaseId")
    public String getMessagebaseId() {
        return messagebaseId;
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
        if (!(o instanceof RcsTemplateIdResultRcs)) {
            return false;
        }
        RcsTemplateIdResultRcs other = (RcsTemplateIdResultRcs) o;
        return Objects.equals(messagebaseId, other.messagebaseId)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messagebaseId, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateIdResultRcs{", "}");
        if (messagebaseId != null) {
            joiner.add("messagebaseId=" + io.github.icommapi.bizgo.internal.Masking.length(messagebaseId));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateIdResultRcs}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String messagebaseId;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsTemplateIdResultRcs#builder()}. */
        public Builder() {
        }

        /**
         * 처리된 메시지베이스 ID입니다. 발송 시에는 이 값을 <code>formatId</code> 필드에 넣습니다(영문 문서 기준).
         *
         * @param messagebaseId the value (null clears it)
         * @return this builder
         */
        public Builder messagebaseId(String messagebaseId) {
            this.messagebaseId = messagebaseId;
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
         * @return a new immutable {@code RcsTemplateIdResultRcs}
         */
        public RcsTemplateIdResultRcs build() {
            return new RcsTemplateIdResultRcs(this);
        }
    }
}
