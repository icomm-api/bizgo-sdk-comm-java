// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.ReservationRecipient;
import io.github.icommapi.bizgo.models.ReservationRecipientCreateRequest;
import io.github.icommapi.bizgo.models.ReservationRecipientListResult;
import io.github.icommapi.bizgo.models.SendOmniResult;
import io.github.icommapi.bizgo.params.ListReservationRecipientsParams;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 예약 발송과 예약 관리: {@code client.reservations().recipients()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: reservations.recipients}).
 */
public final class ReservationsRecipientsService {

    private final Transport transport;

    ReservationsRecipientsService(Transport transport) {
        this.transport = transport;
    }

    /**
     * 예약 수신자 추가.
     *
     * 기존 예약 건에 수신자를 추가합니다. 한 번에 최대 1,000건까지 추가할 수 있습니다. 수신자별 <code>code</code>를 함께 확인합니다.
     *
     * <p>{@code POST /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;/destinations} (operationId {@code addReservationRecipients}, retry {@code rate_limit_only}, rate-limit bucket {@code send}).
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public SendOmniResult create(String resvKey, ReservationRecipientCreateRequest request) {
        Params.required("request", request);
        return transport.object(Operations.ADD_RESERVATION_RECIPIENTS, Operations.ADD_RESERVATION_RECIPIENTS.path(resvKey), null, null, Transport.Body.json(request),
                "data.data", SendOmniResult.class);
    }

    /**
     * 예약 수신자 목록 조회.
     *
     * 예약 건에 등록된 수신자 목록을 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;/destinations} (operationId {@code listReservationRecipients}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public ReservationRecipientListResult list(String resvKey, ListReservationRecipientsParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_RESERVATION_RECIPIENTS, Operations.LIST_RESERVATION_RECIPIENTS.path(resvKey), params.toQuery(), params.toHeaders(), null,
                "data.data", ReservationRecipientListResult.class);
    }

    /**
     * 예약 수신자 목록 조회.
     *
     * <p>Same as the overload with parameters, with none set.
     *
     * <p>{@code GET /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;/destinations} (operationId {@code listReservationRecipients}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public ReservationRecipientListResult list(String resvKey) {
        return list(resvKey, ListReservationRecipientsParams.builder().build());
    }

    /**
     * Every item of {@link #list}, following the cursor pagination across pages lazily.
     *
     * <p>Stops when {@code hasNext} is false, the cursor is missing, or it does not move.
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<ReservationRecipient> iterList(String resvKey, ListReservationRecipientsParams params) {
        Params.required("params", params);
        String path = Operations.LIST_RESERVATION_RECIPIENTS.path(resvKey);
        return Paging.cursor(params.getLastSeq() == null ? null : String.valueOf(params.getLastSeq()),
                cursor -> transport.raw(Operations.LIST_RESERVATION_RECIPIENTS, path,
                        params.toBuilder().lastSeq(Paging.toLong(cursor)).build().toQuery(), params.toHeaders(), null, "data.data.destinations", ReservationRecipient.class),
                "data.data.destinations", "data.data.lastSeq", "data.data.hasNext", ReservationRecipient.class);
    }

    /**
     * Every item of {@link #list}, following the cursor pagination across pages lazily.
     *
     * <p>Stops when {@code hasNext} is false, the cursor is missing, or it does not move.
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<ReservationRecipient> iterList(String resvKey) {
        return iterList(resvKey, ListReservationRecipientsParams.builder().build());
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<ReservationRecipient> streamList(String resvKey, ListReservationRecipientsParams params) {
        return StreamSupport.stream(iterList(resvKey, params).spliterator(), false);
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @return lazy sequential stream
     */
    public Stream<ReservationRecipient> streamList(String resvKey) {
        return StreamSupport.stream(iterList(resvKey).spliterator(), false);
    }

    /**
     * 예약 수신자 삭제.
     *
     * 예약 건에 등록된 수신자를 메시지 키(msgKey) 기준으로 삭제합니다.
     *
     * <p>{@code DELETE /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;/destinations/msgKey/&#123;msgKey&#125;} (operationId {@code deleteReservationRecipient}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @param msgKey 조회할 메시지 키입니다. (required)
     */
    public void delete(String resvKey, String msgKey) {
        transport.empty(Operations.DELETE_RESERVATION_RECIPIENT, Operations.DELETE_RESERVATION_RECIPIENT.path(resvKey, msgKey), null, null, null);
    }

    @Override
    public String toString() {
        return "ReservationsRecipientsService";
    }
}
