package io.github.icommapi.bizgo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * One API operation of the spec with its SDK metadata ({@code x-sdk-resource}, {@code x-sdk-method},
 * {@code x-sdk-retry}, {@code x-sdk-pagination}, {@code x-sdk-result}). Hooks receive it, and the testing module
 * uses it to match requests. It holds no request values.
 *
 * <pre>{@code
 * for (Operation op : Operation.all()) {
 *     System.out.println(op.getResourceMethod() + " " + op.getHttpMethod() + " " + op.getPathTemplate());
 * }
 * }</pre>
 */
public final class Operation {

    /** Which client-side rate-limit bucket a request uses (see {@link RateLimit}). */
    public enum RateBucket {
        /** Operations marked {@code x-sdk-rate: send}: cost = recipients (at least 1). */
        SEND,
        /** Every other API. */
        OTHER
    }

    private static final Pattern PLACEHOLDER = Pattern.compile("\\{([^}]+)}");

    private final String operationId;
    private final String resource;
    private final String method;
    private final String httpMethod;
    private final String pathTemplate;
    private final Retry retry;
    private final RateBucket rateBucket;
    private final String paginationStyle;
    private final String resultPath;
    private final List<String> pathParameters;
    private final Pattern pathPattern;

    Operation(String operationId, String resource, String method, String httpMethod, String pathTemplate, Retry retry,
            RateBucket rateBucket, String paginationStyle, String resultPath) {
        this.operationId = operationId;
        this.resource = resource;
        this.method = method;
        this.httpMethod = httpMethod;
        this.pathTemplate = pathTemplate;
        this.retry = retry;
        this.rateBucket = rateBucket;
        this.paginationStyle = paginationStyle;
        this.resultPath = resultPath;
        Matcher m = PLACEHOLDER.matcher(pathTemplate);
        java.util.ArrayList<String> names = new java.util.ArrayList<>();
        StringBuilder regex = new StringBuilder("^");
        int last = 0;
        while (m.find()) {
            names.add(m.group(1));
            regex.append(Pattern.quote(pathTemplate.substring(last, m.start()))).append("([^/]+)");
            last = m.end();
        }
        regex.append(Pattern.quote(pathTemplate.substring(last))).append('$');
        this.pathParameters = List.copyOf(names);
        this.pathPattern = Pattern.compile(regex.toString());
    }

    /**
     * Every operation of the spec, in spec order.
     *
     * @return unmodifiable list
     */
    public static List<Operation> all() {
        return Operations.ALL;
    }

    /**
     * Looks up an operation by its {@code operationId}.
     *
     * @param operationId for example {@code listAlimtalkTemplates}
     * @return the operation, or empty
     */
    public static Optional<Operation> find(String operationId) {
        return Operations.ALL.stream().filter(op -> op.operationId.equals(operationId)).findFirst();
    }

    /**
     * Finds the operation that a request method and a raw (still encoded) path belong to.
     *
     * @param httpMethod {@code GET}, {@code POST}, ...
     * @param rawPath request path without the query string
     * @return the operation, or empty; a template without parameters wins over one with parameters
     */
    public static Optional<Operation> match(String httpMethod, String rawPath) {
        Operation best = null;
        for (Operation op : Operations.ALL) {
            if (op.httpMethod.equalsIgnoreCase(httpMethod) && op.pathPattern.matcher(rawPath).matches()
                    && (best == null || op.pathParameters.size() < best.pathParameters.size())) {
                best = op;
            }
        }
        return Optional.ofNullable(best);
    }

    static Operation byTemplate(String httpMethod, String pathTemplate) {
        for (Operation op : Operations.ALL) {
            if (op.httpMethod.equals(httpMethod) && op.pathTemplate.equals(pathTemplate)) {
                return op;
            }
        }
        throw new IllegalStateException("no operation for " + httpMethod + " " + pathTemplate);
    }

    /** Expands the path template with URL-encoded path parameter values (in template order). */
    String path(String... values) {
        if (values.length != pathParameters.size()) {
            throw new IllegalArgumentException("expected " + pathParameters.size() + " path parameters");
        }
        if (values.length == 0) {
            return pathTemplate;
        }
        Matcher m = PLACEHOLDER.matcher(pathTemplate);
        StringBuilder out = new StringBuilder();
        int i = 0;
        while (m.find()) {
            m.appendReplacement(out, Matcher.quoteReplacement(Params.segment(m.group(1), values[i++])));
        }
        m.appendTail(out);
        return out.toString();
    }

    Retry retry() {
        return retry;
    }

    /**
     * {@code operationId}, for example {@code listAlimtalkTemplates}.
     *
     * @return operation id
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * {@code x-sdk-resource}, for example {@code alimtalk.templates}.
     *
     * @return dotted resource path
     */
    public String getResource() {
        return resource;
    }

    /**
     * {@code x-sdk-method}, for example {@code list}.
     *
     * @return method name within the resource
     */
    public String getMethod() {
        return method;
    }

    /**
     * {@code resource.method}, for example {@code alimtalk.templates.list}.
     *
     * @return resource and method
     */
    public String getResourceMethod() {
        return resource + "." + method;
    }

    /**
     * HTTP method in upper case.
     *
     * @return {@code GET}, {@code POST}, {@code PUT} or {@code DELETE}
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * Path template with placeholders, for example {@code /api/comm/v1/report/inquiry/{msgKey}}. It never contains
     * request values.
     *
     * @return path template
     */
    public String getPathTemplate() {
        return pathTemplate;
    }

    /**
     * Names of the path parameters in template order.
     *
     * @return unmodifiable list
     */
    public List<String> getPathParameters() {
        return pathParameters;
    }

    /**
     * {@code x-sdk-retry}: {@code safe} (429, 5xx and network errors are retried) or {@code rate_limit_only} (only
     * 429). A send with an {@code idempotencyKey} is retried as {@code safe}.
     *
     * @return retry policy name
     */
    public String getRetryPolicy() {
        return retry == Retry.SAFE ? "safe" : "rate_limit_only";
    }

    /**
     * Rate-limit bucket of this operation.
     *
     * @return bucket
     */
    public RateBucket getRateBucket() {
        return rateBucket;
    }

    /**
     * {@code x-sdk-pagination} style.
     *
     * @return {@code cursor}, {@code page} or {@code offset}; empty if the operation is not paginated
     */
    public Optional<String> getPaginationStyle() {
        return Optional.ofNullable(paginationStyle);
    }

    /**
     * {@code x-sdk-result}: the response part the SDK returns (default {@code data.data}).
     *
     * @return dotted path
     */
    public String getResultPath() {
        return resultPath;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Operation && ((Operation) o).operationId.equals(operationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId);
    }

    @Override
    public String toString() {
        return operationId + "(" + httpMethod + " " + pathTemplate + ")";
    }
}
