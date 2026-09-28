package io.github.icommapi.bizgo.codegen;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generates the Java model classes and the service error-code table from {@code spec/openapi.yaml} and
 * {@code spec/error-codes.json}.
 *
 * <p>Request models (everything reachable from {@code SendOmniRequest}) are immutable, built with a builder, and
 * validated in {@code build()}. Response models keep unknown JSON properties. The output is deterministic so that
 * {@code checkGeneratedModels} can compare it with the committed sources.
 */
public final class ModelGenerator {

    public static final String MODELS_PACKAGE = "io.github.icommapi.bizgo.models";
    public static final String ERRORS_PACKAGE = "io.github.icommapi.bizgo.errors";
    private static final String FLOW_ITEM = "MessageFlowItem";
    private static final String HEADER =
            "// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.\n"
                    + "// Regenerate with: ./gradlew generateModels\n";

    /** Field names whose values are safe to show in {@code toString()} (codes, keys, timestamps, counters). */
    private static final Set<String> SAFE_TO_PRINT = Set.of(
            "code", "result", "authCode", "authResult", "infobankTrId", "msgKey", "serviceType", "msgType",
            "reportId", "reportType", "reportCode", "reportText", "responseCode", "responseText", "statDate",
            "recvTotalCnt", "recvSuccCnt", "recvFailCnt", "reportTotalCnt", "reportSuccCnt", "reportFailCnt",
            "hasNext", "lastSeq", "fileKey", "expired", "media", "carrier", "fallback", "requestTime", "sendTime",
            "reportTime", "occurredTime", "userType", "resCnt", "sendType", "templateCode", "formatId",
            "responseMethod", "targeting", "expiryOption", "buttonCode", "type");

    /** Phone number fields: {@code toString()} shows {@code 010****0000} (first 3 and last 4 characters). */
    static final Set<String> PHONE_FIELDS = Set.of(
            "to", "from", "phoneNumber", "phone_number", "unsubscribePhoneNumber", "originator", "callback", "callbackNumber",
            "telNumber", "tel", "dialPhoneNumber");

    static final String MASKING = "io.github.icommapi.bizgo.internal.Masking";
    /** Person fields: {@code toString()} keeps the first character only. */
    static final Set<String> PERSON_FIELDS = Set.of("userName", "nickname", "nickName", "email", "realName");

    /** {@code name} is a person's name only in the personal-information payloads (not templates, channels, ...). */
    static boolean isPerson(String owner, String field) {
        return PERSON_FIELDS.contains(field) || (field.equals("name") && owner.contains("Personal"));
    }

    static final Set<String> JAVA_KEYWORDS = Set.of(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if",
            "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null", "var",
            "record", "yield", "sealed", "permits");

    /** Package of the generated query/header parameter classes. */
    public static final String PARAMS_PACKAGE = "io.github.icommapi.bizgo.params";
    static final String INTERNAL_PACKAGE = "io.github.icommapi.bizgo.internal";
    static final String FILE_UPLOAD = "io.github.icommapi.bizgo.FileUpload";
    /** Multipart fields the {@code FileUpload} helper covers; schemas with only these use it instead of a model. */
    static final Set<String> SIMPLE_UPLOAD_FIELDS = Set.of("file", "fileKey", "imageName");

    private final JsonNode spec;
    private final JsonNode schemas;
    private final Map<String, ClassModel> classes = new TreeMap<>();
    /** channel key (sms, mms, ...) -> message class name, in spec order. */
    private final Map<String, String> channels = new LinkedHashMap<>();
    /** flow item schema (MessageFlowItem, ReservationMessageFlowItem) -> its channel keys. */
    private final Map<String, List<String>> flowItems = new TreeMap<>();
    /** JSON request body roots: get fromJson/fromMap/toJson helpers. */
    private final Set<String> jsonRoots = new java.util.TreeSet<>();

    private ModelGenerator(JsonNode spec) {
        this.spec = spec;
        this.schemas = spec.path("components").path("schemas");
    }

    /**
     * Generate all sources.
     *
     * @return relative source path (for example {@code io/github/icommapi/bizgo/models/SmsMessage.java}) to content
     */
    public static Map<String, String> generate(Path spec, Path errorCodes) throws IOException {
        ObjectMapper yaml = new ObjectMapper(new YAMLFactory());
        ModelGenerator generator = new ModelGenerator(yaml.readTree(Files.readString(spec, StandardCharsets.UTF_8)));
        return generate(spec, errorCodes, null);
    }

    /**
     * Generate all sources, including the resource classes.
     *
     * @param handWritten directory of the hand-written sources ({@code src/main/java}); methods declared there win
     *     over generated ones with the same name. Null skips the resource classes (models only).
     * @return relative source path to content
     */
    public static Map<String, String> generate(Path spec, Path errorCodes, Path handWritten) throws IOException {
        ObjectMapper yaml = new ObjectMapper(new YAMLFactory());
        JsonNode root = yaml.readTree(Files.readString(spec, StandardCharsets.UTF_8));
        ModelGenerator generator = new ModelGenerator(root);
        Map<String, String> out = new TreeMap<>();
        generator.collect();
        for (ClassModel model : generator.classes.values()) {
            out.put(path(MODELS_PACKAGE, model.name), generator.render(model));
        }
        for (Map.Entry<String, List<String>> flow : generator.flowItems.entrySet()) {
            out.put(path(MODELS_PACKAGE, flow.getKey()), generator.renderFlowItem(flow.getKey(), flow.getValue()));
        }
        out.put(path(MODELS_PACKAGE, "ChannelMessage"), generator.renderChannelMessage());
        out.put(path(INTERNAL_PACKAGE, "GeneratedRequestModels"), generator.renderRequestModels());
        out.put(path(MODELS_PACKAGE, "GeneratedRequiredIf"), generator.renderRequiredIf());
        JsonNode codes = new ObjectMapper().readTree(Files.readString(errorCodes, StandardCharsets.UTF_8));
        out.put(path(ERRORS_PACKAGE, "ServiceCodes"), renderServiceCodes(codes));
        if (handWritten != null) {
            out.putAll(new ResourceGenerator(root, handWritten).generate());
        }
        return out;
    }

    /** True for multipart schemas that the {@code FileUpload} helper represents (file, fileKey, imageName only). */
    static boolean isSimpleUpload(JsonNode schema) {
        if (!schema.has("properties")) {
            return false;
        }
        java.util.Iterator<String> names = schema.path("properties").fieldNames();
        boolean hasFile = false;
        while (names.hasNext()) {
            String name = names.next();
            if (!SIMPLE_UPLOAD_FIELDS.contains(name)) {
                return false;
            }
            hasFile |= name.equals("file");
        }
        return hasFile;
    }

    private String renderRequestModels() {
        StringBuilder s = new StringBuilder(HEADER);
        s.append("package ").append(INTERNAL_PACKAGE).append(";\n\n");
        s.append("import java.util.List;\n\n");
        s.append("/**\n * Builders of the request models. Internal: {@link Json#RESPONSE} registers a lenient mix-in for them,\n")
                .append(" * so a request model that appears in a response is read without request validation.\n */\n");
        s.append("final class GeneratedRequestModels {\n\n");
        s.append("    static final List<Class<?>> BUILDERS = List.of(");
        List<String> builders = new ArrayList<>();
        for (ClassModel m : classes.values()) {
            if (m.request && !m.multipart) {
                builders.add("\n            " + MODELS_PACKAGE + "." + m.name + ".Builder.class");
            }
        }
        for (String flow : flowItems.keySet()) {
            builders.add("\n            " + MODELS_PACKAGE + "." + flow + ".Builder.class");
        }
        s.append(String.join(",", builders)).append(");\n\n");
        s.append("    private GeneratedRequestModels() {\n    }\n}\n");
        return s.toString();
    }

