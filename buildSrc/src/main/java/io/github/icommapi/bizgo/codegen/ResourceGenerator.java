package io.github.icommapi.bizgo.codegen;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Generates the resource classes ({@code client.alimtalk().templates().list(...)}), the query/header parameter
 * classes, the operation table and the webhook parsers from the {@code x-sdk-*} metadata of the spec.
 *
 * <p>Methods that a hand-written class already declares (same name) are not generated: hand-written methods win.
 */
final class ResourceGenerator {

    static final String ROOT_PACKAGE = "io.github.icommapi.bizgo";
    static final String WEBHOOKS_PACKAGE = "io.github.icommapi.bizgo.webhooks";
    private static final String HEADER =
            "// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.\n"
                    + "// Regenerate with: ./gradlew generateModels\n";

    /** Resources with a hand-written class; the generated methods go into its generated superclass. */
    static final Map<String, String> HAND_WRITTEN = Map.of(
            "send", "SendService",
            "files", "FileService",
            "reports", "ReportService",
            "messages", "MessageService");

    private static final Set<String> HTTP_METHODS = Set.of("get", "post", "put", "delete", "patch");
    private static final Set<String> FORBIDDEN_HEADERS = Set.of(
            "authorization", "accept", "content-type", "content-length", "host", "user-agent", "connection",
            "x-bizgo-client");
    private static final Pattern PUBLIC_METHOD = Pattern.compile(
            "(?m)^\\s+public\\s+(?:static\\s+)?(?:final\\s+)?[\\w<>\\[\\], ?.]+\\s+(\\w+)\\s*\\(");
    private static final Set<String> SAFE_PARAM_VALUES = Set.of(
            "page", "rows", "count", "offset", "limit", "lastSeq", "senderKeyType", "status", "inspectionStatus",
            "templateType", "sendType", "target", "msgType", "serviceType", "startDate", "endDate", "date", "since");

    private final JsonNode spec;
    private final JsonNode schemas;
    private final Path handWritten;
    private final List<Op> ops = new ArrayList<>();
    private final Res root = new Res("");
    private final Map<String, String> tagDescriptions = new LinkedHashMap<>();

    ResourceGenerator(JsonNode spec, Path handWritten) {
        this.spec = spec;
        this.schemas = spec.path("components").path("schemas");
        this.handWritten = handWritten;
        spec.path("tags").forEach(t -> tagDescriptions.put(t.path("name").asText(), t.path("description").asText("")));
    }

    Map<String, String> generate() throws IOException {
        collect();
        Map<String, String> out = new TreeMap<>();
        out.put(path(ROOT_PACKAGE, "Operations"), renderOperations());
        out.put(path(ROOT_PACKAGE, "BizgoResources"), renderClientBase());
        for (Res res : allResources()) {
            if (res.path.isEmpty()) {
                continue;
            }
            Set<String> declared = declared(res);
            out.put(path(ROOT_PACKAGE, res.className()), renderResource(res, declared));
        }
        for (Op op : ops) {
            if (op.paramsClass != null && op.rendered) {
                out.put(path(ModelGenerator.PARAMS_PACKAGE, op.paramsClass), renderParams(op));
            }
        }
        out.put(path(WEBHOOKS_PACKAGE, "GeneratedWebhookReceiver"), renderWebhooks());
        return out;
    }

    private static String path(String pkg, String name) {
        return pkg.replace('.', '/') + "/" + name + ".java";
    }

    // ------------------------------------------------------------------ collection

    private void collect() {
        Set<String> ids = new LinkedHashSet<>();
        spec.path("paths").properties().forEach(pathEntry -> {
            String template = pathEntry.getKey();
            JsonNode item = pathEntry.getValue();
            item.properties().forEach(opEntry -> {
                if (!HTTP_METHODS.contains(opEntry.getKey())) {
                    return;
                }
                Op op = op(template, opEntry.getKey().toUpperCase(Locale.ROOT), item, opEntry.getValue());
                if (!ids.add(op.id)) {
                    throw new IllegalStateException("duplicate operationId " + op.id);
                }
                ops.add(op);
                resource(op.resource).ops.add(op);
            });
        });
        for (Res res : allResources()) {
            Set<String> names = new LinkedHashSet<>();
            for (Op op : res.ops) {
                if (!names.add(op.method)) {
                    throw new IllegalStateException("duplicate x-sdk-method " + op.resource + "." + op.method);
                }
            }
            for (String child : res.children.keySet()) {
                if (names.contains(child)) {
                    throw new IllegalStateException("method and sub-resource share a name: " + res.path + "." + child);
                }
            }
        }
    }

    private Res resource(String path) {
        Res current = root;
        StringBuilder full = new StringBuilder();
        for (String part : path.split("\\.")) {
            if (full.length() > 0) {
                full.append('.');
            }
            full.append(part);
            String name = full.toString();
            current = current.children.computeIfAbsent(part, k -> new Res(name));
        }
        return current;
    }

    private List<Res> allResources() {
        List<Res> list = new ArrayList<>();
        collectResources(root, list);
        return list;
    }

    private static void collectResources(Res res, List<Res> out) {
        out.add(res);
        res.children.values().forEach(child -> collectResources(child, out));
    }

