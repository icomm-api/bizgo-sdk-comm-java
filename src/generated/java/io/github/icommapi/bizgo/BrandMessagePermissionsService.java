// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessagePermissionApplyRequest;
import io.github.icommapi.bizgo.params.CheckBrandMessageSendPermissionParams;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().permissions()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage.permissions}).
 */
public final class BrandMessagePermissionsService {

    private final Transport transport;

    BrandMessagePermissionsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 브랜드메시지 발송권한 신청 가능 여부 확인.
     *
     * 발신프로필이 고객사 회원 대상 발송 권한을 신청할 수 있는 상태인지 확인합니다. <code>data.code</code>가 <code>A000</code>이면 신청 가능합니다. 고객사 회원 대상 발송(targeting M·N·O)에는 카카오 발송 권한이 필요합니다. 조건: 비즈니스 인증 채널, 등록된 채널 전화번호, 채널 친구 수 5만 이상, 업로드된 광고성 정보 수신동의 증적파일, 3개월 이내 알림톡 발송 이력. 어떤 조건이 미달인지는 응답으로 구분되지 않습니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/sendPermission} (operationId {@code checkBrandMessageSendPermission}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     */
    public void check(CheckBrandMessageSendPermissionParams params) {
        Params.required("params", params);
        transport.empty(Operations.CHECK_BRAND_MESSAGE_SEND_PERMISSION, Operations.CHECK_BRAND_MESSAGE_SEND_PERMISSION.path(), params.toQuery(), params.toHeaders(), null);
    }

    /**
     * 브랜드메시지 발송권한 신청.
     *
     * 고객사 회원 대상 발송(targeting M·N·O) 권한을 신청합니다. 권한은 톡채널 단위로 부여되므로 같은 톡채널을 쓰는 다른 딜러사의 발신프로필에도 함께 적용됩니다. 고객사 회원 대상 발송(targeting M·N·O)에는 카카오 발송 권한이 필요합니다. 조건: 비즈니스 인증 채널, 등록된 채널 전화번호, 채널 친구 수 5만 이상, 업로드된 광고성 정보 수신동의 증적파일, 3개월 이내 알림톡 발송 이력. 어떤 조건이 미달인지는 응답으로 구분되지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/sendPermission} (operationId {@code applyBrandMessageSendPermission}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void apply(BrandMessagePermissionApplyRequest request) {
        Params.required("request", request);
        transport.empty(Operations.APPLY_BRAND_MESSAGE_SEND_PERMISSION, Operations.APPLY_BRAND_MESSAGE_SEND_PERMISSION.path(), null, null, Transport.Body.json(request));
    }

    @Override
    public String toString() {
        return "BrandMessagePermissionsService";
    }
}
