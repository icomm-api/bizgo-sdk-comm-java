// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.BrandMessageGroupTagListResult;
import io.github.icommapi.bizgo.models.BrandMessageGroupTagRequest;
import io.github.icommapi.bizgo.params.GetBrandMessageGroupTagParams;
import io.github.icommapi.bizgo.params.ListBrandMessageGroupTagsParams;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().groupTags()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage.groupTags}).
 */
public final class BrandMessageGroupTagsService {

    private final Transport transport;

    BrandMessageGroupTagsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 브랜드메시지 전체 그룹태그 조회.
     *
     * 발신프로필 키로 브랜드메시지 전체 그룹태그 목록을 조회합니다. 그룹태그 키는 자유형 발송의 <code>groupTagKey</code>에 씁니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/groupTag/list} (operationId {@code listBrandMessageGroupTags}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageGroupTagListResult list(ListBrandMessageGroupTagsParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_BRAND_MESSAGE_GROUP_TAGS, Operations.LIST_BRAND_MESSAGE_GROUP_TAGS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageGroupTagListResult.class);
    }

    /**
     * 브랜드메시지 그룹태그 조회.
     *
     * 발신프로필 키와 그룹태그 키로 그룹태그 상세 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/brandmessage/groupTag} (operationId {@code getBrandMessageGroupTag}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageGroupTagListResult get(GetBrandMessageGroupTagParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_BRAND_MESSAGE_GROUP_TAG, Operations.GET_BRAND_MESSAGE_GROUP_TAG.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", BrandMessageGroupTagListResult.class);
    }

    /**
     * 브랜드메시지 그룹태그 등록.
     *
     * 브랜드메시지 그룹태그를 등록합니다.
     *
     * <p>{@code POST /api/comm/v1/center/brandmessage/groupTag} (operationId {@code createBrandMessageGroupTag}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageGroupTagListResult create(BrandMessageGroupTagRequest request) {
        Params.required("request", request);
        return transport.object(Operations.CREATE_BRAND_MESSAGE_GROUP_TAG, Operations.CREATE_BRAND_MESSAGE_GROUP_TAG.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageGroupTagListResult.class);
    }

    /**
     * 브랜드메시지 그룹태그 수정.
     *
     * 등록된 브랜드메시지 그룹태그 정보를 수정합니다.
     *
     * <p>{@code PUT /api/comm/v1/center/brandmessage/groupTag} (operationId {@code updateBrandMessageGroupTag}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public BrandMessageGroupTagListResult update(BrandMessageGroupTagRequest request) {
        Params.required("request", request);
        return transport.object(Operations.UPDATE_BRAND_MESSAGE_GROUP_TAG, Operations.UPDATE_BRAND_MESSAGE_GROUP_TAG.path(), null, null, Transport.Body.json(request),
                "data.data", BrandMessageGroupTagListResult.class);
    }

    /**
     * 브랜드메시지 그룹태그 삭제.
     *
     * 발신프로필 키와 그룹태그 키로 그룹태그를 삭제합니다.
     *
     * <p>{@code DELETE /api/comm/v1/center/brandmessage/groupTag/senderKey/&#123;senderKey&#125;/groupTagKey/&#123;groupTagKey&#125;} (operationId {@code deleteBrandMessageGroupTag}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param senderKey 발신프로필 키입니다. (required)
     * @param groupTagKey 삭제할 그룹태그 키입니다. (required)
     */
    public void delete(String senderKey, String groupTagKey) {
        transport.empty(Operations.DELETE_BRAND_MESSAGE_GROUP_TAG, Operations.DELETE_BRAND_MESSAGE_GROUP_TAG.path(senderKey, groupTagKey), null, null, null);
    }

    @Override
    public String toString() {
        return "BrandMessageGroupTagsService";
    }
}
