package net.bizgo.client.service.report;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;

import net.bizgo.client.core.HttpWrapper;
import net.bizgo.client.core.exception.ErrorResponseException;
import net.bizgo.client.data.response.BizgoResponse;

/**
 * MessageHistoryInquiryService handles message sending history inquiry.
 *
 * @author Infobank
 * @version 1.0
 * @since 2025-01-01
 */
public class MessageHistoryInquiryService {

    private static final String PATH = "/v1/message/history";

    private final HttpWrapper httpWrapper;
    private final BasicResponseHandler basicResponseHandler;

    public MessageHistoryInquiryService(HttpWrapper httpWrapper) {
        this.httpWrapper = httpWrapper;
        this.basicResponseHandler = new BasicResponseHandler();
    }

    /**
     * Inquire message history
     *
     * @param requestTime Request time (YYYY-MM-DDTHH:mm:ss) - Required
     * @return MarsResponse containing message history data
     * @throws Exception if inquiry fails
     */
    public BizgoResponse inquire(String requestTime) throws Exception {
        return inquire(requestTime, null, null, null, null);
    }

    /**
     * Inquire message history
     *
     * @param requestTime Request time (YYYY-MM-DDTHH:mm:ss) - Required
     * @param serviceType Service type (SMS, MMS, RCS, ALIMTALK, BRANDMESSAGE) - Optional
     * @return MarsResponse containing message history data
     * @throws Exception if inquiry fails
     */
    public BizgoResponse inquire(String requestTime, String serviceType) throws Exception {
        return inquire(requestTime, serviceType, null, null, null);
    }

    /**
     * Inquire message history
     *
     * @param requestTime Request time (YYYY-MM-DDTHH:mm:ss) - Required
     * @param serviceType Service type (SMS, MMS, RCS, ALIMTALK, BRANDMESSAGE) - Optional
     * @param groupKey Group key - Optional
     * @param lastSeq Last sequence for pagination - Optional
     * @param limit Maximum number of records (default: 100, max: 1000) - Optional
     * @return MarsResponse containing message history data
     * @throws Exception if inquiry fails
     */
    public BizgoResponse inquire(String requestTime, String serviceType, String groupKey, 
                                         String lastSeq, Integer limit) throws Exception {
        if (requestTime == null || requestTime.isEmpty()) {
            throw new IllegalArgumentException("requestTime must not be null or empty");
        }

        try {
            URIBuilder uriBuilder = new URIBuilder(httpWrapper.getHttpConfig().getBaseUrl() + PATH);
            uriBuilder.addParameter("requestTime", requestTime);
            
            if (serviceType != null && !serviceType.isEmpty()) {
                uriBuilder.addParameter("serviceType", serviceType);
            }
            
            if (groupKey != null && !groupKey.isEmpty()) {
                uriBuilder.addParameter("groupKey", groupKey);
            }
            
            if (lastSeq != null && !lastSeq.isEmpty()) {
                uriBuilder.addParameter("lastSeq", lastSeq);
            }
            
            if (limit != null) {
                uriBuilder.addParameter("limit", String.valueOf(limit));
            }

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            
            HttpResponse response = httpWrapper.getHttpClient().execute(httpGet);
            
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String responseBody = basicResponseHandler.handleResponse(response);
                return BizgoResponse.fromJson(responseBody);
            } else {
                throw ErrorResponseException.fromHttpResponse(response);
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to build URI", e);
        } catch (IOException e) {
            throw new Exception("Failed to execute HTTP request", e);
        }
    }
}

