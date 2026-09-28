// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessageGroupSendControlRequest;
import io.github.icommapi.bizgo.models.BrandMessageGroupSendCreateRequest;
import io.github.icommapi.bizgo.models.BrandMessageGroupSendResult;
import io.github.icommapi.bizgo.params.GetBrandMessageGroupSendParams;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().groupSends()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage.groupSends}).
 */
public final class BrandMessageGroupSendsService {

    private final Transport transport;

    BrandMessageGroupSendsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 브랜드메시지 동보 발송.
     *
     * 기본형 템플릿을 기준으로 친구 그룹 또는 전체 친구에게 동보 발송을 예약합니다. 템플릿은 변수가 없고 상태가 등록(<code>A</code>)이어야 합니다. 발송 수는 요청 시점의 친구 관계로 정해지고, 실제 발송 시점의 친구 관계에 따라 그 수 안에서 순차 발송됩니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/groupMessage} (operationId {@code createBrandMessageGroupSend}, retry {@code rate_limit_only}, rate-limit bucket {@code send}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageGroupSendResult create(BrandMessageGroupSendCreateRequest request) {
        Params.required("request", request);
        return transport.object(Operations.CREATE_BRAND_MESSAGE_GROUP_SEND, Operations.CREATE_BRAND_MESSAGE_GROUP_SEND.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageGroupSendResult.class);
    }

    /**
     * 브랜드메시지 동보 발송 조회.
     *
     * 발신프로필 키와 요청 아이디로 특정 동보 발송 요청의 상태를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/groupMessage} (operationId {@code getBrandMessageGroupSend}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageGroupSendResult get(GetBrandMessageGroupSendParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_GROUP_SEND, Operations.GET_BRAND_MESSAGE_GROUP_SEND.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageGroupSendResult.class);
    }

    /**
     * 브랜드메시지 동보 발송 재개.
     *
     * 중지된 기본형 템플릿 동보 발송 요청을 다시 시작합니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/groupMessage/resume} (operationId {@code resumeBrandMessageGroupSend}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageGroupSendResult resume(BrandMessageGroupSendControlRequest request) {
        Params.required("request", request);
        return transport.object(Operations.RESUME_BRAND_MESSAGE_GROUP_SEND, Operations.RESUME_BRAND_MESSAGE_GROUP_SEND.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageGroupSendResult.class);
    }

    /**
     * 브랜드메시지 동보 발송 중지.
     *
     * 진행 중인 기본형 템플릿 동보 발송 요청을 일시 중지합니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/groupMessage/pause} (operationId {@code pauseBrandMessageGroupSend}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageGroupSendResult pause(BrandMessageGroupSendControlRequest request) {
        Params.required("request", request);
        return transport.object(Operations.PAUSE_BRAND_MESSAGE_GROUP_SEND, Operations.PAUSE_BRAND_MESSAGE_GROUP_SEND.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageGroupSendResult.class);
    }

    /**
     * 브랜드메시지 동보 발송 종료.
     *
     * 예약 또는 진행 중인 기본형 템플릿 동보 발송 요청을 종료합니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/groupMessage/terminate} (operationId {@code terminateBrandMessageGroupSend}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageGroupSendResult terminate(BrandMessageGroupSendControlRequest request) {
        Params.required("request", request);
        return transport.object(Operations.TERMINATE_BRAND_MESSAGE_GROUP_SEND, Operations.TERMINATE_BRAND_MESSAGE_GROUP_SEND.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageGroupSendResult.class);
    }

    @Override
    public String toString() {
        return "BrandMessageGroupSendsService";
    }
}
