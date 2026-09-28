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
 * 예약 발송 건입니다.
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
@JsonPropertyOrder({"seq", "resvKey", "paymentCode", "resvName", "productType", "status", "adYn", "resvSendTime", "resvData", "expectedCnt", "sentCnt", "successCnt", "failCnt", "updateDate", "regDate"})
public final class Reservation {

    private final Long seq;
    private final String resvKey;
    private final String paymentCode;
    private final String resvName;
    private final String productType;
    private final String status;
    private final String adYn;
    private final String resvSendTime;
    private final String resvData;
    private final Long expectedCnt;
    private final Long sentCnt;
    private final Long successCnt;
    private final Long failCnt;
    private final String updateDate;
    private final String regDate;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private Reservation(
            @JsonProperty("seq") Long seq,
            @JsonProperty("resvKey") String resvKey,
            @JsonProperty("paymentCode") String paymentCode,
            @JsonProperty("resvName") String resvName,
            @JsonProperty("productType") String productType,
            @JsonProperty("status") String status,
            @JsonProperty("adYn") String adYn,
            @JsonProperty("resvSendTime") String resvSendTime,
            @JsonProperty("resvData") String resvData,
            @JsonProperty("expectedCnt") Long expectedCnt,
            @JsonProperty("sentCnt") Long sentCnt,
            @JsonProperty("successCnt") Long successCnt,
            @JsonProperty("failCnt") Long failCnt,
            @JsonProperty("updateDate") String updateDate,
            @JsonProperty("regDate") String regDate) {
        this.seq = seq;
        this.resvKey = resvKey;
        this.paymentCode = paymentCode;
        this.resvName = resvName;
        this.productType = productType;
        this.status = status;
        this.adYn = adYn;
        this.resvSendTime = resvSendTime;
        this.resvData = resvData;
        this.expectedCnt = expectedCnt;
        this.sentCnt = sentCnt;
        this.successCnt = successCnt;
        this.failCnt = failCnt;
        this.updateDate = updateDate;
        this.regDate = regDate;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private Reservation(Builder builder) {
        this(builder.seq, builder.resvKey, builder.paymentCode, builder.resvName, builder.productType, builder.status, builder.adYn, builder.resvSendTime, builder.resvData, builder.expectedCnt, builder.sentCnt, builder.successCnt, builder.failCnt, builder.updateDate, builder.regDate);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.seq = this.seq;
        builder.resvKey = this.resvKey;
        builder.paymentCode = this.paymentCode;
        builder.resvName = this.resvName;
        builder.productType = this.productType;
        builder.status = this.status;
        builder.adYn = this.adYn;
        builder.resvSendTime = this.resvSendTime;
        builder.resvData = this.resvData;
        builder.expectedCnt = this.expectedCnt;
        builder.sentCnt = this.sentCnt;
        builder.successCnt = this.successCnt;
        builder.failCnt = this.failCnt;
        builder.updateDate = this.updateDate;
        builder.regDate = this.regDate;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 예약 순번입니다. 목록 조회의 <code>lastSeq</code> 기준값으로 쓸 수 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("seq")
    public Long getSeq() {
        return seq;
    }

    /**
     * 예약 발송 키입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resvKey")
    public String getResvKey() {
        return resvKey;
    }

    /**
     * 정산 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("paymentCode")
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * 예약명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resvName")
    public String getResvName() {
        return resvName;
    }

    /**
     * 상품 유형입니다. 알려진 값은 <code>MESSAGE</code>입니다.
     *
     * <p>알려진 값 <code>MESSAGE</code>
     *
     * <p><b>확인 필요:</b> productType 값 목록이 문서에 없습니다(예시에 MESSAGE만 있음).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("productType")
    public String getProductType() {
        return productType;
    }

    /**
     * 예약 상태입니다. 알려진 값: <code>PENDING</code>(예약 대기), <code>PROCESSING</code>(발송 처리 중), <code>STOPPED</code>(예약 중지), <code>CANCELLED</code>(취소). 수정은 PENDING, 취소는 PENDING·STOPPED, 중지는 PROCESSING, 재개는 STOPPED 상태에서만 할 수 있습니다(그 밖에는 A824).
     *
     * <p>알려진 값 <code>PENDING</code>, <code>PROCESSING</code>, <code>STOPPED</code>, <code>CANCELLED</code>
     *
     * <p><b>확인 필요:</b> 예약 상태 전체 목록(발송 완료 등)이 문서에 없습니다. A824 적용 여부는 에러코드표 설명에서 추정했습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 광고 메시지 여부입니다(Y/N).
     *
     * <p>알려진 값 <code>Y</code>, <code>N</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("adYn")
    public String getAdYn() {
        return adYn;
    }

    /**
     * 예약 발송 시각입니다(yyyy-MM-dd HH:mm:ss).
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resvSendTime")
    public String getResvSendTime() {
        return resvSendTime;
    }

    /**
     * 예약 발송 요청 본문(JSON 문자열)입니다. 수정 응답과 목록 응답 예시에는 없습니다.
     *
     * <p><b>확인 필요:</b> resvData에 담기는 범위가 불명확합니다. 문서 예시는 messageFlow 항목 하나(sms 객체)만 담고 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resvData")
    public String getResvData() {
        return resvData;
    }

    /**
     * 예상 발송 수량입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("expectedCnt")
    public Long getExpectedCnt() {
        return expectedCnt;
    }

    /**
     * 발송 처리 수량입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("sentCnt")
    public Long getSentCnt() {
        return sentCnt;
    }

    /**
     * 성공 수량입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("successCnt")
    public Long getSuccessCnt() {
        return successCnt;
    }

    /**
     * 실패 수량입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("failCnt")
    public Long getFailCnt() {
        return failCnt;
    }

    /**
     * 수정 일시입니다(yyyy-MM-dd HH:mm:ss).
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("updateDate")
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 등록 일시입니다(yyyy-MM-dd HH:mm:ss).
     *
     * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("regDate")
    public String getRegDate() {
        return regDate;
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
        if (!(o instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) o;
        return Objects.equals(seq, other.seq)
                && Objects.equals(resvKey, other.resvKey)
                && Objects.equals(paymentCode, other.paymentCode)
                && Objects.equals(resvName, other.resvName)
                && Objects.equals(productType, other.productType)
                && Objects.equals(status, other.status)
                && Objects.equals(adYn, other.adYn)
                && Objects.equals(resvSendTime, other.resvSendTime)
                && Objects.equals(resvData, other.resvData)
                && Objects.equals(expectedCnt, other.expectedCnt)
                && Objects.equals(sentCnt, other.sentCnt)
                && Objects.equals(successCnt, other.successCnt)
                && Objects.equals(failCnt, other.failCnt)
                && Objects.equals(updateDate, other.updateDate)
                && Objects.equals(regDate, other.regDate)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq, resvKey, paymentCode, resvName, productType, status, adYn, resvSendTime, resvData, expectedCnt, sentCnt, successCnt, failCnt, updateDate, regDate, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "Reservation{", "}");
        if (seq != null) {
            joiner.add("seq=***");
        }
        if (resvKey != null) {
            joiner.add("resvKey=" + io.github.icommapi.bizgo.internal.Masking.length(resvKey));
        }
        if (paymentCode != null) {
            joiner.add("paymentCode=" + io.github.icommapi.bizgo.internal.Masking.length(paymentCode));
        }
        if (resvName != null) {
            joiner.add("resvName=" + io.github.icommapi.bizgo.internal.Masking.length(resvName));
        }
        if (productType != null) {
            joiner.add("productType=" + io.github.icommapi.bizgo.internal.Masking.length(productType));
        }
        if (status != null) {
            joiner.add("status=" + io.github.icommapi.bizgo.internal.Masking.length(status));
        }
        if (adYn != null) {
            joiner.add("adYn=" + io.github.icommapi.bizgo.internal.Masking.length(adYn));
        }
        if (resvSendTime != null) {
            joiner.add("resvSendTime=" + io.github.icommapi.bizgo.internal.Masking.length(resvSendTime));
        }
        if (resvData != null) {
            joiner.add("resvData=" + io.github.icommapi.bizgo.internal.Masking.length(resvData));
        }
        if (expectedCnt != null) {
            joiner.add("expectedCnt=***");
        }
        if (sentCnt != null) {
            joiner.add("sentCnt=***");
        }
        if (successCnt != null) {
            joiner.add("successCnt=***");
        }
        if (failCnt != null) {
            joiner.add("failCnt=***");
        }
        if (updateDate != null) {
            joiner.add("updateDate=" + io.github.icommapi.bizgo.internal.Masking.length(updateDate));
        }
        if (regDate != null) {
            joiner.add("regDate=" + io.github.icommapi.bizgo.internal.Masking.length(regDate));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link Reservation}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private Long seq;
        private String resvKey;
        private String paymentCode;
        private String resvName;
        private String productType;
        private String status;
        private String adYn;
        private String resvSendTime;
        private String resvData;
        private Long expectedCnt;
        private Long sentCnt;
        private Long successCnt;
        private Long failCnt;
        private String updateDate;
        private String regDate;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link Reservation#builder()}. */
        public Builder() {
        }

        /**
         * 예약 순번입니다. 목록 조회의 <code>lastSeq</code> 기준값으로 쓸 수 있습니다.
         *
         * @param seq the value (null clears it)
         * @return this builder
         */
        public Builder seq(Long seq) {
            this.seq = seq;
            return this;
        }

        /**
         * 예약 발송 키입니다.
         *
         * @param resvKey the value (null clears it)
         * @return this builder
         */
        public Builder resvKey(String resvKey) {
            this.resvKey = resvKey;
            return this;
        }

        /**
         * 정산 코드입니다.
         *
         * @param paymentCode the value (null clears it)
         * @return this builder
         */
        public Builder paymentCode(String paymentCode) {
            this.paymentCode = paymentCode;
            return this;
        }

        /**
         * 예약명입니다.
         *
         * @param resvName the value (null clears it)
         * @return this builder
         */
        public Builder resvName(String resvName) {
            this.resvName = resvName;
            return this;
        }

        /**
         * 상품 유형입니다. 알려진 값은 <code>MESSAGE</code>입니다.
         *
         * <p>알려진 값 <code>MESSAGE</code>
         *
         * <p><b>확인 필요:</b> productType 값 목록이 문서에 없습니다(예시에 MESSAGE만 있음).
         *
         * @param productType the value (null clears it)
         * @return this builder
         */
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        /**
         * 예약 상태입니다. 알려진 값: <code>PENDING</code>(예약 대기), <code>PROCESSING</code>(발송 처리 중), <code>STOPPED</code>(예약 중지), <code>CANCELLED</code>(취소). 수정은 PENDING, 취소는 PENDING·STOPPED, 중지는 PROCESSING, 재개는 STOPPED 상태에서만 할 수 있습니다(그 밖에는 A824).
         *
         * <p>알려진 값 <code>PENDING</code>, <code>PROCESSING</code>, <code>STOPPED</code>, <code>CANCELLED</code>
         *
         * <p><b>확인 필요:</b> 예약 상태 전체 목록(발송 완료 등)이 문서에 없습니다. A824 적용 여부는 에러코드표 설명에서 추정했습니다.
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 광고 메시지 여부입니다(Y/N).
         *
         * <p>알려진 값 <code>Y</code>, <code>N</code>
         *
         * @param adYn the value (null clears it)
         * @return this builder
         */
        public Builder adYn(String adYn) {
            this.adYn = adYn;
            return this;
        }

        /**
         * 예약 발송 시각입니다(yyyy-MM-dd HH:mm:ss).
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param resvSendTime the value (null clears it)
         * @return this builder
         */
        public Builder resvSendTime(String resvSendTime) {
            this.resvSendTime = resvSendTime;
            return this;
        }

        /**
         * 예약 발송 요청 본문(JSON 문자열)입니다. 수정 응답과 목록 응답 예시에는 없습니다.
         *
         * <p><b>확인 필요:</b> resvData에 담기는 범위가 불명확합니다. 문서 예시는 messageFlow 항목 하나(sms 객체)만 담고 있습니다.
         *
         * @param resvData the value (null clears it)
         * @return this builder
         */
        public Builder resvData(String resvData) {
            this.resvData = resvData;
            return this;
        }

        /**
         * 예상 발송 수량입니다.
         *
         * @param expectedCnt the value (null clears it)
         * @return this builder
         */
        public Builder expectedCnt(Long expectedCnt) {
            this.expectedCnt = expectedCnt;
            return this;
        }

        /**
         * 발송 처리 수량입니다.
         *
         * @param sentCnt the value (null clears it)
         * @return this builder
         */
        public Builder sentCnt(Long sentCnt) {
            this.sentCnt = sentCnt;
            return this;
        }

        /**
         * 성공 수량입니다.
         *
         * @param successCnt the value (null clears it)
         * @return this builder
         */
        public Builder successCnt(Long successCnt) {
            this.successCnt = successCnt;
            return this;
        }

        /**
         * 실패 수량입니다.
         *
         * @param failCnt the value (null clears it)
         * @return this builder
         */
        public Builder failCnt(Long failCnt) {
            this.failCnt = failCnt;
            return this;
        }

        /**
         * 수정 일시입니다(yyyy-MM-dd HH:mm:ss).
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param updateDate the value (null clears it)
         * @return this builder
         */
        public Builder updateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        /**
         * 등록 일시입니다(yyyy-MM-dd HH:mm:ss).
         *
         * <p>형식 <code>yyyy-MM-dd HH:mm:ss</code>
         *
         * @param regDate the value (null clears it)
         * @return this builder
         */
        public Builder regDate(String regDate) {
            this.regDate = regDate;
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
         * @return a new immutable {@code Reservation}
         */
        public Reservation build() {
            return new Reservation(this);
        }
    }
}
