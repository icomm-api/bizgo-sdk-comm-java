/**
 * Java SDK for the Bizgo Communication API.
 *
 * <pre>{@code
 * try (Bizgo client = Bizgo.builder().environment(Environment.SANDBOX).build()) {   // key from BIZGO_API_KEY
 *     // AlimTalk, falling back to SMS if it fails
 *     SendResult result = client.send().omni(
 *             "01000000000",
 *             List.of(
 *                     AlimtalkMessage.builder().senderKey("SENDER_KEY_EXAMPLE").templateCode("TEMPLATE_CODE_EXAMPLE")
 *                             .msgType("AT").text("주문이 접수되었습니다.").build(),
 *                     SmsMessage.builder().from("01000000000").text("주문이 접수되었습니다.").build()),
 *             SendOptions.idempotencyKey("order-1234"));
 * }
 * }</pre>
 *
 * <p>Entry point: {@link io.github.icommapi.bizgo.Bizgo}. Resources: {@code send()}, {@code files()},
 * {@code reports()}, {@code messages()}. Models: {@link io.github.icommapi.bizgo.models}. Errors:
 * {@link io.github.icommapi.bizgo.errors}. Webhooks: {@link io.github.icommapi.bizgo.webhooks}.
 *
 * <p>Logging uses {@link java.lang.System.Logger} named {@code io.github.icommapi.bizgo}. At DEBUG it writes one line
 * per attempt ({@code METHOD path -> status (ms, attempt n)}); it never logs the API key, bodies, query strings or
 * phone numbers.
 */
package io.github.icommapi.bizgo;
