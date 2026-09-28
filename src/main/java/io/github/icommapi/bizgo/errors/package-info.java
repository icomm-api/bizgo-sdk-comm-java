/**
 * Exceptions. All are unchecked and extend {@link io.github.icommapi.bizgo.errors.BizgoException}.
 *
 * <pre>
 * BizgoException
 * +-- ConfigurationException          missing API key, http base URL, ...
 * +-- ValidationException             the request is invalid; nothing was sent
 * +-- ApiConnectionException          network failure; a send may or may not have been accepted
 * |   +-- ApiTimeoutException
 * +-- ApiException                    Bizgo answered with a failure code
 * |   +-- BadRequestException         400
 * |   +-- AuthenticationException     401 / A401, A001, A002, A100
 * |   +-- PermissionDeniedException   403 / A403, A110, A111
 * |   +-- NotFoundException           404
 * |   +-- DuplicateRequestException   service A301 (same idempotencyKey)
 * |   +-- RateLimitException          429 / A020
 * |   +-- InternalServerException     5xx
 * +-- InvalidResponseException        the body is not the documented envelope
 * +-- WebhookVerificationException    webhook signature / timestamp check failed
 * </pre>
 */
package io.github.icommapi.bizgo.errors;
