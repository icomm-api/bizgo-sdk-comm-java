package io.github.icommapi.bizgo.testing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

/** JSON bodies for {@link FakeTransport.Stub#thenRespond(int, String)}. */
public final class FakeResponses {

    private FakeResponses() {
    }

    /**
     * A success envelope: {@code {"common": {"authCode": "A000", ...}, "data": {"code": "A000", "data": <data>}}}.
     *
     * @param dataJson JSON of {@code data.data}
     * @return envelope JSON
     */
    public static String success(String dataJson) {
        try {
            return FakeTransport.JSON.writeValueAsString(successNode(FakeTransport.JSON.readTree(dataJson)));
        } catch (IOException e) {
            throw new IllegalArgumentException("dataJson is not JSON");
        }
    }

    static ObjectNode successNode(JsonNode data) {
        ObjectNode body = FakeTransport.JSON.createObjectNode();
        ObjectNode common = body.putObject("common");
        common.put("authCode", "A000");
        common.put("authResult", "Success");
        common.put("infobankTrId", "FAKE-TR-ID");
        ObjectNode inner = body.putObject("data");
        inner.put("code", "A000");
        inner.put("result", "Success");
        inner.set("data", data);
        return body;
    }
}
