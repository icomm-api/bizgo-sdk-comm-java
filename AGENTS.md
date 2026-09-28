# AGENTS.md — bizgo-sdk-comm-java

AI 코딩 도구와 기여자가 이 저장소를 수정할 때 따르는 규칙입니다. SDK를 *사용하는* 코드를 쓸 때는 [llms.txt](llms.txt)를 보세요.
동작 규약은 bizgo-api-spec의 `docs/SDK-DESIGN.md`이며, 참조 구현은 Python SDK(`bizgo-sdk-comm-python`)입니다.

## 명령

```bash
./gradlew build                          # 컴파일(-Xlint:all -Werror) + 테스트 + javadoc(doclint) + checkGeneratedModels
./gradlew test                           # 전부 mock HTTP(JDK HttpServer). 네트워크·API Key 불필요
./gradlew generateModels                 # spec → src/generated/java 재생성 (모델 + 리소스 + 파라미터 + 웹훅 파서)
./gradlew checkGeneratedModels           # CI: 생성 결과가 커밋과 같은지 (src/generated 전체, 손으로 쓴 메서드 이름도 입력)
./gradlew resolveAndLockAll --write-locks  # 의존성을 바꾼 뒤 gradle.lockfile 갱신
```

변경 후 `./gradlew build`가 통과해야 합니다(루트·`testing`·`opentelemetry` 모듈 모두). JDK 17과 21 모두에서 CI가 돕니다(바이트코드는 `--release 17`). 의존성을 바꾸면 세 모듈의 `gradle.lockfile`을 모두 갱신합니다.

## 구조

```
spec/openapi.yaml, spec/error-codes.json    # bizgo-api-spec에서 복사한 스펙 (직접 수정 금지, 스펙 저장소에서 고친 뒤 복사)
buildSrc/.../codegen/ModelGenerator.java    # 스펙 → 모델·ServiceCodes 생성기 (배포되지 않음)
buildSrc/.../codegen/ResourceGenerator.java # 스펙 x-sdk-* → 리소스 클래스·Operations·*Params·웹훅 파서 생성기
src/generated/java/                         # 생성됨 (직접 수정 금지)
  .../models/*.java                         #   요청 모델(빌더+build() 검증), 응답 모델(unknown 필드 보존), MessageFlowItem, ReservationMessageFlowItem, ChannelMessage
  .../errors/ServiceCodes.java              #   data.code → (HTTP 상태, 한국어 설명)
  .../Operations.java                       #   operation 표(operationId, resource, method, 경로 템플릿, retry, 속도 버킷, pagination, result)
  .../BizgoResources.java, *Service.java    #   생성 리소스(예: AlimtalkTemplatesService). Generated{Send,File,Report,Message}Service는 손으로 쓴 서비스의 상위 클래스
  .../params/*Params.java                   #   쿼리·헤더 파라미터(빌더+검증, toString은 값 마스킹)
  .../webhooks/GeneratedWebhookReceiver.java #  x-sdk-webhook 파서(상담톡 등). WebhookReceiver가 상속
  .../internal/GeneratedRequestModels.java  #   응답에 나오는 요청 모델을 검증 없이 읽는 mix-in 대상 목록
  .../models/GeneratedRequiredIf.java       #   x-sdk-required-if 규칙 표(models/RequiredIf가 검사)
src/main/java/io/github/icommapi/bizgo/
  Bizgo.java                                # 클라이언트·Builder, API Key·base URL 검증
  Transport.java                            # 헤더, 속도 제한, 재시도, 응답 봉투 해석, hook, 로깅 (package-private)
  HttpTransport.java, JdkHttpTransport.java # HTTP 교체 지점(테스트용 FakeTransport)과 기본 구현
  Operation.java, RateLimit.java, RateLimiter.java, RequestHook.java, RequestEvent.java, Paging.java, BulkOptions.java
  ErrorMapper.java                          # 층별 코드 → 예외 클래스
  SendService / FileService / ReportService / MessageService   # 리소스
  SendOptions, HistoryQuery, MoHistoryQuery, FileUpload, BrandImageKind
  Params.java, Multipart.java, Pager.java   # 경로 인코딩·날짜 형식, multipart, 페이지 순회
  models/                                   # 손으로 쓴 부분: ModelValidator, RequestParser, MessageBytes, SendResult 등 결과 타입
  errors/                                   # 예외 계층
  webhooks/                                 # Webhooks(서명 검증·파싱), WebhookReceiver
  internal/Json.java                        # Jackson 설정 (공개 API 아님)
src/examples/java/examples/                 # 예제. ExamplesTest가 mock 서버로 실행
src/test/java/                              # JUnit 5. MockServer = com.sun.net.httpserver 기반, OperationsTest = 모든 operation을 FakeTransport로 호출
testing/                                    # 아티팩트 bizgo-sdk-comm-java-testing: FakeTransport, RecordedRequest, FakeResponses, WebhookSigner
opentelemetry/                              # 아티팩트 bizgo-sdk-comm-java-opentelemetry: BizgoTracing(RequestHook → span)
```

