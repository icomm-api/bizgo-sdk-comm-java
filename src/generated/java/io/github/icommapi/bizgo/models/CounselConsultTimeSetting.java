// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 저장할 상담시간입니다.
 *
 * <p>Request model: immutable, created with {@link #builder()}, validated in {@link Builder#build()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonDeserialize(builder = CounselConsultTimeSetting.Builder.class)
@JsonPropertyOrder({"senderKey", "weekTimeTable"})
public final class CounselConsultTimeSetting {

    private final String senderKey;
    private final List<CounselWeekTime> weekTimeTable;

    private CounselConsultTimeSetting(Builder builder) {
        this.senderKey = builder.senderKey;
        this.weekTimeTable = builder.weekTimeTable == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.weekTimeTable));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = this.senderKey;
        builder.weekTimeTable = this.weekTimeTable;
        return builder;
    }

    /**
     * 발신프로필 키입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("senderKey")
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 요일별 상담 시간 목록입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("weekTimeTable")
    public List<CounselWeekTime> getWeekTimeTable() {
        return weekTimeTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CounselConsultTimeSetting)) {
            return false;
        }
        CounselConsultTimeSetting other = (CounselConsultTimeSetting) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(weekTimeTable, other.weekTimeTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, weekTimeTable);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CounselConsultTimeSetting{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.length(senderKey));
        }
        if (weekTimeTable != null) {
            joiner.add("weekTimeTable=" + weekTimeTable);
        }
        return joiner.toString();
    }

    /** Builder for {@link CounselConsultTimeSetting}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String senderKey;
        private List<CounselWeekTime> weekTimeTable;

        /** Creates an empty builder; same as {@link CounselConsultTimeSetting#builder()}. */
        public Builder() {
        }

        /**
         * 발신프로필 키입니다.
         *
         * <p>필수
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("senderKey")
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 요일별 상담 시간 목록입니다.
         *
         * <p>필수
         *
         * @param weekTimeTable the value (null clears it)
         * @return this builder
         */
        @JsonProperty("weekTimeTable")
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
         * Builds the object.
         *
         * @return a new immutable {@code CounselConsultTimeSetting}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public CounselConsultTimeSetting build() {
            CounselConsultTimeSetting built = new CounselConsultTimeSetting(this);
            ModelValidator v = new ModelValidator("CounselConsultTimeSetting");
            v.required("senderKey", built.senderKey);
            v.required("weekTimeTable", built.weekTimeTable);
            v.items("weekTimeTable", built.weekTimeTable, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        CounselConsultTimeSetting buildUnvalidated() {
            return new CounselConsultTimeSetting(this);
        }
    }
}
