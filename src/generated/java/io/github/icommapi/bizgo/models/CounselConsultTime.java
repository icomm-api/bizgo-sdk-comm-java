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
 * 상담 운영 시간입니다.
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
@JsonPropertyOrder({"weekTimeTable"})
public final class CounselConsultTime {

    private final List<CounselWeekTime> weekTimeTable;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private CounselConsultTime(
            @JsonProperty("weekTimeTable") List<CounselWeekTime> weekTimeTable) {
        this.weekTimeTable = weekTimeTable == null ? null : Collections.unmodifiableList(new ArrayList<>(weekTimeTable));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private CounselConsultTime(Builder builder) {
        this(builder.weekTimeTable);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.weekTimeTable = this.weekTimeTable;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 요일별 상담 시간 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("weekTimeTable")
    public List<CounselWeekTime> getWeekTimeTable() {
        return weekTimeTable;
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
        if (!(o instanceof CounselConsultTime)) {
            return false;
        }
        CounselConsultTime other = (CounselConsultTime) o;
        return Objects.equals(weekTimeTable, other.weekTimeTable)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weekTimeTable, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselConsultTime{", "}");
        if (weekTimeTable != null) {
            joiner.add("weekTimeTable=" + weekTimeTable);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselConsultTime}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<CounselWeekTime> weekTimeTable;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link CounselConsultTime#builder()}. */
        public Builder() {
        }

        /**
         * 요일별 상담 시간 목록입니다.
         *
         * @param weekTimeTable the value (null clears it)
         * @return this builder
         */
        public Builder weekTimeTable(List<CounselWeekTime> weekTimeTable) {
            this.weekTimeTable = weekTimeTable;
            return this;
        }

        /**
         * Varargs form of {@link #weekTimeTable(List)}.
         *
         * @param weekTimeTable values
         * @return this builder
         */
        public Builder weekTimeTable(CounselWeekTime... weekTimeTable) {
            this.weekTimeTable = weekTimeTable == null ? null : Arrays.asList(weekTimeTable);
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
         * @return a new immutable {@code CounselConsultTime}
         */
        public CounselConsultTime build() {
            return new CounselConsultTime(this);
        }
    }
}
