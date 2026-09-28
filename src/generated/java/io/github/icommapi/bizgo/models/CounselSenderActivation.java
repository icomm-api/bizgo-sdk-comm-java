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
 * 상담톡 이용 활성화·비활성화 대상입니다.
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
@JsonDeserialize(builder = CounselSenderActivation.Builder.class)
@JsonPropertyOrder({"senderKey", "committalCompany"})
public final class CounselSenderActivation {

    private final String senderKey;
    private final String committalCompany;

    private CounselSenderActivation(Builder builder) {
        this.senderKey = builder.senderKey;
        this.committalCompany = builder.committalCompany;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.committalCompany = this.committalCompany;
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
     * 위탁사명입니다. 사전에 등록된 경우 생략할 수 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("committalCompany")
    public String getCommittalCompany() {
        return committalCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselSenderActivation)) {
            return false;
        }
        CounselSenderActivation other = (CounselSenderActivation) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(committalCompany, other.committalCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, committalCompany);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselSenderActivation{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (committalCompany != null) {
            joiner.add("committalCompany=" + io.github.icommapi.bizgo.internal.Masking.length(committalCompany));
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselSenderActivation}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String committalCompany;

        /** Creates an empty builder; same as {@link CounselSenderActivation#builder()}. */
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
         * 위탁사명입니다. 사전에 등록된 경우 생략할 수 있습니다.
         *
         * @param committalCompany the value (null clears it)
         * @return this builder
         */
        @JsonProperty("committalCompany")
        public Builder committalCompany(String committalCompany) {
            this.committalCompany = committalCompany;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselSenderActivation}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselSenderActivation build() {
            CounselSenderActivation built = new CounselSenderActivation(this);
            ModelValidator v = new ModelValidator("CounselSenderActivation");
            v.required("senderKey", built.senderKey);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselSenderActivation buildUnvalidated() {
            return new CounselSenderActivation(this);
        }
    }
}
