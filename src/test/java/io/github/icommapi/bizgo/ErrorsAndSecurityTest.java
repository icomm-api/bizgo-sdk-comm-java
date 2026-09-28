package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.ApiConnectionException;
import io.github.icommapi.bizgo.errors.ApiException;
import io.github.icommapi.bizgo.errors.AuthenticationException;
import io.github.icommapi.bizgo.errors.BadRequestException;
import io.github.icommapi.bizgo.errors.ConfigurationException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.errors.InternalServerException;
import io.github.icommapi.bizgo.errors.InvalidResponseException;
import io.github.icommapi.bizgo.errors.NotFoundException;
import io.github.icommapi.bizgo.errors.PermissionDeniedException;
import io.github.icommapi.bizgo.models.Destination;
import io.github.icommapi.bizgo.models.SmsMessage;
import java.net.http.HttpClient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ErrorsAndSecurityTest extends TestSupport {

    private static final String STATS = "/api/comm/v1/message/statistics";
    private static final String MO_HISTORY = "/api/comm/v1/message/history/mo";
    private static final LocalDate DAY = LocalDate.of(2026, 1, 1);

    @Test
    void gatewayAuthFailureWithoutData() {
        // observed on sandbox: invalid key -> HTTP 401, common.authCode=A401, no data
        server.route("GET", STATS).reply(MockServer.json(401,
                Map.of("common", Map.of("authCode", "A401", "authResult", "Unauthorized", "infobankTrId", "TR-1"))));
        AuthenticationException e = assertThrows(AuthenticationException.class,
                () -> client.messages().statistics(DAY));
        assertEquals(401, e.getHttpStatus());
        assertEquals("A401", e.getCode());
        assertEquals(ErrorLayer.GATEWAY, e.getLayer());
        assertEquals("TR-1", e.getTrackingId());
        assertNull(e.getDescription());
        assertFalse(e.getMessage().contains(API_KEY));
        assertFalse(e.toString().contains(API_KEY));
    }

    @Test
    void serviceErrorCodeOnHttp200UsesDocumentedStatus() {
        server.route("GET", STATS).reply(MockServer.json(200, envelope(null, "A306", null)));
        BadRequestException e = assertThrows(BadRequestException.class, () -> client.messages().statistics(DAY));
        assertEquals(ErrorLayer.SERVICE, e.getLayer());
        assertEquals("유효하지 않거나 비어있는 필드 (필드명 : to)", e.getDescription());
        assertEquals("HTTP 200 | service code=A306 | Failed | 유효하지 않거나 비어있는 필드 (필드명 : to) | infobankTrId=TR-TEST",
                e.getMessage());
    }

    @Test
    void sameCodeMeansDifferentThingsPerLayer() {
        MockServer.Route route = server.route("GET", STATS).reply(
                MockServer.json(400, envelope(null, "A401", null)), // service A401 = invalid paymentCode
                MockServer.json(401, Map.of("common", Map.of("authCode", "A401", "authResult", "Unauthorized"))));
        assertThrows(BadRequestException.class, () -> client.messages().statistics(DAY));
        assertThrows(AuthenticationException.class, () -> client.messages().statistics(DAY));
        assertEquals(2, route.count());
    }

    @Test
    void serviceCodesMapToTheirOwnExceptions() {
        server.route("GET", STATS).reply(MockServer.json(200, envelope(null, "A110", null)));
        assertThrows(PermissionDeniedException.class, () -> client.messages().statistics(DAY));
    }

    @Test
    void notFoundStatus() {
        server.route("GET", STATS).reply(
                MockServer.json(404, Map.of("common", Map.of("authCode", "A404", "authResult", "Not Found"))));
        assertThrows(NotFoundException.class, () -> client.messages().statistics(DAY));
    }

    @Test
    void serverErrorWithHtmlBodyIsRetriedThenRaised() {
        MockServer.Route route = server.route("GET", STATS).reply(MockServer.text(502, "<html>bad gateway</html>"));
        InternalServerException e = assertThrows(InternalServerException.class,
                () -> client.messages().statistics(DAY));
        assertEquals(3, route.count());
        assertEquals(502, e.getHttpStatus());
        assertNull(e.getBody());
    }

    @Test
    void errorWithEmptyBodyDoesNotBreakParsing() {
        // v1 threw a NullPointerException for error responses without a body
        server.route("GET", STATS).reply(MockServer.text(500, ""));
        InternalServerException e = assertThrows(InternalServerException.class,
                () -> client.messages().statistics(DAY));
        assertTrue(e.getMessage().contains("JSON이 아닙니다"), e.getMessage());
    }

    @Test
    void successStatusWithNonJsonBody() {
        server.route("GET", STATS).reply(MockServer.text(200, "ok"));
        InvalidResponseException e = assertThrows(InvalidResponseException.class,
                () -> client.messages().statistics(DAY));
        assertEquals(200, e.getHttpStatus());
    }

    @Test
    void responseWithWrongShapeIsInvalidResponse() {
        server.route("GET", STATS).reply(MockServer.json(200, envelope(Map.of("statistics", "not-a-list"))));
        assertThrows(InvalidResponseException.class, () -> client.messages().statistics(DAY));
    }

    @Test
    void connectionErrorHidesRequestDetails() {
        MockServer.Route route = server.route("GET", MO_HISTORY).reply(MockServer.disconnect());
        ApiConnectionException e = assertThrows(ApiConnectionException.class,
                () -> client.messages().moHistory(MoHistoryQuery.since("2026-04-23T14:11:01+09:00").from(OTHER_PHONE)));
        assertFalse(e.getMessage().contains(OTHER_PHONE));
        assertFalse(e.getMessage().contains("history"));
        assertNull(e.getCause(), "the HTTP client exception (with the full URL) is not chained");
        // queries are retried after connection errors (2 retries); the JDK client may also retry an idempotent GET
        assertEquals(2, delays.size());
        assertTrue(route.count() >= 3, String.valueOf(route.count()));
    }

    @Test
    void debugLogHasNoKeyQueryOrBody() {
        server.route("GET", MO_HISTORY).reply(MockServer.json(200, envelope(Map.of("messages", List.of(),
                "hasNext", false))));
        Logger logger = Logger.getLogger(Transport.LOGGER_NAME);
        List<String> lines = new ArrayList<>();
        Handler handler = new Handler() {
            @Override
            public void publish(LogRecord record) {
                lines.add(record.getMessage());
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() {
            }
        };
        Level previous = logger.getLevel();
        logger.setLevel(Level.ALL);
        logger.addHandler(handler);
        try {
            client.messages().moHistory(MoHistoryQuery.since("2026-04-23T14:11:01+09:00").from(OTHER_PHONE));
        } finally {
            logger.removeHandler(handler);
            logger.setLevel(previous);
        }
        String text = String.join("\n", lines);
        assertTrue(text.matches("GET /api/comm/v1/message/history/mo -> 200 \\(\\d+ ms, attempt 1\\)"), text);
        assertFalse(text.contains(API_KEY));
        assertFalse(text.contains(OTHER_PHONE));
    }

    @Test
    void toStringHidesKeyAndPersonalData() {
        assertFalse(client.toString().contains(API_KEY));
        String sms = SmsMessage.builder().from(PHONE).text("비밀 본문").build().toString();
        assertFalse(sms.contains(PHONE) || sms.contains("비밀"), sms);
        String destination = Destination.builder().to(OTHER_PHONE).build().toString();
        assertFalse(destination.contains(OTHER_PHONE), destination);
        assertFalse(MoHistoryQuery.since("2026-04-23T14:11:01+09:00").from(OTHER_PHONE).toString()
                .contains(OTHER_PHONE));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Bearer abc", "ApiKey abc", "  ", "", "key\twith-tab", "kéy-not-ascii"})
    void prefixedBlankOrInvalidKeysAreRejected(String key) {
        ConfigurationException e = assertThrows(ConfigurationException.class,
                () -> Bizgo.builder().apiKey(key).env(n -> null).build());
        if (!key.isBlank()) {
            assertFalse(e.getMessage().contains(key), e.getMessage());
        }
    }

    @Test
    void apiKeyFromEnvironment() {
        try (Bizgo fromEnv = Bizgo.builder().env(name -> "BIZGO_API_KEY".equals(name) ? API_KEY : null).build()) {
            assertEquals(Environment.PRODUCTION.baseUrl(), fromEnv.baseUrl());
        }
        ConfigurationException e = assertThrows(ConfigurationException.class,
                () -> Bizgo.builder().env(name -> null).build());
        assertTrue(e.getMessage().contains("BIZGO_API_KEY"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://mars.ibapi.kr", "ftp://example.com", "https://user:pw@example.com",
            "https://example.com/?a=b", "not a url", "https://"})
    void insecureOrMalformedBaseUrlsAreRejected(String url) {
        assertThrows(ConfigurationException.class,
                () -> Bizgo.builder().apiKey(API_KEY).baseUrl(url).build());
    }

    @Test
    void localhostHttpIsAllowedForMockServers() {
        try (Bizgo local = Bizgo.builder().apiKey(API_KEY).baseUrl("http://localhost:4010/").build()) {
            assertEquals("http://localhost:4010", local.baseUrl());
        }
        try (Bizgo sandbox = Bizgo.builder().apiKey(API_KEY).environment(Environment.SANDBOX).build()) {
            assertEquals("https://sandbox-mars.ibapi.kr", sandbox.baseUrl());
        }
    }

    @Test
    void httpClientThatFollowsRedirectsIsRejected() {
        HttpClient redirecting = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
        assertThrows(ConfigurationException.class,
                () -> Bizgo.builder().apiKey(API_KEY).httpClient(redirecting).build());
        HttpClient own = HttpClient.newBuilder().build(); // Redirect.NEVER is the default
        try (Bizgo ok = clientBuilder().httpClient(own).build()) {
            server.route("GET", STATS).reply(MockServer.json(200, envelope(Map.of("statistics", List.of()))));
            assertTrue(ok.messages().statistics(DAY).isEmpty());
        }
    }

    @Test
    void invalidSettingsAreRejected() {
        assertThrows(ConfigurationException.class, () -> clientBuilder().maxRetries(-1).build());
        assertThrows(ConfigurationException.class, () -> clientBuilder().timeout(java.time.Duration.ZERO).build());
    }

    @Test
    void genericApiExceptionForUnknownFailureCode() {
        server.route("GET", STATS).reply(MockServer.json(200, envelope(null, "Z999", null)));
        ApiException e = assertThrows(ApiException.class, () -> client.messages().statistics(DAY));
        assertEquals(ApiException.class, e.getClass());
        assertEquals("Z999", e.getCode());
    }
}
