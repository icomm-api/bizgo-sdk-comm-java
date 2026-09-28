package io.github.icommapi.bizgo.errors;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The response was not what the API reference documents: not the {@code {common, data}} JSON envelope, a redirect,
 * or a body that does not fit the response model. For a send the message says that the request may have been
 * accepted anyway: check with the status APIs before sending again.
 */
public class InvalidResponseException extends BizgoException {

    private static final long serialVersionUID = 2L;

    private final int httpStatus;
    private final String trackingId;
    /** Kept across Java serialization as JSON text. */
    private transient JsonNode body;

    /**
     * Creates an exception.
     *
     * @param message what was wrong (without the body)
     * @param httpStatus HTTP status of the response
     */
    public InvalidResponseException(String message, int httpStatus) {
        this(message, httpStatus, null, null);
    }

    /**
     * Creates an exception.
     *
     * @param message what was wrong (without the body)
     * @param httpStatus HTTP status of the response
     * @param trackingId {@code common.infobankTrId}, may be null
     * @param body parsed response body, may be null
     */
    public InvalidResponseException(String message, int httpStatus, String trackingId, JsonNode body) {
        super(message);
        this.httpStatus = httpStatus;
        this.trackingId = trackingId;
        this.body = body;
    }

    /**
     * HTTP status of the response.
     *
     * @return status code
     */
    public int getHttpStatus() {
        return httpStatus;
    }

    /**
     * {@code common.infobankTrId} of the response, for support inquiries.
     *
     * @return tracking id, or null
     */
    public String getTrackingId() {
        return trackingId;
    }

    /**
     * The parsed response body. It can contain phone numbers: do not log it as is.
     *
     * @return body, or null if it was not JSON
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
