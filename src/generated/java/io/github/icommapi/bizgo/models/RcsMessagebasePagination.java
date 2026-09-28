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
 * 전체 건수와 페이지 조건 정보입니다. 문서상 모든 값이 문자열입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> offset·limit·total이 문자열(String)로 표기되어 있으나 숫자일 가능성이 있습니다. 문서 응답 예시에는 pagination이 없습니다.
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
@JsonPropertyOrder({"offset", "limit", "total"})
public final class RcsMessagebasePagination {

    private final String offset;
    private final String limit;
    private final String total;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsMessagebasePagination(
            @JsonProperty("offset") String offset,
            @JsonProperty("limit") String limit,
            @JsonProperty("total") String total) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsMessagebasePagination(Builder builder) {
        this(builder.offset, builder.limit, builder.total);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.offset = this.offset;
        builder.limit = this.limit;
        builder.total = this.total;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 조회 기준 위치입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("offset")
    public String getOffset() {
        return offset;
    }

    /**
     * 페이지당 조회 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("limit")
    public String getLimit() {
        return limit;
    }

    /**
     * 전체 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("total")
    public String getTotal() {
        return total;
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
        if (!(o instanceof RcsMessagebasePagination)) {
            return false;
        }
        RcsMessagebasePagination other = (RcsMessagebasePagination) o;
        return Objects.equals(offset, other.offset)
                && Objects.equals(limit, other.limit)
                && Objects.equals(total, other.total)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset, limit, total, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsMessagebasePagination{", "}");
        if (offset != null) {
            joiner.add("offset=" + io.github.icommapi.bizgo.internal.Masking.length(offset));
        }
        if (limit != null) {
            joiner.add("limit=" + io.github.icommapi.bizgo.internal.Masking.length(limit));
        }
        if (total != null) {
            joiner.add("total=" + io.github.icommapi.bizgo.internal.Masking.length(total));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsMessagebasePagination}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String offset;
        private String limit;
        private String total;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsMessagebasePagination#builder()}. */
        public Builder() {
        }

        /**
         * 조회 기준 위치입니다.
         *
         * @param offset the value (null clears it)
         * @return this builder
         */
        public Builder offset(String offset) {
            this.offset = offset;
            return this;
        }

        /**
         * 페이지당 조회 건수입니다.
         *
         * @param limit the value (null clears it)
         * @return this builder
         */
        public Builder limit(String limit) {
            this.limit = limit;
            return this;
        }

        /**
         * 전체 건수입니다.
         *
         * @param total the value (null clears it)
         * @return this builder
         */
        public Builder total(String total) {
            this.total = total;
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
         * @return a new immutable {@code RcsMessagebasePagination}
         */
        public RcsMessagebasePagination build() {
            return new RcsMessagebasePagination(this);
        }
    }
}
