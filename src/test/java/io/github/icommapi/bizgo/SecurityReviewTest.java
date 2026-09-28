package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.ApiException;
import io.github.icommapi.bizgo.errors.BizgoException;
import io.github.icommapi.bizgo.errors.BulkSendException;
import io.github.icommapi.bizgo.errors.ConfigurationException;
import io.github.icommapi.bizgo.errors.DuplicateRequestException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.errors.InvalidResponseException;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.errors.WebhookVerificationException;
import io.github.icommapi.bizgo.internal.Json;
import io.github.icommapi.bizgo.models.BulkSendResult;
import io.github.icommapi.bizgo.models.FileUploadResult;
import io.github.icommapi.bizgo.models.RcsFileUploadResult;
import io.github.icommapi.bizgo.models.SendResult;
import io.github.icommapi.bizgo.models.SmsMessage;
import io.github.icommapi.bizgo.testing.FakeTransport;
import io.github.icommapi.bizgo.testing.WebhookSigner;
import io.github.icommapi.bizgo.webhooks.WebhookReceiver;
import io.github.icommapi.bizgo.webhooks.Webhooks;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

/** Regression tests for the security/usability review (SDK-DESIGN 12). */
class SecurityReviewTest {

    private static final String PHONE = "01000000000";
    private static final SmsMessage SMS = SmsMessage.builder().from(PHONE).text("hi").build();
    private static final String OK = "{\"common\":{\"authCode\":\"A000\",\"infobankTrId\":\"TR1\"},\"data\":{\"code\":"
            + "\"A000\",\"data\":{\"destinations\":[{\"to\":\"01000000000\",\"msgKey\":\"K1\",\"code\":\"A000\"}]}}}";
    private static final String A301 = "{\"common\":{\"authCode\":\"A000\",\"infobankTrId\":\"TR2\"},\"data\":{\"code\":"
            + "\"A301\",\"result\":\"Duplicated\"}}";

    interface Script {
        HttpTransport.Response respond(int attempt) throws IOException;
    }

    static HttpTransport scripted(Script script, List<HttpTransport.Request> seen) {
        AtomicInteger n = new AtomicInteger();
        return request -> {
            seen.add(request);
            return script.respond(n.getAndIncrement());
        };
    }

