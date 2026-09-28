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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * KakaoSenderListServiceResult.
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
@JsonPropertyOrder({"code", "result", "ref", "resultMsg", "page", "totalPage", "totalCount", "hasNext", "channels"})
public final class KakaoSenderListServiceResult {

    private final String code;
    private final String result;
    private final String ref;
    private final String resultMsg;
    private final Long page;
    private final Long totalPage;
    private final Long totalCount;
    private final Boolean hasNext;
    private final List<KakaoSenderChannel> channels;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private KakaoSenderListServiceResult(
            @JsonProperty("code") String code,
            @JsonProperty("result") String result,
            @JsonProperty("ref") String ref,
            @JsonProperty("resultMsg") String resultMsg,
            @JsonProperty("page") Long page,
            @JsonProperty("totalPage") Long totalPage,
            @JsonProperty("totalCount") Long totalCount,
            @JsonProperty("hasNext") Boolean hasNext,
            @JsonProperty("channels") List<KakaoSenderChannel> channels) {
        this.code = code;
        this.result = result;
        this.ref = ref;
        this.resultMsg = resultMsg;
        this.page = page;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.hasNext = hasNext;
        this.channels = channels == null ? null : Collections.unmodifiableList(new ArrayList<>(channels));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private KakaoSenderListServiceResult(Builder builder) {
        this(builder.code, builder.result, builder.ref, builder.resultMsg, builder.page, builder.totalPage, builder.totalCount, builder.hasNext, builder.channels);
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
        builder.page = this.page;
        builder.totalPage = this.totalPage;
        builder.totalCount = this.totalCount;
        builder.hasNext = this.hasNext;
        builder.channels = this.channels;
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
     * 현재 페이지 번호입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("page")
    public Long getPage() {
        return page;
    }

    /**
     * 전체 페이지 수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("totalPage")
    public Long getTotalPage() {
        return totalPage;
    }

    /**
     * 전체 조회 건수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("totalCount")
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * 다음 페이지 존재 여부입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("hasNext")
    public Boolean getHasNext() {
        return hasNext;
    }

    /**
     * 발신프로필 목록입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("channels")
    public List<KakaoSenderChannel> getChannels() {
        return channels;
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
        if (!(o instanceof KakaoSenderListServiceResult)) {
            return false;
        }
        KakaoSenderListServiceResult other = (KakaoSenderListServiceResult) o;
        return Objects.equals(code, other.code)
                && Objects.equals(result, other.result)
                && Objects.equals(ref, other.ref)
                && Objects.equals(resultMsg, other.resultMsg)
                && Objects.equals(page, other.page)
                && Objects.equals(totalPage, other.totalPage)
                && Objects.equals(totalCount, other.totalCount)
                && Objects.equals(hasNext, other.hasNext)
                && Objects.equals(channels, other.channels)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, result, ref, resultMsg, page, totalPage, totalCount, hasNext, channels, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "KakaoSenderListServiceResult{", "}");
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
        if (page != null) {
            joiner.add("page=***");
        }
        if (totalPage != null) {
            joiner.add("totalPage=***");
        }
        if (totalCount != null) {
            joiner.add("totalCount=***");
        }
        if (hasNext != null) {
            joiner.add("hasNext=" + hasNext);
        }
        if (channels != null) {
            joiner.add("channels=" + channels);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link KakaoSenderListServiceResult}. */
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
        private Long page;
        private Long totalPage;
        private Long totalCount;
        private Boolean hasNext;
        private List<KakaoSenderChannel> channels;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link KakaoSenderListServiceResult#builder()}. */
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
         * 현재 페이지 번호입니다.
         *
         * @param page the value (null clears it)
         * @return this builder
         */
        public Builder page(Long page) {
            this.page = page;
            return this;
        }

        /**
         * 전체 페이지 수입니다.
         *
         * @param totalPage the value (null clears it)
         * @return this builder
         */
        public Builder totalPage(Long totalPage) {
            this.totalPage = totalPage;
            return this;
        }

        /**
         * 전체 조회 건수입니다.
         *
         * @param totalCount the value (null clears it)
         * @return this builder
         */
        public Builder totalCount(Long totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        /**
         * 다음 페이지 존재 여부입니다.
         *
         * @param hasNext the value (null clears it)
         * @return this builder
         */
        public Builder hasNext(Boolean hasNext) {
            this.hasNext = hasNext;
            return this;
        }

        /**
         * 발신프로필 목록입니다.
         *
         * @param channels the value (null clears it)
         * @return this builder
         */
        public Builder channels(List<KakaoSenderChannel> channels) {
            this.channels = channels;
            return this;
        }

        /**
         * Varargs form of {@link #channels(List)}.
         *
         * @param channels values
         * @return this builder
         */
        public Builder channels(KakaoSenderChannel... channels) {
            this.channels = channels == null ? null : Arrays.asList(channels);
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
         * @return a new immutable {@code KakaoSenderListServiceResult}
         */
        public KakaoSenderListServiceResult build() {
            return new KakaoSenderListServiceResult(this);
        }
    }
}
