// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.RcsTemplateFormLogoListResult;
import io.github.icommapi.bizgo.models.RcsTemplateImageResult;
import io.github.icommapi.bizgo.models.RcsTemplateImageUploadRequest;
import io.github.icommapi.bizgo.params.GetRcsTemplateImageParams;
import io.github.icommapi.bizgo.params.ListRcsTemplateFormLogosParams;

/**
 * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().templateImages()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: rcs.templateImages}).
 */
public final class RcsTemplateImagesService {

    private final Transport transport;

    RcsTemplateImagesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * RCS 템플릿 이미지 상세 조회.
     *
     * 브랜드 ID와 템플릿 파일 ID를 기준으로 템플릿 이미지 상세 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/messagebase/file} (operationId {@code getRcsTemplateImage}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsTemplateImageResult get(GetRcsTemplateImageParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_TEMPLATE_IMAGE, Operations.GET_RCS_TEMPLATE_IMAGE.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", RcsTemplateImageResult.class);
    }

    /**
     * RCS 템플릿 이미지 등록.
     *
     * RCS 템플릿 등록에 사용할 이미지를 업로드하고 템플릿 파일 ID를 발급받습니다. 발송용 이미지 업로드(<code>/api/comm/v1/file/rcs</code>)와는 다른 API입니다.
     *
     * <p>{@code POST /api/comm/v1/center/rcs/messagebase/file} (operationId {@code uploadRcsTemplateImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsTemplateImageResult upload(RcsTemplateImageUploadRequest request) {
        Params.required("request", request);
        Multipart.Form form = Multipart.form();
        form.text("brandId", request.getBrandId());
        form.file("file", request.getFile());
        return transport.object(Operations.UPLOAD_RCS_TEMPLATE_IMAGE, Operations.UPLOAD_RCS_TEMPLATE_IMAGE.path(), null, null, form.build(),
                "data.data", RcsTemplateImageResult.class);
    }

    /**
     * RCS 템플릿 양식 로고 이미지 조회.
     *
     * 템플릿 양식 ID를 기준으로 템플릿 양식에서 사용할 수 있는 로고 이미지 목록을 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/messagebase/messagebaseform/logo} (operationId {@code listRcsTemplateFormLogos}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsTemplateFormLogoListResult listFormLogos(ListRcsTemplateFormLogosParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_RCS_TEMPLATE_FORM_LOGOS, Operations.LIST_RCS_TEMPLATE_FORM_LOGOS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", RcsTemplateFormLogoListResult.class);
    }

    @Override
    public String toString() {
        return "RcsTemplateImagesService";
    }
}
