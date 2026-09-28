// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 브랜드메시지 카탈로그 요소입니다. <code>msgType</code>이 <code>FG</code>일 때 사용합니다.
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
@JsonDeserialize(builder = BrandMessageCatalog.Builder.class)
@JsonPropertyOrder({"list"})
public final class BrandMessageCatalog {

    private final List<BrandMessageCatalogItem> list;

    private BrandMessageCatalog(Builder builder) {
        this.list = builder.list == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.list));
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.list = this.list;
        return builder;
    }

    /**
     * 카탈로그 아이템 목록입니다. FG 타입에서 필수이며 최소 3개, 최대 7개입니다. 아이템이 홀수 개(3·5·7)이면 첫 번째 아이템만 2:1 가로형 이미지(카탈로그 홀수형 첫번째 이미지 업로드)를, 나머지는 1:1 정사각형 이미지(카탈로그 이미지 업로드)를 씁니다. 짝수 개(4·6)이면 전부 1:1입니다.
     *
     * <p>항목 수 3~7
     *
     * @return the value, or null if not set
     */
    @JsonProperty("list")
    public List<BrandMessageCatalogItem> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrandMessageCatalog)) {
            return false;
        }
        BrandMessageCatalog other = (BrandMessageCatalog) o;
        return Objects.equals(list, other.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "BrandMessageCatalog{", "}");
        if (list != null) {
            joiner.add("list=" + list);
        }
        return joiner.toString();
    }

    /** Builder for {@link BrandMessageCatalog}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private List<BrandMessageCatalogItem> list;

        /** Creates an empty builder; same as {@link BrandMessageCatalog#builder()}. */
        public Builder() {
        }

        /**
         * 카탈로그 아이템 목록입니다. FG 타입에서 필수이며 최소 3개, 최대 7개입니다. 아이템이 홀수 개(3·5·7)이면 첫 번째 아이템만 2:1 가로형 이미지(카탈로그 홀수형 첫번째 이미지 업로드)를, 나머지는 1:1 정사각형 이미지(카탈로그 이미지 업로드)를 씁니다. 짝수 개(4·6)이면 전부 1:1입니다.
         *
         * <p>항목 수 3~7
         *
         * @param list the value (null clears it)
         * @return this builder
         */
        @JsonProperty("list")
        public Builder list(List<BrandMessageCatalogItem> list) {
            this.list = list;
            return this;
        }

        /**
         * Varargs form of {@link #list(List)}.
         *
         * @param list values
         * @return this builder
         */
        public Builder list(BrandMessageCatalogItem... list) {
            this.list = list == null ? null : Arrays.asList(list);
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code BrandMessageCatalog}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public BrandMessageCatalog build() {
            BrandMessageCatalog built = new BrandMessageCatalog(this);
            ModelValidator v = new ModelValidator("BrandMessageCatalog");
            v.items("list", built.list, 3, 7);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        BrandMessageCatalog buildUnvalidated() {
            return new BrandMessageCatalog(this);
        }
    }
}
