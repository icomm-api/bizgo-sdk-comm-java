// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.RcsTemplateIdResult;
import io.github.icommapi.bizgo.models.RcsTemplateListResult;
import io.github.icommapi.bizgo.models.RcsTemplateRequest;
import io.github.icommapi.bizgo.models.RcsTemplateResult;
import io.github.icommapi.bizgo.params.GetRcsTemplateParams;

/**
 * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().templates()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: rcs.templates}).
 */
public final class RcsTemplatesService {

    private final Transport transport;

    RcsTemplatesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * RCS 템플릿 목록 조회.
     *
     * 브랜드 ID를 기준으로 등록된 RCS 템플릿 목록을 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/messagebase/list} (operationId {@code listRcsTemplates}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsTemplateListResult list() {
        return transport.object(Operations.LIST_RCS_TEMPLATES, Operations.LIST_RCS_TEMPLATES.path(), null, null, null,
                "data.data", RcsTemplateListResult.class);
    }

    /**
     * RCS 템플릿 상세 조회.
     *
     * 메시지베이스 ID를 기준으로 등록된 RCS 템플릿 상세 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/messagebase} (operationId {@code getRcsTemplate}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsTemplateResult get(GetRcsTemplateParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_TEMPLATE, Operations.GET_RCS_TEMPLATE.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", RcsTemplateResult.class);
    }

    /**
     * RCS 템플릿 등록.
     *
     * 브랜드에 RCS 템플릿을 등록합니다. 응답의 <code>messagebaseId</code>를 발송 시 <code>formatId</code> 필드에 넣습니다(영문 문서 기준).
     *
     * <p>{@code POST /api/comm/v1/center/rcs/messagebase} (operationId {@code createRcsTemplate}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsTemplateIdResult create(RcsTemplateRequest request) {
        Params.required("request", request);
        return transport.object(Operations.CREATE_RCS_TEMPLATE, Operations.CREATE_RCS_TEMPLATE.path(), null, null, Transport.Body.json(request),
                "data.data", RcsTemplateIdResult.class);
    }

    /**
     * RCS 템플릿 수정.
     *
     * 등록된 RCS 템플릿 정보를 수정합니다.
     *
     * <p>{@code PUT /api/comm/v1/center/rcs/messagebase} (operationId {@code updateRcsTemplate}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsTemplateIdResult update(RcsTemplateRequest request) {
        Params.required("request", request);
        return transport.object(Operations.UPDATE_RCS_TEMPLATE, Operations.UPDATE_RCS_TEMPLATE.path(), null, null, Transport.Body.json(request),
                "data.data", RcsTemplateIdResult.class);
    }

    /**
     * RCS 템플릿 승인 취소.
     *
     * 승인 진행 중인 RCS 템플릿의 승인 요청을 취소합니다.
     *
     * <p>{@code PUT /api/comm/v1/center/rcs/brandId/&#123;brandId&#125;/messagebaseId/&#123;messagebaseId&#125;/cancel} (operationId {@code cancelRcsTemplateApproval}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param brandId 브랜드 ID입니다. (required)
     * @param messagebaseId 메시지베이스 ID입니다. 발송 시에는 <code>formatId</code> 필드 이름으로 쓰이므로 혼동하지 않도록 주의합니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsTemplateIdResult cancel(String brandId, String messagebaseId) {
        return transport.object(Operations.CANCEL_RCS_TEMPLATE_APPROVAL, Operations.CANCEL_RCS_TEMPLATE_APPROVAL.path(brandId, messagebaseId), null, null, null,
                "data.data", RcsTemplateIdResult.class);
    }

    /**
     * RCS 템플릿 삭제.
     *
     * 등록된 RCS 템플릿을 삭제합니다.
     *
     * <p>{@code DELETE /api/comm/v1/center/rcs/brandId/&#123;brandId&#125;/messagebaseId/&#123;messagebaseId&#125;} (operationId {@code deleteRcsTemplate}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param brandId 브랜드 ID입니다. (required)
     * @param messagebaseId 메시지베이스 ID입니다. 발송 시에는 <code>formatId</code> 필드 이름으로 쓰이므로 혼동하지 않도록 주의합니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsTemplateIdResult delete(String brandId, String messagebaseId) {
        return transport.object(Operations.DELETE_RCS_TEMPLATE, Operations.DELETE_RCS_TEMPLATE.path(brandId, messagebaseId), null, null, null,
                "data.data", RcsTemplateIdResult.class);
    }

    @Override
    public String toString() {
        return "RcsTemplatesService";
    }
}
