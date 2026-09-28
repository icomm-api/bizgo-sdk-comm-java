package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.github.icommapi.bizgo.errors.ServiceCodes;
import io.github.icommapi.bizgo.internal.Json;
import io.github.icommapi.bizgo.models.BrandMessageFileUploadResponse;
import io.github.icommapi.bizgo.models.RcsFileUploadResponse;
import io.github.icommapi.bizgo.models.SendOmniRequest;
import io.github.icommapi.bizgo.models.SendOmniResponse;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Consistency with the vendored OpenAPI spec. */
class SpecTest {

    private static final JsonNode SPEC = read("spec/openapi.yaml", new ObjectMapper(new YAMLFactory()));
    private static final JsonNode SEND = SPEC.at("/paths/~1api~1comm~1v1~1send~1omni/post");

    private static JsonNode read(String file, ObjectMapper mapper) {
        try {
            return mapper.readTree(Path.of(file).toFile());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    static Stream<String> requestExamples() {
        List<String> names = new ArrayList<>();
        SEND.at("/requestBody/content/application~1json/examples").fieldNames().forEachRemaining(names::add);
        return names.stream();
    }

    @ParameterizedTest
    @MethodSource("requestExamples")
    void specRequestExamplesValidateAndRoundTrip(String name) throws Exception {
        JsonNode value = SEND.at("/requestBody/content/application~1json/examples/" + name + "/value");
        SendOmniRequest request = SendOmniRequest.fromJson(value.toString());
        assertEquals(value, Json.readTree(request.toJson()));
        @SuppressWarnings("unchecked")
        Map<String, Object> map = new ObjectMapper().convertValue(value, Map.class);
        assertEquals(request, SendOmniRequest.fromMap(map));
    }

    @Test
    void specResponseExamplesParse() throws Exception {
        JsonNode example = SEND.at("/responses/200/content/application~1json/example");
        SendOmniResponse response = Json.treeToValue(example, SendOmniResponse.class);
        assertEquals("20260424104234546POM101182450000",
                response.getData().getData().getDestinations().get(0).getMsgKey());
        assertEquals("sms-20260330-001", response.getData().getRef());
        JsonNode rcs = SPEC.at("/paths/~1api~1comm~1v1~1file~1rcs/post/responses/200/content/application~1json/example");
        assertEquals("maapfile://MEDIA_KEY_EXAMPLE",
                Json.treeToValue(rcs, RcsFileUploadResponse.class).getData().getData().getMedia());
        JsonNode brand = SPEC.at("/paths/~1api~1comm~1v1~1file~1brandmessage~1wide/post/responses/200/content"
                + "/application~1json/example");
        assertNotNull(Json.treeToValue(brand, BrandMessageFileUploadResponse.class).getData().getData()
                .getImgUrl());
    }

    @Test
    void everyOperationIsCovered() {
        // The operation table is generated from the spec; OperationsTest calls every one of them.
        Set<String> ids = new TreeSet<>();
        SPEC.get("paths").forEach(item -> item.properties().forEach(op -> {
            if (op.getValue().has("operationId")) {
                ids.add(op.getValue().get("operationId").asText());
            }
        }));
        Set<String> generated = new TreeSet<>();
        Operation.all().forEach(op -> generated.add(op.getOperationId()));
        assertEquals(ids, generated);
        assertEquals(146, generated.size());
        // every brand message upload path is reachable through BrandImageKind
        Set<String> brandPaths = new TreeSet<>();
        SPEC.get("paths").fieldNames().forEachRemaining(p -> {
            // catalog images are not a BrandImageKind (SDK-DESIGN 3); files().uploadBrandMessageCatalog*() cover them
            if (p.startsWith("/api/comm/v1/file/brandmessage/") && !p.contains("/catalog")) {
                brandPaths.add(p.substring("/api/comm/v1/file/brandmessage/".length()));
            }
        });
        Set<String> kinds = new TreeSet<>();
        for (BrandImageKind kind : BrandImageKind.values()) {
            kinds.add(kind.value());
        }
        assertEquals(brandPaths, kinds);
    }

    @Test
    void everySchemaHasAModel() {
        List<String> missing = new ArrayList<>();
        SPEC.at("/components/schemas").fieldNames().forEachRemaining(name -> {
            JsonNode schema = SPEC.at("/components/schemas/" + name);
            if (isSimpleUpload(schema) || (name.endsWith("FlowItem") && !schema.has("oneOf"))) {
                return; // file + fileKey + imageName uploads use FileUpload; SmsFlowItem etc. are MessageFlowItem
            }
            try {
                Class.forName("io.github.icommapi.bizgo.models." + name);
            } catch (ClassNotFoundException e) {
                missing.add(name);
            }
        });
        assertEquals(List.of(), missing);
    }

    private static boolean isSimpleUpload(JsonNode schema) {
        Set<String> names = new TreeSet<>();
        schema.path("properties").fieldNames().forEachRemaining(names::add);
        return names.contains("file") && Set.of("file", "fileKey", "imageName").containsAll(names);
    }

    @Test
    void serviceCodeTableMatchesTheErrorCodeFile() {
        JsonNode codes = read("spec/error-codes.json", new ObjectMapper());
        assertEquals(codes.get("service").size(), ServiceCodes.all().size());
        codes.get("service").forEach(entry -> {
            ServiceCodes.Code code = ServiceCodes.lookup(entry.get("code").asText()).orElseThrow();
            assertEquals(entry.path("httpStatus").asInt(0), code.httpStatus());
            assertFalse(code.description().isEmpty());
        });
        assertEquals(400, ServiceCodes.lookup("A306").orElseThrow().httpStatus());
    }

    @Test
    void specVersionsAreCopiedFromTheSpecRepository() {
        assertDoesNotThrow(() -> SPEC.at("/info/version").asText());
        assertEquals("3.1.0", SPEC.get("openapi").asText());
    }
}
