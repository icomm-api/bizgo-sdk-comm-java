// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 현재 메타 정보가 없을 때 전달되는 가장 마지막 메타 정보입니다.
 *
 * <p>Response model: unknown JSON properties are kept in {@link #getAdditionalProperties()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({"extra", "bot", "bot_event", "created_at"})
public final class CounselLastReference {

    private final String extra;
    private final String bot;
    private final String bot_event;
    private final String created_at;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselLastReference(
            @JsonProperty("extra") String extra,
            @JsonProperty("bot") String bot,
            @JsonProperty("bot_event") String bot_event,
            @JsonProperty("created_at") String created_at) {
        this.extra = extra;
        this.bot = bot;
        this.bot_event = bot_event;
        this.created_at = created_at;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselLastReference(Builder builder) {
        this(builder.extra, builder.bot, builder.bot_event, builder.created_at);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.extra = this.extra;
        builder.bot = this.bot;
        builder.bot_event = this.bot_event;
        builder.created_at = this.created_at;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 이전 상담 연결 버튼으로 전달된 메타 정보입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("extra")
    public String getExtra() {
        return extra;
    }

    /**
     * 상담을 어떻게 시작했는지 나타내는 값입니다. 문서 예시 값은 문자열 <code>false</code>입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bot")
    public String getBot() {
        return bot;
    }

    /**
     * 봇으로 상담을 시작했을 때 전달되는 봇 블록 이벤트 값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("bot_event")
    public String getBot_event() {
        return bot_event;
    }

    /**
     * 마지막 메타 정보 생성 시각입니다.
     *
     * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("created_at")
    public String getCreated_at() {
        return created_at;
    }

    /**
     * Properties the server sent that are not in the spec (new fields are kept instead of dropped).
     *
     * @return unmodifiable map, empty if there are none
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnySetter
    private void putAdditionalProperty(String name, Object value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselLastReference)) {
            return false;
        }
        CounselLastReference other = (CounselLastReference) o;
        return Objects.equals(extra, other.extra)
                && Objects.equals(bot, other.bot)
                && Objects.equals(bot_event, other.bot_event)
                && Objects.equals(created_at, other.created_at)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extra, bot, bot_event, created_at, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselLastReference{", "}");
        if (extra != null) {
            joiner.add("extra=" + io.github.icommapi.bizgo.internal.Masking.length(extra));
        }
        if (bot != null) {
            joiner.add("bot=" + io.github.icommapi.bizgo.internal.Masking.length(bot));
        }
        if (bot_event != null) {
            joiner.add("bot_event=" + io.github.icommapi.bizgo.internal.Masking.length(bot_event));
        }
        if (created_at != null) {
            joiner.add("created_at=" + io.github.icommapi.bizgo.internal.Masking.length(created_at));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselLastReference}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String extra;
        private String bot;
        private String bot_event;
        private String created_at;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselLastReference#builder()}. */
        public Builder() {
        }

        /**
         * 이전 상담 연결 버튼으로 전달된 메타 정보입니다.
         *
         * @param extra the value (null clears it)
         * @return this builder
         */
        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        /**
         * 상담을 어떻게 시작했는지 나타내는 값입니다. 문서 예시 값은 문자열 <code>false</code>입니다.
         *
         * @param bot the value (null clears it)
         * @return this builder
         */
        public Builder bot(String bot) {
            this.bot = bot;
            return this;
        }

        /**
         * 봇으로 상담을 시작했을 때 전달되는 봇 블록 이벤트 값입니다.
         *
         * @param bot_event the value (null clears it)
         * @return this builder
         */
        public Builder bot_event(String bot_event) {
            this.bot_event = bot_event;
            return this;
        }

        /**
         * 마지막 메타 정보 생성 시각입니다.
         *
         * <p>형식 <code>yyyy-MM-dd'T'HH:mm:ss.SSSXXX</code>
         *
         * @param created_at the value (null clears it)
         * @return this builder
         */
        public Builder created_at(String created_at) {
            this.created_at = created_at;
            return this;
        }

        /**
         * Adds a property that is not in the spec.
         *
         * @param name JSON property name
         * @param value value
         * @return this builder
         */
        public Builder additionalProperty(String name, Object value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code CounselLastReference}
         */
        public CounselLastReference build() {
            return new CounselLastReference(this);
        }
    }
}
