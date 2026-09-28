package io.github.icommapi.bizgo.errors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A request is invalid and was not sent: a required field is missing, a value is too long (SMS text is limited to
 * 90 bytes in EUC-KR), there are too many recipients, a field is unknown, and so on.
 *
 * <p>The message names the field and the reason only. It never contains the value, which can be a phone number.
 */
public class ValidationException extends BizgoException {

    private static final long serialVersionUID = 1L;

    /**
     * One problem.
     *
     * @param field field path, for example {@code SmsMessage.text} or {@code messageFlow[0].sms.text}
     * @param reason why the value is invalid
     */
    public record Violation(String field, String reason) implements java.io.Serializable {

        @Override
        public String toString() {
            return field.isEmpty() ? reason : field + ": " + reason;
        }
    }

    private final Violation[] violations;

    /**
     * Creates an exception with one problem.
     *
     * @param field field path
     * @param reason reason
     */
    public ValidationException(String field, String reason) {
        this(List.of(new Violation(field, reason)));
    }

    /**
     * Creates an exception.
     *
     * @param violations problems (at least one)
     */
    public ValidationException(List<Violation> violations) {
        super("요청 검증 실패: " + violations.stream().map(Violation::toString).collect(Collectors.joining("; ")));
        this.violations = violations.toArray(new Violation[0]);
    }

    /**
     * Every problem found.
     *
     * @return unmodifiable list
     */
    public List<Violation> getViolations() {
        return violations == null ? List.of() : List.of(violations);
    }

    /**
     * Returns a copy whose field paths start with {@code path} instead of the class name. Used when a nested object
     * fails while a whole request is parsed from JSON.
     *
     * @param path JSON path of the object, for example {@code messageFlow[0].sms}
     * @return new exception
     */
    public ValidationException withPath(String path) {
        if (path == null || path.isEmpty()) {
            return this;
        }
        List<Violation> moved = new ArrayList<>();
        for (Violation v : getViolations()) {
            String field = v.field();
            int dot = field.indexOf('.');
            String rest = dot < 0 ? "" : field.substring(dot);
            moved.add(new Violation(path + rest, v.reason()));
        }
        return new ValidationException(moved);
    }
}
