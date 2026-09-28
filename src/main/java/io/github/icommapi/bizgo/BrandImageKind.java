package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.util.Arrays;
import java.util.stream.Collectors;

/** Kakao brand message image type. Each type has its own size and ratio rules (see the API reference). */
public enum BrandImageKind {
    /** Default image ({@code /file/brandmessage/default}). */
    DEFAULT("default"),
    /** Wide image ({@code FW}). */
    WIDE("wide"),
    /** Wide item list, items 2 to 4 ({@code FL}). */
    WIDE_ITEM_LIST("wideItemList"),
    /** Wide item list, first item ({@code FL}). */
    WIDE_ITEM_LIST_FIRST("wideItemList/first"),
    /** Carousel feed ({@code FC}). */
    CAROUSEL_FEED("carouselFeed"),
    /** Carousel commerce ({@code FA}). */
    CAROUSEL_COMMERCE("carouselCommerce");

    private final String value;

    BrandImageKind(String value) {
        this.value = value;
    }

    /**
     * Path value used in {@code /api/comm/v1/file/brandmessage/{kind}}.
     *
     * @return value such as {@code wideItemList/first}
     */
    public String value() {
        return value;
    }

    /**
     * Looks up a kind by its path value.
     *
     * @param value {@code default}, {@code wide}, {@code wideItemList}, {@code wideItemList/first},
     *     {@code carouselFeed} or {@code carouselCommerce}
     * @return the kind
     * @throws ValidationException for any other value
     */
    public static BrandImageKind fromValue(String value) {
        for (BrandImageKind kind : values()) {
            if (kind.value.equals(value)) {
                return kind;
            }
        }
        throw new ValidationException("kind", "지원하지 않는 브랜드메시지 이미지 종류입니다. 허용 값: "
                + Arrays.stream(values()).map(BrandImageKind::value).collect(Collectors.joining(", ")));
    }
}
