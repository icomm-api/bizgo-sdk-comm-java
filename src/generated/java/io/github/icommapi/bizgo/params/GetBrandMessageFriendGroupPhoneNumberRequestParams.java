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
 * Query parameters of {@code getBrandMessageFriendGroupPhoneNumberRequest} ({@code GET /api/comm/v1/center/brandmessage/friendGroup/phoneNumber/request}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetBrandMessageFriendGroupPhoneNumberRequestParams {

    private final String senderKey;
    private final String friendGroupKey;
    private final String requestId;

    private GetBrandMessageFriendGroupPhoneNumberRequestParams(Builder builder) {
        this.senderKey = builder.senderKey;
        this.friendGroupKey = builder.friendGroupKey;
        this.requestId = builder.requestId;
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
        builder.friendGroupKey = friendGroupKey;
        builder.requestId = requestId;
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
     * 친구 그룹 키입니다.
     *
     * <p>쿼리 {@code friendGroupKey} · 필수
     *
     * @return the value, or null
     */
    public String getFriendGroupKey() {
        return friendGroupKey;
    }

    /**
     * 조회할 요청 아이디입니다.
     *
     * <p>쿼리 {@code requestId} · 필수
     *
     * @return the value, or null
     */
    public String getRequestId() {
        return requestId;
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
        if (friendGroupKey != null) {
            query.put("friendGroupKey", friendGroupKey);
        }
        if (requestId != null) {
            query.put("requestId", requestId);
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
        if (!(o instanceof GetBrandMessageFriendGroupPhoneNumberRequestParams)) {
            return false;
        }
        GetBrandMessageFriendGroupPhoneNumberRequestParams other = (GetBrandMessageFriendGroupPhoneNumberRequestParams) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(friendGroupKey, other.friendGroupKey)
                && Objects.equals(requestId, other.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, friendGroupKey, requestId);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetBrandMessageFriendGroupPhoneNumberRequestParams{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (friendGroupKey != null) {
            joiner.add("friendGroupKey=***");
        }
        if (requestId != null) {
            joiner.add("requestId=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetBrandMessageFriendGroupPhoneNumberRequestParams}. */
    public static final class Builder {
        private String senderKey;
        private String friendGroupKey;
        private String requestId;

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
         * 친구 그룹 키입니다.
         *
         * <p>쿼리 {@code friendGroupKey} · 필수
         *
         * @param friendGroupKey the value (null clears it)
         * @return this builder
         */
        public Builder friendGroupKey(String friendGroupKey) {
            this.friendGroupKey = friendGroupKey;
            return this;
        }

        /**
         * 조회할 요청 아이디입니다.
         *
         * <p>쿼리 {@code requestId} · 필수
         *
         * @param requestId the value (null clears it)
         * @return this builder
         */
        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetBrandMessageFriendGroupPhoneNumberRequestParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("GetBrandMessageFriendGroupPhoneNumberRequestParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageFriendGroupPhoneNumberRequestParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("GetBrandMessageFriendGroupPhoneNumberRequestParams.senderKey", "빈 값입니다"));
            }
            if (friendGroupKey == null) {
                violations.add(new ValidationException.Violation("GetBrandMessageFriendGroupPhoneNumberRequestParams.friendGroupKey", "필수 값입니다"));
            }
            if (friendGroupKey != null && friendGroupKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageFriendGroupPhoneNumberRequestParams.friendGroupKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (friendGroupKey != null && friendGroupKey.isEmpty()) {
                violations.add(new ValidationException.Violation("GetBrandMessageFriendGroupPhoneNumberRequestParams.friendGroupKey", "빈 값입니다"));
            }
            if (requestId == null) {
                violations.add(new ValidationException.Violation("GetBrandMessageFriendGroupPhoneNumberRequestParams.requestId", "필수 값입니다"));
            }
            if (requestId != null && requestId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageFriendGroupPhoneNumberRequestParams.requestId", "제어 문자는 쓸 수 없습니다"));
            }
            if (requestId != null && requestId.isEmpty()) {
                violations.add(new ValidationException.Violation("GetBrandMessageFriendGroupPhoneNumberRequestParams.requestId", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetBrandMessageFriendGroupPhoneNumberRequestParams(this);
        }

        GetBrandMessageFriendGroupPhoneNumberRequestParams buildUnvalidated() {
            return new GetBrandMessageFriendGroupPhoneNumberRequestParams(this);
        }
    }
}
