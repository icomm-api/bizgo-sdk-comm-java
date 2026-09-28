package io.github.icommapi.bizgo.errors;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * The key is valid but not allowed to do this (HTTP 403, {@code A403}, {@code A110}, {@code A111}), for example a blocked account.
 */
public class PermissionDeniedException extends ApiException {

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
    public PermissionDeniedException(String serverMessage, int httpStatus, String code, ErrorLayer layer, String trackingId,
            JsonNode body) {
        super(serverMessage, httpStatus, code, layer, trackingId, body);
    }
}
