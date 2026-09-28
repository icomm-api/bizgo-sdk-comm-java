// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.CounselSenderActivationRequest;
import io.github.icommapi.bizgo.models.CounselSenderRequest;

/**
 * 카카오 상담톡: {@code client.counsel().channels()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: counsel.channels}).
 */
public final class CounselChannelsService {

    private final Transport transport;

    CounselChannelsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 상담톡 이용 활성화.
     *
     * 발신프로필의 상담톡 이용을 활성화합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/sender/activate} (operationId {@code activateCounsel}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void activate(CounselSenderActivationRequest request) {
        Params.required("request", request);
        transport.empty(Operations.ACTIVATE_COUNSEL, Operations.ACTIVATE_COUNSEL.path(), null, null, Transport.Body.json(request));
    }

    /**
     * 상담톡 이용 비활성화.
     *
     * 발신프로필의 상담톡 이용을 비활성화합니다. 해지하면 저장된 상담시간이 삭제됩니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/sender/deactivate} (operationId {@code deactivateCounsel}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void deactivate(CounselSenderActivationRequest request) {
        Params.required("request", request);
        transport.empty(Operations.DEACTIVATE_COUNSEL, Operations.DEACTIVATE_COUNSEL.path(), null, null, Transport.Body.json(request));
    }

    /**
     * 채팅 기능 활성화.
     *
     * 카카오톡 채널의 채팅 기능을 활성화합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/sender/chat/activate} (operationId {@code activateCounselChat}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void activateChat(CounselSenderRequest request) {
        Params.required("request", request);
        transport.empty(Operations.ACTIVATE_COUNSEL_CHAT, Operations.ACTIVATE_COUNSEL_CHAT.path(), null, null, Transport.Body.json(request));
    }

    /**
     * 채팅 기능 비활성화.
     *
     * 카카오톡 채널의 채팅 기능을 비활성화합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/sender/chat/deactivate} (operationId {@code deactivateCounselChat}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void deactivateChat(CounselSenderRequest request) {
        Params.required("request", request);
        transport.empty(Operations.DEACTIVATE_COUNSEL_CHAT, Operations.DEACTIVATE_COUNSEL_CHAT.path(), null, null, Transport.Body.json(request));
    }

    @Override
    public String toString() {
        return "CounselChannelsService";
    }
}
