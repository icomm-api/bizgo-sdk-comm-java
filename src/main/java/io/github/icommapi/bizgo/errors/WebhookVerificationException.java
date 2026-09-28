package io.github.icommapi.bizgo.errors;

/** A webhook request failed the signature, timestamp or body checks. Answer it with HTTP 401. */
public class WebhookVerificationException extends BizgoException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception.
     *
     * @param message reason (never contains the secret)
     */
    public WebhookVerificationException(String message) {
        super(message);
    }
}
