// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.KakaoGroup;
import io.github.icommapi.bizgo.models.KakaoGroupSenderAddRequest;
import io.github.icommapi.bizgo.params.ListKakaoGroupsParams;
import java.util.List;

/**
 * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao().groups()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: kakao.groups}).
 */
public final class KakaoGroupsService {

    private final Transport transport;

    KakaoGroupsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 발신프로필키로 그룹 조회.
     *
     * 발신프로필 키를 기준으로 연결된 발신프로필 그룹 정보를 조회합니다. <code>senderKey</code>를 생략하면 조회 가능한 그룹 정보를 기준으로 응답합니다.
     *
     * <p>{@code GET /api/comm/v1/center/kakao/group} (operationId {@code listKakaoGroups}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the items at {@code data.data.kakao.groups}, empty if none
     */
    public List<KakaoGroup> list(ListKakaoGroupsParams params) {
        Params.required("params", params);
        return transport.list(Operations.LIST_KAKAO_GROUPS, Operations.LIST_KAKAO_GROUPS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.kakao.groups", KakaoGroup.class);
    }

    /**
     * 발신프로필키로 그룹 조회.
     *
     * <p>Same as the overload with parameters, with none set.
     *
     * <p>{@code GET /api/comm/v1/center/kakao/group} (operationId {@code listKakaoGroups}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @return the items at {@code data.data.kakao.groups}, empty if none
     */
    public List<KakaoGroup> list() {
        return list(ListKakaoGroupsParams.builder().build());
    }

    /**
     * 그룹에 발신프로필 등록.
     *
     * 발신프로필 그룹에 발신프로필을 등록합니다. 그룹 키와 등록할 발신프로필 키를 함께 전달합니다.
     *
     * <p>{@code POST /api/comm/v1/center/kakao/group} (operationId {@code addKakaoGroupSender}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void addSender(KakaoGroupSenderAddRequest request) {
        Params.required("request", request);
        transport.empty(Operations.ADD_KAKAO_GROUP_SENDER, Operations.ADD_KAKAO_GROUP_SENDER.path(), null, null, Transport.Body.json(request));
    }

    /**
     * 그룹에서 발신프로필 삭제.
     *
     * 발신프로필 그룹에서 특정 발신프로필을 삭제합니다.
     *
     * <p>{@code DELETE /api/comm/v1/center/kakao/group/groupKey/&#123;groupKey&#125;/senderKey/&#123;senderKey&#125;} (operationId {@code removeKakaoGroupSender}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param groupKey 그룹 키입니다. (required)
     * @param senderKey 삭제할 발신프로필 키입니다. (required)
     */
    public void removeSender(String groupKey, String senderKey) {
        transport.empty(Operations.REMOVE_KAKAO_GROUP_SENDER, Operations.REMOVE_KAKAO_GROUP_SENDER.path(groupKey, senderKey), null, null, null);
    }

    @Override
    public String toString() {
        return "KakaoGroupsService";
    }
}
