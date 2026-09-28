package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.InternalServerException;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.models.BrandMessageFileUploadResult;
import io.github.icommapi.bizgo.models.FileUploadResult;
import io.github.icommapi.bizgo.models.MessageStatistics;
import io.github.icommapi.bizgo.models.MessageStatus;
import io.github.icommapi.bizgo.models.MoMessage;
import io.github.icommapi.bizgo.models.RcsFileUploadResult;
import io.github.icommapi.bizgo.models.Report;
import io.github.icommapi.bizgo.models.ReportBatch;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ReportsMessagesFilesTest extends TestSupport {

    private static final Map<String, Object> REPORT = Map.of("msgKey", "KEY001", "serviceType", "SMS", "msgType", "SM",
            "reportCode", "10000", "reportType", "0");
    private static final String POLLING = "/api/comm/v1/report/polling";
    private static final String HISTORY = "/api/comm/v1/message/history";

    private static Map<String, Object> emptyBatch() {
        Map<String, Object> data = new java.util.HashMap<>();
        data.put("reportId", "");
        data.put("report", null);
        return envelope(data);
    }

    @Test
    void consumeAcksEachBatchAfterTheHandler() {
        server.route("GET", POLLING).reply(
                MockServer.json(200, envelope(Map.of("reportId", "R1", "report", List.of(REPORT, REPORT)))),
                MockServer.json(200, emptyBatch()));
        MockServer.Route ack = server.route("DELETE", POLLING + "/R1").reply(MockServer.json(200, envelope(null)));
        List<String> seen = new ArrayList<>();
        int handled = client.reports().consume(reports -> reports.forEach(r -> seen.add(r.getMsgKey())));
        assertEquals(2, handled);
        assertEquals(List.of("KEY001", "KEY001"), seen);
        assertEquals(1, ack.count());
    }

    @Test
    void consumeDoesNotAckWhenTheHandlerFails() {
        server.route("GET", POLLING).reply(MockServer.json(200, envelope(Map.of("reportId", "R1", "report",
                List.of(REPORT)))));
        MockServer.Route ack = server.route("DELETE", POLLING + "/R1");
        assertThrows(IllegalStateException.class, () -> client.reports().consume(reports -> {
            throw new IllegalStateException("db down");
        }));
        assertEquals(0, ack.count());
    }

    @Test
    void consumeStopsAfterMaxBatches() {
        server.route("GET", POLLING).reply(MockServer.json(200, envelope(Map.of("reportId", "R1", "report",
                List.of(REPORT)))));
        server.route("DELETE", POLLING + "/R1").reply(MockServer.json(200, envelope(null)));
        assertEquals(2, client.reports().consume(reports -> { }, 2));
    }

    @Test
    void pollReturnsEmptyBatch() {
        server.route("GET", POLLING).reply(MockServer.json(200, emptyBatch()));
        ReportBatch batch = client.reports().poll();
        assertTrue(batch.isEmpty());
        assertEquals("", batch.getReportId());
    }

    @Test
    void pathParametersAreEscaped() {
        MockServer.Route route = server.route("GET", "/api/comm/v1/report/inquiry/a%2Fb%3Fc%20d")
                .reply(MockServer.json(200, envelope(Map.of("report", List.of(REPORT)))));
        List<Report> reports = client.reports().inquiry("a/b?c d");
        assertEquals(1, route.count());
        assertEquals("KEY001", reports.get(0).getMsgKey());
    }

    @Test
    void dotAndEmptySegmentsAreRejected() {
        assertThrows(ValidationException.class, () -> client.reports().inquiry(".."));
        assertThrows(ValidationException.class, () -> client.reports().ack(""));
        assertThrows(ValidationException.class, () -> client.messages().status(null));
        assertEquals(0, server.requests.size());
    }

    @Test
    void iterHistoryFollowsLastSeq() {
        Map<String, Object> msg = Map.of("msgKey", "K", "serviceType", "SMS");
        MockServer.Route route = server.route("GET", HISTORY).reply(
                MockServer.json(200, envelope(Map.of("messages", List.of(msg, msg), "lastSeq", 10, "hasNext", true))),
                MockServer.json(200, envelope(Map.of("messages", List.of(msg), "lastSeq", 11, "hasNext", false))));
        List<MessageStatus> items = new ArrayList<>();
        client.messages().iterHistory(HistoryQuery.since(LocalDateTime.of(2026, 9, 23, 9, 0))
                .serviceTypes("SMS", "RCS").limit(2)).forEach(items::add);
        assertEquals(3, items.size());
        Map<String, String> first = route.calls.get(0).query();
        Map<String, String> second = route.calls.get(1).query();
        assertEquals("2026-09-23T09:00:00", first.get("requestTime"));
        assertEquals("SMS,RCS", first.get("serviceType"));
        assertEquals("2", first.get("limit"));
        assertFalse(first.containsKey("lastSeq"));
        assertEquals("10", second.get("lastSeq"));
    }

    @Test
    void iterHistoryStopsIfTheCursorDoesNotMove() {
        MockServer.Route route = server.route("GET", HISTORY).reply(MockServer.json(200,
                envelope(Map.of("messages", List.of(Map.of("msgKey", "K")), "lastSeq", 5, "hasNext", true))));
        assertEquals(2, client.messages().streamHistory(HistoryQuery.since("2026-09-23T09:00:00")).count());
        assertEquals(2, route.count());
    }

    @Test
    void iterHistoryStopsWithoutLastSeq() {
        MockServer.Route route = server.route("GET", HISTORY).reply(MockServer.json(200,
                envelope(Map.of("messages", List.of(Map.of("msgKey", "K")), "hasNext", true))));
        assertEquals(1, client.messages().streamHistory(HistoryQuery.since("2026-09-23T09:00:00")).count());
        assertEquals(1, route.count());
    }

    @Test
    void iterMoHistoryWalksPages() {
        server.route("GET", "/api/comm/v1/message/history/mo").reply(
                MockServer.json(200, envelope(Map.of("messages", List.of(Map.of("msgKey", "M1")), "lastSeq", 1,
                        "hasNext", true))),
                MockServer.json(200, envelope(Map.of("messages", List.of(Map.of("msgKey", "M2")), "lastSeq", 2,
                        "hasNext", false))));
        List<String> keys = client.messages().streamMoHistory(MoHistoryQuery.since("2026-04-23T14:11:01+09:00"))
                .map(MoMessage::getMsgKey).collect(Collectors.toList());
        assertEquals(List.of("M1", "M2"), keys);
    }

    @Test
    void moHistoryTimeIsSentWithKstOffset() {
        MockServer.Route route = server.route("GET", "/api/comm/v1/message/history/mo")
                .reply(MockServer.json(200, envelope(Map.of("messages", List.of(), "hasNext", false))));
        client.messages().moHistory(MoHistoryQuery.since(LocalDateTime.of(2026, 4, 23, 14, 11, 1)).from(OTHER_PHONE)
                .limit(1000));
        Map<String, String> query = route.last().query();
        assertEquals("2026-04-23T14:11:01+09:00", query.get("occurredTime"));
        assertEquals(OTHER_PHONE, query.get("from"));
        assertTrue(route.last().rawQuery().contains("%2B09%3A00"), "'+' must be percent-encoded");
        client.messages().moHistory(MoHistoryQuery.since(OffsetDateTime.of(2026, 4, 23, 5, 11, 1, 0, ZoneOffset.UTC)));
        assertEquals("2026-04-23T05:11:01+00:00", route.last().query().get("occurredTime"));
    }

    @Test
    void awareTimesAreConvertedToKst() {
        MockServer.Route route = server.route("GET", HISTORY).reply(MockServer.json(200,
                envelope(Map.of("messages", List.of()))));
        client.messages().history(HistoryQuery.since(OffsetDateTime.of(2026, 9, 23, 0, 0, 0, 0, ZoneOffset.UTC)));
        assertEquals("2026-09-23T09:00:00", route.last().query().get("requestTime"));
        client.messages().history(HistoryQuery.since(ZonedDateTime.of(2026, 9, 23, 0, 0, 0, 0, ZoneId.of("UTC"))
                .toInstant()));
        assertEquals("2026-09-23T09:00:00", route.last().query().get("requestTime"));
    }

    @Test
    void limitRangeIsCheckedBeforeSending() {
        ValidationException e = assertThrows(ValidationException.class,
                () -> HistoryQuery.since("2026-09-23T09:00:00").limit(1001));
        assertTrue(e.getMessage().contains("1~1000"));
        assertThrows(ValidationException.class, () -> MoHistoryQuery.since("2026-09-23T09:00:00+09:00").limit(0));
    }

    @Test
    void statisticsParameters() {
        MockServer.Route route = server.route("GET", "/api/comm/v1/message/statistics").reply(MockServer.json(200,
                envelope(Map.of("statistics", List.of(Map.of("statDate", "20260923", "recvTotalCnt", 3))))));
        List<MessageStatistics> stats = client.messages().statistics(LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 9, 23), "SMS", null);
        assertEquals(3L, stats.get(0).getRecvTotalCnt());
        assertEquals(Map.of("startDate", "20260901", "endDate", "20260923", "serviceType", "SMS"),
                route.last().query());
    }

    @Test
    void statusQueriesUseTheirPaths() {
        server.route("GET", "/api/comm/v1/message/inquiry/requestId/REQ1").reply(MockServer.json(200,
                envelope(Map.of("messages", List.of(Map.of("msgKey", "REQ1001"))))));
        server.route("GET", "/api/comm/v1/message/inquiry/mo/msgKey/M1").reply(MockServer.json(200,
                envelope(Map.of("messages", List.of(Map.of("msgKey", "M1", "from", PHONE))))));
        assertEquals("REQ1001", client.messages().statusByRequestId("REQ1").get(0).getMsgKey());
        assertEquals(PHONE, client.messages().mo("M1").get(0).getFrom());
    }

    @Test
    void responseKeepsUnknownFields() {
        server.route("GET", "/api/comm/v1/message/inquiry/msgKey/K").reply(MockServer.json(200,
                envelope(Map.of("messages", List.of(Map.of("msgKey", "K", "newServerField", "v"))))));
        MessageStatus status = client.messages().status("K").get(0);
        assertEquals(Map.of("newServerField", "v"), status.getAdditionalProperties());
        assertEquals("K", status.getMsgKey());
    }

    @Test
    void uploadMmsSendsMultipart() {
        MockServer.Route route = server.route("POST", "/api/comm/v1/file/mms").reply(MockServer.json(200,
                envelope(Map.of("fileKey", "FILE_KEY_001", "expired", "2027-04-24T10:45:24+09:00"))));
        FileUploadResult result = client.files().uploadMms(
                FileUpload.of(new byte[] {(byte) 0xff, (byte) 0xd8, 'j', 'p', 'g'}, "a.jpg").imageName("banner"));
        MockServer.Request request = route.last();
        assertTrue(request.header("Content-Type").startsWith("multipart/form-data; boundary=bizgo-"));
        String body = new String(request.body(), StandardCharsets.ISO_8859_1);
        assertTrue(body.contains("Content-Disposition: form-data; name=\"file\"; filename=\"a.jpg\""), body);
        assertTrue(body.contains("Content-Type: image/jpeg"));
        assertTrue(body.contains("name=\"imageName\"\r\n\r\nbanner\r\n"));
        assertFalse(body.contains("name=\"fileKey\""));
        assertEquals(API_KEY, request.header("Authorization"));
        assertEquals("FILE_KEY_001", result.getFileKey());
        assertEquals("2027-04-24T10:45:24+09:00", result.getExpired());
    }

    @Test
    void uploadMmsSizeLimitIsCheckedBeforeSending() {
        MockServer.Route route = server.route("POST", "/api/comm/v1/file/mms");
        ValidationException e = assertThrows(ValidationException.class,
                () -> client.files().uploadMms(FileUpload.of(new byte[300 * 1024 + 1], "a.jpg")));
        assertTrue(e.getMessage().contains("300KB"));
        assertEquals(0, route.count());
        client.files().uploadMms(FileUpload.of(new byte[300 * 1024], "a.jpg")); // exactly 300KB is allowed
        assertEquals(1, route.count());
    }

    @Test
    void uploadFromPathUsesTheFileName(@TempDir Path dir) throws Exception {
        Path image = dir.resolve("card.png");
        Files.write(image, new byte[] {1, 2, 3});
        MockServer.Route route = server.route("POST", "/api/comm/v1/file/rcs").reply(MockServer.json(200,
                envelope(Map.of("media", "maapfile://MEDIA_KEY_EXAMPLE"))));
        RcsFileUploadResult result = client.files().uploadRcs(image);
        String body = new String(route.last().body(), StandardCharsets.UTF_8);
        assertTrue(body.contains("filename=\"card.png\"") && body.contains("Content-Type: image/png"), body);
        assertEquals("maapfile://MEDIA_KEY_EXAMPLE", result.getMedia());
    }

    @Test
    void fileNamesCannotInjectHeaders() {
        MockServer.Route route = server.route("POST", "/api/comm/v1/file/mms").reply(MockServer.json(200,
                envelope(Map.of("fileKey", "F"))));
        client.files().uploadMms(FileUpload.of(new byte[] {1}, "a\"\r\nX-Injected: 1.jpg"));
        String body = new String(route.last().body(), StandardCharsets.UTF_8);
        assertFalse(body.contains("\r\nX-Injected"), body);
        assertTrue(body.contains("filename=\"a%22%0D%0AX-Injected: 1.jpg\""), body);
    }

    @Test
    void uploadBrandMessagePathAndKindWhitelist() {
        MockServer.Route route = server.route("POST", "/api/comm/v1/file/brandmessage/wideItemList/first")
                .reply(MockServer.json(200, envelope(Map.of("imgUrl", "https://example.com/img.jpg"))));
        BrandMessageFileUploadResult result = client.files().uploadBrandMessage(FileUpload.of(new byte[] {1}, "a.png"),
                "wideItemList/first");
        assertEquals(1, route.count());
        assertEquals("https://example.com/img.jpg", result.getImgUrl());
        for (BrandImageKind kind : BrandImageKind.values()) {
            server.route("POST", "/api/comm/v1/file/brandmessage/" + kind.value())
                    .reply(MockServer.json(200, envelope(Map.of("imgUrl", "u"))));
            assertEquals("u", client.files().uploadBrandMessage(FileUpload.of(new byte[] {1}, "a.png"), kind)
                    .getImgUrl());
        }
        int before = server.requests.size();
        assertThrows(ValidationException.class,
                () -> client.files().uploadBrandMessage(FileUpload.of(new byte[] {1}, "a.png"), "../etc"));
        assertThrows(ValidationException.class,
                () -> client.files().uploadBrandMessage(FileUpload.of(new byte[] {1}, "a.png"), "catalog"));
        assertEquals(before, server.requests.size());
    }

    @Test
    void uploadsAreNotRetriedOnServerErrors() {
        MockServer.Route route = server.route("POST", "/api/comm/v1/file/mms").reply(MockServer.text(500, "x"));
        assertThrows(InternalServerException.class,
                () -> client.files().uploadMms(FileUpload.of(new byte[] {1}, null)));
        assertEquals(1, route.count());
        assertTrue(new String(route.last().body(), StandardCharsets.UTF_8).contains("filename=\"image.jpg\""));
    }

    @Test
    void ackIsRetriedOnServerErrors() {
        MockServer.Route route = server.route("DELETE", POLLING + "/R1").reply(MockServer.text(503, "x"),
                MockServer.json(200, envelope(null)));
        client.reports().ack("R1");
        assertEquals(2, route.count());
    }
}
