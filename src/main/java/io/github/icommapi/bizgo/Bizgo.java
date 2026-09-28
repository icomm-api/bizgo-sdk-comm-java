package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ConfigurationException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.LongSupplier;

/**
 * Bizgo Communication API client.
 *
 * <pre>{@code
 * try (Bizgo client = Bizgo.builder().environment(Environment.SANDBOX).build()) {  // key from BIZGO_API_KEY
 *     SendResult result = client.send().sms("01000000000", "01000000000", "[비즈고] 인증번호는 123456 입니다.");
 *     System.out.println(result.getMsgKeys() + " " + result.getFailed());
 * }
 * }</pre>
 *
 * <p>A client is thread-safe; create one per API key and reuse it. The key and the settings belong to this instance
 * only (nothing is shared between clients). {@link #toString()} never shows the key.
 *
 * <p>Besides the hand-written resources ({@link #send()}, {@link #files()}, {@link #reports()}, {@link #messages()}),
 * every operation of the API is available through the resources generated from the spec, for example
 * {@code client.alimtalk().templates().list(...)} or {@code client.reservations().create(...)} (see
 * {@link BizgoResources}).
 */
public final class Bizgo extends BizgoResources implements AutoCloseable {

    /** SDK version. */
    public static final String VERSION = "1.2.0";
    /** Environment variable read when no API key is given. */
    public static final String API_KEY_ENV = "BIZGO_API_KEY";
    /** Default total timeout of one request attempt. */
    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(30);
    /** Default connect timeout. */
    public static final Duration DEFAULT_CONNECT_TIMEOUT = Duration.ofSeconds(5);
    /** Default number of retries. */
    public static final int DEFAULT_MAX_RETRIES = 2;
    /**
     * {@code idempotencyTtl} (seconds, 24 hours) sent when an {@code idempotencyKey} is set without a TTL.
     *
     * <p>Bizgo rejects a request that has {@code idempotencyKey} but no {@code idempotencyTtl} (A309; the TTL range
     * is 0 to 86,400 seconds), so the SDK adds this value to every request body with a key and no TTL: the send
     * methods ({@code omni}/{@code sms}/{@code lms}/{@code mms}/{@code request}), every chunk of {@code bulk} with
     * an {@code idempotencyKeyPrefix}, and generated operations whose request body has both fields. An explicit TTL
     * (including 0) is sent as given, and no TTL is added when there is no key. The caller's objects are not
     * changed.
     */
    public static final int DEFAULT_IDEMPOTENCY_TTL = 86400;

    /** The testing module's fake, the only HttpTransport accepted without {@code trustHttpTransport(true)}. */
    static final String FAKE_TRANSPORT = "io.github.icommapi.bizgo.testing.FakeTransport";

    private static final Set<String> LOCAL_HOSTS = Set.of("localhost", "127.0.0.1", "::1", "[::1]");

    private final Transport transport;
    private final SendService send;
    private final FileService files;
    private final ReportService reports;
    private final MessageService messages;

    private Bizgo(Builder builder) {
        this(createTransport(builder));
    }

    private Bizgo(Transport transport) {
        super(transport);
        this.transport = transport;
        this.send = new SendService(transport);
        this.files = new FileService(transport);
        this.reports = new ReportService(transport);
        this.messages = new MessageService(transport);
    }

