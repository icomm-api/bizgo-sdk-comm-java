// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessageVideoInfoResult;
import io.github.icommapi.bizgo.models.BrandMessageVideoListEntry;
import io.github.icommapi.bizgo.models.BrandMessageVideoListResult;
import io.github.icommapi.bizgo.models.BrandMessageVideoRegisterRequest;
import io.github.icommapi.bizgo.models.BrandMessageVideoUploadRegisterRequest;
import io.github.icommapi.bizgo.models.BrandMessageVideoUploadRegisterResult;
import io.github.icommapi.bizgo.params.GetBrandMessageVideoParams;
import io.github.icommapi.bizgo.params.ListBrandMessageVideosParams;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().videos()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage.videos}).
 */
public final class BrandMessageVideosService {

    private final Transport transport;

    BrandMessageVideosService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 브랜드메시지 동영상 업로드 등록.
     *
     * 브랜드메시지에 쓸 동영상의 업로드를 등록하고 카카오 업로드 채널(<code>vid</code>, <code>uploadUrl</code>, <code>token</code>)을 발급받습니다. 파일은 이 API로 보내지 않고 <code>uploadUrl</code>로 직접 전송합니다(5분 안에). 전송 후 동영상 조회로 <code>status</code>가 <code>PUBLIC</code>인지 확인합니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/video/upload/register} (operationId {@code registerBrandMessageVideoUpload}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageVideoUploadRegisterResult registerUpload(BrandMessageVideoUploadRegisterRequest request) {
        Params.required("request", request);
        return transport.object(Operations.REGISTER_BRAND_MESSAGE_VIDEO_UPLOAD, Operations.REGISTER_BRAND_MESSAGE_VIDEO_UPLOAD.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageVideoUploadRegisterResult.class);
    }

    /**
     * 브랜드메시지 기존 동영상 등록.
     *
     * 카카오톡 채널에 이미 올라가 있는 동영상을 재업로드 없이 브랜드메시지 발송용으로 등록합니다. <code>vid</code> 또는 <code>videoUrl</code> 중 하나만 지정합니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/video/register} (operationId {@code registerBrandMessageExistingVideo}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageVideoInfoResult registerExisting(BrandMessageVideoRegisterRequest request) {
        Params.required("request", request);
        return transport.object(Operations.REGISTER_BRAND_MESSAGE_EXISTING_VIDEO, Operations.REGISTER_BRAND_MESSAGE_EXISTING_VIDEO.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageVideoInfoResult.class);
    }

    /**
     * 브랜드메시지 동영상 조회.
     *
     * 동영상 식별자로 업로드된 동영상 한 건의 처리 상태와 메타 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/video} (operationId {@code getBrandMessageVideo}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageVideoInfoResult get(GetBrandMessageVideoParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_VIDEO, Operations.GET_BRAND_MESSAGE_VIDEO.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageVideoInfoResult.class);
    }

    /**
     * 브랜드메시지 동영상 목록 조회.
     *
     * 발신프로필 기준으로 업로드한 동영상 이력을 조회합니다. 등록일자로 거르고 <code>offset</code>·<code>limit</code>으로 페이징합니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/video/list} (operationId {@code listBrandMessageVideos}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageVideoListResult list(ListBrandMessageVideosParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_BRAND_MESSAGE_VIDEOS, Operations.LIST_BRAND_MESSAGE_VIDEOS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageVideoListResult.class);
    }

    /**
     * Every item of {@link #list}, following the offset pagination across pages lazily.
     *
     * <p>Advances the offset by the number of items received; stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<BrandMessageVideoListEntry> iterList(ListBrandMessageVideosParams params) {
        Params.required("params", params);
        String path = Operations.LIST_BRAND_MESSAGE_VIDEOS.path();
        return Paging.numbered(params.getOffset() == null ? 0 : params.getOffset(), params.getLimit(), true,
                n -> transport.raw(Operations.LIST_BRAND_MESSAGE_VIDEOS, path,
                        params.toBuilder().offset(n).build().toQuery(), params.toHeaders(), null, "data.data.videos", BrandMessageVideoListEntry.class),
                "data.data.videos", "data.data.totalCount", null, BrandMessageVideoListEntry.class);
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<BrandMessageVideoListEntry> streamList(ListBrandMessageVideosParams params) {
        return StreamSupport.stream(iterList(params).spliterator(), false);
    }

    @Override
    public String toString() {
        return "BrandMessageVideosService";
    }
}
