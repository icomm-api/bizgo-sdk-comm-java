package net.bizgo.client.service.report;

import net.bizgo.client.core.HttpWrapper;
import net.bizgo.client.core.exception.ErrorResponseException;
import net.bizgo.client.data.response.MarsResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;

import java.io.IOException;

/**
 * MessageStatusInquiryService handles message status inquiry.
 *
 * @author Infobank
 * @version 1.0
 * @since 2025-01-01
 */
public class MessageStatusInquiryService {

    private static final String PATH_BY_MSG_KEY = "/v1/message/inquiry/msgKey/{msgKey}";
    private static final String PATH_BY_REQUEST_ID = "/v1/message/inquiry/requestId/{requestId}";

    private final HttpWrapper httpWrapper;
    private final BasicResponseHandler basicResponseHandler;

    public MessageStatusInquiryService(HttpWrapper httpWrapper) {
        this.httpWrapper = httpWrapper;
        this.basicResponseHandler = new BasicResponseHandler();
    }

    /**
     * Inquire message status by message key (single message)
     *
     * @param msgKey Message key - Required
     * @return MarsResponse containing message status data
     * @throws Exception if inquiry fails
     */
    public MarsResponse inquireByMsgKey(String msgKey) throws Exception {
        if (msgKey == null || msgKey.isEmpty()) {
            throw new IllegalArgumentException("msgKey must not be null or empty");
        }

        String url = httpWrapper.getHttpConfig().getBaseUrl() + 
            PATH_BY_MSG_KEY.replace("{msgKey}", msgKey);

        return executeRequest(url);
    }

    /**
     * Inquire message status by request ID (multiple messages)
     * 
     * RequestId is msgKey without the last 3 characters (for broadcast inquiry)
     *
     * @param requestId Request ID - Required
     * @return MarsResponse containing message status data
     * @throws Exception if inquiry fails
     */
    public MarsResponse inquireByRequestId(String requestId) throws Exception {
        if (requestId == null || requestId.isEmpty()) {
            throw new IllegalArgumentException("requestId must not be null or empty");
        }

        String url = httpWrapper.getHttpConfig().getBaseUrl() + 
            PATH_BY_REQUEST_ID.replace("{requestId}", requestId);

        return executeRequest(url);
    }

    private MarsResponse executeRequest(String url) throws Exception {
        try {
            HttpGet httpGet = new HttpGet(url);
            
            HttpResponse response = httpWrapper.getHttpClient().execute(httpGet);
            
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String responseBody = basicResponseHandler.handleResponse(response);
                return MarsResponse.fromJson(responseBody);
            } else {
                throw ErrorResponseException.fromHttpResponse(response);
            }
        } catch (IOException e) {
            throw new Exception("Failed to execute HTTP request", e);
        }
    }
}

