// Generated from spec/error-codes.json by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.errors;

import java.util.Map;
import java.util.Optional;

/**
 * Service-layer ({@code data.code}) result codes with their documented HTTP status and Korean description.
 *
 * <p>Source: https://developers.bizgo.io/api-sdk/api-reference/error-codes
 */
public final class ServiceCodes {

    /** Where the table comes from. */
    public static final String SOURCE = "https://developers.bizgo.io/api-sdk/api-reference/error-codes";

    /**
     * One service code.
     *
     * @param code code, for example {@code A306}
     * @param httpStatus documented HTTP status (0 if not documented)
     * @param description Korean description
     */
    public record Code(String code, int httpStatus, String description) {
    }

    private static final Map<String, Code> CODES = Map.ofEntries(
            Map.entry("A000", new Code("A000", 200, "요청 성공")),
            Map.entry("A001", new Code("A001", 401, "만료된 토큰")),
            Map.entry("A002", new Code("A002", 403, "토큰 권한 없음")),
            Map.entry("A010", new Code("A010", 400, "JSON을 파싱 할 수 없음")),
            Map.entry("A011", new Code("A011", 400, "JSON을 매핑 할 수 없음")),
            Map.entry("A020", new Code("A020", 429, "Ratelimit(TPS) 초과")),
            Map.entry("A910", new Code("A910", 500, "Internal server error")),
            Map.entry("A920", new Code("A920", 503, "서비스 처리 일시적 불가")),
            Map.entry("A999", new Code("A999", 500, "알려지지 않은 에러")),
            Map.entry("A100", new Code("A100", 401, "잘못된 인증 정보")),
            Map.entry("A110", new Code("A110", 403, "차단된 계정")),
            Map.entry("A111", new Code("A111", 403, "차단된 계정")),
            Map.entry("A113", new Code("A113", 403, "유효하지 않은 Expired Set Value")),
            Map.entry("A200", new Code("A200", 400, "파일 크기 초과")),
            Map.entry("A201", new Code("A201", 400, "이미지명 길이 초과")),
            Map.entry("A202", new Code("A202", 400, "사용할 수 없는 파일")),
            Map.entry("A203", new Code("A203", 400, "유효하지 않은 이미지해상도")),
            Map.entry("A204", new Code("A204", 400, "업로드된 파일이 없거나 잘못된 요청")),
            Map.entry("A205", new Code("A205", 400, "파일의 Content-Type과 실제 MIME 타입 불일치")),
            Map.entry("A206", new Code("A206", 400, "지원하지 않는 파일 형식")),
            Map.entry("A207", new Code("A207", 400, "유효하지 않거나 비어있는 Content-Disposition")),
            Map.entry("A208", new Code("A208", 400, "유효하지 않거나 비어있는 fileName")),
            Map.entry("A213", new Code("A213", 400, "잘못된 요청")),
            Map.entry("A214", new Code("A214", 500, "이미지 파일 처리 실패")),
            Map.entry("A215", new Code("A215", 500, "이동통신사 이미지 업로드 실패")),
            Map.entry("A217", new Code("A217", 400, "유효하지 않은 fileKey")),
            Map.entry("A219", new Code("A219", 400, "유효하지 않은 serviceType")),
            Map.entry("A220", new Code("A220", 400, "유효하지 않은 msgType")),
            Map.entry("A250", new Code("A250", 400, "유효하지 않는 formId")),
            Map.entry("A801", new Code("A801", 400, "리포트 POLLING API 사용권한 없음")),
            Map.entry("A802", new Code("A802", 403, "유효하지 않는 Report ID")),
            Map.entry("A300", new Code("A300", 400, "잘못된 메시지 발송 요청")),
            Map.entry("A301", new Code("A301", 400, "이미 동일한 요청이 처리되었습니다.")),
            Map.entry("A302", new Code("A302", 400, "유효하지 않거나 비어있는 필드 (필드명 : from)")),
            Map.entry("A303", new Code("A303", 400, "유효하지 않거나 비어있는 필드 (필드명 : text)")),
            Map.entry("A304", new Code("A304", 400, "유효하지 않거나 비어있는 필드 (필드명 : ttl)")),
            Map.entry("A305", new Code("A305", 400, "유효하지 않거나 비어있는 필드 (필드명 : ref)")),
            Map.entry("A306", new Code("A306", 400, "유효하지 않거나 비어있는 필드 (필드명 : to)")),
            Map.entry("A307", new Code("A307", 400, "필수 대상자 필드(to, appUserId, userKey) 중 최소 하나는 입력해야 합니다.")),
            Map.entry("A308", new Code("A308", 400, "idempotencyKey가 비어 있거나 허용된 길이(최대 200자)를 초과했습니다.")),
            Map.entry("A309", new Code("A309", 400, "idempotencyTtl 값이 숫자가 아니거나 허용된 범위(0~86400초)를 초과했습니다.")),
            Map.entry("A310", new Code("A310", 400, "최대 길이 초과 (필드명 : paymentCode)")),
            Map.entry("A311", new Code("A311", 400, "유효하지 않거나 비어있는 필드 (필드명 : groupKey)")),
            Map.entry("A312", new Code("A312", 400, "유효하지 않거나 비어있는 필드 (필드명 : fallback.type)")),
            Map.entry("A313", new Code("A313", 400, "유효하지 않거나 비어있는 필드 (필드명 : clientSubId)")),
            Map.entry("A314", new Code("A314", 400, "유효하지 않거나 비어있는 필드 (필드명 : fallback.text)")),
            Map.entry("A315", new Code("A315", 400, "유효하지 않거나 비어있는 필드 (필드명 : resvSendTime)")),
            Map.entry("A316", new Code("A316", 400, "예약 발송 가능 시각보다 이른 시간입니다.")),
            Map.entry("A317", new Code("A317", 400, "fallback 메시지 파일 키 수(3건) 초과")),
            Map.entry("A318", new Code("A318", 400, "발송 가능한 수신번호 수(200건) 초과")),
            Map.entry("A319", new Code("A319", 400, "첨부 가능한 파일 키 수(3건) 초과")),
            Map.entry("A320", new Code("A320", 400, "메시지 제한건수 여분 초과")),
            Map.entry("A321", new Code("A321", 400, "국제문자에서는 title, fileKey를 사용할 수 없습니다.")),
            Map.entry("A322", new Code("A322", 400, "스팸 차단(메시지 내용)")),
            Map.entry("A323", new Code("A323", 400, "스팸 차단(발신 번호)")),
            Map.entry("A324", new Code("A324", 400, "스팸 차단(수신 번호)")),
            Map.entry("A325", new Code("A325", 400, "발송채널 권한 없음")),
            Map.entry("A326", new Code("A326", 400, "MT fallback 기능 권한 없음")),
            Map.entry("A327", new Code("A327", 400, "미등록 발신번호")),
            Map.entry("A328", new Code("A328", 400, "최대 길이 초과 (필드명 : text)")),
            Map.entry("A329", new Code("A329", 400, "최대 길이 초과 (필드명 : fallback.text)")),
            Map.entry("A330", new Code("A330", 400, "광고 메시지는 야간 차단 시간대(20:00~08:00 KST)에 예약할 수 없습니다.")),
            Map.entry("A331", new Code("A331", 400, "예약 발송 가능 기간(1년 이내)을 초과했습니다.")),
            Map.entry("A332", new Code("A332", 400, "최대 길이 초과 (필드명 : resvName)")),
            Map.entry("A820", new Code("A820", 400, "요청한 데이터가 존재하지 않습니다.")),
            Map.entry("A821", new Code("A821", 400, "세션이 만료되었거나 존재하지 않음")),
            Map.entry("A823", new Code("A823", 400, "예약 발송 가능 시각보다 이른 시간입니다.")),
            Map.entry("A824", new Code("A824", 400, "예약 상태가 요청한 작업을 수행할 수 없는 상태입니다.")),
            Map.entry("A401", new Code("A401", 400, "유효하지 않거나 비어있는 필드 (필드명 : paymentCode)")),
            Map.entry("A402", new Code("A402", 400, "유효하지 않거나 비어있는 필드 (필드명 : clientSubId)")),
            Map.entry("A403", new Code("A403", 400, "유효하지 않거나 비어있는 필드 (필드명 : transferTime)")),
            Map.entry("A404", new Code("A404", 400, "유효하지 않거나 비어있는 필드 (필드명 : formatId)")),
            Map.entry("A406", new Code("A406", 400, "유효하지 않거나 비어있는 필드 (필드명 : RCS button)")),
            Map.entry("A407", new Code("A407", 400, "유효하지 않거나 비어있는 필드 (필드명 : copyallowed)")),
            Map.entry("A408", new Code("A408", 400, "유효하지 않거나 비어있는 필드 (필드명 : expiryOption)")),
            Map.entry("A409", new Code("A409", 400, "유효하지 않거나 비어있는 필드 (필드명 : groupId)")),
            Map.entry("A411", new Code("A411", 400, "유효하지 않거나 비어있는 필드 (필드명 : header)")),
            Map.entry("A412", new Code("A412", 400, "유효하지 않거나 비어있는 필드 (필드명 : footer)")),
            Map.entry("A413", new Code("A413", 400, "유효하지 않거나 비어있는 필드 (필드명 : agencyId)")),
            Map.entry("A415", new Code("A415", 400, "유효하지 않거나 비어있는 필드 (필드명 : rcs.content)")),
            Map.entry("A417", new Code("A417", 400, "RCS Carousel Card 수 초과")),
            Map.entry("A418", new Code("A418", 400, "유효하지 않거나 비어있는 필드 (필드명 : agencyKey)")),
            Map.entry("A419", new Code("A419", 400, "유효하지 않거나 비어있는 필드 (필드명 : brandId)")),
            Map.entry("A420", new Code("A420", 400, "유효하지 않거나 비어있는 필드 (필드명 : brandKey)")),
            Map.entry("A424", new Code("A424", 400, "RCS subContent 수 초과")),
            Map.entry("A425", new Code("A425", 400, "body 필드를 사용할 때, buttons 필드는 선택 사항입니다.")),
            Map.entry("A426", new Code("A426", 400, "유효하지 않거나 비어있는 필드 (button.type)")),
            Map.entry("A427", new Code("A427", 400, "유효하지 않거나 비어있는 필드 (button.name)")),
            Map.entry("A428", new Code("A428", 400, "유효하지 않거나 비어있는 필드 ('MAP_LOC' 버튼)")),
            Map.entry("A429", new Code("A429", 400, "유효하지 않거나 비어있는 필드 ('MAP_QRY' 버튼)")),
            Map.entry("A430", new Code("A430", 400, "유효하지 않거나 비어있는 필드 ('CALENDAR' 버튼)")),
            Map.entry("A431", new Code("A431", 400, "유효하지 않거나 비어있는 필드 ('COPY' 버튼)")),
            Map.entry("A432", new Code("A432", 400, "유효하지 않거나 비어있는 필드 ('COM_T' 버튼)")),
            Map.entry("A433", new Code("A433", 400, "유효하지 않거나 비어있는 필드 ('COM_V' 버튼)")),
            Map.entry("A434", new Code("A434", 400, "유효하지 않거나 비어있는 필드 ('DIAL' 버튼)")),
            Map.entry("A501", new Code("A501", 400, "유효하지 않거나 비어있는 필드 (responseMethod)")),
            Map.entry("A502", new Code("A502", 400, "유효하지 않거나 비어있는 필드 (senderKey)")),
            Map.entry("A503", new Code("A503", 400, "유효하지 않거나 비어있는 필드 (button)")),
            Map.entry("A505", new Code("A505", 400, "유효하지 않거나 비어있는 필드 (templateCode)")),
            Map.entry("A506", new Code("A506", 400, "유효하지 않거나 비어있는 필드 (adFlag)")),
            Map.entry("A513", new Code("A513", 400, "유효하지 않거나 비어있는 필드 (image)")),
            Map.entry("A521", new Code("A521", 400, "유효하지 않거나 비어있는 필드 (item`s tltle/description)")),
            Map.entry("A523", new Code("A523", 400, "유효하지 않거나 비어있는 필드 (msgType)")),
            Map.entry("A524", new Code("A524", 400, "유효하지 않거나 비어있는 필드 (button.type)")),
            Map.entry("A525", new Code("A525", 400, "유효하지 않거나 비어있는 필드 (button.name)")),
            Map.entry("A526", new Code("A526", 400, "유효하지 않거나 비어있는 필드 (timeout)")),
            Map.entry("A559", new Code("A559", 400, "유효하지 않거나 비어있는 필드 (price)")),
            Map.entry("A560", new Code("A560", 400, "유효하지 않거나 비어있는 필드 (item.title/description)")),
            Map.entry("A561", new Code("A561", 400, "유효하지 않거나 비어있는 필드 (item.summary)")),
            Map.entry("A562", new Code("A562", 400, "유효하지 않거나 비어있는 필드 (supplement.quickReply)")),
            Map.entry("A563", new Code("A563", 400, "유효하지 않거나 비어있는 필드 (supplement.quickReply.type)")),
            Map.entry("A564", new Code("A564", 400, "유효하지 않거나 비어있는 필드 (supplement.quickReply.name)")),
            Map.entry("A565", new Code("A565", 400, "유효하지 않거나 비어있는 필드 (header)")),
            Map.entry("A567", new Code("A567", 400, "유효하지 않거나 비어있는 필드 (carousel)")),
            Map.entry("A568", new Code("A568", 400, "잘못된 친구톡 케로셀 요청")),
            Map.entry("A569", new Code("A569", 400, "유효하지 않거나 비어있는 필드 (adult)")),
            Map.entry("A570", new Code("A570", 400, "유효하지 않거나 비어있는 필드 (targeting)")),
            Map.entry("A571", new Code("A571", 400, "유효하지 않거나 비어있는 필드 (sendType)")),
            Map.entry("A572", new Code("A572", 400, "유효하지 않거나 비어있는 필드 (message)")),
            Map.entry("A573", new Code("A573", 400, "유효하지 않거나 비어있는 필드 (attachment)")),
            Map.entry("A601", new Code("A601", 400, "유효하지 않거나 비어있는 필드 (partnerKey)")),
            Map.entry("A602", new Code("A602", 400, "유효하지 않은 필드 (productCode)")),
            Map.entry("A603", new Code("A603", 400, "유효하지 않은 필드 (buttons)")),
            Map.entry("A604", new Code("A604", 400, "유효하지 않은 필드 (type)")),
            Map.entry("A605", new Code("A605", 400, "유효하지 않은 필드 (buttonCode)")),
            Map.entry("A606", new Code("A606", 400, "WEB_LINK 버튼은 mobileUrl 필수입니다")),
            Map.entry("A607", new Code("A607", 400, "APP_LINK 버튼은 aOsAppScheme과 iOsAppScheme 필수입니다")),
            Map.entry("A608", new Code("A608", 400, "유효하지 않은 필드 (gift)")),
            Map.entry("A609", new Code("A609", 400, "유효하지 않은 필드 (coupon)")));

    private ServiceCodes() {
    }

    /**
     * Looks up a service code.
     *
     * @param code code, for example {@code A306}
     * @return the entry, or empty if the code is not in the table
     */
    public static Optional<Code> lookup(String code) {
        return code == null ? Optional.empty() : Optional.ofNullable(CODES.get(code));
    }

    /**
     * All codes in the table.
     *
     * @return unmodifiable map from code to entry
     */
    public static Map<String, Code> all() {
        return CODES;
    }
}
