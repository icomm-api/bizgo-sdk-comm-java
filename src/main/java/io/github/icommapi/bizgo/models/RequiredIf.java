package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.icommapi.bizgo.internal.Json;
import java.util.List;
import java.util.Map;

/**
 * Checks the spec's {@code x-sdk-required-if} rules (conditionally required fields, SDK-DESIGN §4). The rules come from
 * the generated table {@link GeneratedRequiredIf}; nothing here knows a schema.
 *
 * <p>Two entry points, both called from generated {@code build()} methods:
 * <ul>
 * <li>{@link #checkObject}: rules whose fields and paths are relative to the object itself (every model with rules).</li>
 * <li>{@link #checkRequest}: rules with {@code $.} paths, evaluated against the whole request body (the request
 * models that contain such an object, for example {@code SendOmniRequest} for {@code destinations[].replaceWords}).</li>
 * </ul>
 *
 * <p>Messages name field paths, indexes and the spec condition only, never input values.
 */
final class RequiredIf {

    /**
     * One rule.
     *
     * @param field property of the object the rule belongs to
     * @param op {@code equals}, {@code notEquals}, {@code in} or {@code notIn}
     * @param values comparison values (one for equals/notEquals)
     * @param required own properties that must be present
     * @param paths paths that must be present ({@code $.} = from the request root, otherwise relative)
     */
    record Rule(String field, String op, List<String> values, List<String> required, List<String> paths) {

        boolean applies(JsonNode object) {
            JsonNode value = object.get(field);
            boolean present = value != null && !value.isNull();
            boolean member = present && values.contains(value.isValueNode() ? value.asText() : value.toString());
            switch (op) {
                case "equals":
                case "in":
                    return member;
                case "notEquals":
                case "notIn":
                    return !member;
                default:
                    throw new IllegalStateException("unknown x-sdk-required-if operator");
            }
        }

        String condition() {
            switch (op) {
                case "equals":
                    return field + " == " + values.get(0);
                case "notEquals":
                    return field + " != " + values.get(0);
                case "in":
                    return field + " in (" + String.join(", ", values) + ")";
                default:
                    return field + " not in (" + String.join(", ", values) + ")";
            }
        }
    }

    private RequiredIf() {
    }

    /** Checks the rules of {@code type} that do not need the request root. */
    static void checkObject(ModelValidator v, String type, Object built) {
        List<Rule> rules = GeneratedRequiredIf.RULES.getOrDefault(type, List.of());
        if (rules.isEmpty()) {
            return;
        }
        JsonNode node = Json.requestTree(built);
        for (Rule rule : rules) {
            if (!rule.applies(node)) {
                continue;
            }
            String reason = rule.condition() + "이면 필수입니다";
            for (String name : rule.required()) {
                if (!present(node.get(name))) {
                    v.violation(name, reason);
                }
            }
            for (String path : rule.paths()) {
                if (!path.startsWith("$.")) {
                    missing(node, path.split("\\."), 0, "", v, reason);
                }
            }
        }
    }

    /** Checks the {@code $.} rules of every object in the request {@code type} against the whole body. */
    static void checkRequest(ModelValidator v, String type, Object built) {
        JsonNode root = Json.requestTree(built);
        walk(root, type, "", root, type, v);
    }

    private static void walk(JsonNode node, String type, String at, JsonNode root, String rootType, ModelValidator v) {
        if (node == null || !node.isObject()) {
            return;
        }
        for (Rule rule : GeneratedRequiredIf.RULES.getOrDefault(type, List.of())) {
            if (rule.paths().stream().noneMatch(p -> p.startsWith("$.")) || !rule.applies(node)) {
                continue;
            }
            String reason = (at.isEmpty() ? "" : at + ".") + rule.condition() + "이면 필수입니다";
            for (String path : rule.paths()) {
                if (!path.startsWith("$.")) {
                    continue;
                }
                String[] parts = path.substring(2).split("\\.");
                String first = parts[0].endsWith("[]") ? parts[0].substring(0, parts[0].length() - 2) : parts[0];
                if (!GeneratedRequiredIf.PROPERTIES.getOrDefault(rootType, List.of()).contains(first)) {
                    continue; // the request body has no such field (for example the add-recipients API)
                }
                missing(root, parts, 0, "", v, reason);
            }
        }
        for (Map.Entry<String, String> child : GeneratedRequiredIf.CHILDREN.getOrDefault(type, Map.of()).entrySet()) {
            String name = child.getKey();
            String childType = child.getValue();
            JsonNode value = node.get(name);
            String path = at.isEmpty() ? name : at + "." + name;
            if (value != null && value.isArray()) {
                for (int i = 0; i < value.size(); i++) {
                    walk(value.get(i), childType, path + "[" + i + "]", root, rootType, v);
                }
            } else {
                walk(value, childType, path, root, rootType, v);
            }
        }
    }

    /** Reports every place where {@code parts[index..]} is missing below {@code node}. */
    private static void missing(JsonNode node, String[] parts, int index, String at, ModelValidator v, String reason) {
        String part = parts[index];
        boolean each = part.endsWith("[]");
        String name = each ? part.substring(0, part.length() - 2) : part;
        String path = at.isEmpty() ? name : at + "." + name;
        JsonNode value = node == null || !node.isObject() ? null : node.get(name);
        boolean last = index == parts.length - 1;
        if (!present(value)) {
            if (!each) { // a missing intermediate object: the whole path is missing
                StringBuilder full = new StringBuilder(path);
                for (int i = index + 1; i < parts.length && !parts[i - 1].endsWith("[]"); i++) {
                    full.append('.').append(parts[i].endsWith("[]") ? parts[i].substring(0, parts[i].length() - 2)
                            : parts[i]);
                }
                v.violation(full.toString(), reason);
            }
            return; // a missing array has no elements to check (the array itself is a separate rule)
        }
        if (each) {
            if (!value.isArray()) {
                return;
            }
            for (int i = 0; i < value.size(); i++) {
                JsonNode element = value.get(i);
                if (last) {
                    if (!present(element)) {
                        v.violation(path + "[" + i + "]", reason);
                    }
                } else {
                    missing(element, parts, index + 1, path + "[" + i + "]", v, reason);
                }
            }
        } else if (!last) {
            missing(value, parts, index + 1, path, v, reason);
        }
    }

    private static boolean present(JsonNode value) {
        return value != null && !value.isNull();
    }
}
