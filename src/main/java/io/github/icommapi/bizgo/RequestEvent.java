package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ErrorLayer;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * One API call as seen by a {@link RequestHook}. It carries no request values: no body, query, header values, path
 * values, phone numbers or API key. Only {@link #getPathTemplate()} (for example
 * {@code /api/comm/v1/report/inquiry/{msgKey}}) identifies the endpoint.
 *
 * <p>Hooks can keep per-call state (for example a tracing span) with {@link #putContext(Object, Object)}.
 */
public final class RequestEvent {

    private final Operation operation;
    private final Map<Object, Object> context = new ConcurrentHashMap<>();
    private volatile Integer status;
    private volatile ErrorLayer errorLayer;
    private volatile String errorCode;
    private volatile String errorType;
    private volatile int attempts;
    private volatile Duration duration = Duration.ZERO;
    private volatile boolean finished;

    RequestEvent(Operation operation) {
        this.operation = operation;
    }

    void finish(Integer status, ErrorLayer layer, String code, String errorType, int attempts, Duration duration) {
        this.status = status;
        this.errorLayer = layer;
        this.errorCode = code;
        this.errorType = errorType;
        this.attempts = attempts;
        this.duration = duration;
        this.finished = true;
    }

    /**
     * The operation.
     *
     * @return operation metadata
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * {@code operationId}, for example {@code sendOmni}.
     *
     * @return operation id
     */
    public String getOperationId() {
        return operation.getOperationId();
    }

    /**
     * {@code resource.method}, for example {@code alimtalk.templates.list}.
     *
     * @return resource and method
     */
    public String getResourceMethod() {
        return operation.getResourceMethod();
    }

    /**
     * HTTP method.
     *
     * @return method
     */
    public String getHttpMethod() {
        return operation.getHttpMethod();
    }

    /**
     * Path template, never the actual path.
     *
     * @return template
     */
    public String getPathTemplate() {
        return operation.getPathTemplate();
    }

    /**
     * HTTP status of the last attempt.
     *
     * @return status, or null for a network error, a timeout, or before the end
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Where an API error came from.
     *
     * @return {@code GATEWAY} or {@code SERVICE}; null on success or for non-API errors
     */
    public ErrorLayer getErrorLayer() {
        return errorLayer;
    }

    /**
     * Result code of an API error, for example {@code A020} or {@code A306}.
     *
     * @return code, or null
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Simple class name of the exception the call ended with.
     *
     * @return for example {@code RateLimitException}; null on success
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * True if the call returned normally.
     *
     * @return success
     */
    public boolean isSuccess() {
        return finished && errorType == null;
    }

    /**
     * Number of HTTP attempts (1 without retries).
     *
     * @return attempts
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * Time from the start of the first attempt to the end of the last (including rate-limit and retry waits).
     *
     * @return duration
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Stores per-call state for a hook.
     *
     * @param key key (use an object your hook owns)
     * @param value value
     */
    public void putContext(Object key, Object value) {
        if (key != null && value != null) {
            context.put(key, value);
        }
    }

    /**
     * Reads per-call state stored with {@link #putContext(Object, Object)}.
     *
     * @param key key
     * @return value, or null
     */
    public Object getContext(Object key) {
        return key == null ? null : context.get(key);
    }

    @Override
    public String toString() {
        return "RequestEvent{" + getResourceMethod() + " " + getHttpMethod() + " " + getPathTemplate() + ", status="
                + status + ", layer=" + errorLayer + ", code=" + errorCode + ", attempts=" + attempts + ", duration="
                + duration.toMillis() + "ms}";
    }
}
