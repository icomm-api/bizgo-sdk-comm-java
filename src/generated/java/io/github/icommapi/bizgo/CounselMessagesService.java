// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.CounselMessageDeleteRequest;
import io.github.icommapi.bizgo.models.CounselPlainMessageRequest;
import io.github.icommapi.bizgo.models.CounselRichMessageRequest;
import io.github.icommapi.bizgo.models.CounselSendServiceResult;

/**
 * 카카오 상담톡: {@code client.counsel().messages()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: counsel.messages}).
 */
public final class CounselMessagesService {

    private final Transport transport;

    CounselMessagesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 상담톡 Plain 메시지 발송.
     *
     * 상담톡 Plain 메시지(TEXT, IMAGE, VIDEO, AUDIO, FILE)를 발송합니다.
     * <p>상담 세션이 열려 있는 사용자에게만 보낼 수 있습니다. 세션은 사용자의 마지막 메시지 수신 후 30일간 유지됩니다. 접수 결과의 <code>msgKey</code>로 발송 결과 웹훅(<code>counselResult</code>)과 대조합니다. 두 번 호출하면 중복 발송되므로 429 외에는 자동 재시도하지 않습니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/cstalk/plain} (operationId {@code sendCounselPlain}, retry {@code rate_limit_only}, rate-limit bucket {@code send}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data} (an empty object if the server omits it)
     */
    public CounselSendServiceResult sendPlain(CounselPlainMessageRequest request) {
        Params.required("request", request);
        return transport.object(Operations.SEND_COUNSEL_PLAIN, Operations.SEND_COUNSEL_PLAIN.path(), null, null, Transport.Body.json(request),
                "data", CounselSendServiceResult.class);
    }

    /**
     * 상담톡 Rich 메시지 발송.
     *
     * 상담톡 Rich 메시지(TEXT, IMAGE, WIDE, ITEM_LIST, WIDE_ITEM_LIST, CAROUSEL_FEED, PERSONAL)를 발송합니다. <code>KAKAO_CERT</code>(본인인증) 발송은 채널이 본인인증 화이트리스트에 사전 등록되어 있어야 하며, 결과는 <code>counselCertResult</code> 웹훅으로 옵니다.
     * <p>상담 세션이 열려 있는 사용자에게만 보낼 수 있습니다. 세션은 사용자의 마지막 메시지 수신 후 30일간 유지됩니다. 접수 결과의 <code>msgKey</code>로 발송 결과 웹훅(<code>counselResult</code>)과 대조합니다. 두 번 호출하면 중복 발송되므로 429 외에는 자동 재시도하지 않습니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/cstalk/rich} (operationId {@code sendCounselRich}, retry {@code rate_limit_only}, rate-limit bucket {@code send}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data} (an empty object if the server omits it)
     */
    public CounselSendServiceResult sendRich(CounselRichMessageRequest request) {
        Params.required("request", request);
        return transport.object(Operations.SEND_COUNSEL_RICH, Operations.SEND_COUNSEL_RICH.path(), null, null, Transport.Body.json(request),
                "data", CounselSendServiceResult.class);
    }

    /**
     * 상담 메시지 삭제.
     *
     * 이미 발송된 상담톡 메시지를 삭제합니다. 삭제한 메시지는 복구할 수 없습니다. 응답 코드: <code>A000</code> 삭제 성공, <code>A502</code> 발신프로필 미등록·<code>senderKey</code>/<code>msgKey</code> 오류·소유자 불일치, <code>A507</code> <code>userKey</code> 오류, <code>A822</code> 삭제 불가 상태, <code>A213</code> 그 외 처리 실패.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/chat/delete} (operationId {@code deleteCounselMessage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void delete(CounselMessageDeleteRequest request) {
        Params.required("request", request);
        transport.empty(Operations.DELETE_COUNSEL_MESSAGE, Operations.DELETE_COUNSEL_MESSAGE.path(), null, null, Transport.Body.json(request));
    }

    @Override
    public String toString() {
        return "CounselMessagesService";
    }
}
