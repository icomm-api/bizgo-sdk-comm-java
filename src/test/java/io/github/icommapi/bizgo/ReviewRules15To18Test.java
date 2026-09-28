package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.ConfigurationException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.errors.InvalidResponseException;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.internal.Json;
import io.github.icommapi.bizgo.models.BulkSendResult;
import io.github.icommapi.bizgo.models.SmsMessage;
import io.github.icommapi.bizgo.testing.FakeTransport;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/** SDK-DESIGN 12 rules 15-18, the depth limit of rule 8 and the cross-SDK key vector of rule 3. */
class ReviewRules15To18Test {

    private static final SmsMessage SMS = SmsMessage.builder().from("01000000000").text("hi").build();

    // ---- rule 15: user callbacks never change results, retries or bulk results

    @Test
    void throwingHooksDoNotAffectCallsRetriesOrBulk() {
        RequestHook broken = new RequestHook() {
            @Override
            public void onRequestStart(RequestEvent event) {
                throw new IllegalStateException("boom");
            }

            @Override
            public void onRequestEnd(RequestEvent event) {
                throw new StackOverflowError();
            }
        };
        FakeTransport fake = new FakeTransport();
        fake.on("getReportPolling").thenFail(ErrorLayer.GATEWAY, 503, "A503").thenDefault();
        try (Bizgo client = fake.clientBuilder().maxRetries(1).sleeper(d -> { }).hook(broken).build()) {
            assertTrue(client.reports().poll().isEmpty());
            assertEquals(2, fake.requests("getReportPolling").size(), "the retry still happened once");
            List<String> numbers = List.of("01000000000", "01000000001", "01000000002");
            BulkSendResult result = client.send().bulk(numbers, List.of(SMS),
                    BulkOptions.builder().chunkSize(1).concurrency(2).build());
            assertEquals(3, result.getResults().size());
            assertTrue(result.getErrors().isEmpty());
        }
    }

    // ---- rule 16: the API key is used exactly as given

    @Test
    void apiKeyIsNeverTrimmed() {
        for (String bad : List.of(" test-api-key-not-real", "test-api-key-not-real\n", "test-api-key-not-real\t",
                "test api key", "키-not-ascii", "")) {
            assertThrows(ConfigurationException.class, () -> Bizgo.resolveApiKey(bad, name -> null), bad);
            assertThrows(ConfigurationException.class, () -> Bizgo.resolveApiKey(null, name -> bad), "env " + bad);
        }
        assertEquals("test-api-key-not-real", Bizgo.resolveApiKey(null, name -> "test-api-key-not-real"));
        assertEquals("!~", Bizgo.resolveApiKey("!~", name -> null));
    }

    // ---- rule 17: 3xx is never retried, not even on the SAFE path

    @Test
    void redirectsAreNeverRetried() {
        for (int status : new int[] {301, 302, 307, 308}) {
            AtomicInteger calls = new AtomicInteger();
            HttpTransport transport = request -> {
                calls.incrementAndGet();
                return new HttpTransport.Response(status, Map.of("Location", List.of("https://example.invalid/")),
                        new byte[0]);
            };
            try (Bizgo client = Bizgo.builder().apiKey("test-api-key-not-real").httpTransport(transport).trustHttpTransport(true)
                    .rateLimit(null).maxRetries(3).sleeper(d -> { }).build()) {
                InvalidResponseException e = assertThrows(InvalidResponseException.class,
                        () -> client.messages().status("K1"));                  // SAFE retry policy
                assertTrue(e.getMessage().startsWith("HTTP " + status), e.getMessage());
                assertEquals(status, e.getHttpStatus());
                assertThrows(InvalidResponseException.class,
                        () -> client.send().sms("01000000000", "01000000000", "hi", SendOptions.idempotencyKey("k")));
            }
            assertEquals(2, calls.get(), "one attempt per call");
        }
    }

    // ---- rule 18: unreadable files

    @Test
    void unreadableUploadFilesAreValidationErrorsWithTheNameOnly(@TempDir Path dir) throws Exception {
        Path missing = dir.resolve("secret-folder").resolve("missing-image.jpg");
        ValidationException e = assertThrows(ValidationException.class, () -> FileUpload.of(missing));
        assertTrue(e.getMessage().contains("missing-image.jpg"), e.getMessage());
        assertFalse(e.getMessage().contains("secret-folder"), e.getMessage());
        assertFalse(e.getMessage().contains(dir.toString()), e.getMessage());
        assertEquals(null, e.getCause());

        Path folder = Files.createDirectory(dir.resolve("a-directory"));
        ValidationException d = assertThrows(ValidationException.class, () -> FileUpload.of(folder));
        assertTrue(d.getMessage().contains("a-directory"));
        assertFalse(d.getMessage().contains(dir.toString()));

        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            assertThrows(ValidationException.class, () -> client.files().uploadMms(missing));
            assertThrows(ValidationException.class, () -> client.files().uploadAlimtalkTemplateImage(missing));
        }
        assertTrue(fake.requests().isEmpty());
    }

    // ---- rule 8: JSON depth 64

    @Test
    void jsonDepthIsLimitedTo64() throws Exception {
        assertEquals(64, Json.MAX_DEPTH);
        String ok = "[".repeat(60) + "]".repeat(60);
        Json.readTree(ok);
        String deep = "[".repeat(70) + "]".repeat(70);
        assertThrows(java.io.IOException.class, () -> Json.readTree(deep));
    }

    // ---- rule 3: cross-SDK test vector

    @Test
    void bulkKeysMatchTheCrossSdkVector() {
        List<String> numbers = List.of("01000000000", "01000000001", "01000000002");
        assertEquals("camp-2-0-32fe30d2", BulkOptions.idempotencyKey("camp", 2, 0, numbers.subList(0, 2)));
        assertEquals("camp-2-2-370752d8", BulkOptions.idempotencyKey("camp", 2, 2, numbers.subList(2, 3)));
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            client.send().bulk(numbers, List.of(SMS),
                    BulkOptions.builder().chunkSize(2).concurrency(1).idempotencyKeyPrefix("camp").build());
        }
        List<String> keys = new ArrayList<>();
        fake.requests("sendOmni").forEach(r -> keys.add(r.getJsonBody().get("idempotencyKey").asText()));
        assertEquals(List.of("camp-2-0-32fe30d2", "camp-2-2-370752d8"), keys);
    }
}
