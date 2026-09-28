// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessageAudienceEstimateResult;
import io.github.icommapi.bizgo.models.BrandMessageAudienceFriendCountResult;
import io.github.icommapi.bizgo.models.BrandMessageAudiencePossibleByPhoneNumbersRequest;
import io.github.icommapi.bizgo.models.BrandMessageAudiencePossibleResult;
import io.github.icommapi.bizgo.params.CheckBrandMessageAudiencePossibleParams;
import io.github.icommapi.bizgo.params.EstimateBrandMessageGroupSendDurationParams;
import io.github.icommapi.bizgo.params.GetBrandMessageFriendCountParams;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().audience()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage.audience}).
 */
public final class BrandMessageAudienceService {

    private final Transport transport;

    BrandMessageAudienceService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 발송 예상 모수 확인 (친구 그룹 기반).
     *
     * 메시지 타입과 친구 그룹 조건으로 동보 발송 예상 발송 수를 조회합니다. 친구 그룹을 쓰면 그룹 상태가 완료이고 등록 유저 수가 10 이상이어야 발송 예약이 가능하며, 친구 관계는 실시간으로 동기화됩니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/groupMessage/possible} (operationId {@code checkBrandMessageAudiencePossible}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageAudiencePossibleResult checkPossible(CheckBrandMessageAudiencePossibleParams params) {
        Params.required("params", params);
        return transport.object(Operations.CHECK_BRAND_MESSAGE_AUDIENCE_POSSIBLE, Operations.CHECK_BRAND_MESSAGE_AUDIENCE_POSSIBLE.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageAudiencePossibleResult.class);
    }

    /**
     * 발송 예상 모수 확인 (전화번호 명단 기반).
     *
     * 전화번호 명단으로 동보 발송 가능 예상 수를 조회합니다. 국가코드는 자동 정규화되고 유효한 번호로 모수를 계산합니다. 최소 10건이며, 하나라도 형식이 잘못되면 요청 전체가 거부됩니다. 상태를 바꾸지 않는 조회이므로 재시도해도 안전합니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/groupMessage/friend/possible} (operationId {@code checkBrandMessageAudiencePossibleByPhoneNumbers}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageAudiencePossibleResult checkPossibleByPhoneNumbers(BrandMessageAudiencePossibleByPhoneNumbersRequest request) {
        Params.required("request", request);
        return transport.object(Operations.CHECK_BRAND_MESSAGE_AUDIENCE_POSSIBLE_BY_PHONE_NUMBERS, Operations.CHECK_BRAND_MESSAGE_AUDIENCE_POSSIBLE_BY_PHONE_NUMBERS.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageAudiencePossibleResult.class);
    }

    /**
     * 채널 전체 친구 수 조회.
     *
     * 발신프로필 기준 친구 수를 조회합니다. 동보 발송 가능 대상 수를 미리 확인할 때 씁니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/groupMessage/friendCount} (operationId {@code getBrandMessageFriendCount}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageAudienceFriendCountResult getFriendCount(GetBrandMessageFriendCountParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_FRIEND_COUNT, Operations.GET_BRAND_MESSAGE_FRIEND_COUNT.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageAudienceFriendCountResult.class);
    }

    /**
     * 동보 발송 예상 소요시간 조회.
     *
     * 동보 발송 시작 시각과 대상 수로 예상 종료 시각과 소요 시간을 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/groupMessage/estimate} (operationId {@code estimateBrandMessageGroupSendDuration}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageAudienceEstimateResult estimate(EstimateBrandMessageGroupSendDurationParams params) {
        Params.required("params", params);
        return transport.object(Operations.ESTIMATE_BRAND_MESSAGE_GROUP_SEND_DURATION, Operations.ESTIMATE_BRAND_MESSAGE_GROUP_SEND_DURATION.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageAudienceEstimateResult.class);
    }

    @Override
    public String toString() {
        return "BrandMessageAudienceService";
    }
}
