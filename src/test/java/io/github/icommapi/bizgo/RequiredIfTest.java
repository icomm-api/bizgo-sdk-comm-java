package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.models.AlimtalkMessage;
import io.github.icommapi.bizgo.models.BrandMessageButton;
import io.github.icommapi.bizgo.models.CounselFile;
import io.github.icommapi.bizgo.models.CounselPlainAttachment;
import io.github.icommapi.bizgo.models.CounselPlainMessageRequest;
import io.github.icommapi.bizgo.models.Destination;
import io.github.icommapi.bizgo.models.RcsBody;
import io.github.icommapi.bizgo.models.RcsMessage;
import io.github.icommapi.bizgo.models.SendOmniRequest;
import io.github.icommapi.bizgo.models.SmsMessage;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** The spec's {@code x-sdk-required-if} rules are checked before anything is sent (SDK-DESIGN §4). */
class RequiredIfTest extends TestSupport {

    private static final String PATH = "/api/comm/v1/send/omni";
    private static final String SECRET_TEXT = "본문-값-노출-금지";

    private static void assertNoValues(ValidationException e) {
        assertFalse(e.getMessage().contains(PHONE), e.getMessage());
        assertFalse(e.getMessage().contains("SENDER_KEY_EXAMPLE"), e.getMessage());
        assertFalse(e.getMessage().contains(SECRET_TEXT), e.getMessage());
    }

    private static AlimtalkMessage.Builder alimtalk() {
        return AlimtalkMessage.builder().senderKey("SENDER_KEY_EXAMPLE").templateCode("TEMPLATE_CODE_EXAMPLE");
    }

    @Test
    void alimtalkFullSendWithoutMsgTypeFailsBeforeSending() {
        server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        // no sendType: notEquals is true for a missing field, so msgType and text are required (server: A523)
        ValidationException e = assertThrows(ValidationException.class, () -> alimtalk().text(SECRET_TEXT).build());
        assertEquals(List.of("AlimtalkMessage.msgType"),
                e.getViolations().stream().map(ValidationException.Violation::field).toList());
        assertTrue(e.getMessage().contains("sendType != template"), e.getMessage());
        assertNoValues(e);

        // the same request as a raw map: the path names the position in the body
        Map<String, Object> body = Map.of(
                "destinations", List.of(Map.of("to", PHONE)),
                "messageFlow", List.of(Map.of("alimtalk", Map.of(
                        "senderKey", "SENDER_KEY_EXAMPLE", "templateCode", "TEMPLATE_CODE_EXAMPLE", "text", SECRET_TEXT))));
        ValidationException raw = assertThrows(ValidationException.class, () -> SendOmniRequest.fromMap(body));
        assertEquals("messageFlow[0].alimtalk.msgType", raw.getViolations().get(0).field());
        assertNoValues(raw);
        assertTrue(server.requests.isEmpty(), "nothing is sent");
    }

    @Test
    void alimtalkFullSendWithMsgTypeAndTextIsSent() throws Exception {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        client.send().omni(PHONE, alimtalk().msgType("AT").text("주문이 접수되었습니다.").build());
        JsonNode sent = route.last().json().at("/messageFlow/0/alimtalk");
        assertEquals("AT", sent.get("msgType").asText());
        assertEquals(1, route.count());
    }

