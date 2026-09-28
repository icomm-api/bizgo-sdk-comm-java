package io.github.icommapi.bizgo.errors;

import com.fasterxml.jackson.databind.JsonNode;
import java.time.Duration;
import java.util.Optional;

/**
 * Too many requests (HTTP 429 / {@code A020}), after the automatic retries. Default limits: 200 requests per second
 * for send APIs, 5 per second for the others.
 */
public class RateLimitException extends ApiException {

    private static final long serialVersionUID = 1L;

    private final Duration retryAfter;

    /**
     * Creates an exception.
     *
     * @param serverMessage server message
     * @param httpStatus HTTP status
     * @param code result code
     * @param layer layer
     * @param trackingId tracking id
     * @param body response body
     * @param retryAfter value of the {@code Retry-After} header, or null
     */
    public RateLimitException(String serverMessage, int httpStatus, String code, ErrorLayer layer, String trackingId,
            JsonNode body, Duration retryAfter) {
        super(serverMessage, httpStatus, code, layer, trackingId, body);
        this.retryAfter = retryAfter;
    }

    /**
     * How long the server asked to wait.
     *
     * @return the {@code Retry-After} value, if the server sent one
     */
    public Optional<Duration> getRetryAfter() {
        return Optional.ofNullable(retryAfter);
    }
}
