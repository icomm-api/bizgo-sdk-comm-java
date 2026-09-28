package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.ConfigurationException;
import io.github.icommapi.bizgo.internal.Masking;
import io.github.icommapi.bizgo.models.CounselPersonalInfo;
import io.github.icommapi.bizgo.params.CreateKakaoSenderParams;
import io.github.icommapi.bizgo.testing.FakeTransport;
import java.lang.reflect.Method;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;
import javax.net.ssl.SSLContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** SDK-DESIGN 12 rule 6 (general principle), rule 11 (extended) and rule 19. */
class FinalAlignmentTest {

    private static final String KEY = "test-api-key-not-real";

    // ---- rule 6: uninspectable clients need an explicit opt-in; common needs have SDK options

    @Test
    void customTransportsNeedAnExplicitOptIn() {
        HttpTransport custom = request -> new FakeTransport().execute(request);
        ConfigurationException e = assertThrows(ConfigurationException.class,
                () -> Bizgo.builder().apiKey(KEY).httpTransport(custom).build());
        assertTrue(e.getMessage().contains("trustHttpTransport"));
        Bizgo.builder().apiKey(KEY).httpTransport(custom).trustHttpTransport(true).build().close();
        Bizgo.builder().apiKey(KEY).httpTransport(new FakeTransport()).build().close(); // the SDK's own fake
    }

    @Test
    void httpClientWithCookiesIsRejected() {
        HttpClient withCookies = HttpClient.newBuilder().cookieHandler(new CookieManager()).build();
        assertThrows(ConfigurationException.class, () -> Bizgo.builder().apiKey(KEY).httpClient(withCookies).build());
        HttpClient redirects = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
        assertThrows(ConfigurationException.class, () -> Bizgo.builder().apiKey(KEY).httpClient(redirects).build());
    }

    @Test
    void proxyAndSslContextAreSdkOptions() throws Exception {
        Bizgo.builder().apiKey(KEY).proxy(new InetSocketAddress("localhost", 3128)).sslContext(SSLContext.getDefault())
                .build().close();
        Bizgo.builder().apiKey(KEY).proxy(ProxySelector.of(new InetSocketAddress("localhost", 3128))).build().close();
        assertThrows(ConfigurationException.class, () -> Bizgo.builder().apiKey(KEY)
                .httpClient(HttpClient.newBuilder().build()).sslContext(SSLContext.getDefault()).build());
        assertThrows(ConfigurationException.class, () -> Bizgo.builder().apiKey(KEY).httpTransport(new FakeTransport())
                .proxy(new InetSocketAddress("localhost", 3128)).build());
        for (Method m : Bizgo.Builder.class.getMethods()) {
            String name = m.getName().toLowerCase(java.util.Locale.ROOT);
            assertFalse(name.contains("trustall") || name.contains("insecure") || name.contains("verify"),
                    "no option to turn TLS verification off: " + m.getName());
        }
    }

    // ---- rule 11: masking everywhere, short numbers at least half hidden, person fields

    @Test
    void maskingRules() {
        assertEquals("010****0000", Masking.phone("01000000000"));
        assertEquals("010*****1234", Masking.phone("010001231234"));
        assertEquals("158*****34", Masking.phone("1588123434"));
        assertEquals("158*****4", Masking.phone("158812344"));
        assertEquals("158****4", Masking.phone("15881234"));
        assertEquals("*******", Masking.phone("1234567"));
        assertEquals("***", Masking.phone("12"));
        for (String number : List.of("15881234", "158812344", "1588123434", "01000000000")) {
            long hidden = Masking.phone(number).chars().filter(c -> c == '*').count();
            assertTrue(hidden * 2 >= number.length() - 3, number); // at least half of the digits after the prefix
            assertTrue(hidden >= 4, number);
        }
        assertEquals("홍**", Masking.person("홍길동"));
        assertEquals("u***@***", Masking.person("user@example.com"));
        assertEquals("***(3자)", Masking.length("abc"));
    }

    @Test
    void parameterOptionAndModelObjectsAreMasked() {
        String params = CreateKakaoSenderParams.builder().token("TOKEN_SECRET").phoneNumber("01000000000").build()
                .toString();
        assertTrue(params.contains("phoneNumber=010****0000"), params);
        assertTrue(params.contains("token=***"), params);
        assertFalse(params.contains("TOKEN_SECRET"));

        String mo = MoHistoryQuery.since(LocalDateTime.of(2026, 1, 1, 0, 0)).from("01000001234").to("15881234")
                .toString();
        assertTrue(mo.contains("from=010****1234") && mo.contains("to=158****4"), mo);

        String options = SendOptions.builder().ref("REF_SECRET").idempotencyKey("KEY_SECRET").build().toString();
        assertFalse(options.contains("REF_SECRET") || options.contains("KEY_SECRET"), options);
        String bulk = BulkOptions.builder().idempotencyKeyPrefix("PREFIX_SECRET").build().toString();
        assertFalse(bulk.contains("PREFIX_SECRET"), bulk);

        CounselPersonalInfo info = CounselPersonalInfo.builder().nickname("홍길동").phone_number("01000000000").build();
        assertTrue(info.toString().contains("nickname=홍**"), info.toString());
        assertTrue(info.toString().contains("phone_number=010****0000"), info.toString());
        assertEquals("홍길동", info.getNickname(), "values are unchanged");

        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            client.send().sms("01000001234", "01000000000", "private text");
        }
        String recorded = fake.lastRequest().toString();
        assertFalse(recorded.contains("01000001234") || recorded.contains("private text"), recorded);
    }

    // ---- rule 19: never null for a success response

    static Stream<Operation> valueOperations() {
        return Operation.all().stream();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("valueOperations")
    void successWithoutDataIsAnEmptyResultNotNull(Operation op) {
        for (String body : List.of("{\"common\":{\"authCode\":\"A000\"},\"data\":{\"code\":\"A000\"}}",
                "{\"common\":{\"authCode\":\"A000\"},\"data\":{\"code\":\"A000\",\"data\":null}}",
                "{\"common\":{\"authCode\":\"A000\"},\"data\":null}")) {
            FakeTransport fake = new FakeTransport();
            fake.on(op.getOperationId()).thenRespond(200, body);
            try (Bizgo client = fake.clientBuilder().maxRetries(0).build()) {
                Method method = OperationsTest.method(OperationsTest.resource(client, op), op.getMethod());
                Object result = OperationsTest.call(client, op);
                if (method.getReturnType() == void.class) {
                    continue;
                }
                assertNotNull(result, op + " with " + body);
                if (result instanceof List) {
                    assertTrue(((List<?>) result).isEmpty(), op.toString());
                }
            }
        }
    }
}
