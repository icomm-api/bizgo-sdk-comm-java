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
 * Query parameters of {@code listRcsTemplateFormLogos} ({@code GET /api/comm/v1/center/rcs/messagebase/messagebaseform/logo}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListRcsTemplateFormLogosParams {

    private final String messagebaseformId;

    private ListRcsTemplateFormLogosParams(Builder builder) {
        this.messagebaseformId = builder.messagebaseformId;
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
        builder.messagebaseformId = messagebaseformId;
        return builder;
    }

    /**
     * 메시지 양식 ID입니다.
     *
     * <p>쿼리 {@code messagebaseformId} · 필수
     *
     * @return the value, or null
     */
    public String getMessagebaseformId() {
        return messagebaseformId;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (messagebaseformId != null) {
            query.put("messagebaseformId", messagebaseformId);
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
        if (!(o instanceof ListRcsTemplateFormLogosParams)) {
            return false;
        }
        ListRcsTemplateFormLogosParams other = (ListRcsTemplateFormLogosParams) o;
        return Objects.equals(messagebaseformId, other.messagebaseformId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messagebaseformId);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListRcsTemplateFormLogosParams{", "}");
        if (messagebaseformId != null) {
            joiner.add("messagebaseformId=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link ListRcsTemplateFormLogosParams}. */
    public static final class Builder {
        private String messagebaseformId;

        private Builder() {
        }

        /**
         * 메시지 양식 ID입니다.
         *
         * <p>쿼리 {@code messagebaseformId} · 필수
         *
         * @param messagebaseformId the value (null clears it)
         * @return this builder
         */
        public Builder messagebaseformId(String messagebaseformId) {
            this.messagebaseformId = messagebaseformId;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public ListRcsTemplateFormLogosParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (messagebaseformId == null) {
                violations.add(new ValidationException.Violation("ListRcsTemplateFormLogosParams.messagebaseformId", "필수 값입니다"));
            }
            if (messagebaseformId != null && messagebaseformId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListRcsTemplateFormLogosParams.messagebaseformId", "제어 문자는 쓸 수 없습니다"));
            }
            if (messagebaseformId != null && messagebaseformId.isEmpty()) {
                violations.add(new ValidationException.Violation("ListRcsTemplateFormLogosParams.messagebaseformId", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListRcsTemplateFormLogosParams(this);
        }

        ListRcsTemplateFormLogosParams buildUnvalidated() {
            return new ListRcsTemplateFormLogosParams(this);
        }
    }
}
