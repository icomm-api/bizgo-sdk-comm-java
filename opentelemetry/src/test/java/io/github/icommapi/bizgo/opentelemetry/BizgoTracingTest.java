package io.github.icommapi.bizgo.opentelemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.errors.BadRequestException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.params.ListAlimtalkTemplatesParams;
import io.github.icommapi.bizgo.testing.FakeTransport;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.util.List;
import org.junit.jupiter.api.Test;

class BizgoTracingTest {

    private final InMemorySpanExporter exporter = InMemorySpanExporter.create();
    private final OpenTelemetrySdk otel = OpenTelemetrySdk.builder()
            .setTracerProvider(SdkTracerProvider.builder().addSpanProcessor(SimpleSpanProcessor.create(exporter)).build())
            .build();

    @Test
    void spanPerCallWithTemplateAndNoValues() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.clientBuilder().hook(BizgoTracing.create(otel)).build()) {
            client.reports().inquiry("MSGKEY-SECRET-VALUE");
            client.alimtalk().templates().list(ListAlimtalkTemplatesParams.builder()
                    .senderKey("SENDER_KEY_EXAMPLE").build());
            client.send().sms("01000000000", "01000001234", "hello");
        }
        List<SpanData> spans = exporter.getFinishedSpanItems();
        assertEquals(3, spans.size());
        SpanData inquiry = spans.get(0);
        assertEquals("bizgo reports.inquiry", inquiry.getName());
        assertEquals(SpanKind.CLIENT, inquiry.getKind());
        assertEquals("/api/comm/v1/report/inquiry/{msgKey}", inquiry.getAttributes().get(BizgoTracing.URL_TEMPLATE));
        assertEquals("GET", inquiry.getAttributes().get(BizgoTracing.HTTP_METHOD));
        assertEquals(200L, inquiry.getAttributes().get(BizgoTracing.STATUS));
        assertEquals(0L, inquiry.getAttributes().get(BizgoTracing.RETRIES));
        assertEquals("bizgo alimtalk.templates.list", spans.get(1).getName());
        assertEquals("bizgo send.omni", spans.get(2).getName());
        for (SpanData span : spans) {
            String all = span.toString();
            assertFalse(all.contains("MSGKEY-SECRET-VALUE"));
            assertFalse(all.contains("SENDER_KEY_EXAMPLE"));
            assertFalse(all.contains("01000000000"));
            assertFalse(all.contains(FakeTransport.FAKE_API_KEY));
        }
    }

    @Test
    void errorsAndRetriesAreRecorded() {
        FakeTransport fake = new FakeTransport();
        fake.on("getReportPolling").thenFail(ErrorLayer.GATEWAY, 503, "A503").thenFail(ErrorLayer.SERVICE, 200, "A306");
        try (Bizgo client = fake.clientBuilder().maxRetries(1).hook(BizgoTracing.create(otel)).build()) {
            assertThrows(BadRequestException.class, () -> client.reports().poll());
        }
        SpanData span = exporter.getFinishedSpanItems().get(0);
        assertEquals(StatusCode.ERROR, span.getStatus().getStatusCode());
        assertEquals("A306", span.getAttributes().get(BizgoTracing.CODE));
        assertEquals("service", span.getAttributes().get(BizgoTracing.LAYER));
        assertEquals(1L, span.getAttributes().get(BizgoTracing.RETRIES));
        assertEquals("BadRequestException", span.getAttributes().get(BizgoTracing.ERROR_TYPE));
    }
}
