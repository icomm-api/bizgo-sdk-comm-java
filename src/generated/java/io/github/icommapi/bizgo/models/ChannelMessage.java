// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

/**
 * A channel message you can put in {@code client.send().omni(to, messages...)}.
 *
 * <table>
 * <caption>Channels</caption>
 * <tr><th>messageFlow key</th><th>class</th></tr>
 * <tr><td>{@code sms}</td><td>{@link SmsMessage}</td></tr>
 * <tr><td>{@code mms}</td><td>{@link MmsMessage}</td></tr>
 * <tr><td>{@code international}</td><td>{@link InternationalMessage}</td></tr>
 * <tr><td>{@code rcs}</td><td>{@link RcsMessage}</td></tr>
 * <tr><td>{@code alimtalk}</td><td>{@link AlimtalkMessage}</td></tr>
 * <tr><td>{@code brandmessage}</td><td>{@link BrandMessage}</td></tr>
 * <tr><td>{@code navertalk}</td><td>{@link NaverTalkMessage}</td></tr>
 * </table>
 */
public sealed interface ChannelMessage permits SmsMessage, MmsMessage, InternationalMessage, RcsMessage, AlimtalkMessage, BrandMessage, NaverTalkMessage {

    /**
     * The {@code messageFlow} channel key, for example {@code sms} or {@code alimtalk}.
     *
     * @return channel key
     */
    String channelKey();
}
