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
 * 예약 건에 등록된 수신자입니다.
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
@JsonPropertyOrder({"msgKey", "destSeq", "to", "destData", "status", "responseCode", "responseText"})
public final class ReservationRecipient {

    private final String msgKey;
    private final Long destSeq;
    private final String to;
    private final String destData;
    private final String status;
    private final String responseCode;
    private final String responseText;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private ReservationRecipient(
            @JsonProperty("msgKey") String msgKey,
            @JsonProperty("destSeq") Long destSeq,
            @JsonProperty("to") String to,
            @JsonProperty("destData") String destData,
            @JsonProperty("status") String status,
            @JsonProperty("responseCode") String responseCode,
            @JsonProperty("responseText") String responseText) {
        this.msgKey = msgKey;
        this.destSeq = destSeq;
        this.to = to;
        this.destData = destData;
        this.status = status;
        this.responseCode = responseCode;
        this.responseText = responseText;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private ReservationRecipient(Builder builder) {
        this(builder.msgKey, builder.destSeq, builder.to, builder.destData, builder.status, builder.responseCode, builder.responseText);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.msgKey = this.msgKey;
        builder.destSeq = this.destSeq;
        builder.to = this.to;
        builder.destData = this.destData;
        builder.status = this.status;
        builder.responseCode = this.responseCode;
        builder.responseText = this.responseText;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 메시지 키입니다. 수신자 삭제에 씁니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("msgKey")
    public String getMsgKey() {
        return msgKey;
    }

    /**
     * 수신자 순번입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("destSeq")
    public Long getDestSeq() {
        return destSeq;
    }

    /**
     * 수신번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    /**
     * 수신자별 치환 데이터입니다.
     *
     * <p><b>확인 필요:</b> destData 형식이 불명확합니다. 요청은 replaceWords(JSON 객체)인데 응답 예시는 <code>name=홍길동</code> 형태의 문자열입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("destData")
    public String getDestData() {
        return destData;
    }

    /**
     * 수신자 상태입니다. 알려진 값은 <code>PENDING</code>입니다.
     *
     * <p>알려진 값 <code>PENDING</code>
     *
     * <p><b>확인 필요:</b> 수신자 상태 값 목록이 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 처리 결과 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("responseCode")
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * 처리 결과 메시지입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("responseText")
    public String getResponseText() {
        return responseText;
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
        if (!(o instanceof ReservationRecipient)) {
            return false;
        }
        ReservationRecipient other = (ReservationRecipient) o;
        return Objects.equals(msgKey, other.msgKey)
                && Objects.equals(destSeq, other.destSeq)
                && Objects.equals(to, other.to)
                && Objects.equals(destData, other.destData)
                && Objects.equals(status, other.status)
                && Objects.equals(responseCode, other.responseCode)
                && Objects.equals(responseText, other.responseText)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgKey, destSeq, to, destData, status, responseCode, responseText, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ReservationRecipient{", "}");
        if (msgKey != null) {
            joiner.add("msgKey=" + msgKey);
        }
        if (destSeq != null) {
            joiner.add("destSeq=***");
        }
        if (to != null) {
            joiner.add("to=" + io.github.icommapi.bizgo.internal.Masking.phone(to));
        }
        if (destData != null) {
            joiner.add("destData=" + io.github.icommapi.bizgo.internal.Masking.length(destData));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (responseCode != null) {
            joiner.add("responseCode=" + responseCode);
        }
        if (responseText != null) {
            joiner.add("responseText=" + responseText);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link ReservationRecipient}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String msgKey;
        private Long destSeq;
        private String to;
        private String destData;
        private String status;
        private String responseCode;
        private String responseText;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link ReservationRecipient#builder()}. */
        public Builder() {
        }

        /**
         * 메시지 키입니다. 수신자 삭제에 씁니다.
         *
         * @param msgKey the value (null clears it)
         * @return this builder
         */
        public Builder msgKey(String msgKey) {
            this.msgKey = msgKey;
            return this;
        }

        /**
         * 수신자 순번입니다.
         *
         * @param destSeq the value (null clears it)
         * @return this builder
         */
        public Builder destSeq(Long destSeq) {
            this.destSeq = destSeq;
            return this;
        }

        /**
         * 수신번호입니다.
         *
         * @param to the value (null clears it)
         * @return this builder
         */
        public Builder to(String to) {
            this.to = to;
            return this;
        }

        /**
         * 수신자별 치환 데이터입니다.
         *
         * <p><b>확인 필요:</b> destData 형식이 불명확합니다. 요청은 replaceWords(JSON 객체)인데 응답 예시는 <code>name=홍길동</code> 형태의 문자열입니다.
         *
         * @param destData the value (null clears it)
         * @return this builder
         */
        public Builder destData(String destData) {
            this.destData = destData;
            return this;
        }

        /**
         * 수신자 상태입니다. 알려진 값은 <code>PENDING</code>입니다.
         *
         * <p>알려진 값 <code>PENDING</code>
         *
         * <p><b>확인 필요:</b> 수신자 상태 값 목록이 문서에 없습니다.
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 처리 결과 코드입니다.
         *
         * @param responseCode the value (null clears it)
         * @return this builder
         */
        public Builder responseCode(String responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        /**
         * 처리 결과 메시지입니다.
         *
         * @param responseText the value (null clears it)
         * @return this builder
         */
        public Builder responseText(String responseText) {
            this.responseText = responseText;
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
         * @return a new immutable {@code ReservationRecipient}
         */
        public ReservationRecipient build() {
            return new ReservationRecipient(this);
        }
    }
}
