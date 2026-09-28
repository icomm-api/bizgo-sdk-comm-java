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
 * Query parameters of {@code listBrandMessageTemplates} ({@code GET /api/comm/v1/center/brandmessage/template/list}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class ListBrandMessageTemplatesParams {

    private final String senderKey;
    private final String senderKeyType;
    private final String status;
    private final String templateType;
    private final Integer offset;
    private final Integer limit;

    private ListBrandMessageTemplatesParams(Builder builder) {
        this.senderKey = builder.senderKey;
        this.senderKeyType = builder.senderKeyType;
        this.status = builder.status;
        this.templateType = builder.templateType;
        this.offset = builder.offset;
        this.limit = builder.limit;
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
        builder.senderKeyType = senderKeyType;
        builder.status = status;
        builder.templateType = templateType;
        builder.offset = offset;
        builder.limit = limit;
        return builder;
    }

    /**
     * 발신프로필 키 또는 그룹키입니다.
     *
     * <p>쿼리 {@code senderKey} · 필수
     *
     * @return the value, or null
     */
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * 발신키 유형입니다. 문서 예시 값은 <code>S</code>(발신프로필)입니다. 기본값은 <code>S</code>입니다.
     *
     * <p>쿼리 {@code senderKeyType}
     *
     * @return the value, or null
     */
    public String getSenderKeyType() {
        return senderKeyType;
    }

    /**
     * 템플릿 상태입니다. 알려진 값: <code>A</code>(등록), <code>S</code>(차단).
     *
     * <p>쿼리 {@code status}
     *
     * @return the value, or null
     */
    public String getStatus() {
        return status;
    }

    /**
     * 템플릿 유형입니다.
     *
     * <p>쿼리 {@code templateType}
     *
     * @return the value, or null
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 조회 시작 위치입니다.
     *
     * <p>쿼리 {@code offset} · 범위 0~
     *
     * @return the value, or null
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 조회 건수입니다.
     *
     * <p>쿼리 {@code limit} · 범위 1~
     *
     * @return the value, or null
     */
    public Integer getLimit() {
        return limit;
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
        if (senderKeyType != null) {
            query.put("senderKeyType", senderKeyType);
        }
        if (status != null) {
            query.put("status", status);
        }
        if (templateType != null) {
            query.put("templateType", templateType);
        }
        if (offset != null) {
            query.put("offset", String.valueOf(offset));
        }
        if (limit != null) {
            query.put("limit", String.valueOf(limit));
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
        if (!(o instanceof ListBrandMessageTemplatesParams)) {
            return false;
        }
        ListBrandMessageTemplatesParams other = (ListBrandMessageTemplatesParams) o;
        return Objects.equals(senderKey, other.senderKey)
                && Objects.equals(senderKeyType, other.senderKeyType)
                && Objects.equals(status, other.status)
                && Objects.equals(templateType, other.templateType)
                && Objects.equals(offset, other.offset)
                && Objects.equals(limit, other.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderKey, senderKeyType, status, templateType, offset, limit);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ListBrandMessageTemplatesParams{", "}");
        if (senderKey != null) {
            joiner.add("senderKey=***");
        }
        if (senderKeyType != null) {
            joiner.add("senderKeyType=" + senderKeyType);
        }
        if (status != null) {
            joiner.add("status=" + status);
        }
        if (templateType != null) {
            joiner.add("templateType=" + templateType);
        }
        if (offset != null) {
            joiner.add("offset=" + offset);
        }
        if (limit != null) {
            joiner.add("limit=" + limit);
        }
        return joiner.toString();
    }

    /** Builder for {@link ListBrandMessageTemplatesParams}. */
    public static final class Builder {
        private String senderKey;
        private String senderKeyType;
        private String status;
        private String templateType;
        private Integer offset;
        private Integer limit;

        private Builder() {
        }

        /**
         * 발신프로필 키 또는 그룹키입니다.
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
         * 발신키 유형입니다. 문서 예시 값은 <code>S</code>(발신프로필)입니다. 기본값은 <code>S</code>입니다.
         *
         * <p>쿼리 {@code senderKeyType}
         *
         * @param senderKeyType the value (null clears it)
         * @return this builder
         */
        public Builder senderKeyType(String senderKeyType) {
            this.senderKeyType = senderKeyType;
            return this;
        }

        /**
         * 템플릿 상태입니다. 알려진 값: <code>A</code>(등록), <code>S</code>(차단).
         *
         * <p>쿼리 {@code status}
         *
         * @param status the value (null clears it)
         * @return this builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 템플릿 유형입니다.
         *
         * <p>쿼리 {@code templateType}
         *
         * @param templateType the value (null clears it)
         * @return this builder
         */
        public Builder templateType(String templateType) {
            this.templateType = templateType;
            return this;
        }

        /**
         * 조회 시작 위치입니다.
         *
         * <p>쿼리 {@code offset} · 범위 0~
         *
         * @param offset the value (null clears it)
         * @return this builder
         */
        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * 조회 건수입니다.
         *
         * <p>쿼리 {@code limit} · 범위 1~
         *
         * @param limit the value (null clears it)
         * @return this builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public ListBrandMessageTemplatesParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (senderKey == null) {
                violations.add(new ValidationException.Violation("ListBrandMessageTemplatesParams.senderKey", "필수 값입니다"));
            }
            if (senderKey != null && senderKey.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListBrandMessageTemplatesParams.senderKey", "제어 문자는 쓸 수 없습니다"));
            }
            if (senderKey != null && senderKey.isEmpty()) {
                violations.add(new ValidationException.Violation("ListBrandMessageTemplatesParams.senderKey", "빈 값입니다"));
            }
            if (senderKeyType != null && senderKeyType.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListBrandMessageTemplatesParams.senderKeyType", "제어 문자는 쓸 수 없습니다"));
            }
            if (status != null && status.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListBrandMessageTemplatesParams.status", "제어 문자는 쓸 수 없습니다"));
            }
            if (templateType != null && templateType.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("ListBrandMessageTemplatesParams.templateType", "제어 문자는 쓸 수 없습니다"));
            }
            if (offset != null && (offset < 0L)) {
                violations.add(new ValidationException.Violation("ListBrandMessageTemplatesParams.offset", "허용 범위(0~)를 벗어났습니다"));
            }
            if (limit != null && (limit < 1L)) {
                violations.add(new ValidationException.Violation("ListBrandMessageTemplatesParams.limit", "허용 범위(1~)를 벗어났습니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new ListBrandMessageTemplatesParams(this);
        }

        ListBrandMessageTemplatesParams buildUnvalidated() {
            return new ListBrandMessageTemplatesParams(this);
        }
    }
}
