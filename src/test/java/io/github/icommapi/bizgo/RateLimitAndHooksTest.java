package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.BadRequestException;
import io.github.icommapi.bizgo.errors.ConfigurationException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.models.ReservationCreateRequest;
import io.github.icommapi.bizgo.models.ReservationMessageFlowItem;
import io.github.icommapi.bizgo.models.SmsMessage;
import io.github.icommapi.bizgo.models.Destination;
import io.github.icommapi.bizgo.params.GetAlimtalkTemplateParams;
import io.github.icommapi.bizgo.testing.FakeTransport;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Test;

class RateLimitAndHooksTest {

    /** A fake monotonic clock: sleeping advances it. */
    private final AtomicLong now = new AtomicLong(1_000_000_000L);
    private final List<Duration> waits = new CopyOnWriteArrayList<>();

    private Bizgo.Builder limited(FakeTransport fake, RateLimit limit) {
        return fake.clientBuilder().rateLimit(limit).nanoClock(now::get).sleeper(d -> {
            waits.add(d);
            now.addAndGet(d.toNanos());
        });
    }

    @Test
    void otherBucketAllowsABurstThenWaits() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = limited(fake, RateLimit.DEFAULT).build()) {
            for (int i = 0; i < 5; i++) {
                client.reports().poll();
            }
            assertTrue(waits.isEmpty(), "burst of 5 without waiting");
            client.reports().poll();
            assertEquals(1, waits.size());
            assertEquals(200, waits.get(0).toMillis(), "1/5 s for the next token");
            now.addAndGet(Duration.ofSeconds(10).toNanos());
            client.reports().poll();
            assertEquals(1, waits.size(), "refilled after a pause");
        }
    }

    @Test
    void canBeTurnedOff() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = limited(fake, null).build()) {
            for (int i = 0; i < 50; i++) {
                client.reports().poll();
            }
        }
        assertTrue(waits.isEmpty());
        assertThrows(ConfigurationException.class, () -> RateLimit.of(0, 5));
        assertThrows(ConfigurationException.class, () -> RateLimit.of(10, Double.NaN));
    }

    // ------------------------------------------------------------------ hooks

    static final class Recorder implements RequestHook {
        final List<RequestEvent> started = new CopyOnWriteArrayList<>();
        final List<RequestEvent> ended = new CopyOnWriteArrayList<>();

        @Override
        public void onRequestStart(RequestEvent event) {
            started.add(event);
            event.putContext(this, "span");
        }

        @Override
        public void onRequestEnd(RequestEvent event) {
            ended.add(event);
        }
    }

    @Test
    void hooksSeeTemplatesNotValues() {
        FakeTransport fake = new FakeTransport();
        Recorder recorder = new Recorder();
        try (Bizgo client = fake.clientBuilder().hook(recorder).build()) {
            client.reports().inquiry("MSGKEY-VALUE-123");
            client.alimtalk().templates().get(GetAlimtalkTemplateParams.builder()
                    .senderKey("SENDER_KEY_EXAMPLE").templateCode("TPL_SECRET").build());
            client.send().sms("01000001234", "01000000000", "private text");
        }
        assertEquals(3, recorder.started.size());
        assertEquals(3, recorder.ended.size());
        RequestEvent inquiry = recorder.ended.get(0);
        assertSame(recorder.started.get(0), inquiry);
        assertEquals("span", inquiry.getContext(recorder));
        assertEquals("getReportInquiry", inquiry.getOperationId());
        assertEquals("reports.inquiry", inquiry.getResourceMethod());
        assertEquals("GET", inquiry.getHttpMethod());
        assertEquals("/api/comm/v1/report/inquiry/{msgKey}", inquiry.getPathTemplate());
        assertEquals(200, inquiry.getStatus());
        assertEquals(1, inquiry.getAttempts());
        assertTrue(inquiry.isSuccess());
        assertNull(inquiry.getErrorCode());
        assertEquals("send.omni", recorder.ended.get(2).getResourceMethod());
        for (RequestEvent event : recorder.ended) {
            String text = event.toString();
            for (String secret : List.of("MSGKEY-VALUE-123", "SENDER_KEY_EXAMPLE", "TPL_SECRET", "01000001234",
                    "private text", FakeTransport.FAKE_API_KEY)) {
                assertFalse(text.contains(secret), text);
            }
        }
    }

    @Test
    void hooksSeeErrorsAndRetries() {
        FakeTransport fake = new FakeTransport();
        fake.on("getReportPolling").thenFail(ErrorLayer.GATEWAY, 503, "A503").thenFail(ErrorLayer.SERVICE, 200, "A306");
        Recorder recorder = new Recorder();
        try (Bizgo client = fake.clientBuilder().maxRetries(1).sleeper(d -> { }).hook(recorder).build()) {
            assertThrows(BadRequestException.class, () -> client.reports().poll());
        }
        RequestEvent event = recorder.ended.get(0);
        assertEquals(2, event.getAttempts());
        assertEquals(200, event.getStatus());
        assertEquals(ErrorLayer.SERVICE, event.getErrorLayer());
        assertEquals("A306", event.getErrorCode());
        assertEquals("BadRequestException", event.getErrorType());
        assertFalse(event.isSuccess());
    }

    @Test
    void aFailingHookDoesNotBreakTheCall() {
        FakeTransport fake = new FakeTransport();
        RequestHook broken = new RequestHook() {
            @Override
            public void onRequestStart(RequestEvent event) {
                throw new IllegalStateException("boom");
            }

            @Override
            public void onRequestEnd(RequestEvent event) {
                throw new IllegalStateException("boom");
            }
        };
        try (Bizgo client = fake.clientBuilder().hook(broken).build()) {
            assertDoesNotThrow(() -> client.reports().poll());
        }
        assertThrows(ConfigurationException.class, () -> Bizgo.builder().hook(null));
    }

    @Test
    void customTransportCannotBeCombinedWithHttpClient() {
        assertThrows(ConfigurationException.class, () -> Bizgo.builder().apiKey("test-api-key-not-real")
                .httpTransport(new FakeTransport()).httpClient(java.net.http.HttpClient.newBuilder().build()).build());
    }
}
