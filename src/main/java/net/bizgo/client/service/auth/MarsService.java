package net.bizgo.client.service.auth;

import net.bizgo.client.core.HttpConfig;
import net.bizgo.client.core.Util;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicResponseHandler;

import java.io.IOException;

/**
 * AuthService 클래스는 응용 프로그램 내에서 인증 작업을 처리하는 것을 담당합니다.
 * 이에는 인증 토큰 관리, 요청 초기화, 그리고 HTTP 클라이언트 상호작용을 포함합니다.
 * 이 클래스는 HTTP 작업을 처리하기 위해 Apache HttpComponents 라이브러리를 사용하고, 로깅을 위해 SLF4J를 사용합니다.
 *
 * @author OpenAI
 * @version 1.0
 * @since 2023-07-13
 */
public class MarsService {


    /**
     * HTTP 응답을 처리하는 기본 응답 핸들러입니다.
     */
    private final BasicResponseHandler basicResponseHandler = new BasicResponseHandler();

    /**
     * HTTP 설정 정보를 관리하는 객체입니다.
     */
    private HttpConfig httpConfig;

    /**
     * HTTP 클라이언트 객체를 관리하는 변수입니다.
     */
    private HttpClient httpClient;

    /**
     * 클라이언트 ID를 저장하는 변수입니다.
     */
    private String apiKey;
    

    /**
     * 새로운 AuthService 객체를 생성합니다.
     *
     * @param httpConfig HTTP 구성 객체입니다.
     * @param httpClient HTTP 클라이언트 객체입니다.
     * @param apiKey Api Key입니다.
     */
    public MarsService(HttpConfig httpConfig, HttpClient httpClient, String apiKey) {
        this.httpConfig = httpConfig;
        this.httpClient = httpClient;
        this.apiKey = apiKey;
    }

    /**
     * 인증 헤더를 포함한 RequestBuilder 를 초기화합니다. 이 헤더에는 베어러 토큰이 포함되어 있습니다.
     *
     * @param request 초기화할 요청입니다.
     * @return 추가된 인증 헤더가 있는 RequestBuilder 객체를 반환합니다.
     */
    public RequestBuilder init(RequestBuilder request) throws IOException {
        return request.addHeader("Authorization", apiKey);
    }

    /**
     * HTTP 클라이언트 객체를 반환합니다. 이 객체가 존재하지 않는 경우 새로운 객체를 생성하려고 시도합니다.
     *
     * @return HttpClient 객체를 반환합니다.
     */
    public HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = Util.createHttpClient(httpConfig);
        }
        return httpClient;
    }

}
