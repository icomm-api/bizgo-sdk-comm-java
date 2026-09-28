package io.github.icommapi.bizgo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import io.github.icommapi.bizgo.errors.ApiConnectionException;
import io.github.icommapi.bizgo.errors.ApiException;
import io.github.icommapi.bizgo.errors.ApiTimeoutException;
import io.github.icommapi.bizgo.errors.DuplicateRequestException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.errors.InvalidResponseException;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.internal.Json;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.LongSupplier;

/**
 * HTTP transport: headers, rate limiting, retries, envelope parsing, error mapping, hooks and logging.
 *
 * <p>Nothing here logs or throws request bodies, header values or query strings, because they can contain the API
 * key and phone numbers. Exceptions from the HTTP layer are never chained as causes: their messages can contain the
 * full URL.
 */
final class Transport implements AutoCloseable {

    static final String LOGGER_NAME = "io.github.icommapi.bizgo";
    static final String SDK_NAME = "bizgo-sdk-comm-java";
    /** {@code X-Bizgo-Client}: survives proxies that rewrite the User-Agent (SDK-DESIGN 2.1). */
    static final String CLIENT_HEADER = SDK_NAME + "/" + Bizgo.VERSION;
    /** User-Agent without app info. */
    static final String USER_AGENT = userAgent(null, null);
    private static final java.util.regex.Pattern APP_NAME = java.util.regex.Pattern.compile("[A-Za-z0-9._-]{1,50}");
    private static final java.util.regex.Pattern APP_VERSION = java.util.regex.Pattern.compile("[A-Za-z0-9._+-]{1,30}");
    static final int MAX_RESPONSE_BYTES = 16 * 1024 * 1024;

    private static final System.Logger LOG = System.getLogger(LOGGER_NAME);
    private static final Set<Integer> RETRYABLE_STATUS = Set.of(429, 500, 502, 503, 504);
    private static final double MAX_BACKOFF_SECONDS = 8.0;
    private static final double MAX_RETRY_AFTER_SECONDS = 60.0;

    /** A request body. */
    record Body(byte[] bytes, String contentType) {

        static Body json(Object model) {
            try {
                return new Body(Json.writeRequest(model), "application/json");
            } catch (JsonProcessingException e) {
                throw new IllegalStateException("요청을 JSON으로 만들 수 없습니다");
            }
        }

        /**
         * JSON body of an operation whose request schema has both {@code idempotencyKey} and
         * {@code idempotencyTtl}: when the body has a non-null {@code idempotencyKey} and no (or a null)
         * {@code idempotencyTtl}, {@link Bizgo#DEFAULT_IDEMPOTENCY_TTL} is added (Bizgo rejects a key without a TTL
         * with A309). An explicit TTL (including 0) is kept, and nothing is added without a key. Works on request
         * models, maps and {@link JsonNode}s; the caller's object is never changed (the default is added to a
         * copy of the serialized tree).
         */
        static Body jsonWithDefaultTtl(Object model) {
            try {
                JsonNode tree = model instanceof JsonNode node ? node.deepCopy() : Json.requestTree(model);
                if (tree instanceof com.fasterxml.jackson.databind.node.ObjectNode object
                        && object.hasNonNull("idempotencyKey") && !object.hasNonNull("idempotencyTtl")) {
                    object.put("idempotencyTtl", Bizgo.DEFAULT_IDEMPOTENCY_TTL);
                }
                return new Body(Json.writeRequest(tree), "application/json");
            } catch (JsonProcessingException | IllegalArgumentException e) {
                throw new IllegalStateException("요청을 JSON으로 만들 수 없습니다");
            }
        }

        @Override
        public String toString() {
            return "Body{" + contentType + ", " + bytes.length + " bytes}";
        }
    }

