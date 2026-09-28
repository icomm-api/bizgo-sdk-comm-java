// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.AlimtalkTemplate;
import io.github.icommapi.bizgo.models.AlimtalkTemplateInspectionCancelRequest;
import io.github.icommapi.bizgo.models.AlimtalkTemplateInspectionFileRequest;
import io.github.icommapi.bizgo.models.AlimtalkTemplateInspectionRequest;
import io.github.icommapi.bizgo.models.AlimtalkTemplateSaveRequest;
import io.github.icommapi.bizgo.params.GetAlimtalkTemplateParams;
import io.github.icommapi.bizgo.params.ListAlimtalkTemplatesParams;
import io.github.icommapi.bizgo.params.ListModifiedAlimtalkTemplatesParams;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 알림톡 템플릿 관리: {@code client.alimtalk().templates()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: alimtalk.templates}).
 */
public final class AlimtalkTemplatesService {

    private final Transport transport;

    AlimtalkTemplatesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 알림톡 템플릿 조회.
     *
     * 발신프로필 키와 템플릿 코드를 기준으로 알림톡 템플릿 상세 정보(검수 상태, 심사 의견 포함)를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/alimtalk/template} (operationId {@code getAlimtalkTemplate}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data.alimtalk} (an empty object if the server omits it)
     */
    public AlimtalkTemplate get(GetAlimtalkTemplateParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_ALIMTALK_TEMPLATE, Operations.GET_ALIMTALK_TEMPLATE.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.alimtalk", AlimtalkTemplate.class);
    }

    /**
     * 알림톡 템플릿 등록.
     *
     * 알림톡 템플릿을 등록합니다. 등록한 템플릿은 검수 요청(<code>POST /api/comm/v1/center/alimtalk/template/request</code>) 후 카카오 승인을 받아야 발송할 수 있습니다. 이미지형·아이템리스트형 템플릿은 템플릿 이미지 업로드 API로 받은 <code>imgUrl</code>을 함께 넣습니다.
     *
     * <p>{@code POST /api/comm/v1/center/alimtalk/template} (operationId {@code createAlimtalkTemplate}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data.alimtalk} (an empty object if the server omits it)
     */
    public AlimtalkTemplate create(AlimtalkTemplateSaveRequest request) {
        Params.required("request", request);
        return transport.object(Operations.CREATE_ALIMTALK_TEMPLATE, Operations.CREATE_ALIMTALK_TEMPLATE.path(), null, null, Transport.Body.json(request),
                "data.data.alimtalk", AlimtalkTemplate.class);
    }

    /**
     * 알림톡 템플릿 수정.
     *
     * 등록된 알림톡 템플릿 정보를 수정합니다. 검수 상태와 카카오 정책에 따라 수정 가능한 범위가 달라질 수 있습니다. 대상 템플릿은 본문의 <code>senderKey</code>와 <code>templateCode</code>로 지정합니다.
     *
     * <p>{@code PUT /api/comm/v1/center/alimtalk/template} (operationId {@code updateAlimtalkTemplate}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data.alimtalk} (an empty object if the server omits it)
     */
    public AlimtalkTemplate update(AlimtalkTemplateSaveRequest request) {
        Params.required("request", request);
        return transport.object(Operations.UPDATE_ALIMTALK_TEMPLATE, Operations.UPDATE_ALIMTALK_TEMPLATE.path(), null, null, Transport.Body.json(request),
                "data.data.alimtalk", AlimtalkTemplate.class);
    }

    /**
     * 알림톡 템플릿 목록 조회.
     *
     * 발신프로필에 등록된 알림톡 템플릿 목록을 페이징 조회합니다. 카카오를 호출하지 않고 비즈고에 적재된 템플릿을 읽으므로 목록 화면이나 주기적인 동기화에 사용할 수 있습니다.
     *
     * <p>{@code GET /api/comm/v1/center/alimtalk/template/list} (operationId {@code listAlimtalkTemplates}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the items at {@code data.data.alimtalk.templates}, empty if none
     */
    public List<AlimtalkTemplate> list(ListAlimtalkTemplatesParams params) {
        Params.required("params", params);
        return transport.list(Operations.LIST_ALIMTALK_TEMPLATES, Operations.LIST_ALIMTALK_TEMPLATES.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.alimtalk.templates", AlimtalkTemplate.class);
    }

    /**
     * Every item of {@link #list}, following the offset pagination across pages lazily.
     *
     * <p>Advances the offset by the number of items received; stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<AlimtalkTemplate> iterList(ListAlimtalkTemplatesParams params) {
        Params.required("params", params);
        String path = Operations.LIST_ALIMTALK_TEMPLATES.path();
        return Paging.numbered(params.getOffset() == null ? 0 : params.getOffset(), params.getLimit(), true,
                n -> transport.raw(Operations.LIST_ALIMTALK_TEMPLATES, path,
                        params.toBuilder().offset(n).build().toQuery(), params.toHeaders(), null, "data.data.alimtalk.templates", AlimtalkTemplate.class),
                "data.data.alimtalk.templates", null, null, AlimtalkTemplate.class);
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<AlimtalkTemplate> streamList(ListAlimtalkTemplatesParams params) {
        return StreamSupport.stream(iterList(params).spliterator(), false);
    }

    /**
     * 최근 변경 알림톡 템플릿 조회.
     *
     * 지정한 시각 이후 변경된 알림톡 템플릿 목록을 조회합니다. 템플릿 최신화나 내부 동기화 배치 기준으로 사용할 수 있습니다.
     *
     * <p>{@code GET /api/comm/v1/center/alimtalk/template/lastModified} (operationId {@code listModifiedAlimtalkTemplates}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the items at {@code data.data.alimtalk.templates}, empty if none
     */
    public List<AlimtalkTemplate> listModified(ListModifiedAlimtalkTemplatesParams params) {
        Params.required("params", params);
        return transport.list(Operations.LIST_MODIFIED_ALIMTALK_TEMPLATES, Operations.LIST_MODIFIED_ALIMTALK_TEMPLATES.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.alimtalk.templates", AlimtalkTemplate.class);
    }

    /**
     * Every item of {@link #listModified}, following the page pagination across pages lazily.
     *
     * <p>Stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<AlimtalkTemplate> iterListModified(ListModifiedAlimtalkTemplatesParams params) {
        Params.required("params", params);
        String path = Operations.LIST_MODIFIED_ALIMTALK_TEMPLATES.path();
        return Paging.numbered(params.getPage() == null ? 1 : params.getPage(), params.getCount(), false,
                n -> transport.raw(Operations.LIST_MODIFIED_ALIMTALK_TEMPLATES, path,
                        params.toBuilder().page(n).build().toQuery(), params.toHeaders(), null, "data.data.alimtalk.templates", AlimtalkTemplate.class),
                "data.data.alimtalk.templates", null, null, AlimtalkTemplate.class);
    }

    /**
     * {@link #iterListModified} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<AlimtalkTemplate> streamListModified(ListModifiedAlimtalkTemplatesParams params) {
        return StreamSupport.stream(iterListModified(params).spliterator(), false);
    }

    /**
     * 알림톡 템플릿 삭제.
     *
     * 발신프로필 키와 템플릿 코드를 기준으로 알림톡 템플릿을 삭제합니다.
     *
     * <p>{@code DELETE /api/comm/v1/center/alimtalk/template/senderKey/&#123;senderKey&#125;/templateCode/&#123;templateCode&#125;} (operationId {@code deleteAlimtalkTemplate}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param senderKey 발신프로필 키입니다. (required)
     * @param templateCode 삭제할 템플릿 코드입니다. (required)
     */
    public void delete(String senderKey, String templateCode) {
        transport.empty(Operations.DELETE_ALIMTALK_TEMPLATE, Operations.DELETE_ALIMTALK_TEMPLATE.path(senderKey, templateCode), null, null, null);
    }

    /**
     * 알림톡 템플릿 검수 요청.
     *
     * 등록된 알림톡 템플릿을 카카오 검수로 요청합니다. 템플릿 상태가 대기이고 검수 상태가 등록(<code>REG</code>)인 경우 요청할 수 있습니다.
     * <ul>
     * <li><code>application/json</code>: 첨부 없이 요청합니다. 템플릿 정보는 <code>alimtalk</code> 객체에 넣습니다.</li>
     * <li><code>multipart/form-data</code>: 파일을 첨부해 요청합니다. 필드를 최상위에 두며 <code>comment</code>가 필수입니다. 파일 형식은 png, jpg, jpeg, gif, pdf, hwp, doc, docx입니다.</li>
     * </ul>
     *
     * <p>{@code POST /api/comm/v1/center/alimtalk/template/request} (operationId {@code requestAlimtalkTemplateInspection}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void requestInspection(AlimtalkTemplateInspectionRequest request) {
        Params.required("request", request);
        transport.empty(Operations.REQUEST_ALIMTALK_TEMPLATE_INSPECTION, Operations.REQUEST_ALIMTALK_TEMPLATE_INSPECTION.path(), null, null, Transport.Body.json(request));
    }

    /**
     * 알림톡 템플릿 검수 요청.
     *
     * 등록된 알림톡 템플릿을 카카오 검수로 요청합니다. 템플릿 상태가 대기이고 검수 상태가 등록(<code>REG</code>)인 경우 요청할 수 있습니다.
     * <ul>
     * <li><code>application/json</code>: 첨부 없이 요청합니다. 템플릿 정보는 <code>alimtalk</code> 객체에 넣습니다.</li>
     * <li><code>multipart/form-data</code>: 파일을 첨부해 요청합니다. 필드를 최상위에 두며 <code>comment</code>가 필수입니다. 파일 형식은 png, jpg, jpeg, gif, pdf, hwp, doc, docx입니다.</li>
     * </ul>
     *
     * <p>{@code POST /api/comm/v1/center/alimtalk/template/request} (operationId {@code requestAlimtalkTemplateInspection}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void requestInspection(AlimtalkTemplateInspectionFileRequest request) {
        Params.required("request", request);
        Multipart.Form form = Multipart.form();
        form.text("senderKey", request.getSenderKey());
        form.text("senderKeyType", request.getSenderKeyType());
        form.text("templateCode", request.getTemplateCode());
        form.text("comment", request.getComment());
        form.files("attachment", request.getAttachment());
        transport.empty(Operations.REQUEST_ALIMTALK_TEMPLATE_INSPECTION, Operations.REQUEST_ALIMTALK_TEMPLATE_INSPECTION.path(), null, null, form.build());
    }

    /**
     * 알림톡 템플릿 검수 요청 취소.
     *
     * 검수 요청된 알림톡 템플릿의 검수 요청을 취소합니다.
     *
     * <p>{@code POST /api/comm/v1/center/alimtalk/template/request/cancel} (operationId {@code cancelAlimtalkTemplateInspection}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void cancelInspection(AlimtalkTemplateInspectionCancelRequest request) {
        Params.required("request", request);
        transport.empty(Operations.CANCEL_ALIMTALK_TEMPLATE_INSPECTION, Operations.CANCEL_ALIMTALK_TEMPLATE_INSPECTION.path(), null, null, Transport.Body.json(request));
    }

    @Override
    public String toString() {
        return "AlimtalkTemplatesService";
    }
}
