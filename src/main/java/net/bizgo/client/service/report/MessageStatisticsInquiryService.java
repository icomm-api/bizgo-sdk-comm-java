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
 * MessageStatisticsInquiryService handles message sending statistics inquiry.
 *
 * @author Infobank
 * @version 1.0
 * @since 2025-01-01
 */
public class MessageStatisticsInquiryService {

    private static final String PATH = "/v1/message/statistics";

    private final HttpWrapper httpWrapper;
    private final BasicResponseHandler basicResponseHandler;

    public MessageStatisticsInquiryService(HttpWrapper httpWrapper) {
        this.httpWrapper = httpWrapper;
        this.basicResponseHandler = new BasicResponseHandler();
    }

    /**
     * Inquire message statistics
     *
     * @param startDate Start date (YYYYMMDD) - Required
     * @return MarsResponse containing statistics data
     * @throws Exception if inquiry fails
     */
    public BizgoResponse inquire(String startDate) throws Exception {
        return inquire(startDate, null, null, null);
    }

    /**
     * Inquire message statistics
     *
     * @param startDate Start date (YYYYMMDD) - Required
     * @param endDate End date (YYYYMMDD) - Optional
     * @return MarsResponse containing statistics data
     * @throws Exception if inquiry fails
     */
    public BizgoResponse inquire(String startDate, String endDate) throws Exception {
        return inquire(startDate, endDate, null, null);
    }

    /**
     * Inquire message statistics
     *
     * @param startDate Start date (YYYYMMDD) - Required
     * @param endDate End date (YYYYMMDD) - Optional
     * @param serviceType Service type (SMS, MMS, RCS, ALIMTALK, BRANDMESSAGE) - Optional
     * @param groupKey Group key - Optional
     * @return MarsResponse containing statistics data
     * @throws Exception if inquiry fails
     */
    public BizgoResponse inquire(String startDate, String endDate, String serviceType, String groupKey) 
            throws Exception {
        if (startDate == null || startDate.isEmpty()) {
            throw new IllegalArgumentException("startDate must not be null or empty");
        }

        try {
            URIBuilder uriBuilder = new URIBuilder(httpWrapper.getHttpConfig().getBaseUrl() + PATH);
            uriBuilder.addParameter("startDate", startDate);
            
            if (endDate != null && !endDate.isEmpty()) {
                uriBuilder.addParameter("endDate", endDate);
            }
            
            if (serviceType != null && !serviceType.isEmpty()) {
                uriBuilder.addParameter("serviceType", serviceType);
            }
            
            if (groupKey != null && !groupKey.isEmpty()) {
                uriBuilder.addParameter("groupKey", groupKey);
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

