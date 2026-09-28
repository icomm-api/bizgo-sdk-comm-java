// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * KakaoSenderAccountServiceResult.
 *
 * <p>Response model: unknown JSON properties are kept in {@link #getAdditionalProperties()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({"code", "result", "ref", "resultMsg", "kakao"})
public final class KakaoSenderAccountServiceResult {

    private final String code;
    private final String result;
    private final String ref;
    private final String resultMsg;
    private final KakaoSenderProfileResult kakao;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private KakaoSenderAccountServiceResult(
            @JsonProperty("code") String code,
            @JsonProperty("result") String result,
            @JsonProperty("ref") String ref,
            @JsonProperty("resultMsg") String resultMsg,
            @JsonProperty("kakao") KakaoSenderProfileResult kakao) {
        this.code = code;
        this.result = result;
        this.ref = ref;
        this.resultMsg = resultMsg;
        this.kakao = kakao;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private KakaoSenderAccountServiceResult(Builder builder) {
        this(builder.code, builder.result, builder.ref, builder.resultMsg, builder.kakao);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.code = this.code;
        builder.result = this.result;
        builder.ref = this.ref;
        builder.resultMsg = this.resultMsg;
        builder.kakao = this.kakao;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 처리 결과 코드입니다. <code>A000</code>이면 성공입니다. 코드 목록은 에러코드 문서를 참고합니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 처리 결과 설명입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    /**
     * 요청 시 전달한 참조값입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * 호출 결과 메시지입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("resultMsg")
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * {@code kakao}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("kakao")
    public KakaoSenderProfileResult getKakao() {
        return kakao;
    }

    /**
     * Properties the server sent that are not in the spec (new fields are kept instead of dropped).
     *
     * @return unmodifiable map, empty if there are none
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnySetter
    private void putAdditionalProperty(String name, Object value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KakaoSenderAccountServiceResult)) {
            return false;
        }
        KakaoSenderAccountServiceResult other = (KakaoSenderAccountServiceResult) o;
        return Objects.equals(code, other.code)
                && Objects.equals(result, other.result)
                && Objects.equals(ref, other.ref)
                && Objects.equals(resultMsg, other.resultMsg)
                && Objects.equals(kakao, other.kakao)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, result, ref, resultMsg, kakao, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoSenderAccountServiceResult{", "}");
        if (code != null) {
            joiner.add("code=" + code);
        }
        if (result != null) {
            joiner.add("result=" + result);
        }
        if (ref != null) {
            joiner.add("ref=" + io.github.icommapi.bizgo.internal.Masking.length(ref));
        }
        if (resultMsg != null) {
            joiner.add("resultMsg=" + io.github.icommapi.bizgo.internal.Masking.length(resultMsg));
        }
        if (kakao != null) {
            joiner.add("kakao=" + kakao);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoSenderAccountServiceResult}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String code;
        private String result;
        private String ref;
        private String resultMsg;
        private KakaoSenderProfileResult kakao;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link KakaoSenderAccountServiceResult#builder()}. */
        public Builder() {
        }

        /**
         * 처리 결과 코드입니다. <code>A000</code>이면 성공입니다. 코드 목록은 에러코드 문서를 참고합니다.
         *
         * <p>필수
         *
         * @param code the value (null clears it)
         * @return this builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * 처리 결과 설명입니다.
         *
         * <p>필수
         *
         * @param result the value (null clears it)
         * @return this builder
         */
        public Builder result(String result) {
            this.result = result;
            return this;
        }

        /**
         * 요청 시 전달한 참조값입니다.
         *
         * @param ref the value (null clears it)
         * @return this builder
         */
        public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

        /**
         * 호출 결과 메시지입니다.
         *
         * @param resultMsg the value (null clears it)
         * @return this builder
         */
        public Builder resultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
            return this;
        }

        /**
         * {@code kakao}.
         *
         * @param kakao the value (null clears it)
         * @return this builder
         */
        public Builder kakao(KakaoSenderProfileResult kakao) {
            this.kakao = kakao;
            return this;
        }

        /**
         * Adds a property that is not in the spec.
         *
         * @param name JSON property name
         * @param value value
         * @return this builder
         */
        public Builder additionalProperty(String name, Object value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code KakaoSenderAccountServiceResult}
         */
        public KakaoSenderAccountServiceResult build() {
            return new KakaoSenderAccountServiceResult(this);
        }
    }
}
