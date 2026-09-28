package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessageFileUploadResponse;
import io.github.icommapi.bizgo.models.BrandMessageFileUploadResult;
import io.github.icommapi.bizgo.models.BrandMessageFileUploadServiceResult;
import io.github.icommapi.bizgo.models.FileUploadResponse;
import io.github.icommapi.bizgo.models.FileUploadResult;
import io.github.icommapi.bizgo.models.FileUploadServiceResult;
import io.github.icommapi.bizgo.models.RcsFileUploadResponse;
import io.github.icommapi.bizgo.models.RcsFileUploadResult;
import io.github.icommapi.bizgo.models.RcsFileUploadServiceResult;
import java.nio.file.Path;

/**
 * Image uploads: {@code POST /api/comm/v1/file/*}. Access as {@code client.files()}. Uploads are retried only on
 * HTTP 429.
 */
public final class FileService extends GeneratedFileService {

    /** Maximum MMS image size (300 KB). */
    public static final int MMS_MAX_BYTES = 300 * 1024;

    private final Transport transport;

    FileService(Transport transport) {
        super(transport);
        this.transport = transport;
    }

    /**
     * Uploads an MMS image (jpg, at most 300 KB). Use {@link FileUploadResult#getFileKey()} in
     * {@code MmsMessage.fileKey} or {@code client.send().mms(...)}.
     *
     * @param file image file
     * @return file key and expiry
     */
    public FileUploadResult uploadMms(Path file) {
        return uploadMms(FileUpload.of(file));
    }

    /**
     * Uploads an MMS image. The size is checked before anything is sent.
     *
     * @param file image
     * @return file key and expiry
     * @throws io.github.icommapi.bizgo.errors.ValidationException if the image is larger than 300 KB
     */
    public FileUploadResult uploadMms(FileUpload file) {
        Params.required("file", file);
        FileUpload.checkMaxSize(file, MMS_MAX_BYTES, "MMS 이미지는 최대 300KB입니다(jpg, 권장 1,500×1,440px 이하).");
        FileUploadResponse response = transport.call(Operations.UPLOAD_MMS_FILE, Retry.RATE_LIMIT_ONLY, Operations.UPLOAD_MMS_FILE.path(), null,
                Multipart.build(file), FileUploadResponse.class);
        FileUploadServiceResult data = response.getData();
        return data != null && data.getData() != null ? data.getData() : FileUploadResult.builder().build();
    }

    /**
     * Uploads an RCS image. Use {@link RcsFileUploadResult#getMedia()} in the RCS message body.
     *
     * @param file image file
     * @return media key and expiry
     */
    public RcsFileUploadResult uploadRcs(Path file) {
        return uploadRcs(FileUpload.of(file));
    }

    /**
     * Uploads an RCS image (jpg, bmp, png, gif).
     *
     * @param file image
     * @return media key and expiry
     */
    public RcsFileUploadResult uploadRcs(FileUpload file) {
        Params.required("file", file);
        RcsFileUploadResponse response = transport.call(Operations.UPLOAD_RCS_FILE, Retry.RATE_LIMIT_ONLY, Operations.UPLOAD_RCS_FILE.path(), null,
                Multipart.build(file), RcsFileUploadResponse.class);
        RcsFileUploadServiceResult data = response.getData();
        return data != null && data.getData() != null ? data.getData() : RcsFileUploadResult.builder().build();
    }

    /**
     * Uploads a Kakao brand message image. Use {@link BrandMessageFileUploadResult#getImgUrl()} in the message.
     *
     * @param file image file
     * @param kind image type
     * @return image URL
     */
    public BrandMessageFileUploadResult uploadBrandMessage(Path file, BrandImageKind kind) {
        return uploadBrandMessage(FileUpload.of(file), kind);
    }

    /**
     * Uploads a Kakao brand message image.
     *
     * @param file image
     * @param kind image type
     * @return image URL
     */
    public BrandMessageFileUploadResult uploadBrandMessage(FileUpload file, BrandImageKind kind) {
        Params.required("file", file);
        Params.required("kind", kind);
        String path = "/api/comm/v1/file/brandmessage/" + kind.value();
        BrandMessageFileUploadResponse response = transport.call(Operation.byTemplate("POST", path),
                Retry.RATE_LIMIT_ONLY, path, null, Multipart.build(file),
                BrandMessageFileUploadResponse.class);
        BrandMessageFileUploadServiceResult data = response.getData();
        return data != null && data.getData() != null ? data.getData()
                : BrandMessageFileUploadResult.builder().build();
    }

    /**
     * Uploads a Kakao brand message image, with the kind given as its path value.
     *
     * @param file image
     * @param kind {@code default}, {@code wide}, {@code wideItemList}, {@code wideItemList/first},
     *     {@code carouselFeed} or {@code carouselCommerce}
     * @return image URL
     * @throws io.github.icommapi.bizgo.errors.ValidationException for any other kind
     */
    public BrandMessageFileUploadResult uploadBrandMessage(FileUpload file, String kind) {
        return uploadBrandMessage(file, BrandImageKind.fromValue(kind));
    }

    @Override
    public String toString() {
        return "FileService";
    }
}