    private Op op(String template, String httpMethod, JsonNode item, JsonNode node) {
        Op op = new Op();
        op.id = required(node, "operationId", template);
        op.resource = required(node, "x-sdk-resource", op.id);
        op.method = required(node, "x-sdk-method", op.id);
        op.retry = required(node, "x-sdk-retry", op.id);
        if (!op.retry.equals("safe") && !op.retry.equals("rate_limit_only")) {
            throw new IllegalStateException("unknown x-sdk-retry for " + op.id + ": " + op.retry);
        }
        op.httpMethod = httpMethod;
        op.template = template;
        op.summary = node.path("summary").asText("");
        op.description = node.path("description").asText("");
        op.tag = node.path("tags").path(0).asText("");
        op.resultPath = node.path("x-sdk-result").asText("data.data");
        op.pagination = node.get("x-sdk-pagination");
        // SDK-DESIGN 11.5: only x-sdk-rate: send selects the send bucket (cost = recipients); nothing hard-coded
        String rate = node.path("x-sdk-rate").asText("");
        if (!rate.isEmpty() && !rate.equals("send")) {
            throw new IllegalStateException("unknown x-sdk-rate for " + op.id + ": " + rate);
        }
        op.sendBucket = rate.equals("send");
        List<JsonNode> params = new ArrayList<>();
        item.path("parameters").forEach(params::add);
        node.path("parameters").forEach(params::add);
        Map<String, Param> byName = new LinkedHashMap<>();
        for (JsonNode raw : params) {
            JsonNode p = deref(raw);
            Param param = new Param();
            param.name = p.path("name").asText();
            param.in = p.path("in").asText();
            param.required = p.path("required").asBoolean(false) || param.in.equals("path");
            param.description = p.path("description").asText("");
            param.schema = p.path("schema");
            param.javaType = paramType(param.schema, op.id + "." + param.name);
            param.java = ModelGenerator.JAVA_KEYWORDS.contains(param.name) ? param.name + "_" : param.name;
            if (param.in.equals("header") && FORBIDDEN_HEADERS.contains(param.name.toLowerCase(Locale.ROOT))) {
                throw new IllegalStateException("header parameter not allowed: " + op.id + "." + param.name);
            }
            byName.put(param.in + ":" + param.name, param);
        }
        Matcher m = Pattern.compile("\\{([^}]+)}").matcher(template);
        while (m.find()) {
            Param p = byName.get("path:" + m.group(1));
            if (p == null) {
                throw new IllegalStateException("path parameter without definition: " + op.id + " " + m.group(1));
            }
            op.pathParams.add(p);
        }
        for (Param p : byName.values()) {
            if (p.in.equals("query") || p.in.equals("header")) {
                op.queryParams.add(p);
            } else if (!p.in.equals("path")) {
                throw new IllegalStateException("unsupported parameter location " + p.in + " in " + op.id);
            }
        }
        if (!op.queryParams.isEmpty()) {
            op.paramsClass = ModelGenerator.capitalize(op.id) + "Params";
        }
        node.path("requestBody").path("content").properties().forEach(content -> {
            String name = refName(content.getValue().path("schema"));
            if (content.getKey().equals("application/json")) {
                op.jsonBody = name;
            } else if (content.getKey().equals("multipart/form-data")) {
                JsonNode schema = schemas.path(name);
                if (ModelGenerator.isSimpleUpload(schema)) {
                    op.simpleUpload = true;
                    JsonNode max = schema.path("properties").path("file").path("x-max-bytes");
                    op.maxFileBytes = max.isNumber() ? max.asLong() : null;
                } else {
                    op.multipartBody = name;
                    op.multipartEncoding = content.getValue().path("encoding");
                }
            } else {
                throw new IllegalStateException("unsupported request content " + content.getKey() + " in " + op.id);
            }
        });
        JsonNode response = null;
        for (Map.Entry<String, JsonNode> r : node.path("responses").properties()) {
            if (r.getKey().startsWith("2")) {
                response = deref(r.getValue()).path("content").path("application/json").path("schema");
                break;
            }
        }
        op.responseSchema = response == null || !response.has("$ref") ? null : refName(response);
        if (op.responseSchema != null) {
            op.result = walk(op.responseSchema, op.resultPath);
            if (op.result == null && !op.responseSchema.equals("ApiResponse")) {
                throw new IllegalStateException("x-sdk-result path not found: " + op.id + " " + op.resultPath);
            }
        }
        if (op.pagination != null) {
            String style = op.pagination.path("style").asText();
            op.paginationStyle = style;
            TypeRef items = walk(op.responseSchema, stripIndex(op.pagination.path("items").asText()));
            if (items == null || !items.list) {
                throw new IllegalStateException("x-sdk-pagination items is not a list: " + op.id);
            }
            op.itemType = items.item;
            op.pageParam = findParam(op, op.pagination.path("request").asText());
            if (!style.equals("cursor")) {
                String size = op.pagination.path("size").asText("");
                op.sizeParam = size.isEmpty() ? null : findParam(op, size);
            }
            if (!Set.of("cursor", "page", "offset").contains(style)) {
                throw new IllegalStateException("unknown pagination style " + style + " in " + op.id);
            }
        }
        return op;
    }

    private static Param findParam(Op op, String name) {
        for (Param p : op.queryParams) {
            if (p.name.equals(name)) {
                return p;
            }
        }
        throw new IllegalStateException("pagination parameter " + name + " is not a query parameter of " + op.id);
    }

    private static String stripIndex(String path) {
        return path.replaceAll("\\[-?\\d+]", "");
    }

    private static String required(JsonNode node, String field, String where) {
        JsonNode value = node.get(field);
        if (value == null || value.asText().isEmpty()) {
            throw new IllegalStateException(field + " is missing in " + where);
        }
        return value.asText();
    }

    private JsonNode deref(JsonNode node) {
        JsonNode current = node;
        int guard = 0;
        while (current.has("$ref") && guard++ < 10) {
            JsonNode target = spec;
            for (String part : current.get("$ref").asText().replaceFirst("^#/", "").split("/")) {
                target = target.path(part.replace("~1", "/").replace("~0", "~"));
            }
            current = target;
        }
        return current;
    }

    private static String refName(JsonNode node) {
        String ref = node.path("$ref").asText();
        return ref.substring(ref.lastIndexOf('/') + 1);
    }

