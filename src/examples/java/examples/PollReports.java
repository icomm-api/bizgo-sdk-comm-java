package examples;

import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.Environment;
import io.github.icommapi.bizgo.models.Report;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Processes delivery reports with polling (the API key must be set to POLLING in the console). */
public final class PollReports {

    /** Stand-in for your database. */
    public static final Map<String, String> STORE = new ConcurrentHashMap<>();

    private PollReports() {
    }

    static void save(List<Report> reports) {
        for (Report report : reports) {
            // upsert by msgKey: a batch is delivered again if this method throws before the ack
            String status = "10000".equals(report.getReportCode()) ? "delivered" : "failed:" + report.getReportCode();
            STORE.put(report.getMsgKey(), status);
        }
    }

    public static int run(Bizgo client) {
        int handled = client.reports().consume(PollReports::save); // polls, saves, acks only after save() succeeded
        System.out.println("리포트 " + handled + "건 처리");
        return handled;
    }

    public static void main(String[] args) {
        try (Bizgo client = Bizgo.builder().environment(Environment.SANDBOX).build()) {
            run(client);
        }
    }
}
