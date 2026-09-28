# bizgo-sdk-comm-java

> [!IMPORTANT]
> **1.2.0은 1.1.x와 호환되지 않습니다.** Maven Central의 `io.github.icomm-api:bizgo-sdk-comm-java` 1.1.1 이하(`net.bizgo.client.BizgoClient`)와 패키지·진입점·인증·응답 타입이 모두 다르므로, 버전 번호만 올려서는 컴파일되지 않습니다. 올리기 전에 [이전 버전에서 옮기기](#이전-버전에서-옮기기)를 보세요.

[비즈고(Bizgo)](https://bizgo.io) 커뮤니케이션 API의 Java SDK입니다.
SMS/LMS/MMS, 국제문자, RCS, 카카오 알림톡·브랜드메시지, 네이버 톡톡을 하나의 클라이언트로 발송하고, 리포트·이력·통계를 조회하고, 웹훅을 검증합니다.

- Java 17 이상 · 런타임 의존성은 Jackson(`jackson-databind`) 하나 · HTTP는 JDK 내장 `java.net.http.HttpClient`
- 요청 모델은 보내기 전에 검증합니다: 필수 필드, 알 수 없는 필드, **바이트 길이**(SMS 90byte 등, EUC-KR 기준), EUC-KR 범위 밖 문자(이모지), 허용 값, 항목 수
- 모델과 **전체 API(146개 operation)의 메서드**를 스펙에서 생성합니다: [bizgo-api-spec](https://github.com/icomm-api/bizgo-api-spec) (OpenAPI 3.1) · 원문: [API 레퍼런스](https://developers.bizgo.io/api-sdk/api-reference)
- 편의 기능: [대량 발송](#대량-발송), 클라이언트 [속도 제한](#속도-제한), [테스트 도구](#테스트)(`-testing` 아티팩트), [관측](#관측observability)(hook, 선택 OpenTelemetry 아티팩트)

## 설치

Gradle:

```groovy
implementation 'io.github.icomm-api:bizgo-sdk-comm-java:1.2.0'
```

Maven:

```xml
<dependency>
  <groupId>io.github.icomm-api</groupId>
  <artifactId>bizgo-sdk-comm-java</artifactId>
  <version>1.2.0</version>
</dependency>
```

선택 아티팩트(같은 버전): `bizgo-sdk-comm-java-testing`(테스트 도구, [테스트](#테스트)), `bizgo-sdk-comm-java-opentelemetry`(tracing, [관측](#관측observability)).

## 시작하기

1. 콘솔 `발송관리 > 연동관리`에서 **API Key**를 발급하고, 호출할 서버의 **공인 IP를 등록**합니다.
2. 키를 환경변수로 설정합니다. 키는 코드나 저장소에 쓰지 않습니다.

```bash
export BIZGO_API_KEY=...
```

3. sandbox(실제 발송 없음)에서 먼저 확인합니다.

```java
import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.Environment;
import io.github.icommapi.bizgo.models.SendResult;

try (Bizgo client = Bizgo.builder().environment(Environment.SANDBOX).build()) { // 키는 BIZGO_API_KEY에서 읽음
    SendResult result = client.send().sms("01000000000", "01000000000", "[비즈고] 인증번호는 123456 입니다.");
    System.out.println(result.getMsgKeys()); // 접수된 메시지 키
    System.out.println(result.getFailed());  // 접수 단계에서 거절된 수신자 (없으면 []). 같은 멱등성 키로 이미 접수된 수신자는 getDuplicates()
}
```

운영에 보낼 때는 `environment(...)`를 생략하거나 `Environment.PRODUCTION`을 씁니다.
`Bizgo`는 스레드 안전하므로 API Key마다 하나를 만들어 재사용하세요.

> **접수 ≠ 발송 완료.** `send()`의 결과는 접수 결과입니다. 최종 결과는 [리포트](#리포트)로 받습니다.

## 발송

모든 채널은 `client.send().omni(...)` 하나로 보냅니다. 메시지를 여러 개 넣으면 **앞 메시지가 실패할 때 다음 메시지로 대체발송**됩니다.

```java
import io.github.icommapi.bizgo.SendOptions;
import io.github.icommapi.bizgo.models.*;

SendResult result = client.send().omni(
        List.of(Destination.builder().to("01000000000").replaceWords(Map.of("name", "홍길동")).build()), // 최대 200명
        List.of(
                AlimtalkMessage.builder().senderKey("SENDER_KEY_EXAMPLE").templateCode("TEMPLATE_CODE_EXAMPLE")
                        .msgType("AT").text("#{name}님, 주문이 접수되었습니다.").build(),
                SmsMessage.builder().from("01000000000").text("#{name}님, 주문이 접수되었습니다.").build()), // 알림톡 실패 시
        SendOptions.builder()
                .idempotencyKey("order-20260923-0001") // 권장: 재시도해도 중복 발송되지 않음 (idempotencyTtl 기본 86400)
                .ref("order-20260923-0001")            // 리포트에 그대로 돌아오는 참조값
                .build());
```

`idempotencyKey`를 주고 `idempotencyTtl`을 생략하면 SDK가 `idempotencyTtl`을 `Bizgo.DEFAULT_IDEMPOTENCY_TTL`(86400초 = 24시간)로 채워 보냅니다(비즈고는 키만 있고 TTL이 없으면 A309로 거절). 직접 준 값(0~86400, `0` 포함)은 그대로 보내고, 키가 없으면 TTL도 보내지 않습니다. `send().request(...)`(`fromJson`/`fromMap`으로 만든 요청 포함), `send().bulk`의 청크 키, 본문에 `idempotencyKey`·`idempotencyTtl`이 모두 있는 생성 메서드에도 같은 규칙이 적용되며, 넘긴 요청 객체·Map은 바꾸지 않습니다.

간단한 경우:

```java
client.send().omni("01000000000", alimtalk, sms);                       // 수신자 1명, 대체발송 순서대로
client.send().omni(List.of("01000000000", "01000001234"), sms);         // 여러 명
client.send().request(SendOmniRequest.fromJson(json));                   // API 문서의 JSON 그대로 (검증 후 발송)
```

| 채널 | 모델 | 간편 메서드 |
|---|---|---|
| SMS (90byte) | `SmsMessage` | `send().sms()` |
| LMS (2,000byte) | `MmsMessage` (`fileKey` 없음) | `send().lms()` |
| MMS | `MmsMessage` (`fileKey` 최대 3개) | `send().mms()` |
| 국제문자 | `InternationalMessage` | |
| RCS | `RcsMessage` | |
| 카카오 알림톡 | `AlimtalkMessage` | |
| 카카오 브랜드메시지 | `BrandMessage` | |
| 네이버 톡톡 | `NaverTalkMessage` | |

- 모델은 불변 객체이고 `X.builder()...build()`로 만듭니다. `build()`에서 검증하며, 잘못되면 `ValidationException`이 납니다(보내기 전).
- 조건부 필수 필드(스펙의 `x-sdk-required-if`)도 보내기 전에 검사합니다. 알림톡 전문 발송(`sendType`이 `template`이 아님)은 `msgType`(`AT` 텍스트형·`AI` 이미지형)과 `text`가 필수입니다(빠지면 서버가 A523으로 거절). `msgType`은 템플릿 조회 결과(`AlimtalkTemplate.getMsgType()`)의 값을 그대로 쓰면 됩니다. 템플릿 자동 치환(`sendType("template")`)은 `msgType`·`text` 없이 보내고, 대신 모든 `destinations[].replaceWords`가 필요합니다. 그 밖에 브랜드메시지 `sendType`별 필드, 버튼 `WL`(`urlPc`·`urlMobile`)·`AL`(`urlMobile`), RCS `header("1")` → `footer`, 상담톡 Plain `FILE`·Rich 타입별 첨부가 있습니다. 요청 전체가 필요한 규칙(`$.destinations[]...`)은 `SendOmniRequest`·`ReservationCreateRequest`를 만들 때(`omni`, `bulk`, `fromJson`/`fromMap`) 검사하며, 오류에는 경로(`SendOmniRequest.destinations[1].replaceWords`)와 조건만 담깁니다.
- 필드 이름은 API와 같습니다(`senderKey`, `from`). 설정한 필드만 전송되고, 스펙 기본값은 보내지 않습니다(서버 기본값 사용).
- SMS가 90byte를 넘는지 미리 알고 싶으면 `MessageBytes.euckr(text)`를 씁니다.

### 이미지

```java
FileUploadResult uploaded = client.files().uploadMms(Path.of("banner.jpg")); // jpg, 최대 300KB (넘으면 보내기 전 오류)
client.send().mms("01000000000", "01000000000", "...", List.of(uploaded.getFileKey()));

client.files().uploadRcs(Path.of("card.png"));                                // -> getMedia()
client.files().uploadBrandMessage(Path.of("wide.jpg"), BrandImageKind.WIDE);  // -> getImgUrl()
client.files().uploadMms(FileUpload.of(bytes, "banner.jpg").imageName("event")); // 바이트로 올리기
```

## 리포트

콘솔에서 API Key별로 리포트 수신 방식(POLLING 또는 WEBHOOK)을 정합니다.

**Polling** — 처리에 성공한 배치만 수신 확인(ack)합니다. 처리 함수가 예외를 내면 같은 배치를 다시 받습니다.

```java
int handled = client.reports().consume(reports -> {
    for (Report r : reports) {
        db.upsert(r.getMsgKey(), r.getReportCode()); // 같은 리포트가 다시 올 수 있으니 upsert
    }
});
```

**Webhook** — 서명을 검증하고 5초 안에 `{"msgKey": ...}`로 응답합니다. 웹훅 secret은 비즈고에 요청해 별도로 받습니다.

```java
WebhookReceiver receiver = new WebhookReceiver(System.getenv("BIZGO_WEBHOOK_SECRET"));

// 사용하는 웹 프레임워크의 핸들러 안에서 (headers: Map<String, String> 또는 Map<String, List<String>>)
try {
    ReportWebhookPayload report = receiver.report(headers, rawBody);
    enqueue(report);                                   // 무거운 처리는 비동기로
    return ok(Webhooks.ackJson(report.getMsgKey()));   // {"msgKey":"..."}
} catch (WebhookVerificationException e) {
    return status(401);
}
```

> 웹훅 서명과 timestamp 허용 오차를 검증하세요. 운영 환경에서는 HTTPS, 비즈고 웹훅 발신 IP 허용 목록, `msgKey` 기준 중복 제거를 함께 적용하고, 중요한 판단은 리포트·상태 조회 API로 결과를 확인하세요.

**개별 조회** — `client.reports().inquiry(msgKey)` (30일 이내)

## 조회

```java
client.messages().status(msgKey);                  // 단건 상태 (대체발송 시 채널별 항목)
client.messages().statusByRequestId(requestId);    // 동보 요청 전체 (msgKey에서 끝 3자리를 뺀 값)
client.messages().statistics(LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 23), "SMS", null);

// 페이지(lastSeq)를 자동으로 따라감. LocalDateTime은 KST, 시간대가 있는 값은 KST로 변환
for (MessageStatus m : client.messages().iterHistory(
        HistoryQuery.since(LocalDateTime.of(2026, 9, 23, 9, 0)).serviceTypes("SMS", "ALIMTALK"))) {
    ...
}
client.messages().streamHistory(HistoryQuery.since(Instant.now().minus(1, ChronoUnit.HOURS)))
        .filter(m -> !"10000".equals(m.getReportCode()))
        .forEach(...);

// MO(수신) 이력. occurredTime은 +09:00 오프셋으로 보냄
client.messages().iterMoHistory(MoHistoryQuery.since(LocalDateTime.of(2026, 9, 23, 9, 0)).limit(500));
```

조회 API의 기본 호출 한도는 초당 5회입니다. `limit`은 1~1000이며 범위 밖이면 보내기 전에 오류가 납니다.

## 전체 API

위의 발송·업로드·리포트·조회 외에 **스펙의 모든 operation(146개)** 을 쓸 수 있습니다. 메서드는 스펙의 `x-sdk-*` 메타데이터에서 생성되며, 위치는 `client.<리소스>().<하위 리소스>().<메서드>(...)`입니다.

| 리소스 | 예 |
|---|---|
| `reservations()` · `reservations().recipients()` | 예약 발송 등록·조회·수정·취소·일시정지·재개, 예약 수신자 |
| `insights().alimtalk()` · `insights().brandMessage()` · `insights().rcs()` | 채널별 인사이트(통계) |
| `kakao().senders()` · `categories()` · `groups()` · `sanctions()` | 카카오 발신프로필·카테고리·그룹·제재 |
| `alimtalk().templates()` · `templateCategories()` · `publicTemplates()` | 알림톡 템플릿 관리·검수 |
| `brandMessage().groupSends()` · `templates()` · `friendGroups()` · `videos()` … | 브랜드메시지 동보·템플릿·친구 그룹 |
| `rcs().brands()` · `chatbots()` · `templates()` · `templateForms()` … | RCS 브랜드·챗봇·템플릿 |
| `counsel().messages()` · `sessions()` · `channels()` · `systemMessages()` … | 카카오 상담톡 |
| `files()` | 위의 업로드 + 알림톡 템플릿·아이템하이라이트 이미지, 브랜드메시지 카탈로그 이미지 |

인자 순서는 **경로 파라미터 → 요청 본문 모델 → 쿼리 파라미터 객체**입니다. 요청 본문은 발송 모델처럼 `build()`에서 검증되고, 쿼리 파라미터는 `io.github.icommapi.bizgo.params.<OperationId>Params` 빌더로 만듭니다(필수 값·허용 값 검증).
반환값은 스펙의 `x-sdk-result`가 가리키는 응답 부분입니다(기본 `data.data`, 데이터가 없는 응답은 `void`).

```java
import io.github.icommapi.bizgo.models.*;
import io.github.icommapi.bizgo.params.ListAlimtalkTemplatesParams;

// 알림톡 템플릿 목록 (offset 페이지를 자동으로 순회)
for (AlimtalkTemplate t : client.alimtalk().templates().iterList(
        ListAlimtalkTemplatesParams.builder().senderKey("SENDER_KEY_EXAMPLE").limit(100).build())) {
    System.out.println(t.getTemplateCode() + " " + t.getInspectionStatus());
}

// 예약 발송: 채널 메시지를 ReservationMessageFlowItem으로 감쌉니다
ReservationCreateServiceResult created = client.reservations().create(ReservationCreateRequest.builder()
        .destinations(Destination.builder().to("01000000000").build())
        .messageFlow(ReservationMessageFlowItem.of(SmsMessage.builder().from("01000000000").text("예약 안내").build()))
        .resvSendTime("2026-12-31 09:00:00")
        .build());
String resvKey = created.getResvKey();              // 예약 키 (취소·수정에 사용)
created.getData().getDestinations();                // 수신자별 접수 결과
Reservation cancelled = client.reservations().cancel("RESV_KEY_EXAMPLE");

// 경로 파라미터는 앞에, 자동으로 URL 인코딩됩니다
client.alimtalk().templates().delete("SENDER_KEY_EXAMPLE", "TEMPLATE_CODE_EXAMPLE");
```

- **페이지 순회**: 스펙에 `x-sdk-pagination`이 있는 목록은 `iter<메서드>(...)`(`Iterable`, 게으르게 조회)와 `stream<메서드>(...)`(`Stream`)가 함께 생성됩니다. cursor는 `hasNext`가 false이거나 커서가 없거나 움직이지 않으면, page·offset은 빈 페이지·요청한 크기보다 작은 페이지·`total` 도달 시 멈춥니다. 같은 페이지가 반복되면 멈춥니다.
- **재시도**: operation마다 스펙의 `x-sdk-retry`를 따릅니다. `safe`(조회, 멱등 PUT/DELETE)는 429·5xx·네트워크 오류를, `rate_limit_only`(생성·발송·업로드)는 429만 재시도합니다.
- **업로드**: `file`(+ `fileKey`/`imageName`)만 받는 업로드는 `FileUpload`/`Path`를, 그 밖의 multipart 요청(`rcs().brands().update(...)` 등)은 생성된 요청 모델(파일 필드는 `FileUpload`)을 받습니다. 파일은 한 번 읽어 재시도에 재사용합니다.
- 직접 만든 편의 메서드(`send().sms`, `reports().consume`, `messages().iterHistory` 등)는 그대로이며, 같은 이름이면 편의 메서드가 우선합니다.
- 모든 operation 목록과 메타데이터는 `Operation.all()`로 볼 수 있습니다.

### 상담톡 웹훅

`WebhookReceiver`에 상담톡 웹훅 파서가 생성되어 있습니다: `counselMessage`, `counselReference`, `counselExpiredSession`, `counselSeenInfo`, `counselPersonalInfo`, `counselCertResult`, `counselResult`. 응답은 `Webhooks.counselAckJson()`(`{"code":"A000","result":"Success"}`)입니다.

상담톡 웹훅에는 서명이 없습니다(서명은 리포트·MO 웹훅에만 적용). 그래서 상담톡 파서는 서명을 요구하거나 검사하지 않고(서명 헤더가 와도 무시), 본문 크기 제한(1 MiB)·JSON 깊이 64·타입 검사만 한 뒤 타입이 있는 페이로드를 돌려줍니다. 웹훅 secret도 필요 없습니다.

상담톡만 받는 엔드포인트는 secret 없이 정적 파서를 씁니다.

```java
CounselMessageWebhookPayload message = WebhookReceiver.parseCounselMessage(rawBody);
return Webhooks.counselAckJson();
```

정적 파서는 7종 모두 있습니다: `parseCounselMessage`, `parseCounselReference`, `parseCounselExpiredSession`, `parseCounselSeenInfo`, `parseCounselPersonalInfo`, `parseCounselCertResult`, `parseCounselResult`. 리포트·MO용 `WebhookReceiver`(secret 필요)가 이미 있다면 `receiver.counselMessage(headers, rawBody)`처럼 인스턴스 메서드를 써도 결과는 같습니다. 리포트·MO 웹훅은 항상 서명이 필요합니다.

상담톡 수신 엔드포인트에는 HTTPS와 비즈고 웹훅 발신 IP 허용 목록을 적용하고, 재전송으로 같은 이벤트가 다시 올 수 있으니 `msgKey`가 있으면 그것으로 중복을 제거하세요. 상담톡 웹훅에는 사용자 식별자·상담 내용·암호화된 인증 결과가 있으니 로그에 남기지 마세요.

## 대량 발송

`send().bulk(...)`는 수신자 수 제한 없이 `chunkSize`(1~200, 기본 200)씩 나눠 `omni`를 호출하고, 최대 `concurrency`(기본 4)개를 동시에 보냅니다. 한 요청이 실패해도 나머지는 계속 보냅니다.

```java
BulkSendResult result = client.send().bulk(numbers, List.of(sms),
        BulkOptions.builder()
                .idempotencyKeyPrefix("campaign-20260923")   // 키: campaign-20260923-<chunkSize>-<시작 인덱스>-<hash8>
                .concurrency(4)
                .build());
System.out.println(result.getSucceeded().size() + " accepted, " + result.getFailed().size() + " rejected");
for (BulkSendResult.ChunkError e : result.getErrors()) {        // 요청 전체가 실패한 청크 (인덱스 범위만)
    retryLater(numbers.subList(e.fromIndex(), e.toIndex()), e.error());
}
```

- `idempotencyKeyPrefix`가 있으면 요청마다 `<prefix>-<chunkSize>-<시작 인덱스>-<hash8>`을 멱등성 키로 씁니다. `hash8`은 그 청크의 수신번호 목록(순서 포함)을 SHA-256으로 해시한 앞 8자리입니다(`BulkOptions.idempotencyKey(...)`). 그래서 같은 키가 다른 수신자 묶음에 쓰이는 일이 없고, 타임아웃도 재시도합니다. `idempotencyTtl`을 주지 않으면 청크마다 86400(`Bizgo.DEFAULT_IDEMPOTENCY_TTL`)을 보냅니다. 없으면 재시도 정책은 일반 발송과 같습니다(429만).
- **재실행은 같은 목록·같은 prefix·같은 `chunkSize`로** 하세요. 그러면 키가 같아 이미 접수된 청크는 다시 발송되지 않습니다(목록·순서·chunkSize를 바꾸면 키가 달라져 중복 발송될 수 있음). 실패한 청크만 다시 보내려면 `getErrors()`의 청크 번호와 인덱스 범위(`fromIndex`~`toIndex`)를 쓰세요. prefix는 176자 이하(생성된 키는 200자 이하)여야 합니다.
- 한 청크의 어떤 실패도 다른 청크와 이미 받은 결과를 잃게 하지 않습니다. 치명적 오류(`Error`)나 스레드 인터럽트가 나면 `BulkSendException`이 나고 `getPartialResult()`에 접수된 청크의 결과가 있습니다(인터럽트 플래그는 복원).
- 결과: `getResults()`(청크 번호 → `SendResult`), `getErrors()`(청크 번호·수신자 인덱스 범위·예외), 전체 합계 `getSucceeded()`/`getDuplicates()`/`getFailed()`/`getMsgKeys()`. 같은 prefix로 다시 실행하면 이미 접수된 수신자는 `getDuplicates()`에 모이고, 모든 수신자가 `A301`인 청크도 오류가 아닌 접수된 요청으로 셉니다(`isComplete()`에 영향 없음). 로그·예외·`toString()`에는 수신자 번호를 넣지 않습니다.
- 아래 속도 제한(send 버킷)이 함께 적용됩니다.

## 속도 제한

클라이언트마다 토큰 버킷 2개로 요청 속도를 제한합니다(기본 켜짐). 토큰이 모자라면 요청 전에 기다리며, 재시도도 시도마다 다시 기다립니다.

| 버킷 | 기본 | 요청 1건의 비용 | 대상 operation (스펙의 `x-sdk-rate: send`) |
|---|---|---|---|
| send | **초당 200 메시지(수신번호 기준)** | 요청의 `destinations` 수(최소 1, 수신자 목록이 없는 발송은 1) | `send.omni`(`send().sms/lms/mms/omni/request/bulk`), `reservations.create`, `reservations.recipients.create`, `brandMessage.groupSends.create`, `counsel.messages.sendPlain`, `counsel.messages.sendRich` |
| other | 초당 5 요청 | 1 | 그 밖의 전부(조회, 업로드, 템플릿 관리 등) |

- 수신자 200명짜리 요청은 토큰 200개를 쓰므로 기본 한도에서 초당 1건만 나갑니다. `bulk`도 같아서 1,000명은 약 4~5초에 걸쳐 나갑니다.
- 버킷 용량(순간 허용량)은 초당 한도와 같습니다. 한도를 요청 크기보다 낮게 잡아도(예: 100/초에 200명 요청) 버킷이 가득 찰 때까지 기다린 뒤 보내고 부족분은 다음 요청이 갚으므로, 멈추지 않고 평균 속도를 지킵니다.
- 어떤 operation이 send 버킷인지는 SDK에 목록으로 두지 않고 스펙의 `x-sdk-rate`에서 생성합니다(`Operation.getRateBucket()`).

```java
Bizgo.builder().rateLimit(RateLimit.of(100, 5)).build();   // 값 변경
Bizgo.builder().rateLimit(null).build();                   // 끄기
```

> **프로세스 단위입니다.** 비즈고의 한도(발송 초당 200 메시지, 그 외 초당 5 요청)는 **계정(API Key) 단위**입니다. 여러 프로세스·서버·클라이언트 인스턴스가 같은 키를 쓰면 이 제한만으로는 한도를 지킬 수 없습니다. 인스턴스 수로 나눈 값을 설정하거나 공유 제한기를 쓰세요. 한도를 넘어 받은 429(`A020`)는 계속 재시도합니다. operation별 버킷은 `Operation.getRateBucket()`으로 확인할 수 있습니다.

## SDK 식별 정보

비즈고가 SDK 사용 현황(언어·버전·런타임)을 파악할 수 있도록 모든 요청에 다음 헤더를 붙입니다.

| 헤더 | 값 |
|---|---|
| `User-Agent` | `bizgo-sdk-comm-java/<SDK 버전> java/<Java 버전> (<OS>; <CPU>)[ app/<앱 이름>-<앱 버전>]` 예: `bizgo-sdk-comm-java/1.2.0 java/21.0.11 (linux; x64)` |
| `X-Bizgo-Client` | `bizgo-sdk-comm-java/<SDK 버전>` (프록시가 User-Agent를 바꿔도 남도록) |

- OS는 `linux`/`windows`/`darwin`/`freebsd`/`other`, CPU는 `x64`/`arm64`/`x86`/`arm`/`other`만 보냅니다. 호스트명·사용자명·커널 버전·IP 같은 값은 넣지 않고, **이 헤더 외에 SDK가 따로 수집하거나 전송하는 정보는 없습니다**(phone-home 없음).
- 선택: `Bizgo.builder().appInfo("myshop", "1.4.2")`로 앱 이름·버전을 덧붙일 수 있습니다. 이름은 `[A-Za-z0-9._-]` 1~50자, 버전은 `[A-Za-z0-9._+-]` 1~30자만 허용하고 그 밖(공백, 줄바꿈, `@` 등)은 설정 오류입니다. 이메일·전화번호 같은 개인정보를 넣지 마세요.
- `Authorization`, `User-Agent`, `X-Bizgo-Client`는 다른 옵션이나 `HttpTransport`로 덮어쓸 수 없습니다.

## 테스트

`bizgo-sdk-comm-java-testing` 아티팩트(테스트 의존성으로만)로 네트워크·API Key 없이 SDK를 쓰는 코드를 테스트합니다.

```groovy
testImplementation 'io.github.icomm-api:bizgo-sdk-comm-java-testing:1.2.0'
```

```java
import io.github.icommapi.bizgo.testing.*;

FakeTransport fake = new FakeTransport();
Bizgo client = fake.client();          // 가짜 키(test-api-key-not-real), 속도 제한 끔, 네트워크 연결 없음

client.send().sms("01000000000", "01000000000", "hello");         // 기본: 수신자마다 A000 + 가짜 msgKey
RecordedRequest request = fake.lastRequest();
assertEquals("sendOmni", request.getOperationId());
assertEquals("hello", request.getJsonBody().at("/messageFlow/0/sms/text").asText());

fake.on("sendOmni")
        .thenFail(ErrorLayer.SERVICE, 429, "A020")      // 다음 호출: 속도 제한 (Retry-After: 0이라 바로 재시도)
        .thenSendResult("A000", "A306");                // 그다음: 두 번째 수신자 거절
fake.on("getReportPolling").thenFail(ErrorLayer.GATEWAY, 401, "A401");
fake.on("listReservations").thenData("{\"reservations\":[],\"hasNext\":false}");

// 웹훅 테스트 요청 (서명 방식은 실제와 같음)
WebhookSigner.SignedWebhook hook = WebhookSigner.sign("test-webhook-secret", "{\"msgKey\":\"K001\"}");
ReportWebhookPayload report = new WebhookReceiver("test-webhook-secret").report(hook.headers(), hook.body());
```

- 기록(`requests()`, `requests(operationId)`, `lastRequest()`)에는 operation, method, 경로, 쿼리, JSON 본문이 있고 **헤더 값(API Key 포함)은 기록하지 않습니다.**
- 응답을 지정하지 않은 operation은 성공 봉투를 돌려줍니다(발송·예약 등록은 수신자마다 `A000` + `FAKE-MSGKEY-000001`…, 그 밖에는 빈 `data.data`). `thenRespond(status, json)`, `thenData(json)`, `thenFail(layer, status, code)`, `thenNetworkError()`, `thenTimeout()`, `thenDefault()`를 순서대로 쓰고 마지막 응답이 반복됩니다.
- `fake.clientBuilder()`로 `maxRetries`·hook 등 다른 설정을 더할 수 있습니다. 직접 만든 `HttpTransport`는 SDK가 안전 설정(리다이렉트·재시도·자체 인증·쿠키 끔)을 확인할 수 없어 **기본으로 거부**합니다. 구현이 이를 지키고 API Key 헤더·URL을 로그에 남기지 않는다면 `Bizgo.builder().httpTransport(t).trustHttpTransport(true)`로 명시적으로 허용하세요. `FakeTransport`는 이 설정이 필요 없습니다.

## 관측(Observability)

`RequestHook`으로 호출 시작·종료를 받습니다. 전달되는 값은 operationId, `resource.method`, HTTP method, **경로 템플릿**(예: `/api/comm/v1/report/inquiry/{msgKey}`), 상태 코드, 오류 `layer`/`code`, 시도 횟수, 소요 시간뿐입니다. **본문·쿼리·헤더 값·실제 경로 값·전화번호·API Key는 넘기지 않습니다.** hook에서 난 예외는 무시됩니다.

```java
Bizgo client = Bizgo.builder()
        .hook(new RequestHook() {
            @Override
            public void onRequestEnd(RequestEvent e) {
                metrics.record(e.getOperationId(), e.getStatus(), e.getErrorCode(), e.getAttempts(), e.getDuration());
            }
        })
        .build();
```

OpenTelemetry는 선택 아티팩트 `bizgo-sdk-comm-java-opentelemetry`로 제공합니다(코어의 런타임 의존성은 Jackson 하나 그대로).

```groovy
implementation 'io.github.icomm-api:bizgo-sdk-comm-java-opentelemetry:1.2.0'
```

```java
Bizgo client = Bizgo.builder().hook(BizgoTracing.create(GlobalOpenTelemetry.get())).build();
```

span 이름은 `bizgo <resource>.<method>`(예: `bizgo alimtalk.templates.list`, kind CLIENT), 속성은 `http.request.method`, `url.template`, `http.response.status_code`, `bizgo.operation_id`, `bizgo.code`, `bizgo.layer`, `bizgo.retry_count`, `error.type`입니다. 비즈고로 trace 헤더를 보내지 않습니다.

## 오류 처리

모든 예외는 unchecked이며 `BizgoException`을 상속합니다(`io.github.icommapi.bizgo.errors`).

```java
try {
    client.send().omni(...);
} catch (ValidationException e) {         // 보내기 전 검증 실패 (필드, 길이, 문자). e.getViolations()
} catch (AuthenticationException e) {     // 키가 틀렸거나 IP가 등록되지 않음
} catch (RateLimitException e) {          // 자동 재시도 후에도 한도 초과. e.getRetryAfter()
} catch (DuplicateRequestException e) {   // 같은 idempotencyKey가 이미 접수됨 (다시 발송되지 않음)
} catch (ApiException e) {                // 그 밖의 거절. e.getCode(), e.getLayer(), e.getDescription(), e.getTrackingId()
} catch (ApiConnectionException e) {      // 네트워크 오류·타임아웃. 발송은 접수됐을 수도 있음 → 상태 조회로 확인
}
```

```
BizgoException
├── ConfigurationException      ├── ValidationException
├── ApiConnectionException ── ApiTimeoutException
├── ApiException {httpStatus, code, serverMessage, layer, description, trackingId, body}
│   ├── BadRequestException (400)       ├── AuthenticationException (401)   ├── PermissionDeniedException (403)
│   ├── NotFoundException (404)         ├── DuplicateRequestException (A301)
│   ├── RateLimitException (429 / A020) └── InternalServerException (5xx)
├── InvalidResponseException
└── WebhookVerificationException
```

- 응답은 두 단계로 판정합니다: `common.authCode`(게이트웨이: 인증·형식) → `data.code`(상품 처리). `e.getLayer()`가 `GATEWAY`/`SERVICE`입니다. 같은 코드라도 단계마다 뜻이 다릅니다(예: `A401`).
- HTTP 200인데 `data.code`가 실패면 에러코드 표의 문서상 HTTP 상태로 예외를 고릅니다(예: `A306` → `BadRequestException`). 설명은 `ServiceCodes.lookup(code)`로도 볼 수 있습니다.
- 발송 요청이 성공해도 **일부 수신자는 거절될 수 있습니다.** 항상 `result.getFailed()`를 확인하세요.
- 같은 `idempotencyKey`로 유효시간 안에 다시 보내면 요청은 성공(HTTP 200)하고 이미 접수된 수신자는 수신자별 코드 `A301`로 옵니다. SDK는 이 수신자를 `getFailed()`가 아니라 `result.getDuplicates()`로 돌려줍니다(`getSucceeded()`·`getMsgKeys()`에도 없음, 이 요청으로 새로 접수된 것이 아님). 따라서 같은 키로 다시 보내도 안전하고, 이미 접수된 수신자는 `getDuplicates()`에서 확인합니다. 요청 전체가 `data.code` A301이면 기존처럼 `DuplicateRequestException`입니다.

## 재시도와 타임아웃

| 요청 | 자동 재시도 |
|---|---|
| 조회, 리포트 수신 확인 | 429, 500/502/503/504, 네트워크 오류 |
| 발송 (`idempotencyKey` 있음) | 429, 500/502/503/504, 네트워크 오류 |
| 발송 (`idempotencyKey` 없음), 업로드 | 429만 (중복 발송 방지) |

기본값은 최대 2회 재시도(지수 백오프 0.5s·1s… 최대 8s, jitter, `Retry-After` 우선·최대 60s), 요청 타임아웃 30초, 연결 타임아웃 5초입니다.
재시도한 요청(네트워크 오류·5xx·429 뒤)이 `A301`을 받으면 `DuplicateRequestException.isAlreadyAccepted()`가 `true`이고 "이전 시도가 이미 접수됨" 안내가 붙습니다. 메시지는 이미 발송 중이니 다시 보내지 마세요.
응답이 문서와 다르면(목록에 `null`, 형태 오류, 리다이렉트 등) `InvalidResponseException`(HTTP 상태, `getTrackingId()`, `getBody()`)이 납니다. 발송이면 "요청은 접수됐을 수 있으니 상태 조회로 확인하세요"가 메시지에 들어 있으니, 다시 보내기 전에 조회 API로 확인하세요.

```java
Bizgo.builder().maxRetries(3).timeout(Duration.ofSeconds(10)).build();

// 프록시·사내 CA가 필요하면 SDK 옵션을 쓰세요 (TLS 검증을 끄는 옵션은 없습니다)
Bizgo.builder()
        .proxy(new InetSocketAddress("proxy.example.internal", 3128))   // 또는 proxy(ProxySelector)
        .sslContext(companySslContext)                                  // 사내 CA를 넣은 SSLContext
        .build();

// HttpClient를 직접 넘길 수도 있지만, 리다이렉트를 따르거나 Authenticator·CookieHandler가 있으면 설정 오류입니다.
// (자동 인증은 SDK의 Authorization(API Key)을 바꾸고 401 뒤 요청(발송 포함)을 여러 번 다시 보냅니다.)
// 넘긴 HttpClient의 TLS 설정이 그대로 적용되고, close()하지 않습니다.
Bizgo.builder().httpClient(HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()).build();
```

## 로깅

`System.Logger`(`io.github.icommapi.bizgo`)를 씁니다. 별도 로깅 의존성이 없으며, SLF4J/Log4j 등은 각 프레임워크의 `System.Logger` 브리지로 연결됩니다.
DEBUG에서 시도마다 `GET /api/comm/v1/message/history -> 200 (35 ms, attempt 1)` 한 줄만 남깁니다. 키, 본문, 쿼리 문자열, 전화번호는 남기지 않습니다.

## 보안

- API Key는 **접두어 없이** 키 값만 씁니다(`Bearer`/`ApiKey` 접두어는 401). 앞뒤 공백·줄바꿈도 지우지 않고 설정 오류로 처리합니다(환경변수 포함). 환경변수나 시크릿 저장소에서 읽고, 코드·저장소·클라이언트 앱에 넣지 않습니다.
- SDK는 키, 요청 본문, 쿼리 문자열(전화번호가 들어갈 수 있음)을 로그나 예외 메시지에 남기지 않습니다. 검증 오류에도 입력값을 싣지 않고, HTTP 클라이언트 예외(URL 포함)는 원인으로 연결하지 않습니다.
- 모델·쿼리 파라미터(`*Params`)·옵션 객체의 `toString()`은 전화번호 가운데를 가리고(`010****0000`, 8~10자리는 `158****4`처럼 절반 이상, 7자리 이하는 전부), 이름·닉네임·이메일은 첫 글자만(`홍**`), 본문 같은 값은 길이만(`***(12자)`), 키·토큰은 전부 가립니다. getter 값은 그대로입니다. `SendOmniRequest.toJson()`과 `ApiException.getBody()`에는 원문(전화번호 포함 가능)이 있으니 그대로 로그에 남기지 마세요.
- JDK HTTP 클라이언트 디버그 로그(`-Djdk.httpclient.HttpClient.log=headers` 등)는 `Authorization` 헤더를 그대로 출력하므로 운영에서 켜지 마세요.
- `http://` base URL, userinfo·query·fragment가 있는 base URL은 거부합니다(테스트용 localhost 제외). SDK 자체에는 TLS 검증을 끄는 옵션이 없습니다. 단, `httpClient(...)`로 넘긴 `HttpClient`는 **그 클라이언트의 TLS 설정(SSLContext)이 그대로 적용**되므로 검증을 끈 클라이언트를 넘기지 마세요. 리다이렉트를 따르거나 `Authenticator`가 있는 `HttpClient`는 받지 않습니다(키가 다른 서버로 가거나 바뀔 수 있음). 3xx 응답은 따르지 않고 `HTTP 302: 리다이렉트…` 오류로 알립니다.
- 웹훅: `X-IB-Timestamp`는 ASCII 숫자 1~16자리만, secret은 공백만 있는 값도 거부, `tolerance`는 0보다 크거나 `null`(끔)만 허용합니다. 깊게 중첩되거나 형태가 틀린 본문은 `WebhookVerificationException`(핸들러에서 4xx로 응답)입니다. 응답·웹훅 JSON의 중첩은 64단계까지입니다.
- `ApiException`·`InvalidResponseException`(본문 포함)과 `ValidationException`(위반 목록 포함)은 Java 직렬화로 주고받을 수 있습니다(작업 큐 등).
- 취약점 신고는 [SECURITY.md](SECURITY.md)를 참고하세요.

## 이전 버전에서 옮기기

1.2.0은 [bizgo-api-spec](https://github.com/icomm-api/bizgo-api-spec)을 기준으로 새로 작성했습니다. 1.1.x 코드는 git 기록에 남아 있습니다. **호환되지 않는 변경:**

| 1.1.x | 1.2.0 |
|---|---|
| 패키지 `net.bizgo.client` | `io.github.icommapi.bizgo` (Maven groupId `io.github.icomm-api`와 맞춤) |
| `BizgoClient.builder().apiKey(...)` | `Bizgo.builder().apiKey(...)` (생략 시 환경변수 `BIZGO_API_KEY`) |
| ID/PW 토큰 인증(`clientId`/`password`, `/v1/auth/token`) | 제거. API Key만 지원 |
| `HttpConfig.baseUrl("https://mars.ibapi.kr/api/comm")` | `environment(Environment.SANDBOX)` 또는 `baseUrl("https://mars.ibapi.kr")` (`/api/comm` 없이) |
| `send(OmniRequest)` | `send().omni(to, messages...)`, `send().request(SendOmniRequest)`, `send().sms/lms/mms(...)` |
| `upload(FileRequest)` | `files().uploadMms / uploadRcs / uploadBrandMessage(file, BrandImageKind)` |
| `get(ReportPollingRequest)` / `remove(...)` | `reports().poll()` / `reports().ack(reportId)`, 또는 `reports().consume(handler)` |
| `get(ReportInquiryRequest)` | `reports().inquiry(msgKey)` |
| `inquireStatusByMsgKey` / `inquireStatusByRequestId` | `messages().status(msgKey)` / `messages().statusByRequestId(requestId)` |
| `inquireStatistics(...)` / `inquireHistory(...)` | `messages().statistics(...)` / `messages().history(HistoryQuery)`, `iterHistory`, `streamHistory` |
| (없음) | MO 조회(`messages().mo`, `moHistory`), 웹훅 검증(`WebhookReceiver`) |
| 모든 응답이 `BizgoResponse` 하나 | 엔드포인트별 타입(`SendResult`, `ReportBatch`, `List<Report>`, `MessagePage` …) |
| `data.code != A000`이어도 정상 반환 | 예외(`ApiException` 계열)로 던짐 |
| 모든 메서드 `throws Exception`, 여러 계열의 예외 | unchecked `BizgoException` 계층 하나 |
| `OmniRequest`, 손으로 쓴 메시지 클래스·enum(`MsgType` 등) | 스펙에서 생성한 불변 모델(`SendOmniRequest`, `SmsMessage` …). 코드 값은 문자열이고 `build()`에서 허용 값 검증 |
| 카카오 버튼 서브클래스(`WLButton` 등) | `AlimtalkButton` / `BrandMessageButton` 하나에 `type("WL")` |
| `idempotencyTtl(String)` | `SendOptions.builder().idempotencyTtl(Integer)` |
| Apache HttpClient 4, Tika, shadow jar, Jackson `compileOnly` | JDK `HttpClient`, 일반 jar, Jackson `jackson-databind`가 정식(`api`) 의존성 |
| 타임아웃 없음, 재시도 없음 | 기본 타임아웃 30초(연결 5초), 재시도 2회(정책은 위 표) |

1.1.x에서 고친 결함: 여러 클라이언트가 인증 토큰을 static으로 공유하던 문제(이제 키·설정은 인스턴스별), RCS 버튼이 전송되지 않던 문제, 본문 없는 오류 응답에서 NPE, 경로 파라미터 미인코딩, README와 코드 불일치, POM의 scm/url이 다른 저장소를 가리키던 문제.

## 개발

```bash
./gradlew build                 # 컴파일(-Xlint:all -Werror), 테스트(mock HTTP, 네트워크·키 불필요), javadoc, 생성 코드 검사
./gradlew generateModels        # spec/openapi.yaml이 바뀌었을 때 모델 재생성
./gradlew checkGeneratedModels  # 생성 결과(모델·리소스·파라미터·웹훅 파서)가 커밋과 같은지 (CI)
```

모듈: 루트(코어, `bizgo-sdk-comm-java`), `testing/`(`bizgo-sdk-comm-java-testing`), `opentelemetry/`(`bizgo-sdk-comm-java-opentelemetry`).

AI 코딩 도구로 이 저장소를 수정할 때의 규칙은 [AGENTS.md](AGENTS.md)에 있습니다.
SDK를 **사용하는** 코드를 AI로 작성할 때는 [llms.txt](llms.txt)를 컨텍스트로 넣으면 정확도가 높아집니다.

## 라이선스

[Apache-2.0](LICENSE)
