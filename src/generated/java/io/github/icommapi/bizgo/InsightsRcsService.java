// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.InsightRcsBrandProfileStatResult;
import io.github.icommapi.bizgo.models.InsightRcsMessageButtonStatResult;
import io.github.icommapi.bizgo.models.InsightRcsMessageStatResult;
import io.github.icommapi.bizgo.models.InsightRcsPersistentMenuStatResult;
import io.github.icommapi.bizgo.params.GetRcsBrandProfileInsightParams;
import io.github.icommapi.bizgo.params.GetRcsMessageButtonInsightParams;
import io.github.icommapi.bizgo.params.GetRcsMessageInsightParams;
import io.github.icommapi.bizgo.params.GetRcsPersistentMenuInsightParams;

/**
 * 채널별 인사이트(알림톡·브랜드메시지·RCS): {@code client.insights().rcs()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: insights.rcs}).
 */
public final class InsightsRcsService {

    private final Transport transport;

    InsightsRcsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * RCS 메시지 발송·노출 통계.
     *
     * 브랜드·그룹 기준으로 RCS 메시지의 발송 건수와 노출(읽음) 건수를 일자별로 조회합니다. 통계는 발송 요청의 <code>groupId</code> 단위로 집계되며, <code>groupId</code> 없이 보낸 건은 포함되지 않습니다. 응답 데이터는 <code>data.data</code>가 아니라 <code>data.rcs</code>에 있습니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/brandId/&#123;brandId&#125;/stat/message} (operationId {@code getRcsMessageInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param brandId RCS 브랜드 ID입니다. (required)
     * @param params query parameters
     * @return the response part at {@code data.rcs} (an empty object if the server omits it)
     */
    public InsightRcsMessageStatResult getMessage(String brandId, GetRcsMessageInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_MESSAGE_INSIGHT, Operations.GET_RCS_MESSAGE_INSIGHT.path(brandId), params.toQuery(), params.toHeaders(), null,
                "data.rcs", InsightRcsMessageStatResult.class);
    }

    /**
     * RCS 메시지 버튼 클릭 통계.
     *
     * RCS 메시지에 포함된 버튼의 클릭 수를 카드·버튼 단위로 조회합니다. 응답 데이터는 <code>data.data</code>가 아니라 <code>data.rcs</code>에 있습니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/brandId/&#123;brandId&#125;/stat/messageButton} (operationId {@code getRcsMessageButtonInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param brandId RCS 브랜드 ID입니다. (required)
     * @param params query parameters
     * @return the response part at {@code data.rcs} (an empty object if the server omits it)
     */
    public InsightRcsMessageButtonStatResult getMessageButton(String brandId, GetRcsMessageButtonInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_MESSAGE_BUTTON_INSIGHT, Operations.GET_RCS_MESSAGE_BUTTON_INSIGHT.path(brandId), params.toQuery(), params.toHeaders(), null,
                "data.rcs", InsightRcsMessageButtonStatResult.class);
    }

    /**
     * RCS 대화방 메뉴 클릭 통계.
     *
     * 대화방 하단 고정 메뉴의 클릭 수를 메뉴 단위로 조회합니다. RCS 인사이트 중 이 API만 <code>chatbotId</code>가 필수입니다. 응답 데이터는 <code>data.data</code>가 아니라 <code>data.rcs</code>에 있습니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/brandId/&#123;brandId&#125;/stat/persistentMenu} (operationId {@code getRcsPersistentMenuInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param brandId RCS 브랜드 ID입니다. (required)
     * @param params query parameters
     * @return the response part at {@code data.rcs} (an empty object if the server omits it)
     */
    public InsightRcsPersistentMenuStatResult getPersistentMenu(String brandId, GetRcsPersistentMenuInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_PERSISTENT_MENU_INSIGHT, Operations.GET_RCS_PERSISTENT_MENU_INSIGHT.path(brandId), params.toQuery(), params.toHeaders(), null,
                "data.rcs", InsightRcsPersistentMenuStatResult.class);
    }

    /**
     * RCS 브랜드 프로필 노출 통계.
     *
     * 브랜드 프로필이 노출된 건수를 일자별로 조회합니다. 그룹·챗봇 조건 없이 기간만으로 조회합니다. 응답 데이터는 <code>data.data</code>가 아니라 <code>data.rcs</code>에 있습니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/brandId/&#123;brandId&#125;/stat/brandProfile} (operationId {@code getRcsBrandProfileInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param brandId RCS 브랜드 ID입니다. (required)
     * @param params query parameters
     * @return the response part at {@code data.rcs} (an empty object if the server omits it)
     */
    public InsightRcsBrandProfileStatResult getBrandProfile(String brandId, GetRcsBrandProfileInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_BRAND_PROFILE_INSIGHT, Operations.GET_RCS_BRAND_PROFILE_INSIGHT.path(brandId), params.toQuery(), params.toHeaders(), null,
                "data.rcs", InsightRcsBrandProfileStatResult.class);
    }

    @Override
    public String toString() {
        return "InsightsRcsService";
    }
}
