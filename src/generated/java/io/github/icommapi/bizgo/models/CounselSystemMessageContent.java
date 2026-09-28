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
 * 시스템 메시지 1건의 내용입니다.
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
@JsonDeserialize(builder = CounselSystemMessageContent.Builder.class)
@JsonPropertyOrder({"messageType", "content", "buttons"})
public final class CounselSystemMessageContent {

    private final String messageType;
    private final String content;
    private final List<CounselSystemMessageButton> buttons;

    private CounselSystemMessageContent(Builder builder) {
        this.messageType = builder.messageType;
        this.content = builder.content;
        this.buttons = builder.buttons == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.buttons));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.messageType = this.messageType;
        builder.content = this.content;
        builder.buttons = this.buttons;
        return builder;
    }

    /**
     * 시스템 메시지 타입입니다. 문서 예시 값은 <code>ST</code>입니다.
     *
     * <p>필수 · 알려진 값 <code>ST</code>
     *
     * <p><b>확인 필요:</b> messageType 코드 목록과 의미가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messageType")
    public String getMessageType() {
        return messageType;
    }

    /**
     * 메시지 내용입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 메시지 하단 버튼 목록입니다. 등록 요청에서는 필수로 표시되어 있습니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttons")
    public List<CounselSystemMessageButton> getButtons() {
        return buttons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselSystemMessageContent)) {
            return false;
        }
        CounselSystemMessageContent other = (CounselSystemMessageContent) o;
        return Objects.equals(messageType, other.messageType)
                && Objects.equals(content, other.content)
                && Objects.equals(buttons, other.buttons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageType, content, buttons);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselSystemMessageContent{", "}");
        if (messageType != null) {
            joiner.add("messageType=" + io.github.icommapi.bizgo.internal.Masking.length(messageType));
        }
        if (content != null) {
            joiner.add("content=" + io.github.icommapi.bizgo.internal.Masking.length(content));
        }
        if (buttons != null) {
            joiner.add("buttons=" + buttons);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselSystemMessageContent}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String messageType;
        private String content;
        private List<CounselSystemMessageButton> buttons;

        /** Creates an empty builder; same as {@link CounselSystemMessageContent#builder()}. */
        public Builder() {
        }

        /**
         * 시스템 메시지 타입입니다. 문서 예시 값은 <code>ST</code>입니다.
         *
         * <p>필수 · 알려진 값 <code>ST</code>
         *
         * <p><b>확인 필요:</b> messageType 코드 목록과 의미가 문서에 없습니다.
         *
         * @param messageType the value (null clears it)
         * @return this builder
         */
        @JsonProperty("messageType")
        public Builder messageType(String messageType) {
            this.messageType = messageType;
            return this;
        }

        /**
         * 메시지 내용입니다.
         *
         * <p>필수
         *
         * @param content the value (null clears it)
         * @return this builder
         */
        @JsonProperty("content")
        public Builder content(String content) {
            this.content = content;
            return this;
        }

        /**
         * 메시지 하단 버튼 목록입니다. 등록 요청에서는 필수로 표시되어 있습니다.
         *
         * <p>필수
         *
         * @param buttons the value (null clears it)
         * @return this builder
         */
        @JsonProperty("buttons")
        public Builder buttons(List<CounselSystemMessageButton> buttons) {
            this.buttons = buttons;
            return this;
        }

        /**
         * Varargs form of {@link #buttons(List)}.
         *
         * @param buttons values
         * @return this builder
         */
        public Builder buttons(CounselSystemMessageButton... buttons) {
            this.buttons = buttons == null ? null : Arrays.asList(buttons);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselSystemMessageContent}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselSystemMessageContent build() {
            CounselSystemMessageContent built = new CounselSystemMessageContent(this);
            ModelValidator v = new ModelValidator("CounselSystemMessageContent");
            v.required("messageType", built.messageType);
            v.required("content", built.content);
            v.required("buttons", built.buttons);
            v.items("buttons", built.buttons, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselSystemMessageContent buildUnvalidated() {
            return new CounselSystemMessageContent(this);
        }
    }
}
