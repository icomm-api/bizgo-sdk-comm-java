package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.MessagePage;
import io.github.icommapi.bizgo.models.MessageStatistics;
import io.github.icommapi.bizgo.models.MessageStatisticsResponse;
import io.github.icommapi.bizgo.models.MessageStatisticsServiceResult;
import io.github.icommapi.bizgo.models.MessageStatus;
import io.github.icommapi.bizgo.models.MessageStatusListResponse;
import io.github.icommapi.bizgo.models.MessageStatusListResult;
import io.github.icommapi.bizgo.models.MoMessage;
import io.github.icommapi.bizgo.models.MoMessageListResponse;
import io.github.icommapi.bizgo.models.MoMessageListResult;
import io.github.icommapi.bizgo.models.MoPage;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Message status, history and statistics: {@code /api/comm/v1/message/*}. Access as {@code client.messages()}.
 *
 * <p>These are non-send APIs, limited to 5 requests per second by default.
 */
public final class MessageService extends GeneratedMessageService {

    private static final String BASE = "/api/comm/v1/message";

    private final Transport transport;

    MessageService(Transport transport) {
        super(transport);
        this.transport = transport;
    }

    /**
     * Acceptance, send and report status of one message. With fallback there is one entry per channel tried.
     *
     * @param msgKey message key
     * @return status entries, empty if none
     */
    public List<MessageStatus> status(String msgKey) {
        return statuses(Operations.GET_MESSAGE_STATUS_BY_MSG_KEY, Operations.GET_MESSAGE_STATUS_BY_MSG_KEY.path(msgKey));
    }

    /**
     * Status of every message of one broadcast request.
     *
     * @param requestId {@code msgKey} without its last 3 characters
     * @return status entries, empty if none
     */
    public List<MessageStatus> statusByRequestId(String requestId) {
        return statuses(Operations.GET_MESSAGE_STATUS_BY_REQUEST_ID,
                Operations.GET_MESSAGE_STATUS_BY_REQUEST_ID.path(requestId));
    }

    private List<MessageStatus> statuses(Operation op, String path) {
        MessageStatusListResult inner = messagePage(transport.call(op, Retry.SAFE, path, null, null,
                MessageStatusListResponse.class));
        return inner == null || inner.getMessages() == null ? List.of() : inner.getMessages();
    }

    /**
     * Daily acceptance and report counts from {@code startDate}.
     *
     * @param startDate first day
     * @return statistics per day
     */
    public List<MessageStatistics> statistics(LocalDate startDate) {
        return statistics(startDate, null, null, null);
    }

    /**
     * Daily acceptance and report counts in a date range.
     *
     * @param startDate first day
     * @param endDate last day, may be null
     * @return statistics per day
     */
    public List<MessageStatistics> statistics(LocalDate startDate, LocalDate endDate) {
        return statistics(startDate, endDate, null, null);
    }

    /**
     * Daily acceptance and report counts.
     *
     * @param startDate first day
     * @param endDate last day, may be null
     * @param serviceType {@code SMS}, {@code MMS}, {@code RCS}, {@code ALIMTALK} or {@code BRANDMESSAGE}; null for all
     * @param groupKey message group key, may be null
     * @return statistics per day
     */
    public List<MessageStatistics> statistics(LocalDate startDate, LocalDate endDate, String serviceType,
            String groupKey) {
        return statistics(Params.date(Params.required("startDate", startDate)), Params.date(endDate), serviceType,
                groupKey);
    }

    /**
     * Daily acceptance and report counts, with dates already formatted as {@code YYYYMMDD}.
     *
     * @param startDate first day, {@code YYYYMMDD}
     * @param endDate last day, {@code YYYYMMDD}, may be null
     * @param serviceType channel type, may be null
     * @param groupKey message group key, may be null
     * @return statistics per day
     */
    public List<MessageStatistics> statistics(String startDate, String endDate, String serviceType,
            String groupKey) {
        Map<String, String> query = new LinkedHashMap<>();
        query.put("startDate", Params.required("startDate", startDate));
        query.put("endDate", endDate);
        query.put("serviceType", serviceType);
        query.put("groupKey", groupKey);
        MessageStatisticsResponse response = transport.call(Operations.GET_MESSAGE_STATISTICS, Retry.SAFE, BASE + "/statistics", query, null,
                MessageStatisticsResponse.class);
        MessageStatisticsServiceResult data = response.getData();
        if (data == null || data.getData() == null || data.getData().getStatistics() == null) {
            return List.of();
        }
        return data.getData().getStatistics();
    }

    /**
     * One page of send history. Use {@link #iterHistory(HistoryQuery)} to walk all pages.
     *
     * @param query query
     * @return the page
     */
    public MessagePage history(HistoryQuery query) {
        Params.required("query", query);
        return transport.call(Operations.GET_MESSAGE_HISTORY, Retry.SAFE, BASE + "/history", query.toQuery(), null,
                MessageStatusListResponse.class, response -> {
                    MessageStatusListResult inner = messagePage(response);
                    return inner == null ? new MessagePage(List.of(), null, false)
                            : new MessagePage(inner.getMessages(), inner.getLastSeq(),
                                    Boolean.TRUE.equals(inner.getHasNext()));
                });
    }

    /**
     * All send history from the query's time, following {@code lastSeq} across pages lazily.
     *
     * <pre>{@code
     * for (MessageStatus m : client.messages().iterHistory(HistoryQuery.since(since).serviceTypes("SMS"))) { ... }
     * }</pre>
     *
     * @param query query (its {@code lastSeq}, if set, is the starting cursor)
     * @return iterable that fetches pages as you iterate; each iteration starts over
     */
    public Iterable<MessageStatus> iterHistory(HistoryQuery query) {
        Params.required("query", query);
        return new Pager<>(query.lastSeq(), cursor -> {
            MessagePage page = history(query.lastSeq(cursor));
            return new Pager.Page<>(page.getMessages(), page.getLastSeq(), page.hasNext());
        });
    }

    /**
     * {@link #iterHistory(HistoryQuery)} as a sequential stream.
     *
     * @param query query
     * @return lazy stream
     */
    public Stream<MessageStatus> streamHistory(HistoryQuery query) {
        return StreamSupport.stream(iterHistory(query).spliterator(), false);
    }

    /**
     * Looks up an MO (inbound) message by key. The same key can have several entries.
     *
     * @param msgKey MO message key
     * @return messages, empty if none
     */
    public List<MoMessage> mo(String msgKey) {
        MoMessageListResult inner = moPage(transport.call(Operations.GET_MO_BY_MSG_KEY, Retry.SAFE,
                Operations.GET_MO_BY_MSG_KEY.path(msgKey), null, null,
                MoMessageListResponse.class));
        return inner == null || inner.getMessages() == null ? List.of() : inner.getMessages();
    }

    /**
     * One page of MO history, newest first.
     *
     * @param query query
     * @return the page
     */
    public MoPage moHistory(MoHistoryQuery query) {
        Params.required("query", query);
        return transport.call(Operations.GET_MO_HISTORY, Retry.SAFE, BASE + "/history/mo", query.toQuery(), null,
                MoMessageListResponse.class, response -> {
                    MoMessageListResult inner = moPage(response);
                    return inner == null ? new MoPage(List.of(), null, false)
                            : new MoPage(inner.getMessages(), inner.getLastSeq(), Boolean.TRUE.equals(inner.getHasNext()));
                });
    }

    /**
     * All MO history pages, fetched lazily.
     *
     * @param query query (its {@code lastSeq}, if set, is the starting cursor)
     * @return iterable that fetches pages as you iterate
     */
    public Iterable<MoMessage> iterMoHistory(MoHistoryQuery query) {
        Params.required("query", query);
        return new Pager<>(query.lastSeq(), cursor -> {
            MoPage page = moHistory(query.lastSeq(cursor));
            return new Pager.Page<>(page.getMessages(), page.getLastSeq(), page.hasNext());
        });
    }

    /**
     * {@link #iterMoHistory(MoHistoryQuery)} as a sequential stream.
     *
     * @param query query
     * @return lazy stream
     */
    public Stream<MoMessage> streamMoHistory(MoHistoryQuery query) {
        return StreamSupport.stream(iterMoHistory(query).spliterator(), false);
    }

    private static MessageStatusListResult messagePage(MessageStatusListResponse response) {
        return response.getData() == null ? null : response.getData().getData();
    }

    private static MoMessageListResult moPage(MoMessageListResponse response) {
        return response.getData() == null ? null : response.getData().getData();
    }

    @Override
    public String toString() {
        return "MessageService";
    }
}
