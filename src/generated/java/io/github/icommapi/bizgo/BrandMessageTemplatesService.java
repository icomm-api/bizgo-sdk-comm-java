// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessageTemplateListResult;
import io.github.icommapi.bizgo.models.BrandMessageTemplateRequest;
import io.github.icommapi.bizgo.models.BrandMessageTemplateResult;
import io.github.icommapi.bizgo.models.BrandMessageTemplateSummary;
import io.github.icommapi.bizgo.params.GetBrandMessageTemplateParams;
import io.github.icommapi.bizgo.params.ListBrandMessageTemplatesLastModifiedParams;
import io.github.icommapi.bizgo.params.ListBrandMessageTemplatesParams;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().templates()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage.templates}).
 */
public final class BrandMessageTemplatesService {

    private final Transport transport;

    BrandMessageTemplatesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 브랜드메시지 템플릿 조회.
     *
     * 발신프로필 키와 템플릿 코드로 브랜드메시지 템플릿 상세 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/template} (operationId {@code getBrandMessageTemplate}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageTemplateResult get(GetBrandMessageTemplateParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_TEMPLATE, Operations.GET_BRAND_MESSAGE_TEMPLATE.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageTemplateResult.class);
    }

    /**
     * 브랜드메시지 템플릿 등록.
     *
     * 브랜드메시지 템플릿을 등록합니다. 이미지가 필요한 유형은 이미지 업로드 API로 발급받은 <code>imgUrl</code>을 함께 씁니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/template} (operationId {@code createBrandMessageTemplate}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageTemplateResult create(BrandMessageTemplateRequest request) {
        Params.required("request", request);
        return transport.object(Operations.CREATE_BRAND_MESSAGE_TEMPLATE, Operations.CREATE_BRAND_MESSAGE_TEMPLATE.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageTemplateResult.class);
    }

    /**
     * 브랜드메시지 템플릿 수정.
     *
     * 등록된 브랜드메시지 템플릿을 수정합니다. 검수 상태와 카카오 정책에 따라 수정 가능한 범위가 달라질 수 있습니다.
     *
     * <p>{@code PUT /api/comm/v1/center/brandmessage/template} (operationId {@code updateBrandMessageTemplate}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageTemplateResult update(BrandMessageTemplateRequest request) {
        Params.required("request", request);
        return transport.object(Operations.UPDATE_BRAND_MESSAGE_TEMPLATE, Operations.UPDATE_BRAND_MESSAGE_TEMPLATE.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageTemplateResult.class);
    }

    /**
     * 브랜드메시지 템플릿 목록 조회.
     *
     * 발신프로필(또는 그룹키)에 등록된 브랜드메시지 템플릿 목록을 페이징 조회합니다. 카카오를 호출하지 않고 비즈고에 적재된 템플릿을 읽으므로 목록 화면이나 주기적인 동기화에 쓸 수 있습니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/template/list} (operationId {@code listBrandMessageTemplates}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageTemplateListResult list(ListBrandMessageTemplatesParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_BRAND_MESSAGE_TEMPLATES, Operations.LIST_BRAND_MESSAGE_TEMPLATES.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageTemplateListResult.class);
    }

    /**
     * Every item of {@link #list}, following the offset pagination across pages lazily.
     *
     * <p>Advances the offset by the number of items received; stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<BrandMessageTemplateSummary> iterList(ListBrandMessageTemplatesParams params) {
        Params.required("params", params);
        String path = Operations.LIST_BRAND_MESSAGE_TEMPLATES.path();
        return Paging.numbered(params.getOffset() == null ? 0 : params.getOffset(), params.getLimit(), true,
                n -> transport.raw(Operations.LIST_BRAND_MESSAGE_TEMPLATES, path,
                        params.toBuilder().offset(n).build().toQuery(), params.toHeaders(), null, "data.data.brandmessage.templates", BrandMessageTemplateSummary.class),
                "data.data.brandmessage.templates", null, null, BrandMessageTemplateSummary.class);
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<BrandMessageTemplateSummary> streamList(ListBrandMessageTemplatesParams params) {
        return StreamSupport.stream(iterList(params).spliterator(), false);
    }

    /**
     * 최근 변경 브랜드메시지 템플릿 조회.
     *
     * 지정한 시각 이후 변경된 브랜드메시지 템플릿 목록을 조회합니다. 템플릿 최신화나 내부 동기화 배치에 씁니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/template/lastModified} (operationId {@code listBrandMessageTemplatesLastModified}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageTemplateListResult listLastModified(ListBrandMessageTemplatesLastModifiedParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_BRAND_MESSAGE_TEMPLATES_LAST_MODIFIED, Operations.LIST_BRAND_MESSAGE_TEMPLATES_LAST_MODIFIED.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageTemplateListResult.class);
    }

    /**
     * Every item of {@link #listLastModified}, following the page pagination across pages lazily.
     *
     * <p>Stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<BrandMessageTemplateSummary> iterListLastModified(ListBrandMessageTemplatesLastModifiedParams params) {
        Params.required("params", params);
        String path = Operations.LIST_BRAND_MESSAGE_TEMPLATES_LAST_MODIFIED.path();
        return Paging.numbered(params.getPage() == null ? 1 : params.getPage(), params.getCount(), false,
                n -> transport.raw(Operations.LIST_BRAND_MESSAGE_TEMPLATES_LAST_MODIFIED, path,
                        params.toBuilder().page(n).build().toQuery(), params.toHeaders(), null, "data.data.brandmessage.templates", BrandMessageTemplateSummary.class),
                "data.data.brandmessage.templates", null, null, BrandMessageTemplateSummary.class);
    }

    /**
     * {@link #iterListLastModified} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<BrandMessageTemplateSummary> streamListLastModified(ListBrandMessageTemplatesLastModifiedParams params) {
        return StreamSupport.stream(iterListLastModified(params).spliterator(), false);
    }

    /**
     * 브랜드메시지 템플릿 삭제.
     *
     * 발신프로필 키와 템플릿 코드로 브랜드메시지 템플릿을 삭제합니다.
     *
     * <p>{@code DELETE /api/comm/v1/center/brandmessage/template/senderKey/&#123;senderKey&#125;/templateCode/&#123;templateCode&#125;} (operationId {@code deleteBrandMessageTemplate}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param senderKey 발신프로필 키입니다. (required)
     * @param templateCode 삭제할 템플릿 코드입니다. (required)
     */
    public void delete(String senderKey, String templateCode) {
        transport.empty(Operations.DELETE_BRAND_MESSAGE_TEMPLATE, Operations.DELETE_BRAND_MESSAGE_TEMPLATE.path(senderKey, templateCode), null, null, null);
    }

    @Override
    public String toString() {
        return "BrandMessageTemplatesService";
    }
}
