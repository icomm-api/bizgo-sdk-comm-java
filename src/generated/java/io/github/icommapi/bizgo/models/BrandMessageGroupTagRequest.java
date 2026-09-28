// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 그룹태그 등록·수정 요청입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 등록·수정 요청 본문에 <code>senderKey</code>가 없습니다(Part A·B 동일). 어떤 발신프로필에 등록되는지, 키·이름 길이 제한이 문서에 없습니다.
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
@JsonDeserialize(builder = BrandMessageGroupTagRequest.Builder.class)
@JsonPropertyOrder({"groupTag"})
public final class BrandMessageGroupTagRequest {

    private final BrandMessageGroupTagRequestGroupTag groupTag;

    private BrandMessageGroupTagRequest(Builder builder) {
        this.groupTag = builder.groupTag;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.groupTag = this.groupTag;
        return builder;
    }

    /**
     * Parse and validate a request written with the API field names (JSON).
     * Unknown fields are rejected so that typos fail before anything is sent.
     *
     * @param json request body, for example an example from the API reference
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageGroupTagRequest fromJson(String json) {
        return RequestParser.parse(json, BrandMessageGroupTagRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static BrandMessageGroupTagRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, BrandMessageGroupTagRequest.class);
    }

    /**
     * The JSON body that is sent. Contains phone numbers: do not log it.
     *
     * @return JSON with only the fields that were set
     */
    public String toJson() {
        return RequestParser.toJson(this);
    }

    /**
     * 브랜드메시지 그룹태그 정보입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupTag")
    public BrandMessageGroupTagRequestGroupTag getGroupTag() {
        return groupTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageGroupTagRequest)) {
            return false;
        }
        BrandMessageGroupTagRequest other = (BrandMessageGroupTagRequest) o;
        return Objects.equals(groupTag, other.groupTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupTag);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageGroupTagRequest{", "}");
        if (groupTag != null) {
            joiner.add("groupTag=" + groupTag);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageGroupTagRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private BrandMessageGroupTagRequestGroupTag groupTag;

        /** Creates an empty builder; same as {@link BrandMessageGroupTagRequest#builder()}. */
        public Builder() {
        }

        /**
         * 브랜드메시지 그룹태그 정보입니다.
         *
         * <p>필수
         *
         * @param groupTag the value (null clears it)
         * @return this builder
         */
        @JsonProperty("groupTag")
        public Builder groupTag(BrandMessageGroupTagRequestGroupTag groupTag) {
            this.groupTag = groupTag;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageGroupTagRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageGroupTagRequest build() {
            BrandMessageGroupTagRequest built = new BrandMessageGroupTagRequest(this);
            ModelValidator v = new ModelValidator("BrandMessageGroupTagRequest");
            v.required("groupTag", built.groupTag);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageGroupTagRequest buildUnvalidated() {
            return new BrandMessageGroupTagRequest(this);
        }
    }
}
