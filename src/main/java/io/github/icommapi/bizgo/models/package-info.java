/**
 * Request and response models, generated from the OpenAPI spec (plus a few result types).
 *
 * <p>Channel messages for {@code client.send().omni(to, messages...)}:
 *
 * <table>
 * <caption>Channel messages</caption>
 * <tr><th>Channel</th><th>Class</th><th>messageFlow key</th></tr>
 * <tr><td>SMS (90 bytes)</td><td>{@link io.github.icommapi.bizgo.models.SmsMessage}</td><td>{@code sms}</td></tr>
 * <tr><td>LMS / MMS (2,000 bytes; MMS if {@code fileKey} is set)</td>
 *     <td>{@link io.github.icommapi.bizgo.models.MmsMessage}</td><td>{@code mms}</td></tr>
 * <tr><td>International</td><td>{@link io.github.icommapi.bizgo.models.InternationalMessage}</td>
 *     <td>{@code international}</td></tr>
 * <tr><td>RCS</td><td>{@link io.github.icommapi.bizgo.models.RcsMessage}</td><td>{@code rcs}</td></tr>
 * <tr><td>Kakao AlimTalk</td><td>{@link io.github.icommapi.bizgo.models.AlimtalkMessage}</td>
 *     <td>{@code alimtalk}</td></tr>
 * <tr><td>Kakao BrandMessage</td><td>{@link io.github.icommapi.bizgo.models.BrandMessage}</td>
 *     <td>{@code brandmessage}</td></tr>
 * <tr><td>Naver TalkTalk</td><td>{@link io.github.icommapi.bizgo.models.NaverTalkMessage}</td>
 *     <td>{@code navertalk}</td></tr>
 * </table>
 *
 * <p>Request models are immutable and validated in {@code build()} (required fields, lengths, byte limits in EUC-KR,
 * allowed values, item counts); invalid input throws
 * {@link io.github.icommapi.bizgo.errors.ValidationException} before anything is sent. Only the fields you set are
 * serialized. Response models keep unknown properties in {@code getAdditionalProperties()}.
 *
 * <p>{@code toString()} masks values that can contain personal data. Do not log request bodies.
 */
package io.github.icommapi.bizgo.models;