    @Test
    void templateSendNeedsReplaceWordsForEveryRecipient() {
        server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        AlimtalkMessage template = alimtalk().sendType("template").build(); // msgType and text are not required
        ValidationException e = assertThrows(ValidationException.class, () -> client.send().omni(List.of(
                Destination.builder().to(PHONE).replaceWords(Map.of("name", SECRET_TEXT)).build(),
                Destination.builder().to(OTHER_PHONE).build()), List.of(template), null));
        assertEquals(List.of("SendOmniRequest.destinations[1].replaceWords"),
                e.getViolations().stream().map(ValidationException.Violation::field).toList());
        assertTrue(e.getMessage().contains("messageFlow[0].alimtalk.sendType == template"), e.getMessage());
        assertFalse(e.getMessage().contains(OTHER_PHONE), e.getMessage());
        assertNoValues(e);

        // bulk: checked for every chunk before the first chunk is sent
        assertThrows(ValidationException.class, () -> client.send().bulk(List.of(
                Destination.builder().to(PHONE).replaceWords(Map.of("name", "a")).build(),
                Destination.builder().to(OTHER_PHONE).build()), List.of(template),
                BulkOptions.builder().chunkSize(1).build()));
        // raw JSON body
        ValidationException raw = assertThrows(ValidationException.class, () -> SendOmniRequest.fromJson(
                "{\"destinations\":[{\"to\":\"" + PHONE + "\"}],\"messageFlow\":[{\"sms\":{\"from\":\"" + PHONE
                        + "\",\"text\":\"x\"}},{\"alimtalk\":{\"senderKey\":\"SENDER_KEY_EXAMPLE\","
                        + "\"templateCode\":\"T\",\"sendType\":\"template\"}}]}"));
        assertEquals("SendOmniRequest.destinations[0].replaceWords", raw.getViolations().get(0).field());
        assertTrue(raw.getMessage().contains("messageFlow[1].alimtalk"), raw.getMessage());
        assertNoValues(raw);
        assertTrue(server.requests.isEmpty(), "nothing is sent");
    }

    @Test
    void templateSendWithReplaceWordsIsSentWithoutMsgType() throws Exception {
        MockServer.Route route = server.route("POST", PATH).reply(MockServer.json(200, accepted("A000")));
        client.send().omni(
                List.of(Destination.builder().to(PHONE).replaceWords(Map.of("name", "홍길동")).build()),
                List.of(alimtalk().sendType("template").build(),
                        SmsMessage.builder().from(PHONE).text("#{name}님").build()),
                null);
        JsonNode sent = route.last().json().at("/messageFlow/0/alimtalk");
        assertEquals("template", sent.get("sendType").asText());
        assertFalse(sent.has("msgType"));
        assertEquals(1, route.count());
    }

    @Test
    void otherRules() {
        // brand message button: WL needs urlPc and urlMobile, AL needs urlMobile
        ValidationException wl = assertThrows(ValidationException.class,
                () -> BrandMessageButton.builder().type("WL").urlMobile("https://example.com/m").build());
        assertEquals(List.of("BrandMessageButton.urlPc"),
                wl.getViolations().stream().map(ValidationException.Violation::field).toList());
        assertFalse(wl.getMessage().contains("example.com"), wl.getMessage());
        BrandMessageButton.builder().type("WL").urlMobile("https://example.com/m").urlPc("https://example.com").build();
        BrandMessageButton.builder().type("BK").build();

        // RCS: header 1 (advertisement) needs footer
        RcsMessage.Builder rcs = RcsMessage.builder().from(PHONE).formatId("F").brandKey("B")
                .body(RcsBody.builder().build());
        ValidationException header = assertThrows(ValidationException.class, () -> rcs.header("1").build());
        assertEquals("RcsMessage.footer", header.getViolations().get(0).field());
        assertTrue(header.getMessage().contains("header == 1"), header.getMessage());
        assertNoValues(header);
        rcs.header("1").footer("0800000000").build();
        rcs.header("0").footer(null).build();

        // counsel plain FILE: relative path through a missing intermediate object
        CounselPlainMessageRequest.Builder counsel = CounselPlainMessageRequest.builder().userKey("U").senderKey("S")
                .msgType("FILE").message(SECRET_TEXT);
        ValidationException file = assertThrows(ValidationException.class, counsel::build);
        assertEquals(List.of("CounselPlainMessageRequest.attachment.file.fileName",
                        "CounselPlainMessageRequest.attachment.file.fileSize"),
                file.getViolations().stream().map(ValidationException.Violation::field).toList());
        assertNoValues(file);
        counsel.attachment(CounselPlainAttachment.builder().file(CounselFile.builder().fileUrl("https://example.com/f")
                .fileName("a.pdf").fileSize("10").build()).build()).build();
        counsel.msgType("TEXT").attachment(null).build();
        assertTrue(server.requests.isEmpty());
    }
}
