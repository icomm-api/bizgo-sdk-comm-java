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
 * Query and header parameters of {@code createKakaoSender} ({@code POST /api/comm/v1/account/kakao/sender}).
 *
 * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}
 * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).
 */
public final class CreateKakaoSenderParams {

    private final String token;
    private final String phoneNumber;

    private CreateKakaoSenderParams(Builder builder) {
        this.token = builder.token;
        this.phoneNumber = builder.phoneNumber;
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
        builder.token = token;
        builder.phoneNumber = phoneNumber;
        return builder;
    }

    /**
     * 카카오 채널 인증 토큰 요청 후 카카오톡으로 받은 채널 인증 토큰 값입니다.
     *
     * <p>헤더 {@code token} · 필수
     *
     * @return the value, or null
     */
    public String getToken() {
        return token;
    }

    /**
     * 관리자 전화번호입니다. 카카오 채널 인증 토큰 요청 시 입력한 번호와 같아야 합니다.
     *
     * <p>헤더 {@code phoneNumber} · 필수
     *
     * @return the value, or null
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Query string values in spec order (lists joined with commas). The values can contain
     * personal data: do not log them.
     *
     * @return unmodifiable map; unset parameters are left out
     */
    public Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        return Collections.unmodifiableMap(query);
    }

    /**
     * Request header values. They can contain personal data: do not log them.
     *
     * @return unmodifiable map; unset headers are left out
     */
    public Map<String, String> toHeaders() {
        Map<String, String> headers = new LinkedHashMap<>();
        if (token != null) {
            headers.put("token", token);
        }
        if (phoneNumber != null) {
            headers.put("phoneNumber", phoneNumber);
        }
        return Collections.unmodifiableMap(headers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CreateKakaoSenderParams)) {
            return false;
        }
        CreateKakaoSenderParams other = (CreateKakaoSenderParams) o;
        return Objects.equals(token, other.token)
                && Objects.equals(phoneNumber, other.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, phoneNumber);
    }

    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "CreateKakaoSenderParams{", "}");
        if (token != null) {
            joiner.add("token=***");
        }
        if (phoneNumber != null) {
            joiner.add("phoneNumber=" + io.github.icommapi.bizgo.internal.Masking.phone(phoneNumber));
        }
        return joiner.toString();
    }

    /** Builder for {@link CreateKakaoSenderParams}. */
    public static final class Builder {
        private String token;
        private String phoneNumber;

        private Builder() {
        }

        /**
         * 카카오 채널 인증 토큰 요청 후 카카오톡으로 받은 채널 인증 토큰 값입니다.
         *
         * <p>헤더 {@code token} · 필수
         *
         * @param token the value (null clears it)
         * @return this builder
         */
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        /**
         * 관리자 전화번호입니다. 카카오 채널 인증 토큰 요청 시 입력한 번호와 같아야 합니다.
         *
         * <p>헤더 {@code phoneNumber} · 필수
         *
         * @param phoneNumber the value (null clears it)
         * @return this builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Builds the parameters.
         *
         * @return immutable parameters
         * @throws ValidationException if a required parameter is missing or a value is invalid
         */
        public CreateKakaoSenderParams build() {
            List<ValidationException.Violation> violations = new ArrayList<>();
            if (token == null) {
                violations.add(new ValidationException.Violation("CreateKakaoSenderParams.token", "필수 값입니다"));
            }
            if (token != null && token.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("CreateKakaoSenderParams.token", "제어 문자는 쓸 수 없습니다"));
            }
            if (token != null && token.isEmpty()) {
                violations.add(new ValidationException.Violation("CreateKakaoSenderParams.token", "빈 값입니다"));
            }
            if (phoneNumber == null) {
                violations.add(new ValidationException.Violation("CreateKakaoSenderParams.phoneNumber", "필수 값입니다"));
            }
            if (phoneNumber != null && phoneNumber.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                violations.add(new ValidationException.Violation("CreateKakaoSenderParams.phoneNumber", "제어 문자는 쓸 수 없습니다"));
            }
            if (phoneNumber != null && phoneNumber.isEmpty()) {
                violations.add(new ValidationException.Violation("CreateKakaoSenderParams.phoneNumber", "빈 값입니다"));
            }
            if (!violations.isEmpty()) {
                throw new ValidationException(violations);
            }
            return new CreateKakaoSenderParams(this);
        }

        CreateKakaoSenderParams buildUnvalidated() {
            return new CreateKakaoSenderParams(this);
        }
    }
}
