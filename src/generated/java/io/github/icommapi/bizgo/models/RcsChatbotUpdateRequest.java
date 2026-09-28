// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.github.icommapi.bizgo.FileUpload;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 대화방 수정 요청(multipart/form-data)입니다. <code>chatbot</code>은 JSON 문자열 파트로 보냅니다.
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
@JsonDeserialize(builder = RcsChatbotUpdateRequest.Builder.class)
@JsonPropertyOrder({"brandId", "chatbot", "subNumCertificate"})
public final class RcsChatbotUpdateRequest {

    private final String brandId;
    private final RcsChatbot chatbot;
    private final FileUpload subNumCertificate;

    private RcsChatbotUpdateRequest(Builder builder) {
        this.brandId = builder.brandId;
        this.chatbot = builder.chatbot;
        this.subNumCertificate = builder.subNumCertificate;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.brandId = this.brandId;
        builder.chatbot = this.chatbot;
        builder.subNumCertificate = this.subNumCertificate;
        return builder;
    }

    /**
     * 수정할 대화방이 속한 브랜드 ID입니다.
     *
     * <p>필수
     *
     * @return the value, or null if not set
     */
    @JsonProperty("brandId")
    public String getBrandId() {
        return brandId;
    }

    /**
     * 수정할 대화방 정보입니다. 문서상 타입은 String(JSON 문자열)이며, JSON으로 직렬화해 한 파트로 보냅니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> chatbot의 하위 필드가 모두 선택으로 표시되어 어떤 필드로 수정 대상을 식별하는지(chatbotId 필수 여부) 불명확합니다. status·approvalResult·registerDate처럼 서버가 정하는 값도 요청 필드로 나열되어 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("chatbot")
    public RcsChatbot getChatbot() {
        return chatbot;
    }

    /**
     * 부가번호 사용을 증명하는 서류 파일입니다.
     *
     * <p>필수
     *
     * <p><b>확인 필요:</b> 부가번호를 바꾸지 않는 수정에도 필수인지 불명확합니다. 허용 형식·용량도 문서화되어 있지 않습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("subNumCertificate")
    public FileUpload getSubNumCertificate() {
        return subNumCertificate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsChatbotUpdateRequest)) {
            return false;
        }
        RcsChatbotUpdateRequest other = (RcsChatbotUpdateRequest) o;
        return Objects.equals(brandId, other.brandId)
                && Objects.equals(chatbot, other.chatbot)
                && Objects.equals(subNumCertificate, other.subNumCertificate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, chatbot, subNumCertificate);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsChatbotUpdateRequest{", "}");
        if (brandId != null) {
            joiner.add("brandId=" + io.github.icommapi.bizgo.internal.Masking.length(brandId));
        }
        if (chatbot != null) {
            joiner.add("chatbot=" + chatbot);
        }
        if (subNumCertificate != null) {
            joiner.add("subNumCertificate=***");
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsChatbotUpdateRequest}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String brandId;
        private RcsChatbot chatbot;
        private FileUpload subNumCertificate;

        /** Creates an empty builder; same as {@link RcsChatbotUpdateRequest#builder()}. */
        public Builder() {
        }

        /**
         * 수정할 대화방이 속한 브랜드 ID입니다.
         *
         * <p>필수
         *
         * @param brandId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("brandId")
        public Builder brandId(String brandId) {
            this.brandId = brandId;
            return this;
        }

        /**
         * 수정할 대화방 정보입니다. 문서상 타입은 String(JSON 문자열)이며, JSON으로 직렬화해 한 파트로 보냅니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> chatbot의 하위 필드가 모두 선택으로 표시되어 어떤 필드로 수정 대상을 식별하는지(chatbotId 필수 여부) 불명확합니다. status·approvalResult·registerDate처럼 서버가 정하는 값도 요청 필드로 나열되어 있습니다.
         *
         * @param chatbot the value (null clears it)
         * @return this builder
         */
        @JsonProperty("chatbot")
        public Builder chatbot(RcsChatbot chatbot) {
            this.chatbot = chatbot;
            return this;
        }

        /**
         * 부가번호 사용을 증명하는 서류 파일입니다.
         *
         * <p>필수
         *
         * <p><b>확인 필요:</b> 부가번호를 바꾸지 않는 수정에도 필수인지 불명확합니다. 허용 형식·용량도 문서화되어 있지 않습니다.
         *
         * @param subNumCertificate the value (null clears it)
         * @return this builder
         */
        @JsonProperty("subNumCertificate")
        public Builder subNumCertificate(FileUpload subNumCertificate) {
            this.subNumCertificate = subNumCertificate;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsChatbotUpdateRequest}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsChatbotUpdateRequest build() {
            RcsChatbotUpdateRequest built = new RcsChatbotUpdateRequest(this);
            ModelValidator v = new ModelValidator("RcsChatbotUpdateRequest");
            v.required("brandId", built.brandId);
            v.required("chatbot", built.chatbot);
            v.required("subNumCertificate", built.subNumCertificate);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsChatbotUpdateRequest buildUnvalidated() {
            return new RcsChatbotUpdateRequest(this);
        }
    }
}
