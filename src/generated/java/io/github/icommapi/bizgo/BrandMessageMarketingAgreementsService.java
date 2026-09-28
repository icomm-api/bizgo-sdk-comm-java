// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessageMarketingAgreeResult;
import io.github.icommapi.bizgo.models.BrandMessageMarketingAgreeUploadRequest;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().marketingAgreements()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage.marketingAgreements}).
 */
public final class BrandMessageMarketingAgreementsService {

    private final Transport transport;

    BrandMessageMarketingAgreementsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 광고성 정보 수신동의 증적자료 파일 업로드.
     *
     * 광고성 정보 수신동의를 입증하는 증적자료 파일을 업로드합니다. 파일은 발신프로필 기준으로 관리되며, 발송권한 신청 조건 중 하나입니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/marketingAgree} (operationId {@code uploadBrandMessageMarketingAgreeEvidence}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageMarketingAgreeResult uploadEvidence(BrandMessageMarketingAgreeUploadRequest request) {
        Params.required("request", request);
        Multipart.Form form = Multipart.form();
        form.text("senderKey", request.getSenderKey());
        form.file("file", request.getFile());
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_MARKETING_AGREE_EVIDENCE, Operations.UPLOAD_BRAND_MESSAGE_MARKETING_AGREE_EVIDENCE.path(), null, null, form.build(),
                "data.data", BrandMessageMarketingAgreeResult.class);
    }

    @Override
    public String toString() {
        return "BrandMessageMarketingAgreementsService";
    }
}
