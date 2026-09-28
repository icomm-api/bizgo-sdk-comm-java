// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 삭제할 상담톡 메시지입니다.
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
@JsonDeserialize(builder = CounselMessageDeleteTarget.Builder.class)
@JsonPropertyOrder({"senderKey", "userKey", "msgKey"})
public final class CounselMessageDeleteTarget {

    private final String senderKey;
    private final String userKey;
    private final String msgKey;

    private CounselMessageDeleteTarget(Builder builder) {
        this.senderKey = builder.senderKey;
        this.userKey = builder.userKey;
        this.msgKey = builder.msgKey;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.userKey = this.userKey;
        builder.msgKey = this.msgKey;
        return builder;
    }

    /**
     * 발신프로필 키입니다. 호출자 소유가 아니면 <code>A502</code>로 거부됩니다.
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
     * 메시지를 받은 사용자 키입니다.
     *
     * <p>필수 · 최대 20자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("userKey")
    public String getUserKey() {
        return userKey;
    }

    /**
     * 삭제할 메시지의 발송 시 msgKey입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgKey")
    public String getMsgKey() {
        return msgKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselMessageDeleteTarget)) {
            return false;
        }
        CounselMessageDeleteTarget other = (CounselMessageDeleteTarget) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(userKey, other.userKey)
                && Objects.equals(msgKey, other.msgKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, userKey, msgKey);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselMessageDeleteTarget{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (userKey != null) {
            joiner.add("userKey=" + io.github.icommapi.bizgo.internal.Masking.length(userKey));
        }
        if (msgKey != null) {
            joiner.add("msgKey=" + msgKey);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselMessageDeleteTarget}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String userKey;
        private String msgKey;

        /** Creates an empty builder; same as {@link CounselMessageDeleteTarget#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다. 호출자 소유가 아니면 <code>A502</code>로 거부됩니다.
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
         * 메시지를 받은 사용자 키입니다.
         *
         * <p>필수 · 최대 20자
         *
         * @param userKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("userKey")
        public Builder userKey(String userKey) {
            this.userKey = userKey;
            return this;
        }

        /**
         * 삭제할 메시지의 발송 시 msgKey입니다.
         *
         * <p>필수
         *
         * @param msgKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("msgKey")
        public Builder msgKey(String msgKey) {
            this.msgKey = msgKey;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselMessageDeleteTarget}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselMessageDeleteTarget build() {
            CounselMessageDeleteTarget built = new CounselMessageDeleteTarget(this);
            ModelValidator v = new ModelValidator("CounselMessageDeleteTarget");
            v.required("senderKey", built.senderKey);
            v.required("userKey", built.userKey);
            v.maxLength("userKey", built.userKey, 20);
            v.required("msgKey", built.msgKey);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselMessageDeleteTarget buildUnvalidated() {
            return new CounselMessageDeleteTarget(this);
        }
    }
}
