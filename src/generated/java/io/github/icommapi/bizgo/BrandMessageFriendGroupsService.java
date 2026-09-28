// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessageFriendGroupFileUploadRequest;
import io.github.icommapi.bizgo.models.BrandMessageFriendGroupFileUploadResult;
import io.github.icommapi.bizgo.models.BrandMessageFriendGroupListResult;
import io.github.icommapi.bizgo.models.BrandMessageFriendGroupPhoneNumberRequest;
import io.github.icommapi.bizgo.models.BrandMessageFriendGroupPhoneNumberRequestListResult;
import io.github.icommapi.bizgo.models.BrandMessageFriendGroupPhoneNumberRequestResult;
import io.github.icommapi.bizgo.models.BrandMessageFriendGroupProcessingResult;
import io.github.icommapi.bizgo.models.BrandMessageFriendGroupRequest;
import io.github.icommapi.bizgo.models.BrandMessageFriendGroupResult;
import io.github.icommapi.bizgo.params.GetBrandMessageFriendGroupParams;
import io.github.icommapi.bizgo.params.GetBrandMessageFriendGroupPhoneNumberRequestParams;
import io.github.icommapi.bizgo.params.ListBrandMessageFriendGroupPhoneNumberRequestsParams;
import io.github.icommapi.bizgo.params.ListBrandMessageFriendGroupsParams;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().friendGroups()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage.friendGroups}).
 */
public final class BrandMessageFriendGroupsService {

    private final Transport transport;

    BrandMessageFriendGroupsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 친구 그룹 파일 업로드.
     *
     * 전화번호 목록 파일(txt, csv)을 업로드해 친구 그룹 등록 또는 전화번호 추가·삭제에 쓸 임시 파일 키를 발급받습니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/friendGroup/file} (operationId {@code uploadBrandMessageFriendGroupFile}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFriendGroupFileUploadResult uploadFile(BrandMessageFriendGroupFileUploadRequest request) {
        Params.required("request", request);
        Multipart.Form form = Multipart.form();
        form.text("senderKey", request.getSenderKey());
        form.file("file", request.getFile());
        return transport.object(Operations.UPLOAD_BRAND_MESSAGE_FRIEND_GROUP_FILE, Operations.UPLOAD_BRAND_MESSAGE_FRIEND_GROUP_FILE.path(), null, null, form.build(),
                "data.data", BrandMessageFriendGroupFileUploadResult.class);
    }

    /**
     * 친구 그룹 등록.
     *
     * 친구 그룹을 생성합니다. <code>fileKey</code> 또는 <code>phoneNumbers</code>로 그룹에 넣을 전화번호를 함께 등록할 수 있습니다. 처리는 비동기이며 응답의 <code>status</code>는 <code>IN_PROGRESS</code>일 수 있습니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/friendGroup} (operationId {@code createBrandMessageFriendGroup}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFriendGroupProcessingResult create(BrandMessageFriendGroupRequest request) {
        Params.required("request", request);
        return transport.object(Operations.CREATE_BRAND_MESSAGE_FRIEND_GROUP, Operations.CREATE_BRAND_MESSAGE_FRIEND_GROUP.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageFriendGroupProcessingResult.class);
    }

    /**
     * 친구 그룹 조회.
     *
     * 발신프로필 키와 친구 그룹 키로 친구 그룹 상세 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/friendGroup} (operationId {@code getBrandMessageFriendGroup}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFriendGroupResult get(GetBrandMessageFriendGroupParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_FRIEND_GROUP, Operations.GET_BRAND_MESSAGE_FRIEND_GROUP.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageFriendGroupResult.class);
    }

    /**
     * 친구 그룹 목록 조회.
     *
     * 발신프로필 기준으로 등록된 친구 그룹 목록을 조회합니다. 문서에 페이징 파라미터가 없습니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/friendGroup/list} (operationId {@code listBrandMessageFriendGroups}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFriendGroupListResult list(ListBrandMessageFriendGroupsParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_BRAND_MESSAGE_FRIEND_GROUPS, Operations.LIST_BRAND_MESSAGE_FRIEND_GROUPS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageFriendGroupListResult.class);
    }

    /**
     * 친구 그룹 삭제.
     *
     * 발신프로필 키와 친구 그룹 키로 친구 그룹을 삭제합니다.
     *
     * <p>{@code DELETE /api/comm/v1/center/brandmessage/friendGroup/senderKey/&#123;senderKey&#125;/friendGroupKey/&#123;friendGroupKey&#125;} (operationId {@code deleteBrandMessageFriendGroup}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param senderKey 발신프로필 키입니다. (required)
     * @param friendGroupKey 삭제할 친구 그룹 키입니다. (required)
     */
    public void delete(String senderKey, String friendGroupKey) {
        transport.empty(Operations.DELETE_BRAND_MESSAGE_FRIEND_GROUP, Operations.DELETE_BRAND_MESSAGE_FRIEND_GROUP.path(senderKey, friendGroupKey), null, null, null);
    }

    /**
     * 친구 그룹 내 전화번호 추가.
     *
     * 기존 친구 그룹에 전화번호를 추가합니다. <code>fileKey</code> 또는 <code>phoneNumbers</code>로 입력합니다. 처리는 비동기이며 진행 상황은 전화번호 요청 조회로 확인합니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/friendGroup/phoneNumber/update} (operationId {@code addBrandMessageFriendGroupPhoneNumbers}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFriendGroupProcessingResult addPhoneNumbers(BrandMessageFriendGroupRequest request) {
        Params.required("request", request);
        return transport.object(Operations.ADD_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBERS, Operations.ADD_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBERS.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageFriendGroupProcessingResult.class);
    }

    /**
     * 친구 그룹 내 전화번호 삭제.
     *
     * 기존 친구 그룹에서 전화번호를 삭제합니다. <code>fileKey</code> 또는 <code>phoneNumbers</code>로 입력합니다. 처리는 비동기이며 진행 상황은 전화번호 요청 조회로 확인합니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/friendGroup/phoneNumber/delete} (operationId {@code deleteBrandMessageFriendGroupPhoneNumbers}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFriendGroupProcessingResult deletePhoneNumbers(BrandMessageFriendGroupRequest request) {
        Params.required("request", request);
        return transport.object(Operations.DELETE_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBERS, Operations.DELETE_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBERS.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageFriendGroupProcessingResult.class);
    }

    /**
     * 친구 그룹 전화번호 요청 목록 조회.
     *
     * 친구 그룹 전화번호 추가·삭제 요청의 처리 상태를 목록으로 조회합니다. 다음 페이지는 이전 응답의 마지막 항목 <code>requestId</code>를 <code>lastRequestId</code>로 넘겨 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/friendGroup/phoneNumber/requests} (operationId {@code listBrandMessageFriendGroupPhoneNumberRequests}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFriendGroupPhoneNumberRequestListResult listPhoneNumberRequests(ListBrandMessageFriendGroupPhoneNumberRequestsParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUESTS, Operations.LIST_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUESTS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageFriendGroupPhoneNumberRequestListResult.class);
    }

    /**
     * Every item of {@link #listPhoneNumberRequests}, following the cursor pagination across pages lazily.
     *
     * <p>Stops when {@code hasNext} is false, the cursor is missing, or it does not move.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<BrandMessageFriendGroupPhoneNumberRequest> iterListPhoneNumberRequests(ListBrandMessageFriendGroupPhoneNumberRequestsParams params) {
        Params.required("params", params);
        String path = Operations.LIST_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUESTS.path();
        return Paging.cursor(params.getLastRequestId() == null ? null : String.valueOf(params.getLastRequestId()),
                cursor -> transport.raw(Operations.LIST_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUESTS, path,
                        params.toBuilder().lastRequestId(cursor).build().toQuery(), params.toHeaders(), null, "data.data.friendGroups", BrandMessageFriendGroupPhoneNumberRequest.class),
                "data.data.friendGroups", "data.data.friendGroups[-1].requestId", "data.data.hasNext", BrandMessageFriendGroupPhoneNumberRequest.class);
    }

    /**
     * {@link #iterListPhoneNumberRequests} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<BrandMessageFriendGroupPhoneNumberRequest> streamListPhoneNumberRequests(ListBrandMessageFriendGroupPhoneNumberRequestsParams params) {
        return StreamSupport.stream(iterListPhoneNumberRequests(params).spliterator(), false);
    }

    /**
     * 친구 그룹 전화번호 요청 단건 조회.
     *
     * 전화번호 추가·삭제 응답으로 받은 <code>requestId</code>로 해당 요청의 처리 상태를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/friendGroup/phoneNumber/request} (operationId {@code getBrandMessageFriendGroupPhoneNumberRequest}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageFriendGroupPhoneNumberRequestResult getPhoneNumberRequest(GetBrandMessageFriendGroupPhoneNumberRequestParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUEST, Operations.GET_BRAND_MESSAGE_FRIEND_GROUP_PHONE_NUMBER_REQUEST.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageFriendGroupPhoneNumberRequestResult.class);
    }

    @Override
    public String toString() {
        return "BrandMessageFriendGroupsService";
    }
}
