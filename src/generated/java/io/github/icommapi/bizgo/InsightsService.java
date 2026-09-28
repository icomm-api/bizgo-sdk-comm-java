// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

/**
 * 채널별 인사이트(알림톡·브랜드메시지·RCS): {@code client.insights()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: insights}).
 */
public final class InsightsService {

    private final Transport transport;
    private final InsightsAlimtalkService alimtalk;
    private final InsightsBrandMessageService brandMessage;
    private final InsightsRcsService rcs;

    InsightsService(Transport transport) {
        this.transport = transport;
        this.alimtalk = new InsightsAlimtalkService(transport);
        this.brandMessage = new InsightsBrandMessageService(transport);
        this.rcs = new InsightsRcsService(transport);
    }

    /**
     * 채널별 인사이트(알림톡·브랜드메시지·RCS): {@code client.insights().alimtalk()}.
     *
     * @return the {@code insights.alimtalk} resource
     */
    public InsightsAlimtalkService alimtalk() {
        return alimtalk;
    }

    /**
     * 채널별 인사이트(알림톡·브랜드메시지·RCS): {@code client.insights().brandMessage()}.
     *
     * @return the {@code insights.brandMessage} resource
     */
    public InsightsBrandMessageService brandMessage() {
        return brandMessage;
    }

    /**
     * 채널별 인사이트(알림톡·브랜드메시지·RCS): {@code client.insights().rcs()}.
     *
     * @return the {@code insights.rcs} resource
     */
    public InsightsRcsService rcs() {
        return rcs;
    }

    @Override
    public String toString() {
        return "InsightsService";
    }
}
