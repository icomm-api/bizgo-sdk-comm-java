package io.github.icommapi.bizgo;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.icommapi.bizgo.errors.ApiException;
import io.github.icommapi.bizgo.errors.AuthenticationException;
import io.github.icommapi.bizgo.errors.BadRequestException;
import io.github.icommapi.bizgo.errors.DuplicateRequestException;
import io.github.icommapi.bizgo.errors.ErrorLayer;
import io.github.icommapi.bizgo.errors.InternalServerException;
import io.github.icommapi.bizgo.errors.NotFoundException;
import io.github.icommapi.bizgo.errors.PermissionDeniedException;
import io.github.icommapi.bizgo.errors.RateLimitException;
import io.github.icommapi.bizgo.errors.ServiceCodes;
import java.time.Duration;
import java.util.Map;

/**
 * Picks the exception class. Gateway ({@code common.authCode}) and service ({@code data.code}) codes are looked up in
 * separate tables because the same code means different things: service {@code A401} is an invalid
 * {@code paymentCode}, not an authentication failure.
 */
final class ErrorMapper {

    enum Kind {
        BAD_REQUEST, AUTHENTICATION, PERMISSION_DENIED, NOT_FOUND, DUPLICATE, RATE_LIMIT, INTERNAL, GENERIC
    }

    private static final Map<String, Kind> GATEWAY_CODES = Map.of(
            "A400", Kind.BAD_REQUEST,
            "A401", Kind.AUTHENTICATION,
            "A403", Kind.PERMISSION_DENIED,
            "A404", Kind.NOT_FOUND);

    private static final Map<String, Kind> SERVICE_CODES = Map.of(
            "A001", Kind.AUTHENTICATION,
            "A002", Kind.AUTHENTICATION,
            "A100", Kind.AUTHENTICATION,
            "A110", Kind.PERMISSION_DENIED,
            "A111", Kind.PERMISSION_DENIED,
            "A020", Kind.RATE_LIMIT,
            "A301", Kind.DUPLICATE);

    private static final Map<Integer, Kind> STATUS = Map.of(
            400, Kind.BAD_REQUEST,
            401, Kind.AUTHENTICATION,
            403, Kind.PERMISSION_DENIED,
            404, Kind.NOT_FOUND,
            429, Kind.RATE_LIMIT);

    private ErrorMapper() {
    }

    static Kind kind(int httpStatus, String code, ErrorLayer layer) {
        Map<String, Kind> table = layer == ErrorLayer.GATEWAY ? GATEWAY_CODES : SERVICE_CODES;
        if (code != null && table.containsKey(code)) {
            return table.get(code);
        }
        int status = httpStatus;
        if (layer == ErrorLayer.SERVICE && httpStatus < 400) {
            // failures reported inside an HTTP 200: use the status documented for the code
            int documented = ServiceCodes.lookup(code).map(ServiceCodes.Code::httpStatus).orElse(0);
            if (documented != 0) {
                status = documented;
            }
        }
        if (STATUS.containsKey(status)) {
            return STATUS.get(status);
        }
        if (status >= 500) {
            return Kind.INTERNAL;
        }
        if (status >= 400) {
            return Kind.BAD_REQUEST;
        }
        return Kind.GENERIC;
    }

    static ApiException create(int httpStatus, String code, String message, ErrorLayer layer, String trackingId,
            JsonNode body, Duration retryAfter) {
        switch (kind(httpStatus, code, layer)) {
            case BAD_REQUEST:
                return new BadRequestException(message, httpStatus, code, layer, trackingId, body);
            case AUTHENTICATION:
                return new AuthenticationException(message, httpStatus, code, layer, trackingId, body);
            case PERMISSION_DENIED:
                return new PermissionDeniedException(message, httpStatus, code, layer, trackingId, body);
            case NOT_FOUND:
                return new NotFoundException(message, httpStatus, code, layer, trackingId, body);
            case DUPLICATE:
                return new DuplicateRequestException(message, httpStatus, code, layer, trackingId, body);
            case RATE_LIMIT:
                return new RateLimitException(message, httpStatus, code, layer, trackingId, body, retryAfter);
            case INTERNAL:
                return new InternalServerException(message, httpStatus, code, layer, trackingId, body);
            default:
                return new ApiException(message, httpStatus, code, layer, trackingId, body);
        }
    }
}
