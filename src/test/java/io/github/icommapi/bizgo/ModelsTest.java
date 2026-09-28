package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.models.AlimtalkItem;
import io.github.icommapi.bizgo.models.AlimtalkItemListEntry;
import io.github.icommapi.bizgo.models.AlimtalkMessage;
import io.github.icommapi.bizgo.models.BrandMessage;
import io.github.icommapi.bizgo.models.BrandMessageCommerce;
import io.github.icommapi.bizgo.models.ChannelMessage;
import io.github.icommapi.bizgo.models.Destination;
import io.github.icommapi.bizgo.models.InternationalMessage;
import io.github.icommapi.bizgo.models.MessageBytes;
import io.github.icommapi.bizgo.models.MessageFlowItem;
import io.github.icommapi.bizgo.models.MmsMessage;
import io.github.icommapi.bizgo.models.NaverTalkGift;
import io.github.icommapi.bizgo.models.NaverTalkMessage;
import io.github.icommapi.bizgo.models.RcsMessage;
import io.github.icommapi.bizgo.models.SendOmniRequest;
import io.github.icommapi.bizgo.models.SmsMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ModelsTest {

    private static final String PHONE = TestSupport.PHONE;

    @Test
    void requiredFieldsAreReportedTogether() {
        ValidationException e = assertThrows(ValidationException.class, () -> SmsMessage.builder().build());
        assertEquals(List.of("SmsMessage.from", "SmsMessage.text"),
                e.getViolations().stream().map(ValidationException.Violation::field).toList());
    }

    @Test
    void maxLengthCountsCodePoints() {
        AlimtalkMessage.builder().senderKey("S").templateCode("T").msgType("AT").text("x").title("가".repeat(50)).build();
        assertThrows(ValidationException.class,
                () -> AlimtalkMessage.builder().senderKey("S").templateCode("T").msgType("AT").text("x").title("가".repeat(51)).build());
        // an international message is limited by characters, not bytes; a supplementary character counts once
        InternationalMessage.builder().from(PHONE).text("😀".repeat(1000)).build();
    }

    @Test
    void enumValuesAreChecked() {
        ValidationException e = assertThrows(ValidationException.class,
                () -> AlimtalkMessage.builder().senderKey("S").templateCode("T").msgType("XX").build());
        assertTrue(e.getMessage().contains("허용 값(AT, AI)"), e.getMessage());
        assertThrows(ValidationException.class,
                () -> BrandMessage.builder().sendType("other").senderKey("S").build());
        assertThrows(ValidationException.class, () -> RcsMessage.builder().from(PHONE).formatId("F").brandKey("B")
                .body(io.github.icommapi.bizgo.models.RcsBody.builder().build()).expiryOption("9").build());
    }

    @Test
    void patternsAreChecked() {
        assertThrows(ValidationException.class, () -> SmsMessage.builder().from(PHONE).text("x").ttl("1h").build());
        SmsMessage.builder().from(PHONE).text("x").ttl("3600").build();
        assertThrows(ValidationException.class,
                () -> NaverTalkGift.builder().code("C").imageUrl("u").endDate("2026/12/31").build());
    }

    @Test
    void itemCountsAndRangesAreChecked() {
        assertThrows(ValidationException.class, () -> MmsMessage.builder().from(PHONE).text("x").fileKey(List.of())
                .build());
        assertThrows(ValidationException.class, () -> MmsMessage.builder().from(PHONE).text("x")
                .fileKey("A", "B", "C", "D").build());
        AlimtalkItemListEntry entry = AlimtalkItemListEntry.builder().title("t").description("d").build();
        assertThrows(ValidationException.class, () -> AlimtalkItem.builder().list(entry).build()); // min 2
        assertThrows(ValidationException.class, () -> BrandMessageCommerce.builder().title("t")
                .regularPrice(100_000_000).build());
        BrandMessageCommerce.builder().title("t").regularPrice(0).build();
        List<Destination> nulls = new ArrayList<>();
        nulls.add(null);
        assertThrows(ValidationException.class, () -> SendOmniRequest.builder().destinations(nulls)
                .messageFlow(MessageFlowItem.of(SmsMessage.builder().from(PHONE).text("x").build())).build());
        Map<String, String> words = new HashMap<>();
        words.put("name", null);
        assertThrows(ValidationException.class, () -> Destination.builder().to(PHONE).replaceWords(words).build());
        assertThrows(ValidationException.class, () -> SendOmniRequest.fromJson("{\"destinations\":[{\"to\":\"1\"}],"
                + "\"messageFlow\":[{\"sms\":{\"from\":\"1\",\"text\":\"x\"}}],\"idempotencyTtl\":86401}"));
        assertThrows(ValidationException.class, () -> SendOmniRequest.fromJson("{\"destinations\":[{\"to\":\"1\"}],"
                + "\"messageFlow\":[{\"sms\":{\"from\":\"1\",\"text\":\"x\"}}],\"idempotencyTtl\":1.5}"));
    }

    @Test
    void modelsAreImmutable() {
        List<String> keys = new ArrayList<>(Arrays.asList("A", "B"));
        MmsMessage mms = MmsMessage.builder().from(PHONE).text("x").fileKey(keys).build();
        keys.add("C");
        assertEquals(List.of("A", "B"), mms.getFileKey());
        assertThrows(UnsupportedOperationException.class, () -> mms.getFileKey().add("D"));
        MmsMessage copy = mms.toBuilder().title("t").build();
        assertNotEquals(mms, copy);
        assertEquals(mms, copy.toBuilder().title(null).build());
    }

    @Test
    void flowItemsWrapEveryChannel() {
        List<ChannelMessage> messages = List.of(
                SmsMessage.builder().from(PHONE).text("x").build(),
                MmsMessage.builder().from(PHONE).text("x").build(),
                InternationalMessage.builder().from(PHONE).text("x").build(),
                RcsMessage.builder().from(PHONE).formatId("F").brandKey("B")
                        .body(io.github.icommapi.bizgo.models.RcsBody.builder().build()).build(),
                AlimtalkMessage.builder().senderKey("S").templateCode("T").msgType("AT").text("x").build(),
                BrandMessage.builder().sendType("free").senderKey("S").msgType("FT").build(),
                NaverTalkMessage.builder().partnerKey("P").templateCode("T").productCode("INFORMATION").build());
        List<String> keys = new ArrayList<>();
        for (ChannelMessage message : messages) {
            MessageFlowItem item = MessageFlowItem.of(message);
            assertEquals(message, item.getMessage());
            keys.add(message.channelKey());
        }
        assertEquals(List.of("sms", "mms", "international", "rcs", "alimtalk", "brandmessage", "navertalk"), keys);
        assertThrows(ValidationException.class, () -> MessageFlowItem.of(null));
        assertThrows(ValidationException.class, () -> MessageFlowItem.builder().build());
    }

    @Test
    void messageBytes() {
        assertEquals(34, MessageBytes.euckr("[비즈고] 인증번호는 123456 입니다."));
        assertEquals(90, MessageBytes.euckr("가".repeat(45)));
        ValidationException e = assertThrows(ValidationException.class, () -> MessageBytes.euckr("안녕😀"));
        assertTrue(e.getMessage().contains("3번째 글자"), e.getMessage());
        assertFalse(e.getMessage().contains("😀"));
    }

    @Test
    void nonEuckrCharactersInSmsAreRejected() {
        ValidationException e = assertThrows(ValidationException.class,
                () -> SmsMessage.builder().from(PHONE).text("\uD800").build()); // lone surrogate
        assertTrue(e.getMessage().contains("EUC-KR"));
    }

    @Test
    void requestJsonHasOnlySetFields() {
        SendOmniRequest request = SendOmniRequest.builder()
                .destinations(Destination.builder().to(PHONE).build())
                .messageFlow(MessageFlowItem.of(
                        AlimtalkMessage.builder().senderKey("S").templateCode("T").msgType("AT").text("x").build()))
                .build();
        assertEquals("{\"destinations\":[{\"to\":\"01000000000\"}],\"messageFlow\":[{\"alimtalk\":"
                + "{\"msgType\":\"AT\",\"senderKey\":\"S\",\"templateCode\":\"T\",\"text\":\"x\"}}]}", request.toJson());
    }

    @Test
    void versionMatchesTheBuild() {
        assertEquals(System.getProperty("bizgo.version"), Bizgo.VERSION);
        assertTrue(Transport.USER_AGENT.startsWith("bizgo-sdk-comm-java/" + Bizgo.VERSION + " java/"));
    }
}
