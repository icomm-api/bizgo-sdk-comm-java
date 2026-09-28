// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.CounselConsultTimeResult;
import io.github.icommapi.bizgo.models.CounselConsultTimeSaveRequest;
import io.github.icommapi.bizgo.params.GetCounselConsultTimeParams;

/**
 * 카카오 상담톡: {@code client.counsel().consultTime()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: counsel.consultTime}).
 */
public final class CounselConsultTimeService {

    private final Transport transport;

    CounselConsultTimeService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 상담시간 조회.
     *
     * 상담 운영 시간(요일별)을 조회합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code GET /api/comm/v1/center/cstalk/consult/time} (operationId {@code getCounselConsultTime}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public CounselConsultTimeResult get(GetCounselConsultTimeParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_COUNSEL_CONSULT_TIME, Operations.GET_COUNSEL_CONSULT_TIME.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", CounselConsultTimeResult.class);
    }

    /**
     * 상담시간 저장.
     *
     * 카카오톡 채널의 상담시간을 저장합니다. 한 번 등록하면 수정만 가능하며, 상담톡 이용을 해지하면 삭제됩니다. 상담시간은 카카오톡 채널 홈에 노출되며, 확인하려면 채팅 기능이 활성화되어 있어야 합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/consult/time} (operationId {@code saveCounselConsultTime}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void save(CounselConsultTimeSaveRequest request) {
        Params.required("request", request);
        transport.empty(Operations.SAVE_COUNSEL_CONSULT_TIME, Operations.SAVE_COUNSEL_CONSULT_TIME.path(), null, null, Transport.Body.json(request));
    }

    @Override
    public String toString() {
        return "CounselConsultTimeService";
    }
}
