package io.github.icommapi.bizgo.errors;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringJoiner;

/**
 * Bizgo answered with a failure.
 *
 * <p>{@link #getMessage()} looks like
 * {@code HTTP 400 | service code=A306 | Failed | <description> | infobankTrId=...}.
 * Give the {@linkplain #getTrackingId() tracking id} to Bizgo support when you ask about a request.
 */
public class ApiException extends BizgoException {

    private static final long serialVersionUID = 1L;

    private final int httpStatus;
    private final String code;
    private final String serverMessage;
    private final ErrorLayer layer;
    private final String trackingId;
    private final String description;
    /** Kept across Java serialization as JSON text (see {@link #writeObject}). */
    private transient JsonNode body;

    /**
     * Creates an exception.
     *
     * @param serverMessage {@code authResult} / {@code result} text from the server
     * @param httpStatus HTTP status code
     * @param code {@code common.authCode} (gateway) or {@code data.code} (service), may be null
     * @param layer which layer failed
     * @param trackingId {@code common.infobankTrId}, may be null
     * @param body parsed response body, may be null
     */
    public ApiException(String serverMessage, int httpStatus, String code, ErrorLayer layer, String trackingId,
            JsonNode body) {
        super(format(serverMessage, httpStatus, code, layer, trackingId));
        this.httpStatus = httpStatus;
        this.code = code;
        this.serverMessage = serverMessage;
        this.layer = layer;
        this.trackingId = trackingId;
        this.body = body;
        this.description = describe(code, layer);
    }

    private static String describe(String code, ErrorLayer layer) {
        if (layer != ErrorLayer.SERVICE) {
            return null;
        }
        return ServiceCodes.lookup(code).map(ServiceCodes.Code::description).orElse(null);
    }

    private static String format(String serverMessage, int httpStatus, String code, ErrorLayer layer,
            String trackingId) {
        StringJoiner parts = new StringJoiner(" | ");
        parts.add("HTTP " + httpStatus);
        parts.add(layer + " code=" + code);
        if (serverMessage != null && !serverMessage.isEmpty()) {
            parts.add(serverMessage);
        }
        String description = describe(code, layer);
        if (description != null && !description.equals(serverMessage)) {
            parts.add(description);
        }
        if (trackingId != null && !trackingId.isEmpty()) {
            parts.add("infobankTrId=" + trackingId);
        }
        return parts.toString();
    }

    /**
     * HTTP status code of the response.
     *
     * @return status, for example 400
     */
    public int getHttpStatus() {
        return httpStatus;
    }

    /**
     * {@code common.authCode} for the gateway layer or {@code data.code} for the service layer.
     *
     * @return code such as {@code A401}, or null if the response had none
     */
    public String getCode() {
        return code;
    }

    /**
     * {@code authResult} / {@code result} text from the server.
     *
     * @return server message, may be empty
     */
    public String getServerMessage() {
        return serverMessage;
    }

    /**
     * Which layer rejected the request.
     *
     * @return gateway or service
     */
    public ErrorLayer getLayer() {
        return layer;
    }

    /**
     * {@code common.infobankTrId}.
     *
     * @return tracking id for support inquiries, or null
     */
    public String getTrackingId() {
        return trackingId;
    }

    /**
     * Korean description of a service-layer code from the error code table ({@link ServiceCodes}).
     *
     * @return description, or null if unknown or not a service-layer error
     */
    public String getDescription() {
        return description;
    }

    /**
     * The parsed response body. It can contain phone numbers: do not log it as is.
     *
     * @return body, or null if it was not JSON (kept when the exception is serialized)
     */
    public JsonNode getBody() {
        return body;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(BodyCodec.encode(body));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        body = BodyCodec.decode((String) in.readObject());
    }
}