    private static String path(String pkg, String name) {
        return pkg.replace('.', '/') + "/" + name + ".java";
    }

    // ------------------------------------------------------------------ model collection

    private void collect() {
        JsonNode flow = schemas.path(FLOW_ITEM);
        Map<String, String> wrapperKeys = new LinkedHashMap<>();
        for (JsonNode option : flow.path("oneOf")) {
            JsonNode item = schemas.path(refName(option));
            String key = item.path("required").get(0).asText();
            channels.put(key, refName(item.path("properties").path(key)));
            wrapperKeys.put(refName(option), key);
        }
        Set<String> skip = new LinkedHashSet<>(wrapperKeys.keySet()); // SmsFlowItem etc.: see MessageFlowItem
        for (Map.Entry<String, JsonNode> schemaEntry : schemas.properties()) {
            JsonNode oneOf = schemaEntry.getValue().path("oneOf");
            if (oneOf.isArray() && oneOf.size() > 0) {
                List<String> keys = new ArrayList<>();
                for (JsonNode option : oneOf) {
                    String key = wrapperKeys.get(refName(option));
                    if (key == null) {
                        throw new IllegalStateException("unsupported oneOf in " + schemaEntry.getKey());
                    }
                    keys.add(key);
                }
                flowItems.put(schemaEntry.getKey(), keys);
                skip.add(schemaEntry.getKey());
            }
        }
        Set<String> roots = new LinkedHashSet<>();
        Set<String> multipart = new LinkedHashSet<>();
        spec.path("paths").forEach(item -> item.forEach(op -> op.path("requestBody").path("content").properties()
                .forEach(content -> {
                    String name = refName(content.getValue().path("schema"));
                    if (content.getKey().equals("application/json")) {
                        roots.add(name);
                        jsonRoots.add(name);
                    } else if (!isSimpleUpload(schemas.path(name))) {
                        roots.add(name);
                        multipart.add(name);
                    } else {
                        skip.add(name); // file + fileKey + imageName: FileUpload
                    }
                })));
        Set<String> request = new LinkedHashSet<>();
        roots.forEach(root -> request.addAll(closure(root)));
        for (Map.Entry<String, JsonNode> schemaEntry : schemas.properties()) {
            String name = schemaEntry.getKey();
            if (skip.contains(name)) {
                continue;
            }
            addClass(name, schemas.get(name), request.contains(name));
            classes.get(name).multipart = multipart.contains(name);
        }
        collectRootRuleGraph();
    }

    // ------------------------------------------------------------------ x-sdk-required-if

    private static final List<String> OPERATORS = List.of("equals", "notEquals", "in", "notIn");
    private static final Set<String> RULE_KEYS = Set.of("when", "required", "requiredPaths");

    /** Request classes that are, or contain, an object with {@code $.} rules: {@code checkRequest} walks these. */
    private final Set<String> rootRuleGraph = new java.util.TreeSet<>();

    private static boolean rootPath(String path) {
        return path.startsWith("$.");
    }

    private static List<String> texts(JsonNode node) {
        List<String> out = new ArrayList<>();
        if (node.isArray()) {
            node.forEach(n -> out.add(n.asText()));
        } else if (!node.isMissingNode() && !node.isNull()) {
            out.add(node.asText());
        }
        return out;
    }

    private static String operator(JsonNode when) {
        return OPERATORS.stream().filter(when::has).findFirst().orElseThrow();
    }

    /** Checks the rules of one schema when it is read, so a malformed extension fails the generator. */
    private static void checkRules(ClassModel model) {
        Set<String> names = model.props.stream().map(p -> p.json).collect(Collectors.toSet());
        String where = model.name + " x-sdk-required-if";
        if (!model.requiredIf.isMissingNode() && !model.requiredIf.isArray()) {
            throw new IllegalStateException(where + ": must be a list");
        }
        for (JsonNode rule : model.requiredIf) {
            rule.fieldNames().forEachRemaining(key -> {
                if (!RULE_KEYS.contains(key)) {
                    throw new IllegalStateException(where + ": unknown key " + key);
                }
            });
            JsonNode when = rule.path("when");
            if (!names.contains(when.path("field").asText())) {
                throw new IllegalStateException(where + ": when.field is not a property");
            }
            if (OPERATORS.stream().filter(when::has).count() != 1) {
                throw new IllegalStateException(where + ": exactly one operator is required");
            }
            if (texts(rule.path("required")).isEmpty() && texts(rule.path("requiredPaths")).isEmpty()) {
                throw new IllegalStateException(where + ": required or requiredPaths is required");
            }
            for (String name : texts(rule.path("required"))) {
                if (!names.contains(name)) {
                    throw new IllegalStateException(where + ": required '" + name + "' is not a property");
                }
            }
        }
    }

