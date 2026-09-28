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
 * 대화방 메뉴 1개의 클릭 통계입니다.
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
@JsonPropertyOrder({"postbackId", "menuType", "actionType", "title", "clickCount", "subList"})
public final class InsightRcsMenuClick {

    private final String postbackId;
    private final String menuType;
    private final String actionType;
    private final String title;
    private final Long clickCount;
    private final List<InsightRcsMenuClick> subList;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private InsightRcsMenuClick(
            @JsonProperty("postbackId") String postbackId,
            @JsonProperty("menuType") String menuType,
            @JsonProperty("actionType") String actionType,
            @JsonProperty("title") String title,
            @JsonProperty("clickCount") Long clickCount,
            @JsonProperty("subList") List<InsightRcsMenuClick> subList) {
        this.postbackId = postbackId;
        this.menuType = menuType;
        this.actionType = actionType;
        this.title = title;
        this.clickCount = clickCount;
        this.subList = subList == null ? null : Collections.unmodifiableList(new ArrayList<>(subList));
        this.additionalProperties = new LinkedHashMap<>();
    }

    private InsightRcsMenuClick(Builder builder) {
        this(builder.postbackId, builder.menuType, builder.actionType, builder.title, builder.clickCount, builder.subList);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.postbackId = this.postbackId;
        builder.menuType = this.menuType;
        builder.actionType = this.actionType;
        builder.title = this.title;
        builder.clickCount = this.clickCount;
        builder.subList = this.subList;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 포스트백 ID입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("postbackId")
    public String getPostbackId() {
        return postbackId;
    }

    /**
     * 메뉴 유형입니다. 알려진 값은 <code>text</code>입니다.
     *
     * <p>알려진 값 <code>text</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("menuType")
    public String getMenuType() {
        return menuType;
    }

    /**
     * 메뉴 액션 유형입니다. 알려진 값은 <code>postbackAction</code>입니다.
     *
     * <p>알려진 값 <code>postbackAction</code>
     *
     * @return the value, or null if not set
     */
    @JsonProperty("actionType")
    public String getActionType() {
        return actionType;
    }

    /**
     * 메뉴 제목입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 클릭 수입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("clickCount")
    public Long getClickCount() {
        return clickCount;
    }

    /**
     * 하위 메뉴 목록입니다. 상위 메뉴와 같은 항목으로 구성됩니다.
     *
     * <p><b>확인 필요:</b> 하위 메뉴가 다시 subList를 가질 수 있는지(중첩 깊이)가 문서에 없습니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("subList")
    public List<InsightRcsMenuClick> getSubList() {
        return subList;
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
        if (!(o instanceof InsightRcsMenuClick)) {
            return false;
        }
        InsightRcsMenuClick other = (InsightRcsMenuClick) o;
        return Objects.equals(postbackId, other.postbackId)
                && Objects.equals(menuType, other.menuType)
                && Objects.equals(actionType, other.actionType)
                && Objects.equals(title, other.title)
                && Objects.equals(clickCount, other.clickCount)
                && Objects.equals(subList, other.subList)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postbackId, menuType, actionType, title, clickCount, subList, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "InsightRcsMenuClick{", "}");
        if (postbackId != null) {
            joiner.add("postbackId=" + io.github.icommapi.bizgo.internal.Masking.length(postbackId));
        }
        if (menuType != null) {
            joiner.add("menuType=" + io.github.icommapi.bizgo.internal.Masking.length(menuType));
        }
        if (actionType != null) {
            joiner.add("actionType=" + io.github.icommapi.bizgo.internal.Masking.length(actionType));
        }
        if (title != null) {
            joiner.add("title=" + io.github.icommapi.bizgo.internal.Masking.length(title));
        }
        if (clickCount != null) {
            joiner.add("clickCount=***");
        }
        if (subList != null) {
            joiner.add("subList=" + subList);
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link InsightRcsMenuClick}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String postbackId;
        private String menuType;
        private String actionType;
        private String title;
        private Long clickCount;
        private List<InsightRcsMenuClick> subList;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link InsightRcsMenuClick#builder()}. */
        public Builder() {
        }

        /**
         * 포스트백 ID입니다.
         *
         * @param postbackId the value (null clears it)
         * @return this builder
         */
        public Builder postbackId(String postbackId) {
            this.postbackId = postbackId;
            return this;
        }

        /**
         * 메뉴 유형입니다. 알려진 값은 <code>text</code>입니다.
         *
         * <p>알려진 값 <code>text</code>
         *
         * @param menuType the value (null clears it)
         * @return this builder
         */
        public Builder menuType(String menuType) {
            this.menuType = menuType;
            return this;
        }

        /**
         * 메뉴 액션 유형입니다. 알려진 값은 <code>postbackAction</code>입니다.
         *
         * <p>알려진 값 <code>postbackAction</code>
         *
         * @param actionType the value (null clears it)
         * @return this builder
         */
        public Builder actionType(String actionType) {
            this.actionType = actionType;
            return this;
        }

        /**
         * 메뉴 제목입니다.
         *
         * @param title the value (null clears it)
         * @return this builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * 클릭 수입니다.
         *
         * @param clickCount the value (null clears it)
         * @return this builder
         */
        public Builder clickCount(Long clickCount) {
            this.clickCount = clickCount;
            return this;
        }

        /**
         * 하위 메뉴 목록입니다. 상위 메뉴와 같은 항목으로 구성됩니다.
         *
         * <p><b>확인 필요:</b> 하위 메뉴가 다시 subList를 가질 수 있는지(중첩 깊이)가 문서에 없습니다.
         *
         * @param subList the value (null clears it)
         * @return this builder
         */
        public Builder subList(List<InsightRcsMenuClick> subList) {
            this.subList = subList;
            return this;
        }

        /**
         * Varargs form of {@link #subList(List)}.
         *
         * @param subList values
         * @return this builder
         */
        public Builder subList(InsightRcsMenuClick... subList) {
            this.subList = subList == null ? null : Arrays.asList(subList);
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
         * @return a new immutable {@code InsightRcsMenuClick}
         */
        public InsightRcsMenuClick build() {
            return new InsightRcsMenuClick(this);
        }
    }
}
