// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.CounselFileUploadRequest;
import io.github.icommapi.bizgo.models.CounselFileUploadResult;
import io.github.icommapi.bizgo.models.CounselImageUploadRequest;
import io.github.icommapi.bizgo.models.CounselImageUploadResult;

/**
 * 카카오 상담톡: {@code client.counsel().files()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: counsel.files}).
 */
public final class CounselFilesService {

    private final Transport transport;

    CounselFilesService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 상담톡 이미지 업로드.
     *
     * 상담톡 이미지(jpg, png, gif, 최대 5MB)를 올리고 <code>imgUrl</code>을 받습니다. Rich 메시지용은 <code>imageType=rich</code>로 올립니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/file/cstalk/image} (operationId {@code uploadCounselImage}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public CounselImageUploadResult uploadImage(CounselImageUploadRequest request) {
        Params.required("request", request);
        Multipart.Form form = Multipart.form();
        form.file("file", request.getFile());
        form.text("fileKey", request.getFileKey());
        form.text("imageName", request.getImageName());
        form.text("senderKey", request.getSenderKey());
        form.text("imageType", request.getImageType());
        return transport.object(Operations.UPLOAD_COUNSEL_IMAGE, Operations.UPLOAD_COUNSEL_IMAGE.path(), null, null, form.build(),
                "data.data", CounselImageUploadResult.class);
    }

    /**
     * 상담톡 파일 업로드.
     *
     * 상담톡 FILE·AUDIO·VIDEO 타입 첨부 파일을 올리고 <code>fileUrl</code>을 받습니다. 운영은 최대 300MB, 샌드박스는 최대 10MB입니다.
     * <p>상담톡 요청·응답에는 최종 사용자 식별자(<code>userKey</code>)와 상담 내용이 들어가므로 개인정보로 취급하고 본문을 로그에 남기지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/file/cstalk} (operationId {@code uploadCounselFile}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public CounselFileUploadResult upload(CounselFileUploadRequest request) {
        Params.required("request", request);
        Multipart.Form form = Multipart.form();
        form.file("file", request.getFile());
        form.text("fileKey", request.getFileKey());
        form.text("imageName", request.getImageName());
        form.text("senderKey", request.getSenderKey());
        form.text("fileType", request.getFileType());
        return transport.object(Operations.UPLOAD_COUNSEL_FILE, Operations.UPLOAD_COUNSEL_FILE.path(), null, null, form.build(),
                "data.data", CounselFileUploadResult.class);
    }

    @Override
    public String toString() {
        return "CounselFilesService";
    }
}
