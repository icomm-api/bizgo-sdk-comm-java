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
 * 브랜드메시지 그룹태그 정보입니다.
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
@JsonDeserialize(builder = BrandMessageGroupTagRequestGroupTag.Builder.class)
@JsonPropertyOrder({"groupTagKey", "groupTagName"})
public final class BrandMessageGroupTagRequestGroupTag {

    private final String groupTagKey;
    private final String groupTagName;

    private BrandMessageGroupTagRequestGroupTag(Builder builder) {
        this.groupTagKey = builder.groupTagKey;
        this.groupTagName = builder.groupTagName;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.groupTagKey = this.groupTagKey;
        builder.groupTagName = this.groupTagName;
        return builder;
    }

    /**
     * 그룹태그 키입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupTagKey")
    public String getGroupTagKey() {
        return groupTagKey;
    }

    /**
     * 그룹태그 이름입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupTagName")
    public String getGroupTagName() {
        return groupTagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageGroupTagRequestGroupTag)) {
            return false;
        }
        BrandMessageGroupTagRequestGroupTag other = (BrandMessageGroupTagRequestGroupTag) o;
        return Objects.equals(groupTagKey, other.groupTagKey)
                && Objects.equals(groupTagName, other.groupTagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupTagKey, groupTagName);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageGroupTagRequestGroupTag{", "}");
        if (groupTagKey != null) {
            joiner.add("groupTagKey=" + io.github.icommapi.bizgo.internal.Masking.length(groupTagKey));
        }
        if (groupTagName != null) {
            joiner.add("groupTagName=" + io.github.icommapi.bizgo.internal.Masking.length(groupTagName));
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageGroupTagRequestGroupTag}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String groupTagKey;
        private String groupTagName;

        /** Creates an empty builder; same as {@link BrandMessageGroupTagRequestGroupTag#builder()}. */
        public Builder() {
        }

        /**
         * 그룹태그 키입니다.
         *
         * <p>필수
         *
         * @param groupTagKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("groupTagKey")
        public Builder groupTagKey(String groupTagKey) {
            this.groupTagKey = groupTagKey;
            return this;
        }

        /**
         * 그룹태그 이름입니다.
         *
         * <p>필수
         *
         * @param groupTagName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("groupTagName")
        public Builder groupTagName(String groupTagName) {
            this.groupTagName = groupTagName;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageGroupTagRequestGroupTag}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageGroupTagRequestGroupTag build() {
            BrandMessageGroupTagRequestGroupTag built = new BrandMessageGroupTagRequestGroupTag(this);
            ModelValidator v = new ModelValidator("BrandMessageGroupTagRequestGroupTag");
            v.required("groupTagKey", built.groupTagKey);
            v.required("groupTagName", built.groupTagName);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageGroupTagRequestGroupTag buildUnvalidated() {
            return new BrandMessageGroupTagRequestGroupTag(this);
        }
    }
}
