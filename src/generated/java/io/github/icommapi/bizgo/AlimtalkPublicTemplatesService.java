// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.AlimtalkTemplatePublic;
import io.github.icommapi.bizgo.params.ListAlimtalkPublicTemplatesParams;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 알림톡 템플릿 관리: {@code client.alimtalk().publicTemplates()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: alimtalk.publicTemplates}).
 */
public final class AlimtalkPublicTemplatesService {

    private final Transport transport;

    AlimtalkPublicTemplatesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 알림톡 공용템플릿 조회.
     *
     * 카카오가 제공하는 공용템플릿 목록을 조회합니다.
     * <p><b>신규 발송에 권장하지 않습니다.</b> 공용템플릿은 비즈고 콘솔 템플릿 선택 화면에서 제외되었고 조회 API만 남아 있으며, 이후 제공이 중단될 예정입니다. 발송 시 변수 치환 결과가 템플릿에 정의된 글자 수를 넘으면 잘라내거나 대체발송하지 않고 실패로 처리합니다. 신규 연동은 템플릿 등록으로 직접 만든 템플릿을 사용합니다.
     *
     * <p>{@code GET /api/comm/v1/center/alimtalk/public/template} (operationId {@code listAlimtalkPublicTemplates}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the items at {@code data.data.templates}, empty if none
     */
    public List<AlimtalkTemplatePublic> list(ListAlimtalkPublicTemplatesParams params) {
        Params.required("params", params);
        return transport.list(Operations.LIST_ALIMTALK_PUBLIC_TEMPLATES, Operations.LIST_ALIMTALK_PUBLIC_TEMPLATES.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.templates", AlimtalkTemplatePublic.class);
    }

    /**
     * 알림톡 공용템플릿 조회.
     *
     * <p>Same as the overload with parameters, with none set.
     *
     * <p>{@code GET /api/comm/v1/center/alimtalk/public/template} (operationId {@code listAlimtalkPublicTemplates}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @return the items at {@code data.data.templates}, empty if none
     */
    public List<AlimtalkTemplatePublic> list() {
        return list(ListAlimtalkPublicTemplatesParams.builder().build());
    }

    /**
     * Every item of {@link #list}, following the page pagination across pages lazily.
     *
     * <p>Stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<AlimtalkTemplatePublic> iterList(ListAlimtalkPublicTemplatesParams params) {
        Params.required("params", params);
        String path = Operations.LIST_ALIMTALK_PUBLIC_TEMPLATES.path();
        return Paging.numbered(params.getPage() == null ? 1 : params.getPage(), params.getCount(), false,
                n -> transport.raw(Operations.LIST_ALIMTALK_PUBLIC_TEMPLATES, path,
                        params.toBuilder().page(n).build().toQuery(), params.toHeaders(), null, "data.data.templates", AlimtalkTemplatePublic.class),
                "data.data.templates", null, null, AlimtalkTemplatePublic.class);
    }

    /**
     * Every item of {@link #list}, following the page pagination across pages lazily.
     *
     * <p>Stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<AlimtalkTemplatePublic> iterList() {
        return iterList(ListAlimtalkPublicTemplatesParams.builder().build());
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<AlimtalkTemplatePublic> streamList(ListAlimtalkPublicTemplatesParams params) {
        return StreamSupport.stream(iterList(params).spliterator(), false);
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @return lazy sequential stream
     */
    public Stream<AlimtalkTemplatePublic> streamList() {
        return StreamSupport.stream(iterList().spliterator(), false);
    }

    @Override
    public String toString() {
        return "AlimtalkPublicTemplatesService";
    }
}
