// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.KakaoCategory;
import io.github.icommapi.bizgo.params.GetKakaoSenderCategoryParams;
import java.util.List;

/**
 * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao().categories()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: kakao.categories}).
 */
public final class KakaoCategoriesService {

    private final Transport transport;

    KakaoCategoriesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 발신프로필 카테고리 전체조회.
     *
     * 발신프로필 등록 시 사용할 수 있는 카카오 비즈메시지 카테고리 목록을 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/kakao/sender/category/list} (operationId {@code listKakaoSenderCategories}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @return the items at {@code data.data.kakao.categories}, empty if none
     */
    public List<KakaoCategory> list() {
        return transport.list(Operations.LIST_KAKAO_SENDER_CATEGORIES, Operations.LIST_KAKAO_SENDER_CATEGORIES.path(), null, null, null,
                "data.data.kakao.categories", KakaoCategory.class);
    }

    /**
     * 발신프로필 카테고리 상세조회.
     *
     * 카테고리 코드를 기준으로 카카오 비즈메시지 카테고리 상세 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/kakao/sender/category} (operationId {@code getKakaoSenderCategory}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data.kakao.category} (an empty object if the server omits it)
     */
    public KakaoCategory get(GetKakaoSenderCategoryParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_KAKAO_SENDER_CATEGORY, Operations.GET_KAKAO_SENDER_CATEGORY.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.kakao.category", KakaoCategory.class);
    }

    @Override
    public String toString() {
        return "KakaoCategoriesService";
    }
}
