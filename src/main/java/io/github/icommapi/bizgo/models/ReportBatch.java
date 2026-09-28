package io.github.icommapi.bizgo.models;

import java.util.List;
import java.util.Objects;

/** One batch from report polling. Call {@code client.reports().ack(batch.getReportId())} after you stored it. */
public final class ReportBatch {

    private final String reportId;
    private final List<Report> reports;

    /**
     * Creates a batch.
     *
     * @param reportId id to acknowledge; empty when there are no reports
     * @param reports reports, may be null
     */
    public ReportBatch(String reportId, List<Report> reports) {
        this.reportId = reportId == null ? "" : reportId;
        this.reports = reports == null ? List.of() : List.copyOf(reports);
    }

    /**
     * Id for {@code client.reports().ack(...)}.
     *
     * @return report id, empty string when there were no reports
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * Reports in this batch.
     *
     * @return unmodifiable list
     */
    public List<Report> getReports() {
        return reports;
    }

    /**
     * Whether there was nothing new.
     *
     * @return true if the batch has no reports
     */
    public boolean isEmpty() {
        return reports.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ReportBatch && reportId.equals(((ReportBatch) o).reportId)
                && reports.equals(((ReportBatch) o).reports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, reports);
    }

    @Override
    public String toString() {
        return "ReportBatch{reportId=" + reportId + ", reports=" + reports.size() + "}";
    }
}
