package examples;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import io.github.icommapi.bizgo.errors.WebhookVerificationException;
import io.github.icommapi.bizgo.models.ReportWebhookPayload;
import io.github.icommapi.bizgo.webhooks.WebhookReceiver;
import io.github.icommapi.bizgo.webhooks.Webhooks;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Receives delivery report webhooks with the JDK HTTP server.
 *
 * <p>Production checklist:
 * <ul>
 * <li>serve over HTTPS (put a TLS reverse proxy in front) and allow only the Bizgo webhook source IPs</li>
 * <li>answer within 5 seconds; do slow work asynchronously</li>
 * <li>deduplicate by msgKey (Bizgo retries up to 3 times)</li>
 * </ul>
 */
public final class WebhookServer {

    /** Stand-in for a persistent dedup store. */
    static final Set<String> SEEN = ConcurrentHashMap.newKeySet();

    private WebhookServer() {
    }

    /** HTTP status and JSON body to answer with. */
    public record Reply(int status, String body) {
    }

    /** Framework-independent handler, so it is easy to test and reuse. */
    public static Reply handle(WebhookReceiver receiver, Map<String, List<String>> headers, byte[] body) {
        ReportWebhookPayload report;
        try {
            report = receiver.report(headers, body);
        } catch (WebhookVerificationException e) {
            return new Reply(401, "{}");
        }
        if (SEEN.add(report.getMsgKey())) {
            // enqueue the report for processing here
        }
        return new Reply(200, Webhooks.ackJson(report.getMsgKey()));
    }

    public static void main(String[] args) throws IOException {
        WebhookReceiver receiver = new WebhookReceiver(Env.get("BIZGO_WEBHOOK_SECRET"));
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 8080), 0);
        server.createContext("/bizgo/report", exchange -> respond(exchange, receiver));
        server.start();
        System.out.println("listening on http://127.0.0.1:8080/bizgo/report");
    }

    private static void respond(HttpExchange exchange, WebhookReceiver receiver) throws IOException {
        byte[] body;
        try (InputStream in = exchange.getRequestBody()) {
            body = in.readNBytes(Webhooks.MAX_BODY_BYTES + 1); // bounded read
        }
        Reply reply = handle(receiver, exchange.getRequestHeaders(), body);
        byte[] out = reply.body().getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(reply.status(), out.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(out);
        }
    }
}
