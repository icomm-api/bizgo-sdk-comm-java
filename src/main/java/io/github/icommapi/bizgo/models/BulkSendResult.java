package io.github.icommapi.bizgo.models;

import io.github.icommapi.bizgo.errors.BizgoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Result of {@code client.send().bulk(...)}: one {@link SendResult} per accepted request and one {@link ChunkError}
 * per failed request. A failed request does not stop the others.
 *
 * <p>Like {@link SendResult}, acceptance is not delivery. {@link #getFailed()} lists the recipients the server
 * rejected inside accepted requests; recipients of failed requests are in {@link #getErrors()} (as index ranges).
 * Recipients already accepted earlier with the same idempotency key ({@code A301}, for example when a bulk send is
 * repeated with the same {@code idempotencyKeyPrefix}) are in {@link #getDuplicates()}; a request whose recipients
 * are all duplicates is an accepted request, not an error.
 * {@link #toString()} shows counts only, never phone numbers.
 */
public final class BulkSendResult {

    /**
     * A request (chunk) that failed as a whole.
     *
     * @param chunkIndex index of the chunk (0-based)
     * @param fromIndex index of the chunk's first recipient in the input list (inclusive)
     * @param toIndex index after the chunk's last recipient (exclusive)
     * @param error the exception; its message never contains phone numbers
     */
    public record ChunkError(int chunkIndex, int fromIndex, int toIndex, BizgoException error) {

        @Override
        public String toString() {
            return "ChunkError{chunk=" + chunkIndex + ", recipients=[" + fromIndex + ", " + toIndex + "), error="
                    + error.getClass().getSimpleName() + "}";
        }
    }

    private final Map<Integer, SendResult> results;
    private final List<ChunkError> errors;

    /**
     * Creates a result.
     *
     * @param results accepted requests by chunk index
     * @param errors failed requests
     */
    public BulkSendResult(Map<Integer, SendResult> results, List<ChunkError> errors) {
        this.results = Collections.unmodifiableMap(new TreeMap<>(results));
        List<ChunkError> sorted = new ArrayList<>(errors);
        sorted.sort((a, b) -> Integer.compare(a.chunkIndex(), b.chunkIndex()));
        this.errors = Collections.unmodifiableList(sorted);
    }

    /**
     * Accepted requests by chunk index, in chunk order.
     *
     * @return unmodifiable map
     */
    public Map<Integer, SendResult> getResults() {
        return results;
    }

    /**
     * Requests that failed as a whole, in chunk order.
     *
     * @return unmodifiable list, empty if every request was accepted
     */
    public List<ChunkError> getErrors() {
        return errors;
    }

    /**
     * Recipients accepted by the server ({@code code == A000}) over all accepted requests.
     *
     * @return unmodifiable list
     */
    public List<SendDestinationResult> getSucceeded() {
        List<SendDestinationResult> list = new ArrayList<>();
        results.values().forEach(r -> list.addAll(r.getSucceeded()));
        return Collections.unmodifiableList(list);
    }

    /**
     * Recipients already accepted earlier with the same idempotency key ({@code A301}) over all accepted requests,
     * in chunk order. They are neither in {@link #getSucceeded()} nor in {@link #getFailed()}.
     *
     * @return unmodifiable list
     */
    public List<SendDestinationResult> getDuplicates() {
        List<SendDestinationResult> list = new ArrayList<>();
        results.values().forEach(r -> list.addAll(r.getDuplicates()));
        return Collections.unmodifiableList(list);
    }

    /**
     * Recipients the server rejected inside accepted requests (duplicates excluded, see {@link #getDuplicates()}).
     *
     * @return unmodifiable list
     */
    public List<SendDestinationResult> getFailed() {
        List<SendDestinationResult> list = new ArrayList<>();
        results.values().forEach(r -> list.addAll(r.getFailed()));
        return Collections.unmodifiableList(list);
    }

    /**
     * Message keys of the accepted recipients, in chunk order.
     *
     * @return unmodifiable list
     */
    public List<String> getMsgKeys() {
        List<String> list = new ArrayList<>();
        results.values().forEach(r -> list.addAll(r.getMsgKeys()));
        return Collections.unmodifiableList(list);
    }

    /**
     * True if every request was accepted and no recipient was rejected. Duplicates do not make a result
     * incomplete.
     *
     * @return all accepted
     */
    public boolean isComplete() {
        return errors.isEmpty() && getFailed().isEmpty();
    }

    @Override
    public String toString() {
        return "BulkSendResult{requests=" + results.size() + ", failedRequests=" + errors.size() + ", succeeded="
                + getSucceeded().size() + ", duplicates=" + getDuplicates().size() + ", failed=" + getFailed().size() + "}";
    }
}
