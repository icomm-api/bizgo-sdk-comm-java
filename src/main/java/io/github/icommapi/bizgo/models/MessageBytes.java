package io.github.icommapi.bizgo.models;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/**
 * Counts message length the way carriers do.
 *
 * <p>SMS/LMS/MMS text limits ({@code x-max-bytes} with {@code x-charset: EUC-KR} in the spec) are counted in CP949
 * (MS949), a superset of EUC-KR that uses 2 bytes per Hangul syllable. Characters that CP949 cannot represent, such
 * as emoji, are rejected because carriers reject them.
 *
 * <p>If the JVM has no CP949 charset (a stripped-down runtime without the {@code jdk.charsets} module), a documented
 * approximation is used instead: ASCII 1 byte, other characters of the Basic Multilingual Plane 2 bytes, anything
 * outside it is rejected.
 *
 * <pre>{@code
 * int bytes = MessageBytes.euckr("[비즈고] 인증번호는 123456 입니다.");  // 34
 * boolean fitsSms = bytes <= 90;
 * }</pre>
 */
public final class MessageBytes {

    /** SMS text limit in bytes. */
    public static final int SMS_MAX_BYTES = 90;
    /** LMS/MMS text limit in bytes. */
    public static final int LMS_MAX_BYTES = 2000;

    private static final Charset CP949 = findCp949();

    private MessageBytes() {
    }

    private static Charset findCp949() {
        for (String name : new String[] {"x-windows-949", "MS949"}) {
            try {
                if (Charset.isSupported(name)) {
                    return Charset.forName(name);
                }
            } catch (IllegalArgumentException ignored) {
                // try the next alias
            }
        }
        return null;
    }

    /**
     * Length of {@code text} in EUC-KR (CP949) bytes.
     *
     * @param text message text
     * @return number of bytes
     * @throws ValidationException if the text contains a character that EUC-KR cannot represent (emoji, ...)
     */
    public static int euckr(String text) {
        try {
            return count(text, "EUC-KR");
        } catch (UnencodableException e) {
            throw new ValidationException("text", e.getMessage());
        }
    }

    static int count(String text, String charset) throws UnencodableException {
        if (charset == null || !"EUC-KR".equalsIgnoreCase(charset)) {
            return text.getBytes(StandardCharsets.UTF_8).length;
        }
        if (CP949 == null) {
            return approximate(text);
        }
        CharsetEncoder encoder = CP949.newEncoder()
                .onMalformedInput(CodingErrorAction.REPORT)
                .onUnmappableCharacter(CodingErrorAction.REPORT);
        try {
            return encoder.encode(CharBuffer.wrap(text)).remaining();
        } catch (CharacterCodingException e) {
            throw new UnencodableException(firstUnencodable(text));
        }
    }

    private static int approximate(String text) throws UnencodableException {
        int size = 0;
        int position = 0;
        for (int i = 0; i < text.length(); ) {
            int cp = text.codePointAt(i);
            if (cp > 0xFFFF || Character.isSurrogate((char) cp)) {
                throw new UnencodableException(position);
            }
            size += cp < 0x80 ? 1 : 2;
            i += Character.charCount(cp);
            position++;
        }
        return size;
    }

    private static int firstUnencodable(String text) {
        CharsetEncoder encoder = CP949.newEncoder();
        int position = 0;
        for (int i = 0; i < text.length(); ) {
            int cp = text.codePointAt(i);
            int next = i + Character.charCount(cp);
            if (!encoder.canEncode(text.subSequence(i, next))) {
                return position;
            }
            i = next;
            position++;
        }
        return -1;
    }

    /** A character cannot be represented in EUC-KR. The message has the position, not the character. */
    static final class UnencodableException extends Exception {

        private static final long serialVersionUID = 1L;

        UnencodableException(int position) {
            super("EUC-KR로 표현할 수 없는 문자가 있습니다" + (position >= 0 ? "(" + (position + 1) + "번째 글자)" : "")
                    + ". 이모지 등은 문자메시지에 쓸 수 없습니다");
        }
    }
}
