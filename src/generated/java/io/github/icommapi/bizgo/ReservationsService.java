// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

import io.github.icommapi.bizgo.models.Reservation;
import io.github.icommapi.bizgo.models.ReservationCreateRequest;
import io.github.icommapi.bizgo.models.ReservationCreateServiceResult;
import io.github.icommapi.bizgo.models.ReservationListResult;
import io.github.icommapi.bizgo.models.ReservationUpdateRequest;
import io.github.icommapi.bizgo.params.ListReservationsParams;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 예약 발송과 예약 관리: {@code client.reservations()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: reservations}).
 */
public final class ReservationsService {

    private final Transport transport;
    private final ReservationsRecipientsService recipients;

    ReservationsService(Transport transport) {
        this.transport = transport;
        this.recipients = new ReservationsRecipientsService(transport);
    }

    /**
     * 예약 발송과 예약 관리: {@code client.reservations().recipients()}.
     *
     * @return the {@code reservations.recipients} resource
     */
    public ReservationsRecipientsService recipients() {
        return recipients;
    }

    /**
     * 예약 발송 등록.
     *
     * 메시지를 지정한 시각에 발송하도록 예약 등록합니다. SMS/LMS/MMS, 국제, 통합 RCS, 알림톡, 브랜드메시지(기본형·자유형)를 예약할 수 있으며, 채널별 메시지 필드는 통합 발송 규격과 같습니다. 채널별 안내는 문자·국제·RCS·알림톡·브랜드메시지 API 레퍼런스의 "예약 발송" 섹션에 있습니다.
     * <ul>
     * <li><code>resvSendTime</code>은 현재 시각 + 10분부터 1년 이내여야 합니다(A316, A331).</li>
     * <li>광고성 메시지는 20:00~08:00(KST)에 예약할 수 없습니다(A330).</li>
     * <li>응답의 <code>data.resvKey</code>로 예약 조회·수정·취소·중지·재개·수신자 관리를 합니다.</li>
     * </ul>
     * <p>문서에 멱등성 키가 없으므로, 네트워크 오류로 결과를 모를 때는 다시 등록하기 전에 예약 목록 조회로 등록 여부를 확인합니다.
     *
     * <p>{@code POST /api/comm/v1/reservation} (operationId {@code createReservation}, retry {@code rate_limit_only}, rate-limit bucket {@code send}).
     *
     * @param request request body (validated when built)
     * @return the response part at {@code data} (an empty object if the server omits it)
     */
    public ReservationCreateServiceResult create(ReservationCreateRequest request) {
        Params.required("request", request);
        return transport.object(Operations.CREATE_RESERVATION, Operations.CREATE_RESERVATION.path(), null, null, Transport.Body.json(request),
                "data", ReservationCreateServiceResult.class);
    }

    /**
     * 예약 목록 조회.
     *
     * 예약 발송 건 목록을 조회합니다. <code>resvSendTime</code>에 지정한 시각을 포함해 그 이후의 예약 건이 조회됩니다.
     *
     * <p>{@code GET /api/comm/v1/reservation/list} (operationId {@code listReservations}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param params query parameters
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public ReservationListResult list(ListReservationsParams params) {
        Params.required("params", params);
        return transport.object(Operations.LIST_RESERVATIONS, Operations.LIST_RESERVATIONS.path(), params.toQuery(), params.toHeaders(), null,
                "data.data", ReservationListResult.class);
    }

    /**
     * Every item of {@link #list}, following the cursor pagination across pages lazily.
     *
     * <p>Stops when {@code hasNext} is false, the cursor is missing, or it does not move.
     *
     * @param params query parameters; the page parameter, if set, is the starting point
     * @return iterable that fetches pages lazily; each iteration starts over
     */
    public Iterable<Reservation> iterList(ListReservationsParams params) {
        Params.required("params", params);
        String path = Operations.LIST_RESERVATIONS.path();
        return Paging.cursor(params.getLastSeq() == null ? null : String.valueOf(params.getLastSeq()),
                cursor -> transport.raw(Operations.LIST_RESERVATIONS, path,
                        params.toBuilder().lastSeq(Paging.toLong(cursor)).build().toQuery(), params.toHeaders(), null, "data.data.reservations", Reservation.class),
                "data.data.reservations", "data.data.lastSeq", "data.data.hasNext", Reservation.class);
    }

