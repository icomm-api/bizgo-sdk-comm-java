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
 * ReservationRecipientListResult.
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
@JsonPropertyOrder({"lastSeq", "hasNext", "destinations"})
public final class ReservationRecipientListResult {

    private final Long lastSeq;
    private final Boolean hasNext;
    private final List<ReservationRecipient> destinations;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private ReservationRecipientListResult(
            @JsonProperty("lastSeq") Long lastSeq,
            @JsonProperty("hasNext") Boolean hasNext,
            @JsonProperty("destinations") List<ReservationRecipient> destinations) {
        this.lastSeq = lastSeq;
        this.hasNext = hasNext;
        this.destinations = destinations == null ? null : Collections.unmodifiableList(new ArrayList<>(destinations));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private ReservationRecipientListResult(Builder builder) {
        this(builder.lastSeq, builder.hasNext, builder.destinations);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.lastSeq = this.lastSeq;
        builder.hasNext = this.hasNext;
        builder.destinations = this.destinations;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 다음 페이지 조회에 쓰는 커서입니다. 다음 요청의 <code>lastSeq</code> 쿼리에 그대로 넣습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("lastSeq")
    public Long getLastSeq() {
        return lastSeq;
    }

    /**
     * 다음 페이지가 있는지 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("hasNext")
    public Boolean getHasNext() {
        return hasNext;
    }

    /**
     * 예약 수신자 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("destinations")
    public List<ReservationRecipient> getDestinations() {
        return destinations;
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
        if (!(o instanceof ReservationRecipientListResult)) {
            return false;
        }
        ReservationRecipientListResult other = (ReservationRecipientListResult) o;
        return Objects.equals(lastSeq, other.lastSeq)
                && Objects.equals(hasNext, other.hasNext)
                && Objects.equals(destinations, other.destinations)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastSeq, hasNext, destinations, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ReservationRecipientListResult{", "}");
        if (lastSeq != null) {
            joiner.add("lastSeq=" + lastSeq);
        }
        if (hasNext != null) {
            joiner.add("hasNext=" + hasNext);
        }
        if (destinations != null) {
            joiner.add("destinations=" + destinations);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link ReservationRecipientListResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Long lastSeq;
        private Boolean hasNext;
        private List<ReservationRecipient> destinations;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link ReservationRecipientListResult#builder()}. */
        public Builder() {
        }

        /**
         * 다음 페이지 조회에 쓰는 커서입니다. 다음 요청의 <code>lastSeq</code> 쿼리에 그대로 넣습니다.
         *
         * @param lastSeq the value (null clears it)
         * @return this builder
         */
        public Builder lastSeq(Long lastSeq) {
            this.lastSeq = lastSeq;
            return this;
        }

        /**
         * 다음 페이지가 있는지 여부입니다.
         *
         * @param hasNext the value (null clears it)
         * @return this builder
         */
        public Builder hasNext(Boolean hasNext) {
            this.hasNext = hasNext;
            return this;
        }

        /**
         * 예약 수신자 목록입니다.
         *
         * @param destinations the value (null clears it)
         * @return this builder
         */
        public Builder destinations(List<ReservationRecipient> destinations) {
            this.destinations = destinations;
            return this;
        }

        /**
         * Varargs form of {@link #destinations(List)}.
         *
         * @param destinations values
         * @return this builder
         */
        public Builder destinations(ReservationRecipient... destinations) {
            this.destinations = destinations == null ? null : Arrays.asList(destinations);
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
         * @return a new immutable {@code ReservationRecipientListResult}
         */
        public ReservationRecipientListResult build() {
            return new ReservationRecipientListResult(this);
        }
    }
}
