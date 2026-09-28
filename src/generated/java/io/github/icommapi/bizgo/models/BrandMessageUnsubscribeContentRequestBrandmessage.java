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
 * 무료수신거부 정보입니다.
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
@JsonDeserialize(builder = BrandMessageUnsubscribeContentRequestBrandmessage.Builder.class)
@JsonPropertyOrder({"senderKey", "unsubscribePhoneNumber", "unsubscribeAuthNumber"})
public final class BrandMessageUnsubscribeContentRequestBrandmessage {

    private final String senderKey;
    private final String unsubscribePhoneNumber;
    private final String unsubscribeAuthNumber;

    private BrandMessageUnsubscribeContentRequestBrandmessage(Builder builder) {
        this.senderKey = builder.senderKey;
        this.unsubscribePhoneNumber = builder.unsubscribePhoneNumber;
        this.unsubscribeAuthNumber = builder.unsubscribeAuthNumber;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.unsubscribePhoneNumber = this.unsubscribePhoneNumber;
        builder.unsubscribeAuthNumber = this.unsubscribeAuthNumber;
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
     * 무료수신거부 전화번호입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 하이픈 포함 여부·길이 제한이 문서에 없습니다(예시는 하이픈 포함). 발송 규격의 같은 필드는 최대 13자입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("unsubscribePhoneNumber")
    public String getUnsubscribePhoneNumber() {
        return unsubscribePhoneNumber;
    }

    /**
     * 무료수신거부 인증번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("unsubscribeAuthNumber")
    public String getUnsubscribeAuthNumber() {
        return unsubscribeAuthNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageUnsubscribeContentRequestBrandmessage)) {
            return false;
        }
        BrandMessageUnsubscribeContentRequestBrandmessage other = (BrandMessageUnsubscribeContentRequestBrandmessage) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(unsubscribePhoneNumber, other.unsubscribePhoneNumber)
                && Objects.equals(unsubscribeAuthNumber, other.unsubscribeAuthNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, unsubscribePhoneNumber, unsubscribeAuthNumber);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageUnsubscribeContentRequestBrandmessage{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (unsubscribePhoneNumber != null) {
            joiner.add("unsubscribePhoneNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(unsubscribePhoneNumber));
        }
        if (unsubscribeAuthNumber != null) {
            joiner.add("unsubscribeAuthNumber=" + io.github.icommapi.bizgo.internal.Masking.length(unsubscribeAuthNumber));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageUnsubscribeContentRequestBrandmessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String unsubscribePhoneNumber;
        private String unsubscribeAuthNumber;

        /** Creates an empty builder; same as {@link BrandMessageUnsubscribeContentRequestBrandmessage#builder()}. */
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
         * 무료수신거부 전화번호입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 하이픈 포함 여부·길이 제한이 문서에 없습니다(예시는 하이픈 포함). 발송 규격의 같은 필드는 최대 13자입니다.
         *
         * @param unsubscribePhoneNumber the value (null clears it)
         * @return this builder
         */
        @JsonProperty("unsubscribePhoneNumber")
        public Builder unsubscribePhoneNumber(String unsubscribePhoneNumber) {
            this.unsubscribePhoneNumber = unsubscribePhoneNumber;
            return this;
        }

        /**
         * 무료수신거부 인증번호입니다.
         *
         * @param unsubscribeAuthNumber the value (null clears it)
         * @return this builder
         */
        @JsonProperty("unsubscribeAuthNumber")
        public Builder unsubscribeAuthNumber(String unsubscribeAuthNumber) {
            this.unsubscribeAuthNumber = unsubscribeAuthNumber;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageUnsubscribeContentRequestBrandmessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageUnsubscribeContentRequestBrandmessage build() {
            BrandMessageUnsubscribeContentRequestBrandmessage built = new BrandMessageUnsubscribeContentRequestBrandmessage(this);
            ModelValidator v = new ModelValidator("BrandMessageUnsubscribeContentRequestBrandmessage");
            v.required("senderKey", built.senderKey);
            v.required("unsubscribePhoneNumber", built.unsubscribePhoneNumber);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageUnsubscribeContentRequestBrandmessage buildUnvalidated() {
            return new BrandMessageUnsubscribeContentRequestBrandmessage(this);
        }
    }
}
