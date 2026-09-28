package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.github.icommapi.bizgo.errors.AuthenticationException;
import io.github.icommapi.bizgo.errors.BizgoException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.models.AlimtalkTemplate;
import io.github.icommapi.bizgo.models.BulkSendResult;
import io.github.icommapi.bizgo.models.CounselMessageWebhookPayload;
import io.github.icommapi.bizgo.models.Destination;
import io.github.icommapi.bizgo.models.ReportWebhookPayload;
import io.github.icommapi.bizgo.models.Reservation;
import io.github.icommapi.bizgo.models.ReservationCreateRequest;
import io.github.icommapi.bizgo.models.ReservationCreateServiceResult;
import io.github.icommapi.bizgo.models.ReservationMessageFlowItem;
import io.github.icommapi.bizgo.models.SendOmniResult;
import io.github.icommapi.bizgo.models.SmsMessage;
import io.github.icommapi.bizgo.params.ListAlimtalkTemplatesParams;
import io.github.icommapi.bizgo.testing.FakeTransport;
import io.github.icommapi.bizgo.testing.RecordedRequest;
import io.github.icommapi.bizgo.testing.WebhookSigner;
import io.github.icommapi.bizgo.webhooks.WebhookReceiver;
import io.github.icommapi.bizgo.webhooks.Webhooks;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** The code of the README sections "전체 API", "대량 발송", "속도 제한", "테스트", "관측", run against the fake. */
class ReadmeSnippetsTest {

    @Test
    void fullApi() {
        FakeTransport fake = new FakeTransport();
        fake.on("listAlimtalkTemplates").thenData("{\"alimtalk\":{\"templates\":[{\"templateCode\":\"T1\"}]}}")
                .thenData("{\"alimtalk\":{\"templates\":[]}}");
        try (Bizgo client = fake.client()) {
            List<String> seen = new ArrayList<>();
            for (AlimtalkTemplate t : client.alimtalk().templates().iterList(
                    ListAlimtalkTemplatesParams.builder().senderKey("SENDER_KEY_EXAMPLE").limit(100).build())) {
                seen.add(t.getTemplateCode() + " " + t.getInspectionStatus());
            }
            assertEquals(List.of("T1 null"), seen);

            ReservationCreateServiceResult accepted = client.reservations().create(ReservationCreateRequest.builder()
                    .destinations(Destination.builder().to("01000000000").build())
                    .messageFlow(ReservationMessageFlowItem.of(
                            SmsMessage.builder().from("01000000000").text("예약 안내").build()))
                    .resvSendTime("2026-12-31 09:00:00")
                    .build());
            assertNotNull(accepted.getResvKey());
            assertEquals(1, accepted.getData().getDestinations().size());
            Reservation cancelled = client.reservations().cancel("RESV_KEY_EXAMPLE");
            assertNotNull(cancelled);

            client.alimtalk().templates().delete("SENDER_KEY_EXAMPLE", "TEMPLATE_CODE_EXAMPLE");
        }
        assertEquals("/api/comm/v1/reservation/resvKey/RESV_KEY_EXAMPLE/cancel",
                fake.requests("cancelReservation").get(0).getPath());
    }

    @Test
    void counselWebhook() {
        WebhookSigner.SignedWebhook request = WebhookSigner.unsigned("{\"msgKey\":\"CS1\"}");
        byte[] rawBody = request.body();
        CounselMessageWebhookPayload message = WebhookReceiver.parseCounselMessage(rawBody);
        assertEquals("CS1", message.getMsgKey());
        assertEquals("{\"code\":\"A000\",\"result\":\"Success\"}", Webhooks.counselAckJson());
    }

    @Test
    void bulk() {
        FakeTransport fake = new FakeTransport();
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            numbers.add("01000000000");
        }
        SmsMessage sms = SmsMessage.builder().from("01000000000").text("hello").build();
        List<String> retried = new ArrayList<>();
        try (Bizgo client = fake.client()) {
            BulkSendResult result = client.send().bulk(numbers, List.of(sms),
                    BulkOptions.builder()
                            .idempotencyKeyPrefix("campaign-20260923")
                            .concurrency(4)
                            .build());
            assertEquals(250, result.getSucceeded().size());
            for (BulkSendResult.ChunkError e : result.getErrors()) {
                retryLater(numbers.subList(e.fromIndex(), e.toIndex()), e.error(), retried);
            }
        }
        assertEquals(List.of(), retried);
    }

    private static void retryLater(List<String> numbers, BizgoException error, List<String> out) {
        out.addAll(numbers);
    }

    @Test
    void rateLimitConfiguration() {
        FakeTransport fake = new FakeTransport();
        Bizgo.builder().apiKey("test-api-key-not-real").httpTransport(fake).rateLimit(RateLimit.of(100, 5)).build()
                .close();
        Bizgo.builder().apiKey("test-api-key-not-real").httpTransport(fake).rateLimit(null).build().close();
    }

    @Test
    void testingSection() {
        FakeTransport fake = new FakeTransport();
        Bizgo client = fake.client();
        client.send().sms("01000000000", "01000000000", "hello");
        RecordedRequest request = fake.lastRequest();
        assertEquals("sendOmni", request.getOperationId());
        assertEquals("hello", request.getJsonBody().at("/messageFlow/0/sms/text").asText());

        fake.on("sendOmni")
                .thenFail(ErrorLayer.SERVICE, 429, "A020")
                .thenSendResult("A000", "A306");
        fake.on("getReportPolling").thenFail(ErrorLayer.GATEWAY, 401, "A401");
        fake.on("listReservations").thenData("{\"reservations\":[],\"hasNext\":false}");
        assertEquals(1, client.send().sms(List.of("01000000000", "01000001234"), "01000000000", "hi", null)
                .getFailed().size());
        assertThrows(AuthenticationException.class, () -> client.reports().poll());

        WebhookSigner.SignedWebhook hook = WebhookSigner.sign("test-webhook-secret", "{\"msgKey\":\"K001\"}");
        ReportWebhookPayload report = new WebhookReceiver("test-webhook-secret").report(hook.headers(), hook.body());
        assertEquals("K001", report.getMsgKey());
        client.close();
    }

    @Test
    void observability() {
        FakeTransport fake = new FakeTransport();
        List<String> metrics = new ArrayList<>();
        Bizgo client = fake.clientBuilder()
                .hook(new RequestHook() {
                    @Override
                    public void onRequestEnd(RequestEvent e) {
                        record(metrics, e.getOperationId(), e.getStatus(), e.getErrorCode(), e.getAttempts(),
                                e.getDuration());
                    }
                })
                .build();
        client.reports().poll();
        client.close();
        assertEquals(List.of("getReportPolling 200 null 1"), metrics);
    }

    private static void record(List<String> out, String op, Integer status, String code, int attempts,
            Duration duration) {
        out.add(op + " " + status + " " + code + " " + attempts);
    }
}