    private static Transport createTransport(Builder builder) {
        String apiKey = resolveApiKey(builder.apiKey, builder.env);
        String baseUrl = resolveBaseUrl(builder.environment, builder.baseUrl);
        if (builder.maxRetries < 0) {
            throw new ConfigurationException("maxRetries는 0 이상이어야 합니다");
        }
        requirePositive(builder.timeout, "timeout");
        requirePositive(builder.connectTimeout, "connectTimeout");
        HttpTransport http = builder.httpTransport;
        AutoCloseable owned = null;
        boolean sdkOptions = builder.proxy != null || builder.sslContext != null;
        if (http != null) {
            if (builder.httpClient != null) {
                throw new ConfigurationException("httpClient와 httpTransport는 함께 설정할 수 없습니다");
            }
            if (sdkOptions) {
                throw new ConfigurationException("proxy/sslContext는 httpTransport와 함께 쓸 수 없습니다");
            }
            if (!builder.trustHttpTransport && !FAKE_TRANSPORT.equals(http.getClass().getName())) {
                // An HttpTransport is code the SDK cannot inspect: it could follow redirects, retry, add its own
                // authentication or log the key (SDK-DESIGN 12.6). Only an explicit opt-in allows it.
                throw new ConfigurationException("직접 구현한 httpTransport는 SDK가 안전 설정(리다이렉트·재시도·자체 인증 끔)을 "
                        + "확인할 수 없어 기본으로 거부합니다. 구현이 이를 지킨다면 trustHttpTransport(true)로 명시적으로 허용하세요. "
                        + "프록시·인증서가 필요하면 proxy(...)/sslContext(...)를 쓰세요");
            }
        } else {
            HttpClient client = builder.httpClient;
            boolean owns = client == null;
            if (client != null && sdkOptions) {
                throw new ConfigurationException("proxy/sslContext는 httpClient와 함께 쓸 수 없습니다(그 HttpClient에 직접 설정하세요)");
            }
            if (client == null) {
                HttpClient.Builder http2 = HttpClient.newBuilder()
                        .connectTimeout(builder.connectTimeout)
                        .followRedirects(HttpClient.Redirect.NEVER);
                if (builder.proxy != null) {
                    http2.proxy(builder.proxy);
                }
                if (builder.sslContext != null) {
                    http2.sslContext(builder.sslContext);
                }
                client = http2.build();
            } else if (client.cookieHandler().isPresent()) {
                // cookies are server-set state the SDK does not use; a shared handler could leak them across clients
                throw new ConfigurationException("httpClient에 CookieHandler를 설정할 수 없습니다. SDK는 쿠키를 쓰지 않으며 "
                        + "저장된 쿠키가 요청에 섞일 수 있습니다");
            } else if (client.followRedirects() != HttpClient.Redirect.NEVER) {
                // A redirect could forward the Authorization header (the API key) to another server.
                throw new ConfigurationException(
                        "httpClient는 리다이렉트를 따르지 않도록(HttpClient.Redirect.NEVER) 설정해야 합니다");
            } else if (client.authenticator().isPresent()) {
                // An Authenticator makes HttpClient drop our Authorization header and resend the request (a send can
                // go out several times) with its own credentials after a 401 (SDK-DESIGN 12.6).
                throw new ConfigurationException("httpClient에 Authenticator를 설정할 수 없습니다. HttpClient의 자동 인증은 "
                        + "SDK의 Authorization 헤더(API Key)를 바꾸고 401 뒤 요청(발송 포함)을 다시 보냅니다. "
                        + "프록시 인증이 필요하면 Authenticator 없는 HttpClient와 프록시 설정을 쓰세요");
            }
            JdkHttpTransport jdk = new JdkHttpTransport(client, owns);
            http = jdk;
            owned = jdk;
        }
        RateLimiter limiter = builder.rateLimit == null ? null
                : new RateLimiter(builder.rateLimit, builder.nanoClock, builder.sleeper);
        if (builder.appName != null || builder.appVersion != null) {
            Transport.checkAppInfo(builder.appName, builder.appVersion);
        }
        return new Transport(baseUrl, apiKey, builder.timeout, builder.maxRetries, http, owned, builder.sleeper,
                limiter, builder.hooks, builder.nanoClock, Transport.userAgent(builder.appName, builder.appVersion));
    }

    /**
     * Starts building a client.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Sending: {@code POST /api/comm/v1/send/omni}.
     *
     * @return the send resource
     */
    public SendService send() {
        return send;
    }

    /**
     * Image uploads: {@code POST /api/comm/v1/file/*}.
     *
     * @return the file resource
     */
    public FileService files() {
        return files;
    }

    /**
     * Delivery reports: {@code /api/comm/v1/report/*}.
     *
     * @return the report resource
     */
    public ReportService reports() {
        return reports;
    }

    /**
     * Message status, history and statistics: {@code /api/comm/v1/message/*}.
     *
     * @return the message resource
     */
    public MessageService messages() {
        return messages;
    }

    /**
     * The server this client talks to.
     *
     * @return base URL without a trailing slash
     */
    public String baseUrl() {
        return transport.baseUrl();
    }

    /** Releases the HTTP client if this client created it (Java 21+). A client passed to the builder is not closed. */
    @Override
    public void close() {
        transport.close();
    }

    /** Shows the base URL only, never the API key. */
    @Override
    public String toString() {
        return "Bizgo{baseUrl=" + transport.baseUrl() + "}";
    }

