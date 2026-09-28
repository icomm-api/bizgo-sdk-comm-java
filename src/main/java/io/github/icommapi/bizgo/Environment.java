package io.github.icommapi.bizgo;

/** Bizgo API server. */
public enum Environment {
    /** 운영 서버. 실제로 발송됩니다. */
    PRODUCTION("https://mars.ibapi.kr"),
    /** 테스트 서버. 운영과 같은 API Key를 쓰며 실제로 발송되지 않습니다. */
    SANDBOX("https://sandbox-mars.ibapi.kr");

    private final String baseUrl;

    Environment(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Base URL of the server.
     *
     * @return URL without a trailing slash
     */
    public String baseUrl() {
        return baseUrl;
    }
}
