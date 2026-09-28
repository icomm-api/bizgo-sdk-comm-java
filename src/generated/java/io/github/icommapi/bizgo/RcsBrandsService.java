// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.RcsBrandResult;
import io.github.icommapi.bizgo.models.RcsBrandUpdateRequest;
import io.github.icommapi.bizgo.params.GetRcsBrandParams;

/**
 * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().brands()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: rcs.brands}).
 */
public final class RcsBrandsService {

    private final Transport transport;

    RcsBrandsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * RCS 브랜드 상세 조회.
     *
     * brandId 기준으로 RCS 브랜드 상세 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/brand} (operationId {@code getRcsBrand}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsBrandResult get(GetRcsBrandParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_BRAND, Operations.GET_RCS_BRAND.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", RcsBrandResult.class);
    }

    /**
     * RCS 브랜드 수정.
     *
     * 브랜드 기본 정보와 브랜드 이미지를 수정합니다. <code>multipart/form-data</code>로 보내며, <code>regBrand</code>는 JSON 문자열 파트, 이미지·증빙 파일은 바이너리 파트입니다. 파일 스트림을 다시 보내야 하고 검수 요청이 다시 걸릴 수 있으므로 SDK는 429만 재시도합니다.
     *
     * <p>{@code PUT /api/comm/v1/center/rcs/brand} (operationId {@code updateRcsBrand}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsBrandResult update(RcsBrandUpdateRequest request) {
        Params.required("request", request);
        Multipart.Form form = Multipart.form();
        form.text("brandId", request.getBrandId());
        form.json("regBrand", request.getRegBrand());
        form.file("brandProfile", request.getBrandProfile());
        form.file("brandBackground", request.getBrandBackground());
        form.file("seasonDocFile", request.getSeasonDocFile());
        return transport.object(Operations.UPDATE_RCS_BRAND, Operations.UPDATE_RCS_BRAND.path(), null, null, form.build(),
                "data.data", RcsBrandResult.class);
    }

    @Override
    public String toString() {
        return "RcsBrandsService";
    }
}
