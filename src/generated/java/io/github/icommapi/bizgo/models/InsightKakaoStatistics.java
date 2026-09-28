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
 * 카카오(알림톡·브랜드메시지) 발송·읽음·클릭 통계 1건입니다. 카카오가 직접 제공하는 채널 기반 통계입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 비율 필드(sendRate·readRate·clickRate·ctr)의 단위(백분율 여부)와 소수 자릿수가 문서에 없습니다. 예시 값(98.57 등)은 백분율로 보입니다.
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
@JsonPropertyOrder({"successCount", "failCount", "readCount", "buttonClickCount", "listClickCount", "thumbnailClickCount", "etcClickCount", "sendRate", "readRate", "clickRate", "ctr"})
public final class InsightKakaoStatistics {

    private final Long successCount;
    private final Long failCount;
    private final Long readCount;
    private final Long buttonClickCount;
    private final Long listClickCount;
    private final Long thumbnailClickCount;
    private final Long etcClickCount;
    private final Double sendRate;
    private final Double readRate;
    private final Double clickRate;
    private final Double ctr;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private InsightKakaoStatistics(
            @JsonProperty("successCount") Long successCount,
            @JsonProperty("failCount") Long failCount,
            @JsonProperty("readCount") Long readCount,
            @JsonProperty("buttonClickCount") Long buttonClickCount,
            @JsonProperty("listClickCount") Long listClickCount,
            @JsonProperty("thumbnailClickCount") Long thumbnailClickCount,
            @JsonProperty("etcClickCount") Long etcClickCount,
            @JsonProperty("sendRate") Double sendRate,
            @JsonProperty("readRate") Double readRate,
            @JsonProperty("clickRate") Double clickRate,
            @JsonProperty("ctr") Double ctr) {
        this.successCount = successCount;
        this.failCount = failCount;
        this.readCount = readCount;
        this.buttonClickCount = buttonClickCount;
        this.listClickCount = listClickCount;
        this.thumbnailClickCount = thumbnailClickCount;
        this.etcClickCount = etcClickCount;
        this.sendRate = sendRate;
        this.readRate = readRate;
        this.clickRate = clickRate;
        this.ctr = ctr;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private InsightKakaoStatistics(Builder builder) {
        this(builder.successCount, builder.failCount, builder.readCount, builder.buttonClickCount, builder.listClickCount, builder.thumbnailClickCount, builder.etcClickCount, builder.sendRate, builder.readRate, builder.clickRate, builder.ctr);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.successCount = this.successCount;
        builder.failCount = this.failCount;
        builder.readCount = this.readCount;
        builder.buttonClickCount = this.buttonClickCount;
        builder.listClickCount = this.listClickCount;
        builder.thumbnailClickCount = this.thumbnailClickCount;
        builder.etcClickCount = this.etcClickCount;
        builder.sendRate = this.sendRate;
        builder.readRate = this.readRate;
        builder.clickRate = this.clickRate;
        builder.ctr = this.ctr;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 발송 성공 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("successCount")
    public Long getSuccessCount() {
        return successCount;
    }

    /**
     * 발송 실패 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("failCount")
    public Long getFailCount() {
        return failCount;
    }

    /**
     * 읽음 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("readCount")
    public Long getReadCount() {
        return readCount;
    }

    /**
     * 버튼 클릭 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttonClickCount")
    public Long getButtonClickCount() {
        return buttonClickCount;
    }

    /**
     * 목록 클릭 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("listClickCount")
    public Long getListClickCount() {
        return listClickCount;
    }

    /**
     * 썸네일 클릭 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("thumbnailClickCount")
    public Long getThumbnailClickCount() {
        return thumbnailClickCount;
    }

    /**
     * 기타 클릭 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("etcClickCount")
    public Long getEtcClickCount() {
        return etcClickCount;
    }

    /**
     * 발송 성공률입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sendRate")
    public Double getSendRate() {
        return sendRate;
    }

    /**
     * 읽음률입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("readRate")
    public Double getReadRate() {
        return readRate;
    }

    /**
     * 클릭률입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("clickRate")
    public Double getClickRate() {
        return clickRate;
    }

    /**
     * CTR(클릭률/읽음률)입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ctr")
    public Double getCtr() {
        return ctr;
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
        if (!(o instanceof InsightKakaoStatistics)) {
            return false;
        }
        InsightKakaoStatistics other = (InsightKakaoStatistics) o;
        return Objects.equals(successCount, other.successCount)
                && Objects.equals(failCount, other.failCount)
                && Objects.equals(readCount, other.readCount)
                && Objects.equals(buttonClickCount, other.buttonClickCount)
                && Objects.equals(listClickCount, other.listClickCount)
                && Objects.equals(thumbnailClickCount, other.thumbnailClickCount)
                && Objects.equals(etcClickCount, other.etcClickCount)
                && Objects.equals(sendRate, other.sendRate)
                && Objects.equals(readRate, other.readRate)
                && Objects.equals(clickRate, other.clickRate)
                && Objects.equals(ctr, other.ctr)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(successCount, failCount, readCount, buttonClickCount, listClickCount, thumbnailClickCount, etcClickCount, sendRate, readRate, clickRate, ctr, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "InsightKakaoStatistics{", "}");
        if (successCount != null) {
            joiner.add("successCount=***");
        }
        if (failCount != null) {
            joiner.add("failCount=***");
        }
        if (readCount != null) {
            joiner.add("readCount=***");
        }
        if (buttonClickCount != null) {
            joiner.add("buttonClickCount=***");
        }
        if (listClickCount != null) {
            joiner.add("listClickCount=***");
        }
        if (thumbnailClickCount != null) {
            joiner.add("thumbnailClickCount=***");
        }
        if (etcClickCount != null) {
            joiner.add("etcClickCount=***");
        }
        if (sendRate != null) {
            joiner.add("sendRate=***");
        }
        if (readRate != null) {
            joiner.add("readRate=***");
        }
        if (clickRate != null) {
            joiner.add("clickRate=***");
        }
        if (ctr != null) {
            joiner.add("ctr=***");
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link InsightKakaoStatistics}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Long successCount;
        private Long failCount;
        private Long readCount;
        private Long buttonClickCount;
        private Long listClickCount;
        private Long thumbnailClickCount;
        private Long etcClickCount;
        private Double sendRate;
        private Double readRate;
        private Double clickRate;
        private Double ctr;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link InsightKakaoStatistics#builder()}. */
        public Builder() {
        }

        /**
         * 발송 성공 건수입니다.
         *
         * @param successCount the value (null clears it)
         * @return this builder
         */
        public Builder successCount(Long successCount) {
            this.successCount = successCount;
            return this;
        }

        /**
         * 발송 실패 건수입니다.
         *
         * @param failCount the value (null clears it)
         * @return this builder
         */
        public Builder failCount(Long failCount) {
            this.failCount = failCount;
            return this;
        }

        /**
         * 읽음 건수입니다.
         *
         * @param readCount the value (null clears it)
         * @return this builder
         */
        public Builder readCount(Long readCount) {
            this.readCount = readCount;
            return this;
        }

        /**
         * 버튼 클릭 건수입니다.
         *
         * @param buttonClickCount the value (null clears it)
         * @return this builder
         */
        public Builder buttonClickCount(Long buttonClickCount) {
            this.buttonClickCount = buttonClickCount;
            return this;
        }

        /**
         * 목록 클릭 건수입니다.
         *
         * @param listClickCount the value (null clears it)
         * @return this builder
         */
        public Builder listClickCount(Long listClickCount) {
            this.listClickCount = listClickCount;
            return this;
        }

        /**
         * 썸네일 클릭 건수입니다.
         *
         * @param thumbnailClickCount the value (null clears it)
         * @return this builder
         */
        public Builder thumbnailClickCount(Long thumbnailClickCount) {
            this.thumbnailClickCount = thumbnailClickCount;
            return this;
        }

        /**
         * 기타 클릭 건수입니다.
         *
         * @param etcClickCount the value (null clears it)
         * @return this builder
         */
        public Builder etcClickCount(Long etcClickCount) {
            this.etcClickCount = etcClickCount;
            return this;
        }

        /**
         * 발송 성공률입니다.
         *
         * @param sendRate the value (null clears it)
         * @return this builder
         */
        public Builder sendRate(Double sendRate) {
            this.sendRate = sendRate;
            return this;
        }

        /**
         * 읽음률입니다.
         *
         * @param readRate the value (null clears it)
         * @return this builder
         */
        public Builder readRate(Double readRate) {
            this.readRate = readRate;
            return this;
        }

        /**
         * 클릭률입니다.
         *
         * @param clickRate the value (null clears it)
         * @return this builder
         */
        public Builder clickRate(Double clickRate) {
            this.clickRate = clickRate;
            return this;
        }

        /**
         * CTR(클릭률/읽음률)입니다.
         *
         * @param ctr the value (null clears it)
         * @return this builder
         */
        public Builder ctr(Double ctr) {
            this.ctr = ctr;
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
         * @return a new immutable {@code InsightKakaoStatistics}
         */
        public InsightKakaoStatistics build() {
            return new InsightKakaoStatistics(this);
        }
    }
}