    private final String baseUrl;
    private final String apiKey;
    private final Duration timeout;
    private final int maxRetries;
    private final HttpTransport http;
    private final AutoCloseable owned;
    private final Sleeper sleeper;
    private final RateLimiter limiter;
    private final List<RequestHook> hooks;
    private final LongSupplier nanoClock;
    private final String userAgent;

    Transport(String baseUrl, String apiKey, Duration timeout, int maxRetries, HttpTransport http, AutoCloseable owned,
            Sleeper sleeper, RateLimiter limiter, List<RequestHook> hooks, LongSupplier nanoClock) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.timeout = timeout;
        this.maxRetries = maxRetries;
        this.http = http;
        this.owned = owned;
        this.sleeper = sleeper;
        this.limiter = limiter;
        this.hooks = List.copyOf(hooks);
        this.nanoClock = nanoClock;
        this.userAgent = USER_AGENT;
    }

    Transport(String baseUrl, String apiKey, Duration timeout, int maxRetries, HttpTransport http, AutoCloseable owned,
            Sleeper sleeper, RateLimiter limiter, List<RequestHook> hooks, LongSupplier nanoClock, String userAgent) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.timeout = timeout;
        this.maxRetries = maxRetries;
        this.http = http;
        this.owned = owned;
        this.sleeper = sleeper;
        this.limiter = limiter;
        this.hooks = List.copyOf(hooks);
        this.nanoClock = nanoClock;
        this.userAgent = userAgent;
    }

    /**
     * {@code bizgo-sdk-comm-java/<ver> java/<ver> (<os>; <arch>)[ app/<name>-<ver>]}. Only coarse OS and CPU
     * names: never the host name, user name or kernel version.
     */
    static String userAgent(String appName, String appVersion) {
        String agent = SDK_NAME + "/" + Bizgo.VERSION + " java/" + System.getProperty("java.version") + " ("
                + osName(System.getProperty("os.name", "")) + "; " + archName(System.getProperty("os.arch", "")) + ")";
        return appName == null ? agent : agent + " app/" + appName + "-" + appVersion;
    }

    /** Validates {@code appInfo}: letters, digits and {@code ._-} (version also {@code +}), so no header injection. */
    static void checkAppInfo(String name, String version) {
        if (name == null || !APP_NAME.matcher(name).matches()) {
            throw new io.github.icommapi.bizgo.errors.ConfigurationException(
                    "appInfo 이름은 영문·숫자·'.'·'_'·'-' 1~50자여야 합니다");
        }
        if (version == null || !APP_VERSION.matcher(version).matches()) {
            throw new io.github.icommapi.bizgo.errors.ConfigurationException(
                    "appInfo 버전은 영문·숫자·'.'·'_'·'+'·'-' 1~30자여야 합니다");
        }
    }

    static String osName(String value) {
        String v = value.toLowerCase(java.util.Locale.ROOT);
        if (v.startsWith("linux")) {
            return "linux";
        }
        if (v.startsWith("windows")) {
            return "windows";
        }
        if (v.startsWith("mac") || v.startsWith("darwin")) {
            return "darwin";
        }
        if (v.startsWith("freebsd")) {
            return "freebsd";
        }
        return "other";
    }

    static String archName(String value) {
        String v = value.toLowerCase(java.util.Locale.ROOT);
        switch (v) {
            case "amd64":
            case "x86_64":
            case "x64":
                return "x64";
            case "aarch64":
            case "arm64":
            case "armv8":
            case "armv8l":
                return "arm64";
            case "x86":
            case "i386":
            case "i486":
            case "i586":
            case "i686":
                return "x86";
            default:
                return v.startsWith("arm") ? "arm" : "other";
        }
    }

    /** Send-bucket cost: the number of {@code destinations} in a JSON body (at least 1). */
    static int cost(Operation op, Body body) {
        if (op.getRateBucket() != Operation.RateBucket.SEND || body == null
                || !body.contentType().startsWith("application/json")) {
            return 1;
        }
        try {
            JsonNode destinations = Json.readTree(body.bytes()).get("destinations");
            return destinations != null && destinations.isArray() ? Math.max(1, destinations.size()) : 1;
        } catch (IOException e) {
            return 1;
        }
    }

    String baseUrl() {
        return baseUrl;
    }

    @Override
    public void close() {
        if (owned != null) {
            try {
                owned.close();
            } catch (Exception ignored) {
                // nothing useful to report
            }
        }
    }

    @Override
    public String toString() {
        return "Transport{baseUrl=" + baseUrl + "}";
    }

    // ------------------------------------------------------------------ calls used by the resources

    /** Sends a request and converts the whole successful envelope to {@code type}. */
    <T> T call(Operation op, Retry retry, String path, Map<String, String> query, Body body, Class<T> type) {
        return execute(op, retry, path, query, null, body, result -> Json.treeToValue(result.body, type));
    }

    /**
     * Sends a request, converts the envelope to {@code type} and maps it with {@code mapper}. Any failure of the
     * conversion or the mapping (a {@code null} list entry, a wrong shape) becomes an
     * {@link InvalidResponseException} that the hooks see as a failure (SDK-DESIGN 12.1).
     */
    <T, R> R call(Operation op, Retry retry, String path, Map<String, String> query, Body body, Class<T> type,
            java.util.function.Function<T, R> mapper) {
        return execute(op, retry, path, query, null, body, result -> mapper.apply(Json.treeToValue(result.body, type)));
    }

    /** One page of a paginated operation: the whole body and the converted items. */
    record Page<T>(JsonNode body, List<T> items) {
    }

    /** Returns the successful response body and the items at {@code itemsPath}, converted within the call. */
    <T> Page<T> raw(Operation op, String path, Map<String, String> query, Map<String, String> headers, Body body,
            String itemsPath, Class<T> type) {
        return execute(op, op.retry(), path, query, headers, body,
                result -> new Page<>(result.body, convertList(Paging.at(result.body, itemsPath), type)));
    }

    /** Returns the part of the response at {@code resultPath}; an empty object if it is missing. */
    <T> T object(Operation op, String path, Map<String, String> query, Map<String, String> headers, Body body,
            String resultPath, Class<T> type) {
        return execute(op, op.retry(), path, query, headers, body, result -> {
            JsonNode node = Paging.at(result.body, resultPath);
            if (node == null || node.isNull() || node.isMissingNode()) {
                node = JsonNodeFactory.instance.objectNode();
            }
            return Json.treeToValue(node, type);
        });
    }

    /** Returns the list at {@code resultPath}; empty if it is missing. */
    <T> List<T> list(Operation op, String path, Map<String, String> query, Map<String, String> headers, Body body,
            String resultPath, Class<T> type) {
        return execute(op, op.retry(), path, query, headers, body,
                result -> convertList(Paging.at(result.body, resultPath), type));
    }

    /** Sends a request whose response carries no data. */
    void empty(Operation op, String path, Map<String, String> query, Map<String, String> headers, Body body) {
        execute(op, op.retry(), path, query, headers, body, result -> null);
    }

    static <T> List<T> convertList(JsonNode node, Class<T> type) throws JsonProcessingException {
        if (node == null || node.isNull() || node.isMissingNode()) {
            return List.of();
        }
        if (!node.isArray()) {
            throw new IllegalArgumentException("not a list");
        }
        List<T> items = new ArrayList<>(node.size());
        for (JsonNode item : node) {
            if (item == null || item.isNull()) {
                throw new IllegalArgumentException("null item");
            }
            items.add(Json.treeToValue(item, type));
        }
        return java.util.Collections.unmodifiableList(items);
    }

    // ------------------------------------------------------------------ execution

    /** The successful response. */
    record Result(int status, JsonNode body) {

        String trackingId() {
            JsonNode id = body.path("common").get("infobankTrId");
            return id == null || !id.isValueNode() ? null : id.asText();
        }
    }

    /** Converts a successful response; may throw anything, which becomes an {@link InvalidResponseException}. */
    @FunctionalInterface
    interface Converter<R> {
        R convert(Result result) throws Exception;
    }

    /** The response did not fit: keeps status, tracking id and body; for sends, says it may have been accepted. */
    static InvalidResponseException invalid(Operation op, Result result) {
        String message = "응답 형식이 문서와 다릅니다(HTTP " + result.status + ")";
        if (op.getRateBucket() == Operation.RateBucket.SEND) {
            message += ". 요청은 접수됐을 수 있으니 다시 보내기 전에 상태 조회 API로 확인하세요";
        }
        return new InvalidResponseException(message, result.status, result.trackingId(), result.body);
    }

    private <R> R execute(Operation op, Retry retry, String path, Map<String, String> query,
            Map<String, String> extraHeaders, Body body, Converter<R> converter) {
        URI uri = URI.create(baseUrl + path + queryString(query));
        Map<String, String> headers = headers(extraHeaders, body);
        byte[] bytes = body == null ? new byte[0] : body.bytes();
        int cost = cost(op, body);
        RequestEvent event = new RequestEvent(op);
        for (RequestHook hook : hooks) {
            safely(() -> hook.onRequestStart(event));
        }
        long callStarted = nanoClock.getAsLong();
        int attempts = 0;
        Integer lastStatus = null;
        Throwable failure = null;
        try {
            for (int attempt = 0; ; attempt++) {
                boolean last = attempt >= maxRetries;
                acquire(op, cost); // every attempt, retries included
                attempts = attempt + 1;
                long started = System.nanoTime();
                HttpTransport.Response response;
                try {
                    response = http.execute(new HttpTransport.Request(op.getHttpMethod(), uri, headers, bytes, timeout));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log(op, path, "InterruptedException", started, attempt);
                    throw new ApiConnectionException("요청이 중단됐습니다(InterruptedException)");
                } catch (IOException | RuntimeException e) {
                    log(op, path, e.getClass().getSimpleName(), started, attempt);
                    lastStatus = null;
                    if (last || !shouldRetry(retry, null)) {
                        throw connectionError(e);
                    }
                    pause(backoff(attempt, null));
                    continue;
                }
                int status = response.status();
                lastStatus = status;
                log(op, path, String.valueOf(status), started, attempt);
                if (!last && shouldRetry(retry, status)) {
                    pause(backoff(attempt, retryAfter(response)));
                    continue;
                }
                Result result;
                try {
                    result = new Result(status, parse(response));
                } catch (ApiException error) {
                    throw afterRetry(error, attempt > 0);
                }
                try {
                    return converter.convert(result);
                } catch (io.github.icommapi.bizgo.errors.BizgoException e) {
                    throw e;
                } catch (Exception e) {
                    // Jackson messages can quote response values (phone numbers): do not chain or copy them.
                    throw invalid(op, result);
                }
            }
        } catch (RuntimeException | Error e) {
            failure = e;
            throw e;
        } finally {
            Duration duration = Duration.ofNanos(Math.max(0, nanoClock.getAsLong() - callStarted));
            ErrorLayer layer = failure instanceof ApiException ? ((ApiException) failure).getLayer() : null;
            String code = failure instanceof ApiException ? ((ApiException) failure).getCode() : null;
            event.finish(lastStatus, layer, code, failure == null ? null : failure.getClass().getSimpleName(), attempts,
                    duration);
            for (RequestHook hook : hooks) {
                safely(() -> hook.onRequestEnd(event));
            }
        }
    }

    private void acquire(Operation op, int cost) {
        if (limiter == null) {
            return;
        }
        try {
            limiter.acquire(op.getRateBucket(), cost);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiConnectionException("속도 제한 대기 중 중단됐습니다(InterruptedException)");
        }
    }

    private final java.util.concurrent.atomic.AtomicBoolean hookWarned = new java.util.concurrent.atomic.AtomicBoolean();

    /**
     * Runs a user callback (hook). Whatever it throws never changes the result, the retries or bulk results
     * (SDK-DESIGN 12.15); the first failure is logged once at WARNING with the exception class only.
     */
    private void safely(Runnable action) {
        try {
            action.run();
        } catch (RuntimeException | StackOverflowError | LinkageError | AssertionError e) {
            if (hookWarned.compareAndSet(false, true) && LOG.isLoggable(System.Logger.Level.WARNING)) {
                LOG.log(System.Logger.Level.WARNING, "RequestHook threw " + e.getClass().getSimpleName()
                        + "; ignored (logged once per client)");
            }
        }
    }

    Map<String, String> headers(Map<String, String> extra, Body body) {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Authorization", apiKey);
        headers.put("Accept", "application/json");
        headers.put("User-Agent", userAgent);
        headers.put("X-Bizgo-Client", CLIENT_HEADER);
        if (body != null) {
            headers.put("Content-Type", body.contentType());
        }
        if (extra != null) {
            extra.forEach((name, value) -> {
                if (value == null) {
                    return;
                }
                if (headers.keySet().stream().anyMatch(existing -> existing.equalsIgnoreCase(name))) {
                    throw new ValidationException(name, "이 헤더는 설정할 수 없습니다");
                }
                if (value.chars().anyMatch(c -> c < 0x20 || c == 0x7f)) {
                    throw new ValidationException(name, "헤더 값에 제어 문자를 쓸 수 없습니다");
                }
                headers.put(name, value);
            });
        }
        return headers;
    }

    private static ApiConnectionException connectionError(Exception e) {
        String name = e.getClass().getSimpleName();
        if (e instanceof HttpTimeoutException) {
            return new ApiTimeoutException("요청 시간이 초과됐습니다(" + name + ")");
        }
        return new ApiConnectionException("서버에 연결하지 못했습니다(" + name + ")");
    }

    static boolean shouldRetry(Retry policy, Integer status) {
        if (status != null && status == 429) {
            return true;
        }
        if (policy == Retry.RATE_LIMIT_ONLY) {
            return false;
        }
        return status == null || RETRYABLE_STATUS.contains(status);
    }

    static Duration retryAfter(HttpTransport.Response response) {
        String value = response.header("Retry-After");
        if (value == null) {
            return null;
        }
        try {
            double seconds = Double.parseDouble(value.strip());
            if (Double.isNaN(seconds) || Double.isInfinite(seconds) || seconds < 0) {
                return null; // only finite values >= 0 (SDK-DESIGN 12.9); otherwise the default backoff
            }
            seconds = Math.min(seconds, MAX_RETRY_AFTER_SECONDS);
            return Duration.ofMillis(Math.round(seconds * 1000));
        } catch (NumberFormatException e) {
            return null; // HTTP-date form is not supported; fall back to exponential backoff
        }
    }

    static Duration backoff(int attempt, Duration retryAfter) {
        if (retryAfter != null) {
            return retryAfter;
        }
        double base = Math.min(0.5 * Math.pow(2, attempt), MAX_BACKOFF_SECONDS);
        double jitter = ThreadLocalRandom.current().nextDouble(0.75, 1.25);
        return Duration.ofMillis(Math.round(base * jitter * 1000));
    }

    private void pause(Duration duration) {
        try {
            sleeper.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiConnectionException("재시도 대기 중 중단됐습니다(InterruptedException)");
        }
    }

    /** Returns the JSON body, or throws the matching {@link ApiException}. */
    private static JsonNode parse(HttpTransport.Response response) {
        int status = response.status();
        JsonNode body = null;
        byte[] bytes = response.bodyUnsafe();
        if (bytes.length > MAX_RESPONSE_BYTES) {
            throw new InvalidResponseException("응답 본문이 너무 큽니다", status);
        }
        if (bytes.length > 0) {
            try {
                body = Json.readTree(bytes);
            } catch (IOException e) {
                body = null;
            }
        }
        if (status >= 300 && status < 400) {
            // Redirects are never followed: the Authorization header (the API key) could go to another server.
            throw new InvalidResponseException("HTTP " + status + ": 리다이렉트 응답입니다. SDK는 API Key 보호를 위해 "
                    + "리다이렉트를 따르지 않습니다. baseUrl이 올바른지(https, 경로 없이) 확인하세요", status);
        }
        if (body == null || !body.isObject()) {
            if (status >= 400) {
                throw ErrorMapper.create(status, null, "응답 본문이 JSON이 아닙니다(HTTP " + status + ")",
                        ErrorLayer.GATEWAY, null, null, retryAfter(response));
            }
            throw new InvalidResponseException("응답 본문이 JSON 객체가 아닙니다(HTTP " + status + ")", status);
        }
        JsonNode common = body.path("common");
        JsonNode data = body.get("data");
        if (data != null && !data.isObject()) {
            data = null;
        }
        String trackingId = text(common.get("infobankTrId"));
        String authCode = text(common.get("authCode"));
        String serviceCode = data == null ? null : text(data.get("code"));
        Duration retryAfter = retryAfter(response);
        if (authCode != null && !"A000".equals(authCode)) {
            String message = String.valueOf(firstNonNull(text(common.get("authResult")), ""));
            throw ErrorMapper.create(status, authCode, message, ErrorLayer.GATEWAY, trackingId, body, retryAfter);
        }
        if (serviceCode != null && !"A000".equals(serviceCode)) {
            String message = String.valueOf(firstNonNull(text(data.get("result")), ""));
            throw ErrorMapper.create(status, serviceCode, message, ErrorLayer.SERVICE, trackingId, body, retryAfter);
        }
        if (status >= 400) {
            throw ErrorMapper.create(status, null, "요청이 실패했습니다", ErrorLayer.GATEWAY, trackingId, body,
                    retryAfter);
        }
        return body;
    }

    private static String text(JsonNode node) {
        if (node == null || node.isNull() || node.isMissingNode()) {
            return null;
        }
        return node.isValueNode() ? node.asText() : node.toString();
    }

    private static String firstNonNull(String a, String b) {
        return a != null ? a : b;
    }

    /** A301 on a retried attempt (after a network error, a 5xx or a 429): an earlier attempt was accepted. */
    private static ApiException afterRetry(ApiException error, boolean retried) {
        if (error instanceof DuplicateRequestException && retried) {
            return new DuplicateRequestException(
                    "이전 시도가 이미 접수된 것으로 보입니다(재시도한 요청이 A301을 받음). 메시지는 다시 발송되지 않았으며, "
                            + "접수 결과는 상태 조회 API로 확인하세요.",
                    error.getHttpStatus(), error.getCode(), error.getLayer(), error.getTrackingId(), error.getBody(),
                    true);
        }
        return error;
    }

    private static void log(Operation op, String path, String status, long startedNanos, int attempt) {
        if (LOG.isLoggable(System.Logger.Level.DEBUG)) {
            long ms = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startedNanos);
            // path only: query strings can carry phone numbers (for example MO history filters)
            LOG.log(System.Logger.Level.DEBUG,
                    op.getHttpMethod() + " " + path + " -> " + status + " (" + ms + " ms, attempt " + (attempt + 1)
                            + ")");
        }
    }

    static String queryString(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            return "";
        }
        StringJoiner joiner = new StringJoiner("&", "?", "");
        query.forEach((key, value) -> {
            if (value != null) {
                joiner.add(encode(key) + "=" + encode(value));
            }
        });
        return joiner.length() == 1 ? "" : joiner.toString();
    }

    static String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
    }
}
