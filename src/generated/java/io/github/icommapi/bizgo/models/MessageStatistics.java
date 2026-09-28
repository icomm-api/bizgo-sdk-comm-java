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
 * 일자별 접수·리포트 통계입니다.
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
@JsonPropertyOrder({"statDate", "recvTotalCnt", "recvSuccCnt", "recvFailCnt", "reportTotalCnt", "reportSuccCnt", "reportFailCnt"})
public final class MessageStatistics {

    private final String statDate;
    private final Long recvTotalCnt;
    private final Long recvSuccCnt;
    private final Long recvFailCnt;
    private final Long reportTotalCnt;
    private final Long reportSuccCnt;
    private final Long reportFailCnt;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private MessageStatistics(
            @JsonProperty("statDate") String statDate,
            @JsonProperty("recvTotalCnt") Long recvTotalCnt,
            @JsonProperty("recvSuccCnt") Long recvSuccCnt,
            @JsonProperty("recvFailCnt") Long recvFailCnt,
            @JsonProperty("reportTotalCnt") Long reportTotalCnt,
            @JsonProperty("reportSuccCnt") Long reportSuccCnt,
            @JsonProperty("reportFailCnt") Long reportFailCnt) {
        this.statDate = statDate;
        this.recvTotalCnt = recvTotalCnt;
        this.recvSuccCnt = recvSuccCnt;
        this.recvFailCnt = recvFailCnt;
        this.reportTotalCnt = reportTotalCnt;
        this.reportSuccCnt = reportSuccCnt;
        this.reportFailCnt = reportFailCnt;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private MessageStatistics(Builder builder) {
        this(builder.statDate, builder.recvTotalCnt, builder.recvSuccCnt, builder.recvFailCnt, builder.reportTotalCnt, builder.reportSuccCnt, builder.reportFailCnt);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.statDate = this.statDate;
        builder.recvTotalCnt = this.recvTotalCnt;
        builder.recvSuccCnt = this.recvSuccCnt;
        builder.recvFailCnt = this.recvFailCnt;
        builder.reportTotalCnt = this.reportTotalCnt;
        builder.reportSuccCnt = this.reportSuccCnt;
        builder.reportFailCnt = this.reportFailCnt;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 집계일입니다.
     *
     * <p>형식 <code>^[0-9]&#123;8&#125;$</code> · 형식 <code>YYYYMMDD</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("statDate")
    public String getStatDate() {
        return statDate;
    }

    /**
     * 접수 전체 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("recvTotalCnt")
    public Long getRecvTotalCnt() {
        return recvTotalCnt;
    }

    /**
     * 접수 성공 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("recvSuccCnt")
    public Long getRecvSuccCnt() {
        return recvSuccCnt;
    }

    /**
     * 접수 실패 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("recvFailCnt")
    public Long getRecvFailCnt() {
        return recvFailCnt;
    }

    /**
     * 리포트 전체 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportTotalCnt")
    public Long getReportTotalCnt() {
        return reportTotalCnt;
    }

    /**
     * 리포트 성공 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportSuccCnt")
    public Long getReportSuccCnt() {
        return reportSuccCnt;
    }

    /**
     * 리포트 실패 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("reportFailCnt")
    public Long getReportFailCnt() {
        return reportFailCnt;
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
        if (!(o instanceof MessageStatistics)) {
            return false;
        }
        MessageStatistics other = (MessageStatistics) o;
        return Objects.equals(statDate, other.statDate)
                && Objects.equals(recvTotalCnt, other.recvTotalCnt)
                && Objects.equals(recvSuccCnt, other.recvSuccCnt)
                && Objects.equals(recvFailCnt, other.recvFailCnt)
                && Objects.equals(reportTotalCnt, other.reportTotalCnt)
                && Objects.equals(reportSuccCnt, other.reportSuccCnt)
                && Objects.equals(reportFailCnt, other.reportFailCnt)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statDate, recvTotalCnt, recvSuccCnt, recvFailCnt, reportTotalCnt, reportSuccCnt, reportFailCnt, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "MessageStatistics{", "}");
        if (statDate != null) {
            joiner.add("statDate=" + statDate);
        }
        if (recvTotalCnt != null) {
            joiner.add("recvTotalCnt=" + recvTotalCnt);
        }
        if (recvSuccCnt != null) {
            joiner.add("recvSuccCnt=" + recvSuccCnt);
        }
        if (recvFailCnt != null) {
            joiner.add("recvFailCnt=" + recvFailCnt);
        }
        if (reportTotalCnt != null) {
            joiner.add("reportTotalCnt=" + reportTotalCnt);
        }
        if (reportSuccCnt != null) {
            joiner.add("reportSuccCnt=" + reportSuccCnt);
        }
        if (reportFailCnt != null) {
            joiner.add("reportFailCnt=" + reportFailCnt);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link MessageStatistics}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String statDate;
        private Long recvTotalCnt;
        private Long recvSuccCnt;
        private Long recvFailCnt;
        private Long reportTotalCnt;
        private Long reportSuccCnt;
        private Long reportFailCnt;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link MessageStatistics#builder()}. */
        public Builder() {
        }

        /**
         * 집계일입니다.
         *
         * <p>형식 <code>^[0-9]&#123;8&#125;$</code> · 형식 <code>YYYYMMDD</code>
         *
         * @param statDate the value (null clears it)
         * @return this builder
         */
        public Builder statDate(String statDate) {
            this.statDate = statDate;
            return this;
        }

        /**
         * 접수 전체 건수입니다.
         *
         * @param recvTotalCnt the value (null clears it)
         * @return this builder
         */
        public Builder recvTotalCnt(Long recvTotalCnt) {
            this.recvTotalCnt = recvTotalCnt;
            return this;
        }

        /**
         * 접수 성공 건수입니다.
         *
         * @param recvSuccCnt the value (null clears it)
         * @return this builder
         */
        public Builder recvSuccCnt(Long recvSuccCnt) {
            this.recvSuccCnt = recvSuccCnt;
            return this;
        }

        /**
         * 접수 실패 건수입니다.
         *
         * @param recvFailCnt the value (null clears it)
         * @return this builder
         */
        public Builder recvFailCnt(Long recvFailCnt) {
            this.recvFailCnt = recvFailCnt;
            return this;
        }

        /**
         * 리포트 전체 건수입니다.
         *
         * @param reportTotalCnt the value (null clears it)
         * @return this builder
         */
        public Builder reportTotalCnt(Long reportTotalCnt) {
            this.reportTotalCnt = reportTotalCnt;
            return this;
        }

        /**
         * 리포트 성공 건수입니다.
         *
         * @param reportSuccCnt the value (null clears it)
         * @return this builder
         */
        public Builder reportSuccCnt(Long reportSuccCnt) {
            this.reportSuccCnt = reportSuccCnt;
            return this;
        }

        /**
         * 리포트 실패 건수입니다.
         *
         * @param reportFailCnt the value (null clears it)
         * @return this builder
         */
        public Builder reportFailCnt(Long reportFailCnt) {
            this.reportFailCnt = reportFailCnt;
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
         * @return a new immutable {@code MessageStatistics}
         */
        public MessageStatistics build() {
            return new MessageStatistics(this);
        }
    }
}