## 규칙

1. **생성 파일은 손으로 고치지 않습니다.** 모델을 바꾸려면 bizgo-api-spec을 고치고 `spec/`에 복사한 뒤 `./gradlew generateModels`. 생성 방식 자체를 바꿀 때는 `ModelGenerator.java`를 고칩니다.
2. 새 엔드포인트는 **손으로 쓰지 않습니다.** 스펙에 operation과 `x-sdk-*`를 추가하고 `spec/`에 복사한 뒤 `./gradlew generateModels`. `OperationsTest`가 모든 operation의 method·경로·재시도·pagination을 확인합니다. 편의 메서드가 필요하면 손으로 쓴 서비스(`SendService` 등)에 추가합니다(같은 이름이면 생성되지 않음 = 손으로 쓴 메서드 우선).
3. 공개 메서드는 Javadoc(`@param`/`@return`/`@throws`)을 갖춥니다(doclint가 검사). 반환 타입은 생성 모델이나 결과 타입입니다(`Map`/`JsonNode` 반환 금지, 웹훅 ack 제외).
4. 재시도 정책은 operation의 `x-sdk-retry`(`Operations`에 생성)를 따릅니다. 예외: 발송은 `idempotencyKey`가 있을 때만 `SAFE`. 속도 제한 버킷은 스펙의 `x-sdk-rate: send`만 send(비용 = 요청의 `destinations` 수, 최소 1, 초당 200 메시지)이고 나머지는 other(요청당 1, 초당 5)입니다. SDK에 operation 목록을 하드코딩하지 않습니다(`RecipientRateLimitTest`가 스펙과 대조).
5. 예제·README의 코드는 실제로 동작해야 합니다. 예제를 바꾸면 `ExamplesTest`도 맞춥니다.
6. 문서에 없는 동작을 가정하지 않습니다. 불확실하면 스펙에 `x-unverified`로 표시하고 bizgo-api-spec의 GitHub Issues에 알립니다.
7. 공유 상태 금지: API Key·설정은 `Bizgo` 인스턴스에만 둡니다. static에는 설정 없는 상수(Jackson mapper, 로거)만 둡니다.
8. `idempotencyKey`가 있고 `idempotencyTtl`이 없으면 `Bizgo.DEFAULT_IDEMPOTENCY_TTL`(86400)을 채웁니다(없으면 A309, SDK-DESIGN 12.20). 명시한 TTL(0 포함)은 그대로, 키가 없으면 TTL을 넣지 않습니다. 직렬화 단계의 `Transport.Body.jsonWithDefaultTtl(...)` 하나로만 적용하며(`SendService.request`, 그리고 `ResourceGenerator`가 본문 스키마에 두 필드가 모두 있는 operation에 생성), 호출자의 모델·Map·JsonNode는 바꾸지 않습니다. 관련 테스트: `IdempotencyTtlTest`.
9. 조건부 필수(`x-sdk-required-if`, SDK-DESIGN §4): 규칙을 SDK에 하드코딩하지 않습니다. `ModelGenerator`가 스펙에서 `models/GeneratedRequiredIf`(규칙 표, `$.` 규칙까지 가는 요청 객체 그래프, 루트 본문 속성)를 만들고, 손으로 쓴 `models/RequiredIf` 하나가 검사합니다. 객체 기준 규칙(`required`, 상대 `requiredPaths`)은 그 모델의 `build()`에서(`checkObject`), `$.` 경로는 요청 본문 루트 모델(`SendOmniRequest`, `ReservationCreateRequest`)의 `build()`에서(`checkRequest`) 검사하므로 `fromJson`/`fromMap`도 같습니다. `bulk`는 모든 청크 요청을 보내기 전에 만듭니다. 형식이 틀린 확장(연산자 0개/2개, 없는 속성)은 생성기가 실패시킵니다. 메시지에는 경로·조건만(값 금지). 관련 테스트: `RequiredIfTest`.

## 보안 규칙 (오픈소스 저장소)

