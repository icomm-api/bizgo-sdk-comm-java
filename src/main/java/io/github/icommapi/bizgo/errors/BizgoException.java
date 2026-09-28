package io.github.icommapi.bizgo.errors;

/**
 * Base class of every exception thrown by this SDK. It is unchecked.
 *
 * <p>Messages never contain the API key, request bodies or phone numbers.
 */
public class BizgoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception.
     *
     * @param message message without secrets or personal data
     */
    public BizgoException(String message) {
        super(message);
    }
}
