// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.RcsMessagebaseCommonListResult;
import io.github.icommapi.bizgo.models.RcsMessagebaseFormDetailResult;
import io.github.icommapi.bizgo.params.GetRcsCommonFormatParams;

/**
 * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().commonFormats()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: rcs.commonFormats}).
 */
public final class RcsCommonFormatsService {

    private final Transport transport;

    RcsCommonFormatsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * RCS 공통 포맷 목록 조회.
     *
     * RCS에서 사용할 수 있는 공통 포맷 목록을 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/messagebase/common/list} (operationId {@code listRcsCommonFormats}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsMessagebaseCommonListResult list() {
        return transport.object(Operations.LIST_RCS_COMMON_FORMATS, Operations.LIST_RCS_COMMON_FORMATS.path(), null, null, null,
                "data.data", RcsMessagebaseCommonListResult.class);
    }

    /**
     * RCS 공통 포맷 상세 조회.
     *
     * 메시지베이스 ID를 기준으로 RCS 공통 포맷 상세 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/messagebase/common} (operationId {@code getRcsCommonFormat}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsMessagebaseFormDetailResult get(GetRcsCommonFormatParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_COMMON_FORMAT, Operations.GET_RCS_COMMON_FORMAT.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", RcsMessagebaseFormDetailResult.class);
    }

    @Override
    public String toString() {
        return "RcsCommonFormatsService";
    }
}
