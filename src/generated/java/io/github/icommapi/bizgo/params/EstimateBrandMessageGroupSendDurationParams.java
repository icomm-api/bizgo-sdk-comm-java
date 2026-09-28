// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.params;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Query parameters of {@code estimateBrandMessageGroupSendDuration} ({@code GET /api/comm/v1/center/brandmessage/groupMessage/estimate}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class EstimateBrandMessageGroupSendDurationParams {

    private final String senderKey;
    private final String startTime;
    private final Integer count;
    private final String target;

    private EstimateBrandMessageGroupSendDurationParams(Builder builder) {
        this.senderKey = builder.senderKey;
        this.startTime = builder.startTime;
        this.count = builder.count;
        this.target = builder.target;
    }

    /**
     * Returns a new, empty builder.
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns a builder initialised with these values.
     *
     * @return builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.senderKey = senderKey;
        builder.startTime = startTime;
        builder.count = count;
        builder.target = target;
        return builder;
    }

    /**
     * 발신프로필 키입니다.
     *
     * <p>쿼리 {@code senderKey} · 필수
     *
     * @return the value, or null
     */
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 동보 발송 시작 일시(<code>yyyy-MM-dd'T'HH:mm:ss</code>, KST)입니다. 동보 발송 요청의 <code>sendStartAt</code>(<code>yyyy-MM-dd HH:mm:ss</code>)과 형식이 다릅니다.
     *
     * <p>쿼리 {@code startTime} · 필수
     *
     * @return the value, or null
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 발송 모수입니다.
     *
     * <p>쿼리 {@code count} · 필수
     *
     * @return the value, or null
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 대상 유형입니다. 기본값은 <code>NONE</code>입니다.
     *
     * <p>쿼리 {@code target} · 허용 값 <code>NONE</code>, <code>FRIEND_GROUP</code> · 서버 기본값 <code>NONE</code>
     *
     * @return the value, or null
     */
    public String getTarget() {
        return target;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (senderKey != null) {
            query.put("senderKey", senderKey);
        }
        if (startTime != null) {
            query.put("startTime", startTime);
        }
        if (count != null) {
            query.put("count", String.valueOf(count));
        }
        if (target != null) {
            query.put("target", target);
        }
        return Collections.unmodifiableMap(query);
    }

    /**
     * Request header values. They can contain personal data: do not log them.
     *
     * @return unmodifiable map; unset headers are left out
     */
    public Map<String, String> toHeaders() {
        return Map.of();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EstimateBrandMessageGroupSendDurationParams)) {
            return false;
        }
        EstimateBrandMessageGroupSendDurationParams other = (EstimateBrandMessageGroupSendDurationParams) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(startTime, other.startTime)
                && Objects.equals(count, other.count)
                && Objects.equals(target, other.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, startTime, count, target);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "EstimateBrandMessageGroupSendDurationParams{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (startTime != null) {
            joiner.add("startTime=***");
        }
        if (count != null) {
            joiner.add("count=" + count);
        }
        if (target != null) {
            joiner.add("target=" + target);
        }
        return joiner.toString();
    }

    /** Builder for {@link EstimateBrandMessageGroupSendDurationParams}. */
    public static final class Builder {
        private String senderKey;
        private String startTime;
        private Integer count;
        private String target;

        private Builder() {
        }

        /**
         * 발신프로필 키입니다.
         *
         * <p>쿼리 {@code senderKey} · 필수
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * 동보 발송 시작 일시(<code>yyyy-MM-dd'T'HH:mm:ss</code>, KST)입니다. 동보 발송 요청의 <code>sendStartAt</code>(<code>yyyy-MM-dd HH:mm:ss</code>)과 형식이 다릅니다.
         *
         * <p>쿼리 {@code startTime} · 필수
         *
         * @param startTime the value (null clears it)
         * @return this builder
         */
        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        /**
         * 발송 모수입니다.
         *
         * <p>쿼리 {@code count} · 필수
         *
         * @param count the value (null clears it)
         * @return this builder
         */
        public Builder count(Integer count) {
            this.count = count;
            return this;
        }

        /**
         * 대상 유형입니다. 기본값은 <code>NONE</code>입니다.
         *
         * <p>쿼리 {@code target} · 허용 값 <code>NONE</code>, <code>FRIEND_GROUP</code> · 서버 기본값 <code>NONE</code>
         *
         * @param target the value (null clears it)
         * @return this builder
         */
        public Builder target(String target) {
            this.target = target;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public EstimateBrandMessageGroupSendDurationParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("EstimateBrandMessageGroupSendDurationParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("EstimateBrandMessageGroupSendDurationParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("EstimateBrandMessageGroupSendDurationParams.senderKey", "빈 값입니다"));
            }
            if (startTime == null) {
                violations.add(new ValidationException.Violation("EstimateBrandMessageGroupSendDurationParams.startTime", "필수 값입니다"));
            }
            if (startTime != null && startTime.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("EstimateBrandMessageGroupSendDurationParams.startTime", "제어 문자는 쓸 수 없습니다"));
            }
            if (startTime != null && startTime.isEmpty()) {
                violations.add(new ValidationException.Violation("EstimateBrandMessageGroupSendDurationParams.startTime", "빈 값입니다"));
            }
            if (count == null) {
                violations.add(new ValidationException.Violation("EstimateBrandMessageGroupSendDurationParams.count", "필수 값입니다"));
            }
            if (target != null && !List.of("NONE", "FRIEND_GROUP").contains(target)) {
                violations.add(new ValidationException.Violation("EstimateBrandMessageGroupSendDurationParams.target", "허용 값(NONE, FRIEND_GROUP)이 아닙니다"));
            }
            if (target != null && target.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("EstimateBrandMessageGroupSendDurationParams.target", "제어 문자는 쓸 수 없습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new EstimateBrandMessageGroupSendDurationParams(this);
        }

        EstimateBrandMessageGroupSendDurationParams buildUnvalidated() {
            return new EstimateBrandMessageGroupSendDurationParams(this);
        }
    }
}
