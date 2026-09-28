package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.errors.InternalServerException;
import io.github.icommapi.bizgo.errors.RateLimitException;
import io.github.icommapi.bizgo.models.AlimtalkTemplate;
import io.github.icommapi.bizgo.models.KakaoSenderProfile;
import io.github.icommapi.bizgo.models.SmsMessage;
import io.github.icommapi.bizgo.params.GetAlimtalkTemplateParams;
import io.github.icommapi.bizgo.params.ListBrandMessageFriendGroupPhoneNumberRequestsParams;
import io.github.icommapi.bizgo.params.ListBrandMessageVideosParams;
import io.github.icommapi.bizgo.params.ListModifiedAlimtalkTemplatesParams;
import io.github.icommapi.bizgo.params.ListReservationsParams;
import io.github.icommapi.bizgo.testing.FakeTransport;
import io.github.icommapi.bizgo.testing.RecordedRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Every operation of the spec is reachable through the client, with the method, path, retry policy and pagination
 * of the spec. Runs against {@link FakeTransport}: no network.
 */
class OperationsTest {

    private static final JsonNode SPEC;

    static {
        try {
            SPEC = new ObjectMapper(new YAMLFactory()).readTree(Path.of("spec/openapi.yaml").toFile());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /** Hand-written P0 methods have their own signatures; call them explicitly. */
    private static final Map<String, Function<Bizgo, Object>> HAND_WRITTEN = Map.ofEntries(
            Map.entry("sendOmni", c -> c.send().omni("01000000000",
                    SmsMessage.builder().from("01000000000").text("hello").build())),
            Map.entry("uploadMmsFile", c -> c.files().uploadMms(FileUpload.of(new byte[] {1, 2, 3}, "a.jpg"))),
            Map.entry("uploadRcsFile", c -> c.files().uploadRcs(FileUpload.of(new byte[] {1, 2, 3}, "a.jpg"))),
            Map.entry("getReportPolling", c -> c.reports().poll()),
            Map.entry("ackReportPolling", c -> {
                c.reports().ack("P1");
                return null;
            }),
            Map.entry("getReportInquiry", c -> c.reports().inquiry("P1")),
            Map.entry("getMessageStatistics", c -> c.messages().statistics(LocalDate.of(2026, 1, 1))),
            Map.entry("getMessageHistory", c -> c.messages().history(
                    HistoryQuery.since(LocalDateTime.of(2026, 1, 1, 0, 0)))),
            Map.entry("getMoHistory", c -> c.messages().moHistory(
                    MoHistoryQuery.since(LocalDateTime.of(2026, 1, 1, 0, 0)))),
            Map.entry("getMessageStatusByMsgKey", c -> c.messages().status("P1")),
            Map.entry("getMessageStatusByRequestId", c -> c.messages().statusByRequestId("P1")),
            Map.entry("getMoByMsgKey", c -> c.messages().mo("P1")));

    static Stream<Arguments> operations() {
        List<Arguments> list = new ArrayList<>();
        SPEC.get("paths").properties().forEach(path -> path.getValue().properties().forEach(op -> {
            if (op.getValue().has("operationId")) {
                list.add(Arguments.of(op.getValue().get("operationId").asText(),
                        op.getKey().toUpperCase(java.util.Locale.ROOT), path.getKey(), op.getValue()));
            }
        }));
        return list.stream();
    }

    static Stream<Arguments> paginated() {
        return operations().filter(a -> ((JsonNode) a.get()[3]).has("x-sdk-pagination"));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("operations")
    void metadataMatchesTheSpec(String id, String httpMethod, String template, JsonNode node) {
        Operation op = Operation.find(id).orElseThrow();
        assertEquals(httpMethod, op.getHttpMethod());
        assertEquals(template, op.getPathTemplate());
        assertEquals(node.get("x-sdk-resource").asText(), op.getResource());
        assertEquals(node.get("x-sdk-method").asText(), op.getMethod());
        assertEquals(node.get("x-sdk-retry").asText(), op.getRetryPolicy());
        assertEquals(node.path("x-sdk-result").asText("data.data"), op.getResultPath());
        assertEquals(node.has("x-sdk-pagination") ? node.at("/x-sdk-pagination/style").asText() : null,
                op.getPaginationStyle().orElse(null));
        assertEquals(op, Operation.match(httpMethod, expectedPath(op)).orElseThrow());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("operations")
    void everyOperationIsReachable(String id, String httpMethod, String template, JsonNode node) {
        FakeTransport fake = new FakeTransport();
        Operation op = Operation.find(id).orElseThrow();
        try (Bizgo client = fake.clientBuilder().maxRetries(0).build()) {
            Object result = call(client, op);
            List<RecordedRequest> requests = fake.requests();
            assertEquals(1, requests.size(), "one request");
            RecordedRequest request = requests.get(0);
            assertEquals(id, request.getOperationId());
            assertEquals(httpMethod, request.getMethod());
            assertEquals(expectedPath(op), request.getPath());
            Method method = method(resource(client, op), op.getMethod());
            if (method.getReturnType() != void.class) {
                assertNotNull(result, "non-void result");
            }
        }
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("operations")
    void retryPolicyFollowsTheSpec(String id, String httpMethod, String template, JsonNode node) {
        FakeTransport fake = new FakeTransport();
        Operation op = Operation.find(id).orElseThrow();
        fake.on(id).thenFail(ErrorLayer.GATEWAY, 503, "A503").thenDefault();
        try (Bizgo client = fake.clientBuilder().maxRetries(1).sleeper(d -> { }).build()) {
            if (op.getRetryPolicy().equals("safe")) {
                call(client, op);
                assertEquals(2, fake.requests().size(), "retried after 503");
            } else {
                RuntimeException e = assertThrows(RuntimeException.class, () -> call(client, op));
                assertInstanceOf(InternalServerException.class, e);
                assertEquals(1, fake.requests().size(), "not retried after 503");
            }
        }
        // 429 is retried for every operation: the gateway rejected the request before processing it
        FakeTransport limited = new FakeTransport();
        limited.on(id).thenFail(ErrorLayer.SERVICE, 429, "A020").thenDefault();
        try (Bizgo client = limited.clientBuilder().maxRetries(1).sleeper(d -> { }).build()) {
            call(client, op);
            assertEquals(2, limited.requests().size());
        }
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("paginated")
    void paginatedOperationsHaveIterators(String id, String httpMethod, String template, JsonNode node)
            throws Exception {
        FakeTransport fake = new FakeTransport();
        Operation op = Operation.find(id).orElseThrow();
        try (Bizgo client = fake.clientBuilder().build()) {
            Object resource = resource(client, op);
            String suffix = Character.toUpperCase(op.getMethod().charAt(0)) + op.getMethod().substring(1);
            Method iter = method(resource, "iter" + suffix);
            Object iterable = iter.invoke(resource, validArgs(iter, node));
            assertEquals(0, StreamSupport.stream(((Iterable<?>) iterable).spliterator(), false).count());
            assertEquals(1, fake.requests().size(), "an empty first page ends the iteration");
            Method stream = method(resource, "stream" + suffix);
            assertEquals(0, ((Stream<?>) stream.invoke(resource, validArgs(stream, node))).count());
        }
    }

    @Test
    void cursorPaginationFollowsLastSeq() {
        FakeTransport fake = new FakeTransport();
        fake.on("listReservations")
                .thenData("{\"reservations\":[{\"resvKey\":\"R1\"}],\"lastSeq\":5,\"hasNext\":true}")
                .thenData("{\"reservations\":[{\"resvKey\":\"R2\"}],\"lastSeq\":6,\"hasNext\":false}");
        try (Bizgo client = fake.client()) {
            List<String> keys = client.reservations().streamList(ListReservationsParams.builder()
                            .resvSendTime("2026-01-01T00:00:00").build())
                    .map(r -> r.getResvKey()).collect(Collectors.toList());
            assertEquals(List.of("R1", "R2"), keys);
        }
        assertFalse(fake.requests().get(0).getQuery().containsKey("lastSeq"));
        assertEquals("5", fake.requests().get(1).getQuery().get("lastSeq"));
    }

    @Test
    void cursorFromTheLastItem() {
        FakeTransport fake = new FakeTransport();
        fake.on("listBrandMessageFriendGroupPhoneNumberRequests")
                .thenData("{\"friendGroups\":[{\"requestId\":\"Q1\"},{\"requestId\":\"Q2\"}],\"hasNext\":true}")
                .thenData("{\"friendGroups\":[{\"requestId\":\"Q3\"}],\"hasNext\":false}");
        try (Bizgo client = fake.client()) {
            long count = client.brandMessage().friendGroups().streamListPhoneNumberRequests(
                    ListBrandMessageFriendGroupPhoneNumberRequestsParams.builder()
                            .senderKey("SENDER_KEY_EXAMPLE").friendGroupKey("FG1").build()).count();
            assertEquals(3, count);
        }
        assertEquals("Q2", fake.requests().get(1).getQuery().get("lastRequestId"));
    }

    @Test
    void pagePaginationStopsAtAShortPage() {
        FakeTransport fake = new FakeTransport();
        fake.on("listModifiedAlimtalkTemplates")
                .thenData("{\"alimtalk\":{\"templates\":[{\"templateCode\":\"T1\"},{\"templateCode\":\"T2\"}]}}")
                .thenData("{\"alimtalk\":{\"templates\":[{\"templateCode\":\"T3\"}]}}");
        try (Bizgo client = fake.client()) {
            List<String> codes = client.alimtalk().templates().streamListModified(
                            ListModifiedAlimtalkTemplatesParams.builder().senderKey("SENDER_KEY_EXAMPLE").count(2).build())
                    .map(AlimtalkTemplate::getTemplateCode).collect(Collectors.toList());
            assertEquals(List.of("T1", "T2", "T3"), codes);
        }
        assertEquals(2, fake.requests().size());
        assertEquals("1", fake.requests().get(0).getQuery().get("page"));
        assertEquals("2", fake.requests().get(1).getQuery().get("page"));
    }

    @Test
    void pageThatRepeatsStopsTheIteration() {
        FakeTransport fake = new FakeTransport();
        fake.on("listModifiedAlimtalkTemplates")
                .thenData("{\"alimtalk\":{\"templates\":[{\"templateCode\":\"T1\"}]}}");
        try (Bizgo client = fake.client()) {
            long count = client.alimtalk().templates().streamListModified(
                    ListModifiedAlimtalkTemplatesParams.builder().senderKey("SENDER_KEY_EXAMPLE").build()).count();
            assertEquals(1, count);
        }
        assertEquals(2, fake.requests().size());
    }

    @Test
    void offsetPaginationStopsAtTheTotal() {
        FakeTransport fake = new FakeTransport();
        fake.on("listBrandMessageVideos")
                .thenData("{\"videos\":[{\"vid\":\"V1\"},{\"vid\":\"V2\"}],\"totalCount\":3}")
                .thenData("{\"videos\":[{\"vid\":\"V3\"}],\"totalCount\":3}");
        try (Bizgo client = fake.client()) {
            long count = client.brandMessage().videos().streamList(ListBrandMessageVideosParams.builder()
                    .senderKey("SENDER_KEY_EXAMPLE").build()).count();
            assertEquals(3, count);
        }
        assertEquals(2, fake.requests().size());
        assertEquals("0", fake.requests().get(0).getQuery().get("offset"));
        assertEquals("2", fake.requests().get(1).getQuery().get("offset"));
    }

    @Test
    void resultIsTakenFromTheSdkResultPath() {
        FakeTransport fake = new FakeTransport();
        fake.on("getAlimtalkTemplate").thenData("{\"alimtalk\":{\"templateCode\":\"TPL_001\"}}");
        fake.on("findKakaoSender").thenRespond(200, "{\"common\":{\"authCode\":\"A000\"},\"data\":{\"code\":\"A000\","
                + "\"kakao\":{\"senderProfile\":{\"senderKey\":\"SENDER_KEY_EXAMPLE\"}}}}");
        try (Bizgo client = fake.client()) {
            AlimtalkTemplate template = client.alimtalk().templates().get(GetAlimtalkTemplateParams.builder()
                    .senderKey("SENDER_KEY_EXAMPLE").templateCode("TPL_001").build());
            assertEquals("TPL_001", template.getTemplateCode());
            KakaoSenderProfile profile = client.kakao().senders().find();
            assertEquals("SENDER_KEY_EXAMPLE", profile.getSenderKey());
        }
        RecordedRequest get = fake.requests().get(0);
        assertEquals(Map.of("senderKey", "SENDER_KEY_EXAMPLE", "templateCode", "TPL_001"), get.getQuery());
    }

    @Test
    void requiredParametersAreValidatedBeforeSending() {
        FakeTransport fake = new FakeTransport();
        assertThrows(io.github.icommapi.bizgo.errors.ValidationException.class,
                () -> GetAlimtalkTemplateParams.builder().senderKey("SENDER_KEY_EXAMPLE").build());
        try (Bizgo client = fake.client()) {
            assertThrows(io.github.icommapi.bizgo.errors.ValidationException.class,
                    () -> client.alimtalk().templates().delete("SENDER_KEY_EXAMPLE", ".."));
        }
        assertTrue(fake.requests().isEmpty());
    }

    @Test
    void pathValuesAreEncoded() {
        FakeTransport fake = new FakeTransport();
        try (Bizgo client = fake.client()) {
            client.alimtalk().templates().delete("SENDER/KEY", "a?b");
        }
        assertEquals("/api/comm/v1/center/alimtalk/template/senderKey/SENDER%2FKEY/templateCode/a%3Fb",
                fake.lastRequest().getPath());
    }

    @Test
    void rateLimitRetryUsesRateLimitException() {
        FakeTransport fake = new FakeTransport();
        fake.on("getReportPolling").thenFail(ErrorLayer.SERVICE, 429, "A020");
        try (Bizgo client = fake.clientBuilder().maxRetries(0).build()) {
            assertThrows(RateLimitException.class, () -> client.reports().poll());
        }
    }

    // ------------------------------------------------------------------ reflection helpers

    static String expectedPath(Operation op) {
        String path = op.getPathTemplate();
        int i = 1;
        for (String name : op.getPathParameters()) {
            path = path.replace("{" + name + "}", "P" + i++);
        }
        return path;
    }

    static Object call(Bizgo client, Operation op) {
        Function<Bizgo, Object> handWritten = HAND_WRITTEN.get(op.getOperationId());
        if (handWritten != null) {
            return handWritten.apply(client);
        }
        Object resource = resource(client, op);
        Method method = method(resource, op.getMethod());
        try {
            return method.invoke(resource, args(method));
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof RuntimeException) {
                throw (RuntimeException) e.getCause();
            }
            throw new IllegalStateException(e.getCause());
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }

    static Object resource(Bizgo client, Operation op) {
        Object target = client;
        for (String part : op.getResource().split("\\.")) {
            try {
                target = target.getClass().getMethod(part).invoke(target);
            } catch (ReflectiveOperationException e) {
                throw new AssertionError("no resource accessor " + part + " for " + op, e);
            }
        }
        return target;
    }

    /** The overload with the most parameters, not taking a {@link Path}. */
    static Method method(Object resource, String name) {
        return Arrays.stream(resource.getClass().getMethods())
                .filter(m -> m.getName().equals(name) && Modifier.isPublic(m.getModifiers()))
                .filter(m -> Arrays.stream(m.getParameterTypes()).noneMatch(Path.class::equals))
                .max(Comparator.comparingInt(Method::getParameterCount))
                .orElseThrow(() -> new AssertionError("no method " + name + " on " + resource.getClass()));
    }

    static Object[] args(Method method) {
        Class<?>[] types = method.getParameterTypes();
        Object[] args = new Object[types.length];
        int path = 1;
        for (int i = 0; i < types.length; i++) {
            Class<?> type = types[i];
            if (type == String.class) {
                args[i] = "P" + path++;
            } else if (type == FileUpload.class) {
                args[i] = FileUpload.of(new byte[] {1, 2, 3}, "a.jpg");
            } else {
                args[i] = unvalidated(type);
            }
        }
        return args;
    }

    /** Arguments that pass validation: required query parameters get sample values (iterators rebuild them). */
    static Object[] validArgs(Method method, JsonNode node) throws ReflectiveOperationException {
        Class<?>[] types = method.getParameterTypes();
        Object[] args = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            Class<?> type = types[i];
            if (type == String.class) {
                args[i] = "P" + (i + 1);
            } else if (type == HistoryQuery.class) {
                args[i] = HistoryQuery.since(LocalDateTime.of(2026, 1, 1, 0, 0));
            } else if (type == MoHistoryQuery.class) {
                args[i] = MoHistoryQuery.since(LocalDateTime.of(2026, 1, 1, 0, 0));
            } else {
                Object builder = type.getMethod("builder").invoke(null);
                for (JsonNode p : node.path("parameters")) {
                    if (!p.path("required").asBoolean() || p.path("in").asText().equals("path")) {
                        continue;
                    }
                    JsonNode schema = p.path("schema");
                    String kind = schema.path("type").asText();
                    Object value;
                    Class<?> param;
                    if (kind.equals("integer")) {
                        boolean wide = "int64".equals(schema.path("format").asText());
                        value = wide ? (Object) 1L : (Object) 1;
                        param = wide ? Long.class : Integer.class;
                    } else if (kind.equals("array")) {
                        value = List.of("X");
                        param = List.class;
                    } else {
                        value = schema.has("enum") ? schema.get("enum").get(0).asText() : "X";
                        param = String.class;
                    }
                    builder.getClass().getMethod(p.path("name").asText(), param).invoke(builder, value);
                }
                args[i] = builder.getClass().getMethod("build").invoke(builder);
            }
        }
        return args;
    }

    /** Builds an empty request model or parameter object without validation (the fake does not care). */
    static Object unvalidated(Class<?> type) {
        try {
            Object builder = type.getMethod("builder").invoke(null);
            Method build = builder.getClass().getDeclaredMethod("buildUnvalidated");
            build.setAccessible(true);
            return build.invoke(builder);
        } catch (ReflectiveOperationException e) {
            throw new AssertionError("cannot build " + type, e);
        }
    }
}
