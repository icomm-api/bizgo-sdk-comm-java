package io.github.icommapi.bizgo.testing;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.icommapi.bizgo.Operation;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * A request received by {@link FakeTransport}. Header values (including the API key) are not recorded.
 * {@link #toString()} shows the operation and the path template only.
 */
public final class RecordedRequest {

    private final Operation operation;
    private final String method;
    private final String path;
    private final Map<String, String> query;
    private final JsonNode jsonBody;
    private final String contentType;
    private final byte[] body;

    RecordedRequest(Operation operation, String method, String path, Map<String, String> query, JsonNode jsonBody,
            String contentType, byte[] body) {
        this.operation = operation;
        this.method = method;
        this.path = path;
        this.query = query;
        this.jsonBody = jsonBody;
        this.contentType = contentType;
        this.body = body;
    }

    /**
     * The matched operation.
     *
     * @return operation, or null if the path is not in the spec
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * The matched operation id.
     *
     * @return operation id, or null if the path is not in the spec
     */
    public String getOperationId() {
        return operation == null ? null : operation.getOperationId();
    }

    /**
     * HTTP method.
     *
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Raw (URL-encoded) path without the query.
     *
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * Decoded query parameters.
     *
     * @return unmodifiable map
     */
    public Map<String, String> getQuery() {
        return query;
    }

    /**
     * The JSON body.
     *
     * @return body, or null for a request without a JSON body (for example multipart)
     */
    public JsonNode getJsonBody() {
        return jsonBody == null ? null : jsonBody.deepCopy();
    }

    /**
     * Request content type.
     *
     * @return content type, or null without a body
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * The raw body as UTF-8 text (useful for multipart).
     *
     * @return body text, empty without a body
     */
    public String getBodyText() {
        return new String(body, StandardCharsets.UTF_8);
    }

    @Override
    public String toString() {
        return "RecordedRequest{" + (operation == null ? method + " <unknown path>" : operation.toString()) + "}";
    }
}
