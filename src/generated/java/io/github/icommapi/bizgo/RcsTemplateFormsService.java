// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.RcsMessagebaseFormDetailResult;
import io.github.icommapi.bizgo.models.RcsMessagebaseFormListResult;
import io.github.icommapi.bizgo.models.RcsMessagebaseFormSummary;
import io.github.icommapi.bizgo.params.GetRcsTemplateFormParams;
import io.github.icommapi.bizgo.params.ListRcsTemplateFormsParams;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().templateForms()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: rcs.templateForms}).
 */
public final class RcsTemplateFormsService {

    private final Transport transport;

    RcsTemplateFormsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * RCS 템플릿 양식 목록 조회.
     *
     * RCS 템플릿 등록에 사용할 수 있는 템플릿 양식 목록을 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/messagebase/messagebaseform/list} (operationId {@code listRcsTemplateForms}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsMessagebaseFormListResult list(ListRcsTemplateFormsParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_RCS_TEMPLATE_FORMS, Operations.LIST_RCS_TEMPLATE_FORMS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", RcsMessagebaseFormListResult.class);
    }

    /**
     * RCS 템플릿 양식 목록 조회.
     *
     * <p>Same as the overload with parameters, with none set.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/messagebase/messagebaseform/list} (operationId {@code listRcsTemplateForms}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsMessagebaseFormListResult list() {
        return list(ListRcsTemplateFormsParams.builder().build());
    }

    /**
     * Every item of {@link #list}, following the offset pagination across pages lazily.
     *
     * <p>Advances the offset by the number of items received; stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<RcsMessagebaseFormSummary> iterList(ListRcsTemplateFormsParams params) {
        Params.required("params", params);
        String path = Operations.LIST_RCS_TEMPLATE_FORMS.path();
        return Paging.numbered(params.getOffset() == null ? 0 : params.getOffset(), params.getLimit(), true,
                n -> transport.raw(Operations.LIST_RCS_TEMPLATE_FORMS, path,
                        params.toBuilder().offset(n).build().toQuery(), params.toHeaders(), null, "data.data.rcs.messageForms", RcsMessagebaseFormSummary.class),
                "data.data.rcs.messageForms", "data.data.rcs.pagination.total", null, RcsMessagebaseFormSummary.class);
    }

    /**
     * Every item of {@link #list}, following the offset pagination across pages lazily.
     *
     * <p>Advances the offset by the number of items received; stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<RcsMessagebaseFormSummary> iterList() {
        return iterList(ListRcsTemplateFormsParams.builder().build());
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<RcsMessagebaseFormSummary> streamList(ListRcsTemplateFormsParams params) {
        return StreamSupport.stream(iterList(params).spliterator(), false);
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @return lazy sequential stream
     */
    public Stream<RcsMessagebaseFormSummary> streamList() {
        return StreamSupport.stream(iterList().spliterator(), false);
    }

    /**
     * RCS 템플릿 양식 상세 조회.
     *
     * 템플릿 양식 ID를 기준으로 템플릿 양식 상세 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/messagebase/messagebaseform} (operationId {@code getRcsTemplateForm}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsMessagebaseFormDetailResult get(GetRcsTemplateFormParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_TEMPLATE_FORM, Operations.GET_RCS_TEMPLATE_FORM.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", RcsMessagebaseFormDetailResult.class);
    }

    @Override
    public String toString() {
        return "RcsTemplateFormsService";
    }
}
