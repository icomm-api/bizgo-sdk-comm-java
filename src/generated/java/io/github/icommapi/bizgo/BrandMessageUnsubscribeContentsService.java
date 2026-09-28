// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessageUnsubscribeContentRequest;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().unsubscribeContents()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage.unsubscribeContents}).
 */
public final class BrandMessageUnsubscribeContentsService {

    private final Transport transport;

    BrandMessageUnsubscribeContentsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 발신프로필 무료수신거부 정보 입력.
     *
     * 발신프로필의 무료수신거부 전화번호와 인증번호를 등록합니다. 광고성 메시지 하단의 무료수신거부 안내에 씁니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/unSubscribeContent} (operationId {@code registerBrandMessageUnsubscribeContent}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void register(BrandMessageUnsubscribeContentRequest request) {
        Params.required("request", request);
        transport.empty(Operations.REGISTER_BRAND_MESSAGE_UNSUBSCRIBE_CONTENT, Operations.REGISTER_BRAND_MESSAGE_UNSUBSCRIBE_CONTENT.path(), null, null, Transport.Body.json(request));
    }

    @Override
    public String toString() {
        return "BrandMessageUnsubscribeContentsService";
    }
}
