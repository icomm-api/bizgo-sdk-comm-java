// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import java.util.List;
import java.util.Map;

/**
 * The spec's {@code x-sdk-required-if} rules as data, read by {@link RequiredIf}.
 */
final class GeneratedRequiredIf {

    /** Schema name to its rules (all apply). */
    static final Map<String, List<RequiredIf.Rule>> RULES = Map.ofEntries(
            Map.entry("AlimtalkMessage", List.of(
                    new RequiredIf.Rule("sendType", "notEquals", List.of("template"),
                            List.of("msgType", "text"), List.of()),
                    new RequiredIf.Rule("sendType", "equals", List.of("template"),
                            List.of(), List.of("$.destinations[].replaceWords")))),
            Map.entry("BrandMessage", List.of(
                    new RequiredIf.Rule("sendType", "in", List.of("basic", "free"),
                            List.of("msgType"), List.of()),
                    new RequiredIf.Rule("sendType", "in", List.of("basic", "template"),
                            List.of("templateCode", "targeting"), List.of()),
                    new RequiredIf.Rule("sendType", "equals", List.of("template"),
                            List.of(), List.of("$.destinations[].replaceWords")))),
            Map.entry("BrandMessageButton", List.of(
                    new RequiredIf.Rule("type", "equals", List.of("WL"),
                            List.of("urlPc", "urlMobile"), List.of()),
                    new RequiredIf.Rule("type", "equals", List.of("AL"),
                            List.of("urlMobile"), List.of()))),
            Map.entry("CounselPlainMessageRequest", List.of(
                    new RequiredIf.Rule("msgType", "equals", List.of("FILE"),
                            List.of(), List.of("attachment.file.fileName", "attachment.file.fileSize")))),
            Map.entry("CounselRichMessageRequest", List.of(
                    new RequiredIf.Rule("msgType", "in", List.of("IMAGE", "WIDE"),
                            List.of(), List.of("attachment.image")),
                    new RequiredIf.Rule("msgType", "in", List.of("ITEM_LIST", "WIDE_ITEM_LIST"),
                            List.of(), List.of("attachment.item")),
                    new RequiredIf.Rule("msgType", "equals", List.of("CAROUSEL_FEED"),
                            List.of("carousel"), List.of()),
                    new RequiredIf.Rule("msgType", "equals", List.of("KAKAO_CERT"),
                            List.of("certExpiry"), List.of()))),
            Map.entry("RcsMessage", List.of(
                    new RequiredIf.Rule("header", "equals", List.of("1"),
                            List.of("footer"), List.of()))));

    /** Request objects on the way to an object with {@code $.} rules: property to child schema. */
    static final Map<String, Map<String, String>> CHILDREN = Map.ofEntries(
            Map.entry("AlimtalkMessage", Map.of()),
            Map.entry("BrandMessage", Map.of()),
            Map.entry("MessageFlowItem", Map.of("alimtalk", "AlimtalkMessage", "brandmessage", "BrandMessage")),
            Map.entry("ReservationCreateRequest", Map.of("messageFlow", "ReservationMessageFlowItem")),
            Map.entry("ReservationMessageFlowItem", Map.of("alimtalk", "AlimtalkMessage", "brandmessage", "BrandMessage")),
            Map.entry("SendOmniRequest", Map.of("messageFlow", "MessageFlowItem")));

    /** Properties of the request bodies checked with {@code checkRequest}: a {@code $.} path whose first
     * property the body does not have is skipped. */
    static final Map<String, List<String>> PROPERTIES = Map.ofEntries(
            Map.entry("ReservationCreateRequest", List.of("destinations", "messageFlow", "resvSendTime", "resvName", "paymentCode", "ref")),
            Map.entry("SendOmniRequest", List.of("destinations", "messageFlow", "paymentCode", "groupKey", "idempotencyKey", "idempotencyTtl", "ref")));

    private GeneratedRequiredIf() {
    }
}
