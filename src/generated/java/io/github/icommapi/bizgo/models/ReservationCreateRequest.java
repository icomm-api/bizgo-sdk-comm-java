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
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 예약 발송 등록 요청입니다. 통합 발송 요청과 같은 <code>destinations</code>·<code>messageFlow</code> 구조에 예약 시각(<code>resvSendTime</code>)과 예약명(<code>resvName</code>)을 더합니다. 예약 발송 문서에는 <code>groupKey</code>, <code>idempotencyKey</code>, <code>idempotencyTtl</code>이 없으므로 넣지 않았습니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 예약 발송 요청이 idempotencyKey·idempotencyTtl·groupKey를 받는지 문서에 없습니다. 멱등성 키가 없으면 네트워크 오류 뒤 재시도할 때 예약이 중복 등록될 수 있습니다.
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
@JsonDeserialize(builder = ReservationCreateRequest.Builder.class)
@JsonPropertyOrder({"destinations", "messageFlow", "resvSendTime", "resvName", "paymentCode", "ref"})
public final class ReservationCreateRequest {

    private final List<Destination> destinations;
    private final List<ReservationMessageFlowItem> messageFlow;
    private final String resvSendTime;
    private final String resvName;
    private final String paymentCode;
    private final String ref;

    private ReservationCreateRequest(Builder builder) {
        this.destinations = builder.destinations == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.destinations));
        this.messageFlow = builder.messageFlow == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.messageFlow));
        this.resvSendTime = builder.resvSendTime;
        this.resvName = builder.resvName;
        this.paymentCode = builder.paymentCode;
        this.ref = builder.ref;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.destinations = this.destinations;
        builder.messageFlow = this.messageFlow;
        builder.resvSendTime = this.resvSendTime;
        builder.resvName = this.resvName;
        builder.paymentCode = this.paymentCode;
        builder.ref = this.ref;
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
    public static ReservationCreateRequest fromJson(String json) {
        return RequestParser.parse(json, ReservationCreateRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static ReservationCreateRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, ReservationCreateRequest.class);
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
     * 수신자 목록입니다. 한 요청에 최대 200건까지 동보발송할 수 있습니다. 국제메시지는 국가번호를 포함한 E.164 형식(+ 제외)을 씁니다.
     *
     * <p>필수 · 항목 수 1~200
     *
     * @return the value, or null if not set
     */
    @JsonProperty("destinations")
    public List<Destination> getDestinations() {
        return destinations;
    }

    /**
     * 예약 발송할 메시지 목록입니다. 순서대로 대체발송(Fallback)됩니다.
     *
     * <p>필수 · 항목 수 1~
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messageFlow")
    public List<ReservationMessageFlowItem> getMessageFlow() {
        return messageFlow;
    }

    /**
     * 예약 발송 시각입니다. <code>yyyy-MM-dd HH:mm:ss</code> 또는 <code>yyyy-MM-dd'T'HH:mm:ss</code> 형식을 씁니다. 현재 시각 + 10분부터 1년 이내로 지정할 수 있습니다(너무 이르면 A316, 1년 초과 시 A331). 광고성 메시지는 야간 차단 시간대(20:00~08:00 KST)에 예약할 수 없습니다(A330).
     *
     * <p>필수 · 형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * <p><b>확인 필요:</b> 시각의 기준 시간대가 명시되지 않았습니다(야간 차단 규칙만 KST로 표기). 형식·범위 제약은 영문 문서(Part B)에만 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resvSendTime")
    public String getResvSendTime() {
        return resvSendTime;
    }

    /**
     * 예약 건을 식별하기 위한 이름입니다.
     *
     * <p>최대 100자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resvName")
    public String getResvName() {
        return resvName;
    }

    /**
     * 정산용 부서 코드입니다.
     *
     * <p>최대 20자
     *
     * <p><b>확인 필요:</b> 한국어 문서(Part A)는 SMS/MMS·알림톡 예약 발송에만 paymentCode를 표기하고 국제·RCS·브랜드메시지 예약 발송에는 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("paymentCode")
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * 요청 단위 참조 필드입니다. 리포트에 그대로 담겨 요청·메시지를 구분하는 데 씁니다.
     *
     * <p>최대 200자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReservationCreateRequest)) {
            return false;
        }
        ReservationCreateRequest other = (ReservationCreateRequest) o;
        return Objects.equals(destinations, other.destinations)
                && Objects.equals(messageFlow, other.messageFlow)
                && Objects.equals(resvSendTime, other.resvSendTime)
                && Objects.equals(resvName, other.resvName)
                && Objects.equals(paymentCode, other.paymentCode)
                && Objects.equals(ref, other.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations, messageFlow, resvSendTime, resvName, paymentCode, ref);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ReservationCreateRequest{", "}");
        if (destinations != null) {
            joiner.add("destinations=" + destinations);
        }
        if (messageFlow != null) {
            joiner.add("messageFlow=" + messageFlow);
        }
        if (resvSendTime != null) {
            joiner.add("resvSendTime=" + io.github.icommapi.bizgo.internal.Masking.length(resvSendTime));
        }
        if (resvName != null) {
            joiner.add("resvName=" + io.github.icommapi.bizgo.internal.Masking.length(resvName));
        }
        if (paymentCode != null) {
            joiner.add("paymentCode=" + io.github.icommapi.bizgo.internal.Masking.length(paymentCode));
        }
        if (ref != null) {
            joiner.add("ref=" + io.github.icommapi.bizgo.internal.Masking.length(ref));
        }
        return joiner.toString();
    }

    /** Builder for {@link ReservationCreateRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<Destination> destinations;
        private List<ReservationMessageFlowItem> messageFlow;
        private String resvSendTime;
        private String resvName;
        private String paymentCode;
        private String ref;

        /** Creates an empty builder; same as {@link ReservationCreateRequest#builder()}. */
        public Builder() {
        }

        /**
         * 수신자 목록입니다. 한 요청에 최대 200건까지 동보발송할 수 있습니다. 국제메시지는 국가번호를 포함한 E.164 형식(+ 제외)을 씁니다.
         *
         * <p>필수 · 항목 수 1~200
         *
         * @param destinations the value (null clears it)
         * @return this builder
         */
        @JsonProperty("destinations")
        public Builder destinations(List<Destination> destinations) {
            this.destinations = destinations;
            return this;
        }

        /**
         * Varargs form of {@link #destinations(List)}.
         *
         * @param destinations values
         * @return this builder
         */
        public Builder destinations(Destination... destinations) {
            this.destinations = destinations == null ? null : Arrays.asList(destinations);
            return this;
        }

        /**
         * 예약 발송할 메시지 목록입니다. 순서대로 대체발송(Fallback)됩니다.
         *
         * <p>필수 · 항목 수 1~
         *
         * @param messageFlow the value (null clears it)
         * @return this builder
         */
        @JsonProperty("messageFlow")
        public Builder messageFlow(List<ReservationMessageFlowItem> messageFlow) {
            this.messageFlow = messageFlow;
            return this;
        }

        /**
         * Varargs form of {@link #messageFlow(List)}.
         *
         * @param messageFlow values
         * @return this builder
         */
        public Builder messageFlow(ReservationMessageFlowItem... messageFlow) {
            this.messageFlow = messageFlow == null ? null : Arrays.asList(messageFlow);
            return this;
        }

        /**
         * 예약 발송 시각입니다. <code>yyyy-MM-dd HH:mm:ss</code> 또는 <code>yyyy-MM-dd'T'HH:mm:ss</code> 형식을 씁니다. 현재 시각 + 10분부터 1년 이내로 지정할 수 있습니다(너무 이르면 A316, 1년 초과 시 A331). 광고성 메시지는 야간 차단 시간대(20:00~08:00 KST)에 예약할 수 없습니다(A330).
         *
         * <p>필수 · 형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * <p><b>확인 필요:</b> 시각의 기준 시간대가 명시되지 않았습니다(야간 차단 규칙만 KST로 표기). 형식·범위 제약은 영문 문서(Part B)에만 있습니다.
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
         * 예약 건을 식별하기 위한 이름입니다.
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
         * 정산용 부서 코드입니다.
         *
         * <p>최대 20자
         *
         * <p><b>확인 필요:</b> 한국어 문서(Part A)는 SMS/MMS·알림톡 예약 발송에만 paymentCode를 표기하고 국제·RCS·브랜드메시지 예약 발송에는 없습니다.
         *
         * @param paymentCode the value (null clears it)
         * @return this builder
         */
        @JsonProperty("paymentCode")
        public Builder paymentCode(String paymentCode) {
            this.paymentCode = paymentCode;
            return this;
        }

        /**
         * 요청 단위 참조 필드입니다. 리포트에 그대로 담겨 요청·메시지를 구분하는 데 씁니다.
         *
         * <p>최대 200자
         *
         * @param ref the value (null clears it)
         * @return this builder
         */
        @JsonProperty("ref")
        public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code ReservationCreateRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public ReservationCreateRequest build() {
            ReservationCreateRequest built = new ReservationCreateRequest(this);
            ModelValidator v = new ModelValidator("ReservationCreateRequest");
            v.required("destinations", built.destinations);
            v.items("destinations", built.destinations, 1, 200);
            v.required("messageFlow", built.messageFlow);
            v.items("messageFlow", built.messageFlow, 1, -1);
            v.required("resvSendTime", built.resvSendTime);
            v.maxLength("resvName", built.resvName, 100);
            v.maxLength("paymentCode", built.paymentCode, 20);
            v.maxLength("ref", built.ref, 200);
            RequiredIf.checkRequest(v, "ReservationCreateRequest", built); // x-sdk-required-if $. paths
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        ReservationCreateRequest buildUnvalidated() {
            return new ReservationCreateRequest(this);
        }
    }
}
