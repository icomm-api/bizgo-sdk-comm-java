package io.github.icommapi.bizgo.errors;

/**
 * The request failed before a response arrived.
 *
 * <p>For send requests the message may or may not have been accepted. Sending again can deliver it twice unless
 * you set an {@code idempotencyKey}. Check the result with {@code client.messages().status(msgKey)} or the
 * history API.
 *
 * <p>The underlying {@code IOException} is intentionally not attached as the cause: it can contain the request URL.
 */
public class ApiConnectionException extends BizgoException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception.
     *
     * @param message message without the URL
     */
    public ApiConnectionException(String message) {
        super(message);
    }
}
