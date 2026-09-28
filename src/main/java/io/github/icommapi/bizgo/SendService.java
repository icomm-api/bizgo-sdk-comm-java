package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ApiConnectionException;
import io.github.icommapi.bizgo.errors.BizgoException;
import io.github.icommapi.bizgo.errors.BulkSendException;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.models.BulkSendResult;
import io.github.icommapi.bizgo.models.ChannelMessage;
import io.github.icommapi.bizgo.models.Destination;
import io.github.icommapi.bizgo.models.MessageFlowItem;
import io.github.icommapi.bizgo.models.MmsMessage;
import io.github.icommapi.bizgo.models.SendOmniRequest;
import io.github.icommapi.bizgo.models.SendOmniResponse;
import io.github.icommapi.bizgo.models.SendOmniResult;
import io.github.icommapi.bizgo.models.SendOmniServiceResult;
import io.github.icommapi.bizgo.models.SendResult;
import io.github.icommapi.bizgo.models.SmsMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * Sending: {@code POST /api/comm/v1/send/omni}. Access as {@code client.send()}.
 *
 * <p>Every channel is sent with {@link #omni(String, ChannelMessage...)}. With several messages, the next one is sent
 * when the previous one fails (fallback): {@code omni(to, alimtalk, sms)}.
 *
 * <p>A successful call means <em>accepted</em>, not delivered. Check {@link SendResult#getFailed()} and get the final
 * result from reports. Resending with the same {@code idempotencyKey} is safe: recipients already accepted earlier
 * come back (per-recipient code {@code A301}) in {@link SendResult#getDuplicates()}, not in {@code getFailed()}. Requests are validated before anything is sent (throws
 * {@link ValidationException}).
 */
public final class SendService extends GeneratedSendService {

    static final String PATH = "/api/comm/v1/send/omni";

    private final Transport transport;

    SendService(Transport transport) {
        super(transport);
        this.transport = transport;
    }

    /**
     * Sends a message to one recipient. Messages are tried in order (fallback).
     *
     * @param to recipient phone number
     * @param messages channel messages in fallback order, for example {@code alimtalk, sms}
     * @return acceptance result
     */
    public SendResult omni(String to, ChannelMessage... messages) {
        return omni(single(to), messages == null ? null : Arrays.asList(messages), SendOptions.NONE);
    }

    /**
     * Sends a message to several recipients (at most 200 per request).
     *
     * @param to recipient phone numbers
     * @param messages channel messages in fallback order
     * @return acceptance result
     */
    public SendResult omni(Collection<String> to, ChannelMessage... messages) {
        return omni(to, messages == null ? null : Arrays.asList(messages), SendOptions.NONE);
    }

    /**
     * Sends a message to one recipient with request options (idempotency key, ref, ...).
     *
     * @param to recipient phone number
     * @param messages channel messages in fallback order
     * @param options request options, may be null
     * @return acceptance result
     */
    public SendResult omni(String to, List<? extends ChannelMessage> messages, SendOptions options) {
        return omni(single(to), messages, options);
    }

    /**
     * Sends a message to several recipients with request options.
     *
     * @param to recipient phone numbers (at most 200)
     * @param messages channel messages in fallback order
     * @param options request options, may be null
     * @return acceptance result
     */
    public SendResult omni(Collection<String> to, List<? extends ChannelMessage> messages, SendOptions options) {
        return omni(destinations(to), messages, options);
    }

    /**
     * Sends a message to recipients with per-recipient values ({@code replaceWords} for {@code #{name}}
     * substitution, a per-recipient {@code ref}).
     *
     * <pre>{@code
     * client.send().omni(
     *         List.of(Destination.builder().to("01000000000").replaceWords(Map.of("name", "홍길동")).build()),
     *         List.of(alimtalk, sms),
     *         SendOptions.idempotencyKey("order-1"));
     * }</pre>
     *
     * @param to recipients (at most 200)
     * @param messages channel messages in fallback order
     * @param options request options, may be null
     * @return acceptance result
     */
    public SendResult omni(List<Destination> to, List<? extends ChannelMessage> messages, SendOptions options) {
        return request(omniRequest(to, messages, options));
    }

    /** Builds and validates the whole request (including the spec's {@code x-sdk-required-if} rules). */
    private static SendOmniRequest omniRequest(List<Destination> to, List<? extends ChannelMessage> messages,
            SendOptions options) {
        SendOptions opts = options == null ? SendOptions.NONE : options;
        if (messages == null || messages.isEmpty()) {
            throw new ValidationException("messages", "messages가 비어 있습니다. 채널 메시지를 1개 이상 넣으세요.");
        }
        List<MessageFlowItem> flow = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {
            ChannelMessage message = messages.get(i);
            if (message == null) {
                throw new ValidationException("messages[" + i + "]", "null입니다");
            }
            flow.add(MessageFlowItem.of(message));
        }
        SendOmniRequest request = SendOmniRequest.builder()
                .destinations(to)
                .messageFlow(flow)
                .ref(opts.getRef())
                .groupKey(opts.getGroupKey())
                .paymentCode(opts.getPaymentCode())
                .idempotencyKey(opts.getIdempotencyKey())
                .idempotencyTtl(opts.getIdempotencyTtl())
                .build();
        return request;
    }

    /**
     * Sends a prepared request (for example one parsed with {@link SendOmniRequest#fromJson(String)}).
     *
     * <p>If the request has an {@code idempotencyKey} but no {@code idempotencyTtl}, the body is sent with
     * {@code idempotencyTtl} {@value Bizgo#DEFAULT_IDEMPOTENCY_TTL} ({@link Bizgo#DEFAULT_IDEMPOTENCY_TTL}); the
     * request object itself is not changed.
     *
     * @param request validated request
     * @return acceptance result
     */
    public SendResult request(SendOmniRequest request) {
        if (request == null) {
            throw new ValidationException("request", "null입니다");
        }
        // Without an idempotency key, a retried send after a timeout could deliver twice.
        String key = request.getIdempotencyKey();
        Retry retry = key != null && !key.isEmpty() ? Retry.SAFE : Retry.RATE_LIMIT_ONLY;
        // built inside the call: a malformed body (e.g. a null destination) becomes InvalidResponseException
        return transport.call(Operations.SEND_OMNI, retry, PATH, null, Transport.Body.jsonWithDefaultTtl(request),
                SendOmniResponse.class, response -> {
                    SendOmniServiceResult data = response.getData();
                    SendOmniResult inner = data == null ? null : data.getData();
                    return new SendResult(inner == null ? null : inner.getDestinations(),
                            data == null ? null : data.getRef(),
                            response.getCommon() == null ? null : response.getCommon().getInfobankTrId());
                });
    }

    /**
     * Sends an SMS: text up to 90 bytes in EUC-KR (about 45 Korean characters).
     *
     * @param to recipient phone number
     * @param from sender number registered in the Bizgo console
     * @param text message text
     * @return acceptance result
     */
    public SendResult sms(String to, String from, String text) {
        return sms(single(to), from, text, SendOptions.NONE);
    }

    /**
     * Sends an SMS with request options.
     *
     * @param to recipient phone number
     * @param from registered sender number
     * @param text message text (90 bytes in EUC-KR)
     * @param options request options, may be null
     * @return acceptance result
     */
    public SendResult sms(String to, String from, String text, SendOptions options) {
        return sms(single(to), from, text, options);
    }

    /**
     * Sends an SMS to several recipients.
     *
     * @param to recipient phone numbers (at most 200)
     * @param from registered sender number
     * @param text message text (90 bytes in EUC-KR)
     * @param options request options, may be null
     * @return acceptance result
     */
    public SendResult sms(Collection<String> to, String from, String text, SendOptions options) {
        SmsMessage message = SmsMessage.builder().from(from).text(text).build();
        return omni(to, List.of(message), options);
    }

    /**
     * Sends an LMS (text up to 2,000 bytes in EUC-KR).
     *
     * @param to recipient phone number
     * @param from registered sender number
     * @param text message text
     * @return acceptance result
     */
    public SendResult lms(String to, String from, String text) {
        return lms(single(to), from, text, null, SendOptions.NONE);
    }

    /**
     * Sends an LMS with a title and request options.
     *
     * @param to recipient phone number
     * @param from registered sender number
     * @param text message text (2,000 bytes in EUC-KR)
     * @param title title, may be null
     * @param options request options, may be null
     * @return acceptance result
     */
    public SendResult lms(String to, String from, String text, String title, SendOptions options) {
        return lms(single(to), from, text, title, options);
    }

    /**
     * Sends an LMS to several recipients.
     *
     * @param to recipient phone numbers (at most 200)
     * @param from registered sender number
     * @param text message text (2,000 bytes in EUC-KR)
     * @param title title, may be null
     * @param options request options, may be null
     * @return acceptance result
     */
    public SendResult lms(Collection<String> to, String from, String text, String title, SendOptions options) {
        MmsMessage message = MmsMessage.builder().from(from).text(text).title(title).build();
        return omni(to, List.of(message), options);
    }

    /**
     * Sends an MMS. Upload the images first with {@code client.files().uploadMms(...)} (at most 3 keys).
     *
     * @param to recipient phone number
     * @param from registered sender number
     * @param text message text (2,000 bytes in EUC-KR)
     * @param fileKeys file keys from the upload
     * @return acceptance result
     */
    public SendResult mms(String to, String from, String text, List<String> fileKeys) {
        return mms(single(to), from, text, fileKeys, null, SendOptions.NONE);
    }

    /**
     * Sends an MMS with a title and request options.
     *
     * @param to recipient phone number
     * @param from registered sender number
     * @param text message text (2,000 bytes in EUC-KR)
     * @param fileKeys file keys from the upload (1 to 3)
     * @param title title, may be null
     * @param options request options, may be null
     * @return acceptance result
     */
    public SendResult mms(String to, String from, String text, List<String> fileKeys, String title,
            SendOptions options) {
        return mms(single(to), from, text, fileKeys, title, options);
    }

    /**
     * Sends an MMS to several recipients.
     *
     * @param to recipient phone numbers (at most 200)
     * @param from registered sender number
     * @param text message text (2,000 bytes in EUC-KR)
     * @param fileKeys file keys from the upload (1 to 3)
     * @param title title, may be null
     * @param options request options, may be null
     * @return acceptance result
     */
    public SendResult mms(Collection<String> to, String from, String text, List<String> fileKeys, String title,
            SendOptions options) {
        if (fileKeys == null || fileKeys.isEmpty()) {
            throw new ValidationException("fileKeys", "MMS에는 파일 키가 1개 이상 필요합니다(client.files().uploadMms)");
        }
        MmsMessage message = MmsMessage.builder().from(from).text(text).title(title).fileKey(fileKeys).build();
        return omni(to, List.of(message), options);
    }

    /**
     * Sends to any number of recipients: splits them into requests of {@link BulkOptions#getChunkSize()} (at most
     * 200) and sends up to {@link BulkOptions#getConcurrency()} requests at a time. A failed request does not stop
     * the others; see {@link BulkSendResult#getErrors()}.
     *
     * <pre>{@code
     * BulkSendResult result = client.send().bulk(numbers, List.of(sms),
     *         BulkOptions.builder().idempotencyKeyPrefix("campaign-0923").build());
     * result.getErrors().forEach(e -> retryLater(numbers.subList(e.fromIndex(), e.toIndex())));
     * }</pre>
     *
     * <p>With {@link BulkOptions.Builder#idempotencyKeyPrefix(String)} every request uses the key
     * {@code <prefix>-<chunkSize>-<startIndex>-<hash8>} ({@link BulkOptions#idempotencyKey}), so a rerun with the same
     * list, prefix and chunk size does not send an accepted chunk again. Without it, the retry policy is the same as
     * {@link #omni(List, List, SendOptions)}.
     *
     * <p>A failure of one request never loses the others: if a chunk hits a fatal {@link Error} or the thread is
     * interrupted, a {@link BulkSendException} carries the results of the accepted chunks
     * ({@link BulkSendException#getPartialResult()}); the interrupt flag is restored.
     *
     * @param to recipient phone numbers
     * @param messages channel messages in fallback order
     * @param options bulk options, null for {@link BulkOptions#DEFAULT}
     * @return per-request results and errors
     * @throws ValidationException before anything is sent if {@code to} or {@code messages} is empty or invalid
     */
    public BulkSendResult bulk(Collection<String> to, List<? extends ChannelMessage> messages, BulkOptions options) {
        return bulk(destinations(to), messages, options);
    }

    /**
     * Same as {@link #bulk(Collection, List, BulkOptions)} with per-recipient values ({@code replaceWords},
     * {@code ref}).
     *
     * @param to recipients
     * @param messages channel messages in fallback order
     * @param options bulk options, null for {@link BulkOptions#DEFAULT}
     * @return per-request results and errors
     * @throws ValidationException before anything is sent if {@code to} or {@code messages} is empty or invalid
     */
    public BulkSendResult bulk(List<Destination> to, List<? extends ChannelMessage> messages, BulkOptions options) {
        BulkOptions opts = options == null ? BulkOptions.DEFAULT : options;
        if (to == null || to.isEmpty()) {
            throw new ValidationException("to", "수신자가 없습니다");
        }
        if (messages == null || messages.isEmpty()) {
            throw new ValidationException("messages", "messages가 비어 있습니다. 채널 메시지를 1개 이상 넣으세요.");
        }
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i) == null) {
                throw new ValidationException("messages[" + i + "]", "null입니다");
            }
            MessageFlowItem.of(messages.get(i)); // validates before anything is sent
        }
        if (to.stream().anyMatch(java.util.Objects::isNull)) { // List.of(...).contains(null) throws NPE
            throw new ValidationException("to", "null 항목이 있습니다");
        }
        List<Destination> recipients = List.copyOf(to);
        int size = opts.getChunkSize();
        int chunks = (recipients.size() + size - 1) / size;
        String[] keys = new String[chunks];
        SendOmniRequest[] requests = new SendOmniRequest[chunks];
        for (int c = 0; c < chunks; c++) {       // all keys and requests are built and checked before anything is sent
            int from = c * size;
            List<String> numbers = new ArrayList<>();
            for (Destination d : recipients.subList(from, Math.min(from + size, recipients.size()))) {
                numbers.add(d.getTo() == null ? "" : d.getTo());
            }
            if (opts.getIdempotencyKeyPrefix() != null) {
                keys[c] = BulkOptions.idempotencyKey(opts.getIdempotencyKeyPrefix(), size, from, numbers);
                if (keys[c].length() > BulkOptions.MAX_KEY_LENGTH) {
                    throw new ValidationException("idempotencyKeyPrefix",
                            "생성된 멱등성 키가 " + BulkOptions.MAX_KEY_LENGTH + "자를 넘습니다");
                }
            }
            // whole-request rules ($.destinations[].replaceWords etc.) fail here, before any chunk is sent
            requests[c] = omniRequest(recipients.subList(from, Math.min(from + size, recipients.size())), messages,
                    opts.sendOptions(keys[c]));
        }
        Map<Integer, SendResult> results = new ConcurrentHashMap<>();
        List<BulkSendResult.ChunkError> errors = new CopyOnWriteArrayList<>();
        java.util.concurrent.atomic.AtomicReference<Throwable> fatal = new java.util.concurrent.atomic.AtomicReference<>();
        ExecutorService pool = Executors.newFixedThreadPool(Math.min(opts.getConcurrency(), chunks), BULK_THREADS);
        List<Future<?>> futures = new ArrayList<>();
        boolean interrupted = false;
        try {
            for (int c = 0; c < chunks; c++) {
                int chunk = c;
                int from = c * size;
                int until = Math.min(from + size, recipients.size());
                SendOmniRequest chunkRequest = requests[c];
                futures.add(pool.submit(() -> {
                    try {
                        results.put(chunk, request(chunkRequest));
                    } catch (BizgoException e) {
                        errors.add(new BulkSendResult.ChunkError(chunk, from, until, e));
                    } catch (Throwable e) {
                        // anything else (a bug, an Error): keep the other chunks and the accepted results (12.2)
                        if (e instanceof Error) {
                            fatal.compareAndSet(null, e);
                        }
                        errors.add(new BulkSendResult.ChunkError(chunk, from, until, new BizgoException(
                                "청크 처리 중 오류(" + e.getClass().getSimpleName() + "). 접수됐을 수 있으니 상태 조회 API로 "
                                        + "확인하세요")));
                    }
                }));
            }
            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (ExecutionException e) {
                    // cannot happen: every task catches Throwable
                }
            }
        } catch (InterruptedException e) {
            interrupted = true;
            pool.shutdownNow();
            try {
                pool.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS); // let running chunks record results
            } catch (InterruptedException again) {
                // keep going: the flag is restored below
            }
        } finally {
            pool.shutdown();
        }
        if (interrupted) {
            for (int c = 0; c < chunks; c++) {
                int chunk = c;
                if (!results.containsKey(c) && errors.stream().noneMatch(err -> err.chunkIndex() == chunk)) {
                    int from = c * size;
                    errors.add(new BulkSendResult.ChunkError(c, from, Math.min(from + size, recipients.size()),
                            new ApiConnectionException("대량 발송이 중단됐습니다. 이 청크는 접수됐을 수 있으니 상태 조회 API로 "
                                    + "확인하세요")));
                }
            }
            Thread.currentThread().interrupt(); // restore the flag for the caller
            throw new BulkSendException("대량 발송이 중단됐습니다(InterruptedException). 접수된 청크의 결과는 "
                    + "getPartialResult()에 있습니다", new BulkSendResult(results, errors));
        }
        BulkSendResult result = new BulkSendResult(results, errors);
        if (fatal.get() != null) {
            throw new BulkSendException("대량 발송 중 치명적 오류(" + fatal.get().getClass().getSimpleName()
                    + "). 접수된 청크의 결과는 getPartialResult()에 있습니다", result);
        }
        return result;
    }

    private static final ThreadFactory BULK_THREADS = runnable -> {
        Thread thread = new Thread(runnable, "bizgo-bulk");
        thread.setDaemon(true);
        return thread;
    };

    @Override
    public String toString() {
        return "SendService";
    }

    private static List<String> single(String to) {
        List<String> list = new ArrayList<>(1);
        list.add(to);
        return list;
    }

    private static List<Destination> destinations(Collection<String> to) {
        if (to == null) {
            throw new ValidationException("to", "수신자가 없습니다");
        }
        List<Destination> list = new ArrayList<>(to.size());
        for (String number : to) {
            list.add(Destination.builder().to(number).build());
        }
        return list;
    }
}