    static String resolveApiKey(String apiKey, Function<String, String> env) {
        String key = apiKey != null ? apiKey : env.apply(API_KEY_ENV);
        key = key == null ? "" : key; // no silent trimming (SDK-DESIGN 12.16): the key must be exactly [\x21-\x7e]+
        if (key.isEmpty()) {
            throw new ConfigurationException("API Key가 없습니다. apiKey(...)로 넘기거나 환경변수 " + API_KEY_ENV
                    + "에 설정하세요. 키는 코드에 직접 쓰지 말고 환경변수나 시크릿 저장소에서 읽어 오세요.");
        }
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (Character.isWhitespace(c) || Character.isSpaceChar(c)) {
                throw new ConfigurationException(
                        "API Key에 공백이 있습니다. 'Bearer '나 'ApiKey ' 같은 접두어 없이 키만 넣으세요.");
            }
            if (c < 0x21 || c > 0x7e) {
                throw new ConfigurationException("API Key에 쓸 수 없는 문자가 있습니다. 콘솔에서 받은 키를 그대로 넣으세요.");
            }
        }
        return key;
    }

    static String resolveBaseUrl(Environment environment, String baseUrl) {
        String url = baseUrl != null ? baseUrl.strip() : Objects.requireNonNullElse(environment, Environment.PRODUCTION)
                .baseUrl();
        while (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new ConfigurationException("baseUrl 형식이 올바르지 않습니다");
        }
        String scheme = uri.getScheme() == null ? "" : uri.getScheme().toLowerCase(Locale.ROOT);
        String host = uri.getHost() == null ? "" : uri.getHost().toLowerCase(Locale.ROOT);
        if (host.isEmpty()) {
            throw new ConfigurationException("baseUrl에 호스트가 없습니다");
        }
        if (uri.getRawUserInfo() != null || uri.getRawQuery() != null || uri.getRawFragment() != null) {
            throw new ConfigurationException("baseUrl에는 사용자 정보, 쿼리, fragment를 넣을 수 없습니다");
        }
        boolean local = LOCAL_HOSTS.contains(host);
        if (!"https".equals(scheme) && !("http".equals(scheme) && local)) {
            // The API key travels in a header, so it must never be sent over plain HTTP.
            throw new ConfigurationException("baseUrl은 https여야 합니다(테스트용 localhost 제외): " + scheme + "://" + host);
        }
        return url;
    }

    private static void requirePositive(Duration value, String name) {
        if (value == null || value.isZero() || value.isNegative()) {
            throw new ConfigurationException(name + "는 0보다 커야 합니다");
        }
    }

    /**
     * Builder for {@link Bizgo}.
     *
     * <pre>{@code
     * Bizgo client = Bizgo.builder()
     *         .apiKey(System.getenv("BIZGO_API_KEY"))   // optional: this is the default
     *         .environment(Environment.SANDBOX)
     *         .timeout(Duration.ofSeconds(10))
     *         .maxRetries(3)
     *         .build();
     * }</pre>
     */
    public static final class Builder {
        private String apiKey;
        private Environment environment = Environment.PRODUCTION;
        private String baseUrl;
        private Duration timeout = DEFAULT_TIMEOUT;
        private Duration connectTimeout = DEFAULT_CONNECT_TIMEOUT;
        private int maxRetries = DEFAULT_MAX_RETRIES;
        private HttpClient httpClient;
        private Function<String, String> env = System::getenv;
        private Sleeper sleeper = Sleeper.SYSTEM;
        private HttpTransport httpTransport;
        private RateLimit rateLimit = RateLimit.DEFAULT;
        private final List<RequestHook> hooks = new ArrayList<>();
        private LongSupplier nanoClock = System::nanoTime;
        private String appName;
        private String appVersion;
        private boolean trustHttpTransport;
        private java.net.ProxySelector proxy;
        private javax.net.ssl.SSLContext sslContext;

        private Builder() {
        }

        /**
         * Integrated API key from the console ({@code 발송관리 > 연동관리}). Defaults to the {@code BIZGO_API_KEY}
         * environment variable. Pass the key only, without {@code Bearer }/{@code ApiKey } prefixes. Never hard-code
         * it.
         *
         * @param apiKey the key
         * @return this builder
         */
        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * {@link Environment#PRODUCTION} (default, real sends) or {@link Environment#SANDBOX}.
         *
         * @param environment server
         * @return this builder
         */
        public Builder environment(Environment environment) {
            this.environment = environment;
            return this;
        }

        /**
         * Overrides the server URL. It must be https, except {@code http://localhost} for mock servers in tests.
         *
         * @param baseUrl URL such as {@code https://mars.ibapi.kr}
         * @return this builder
         */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /**
         * Total timeout of one request attempt (default 30 seconds).
         *
         * @param timeout timeout
         * @return this builder
         */
        public Builder timeout(Duration timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * Connect timeout (default 5 seconds). Ignored when you pass your own {@link #httpClient(HttpClient)}.
         *
         * @param connectTimeout timeout
         * @return this builder
         */
        public Builder connectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        /**
         * Retries for rate limits and transient errors (default 2). Sends are retried after a timeout or a 5xx only
         * when they have an {@code idempotencyKey}.
         *
         * @param maxRetries retries, 0 to disable
         * @return this builder
         */
        public Builder maxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
            return this;
        }

        /**
         * Your own {@link HttpClient} (proxy, custom TLS trust store, executor). It must not follow redirects, and it
         * is not closed by {@link Bizgo#close()}.
         *
         * @param httpClient client
         * @return this builder
         */
        public Builder httpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        /**
         * Sends requests through a proxy (the client the SDK creates uses it). Cannot be combined with
         * {@link #httpClient(HttpClient)} or {@link #httpTransport(HttpTransport)}.
         *
         * @param proxy proxy selector, null for none
         * @return this builder
         */
        public Builder proxy(java.net.ProxySelector proxy) {
            this.proxy = proxy;
            return this;
        }

        /**
         * Sends requests through an HTTP proxy at {@code address}.
         *
         * @param address proxy host and port
         * @return this builder
         */
        public Builder proxy(java.net.InetSocketAddress address) {
            this.proxy = address == null ? null : java.net.ProxySelector.of(address);
            return this;
        }

        /**
         * TLS settings for the client the SDK creates, for example a trust store with your company's CA. Certificate
         * and host name verification stay on: there is no option to turn them off.
         *
         * @param sslContext initialised SSL context, null for the JDK default
         * @return this builder
         */
        public Builder sslContext(javax.net.ssl.SSLContext sslContext) {
            this.sslContext = sslContext;
            return this;
        }

        /**
         * Allows a custom {@link HttpTransport} (default false). The SDK cannot inspect such code, so it is refused
         * unless you confirm it does <b>not</b> follow redirects, retry, add its own authentication or cookies, or
         * log the headers (API key) or the URL (phone numbers), and uses TLS. {@code FakeTransport} from the testing
         * module does not need this.
         *
         * @param trust true to allow a custom transport
         * @return this builder
         */
        public Builder trustHttpTransport(boolean trust) {
            this.trustHttpTransport = trust;
            return this;
        }

        /**
         * Replaces the HTTP layer, for example with {@code FakeTransport} from the testing module. Any other
         * implementation needs {@link #trustHttpTransport(boolean) trustHttpTransport(true)}. The transport
         * receives the API key header and the full URL: use only implementations you trust. Cannot be combined with
         * {@link #httpClient(HttpClient)}.
         *
         * @param httpTransport transport, null for the default {@link HttpClient}
         * @return this builder
         */
        public Builder httpTransport(HttpTransport httpTransport) {
            this.httpTransport = httpTransport;
            return this;
        }

        /**
         * Client-side rate limit (default {@link RateLimit#DEFAULT}: send 200/s, other 5/s). It is per client
         * instance, so it does not cover several processes or servers sharing one API key.
         *
         * @param rateLimit limit, or null to turn client-side limiting off
         * @return this builder
         */
        public Builder rateLimit(RateLimit rateLimit) {
            this.rateLimit = rateLimit;
            return this;
        }

        /**
         * Adds a hook that observes every call (metrics, tracing). Hooks never see bodies, queries, header values,
         * path values or the API key.
         *
         * @param hook hook
         * @return this builder
         */
        public Builder hook(RequestHook hook) {
            if (hook == null) {
                throw new ConfigurationException("hook이 null입니다");
            }
            this.hooks.add(hook);
            return this;
        }

        /**
         * Adds your application to the User-Agent ({@code ... app/<name>-<version>}) so Bizgo can tell your
         * integrations apart. Use a product name, never an e-mail address, phone number or other personal data.
         *
         * @param name {@code [A-Za-z0-9._-]}, 1 to 50 characters
         * @param version {@code [A-Za-z0-9._+-]}, 1 to 30 characters
         * @return this builder
         * @throws ConfigurationException (from {@link #build()}) if a value has other characters or is too long
         */
        public Builder appInfo(String name, String version) {
            this.appName = name;
            this.appVersion = version;
            return this;
        }

        /** For tests: monotonic clock of the rate limiter and the hook durations. */
        Builder nanoClock(LongSupplier nanoClock) {
            this.nanoClock = nanoClock;
            return this;
        }

        /** For tests: where the API key is looked up when none is given. */
        Builder env(Function<String, String> env) {
            this.env = env;
            return this;
        }

        /** For tests: how retries wait. */
        Builder sleeper(Sleeper sleeper) {
            this.sleeper = sleeper;
            return this;
        }

        /**
         * Creates the client.
         *
         * @return the client
         * @throws ConfigurationException if the API key is missing or invalid, or the base URL is not https
         */
        public Bizgo build() {
            return new Bizgo(this);
        }
    }
}
