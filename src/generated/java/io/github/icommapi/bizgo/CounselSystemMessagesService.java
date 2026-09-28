// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.CounselSenderRequest;
import io.github.icommapi.bizgo.models.CounselSystemMessageCreateRequest;
import io.github.icommapi.bizgo.models.CounselSystemMessageCreateResult;
import io.github.icommapi.bizgo.models.CounselSystemMessageListResult;
import io.github.icommapi.bizgo.params.ListCounselSystemMessagesParams;

/**
 * 카카오 상담톡: {@code client.counsel().systemMessages()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: counsel.systemMessages}).
 */
public final class CounselSystemMessagesService {

    private final Transport transport;

    CounselSystemMessagesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 시스템 메시지 조회.
     *
     * 시스템 메시지 목록을 조회합니다. <code>id</code>를 주면 해당 메시지만 조회합니다. 페이지네이션은 문서에 없습니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code GET /api/comm/v1/center/cstalk/system/message} (operationId {@code listCounselSystemMessages}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public CounselSystemMessageListResult list(ListCounselSystemMessagesParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_COUNSEL_SYSTEM_MESSAGES, Operations.LIST_COUNSEL_SYSTEM_MESSAGES.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", CounselSystemMessageListResult.class);
    }

    /**
     * 시스템 메시지 등록.
     *
     * 시스템 메시지를 등록합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/system/message} (operationId {@code createCounselSystemMessage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public CounselSystemMessageCreateResult create(CounselSystemMessageCreateRequest request) {
        Params.required("request", request);
        return transport.object(Operations.CREATE_COUNSEL_SYSTEM_MESSAGE, Operations.CREATE_COUNSEL_SYSTEM_MESSAGE.path(), null, null, Transport.Body.json(request),
                "data.data", CounselSystemMessageCreateResult.class);
    }

    /**
     * 시스템 메시지 삭제.
     *
     * 시스템 메시지를 삭제합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code DELETE /api/comm/v1/center/cstalk/system/message/senderKey/&#123;senderKey&#125;/id/&#123;id&#125;} (operationId {@code deleteCounselSystemMessage}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param senderKey 발신프로필 키입니다. URL 인코딩해서 넣습니다. (required)
     * @param id 삭제할 시스템 메시지 ID입니다. (required)
     */
    public void delete(String senderKey, String id) {
        transport.empty(Operations.DELETE_COUNSEL_SYSTEM_MESSAGE, Operations.DELETE_COUNSEL_SYSTEM_MESSAGE.path(senderKey, id), null, null, null);
    }

    /**
     * 시스템 메시지 검수 요청.
     *
     * 시스템 메시지 검수를 요청합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/system/message/approval/request} (operationId {@code requestCounselSystemMessageApproval}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void requestApproval(CounselSenderRequest request) {
        Params.required("request", request);
        transport.empty(Operations.REQUEST_COUNSEL_SYSTEM_MESSAGE_APPROVAL, Operations.REQUEST_COUNSEL_SYSTEM_MESSAGE_APPROVAL.path(), null, null, Transport.Body.json(request));
    }

    /**
     * 시스템 메시지 검수 취소.
     *
     * 시스템 메시지 검수 요청을 취소합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/system/message/approval/cancel} (operationId {@code cancelCounselSystemMessageApproval}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void cancelApproval(CounselSenderRequest request) {
        Params.required("request", request);
        transport.empty(Operations.CANCEL_COUNSEL_SYSTEM_MESSAGE_APPROVAL, Operations.CANCEL_COUNSEL_SYSTEM_MESSAGE_APPROVAL.path(), null, null, Transport.Body.json(request));
    }

    @Override
    public String toString() {
        return "CounselSystemMessagesService";
    }
}
