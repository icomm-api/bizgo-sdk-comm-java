package io.github.icommapi.bizgo.errors;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * The API key is missing, wrong or expired (HTTP 401, {@code A401}, {@code A001}, {@code A002}, {@code A100}).
 * Check the key and that the calling server's public IP is registered in the console.
 */
public class AuthenticationException extends ApiException {

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
    public AuthenticationException(String serverMessage, int httpStatus, String code, ErrorLayer layer, String trackingId,
            JsonNode body) {
        super(serverMessage, httpStatus, code, layer, trackingId, body);
    }
}
