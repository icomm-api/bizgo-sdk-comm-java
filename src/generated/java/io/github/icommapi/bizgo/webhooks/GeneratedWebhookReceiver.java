// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.webhooks;

import io.github.icommapi.bizgo.models.CounselCertResultWebhookPayload;
import io.github.icommapi.bizgo.models.CounselExpiredSessionWebhookPayload;
import io.github.icommapi.bizgo.models.CounselMessageWebhookPayload;
import io.github.icommapi.bizgo.models.CounselPersonalInfoWebhookPayload;
import io.github.icommapi.bizgo.models.CounselReferenceWebhookPayload;
import io.github.icommapi.bizgo.models.CounselResultWebhookPayload;
import io.github.icommapi.bizgo.models.CounselSeenInfoWebhookPayload;
import java.util.Map;

/**
 * Webhook parsers generated from the spec ({@code x-sdk-webhook}). {@link WebhookReceiver} extends this class
 * and adds the hand-written ones ({@code report}, {@code mo}).
 */
public abstract class GeneratedWebhookReceiver {

    GeneratedWebhookReceiver() {
    }

    /** Verifies the signature headers; they must be present. */
    abstract void verifySigned(Map<String, ?> headers);

    /**
     * 상담톡 사용자 메시지 수신(Webhook).
     *
     * <p>This webhook carries no signature (signatures apply only to the report and MO webhooks),
     * so the headers are not checked and signature headers, if present, are ignored. The body
     * checks (size limit, nesting depth, types) still apply. No webhook secret is needed: see
     * {@link #parseCounselMessage(byte[])}.
     *
     * <p>{@code POST} to your webhook URL (operationId {@code onCounselMessageWebhook}). Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param headers request headers (names are case-insensitive); not used
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public CounselMessageWebhookPayload counselMessage(Map<String, ?> headers, byte[] body) {
        return parseCounselMessage(body);
    }

    /**
     * 상담톡 사용자 메시지 수신(Webhook).
     *
     * <p>Parses the body without a receiver or webhook secret, for example
     * {@code WebhookReceiver.parseCounselMessage(rawBody)}. Same checks as
     * {@link #counselMessage(Map, byte[])}. Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public static CounselMessageWebhookPayload parseCounselMessage(byte[] body) {
        return Webhooks.parse(body, CounselMessageWebhookPayload.class);
    }

    /**
     * 상담톡 사용자 메타 정보 수신(Webhook).
     *
     * <p>This webhook carries no signature (signatures apply only to the report and MO webhooks),
     * so the headers are not checked and signature headers, if present, are ignored. The body
     * checks (size limit, nesting depth, types) still apply. No webhook secret is needed: see
     * {@link #parseCounselReference(byte[])}.
     *
     * <p>{@code POST} to your webhook URL (operationId {@code onCounselReferenceWebhook}). Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param headers request headers (names are case-insensitive); not used
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public CounselReferenceWebhookPayload counselReference(Map<String, ?> headers, byte[] body) {
        return parseCounselReference(body);
    }

    /**
     * 상담톡 사용자 메타 정보 수신(Webhook).
     *
     * <p>Parses the body without a receiver or webhook secret, for example
     * {@code WebhookReceiver.parseCounselReference(rawBody)}. Same checks as
     * {@link #counselReference(Map, byte[])}. Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public static CounselReferenceWebhookPayload parseCounselReference(byte[] body) {
        return Webhooks.parse(body, CounselReferenceWebhookPayload.class);
    }

    /**
     * 상담톡 세션 종료 수신(Webhook).
     *
     * <p>This webhook carries no signature (signatures apply only to the report and MO webhooks),
     * so the headers are not checked and signature headers, if present, are ignored. The body
     * checks (size limit, nesting depth, types) still apply. No webhook secret is needed: see
     * {@link #parseCounselExpiredSession(byte[])}.
     *
     * <p>{@code POST} to your webhook URL (operationId {@code onCounselExpiredSessionWebhook}). Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param headers request headers (names are case-insensitive); not used
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public CounselExpiredSessionWebhookPayload counselExpiredSession(Map<String, ?> headers, byte[] body) {
        return parseCounselExpiredSession(body);
    }

    /**
     * 상담톡 세션 종료 수신(Webhook).
     *
     * <p>Parses the body without a receiver or webhook secret, for example
     * {@code WebhookReceiver.parseCounselExpiredSession(rawBody)}. Same checks as
     * {@link #counselExpiredSession(Map, byte[])}. Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public static CounselExpiredSessionWebhookPayload parseCounselExpiredSession(byte[] body) {
        return Webhooks.parse(body, CounselExpiredSessionWebhookPayload.class);
    }

    /**
     * 상담톡 읽음 정보 수신(Webhook).
     *
     * <p>This webhook carries no signature (signatures apply only to the report and MO webhooks),
     * so the headers are not checked and signature headers, if present, are ignored. The body
     * checks (size limit, nesting depth, types) still apply. No webhook secret is needed: see
     * {@link #parseCounselSeenInfo(byte[])}.
     *
     * <p>{@code POST} to your webhook URL (operationId {@code onCounselSeenInfoWebhook}). Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param headers request headers (names are case-insensitive); not used
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public CounselSeenInfoWebhookPayload counselSeenInfo(Map<String, ?> headers, byte[] body) {
        return parseCounselSeenInfo(body);
    }

    /**
     * 상담톡 읽음 정보 수신(Webhook).
     *
     * <p>Parses the body without a receiver or webhook secret, for example
     * {@code WebhookReceiver.parseCounselSeenInfo(rawBody)}. Same checks as
     * {@link #counselSeenInfo(Map, byte[])}. Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public static CounselSeenInfoWebhookPayload parseCounselSeenInfo(byte[] body) {
        return Webhooks.parse(body, CounselSeenInfoWebhookPayload.class);
    }

    /**
     * 상담톡 개인정보 수신(Webhook).
     *
     * <p>This webhook carries no signature (signatures apply only to the report and MO webhooks),
     * so the headers are not checked and signature headers, if present, are ignored. The body
     * checks (size limit, nesting depth, types) still apply. No webhook secret is needed: see
     * {@link #parseCounselPersonalInfo(byte[])}.
     *
     * <p>{@code POST} to your webhook URL (operationId {@code onCounselPersonalInfoWebhook}). Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param headers request headers (names are case-insensitive); not used
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public CounselPersonalInfoWebhookPayload counselPersonalInfo(Map<String, ?> headers, byte[] body) {
        return parseCounselPersonalInfo(body);
    }

    /**
     * 상담톡 개인정보 수신(Webhook).
     *
     * <p>Parses the body without a receiver or webhook secret, for example
     * {@code WebhookReceiver.parseCounselPersonalInfo(rawBody)}. Same checks as
     * {@link #counselPersonalInfo(Map, byte[])}. Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public static CounselPersonalInfoWebhookPayload parseCounselPersonalInfo(byte[] body) {
        return Webhooks.parse(body, CounselPersonalInfoWebhookPayload.class);
    }

    /**
     * 상담톡 본인인증 결과 수신(Webhook).
     *
     * <p>This webhook carries no signature (signatures apply only to the report and MO webhooks),
     * so the headers are not checked and signature headers, if present, are ignored. The body
     * checks (size limit, nesting depth, types) still apply. No webhook secret is needed: see
     * {@link #parseCounselCertResult(byte[])}.
     *
     * <p>{@code POST} to your webhook URL (operationId {@code onCounselCertResultWebhook}). Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param headers request headers (names are case-insensitive); not used
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public CounselCertResultWebhookPayload counselCertResult(Map<String, ?> headers, byte[] body) {
        return parseCounselCertResult(body);
    }

    /**
     * 상담톡 본인인증 결과 수신(Webhook).
     *
     * <p>Parses the body without a receiver or webhook secret, for example
     * {@code WebhookReceiver.parseCounselCertResult(rawBody)}. Same checks as
     * {@link #counselCertResult(Map, byte[])}. Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public static CounselCertResultWebhookPayload parseCounselCertResult(byte[] body) {
        return Webhooks.parse(body, CounselCertResultWebhookPayload.class);
    }

    /**
     * 상담톡 발송 결과 수신(Webhook).
     *
     * <p>This webhook carries no signature (signatures apply only to the report and MO webhooks),
     * so the headers are not checked and signature headers, if present, are ignored. The body
     * checks (size limit, nesting depth, types) still apply. No webhook secret is needed: see
     * {@link #parseCounselResult(byte[])}.
     *
     * <p>{@code POST} to your webhook URL (operationId {@code onCounselResultWebhook}). Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param headers request headers (names are case-insensitive); not used
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public CounselResultWebhookPayload counselResult(Map<String, ?> headers, byte[] body) {
        return parseCounselResult(body);
    }

    /**
     * 상담톡 발송 결과 수신(Webhook).
     *
     * <p>Parses the body without a receiver or webhook secret, for example
     * {@code WebhookReceiver.parseCounselResult(rawBody)}. Same checks as
     * {@link #counselResult(Map, byte[])}. Answer with {@link Webhooks#counselAckJson()}.
     *
     * @param body raw request body
     * @return the payload
     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails
     */
    public static CounselResultWebhookPayload parseCounselResult(byte[] body) {
        return Webhooks.parse(body, CounselResultWebhookPayload.class);
    }
}
