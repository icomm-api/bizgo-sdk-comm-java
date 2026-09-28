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
 * Query parameters of {@code getCounselCertStatus} ({@code GET /api/comm/v1/center/cstalk/cert/status}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class GetCounselCertStatusParams {

    private final String certTxId;

    private GetCounselCertStatusParams(Builder builder) {
        this.certTxId = builder.certTxId;
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
        builder.certTxId = certTxId;
        return builder;
    }

    /**
     * 인증 트랜잭션 ID입니다. 카카오가 인증 요청 시 발급하며 <code>counselCertResult</code> 웹훅의 <code>certTxId</code>와 같습니다.
     *
     * <p>쿼리 {@code certTxId} · 필수
     *
     * @return the value, or null
     */
    public String getCertTxId() {
        return certTxId;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        if (certTxId != null) {
            query.put("certTxId", certTxId);
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
        if (!(o instanceof GetCounselCertStatusParams)) {
            return false;
        }
        GetCounselCertStatusParams other = (GetCounselCertStatusParams) o;
        return Objects.equals(certTxId, other.certTxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certTxId);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "GetCounselCertStatusParams{", "}");
        if (certTxId != null) {
            joiner.add("certTxId=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link GetCounselCertStatusParams}. */
    public static final class Builder {
        private String certTxId;

        private Builder() {
        }

        /**
         * 인증 트랜잭션 ID입니다. 카카오가 인증 요청 시 발급하며 <code>counselCertResult</code> 웹훅의 <code>certTxId</code>와 같습니다.
         *
         * <p>쿼리 {@code certTxId} · 필수
         *
         * @param certTxId the value (null clears it)
         * @return this builder
         */
        public Builder certTxId(String certTxId) {
            this.certTxId = certTxId;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public GetCounselCertStatusParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (certTxId == null) {
                violations.add(new ValidationException.Violation("GetCounselCertStatusParams.certTxId", "필수 값입니다"));
            }
            if (certTxId != null && certTxId.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("GetCounselCertStatusParams.certTxId", "제어 문자는 쓸 수 없습니다"));
            }
            if (certTxId != null && certTxId.isEmpty()) {
                violations.add(new ValidationException.Violation("GetCounselCertStatusParams.certTxId", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new GetCounselCertStatusParams(this);
        }

        GetCounselCertStatusParams buildUnvalidated() {
            return new GetCounselCertStatusParams(this);
        }
    }
}
