package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Parameters of the send history query ({@code GET /api/comm/v1/message/history}). Immutable.
 *
 * <pre>{@code
 * HistoryQuery query = HistoryQuery.since(LocalDateTime.of(2026, 9, 23, 9, 0))   // KST
 *         .serviceTypes("SMS", "ALIMTALK")
 *         .limit(500);
 * }</pre>
 *
 * <p>{@code requestTime} is sent as {@code yyyy-MM-dd'T'HH:mm:ss} in Korea time: a {@link LocalDateTime} is taken as
 * KST, times with an offset or zone are converted to KST.
 */
public final class HistoryQuery {

    private final String requestTime;
    private final List<String> serviceTypes;
    private final String groupKey;
    private final Long lastSeq;
    private final Integer limit;

    private HistoryQuery(String requestTime, List<String> serviceTypes, String groupKey, Long lastSeq, Integer limit) {
        this.requestTime = requestTime;
        this.serviceTypes = serviceTypes;
        this.groupKey = groupKey;
        this.lastSeq = lastSeq;
        this.limit = limit;
    }

    /**
     * History from a Korea-time local date-time.
     *
     * @param requestTime KST time
     * @return query
     */
    public static HistoryQuery since(LocalDateTime requestTime) {
        return new HistoryQuery(Params.kstLocal(Params.required("requestTime", requestTime)), null, null, null, null);
    }

    /**
     * History from a time with an offset (converted to KST).
     *
     * @param requestTime time
     * @return query
     */
    public static HistoryQuery since(OffsetDateTime requestTime) {
        return new HistoryQuery(Params.kstLocal(Params.required("requestTime", requestTime)), null, null, null, null);
    }

    /**
     * History from a zoned time (converted to KST).
     *
     * @param requestTime time
     * @return query
     */
    public static HistoryQuery since(ZonedDateTime requestTime) {
        return new HistoryQuery(Params.kstLocal(Params.required("requestTime", requestTime)), null, null, null, null);
    }

    /**
     * History from an instant (converted to KST).
     *
     * @param requestTime time
     * @return query
     */
    public static HistoryQuery since(Instant requestTime) {
        return new HistoryQuery(Params.kstLocal(Params.required("requestTime", requestTime)), null, null, null, null);
    }

    /**
     * History from a time already formatted as {@code yyyy-MM-dd'T'HH:mm:ss} (KST). Sent as is.
     *
     * @param requestTime formatted time
     * @return query
     */
    public static HistoryQuery since(String requestTime) {
        if (requestTime == null || requestTime.isEmpty()) {
            throw new ValidationException("requestTime", "필수 값입니다");
        }
        return new HistoryQuery(requestTime, null, null, null, null);
    }

    /**
     * Channel filter: {@code SMS}, {@code MMS}, {@code RCS}, {@code ALIMTALK}, {@code BRANDMESSAGE}.
     *
     * @param serviceTypes one or more channel types
     * @return a copy with the filter
     */
    public HistoryQuery serviceTypes(String... serviceTypes) {
        return serviceTypes(serviceTypes == null ? null : Arrays.asList(serviceTypes));
    }

    /**
     * Channel filter.
     *
     * @param serviceTypes channel types, null or empty for all
     * @return a copy with the filter
     */
    public HistoryQuery serviceTypes(Collection<String> serviceTypes) {
        List<String> types = serviceTypes == null || serviceTypes.isEmpty() ? null : List.copyOf(serviceTypes);
        return new HistoryQuery(requestTime, types, groupKey, lastSeq, limit);
    }

    /**
     * Message group filter.
     *
     * @param groupKey group key
     * @return a copy with the filter
     */
    public HistoryQuery groupKey(String groupKey) {
        return new HistoryQuery(requestTime, serviceTypes, groupKey, lastSeq, limit);
    }

    /**
     * Page cursor ({@code lastSeq} of the previous page).
     *
     * @param lastSeq cursor, null for the first page
     * @return a copy with the cursor
     */
    public HistoryQuery lastSeq(Long lastSeq) {
        return new HistoryQuery(requestTime, serviceTypes, groupKey, lastSeq, limit);
    }

    /**
     * Page size, 1 to 1,000 (server default 100).
     *
     * @param limit page size
     * @return a copy with the page size
     * @throws ValidationException if the value is out of range
     */
    public HistoryQuery limit(Integer limit) {
        return new HistoryQuery(requestTime, serviceTypes, groupKey, lastSeq, Params.limit(limit));
    }

    Long lastSeq() {
        return lastSeq;
    }

    Map<String, String> toQuery() {
        Map<String, String> query = new LinkedHashMap<>();
        query.put("requestTime", requestTime);
        query.put("serviceType", serviceTypes == null ? null : String.join(",", serviceTypes));
        query.put("groupKey", groupKey);
        query.put("lastSeq", lastSeq == null ? null : lastSeq.toString());
        query.put("limit", limit == null ? null : limit.toString());
        return query;
    }

    @Override
    public String toString() {
        return "HistoryQuery{requestTime=" + requestTime + ", serviceTypes=" + serviceTypes + ", lastSeq=" + lastSeq
                + ", limit=" + limit + "}";
    }
}
