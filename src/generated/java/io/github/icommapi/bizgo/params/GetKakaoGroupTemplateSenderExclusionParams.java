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
 * Query parameters of {@code getKakaoGroupTemplateSenderExclusion} ({@code GET /api/comm/v1/center/kakao/abusing/block/senderGroup}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetKakaoGroupTemplateSenderExclusionParams {

    private final String date;
    private final String senderKey;
    private final String groupKey;
    private final String templateCode;

    private GetKakaoGroupTemplateSenderExclusionParams(Builder builder) {
        this.date = builder.date;
        this.senderKey = builder.senderKey;
        this.groupKey = builder.groupKey;
        this.templateCode = builder.templateCode;
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
        builder.date = date;
        builder.senderKey = senderKey;
        builder.groupKey = groupKey;
        builder.templateCode = templateCode;
        return builder;
    }

    /**
     * 조회 기준 날짜(YYYYMMDD)입니다. 예 <code>20260305</code>.
     *
     * <p>쿼리 {@code date} · 필수
     *
     * @return the value, or null
     */
    public String getDate() {
        return date;
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
     * 그룹 발신프로필 키입니다.
     *
     * <p>쿼리 {@code groupKey} · 필수
     *
     * @return the value, or null
     */
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * 템플릿 코드입니다.
     *
     * <p>쿼리 {@code templateCode} · 필수
     *
     * @return the value, or null
     */
    public String getTemplateCode() {
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
        if (date != null) {
            query.put("date", date);
        }
        if (senderKey != null) {
            query.put("senderKey", senderKey);
        }
        if (groupKey != null) {
            query.put("groupKey", groupKey);
        }
        if (templateCode != null) {
            query.put("templateCode", templateCode);
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
        if (!(o instanceof GetKakaoGroupTemplateSenderExclusionParams)) {
            return false;
        }
        GetKakaoGroupTemplateSenderExclusionParams other = (GetKakaoGroupTemplateSenderExclusionParams) o;
        return Objects.equals(date, other.date)
                && Objects.equals(senderKey, other.senderKey)
                && Objects.equals(groupKey, other.groupKey)
                && Objects.equals(templateCode, other.templateCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, senderKey, groupKey, templateCode);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetKakaoGroupTemplateSenderExclusionParams{", "}");
        if (date != null) {
            joiner.add("date=" + date);
        }
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (groupKey != null) {
            joiner.add("groupKey=***");
        }
        if (templateCode != null) {
            joiner.add("templateCode=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetKakaoGroupTemplateSenderExclusionParams}. */
    public static final class Builder {
        private String date;
        private String senderKey;
        private String groupKey;
        private String templateCode;

        private Builder() {
        }

        /**
         * 조회 기준 날짜(YYYYMMDD)입니다. 예 <code>20260305</code>.
         *
         * <p>쿼리 {@code date} · 필수
         *
         * @param date the value (null clears it)
         * @return this builder
         */
        public Builder date(String date) {
            this.date = date;
            return this;
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
         * 그룹 발신프로필 키입니다.
         *
         * <p>쿼리 {@code groupKey} · 필수
         *
         * @param groupKey the value (null clears it)
         * @return this builder
         */
        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        /**
         * 템플릿 코드입니다.
         *
         * <p>쿼리 {@code templateCode} · 필수
         *
         * @param templateCode the value (null clears it)
         * @return this builder
         */
        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetKakaoGroupTemplateSenderExclusionParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (date == null) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.date", "필수 값입니다"));
            }
            if (date != null && date.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.date", "제어 문자는 쓸 수 없습니다"));
            }
            if (date != null && date.isEmpty()) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.date", "빈 값입니다"));
            }
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.senderKey", "빈 값입니다"));
            }
            if (groupKey == null) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.groupKey", "필수 값입니다"));
            }
            if (groupKey != null && groupKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.groupKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (groupKey != null && groupKey.isEmpty()) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.groupKey", "빈 값입니다"));
            }
            if (templateCode == null) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.templateCode", "필수 값입니다"));
            }
            if (templateCode != null && templateCode.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.templateCode", "제어 문자는 쓸 수 없습니다"));
            }
            if (templateCode != null && templateCode.isEmpty()) {
                violations.add(new ValidationException.Violation("GetKakaoGroupTemplateSenderExclusionParams.templateCode", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetKakaoGroupTemplateSenderExclusionParams(this);
        }

        GetKakaoGroupTemplateSenderExclusionParams buildUnvalidated() {
            return new GetKakaoGroupTemplateSenderExclusionParams(this);
        }
    }
}
