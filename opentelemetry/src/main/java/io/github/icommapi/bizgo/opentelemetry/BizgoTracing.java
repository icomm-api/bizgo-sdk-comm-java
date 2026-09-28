package io.github.icommapi.bizgo.opentelemetry;

import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.RequestEvent;
import io.github.icommapi.bizgo.RequestHook;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;

/**
 * Creates an OpenTelemetry client span for every Bizgo API call.
 *
 * <pre>{@code
 * Bizgo client = Bizgo.builder()
 *         .hook(BizgoTracing.create(GlobalOpenTelemetry.get()))
 *         .build();
 * }</pre>
 *
 * <p>Span name {@code bizgo <resource>.<method>} (for example {@code bizgo alimtalk.templates.list}), kind CLIENT,
 * attributes {@code http.request.method}, {@code url.template}, {@code http.response.status_code},
 * {@code bizgo.operation_id}, {@code bizgo.code}, {@code bizgo.layer}, {@code bizgo.retry_count} and
 * {@code error.type}. Like every {@link RequestHook}, it never records bodies, query strings, header values, path
 * values, phone numbers or the API key. No trace headers are sent to Bizgo.
 */
public final class BizgoTracing implements RequestHook {

    /** Instrumentation scope name. */
    public static final String INSTRUMENTATION_NAME = "io.github.icommapi.bizgo";

    static final AttributeKey<String> HTTP_METHOD = AttributeKey.stringKey("http.request.method");
    static final AttributeKey<String> URL_TEMPLATE = AttributeKey.stringKey("url.template");
    static final AttributeKey<Long> STATUS = AttributeKey.longKey("http.response.status_code");
    static final AttributeKey<String> OPERATION = AttributeKey.stringKey("bizgo.operation_id");
    static final AttributeKey<String> CODE = AttributeKey.stringKey("bizgo.code");
    static final AttributeKey<String> LAYER = AttributeKey.stringKey("bizgo.layer");
    static final AttributeKey<Long> RETRIES = AttributeKey.longKey("bizgo.retry_count");
    static final AttributeKey<String> ERROR_TYPE = AttributeKey.stringKey("error.type");

    private final Tracer tracer;
    private final Object key = new Object();

    private BizgoTracing(Tracer tracer) {
        this.tracer = tracer;
    }

    /**
     * Creates the hook.
     *
     * @param openTelemetry your OpenTelemetry instance
     * @return the hook
     */
    public static BizgoTracing create(OpenTelemetry openTelemetry) {
        if (openTelemetry == null) {
            throw new IllegalArgumentException("openTelemetry is null");
        }
        return new BizgoTracing(openTelemetry.getTracer(INSTRUMENTATION_NAME, Bizgo.VERSION));
    }

    @Override
    public void onRequestStart(RequestEvent event) {
        Span span = tracer.spanBuilder("bizgo " + event.getResourceMethod())
                .setSpanKind(SpanKind.CLIENT)
                .setAttribute(HTTP_METHOD, event.getHttpMethod())
                .setAttribute(URL_TEMPLATE, event.getPathTemplate())
                .setAttribute(OPERATION, event.getOperationId())
                .startSpan();
        event.putContext(key, span);
    }

    @Override
    public void onRequestEnd(RequestEvent event) {
        Object value = event.getContext(key);
        if (!(value instanceof Span)) {
            return;
        }
        Span span = (Span) value;
        if (event.getStatus() != null) {
            span.setAttribute(STATUS, (long) event.getStatus());
        }
        if (event.getErrorCode() != null) {
            span.setAttribute(CODE, event.getErrorCode());
        }
        if (event.getErrorLayer() != null) {
            span.setAttribute(LAYER, event.getErrorLayer().name().toLowerCase(java.util.Locale.ROOT));
        }
        span.setAttribute(RETRIES, (long) Math.max(0, event.getAttempts() - 1));
        if (!event.isSuccess()) {
            span.setAttribute(ERROR_TYPE, event.getErrorType());
            span.setStatus(StatusCode.ERROR, event.getErrorType());
        }
        span.end();
    }

    @Override
    public String toString() {
        return "BizgoTracing";
    }
}
