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
 * ReportPollingResult.
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
@JsonPropertyOrder({"reportId", "report"})
public final class ReportPollingResult {

    private final String reportId;
    private final List<Report> report;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private ReportPollingResult(
            @JsonProperty("reportId") String reportId,
            @JsonProperty("report") List<Report> report) {
        this.reportId = reportId;
        this.report = report == null ? null : Collections.unmodifiableList(new ArrayList<>(report));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private ReportPollingResult(Builder builder) {
        this(builder.reportId, builder.report);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.reportId = this.reportId;
        builder.report = this.report;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 수신 확인(<code>DELETE /api/comm/v1/report/polling/&#123;reportId&#125;</code>)에 쓰는 리포트 ID입니다. 전달할 리포트가 없으면 빈 문자열입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportId")
    public String getReportId() {
        return reportId;
    }

    /**
     * 리포트 목록입니다. 전달할 리포트가 없으면 null입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("report")
    public List<Report> getReport() {
        return report;
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
        if (!(o instanceof ReportPollingResult)) {
            return false;
        }
        ReportPollingResult other = (ReportPollingResult) o;
        return Objects.equals(reportId, other.reportId)
                && Objects.equals(report, other.report)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, report, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ReportPollingResult{", "}");
        if (reportId != null) {
            joiner.add("reportId=" + reportId);
        }
        if (report != null) {
            joiner.add("report=" + report);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link ReportPollingResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String reportId;
        private List<Report> report;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link ReportPollingResult#builder()}. */
        public Builder() {
        }

        /**
         * 수신 확인(<code>DELETE /api/comm/v1/report/polling/&#123;reportId&#125;</code>)에 쓰는 리포트 ID입니다. 전달할 리포트가 없으면 빈 문자열입니다.
         *
         * @param reportId the value (null clears it)
         * @return this builder
         */
        public Builder reportId(String reportId) {
            this.reportId = reportId;
            return this;
        }

        /**
         * 리포트 목록입니다. 전달할 리포트가 없으면 null입니다.
         *
         * @param report the value (null clears it)
         * @return this builder
         */
        public Builder report(List<Report> report) {
            this.report = report;
            return this;
        }

        /**
         * Varargs form of {@link #report(List)}.
         *
         * @param report values
         * @return this builder
         */
        public Builder report(Report... report) {
            this.report = report == null ? null : Arrays.asList(report);
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
         * @return a new immutable {@code ReportPollingResult}
         */
        public ReportPollingResult build() {
            return new ReportPollingResult(this);
        }
    }
}