- **로그·예외·toString에 민감정보 금지**: API Key, 요청 본문, 쿼리 문자열, 전화번호, 웹훅 secret. `IOException`·Jackson 예외는 URL이나 입력값을 담으므로 **원인(cause)으로 연결하지 않고** 클래스 이름만 씁니다. 관련 테스트: `ErrorsAndSecurityTest`.
- 검증 메시지에는 필드 경로와 이유만 씁니다(`ModelValidator`, `RequestParser`). 생성 모델의 `toString()`은 `ModelGenerator.SAFE_TO_PRINT`에 있는 필드(코드·키·시각·건수)만 값을 보여 줍니다. 여기에 전화번호·본문 필드를 추가하지 않습니다.
- TLS 검증을 끄는 옵션, `http://` base URL(localhost 제외), 리다이렉트를 따르는 HttpClient를 허용하는 코드를 추가하지 않습니다.
- 경로 파라미터는 `Params.segment()`로 인코딩합니다(경로 조작 방지). 생성 코드는 `Operation.path(...)`로 같은 인코딩을 씁니다.
- SDK 식별 헤더(`User-Agent`, `X-Bizgo-Client`)에는 SDK·Java 버전과 거친 OS/CPU 이름, 검증된 `appInfo`만 넣습니다. 호스트명·사용자명 등을 추가하지 않고, 사용자 옵션이 `Authorization`·`User-Agent`·`X-Bizgo-Client`를 덮어쓰지 못하게 유지합니다.
- `RequestHook`/`RequestEvent`에는 경로 **템플릿**·operation·상태·코드·시도 횟수·시간만 넣습니다. 본문, 쿼리, 헤더 값, 실제 경로 값, 전화번호, API Key를 추가하지 않습니다(`RateLimitAndHooksTest`). hook 예외는 삼킵니다.
- 리포트·MO 웹훅 서명은 `X-IB-Signature` = `HmacSHA256(secret, X-IB-Timestamp)`입니다(비즈고 확인). 다른 서명 헤더 이름이나 `sha256=` 같은 접두어는 받지 않고, 출력 인코딩은 아직 확인되지 않아 hex(대소문자 무시)·base64를 모두 허용합니다. 웹훅 secret은 비즈고에 요청해 받습니다.
- 상담톡 웹훅: 서명이 없습니다(스펙에 서명 헤더 파라미터 없음). 생성된 상담톡 파서는 헤더를 검사하지 않고 본문 검사(크기·깊이 64·타입)만 하며, secret 없이 쓰는 정적 파서 `WebhookReceiver.parseCounsel*(byte[])`도 함께 생성됩니다. 리포트·MO는 항상 서명 필요이며 이 검증을 느슨하게 바꾸지 않습니다(`CounselWebhooksTest`). 생성기는 스펙에 `X-IB-Signature` 헤더 파라미터가 있는 웹훅만 검증 파서로 만듭니다.
- SDK-DESIGN 12 규칙은 `SecurityReviewTest`가 지킵니다: 응답 변환 실패는 `InvalidResponseException`(Transport의 converter 안에서 변환해 hook도 실패로 봄), 대량 발송은 청크별로 `Throwable`을 잡고 부분 결과를 보존, 재시도 뒤 A301은 `alreadyAccepted`, 수신자별 A301(`destinations[].code`, HTTP 200)은 실패가 아닌 `SendResult.getDuplicates()`/`BulkSendResult.getDuplicates()`(`getSucceeded`·`getFailed`·`getMsgKeys`에 넣지 않음, 요청 단위 A301은 계속 `DuplicateRequestException`), `Authenticator` 있는 `HttpClient` 거부, 웹훅 timestamp 1~16 ASCII 숫자, 예외는 Java 직렬화로 왕복, 전화번호는 `Masking.phone`으로 표시. 새 hand-written 호출은 `transport.call(..., mapper)`처럼 결과 조립을 converter 안에서 합니다.
- 사용자 HTTP 계층: 점검할 수 없는 것(직접 구현한 `HttpTransport`)은 `trustHttpTransport(true)` 없이는 거부하고(`FakeTransport` 예외), 점검 가능한 `HttpClient`는 리다이렉트·Authenticator·CookieHandler가 있으면 거부합니다. 흔한 이유(프록시·CA)는 `proxy`·`sslContext` 옵션으로 해결합니다. TLS 검증을 끄는 옵션을 만들지 않습니다(`FinalAlignmentTest`).
- 마스킹은 `internal.Masking` 하나로: 생성 모델·`*Params`·손으로 쓴 옵션/쿼리 객체 모두 같은 규칙. 성공 응답에서 null을 돌려주지 않습니다(빈 객체·빈 목록).
- `internal.Json`은 가변 ObjectMapper를 공개하지 않습니다(정적 헬퍼만). 새 코드도 mapper를 밖으로 넘기지 않습니다.
- `FakeTransport`는 헤더 값(API Key)을 기록하지 않습니다. testing·opentelemetry 모듈은 코어의 런타임 의존성을 늘리지 않도록 별도 아티팩트로 둡니다.
- 테스트·예제의 값은 placeholder만 씁니다: 전화번호 `01000000000`, `01000001234`, 키 `test-api-key-not-real`, `SENDER_KEY_EXAMPLE`. 실제 키·번호·발신프로필 키를 커밋하지 않습니다(gitleaks가 pre-commit·CI에서 검사). 테스트는 Bizgo 서버에 연결하지 않습니다.
- 런타임 의존성은 `jackson-databind` 하나만 둡니다. 추가가 필요하면 이유를 PR에 적습니다.
- 배포 자격 증명(서명 키, Central 토큰)은 GitHub Environment `maven-central`의 secret에만 둡니다. `gradle.properties`는 gitignore 대상입니다.
