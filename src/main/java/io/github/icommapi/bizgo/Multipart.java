package io.github.icommapi.bizgo;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.icommapi.bizgo.internal.Json;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

/** Builds a {@code multipart/form-data} body by hand (no extra dependency). */
final class Multipart {

    private static final SecureRandom RANDOM = new SecureRandom();

    private Multipart() {
    }

    /** {@code file} + optional {@code fileKey}/{@code imageName}: the image upload APIs. */
    static Transport.Body build(FileUpload file) {
        return form().file("file", file).text("fileKey", file.fileKey()).text("imageName", file.imageName()).build();
    }

    static Form form() {
        return new Form();
    }

    private record Part(String name, String filename, String contentType, byte[] content) {
    }

    /** A multipart body under construction. Null values are left out. */
    static final class Form {
        private final List<Part> parts = new ArrayList<>();

        private Form() {
        }

        Form text(String name, Object value) {
            if (value != null) {
                parts.add(new Part(name, null, null, String.valueOf(value).getBytes(StandardCharsets.UTF_8)));
            }
            return this;
        }

        Form file(String name, FileUpload file) {
            if (file != null) {
                parts.add(new Part(name, file.getFilename(), file.getContentType(), file.content()));
            }
            return this;
        }

        Form files(String name, List<FileUpload> files) {
            if (files != null) {
                files.forEach(f -> file(name, f));
            }
            return this;
        }

        Form json(String name, Object value) {
            if (value != null) {
                try {
                    parts.add(new Part(name, null, "application/json", Json.writeRequest(value)));
                } catch (JsonProcessingException e) {
                    throw new IllegalStateException("요청을 JSON으로 만들 수 없습니다");
                }
            }
            return this;
        }

        Transport.Body build() {
            String boundary;
            do {
                byte[] random = new byte[16];
                RANDOM.nextBytes(random);
                boundary = "bizgo-" + HexFormat.of().formatHex(random);
            } while (collides(boundary.getBytes(StandardCharsets.US_ASCII)));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            for (Part part : parts) {
                write(out, "--" + boundary + "\r\n");
                write(out, "Content-Disposition: form-data; name=\"" + quote(part.name()) + "\""
                        + (part.filename() == null ? "" : "; filename=\"" + quote(part.filename()) + "\"") + "\r\n");
                if (part.contentType() != null) {
                    write(out, "Content-Type: " + part.contentType() + "\r\n");
                }
                write(out, "\r\n");
                out.write(part.content(), 0, part.content().length);
                write(out, "\r\n");
            }
            write(out, "--" + boundary + "--\r\n");
            return new Transport.Body(out.toByteArray(), "multipart/form-data; boundary=" + boundary);
        }

        private boolean collides(byte[] boundary) {
            for (Part part : parts) {
                if (contains(part.content(), boundary)) {
                    return true;
                }
            }
            return false;
        }
    }

    /** Escapes a quoted header parameter (HTML form encoding rules), so a file name cannot inject headers. */
    static String quote(String value) {
        return value.replace("\"", "%22").replace("\r", "%0D").replace("\n", "%0A");
    }

    private static void write(ByteArrayOutputStream out, String text) {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        out.write(bytes, 0, bytes.length);
    }

    private static boolean contains(byte[] haystack, byte[] needle) {
        outer:
        for (int i = 0; i + needle.length <= haystack.length; i++) {
            for (int j = 0; j < needle.length; j++) {
                if (haystack[i + j] != needle[j]) {
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }
}
