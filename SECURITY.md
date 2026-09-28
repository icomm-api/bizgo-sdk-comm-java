# 보안 정책

## 취약점 신고

보안 취약점은 **공개 Issue로 올리지 마세요.** GitHub의 [Private vulnerability reporting](../../security/advisories/new)으로 비공개 신고해 주세요.
확인 후 영업일 기준 5일 안에 답변합니다.

지원 버전: 최신 minor 버전(현재 1.2.x)에 보안 수정을 제공합니다. 1.1.x 이하(`net.bizgo.client`, 호환되지 않는 이전 API)는 지원하지 않습니다.

## 자격 증명이 노출됐을 때

1. 즉시 비즈고 콘솔 `발송관리 > 연동관리`에서 해당 API Key를 폐기하고 새로 발급합니다. 저장소 기록에서 지워도 이미 복제됐을 수 있으므로 **폐기가 먼저**입니다.
2. 웹훅 secret은 비즈고에 재발급을 요청합니다.
3. 허용 IP(ACL) 목록을 점검합니다.

## SDK의 보안 동작

- API Key는 `Authorization` 헤더로만 보내고, `toString`·로그·예외 메시지에 넣지 않습니다. 키·설정은 클라이언트 인스턴스별이며 static으로 공유하지 않습니다.
- 요청 본문, 쿼리 문자열, 검증 오류의 입력값(전화번호 포함 가능)을 로그·예외에 넣지 않습니다. HTTP 클라이언트·Jackson 예외는 URL이나 값을 담을 수 있어 원인(cause)으로 연결하지 않습니다.
- 모델·파라미터·옵션 객체의 `toString()`은 전화번호 가운데(절반 이상, 7자리 이하는 전부)를 가리고, 사람 이름·닉네임·이메일은 첫 글자만, 본문은 길이만 보여 줍니다. `ApiException.getBody()`와 `SendOmniRequest.toJson()`에는 원문이 있으니 그대로 로그에 남기지 마세요.
- JDK HTTP 클라이언트의 디버그 로그(`jdk.httpclient.HttpClient.log`)는 헤더를 그대로 출력하므로 운영에서 켜지 마세요.
- https가 아닌 base URL과 userinfo·query·fragment가 있는 base URL은 거부합니다(테스트용 localhost 제외). **SDK 자체에는 TLS 검증을 끄는 옵션이 없습니다.** 다만 사용자가 `httpClient(...)`로 넘긴 `HttpClient`는 그 클라이언트의 TLS 설정(SSLContext, SSLParameters)이 그대로 적용되므로, 검증을 끈 클라이언트를 넘기면 보호가 사라집니다.
- SDK가 점검하거나 안전한 값을 강제할 수 없는 HTTP 계층은 기본으로 거부합니다. 직접 구현한 `HttpTransport`는 `trustHttpTransport(true)`로 명시적으로 허용해야 하며(테스트 모듈의 `FakeTransport`만 예외), 프록시·사내 CA는 SDK 옵션 `proxy(...)`·`sslContext(...)`로 설정합니다(검증을 끄는 옵션 없음).
- 리다이렉트를 따르는 `HttpClient`, `Authenticator`나 `CookieHandler`가 있는 `HttpClient`는 설정 오류입니다. `Authenticator`가 있으면 JDK `HttpClient`가 401 응답 뒤 SDK의 `Authorization`(API Key)을 자기 자격 증명으로 바꾸고 요청(발송 포함)을 여러 번 다시 보내는 것이 확인됐습니다(2026-09-24). 3xx 응답은 따르지 않고 HTTP 상태를 담은 오류로 알립니다.
- 웹훅 `X-IB-Timestamp`는 ASCII 숫자 1~16자리만 허용하고, 공백 secret·0 이하 tolerance는 설정 오류입니다. 응답·웹훅 JSON 중첩은 64단계, 응답 본문은 16MB로 제한합니다.
- 배포 산출물은 반드시 서명합니다. `SIGNING_KEY` 없이 staging 게시를 시도하면 빌드가 실패합니다(조용히 서명을 건너뛰지 않음).
- 경로 파라미터는 URL 인코딩하고 `.`/`..`은 거부합니다. 응답 본문은 16MB까지만 읽습니다.
- 발송은 `idempotencyKey`가 없으면 타임아웃·5xx 후 자동 재시도하지 않습니다(중복 발송 방지).
- 웹훅 서명은 `MessageDigest.isEqual`로 constant-time 비교하고 timestamp 허용 오차(기본 300초)를 벗어난 오래된 요청을 거부합니다.
  운영 환경에서는 HTTPS, 발신 IP 허용 목록, `msgKey` 기준 중복 제거를 함께 적용하고, 중요한 판단은 조회 API로 결과를 확인하세요.
- 상담톡 웹훅에는 서명이 없습니다(서명은 리포트·MO 웹훅에만 적용). 상담톡 파서는 서명 헤더를 검사하지 않고(와도 무시) 본문 크기 제한·JSON 깊이 64·타입 검사만 하며 secret이 필요 없습니다(`WebhookReceiver.parseCounselMessage(rawBody)` 등). 수신 엔드포인트에는 HTTPS와 발신 IP 허용 목록을 적용하고 `msgKey`가 있으면 중복을 제거하세요. 리포트·MO 웹훅은 항상 서명을 검증합니다.
- 요청에는 SDK 식별 헤더(`User-Agent`: SDK·Java 버전, 거친 OS/CPU 이름, 선택 `appInfo`; `X-Bizgo-Client`)만 더합니다. 그 밖에 SDK가 수집·전송하는 정보는 없습니다. `appInfo`는 허용 문자만 받아 헤더 인젝션을 막습니다.
- `RequestHook`(와 OpenTelemetry 어댑터)에는 경로 템플릿·상태·코드·시도 횟수·시간만 전달하고 본문·쿼리·헤더 값·경로 값·키는 전달하지 않습니다. `HttpTransport`를 직접 구현하면 API Key 헤더와 전체 URL을 받으므로 로그에 남기지 마세요. 테스트용 `FakeTransport`는 헤더 값을 기록하지 않습니다.

## 공급망

- 코어의 런타임 의존성은 `com.fasterxml.jackson.core:jackson-databind` 하나입니다. 선택 아티팩트 `bizgo-sdk-comm-java-opentelemetry`만 `opentelemetry-api`를 더합니다. 모든 버전은 모듈별 `gradle.lockfile`에 고정합니다.
- CI는 `gradle.lockfile`을 osv-scanner로 검사하고, Gradle wrapper를 검증하고, 모든 커밋을 gitleaks로 검사합니다. GitHub Actions는 커밋 SHA로 고정합니다.
- Maven Central 배포는 `v*` 태그의 GitHub Actions로만 합니다. 서명 키와 Central 토큰은 필수 승인자가 지정된 GitHub Environment(`maven-central`)의 secret에만 있으며, 저장소·개발자 PC에 두지 않습니다. 배포 산출물은 OpenPGP로 서명됩니다.
