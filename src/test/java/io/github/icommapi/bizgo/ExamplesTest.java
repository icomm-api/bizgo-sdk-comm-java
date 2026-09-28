package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import examples.MessageHistory;
import examples.PollReports;
import examples.SendAlimtalkFallback;
import examples.SendMms;
import examples.SendSms;
import examples.WebhookServer;
import io.github.icommapi.bizgo.webhooks.WebhookReceiver;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Runs every example against the mock server so the examples never drift from the SDK. */
class ExamplesTest extends TestSupport {

    @Test
    void sendSms() {
        MockServer.Route route = server.route("POST", "/api/comm/v1/send/omni")
                .reply(MockServer.json(200, accepted("A000")));
        assertEquals(List.of("KEY000"), SendSms.run(client, PHONE, PHONE).getMsgKeys());
        assertEquals("signup-otp", route.last().json().get("ref").asText());
    }

    @Test
    void sendAlimtalkFallback() {
        MockServer.Route route = server.route("POST", "/api/comm/v1/send/omni")
                .reply(MockServer.json(200, accepted("A000")));
        SendAlimtalkFallback.run(client, PHONE, PHONE, "SENDER_KEY_EXAMPLE", "TEMPLATE_CODE_EXAMPLE");
        JsonNode body = route.last().json();
        assertEquals("alimtalk", body.at("/messageFlow/0").fieldNames().next());
        assertEquals("sms", body.at("/messageFlow/1").fieldNames().next());
        assertTrue(body.get("idempotencyKey").asText().startsWith("order-"));
    }

    @Test
    void sendAlimtalkFallbackHandlesDuplicates() {
        server.route("POST", "/api/comm/v1/send/omni").reply(MockServer.json(200, envelope(null, "A301", null)));
        assertEquals(null, SendAlimtalkFallback.run(client, PHONE, PHONE, "SENDER_KEY_EXAMPLE",
                "TEMPLATE_CODE_EXAMPLE"));
    }

    @Test
    void sendMms() {
        server.route("POST", "/api/comm/v1/file/mms").reply(MockServer.json(200, envelope(Map.of("fileKey",
                "FILE_KEY_001"))));
        MockServer.Route route = server.route("POST", "/api/comm/v1/send/omni")
                .reply(MockServer.json(200, accepted("A000")));
        SendMms.run(client, PHONE, PHONE, new byte[] {(byte) 0xff, (byte) 0xd8});
        assertEquals("FILE_KEY_001", route.last().json().at("/messageFlow/0/mms/fileKey/0").asText());
    }

    @Test
    void pollReports() {
        Map<String, Object> empty = new HashMap<>();
        empty.put("reportId", "");
        empty.put("report", null);
        server.route("GET", "/api/comm/v1/report/polling").reply(
                MockServer.json(200, envelope(Map.of("reportId", "R1", "report",
                        List.of(Map.of("msgKey", "K001", "reportCode", "10000"))))),
                MockServer.json(200, envelope(empty)));
        server.route("DELETE", "/api/comm/v1/report/polling/R1").reply(MockServer.json(200, envelope(null)));
        assertEquals(1, PollReports.run(client));
        assertEquals("delivered", PollReports.STORE.get("K001"));
    }

    @Test
    void messageHistory() {
        server.route("GET", "/api/comm/v1/message/history").reply(MockServer.json(200, envelope(Map.of(
                "messages", List.of(Map.of("msgKey", "K001", "reportCode", "63020")), "hasNext", false))));
        MockServer.Route status = server.route("GET", "/api/comm/v1/message/inquiry/msgKey/K001").reply(
                MockServer.json(200, envelope(Map.of("messages", List.of(Map.of("msgKey", "K001",
                        "serviceType", "ALIMTALK", "reportCode", "63020"))))));
        assertEquals(1, MessageHistory.run(client).size());
        assertEquals(1, status.count());
    }

    @Test
    void webhookServer() throws Exception {
        WebhookReceiver receiver = new WebhookReceiver("test-webhook-secret");
        String timestamp = String.valueOf(System.currentTimeMillis());
        String signature = HexFormat.of().formatHex(WebhooksTest.sign(timestamp, "test-webhook-secret"));
        byte[] body = ("{\"msgKey\":\"K001\",\"serviceType\":\"SMS\",\"reportTime\":\"t\",\"reportType\":\"0\","
                + "\"reportCode\":\"10000\"}").getBytes(StandardCharsets.UTF_8);
        Map<String, List<String>> headers = Map.of("X-Ib-Timestamp", List.of(timestamp), "X-Ib-Signature",
                List.of(signature));
        WebhookServer.Reply ok = WebhookServer.handle(receiver, headers, body);
        assertEquals(200, ok.status());
        assertEquals("{\"msgKey\":\"K001\"}", ok.body());
        WebhookServer.Reply rejected = WebhookServer.handle(receiver,
                Map.of("X-Ib-Timestamp", List.of(timestamp), "X-Ib-Signature", List.of("0".repeat(64))), body);
        assertEquals(401, rejected.status());
        assertNotNull(rejected.body());
    }
}
