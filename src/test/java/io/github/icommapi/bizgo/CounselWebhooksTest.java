package io.github.icommapi.bizgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.github.icommapi.bizgo.errors.ConfigurationException;
import io.github.icommapi.bizgo.errors.WebhookVerificationException;
import io.github.icommapi.bizgo.internal.Json;
import io.github.icommapi.bizgo.models.CounselMessageWebhookPayload;
import io.github.icommapi.bizgo.models.CounselResultWebhookPayload;
import io.github.icommapi.bizgo.testing.WebhookSigner;
import io.github.icommapi.bizgo.webhooks.WebhookReceiver;
import io.github.icommapi.bizgo.webhooks.Webhooks;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CounselWebhooksTest {

    private static final String SECRET = "test-webhook-secret-not-real";
    private static final String MESSAGE = "{\"msgKey\":\"CS_KEY_001\",\"userKey\":\"USER_KEY_EXAMPLE\","
            + "\"senderKey\":\"SENDER_KEY_EXAMPLE\",\"newField\":1}";

    private final WebhookReceiver receiver = new WebhookReceiver(SECRET);

    @Test
    void counselWebhookWithoutSignatureHeadersIsParsed() {
        WebhookSigner.SignedWebhook hook = WebhookSigner.unsigned(MESSAGE);
        CounselMessageWebhookPayload payload = receiver.counselMessage(hook.headers(), hook.body());
        assertEquals("CS_KEY_001", payload.getMsgKey());
        assertEquals(1, payload.getAdditionalProperties().get("newField"));
        CounselResultWebhookPayload result = receiver.counselResult(Map.of(), hook.body());
        assertEquals("CS_KEY_001", result.getMsgKey());
        assertEquals("CS_KEY_001", receiver.counselSeenInfo(null, hook.body()).getMsgKey());
    }

    @Test
    void signatureHeadersOnCounselWebhooksAreIgnored() {
        Map<String, String> bogus = new HashMap<>();
        bogus.put("Content-Type", "application/json");
        bogus.put("X-IB-Timestamp", "not-a-timestamp");
        bogus.put("X-IB-Signature", "bogus");
        byte[] body = MESSAGE.getBytes(StandardCharsets.UTF_8);
        assertEquals("CS_KEY_001", receiver.counselMessage(bogus, body).getMsgKey());
        WebhookSigner.SignedWebhook otherSecret = WebhookSigner.sign("another-secret", MESSAGE);
        assertEquals("CS_KEY_001", receiver.counselReference(otherSecret.headers(), otherSecret.body()).getMsgKey());
    }

    @Test
    void counselParsingNeedsNoSecret() {
        byte[] body = MESSAGE.getBytes(StandardCharsets.UTF_8);
        assertEquals("CS_KEY_001", WebhookReceiver.parseCounselMessage(body).getMsgKey());
        WebhookReceiver.parseCounselReference(body);
        WebhookReceiver.parseCounselExpiredSession(body);
        WebhookReceiver.parseCounselSeenInfo(body);
        WebhookReceiver.parseCounselPersonalInfo(body);
        WebhookReceiver.parseCounselCertResult(body);
        assertEquals("CS_KEY_001", WebhookReceiver.parseCounselResult(body).getMsgKey());
        // a receiver (for report / MO) still needs its secret
        assertThrows(ConfigurationException.class, () -> WebhookReceiver.builder().build());
        assertThrows(ConfigurationException.class, () -> new WebhookReceiver(" "));
    }

    @Test
    void counselBodyChecksStillApply() {
        Map<String, String> h = Map.of("Content-Type", "application/json");
        byte[] tooLarge = new byte[Webhooks.MAX_BODY_BYTES + 1];
        Arrays.fill(tooLarge, (byte) ' ');
        assertThrows(WebhookVerificationException.class, () -> receiver.counselMessage(h, tooLarge));
        assertThrows(WebhookVerificationException.class, () -> WebhookReceiver.parseCounselMessage(tooLarge));

        String deep = "{\"a\":" + "[".repeat(Json.MAX_DEPTH + 1) + "]".repeat(Json.MAX_DEPTH + 1) + "}";
        byte[] deepBody = deep.getBytes(StandardCharsets.UTF_8);
        assertThrows(WebhookVerificationException.class, () -> receiver.counselMessage(h, deepBody));

        byte[] wrongType = "{\"msgKey\":{\"nested\":true}}".getBytes(StandardCharsets.UTF_8);
        assertThrows(WebhookVerificationException.class, () -> receiver.counselMessage(h, wrongType));
        byte[] notObject = "[1,2]".getBytes(StandardCharsets.UTF_8);
        assertThrows(WebhookVerificationException.class, () -> WebhookReceiver.parseCounselResult(notObject));
        assertThrows(WebhookVerificationException.class, () -> receiver.counselResult(h, null));
    }

    @Test
    void reportAndMoWebhooksAlwaysRequireASignature() {
        WebhookSigner.SignedWebhook unsigned = WebhookSigner.unsigned("{\"msgKey\":\"K001\"}");
        assertThrows(WebhookVerificationException.class, () -> receiver.report(unsigned.headers(), unsigned.body()));
        assertThrows(WebhookVerificationException.class, () -> receiver.mo(unsigned.headers(), unsigned.body()));
        WebhookSigner.SignedWebhook wrong = WebhookSigner.sign("another-secret", "{\"msgKey\":\"K001\"}");
        assertThrows(WebhookVerificationException.class, () -> receiver.report(wrong.headers(), wrong.body()));
        WebhookSigner.SignedWebhook signed = WebhookSigner.sign(SECRET, "{\"msgKey\":\"K001\"}");
        assertEquals("K001", receiver.report(signed.headers(), signed.body()).getMsgKey());
        assertEquals("K001", receiver.mo(signed.headers(), signed.body()).getMsgKey());
    }

    @Test
    void everyCounselWebhookHasAParser() {
        WebhookSigner.SignedWebhook hook = WebhookSigner.unsigned(MESSAGE);
        Map<String, String> h = hook.headers();
        byte[] b = hook.body();
        receiver.counselMessage(h, b);
        receiver.counselReference(h, b);
        receiver.counselExpiredSession(h, b);
        receiver.counselSeenInfo(h, b);
        receiver.counselPersonalInfo(h, b);
        receiver.counselCertResult(h, b);
        receiver.counselResult(h, b);
    }

    @Test
    void counselAckMatchesTheSpec() throws Exception {
        assertEquals(Map.of("code", "A000", "result", "Success"), Webhooks.counselAck());
        assertEquals(Json.readTree("{\"code\":\"A000\",\"result\":\"Success\"}"),
                Json.readTree(Webhooks.counselAckJson()));
        assertFalse(receiver.toString().contains(SECRET));
    }
}
