package io.github.icommapi.bizgo.errors;

import io.github.icommapi.bizgo.models.BulkSendResult;

/**
 * {@code send().bulk(...)} stopped because of a fatal {@link Error} in a chunk or an interrupt. The chunks that were
 * accepted before are not lost: see {@link #getPartialResult()}. Chunks with an unknown outcome are in its
 * {@code getErrors()}; check them with the status APIs before sending again.
 */
public class BulkSendException extends BizgoException {

    private static final long serialVersionUID = 1L;

    private final transient BulkSendResult partialResult;

    /**
     * Creates an exception.
     *
     * @param message message without personal data
     * @param partialResult results of the accepted chunks and the errors
     */
    public BulkSendException(String message, BulkSendResult partialResult) {
        super(message);
        this.partialResult = partialResult;
    }

    /**
     * Results of the chunks that were accepted, and the errors (including chunks with an unknown outcome).
     *
     * @return partial result, or null after Java deserialization
     */
    public BulkSendResult getPartialResult() {
        return partialResult;
    }
}
