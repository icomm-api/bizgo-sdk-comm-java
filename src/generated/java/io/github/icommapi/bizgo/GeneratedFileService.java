// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.AlimtalkTemplateImageUploadResult;
import io.github.icommapi.bizgo.models.BrandMessageFileUploadResult;
import java.nio.file.Path;

/**
 * 이미지 파일 업로드: {@code client.files()}.
 *
 * <p>Methods generated from the spec for {@link FileService}; the hand-written class adds the
 * convenience methods (and wins on name clashes).
 */
public abstract class GeneratedFileService {

    private final Transport transport;

    GeneratedFileService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 브랜드메시지 이미지 업로드.
     *
     * 기본형 브랜드메시지에서 사용하는 이미지를 업로드합니다. 발송 본문에 파일을 직접 첨부하는 API가 아니라 브랜드메시지 템플릿 등록과 구성에 사용할 이미지 URL(<code>imgUrl</code>)을 발급받는 API입니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/default} (operationId {@code uploadBrandMessageDefaultImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageDefault(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_DEFAULT_IMAGE, Operations.UPLOAD_BRAND_MESSAGE_DEFAULT_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", BrandMessageFileUploadResult.class);
    }

    /**
     * 브랜드메시지 이미지 업로드.
     *
     * 기본형 브랜드메시지에서 사용하는 이미지를 업로드합니다. 발송 본문에 파일을 직접 첨부하는 API가 아니라 브랜드메시지 템플릿 등록과 구성에 사용할 이미지 URL(<code>imgUrl</code>)을 발급받는 API입니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/default} (operationId {@code uploadBrandMessageDefaultImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageDefault(Path file) {
        return uploadBrandMessageDefault(FileUpload.of(file));
    }

    /**
     * 브랜드메시지 와이드 이미지 업로드.
     *
     * 와이드 이미지형 브랜드메시지에서 사용하는 이미지를 업로드합니다. 발급된 <code>imgUrl</code>은 브랜드메시지 템플릿 또는 발송 구성에 사용합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/wide} (operationId {@code uploadBrandMessageWideImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageWide(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_WIDE_IMAGE, Operations.UPLOAD_BRAND_MESSAGE_WIDE_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", BrandMessageFileUploadResult.class);
    }

    /**
     * 브랜드메시지 와이드 이미지 업로드.
     *
     * 와이드 이미지형 브랜드메시지에서 사용하는 이미지를 업로드합니다. 발급된 <code>imgUrl</code>은 브랜드메시지 템플릿 또는 발송 구성에 사용합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/wide} (operationId {@code uploadBrandMessageWideImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageWide(Path file) {
        return uploadBrandMessageWide(FileUpload.of(file));
    }

    /**
     * 브랜드메시지 와이드 리스트 첫번째 이미지 업로드.
     *
     * 와이드 리스트형 브랜드메시지의 첫 번째 리스트 이미지에 사용할 이미지를 업로드합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/wideItemList/first} (operationId {@code uploadBrandMessageWideItemListFirstImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageWideItemListFirst(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_WIDE_ITEM_LIST_FIRST_IMAGE, Operations.UPLOAD_BRAND_MESSAGE_WIDE_ITEM_LIST_FIRST_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", BrandMessageFileUploadResult.class);
    }

    /**
     * 브랜드메시지 와이드 리스트 첫번째 이미지 업로드.
     *
     * 와이드 리스트형 브랜드메시지의 첫 번째 리스트 이미지에 사용할 이미지를 업로드합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/wideItemList/first} (operationId {@code uploadBrandMessageWideItemListFirstImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageWideItemListFirst(Path file) {
        return uploadBrandMessageWideItemListFirst(FileUpload.of(file));
    }

    /**
     * 브랜드메시지 와이드 리스트 이미지 업로드.
     *
     * 와이드 리스트형 브랜드메시지의 2~4번째 리스트 이미지에 사용할 이미지를 업로드합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/wideItemList} (operationId {@code uploadBrandMessageWideItemListImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageWideItemList(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_WIDE_ITEM_LIST_IMAGE, Operations.UPLOAD_BRAND_MESSAGE_WIDE_ITEM_LIST_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", BrandMessageFileUploadResult.class);
    }

    /**
     * 브랜드메시지 와이드 리스트 이미지 업로드.
     *
     * 와이드 리스트형 브랜드메시지의 2~4번째 리스트 이미지에 사용할 이미지를 업로드합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/wideItemList} (operationId {@code uploadBrandMessageWideItemListImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageWideItemList(Path file) {
        return uploadBrandMessageWideItemList(FileUpload.of(file));
    }

    /**
     * 브랜드메시지 캐러셀 피드 이미지 업로드.
     *
     * 캐러셀 피드형 브랜드메시지에서 사용하는 이미지를 업로드합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/carouselFeed} (operationId {@code uploadBrandMessageCarouselFeedImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageCarouselFeed(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_CAROUSEL_FEED_IMAGE, Operations.UPLOAD_BRAND_MESSAGE_CAROUSEL_FEED_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", BrandMessageFileUploadResult.class);
    }

    /**
     * 브랜드메시지 캐러셀 피드 이미지 업로드.
     *
     * 캐러셀 피드형 브랜드메시지에서 사용하는 이미지를 업로드합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/carouselFeed} (operationId {@code uploadBrandMessageCarouselFeedImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageCarouselFeed(Path file) {
        return uploadBrandMessageCarouselFeed(FileUpload.of(file));
    }

    /**
     * 브랜드메시지 캐러셀 커머스 이미지 업로드.
     *
     * 캐러셀 커머스형 브랜드메시지에서 사용하는 이미지를 업로드합니다. 전체 캐러셀 이미지 비율은 동일하게 맞춰야 합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/carouselCommerce} (operationId {@code uploadBrandMessageCarouselCommerceImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageCarouselCommerce(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_CAROUSEL_COMMERCE_IMAGE, Operations.UPLOAD_BRAND_MESSAGE_CAROUSEL_COMMERCE_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", BrandMessageFileUploadResult.class);
    }

    /**
     * 브랜드메시지 캐러셀 커머스 이미지 업로드.
     *
     * 캐러셀 커머스형 브랜드메시지에서 사용하는 이미지를 업로드합니다. 전체 캐러셀 이미지 비율은 동일하게 맞춰야 합니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/carouselCommerce} (operationId {@code uploadBrandMessageCarouselCommerceImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageCarouselCommerce(Path file) {
        return uploadBrandMessageCarouselCommerce(FileUpload.of(file));
    }

    /**
     * 알림톡 템플릿 이미지 업로드.
     *
     * 알림톡 이미지형, 와이드 이미지형, 아이템리스트형 템플릿 등록에 사용할 이미지를 업로드합니다. 메시지 발송용 업로드가 아니라 템플릿 등록을 위한 사전 이미지 등록 API입니다. 응답의 <code>imgUrl</code>을 템플릿 등록의 <code>imgUrl</code>에 넣습니다.
     *
     * <p>{@code POST /api/comm/v1/file/alimtalk/template} (operationId {@code uploadAlimtalkTemplateImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public AlimtalkTemplateImageUploadResult uploadAlimtalkTemplateImage(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_ALIMTALK_TEMPLATE_IMAGE, Operations.UPLOAD_ALIMTALK_TEMPLATE_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", AlimtalkTemplateImageUploadResult.class);
    }

    /**
     * 알림톡 템플릿 이미지 업로드.
     *
     * 알림톡 이미지형, 와이드 이미지형, 아이템리스트형 템플릿 등록에 사용할 이미지를 업로드합니다. 메시지 발송용 업로드가 아니라 템플릿 등록을 위한 사전 이미지 등록 API입니다. 응답의 <code>imgUrl</code>을 템플릿 등록의 <code>imgUrl</code>에 넣습니다.
     *
     * <p>{@code POST /api/comm/v1/file/alimtalk/template} (operationId {@code uploadAlimtalkTemplateImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public AlimtalkTemplateImageUploadResult uploadAlimtalkTemplateImage(Path file) {
        return uploadAlimtalkTemplateImage(FileUpload.of(file));
    }

    /**
     * 알림톡 템플릿 하이라이트 이미지 업로드.
     *
     * 아이템리스트형 알림톡 템플릿의 아이템 하이라이트 영역에 사용할 이미지를 업로드합니다. 템플릿 이미지 업로드와 같은 템플릿 등록용 사전 이미지 등록 API입니다.
     *
     * <p>{@code POST /api/comm/v1/file/alimtalk/itemHighlight} (operationId {@code uploadAlimtalkItemHighlightImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public AlimtalkTemplateImageUploadResult uploadAlimtalkItemHighlightImage(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_ALIMTALK_ITEM_HIGHLIGHT_IMAGE, Operations.UPLOAD_ALIMTALK_ITEM_HIGHLIGHT_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", AlimtalkTemplateImageUploadResult.class);
    }

    /**
     * 알림톡 템플릿 하이라이트 이미지 업로드.
     *
     * 아이템리스트형 알림톡 템플릿의 아이템 하이라이트 영역에 사용할 이미지를 업로드합니다. 템플릿 이미지 업로드와 같은 템플릿 등록용 사전 이미지 등록 API입니다.
     *
     * <p>{@code POST /api/comm/v1/file/alimtalk/itemHighlight} (operationId {@code uploadAlimtalkItemHighlightImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public AlimtalkTemplateImageUploadResult uploadAlimtalkItemHighlightImage(Path file) {
        return uploadAlimtalkItemHighlightImage(FileUpload.of(file));
    }

    /**
     * 브랜드메시지 카탈로그 이미지 업로드.
     *
     * 카탈로그형(FG) 브랜드메시지에서 쓰는 1:1 비율 이미지를 업로드하고 템플릿에 쓸 <code>imgUrl</code>을 발급받습니다. 홀수형(아이템 3·5·7개)의 첫 번째 아이템은 카탈로그 홀수형 첫번째 이미지 업로드를 씁니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/catalog} (operationId {@code uploadBrandMessageCatalogImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageCatalog(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_CATALOG_IMAGE, Operations.UPLOAD_BRAND_MESSAGE_CATALOG_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", BrandMessageFileUploadResult.class);
    }

    /**
     * 브랜드메시지 카탈로그 이미지 업로드.
     *
     * 카탈로그형(FG) 브랜드메시지에서 쓰는 1:1 비율 이미지를 업로드하고 템플릿에 쓸 <code>imgUrl</code>을 발급받습니다. 홀수형(아이템 3·5·7개)의 첫 번째 아이템은 카탈로그 홀수형 첫번째 이미지 업로드를 씁니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/catalog} (operationId {@code uploadBrandMessageCatalogImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageCatalog(Path file) {
        return uploadBrandMessageCatalog(FileUpload.of(file));
    }

    /**
     * 브랜드메시지 카탈로그 홀수형 첫번째 이미지 업로드.
     *
     * 카탈로그형(FG) 홀수형의 첫 번째 아이템에 쓰는 2:1 비율 이미지를 업로드합니다. 나머지 아이템과 짝수형(4·6개)은 카탈로그 이미지 업로드를 씁니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/catalog/oddFirst} (operationId {@code uploadBrandMessageCatalogOddFirstImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload (read once, reused on retries)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageCatalogOddFirst(FileUpload file) {
        Params.required("file", file);
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_CATALOG_ODD_FIRST_IMAGE, Operations.UPLOAD_BRAND_MESSAGE_CATALOG_ODD_FIRST_IMAGE.path(), null, null, Multipart.build(file),
                "data.data", BrandMessageFileUploadResult.class);
    }

    /**
     * 브랜드메시지 카탈로그 홀수형 첫번째 이미지 업로드.
     *
     * 카탈로그형(FG) 홀수형의 첫 번째 아이템에 쓰는 2:1 비율 이미지를 업로드합니다. 나머지 아이템과 짝수형(4·6개)은 카탈로그 이미지 업로드를 씁니다.
     *
     * <p>{@code POST /api/comm/v1/file/brandmessage/catalog/oddFirst} (operationId {@code uploadBrandMessageCatalogOddFirstImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param file file to upload
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFileUploadResult uploadBrandMessageCatalogOddFirst(Path file) {
        return uploadBrandMessageCatalogOddFirst(FileUpload.of(file));
    }
}
