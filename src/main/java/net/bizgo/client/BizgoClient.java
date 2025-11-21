package net.bizgo.client;

import net.bizgo.client.data.request.FileRequest;
import net.bizgo.client.data.request.OmniRequest;
import net.bizgo.client.data.request.ReportInquiryRequest;
import net.bizgo.client.data.request.ReportPollingRequest;
import net.bizgo.client.data.response.MarsResponse;
import net.bizgo.client.service.send.OmniService;
import net.bizgo.client.service.auth.MarsService;
import org.apache.http.client.HttpClient;

import net.bizgo.client.core.HttpConfig;
import net.bizgo.client.core.HttpWrapper;
import net.bizgo.client.service.auth.AuthService;
import net.bizgo.client.service.regi.FileService;
import net.bizgo.client.service.report.MessageStatisticsInquiryService;
import net.bizgo.client.service.report.MessageHistoryInquiryService;
import net.bizgo.client.service.report.MessageStatusInquiryService;
import net.bizgo.client.service.report.ReportInquiryService;
import net.bizgo.client.service.report.ReportPollingService;

/**
 * Infobank OMNI API client Object.
 */
public class BizgoClient {

    private final HttpWrapper httpWrapper;
    private final FileService fileService;
    private final OmniService omniService;
    private final MessageStatisticsInquiryService messageStatisticsInquiryService;
    private final MessageHistoryInquiryService messageHistoryInquiryService;
    private final MessageStatusInquiryService messageStatusInquiryService;
    private final ReportInquiryService reportInquiryService;
    private final ReportPollingService reportPollingService;

    private BizgoClient(Builder builder) {
        httpWrapper = new HttpWrapper(builder.httpConfig, builder.authService, builder.marsService);
        httpWrapper.setHttpClient(builder.httpClient);

        fileService = new FileService(httpWrapper);
        omniService = new OmniService(httpWrapper);
        messageStatisticsInquiryService = new MessageStatisticsInquiryService(httpWrapper);
        messageHistoryInquiryService = new MessageHistoryInquiryService(httpWrapper);
        messageStatusInquiryService = new MessageStatusInquiryService(httpWrapper);
        reportInquiryService = new ReportInquiryService(httpWrapper);
        reportPollingService = new ReportPollingService(httpWrapper);
    }

    public MarsResponse send(OmniRequest omni) throws Exception {
        return omniService.execute(omni);
    }

    public MarsResponse upload(FileRequest file) throws Exception {
        return fileService.execute(file);
    }

    public MarsResponse inquireStatistics(String startDate) throws Exception {
        return messageStatisticsInquiryService.inquire(startDate);
    }

    public MarsResponse inquireStatistics(String startDate, String endDate) throws Exception {
        return messageStatisticsInquiryService.inquire(startDate, endDate);
    }

    public MarsResponse inquireStatistics(String startDate, String endDate, String serviceType, String groupKey) throws Exception {
        return messageStatisticsInquiryService.inquire(startDate, endDate, serviceType, groupKey);
    }

    public MarsResponse inquireHistory(String requestTime) throws Exception {
        return messageHistoryInquiryService.inquire(requestTime);
    }

    public MarsResponse inquireHistory(String requestTime, String serviceType) throws Exception {
        return messageHistoryInquiryService.inquire(requestTime, serviceType);
    }

    public MarsResponse inquireHistory(String requestTime, String serviceType, String groupKey, String lastSeq, Integer limit) throws Exception {
        return messageHistoryInquiryService.inquire(requestTime, serviceType, groupKey, lastSeq, limit);
    }

    public MarsResponse inquireStatusByMsgKey(String msgKey) throws Exception {
        return messageStatusInquiryService.inquireByMsgKey(msgKey);
    }

    public MarsResponse inquireStatusByRequestId(String requestId) throws Exception {
        return messageStatusInquiryService.inquireByRequestId(requestId);
    }

    public MarsResponse get(ReportInquiryRequest req) throws Exception {
        return reportInquiryService.execute(req);
    }

    public MarsResponse get(ReportPollingRequest req) throws Exception {
        req.setMethod("GET");
        return reportPollingService.execute(req);
    }

    public MarsResponse remove(ReportPollingRequest req) throws Exception {
        req.setMethod("DELETE");
        return reportPollingService.execute(req);
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private HttpConfig httpConfig = HttpConfig.defaultConfig();
        private HttpClient httpClient;
        private AuthService authService;
        private MarsService marsService;
        private String apiKey;
        private String clientId;
        private String password;


        public Builder httpConfig(HttpConfig httpConfig) {
            this.httpConfig = httpConfig;
            return this;
        }

        public Builder httpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

         public BizgoClient build() {

             if (apiKey != null) {
                 marsService = new MarsService(httpConfig, httpClient, apiKey);
             }

            if (clientId != null && password != null) {
                authService = new AuthService(httpConfig, httpClient, clientId, password);
            }
            return new BizgoClient(this);
        }
    }
}