    /**
     * {@link #iterList} as a sequential stream.
     *
     * @param params query parameters
     * @return lazy sequential stream
     */
    public Stream<Reservation> streamList(ListReservationsParams params) {
        return StreamSupport.stream(iterList(params).spliterator(), false);
    }

    /**
     * 예약 상세 조회.
     *
     * 예약 발송 키(resvKey)로 예약 건을 단건 조회합니다.
     *
     * <p>{@code GET /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;} (operationId {@code getReservation}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public Reservation get(String resvKey) {
        return transport.object(Operations.GET_RESERVATION, Operations.GET_RESERVATION.path(resvKey), null, null, null,
                "data.data", Reservation.class);
    }

    /**
     * 예약 수정.
     *
     * 예약 대기(PENDING) 상태인 예약 건의 발송 시각과 예약명을 수정합니다. 다른 상태이면 거절됩니다(A824). 수정 응답에는 <code>resvData</code>가 빠질 수 있습니다.
     *
     * <p>{@code PUT /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;} (operationId {@code updateReservation}, retry {@code safe}, rate-limit bucket {@code other}).
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @param request request body (validated when built)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public Reservation update(String resvKey, ReservationUpdateRequest request) {
        Params.required("request", request);
        return transport.object(Operations.UPDATE_RESERVATION, Operations.UPDATE_RESERVATION.path(resvKey), null, null, Transport.Body.json(request),
                "data.data", Reservation.class);
    }

    /**
     * 예약 취소.
     *
     * 예약 대기(PENDING) 또는 예약 중지(STOPPED) 상태인 예약 건을 취소합니다. 성공하면 <code>status</code>가 <code>CANCELLED</code>가 됩니다.
     *
     * <p>{@code POST /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;/cancel} (operationId {@code cancelReservation}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public Reservation cancel(String resvKey) {
        return transport.object(Operations.CANCEL_RESERVATION, Operations.CANCEL_RESERVATION.path(resvKey), null, null, null,
                "data.data", Reservation.class);
    }

    /**
     * 예약 중지.
     *
     * 발송 처리 중(PROCESSING)인 예약 건을 중지합니다. 성공하면 <code>status</code>가 <code>STOPPED</code>가 되며, 재개(<code>resume</code>)로 다시 발송할 수 있습니다.
     *
     * <p>{@code POST /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;/stop} (operationId {@code stopReservation}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public Reservation pause(String resvKey) {
        return transport.object(Operations.STOP_RESERVATION, Operations.STOP_RESERVATION.path(resvKey), null, null, null,
                "data.data", Reservation.class);
    }

    /**
     * 예약 재개.
     *
     * 예약 중지(STOPPED) 상태인 예약 건을 다시 발송 처리합니다.
     *
     * <p>{@code POST /api/comm/v1/reservation/resvKey/&#123;resvKey&#125;/resume} (operationId {@code resumeReservation}, retry {@code rate_limit_only}, rate-limit bucket {@code other}).
     *
     * @param resvKey 예약 발송 키입니다. 예약 발송 등록 응답의 <code>data.resvKey</code> 값입니다. (required)
     * @return the response part at {@code data.data} (an empty object if the server omits it)
     */
    public Reservation resume(String resvKey) {
        return transport.object(Operations.RESUME_RESERVATION, Operations.RESUME_RESERVATION.path(resvKey), null, null, null,
                "data.data", Reservation.class);
    }

    @Override
    public String toString() {
        return "ReservationsService";
    }
}
