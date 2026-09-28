// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.InsightKakaoHourlyStatisticsResult;
import io.github.icommapi.bizgo.models.InsightKakaoStatisticsResult;
import io.github.icommapi.bizgo.models.InsightKakaoTemplateStatisticsResult;
import io.github.icommapi.bizgo.params.GetAlimtalkHourlyInsightParams;
import io.github.icommapi.bizgo.params.GetAlimtalkInsightParams;
import io.github.icommapi.bizgo.params.GetAlimtalkTemplateInsightParams;

/**
 * 채널별 인사이트(알림톡·브랜드메시지·RCS): {@code client.insights().alimtalk()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: insights.alimtalk}).
 */
public final class InsightsAlimtalkService {

    private final Transport transport;

    InsightsAlimtalkService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 알림톡 주요 인사이트 조회.
     *
     * 기간·발신프로필 기준으로 알림톡 발송 성공/실패·읽음·클릭 등 주요 통계를 조회합니다. 카카오가 직접 제공하는 통계입니다.
     *
     * <p>{@code GET /api/comm/v1/center/statistics/alimtalk} (operationId {@code getAlimtalkInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public InsightKakaoStatisticsResult get(GetAlimtalkInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_ALIMTALK_INSIGHT, Operations.GET_ALIMTALK_INSIGHT.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", InsightKakaoStatisticsResult.class);
    }

    /**
     * 알림톡 시간별 반응 지표.
     *
     * 기간·발신프로필 기준으로 알림톡 시간대별(0~23시) 반응 통계를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/statistics/alimtalk/reaction/hourly} (operationId {@code getAlimtalkHourlyInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public InsightKakaoHourlyStatisticsResult getHourly(GetAlimtalkHourlyInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_ALIMTALK_HOURLY_INSIGHT, Operations.GET_ALIMTALK_HOURLY_INSIGHT.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", InsightKakaoHourlyStatisticsResult.class);
    }

    /**
     * 알림톡 템플릿 상세 조회.
     *
     * 기간·발신프로필 기준으로 알림톡 템플릿별 통계를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/statistics/alimtalk/template} (operationId {@code getAlimtalkTemplateInsight}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public InsightKakaoTemplateStatisticsResult getByTemplate(GetAlimtalkTemplateInsightParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_ALIMTALK_TEMPLATE_INSIGHT, Operations.GET_ALIMTALK_TEMPLATE_INSIGHT.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", InsightKakaoTemplateStatisticsResult.class);
    }

    @Override
    public String toString() {
        return "InsightsAlimtalkService";
    }
}
