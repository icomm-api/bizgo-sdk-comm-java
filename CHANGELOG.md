# Changelog

이 프로젝트는 [Semantic Versioning](https://semver.org/lang/ko/)을 따릅니다.

## 1.2.0 - 2026-09-28

**호환되지 않는 변경(breaking change): 1.2.0은 1.1.x(Maven Central `io.github.icomm-api:bizgo-sdk-comm-java` 1.1.1 이하)와 호환되지 않습니다.** 버전 번호만 올리는 업그레이드가 아닙니다. 옮기는 방법은 README의 [이전 버전에서 옮기기](README.md#이전-버전에서-옮기기)를 보세요.

[bizgo-api-spec](https://github.com/icomm-api/bizgo-api-spec) OpenAPI 스펙과 공통 설계 규약(SDK-DESIGN.md)을 기준으로 새로 작성했습니다. 여섯 개 Bizgo SDK의 버전을 1.2.0으로 맞췄습니다.

### 변경 (호환되지 않음)
- 패키지 `net.bizgo.client` → `io.github.icommapi.bizgo`, 진입점 `BizgoClient` → `Bizgo`
- ID/PW 토큰 인증 제거, API Key만 지원(환경변수 `BIZGO_API_KEY` 기본)
- 리소스 구조: `send()`, `files()`, `reports()`, `messages()`. 응답은 엔드포인트별 타입, 실패 코드는 예외
- 모델을 스펙에서 생성(불변, 빌더, 보내기 전 검증). 1.1.x의 손으로 쓴 메시지·버튼·enum 클래스 제거
- 예외를 unchecked `BizgoException` 계층으로 통일
- 의존성: Apache HttpClient·Tika·Lombok·shadow jar 제거, JDK `HttpClient` 사용, Jackson을 정식 의존성으로

### 추가
- 통합 발송 `send().omni()`와 `sms()`/`lms()`/`mms()`, 대체발송, 치환, 멱등성 키(`SendOptions`)
- 채널 모델: SMS, LMS/MMS, 국제, RCS, 알림톡, 브랜드메시지, 네이버 톡톡
- 보내기 전 검증: 필수·알 수 없는 필드, 길이, EUC-KR 바이트 길이(CP949), 허용 값, 항목 수, 수신자 200명
- 이미지 업로드: MMS(300KB 사전 검사), RCS, 브랜드메시지 6종(`BrandImageKind`)
- 리포트: polling(`consume`), 수신 확인, 개별 조회
- 조회: 상태(단건·요청별), 발송 이력·MO 이력(`Iterable`/`Stream` 페이지 자동 순회), 통계, MO 단건
- 웹훅: 서명 검증(hex/base64, constant-time, timestamp 허용 오차), 리포트·MO 파싱
- 오류 계층(게이트웨이/상품 단계 구분, 에러코드 설명 `ServiceCodes`), 재시도(429·5xx·네트워크, 발송은 멱등성 키가 있을 때만, `Retry-After`)
- 기본 타임아웃(요청 30초, 연결 5초), `System.Logger` DEBUG 로그(민감정보 없음)
- **전체 API(스펙의 146개 operation)**: `x-sdk-*` 메타데이터에서 리소스 클래스·메서드를 생성(`client.reservations()`, `insights()`, `kakao()`, `alimtalk()`, `brandMessage()`, `rcs()`, `counsel()`의 하위 리소스, `files()`의 추가 업로드). 경로 파라미터·요청 본문 모델·쿼리 파라미터 객체(`io.github.icommapi.bizgo.params.*Params`, 빌더+검증), `x-sdk-result` 반환 타입, `x-sdk-retry` 재시도, `x-sdk-pagination`(cursor/page/offset)의 `iter*`/`stream*` 순회, multipart 요청 모델(파일 필드는 `FileUpload`). 직접 만든 메서드가 이름이 같으면 우선
- `Operation` 메타데이터(`Operation.all()`, `find`, `match`), 예약 발송용 `ReservationMessageFlowItem`
- 상담톡 웹훅 파서 7종(`WebhookReceiver.counselMessage(headers, body)` 등, secret 없이 쓰는 정적 `WebhookReceiver.parseCounselMessage(body)` 등)과 `Webhooks.counselAck()`. 상담톡 웹훅에는 서명이 없으므로(서명은 리포트·MO 웹훅에만 적용) 서명 헤더를 검사하지 않고 본문 검사(크기·JSON 깊이 64·타입)만 함
- 대량 발송 `send().bulk(...)`(`BulkOptions`: chunkSize 1~200, concurrency, `idempotencyKeyPrefix` → `<prefix>-<청크 번호>`), 결과 `BulkSendResult`(청크별 결과·오류·합계)
- 클라이언트 속도 제한(토큰 버킷, 기본 켜짐, `rateLimit(RateLimit)`/`rateLimit(null)`, 프로세스 단위): send는 **초당 200 메시지(수신번호 기준)**로 요청 비용 = `destinations` 수(최소 1), other는 초당 5 요청. 용량 = 초당 한도, 용량보다 큰 요청은 가득 찰 때까지 기다린 뒤 빚으로 남김(교착 없음), 재시도도 시도마다 대기. send 버킷 대상은 스펙의 `x-sdk-rate: send`에서 생성(상담톡 plain/rich 발송 포함, 하드코딩 목록 없음)
- SDK 식별 헤더: `User-Agent: bizgo-sdk-comm-java/<ver> java/<ver> (<os>; <arch>)[ app/<name>-<ver>]`, `X-Bizgo-Client: bizgo-sdk-comm-java/<ver>`, 선택 `appInfo(name, version)`(허용 문자 검증). `Authorization`·`User-Agent`·`X-Bizgo-Client`는 덮어쓸 수 없음
- `reservations().create(...)`는 스펙의 `x-sdk-result: data`에 따라 `resvKey`와 수신자별 결과를 함께 돌려줌(`ReservationCreateServiceResult`)
- 관측: `RequestHook`/`RequestEvent`(operationId, resource.method, HTTP method, 경로 템플릿, 상태, layer/code, 시도 횟수, 소요 시간 — 본문·쿼리·값·키 없음), `HttpTransport` 교체 지점
- 별도 아티팩트 `bizgo-sdk-comm-java-testing`(`FakeTransport`, `RecordedRequest`, `FakeResponses`, `WebhookSigner`)과 `bizgo-sdk-comm-java-opentelemetry`(`BizgoTracing`). 코어의 런타임 의존성은 계속 jackson-databind 하나

### 수정 (1.1.x 결함)
- 여러 클라이언트가 static 인증 토큰을 공유하던 문제
- RCS `buttons`가 직렬화되지 않던 문제
- 본문 없는 오류 응답에서 NullPointerException
- 경로 파라미터를 인코딩하지 않던 문제
- POM `url`/`scm`이 다른 저장소(infobank-omni-sdk-java)를 가리키던 문제, `settings.gralde` 오타

### 조건부 필수 필드 검사 (`x-sdk-required-if`, SDK-DESIGN §4)
- 스펙의 `x-sdk-required-if`를 생성기가 규칙 표(`models/GeneratedRequiredIf`)로 만들고 `RequiredIf` 하나가 보내기 전에 검사합니다(`ValidationException`, 서버 호출·재시도·속도 제한 토큰 없음). 메시지에는 필드 경로·인덱스와 조건만 담기고 입력값은 담기지 않습니다.
- **동작 변경**: 알림톡 전문 발송(`sendType` 없음 또는 `template`이 아님)은 `msgType`(`AT`/`AI`)과 `text`가 필수입니다(서버가 A523으로 거절하던 요청, 2026-09-28 sandbox 확인). `sendType("template")`이면 둘 다 필요 없고 모든 `destinations[].replaceWords`가 필요합니다.
- 그 밖의 규칙: 브랜드메시지 `sendType`별 `msgType`·`templateCode`·`targeting`·`replaceWords`, 브랜드메시지 버튼 `WL`(`urlPc`·`urlMobile`)·`AL`(`urlMobile`), RCS `header` `1` → `footer`, 상담톡 Plain `FILE`(`attachment.file.fileName`·`fileSize`)·Rich 타입별 첨부.
- `$.` 경로 규칙은 `SendOmniRequest`·`ReservationCreateRequest`의 `build()`(`omni`, `request`의 `fromJson`/`fromMap`, `bulk`)에서 검사합니다. `bulk`는 모든 청크 요청을 먼저 만들어 검증한 뒤 보냅니다.
- `AlimtalkTemplate.getMsgType()` 추가(응답, 알려진 값 `AT`/`AI`, 문자열 그대로). 전문 발송의 `msgType`에 그대로 쓸 수 있습니다.
- 수정: `send().bulk(List.of(...), ...)`가 불변 목록의 null 검사에서 `NullPointerException`을 내던 문제.

### 멱등성 키 유효시간 기본값 (SDK-DESIGN 12.20)
- `Bizgo.DEFAULT_IDEMPOTENCY_TTL = 86400`: `idempotencyKey`만 주고 `idempotencyTtl`을 생략하면 SDK가 86400초를 채워 보냅니다(비즈고는 TTL 없는 키를 A309로 거절, 2026-09-28 sandbox 확인). 명시한 TTL(0 포함)은 그대로, 키가 없으면 TTL을 넣지 않습니다. `send().omni/sms/lms/mms/request/bulk`와 본문에 `idempotencyKey`·`idempotencyTtl`이 모두 있는 생성 메서드(생성기 `ResourceGenerator`)에 적용되며, 입력 객체·Map은 바꾸지 않습니다.

### 보안·편의성 검토 반영 (SDK-DESIGN 12)
- 대량 발송 멱등성 키를 `<prefix>-<chunkSize>-<startIndex>-<hash8>`(청크 수신번호 SHA-256 앞 8자리)로 변경. prefix 176자·키 200자 제한. 청크마다 모든 예외를 잡고, `Error`·인터럽트 시 `BulkSendException.getPartialResult()`로 접수된 결과 보존(인터럽트 플래그 복원)
- `Authenticator`가 있는 `HttpClient` 거부(API Key가 바뀌고 401 뒤 발송이 재전송되던 문제)
- 재시도(네트워크 오류·5xx·429) 뒤 `A301`이면 `DuplicateRequestException.isAlreadyAccepted()` = true와 안내
- 수신자별 `A301`(같은 `idempotencyKey`로 다시 보냄, 요청은 HTTP 200·성공 코드, 2026-09-28 sandbox 확인): `SendResult.getDuplicates()`·`BulkSendResult.getDuplicates()` 추가. 이 수신자는 `getFailed()`(거절)·`getSucceeded()`·`getMsgKeys()`에 넣지 않습니다. 모든 수신자가 A301인 대량 발송 청크는 오류가 아니며 `isComplete()`에 영향이 없습니다. `BulkSendResult.toString()`에 `duplicates` 건수. 테스트 도구: `thenDuplicateSendResult()`, 가짜 응답의 A301 수신자 `result`는 `Duplicated`. 요청 단위 A301(`DuplicateRequestException`)은 그대로
- 응답 변환 실패(목록의 `null` 등, 이전에는 NullPointerException)를 `InvalidResponseException`(HTTP 상태·`getTrackingId()`·`getBody()`, 발송이면 "접수됐을 수 있음" 안내)으로 감싸고, hook·OpenTelemetry에 실패로 보고
- 3xx 응답 오류에 `HTTP <status>`와 리다이렉트 안내. `Retry-After`는 0 이상의 유한한 값만 사용. JSON 중첩 64단계 제한(모든 언어 SDK 공통)
- 웹훅: `X-IB-Timestamp` ASCII 숫자 1~16자리(19자리 값의 NumberFormatException 수정), 공백 secret·0 이하 tolerance는 `ConfigurationException`
- `ApiException`·`InvalidResponseException`의 본문, `ValidationException`의 위반 목록이 Java 직렬화 후에도 유지
- `toString()` 마스킹: 전화번호 `010****0000`, 본문은 길이만(`***(12자)`)
- `internal.Json`의 공개 가변 ObjectMapper 제거(정적 헬퍼만 노출)
- 테스트 도구: 업로드 기본 응답에 가짜 `fileKey`/`media`/`imgUrl`
- hook(과 OpenTelemetry 어댑터)이 던진 예외는 결과·재시도·대량 발송 결과에 영향을 주지 않음(클라이언트당 한 번 WARNING 로그, 값 없음)
- API Key 앞뒤 공백을 조용히 지우지 않고 설정 오류로 처리(`[!-~]`만 허용, 환경변수 포함)
- 3xx는 어떤 재시도 정책에서도 재시도하지 않음
- 읽을 수 없는 업로드 파일(없음·권한·디렉터리)은 파일 이름만 담은 `ValidationException`(전체 경로·IOException 노출 없음)
- JSON 중첩 한도 64단계
- 사용자 HTTP 계층: 직접 구현한 `HttpTransport`는 `trustHttpTransport(true)` 없이는 거부(`FakeTransport` 제외), `CookieHandler`가 있는 `HttpClient` 거부, SDK 옵션 `proxy(...)`·`sslContext(...)` 추가
- 마스킹 확대: 쿼리 파라미터(`*Params`)·`MoHistoryQuery` 등 옵션 객체에도 적용, 8~10자리 번호는 절반 이상·7자리 이하는 전부 가림, 이름·닉네임·이메일은 첫 글자만
- 성공 응답에 `data.data`가 없거나 null이어도 null을 돌려주지 않음(빈 결과 객체·빈 목록) — 모든 operation 표 테스트
- 빌드: `buildSrc/gradle.lockfile`, gradle을 실행하는 모든 CI job에 wrapper 검증, `SIGNING_KEY` 없이 배포하면 실패