    private static boolean hasRootPaths(ClassModel m) {
        for (JsonNode rule : m.requiredIf) {
            if (texts(rule.path("requiredPaths")).stream().anyMatch(ModelGenerator::rootPath)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasObjectRules(ClassModel m) {
        for (JsonNode rule : m.requiredIf) {
            if (!texts(rule.path("required")).isEmpty()
                    || texts(rule.path("requiredPaths")).stream().anyMatch(p -> !rootPath(p))) {
                return true;
            }
        }
        return false;
    }

    private static String target(Prop p) {
        return p.list ? p.itemType : p.type;
    }

    private void collectRootRuleGraph() {
        classes.values().stream().filter(m -> m.request && hasRootPaths(m)).forEach(m -> rootRuleGraph.add(m.name));
        boolean changed = true;
        while (changed) {
            changed = false;
            for (ClassModel m : classes.values()) {
                if (m.request && !m.multipart && !rootRuleGraph.contains(m.name)
                        && m.props.stream().anyMatch(p -> p.structural && rootRuleGraph.contains(target(p)))) {
                    changed |= rootRuleGraph.add(m.name);
                }
            }
            for (Map.Entry<String, List<String>> flow : flowItems.entrySet()) {
                if (!rootRuleGraph.contains(flow.getKey())
                        && flow.getValue().stream().anyMatch(k -> rootRuleGraph.contains(channels.get(k)))) {
                    changed |= rootRuleGraph.add(flow.getKey());
                }
            }
        }
    }

    private static String stringList(List<String> values) {
        return values.isEmpty() ? "List.of()"
                : "List.of(" + values.stream().map(ModelGenerator::quote).collect(Collectors.joining(", ")) + ")";
    }

    private String renderRequiredIf() {
        StringBuilder s = new StringBuilder(HEADER);
        s.append("package ").append(MODELS_PACKAGE).append(";\n\n");
        s.append("import java.util.List;\nimport java.util.Map;\n\n");
        s.append("/**\n * The spec's {@code x-sdk-required-if} rules as data, read by {@link RequiredIf}.\n */\n");
        s.append("final class GeneratedRequiredIf {\n\n");
        s.append("    /** Schema name to its rules (all apply). */\n");
        s.append("    static final Map<String, List<RequiredIf.Rule>> RULES = Map.ofEntries(");
        List<String> rows = new ArrayList<>();
        for (ClassModel m : classes.values()) {
            if (!m.request || m.requiredIf.isEmpty()) {
                continue;
            }
            List<String> rules = new ArrayList<>();
            for (JsonNode rule : m.requiredIf) {
                JsonNode when = rule.path("when");
                String op = operator(when);
                rules.add("\n                    new RequiredIf.Rule(" + quote(when.path("field").asText()) + ", "
                        + quote(op) + ", " + stringList(texts(when.path(op))) + ",\n                            "
                        + stringList(texts(rule.path("required"))) + ", "
                        + stringList(texts(rule.path("requiredPaths"))) + ")");
            }
            rows.add("\n            Map.entry(" + quote(m.name) + ", List.of(" + String.join(",", rules) + "))");
        }
        s.append(String.join(",", rows)).append(");\n\n");
        s.append("    /** Request objects on the way to an object with {@code $.} rules: property to child schema. */\n");
        s.append("    static final Map<String, Map<String, String>> CHILDREN = Map.ofEntries(");
        rows.clear();
        for (String name : rootRuleGraph) {
            Map<String, String> children = new LinkedHashMap<>();
            ClassModel m = classes.get(name);
            if (m != null) {
                m.props.stream().filter(p -> p.structural && rootRuleGraph.contains(target(p)))
                        .forEach(p -> children.put(p.json, target(p)));
            } else {
                flowItems.get(name).stream().filter(k -> rootRuleGraph.contains(channels.get(k)))
                        .forEach(k -> children.put(k, channels.get(k)));
            }
            rows.add("\n            Map.entry(" + quote(name) + ", Map.of(" + children.entrySet().stream()
                    .map(e -> quote(e.getKey()) + ", " + quote(e.getValue())).collect(Collectors.joining(", ")) + "))");
        }
        s.append(String.join(",", rows)).append(");\n\n");
        s.append("    /** Properties of the request bodies checked with {@code checkRequest}: a {@code $.} path whose first\n")
                .append("     * property the body does not have is skipped. */\n");
        s.append("    static final Map<String, List<String>> PROPERTIES = Map.ofEntries(");
        rows.clear();
        for (String name : rootRuleGraph) {
            if (jsonRoots.contains(name) && classes.containsKey(name)) {
                rows.add("\n            Map.entry(" + quote(name) + ", "
                        + stringList(classes.get(name).props.stream().map(p -> p.json).collect(Collectors.toList())) + ")");
            }
        }
        s.append(String.join(",", rows)).append(");\n\n");
        s.append("    private GeneratedRequiredIf() {\n    }\n}\n");
        return s.toString();
    }

    private Set<String> closure(String root) {
        Set<String> seen = new LinkedHashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String name = stack.pop();
            if (seen.add(name)) {
                for (String ref : refs(schemas.path(name))) {
                    if (!seen.contains(ref)) {
                        stack.push(ref);
                    }
                }
            }
        }
        return seen;
    }

    private static Set<String> refs(JsonNode node) {
        Set<String> found = new LinkedHashSet<>();
        if (node.isObject()) {
            JsonNode ref = node.get("$ref");
            if (ref != null && ref.isTextual()) {
                found.add(refName(node));
            }
            node.elements().forEachRemaining(child -> found.addAll(refs(child)));
        } else if (node.isArray()) {
            node.elements().forEachRemaining(child -> found.addAll(refs(child)));
        }
        return found;
    }

    private static String refName(JsonNode node) {
        String ref = node.path("$ref").asText();
        return ref.substring(ref.lastIndexOf('/') + 1);
    }

    private void addClass(String name, JsonNode schema, boolean request) {
        ClassModel model = new ClassModel();
        model.name = name;
        model.request = request;
        model.description = schema.path("description").asText("");
        model.unverified = schema.path("x-unverified").asText("");
        model.requiredIf = schema.path("x-sdk-required-if");
        model.channelKey = channels.entrySet().stream()
                .filter(e -> e.getValue().equals(name)).map(Map.Entry::getKey).findFirst().orElse(null);
        Map<String, JsonNode> props = new LinkedHashMap<>();
        Set<String> required = new LinkedHashSet<>();
        mergeObject(schema, props, required);
        for (Map.Entry<String, JsonNode> entry : props.entrySet()) {
            model.props.add(prop(model, entry.getKey(), entry.getValue(), required.contains(entry.getKey())));
        }
        checkRules(model);
        classes.put(name, model);
    }

    private void mergeObject(JsonNode schema, Map<String, JsonNode> props, Set<String> required) {
        for (JsonNode part : schema.path("allOf")) {
            mergeObject(part.has("$ref") ? schemas.path(refName(part)) : part, props, required);
        }
        schema.path("properties").properties().forEach(e -> props.put(e.getKey(), e.getValue()));
        schema.path("required").forEach(r -> required.add(r.asText()));
    }

    private Prop prop(ClassModel owner, String jsonName, JsonNode schema, boolean required) {
        Prop p = new Prop();
        p.json = jsonName;
        p.java = JAVA_KEYWORDS.contains(jsonName) ? jsonName + "_" : jsonName;
        p.required = required;
        p.description = schema.path("description").asText("");
        p.unverified = schema.path("x-unverified").asText("");
        p.type = javaType(owner, jsonName, schema, p);
        if (schema.has("maxLength")) {
            p.maxLength = schema.get("maxLength").asInt();
        }
        if (schema.has("minItems")) {
            p.minItems = schema.get("minItems").asInt();
        }
        if (schema.has("maxItems")) {
            p.maxItems = schema.get("maxItems").asInt();
        }
        if (schema.has("minimum")) {
            p.minimum = schema.get("minimum").asLong();
        }
        if (schema.has("maximum")) {
            p.maximum = schema.get("maximum").asLong();
        }
        if (schema.has("x-max-bytes")) {
            p.maxBytes = schema.get("x-max-bytes").asInt();
        }
        p.charset = schema.path("x-charset").asText(null);
        p.pattern = schema.path("pattern").asText(null);
        p.format = schema.path("x-format").asText(null);
        if (schema.has("default")) {
            p.defaultValue = schema.get("default").asText();
        }
        schema.path("enum").forEach(v -> p.enumValues.add(v.asText()));
        schema.path("x-known-values").forEach(v -> p.knownValues.add(v.asText()));
        return p;
    }

    private String javaType(ClassModel owner, String jsonName, JsonNode schema, Prop p) {
        if (schema.has("$ref")) {
            p.structural = true;
            return refName(schema);
        }
        JsonNode allOf = schema.path("allOf");
        if (allOf.isArray() && allOf.size() == 1 && allOf.get(0).has("$ref")) {
            p.structural = true;
            return refName(allOf.get(0));
        }
        String type = primaryType(schema);
        switch (type) {
            case "string":
                if ("binary".equals(schema.path("format").asText())) {
                    p.binary = true;
                    return "FileUpload";
                }
                return "String";
            case "boolean":
                return "Boolean";
            case "number":
                return "Double";
            case "integer":
                return "int64".equals(schema.path("format").asText()) || !owner.request ? "Long" : "Integer";
            case "array": {
                p.list = true;
                Prop item = new Prop();
                String itemType = javaType(owner, jsonName, schema.path("items"), item);
                p.structural = item.structural;
                p.binary = item.binary;
                p.itemType = itemType;
                return "List<" + itemType + ">";
            }
            case "object": {
                if (schema.has("properties")) {
                    String nested = owner.name + capitalize(jsonName);
                    addInline(nested, schema, owner.request);
                    p.structural = true;
                    return nested;
                }
                p.map = true;
                JsonNode additional = schema.path("additionalProperties");
                if (additional.isObject() && "string".equals(additional.path("type").asText())) {
                    p.itemType = "String";
                    return "Map<String, String>";
                }
                p.itemType = "Object";
                return "Map<String, Object>";
            }
            default:
                throw new IllegalStateException("unsupported schema type '" + type + "' for " + owner.name + "." + jsonName);
        }
    }

    private void addInline(String name, JsonNode schema, boolean request) {
        if (!classes.containsKey(name)) {
            addClass(name, schema, request);
        }
    }

    private static String primaryType(JsonNode schema) {
        JsonNode type = schema.path("type");
        if (type.isArray()) {
            for (JsonNode t : type) {
                if (!"null".equals(t.asText())) {
                    return t.asText();
                }
            }
        }
        if (type.isMissingNode()) {
            return schema.has("properties") ? "object" : "string";
        }
        return type.asText();
    }

    // ------------------------------------------------------------------ rendering

    private String render(ClassModel m) {
        StringBuilder s = new StringBuilder(HEADER);
        s.append("package ").append(MODELS_PACKAGE).append(";\n\n");
        s.append(imports(m));
        s.append(classDoc(m));
        s.append("@JsonInclude(JsonInclude.Include.NON_NULL)\n");
        s.append(AUTO_DETECT_NONE);
        if (m.request) {
            s.append("@JsonDeserialize(builder = ").append(m.name).append(".Builder.class)\n");
        }
        s.append("@JsonPropertyOrder({").append(m.props.stream().map(p -> quote(p.json)).collect(Collectors.joining(", ")))
                .append("})\n");
        s.append("public final class ").append(m.name);
        if (m.channelKey != null) {
            s.append(" implements ChannelMessage");
        }
        s.append(" {\n");
        if (m.channelKey != null) {
            s.append("\n    /** {@code messageFlow} channel key of this message. */\n");
            s.append("    public static final String CHANNEL_KEY = ").append(quote(m.channelKey)).append(";\n");
        }
        for (Prop p : m.props) {
            if (m.request && !p.enumValues.isEmpty()) {
                s.append("    private static final List<String> ").append(constName(p)).append("_VALUES = List.of(")
                        .append(p.enumValues.stream().map(ModelGenerator::quote).collect(Collectors.joining(", ")))
                        .append(");\n");
            }
            if (m.request && p.pattern != null) {
                s.append("    private static final Pattern ").append(constName(p)).append("_PATTERN = Pattern.compile(")
                        .append(quote(p.pattern)).append(");\n");
            }
        }
        s.append("\n");
        for (Prop p : m.props) {
            s.append("    private final ").append(p.type).append(' ').append(p.java).append(";\n");
        }
        if (!m.request) {
            s.append("    private final Map<String, Object> additionalProperties;\n");
        }
        s.append("\n");
        renderConstructors(s, m);
        s.append("    /** Returns a new, empty builder. */\n");
        s.append("    public static Builder builder() {\n        return new Builder();\n    }\n\n");
        s.append("    /** Returns a builder initialised with the values of this object. */\n");
        s.append("    public Builder toBuilder() {\n        Builder builder = new Builder();\n");
        for (Prop p : m.props) {
            s.append("        builder.").append(p.java).append(" = this.").append(p.java).append(";\n");
        }
        if (!m.request) {
            s.append("        builder.additionalProperties.putAll(this.additionalProperties);\n");
        }
        s.append("        return builder;\n    }\n\n");
        if (m.channelKey != null) {
            s.append("    @Override\n    public String channelKey() {\n        return CHANNEL_KEY;\n    }\n\n");
        }
        if (jsonRoots.contains(m.name)) {
            renderRootHelpers(s, m);
        }
        for (Prop p : m.props) {
            s.append(propDoc(p, "    ", true));
            s.append("    @JsonProperty(").append(quote(p.json)).append(")\n");
            s.append("    public ").append(p.type).append(' ').append(getter(p)).append("() {\n        return ")
                    .append(p.java).append(";\n    }\n\n");
        }
        if (!m.request) {
            s.append("    /**\n     * Properties the server sent that are not in the spec (new fields are kept instead of dropped).\n")
                    .append("     *\n     * @return unmodifiable map, empty if there are none\n     */\n");
            s.append("    @JsonAnyGetter\n    public Map<String, Object> getAdditionalProperties() {\n")
                    .append("        return Collections.unmodifiableMap(additionalProperties);\n    }\n\n");
            s.append("    @JsonAnySetter\n    private void putAdditionalProperty(String name, Object value) {\n")
                    .append("        additionalProperties.put(name, value);\n    }\n\n");
        }
        renderEqualsHashCodeToString(s, m);
        renderBuilder(s, m);
        s.append("}\n");
        return s.toString();
    }

    private static final String AUTO_DETECT_NONE = "@JsonAutoDetect(\n"
            + "        fieldVisibility = JsonAutoDetect.Visibility.NONE,\n"
            + "        getterVisibility = JsonAutoDetect.Visibility.NONE,\n"
            + "        isGetterVisibility = JsonAutoDetect.Visibility.NONE,\n"
            + "        setterVisibility = JsonAutoDetect.Visibility.NONE,\n"
            + "        creatorVisibility = JsonAutoDetect.Visibility.NONE)\n";

    private String imports(ClassModel m) {
        Set<String> imports = new java.util.TreeSet<>();
        imports.add("com.fasterxml.jackson.annotation.JsonAutoDetect");
        imports.add("com.fasterxml.jackson.annotation.JsonInclude");
        imports.add("com.fasterxml.jackson.annotation.JsonProperty");
        imports.add("com.fasterxml.jackson.annotation.JsonPropertyOrder");
        imports.add("java.util.Objects");
        imports.add("java.util.StringJoiner");
        boolean collections = !m.request;
        for (Prop p : m.props) {
            if (p.list) {
                imports.add("java.util.List");
                imports.add("java.util.ArrayList");
                imports.add("java.util.Arrays");
                collections = true;
            }
            if (p.map) {
                imports.add("java.util.Map");
                imports.add("java.util.LinkedHashMap");
                collections = true;
            }
            if (m.request && !p.enumValues.isEmpty()) {
                imports.add("java.util.List");
            }
            if (m.request && p.pattern != null) {
                imports.add("java.util.regex.Pattern");
            }
            if (p.binary) {
                imports.add(FILE_UPLOAD);
            }
        }
        if (collections) {
            imports.add("java.util.Collections");
        }
        if (m.request) {
            imports.add("com.fasterxml.jackson.databind.annotation.JsonDeserialize");
            imports.add("com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder");
        } else {
            imports.add("com.fasterxml.jackson.annotation.JsonAnyGetter");
            imports.add("com.fasterxml.jackson.annotation.JsonAnySetter");
            imports.add("com.fasterxml.jackson.annotation.JsonCreator");
            imports.add("java.util.Map");
            imports.add("java.util.LinkedHashMap");
        }
        if (jsonRoots.contains(m.name)) {
            imports.add("java.util.Map");
        }
        StringBuilder s = new StringBuilder();
        for (String imp : imports) {
            s.append("import ").append(imp).append(";\n");
        }
        return s.append("\n").toString();
    }

    private void renderConstructors(StringBuilder s, ClassModel m) {
        if (m.request) {
            s.append("    private ").append(m.name).append("(Builder builder) {\n");
            for (Prop p : m.props) {
                s.append("        this.").append(p.java).append(" = ").append(copyExpr(p, "builder." + p.java)).append(";\n");
            }
            s.append("    }\n\n");
            return;
        }
        s.append("    @JsonCreator\n    private ").append(m.name).append("(");
        String params = m.props.stream()
                .map(p -> "\n            @JsonProperty(" + quote(p.json) + ") " + p.type + " " + p.java)
                .collect(Collectors.joining(","));
        s.append(params).append(") {\n");
        for (Prop p : m.props) {
            s.append("        this.").append(p.java).append(" = ").append(copyExpr(p, p.java)).append(";\n");
        }
        s.append("        this.additionalProperties = new LinkedHashMap<>();\n    }\n\n");
        s.append("    private ").append(m.name).append("(Builder builder) {\n        this(");
        s.append(m.props.stream().map(p -> "builder." + p.java).collect(Collectors.joining(", ")));
        s.append(");\n        this.additionalProperties.putAll(builder.additionalProperties);\n    }\n\n");
    }

    private static String copyExpr(Prop p, String source) {
        if (p.list) {
            return source + " == null ? null : Collections.unmodifiableList(new ArrayList<>(" + source + "))";
        }
        if (p.map) {
            return source + " == null ? null : Collections.unmodifiableMap(new LinkedHashMap<>(" + source + "))";
        }
        return source;
    }

    private void renderRootHelpers(StringBuilder s, ClassModel m) {
        s.append("    /**\n     * Parse and validate a request written with the API field names (JSON).\n")
                .append("     * Unknown fields are rejected so that typos fail before anything is sent.\n     *\n")
                .append("     * @param json request body, for example an example from the API reference\n")
                .append("     * @return the validated request\n")
                .append("     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid\n     */\n");
        s.append("    public static ").append(m.name).append(" fromJson(String json) {\n")
                .append("        return RequestParser.parse(json, ").append(m.name).append(".class);\n    }\n\n");
        s.append("    /**\n     * Same as {@link #fromJson(String)} for a map with the API field names.\n     *\n")
                .append("     * @param body request body as nested maps and lists\n")
                .append("     * @return the validated request\n")
                .append("     * @throws io.github.icommapi.bizgo.errors.ValidationException if the body is invalid\n     */\n");
        s.append("    public static ").append(m.name).append(" fromMap(Map<String, ?> body) {\n")
                .append("        return RequestParser.parse(body, ").append(m.name).append(".class);\n    }\n\n");
        s.append("    /**\n     * The JSON body that is sent. Contains phone numbers: do not log it.\n     *\n")
                .append("     * @return JSON with only the fields that were set\n     */\n");
        s.append("    public String toJson() {\n        return RequestParser.toJson(this);\n    }\n\n");
    }

    private void renderEqualsHashCodeToString(StringBuilder s, ClassModel m) {
        List<String> fields = new ArrayList<>();
        m.props.forEach(p -> fields.add(p.java));
        if (!m.request) {
            fields.add("additionalProperties");
        }
        s.append("    @Override\n    public boolean equals(Object o) {\n        if (this == o) {\n            return true;\n        }\n");
        s.append("        if (!(o instanceof ").append(m.name).append(")) {\n            return false;\n        }\n");
        if (fields.isEmpty()) {
            s.append("        return true;\n    }\n\n");
        } else {
            s.append("        ").append(m.name).append(" other = (").append(m.name).append(") o;\n        return ");
            s.append(fields.stream().map(f -> "Objects.equals(" + f + ", other." + f + ")")
                    .collect(Collectors.joining("\n                && ")));
            s.append(";\n    }\n\n");
        }
        s.append("    @Override\n    public int hashCode() {\n        return Objects.hash(")
                .append(String.join(", ", fields)).append(");\n    }\n\n");
        s.append("    /** Values that can contain personal data (phone numbers, message text, ...) are masked. */\n");
        s.append("    @Override\n    public String toString() {\n");
        s.append("        StringJoiner joiner = new StringJoiner(\", \", \"").append(m.name).append("{\", \"}\");\n");
        for (Prop p : m.props) {
            boolean show = (SAFE_TO_PRINT.contains(p.json) || p.structural) && !p.binary;
            String value;
            if (show) {
                value = "=\" + " + p.java;
            } else if (PHONE_FIELDS.contains(p.json) && "String".equals(p.type)) {
                value = "=\" + " + MASKING + ".phone(" + p.java + ")"; // 010****0000 (SDK-DESIGN 12.11)
            } else if (isPerson(m.name, p.json) && "String".equals(p.type)) {
                value = "=\" + " + MASKING + ".person(" + p.java + ")"; // 홍**
            } else if ("String".equals(p.type)) {
                value = "=\" + " + MASKING + ".length(" + p.java + ")"; // content: length only
            } else {
                value = "=***\"";
            }
            s.append("        if (").append(p.java).append(" != null) {\n            joiner.add(\"").append(p.json)
                    .append(value).append(");\n        }\n");
        }
        if (!m.request) {
            s.append("        if (!additionalProperties.isEmpty()) {\n")
                    .append("            joiner.add(\"additionalProperties=\" + additionalProperties.keySet());\n        }\n");
        }
        s.append("        return joiner.toString();\n    }\n\n");
    }

    private void renderBuilder(StringBuilder s, ClassModel m) {
        s.append("    /** Builder for {@link ").append(m.name).append("}. */\n");
        if (m.request) {
            s.append("    @JsonPOJOBuilder(withPrefix = \"\")\n");
        }
        s.append(AUTO_DETECT_NONE.replace("\n        ", "\n            ").replace("@JsonAutoDetect", "    @JsonAutoDetect"));
        s.append("    public static final class Builder {\n");
        for (Prop p : m.props) {
            s.append("        private ").append(p.type).append(' ').append(p.java).append(";\n");
        }
        if (!m.request) {
            s.append("        private final Map<String, Object> additionalProperties = new LinkedHashMap<>();\n");
        }
        s.append("\n        /** Creates an empty builder; same as {@link ").append(m.name).append("#builder()}. */\n");
        s.append("        public Builder() {\n        }\n\n");
        for (Prop p : m.props) {
            s.append(propDoc(p, "        ", false));
            if (m.request) {
                s.append("        @JsonProperty(").append(quote(p.json)).append(")\n");
            }
            s.append("        public Builder ").append(p.java).append("(").append(p.type).append(' ').append(p.java)
                    .append(") {\n            this.").append(p.java).append(" = ").append(p.java)
                    .append(";\n            return this;\n        }\n\n");
            if (p.list && !p.itemType.contains("<")) {
                s.append("        /**\n         * Varargs form of {@link #").append(p.java).append("(List)}.\n         *\n")
                        .append("         * @param ").append(p.java).append(" values\n")
                        .append("         * @return this builder\n         */\n");
                s.append("        public Builder ").append(p.java).append("(").append(p.itemType).append("... ")
                        .append(p.java).append(") {\n            this.").append(p.java).append(" = ").append(p.java)
                        .append(" == null ? null : Arrays.asList(").append(p.java)
                        .append(");\n            return this;\n        }\n\n");
            }
        }
        if (!m.request) {
            s.append("        /**\n         * Adds a property that is not in the spec.\n         *\n")
                    .append("         * @param name JSON property name\n         * @param value value\n")
                    .append("         * @return this builder\n         */\n");
            s.append("        public Builder additionalProperty(String name, Object value) {\n")
                    .append("            additionalProperties.put(name, value);\n            return this;\n        }\n\n");
        }
        s.append("        /**\n         * Builds the object.\n         *\n         * @return a new immutable {@code ")
                .append(m.name).append("}\n");
        if (m.request) {
            s.append("         * @throws io.github.icommapi.bizgo.errors.ValidationException if a field is missing or invalid\n");
        }
        s.append("         */\n        public ").append(m.name).append(" build() {\n");
        if (m.request) {
            s.append("            ").append(m.name).append(" built = new ").append(m.name).append("(this);\n");
            s.append("            ModelValidator v = new ModelValidator(").append(quote(m.name)).append(");\n");
            for (Prop p : m.props) {
                s.append(validation(p));
            }
            if (hasObjectRules(m)) {
                s.append("            RequiredIf.checkObject(v, ").append(quote(m.name)).append(", built); // x-sdk-required-if\n");
            }
            if (jsonRoots.contains(m.name) && rootRuleGraph.contains(m.name)) {
                s.append("            RequiredIf.checkRequest(v, ").append(quote(m.name))
                        .append(", built); // x-sdk-required-if $. paths\n");
            }
            s.append("            v.check();\n            return built;\n        }\n");
            s.append("\n        /** Builds without request validation (responses, tests). */\n");
            s.append("        ").append(m.name).append(" buildUnvalidated() {\n            return new ")
                    .append(m.name).append("(this);\n        }\n");
        } else {
            s.append("            return new ").append(m.name).append("(this);\n        }\n");
        }
        s.append("    }\n");
    }

    private String validation(Prop p) {
        StringBuilder s = new StringBuilder();
        String f = "built." + p.java;
        String name = quote(p.json);
        if (p.required) {
            s.append("            v.required(").append(name).append(", ").append(f).append(");\n");
        }
        if (p.list) {
            s.append("            v.items(").append(name).append(", ").append(f).append(", ")
                    .append(p.minItems == null ? "-1" : p.minItems).append(", ")
                    .append(p.maxItems == null ? "-1" : p.maxItems).append(");\n");
        }
        if (p.map) {
            s.append("            v.mapValues(").append(name).append(", ").append(f).append(", ")
                    .append("String".equals(p.itemType)).append(");\n");
        }
        if (p.maxLength != null) {
            s.append("            v.maxLength(").append(name).append(", ").append(f).append(", ").append(p.maxLength)
                    .append(");\n");
        }
        if (p.maxBytes != null) {
            s.append("            v.maxBytes(").append(name).append(", ").append(f).append(", ").append(p.maxBytes)
                    .append(", ").append(p.charset == null ? "null" : quote(p.charset)).append(");\n");
        }
        if (p.minimum != null || p.maximum != null) {
            s.append("            v.range(").append(name).append(", ").append(f).append(", ")
                    .append(p.minimum == null ? "null" : p.minimum + "L").append(", ")
                    .append(p.maximum == null ? "null" : p.maximum + "L").append(");\n");
        }
        if (!p.enumValues.isEmpty()) {
            s.append("            v.oneOf(").append(name).append(", ").append(f).append(", ").append(constName(p))
                    .append("_VALUES);\n");
        }
        if (p.pattern != null) {
            s.append("            v.pattern(").append(name).append(", ").append(f).append(", ").append(constName(p))
                    .append("_PATTERN);\n");
        }
        return s.toString();
    }

    private String renderFlowItem(String name, List<String> keys) {
        Map<String, String> channels = new LinkedHashMap<>();
        keys.forEach(k -> channels.put(k, this.channels.get(k)));
        StringBuilder s = new StringBuilder(HEADER);
        JsonNode schema = schemas.path(name);
        s.append("package ").append(MODELS_PACKAGE).append(";\n\n");
        s.append("import com.fasterxml.jackson.annotation.JsonAutoDetect;\n")
                .append("import com.fasterxml.jackson.annotation.JsonInclude;\n")
                .append("import com.fasterxml.jackson.annotation.JsonProperty;\n")
                .append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;\n")
                .append("import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;\n")
                .append("import java.util.Objects;\nimport java.util.StringJoiner;\nimport java.util.stream.Stream;\n\n");
        s.append("/**\n").append(javadoc(schema.path("description").asText(), " * "))
                .append(" *\n * <p>Usually you do not create this yourself: {@code client.send().omni(...)} wraps each\n")
                .append(" * {@link ChannelMessage} with {@link #of(ChannelMessage)}.\n */\n");
        s.append("@JsonInclude(JsonInclude.Include.NON_NULL)\n").append(AUTO_DETECT_NONE);
        s.append("@JsonDeserialize(builder = " + name + ".Builder.class)\n");
        s.append("public final class " + name + " {\n\n");
        String keyList = String.join(", ", channels.keySet());
        s.append("    static final String EXACTLY_ONE = \"messageFlow 항목에는 채널 키(").append(keyList)
                .append(") 중 정확히 하나가 있어야 합니다\";\n\n");
        channels.forEach((key, cls) -> s.append("    private final ").append(cls).append(' ').append(key).append(";\n"));
        s.append("\n    private " + name + "(Builder builder) {\n");
        channels.keySet().forEach(key -> s.append("        this.").append(key).append(" = builder.").append(key).append(";\n"));
        s.append("    }\n\n");
        s.append("    /**\n     * Wraps a channel message into its {@code messageFlow} item ({@code {\"sms\": {...}}} etc.).\n")
                .append("     *\n     * @param message channel message\n     * @return the flow item\n")
                .append("     * @throws io.github.icommapi.bizgo.errors.ValidationException if {@code message} is null\n     */\n");
        s.append("    public static " + name + " of(ChannelMessage message) {\n");
        s.append("        Builder builder = new Builder();\n");
        boolean first = true;
        for (Map.Entry<String, String> e : channels.entrySet()) {
            s.append(first ? "        if" : " else if").append(" (message instanceof ").append(e.getValue())
                    .append(") {\n            builder.").append(e.getKey()).append("((").append(e.getValue())
                    .append(") message);\n        }");
            first = false;
        }
        s.append("\n        return builder.build();\n    }\n\n");
        s.append("    /** Returns a new, empty builder. */\n    public static Builder builder() {\n        return new Builder();\n    }\n\n");
        s.append("    /**\n     * The channel message in this item.\n     *\n     * @return the only channel message that is set\n     */\n");
        s.append("    public ChannelMessage getMessage() {\n        return Stream.<ChannelMessage>of(")
                .append(String.join(", ", channels.keySet()))
                .append(")\n                .filter(Objects::nonNull).findFirst().orElseThrow();\n    }\n\n");
        channels.forEach((key, cls) -> {
            s.append("    /**\n     * {@code ").append(key).append("} channel message.\n     *\n     * @return the message, or null\n     */\n");
            s.append("    @JsonProperty(").append(quote(key)).append(")\n    public ").append(cls).append(" get")
                    .append(capitalize(key)).append("() {\n        return ").append(key).append(";\n    }\n\n");
        });
        s.append("    @Override\n    public boolean equals(Object o) {\n        if (this == o) {\n            return true;\n        }\n")
                .append("        if (!(o instanceof " + name + ")) {\n            return false;\n        }\n")
                .append("        " + name + " other = (" + name + ") o;\n        return ")
                .append(channels.keySet().stream().map(k -> "Objects.equals(" + k + ", other." + k + ")")
                        .collect(Collectors.joining("\n                && ")))
                .append(";\n    }\n\n");
        s.append("    @Override\n    public int hashCode() {\n        return Objects.hash(")
                .append(String.join(", ", channels.keySet())).append(");\n    }\n\n");
        s.append("    @Override\n    public String toString() {\n")
                .append("        StringJoiner joiner = new StringJoiner(\", \", \"" + name + "{\", \"}\");\n");
        channels.keySet().forEach(k -> s.append("        if (").append(k).append(" != null) {\n            joiner.add(\"")
                .append(k).append("=\" + ").append(k).append(");\n        }\n"));
        s.append("        return joiner.toString();\n    }\n\n");
        s.append("    /** Builder for {@link " + name + "}. Set exactly one channel. */\n");
        s.append("    @JsonPOJOBuilder(withPrefix = \"\")\n");
        s.append(AUTO_DETECT_NONE.replace("\n        ", "\n            ").replace("@JsonAutoDetect", "    @JsonAutoDetect"));
        s.append("    public static final class Builder {\n");
        channels.forEach((key, cls) -> s.append("        private ").append(cls).append(' ').append(key).append(";\n"));
        s.append("\n        /** Creates an empty builder. */\n        public Builder() {\n        }\n\n");
        channels.forEach((key, cls) -> {
            s.append("        /**\n         * Sets the {@code ").append(key).append("} channel message.\n         *\n")
                    .append("         * @param ").append(key).append(" message\n         * @return this builder\n         */\n");
            s.append("        @JsonProperty(").append(quote(key)).append(")\n        public Builder ").append(key)
                    .append("(").append(cls).append(' ').append(key).append(") {\n            this.").append(key)
                    .append(" = ").append(key).append(";\n            return this;\n        }\n\n");
        });
        s.append("        /**\n         * Builds the item.\n         *\n         * @return the item\n")
                .append("         * @throws io.github.icommapi.bizgo.errors.ValidationException unless exactly one channel is set\n")
                .append("         */\n        public " + name + " build() {\n");
        s.append("            long set = Stream.of(").append(String.join(", ", channels.keySet()))
                .append(").filter(Objects::nonNull).count();\n");
        s.append("            ModelValidator v = new ModelValidator(\"" + name + "\");\n");
        s.append("            v.exactlyOne(set == 1, EXACTLY_ONE);\n            v.check();\n");
        s.append("            return new " + name + "(this);\n        }\n\n");
        s.append("        /** Used when this item appears in a response: no request validation. */\n");
        s.append("        " + name + " buildUnvalidated() {\n            return new " + name + "(this);\n        }\n    }\n}\n");
        return s.toString();
    }

    private String renderChannelMessage() {
        StringBuilder s = new StringBuilder(HEADER);
        s.append("package ").append(MODELS_PACKAGE).append(";\n\n");
        s.append("/**\n * A channel message you can put in {@code client.send().omni(to, messages...)}.\n *\n");
        s.append(" * <table>\n * <caption>Channels</caption>\n * <tr><th>messageFlow key</th><th>class</th></tr>\n");
        channels.forEach((key, cls) -> s.append(" * <tr><td>{@code ").append(key).append("}</td><td>{@link ")
                .append(cls).append("}</td></tr>\n"));
        s.append(" * </table>\n */\n");
        s.append("public sealed interface ChannelMessage permits ").append(String.join(", ", channels.values()))
                .append(" {\n\n");
        s.append("    /**\n     * The {@code messageFlow} channel key, for example {@code sms} or {@code alimtalk}.\n     *\n")
                .append("     * @return channel key\n     */\n    String channelKey();\n}\n");
        return s.toString();
    }

    private static String renderServiceCodes(JsonNode codes) {
        StringBuilder s = new StringBuilder(HEADER.replace("spec/openapi.yaml", "spec/error-codes.json"));
        s.append("package ").append(ERRORS_PACKAGE).append(";\n\n");
        s.append("import java.util.Map;\nimport java.util.Optional;\n\n");
        s.append("/**\n * Service-layer ({@code data.code}) result codes with their documented HTTP status and Korean description.\n")
                .append(" *\n * <p>Source: ").append(escapeHtml(codes.path("source").asText())).append("\n */\n");
        s.append("public final class ServiceCodes {\n\n");
        s.append("    /** Where the table comes from. */\n    public static final String SOURCE = ")
                .append(quote(codes.path("source").asText())).append(";\n\n");
        s.append("    /**\n     * One service code.\n     *\n     * @param code code, for example {@code A306}\n")
                .append("     * @param httpStatus documented HTTP status (0 if not documented)\n")
                .append("     * @param description Korean description\n     */\n");
        s.append("    public record Code(String code, int httpStatus, String description) {\n    }\n\n");
        Map<String, String> rows = new LinkedHashMap<>();
        for (JsonNode entry : codes.path("service")) {
            int status = entry.hasNonNull("httpStatus") ? entry.get("httpStatus").asInt() : 0;
            String text = entry.path("descriptionKo").asText("");
            if (text.isEmpty()) {
                text = entry.path("result").asText("");
            }
            String code = entry.path("code").asText();
            rows.put(code, "            Map.entry(" + quote(code) + ", new Code(" + quote(code) + ", " + status + ", "
                    + quote(text) + "))");
        }
        s.append("    private static final Map<String, Code> CODES = Map.ofEntries(\n")
                .append(String.join(",\n", rows.values())).append(");\n\n");
        s.append("    private ServiceCodes() {\n    }\n\n");
        s.append("    /**\n     * Looks up a service code.\n     *\n     * @param code code, for example {@code A306}\n")
                .append("     * @return the entry, or empty if the code is not in the table\n     */\n");
        s.append("    public static Optional<Code> lookup(String code) {\n")
                .append("        return code == null ? Optional.empty() : Optional.ofNullable(CODES.get(code));\n    }\n\n");
        s.append("    /**\n     * All codes in the table.\n     *\n     * @return unmodifiable map from code to entry\n     */\n");
        s.append("    public static Map<String, Code> all() {\n        return CODES;\n    }\n}\n");
        return s.toString();
    }

    // ------------------------------------------------------------------ javadoc

    private static String classDoc(ClassModel m) {
        StringBuilder s = new StringBuilder("/**\n");
        s.append(m.description.isBlank() ? " * " + m.name + ".\n" : javadoc(m.description, " * "));
        if (!m.unverified.isBlank()) {
            s.append(" *\n * <p><b>확인 필요(x-unverified):</b> ").append(inline(m.unverified)).append("\n");
        }
        if (m.channelKey != null) {
            s.append(" *\n * <p>Sent as {@code messageFlow[].").append(m.channelKey).append("}.\n");
        }
        s.append(m.request
                ? " *\n * <p>Request model: immutable, created with {@link #builder()}, validated in {@link Builder#build()}.\n"
                : " *\n * <p>Response model: unknown JSON properties are kept in {@link #getAdditionalProperties()}.\n");
        return s.append(" */\n").toString();
    }

    private static String propDoc(Prop p, String indent, boolean getter) {
        StringBuilder s = new StringBuilder(indent).append("/**\n");
        String prefix = indent + " * ";
        s.append(p.description.isBlank() ? prefix + "{@code " + p.json + "}.\n" : javadoc(p.description, prefix));
        List<String> notes = new ArrayList<>();
        if (p.required) {
            notes.add("필수");
        }
        if (p.maxLength != null) {
            notes.add("최대 " + p.maxLength + "자");
        }
        if (p.maxBytes != null) {
            notes.add("최대 " + p.maxBytes + "byte" + (p.charset != null ? "(" + p.charset + ")" : ""));
        }
        if (p.minItems != null || p.maxItems != null) {
            notes.add("항목 수 " + (p.minItems == null ? "0" : p.minItems) + "~" + (p.maxItems == null ? "" : p.maxItems));
        }
        if (p.minimum != null || p.maximum != null) {
            notes.add("범위 " + (p.minimum == null ? "" : p.minimum) + "~" + (p.maximum == null ? "" : p.maximum));
        }
        if (!p.enumValues.isEmpty()) {
            notes.add("허용 값 " + p.enumValues.stream().map(v -> "<code>" + escapeHtml(v) + "</code>")
                    .collect(Collectors.joining(", ")));
        }
        if (!p.knownValues.isEmpty()) {
            notes.add("알려진 값 " + p.knownValues.stream().map(v -> "<code>" + escapeHtml(v) + "</code>")
                    .collect(Collectors.joining(", ")));
        }
        if (p.pattern != null) {
            notes.add("형식 <code>" + escapeHtml(p.pattern) + "</code>");
        }
        if (p.format != null) {
            notes.add("형식 <code>" + escapeHtml(p.format) + "</code>");
        }
        if (p.defaultValue != null) {
            notes.add("서버 기본값 <code>" + escapeHtml(p.defaultValue) + "</code>(설정하지 않으면 보내지 않음)");
        }
        if (!notes.isEmpty()) {
            s.append(prefix.stripTrailing()).append("\n").append(prefix).append("<p>").append(String.join(" · ", notes))
                    .append("\n");
        }
        if (!p.unverified.isBlank()) {
            s.append(prefix.stripTrailing()).append("\n").append(prefix).append("<p><b>확인 필요:</b> ")
                    .append(inline(p.unverified)).append("\n");
        }
        s.append(prefix.stripTrailing()).append("\n");
        if (getter) {
            s.append(prefix).append("@return the value, or null if not set\n");
        } else {
            s.append(prefix).append("@param ").append(p.java).append(" the value (null clears it)\n");
            s.append(prefix).append("@return this builder\n");
        }
        return s.append(indent).append(" */\n").toString();
    }

    /** Markdown-ish description to Javadoc HTML. Input values are escaped so the comment can never break. */
    static String javadoc(String text, String prefix) {
        List<String> out = new ArrayList<>();
        List<String> paragraph = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<String> pre = new ArrayList<>();
        boolean inFence = false;
        boolean firstBlock = true;
        String[] lines = text.strip().split("\n", -1);
        List<String> all = new ArrayList<>(List.of(lines));
        all.add("");
        for (String raw : all) {
            String line = raw.strip();
            if (line.startsWith("```")) {
                if (inFence) {
                    out.add("<pre>" + escapeHtml(String.join("\n", pre)) + "</pre>");
                    pre.clear();
                    inFence = false;
                } else {
                    firstBlock = flush(out, paragraph, list, firstBlock);
                    inFence = true;
                }
                continue;
            }
            if (inFence) {
                pre.add(line);
                continue;
            }
            if (line.startsWith("|")) {
                firstBlock = flush(out, paragraph, list, firstBlock);
                pre.add(line);
                continue;
            } else if (!pre.isEmpty()) {
                out.add("<pre>" + escapeHtml(String.join("\n", pre)) + "</pre>");
                pre.clear();
            }
            if (line.startsWith("- ")) {
                if (!paragraph.isEmpty()) {
                    firstBlock = flush(out, paragraph, List.of(), firstBlock);
                }
                list.add(line.substring(2));
            } else if (line.isEmpty()) {
                firstBlock = flush(out, paragraph, list, firstBlock);
            } else if (!list.isEmpty() && raw.startsWith("  ")) {
                list.set(list.size() - 1, list.get(list.size() - 1) + " " + line);
            } else {
                if (!list.isEmpty()) {
                    firstBlock = flush(out, List.of(), list, firstBlock);
                }
                paragraph.add(line);
            }
        }
        StringBuilder s = new StringBuilder();
        for (String block : out) {
            for (String l : block.split("\n", -1)) {
                s.append((prefix + l).stripTrailing()).append("\n");
            }
        }
        return s.toString();
    }

    private static boolean flush(List<String> out, List<String> paragraph, List<String> list, boolean firstBlock) {
        boolean first = firstBlock;
        if (!paragraph.isEmpty()) {
            String text = inline(String.join(" ", paragraph));
            out.add(first ? text : "<p>" + text);
            paragraph.clear();
            first = false;
        }
        if (!list.isEmpty()) {
            StringBuilder s = new StringBuilder("<ul>");
            for (String item : list) {
                s.append("\n<li>").append(inline(item)).append("</li>");
            }
            out.add(s.append("\n</ul>").toString());
            list.clear();
            first = false;
        }
        return first;
    }

    static String inline(String text) {
        String escaped = escapeHtml(text);
        escaped = escaped.replaceAll("`([^`]+)`", "<code>$1</code>");
        escaped = escaped.replaceAll("\\*\\*([^*]+)\\*\\*", "<b>$1</b>");
        return escaped;
    }

    static String escapeHtml(String text) {
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("@", "&#64;")
                .replace("*/", "*&#47;").replace("\\", "&#92;").replace("{", "&#123;").replace("}", "&#125;");
    }

    // ------------------------------------------------------------------ helpers

    private static String getter(Prop p) {
        return "get" + capitalize(p.json);
    }

    private static String constName(Prop p) {
        return p.json.replaceAll("([a-z0-9])([A-Z])", "$1_$2").toUpperCase(Locale.ROOT);
    }

    static String capitalize(String s) {
        return s.isEmpty() ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    static String quote(String s) {
        StringBuilder out = new StringBuilder("\"");
        for (char c : s.toCharArray()) {
            switch (c) {
                case '"':
                    out.append("\\\"");
                    break;
                case '\\':
                    out.append("\\\\");
                    break;
                case '\n':
                    out.append("\\n");
                    break;
                case '\r':
                    out.append("\\r");
                    break;
                case '\t':
                    out.append("\\t");
                    break;
                default:
                    if (c < 0x20) {
                        out.append(String.format("\\u%04x", (int) c));
                    } else {
                        out.append(c);
                    }
            }
        }
        return out.append('"').toString();
    }

    /** Lists every generated file under {@code root} (used by the check task to find stale files). */
    public static List<String> existing(Path root) throws IOException {
        if (!Files.isDirectory(root)) {
            return List.of();
        }
        try (Stream<Path> files = Files.walk(root)) {
            return files.filter(Files::isRegularFile)
                    .map(f -> root.relativize(f).toString().replace('\\', '/'))
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    private static final class ClassModel {
        String name;
        boolean request;
        String description;
        String unverified;
        String channelKey;
        boolean multipart;
        JsonNode requiredIf;
        final List<Prop> props = new ArrayList<>();
    }

    private static final class Prop {
        String json;
        String java;
        String type;
        String itemType;
        boolean list;
        boolean map;
        boolean structural;
        boolean binary;
        boolean required;
        String description = "";
        String unverified = "";
        Integer maxLength;
        Integer minItems;
        Integer maxItems;
        Long minimum;
        Long maximum;
        Integer maxBytes;
        String charset;
        String pattern;
        String format;
        String defaultValue;
        final List<String> enumValues = new ArrayList<>();
        final List<String> knownValues = new ArrayList<>();
    }
}
