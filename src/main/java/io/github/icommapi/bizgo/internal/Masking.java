package io.github.icommapi.bizgo.internal;

/**
 * How the SDK prints personal data in {@code toString()} of models, parameter and option objects (SDK-DESIGN 12.11).
 * The values themselves (getters) are unchanged. Internal: not part of the public API.
 */
public final class Masking {

    private Masking() {
    }

    /**
     * Masks a phone number so that at least half of it is hidden: 11+ characters keep the first 3 and the last 4
     * ({@code 010****0000}); 8 to 10 keep the first 3 and the last 1 or 2 ({@code 158****4}); 7 or fewer are hidden
     * completely.
     *
     * @param value phone number
     * @return masked text
     */
    public static String phone(String value) {
        if (value == null) {
            return "null";
        }
        int n = value.length();
        if (n <= 7) {
            return "*".repeat(Math.max(n, 3));
        }
        int tail = n >= 11 ? 4 : n / 2 - 3; // 8, 9 -> 1; 10 -> 2
        return value.substring(0, 3) + "*".repeat(n - 3 - tail) + value.substring(n - tail);
    }

    /**
     * Shows only the length of a text value (message text, content), for example {@code ***(12자)}.
     *
     * @param value text
     * @return masked text
     */
    public static String length(String value) {
        return value == null ? "null" : "***(" + value.codePointCount(0, value.length()) + "자)";
    }

    /**
     * Masks a person's name, nickname or e-mail address: the first character stays, the rest is hidden
     * ({@code 홍**}, {@code u***@***}).
     *
     * @param value name or e-mail
     * @return masked text
     */
    public static String person(String value) {
        if (value == null) {
            return "null";
        }
        if (value.isEmpty()) {
            return "";
        }
        String first = new String(Character.toChars(value.codePointAt(0)));
        return value.indexOf('@') > 0 ? first + "***@***" : first + "**";
    }

    /**
     * A list of values: only the count, for example {@code [3개]}.
     *
     * @param size number of items
     * @return masked text
     */
    public static String count(int size) {
        return "[" + size + "개]";
    }
}
