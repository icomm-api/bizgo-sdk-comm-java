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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * InsightKakaoStatisticsResult.
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
@JsonPropertyOrder({"statistics"})
public final class InsightKakaoStatisticsResult {

    private final List<InsightKakaoStatistics> statistics;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private InsightKakaoStatisticsResult(
            @JsonProperty("statistics") List<InsightKakaoStatistics> statistics) {
        this.statistics = statistics == null ? null : Collections.unmodifiableList(new ArrayList<>(statistics));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private InsightKakaoStatisticsResult(Builder builder) {
        this(builder.statistics);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.statistics = this.statistics;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 발송 통계 목록입니다.
     *
     * <p><b>확인 필요:</b> 주요 인사이트 응답이 배열인데 항목에 발신프로필·템플릿 구분 필드가 없어, 여러 senderKey를 조회할 때 항목이 무엇 단위로 나뉘는지 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("statistics")
    public List<InsightKakaoStatistics> getStatistics() {
        return statistics;
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
        if (!(o instanceof InsightKakaoStatisticsResult)) {
            return false;
        }
        InsightKakaoStatisticsResult other = (InsightKakaoStatisticsResult) o;
        return Objects.equals(statistics, other.statistics)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statistics, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "InsightKakaoStatisticsResult{", "}");
        if (statistics != null) {
            joiner.add("statistics=" + statistics);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link InsightKakaoStatisticsResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<InsightKakaoStatistics> statistics;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link InsightKakaoStatisticsResult#builder()}. */
        public Builder() {
        }

        /**
         * 발송 통계 목록입니다.
         *
         * <p><b>확인 필요:</b> 주요 인사이트 응답이 배열인데 항목에 발신프로필·템플릿 구분 필드가 없어, 여러 senderKey를 조회할 때 항목이 무엇 단위로 나뉘는지 문서에 없습니다.
         *
         * @param statistics the value (null clears it)
         * @return this builder
         */
        public Builder statistics(List<InsightKakaoStatistics> statistics) {
            this.statistics = statistics;
            return this;
        }

        /**
         * Varargs form of {@link #statistics(List)}.
         *
         * @param statistics values
         * @return this builder
         */
        public Builder statistics(InsightKakaoStatistics... statistics) {
            this.statistics = statistics == null ? null : Arrays.asList(statistics);
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
         * @return a new immutable {@code InsightKakaoStatisticsResult}
         */
        public InsightKakaoStatisticsResult build() {
            return new InsightKakaoStatisticsResult(this);
        }
    }
}
