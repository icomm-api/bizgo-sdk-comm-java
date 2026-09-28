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
 * Query parameters of {@code checkBrandMessageAudiencePossible} ({@code GET /api/comm/v1/center/brandmessage/groupMessage/possible}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class CheckBrandMessageAudiencePossibleParams {

    private final String senderKey;
    private final String msgType;
    private final String friendGroupKey;

    private CheckBrandMessageAudiencePossibleParams(Builder builder) {
        this.senderKey = builder.senderKey;
        this.msgType = builder.msgType;
        this.friendGroupKey = builder.friendGroupKey;
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
        builder.msgType = msgType;
        builder.friendGroupKey = friendGroupKey;
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
     * 브랜드메시지 타입입니다(카카오 원본 chatBubbleType으로 변환됩니다). 알려진 값: <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>.
     *
     * <p>쿼리 {@code msgType} · 필수
     *
     * @return the value, or null
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 대상 친구 그룹 키입니다. 생략하면 전체 친구를 기준으로 조회합니다.
     *
     * <p>쿼리 {@code friendGroupKey}
     *
     * @return the value, or null
     */
    public String getFriendGroupKey() {
        return friendGroupKey;
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
        if (msgType != null) {
            query.put("msgType", msgType);
        }
        if (friendGroupKey != null) {
            query.put("friendGroupKey", friendGroupKey);
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
        if (!(o instanceof CheckBrandMessageAudiencePossibleParams)) {
            return false;
        }
        CheckBrandMessageAudiencePossibleParams other = (CheckBrandMessageAudiencePossibleParams) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(msgType, other.msgType)
                && Objects.equals(friendGroupKey, other.friendGroupKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, msgType, friendGroupKey);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CheckBrandMessageAudiencePossibleParams{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (msgType != null) {
            joiner.add("msgType=" + msgType);
        }
        if (friendGroupKey != null) {
            joiner.add("friendGroupKey=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link CheckBrandMessageAudiencePossibleParams}. */
    public static final class Builder {
        private String senderKey;
        private String msgType;
        private String friendGroupKey;

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
         * 브랜드메시지 타입입니다(카카오 원본 chatBubbleType으로 변환됩니다). 알려진 값: <code>FT</code>, <code>FI</code>, <code>FW</code>, <code>FL</code>, <code>FC</code>, <code>FM</code>, <code>FA</code>, <code>FP</code>, <code>FG</code>.
         *
         * <p>쿼리 {@code msgType} · 필수
         *
         * @param msgType the value (null clears it)
         * @return this builder
         */
        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        /**
         * 대상 친구 그룹 키입니다. 생략하면 전체 친구를 기준으로 조회합니다.
         *
         * <p>쿼리 {@code friendGroupKey}
         *
         * @param friendGroupKey the value (null clears it)
         * @return this builder
         */
        public Builder friendGroupKey(String friendGroupKey) {
            this.friendGroupKey = friendGroupKey;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public CheckBrandMessageAudiencePossibleParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("CheckBrandMessageAudiencePossibleParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("CheckBrandMessageAudiencePossibleParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("CheckBrandMessageAudiencePossibleParams.senderKey", "빈 값입니다"));
            }
            if (msgType == null) {
                violations.add(new ValidationException.Violation("CheckBrandMessageAudiencePossibleParams.msgType", "필수 값입니다"));
            }
            if (msgType != null && msgType.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("CheckBrandMessageAudiencePossibleParams.msgType", "제어 문자는 쓸 수 없습니다"));
            }
            if (msgType != null && msgType.isEmpty()) {
                violations.add(new ValidationException.Violation("CheckBrandMessageAudiencePossibleParams.msgType", "빈 값입니다"));
            }
            if (friendGroupKey != null && friendGroupKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("CheckBrandMessageAudiencePossibleParams.friendGroupKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new CheckBrandMessageAudiencePossibleParams(this);
        }

        CheckBrandMessageAudiencePossibleParams buildUnvalidated() {
            return new CheckBrandMessageAudiencePossibleParams(this);
        }
    }
}
