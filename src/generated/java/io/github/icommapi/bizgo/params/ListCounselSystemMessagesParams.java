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
 * Query parameters of {@code listCounselSystemMessages} ({@code GET /api/comm/v1/center/cstalk/system/message}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListCounselSystemMessagesParams {

    private final String senderKey;
    private final String id;

    private ListCounselSystemMessagesParams(Builder builder) {
        this.senderKey = builder.senderKey;
        this.id = builder.id;
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
        builder.id = id;
        return builder;
    }

    /**
     * 카카오 비즈메시지 발신프로필 키입니다.
     *
     * <p>쿼리 {@code senderKey} · 필수
     *
     * @return the value, or null
     */
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 시스템 메시지 ID입니다. 특정 메시지만 조회할 때 입력합니다.
     *
     * <p>쿼리 {@code id}
     *
     * @return the value, or null
     */
    public String getId() {
        return id;
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
        if (id != null) {
            query.put("id", id);
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
        if (!(o instanceof ListCounselSystemMessagesParams)) {
            return false;
        }
        ListCounselSystemMessagesParams other = (ListCounselSystemMessagesParams) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, id);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListCounselSystemMessagesParams{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (id != null) {
            joiner.add("id=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link ListCounselSystemMessagesParams}. */
    public static final class Builder {
        private String senderKey;
        private String id;

        private Builder() {
        }

        /**
         * 카카오 비즈메시지 발신프로필 키입니다.
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
         * 시스템 메시지 ID입니다. 특정 메시지만 조회할 때 입력합니다.
         *
         * <p>쿼리 {@code id}
         *
         * @param id the value (null clears it)
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public ListCounselSystemMessagesParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("ListCounselSystemMessagesParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListCounselSystemMessagesParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("ListCounselSystemMessagesParams.senderKey", "빈 값입니다"));
            }
            if (id != null && id.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListCounselSystemMessagesParams.id", "제어 문자는 쓸 수 없습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListCounselSystemMessagesParams(this);
        }

        ListCounselSystemMessagesParams buildUnvalidated() {
            return new ListCounselSystemMessagesParams(this);
        }
    }
}
