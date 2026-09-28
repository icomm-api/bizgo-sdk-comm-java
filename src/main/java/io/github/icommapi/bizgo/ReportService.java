package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.models.ApiResponse;
import io.github.icommapi.bizgo.models.Report;
import io.github.icommapi.bizgo.models.ReportBatch;
import io.github.icommapi.bizgo.models.ReportInquiryResponse;
import io.github.icommapi.bizgo.models.ReportInquiryServiceResult;
import io.github.icommapi.bizgo.models.ReportPollingResponse;
import io.github.icommapi.bizgo.models.ReportPollingResult;
import io.github.icommapi.bizgo.models.ReportPollingServiceResult;
import java.util.List;
import java.util.function.Consumer;

/**
 * Delivery reports: {@code /api/comm/v1/report/*}. Access as {@code client.reports()}.
 *
 * <p>Pick one primary method per API key in the console: POLLING (this class) or WEBHOOK
 * ({@link io.github.icommapi.bizgo.webhooks.WebhookReceiver}). Use {@link #inquiry(String)} to fill gaps.
 */
public final class ReportService extends GeneratedReportService {

    private static final String POLLING = "/api/comm/v1/report/polling";

    private final Transport transport;

    ReportService(Transport transport) {
        super(transport);
        this.transport = transport;
    }

    /**
     * Fetches the next batch of reports. {@link ReportBatch#isEmpty()} is true when there is nothing new.
     *
     * <p>Call {@link #ack(String)} with {@link ReportBatch#getReportId()} after storing the batch; otherwise the same
     * reports are returned again. {@link #consume(Consumer)} does this for you.
     *
     * @return the batch
     */
    public ReportBatch poll() {
        return transport.call(Operations.GET_REPORT_POLLING, Retry.SAFE, POLLING, null, null,
                ReportPollingResponse.class, response -> {
                    ReportPollingServiceResult data = response.getData();
                    ReportPollingResult inner = data == null ? null : data.getData();
                    return inner == null ? new ReportBatch("", List.of())
                            : new ReportBatch(inner.getReportId(), inner.getReport());
                });
    }

    /**
     * Confirms receipt of a polled batch.
     *
     * @param reportId {@link ReportBatch#getReportId()}
     */
    public void ack(String reportId) {
        transport.call(Operations.ACK_REPORT_POLLING, Retry.SAFE, Operations.ACK_REPORT_POLLING.path(reportId), null, null,
                ApiResponse.class);
    }

    /**
     * Polls until no reports are left, calling {@code handler} for each batch and acknowledging it only if the handler
     * returns normally.
     *
     * <p>If the handler throws, the batch is not acknowledged and will be delivered again, so make the handler
     * idempotent (for example upsert by {@code msgKey}). The exception is rethrown.
     *
     * @param handler stores a batch of reports
     * @return number of reports handled
     */
    public int consume(Consumer<List<Report>> handler) {
        return consume(handler, Integer.MAX_VALUE);
    }

    /**
     * Same as {@link #consume(Consumer)} but stops after {@code maxBatches} batches.
     *
     * @param handler stores a batch of reports
     * @param maxBatches maximum number of batches to handle
     * @return number of reports handled
     */
    public int consume(Consumer<List<Report>> handler, int maxBatches) {
        Params.required("handler", handler);
        if (maxBatches < 0) {
            throw new ValidationException("maxBatches", "0 이상이어야 합니다");
        }
        int handled = 0;
        for (int batches = 0; batches < maxBatches; batches++) {
            ReportBatch batch = poll();
            if (batch.isEmpty()) {
                break;
            }
            handler.accept(batch.getReports());
            ack(batch.getReportId());
            handled += batch.getReports().size();
        }
        return handled;
    }

    /**
     * Looks up the reports of one message (up to 30 days old).
     *
     * @param msgKey message key
     * @return reports, empty if there are none
     */
    public List<Report> inquiry(String msgKey) {
        ReportInquiryResponse response = transport.call(Operations.GET_REPORT_INQUIRY, Retry.SAFE,
                Operations.GET_REPORT_INQUIRY.path(msgKey), null, null,
                ReportInquiryResponse.class);
        ReportInquiryServiceResult data = response.getData();
        if (data == null || data.getData() == null || data.getData().getReport() == null) {
            return List.of();
        }
        return data.getData().getReport();
    }

    @Override
    public String toString() {
        return "ReportService";
    }
}
