// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.RcsChatbot;
import io.github.icommapi.bizgo.models.RcsChatbotResult;
import io.github.icommapi.bizgo.models.RcsChatbotUpdateRequest;
import io.github.icommapi.bizgo.params.GetRcsChatbotParams;
import io.github.icommapi.bizgo.params.ListRcsChatbotsParams;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().chatbots()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: rcs.chatbots}).
 */
public final class RcsChatbotsService {

    private final Transport transport;

    RcsChatbotsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * RCS 대화방 목록 조회.
     *
     * 브랜드 ID를 기준으로 등록된 RCS 대화방 목록을 조회합니다. 대화방(챗봇)은 브랜드에 속해 실제로 메시지를 주고받는 단위입니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/chatbot/list} (operationId {@code listRcsChatbots}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsChatbotResult list(ListRcsChatbotsParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_RCS_CHATBOTS, Operations.LIST_RCS_CHATBOTS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", RcsChatbotResult.class);
    }

    /**
     * Every item of {@link #list}, following the offset pagination across pages lazily.
     *
     * <p>Advances the offset by the number of items received; stops at an empty page, a page smaller than the requested size, or the total count.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<RcsChatbot> iterList(ListRcsChatbotsParams params) {
        Params.required("params", params);
        String path = Operations.LIST_RCS_CHATBOTS.path();
        return Paging.numbered(params.getOffset() == null ? 0 : params.getOffset(), params.getLimit(), true,
                n -> transport.raw(Operations.LIST_RCS_CHATBOTS, path,
                        params.toBuilder().offset(n).build().toQuery(), params.toHeaders(), null, "data.data.rcs.chatbot", RcsChatbot.class),
                "data.data.rcs.chatbot", null, null, RcsChatbot.class);
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<RcsChatbot> streamList(ListRcsChatbotsParams params) {
        return StreamSupport.stream(iterList(params).spliterator(), false);
    }

    /**
     * RCS 대화방 상세 조회.
     *
     * 브랜드 ID와 대화방 ID를 기준으로 RCS 대화방 상세 정보를 조회합니다. 결과는 <code>data.data.rcs.chatbot</code> 배열로 돌아옵니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/chatbot} (operationId {@code getRcsChatbot}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsChatbotResult get(GetRcsChatbotParams params) {
        Params.required("params", params);
        return transport.object(Operations.GET_RCS_CHATBOT, Operations.GET_RCS_CHATBOT.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", RcsChatbotResult.class);
    }

    /**
     * RCS 대화방 수정.
     *
     * 등록된 RCS 대화방 정보를 수정합니다. <code>multipart/form-data</code>로 보내며, 대화방 정보(<code>chatbot</code>)는 JSON 문자열, 부가번호 증명 서류(<code>subNumCertificate</code>)는 파일로 함께 보냅니다. 파일 스트림을 다시 보내야 하고 검수 요청이 다시 걸릴 수 있으므로 SDK는 429만 재시도합니다.
     *
     * <p>{@code PUT /api/comm/v1/center/rcs/chatbot} (operationId {@code updateRcsChatbot}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsChatbotResult update(RcsChatbotUpdateRequest request) {
        Params.required("request", request);
        Multipart.Form form = Multipart.form();
        form.text("brandId", request.getBrandId());
        form.json("chatbot", request.getChatbot());
        form.file("subNumCertificate", request.getSubNumCertificate());
        return transport.object(Operations.UPDATE_RCS_CHATBOT, Operations.UPDATE_RCS_CHATBOT.path(), null, null, form.build(),
                "data.data", RcsChatbotResult.class);
    }

    /**
     * RCS 대화방 승인 취소.
     *
     * 승인 진행 중인 RCS 대화방의 승인 요청을 취소합니다.
     *
     * <p>{@code PUT /api/comm/v1/center/rcs/brandId/&#123;brandId&#125;/chatbotId/&#123;chatbotId&#125;/cancel} (operationId {@code cancelRcsChatbotApproval}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param brandId 브랜드 ID입니다. (required)
     * @param chatbotId 대화방 ID입니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsChatbotResult cancel(String brandId, String chatbotId) {
        return transport.object(Operations.CANCEL_RCS_CHATBOT_APPROVAL, Operations.CANCEL_RCS_CHATBOT_APPROVAL.path(brandId, chatbotId), null, null, null,
                "data.data", RcsChatbotResult.class);
    }

    /**
     * RCS 대화방 삭제.
     *
     * 등록된 RCS 대화방을 삭제합니다.
     *
     * <p>{@code DELETE /api/comm/v1/center/rcs/brandId/&#123;brandId&#125;/chatbotId/&#123;chatbotId&#125;} (operationId {@code deleteRcsChatbot}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param brandId 브랜드 ID입니다. (required)
     * @param chatbotId 대화방 ID입니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsChatbotResult delete(String brandId, String chatbotId) {
        return transport.object(Operations.DELETE_RCS_CHATBOT, Operations.DELETE_RCS_CHATBOT.path(brandId, chatbotId), null, null, null,
                "data.data", RcsChatbotResult.class);
    }

    /**
     * RCS 대화방 사용 가능 쿼리 조회.
     *
     * 대화방 ID를 기준으로 해당 대화방에서 사용할 수 있는 쿼리 정보를 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/center/rcs/usableQuery/chatbotId/&#123;chatbotId&#125;} (operationId {@code getRcsChatbotUsableQueries}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param chatbotId 대화방 ID입니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public RcsChatbotResult getUsableQueries(String chatbotId) {
        return transport.object(Operations.GET_RCS_CHATBOT_USABLE_QUERIES, Operations.GET_RCS_CHATBOT_USABLE_QUERIES.path(chatbotId), null, null, null,
                "data.data", RcsChatbotResult.class);
    }

    @Override
    public String toString() {
        return "RcsChatbotsService";
    }
}
