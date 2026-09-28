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
 * 리치카드, 오픈리치카드에 포함된 content에 대한 검증 정책입니다.
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
@JsonPropertyOrder({"buttonsAllowed", "adHeaderAllowed", "adBodyAllowed", "cardCount", "maxButtonCount", "maxDescriptionSize", "maxMediaSize"})
public final class RcsMessagebasePolicyInfo {

    private final Boolean buttonsAllowed;
    private final Boolean adHeaderAllowed;
    private final Boolean adBodyAllowed;
    private final Long cardCount;
    private final Long maxButtonCount;
    private final Long maxDescriptionSize;
    private final Long maxMediaSize;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsMessagebasePolicyInfo(
            @JsonProperty("buttonsAllowed") Boolean buttonsAllowed,
            @JsonProperty("adHeaderAllowed") Boolean adHeaderAllowed,
            @JsonProperty("adBodyAllowed") Boolean adBodyAllowed,
            @JsonProperty("cardCount") Long cardCount,
            @JsonProperty("maxButtonCount") Long maxButtonCount,
            @JsonProperty("maxDescriptionSize") Long maxDescriptionSize,
            @JsonProperty("maxMediaSize") Long maxMediaSize) {
        this.buttonsAllowed = buttonsAllowed;
        this.adHeaderAllowed = adHeaderAllowed;
        this.adBodyAllowed = adBodyAllowed;
        this.cardCount = cardCount;
        this.maxButtonCount = maxButtonCount;
        this.maxDescriptionSize = maxDescriptionSize;
        this.maxMediaSize = maxMediaSize;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsMessagebasePolicyInfo(Builder builder) {
        this(builder.buttonsAllowed, builder.adHeaderAllowed, builder.adBodyAllowed, builder.cardCount, builder.maxButtonCount, builder.maxDescriptionSize, builder.maxMediaSize);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.buttonsAllowed = this.buttonsAllowed;
        builder.adHeaderAllowed = this.adHeaderAllowed;
        builder.adBodyAllowed = this.adBodyAllowed;
        builder.cardCount = this.cardCount;
        builder.maxButtonCount = this.maxButtonCount;
        builder.maxDescriptionSize = this.maxDescriptionSize;
        builder.maxMediaSize = this.maxMediaSize;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 버튼 사용 가능 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttonsAllowed")
    public Boolean getButtonsAllowed() {
        return buttonsAllowed;
    }

    /**
     * 헤더 광고 문구 사용 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("adHeaderAllowed")
    public Boolean getAdHeaderAllowed() {
        return adHeaderAllowed;
    }

    /**
     * 본문 광고 문구 사용 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("adBodyAllowed")
    public Boolean getAdBodyAllowed() {
        return adBodyAllowed;
    }

    /**
     * 카드 개수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("cardCount")
    public Long getCardCount() {
        return cardCount;
    }

    /**
     * 최대 버튼 개수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("maxButtonCount")
    public Long getMaxButtonCount() {
        return maxButtonCount;
    }

    /**
     * description 영역 최대 글자 수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("maxDescriptionSize")
    public Long getMaxDescriptionSize() {
        return maxDescriptionSize;
    }

    /**
     * 미디어 최대 크기입니다.
     *
     * <p><b>확인 필요:</b> 단위(byte 등)가 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("maxMediaSize")
    public Long getMaxMediaSize() {
        return maxMediaSize;
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
        if (!(o instanceof RcsMessagebasePolicyInfo)) {
            return false;
        }
        RcsMessagebasePolicyInfo other = (RcsMessagebasePolicyInfo) o;
        return Objects.equals(buttonsAllowed, other.buttonsAllowed)
                && Objects.equals(adHeaderAllowed, other.adHeaderAllowed)
                && Objects.equals(adBodyAllowed, other.adBodyAllowed)
                && Objects.equals(cardCount, other.cardCount)
                && Objects.equals(maxButtonCount, other.maxButtonCount)
                && Objects.equals(maxDescriptionSize, other.maxDescriptionSize)
                && Objects.equals(maxMediaSize, other.maxMediaSize)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonsAllowed, adHeaderAllowed, adBodyAllowed, cardCount, maxButtonCount, maxDescriptionSize, maxMediaSize, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsMessagebasePolicyInfo{", "}");
        if (buttonsAllowed != null) {
            joiner.add("buttonsAllowed=***");
        }
        if (adHeaderAllowed != null) {
            joiner.add("adHeaderAllowed=***");
        }
        if (adBodyAllowed != null) {
            joiner.add("adBodyAllowed=***");
        }
        if (cardCount != null) {
            joiner.add("cardCount=***");
        }
        if (maxButtonCount != null) {
            joiner.add("maxButtonCount=***");
        }
        if (maxDescriptionSize != null) {
            joiner.add("maxDescriptionSize=***");
        }
        if (maxMediaSize != null) {
            joiner.add("maxMediaSize=***");
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsMessagebasePolicyInfo}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Boolean buttonsAllowed;
        private Boolean adHeaderAllowed;
        private Boolean adBodyAllowed;
        private Long cardCount;
        private Long maxButtonCount;
        private Long maxDescriptionSize;
        private Long maxMediaSize;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsMessagebasePolicyInfo#builder()}. */
        public Builder() {
        }

        /**
         * 버튼 사용 가능 여부입니다.
         *
         * @param buttonsAllowed the value (null clears it)
         * @return this builder
         */
        public Builder buttonsAllowed(Boolean buttonsAllowed) {
            this.buttonsAllowed = buttonsAllowed;
            return this;
        }

        /**
         * 헤더 광고 문구 사용 여부입니다.
         *
         * @param adHeaderAllowed the value (null clears it)
         * @return this builder
         */
        public Builder adHeaderAllowed(Boolean adHeaderAllowed) {
            this.adHeaderAllowed = adHeaderAllowed;
            return this;
        }

        /**
         * 본문 광고 문구 사용 여부입니다.
         *
         * @param adBodyAllowed the value (null clears it)
         * @return this builder
         */
        public Builder adBodyAllowed(Boolean adBodyAllowed) {
            this.adBodyAllowed = adBodyAllowed;
            return this;
        }

        /**
         * 카드 개수입니다.
         *
         * @param cardCount the value (null clears it)
         * @return this builder
         */
        public Builder cardCount(Long cardCount) {
            this.cardCount = cardCount;
            return this;
        }

        /**
         * 최대 버튼 개수입니다.
         *
         * @param maxButtonCount the value (null clears it)
         * @return this builder
         */
        public Builder maxButtonCount(Long maxButtonCount) {
            this.maxButtonCount = maxButtonCount;
            return this;
        }

        /**
         * description 영역 최대 글자 수입니다.
         *
         * @param maxDescriptionSize the value (null clears it)
         * @return this builder
         */
        public Builder maxDescriptionSize(Long maxDescriptionSize) {
            this.maxDescriptionSize = maxDescriptionSize;
            return this;
        }

        /**
         * 미디어 최대 크기입니다.
         *
         * <p><b>확인 필요:</b> 단위(byte 등)가 문서화되어 있지 않습니다.
         *
         * @param maxMediaSize the value (null clears it)
         * @return this builder
         */
        public Builder maxMediaSize(Long maxMediaSize) {
            this.maxMediaSize = maxMediaSize;
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
         * @return a new immutable {@code RcsMessagebasePolicyInfo}
         */
        public RcsMessagebasePolicyInfo build() {
            return new RcsMessagebasePolicyInfo(this);
        }
    }
}
