# 예제

모든 예제는 **sandbox**(실제 발송 없음)에 연결하고, 값은 환경변수에서 읽습니다.

```bash
export BIZGO_API_KEY=...            # 콘솔 > 발송관리 > 연동관리 (코드에 쓰지 마세요)
export BIZGO_FROM=...               # 등록한 발신번호
export BIZGO_TO=...                 # 테스트 수신번호
./gradlew compileExamplesJava
java -cp "build/classes/java/examples:build/classes/java/main:<jackson-databind 경로>" examples.SendSms
```

IDE에서는 각 클래스의 `main`을 바로 실행하면 됩니다.

| 파일 | 내용 |
|---|---|
| `SendSms.java` | SMS 발송과 수신자별 접수 결과 확인 |
| `SendAlimtalkFallback.java` | 알림톡 발송, 실패 시 SMS 대체발송, 치환 변수, 멱등성 키 |
| `SendMms.java` | 이미지 업로드 후 MMS 발송 |
| `PollReports.java` | 리포트 Polling 처리(처리 성공 시에만 수신 확인) |
| `MessageHistory.java` | 발송 이력 전체 조회(페이지 자동 순회)와 상태 조회 |
| `WebhookServer.java` | 리포트 웹훅 수신 서버(서명 검증, 중복 처리, 5초 안에 응답) |

각 예제의 `run(...)`은 테스트(`src/test/java/.../ExamplesTest.java`)에서 mock 서버로 실행되므로, 예제 코드는 항상 현재 SDK와 맞습니다.
