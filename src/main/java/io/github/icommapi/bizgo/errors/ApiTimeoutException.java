package io.github.icommapi.bizgo.errors;

/** The request timed out (connect timeout or total request timeout). */
public class ApiTimeoutException extends ApiConnectionException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception.
     *
     * @param message message without the URL
     */
    public ApiTimeoutException(String message) {
        super(message);
    }
}
