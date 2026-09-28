package io.github.icommapi.bizgo.models;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Collects validation problems of one object. Used by the generated {@code build()} methods.
 *
 * <p>Messages contain the field name and the reason only, never the value.
 */
final class ModelValidator {

    private final String type;
    private final List<ValidationException.Violation> violations = new ArrayList<>();

    ModelValidator(String type) {
        this.type = type;
    }

    private void add(String field, String reason) {
        violations.add(new ValidationException.Violation(field.isEmpty() ? type : type + "." + field, reason));
    }

    /** Adds a problem found by another check ({@link RequiredIf}). */
    void violation(String field, String reason) {
        add(field, reason);
    }

    void required(String field, Object value) {
        if (value == null) {
            add(field, "필수 필드입니다");
        }
    }

    void items(String field, List<?> list, int min, int max) {
        if (list == null) {
            return;
        }
        if (min >= 0 && list.size() < min) {
            add(field, "항목이 최소 " + min + "개여야 합니다(현재 " + list.size() + "개)");
        }
        if (max >= 0 && list.size() > max) {
            add(field, "항목은 최대 " + max + "개입니다(현재 " + list.size() + "개)");
        }
        if (list.contains(null)) {
            add(field, "null 항목이 있습니다");
        }
    }

    void mapValues(String field, Map<String, ?> map, boolean stringValues) {
        if (map == null) {
            return;
        }
        if (map.containsKey(null)) {
            add(field, "null 키가 있습니다");
        }
        if (stringValues && map.containsValue(null)) {
            add(field, "값이 null인 항목이 있습니다");
        }
    }

    void maxLength(String field, String value, int max) {
        if (value == null) {
            return;
        }
        int length = value.codePointCount(0, value.length());
        if (length > max) {
            add(field, "최대 " + max + "자인데 " + length + "자입니다");
        }
    }

    void maxBytes(String field, String value, int max, String charset) {
        if (value == null) {
            return;
        }
        int size;
        try {
            size = MessageBytes.count(value, charset);
        } catch (MessageBytes.UnencodableException e) {
            add(field, e.getMessage());
            return;
        }
        if (size > max) {
            add(field, "최대 " + max + "byte인데 " + size + "byte입니다");
        }
    }

    void range(String field, Number value, Long min, Long max) {
        if (value == null) {
            return;
        }
        long v = value.longValue();
        if ((min != null && v < min) || (max != null && v > max)) {
            add(field, "허용 범위(" + (min == null ? "" : min) + "~" + (max == null ? "" : max) + ")를 벗어났습니다");
        }
    }

    void oneOf(String field, String value, List<String> allowed) {
        if (value != null && !allowed.contains(value)) {
            add(field, "허용 값(" + String.join(", ", allowed) + ")이 아닙니다");
        }
    }

    void pattern(String field, String value, Pattern pattern) {
        if (value != null && !pattern.matcher(value).find()) {
            add(field, "형식이 맞지 않습니다(" + pattern.pattern() + ")");
        }
    }

    void exactlyOne(boolean ok, String reason) {
        if (!ok) {
            add("", reason);
        }
    }

    void check() {
        if (!violations.isEmpty()) {
            throw new ValidationException(violations);
        }
    }
}
