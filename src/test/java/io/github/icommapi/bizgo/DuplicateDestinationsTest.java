package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.DuplicateRequestException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.models.BulkSendResult;
import io.github.icommapi.bizgo.models.SendDestinationResult;
import io.github.icommapi.bizgo.models.SendResult;
import io.github.icommapi.bizgo.models.SmsMessage;
import io.github.icommapi.bizgo.testing.FakeTransport;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/** Per-recipient A301 (same idempotencyKey resent: HTTP 200, success data.code) goes to duplicates, SDK-DESIGN 12.4. */
class DuplicateDestinationsTest {

    private static final String PHONE = "01000000000";
    private static final SmsMessage SMS = SmsMessage.builder().from(PHONE).text("hello").build();

    private static List<String> numbers(int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(String.format("0100000%04d", i));
        }
        return list;
    }

    @Test
    void allDuplicatesAreNeitherFailedNorSucceeded() {
        FakeTransport fake = new FakeTransport();
        fake.on("sendOmni").thenDuplicateSendResult();
        try (Bizgo client = fake.client()) {
            SendResult result = client.send().sms(numbers(2), PHONE, "hello", SendOptions.idempotencyKey("k-1"));
            assertEquals(2, result.getDuplicates().size());
            assertTrue(result.getFailed().isEmpty());
            assertTrue(result.getSucceeded().isEmpty());
            assertTrue(result.getMsgKeys().isEmpty());
            for (SendDestinationResult d : result.getDuplicates()) {
                assertEquals("A301", d.getCode());
            }
            assertFalse(result.toString().contains("0100000"), "phone numbers are masked");
        }
    }

    @Test
    void mixedResponseSplitsIntoThreeGroups() {
        FakeTransport fake = new FakeTransport();
        fake.on("sendOmni").thenSendResult("A000", "A301", "A306");
        try (Bizgo client = fake.client()) {
            SendResult result = client.send().sms(numbers(3), PHONE, "hello", SendOptions.idempotencyKey("k-2"));
            assertEquals(3, result.getDestinations().size());
            assertEquals(List.of("A000"), codes(result.getSucceeded()));
            assertEquals(List.of("A301"), codes(result.getDuplicates()));
            assertEquals(List.of("A306"), codes(result.getFailed()));
            assertEquals(1, result.getMsgKeys().size());
            assertEquals("Duplicated", result.getDuplicates().get(0).getResult());
        }
    }

    @Test
    void bulkAggregatesDuplicatesAndAnAllDuplicateChunkIsNotAnError() {
        FakeTransport fake = new FakeTransport();
        fake.on("sendOmni").thenDuplicateSendResult().thenSendResult("A301", "A000").thenDefault();
        try (Bizgo client = fake.client()) {
            BulkSendResult result = client.send().bulk(numbers(5), List.of(SMS),
                    BulkOptions.builder().idempotencyKeyPrefix("campaign").chunkSize(2).concurrency(1).build());
            assertEquals(3, result.getResults().size());
            assertTrue(result.getErrors().isEmpty());
            assertEquals(3, result.getDuplicates().size());
            assertEquals(2, result.getSucceeded().size());
            assertTrue(result.getFailed().isEmpty());
            assertEquals(2, result.getMsgKeys().size());
            assertTrue(result.isComplete());
            assertTrue(result.toString().contains("duplicates=3"), result.toString());
            assertFalse(result.toString().contains("0100000"));
        }
    }

    @Test
    void requestLevelA301StillThrows() {
        FakeTransport fake = new FakeTransport();
        fake.on("sendOmni").thenFail(ErrorLayer.SERVICE, 200, "A301");
        try (Bizgo client = fake.client()) {
            assertThrows(DuplicateRequestException.class,
                    () -> client.send().sms(PHONE, PHONE, "hello", SendOptions.idempotencyKey("k-3")));
        }
    }

    private static List<String> codes(List<SendDestinationResult> list) {
        List<String> codes = new ArrayList<>();
        list.forEach(d -> codes.add(d.getCode()));
        return codes;
    }
}
