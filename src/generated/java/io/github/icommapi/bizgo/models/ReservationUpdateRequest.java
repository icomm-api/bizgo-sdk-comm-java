// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 예약 수정 요청입니다. 예약 대기(PENDING) 상태인 예약 건의 발송 시각과 예약명만 바꿀 수 있습니다.
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
@JsonDeserialize(builder = ReservationUpdateRequest.Builder.class)
@JsonPropertyOrder({"resvSendTime", "resvName"})
public final class ReservationUpdateRequest {

    private final String resvSendTime;
    private final String resvName;

    private ReservationUpdateRequest(Builder builder) {
        this.resvSendTime = builder.resvSendTime;
        this.resvName = builder.resvName;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.resvSendTime = this.resvSendTime;
        builder.resvName = this.resvName;
        return builder;
    }

    /**
     * Parse and validate a request written with the API field names (JSON).
     * Unknown fields are rejected so that typos fail before anything is sent.
     *
     * @param json request body, for example an example from the API reference
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static ReservationUpdateRequest fromJson(String json) {
        return RequestParser.parse(json, ReservationUpdateRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static ReservationUpdateRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, ReservationUpdateRequest.class);
    }

    /**
     * The JSON body that is sent. Contains phone numbers: do not log it.
     *
     * @return JSON with only the fields that were set
     */
    public String toJson() {
        return RequestParser.toJson(this);
    }

    /**
     * 변경할 예약 발송 시각입니다(yyyy-MM-dd HH:mm:ss).
     *
     * <p>필수 · 형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * <p><b>확인 필요:</b> 수정 시 허용 형식(<code>T</code> 구분 형식 포함 여부)과 범위 제약(현재+10분~1년, 광고 야간 차단)이 등록 때와 같은지 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resvSendTime")
    public String getResvSendTime() {
        return resvSendTime;
    }

    /**
     * 예약명입니다.
     *
     * <p>최대 100자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resvName")
    public String getResvName() {
        return resvName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReservationUpdateRequest)) {
            return false;
        }
        ReservationUpdateRequest other = (ReservationUpdateRequest) o;
        return Objects.equals(resvSendTime, other.resvSendTime)
                && Objects.equals(resvName, other.resvName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resvSendTime, resvName);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ReservationUpdateRequest{", "}");
        if (resvSendTime != null) {
            joiner.add("resvSendTime=" + io.github.icommapi.bizgo.internal.Masking.length(resvSendTime));
        }
        if (resvName != null) {
            joiner.add("resvName=" + io.github.icommapi.bizgo.internal.Masking.length(resvName));
        }
        return joiner.toString();
    }

    /** Builder for {@link ReservationUpdateRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String resvSendTime;
        private String resvName;

        /** Creates an empty builder; same as {@link ReservationUpdateRequest#builder()}. */
        public Builder() {
        }

        /**
         * 변경할 예약 발송 시각입니다(yyyy-MM-dd HH:mm:ss).
         *
         * <p>필수 · 형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * <p><b>확인 필요:</b> 수정 시 허용 형식(<code>T</code> 구분 형식 포함 여부)과 범위 제약(현재+10분~1년, 광고 야간 차단)이 등록 때와 같은지 문서에 없습니다.
         *
         * @param resvSendTime the value (null clears it)
         * @return this builder
         */
        @JsonProperty("resvSendTime")
        public Builder resvSendTime(String resvSendTime) {
            this.resvSendTime = resvSendTime;
            return this;
        }

        /**
         * 예약명입니다.
         *
         * <p>최대 100자
         *
         * @param resvName the value (null clears it)
         * @return this builder
         */
        @JsonProperty("resvName")
        public Builder resvName(String resvName) {
            this.resvName = resvName;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code ReservationUpdateRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public ReservationUpdateRequest build() {
            ReservationUpdateRequest built = new ReservationUpdateRequest(this);
            ModelValidator v = new ModelValidator("ReservationUpdateRequest");
            v.required("resvSendTime", built.resvSendTime);
            v.maxLength("resvName", built.resvName, 100);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        ReservationUpdateRequest buildUnvalidated() {
            return new ReservationUpdateRequest(this);
        }
    }
}
