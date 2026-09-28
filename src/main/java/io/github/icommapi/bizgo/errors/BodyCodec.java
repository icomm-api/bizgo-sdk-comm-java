package io.github.icommapi.bizgo.errors;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.icommapi.bizgo.internal.Json;
import java.io.IOException;

/** Response bodies of exceptions travel through Java serialization as JSON text (SDK-DESIGN 12.10). */
final class BodyCodec {

    private BodyCodec() {
    }

    static String encode(JsonNode body) {
        return body == null ? null : body.toString();
    }

    static JsonNode decode(String text) {
        if (text == null) {
            return null;
        }
        try {
            return Json.readTree(text);
        } catch (IOException e) {
            return null;
        }
    }
}
