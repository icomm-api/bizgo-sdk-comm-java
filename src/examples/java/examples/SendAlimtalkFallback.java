package examples;

import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.Environment;
import io.github.icommapi.bizgo.SendOptions;
import io.github.icommapi.bizgo.errors.DuplicateRequestException;
import io.github.icommapi.bizgo.models.AlimtalkMessage;
import io.github.icommapi.bizgo.models.Destination;
import io.github.icommapi.bizgo.models.SendResult;
import io.github.icommapi.bizgo.models.SmsMessage;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/** Sends a Kakao AlimTalk message; if it fails, Bizgo sends the SMS instead (fallback). */
public final class SendAlimtalkFallback {

    private SendAlimtalkFallback() {
    }

    public static SendResult run(Bizgo client, String from, String to, String senderKey, String templateCode) {
        String orderId = "20260923-0001";
        String text = "#{name}님, 주문(#{order})이 접수되었습니다."; // must match the approved template
        try {
            SendResult result = client.send().omni(
                    List.of(Destination.builder().to(to).replaceWords(Map.of("name", "홍길동", "order", orderId)).build()),
                    List.of(
                            AlimtalkMessage.builder().senderKey(senderKey).templateCode(templateCode).msgType("AT")
                                    .text(text).build(),
                            SmsMessage.builder().from(from).text(text).build()),
                    SendOptions.builder()
                            // same key => Bizgo rejects a second send, so retries after a timeout are safe
                            .idempotencyKey("order-" + orderId + "-"
                                    + UUID.nameUUIDFromBytes(to.getBytes(StandardCharsets.UTF_8)))
                            .ref(orderId)
                            .build());
            System.out.println("접수: " + result.getMsgKeys() + " 실패: " + result.getFailed().size());
            return result;
        } catch (DuplicateRequestException e) {
            System.out.println("이미 발송된 주문입니다.");
            return null;
        }
    }

    public static void main(String[] args) {
        try (Bizgo client = Bizgo.builder().environment(Environment.SANDBOX).build()) {
            run(client, Env.get("BIZGO_FROM"), Env.get("BIZGO_TO"), Env.get("BIZGO_KAKAO_SENDER_KEY"),
                    Env.get("BIZGO_KAKAO_TEMPLATE_CODE"));
        }
    }
}
