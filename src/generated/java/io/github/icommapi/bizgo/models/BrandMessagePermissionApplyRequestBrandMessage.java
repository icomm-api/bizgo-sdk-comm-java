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
 * 발송 권한 신청 정보입니다. 다른 브랜드메시지 API와 달리 키 이름이 <code>brandMessage</code>(대문자 M)입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 다른 API는 <code>brandmessage</code>(소문자)를 쓰는데 이 API만 <code>brandMessage</code>로 표기되어 있습니다(Part A·B 동일). 서버가 대소문자를 구분하는지 확인이 필요합니다.
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
@JsonDeserialize(builder = BrandMessagePermissionApplyRequestBrandMessage.Builder.class)
@JsonPropertyOrder({"senderKey"})
public final class BrandMessagePermissionApplyRequestBrandMessage {

    private final String senderKey;

    private BrandMessagePermissionApplyRequestBrandMessage(Builder builder) {
        this.senderKey = builder.senderKey;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        return builder;
    }

    /**
     * 발신프로필 키입니다. 최대 40자입니다.
     *
     * <p>필수 · 최대 40자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessagePermissionApplyRequestBrandMessage)) {
            return false;
        }
        BrandMessagePermissionApplyRequestBrandMessage other = (BrandMessagePermissionApplyRequestBrandMessage) o;
        return Objects.equals(senderKey, other.senderKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessagePermissionApplyRequestBrandMessage{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessagePermissionApplyRequestBrandMessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;

        /** Creates an empty builder; same as {@link BrandMessagePermissionApplyRequestBrandMessage#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다. 최대 40자입니다.
         *
         * <p>필수 · 최대 40자
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
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessagePermissionApplyRequestBrandMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessagePermissionApplyRequestBrandMessage build() {
            BrandMessagePermissionApplyRequestBrandMessage built = new BrandMessagePermissionApplyRequestBrandMessage(this);
            ModelValidator v = new ModelValidator("BrandMessagePermissionApplyRequestBrandMessage");
            v.required("senderKey", built.senderKey);
            v.maxLength("senderKey", built.senderKey, 40);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessagePermissionApplyRequestBrandMessage buildUnvalidated() {
            return new BrandMessagePermissionApplyRequestBrandMessage(this);
        }
    }
}
