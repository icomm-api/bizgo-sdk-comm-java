package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.github.icommapi.bizgo.errors.ConfigurationException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.models.BulkSendResult;
import io.github.icommapi.bizgo.models.CounselPlainMessageRequest;
import io.github.icommapi.bizgo.models.SmsMessage;
import io.github.icommapi.bizgo.testing.FakeTransport;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/** Send bucket counted per recipient, buckets chosen by x-sdk-rate, SDK identification headers. */
class RecipientRateLimitTest {

    private static final SmsMessage SMS = SmsMessage.builder().from("01000000000").text("hello").build();

    /** Fake monotonic clock: sleeping advances it. */
    private final AtomicLong now = new AtomicLong(5_000_000_000L);
    private final List<Duration> waits = new CopyOnWriteArrayList<>();

    private Bizgo client(FakeTransport fake, RateLimit limit) {
        return fake.clientBuilder().rateLimit(limit).nanoClock(now::get).sleeper(d -> {
            waits.add(d);
            now.addAndGet(d.toNanos());
        }).build();
    }

    private static List<String> numbers(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add("01000000000");
        }
        return list;
    }

    private long fakeMillis(long start) {
        return Duration.ofNanos(now.get() - start).toMillis();
    }

    @Test
    void aFullChunkUsesTheWholeSecond() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = client(fake, RateLimit.DEFAULT)) {
            long start = now.get();
            client.send().omni(numbers(200), SMS);           // full bucket: no wait
            assertTrue(waits.isEmpty());
            client.send().omni(numbers(200), SMS);           // must wait for 200 new tokens
            assertEquals(1, waits.size());
            assertEquals(1000, waits.get(0).toMillis());
            assertEquals(1000, fakeMillis(start));
        }
    }

    @Test
    void oneRecipientOnAnIdleBucketIsNotDelayed() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = client(fake, RateLimit.DEFAULT)) {
            for (int i = 0; i < 200; i++) {
                client.send().sms("01000000000", "01000000000", "hi");
            }
            assertTrue(waits.isEmpty(), "200 single-recipient sends fit in the burst");
            client.send().sms("01000000000", "01000000000", "hi");
            assertEquals(5, waits.get(0).toMillis(), "1/200 s for one more token");
        }
    }

    @Test
    void costAboveTheCapacityDoesNotDeadlock() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = client(fake, RateLimit.of(100, 5))) {
            long start = now.get();
            client.send().omni(numbers(200), SMS);           // bucket full: goes, leaves 100 tokens of debt
            assertTrue(waits.isEmpty());
            client.send().omni(numbers(200), SMS);           // waits until full again (debt 100 + 100) = 2 s
            assertEquals(2000, fakeMillis(start));
            client.send().omni(numbers(200), SMS);
            assertEquals(4000, fakeMillis(start), "average rate of 100/s holds");
        }
        RateLimiter.Bucket bucket = new RateLimiter.Bucket(10, now::get);
        assertEquals(0L, bucket.reserve(1000));             // never waits for more than the capacity
        assertEquals(Duration.ofMillis(99_100).toNanos(), bucket.reserve(1)); // (990 debt + 1) / 10 per s
    }

    @Test
    void bulkOfAThousandTakesAboutFourSeconds() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = client(fake, RateLimit.DEFAULT)) {
            long start = now.get();
            BulkSendResult result = client.send().bulk(numbers(1000), List.of(SMS),
                    BulkOptions.builder().concurrency(1).build());
            assertEquals(1000, result.getSucceeded().size());
            long elapsed = fakeMillis(start);
            assertTrue(elapsed >= 4000 && elapsed <= 5000, "fake time " + elapsed + " ms");
        }
    }

    @Test
    void retriesWaitAgain() {
        FakeTransport fake = new FakeTransport();
        fake.on("sendOmni").thenFail(ErrorLayer.SERVICE, 429, "A020").thenDefault();
        try (Bizgo client = client(fake, RateLimit.DEFAULT)) {
            long start = now.get();
            client.send().omni(numbers(200), SMS);
            // attempt 1: full bucket; Retry-After 0; attempt 2 waits for 200 more tokens
            assertEquals(1000, fakeMillis(start));
        }
        assertEquals(2, fake.requests().size());
    }

    @Test
    void counselSendsUseTheSendBucketWithCostOne() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = client(fake, RateLimit.of(2, 1))) {
            client.reports().poll();                                         // other: 1 token
            CounselPlainMessageRequest message = (CounselPlainMessageRequest) OperationsTest.unvalidated(
                    CounselPlainMessageRequest.class);
            client.counsel().messages().sendPlain(message);                  // send: 1
            client.counsel().messages().sendPlain(message);                  // send: 1
            assertTrue(waits.isEmpty());
            client.counsel().messages().sendPlain(message);
            assertEquals(500, waits.get(0).toMillis());
        }
    }

    @Test
    void sendBucketIsExactlyTheSpecOperationsMarkedSend() throws Exception {
        JsonNode spec = new ObjectMapper(new YAMLFactory()).readTree(Path.of("spec/openapi.yaml").toFile());
        Set<String> marked = new TreeSet<>();
        spec.get("paths").forEach(item -> item.properties().forEach(op -> {
            if ("send".equals(op.getValue().path("x-sdk-rate").asText())) {
                marked.add(op.getValue().get("operationId").asText());
            }
        }));
        Set<String> send = Operation.all().stream().filter(op -> op.getRateBucket() == Operation.RateBucket.SEND)
                .map(Operation::getOperationId).collect(Collectors.toCollection(TreeSet::new));
        assertEquals(marked, send);
        assertEquals(Set.of("sendOmni", "createReservation", "addReservationRecipients",
                "createBrandMessageGroupSend", "sendCounselPlain", "sendCounselRich"), send);
    }

    // ------------------------------------------------------------------ identification headers (SDK-DESIGN 2.1)

    @Test
    void identificationHeaders() {
        FakeTransport fake = new FakeTransport();
        List<Map<String, String>> seen = new ArrayList<>();
        HttpTransport capture = request -> {
            seen.add(request.headers());
            return fake.execute(request);
        };
        try (Bizgo client = Bizgo.builder().apiKey("test-api-key-not-real").httpTransport(capture).trustHttpTransport(true)
                .appInfo("myshop", "1.4.2+build.7").build()) {
            client.reports().poll();
        }
        Map<String, String> headers = seen.get(0);
        String agent = headers.get("User-Agent");
        assertTrue(agent.matches("bizgo-sdk-comm-java/" + Bizgo.VERSION.replace(".", "\\.")
                + " java/[^ ]+ \\((linux|windows|darwin|freebsd|other); (x64|arm64|x86|arm|other)\\)"
                + " app/myshop-1\\.4\\.2\\+build\\.7"), agent);
        assertEquals("bizgo-sdk-comm-java/" + Bizgo.VERSION, headers.get("X-Bizgo-Client"));
        assertEquals("test-api-key-not-real", headers.get("Authorization"));
        assertTrue(Transport.USER_AGENT.matches("bizgo-sdk-comm-java/\\S+ java/\\S+ \\(\\w+; \\w+\\)"));
    }

    @Test
    void osAndArchAreCoarse() {
        assertEquals("linux", Transport.osName("Linux"));
        assertEquals("windows", Transport.osName("Windows 11"));
        assertEquals("darwin", Transport.osName("Mac OS X"));
        assertEquals("freebsd", Transport.osName("FreeBSD"));
        assertEquals("other", Transport.osName("SunOS"));
        assertEquals("x64", Transport.archName("amd64"));
        assertEquals("x64", Transport.archName("x86_64"));
        assertEquals("arm64", Transport.archName("aarch64"));
        assertEquals("x86", Transport.archName("i386"));
        assertEquals("x86", Transport.archName("x86"));
        assertEquals("arm", Transport.archName("armv7l"));
        assertEquals("other", Transport.archName("ppc64le"));
    }

    @Test
    void appInfoIsValidated() {
        for (String[] bad : new String[][] {
                {"my shop", "1.0"}, {"shop\r\nX-Evil: 1", "1.0"}, {"shop", "1.0\n"}, {"a".repeat(51), "1"},
                {"shop", "1".repeat(31)}, {"", "1"}, {"shop", ""}, {"user@example.com", "1"}, {"shop", null},
                {null, "1"}}) {
            assertThrows(ConfigurationException.class, () -> Bizgo.builder().apiKey("test-api-key-not-real")
                    .httpTransport(new FakeTransport()).appInfo(bad[0], bad[1]).build(),
                    String.valueOf(bad[0]) + "/" + bad[1]);
        }
        Bizgo.builder().apiKey("test-api-key-not-real").httpTransport(new FakeTransport())
                .appInfo("a".repeat(50), "1".repeat(30)).build().close();
    }

    @Test
    void identificationHeadersCannotBeOverridden() {
        Transport transport = new Transport("https://example.invalid", "test-api-key-not-real", Duration.ofSeconds(1),
                0, new FakeTransport(), null, d -> { }, null, List.of(), System::nanoTime, Transport.USER_AGENT);
        for (String name : List.of("Authorization", "user-agent", "X-Bizgo-Client", "x-bizgo-client")) {
            assertThrows(ValidationException.class, () -> transport.headers(Map.of(name, "x"), null), name);
        }
        Map<String, String> headers = transport.headers(Map.of("token", "t"), null);
        assertEquals("bizgo-sdk-comm-java/" + Bizgo.VERSION, headers.get("X-Bizgo-Client"));
        // the request headers handed to a transport are read-only
        HttpTransport.Request request = new HttpTransport.Request("GET", java.net.URI.create("https://example.invalid/"),
                headers, null, Duration.ofSeconds(1));
        assertThrows(UnsupportedOperationException.class, () -> request.headers().put("User-Agent", "x"));
    }
}
