# Infobank Bizgo Communication API SDK for Java

이 레포지토리는 인포뱅크의 **Bizgo Communication API(이하 OMNI API) (통합 메시지 API)** 연동을 위한 **Java용 공식 SDK**입니다.  
Java 환경에서 쉽고 빠르게 통합 메시지 전송 기능(SMS, LMS, MMS, RCS, 알림톡, 친구톡, 브랜드메시지 등)을 구현할 수 있도록 도와줍니다.

**Spring Boot 3.x 및 4.x 완벽 지원** - Jackson 2.18.x 기반으로 최신 Spring Boot와 호환됩니다.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.icomm-api/bizgo-sdk-comm-java.svg)](https://central.sonatype.com/artifact/io.github.icomm-api/bizgo-sdk-comm-java)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE.txt)
[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x%20%7C%204.x-brightgreen.svg)](https://spring.io/projects/spring-boot)

---

## 🚀 Quick Start

### 1. SDK 설치

```gradle
implementation 'io.github.icomm-api:bizgo-sdk-comm-java:1.1.1'
```

### 2. Client 생성

```java
BizgoClient client = BizgoClient.builder()
  .apiKey("YOUR_API_KEY")
  .build();
```

### 3. 메시지 발송

```java
// SMS 발송
SmsMessage sms = SmsMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .text("테스트 메시지입니다")
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(sms)
  .addDestination(Destination.builder().to("01000000000").build())
  .build();

BizgoResponse response = client.send(request);
System.out.println("Result: " + response.getData().getResult());
```

---

## ✨ 주요 특징

### 🎯 Bizgo Communication API의 장점

- **🔄 자동 Failover**: 알림톡 실패 시 SMS로 자동 대체 발송
- **📢 동보 발송**: 하나의 요청으로 여러 수신자에게 전송
- **🎨 다양한 메시지 타입**: SMS, MMS, RCS, 알림톡, 브랜드메시지 등
- **📊 통합 리포트**: 모든 메시지 타입의 전송 결과를 통합 조회
- **🔐 간편한 인증**: API Key 방식으로 빠른 연동

### 🛠️ SDK 특징

- ✅ **Builder 패턴**: 직관적이고 안전한 객체 생성
- ✅ **타입 안정성**: Enum을 활용한 컴파일 타임 오류 방지
- ✅ **풍부한 예제**: 17가지 실전 테스트 케이스 제공
- ✅ **Java 8+ 지원**: 레거시 프로젝트에서도 사용 가능
- ✅ **Apache 2.0 라이선스**: 상업적 이용 가능

---

## 📚 Documentation

- 👉 [OMNI API 명세서 (GitBook)](https://infobank-guide.gitbook.io/omni_api)
- 📧 기술 문의: [support@infobank.net](mailto:support@infobank.net)
- 🌐 Bizgo 콘솔: [https://bizgo.io](https://bizgo.io)

---

## ✅ Requirements

OMNI API 사용 전 다음을 준비해 주세요:

- [Bizgo 계정 생성](https://bizgo.io)
- 발신번호 등록 (SMS, LMS, RCS용)
- RCS BizCenter 가입 (RCS 메시지 전송 시)
- 카카오비즈니스 가입 (알림톡/친구톡 전송 시)
- 방화벽 설정: 명세서에 명시된 IP 허용 필요

---

## ☕ Supported Environment

- **Java 17 이상** (LTS 권장: Java 17 또는 Java 21)
- **Spring Boot 3.x / 4.x** 완벽 지원
- **Jackson 2.18.x** 기반 (고객사 환경의 Jackson 버전 자동 사용)
- TLS 1.2 이상

---

## 📦 Installation (Maven Central)

### Maven

```xml
<dependency>
    <groupId>io.github.icomm-api</groupId>
    <artifactId>bizgo-sdk-comm-java</artifactId>
    <version>1.1.1</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.github.icomm-api:bizgo-sdk-comm-java:1.1.1'
```

🔍 [Maven Central 검색 바로가기](https://central.sonatype.com/artifact/io.github.icomm-api/bizgo-sdk-comm-java)

---

## 🚀 Client Initialization

### API Key 방식 (권장)

```java
BizgoClient client = BizgoClient.builder()
  .apiKey("YOUR_API_KEY")
  .build();
```

### OAuth2 방식

```java
BizgoClient client = BizgoClient.builder()
  .clientId(CLIENT_ID)
  .password(PASSWORD)
  .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
  .build();
```

---

## 💡 Usage Examples

### 1️⃣ 파일 업로드 (MMS, RCS, Brandmessage 등)

```java
File file = new File("src/test/resources/image.png");

// MMS용 파일 업로드
FileRequest mmsFile = FileRequest.builder()
  .file(file)
  .serviceType(ServiceType.MMS)
  .build();
BizgoResponse mmsUploadRes = client.upload(mmsFile);
String fileKey = mmsUploadRes.getData().getData().getFileKey();

// RCS용 파일 업로드
FileRequest rcsFile = FileRequest.builder()
  .file(file)
  .serviceType(ServiceType.RCS)
  .build();
BizgoResponse rcsUploadRes = client.upload(rcsFile);
String mediaUrl = rcsUploadRes.getData().getData().getMedia();

// Brandmessage용 파일 업로드
FileRequest brandFile = FileRequest.builder()
  .file(file)
  .serviceType(ServiceType.BRANDMESSAGE)
  .msgType(MsgType.DEFAULT)
  .build();
BizgoResponse brandUploadRes = client.upload(brandFile);
String imgUrl = brandUploadRes.getData().getData().getImgUrl();
```

---

## 🚀 통합 메시지 전송 (권장)

Omni API는 **하나의 요청으로 여러 메시지 타입을 조합**하여 전송할 수 있습니다.  
예: 알림톡 실패 시 SMS로 자동 Fallback, 동보 발송 등

### 2️⃣ SMS 전송

```java
SmsMessage smsMessage = SmsMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .text("Test SMS Message")
  .build();

Destination destination = Destination.builder()
  .to("01000000000")
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(smsMessage)
  .addDestination(destination)
  .build();

BizgoResponse response = client.send(request);
System.out.println("msgKey: " + response.getData().getData()
  .getDestinations().get(0).getMsgKey());
```

---

### 3️⃣ MMS 전송 (이미지 첨부)

```java
// 1. 파일 업로드
File file = new File("src/test/resources/image.png");
FileRequest fileRequest = FileRequest.builder()
  .file(file)
  .serviceType(ServiceType.MMS)
  .build();
BizgoResponse uploadRes = client.upload(fileRequest);
String fileKey = uploadRes.getData().getData().getFileKey();

// 2. MMS 메시지 전송
MmsMessage mmsMessage = MmsMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .title("Test MMS Title")
  .text("Test MMS Message with Image")
  .addFileKey(fileKey)
  .build();

Destination destination = Destination.builder()
  .to("01000000000")
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(mmsMessage)
  .addDestination(destination)
  .build();

BizgoResponse response = client.send(request);
```

---

### 4️⃣ 국제 메시지 전송

```java
InternationalMessage internationalMessage = InternationalMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .text("Test International Message")
  .build();

Destination destination = Destination.builder()
  .to("8613800138000")  // 국가번호 포함
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(internationalMessage)
  .addDestination(destination)
  .build();

BizgoResponse response = client.send(request);
```

---

### 5️⃣ RCS 전송

#### RCS SMS (텍스트만)

```java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

String json = "{\"title\": \"제목\", \"description\": \"본문\"}";
ObjectMapper mapper = new ObjectMapper();
Map<String, Object> body = mapper.readValue(json, 
  new TypeReference<Map<String, Object>>() {});

RcsMessage rcsMessage = RcsMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .body(body)
  .formatId("RPSSAXX001")
  .brandKey("YOUR_BRAND_KEY")
  .build();

Destination destination = Destination.builder()
  .to("01000000000")
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(rcsMessage)
  .addDestination(destination)
  .build();

BizgoResponse response = client.send(request);
```

#### RCS LMS (긴 텍스트)

```java
String json = "{"
  + "\"title\": \"제목\","
  + "\"description\": \"긴 메시지 본문...\""
  + "}";
ObjectMapper mapper = new ObjectMapper();
Map<String, Object> body = mapper.readValue(json, 
  new TypeReference<Map<String, Object>>() {});

RcsMessage rcsMessage = RcsMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .body(body)
  .formatId("RPLSAXX001")  // LMS 포맷
  .brandKey("YOUR_BRAND_KEY")
  .build();

// ... 전송 코드 동일
```

#### RCS MMS (이미지 포함)

```java
// 1. RCS용 파일 업로드
File file = new File("src/test/resources/image.png");
FileRequest fileRequest = FileRequest.builder()
  .file(file)
  .serviceType(ServiceType.RCS)
  .build();
BizgoResponse uploadRes = client.upload(fileRequest);
String mediaUrl = uploadRes.getData().getData().getMedia();

// 2. RCS MMS 메시지 전송
String json = "{"
  + "\"title\": \"제목\","
  + "\"description\": \"본문\","
  + "\"media\": \"" + mediaUrl + "\""
  + "}";
ObjectMapper mapper = new ObjectMapper();
Map<String, Object> body = mapper.readValue(json, 
  new TypeReference<Map<String, Object>>() {});

RcsMessage rcsMessage = RcsMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .body(body)
  .formatId("RPMSMTX001")  // MMS 포맷
  .brandKey("YOUR_BRAND_KEY")
  .build();

// ... 전송 코드 동일
```

---

### 6️⃣ 알림톡 전송

#### 일반 알림톡 (AT)

```java
AlimtalkMessage alimtalkMessage = AlimtalkMessage.builder()
  .senderKey("YOUR_SENDER_KEY")
  .msgType(MsgType.AT)
  .templateCode("YOUR_TEMPLATE_CODE")
  .text("알림톡 메시지 본문")
  .build();

Destination destination = Destination.builder()
  .to("01000000000")
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(alimtalkMessage)
  .addDestination(destination)
  .build();

BizgoResponse response = client.send(request);
```

#### 카카오페이 알림톡 (AC)

```java
AlimtalkMessage alimtalkMessage = AlimtalkMessage.builder()
  .senderKey("YOUR_SENDER_KEY")
  .msgType(MsgType.AT)
  .templateCode("YOUR_TEMPLATE_CODE")
  .text("테스트")
  .title("금액")
  .attachment(Attachment.builder()
    .addButton(Button.ACButtonBuilder().build())
    .build())
  .build();

// ... 전송 코드 동일
```

---

### 7️⃣ 브랜드 메시지 전송

#### Basic 타입 (템플릿 기반)

```java
BrandMessage brandMessage = BrandMessage.builder()
  .senderKey("YOUR_SENDER_KEY")
  .sendType(SendType.basic)
  .msgType(MsgType.FT)
  .targeting("I")
  .templateCode("YOUR_TEMPLATE_CODE")
  .build();

Destination destination = Destination.builder()
  .to("01000000000")
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(brandMessage)
  .addDestination(destination)
  .build();

BizgoResponse response = client.send(request);
```

#### Free 타입 (자유 형식)

```java
BrandMessage brandMessage = BrandMessage.builder()
  .senderKey("YOUR_SENDER_KEY")
  .sendType(SendType.free)
  .msgType(MsgType.FI)
  .targeting("I")
  .text("브랜드 메시지 본문")
  .attachment(Attachment.builder()
    .image(Image.builder()
      .imgUrl("https://example.com/image.jpg")
      .build())
    .build())
  .build();

// ... 전송 코드 동일
```

---

### 8️⃣ Fallover (대체 발송)

알림톡 실패 시 SMS로 자동 대체 발송:

```java
// 우선순위: 알림톡 → SMS
AlimtalkMessage alimtalkMessage = AlimtalkMessage.builder()
  .senderKey("YOUR_SENDER_KEY")
  .msgType(MsgType.AT)
  .templateCode("YOUR_TEMPLATE_CODE")
  .text("알림톡 메시지")
  .build();

SmsMessage smsMessage = SmsMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .text("대체 SMS 메시지")
  .build();

Destination destination = Destination.builder()
  .to("01000000000")
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(alimtalkMessage)  // Primary
  .addMessage(smsMessage)        // Fallback
  .addDestination(destination)
  .build();

BizgoResponse response = client.send(request);
```

---

### 9️⃣ 동보 발송 (Multiple Destinations)

```java
SmsMessage smsMessage = SmsMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .text("동보 메시지")
  .build();

Destination destination1 = Destination.builder()
  .to("01000000000")
  .build();

Destination destination2 = Destination.builder()
  .to("01011111111")
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(smsMessage)
  .addDestination(destination1)
  .addDestination(destination2)
  .build();

BizgoResponse response = client.send(request);
```

---

### 🔟 참조 필드 활용 (주문번호 추적 등)

```java
SmsMessage smsMessage = SmsMessage.builder()
  .from("YOUR_SENDER_NUMBER")
  .text("주문이 완료되었습니다")
  .build();

Destination destination = Destination.builder()
  .to("01000000000")
  .build();

OmniRequest request = OmniRequest.builder()
  .addMessage(smsMessage)
  .addDestination(destination)
  .ref("ORDER-12345")  // 참조 필드
  .build();

BizgoResponse response = client.send(request);
```

---

### 1️⃣1️⃣ 응답 처리

```java
BizgoResponse response = client.send(request);

// 공통부 확인
System.out.println("authCode: " + response.getCommon().getAuthCode());
System.out.println("authResult: " + response.getCommon().getAuthResult());

// 데이터부 확인
System.out.println("code: " + response.getData().getCode());
System.out.println("result: " + response.getData().getResult());

// 메시지 키 확인 (개별 메시지 추적용)
if (response.getData().getData() != null &&
    response.getData().getData().getDestinations() != null &&
    !response.getData().getData().getDestinations().isEmpty()) {
  
  String msgKey = response.getData().getData()
    .getDestinations().get(0).getMsgKey();
  System.out.println("msgKey: " + msgKey);
}
```

---

### 1️⃣2️⃣ 전송 리포트 조회

```java
BizgoResponse pollRes = client.get(
  ReportPollingRequest.builder().build());
String reportId = pollRes.getData().getReportId();

client.remove(ReportPollingRequest.builder()
  .reportId(reportId).build());
client.get(ReportInquiryRequest.builder()
  .msgKey("MSG_KEY").build());
```

---

## 🧩 기능 요약

| 기능 항목               | 클래스 / 메서드                        | 비고 |
|------------------------|---------------------------------------|------|
| SMS/LMS/MMS 전송       | `SmsMessage`, `MmsMessage`            | Omni 통합 발송 권장 |
| 국제 메시지            | `InternationalMessage`                | Omni 통합 발송 권장 |
| 알림톡 (AT, AC)        | `AlimtalkMessage`                     | Omni 통합 발송 권장 |
| 친구톡                 | `FriendtalkRequest`                   | - |
| 브랜드 메시지          | `BrandMessage`                        | basic / free 타입 |
| RCS 메시지             | `RcsMessage`                          | SMS/LMS/MMS 포맷 지원 |
| **Omni 통합 메시지**   | `OmniRequest`                         | ⭐ **권장** - Failover, 동보 발송 |
| API Key 인증           | `BizgoClient.builder().apiKey()`      | ⭐ **권장** 인증 방식 |
| OAuth2 인증            | `AuthService#getToken()`              | JWT 토큰 발급 |
| 파일 업로드            | `client.upload(FileRequest)`          | MMS, RCS, Brandmessage |
| 전송 리포트 조회       | `ReportInquiryRequest`                | 메시지 상태 추적 |
| 전송 리포트 폴링       | `ReportPollingRequest`                | 전송 결과 수신 |

---

## 🔍 주요 링크

- 📖 **API 명세서**: [GitBook](https://infobank-guide.gitbook.io/omni_api)
- 📦 **Maven Central**: [검색](https://central.sonatype.com/artifact/io.github.icomm-api/bizgo-sdk-comm-java)
- 📧 **기술 지원**: support@infobank.net
- 🌐 **Bizgo 콘솔**: [https://bizgo.io](https://bizgo.io)

---

## ⚠️ 주의사항

1. **Java 버전**: Java 17 이상 필수 (Java 21 LTS 권장)
2. **API Key 발급**: Bizgo 콘솔에서 발급받아 사용하세요
3. **발신번호 등록**: SMS/MMS/RCS 발송 전 필수
4. **카카오 채널 연동**: 알림톡/친구톡/브랜드메시지 사용 시 필수
5. **파일 업로드**: 전송 전 반드시 파일을 먼저 업로드하세요
6. **인코딩**: UTF-8 사용 권장 (MS949 환경에서는 별도 처리 필요)
7. **방화벽**: API 서버 IP를 방화벽에 허용해야 합니다
8. **Jackson 호환성**: SDK는 `compileOnly`로 Jackson을 참조하므로, 고객사 프로젝트의 Jackson 버전을 자동으로 사용합니다

---

## 🔄 버전 업그레이드 가이드

### v1.0.x → v1.1.1 마이그레이션

**주요 변경사항:**

1. **Java 버전 요구사항 변경**
   - 기존: Java 8+
   - 신규: **Java 17+** (Java 21 LTS 권장)

2. **Spring Boot 호환성 향상**
   - 기존: Spring Boot 3.3.4까지 지원
   - 신규: **Spring Boot 3.x / 4.x 완벽 지원**

3. **Jackson 의존성 전략 변경**
   - 기존: `api` 스코프로 Jackson 2.17.0 포함
   - 신규: `compileOnly` 스코프로 변경 → **고객사 환경의 Jackson 자동 사용**
   - Jackson 버전 충돌 문제 완전 해결

4. **HttpClient 업그레이드**
   - 기존: Apache HttpClient 4.x
   - 신규: **Apache HttpClient 5.x** (성능 및 보안 개선)

**마이그레이션 체크리스트:**

- [ ] Java 17 이상 설치 확인
- [ ] `build.gradle` 또는 `pom.xml`에서 SDK 버전을 `1.1.1`으로 변경
- [ ] 프로젝트에 Jackson 2.15.x 이상이 포함되어 있는지 확인 (Spring Boot 3.x는 자동 포함)
- [ ] 빌드 및 테스트 실행

**코드 변경 불필요**: API 사용법은 100% 호환됩니다.

---

## 📝 License

이 프로젝트는 [Apache2.0 라이선스](LICENSE.txt)를 따릅니다.
