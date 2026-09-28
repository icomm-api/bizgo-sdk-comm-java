package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.errors.ValidationException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;

/**
 * An image to upload. The content is read once, so retries resend the same bytes.
 *
 * <pre>{@code
 * FileUpload.of(Path.of("banner.jpg"))
 * FileUpload.of(bytes, "banner.jpg").imageName("spring-event")
 * }</pre>
 */
public final class FileUpload {

    static final String DEFAULT_FILENAME = "image.jpg";

    private static final Map<String, String> CONTENT_TYPES = Map.of(
            "jpg", "image/jpeg",
            "jpeg", "image/jpeg",
            "png", "image/png",
            "gif", "image/gif",
            "bmp", "image/bmp");

    private final byte[] content;
    private final String filename;
    private final String fileKey;
    private final String imageName;

    private FileUpload(byte[] content, String filename, String fileKey, String imageName) {
        this.content = content;
        this.filename = filename;
        this.fileKey = fileKey;
        this.imageName = imageName;
    }

    /**
     * Reads a file.
     *
     * @param path image file
     * @return the upload
     * @throws ValidationException if the file is missing, a directory or not readable (the message has the file
     *     name only, never the full path)
     */
    public static FileUpload of(Path path) {
        Params.required("file", path);
        Path name = path.getFileName();
        String filename = name == null ? DEFAULT_FILENAME : name.toString();
        if (Files.isDirectory(path)) {
            throw new ValidationException("file", "파일이 아니라 디렉터리입니다: " + filename);
        }
        try {
            return new FileUpload(Files.readAllBytes(path), filename, null, null);
        } catch (IOException | SecurityException e) {
            // file name only: the full path (user names, directories) is never put in messages, and the
            // IOException (whose message has the path) is not chained (SDK-DESIGN 12.18)
            throw new ValidationException("file", "파일을 읽을 수 없습니다(" + reason(e) + "): " + filename);
        }
    }

    private static String reason(Exception e) {
        if (e instanceof java.nio.file.NoSuchFileException) {
            return "없음";
        }
        if (e instanceof java.nio.file.AccessDeniedException || e instanceof SecurityException) {
            return "권한 없음";
        }
        return e.getClass().getSimpleName();
    }

    /**
     * Uses bytes you already have.
     *
     * @param content image bytes (copied)
     * @param filename file name; its extension decides the content type (null means {@code image.jpg})
     * @return the upload
     */
    public static FileUpload of(byte[] content, String filename) {
        Params.required("file", content);
        return new FileUpload(content.clone(), filename == null || filename.isBlank() ? DEFAULT_FILENAME : filename,
                null, null);
    }

    /**
     * Reads a stream to the end. The stream is not closed.
     *
     * @param content image stream
     * @param filename file name; its extension decides the content type (null means {@code image.jpg})
     * @return the upload
     * @throws ValidationException if the stream cannot be read
     */
    public static FileUpload of(InputStream content, String filename) {
        Params.required("file", content);
        try {
            return of(content.readAllBytes(), filename);
        } catch (IOException e) {
            throw new ValidationException("file", "이미지를 읽을 수 없습니다(" + e.getClass().getSimpleName() + ")");
        }
    }

    /**
     * Key that identifies the upload; the server creates one if you do not set it.
     *
     * @param fileKey key
     * @return a copy with the key set
     */
    public FileUpload fileKey(String fileKey) {
        return new FileUpload(content, filename, fileKey, imageName);
    }

    /**
     * Image name; the file name without the extension is used if you do not set it.
     *
     * @param imageName name
     * @return a copy with the name set
     */
    public FileUpload imageName(String imageName) {
        return new FileUpload(content, filename, fileKey, imageName);
    }

    /**
     * File name sent in the multipart body.
     *
     * @return file name
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Size in bytes.
     *
     * @return size
     */
    public int getSize() {
        return content.length;
    }

    /**
     * Content type derived from the file name ({@code image/jpeg}, {@code image/png}, ...).
     *
     * @return content type, {@code application/octet-stream} if unknown
     */
    public String getContentType() {
        int dot = filename.lastIndexOf('.');
        String ext = dot < 0 ? "" : filename.substring(dot + 1).toLowerCase(Locale.ROOT);
        return CONTENT_TYPES.getOrDefault(ext, "application/octet-stream");
    }

    byte[] content() {
        return content;
    }

    String fileKey() {
        return fileKey;
    }

    String imageName() {
        return imageName;
    }

    @Override
    public String toString() {
        return "FileUpload{filename=" + filename + ", size=" + content.length + "}";
    }

    static void checkMaxSize(FileUpload file, int maxBytes, String message) {
        if (file.getSize() > maxBytes) {
            throw new ValidationException("file", message);
        }
    }
}
