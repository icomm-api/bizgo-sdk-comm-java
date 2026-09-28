package io.github.icommapi.bizgo.errors;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * A request with the same {@code idempotencyKey} was already accepted (service code {@code A301}).
 * The message was not sent again.
 */
public class DuplicateRequestException extends ApiException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception. See {@link ApiException#ApiException(String, int, String, ErrorLayer, String, JsonNode)}.
     *
     * @param serverMessage server message
     * @param httpStatus HTTP status
     * @param code result code
     * @param layer layer
     * @param trackingId tracking id
     * @param body response body
     */
    public DuplicateRequestException(String serverMessage, int httpStatus, String code, ErrorLayer layer, String trackingId,
            JsonNode body) {
        this(serverMessage, httpStatus, code, layer, trackingId, body, false);
    }

    /**
     * Creates an exception.
     *
     * @param serverMessage server message
     * @param httpStatus HTTP status
     * @param code result code
     * @param layer layer
     * @param trackingId tracking id
     * @param body response body
     * @param alreadyAccepted true if the SDK retried the request and an earlier attempt was accepted
     */
    public DuplicateRequestException(String serverMessage, int httpStatus, String code, ErrorLayer layer, String trackingId,
            JsonNode body, boolean alreadyAccepted) {
        super(serverMessage, httpStatus, code, layer, trackingId, body);
        this.alreadyAccepted = alreadyAccepted;
    }

    private final boolean alreadyAccepted;

    /**
     * True when the SDK retried this request (after a network error, a 5xx or a 429) and the server answered
     * {@code A301}: an earlier attempt was most likely accepted, so the message is on its way and must not be sent
     * again. Confirm with the status APIs.
     *
     * @return whether an earlier attempt of this call was accepted
     */
    public boolean isAlreadyAccepted() {
        return alreadyAccepted;
    }
}
