// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * RCS 메시지 본문입니다. 입력할 수 있는 항목은 <code>formatId</code>로 지정한 포맷에 따라 다릅니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 포맷별로 title/description/media 중 어떤 항목이 필수인지와 길이 제한이 문서화되어 있지 않습니다.
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
@JsonDeserialize(builder = RcsBody.Builder.class)
@JsonPropertyOrder({"title", "description", "media"})
public final class RcsBody {

    private final String title;
    private final String description;
    private final String media;

    private RcsBody(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.media = builder.media;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.title = this.title;
        builder.description = this.description;
        builder.media = this.media;
        return builder;
    }

    /**
     * 메시지 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 메시지 본문입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 이미지입니다. 필드 설명은 "이미지 URL"이지만, 이미지 업로드(<code>POST /api/comm/v1/file/rcs</code>) 응답의 <code>data.data.media</code> 값(미디어 키)을 넣도록 안내합니다.
     *
     * <p><b>확인 필요:</b> 외부 이미지 URL을 직접 넣을 수 있는지, 업로드로 받은 미디어 키(maapfile://...)만 허용되는지 불명확합니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("media")
    public String getMedia() {
        return media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RcsBody)) {
            return false;
        }
        RcsBody other = (RcsBody) o;
        return Objects.equals(title, other.title)
                && Objects.equals(description, other.description)
                && Objects.equals(media, other.media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, media);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsBody{", "}");
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (description != null) {
            joiner.add("description=" + io.github.icommapi.bizgo.internal.Masking.length(description));
        }
        if (media != null) {
            joiner.add("media=" + media);
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsBody}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String title;
        private String description;
        private String media;

        /** Creates an empty builder; same as {@link RcsBody#builder()}. */
        public Builder() {
        }

        /**
         * 메시지 제목입니다.
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        @JsonProperty("title")
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 메시지 본문입니다.
         *
         * @param description the value (null clears it)
         * @return this builder
         */
        @JsonProperty("description")
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * 이미지입니다. 필드 설명은 "이미지 URL"이지만, 이미지 업로드(<code>POST /api/comm/v1/file/rcs</code>) 응답의 <code>data.data.media</code> 값(미디어 키)을 넣도록 안내합니다.
         *
         * <p><b>확인 필요:</b> 외부 이미지 URL을 직접 넣을 수 있는지, 업로드로 받은 미디어 키(maapfile://...)만 허용되는지 불명확합니다.
         *
         * @param media the value (null clears it)
         * @return this builder
         */
        @JsonProperty("media")
        public Builder media(String media) {
            this.media = media;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code RcsBody}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public RcsBody build() {
            RcsBody built = new RcsBody(this);
            ModelValidator v = new ModelValidator("RcsBody");
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        RcsBody buildUnvalidated() {
            return new RcsBody(this);
        }
    }
}
