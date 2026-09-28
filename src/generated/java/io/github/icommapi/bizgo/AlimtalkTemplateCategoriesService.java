// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.AlimtalkTemplateCategoryResult;
import io.github.icommapi.bizgo.params.ListAlimtalkTemplateCategoriesParams;

/**
 * 알림톡 템플릿 관리: {@code client.alimtalk().templateCategories()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: alimtalk.templateCategories}).
 */
public final class AlimtalkTemplateCategoriesService {

    private final Transport transport;

    AlimtalkTemplateCategoriesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 알림톡 템플릿 카테고리 조회.
     *
     * 알림톡 템플릿 카테고리를 조회합니다. 문서는 같은 경로에 두 기능을 둡니다.
     * <ul>
     * <li><code>categoryCode</code> 없이 호출: 템플릿 카테고리 전체 목록(<code>data.data.categories</code>)</li>
     * <li><code>categoryCode</code>를 넣어 호출: 해당 카테고리 상세(<code>data.data.category</code>)</li>
     * </ul>
     *
     * <p>{@code GET /api/comm/v1/center/alimtalk/category} (operationId {@code listAlimtalkTemplateCategories}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public AlimtalkTemplateCategoryResult list(ListAlimtalkTemplateCategoriesParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_ALIMTALK_TEMPLATE_CATEGORIES, Operations.LIST_ALIMTALK_TEMPLATE_CATEGORIES.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", AlimtalkTemplateCategoryResult.class);
    }

    /**
     * 알림톡 템플릿 카테고리 조회.
     *
     * <p>Same as the overload with parameters, with none set.
     *
     * <p>{@code GET /api/comm/v1/center/alimtalk/category} (operationId {@code listAlimtalkTemplateCategories}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public AlimtalkTemplateCategoryResult list() {
        return list(ListAlimtalkTemplateCategoriesParams.builder().build());
    }

    @Override
    public String toString() {
        return "AlimtalkTemplateCategoriesService";
    }
}
