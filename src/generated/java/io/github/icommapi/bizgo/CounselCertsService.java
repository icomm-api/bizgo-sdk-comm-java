// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.CounselCertStatusResult;
import io.github.icommapi.bizgo.params.GetCounselCertStatusParams;

/**
 * 카카오 상담톡: {@code client.counsel().certs()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: counsel.certs}).
 */
public final class CounselCertsService {

    private final Transport transport;

    CounselCertsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 카카오톡 인증 상태 조회.
     *
     * 인증 트랜잭션 ID로 사용자의 카카오톡 인증(전자서명) 진행 상태를 조회합니다. 최종 결과(암호화된 인증정보)는 <code>counselCertResult</code> 웹훅으로 받습니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code GET /api/comm/v1/center/cstalk/cert/status} (operationId {@code getCounselCertStatus}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public CounselCertStatusResult get(GetCounselCertStatusParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_COUNSEL_CERT_STATUS, Operations.GET_COUNSEL_CERT_STATUS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", CounselCertStatusResult.class);
    }

    @Override
    public String toString() {
        return "CounselCertsService";
    }
}
