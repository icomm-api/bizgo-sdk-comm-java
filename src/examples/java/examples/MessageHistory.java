package examples;

import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.Environment;
import io.github.icommapi.bizgo.HistoryQuery;
import io.github.icommapi.bizgo.models.MessageStatus;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/** Walks the send history of the last hour, then looks up one message's status. */
public final class MessageHistory {

    private MessageHistory() {
    }

    public static List<MessageStatus> run(Bizgo client) {
        Instant since = Instant.now().minus(1, ChronoUnit.HOURS); // converted to KST automatically
        List<MessageStatus> failed = client.messages()
                .streamHistory(HistoryQuery.since(since).serviceTypes("SMS", "ALIMTALK")) // follows lastSeq
                .filter(m -> !"10000".equals(m.getReportCode()))
                .collect(Collectors.toList());
        System.out.println("최근 1시간 실패 " + failed.size() + "건");
        for (MessageStatus message : failed.subList(0, Math.min(1, failed.size()))) {
            // one entry per channel tried (fallback)
            for (MessageStatus step : client.messages().status(message.getMsgKey())) {
                System.out.println(step.getServiceType() + " " + step.getReportCode() + " " + step.getReportText());
            }
        }
        return failed;
    }

    public static void main(String[] args) {
        try (Bizgo client = Bizgo.builder().environment(Environment.SANDBOX).build()) {
            run(client);
        }
    }
}
