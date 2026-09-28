// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.CounselUserBlockRequest;

/**
 * 카카오 상담톡: {@code client.counsel().users()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: counsel.users}).
 */
public final class CounselUsersService {

    private final Transport transport;

    CounselUsersService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 사용자 수신 차단.
     *
     * 특정 사용자의 상담톡 수신을 차단합니다. 차단하면 해당 사용자의 상담 세션도 종료됩니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/profile/user/block} (operationId {@code blockCounselUser}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void block(CounselUserBlockRequest request) {
        Params.required("request", request);
        transport.empty(Operations.BLOCK_COUNSEL_USER, Operations.BLOCK_COUNSEL_USER.path(), null, null, Transport.Body.json(request));
    }

    /**
     * 사용자 수신 차단 해제.
     *
     * 차단된 사용자의 상담톡 수신 차단을 해제합니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/cstalk/profile/user/unblock} (operationId {@code unblockCounselUser}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void unblock(CounselUserBlockRequest request) {
        Params.required("request", request);
        transport.empty(Operations.UNBLOCK_COUNSEL_USER, Operations.UNBLOCK_COUNSEL_USER.path(), null, null, Transport.Body.json(request));
    }

    @Override
    public String toString() {
        return "CounselUsersService";
    }
}
