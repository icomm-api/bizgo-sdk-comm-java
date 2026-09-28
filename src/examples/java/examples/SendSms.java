package examples;

import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.Environment;
import io.github.icommapi.bizgo.SendOptions;
import io.github.icommapi.bizgo.models.SendDestinationResult;
import io.github.icommapi.bizgo.models.SendResult;

/** Sends an SMS and checks the per-recipient acceptance result. */
public final class SendSms {

    private SendSms() {
    }

    public static SendResult run(Bizgo client, String from, String to) {
        SendResult result = client.send().sms(to, from, "[비즈고] 인증번호는 123456 입니다.",
                SendOptions.builder().ref("signup-otp").build());

        for (SendDestinationResult rejected : result.getFailed()) { // accepted != delivered
            System.out.println("접수 실패: " + rejected.getCode() + " " + rejected.getResult());
        }
        System.out.println("접수된 메시지 키: " + result.getMsgKeys()); // the final result comes later as a report
        return result;
    }

    public static void main(String[] args) {
        try (Bizgo client = Bizgo.builder().environment(Environment.SANDBOX).build()) { // key from BIZGO_API_KEY
            run(client, Env.get("BIZGO_FROM"), Env.get("BIZGO_TO"));
        }
    }
}
