// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.KakaoSenderAccountServiceResult;
import io.github.icommapi.bizgo.models.KakaoSenderChannel;
import io.github.icommapi.bizgo.models.KakaoSenderCreateRequest;
import io.github.icommapi.bizgo.models.KakaoSenderListServiceResult;
import io.github.icommapi.bizgo.models.KakaoSenderProfile;
import io.github.icommapi.bizgo.models.KakaoSenderRecoverRequest;
import io.github.icommapi.bizgo.models.KakaoSenderTokenRequest;
import io.github.icommapi.bizgo.params.CreateKakaoSenderParams;
import io.github.icommapi.bizgo.params.FindKakaoSenderParams;
import io.github.icommapi.bizgo.params.GetKakaoSenderParams;
import io.github.icommapi.bizgo.params.ListKakaoSenderProfilesParams;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao().senders()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: kakao.senders}).
 */
public final class KakaoSendersService {

    private final Transport transport;

    KakaoSendersService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 카카오 채널 인증 토큰 요청.
     *
     * 발신프로필 등록에 필요한 카카오톡 채널 인증 토큰을 요청합니다.
     * <p>발신프로필 등록 흐름: 1. 이 API에 채널 아이디(<code>yellowId</code>)와 채널 알림을 받는 관리자 전화번호(<code>phoneNumber</code>)를 보냅니다. 2. 그 전화번호에 연결된 카카오톡이 채널을 차단하지 않았다면 카카오가 해당 카카오톡으로 인증 토큰을 보냅니다. 3. 받은 토큰과 같은 전화번호를 헤더(<code>token</code>, <code>phoneNumber</code>)에 넣어 발신프로필 등록(<code>POST /api/comm/v1/account/kakao/sender</code>)을 호출합니다.
     * <p>인증받은 토큰은 7일 동안 비즈메시지 센터 서버에 보관됩니다. 다시 호출하면 토큰이 또 발송되므로 자동 재시도하지 않습니다.
     *
     * <p>{@code POST /api/comm/v1/account/kakao/sender/token} (operationId {@code requestKakaoSenderToken}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data} (an empty object if the server omits it)
     */
    public KakaoSenderAccountServiceResult requestToken(KakaoSenderTokenRequest request) {
        Params.required("request", request);
        return transport.object(Operations.REQUEST_KAKAO_SENDER_TOKEN, Operations.REQUEST_KAKAO_SENDER_TOKEN.path(), null, null, Transport.Body.json(request),
                "data", KakaoSenderAccountServiceResult.class);
    }

    /**
     * 인증 토큰으로 발신프로필 등록.
     *
     * 카카오톡 채널을 발신프로필로 신규 등록합니다. 카카오비즈니스 파트너센터에서 비즈니스 인증을 받았고, 프로필이 activated 상태이며 운영자에 의해 차단되지 않은 채널이어야 합니다. 카카오 채널 인증 토큰 요청(<code>POST /api/comm/v1/account/kakao/sender/token</code>)으로 받은 토큰과 그때 쓴 전화번호를 헤더로 보냅니다.
     * <p>다른 허브파트너 요청으로 이미 등록된 채널이면 이전에 등록된 발신프로필의 카테고리 코드로 등록됩니다. 브랜드메시지를 쓰는 발신프로필은 무료수신거부 전화번호·인증번호를 설정할 수 있습니다(타겟팅 M, N, O 사용 시 필수).
     *
     * <p>{@code POST /api/comm/v1/account/kakao/sender} (operationId {@code createKakaoSender}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @param params query and header parameters
     * @return the response part at {@code data.kakao.senderProfile} (an empty object if the server omits it)
     */
    public KakaoSenderProfile create(KakaoSenderCreateRequest request, CreateKakaoSenderParams params) {
        Params.required("request", request);
        Params.required("params", params);
        return transport.object(Operations.CREATE_KAKAO_SENDER, Operations.CREATE_KAKAO_SENDER.path(), params.toQuery(), params.toHeaders(), Transport.Body.json(request),
                "data.kakao.senderProfile", KakaoSenderProfile.class);
    }

    /**
     * 발신프로필 키 또는 uuid로 조회.
     *
     * 발신프로필 키(<code>senderKey</code>) 또는 카카오톡 채널 uuid에 해당하는 발신프로필을 조회합니다. <code>senderKey</code>와 <code>uuid</code> 중 하나는 반드시 입력해야 합니다.
     *
     * <p>{@code GET /api/comm/v1/account/kakao/sender} (operationId {@code findKakaoSender}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.kakao.senderProfile} (an empty object if the server omits it)
     */
    public KakaoSenderProfile find(FindKakaoSenderParams params) {
        Params.required("params", params);
        return transport.object(Operations.FIND_KAKAO_SENDER, Operations.FIND_KAKAO_SENDER.path(), params.toQuery(), params.toHeaders(), null,
                "data.kakao.senderProfile", KakaoSenderProfile.class);
    }

