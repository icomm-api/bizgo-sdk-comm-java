package io.github.icommapi.bizgo;

/** Which failures may be retried for a request. */
enum Retry {
    /** Read-only or idempotent calls (queries, ack, sends with an idempotency key): 429, 5xx and network errors. */
    SAFE,
    /**
     * Calls that could create a duplicate (sends without an idempotency key, uploads): only 429, which the gateway
     * returns before the request is processed.
     */
    RATE_LIMIT_ONLY
}