    static HttpTransport.Response json(int status, String body, String... headers) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (int i = 0; i + 1 < headers.length; i += 2) {
            map.put(headers[i], List.of(headers[i + 1]));
        }
        return new HttpTransport.Response(status, map, body.getBytes(StandardCharsets.UTF_8));
    }

    static Bizgo client(HttpTransport transport) {
        return Bizgo.builder().apiKey("test-api-key-not-real").httpTransport(transport).trustHttpTransport(true).rateLimit(null).maxRetries(2)
                .sleeper(d -> { }).build();
    }

    // ---- F1 / rule 3: bulk idempotency keys

    @Test
    void bulkKeysDependOnSizeStartAndNumbers() {
        List<String> a = List.of("01000000000", "01000001234");
        String key = BulkOptions.idempotencyKey("camp", 2, 4, a);
        assertTrue(key.matches("camp-2-4-[0-9a-f]{8}"), key);
        assertEquals(key, BulkOptions.idempotencyKey("camp", 2, 4, a), "same list, same key");
        assertFalse(key.equals(BulkOptions.idempotencyKey("camp", 2, 4, List.of("01000001234", "01000000000"))),
                "order matters");
        assertFalse(key.equals(BulkOptions.idempotencyKey("camp", 3, 4, a)), "chunk size is part of the key");
        // hash8 = SHA-256("01000000000\n01000001234") first 8 hex digits, same formula as the other SDKs
        assertEquals(sha8("01000000000\n01000001234"), key.substring(key.lastIndexOf('-') + 1));
        assertThrows(ValidationException.class,
                () -> BulkOptions.builder().idempotencyKeyPrefix("p".repeat(BulkOptions.MAX_PREFIX_LENGTH + 1)).build());
        BulkOptions.builder().idempotencyKeyPrefix("p".repeat(BulkOptions.MAX_PREFIX_LENGTH)).build();
        assertTrue(BulkOptions.idempotencyKey("p".repeat(BulkOptions.MAX_PREFIX_LENGTH), 200, Integer.MAX_VALUE, a)
                .length() <= BulkOptions.MAX_KEY_LENGTH);
    }

    private static String sha8(String text) {
        try {
            return java.util.HexFormat.of().formatHex(java.security.MessageDigest.getInstance("SHA-256")
                    .digest(text.getBytes(StandardCharsets.UTF_8))).substring(0, 8);
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    // ---- F2 / rule 6: HttpClient authenticator

    @Test
    void httpClientWithAnAuthenticatorIsRejected() {
        HttpClient http = HttpClient.newBuilder().authenticator(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("user", "pw-not-real".toCharArray());
            }
        }).build();
        ConfigurationException e = assertThrows(ConfigurationException.class,
                () -> Bizgo.builder().apiKey("test-api-key-not-real").httpClient(http).build());
        assertTrue(e.getMessage().contains("Authenticator"));
        assertThrows(ConfigurationException.class, () -> Bizgo.builder().apiKey("test-api-key-not-real")
                .baseUrl("https://user:pw@example.invalid").build());
    }

    // ---- F3 / rule 4: A301 after any retry

    @Test
    void a301AfterA5xxOr429RetryIsAlreadyAccepted() {
        for (int first : new int[] {503, 429}) {
            List<HttpTransport.Request> seen = new ArrayList<>();
            try (Bizgo c = client(scripted(n -> n == 0 ? json(first, "{}", "Retry-After", "0") : json(200, A301),
                    seen))) {
                DuplicateRequestException e = assertThrows(DuplicateRequestException.class,
                        () -> c.send().sms(PHONE, PHONE, "hi", SendOptions.idempotencyKey("idem-1")));
                assertTrue(e.isAlreadyAccepted(), "after " + first);
                assertTrue(e.getMessage().contains("이미 접수"));
            }
            assertEquals(2, seen.size());
        }
        try (Bizgo c = client(scripted(n -> json(200, A301), new ArrayList<>()))) {
            DuplicateRequestException e = assertThrows(DuplicateRequestException.class,
                    () -> c.send().sms(PHONE, PHONE, "hi", SendOptions.idempotencyKey("idem-1")));
            assertFalse(e.isAlreadyAccepted(), "first attempt: a real duplicate");
        }
    }

    // ---- F4 / rule 1: parse failures

    @Test
    void malformedSendResponsesAreInvalidResponseWithContext() {
        String nullDestination = "{\"common\":{\"authCode\":\"A000\",\"infobankTrId\":\"TR3\"},\"data\":{\"code\":\"A000\","
                + "\"data\":{\"destinations\":[null]}}}";
        String wrongShape = "{\"common\":{\"authCode\":\"A000\",\"infobankTrId\":\"TR4\"},\"data\":{\"code\":\"A000\","
                + "\"data\":{\"destinations\":\"oops\"}}}";
        for (String body : List.of(nullDestination, wrongShape)) {
            try (Bizgo c = client(scripted(n -> json(200, body), new ArrayList<>()))) {
                InvalidResponseException e = assertThrows(InvalidResponseException.class,
                        () -> c.send().sms(PHONE, PHONE, "hi"));
                assertEquals(200, e.getHttpStatus());
                assertNotNull(e.getTrackingId());
                assertNotNull(e.getBody());
                assertTrue(e.getMessage().contains("접수됐을 수 있으니"), e.getMessage());
            }
        }
        // not a send: no acceptance hint
        String badList = "{\"common\":{\"authCode\":\"A000\"},\"data\":{\"code\":\"A000\",\"data\":{\"alimtalk\":"
                + "{\"templates\":[null]}}}}";
        try (Bizgo c = client(scripted(n -> json(200, badList), new ArrayList<>()))) {
            InvalidResponseException e = assertThrows(InvalidResponseException.class,
                    () -> c.alimtalk().templates().list(io.github.icommapi.bizgo.params.ListAlimtalkTemplatesParams
                            .builder().senderKey("SENDER_KEY_EXAMPLE").build()));
            assertFalse(e.getMessage().contains("접수됐을 수 있으니"));
        }
    }

    // ---- F10: hooks see conversion failures

    @Test
    void hooksReportConversionFailures() {
        List<RequestEvent> events = new CopyOnWriteArrayList<>();
        String bad = "{\"common\":{\"authCode\":\"A000\"},\"data\":{\"code\":\"A000\",\"data\":{\"destinations\":\"x\",\"reservations\":\"x\"}}}";
        try (Bizgo c = Bizgo.builder().apiKey("test-api-key-not-real").rateLimit(null)
                .httpTransport(scripted(n -> json(200, bad), new ArrayList<>())).trustHttpTransport(true).hook(new RequestHook() {
                    @Override
                    public void onRequestEnd(RequestEvent e) {
                        events.add(e);
                    }
                }).build()) {
            assertThrows(InvalidResponseException.class, () -> c.send().sms(PHONE, PHONE, "hi"));
            assertThrows(InvalidResponseException.class, () -> c.reservations().streamList(
                    io.github.icommapi.bizgo.params.ListReservationsParams.builder().resvSendTime("2026-01-01 00:00:00")
                            .build()).count());
        }
        assertEquals(2, events.size());
        for (RequestEvent e : events) {
            assertFalse(e.isSuccess());
            assertEquals("InvalidResponseException", e.getErrorType());
        }
    }

    // ---- F9 / rule 12: redirects

    @Test
    void redirectsNameTheStatus() {
        try (Bizgo c = client(scripted(n -> json(302, "", "Location", "https://example.invalid/"), new ArrayList<>()))) {
            InvalidResponseException e = assertThrows(InvalidResponseException.class, () -> c.messages().status("K1"));
            assertTrue(e.getMessage().startsWith("HTTP 302"), e.getMessage());
            assertTrue(e.getMessage().contains("리다이렉트"));
        }
    }

    // ---- rule 9: Retry-After

    @Test
    void retryAfterOnlyFiniteNonNegative() {
        for (String value : List.of("-3", "NaN", "Infinity", "1e400", "Wed, 21 Oct 2015 07:28:00 GMT")) {
            assertNull(Transport.retryAfter(json(429, "{}", "Retry-After", value)), value);
        }
        assertEquals(Duration.ofSeconds(60), Transport.retryAfter(json(429, "{}", "Retry-After", "1e308")));
        assertEquals(Duration.ofMillis(1500), Transport.retryAfter(json(429, "{}", "Retry-After", "1.5")));
    }

    // ---- rule 8: nesting depth

    @Test
    void deeplyNestedResponsesAreInvalid() {
        String deep = "{\"common\":{\"authCode\":\"A000\"},\"data\":{\"code\":\"A000\",\"data\":{\"x\":"
                + "[".repeat(Json.MAX_DEPTH + 10) + "]".repeat(Json.MAX_DEPTH + 10) + "}}}";
        try (Bizgo c = client(scripted(n -> json(200, deep), new ArrayList<>()))) {
            assertThrows(InvalidResponseException.class, () -> c.messages().status("K1"));
        }
    }

    // ---- F5, F6 / rule 7: webhook inputs

    @Test
    void webhookTimestampsAreAsciiDigitsUpTo16() {
        byte[] secret = "test-webhook-secret".getBytes(StandardCharsets.UTF_8);
        for (String ts : List.of("9999999999999999999", "12345678901234567", "１２３", "", "12a", "-1", " 1")) {
            assertThrows(WebhookVerificationException.class, () -> Webhooks.verifySignature(secret, ts,
                    WebhookSigner.signature("test-webhook-secret", ts.isEmpty() ? "0" : ts), null, Instant.now()), ts);
        }
        String ok = "1234567890123456";
        Webhooks.verifySignature(secret, ok, WebhookSigner.signature("test-webhook-secret", ok), null, Instant.now());
    }

    @Test
    void webhookConfigurationIsValidated() {
        assertThrows(ConfigurationException.class, () -> new WebhookReceiver("   "));
        assertThrows(ConfigurationException.class, () -> new WebhookReceiver((String) null));
        assertThrows(ConfigurationException.class, () -> new WebhookReceiver("s", Duration.ofSeconds(-5)));
        assertThrows(ConfigurationException.class, () -> new WebhookReceiver("s", Duration.ZERO));
        assertThrows(ConfigurationException.class, () -> WebhookReceiver.builder().secret(" \t").build());
        new WebhookReceiver("s", null); // explicitly disabled
        // deep or malformed bodies are verification errors (4xx), not 500s
        WebhookSigner.SignedWebhook deep = WebhookSigner.sign("s", "{\"msgKey\":" + "[".repeat(3000)
                + "]".repeat(3000) + "}");
        assertThrows(WebhookVerificationException.class, () -> new WebhookReceiver("s").report(deep.headers(),
                deep.body()));
        WebhookSigner.SignedWebhook shape = WebhookSigner.sign("s", "{\"msgKey\":{\"a\":1}}");
        assertThrows(WebhookVerificationException.class, () -> new WebhookReceiver("s").report(shape.headers(),
                shape.body()));
    }

    // ---- F7 / rule 2: bulk keeps accepted chunks

    @Test
    void bulkKeepsAcceptedChunksOnAnError() {
        try (Bizgo c = client(scripted(n -> {
            if (n == 1) {
                throw new StackOverflowError();
            }
            return json(200, OK);
        }, new ArrayList<>()))) {
            BulkSendException e = assertThrows(BulkSendException.class, () -> c.send().bulk(
                    List.of(PHONE, PHONE, PHONE, PHONE), List.of(SMS),
                    BulkOptions.builder().chunkSize(1).concurrency(1).build()));
            BulkSendResult partial = e.getPartialResult();
            assertEquals(3, partial.getResults().size());
            assertEquals(1, partial.getErrors().size());
            assertEquals(1, partial.getErrors().get(0).chunkIndex());
        }
        // a RuntimeException in one chunk is just a chunk error
        try (Bizgo c = client(scripted(n -> {
            if (n == 0) {
                throw new IllegalStateException("bug");
            }
            return json(200, OK);
        }, new ArrayList<>()))) {
            BulkSendResult result = c.send().bulk(List.of(PHONE, PHONE), List.of(SMS),
                    BulkOptions.builder().chunkSize(1).concurrency(1).build());
            assertEquals(1, result.getResults().size());
            assertEquals(1, result.getErrors().size());
        }
    }

    @Test
    void bulkInterruptKeepsResultsAndRestoresTheFlag() throws Exception {
        java.util.concurrent.CountDownLatch firstDone = new java.util.concurrent.CountDownLatch(1);
        java.util.concurrent.CountDownLatch never = new java.util.concurrent.CountDownLatch(1);
        AtomicInteger calls = new AtomicInteger();
        HttpTransport transport = request -> {
            if (calls.getAndIncrement() == 0) {
                firstDone.countDown();
                return json(200, OK);
            }
            try {
                never.await();
            } catch (InterruptedException e) {
                throw new java.io.InterruptedIOException("interrupted");
            }
            return json(200, OK);
        };
        java.util.concurrent.atomic.AtomicReference<Throwable> thrown = new java.util.concurrent.atomic.AtomicReference<>();
        java.util.concurrent.atomic.AtomicBoolean flag = new java.util.concurrent.atomic.AtomicBoolean();
        Thread caller = new Thread(() -> {
            try (Bizgo c = client(transport)) {
                c.send().bulk(List.of(PHONE, PHONE), List.of(SMS),
                        BulkOptions.builder().chunkSize(1).concurrency(1).build());
            } catch (Throwable t) {
                thrown.set(t);
                flag.set(Thread.currentThread().isInterrupted());
            }
        });
        caller.start();
        assertTrue(firstDone.await(10, java.util.concurrent.TimeUnit.SECONDS));
        Thread.sleep(100);
        caller.interrupt();
        caller.join(10_000);
        BulkSendException e = assertInstanceOf(BulkSendException.class, thrown.get());
        assertEquals(1, e.getPartialResult().getResults().size());
        assertEquals(1, e.getPartialResult().getErrors().size());
        assertTrue(flag.get(), "interrupt flag restored");
    }

    // ---- F8 / rule 10: serialization

    @SuppressWarnings("unchecked")
    private static <T> T roundTrip(T value) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (ObjectOutputStream oo = new ObjectOutputStream(out)) {
            oo.writeObject(value);
        }
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()))) {
            return (T) in.readObject();
        }
    }

    @Test
    void exceptionsSurviveSerialization() throws Exception {
        String serviceError = "{\"common\":{\"authCode\":\"A000\",\"infobankTrId\":\"TR5\"},\"data\":{\"code\":\"A306\","
                + "\"result\":\"bad\"}}";
        try (Bizgo c = client(scripted(n -> json(200, serviceError), new ArrayList<>()))) {
            ApiException e = assertThrows(ApiException.class, () -> c.messages().status("K1"));
            ApiException back = roundTrip(e);
            assertEquals(e.getBody(), back.getBody());
            assertEquals("A306", back.getCode());
            assertEquals("TR5", back.getTrackingId());
            assertEquals(e.getClass(), back.getClass());
        }
        ValidationException v = assertThrows(ValidationException.class, () -> SmsMessage.builder().from(PHONE).build());
        assertEquals(v.getViolations(), roundTrip(v).getViolations());
        InvalidResponseException invalid = new InvalidResponseException("x", 200, "TR",
                Json.readTree("{\"a\":1}"));
        assertEquals(invalid.getBody(), roundTrip(invalid).getBody());
        DuplicateRequestException dup = new DuplicateRequestException("d", 200, "A301", ErrorLayer.SERVICE, "T", null,
                true);
        assertTrue(roundTrip(dup).isAlreadyAccepted());
    }

    // ---- rule 11: masking

    @Test
    void phoneNumbersAreMaskedInToString() {
        try (Bizgo c = client(scripted(n -> json(200, OK), new ArrayList<>()))) {
            SendResult result = c.send().sms(PHONE, PHONE, "hi");
            String text = result.toString();
            assertTrue(text.contains("to=010****0000"), text);
            assertFalse(text.contains(PHONE));
            assertEquals(PHONE, result.getDestinations().get(0).getTo(), "the value itself is unchanged");
        }
        String sms = SmsMessage.builder().from(PHONE).text("안녕하세요").build().toString();
        assertTrue(sms.contains("from=010****0000"), sms);
        assertTrue(sms.contains("text=***(5자)"), sms);
        assertFalse(sms.contains("안녕"));
    }

    // ---- F11: no public mutable mappers

    @Test
    void jsonMappersAreNotExposed() {
        for (Field field : Json.class.getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers())) {
                assertTrue(field.getType().isPrimitive(), "public field " + field.getName());
            }
        }
    }

    // ---- F13: fake uploads

    @Test
    void fakeUploadsReturnKeys() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo c = fake.client()) {
            FileUploadResult mms = c.files().uploadMms(FileUpload.of(new byte[] {1}, "a.jpg"));
            assertTrue(mms.getFileKey().startsWith("FAKE-FILEKEY-"));
            RcsFileUploadResult rcs = c.files().uploadRcs(FileUpload.of(new byte[] {1}, "a.jpg"));
            assertTrue(rcs.getMedia().startsWith("maapfile://"));
            assertNotNull(c.files().uploadBrandMessageWide(FileUpload.of(new byte[] {1}, "a.jpg")).getImgUrl());
        }
    }

    // ---- rule 5: path values

    @Test
    void pathValuesAreOneSegment() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo c = fake.client()) {
            c.reports().inquiry("a/b?c#d%e");
            assertEquals("/api/comm/v1/report/inquiry/a%2Fb%3Fc%23d%25e", fake.lastRequest().getPath());
            for (String bad : List.of(".", "..")) {
                assertThrows(ValidationException.class, () -> c.reports().inquiry(bad));
            }
        }
    }

    @Test
    void everyBizgoExceptionIsSerializable() {
        assertTrue(java.io.Serializable.class.isAssignableFrom(BizgoException.class));
    }
}
