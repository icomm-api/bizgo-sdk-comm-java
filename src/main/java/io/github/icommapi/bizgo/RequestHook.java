package io.github.icommapi.bizgo;

/**
 * Observes API calls, for metrics or tracing (the optional {@code bizgo-sdk-comm-java-opentelemetry} module is built
 * on it). Register with {@link Bizgo.Builder#hook(RequestHook)}.
 *
 * <p>A hook sees the operation, the HTTP method, the <em>path template</em>, the status, the error layer and code,
 * the number of attempts and the duration. It never sees request or response bodies, query strings, header
 * values, path values, phone numbers or the API key. One call (including its retries) produces one
 * {@link #onRequestStart} and one {@link #onRequestEnd} with the same {@link RequestEvent}, on the calling thread.
 *
 * <p>Exceptions thrown by a hook are ignored so that observability cannot break sending. Keep hooks fast.
 *
 * <pre>{@code
 * Bizgo client = Bizgo.builder()
 *         .hook(new RequestHook() {
 *             public void onRequestEnd(RequestEvent e) {
 *                 metrics.timer("bizgo", "op", e.getOperationId(), "status", String.valueOf(e.getStatus()))
 *                         .record(e.getDuration());
 *             }
 *         })
 *         .build();
 * }</pre>
 */
public interface RequestHook {

    /**
     * Called before the first attempt of a call.
     *
     * @param event the call; only the operation fields are set
     */
    default void onRequestStart(RequestEvent event) {
    }

    /**
     * Called after the call finished (successfully or not), after all retries.
     *
     * @param event the call with status, error, attempts and duration set
     */
    default void onRequestEnd(RequestEvent event) {
    }
}
