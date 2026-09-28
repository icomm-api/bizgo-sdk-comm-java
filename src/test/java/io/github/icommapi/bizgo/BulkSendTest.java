package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.ApiConnectionException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.errors.RateLimitException;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.models.BulkSendResult;
import io.github.icommapi.bizgo.models.SmsMessage;
import io.github.icommapi.bizgo.testing.FakeTransport;
import io.github.icommapi.bizgo.testing.RecordedRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class BulkSendTest {

    private static final SmsMessage SMS = SmsMessage.builder().from("01000000000").text("hello").build();

    private static List<String> numbers(int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(String.format("0100000%04d", i));
        }
        return list;
    }

    @Test
    void splitsIntoChunksWithIdempotencyKeys() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            BulkSendResult result = client.send().bulk(numbers(450), List.of(SMS),
                    BulkOptions.builder().idempotencyKeyPrefix("campaign-0923").concurrency(3).build());
            assertEquals(3, result.getResults().size());
            assertTrue(result.getErrors().isEmpty());
            assertEquals(450, result.getSucceeded().size());
            assertEquals(450, result.getMsgKeys().size());
            assertTrue(result.isComplete());
        }
        List<RecordedRequest> requests = fake.requests("sendOmni");
        assertEquals(3, requests.size());
        Set<String> keys = new TreeSet<>();
        List<Integer> sizes = new ArrayList<>();
        for (RecordedRequest r : requests) {
            keys.add(r.getJsonBody().get("idempotencyKey").asText());
            sizes.add(r.getJsonBody().get("destinations").size());
        }
        List<String> all = numbers(450);
        assertEquals(Set.of(
                BulkOptions.idempotencyKey("campaign-0923", 200, 0, all.subList(0, 200)),
                BulkOptions.idempotencyKey("campaign-0923", 200, 200, all.subList(200, 400)),
                BulkOptions.idempotencyKey("campaign-0923", 200, 400, all.subList(400, 450))), keys);
        assertTrue(keys.iterator().next().matches("campaign-0923-200-(0|200|400)-[0-9a-f]{8}"));
        sizes.sort(null);
        assertEquals(List.of(50, 200, 200), sizes);
    }

    @Test
    void aFailedChunkDoesNotStopTheOthers() {
        FakeTransport fake = new FakeTransport();
        fake.on("sendOmni").thenDefault().thenFail(ErrorLayer.SERVICE, 429, "A020").thenSendResult("A000", "A306");
        try (Bizgo client = fake.clientBuilder().maxRetries(0).build()) {
            BulkSendResult result = client.send().bulk(numbers(5), List.of(SMS),
                    BulkOptions.builder().chunkSize(2).concurrency(1).build());
            assertEquals(2, result.getResults().size());
            assertEquals(1, result.getErrors().size());
            BulkSendResult.ChunkError error = result.getErrors().get(0);
            assertEquals(1, error.chunkIndex());
            assertEquals(2, error.fromIndex());
            assertEquals(4, error.toIndex());
            assertInstanceOf(RateLimitException.class, error.error());
            assertEquals(3, result.getSucceeded().size());
            assertEquals(1, result.getFailed().size());
            assertFalse(result.isComplete());
            // no phone numbers in the printable forms
            assertFalse(result.toString().contains("0100000"));
            assertFalse(error.toString().contains("0100000"));
            assertFalse(error.error().getMessage().contains("0100000"));
        }
    }

    @Test
    void withAPrefixTimeoutsAreRetried() {
        FakeTransport fake = new FakeTransport();
        fake.on("sendOmni").thenTimeout().thenDefault();
        try (Bizgo client = fake.clientBuilder().maxRetries(1).sleeper(d -> { }).build()) {
            BulkSendResult result = client.send().bulk(numbers(3), List.of(SMS),
                    BulkOptions.builder().idempotencyKeyPrefix("p").build());
            assertTrue(result.getErrors().isEmpty());
        }
        assertEquals(2, fake.requests().size());
    }

    @Test
    void withoutAPrefixTimeoutsAreNotRetried() {
        FakeTransport fake = new FakeTransport();
        fake.on("sendOmni").thenTimeout().thenDefault();
        try (Bizgo client = fake.clientBuilder().maxRetries(1).sleeper(d -> { }).build()) {
            BulkSendResult result = client.send().bulk(numbers(3), List.of(SMS), null);
            assertEquals(1, result.getErrors().size());
            assertInstanceOf(ApiConnectionException.class, result.getErrors().get(0).error());
        }
        assertEquals(1, fake.requests().size());
    }

    @Test
    void validatesBeforeSending() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            assertThrows(ValidationException.class, () -> BulkOptions.builder().chunkSize(201).build());
            assertThrows(ValidationException.class, () -> BulkOptions.builder().chunkSize(0).build());
            assertThrows(ValidationException.class, () -> BulkOptions.builder().concurrency(0).build());
            assertThrows(ValidationException.class, () -> client.send().bulk(List.<String>of(), List.of(SMS), null));
            assertThrows(ValidationException.class, () -> client.send().bulk(numbers(1), List.of(), null));
        }
        assertTrue(fake.requests().isEmpty());
    }

    @Test
    void usesTheSendBucket() {
        assertEquals(Operation.RateBucket.SEND, Operations.SEND_OMNI.getRateBucket());
    }
}
