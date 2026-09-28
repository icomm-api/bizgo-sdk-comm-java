// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.CounselEndRequest;
import io.github.icommapi.bizgo.models.CounselEndResult;
import io.github.icommapi.bizgo.models.CounselEndWithBotRequest;
import io.github.icommapi.bizgo.models.CounselSessionResult;
import io.github.icommapi.bizgo.params.GetCounselSessionParams;

/**
 * 카카오 상담톡: {@code client.counsel().sessions()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: counsel.sessions}).
 */
public final class CounselSessionsService {

    private final Transport transport;

    CounselSessionsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 상담 종료.
     *
     * 현재 열려 있는 상담 세션을 종료합니다. 처리 결과는 발송 결과 웹훅(<code>counselResult</code>, requestType <code>end</code>)으로도 전달됩니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/cstalk/end} (operationId {@code endCounselSession}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public CounselEndResult end(CounselEndRequest request) {
        Params.required("request", request);
        return transport.object(Operations.END_COUNSEL_SESSION, Operations.END_COUNSEL_SESSION.path(), null, null, Transport.Body.json(request),
                "data.data", CounselEndResult.class);
    }

    /**
     * 상담 종료 및 봇 전환.
     *
     * 상담 세션을 종료한 뒤 봇 이벤트 말블록을 실행합니다. 처리 결과는 발송 결과 웹훅(<code>counselResult</code>, requestType <code>endwithbot</code>)으로도 전달됩니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/cstalk/endWithBot} (operationId {@code endCounselSessionWithBot}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public CounselEndResult endWithBot(CounselEndWithBotRequest request) {
        Params.required("request", request);
        return transport.object(Operations.END_COUNSEL_SESSION_WITH_BOT, Operations.END_COUNSEL_SESSION_WITH_BOT.path(), null, null, Transport.Body.json(request),
                "data.data", CounselEndResult.class);
    }

    /**
     * 세션 조회.
     *
     * 사용자 키 기준으로 현재 상담 세션 정보를 조회합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code GET /api/comm/v1/center/cstalk/session} (operationId {@code getCounselSession}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public CounselSessionResult get(GetCounselSessionParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_COUNSEL_SESSION, Operations.GET_COUNSEL_SESSION.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", CounselSessionResult.class);
    }

    @Override
    public String toString() {
        return "CounselSessionsService";
    }
}
