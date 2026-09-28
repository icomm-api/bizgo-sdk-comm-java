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
 * 템플릿 상세 조회의 본문 영역입니다.
 *
 * <p><b>확인 필요(x-unverified):</b> 등록 요청의 body는 검증 파라미터 배열인데 상세 조회의 body는 description·mTitle·title 객체라서 구조가 다릅니다.
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
@JsonPropertyOrder({"description", "mTitle", "title"})
public final class RcsTemplateDetailBody {

    private final String description;
    private final String mTitle;
    private final String title;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private RcsTemplateDetailBody(
            @JsonProperty("description") String description,
            @JsonProperty("mTitle") String mTitle,
            @JsonProperty("title") String title) {
        this.description = description;
        this.mTitle = mTitle;
        this.title = title;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private RcsTemplateDetailBody(Builder builder) {
        this(builder.description, builder.mTitle, builder.title);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.description = this.description;
        builder.mTitle = this.mTitle;
        builder.title = this.title;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 본문 내용입니다. <code>#&#123;변수&#125;</code> 형태의 치환 변수를 포함할 수 있습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 메인 타이틀입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("mTitle")
    public String getMTitle() {
        return mTitle;
    }

    /**
     * 타이틀입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
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
        if (!(o instanceof RcsTemplateDetailBody)) {
            return false;
        }
        RcsTemplateDetailBody other = (RcsTemplateDetailBody) o;
        return Objects.equals(description, other.description)
                && Objects.equals(mTitle, other.mTitle)
                && Objects.equals(title, other.title)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, mTitle, title, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "RcsTemplateDetailBody{", "}");
        if (description != null) {
            joiner.add("description=" + io.github.icommapi.bizgo.internal.Masking.length(description));
        }
        if (mTitle != null) {
            joiner.add("mTitle=" + io.github.icommapi.bizgo.internal.Masking.length(mTitle));
        }
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link RcsTemplateDetailBody}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String description;
        private String mTitle;
        private String title;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link RcsTemplateDetailBody#builder()}. */
        public Builder() {
        }

        /**
         * 본문 내용입니다. <code>#&#123;변수&#125;</code> 형태의 치환 변수를 포함할 수 있습니다.
         *
         * @param description the value (null clears it)
         * @return this builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * 메인 타이틀입니다.
         *
         * @param mTitle the value (null clears it)
         * @return this builder
         */
        public Builder mTitle(String mTitle) {
            this.mTitle = mTitle;
            return this;
        }

        /**
         * 타이틀입니다.
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        public Builder title(String title) {
            this.title = title;
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
         * @return a new immutable {@code RcsTemplateDetailBody}
         */
        public RcsTemplateDetailBody build() {
            return new RcsTemplateDetailBody(this);
        }
    }
}
