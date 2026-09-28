package io.github.icommapi.bizgo.models;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Acceptance result of a send request.
 *
 * <p>Accepted is not delivered: the final result arrives later as a report (polling, webhook or inquiry).
 * Always check {@link #getFailed()}: a request can succeed while some recipients were rejected.
 *
 * <p>Every recipient is in exactly one of {@link #getSucceeded()} ({@code A000}, newly accepted),
 * {@link #getDuplicates()} ({@code A301}, already accepted earlier with the same {@code idempotencyKey}) and
 * {@link #getFailed()} (any other code, rejected). Retrying with the same key is safe: recipients that were already
 * accepted come back in {@link #getDuplicates()}, not in {@link #getFailed()}.
 */
public final class SendResult {

    /** Per-recipient code for a recipient already accepted earlier with the same {@code idempotencyKey}. */
    public static final String DUPLICATE_CODE = "A301";

    private final List<SendDestinationResult> destinations;
    private final String ref;
    private final String trackingId;

    /**
     * Creates a result.
     *
     * @param destinations per-recipient results in request order
     * @param ref the {@code ref} of the request, may be null
     * @param trackingId {@code common.infobankTrId}, may be null
     */
    public SendResult(List<SendDestinationResult> destinations, String ref, String trackingId) {
        this.destinations = destinations == null ? List.of() : List.copyOf(destinations);
        this.ref = ref;
        this.trackingId = trackingId;
    }

    /**
     * Per-recipient acceptance results, in request order.
     *
     * @return unmodifiable list
     */
    public List<SendDestinationResult> getDestinations() {
        return destinations;
    }

    /**
     * Recipients newly accepted by this request (code {@code A000}).
     *
     * @return unmodifiable list
     */
    public List<SendDestinationResult> getSucceeded() {
        return destinations.stream().filter(d -> "A000".equals(d.getCode())).collect(Collectors.toUnmodifiableList());
    }

    /**
     * Recipients already accepted earlier with the same {@code idempotencyKey} (per-recipient code {@code A301}).
     * They were not accepted again by this request and are not rejected: the earlier request delivers to them.
     * Use the {@code msgKey}/report of the earlier request to follow them.
     *
     * @return unmodifiable list, empty if no recipient was a duplicate
     */
    public List<SendDestinationResult> getDuplicates() {
        return destinations.stream().filter(d -> DUPLICATE_CODE.equals(d.getCode()))
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Recipients rejected at acceptance (code other than {@code A000} and {@code A301}). They will not receive the
     * message. Already-accepted recipients ({@code A301}) are in {@link #getDuplicates()}, not here.
     *
     * @return unmodifiable list, empty if every recipient was accepted or a duplicate
     */
    public List<SendDestinationResult> getFailed() {
        return destinations.stream().filter(d -> !"A000".equals(d.getCode()) && !DUPLICATE_CODE.equals(d.getCode()))
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Message keys of the recipients newly accepted by this request ({@link #getSucceeded()}), for report and status
     * lookups. Duplicates are not included.
     *
     * @return unmodifiable list
     */
    public List<String> getMsgKeys() {
        return getSucceeded().stream().map(SendDestinationResult::getMsgKey).filter(Objects::nonNull)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * The {@code ref} you sent with the request.
     *
     * @return ref, or null
     */
    public String getRef() {
        return ref;
    }

    /**
     * {@code common.infobankTrId}, for support inquiries.
     *
     * @return tracking id, or null
     */
    public String getTrackingId() {
        return trackingId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SendResult)) {
            return false;
        }
        SendResult other = (SendResult) o;
        return destinations.equals(other.destinations) && Objects.equals(ref, other.ref)
                && Objects.equals(trackingId, other.trackingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations, ref, trackingId);
    }

    @Override
    public String toString() {
        return "SendResult{destinations=" + destinations + ", trackingId=" + trackingId + "}";
    }
}
