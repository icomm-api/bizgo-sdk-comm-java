package io.github.icommapi.bizgo.errors;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * The resource does not exist (HTTP 404, {@code A404}).
 */
public class NotFoundException extends ApiException {

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
    public NotFoundException(String serverMessage, int httpStatus, String code, ErrorLayer layer, String trackingId,
            JsonNode body) {
        super(serverMessage, httpStatus, code, layer, trackingId, body);
    }
}
