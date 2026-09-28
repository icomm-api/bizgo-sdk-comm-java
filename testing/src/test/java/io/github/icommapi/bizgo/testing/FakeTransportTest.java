package io.github.icommapi.bizgo.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.errors.ApiConnectionException;
import io.github.icommapi.bizgo.errors.ApiTimeoutException;
import io.github.icommapi.bizgo.errors.AuthenticationException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.errors.RateLimitException;
import io.github.icommapi.bizgo.models.ReportWebhookPayload;
import io.github.icommapi.bizgo.models.SendResult;
import io.github.icommapi.bizgo.webhooks.WebhookReceiver;
import java.util.List;
import org.junit.jupiter.api.Test;

class FakeTransportTest {

    @Test
    void defaultSendAcceptsEveryRecipient() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            SendResult result = client.send().sms(List.of("01000000000", "01000001234"), "01000000000", "hello",
                    null);
            assertEquals(2, result.getSucceeded().size());
            assertEquals(List.of("FAKE-MSGKEY-000001", "FAKE-MSGKEY-000002"), result.getMsgKeys());
        }
        RecordedRequest request = fake.lastRequest();
        assertEquals("sendOmni", request.getOperationId());
        assertEquals("POST", request.getMethod());
        assertEquals("/api/comm/v1/send/omni", request.getPath());
        assertEquals("hello", request.getJsonBody().at("/messageFlow/0/sms/text").asText());
        assertFalse(request.toString().contains("01000000000"));
    }

    @Test
    void errorsCanBeInjected() {
        FakeTransport fake = new FakeTransport();
        fake.on("sendOmni").thenFail(ErrorLayer.SERVICE, 429, "A020")
                .thenFail(ErrorLayer.GATEWAY, 401, "A401")
                .thenSendResult("A000", "A306")
                .thenNetworkError()
                .thenTimeout();
        try (Bizgo client = fake.clientBuilder().maxRetries(0).build()) {
            assertThrows(RateLimitException.class, () -> client.send().sms("01000000000", "01000000000", "a"));
            assertThrows(AuthenticationException.class, () -> client.send().sms("01000000000", "01000000000", "a"));
            SendResult partial = client.send().sms(List.of("01000000000", "01000001234"), "01000000000", "a", null);
            assertEquals("A306", partial.getFailed().get(0).getCode());
            assertThrows(ApiConnectionException.class, () -> client.send().sms("01000000000", "01000000000", "a"));
            assertThrows(ApiTimeoutException.class, () -> client.send().sms("01000000000", "01000000000", "a"));
            assertThrows(ApiTimeoutException.class, () -> client.send().sms("01000000000", "01000000000", "a"));
        }
        assertEquals(6, fake.requests("sendOmni").size());
    }

    @Test
    void rateLimitIsRetriedWithoutWaiting() {
        FakeTransport fake = new FakeTransport();
        fake.on("getReportPolling").thenFail(ErrorLayer.SERVICE, 429, "A020").thenDefault();
        try (Bizgo client = fake.client()) {
            assertTrue(client.reports().poll().isEmpty());
        }
        assertEquals(2, fake.requests().size());
    }

    @Test
    void stubsByMethodAndTemplateAndReset() {
        FakeTransport fake = new FakeTransport();
        fake.on("GET", "/api/comm/v1/report/inquiry/{msgKey}")
                .thenData("{\"report\":[{\"msgKey\":\"K001\",\"reportCode\":\"A000\"}]}");
        try (Bizgo client = fake.client()) {
            assertEquals("K001", client.reports().inquiry("K001").get(0).getMsgKey());
        }
        assertEquals("/api/comm/v1/report/inquiry/K001", fake.lastRequest().getPath());
        fake.reset();
        assertTrue(fake.requests().isEmpty());
        assertThrows(IllegalStateException.class, fake::lastRequest);
        assertThrows(IllegalArgumentException.class, () -> fake.on("noSuchOperation"));
    }

    @Test
    void queryAndMultipartAreRecorded() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            client.messages().statistics(java.time.LocalDate.of(2026, 1, 2));
            client.files().uploadMms(io.github.icommapi.bizgo.FileUpload.of(new byte[] {1, 2}, "a.jpg"));
        }
        assertEquals("20260102", fake.requests().get(0).getQuery().get("startDate"));
        RecordedRequest upload = fake.requests().get(1);
        assertNull(upload.getJsonBody());
        assertTrue(upload.getContentType().startsWith("multipart/form-data"));
        assertTrue(upload.getBodyText().contains("filename=\"a.jpg\""));
    }

    @Test
    void signedWebhooksVerify() {
        String secret = "test-webhook-secret-not-real";
        WebhookSigner.SignedWebhook hook = WebhookSigner.sign(secret, "{\"msgKey\":\"K001\"}");
        ReportWebhookPayload report = new WebhookReceiver(secret).report(hook.headers(), hook.body());
        assertEquals("K001", report.getMsgKey());
        assertFalse(hook.toString().contains(hook.headers().get("X-IB-Signature")));
        assertEquals(64, WebhookSigner.signature(secret, "1").length());
    }
}
