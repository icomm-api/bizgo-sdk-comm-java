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
 * 통합 발송 요청입니다. 모든 채널이 같은 형식을 쓰며, 채널은 <code>messageFlow</code> 안의 채널 키로 구분합니다.
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
@JsonDeserialize(builder = SendOmniRequest.Builder.class)
@JsonPropertyOrder({"destinations", "messageFlow", "paymentCode", "groupKey", "idempotencyKey", "idempotencyTtl", "ref"})
public final class SendOmniRequest {

    private final List<Destination> destinations;
    private final List<MessageFlowItem> messageFlow;
    private final String paymentCode;
    private final String groupKey;
    private final String idempotencyKey;
    private final Integer idempotencyTtl;
    private final String ref;

    private SendOmniRequest(Builder builder) {
        this.destinations = builder.destinations == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.destinations));
        this.messageFlow = builder.messageFlow == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.messageFlow));
        this.paymentCode = builder.paymentCode;
        this.groupKey = builder.groupKey;
        this.idempotencyKey = builder.idempotencyKey;
        this.idempotencyTtl = builder.idempotencyTtl;
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
        builder.paymentCode = this.paymentCode;
        builder.groupKey = this.groupKey;
        builder.idempotencyKey = this.idempotencyKey;
        builder.idempotencyTtl = this.idempotencyTtl;
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
    public static SendOmniRequest fromJson(String json) {
        return RequestParser.parse(json, SendOmniRequest.class);
    }

    /**
     * Same as {@link #fromJson(String)} for a map with the API field names.
     *
     * @param body request body as nested maps and lists
     * @return the validated request
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid
     */
    public static SendOmniRequest fromMap(Map<String, ?> body) {
        return RequestParser.parse(body, SendOmniRequest.class);
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
     * 수신자 목록입니다. 한 요청에 최대 200건까지 동보발송할 수 있습니다(초과 시 A318).
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
     * 발송할 메시지 목록입니다. 순서대로 대체발송(Fallback)됩니다.
     *
     * <p>필수 · 항목 수 1~
     *
     * @return the value, or null if not set
     */
    @JsonProperty("messageFlow")
    public List<MessageFlowItem> getMessageFlow() {
        return messageFlow;
    }

    /**
     * 정산용 부서 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("paymentCode")
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * 메시지 인사이트에서 통계를 그룹으로 묶어 보기 위한 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupKey")
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * 중복 요청을 막는 멱등성 키입니다. 같은 키로 유효시간 안에 다시 요청하면 요청은 성공(HTTP 200)으로 오고 수신자별 결과(<code>destinations[].code</code>)가 A301이 됩니다(2026-09-28 sandbox 확인). SDK는 이 수신자를 실패가 아닌 <code>duplicates</code>로 돌려줍니다. 이 값을 보내면 <code>idempotencyTtl</code>도 함께 보내야 합니다.
     *
     * <p>최대 200자
     *
     * @return the value, or null if not set
     */
    @JsonProperty("idempotencyKey")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * 멱등성 키 유효시간(초)입니다. 공개 문서는 선택 항목으로 표기하지만 <code>idempotencyKey</code>를 보내면 <b>반드시 함께 보내야 합니다</b>(없으면 A309). <code>idempotencyKey</code> 없이 이 값만 보내면 SDK는 받은 값을 그대로 보냅니다. 공식 SDK는 <code>idempotencyKey</code>만 지정하고 이 값을 비워 두면 86400(24시간)을 채워 보냅니다. 직접 지정한 값(0 포함)은 그대로 보냅니다.
     *
     * <p>범위 0~86400
     *
     * @return the value, or null if not set
     */
    @JsonProperty("idempotencyTtl")
    public Integer getIdempotencyTtl() {
        return idempotencyTtl;
    }

    /**
     * 요청 단위 참조 필드입니다. 리포트에 그대로 담겨 요청·메시지를 구분하는 데 씁니다.
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
        if (!(o instanceof SendOmniRequest)) {
            return false;
        }
        SendOmniRequest other = (SendOmniRequest) o;
        return Objects.equals(destinations, other.destinations)
                && Objects.equals(messageFlow, other.messageFlow)
                && Objects.equals(paymentCode, other.paymentCode)
                && Objects.equals(groupKey, other.groupKey)
                && Objects.equals(idempotencyKey, other.idempotencyKey)
                && Objects.equals(idempotencyTtl, other.idempotencyTtl)
                && Objects.equals(ref, other.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations, messageFlow, paymentCode, groupKey, idempotencyKey, idempotencyTtl, ref);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "SendOmniRequest{", "}");
        if (destinations != null) {
            joiner.add("destinations=" + destinations);
        }
        if (messageFlow != null) {
            joiner.add("messageFlow=" + messageFlow);
        }
        if (paymentCode != null) {
            joiner.add("paymentCode=" + io.github.icommapi.bizgo.internal.Masking.length(paymentCode));
        }
        if (groupKey != null) {
            joiner.add("groupKey=" + io.github.icommapi.bizgo.internal.Masking.length(groupKey));
        }
        if (idempotencyKey != null) {
            joiner.add("idempotencyKey=" + io.github.icommapi.bizgo.internal.Masking.length(idempotencyKey));
        }
        if (idempotencyTtl != null) {
            joiner.add("idempotencyTtl=***");
        }
        if (ref != null) {
            joiner.add("ref=" + io.github.icommapi.bizgo.internal.Masking.length(ref));
        }
        return joiner.toString();
    }

    /** Builder for {@link SendOmniRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<Destination> destinations;
        private List<MessageFlowItem> messageFlow;
        private String paymentCode;
        private String groupKey;
        private String idempotencyKey;
        private Integer idempotencyTtl;
        private String ref;

        /** Creates an empty builder; same as {@link SendOmniRequest#builder()}. */
        public Builder() {
        }

        /**
         * 수신자 목록입니다. 한 요청에 최대 200건까지 동보발송할 수 있습니다(초과 시 A318).
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
         * 발송할 메시지 목록입니다. 순서대로 대체발송(Fallback)됩니다.
         *
         * <p>필수 · 항목 수 1~
         *
         * @param messageFlow the value (null clears it)
         * @return this builder
         */
        @JsonProperty("messageFlow")
        public Builder messageFlow(List<MessageFlowItem> messageFlow) {
            this.messageFlow = messageFlow;
            return this;
        }

        /**
         * Varargs form of {@link #messageFlow(List)}.
         *
         * @param messageFlow values
         * @return this builder
         */
        public Builder messageFlow(MessageFlowItem... messageFlow) {
            this.messageFlow = messageFlow == null ? null : Arrays.asList(messageFlow);
            return this;
        }

        /**
         * 정산용 부서 코드입니다.
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
         * 메시지 인사이트에서 통계를 그룹으로 묶어 보기 위한 키입니다.
         *
         * @param groupKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("groupKey")
        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        /**
         * 중복 요청을 막는 멱등성 키입니다. 같은 키로 유효시간 안에 다시 요청하면 요청은 성공(HTTP 200)으로 오고 수신자별 결과(<code>destinations[].code</code>)가 A301이 됩니다(2026-09-28 sandbox 확인). SDK는 이 수신자를 실패가 아닌 <code>duplicates</code>로 돌려줍니다. 이 값을 보내면 <code>idempotencyTtl</code>도 함께 보내야 합니다.
         *
         * <p>최대 200자
         *
         * @param idempotencyKey the value (null clears it)
         * @return this builder
         */
        @JsonProperty("idempotencyKey")
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * 멱등성 키 유효시간(초)입니다. 공개 문서는 선택 항목으로 표기하지만 <code>idempotencyKey</code>를 보내면 <b>반드시 함께 보내야 합니다</b>(없으면 A309). <code>idempotencyKey</code> 없이 이 값만 보내면 SDK는 받은 값을 그대로 보냅니다. 공식 SDK는 <code>idempotencyKey</code>만 지정하고 이 값을 비워 두면 86400(24시간)을 채워 보냅니다. 직접 지정한 값(0 포함)은 그대로 보냅니다.
         *
         * <p>범위 0~86400
         *
         * @param idempotencyTtl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("idempotencyTtl")
        public Builder idempotencyTtl(Integer idempotencyTtl) {
            this.idempotencyTtl = idempotencyTtl;
            return this;
        }

        /**
         * 요청 단위 참조 필드입니다. 리포트에 그대로 담겨 요청·메시지를 구분하는 데 씁니다.
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
         * @return a new immutable {@code SendOmniRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public SendOmniRequest build() {
            SendOmniRequest built = new SendOmniRequest(this);
            ModelValidator v = new ModelValidator("SendOmniRequest");
            v.required("destinations", built.destinations);
            v.items("destinations", built.destinations, 1, 200);
            v.required("messageFlow", built.messageFlow);
            v.items("messageFlow", built.messageFlow, 1, -1);
            v.maxLength("idempotencyKey", built.idempotencyKey, 200);
            v.range("idempotencyTtl", built.idempotencyTtl, 0L, 86400L);
            RequiredIf.checkRequest(v, "SendOmniRequest", built); // x-sdk-required-if $. paths
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        SendOmniRequest buildUnvalidated() {
            return new SendOmniRequest(this);
        }
    }
}
