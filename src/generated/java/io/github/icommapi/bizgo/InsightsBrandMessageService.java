// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.InsightKakaoHourlyStatisticsResult;
import io.github.icommapi.bizgo.models.InsightKakaoStatisticsResult;
import io.github.icommapi.bizgo.models.InsightKakaoTemplateStatisticsResult;
import io.github.icommapi.bizgo.params.GetBrandMessageHourlyInsightParams;
import io.github.icommapi.bizgo.params.GetBrandMessageInsightParams;
import io.github.icommapi.bizgo.params.GetBrandMessageTemplateInsightParams;

/**
 * 채널별 인사이트(알림톡·브랜드메시지·RCS): {@code client.insights().brandMessage()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: insights.brandMessage}).
 */
public final class InsightsBrandMessageService {

    private final Transport transport;

    InsightsBrandMessageService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 브랜드메시지 주요 인사이트 조회.
     *
     * 기간·발신프로필 기준으로 브랜드메시지 발송 성공/실패·읽음·클릭 등 주요 통계를 조회합니다. 카카오가 직접 제공하는 통계입니다.
     *
     * <p>{@code GET /api/comm/v1/center/statistics/brandmessage} (operationId {@code getBrandMessageInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public InsightKakaoStatisticsResult get(GetBrandMessageInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_INSIGHT, Operations.GET_BRAND_MESSAGE_INSIGHT.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", InsightKakaoStatisticsResult.class);
    }

    /**
     * 브랜드메시지 시간별 반응 지표.
     *
     * 기간·발신프로필 기준으로 브랜드메시지 시간대별(0~23시) 반응 통계를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/statistics/brandmessage/reaction/hourly} (operationId {@code getBrandMessageHourlyInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public InsightKakaoHourlyStatisticsResult getHourly(GetBrandMessageHourlyInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_HOURLY_INSIGHT, Operations.GET_BRAND_MESSAGE_HOURLY_INSIGHT.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", InsightKakaoHourlyStatisticsResult.class);
    }

    /**
     * 브랜드메시지 템플릿 상세 조회.
     *
     * 기간·발신프로필 기준으로 브랜드메시지 템플릿별 통계를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/statistics/brandmessage/template} (operationId {@code getBrandMessageTemplateInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public InsightKakaoTemplateStatisticsResult getByTemplate(GetBrandMessageTemplateInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_TEMPLATE_INSIGHT, Operations.GET_BRAND_MESSAGE_TEMPLATE_INSIGHT.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", InsightKakaoTemplateStatisticsResult.class);
    }

    @Override
    public String toString() {
        return "InsightsBrandMessageService";
    }
}
