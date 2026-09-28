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
 * Query parameters of {@code getRcsTemplateImage} ({@code GET /api/comm/v1/center/rcs/messagebase/file}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetRcsTemplateImageParams {

    private final String brandId;
    private final String fileId;

    private GetRcsTemplateImageParams(Builder builder) {
        this.brandId = builder.brandId;
        this.fileId = builder.fileId;
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
        builder.brandId = brandId;
        builder.fileId = fileId;
        return builder;
    }

    /**
     * 브랜드 ID입니다.
     *
     * <p>쿼리 {@code brandId} · 필수
     *
     * @return the value, or null
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * 템플릿 파일 ID입니다.
     *
     * <p>쿼리 {@code fileId} · 필수
     *
     * @return the value, or null
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (brandId != null) {
            query.put("brandId", brandId);
        }
        if (fileId != null) {
            query.put("fileId", fileId);
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
        if (!(o instanceof GetRcsTemplateImageParams)) {
            return false;
        }
        GetRcsTemplateImageParams other = (GetRcsTemplateImageParams) o;
        return Objects.equals(brandId, other.brandId)
                && Objects.equals(fileId, other.fileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, fileId);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetRcsTemplateImageParams{", "}");
        if (brandId != null) {
            joiner.add("brandId=***");
        }
        if (fileId != null) {
            joiner.add("fileId=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetRcsTemplateImageParams}. */
    public static final class Builder {
        private String brandId;
        private String fileId;

        private Builder() {
        }

        /**
         * 브랜드 ID입니다.
         *
         * <p>쿼리 {@code brandId} · 필수
         *
         * @param brandId the value (null clears it)
         * @return this builder
         */
        public Builder brandId(String brandId) {
            this.brandId = brandId;
            return this;
        }

        /**
         * 템플릿 파일 ID입니다.
         *
         * <p>쿼리 {@code fileId} · 필수
         *
         * @param fileId the value (null clears it)
         * @return this builder
         */
        public Builder fileId(String fileId) {
            this.fileId = fileId;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetRcsTemplateImageParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (brandId == null) {
                violations.add(new ValidationException.Violation("GetRcsTemplateImageParams.brandId", "필수 값입니다"));
            }
            if (brandId != null && brandId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetRcsTemplateImageParams.brandId", "제어 문자는 쓸 수 없습니다"));
            }
            if (brandId != null && brandId.isEmpty()) {
                violations.add(new ValidationException.Violation("GetRcsTemplateImageParams.brandId", "빈 값입니다"));
            }
            if (fileId == null) {
                violations.add(new ValidationException.Violation("GetRcsTemplateImageParams.fileId", "필수 값입니다"));
            }
            if (fileId != null && fileId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetRcsTemplateImageParams.fileId", "제어 문자는 쓸 수 없습니다"));
            }
            if (fileId != null && fileId.isEmpty()) {
                violations.add(new ValidationException.Violation("GetRcsTemplateImageParams.fileId", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetRcsTemplateImageParams(this);
        }

        GetRcsTemplateImageParams buildUnvalidated() {
            return new GetRcsTemplateImageParams(this);
        }
    }
}
