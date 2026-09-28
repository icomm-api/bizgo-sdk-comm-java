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
 * 네이버 톡톡 첨부 정보 객체입니다(이미지, 버튼, 쿠폰). 쿠폰(<code>gift</code>)을 첨부하면 이미지는 첨부되지 않습니다(리포트 코드 72105).
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
@JsonDeserialize(builder = NaverTalkAttachments.Builder.class)
@JsonPropertyOrder({"imageUrl", "imageHashId", "buttons", "gift"})
public final class NaverTalkAttachments {

    private final String imageUrl;
    private final String imageHashId;
    private final List<NaverTalkButton> buttons;
    private final NaverTalkGift gift;

    private NaverTalkAttachments(Builder builder) {
        this.imageUrl = builder.imageUrl;
        this.imageHashId = builder.imageHashId;
        this.buttons = builder.buttons == null ? null : Collections.unmodifiableList(new ArrayList<>(builder.buttons));
        this.gift = builder.gift;
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /** Returns a builder initialised with the values of this object. */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.imageUrl = this.imageUrl;
        builder.imageHashId = this.imageHashId;
        builder.buttons = this.buttons;
        builder.gift = this.gift;
        return builder;
    }

    /**
     * 첨부 이미지 URL입니다.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 첨부 이미지 hashId입니다. 이미지 hashId에 해당하는 파트너 키나 템플릿 그룹키를 써야 합니다(리포트 코드 72011, 72104).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("imageHashId")
    public String getImageHashId() {
        return imageHashId;
    }

    /**
     * 버튼 목록입니다. 템플릿에 필요한 버튼 개수와 같아야 합니다(리포트 코드 72004).
     *
     * @return the value, or null if not set
     */
    @JsonProperty("buttons")
    public List<NaverTalkButton> getButtons() {
        return buttons;
    }

    /**
     * {@code gift}.
     *
     * @return the value, or null if not set
     */
    @JsonProperty("gift")
    public NaverTalkGift getGift() {
        return gift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NaverTalkAttachments)) {
            return false;
        }
        NaverTalkAttachments other = (NaverTalkAttachments) o;
        return Objects.equals(imageUrl, other.imageUrl)
                && Objects.equals(imageHashId, other.imageHashId)
                && Objects.equals(buttons, other.buttons)
                && Objects.equals(gift, other.gift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageUrl, imageHashId, buttons, gift);
    }

    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "NaverTalkAttachments{", "}");
        if (imageUrl != null) {
            joiner.add("imageUrl=" + io.github.icommapi.bizgo.internal.Masking.length(imageUrl));
        }
        if (imageHashId != null) {
            joiner.add("imageHashId=" + io.github.icommapi.bizgo.internal.Masking.length(imageHashId));
        }
        if (buttons != null) {
            joiner.add("buttons=" + buttons);
        }
        if (gift != null) {
            joiner.add("gift=" + gift);
        }
        return joiner.toString();
    }

    /** Builder for {@link NaverTalkAttachments}. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private String imageUrl;
        private String imageHashId;
        private List<NaverTalkButton> buttons;
        private NaverTalkGift gift;

        /** Creates an empty builder; same as {@link NaverTalkAttachments#builder()}. */
        public Builder() {
        }

        /**
         * 첨부 이미지 URL입니다.
         *
         * @param imageUrl the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imageUrl")
        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        /**
         * 첨부 이미지 hashId입니다. 이미지 hashId에 해당하는 파트너 키나 템플릿 그룹키를 써야 합니다(리포트 코드 72011, 72104).
         *
         * @param imageHashId the value (null clears it)
         * @return this builder
         */
        @JsonProperty("imageHashId")
        public Builder imageHashId(String imageHashId) {
            this.imageHashId = imageHashId;
            return this;
        }

        /**
         * 버튼 목록입니다. 템플릿에 필요한 버튼 개수와 같아야 합니다(리포트 코드 72004).
         *
         * @param buttons the value (null clears it)
         * @return this builder
         */
        @JsonProperty("buttons")
        public Builder buttons(List<NaverTalkButton> buttons) {
            this.buttons = buttons;
            return this;
        }

        /**
         * Varargs form of {@link #buttons(List)}.
         *
         * @param buttons values
         * @return this builder
         */
        public Builder buttons(NaverTalkButton... buttons) {
            this.buttons = buttons == null ? null : Arrays.asList(buttons);
            return this;
        }

        /**
         * {@code gift}.
         *
         * @param gift the value (null clears it)
         * @return this builder
         */
        @JsonProperty("gift")
        public Builder gift(NaverTalkGift gift) {
            this.gift = gift;
            return this;
        }

        /**
         * Builds the object.
         *
         * @return a new immutable {@code NaverTalkAttachments}
         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid
         */
        public NaverTalkAttachments build() {
            NaverTalkAttachments built = new NaverTalkAttachments(this);
            ModelValidator v = new ModelValidator("NaverTalkAttachments");
            v.items("buttons", built.buttons, -1, -1);
            v.check();
            return built;
        }

        /** Builds without request validation (responses, tests). */
        NaverTalkAttachments buildUnvalidated() {
            return new NaverTalkAttachments(this);
        }
    }
}
