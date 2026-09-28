// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.params;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Query parameters of {@code getBrandMessageInsight} ({@code GET /api/comm/v1/center/statistics/brandmessage}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetBrandMessageInsightParams {

    private final String startDate;
    private final String endDate;
    private final List<String> senderKey;
    private final List<String> templateCode;

    private GetBrandMessageInsightParams(Builder builder) {
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.senderKey = builder.senderKey == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.senderKey));
        this.templateCode = builder.templateCode == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.templateCode));
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
        builder.senderKey = senderKey;
        builder.templateCode = templateCode;
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
     * 발신프로필 키입니다. 여러 개를 조회하려면 콤마(,)로 구분해 전달합니다.
     *
     * <p>쿼리 {@code senderKey} · 필수 · 쉼표로 이어 보냅니다
     *
     * @return the value, or null
     */
    public List<String> getSenderKey() {
        return senderKey;
    }

    /**
     * 템플릿 코드입니다. 여러 개를 조회하려면 콤마(,)로 구분해 전달합니다. 넣지 않으면 전체를 조회합니다.
     *
     * <p>쿼리 {@code templateCode} · 쉼표로 이어 보냅니다
     *
     * @return the value, or null
     */
    public List<String> getTemplateCode() {
        return templateCode;
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
        if (senderKey != null) {
            query.put("senderKey", String.join(",", senderKey));
        }
        if (templateCode != null) {
            query.put("templateCode", String.join(",", templateCode));
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
        if (!(o instanceof GetBrandMessageInsightParams)) {
            return false;
        }
        GetBrandMessageInsightParams other = (GetBrandMessageInsightParams) o;
        return Objects.equals(startDate, other.startDate)
                && Objects.equals(endDate, other.endDate)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(templateCode, other.templateCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, senderKey, templateCode);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetBrandMessageInsightParams{", "}");
        if (startDate != null) {
            joiner.add("startDate=" + startDate);
        }
        if (endDate != null) {
            joiner.add("endDate=" + endDate);
        }
        if (senderKey != null) {
            joiner.add("senderKey=" + io.github.icommapi.bizgo.internal.Masking.count(senderKey.size()));
        }
        if (templateCode != null) {
            joiner.add("templateCode=" + io.github.icommapi.bizgo.internal.Masking.count(templateCode.size()));
        }
        return joiner.toString();
    }

    /** Builder for {@link GetBrandMessageInsightParams}. */
    public static final class Builder {
        private String startDate;
        private String endDate;
        private List<String> senderKey;
        private List<String> templateCode;

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
         * 발신프로필 키입니다. 여러 개를 조회하려면 콤마(,)로 구분해 전달합니다.
         *
         * <p>쿼리 {@code senderKey} · 필수 · 쉼표로 이어 보냅니다
         *
         * @param senderKey the value (null clears it)
         * @return this builder
         */
        public Builder senderKey(List<String> senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        /**
         * Varargs form of {@link #senderKey(List)}.
         *
         * @param senderKey values
         * @return this builder
         */
        public Builder senderKey(String... senderKey) {
            this.senderKey = senderKey == null ? null : Arrays.asList(senderKey);
            return this;
        }

        /**
         * 템플릿 코드입니다. 여러 개를 조회하려면 콤마(,)로 구분해 전달합니다. 넣지 않으면 전체를 조회합니다.
         *
         * <p>쿼리 {@code templateCode} · 쉼표로 이어 보냅니다
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        public Builder templateCode(List<String> templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * Varargs form of {@link #templateCode(List)}.
         *
         * @param templateCode values
         * @return this builder
         */
        public Builder templateCode(String... templateCode) {
            this.templateCode = templateCode == null ? null : Arrays.asList(templateCode);
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetBrandMessageInsightParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (startDate == null) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.startDate", "필수 값입니다"));
            }
            if (startDate != null && startDate.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.startDate", "제어 문자는 쓸 수 없습니다"));
            }
            if (startDate != null && startDate.isEmpty()) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.startDate", "빈 값입니다"));
            }
            if (endDate == null) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.endDate", "필수 값입니다"));
            }
            if (endDate != null && endDate.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.endDate", "제어 문자는 쓸 수 없습니다"));
            }
            if (endDate != null && endDate.isEmpty()) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.endDate", "빈 값입니다"));
            }
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.contains(null)) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.senderKey", "null 항목이 있습니다"));
            }
            if (senderKey != null && senderKey.size() < 1) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.senderKey", "항목이 최소 1개여야 합니다"));
            }
            if (senderKey != null && String.join("", senderKey).chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (templateCode != null && templateCode.contains(null)) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.templateCode", "null 항목이 있습니다"));
            }
            if (templateCode != null && String.join("", templateCode).chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetBrandMessageInsightParams.templateCode", "제어 문자는 쓸 수 없습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetBrandMessageInsightParams(this);
        }

        GetBrandMessageInsightParams buildUnvalidated() {
            return new GetBrandMessageInsightParams(this);
        }
    }
}
