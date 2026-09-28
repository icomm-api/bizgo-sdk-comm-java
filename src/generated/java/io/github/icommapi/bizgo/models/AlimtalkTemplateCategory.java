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
 * 알림톡 템플릿 카테고리입니다.
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
@JsonPropertyOrder({"code", "name", "groupName", "inclusion", "exclusion"})
public final class AlimtalkTemplateCategory {

    private final String code;
    private final String name;
    private final String groupName;
    private final String inclusion;
    private final String exclusion;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private AlimtalkTemplateCategory(
            @JsonProperty("code") String code,
            @JsonProperty("name") String name,
            @JsonProperty("groupName") String groupName,
            @JsonProperty("inclusion") String inclusion,
            @JsonProperty("exclusion") String exclusion) {
        this.code = code;
        this.name = name;
        this.groupName = groupName;
        this.inclusion = inclusion;
        this.exclusion = exclusion;
        this.additionalProperties = new LinkedHashMap<>();
    }

    private AlimtalkTemplateCategory(Builder builder) {
        this(builder.code, builder.name, builder.groupName, builder.inclusion, builder.exclusion);
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
        builder.name = this.name;
        builder.groupName = this.groupName;
        builder.inclusion = this.inclusion;
        builder.exclusion = this.exclusion;
        builder.additionalProperties.putAll(this.additionalProperties);
        return builder;
    }

    /**
     * 카테고리 코드입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 카테고리 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 카테고리 그룹 이름입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("groupName")
    public String getGroupName() {
        return groupName;
    }

    /**
     * 포함 기준 설명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("inclusion")
    public String getInclusion() {
        return inclusion;
    }

    /**
     * 제외 기준 설명입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("exclusion")
    public String getExclusion() {
        return exclusion;
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
        if (!(o instanceof AlimtalkTemplateCategory)) {
            return false;
        }
        AlimtalkTemplateCategory other = (AlimtalkTemplateCategory) o;
        return Objects.equals(code, other.code)
                && Objects.equals(name, other.name)
                && Objects.equals(groupName, other.groupName)
                && Objects.equals(inclusion, other.inclusion)
                && Objects.equals(exclusion, other.exclusion)
                && Objects.equals(additionalProperties, other.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, groupName, inclusion, exclusion, additionalProperties);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "AlimtalkTemplateCategory{", "}");
        if (code != null) {
            joiner.add("code=" + code);
        }
        if (name != null) {
            joiner.add("name=" + io.github.icommapi.bizgo.internal.Masking.length(name));
        }
        if (groupName != null) {
            joiner.add("groupName=" + io.github.icommapi.bizgo.internal.Masking.length(groupName));
        }
        if (inclusion != null) {
            joiner.add("inclusion=" + io.github.icommapi.bizgo.internal.Masking.length(inclusion));
        }
        if (exclusion != null) {
            joiner.add("exclusion=" + io.github.icommapi.bizgo.internal.Masking.length(exclusion));
        }
        if (!additionalProperties.isEmpty()) {
            joiner.add("additionalProperties=" + additionalProperties.keySet());
        }
        return joiner.toString();
    }

    /** Builder for {@link AlimtalkTemplateCategory}. */
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String code;
        private String name;
        private String groupName;
        private String inclusion;
        private String exclusion;
        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

        /** Creates an empty builder; same as {@link AlimtalkTemplateCategory#builder()}. */
        public Builder() {
        }

        /**
         * 카테고리 코드입니다.
         *
         * @param code the value (null clears it)
         * @return this builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * 카테고리 이름입니다.
         *
         * @param name the value (null clears it)
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * 카테고리 그룹 이름입니다.
         *
         * @param groupName the value (null clears it)
         * @return this builder
         */
        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        /**
         * 포함 기준 설명입니다.
         *
         * @param inclusion the value (null clears it)
         * @return this builder
         */
        public Builder inclusion(String inclusion) {
            this.inclusion = inclusion;
            return this;
        }

        /**
         * 제외 기준 설명입니다.
         *
         * @param exclusion the value (null clears it)
         * @return this builder
         */
        public Builder exclusion(String exclusion) {
            this.exclusion = exclusion;
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
         * @return a new immutable {@code AlimtalkTemplateCategory}
         */
        public AlimtalkTemplateCategory build() {
            return new AlimtalkTemplateCategory(this);
        }
    }
}
