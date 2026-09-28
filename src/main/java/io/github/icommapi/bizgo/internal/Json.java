package io.github.icommapi.bizgo.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.io.IOException;
import java.util.Map;

/**
 * Shared Jackson configuration. Internal: not part of the public API and may change without notice.
 *
 * <p>The mappers are private (an {@link ObjectMapper} is mutable, so it is never handed out); only these static
 * helpers are exposed. They hold no credentials or per-client state. JSON nesting is limited to
 * {@link #MAX_DEPTH} levels (SDK-DESIGN 12.8).
 */
public final class Json {

    /**
     * Lenient mapper for responses and webhooks: unknown properties are kept by the response models, scalars are
     * coerced. Request models that also appear in responses are read without request validation (and ignore
     * unknown properties) through {@link LenientBuilder}.
     */
    private static final ObjectMapper RESPONSE = responseMapper();

    /** Maximum JSON nesting depth of responses, webhooks and request JSON. */
    public static final int MAX_DEPTH = 64;

    /**
     * Strict mapper for request bodies built from JSON or maps: unknown properties fail, and numbers are not
     * silently turned into strings (or the other way round).
     */
    private static final ObjectMapper REQUEST = strictRequestMapper();

    private Json() {
    }

    /**
     * Parses a response or webhook body.
     *
     * @param bytes JSON bytes
     * @return tree
     * @throws IOException if it is not JSON or nested too deeply
     */
    public static JsonNode readTree(byte[] bytes) throws IOException {
        return RESPONSE.readTree(bytes);
    }

    /**
     * Parses JSON text (lenient response rules).
     *
     * @param text JSON
     * @return tree
     * @throws IOException if it is not JSON
     */
    public static JsonNode readTree(String text) throws IOException {
        return RESPONSE.readTree(text);
    }

    /**
     * Converts a response tree to a model (unknown properties are kept or ignored).
     *
     * @param node tree
     * @param type model class
     * @param <T> model type
     * @return model
     * @throws JsonProcessingException if the tree does not fit the model
     */
    public static <T> T treeToValue(JsonNode node, Class<T> type) throws JsonProcessingException {
        return RESPONSE.treeToValue(node, type);
    }

    /**
     * Writes a value as JSON (lenient mapper, for acknowledgements).
     *
     * @param value value
     * @return JSON text
     * @throws JsonProcessingException if it cannot be written
     */
    public static String write(Object value) throws JsonProcessingException {
        return RESPONSE.writeValueAsString(value);
    }

    /**
     * Writes a request model.
     *
     * @param model request model
     * @return UTF-8 JSON
     * @throws JsonProcessingException if it cannot be written
     */
    public static byte[] writeRequest(Object model) throws JsonProcessingException {
        return REQUEST.writeValueAsBytes(model);
    }

    /**
     * Converts a request model (or a map) to a new tree with the request serialization rules (nulls left out). The
     * result is a copy: changing it does not change {@code model}.
     *
     * @param model request model or map
     * @return new tree
     * @throws IllegalArgumentException if it cannot be converted
     */
    public static JsonNode requestTree(Object model) {
        return REQUEST.valueToTree(model);
    }

    /**
     * Writes a request model as text.
     *
     * @param model request model
     * @return JSON text
     * @throws JsonProcessingException if it cannot be written
     */
    public static String writeRequestString(Object model) throws JsonProcessingException {
        return REQUEST.writeValueAsString(model);
    }

    /**
     * Reads a request model strictly (unknown properties and type coercions fail).
     *
     * @param json JSON text
     * @param type model class
     * @param <T> model type
     * @return model
     * @throws JsonProcessingException if the JSON is invalid
     */
    public static <T> T readRequest(String json, Class<T> type) throws JsonProcessingException {
        return REQUEST.readValue(json, type);
    }

    /**
     * Converts nested maps to a request model strictly.
     *
     * @param body maps and lists with the API field names
     * @param type model class
     * @param <T> model type
     * @return model
     * @throws IllegalArgumentException if the map does not fit
     */
    public static <T> T convertRequest(Map<String, ?> body, Class<T> type) {
        return REQUEST.convertValue(body, type);
    }

    private static JsonFactory factory() {
        return JsonFactory.builder()
                .streamReadConstraints(StreamReadConstraints.builder().maxNestingDepth(MAX_DEPTH).build())
                .build();
    }

    /** Mix-in for the builders of the request models when they are read from a response. */
    @JsonPOJOBuilder(buildMethodName = "buildUnvalidated", withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private abstract static class LenientBuilder {
    }

    private static ObjectMapper responseMapper() {
        JsonMapper.Builder builder = JsonMapper.builder(factory()).disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        for (Class<?> type : GeneratedRequestModels.BUILDERS) {
            builder.addMixIn(type, LenientBuilder.class);
        }
        return builder.build();
    }

    private static ObjectMapper strictRequestMapper() {
        JsonMapper mapper = JsonMapper.builder(factory())
                .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(DeserializationFeature.ACCEPT_FLOAT_AS_INT)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .build();
        mapper.coercionConfigFor(LogicalType.Textual)
                .setCoercion(CoercionInputShape.Integer, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail);
        mapper.coercionConfigFor(LogicalType.Integer)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail);
        mapper.coercionConfigFor(LogicalType.Float)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail);
        mapper.coercionConfigFor(LogicalType.Boolean)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Integer, CoercionAction.Fail);
        return mapper;
    }
}
