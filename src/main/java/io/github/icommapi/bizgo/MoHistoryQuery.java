package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Parameters of the MO (inbound message) history query ({@code GET /api/comm/v1/message/history/mo}). Immutable.
 *
 * <p>{@code occurredTime} is sent with an offset ({@code 2026-04-23T14:11:01+09:00}). A {@link LocalDateTime} is taken
 * as KST; an {@link OffsetDateTime} or {@link ZonedDateTime} keeps its own offset.
 *
 * <p>{@link #toString()} does not show the phone number filters.
 */
public final class MoHistoryQuery {

    private final String occurredTime;
    private final String from;
    private final String to;
    private final Long lastSeq;
    private final Integer limit;

    private MoHistoryQuery(String occurredTime, String from, String to, Long lastSeq, Integer limit) {
        this.occurredTime = occurredTime;
        this.from = from;
        this.to = to;
        this.lastSeq = lastSeq;
        this.limit = limit;
    }

    /**
     * MO history from a Korea-time local date-time.
     *
     * @param occurredTime KST time
     * @return query
     */
    public static MoHistoryQuery since(LocalDateTime occurredTime) {
        return new MoHistoryQuery(Params.withOffset(Params.required("occurredTime", occurredTime)), null, null, null,
                null);
    }

    /**
     * MO history from a time with an offset (the offset is kept).
     *
     * @param occurredTime time
     * @return query
     */
    public static MoHistoryQuery since(OffsetDateTime occurredTime) {
        return new MoHistoryQuery(Params.withOffset(Params.required("occurredTime", occurredTime)), null, null, null,
                null);
    }

    /**
     * MO history from a zoned time (its offset at that instant is used).
     *
     * @param occurredTime time
     * @return query
     */
    public static MoHistoryQuery since(ZonedDateTime occurredTime) {
        return new MoHistoryQuery(Params.withOffset(Params.required("occurredTime", occurredTime)), null, null, null,
                null);
    }

    /**
     * MO history from an instant (sent with the KST offset).
     *
     * @param occurredTime time
     * @return query
     */
    public static MoHistoryQuery since(Instant occurredTime) {
        return new MoHistoryQuery(Params.withOffset(Params.required("occurredTime", occurredTime)), null, null, null,
                null);
    }

    /**
     * MO history from a time already formatted with an offset ({@code yyyy-MM-dd'T'HH:mm:ssXXX}). Sent as is.
     *
     * @param occurredTime formatted time
     * @return query
     */
    public static MoHistoryQuery since(String occurredTime) {
        if (occurredTime == null || occurredTime.isEmpty()) {
            throw new ValidationException("occurredTime", "필수 값입니다");
        }
        return new MoHistoryQuery(occurredTime, null, null, null, null);
    }

    /**
     * Sender number filter.
     *
     * @param from sender number
     * @return a copy with the filter
     */
    public MoHistoryQuery from(String from) {
        return new MoHistoryQuery(occurredTime, from, to, lastSeq, limit);
    }

    /**
     * Receiving (MO) number filter.
     *
     * @param to MO number
     * @return a copy with the filter
     */
    public MoHistoryQuery to(String to) {
        return new MoHistoryQuery(occurredTime, from, to, lastSeq, limit);
    }

    /**
     * Page cursor ({@code lastSeq} of the previous page).
     *
     * @param lastSeq cursor, null for the newest messages
     * @return a copy with the cursor
     */
    public MoHistoryQuery lastSeq(Long lastSeq) {
        return new MoHistoryQuery(occurredTime, from, to, lastSeq, limit);
    }

    /**
     * Page size, 1 to 1,000 (server default 100).
     *
     * @param limit page size
     * @return a copy with the page size
     * @throws ValidationException if the value is out of range
     */
    public MoHistoryQuery limit(Integer limit) {
        return new MoHistoryQuery(occurredTime, from, to, lastSeq, Params.limit(limit));
    }

    Long lastSeq() {
        return lastSeq;
    }

    Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        query.put("occurredTime", occurredTime);
        query.put("from", from);
        query.put("to", to);
        query.put("lastSeq", lastSeq == null ? null : lastSeq.toString());
        query.put("limit", limit == null ? null : limit.toString());
        return query;
    }

    @Override
    public String toString() {
        return "MoHistoryQuery{occurredTime=" + occurredTime
                + (from == null ? "" : ", from=" + io.github.icommapi.bizgo.internal.Masking.phone(from))
                + (to == null ? "" : ", to=" + io.github.icommapi.bizgo.internal.Masking.phone(to))
                + ", lastSeq=" + lastSeq + ", limit=" + limit + "}";
    }
}
