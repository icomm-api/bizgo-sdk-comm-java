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
 * Query parameters of {@code getRcsMessageInsight} ({@code GET /api/comm/v1/center/rcs/brandId/&#123;brandId&#125;/stat/message}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetRcsMessageInsightParams {

    private final String startDate;
    private final String endDate;
    private final String groupId;
    private final String chatbotId;

    private GetRcsMessageInsightParams(Builder builder) {
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.groupId = builder.groupId;
        this.chatbotId = builder.chatbotId;
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
        builder.startDate = startDate;
        builder.endDate = endDate;
        builder.groupId = groupId;
        builder.chatbotId = chatbotId;
        return builder;
    }

    /**
     * 조회 시작일(YYYYMMDD)입니다.
     *
     * <p>쿼리 {@code startDate} · 필수
     *
     * @return the value, or null
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 조회 종료일(YYYYMMDD)입니다.
     *
     * <p>쿼리 {@code endDate} · 필수
     *
     * @return the value, or null
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 그룹 ID입니다. RCS 발송 요청에 넣은 <code>messageFlow[].rcs.groupId</code> 값이어야 합니다. 발송 시 <code>groupId</code>를 넣지 않은 건은 집계되지 않습니다.
     *
     * <p>쿼리 {@code groupId} · 필수
     *
     * @return the value, or null
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 챗봇 ID입니다. 지정하면 해당 챗봇으로 범위를 좁힙니다.
     *
     * <p>쿼리 {@code chatbotId}
     *
     * @return the value, or null
     */
    public String getChatbotId() {
        return chatbotId;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (startDate != null) {
            query.put("startDate", startDate);
        }
        if (endDate != null) {
            query.put("endDate", endDate);
        }
        if (groupId != null) {
            query.put("groupId", groupId);
        }
        if (chatbotId != null) {
            query.put("chatbotId", chatbotId);
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
        if (!(o instanceof GetRcsMessageInsightParams)) {
            return false;
        }
        GetRcsMessageInsightParams other = (GetRcsMessageInsightParams) o;
        return Objects.equals(startDate, other.startDate)
                && Objects.equals(endDate, other.endDate)
                && Objects.equals(groupId, other.groupId)
                && Objects.equals(chatbotId, other.chatbotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, groupId, chatbotId);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetRcsMessageInsightParams{", "}");
        if (startDate != null) {
            joiner.add("startDate=" + startDate);
        }
        if (endDate != null) {
            joiner.add("endDate=" + endDate);
        }
        if (groupId != null) {
            joiner.add("groupId=***");
        }
        if (chatbotId != null) {
            joiner.add("chatbotId=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetRcsMessageInsightParams}. */
    public static final class Builder {
        private String startDate;
        private String endDate;
        private String groupId;
        private String chatbotId;

        private Builder() {
        }

        /**
         * 조회 시작일(YYYYMMDD)입니다.
         *
         * <p>쿼리 {@code startDate} · 필수
         *
         * @param startDate the value (null clears it)
         * @return this builder
         */
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * 조회 종료일(YYYYMMDD)입니다.
         *
         * <p>쿼리 {@code endDate} · 필수
         *
         * @param endDate the value (null clears it)
         * @return this builder
         */
        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        /**
         * 그룹 ID입니다. RCS 발송 요청에 넣은 <code>messageFlow[].rcs.groupId</code> 값이어야 합니다. 발송 시 <code>groupId</code>를 넣지 않은 건은 집계되지 않습니다.
         *
         * <p>쿼리 {@code groupId} · 필수
         *
         * @param groupId the value (null clears it)
         * @return this builder
         */
        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        /**
         * 챗봇 ID입니다. 지정하면 해당 챗봇으로 범위를 좁힙니다.
         *
         * <p>쿼리 {@code chatbotId}
         *
         * @param chatbotId the value (null clears it)
         * @return this builder
         */
        public Builder chatbotId(String chatbotId) {
            this.chatbotId = chatbotId;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetRcsMessageInsightParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (startDate == null) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.startDate", "필수 값입니다"));
            }
            if (startDate != null && startDate.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.startDate", "제어 문자는 쓸 수 없습니다"));
            }
            if (startDate != null && startDate.isEmpty()) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.startDate", "빈 값입니다"));
            }
            if (endDate == null) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.endDate", "필수 값입니다"));
            }
            if (endDate != null && endDate.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.endDate", "제어 문자는 쓸 수 없습니다"));
            }
            if (endDate != null && endDate.isEmpty()) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.endDate", "빈 값입니다"));
            }
            if (groupId == null) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.groupId", "필수 값입니다"));
            }
            if (groupId != null && groupId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.groupId", "제어 문자는 쓸 수 없습니다"));
            }
            if (groupId != null && groupId.isEmpty()) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.groupId", "빈 값입니다"));
            }
            if (chatbotId != null && chatbotId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetRcsMessageInsightParams.chatbotId", "제어 문자는 쓸 수 없습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetRcsMessageInsightParams(this);
        }

        GetRcsMessageInsightParams buildUnvalidated() {
            return new GetRcsMessageInsightParams(this);
        }
    }
}