    /**
     * 발신프로필 키 또는 uuid로 조회.
     *
     * <p>Same as the overload with parameters, with none set.
     *
     * <p>{@code GET /api/comm/v1/account/kakao/sender} (operationId {@code findKakaoSender}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @return the response part at {@code data.kakao.senderProfile} (an empty object if the server omits it)
     */
    public KakaoSenderProfile find() {
        return find(FindKakaoSenderParams.builder().build());
    }

    /**
     * 발신프로필 목록 조회.
     *
     * API 키에 등록된 발신프로필 목록을 조회합니다. 검색 기간과 발신프로필 키로 범위를 좁힐 수 있고, 결과는 페이지 단위로 반환합니다.
     *
     * <p>{@code GET /api/comm/v1/account/kakao/sender/profiles} (operationId {@code listKakaoSenderProfiles}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data} (an empty object if the server omits it)
     */
    public KakaoSenderListServiceResult list(ListKakaoSenderProfilesParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_KAKAO_SENDER_PROFILES, Operations.LIST_KAKAO_SENDER_PROFILES.path(), params.toQuery(), params.toHeaders(), null,
                "data", KakaoSenderListServiceResult.class);
    }

    /**
     * 발신프로필 목록 조회.
     *
     * <p>Same as the overload with parameters, with none set.
     *
     * <p>{@code GET /api/comm/v1/account/kakao/sender/profiles} (operationId {@code listKakaoSenderProfiles}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @return the response part at {@code data} (an empty object if the server omits it)
     */
    public KakaoSenderListServiceResult list() {
        return list(ListKakaoSenderProfilesParams.builder().build());
    }

    /**
     * Every item of {@link #list}, following the page pagination across pages lazily.
     *
     * <p>Stops at an empty page, a page smaller than the requested size, or the total count, or when {@code hasNext} is false.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<KakaoSenderChannel> iterList(ListKakaoSenderProfilesParams params) {
        Params.required("params", params);
        String path = Operations.LIST_KAKAO_SENDER_PROFILES.path();
        return Paging.numbered(params.getPage() == null ? 1 : params.getPage(), params.getRows(), false,
                n -> transport.raw(Operations.LIST_KAKAO_SENDER_PROFILES, path,
                        params.toBuilder().page(n).build().toQuery(), params.toHeaders(), null, "data.channels", KakaoSenderChannel.class),
                "data.channels", "data.totalCount", "data.hasNext", KakaoSenderChannel.class);
    }

    /**
     * Every item of {@link #list}, following the page pagination across pages lazily.
     *
     * <p>Stops at an empty page, a page smaller than the requested size, or the total count, or when {@code hasNext} is false.
     *
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<KakaoSenderChannel> iterList() {
        return iterList(ListKakaoSenderProfilesParams.builder().build());
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<KakaoSenderChannel> streamList(ListKakaoSenderProfilesParams params) {
        return StreamSupport.stream(iterList(params).spliterator(), false);
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @return lazy sequential stream
     */
    public Stream<KakaoSenderChannel> streamList() {
        return StreamSupport.stream(iterList().spliterator(), false);
    }

    /**
     * 발신프로필 키로 조회.
     *
     * 발신프로필 키를 기준으로 카카오 발신프로필 정보를 조회합니다. 알림톡, 브랜드메시지, 상담톡에서 사용하는 senderKey의 상태(차단·휴면·스팸 등)를 확인할 때 사용합니다.
     *
     * <p>{@code GET /api/comm/v1/center/kakao/sender} (operationId {@code getKakaoSender}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data.kakao.senderProfile} (an empty object if the server omits it)
     */
    public KakaoSenderProfile get(GetKakaoSenderParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_KAKAO_SENDER, Operations.GET_KAKAO_SENDER.path(), params.toQuery(), params.toHeaders(), null,
                "data.data.kakao.senderProfile", KakaoSenderProfile.class);
    }

    /**
     * 발신프로필 휴면 해제.
     *
     * 휴면 상태의 발신프로필을 해제합니다. 카카오 비즈메시지 발송 전 발신프로필 상태 복구가 필요한 경우 사용합니다.
     *
     * <p>{@code POST /api/comm/v1/center/kakao/sender/recover} (operationId {@code recoverKakaoSender}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     */
    public void recover(KakaoSenderRecoverRequest request) {
        Params.required("request", request);
        transport.empty(Operations.RECOVER_KAKAO_SENDER, Operations.RECOVER_KAKAO_SENDER.path(), null, null, Transport.Body.json(request));
    }

    @Override
    public String toString() {
        return "KakaoSendersService";
    }
}
