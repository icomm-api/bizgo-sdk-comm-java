// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.KakaoSanction;
import io.github.icommapi.bizgo.params.GetKakaoGroupTemplateSenderExclusionParams;
import io.github.icommapi.bizgo.params.GetKakaoSenderSanctionParams;
import io.github.icommapi.bizgo.params.GetKakaoTemplateSanctionParams;

/**
 * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao().sanctions()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: kakao.sanctions}).
 */
public final class KakaoSanctionsService {

    private final Transport transport;

    KakaoSanctionsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 발신프로필 제재 조회.
     *
     * 특정 일자에 발신프로필에 적용된 제재 정보를 조회합니다. 발송 전 운영 상태를 확인할 때 사용합니다.
     *
     * <p>{@code GET /api/comm/v1/center/kakao/abusing/block/sender} (operationId {@code getKakaoSenderSanction}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data.kakao.abusing} (an empty object if the server omits it)
     */
    public KakaoSanction getSender(GetKakaoSenderSanctionParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_KAKAO_SENDER_SANCTION, Operations.GET_KAKAO_SENDER_SANCTION.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.kakao.abusing", KakaoSanction.class);
    }

    /**
     * 그룹템플릿 발신프로필 제외 조회.
     *
     * 그룹템플릿에서 특정 발신프로필이 제외(제한)된 제재 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/kakao/abusing/block/senderGroup} (operationId {@code getKakaoGroupTemplateSenderExclusion}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data.kakao.abusing} (an empty object if the server omits it)
     */
    public KakaoSanction getGroupTemplateExclusion(GetKakaoGroupTemplateSenderExclusionParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_KAKAO_GROUP_TEMPLATE_SENDER_EXCLUSION, Operations.GET_KAKAO_GROUP_TEMPLATE_SENDER_EXCLUSION.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.kakao.abusing", KakaoSanction.class);
    }

    /**
     * 템플릿 제재 조회.
     *
     * 특정 일자에 템플릿에 적용된 제재 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/kakao/abusing/block/template} (operationId {@code getKakaoTemplateSanction}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data.kakao.abusing} (an empty object if the server omits it)
     */
    public KakaoSanction getTemplate(GetKakaoTemplateSanctionParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_KAKAO_TEMPLATE_SANCTION, Operations.GET_KAKAO_TEMPLATE_SANCTION.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.kakao.abusing", KakaoSanction.class);
    }

    @Override
    public String toString() {
        return "KakaoSanctionsService";
    }
}
