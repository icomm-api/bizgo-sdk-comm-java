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
 * RCS 응답 영역입니다.
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
@JsonPropertyOrder({"chatbot"})
public final class RcsChatbotResultRcs {

    private final List<RcsChatbot> chatbot;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsChatbotResultRcs(
            @JsonProperty("chatbot") List<RcsChatbot> chatbot) {
        this.chatbot = chatbot == null ? null : Collections.unmodifiableList(new ArrayList<>(chatbot));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsChatbotResultRcs(Builder builder) {
        this(builder.chatbot);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.chatbot = this.chatbot;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 대화방 정보 배열입니다. 상세 조회에서도 배열로 돌아옵니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatbot")
    public List<RcsChatbot> getChatbot() {
        return chatbot;
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
        if (!(o instanceof RcsChatbotResultRcs)) {
            return false;
        }
        RcsChatbotResultRcs other = (RcsChatbotResultRcs) o;
        return Objects.equals(chatbot, other.chatbot)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatbot, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsChatbotResultRcs{", "}");
        if (chatbot != null) {
            joiner.add("chatbot=" + chatbot);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsChatbotResultRcs}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<RcsChatbot> chatbot;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsChatbotResultRcs#builder()}. */
        public Builder() {
        }

        /**
         * 대화방 정보 배열입니다. 상세 조회에서도 배열로 돌아옵니다.
         *
         * @param chatbot the value (null clears it)
         * @return this builder
         */
        public Builder chatbot(List<RcsChatbot> chatbot) {
            this.chatbot = chatbot;
            return this;
        }

        /**
         * Varargs form of {@link #chatbot(List)}.
         *
         * @param chatbot values
         * @return this builder
         */
        public Builder chatbot(RcsChatbot... chatbot) {
            this.chatbot = chatbot == null ? null : Arrays.asList(chatbot);
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
         * @return a new immutable {@code RcsChatbotResultRcs}
         */
        public RcsChatbotResultRcs build() {
            return new RcsChatbotResultRcs(this);
        }
    }
}
