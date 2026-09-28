// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 등록할 시스템 메시지입니다.
 *
 * <p>Request model: immutable, created with {@link #builder()}, validated in {@link Builder#build()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonDeserialize(builder = CounselSystemMessageDraft.Builder.class)
@JsonPropertyOrder({"senderKey", "name", "messages"})
public final class CounselSystemMessageDraft {

    private final String senderKey;
    private final String name;
    private final List<CounselSystemMessageContent> messages;

    private CounselSystemMessageDraft(Builder builder) {
        this.senderKey = builder.senderKey;
        this.name = builder.name;
        this.messages = builder.messages == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.messages));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.name = this.name;
        builder.messages = this.messages;
        return builder;
    }

    /**
     * 발신프로필 키입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 시스템 메시지 이름입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 시스템 메시지 배열입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messages")
    public List<CounselSystemMessageContent> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselSystemMessageDraft)) {
            return false;
        }
        CounselSystemMessageDraft other = (CounselSystemMessageDraft) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(name, other.name)
                && Objects.equals(messages, other.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, name, messages);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselSystemMessageDraft{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (name != null) {
            joiner.add("name=" + io.github.icommapi.bizgo.internal.Masking.length(name));
        }
        if (messages != null) {
            joiner.add("messages=" + messages);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselSystemMessageDraft}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String name;
        private List<CounselSystemMessageContent> messages;

        /** Creates an empty builder; same as {@link CounselSystemMessageDraft#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다.
         *
         * <p>필수
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("senderKey")
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 시스템 메시지 이름입니다.
         *
         * <p>필수
         *
         * @param name the value (null clears it)
         * @return this builder
         */
        @JsonProperty("name")
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * 시스템 메시지 배열입니다.
         *
         * <p>필수
         *
         * @param messages the value (null clears it)
         * @return this builder
         */
        @JsonProperty("messages")
        public Builder messages(List<CounselSystemMessageContent> messages) {
            this.messages = messages;
            return this;
        }

        /**
         * Varargs form of {@link #messages(List)}.
         *
         * @param messages values
         * @return this builder
         */
        public Builder messages(CounselSystemMessageContent... messages) {
            this.messages = messages == null ? null : Arrays.asList(messages);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselSystemMessageDraft}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselSystemMessageDraft build() {
            CounselSystemMessageDraft built = new CounselSystemMessageDraft(this);
            ModelValidator v = new ModelValidator("CounselSystemMessageDraft");
            v.required("senderKey", built.senderKey);
            v.required("name", built.name);
            v.required("messages", built.messages);
            v.items("messages", built.messages, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselSystemMessageDraft buildUnvalidated() {
            return new CounselSystemMessageDraft(this);
        }
    }
}