    private static String paramType(JsonNode schema, String where) {
        String type = primaryType(schema);
        switch (type) {
            case "string":
                return "String";
            case "boolean":
                return "Boolean";
            case "integer":
                return "int64".equals(schema.path("format").asText()) ? "Long" : "Integer";
            case "number":
                return "Double";
            case "array":
                if (!"string".equals(primaryType(schema.path("items")))) {
                    throw new IllegalStateException("unsupported array parameter " + where);
                }
                return "List<String>";
            default:
                throw new IllegalStateException("unsupported parameter type " + type + " for " + where);
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

    // ------------------------------------------------------------------ type walking (same naming as ModelGenerator)

    /** Resolves a dotted path through a response schema to the Java type the models use. */
    private TypeRef walk(String rootSchema, String dotted) {
        String className = rootSchema;
        JsonNode schema = schemas.path(rootSchema);
        String[] parts = dotted.split("\\.");
        for (int i = 0; i < parts.length; i++) {
            Map<String, JsonNode> props = new LinkedHashMap<>();
            merge(schema, props);
            JsonNode child = props.get(parts[i]);
            if (child == null) {
                return null;
            }
            boolean last = i == parts.length - 1;
            String ref = directRef(child);
            if (ref != null) {
                if (last) {
                    return new TypeRef(ref, false, null);
                }
                className = ref;
                schema = schemas.path(ref);
                continue;
            }
            String type = primaryType(child);
            if (type.equals("array")) {
                JsonNode items = child.path("items");
                String itemRef = directRef(items);
                String item;
                if (itemRef != null) {
                    item = itemRef;
                } else if (primaryType(items).equals("object") && items.has("properties")) {
                    item = className + ModelGenerator.capitalize(parts[i]);
                } else {
                    item = scalar(primaryType(items));
                }
                if (!last) {
                    return null;
                }
                return new TypeRef("List<" + item + ">", true, item);
            }
            if (type.equals("object") && child.has("properties")) {
                className = className + ModelGenerator.capitalize(parts[i]);
                schema = child;
                if (last) {
                    return new TypeRef(className, false, null);
                }
                continue;
            }
            return last ? new TypeRef(scalar(type), false, null) : null;
        }
        return null;
    }

    private static String scalar(String type) {
        switch (type) {
            case "boolean":
                return "Boolean";
            case "integer":
                return "Long";
            case "number":
                return "Double";
            default:
                return "String";
        }
    }

    private static String directRef(JsonNode node) {
        if (node.has("$ref")) {
            return refName(node);
        }
        JsonNode allOf = node.path("allOf");
        if (allOf.isArray() && allOf.size() == 1 && allOf.get(0).has("$ref")) {
            return refName(allOf.get(0));
        }
        return null;
    }

    /** Whether the request body schema has both {@code idempotencyKey} and {@code idempotencyTtl}. */
    private boolean hasIdempotencyFields(String schemaName) {
        Map<String, JsonNode> props = new LinkedHashMap<>();
        merge(schemas.path(schemaName), props);
        return props.containsKey("idempotencyKey") && props.containsKey("idempotencyTtl");
    }

    private void merge(JsonNode schema, Map<String, JsonNode> props) {
        for (JsonNode part : schema.path("allOf")) {
            merge(part.has("$ref") ? schemas.path(refName(part)) : part, props);
        }
        schema.path("properties").properties().forEach(e -> props.put(e.getKey(), e.getValue()));
    }

    // ------------------------------------------------------------------ hand-written detection

    private Set<String> declared(Res res) throws IOException {
        String cls = HAND_WRITTEN.get(res.path);
        if (cls == null) {
            return Set.of();
        }
        return declaredIn(handWritten.resolve(ROOT_PACKAGE.replace('.', '/')).resolve(cls + ".java"));
    }

    private static Set<String> declaredIn(Path file) throws IOException {
        Set<String> names = new TreeSet<>();
        if (!Files.exists(file)) {
            return names;
        }
        Matcher m = PUBLIC_METHOD.matcher(Files.readString(file, StandardCharsets.UTF_8));
        while (m.find()) {
            names.add(m.group(1));
        }
        return names;
    }

    // ------------------------------------------------------------------ Operations

    private String renderOperations() {
        StringBuilder s = new StringBuilder(HEADER);
        s.append("package ").append(ROOT_PACKAGE).append(";\n\n");
        s.append("import java.util.List;\n\n");
        s.append("/** Every operation of the spec with its {@code x-sdk-*} metadata. */\n");
        s.append("final class Operations {\n\n");
        List<String> names = new ArrayList<>();
        for (Op op : ops) {
            String name = constant(op.id);
            names.add(name);
            s.append("    static final Operation ").append(name).append(" = new Operation(")
                    .append(q(op.id)).append(", ").append(q(op.resource)).append(", ").append(q(op.method))
                    .append(",\n            ").append(q(op.httpMethod)).append(", ").append(q(op.template))
                    .append(",\n            ").append(op.retry.equals("safe") ? "Retry.SAFE" : "Retry.RATE_LIMIT_ONLY")
                    .append(", ").append(op.sendBucket ? "Operation.RateBucket.SEND" : "Operation.RateBucket.OTHER")
                    .append(", ").append(op.paginationStyle == null ? "null" : q(op.paginationStyle))
                    .append(", ").append(q(op.resultPath)).append(");\n");
        }
        s.append("\n    /** All operations in spec order. */\n    static final List<Operation> ALL = List.of(\n            ")
                .append(String.join(",\n            ", names)).append(");\n\n");
        s.append("    private Operations() {\n    }\n}\n");
        return s.toString();
    }

    static String constant(String id) {
        return id.replaceAll("([a-z0-9])([A-Z])", "$1_$2").toUpperCase(Locale.ROOT);
    }

    // ------------------------------------------------------------------ client base

    private String renderClientBase() {
        StringBuilder s = new StringBuilder(HEADER);
        s.append("package ").append(ROOT_PACKAGE).append(";\n\n");
        s.append("/**\n * Accessors of the resources generated from the spec. {@link Bizgo} extends this class; use it through\n")
                .append(" * a {@link Bizgo} instance.\n */\n");
        s.append("public abstract class BizgoResources {\n\n");
        List<Res> top = root.children.values().stream().filter(r -> !HAND_WRITTEN.containsKey(r.path))
                .collect(Collectors.toList());
        for (Res res : top) {
            s.append("    private final ").append(res.className()).append(' ').append(res.name()).append(";\n");
        }
        s.append("\n    BizgoResources(Transport transport) {\n");
        for (Res res : top) {
            s.append("        this.").append(res.name()).append(" = new ").append(res.className()).append("(transport);\n");
        }
        s.append("    }\n");
        for (Res res : top) {
            s.append("\n    /**\n     * ").append(resourceDoc(res)).append("\n     *\n     * @return the {@code ")
                    .append(res.path).append("} resource\n     */\n");
            s.append("    public ").append(res.className()).append(' ').append(res.name()).append("() {\n        return ")
                    .append(res.name()).append(";\n    }\n");
        }
        s.append("}\n");
        return s.toString();
    }

    private String resourceDoc(Res res) {
        String tag = firstTag(res);
        String description = tag == null ? "" : tagDescriptions.getOrDefault(tag, "");
        return (description.isEmpty() ? "Resource" : ModelGenerator.inline(description)) + ": {@code client."
                + res.path.replace(".", "().") + "()}.";
    }

    private static String firstTag(Res res) {
        if (!res.ops.isEmpty()) {
            return res.ops.get(0).tag;
        }
        for (Res child : res.children.values()) {
            String tag = firstTag(child);
            if (tag != null) {
                return tag;
            }
        }
        return null;
    }

    // ------------------------------------------------------------------ resources

    private String renderResource(Res res, Set<String> declared) {
        boolean base = HAND_WRITTEN.containsKey(res.path);
        String cls = res.className();
        Set<String> imports = new TreeSet<>();
        StringBuilder body = new StringBuilder();
        for (Res child : res.children.values()) {
            body.append("\n    /**\n     * ").append(resourceDoc(child)).append("\n     *\n     * @return the {@code ")
                    .append(child.path).append("} resource\n     */\n");
            body.append("    public ").append(child.className()).append(' ').append(child.name())
                    .append("() {\n        return ").append(child.name()).append(";\n    }\n");
        }
        for (Op op : res.ops) {
            renderOperation(body, op, declared, imports);
        }
        StringBuilder s = new StringBuilder(HEADER);
        s.append("package ").append(ROOT_PACKAGE).append(";\n\n");
        for (String imp : imports) {
            s.append("import ").append(imp).append(";\n");
        }
        if (!imports.isEmpty()) {
            s.append("\n");
        }
        s.append("/**\n * ").append(resourceDoc(res)).append("\n *\n");
        if (base) {
            s.append(" * <p>Methods generated from the spec for {@link ").append(HAND_WRITTEN.get(res.path))
                    .append("}; the hand-written class adds the\n * convenience methods (and wins on name clashes).\n */\n");
            s.append("public abstract class ").append(cls).append(" {\n\n");
        } else {
            s.append(" * <p>Generated from the spec ({@code x-sdk-resource: ").append(res.path).append("}).\n */\n");
            s.append("public final class ").append(cls).append(" {\n\n");
        }
        s.append("    private final Transport transport;\n");
        for (Res child : res.children.values()) {
            s.append("    private final ").append(child.className()).append(' ').append(child.name()).append(";\n");
        }
        s.append("\n    ").append(cls).append("(Transport transport) {\n        this.transport = transport;\n");
        for (Res child : res.children.values()) {
            s.append("        this.").append(child.name()).append(" = new ").append(child.className())
                    .append("(transport);\n");
        }
        s.append("    }\n");
        s.append(body);
        if (!base) {
            s.append("\n    @Override\n    public String toString() {\n        return ").append(q(cls)).append(";\n    }\n");
        }
        s.append("}\n");
        return s.toString();
    }

    private void renderOperation(StringBuilder s, Op op, Set<String> declared, Set<String> target) {
        Set<String> imports = new TreeSet<>();
        boolean generateMain = !declared.contains(op.method);
        String returnType = returnType(op);
        if (op.result != null && op.result.item != null && isModel(op.result.item)) {
            imports.add(ModelGenerator.MODELS_PACKAGE + "." + op.result.item);
        } else if (op.result != null && isModel(op.result.type)) {
            imports.add(ModelGenerator.MODELS_PACKAGE + "." + op.result.type);
        }
        if (returnType.startsWith("List<")) {
            imports.add("java.util.List");
        }
        if (op.paramsClass != null) {
            imports.add(ModelGenerator.PARAMS_PACKAGE + "." + op.paramsClass);
        }
        boolean paramsRequired = op.queryParams.stream().anyMatch(p -> p.required);
        List<String[]> bodyArgs = new ArrayList<>(); // {type, name}
        if (op.jsonBody != null) {
            imports.add(ModelGenerator.MODELS_PACKAGE + "." + op.jsonBody);
            bodyArgs.add(new String[] {op.jsonBody, "request", "json"});
        }
        if (op.multipartBody != null) {
            imports.add(ModelGenerator.MODELS_PACKAGE + "." + op.multipartBody);
            bodyArgs.add(new String[] {op.multipartBody, "request", "multipart"});
        }
        if (op.simpleUpload) {
            bodyArgs.add(new String[] {"FileUpload", "file", "upload"});
        }
        if (bodyArgs.isEmpty()) {
            bodyArgs.add(null);
        }
        op.rendered = generateMain;
        if (generateMain) {
            for (String[] bodyArg : bodyArgs) {
                renderCall(s, op, returnType, bodyArg, true);
                if (op.paramsClass != null && !paramsRequired) {
                    renderCall(s, op, returnType, bodyArg, false);
                }
                if (bodyArg != null && bodyArg[2].equals("upload")) {
                    imports.add("java.nio.file.Path");
                    renderPathUpload(s, op, returnType);
                }
            }
        }
        if (op.pagination != null) {
            String iter = "iter" + ModelGenerator.capitalize(op.method);
            String stream = "stream" + ModelGenerator.capitalize(op.method);
            if (isModel(op.itemType)) {
                imports.add(ModelGenerator.MODELS_PACKAGE + "." + op.itemType);
            }
            op.rendered |= !declared.contains(iter) || !declared.contains(stream);
            if (!declared.contains(iter)) {
                renderIterator(s, op, iter, true);
                if (op.paramsClass != null && !paramsRequired) {
                    renderIterator(s, op, iter, false);
                }
            }
            if (!declared.contains(stream)) {
                imports.add("java.util.stream.Stream");
                imports.add("java.util.stream.StreamSupport");
                renderStream(s, op, iter, stream, true);
                if (op.paramsClass != null && !paramsRequired) {
                    renderStream(s, op, iter, stream, false);
                }
            }
        }
        if (op.rendered) {
            target.addAll(imports);
        }
    }

    private boolean isModel(String type) {
        return type != null && schemas.has(type);
    }

    private static String returnType(Op op) {
        if (op.result == null) {
            return "void";
        }
        return op.result.type;
    }

    private void renderCall(StringBuilder s, Op op, String returnType, String[] bodyArg, boolean withParams) {
        List<String> args = new ArrayList<>();
        List<String> docs = new ArrayList<>();
        for (Param p : op.pathParams) {
            args.add("String " + p.java);
            docs.add("@param " + p.java + " " + paramDoc(p));
        }
        if (bodyArg != null) {
            args.add(bodyArg[0] + " " + bodyArg[1]);
            docs.add("@param " + bodyArg[1] + (bodyArg[2].equals("upload")
                    ? " file to upload (read once, reused on retries)"
                    : " request body (validated when built)"));
        }
        boolean params = withParams && op.paramsClass != null;
        if (params) {
            args.add(op.paramsClass + " params");
            docs.add("@param params query" + (op.queryParams.stream().anyMatch(p -> p.in.equals("header"))
                    ? " and header" : "") + " parameters");
        }
        if (!returnType.equals("void")) {
            docs.add("@return " + returnDoc(op));
        }
        s.append("\n").append(methodDoc(op, docs, !withParams && op.paramsClass != null));
        s.append("    public ").append(returnType).append(' ').append(op.method).append('(')
                .append(String.join(", ", args)).append(") {\n");
        if (!withParams && op.paramsClass != null) {
            List<String> forward = new ArrayList<>();
            op.pathParams.forEach(p -> forward.add(p.java));
            if (bodyArg != null) {
                forward.add(bodyArg[1]);
            }
            forward.add(op.paramsClass + ".builder().build()");
            s.append("        ").append(returnType.equals("void") ? "" : "return ").append(op.method).append('(')
                    .append(String.join(", ", forward)).append(");\n    }\n");
            return;
        }
        if (bodyArg != null) {
            s.append("        Params.required(").append(q(bodyArg[1])).append(", ").append(bodyArg[1]).append(");\n");
        }
        if (params) {
            s.append("        Params.required(\"params\", params);\n");
        }
        String body = "null";
        if (bodyArg != null) {
            switch (bodyArg[2]) {
                case "json":
                    // Bizgo rejects idempotencyKey without idempotencyTtl (A309): such bodies get the SDK default TTL
                    body = hasIdempotencyFields(op.jsonBody) ? "Transport.Body.jsonWithDefaultTtl(request)"
                            : "Transport.Body.json(request)";
                    break;
                case "upload":
                    if (op.maxFileBytes != null) {
                        s.append("        FileUpload.checkMaxSize(file, ").append(op.maxFileBytes)
                                .append(", \"파일은 최대 ").append(op.maxFileBytes).append("byte입니다\");\n");
                    }
                    body = "Multipart.build(file)";
                    break;
                default:
                    s.append(multipartCode(op));
                    body = "form.build()";
            }
        }
        String call = "transport." + (returnType.equals("void") ? "empty" : op.result.list ? "list" : "object")
                + "(Operations." + constant(op.id) + ", " + pathExpr(op) + ", "
                + (params ? "params.toQuery(), params.toHeaders()" : "null, null") + ", " + body;
        if (returnType.equals("void")) {
            s.append("        ").append(call).append(");\n    }\n");
        } else {
            String type = op.result.list ? op.result.item : op.result.type;
            s.append("        return ").append(call).append(",\n                ").append(q(op.resultPath))
                    .append(", ").append(type).append(".class);\n    }\n");
        }
    }

    private void renderPathUpload(StringBuilder s, Op op, String returnType) {
        List<String> args = new ArrayList<>();
        List<String> forward = new ArrayList<>();
        List<String> docs = new ArrayList<>();
        for (Param p : op.pathParams) {
            args.add("String " + p.java);
            forward.add(p.java);
            docs.add("@param " + p.java + " " + paramDoc(p));
        }
        args.add("Path file");
        forward.add("FileUpload.of(file)");
        docs.add("@param file file to upload");
        if (!returnType.equals("void")) {
            docs.add("@return " + returnDoc(op));
        }
        s.append("\n").append(methodDoc(op, docs, false));
        s.append("    public ").append(returnType).append(' ').append(op.method).append('(')
                .append(String.join(", ", args)).append(") {\n        ")
                .append(returnType.equals("void") ? "" : "return ").append(op.method).append('(')
                .append(String.join(", ", forward)).append(");\n    }\n");
    }

    private String multipartCode(Op op) {
        StringBuilder s = new StringBuilder("        Multipart.Form form = Multipart.form();\n");
        JsonNode schema = schemas.path(op.multipartBody);
        Map<String, JsonNode> props = new LinkedHashMap<>();
        merge(schema, props);
        for (Map.Entry<String, JsonNode> e : props.entrySet()) {
            String name = e.getKey();
            JsonNode prop = e.getValue();
            String getter = "request.get" + ModelGenerator.capitalize(name) + "()";
            String type = primaryType(prop);
            boolean json = "application/json".equals(op.multipartEncoding.path(name).path("contentType").asText())
                    || directRef(prop) != null || (type.equals("object") && !prop.has("$ref"));
            if (type.equals("string") && "binary".equals(prop.path("format").asText())) {
                s.append("        form.file(").append(q(name)).append(", ").append(getter).append(");\n");
            } else if (type.equals("array") && "binary".equals(prop.path("items").path("format").asText())) {
                s.append("        form.files(").append(q(name)).append(", ").append(getter).append(");\n");
            } else if (json || type.equals("array")) {
                s.append("        form.json(").append(q(name)).append(", ").append(getter).append(");\n");
            } else {
                s.append("        form.text(").append(q(name)).append(", ").append(getter).append(");\n");
            }
        }
        return s.toString();
    }

    private void renderIterator(StringBuilder s, Op op, String iter, boolean withParams) {
        List<String> args = new ArrayList<>();
        List<String> docs = new ArrayList<>();
        List<String> forward = new ArrayList<>();
        for (Param p : op.pathParams) {
            args.add("String " + p.java);
            forward.add(p.java);
            docs.add("@param " + p.java + " " + paramDoc(p));
        }
        if (withParams && op.paramsClass != null) {
            args.add(op.paramsClass + " params");
            docs.add("@param params query parameters; the page parameter, if set, is the starting point");
        }
        docs.add("@return iterable that fetches pages lazily; each iteration starts over");
        s.append("\n    /**\n     * Every item of {@link #").append(op.method).append("}, following the ")
                .append(op.paginationStyle).append(" pagination across pages lazily.\n");
        s.append("     *\n     * <p>").append(paginationDoc(op)).append("\n     *\n");
        docs.forEach(d -> s.append("     * ").append(d).append("\n"));
        s.append("     */\n");
        s.append("    public Iterable<").append(op.itemType).append("> ").append(iter).append('(')
                .append(String.join(", ", args)).append(") {\n");
        if (!withParams && op.paramsClass != null) {
            forward.add(op.paramsClass + ".builder().build()");
            s.append("        return ").append(iter).append('(').append(String.join(", ", forward))
                    .append(");\n    }\n");
            return;
        }
        String paramsVar = op.paramsClass == null ? null : "params";
        if (paramsVar != null) {
            s.append("        Params.required(\"params\", params);\n");
        }
        s.append("        String path = ").append(pathExpr(op)).append(";\n");
        String op1 = "Operations." + constant(op.id);
        JsonNode pg = op.pagination;
        String items = q(pg.path("items").asText());
        String hasNext = pg.hasNonNull("hasNext") ? q(pg.path("hasNext").asText()) : "null";
        String getter = "params.get" + ModelGenerator.capitalize(op.pageParam.name) + "()";
        String setter = op.pageParam.java;
        if (op.paginationStyle.equals("cursor")) {
            String convert;
            switch (op.pageParam.javaType) {
                case "Long":
                    convert = "Paging.toLong(cursor)";
                    break;
                case "Integer":
                    convert = "Paging.toInt(cursor)";
                    break;
                default:
                    convert = "cursor";
            }
            s.append("        return Paging.cursor(").append(getter).append(" == null ? null : String.valueOf(")
                    .append(getter).append("),\n");
            s.append("                cursor -> transport.raw(").append(op1).append(", path,\n");
            s.append("                        params.toBuilder().").append(setter).append('(').append(convert)
                    .append(").build().toQuery(), params.toHeaders(), null, ").append(items).append(", ")
                    .append(op.itemType).append(".class),\n");
            s.append("                ").append(items).append(", ").append(q(pg.path("response").asText()))
                    .append(", ").append(hasNext).append(", ").append(op.itemType).append(".class);\n    }\n");
        } else {
            boolean offset = op.paginationStyle.equals("offset");
            JsonNode def = op.pageParam.schema.path("default");
            int start = def.isNumber() ? def.asInt() : offset ? 0 : 1;
            String size = op.sizeParam == null ? "null"
                    : "params.get" + ModelGenerator.capitalize(op.sizeParam.name) + "()";
            if (!op.pageParam.javaType.equals("Integer")
                    || (op.sizeParam != null && !op.sizeParam.javaType.equals("Integer"))) {
                throw new IllegalStateException("page/offset parameters must be integers: " + op.id);
            }
            String total = pg.hasNonNull("total") ? q(pg.path("total").asText()) : "null";
            s.append("        return Paging.numbered(").append(getter).append(" == null ? ").append(start)
                    .append(" : ").append(getter).append(", ").append(size).append(", ").append(offset)
                    .append(",\n");
            s.append("                n -> transport.raw(").append(op1).append(", path,\n");
            s.append("                        params.toBuilder().").append(setter)
                    .append("(n).build().toQuery(), params.toHeaders(), null, ").append(items).append(", ")
                    .append(op.itemType).append(".class),\n");
            s.append("                ").append(items).append(", ").append(total).append(", ").append(hasNext)
                    .append(", ").append(op.itemType).append(".class);\n    }\n");
        }
    }

    private void renderStream(StringBuilder s, Op op, String iter, String stream, boolean withParams) {
        List<String> args = new ArrayList<>();
        List<String> forward = new ArrayList<>();
        List<String> docs = new ArrayList<>();
        for (Param p : op.pathParams) {
            args.add("String " + p.java);
            forward.add(p.java);
            docs.add("@param " + p.java + " " + paramDoc(p));
        }
        if (withParams && op.paramsClass != null) {
            args.add(op.paramsClass + " params");
            forward.add("params");
            docs.add("@param params query parameters");
        }
        docs.add("@return lazy sequential stream");
        s.append("\n    /**\n     * {@link #").append(iter).append("} as a sequential stream.\n     *\n");
        docs.forEach(d -> s.append("     * ").append(d).append("\n"));
        s.append("     */\n");
        s.append("    public Stream<").append(op.itemType).append("> ").append(stream).append('(')
                .append(String.join(", ", args)).append(") {\n");
        s.append("        return StreamSupport.stream(").append(iter).append('(').append(String.join(", ", forward))
                .append(").spliterator(), false);\n    }\n");
    }

    private static String paginationDoc(Op op) {
        switch (op.paginationStyle) {
            case "cursor":
                return "Stops when {@code hasNext} is false, the cursor is missing, or it does not move.";
            case "page":
                return "Stops at an empty page, a page smaller than the requested size, or the total count"
                        + (op.pagination.hasNonNull("hasNext") ? ", or when {@code hasNext} is false." : ".");
            default:
                return "Advances the offset by the number of items received; stops at an empty page, a page"
                        + " smaller than the requested size, or the total count.";
        }
    }

    private static String pathExpr(Op op) {
        if (op.pathParams.isEmpty()) {
            return "Operations." + constant(op.id) + ".path()";
        }
        return "Operations." + constant(op.id) + ".path(" + op.pathParams.stream().map(p -> p.java)
                .collect(Collectors.joining(", ")) + ")";
    }

    private String methodDoc(Op op, List<String> tags, boolean noParamsOverload) {
        StringBuilder s = new StringBuilder("    /**\n");
        String summary = op.summary.isBlank() ? op.id : op.summary.strip();
        s.append("     * ").append(ModelGenerator.inline(summary)).append(summary.endsWith(".") ? "" : ".").append("\n");
        if (noParamsOverload) {
            s.append("     *\n     * <p>Same as the overload with parameters, with none set.\n");
        } else if (!op.description.isBlank()) {
            s.append("     *\n").append(ModelGenerator.javadoc("<p>" + op.description, "     * ")
                    .replace("<p>&lt;p&gt;", "<p>").replace("&lt;p&gt;", ""));
        }
        s.append("     *\n     * <p>{@code ").append(op.httpMethod).append(' ').append(ModelGenerator.escapeHtml(op.template))
                .append("} (operationId {@code ").append(op.id).append("}, retry {@code ").append(op.retry)
                .append("}, rate-limit bucket {@code ").append(op.sendBucket ? "send" : "other").append("}).\n");
        s.append("     *\n");
        tags.forEach(t -> s.append("     * ").append(t).append("\n"));
        s.append("     */\n");
        return s.toString();
    }

    private static String paramDoc(Param p) {
        String text = p.description.isBlank() ? p.name : p.description.strip().split("\n")[0];
        return ModelGenerator.inline(text) + " (required)";
    }

    private static String returnDoc(Op op) {
        if (op.result.list) {
            return "the items at {@code " + op.resultPath + "}, empty if none";
        }
        return "the response part at {@code " + op.resultPath + "} (an empty object if the server omits it)";
    }

    // ------------------------------------------------------------------ params

    private String renderParams(Op op) {
        String cls = op.paramsClass;
        List<Param> ps = op.queryParams;
        boolean lists = ps.stream().anyMatch(p -> p.javaType.startsWith("List"));
        StringBuilder s = new StringBuilder(HEADER);
        s.append("package ").append(ModelGenerator.PARAMS_PACKAGE).append(";\n\n");
        s.append("import io.github.icommapi.bizgo.errors.ValidationException;\n");
        s.append("import java.util.ArrayList;\n");
        if (lists) {
            s.append("import java.util.Arrays;\n");
        }
        s.append("import java.util.Collections;\nimport java.util.LinkedHashMap;\nimport java.util.List;\n")
                .append("import java.util.Map;\nimport java.util.Objects;\nimport java.util.StringJoiner;\n\n");
        s.append("/**\n * Query").append(ps.stream().anyMatch(p -> p.in.equals("header")) ? " and header" : "")
                .append(" parameters of {@code ").append(op.id).append("} ({@code ").append(op.httpMethod).append(' ')
                .append(ModelGenerator.escapeHtml(op.template)).append("}).\n *\n")
                .append(" * <p>Immutable; create with {@link #builder()}. Validated in {@link Builder#build()}. {@link #toString()}\n")
                .append(" * masks the values (phone numbers as {@code 010****0000}, keys and tokens completely).\n */\n");
        s.append("public final class ").append(cls).append(" {\n\n");
        for (Param p : ps) {
            s.append("    private final ").append(p.javaType).append(' ').append(p.java).append(";\n");
        }
        s.append("\n    private ").append(cls).append("(Builder builder) {\n");
        for (Param p : ps) {
            s.append("        this.").append(p.java).append(" = ").append(p.javaType.startsWith("List")
                    ? "builder." + p.java + " == null ? null : Collections.unmodifiableList(new ArrayList<>(builder."
                            + p.java + "))"
                    : "builder." + p.java).append(";\n");
        }
        s.append("    }\n\n");
        s.append("    /**\n     * Returns a new, empty builder.\n     *\n     * @return builder\n     */\n");
        s.append("    public static Builder builder() {\n        return new Builder();\n    }\n\n");
        s.append("    /**\n     * Returns a builder initialised with these values.\n     *\n     * @return builder\n     */\n");
        s.append("    public Builder toBuilder() {\n        Builder builder = new Builder();\n");
        for (Param p : ps) {
            s.append("        builder.").append(p.java).append(" = ").append(p.java).append(";\n");
        }
        s.append("        return builder;\n    }\n\n");
        for (Param p : ps) {
            s.append("    /**\n").append(paramJavadoc(p, "    ")).append("     *\n     * @return the value, or null\n     */\n");
            s.append("    public ").append(p.javaType).append(" get").append(ModelGenerator.capitalize(p.name))
                    .append("() {\n        return ").append(p.java).append(";\n    }\n\n");
        }
        s.append("    /**\n     * Query string values in spec order (lists joined with commas). The values can contain\n")
                .append("     * personal data: do not log them.\n     *\n     * @return unmodifiable map; unset parameters are left out\n     */\n");
        s.append("    public Map<String, String> toQuery() {\n        Map<String, String> query = new LinkedHashMap<>();\n");
        for (Param p : ps) {
            if (p.in.equals("query")) {
                s.append("        if (").append(p.java).append(" != null) {\n            query.put(").append(q(p.name))
                        .append(", ").append(stringify(p)).append(");\n        }\n");
            }
        }
        s.append("        return Collections.unmodifiableMap(query);\n    }\n\n");
        s.append("    /**\n     * Request header values. They can contain personal data: do not log them.\n     *\n")
                .append("     * @return unmodifiable map; unset headers are left out\n     */\n");
        s.append("    public Map<String, String> toHeaders() {\n");
        if (ps.stream().noneMatch(p -> p.in.equals("header"))) {
            s.append("        return Map.of();\n    }\n\n");
        } else {
            s.append("        Map<String, String> headers = new LinkedHashMap<>();\n");
            for (Param p : ps) {
                if (p.in.equals("header")) {
                    s.append("        if (").append(p.java).append(" != null) {\n            headers.put(").append(q(p.name))
                            .append(", ").append(stringify(p)).append(");\n        }\n");
                }
            }
            s.append("        return Collections.unmodifiableMap(headers);\n    }\n\n");
        }
        List<String> fields = ps.stream().map(p -> p.java).collect(Collectors.toList());
        s.append("    @Override\n    public boolean equals(Object o) {\n        if (this == o) {\n            return true;\n        }\n");
        s.append("        if (!(o instanceof ").append(cls).append(")) {\n            return false;\n        }\n");
        s.append("        ").append(cls).append(" other = (").append(cls).append(") o;\n        return ")
                .append(fields.stream().map(f -> "Objects.equals(" + f + ", other." + f + ")")
                        .collect(Collectors.joining("\n                && ")))
                .append(";\n    }\n\n");
        s.append("    @Override\n    public int hashCode() {\n        return Objects.hash(").append(String.join(", ", fields))
                .append(");\n    }\n\n");
        s.append("    /** Shows paging values and numbers; phone numbers are partly masked, other values hidden. */\n");
        s.append("    @Override\n    public String toString() {\n        StringJoiner joiner = new StringJoiner(\", \", \"")
                .append(cls).append("{\", \"}\");\n");
        for (Param p : ps) {
            boolean show = SAFE_PARAM_VALUES.contains(p.name) && p.in.equals("query");
            String m = ModelGenerator.MASKING;
            String value;
            if (show) {
                value = "=\" + " + p.java;
            } else if (p.javaType.startsWith("List")) {
                value = "=\" + " + m + ".count(" + p.java + ".size())";
            } else if (!p.javaType.equals("String")) {
                value = "=\" + " + p.java; // numbers and flags
            } else if (ModelGenerator.PHONE_FIELDS.contains(p.name)) {
                value = "=\" + " + m + ".phone(" + p.java + ")";
            } else if (ModelGenerator.isPerson("", p.name)) {
                value = "=\" + " + m + ".person(" + p.java + ")";
            } else {
                value = "=***\""; // keys, tokens, ids: nothing
            }
            s.append("        if (").append(p.java).append(" != null) {\n            joiner.add(\"").append(p.name)
                    .append(value).append(");\n        }\n");
        }
        s.append("        return joiner.toString();\n    }\n\n");
        // builder
        s.append("    /** Builder for {@link ").append(cls).append("}. */\n");
        s.append("    public static final class Builder {\n");
        for (Param p : ps) {
            s.append("        private ").append(p.javaType).append(' ').append(p.java).append(";\n");
        }
        s.append("\n        private Builder() {\n        }\n\n");
        for (Param p : ps) {
            s.append("        /**\n").append(paramJavadoc(p, "        ")).append("         *\n         * @param ")
                    .append(p.java).append(" the value (null clears it)\n         * @return this builder\n         */\n");
            s.append("        public Builder ").append(p.java).append('(').append(p.javaType).append(' ').append(p.java)
                    .append(") {\n            this.").append(p.java).append(" = ").append(p.java)
                    .append(";\n            return this;\n        }\n\n");
            if (p.javaType.startsWith("List")) {
                s.append("        /**\n         * Varargs form of {@link #").append(p.java).append("(List)}.\n         *\n")
                        .append("         * @param ").append(p.java).append(" values\n         * @return this builder\n         */\n");
                s.append("        public Builder ").append(p.java).append("(String... ").append(p.java)
                        .append(") {\n            this.").append(p.java).append(" = ").append(p.java)
                        .append(" == null ? null : Arrays.asList(").append(p.java).append(");\n            return this;\n        }\n\n");
            }
        }
        s.append("        /**\n         * Builds the parameters.\n         *\n         * @return immutable parameters\n")
                .append("         * @throws ValidationException if a required parameter is missing or a value is invalid\n")
                .append("         */\n");
        s.append("        public ").append(cls).append(" build() {\n");
        s.append("            List<ValidationException.Violation> violations = new ArrayList<>();\n");
        for (Param p : ps) {
            s.append(validation(cls, p));
        }
        s.append("            if (!violations.isEmpty()) {\n                throw new ValidationException(violations);\n")
                .append("            }\n            return new ").append(cls).append("(this);\n        }\n\n");
        s.append("        ").append(cls).append(" buildUnvalidated() {\n            return new ").append(cls)
                .append("(this);\n        }\n    }\n}\n");
        return s.toString();
    }

    private static String stringify(Param p) {
        if (p.javaType.startsWith("List")) {
            return "String.join(\",\", " + p.java + ")";
        }
        return p.javaType.equals("String") ? p.java : "String.valueOf(" + p.java + ")";
    }

    private static String validation(String cls, Param p) {
        StringBuilder s = new StringBuilder();
        String field = q(cls + "." + p.name);
        String v = p.java;
        String add = "                violations.add(new ValidationException.Violation(" + field + ", ";
        if (p.required) {
            s.append("            if (").append(v).append(" == null) {\n").append(add).append("\"필수 값입니다\"));\n            }\n");
        }
        JsonNode schema = p.schema;
        if (p.javaType.startsWith("List")) {
            s.append("            if (").append(v).append(" != null && ").append(v).append(".contains(null)) {\n")
                    .append(add).append("\"null 항목이 있습니다\"));\n            }\n");
            if (schema.has("minItems")) {
                s.append("            if (").append(v).append(" != null && ").append(v).append(".size() < ")
                        .append(schema.get("minItems").asInt()).append(") {\n").append(add).append("\"항목이 최소 ")
                        .append(schema.get("minItems").asInt()).append("개여야 합니다\"));\n            }\n");
            }
            if (schema.has("maxItems")) {
                s.append("            if (").append(v).append(" != null && ").append(v).append(".size() > ")
                        .append(schema.get("maxItems").asInt()).append(") {\n").append(add).append("\"항목은 최대 ")
                        .append(schema.get("maxItems").asInt()).append("개입니다\"));\n            }\n");
            }
        }
        if (schema.has("minimum") || schema.has("maximum")) {
            List<String> conds = new ArrayList<>();
            if (schema.has("minimum")) {
                conds.add(v + " < " + schema.get("minimum").asLong() + "L");
            }
            if (schema.has("maximum")) {
                conds.add(v + " > " + schema.get("maximum").asLong() + "L");
            }
            s.append("            if (").append(v).append(" != null && (").append(String.join(" || ", conds))
                    .append(")) {\n").append(add).append(q("허용 범위(" + schema.path("minimum").asText("") + "~"
                            + schema.path("maximum").asText("") + ")를 벗어났습니다")).append("));\n            }\n");
        }
        if (schema.has("maxLength")) {
            s.append("            if (").append(v).append(" != null && ").append(v).append(".codePointCount(0, ").append(v)
                    .append(".length()) > ").append(schema.get("maxLength").asInt()).append(") {\n").append(add)
                    .append(q("최대 " + schema.get("maxLength").asInt() + "자입니다")).append("));\n            }\n");
        }
        if (schema.has("enum")) {
            List<String> values = new ArrayList<>();
            schema.get("enum").forEach(e -> values.add(q(e.asText())));
            s.append("            if (").append(v).append(" != null && !List.of(").append(String.join(", ", values))
                    .append(").contains(").append(v).append(")) {\n").append(add)
                    .append(q("허용 값(" + values.stream().map(x -> x.substring(1, x.length() - 1))
                            .collect(Collectors.joining(", ")) + ")이 아닙니다")).append("));\n            }\n");
        }
        if (p.javaType.equals("String") || p.javaType.startsWith("List")) {
            // control characters could break the query string or, for headers, inject a header
            String expr = p.javaType.equals("String") ? v + ".chars()" : "String.join(\"\", " + v + ").chars()";
            s.append("            if (").append(v).append(" != null && ").append(expr)
                    .append(".anyMatch(c -> c < 0x20 || c == 0x7f)) {\n").append(add)
                    .append("\"제어 문자는 쓸 수 없습니다\"));\n            }\n");
        }
        if (p.in.equals("path") || (p.required && p.javaType.equals("String"))) {
            s.append("            if (").append(v).append(" != null && ").append(v).append(".isEmpty()) {\n").append(add)
                    .append("\"빈 값입니다\"));\n            }\n");
        }
        return s.toString();
    }

    private static String paramJavadoc(Param p, String indent) {
        StringBuilder s = new StringBuilder();
        String text = p.description.isBlank() ? "{@code " + p.name + "}." : p.description;
        s.append(ModelGenerator.javadoc(text, indent + " * "));
        List<String> notes = new ArrayList<>();
        notes.add(p.in.equals("header") ? "헤더 {@code " + p.name + "}" : "쿼리 {@code " + p.name + "}");
        if (p.required) {
            notes.add("필수");
        }
        JsonNode schema = p.schema;
        if (schema.has("enum")) {
            List<String> values = new ArrayList<>();
            schema.get("enum").forEach(e -> values.add("<code>" + ModelGenerator.escapeHtml(e.asText()) + "</code>"));
            notes.add("허용 값 " + String.join(", ", values));
        }
        if (schema.has("minimum") || schema.has("maximum")) {
            notes.add("범위 " + schema.path("minimum").asText("") + "~" + schema.path("maximum").asText(""));
        }
        if (schema.has("default")) {
            notes.add("서버 기본값 <code>" + ModelGenerator.escapeHtml(schema.get("default").asText()) + "</code>");
        }
        if (p.javaType.startsWith("List")) {
            notes.add("쉼표로 이어 보냅니다");
        }
        s.append(indent).append(" *\n").append(indent).append(" * <p>").append(String.join(" · ", notes)).append("\n");
        return s.toString();
    }

    // ------------------------------------------------------------------ webhooks

    private String renderWebhooks() throws IOException {
        Set<String> declared = declaredIn(handWritten.resolve(WEBHOOKS_PACKAGE.replace('.', '/'))
                .resolve("WebhookReceiver.java"));
        StringBuilder methods = new StringBuilder();
        Set<String> imports = new TreeSet<>();
        for (Map.Entry<String, JsonNode> entry : spec.path("webhooks").properties()) {
            for (Map.Entry<String, JsonNode> opEntry : entry.getValue().properties()) {
                if (!HTTP_METHODS.contains(opEntry.getKey())) {
                    continue;
                }
                JsonNode op = opEntry.getValue();
                String name = required(op, "x-sdk-webhook", entry.getKey());
                if (declared.contains(name)) {
                    continue;
                }
                String payload = refName(op.path("requestBody").path("content").path("application/json").path("schema"));
                imports.add(ModelGenerator.MODELS_PACKAGE + "." + payload);
                // A webhook that declares the signature headers is verified; one that does not (the counsel
                // webhooks) carries no signature, so its parser only parses.
                boolean signed = false;
                for (JsonNode raw : op.path("parameters")) {
                    JsonNode p = deref(raw);
                    if (p.path("in").asText().equals("header")
                            && p.path("name").asText().equalsIgnoreCase("X-IB-Signature")) {
                        signed = true;
                    }
                }
                String ack = refName(op.path("responses").path("200").path("content").path("application/json")
                        .path("schema"));
                String answer = ack.equals("CounselWebhookAck") ? "{@link Webhooks#counselAckJson()}"
                        : "{@link Webhooks#ackJson(String)}";
                String summary = op.path("summary").asText(name).strip();
                String title = ModelGenerator.inline(summary) + (summary.endsWith(".") ? "" : ".");
                String staticName = "parse" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
                methods.append("\n    /**\n     * ").append(title).append("\n     *\n");
                if (signed) {
                    methods.append("     * <p>Verifies {@code X-IB-Signature} (required by the spec), then parses the body.\n");
                } else {
                    methods.append("     * <p>This webhook carries no signature (signatures apply only to the report and MO webhooks),\n")
                            .append("     * so the headers are not checked and signature headers, if present, are ignored. The body\n")
                            .append("     * checks (size limit, nesting depth, types) still apply. No webhook secret is needed: see\n")
                            .append("     * {@link #").append(staticName).append("(byte[])}.\n");
                }
                methods.append("     *\n     * <p>{@code POST} to your webhook URL (operationId {@code ")
                        .append(op.path("operationId").asText()).append("}). Answer with ").append(answer)
                        .append(".\n     *\n     * @param headers request headers (names are case-insensitive)")
                        .append(signed ? "" : "; not used")
                        .append("\n     * @param body raw request body\n     * @return the payload\n")
                        .append("     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if ")
                        .append(signed ? "verification or parsing fails" : "parsing fails").append("\n")
                        .append("     */\n");
                methods.append("    public ").append(payload).append(' ').append(name)
                        .append("(Map<String, ?> headers, byte[] body) {\n        ")
                        .append(signed ? "verifySigned(headers);\n        return Webhooks.parse(body, " + payload + ".class);"
                                : "return " + staticName + "(body);")
                        .append("\n    }\n");
                if (!signed) {
                    methods.append("\n    /**\n     * ").append(title).append("\n     *\n")
                            .append("     * <p>Parses the body without a receiver or webhook secret, for example\n")
                            .append("     * {@code WebhookReceiver.").append(staticName).append("(rawBody)}. Same checks as\n")
                            .append("     * {@link #").append(name).append("(Map, byte[])}. Answer with ").append(answer)
                            .append(".\n     *\n     * @param body raw request body\n     * @return the payload\n")
                            .append("     * @throws io.github.icommapi.bizgo.errors.WebhookVerificationException if parsing fails\n")
                            .append("     */\n");
                    methods.append("    public static ").append(payload).append(' ').append(staticName)
                            .append("(byte[] body) {\n        return Webhooks.parse(body, ").append(payload)
                            .append(".class);\n    }\n");
                }
            }
        }
        StringBuilder s = new StringBuilder(HEADER);
        s.append("package ").append(WEBHOOKS_PACKAGE).append(";\n\n");
        imports.forEach(i -> s.append("import ").append(i).append(";\n"));
        s.append("import java.util.Map;\n\n");
        s.append("/**\n * Webhook parsers generated from the spec ({@code x-sdk-webhook}). {@link WebhookReceiver} extends this class\n")
                .append(" * and adds the hand-written ones ({@code report}, {@code mo}).\n */\n");
        s.append("public abstract class GeneratedWebhookReceiver {\n\n    GeneratedWebhookReceiver() {\n    }\n\n");
        s.append("    /** Verifies the signature headers; they must be present. */\n");
        s.append("    abstract void verifySigned(Map<String, ?> headers);\n");
        s.append(methods).append("}\n");
        return s.toString();
    }

    static String q(String s) {
        return ModelGenerator.quote(s);
    }

    // ------------------------------------------------------------------ model

    private static final class Res {
        final String path;
        final List<Op> ops = new ArrayList<>();
        final Map<String, Res> children = new LinkedHashMap<>();

        Res(String path) {
            this.path = path;
        }

        String name() {
            return path.substring(path.lastIndexOf('.') + 1);
        }

        String className() {
            String hand = HAND_WRITTEN.get(path);
            if (hand != null) {
                return "Generated" + hand;
            }
            StringBuilder s = new StringBuilder();
            for (String part : path.split("\\.")) {
                s.append(ModelGenerator.capitalize(part));
            }
            return s.append("Service").toString();
        }
    }

    private static final class Param {
        String name;
        String java;
        String in;
        boolean required;
        String description;
        JsonNode schema;
        String javaType;
    }

    private record TypeRef(String type, boolean list, String item) {
    }

    private static final class Op {
        String id;
        String resource;
        String method;
        String retry;
        String httpMethod;
        String template;
        String summary;
        String description;
        String tag;
        String resultPath;
        JsonNode pagination;
        String paginationStyle;
        boolean sendBucket;
        final List<Param> pathParams = new ArrayList<>();
        final List<Param> queryParams = new ArrayList<>();
        String paramsClass;
        String jsonBody;
        String multipartBody;
        JsonNode multipartEncoding;
        boolean simpleUpload;
        Long maxFileBytes;
        String responseSchema;
        TypeRef result;
        String itemType;
        Param pageParam;
        Param sizeParam;
        boolean rendered;
    }
}
