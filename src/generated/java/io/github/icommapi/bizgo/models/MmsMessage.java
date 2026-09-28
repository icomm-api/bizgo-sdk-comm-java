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
import java.util.regex.Pattern;

/**
 * LMS(장문) 또는 MMS(이미지+장문) 메시지입니다. <code>fileKey</code>가 있으면 MMS, 없으면 LMS로 발송됩니다.
 *
 * <p>Sent as {@code messageFlow[].mms}.
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
@JsonDeserialize(builder = MmsMessage.Builder.class)
@JsonPropertyOrder({"from", "title", "text", "fileKey", "ttl", "originCID"})
public final class MmsMessage implements ChannelMessage {

    /** {@code messageFlow} channel key of this message. */
    public static final String CHANNEL_KEY = "mms";
    private static final Pattern TTL_PATTERN = Pattern.compile("^[0-9]+$");

    private final String from;
    private final String title;
    private final String text;
    private final List<String> fileKey;
    private final String ttl;
    private final String originCID;

    private MmsMessage(Builder builder) {
        this.from = builder.from;
        this.title = builder.title;
        this.text = builder.text;
        this.fileKey = builder.fileKey == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.fileKey));
        this.ttl = builder.ttl;
        this.originCID = builder.originCID;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.from = this.from;
        builder.title = this.title;
        builder.text = this.text;
        builder.fileKey = this.fileKey;
        builder.ttl = this.ttl;
        builder.originCID = this.originCID;
        return builder;
    }

    @Override
    public String channelKey() {
        return CHANNEL_KEY;
    }

    /**
     * 발신번호입니다. 비즈고에 미리 등록한 번호여야 합니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 본문입니다. 최대 2,000byte이며, 이통사 규격상 EUC-KR 범위 밖 문자는 접수 오류가 날 수 있습니다.
     *
     * <p>필수 · 최대 2000byte(EUC-KR)
     *
     * @return the value, or null if not set
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 이미지 업로드(<code>POST /api/comm/v1/file/mms</code>)로 받은 파일 키입니다. MMS 발송 시 필수이며 최대 3개입니다. 이미지 순서는 보장되지 않습니다.
     *
     * <p>항목 수 1~3
     *
     * @return the value, or null if not set
     */
    @JsonProperty("fileKey")
    public List<String> getFileKey() {
        return fileKey;
    }

    /**
     * 이통사 전달까지 유효한 최대 시간(초)입니다. 시간이 지나면 실패 처리됩니다.
     *
     * <p>형식 <code>^[0-9]+$</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ttl")
    public String getTtl() {
        return ttl;
    }

    /**
     * 최초 발신사업자 식별코드(9자리)입니다. 일반 고객은 입력하지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("originCID")
    public String getOriginCID() {
        return originCID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MmsMessage)) {
            return false;
        }
        MmsMessage other = (MmsMessage) o;
        return Objects.equals(from, other.from)
                && Objects.equals(title, other.title)
                && Objects.equals(text, other.text)
                && Objects.equals(fileKey, other.fileKey)
                && Objects.equals(ttl, other.ttl)
                && Objects.equals(originCID, other.originCID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, title, text, fileKey, ttl, originCID);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "MmsMessage{", "}");
        if (from != null) {
            joiner.add("from=" + io.github.icommapi.bizgo.internal.Masking.phone(from));
        }
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (text != null) {
            joiner.add("text=" + io.github.icommapi.bizgo.internal.Masking.length(text));
        }
        if (fileKey != null) {
            joiner.add("fileKey=" + fileKey);
        }
        if (ttl != null) {
            joiner.add("ttl=" + io.github.icommapi.bizgo.internal.Masking.length(ttl));
        }
        if (originCID != null) {
            joiner.add("originCID=" + io.github.icommapi.bizgo.internal.Masking.length(originCID));
        }
        return joiner.toString();
    }

    /** Builder for {@link MmsMessage}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String from;
        private String title;
        private String text;
        private List<String> fileKey;
        private String ttl;
        private String originCID;

        /** Creates an empty builder; same as {@link MmsMessage#builder()}. */
        public Builder() {
        }

        /**
         * 발신번호입니다. 비즈고에 미리 등록한 번호여야 합니다.
         *
         * <p>필수
         *
         * @param from the value (null clears it)
         * @return this builder
         */
        @JsonProperty("from")
        public Builder from(String from) {
            this.from = from;
            return this;
        }

        /**
         * 제목입니다.
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        @JsonProperty("title")
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 본문입니다. 최대 2,000byte이며, 이통사 규격상 EUC-KR 범위 밖 문자는 접수 오류가 날 수 있습니다.
         *
         * <p>필수 · 최대 2000byte(EUC-KR)
         *
         * @param text the value (null clears it)
         * @return this builder
         */
        @JsonProperty("text")
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * 이미지 업로드(<code>POST /api/comm/v1/file/mms</code>)로 받은 파일 키입니다. MMS 발송 시 필수이며 최대 3개입니다. 이미지 순서는 보장되지 않습니다.
         *
         * <p>항목 수 1~3
         *
         * @param fileKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("fileKey")
        public Builder fileKey(List<String> fileKey) {
            this.fileKey = fileKey;
            return this;
        }

        /**
         * Varargs form of {@link #fileKey(List)}.
         *
         * @param fileKey values
         * @return this builder
         */
        public Builder fileKey(String... fileKey) {
            this.fileKey = fileKey == null ? null : Arrays.asList(fileKey);
            return this;
        }

        /**
         * 이통사 전달까지 유효한 최대 시간(초)입니다. 시간이 지나면 실패 처리됩니다.
         *
         * <p>형식 <code>^[0-9]+$</code>
         *
         * @param ttl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("ttl")
        public Builder ttl(String ttl) {
            this.ttl = ttl;
            return this;
        }

        /**
         * 최초 발신사업자 식별코드(9자리)입니다. 일반 고객은 입력하지 않습니다.
         *
         * @param originCID the value (null clears it)
         * @return this builder
         */
        @JsonProperty("originCID")
        public Builder originCID(String originCID) {
            this.originCID = originCID;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code MmsMessage}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public MmsMessage build() {
            MmsMessage built = new MmsMessage(this);
            ModelValidator v = new ModelValidator("MmsMessage");
            v.required("from", built.from);
            v.required("text", built.text);
            v.maxBytes("text", built.text, 2000, "EUC-KR");
            v.items("fileKey", built.fileKey, 1, 3);
            v.pattern("ttl", built.ttl, TTL_PATTERN);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        MmsMessage buildUnvalidated() {
            return new MmsMessage(this);
        }
    }
}
