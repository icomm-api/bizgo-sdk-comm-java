package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/** Path segments, dates and limits in the formats the API expects. */
final class Params {

    /** Korea Standard Time. */
    static final ZoneOffset KST = ZoneOffset.ofHours(9);

    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("uuuuMMdd");
    private static final DateTimeFormatter LOCAL_TIME = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
    private static final DateTimeFormatter OFFSET_TIME = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssxxx");

    private Params() {
    }

    /**
     * URL-encodes one path segment ({@code /} and {@code ?} included) so a value can never change the path.
     */
    static String segment(String name, String value) {
        if (value == null || value.isEmpty()) {
            throw new ValidationException(name, "빈 값은 경로에 쓸 수 없습니다");
        }
        if (value.equals(".") || value.equals("..")) {
            throw new ValidationException(name, "'.'과 '..'은 경로에 쓸 수 없습니다");
        }
        return Transport.encode(value);
    }

    /** {@code YYYYMMDD} (statistics). */
    static String date(LocalDate value) {
        return value == null ? null : DATE.format(value);
    }

    /** {@code yyyy-MM-dd'T'HH:mm:ss} in KST (send history {@code requestTime}). Local times are taken as KST. */
    static String kstLocal(LocalDateTime value) {
        return LOCAL_TIME.format(value);
    }

    static String kstLocal(OffsetDateTime value) {
        return LOCAL_TIME.format(value.withOffsetSameInstant(KST));
    }

    static String kstLocal(ZonedDateTime value) {
        return kstLocal(value.toOffsetDateTime());
    }

    static String kstLocal(Instant value) {
        return LOCAL_TIME.format(value.atOffset(KST));
    }

    /** {@code yyyy-MM-dd'T'HH:mm:ss+09:00} (MO history {@code occurredTime}). Local times are taken as KST. */
    static String withOffset(LocalDateTime value) {
        return OFFSET_TIME.format(value.atOffset(KST));
    }

    /** Keeps the offset of the value, like the Python SDK. */
    static String withOffset(OffsetDateTime value) {
        return OFFSET_TIME.format(value);
    }

    static String withOffset(ZonedDateTime value) {
        return OFFSET_TIME.format(value.toOffsetDateTime());
    }

    static String withOffset(Instant value) {
        return OFFSET_TIME.format(value.atOffset(KST));
    }

    static Integer limit(Integer limit) {
        if (limit != null && (limit < 1 || limit > 1000)) {
            throw new ValidationException("limit", "limit은 1~1000입니다");
        }
        return limit;
    }

    static <T> T required(String name, T value) {
        if (value == null) {
            throw new ValidationException(name, "필수 값입니다");
        }
        return value;
    }
}
