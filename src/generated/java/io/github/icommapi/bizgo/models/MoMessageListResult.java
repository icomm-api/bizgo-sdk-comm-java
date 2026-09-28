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
 * MoMessageListResult.
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
@JsonPropertyOrder({"lastSeq", "hasNext", "messages"})
public final class MoMessageListResult {

    private final Long lastSeq;
    private final Boolean hasNext;
    private final List<MoMessage> messages;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private MoMessageListResult(
            @JsonProperty("lastSeq") Long lastSeq,
            @JsonProperty("hasNext") Boolean hasNext,
            @JsonProperty("messages") List<MoMessage> messages) {
        this.lastSeq = lastSeq;
        this.hasNext = hasNext;
        this.messages = messages == null ? null : Collections.unmodifiableList(new ArrayList<>(messages));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private MoMessageListResult(Builder builder) {
        this(builder.lastSeq, builder.hasNext, builder.messages);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.lastSeq = this.lastSeq;
        builder.hasNext = this.hasNext;
        builder.messages = this.messages;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 다음 페이지 조회에 쓰는 커서입니다(MO 이력 조회).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("lastSeq")
    public Long getLastSeq() {
        return lastSeq;
    }

    /**
     * 다음 페이지가 있는지 여부입니다(MO 이력 조회).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("hasNext")
    public Boolean getHasNext() {
        return hasNext;
    }

    /**
     * MO 메시지 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messages")
    public List<MoMessage> getMessages() {
        return messages;
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
        if (!(o instanceof MoMessageListResult)) {
            return false;
        }
        MoMessageListResult other = (MoMessageListResult) o;
        return Objects.equals(lastSeq, other.lastSeq)
                && Objects.equals(hasNext, other.hasNext)
                && Objects.equals(messages, other.messages)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastSeq, hasNext, messages, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "MoMessageListResult{", "}");
        if (lastSeq != null) {
            joiner.add("lastSeq=" + lastSeq);
        }
        if (hasNext != null) {
            joiner.add("hasNext=" + hasNext);
        }
        if (messages != null) {
            joiner.add("messages=" + messages);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link MoMessageListResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Long lastSeq;
        private Boolean hasNext;
        private List<MoMessage> messages;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link MoMessageListResult#builder()}. */
        public Builder() {
        }

        /**
         * 다음 페이지 조회에 쓰는 커서입니다(MO 이력 조회).
         *
         * @param lastSeq the value (null clears it)
         * @return this builder
         */
        public Builder lastSeq(Long lastSeq) {
            this.lastSeq = lastSeq;
            return this;
        }

        /**
         * 다음 페이지가 있는지 여부입니다(MO 이력 조회).
         *
         * @param hasNext the value (null clears it)
         * @return this builder
         */
        public Builder hasNext(Boolean hasNext) {
            this.hasNext = hasNext;
            return this;
        }

        /**
         * MO 메시지 목록입니다.
         *
         * @param messages the value (null clears it)
         * @return this builder
         */
        public Builder messages(List<MoMessage> messages) {
            this.messages = messages;
            return this;
        }

        /**
         * Varargs form of {@link #messages(List)}.
         *
         * @param messages values
         * @return this builder
         */
        public Builder messages(MoMessage... messages) {
            this.messages = messages == null ? null : Arrays.asList(messages);
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
         * @return a new immutable {@code MoMessageListResult}
         */
        public MoMessageListResult build() {
            return new MoMessageListResult(this);
        }
    }
}
