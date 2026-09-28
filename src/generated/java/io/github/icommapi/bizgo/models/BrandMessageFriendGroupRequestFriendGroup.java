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
 * 친구 그룹 정보입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> <code>fileKey</code>와 <code>phoneNumbers</code>를 둘 다 보내거나 둘 다 생략할 때의 동작이 문서에 없습니다. 친구 그룹 등록 시 <code>friendGroupKey</code>를 고객이 정하는지(요청 필수)만 명시되어 있습니다.
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
@JsonDeserialize(builder = BrandMessageFriendGroupRequestFriendGroup.Builder.class)
@JsonPropertyOrder({"senderKey", "friendGroupKey", "fileKey", "phoneNumbers"})
public final class BrandMessageFriendGroupRequestFriendGroup {

    private final String senderKey;
    private final String friendGroupKey;
    private final String fileKey;
    private final List<String> phoneNumbers;

    private BrandMessageFriendGroupRequestFriendGroup(Builder builder) {
        this.senderKey = builder.senderKey;
        this.friendGroupKey = builder.friendGroupKey;
        this.fileKey = builder.fileKey;
        this.phoneNumbers = builder.phoneNumbers == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.phoneNumbers));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.friendGroupKey = this.friendGroupKey;
        builder.fileKey = this.fileKey;
        builder.phoneNumbers = this.phoneNumbers;
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
     * 친구 그룹 키입니다. 1~50자이며 한글·영문·숫자와 일부 특수문자를 쓸 수 있습니다.
     *
     * <p>필수 · 최대 50자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("friendGroupKey")
    public String getFriendGroupKey() {
        return friendGroupKey;
    }

    /**
     * 친구 그룹 파일 업로드로 발급받은 임시 파일 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileKey")
    public String getFileKey() {
        return fileKey;
    }

    /**
     * 전화번호 목록입니다. 1~10,000건입니다.
     *
     * <p>항목 수 1~10000
     *
     * @return the value, or null if not set
     */
    @JsonProperty("phoneNumbers")
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageFriendGroupRequestFriendGroup)) {
            return false;
        }
        BrandMessageFriendGroupRequestFriendGroup other = (BrandMessageFriendGroupRequestFriendGroup) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(friendGroupKey, other.friendGroupKey)
                && Objects.equals(fileKey, other.fileKey)
                && Objects.equals(phoneNumbers, other.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, friendGroupKey, fileKey, phoneNumbers);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageFriendGroupRequestFriendGroup{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (friendGroupKey != null) {
            joiner.add("friendGroupKey=" + io.github.icommapi.bizgo.internal.Masking.length(friendGroupKey));
        }
        if (fileKey != null) {
            joiner.add("fileKey=" + fileKey);
        }
        if (phoneNumbers != null) {
            joiner.add("phoneNumbers=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageFriendGroupRequestFriendGroup}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private String friendGroupKey;
        private String fileKey;
        private List<String> phoneNumbers;

        /** Creates an empty builder; same as {@link BrandMessageFriendGroupRequestFriendGroup#builder()}. */
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
         * 친구 그룹 키입니다. 1~50자이며 한글·영문·숫자와 일부 특수문자를 쓸 수 있습니다.
         *
         * <p>필수 · 최대 50자
         *
         * @param friendGroupKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("friendGroupKey")
        public Builder friendGroupKey(String friendGroupKey) {
            this.friendGroupKey = friendGroupKey;
            return this;
        }

        /**
         * 친구 그룹 파일 업로드로 발급받은 임시 파일 키입니다.
         *
         * @param fileKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fileKey")
        public Builder fileKey(String fileKey) {
            this.fileKey = fileKey;
            return this;
        }

        /**
         * 전화번호 목록입니다. 1~10,000건입니다.
         *
         * <p>항목 수 1~10000
         *
         * @param phoneNumbers the value (null clears it)
         * @return this builder
         */
        @JsonProperty("phoneNumbers")
        public Builder phoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        /**
         * Varargs form of {@link #phoneNumbers(List)}.
         *
         * @param phoneNumbers values
         * @return this builder
         */
        public Builder phoneNumbers(String... phoneNumbers) {
            this.phoneNumbers = phoneNumbers == null ? null : Arrays.asList(phoneNumbers);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageFriendGroupRequestFriendGroup}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageFriendGroupRequestFriendGroup build() {
            BrandMessageFriendGroupRequestFriendGroup built = new BrandMessageFriendGroupRequestFriendGroup(this);
            ModelValidator v = new ModelValidator("BrandMessageFriendGroupRequestFriendGroup");
            v.required("senderKey", built.senderKey);
            v.required("friendGroupKey", built.friendGroupKey);
            v.maxLength("friendGroupKey", built.friendGroupKey, 50);
            v.items("phoneNumbers", built.phoneNumbers, 1, 10000);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageFriendGroupRequestFriendGroup buildUnvalidated() {
            return new BrandMessageFriendGroupRequestFriendGroup(this);
        }
    }
}
