package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import io.github.icommapi.bizgo.errors.ValidationException;
import io.github.icommapi.bizgo.internal.Json;
import java.util.Map;

/**
 * Turns JSON or maps into validated request models. Jackson exception messages can quote input values, so they are
 * never exposed: only the field path and a reason are reported.
 */
final class RequestParser {

    private RequestParser() {
    }

    static <T> T parse(String json, Class<T> type) {
        if (json == null) {
            throw new ValidationException(type.getSimpleName(), "요청 본문이 null입니다");
        }
        try {
            return Json.readRequest(json, type);
        } catch (JsonProcessingException e) {
            throw translate(e, type);
        }
    }

    static <T> T parse(Map<String, ?> body, Class<T> type) {
        if (body == null) {
            throw new ValidationException(type.getSimpleName(), "요청 본문이 null입니다");
        }
        try {
            return Json.convertRequest(body, type);
        } catch (IllegalArgumentException e) {
            Throwable cause = e.getCause();
            if (cause instanceof JacksonException) {
                throw translate((JacksonException) cause, type);
            }
            ValidationException validation = find(e);
            if (validation != null) {
                throw validation;
            }
            throw new ValidationException(type.getSimpleName(), "요청 본문을 해석할 수 없습니다");
        }
    }

    static String toJson(Object model) {
        try {
            return Json.writeRequestString(model);
        } catch (JsonProcessingException e) {
            // cannot happen for the generated models; do not expose the message (it may quote values)
            throw new IllegalStateException("요청을 JSON으로 만들 수 없습니다");
        }
    }

    private static ValidationException translate(JacksonException e, Class<?> type) {
        ValidationException validation = find(e);
        String path = e instanceof JsonMappingException ? path((JsonMappingException) e) : "";
        if (validation != null) {
            return validation.withPath(path);
        }
        if (e instanceof UnrecognizedPropertyException) {
            String field = path.isEmpty() ? type.getSimpleName() : path;
            return new ValidationException(field, "알 수 없는 필드입니다");
        }
        if (e instanceof StreamReadException && !(e instanceof JsonMappingException)) {
            return new ValidationException(type.getSimpleName(), "JSON 형식이 아닙니다");
        }
        return new ValidationException(path.isEmpty() ? type.getSimpleName() : path, "값의 형식이 맞지 않습니다");
    }

    private static ValidationException find(Throwable e) {
        for (Throwable t = e; t != null; t = t.getCause()) {
            if (t instanceof ValidationException) {
                return (ValidationException) t;
            }
            if (t.getCause() == t) {
                break;
            }
        }
        return null;
    }

    private static String path(JsonMappingException e) {
        StringBuilder s = new StringBuilder();
        for (JsonMappingException.Reference ref : e.getPath()) {
            if (ref.getFieldName() != null) {
                if (s.length() > 0) {
                    s.append('.');
                }
                s.append(ref.getFieldName());
            } else if (ref.getIndex() >= 0) {
                s.append('[').append(ref.getIndex()).append(']');
            }
        }
        return s.toString();
    }
}
