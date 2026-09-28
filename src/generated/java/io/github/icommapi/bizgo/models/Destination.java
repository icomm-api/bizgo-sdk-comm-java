// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 수신자 정보입니다.
 *
 * <p>Request model: immutable, created with {@link #builder()}, validated in {@link Builder#build()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonDeserialize(builder = Destination.Builder.class)
@JsonPropertyOrder({"to", "replaceWords", "ref"})
public final class Destination {

    private final String to;
    private final Map<String, String> replaceWords;
    private final String ref;

    private Destination(Builder builder) {
        this.to = builder.to;
        this.replaceWords = builder.replaceWords == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(builder.replaceWords));
        this.ref = builder.ref;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.to = this.to;
        builder.replaceWords = this.replaceWords;
        builder.ref = this.ref;
        return builder;
    }

    /**
     * 수신번호입니다. 휴대폰 번호는 11자리 형식을 씁니다(국제메시지는 채널 규격 참고).
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    /**
     * 치환메시지 변수입니다. 본문·제목의 <code>#&#123;key&#125;</code>를 이 값으로 바꿉니다. 알림톡·브랜드메시지 템플릿 자동 치환 발송(<code>sendType</code>이 <code>template</code>)에서는 필수입니다(각 채널 스키마의 <code>x-sdk-required-if</code>).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("replaceWords")
    public Map<String, String> getReplaceWords() {
        return replaceWords;
    }

    /**
     * 수신자별 참조 필드입니다. 값이 있으면 이 수신번호에는 요청 단위 <code>ref</code> 대신 이 값이 리포트에 담깁니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) o;
        return Objects.equals(to, other.to)
                && Objects.equals(replaceWords, other.replaceWords)
                && Objects.equals(ref, other.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, replaceWords, ref);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "Destination{", "}");
        if (to != null) {
            joiner.add("to=" + io.github.icommapi.bizgo.internal.Masking.phone(to));
        }
        if (replaceWords != null) {
            joiner.add("replaceWords=***");
        }
        if (ref != null) {
            joiner.add("ref=" + io.github.icommapi.bizgo.internal.Masking.length(ref));
        }
        return joiner.toString();
    }

    /** Builder for {@link Destination}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String to;
        private Map<String, String> replaceWords;
        private String ref;

        /** Creates an empty builder; same as {@link Destination#builder()}. */
        public Builder() {
        }

        /**
         * 수신번호입니다. 휴대폰 번호는 11자리 형식을 씁니다(국제메시지는 채널 규격 참고).
         *
         * <p>필수
         *
         * @param to the value (null clears it)
         * @return this builder
         */
        @JsonProperty("to")
        public Builder to(String to) {
            this.to = to;
            return this;
        }

        /**
         * 치환메시지 변수입니다. 본문·제목의 <code>#&#123;key&#125;</code>를 이 값으로 바꿉니다. 알림톡·브랜드메시지 템플릿 자동 치환 발송(<code>sendType</code>이 <code>template</code>)에서는 필수입니다(각 채널 스키마의 <code>x-sdk-required-if</code>).
         *
         * @param replaceWords the value (null clears it)
         * @return this builder
         */
        @JsonProperty("replaceWords")
        public Builder replaceWords(Map<String, String> replaceWords) {
            this.replaceWords = replaceWords;
            return this;
        }

        /**
         * 수신자별 참조 필드입니다. 값이 있으면 이 수신번호에는 요청 단위 <code>ref</code> 대신 이 값이 리포트에 담깁니다.
         *
         * @param ref the value (null clears it)
         * @return this builder
         */
        @JsonProperty("ref")
        public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code Destination}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public Destination build() {
            Destination built = new Destination(this);
            ModelValidator v = new ModelValidator("Destination");
            v.required("to", built.to);
            v.mapValues("replaceWords", built.replaceWords, true);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        Destination buildUnvalidated() {
            return new Destination(this);
        }
    }
}
