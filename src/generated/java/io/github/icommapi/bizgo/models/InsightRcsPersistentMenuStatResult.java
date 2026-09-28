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
 * RCS 응답 정보입니다.
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
@JsonPropertyOrder({"stat"})
public final class InsightRcsPersistentMenuStatResult {

    private final List<InsightRcsPersistentMenuStat> stat;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private InsightRcsPersistentMenuStatResult(
            @JsonProperty("stat") List<InsightRcsPersistentMenuStat> stat) {
        this.stat = stat == null ? null : Collections.unmodifiableList(new ArrayList<>(stat));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private InsightRcsPersistentMenuStatResult(Builder builder) {
        this(builder.stat);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.stat = this.stat;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 일자별 메뉴 클릭 통계 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("stat")
    public List<InsightRcsPersistentMenuStat> getStat() {
        return stat;
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
        if (!(o instanceof InsightRcsPersistentMenuStatResult)) {
            return false;
        }
        InsightRcsPersistentMenuStatResult other = (InsightRcsPersistentMenuStatResult) o;
        return Objects.equals(stat, other.stat)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stat, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "InsightRcsPersistentMenuStatResult{", "}");
        if (stat != null) {
            joiner.add("stat=" + stat);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link InsightRcsPersistentMenuStatResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<InsightRcsPersistentMenuStat> stat;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link InsightRcsPersistentMenuStatResult#builder()}. */
        public Builder() {
        }

        /**
         * 일자별 메뉴 클릭 통계 목록입니다.
         *
         * @param stat the value (null clears it)
         * @return this builder
         */
        public Builder stat(List<InsightRcsPersistentMenuStat> stat) {
            this.stat = stat;
            return this;
        }

        /**
         * Varargs form of {@link #stat(List)}.
         *
         * @param stat values
         * @return this builder
         */
        public Builder stat(InsightRcsPersistentMenuStat... stat) {
            this.stat = stat == null ? null : Arrays.asList(stat);
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
         * @return a new immutable {@code InsightRcsPersistentMenuStatResult}
         */
        public InsightRcsPersistentMenuStatResult build() {
            return new InsightRcsPersistentMenuStatResult(this);
        }
    }
}
