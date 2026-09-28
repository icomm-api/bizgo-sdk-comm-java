package io.github.icommapi.bizgo.errors;

/** The client is configured incorrectly, for example the API key is missing or the base URL is not https. */
public class ConfigurationException extends BizgoException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception.
     *
     * @param message what is wrong
     */
    public ConfigurationException(String message) {
        super(message);
    }
}
