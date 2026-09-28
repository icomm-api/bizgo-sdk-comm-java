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
 * 동영상 목록 데이터입니다.
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
@JsonPropertyOrder({"offset", "limit", "totalCount", "videos"})
public final class BrandMessageVideoListResult {

    private final Long offset;
    private final Long limit;
    private final Long totalCount;
    private final List<BrandMessageVideoListEntry> videos;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private BrandMessageVideoListResult(
            @JsonProperty("offset") Long offset,
            @JsonProperty("limit") Long limit,
            @JsonProperty("totalCount") Long totalCount,
            @JsonProperty("videos") List<BrandMessageVideoListEntry> videos) {
        this.offset = offset;
        this.limit = limit;
        this.totalCount = totalCount;
        this.videos = videos == null ? null : Collections.unmodifiableList(new ArrayList<>(videos));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private BrandMessageVideoListResult(Builder builder) {
        this(builder.offset, builder.limit, builder.totalCount, builder.videos);
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
        builder.totalCount = this.totalCount;
        builder.videos = this.videos;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 조회 시작 위치입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("offset")
    public Long getOffset() {
        return offset;
    }

    /**
     * 조회 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("limit")
    public Long getLimit() {
        return limit;
    }

    /**
     * 전체 동영상 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("totalCount")
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * 동영상 이력 배열입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("videos")
    public List<BrandMessageVideoListEntry> getVideos() {
        return videos;
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
        if (!(o instanceof BrandMessageVideoListResult)) {
            return false;
        }
        BrandMessageVideoListResult other = (BrandMessageVideoListResult) o;
        return Objects.equals(offset, other.offset)
                && Objects.equals(limit, other.limit)
                && Objects.equals(totalCount, other.totalCount)
                && Objects.equals(videos, other.videos)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset, limit, totalCount, videos, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageVideoListResult{", "}");
        if (offset != null) {
            joiner.add("offset=***");
        }
        if (limit != null) {
            joiner.add("limit=***");
        }
        if (totalCount != null) {
            joiner.add("totalCount=***");
        }
        if (videos != null) {
            joiner.add("videos=" + videos);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageVideoListResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Long offset;
        private Long limit;
        private Long totalCount;
        private List<BrandMessageVideoListEntry> videos;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link BrandMessageVideoListResult#builder()}. */
        public Builder() {
        }

        /**
         * 조회 시작 위치입니다.
         *
         * @param offset the value (null clears it)
         * @return this builder
         */
        public Builder offset(Long offset) {
            this.offset = offset;
            return this;
        }

        /**
         * 조회 건수입니다.
         *
         * @param limit the value (null clears it)
         * @return this builder
         */
        public Builder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        /**
         * 전체 동영상 건수입니다.
         *
         * @param totalCount the value (null clears it)
         * @return this builder
         */
        public Builder totalCount(Long totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        /**
         * 동영상 이력 배열입니다.
         *
         * @param videos the value (null clears it)
         * @return this builder
         */
        public Builder videos(List<BrandMessageVideoListEntry> videos) {
            this.videos = videos;
            return this;
        }

        /**
         * Varargs form of {@link #videos(List)}.
         *
         * @param videos values
         * @return this builder
         */
        public Builder videos(BrandMessageVideoListEntry... videos) {
            this.videos = videos == null ? null : Arrays.asList(videos);
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
         * @return a new immutable {@code BrandMessageVideoListResult}
         */
        public BrandMessageVideoListResult build() {
            return new BrandMessageVideoListResult(this);
        }
    }
}
