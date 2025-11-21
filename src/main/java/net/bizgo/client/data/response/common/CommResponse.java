package net.bizgo.client.data.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bizgo.client.core.exception.ResponseParseException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommResponse {

    private String authCode;
    private String authResult;
    private String infobankTrId;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthResult() {
        return authResult;
    }

    public void setAuthResult(String authResult) {
        this.authResult = authResult;
    }

    public String getInfobankTrId() {
        return infobankTrId;
    }

    public void setInfobankTrId(String infobankTrId) {
        this.infobankTrId = infobankTrId;
    }

    public static CommResponse fromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, CommResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce ApiResponse from json.", e);
        }
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "authCode='" + authCode + '\'' +
                ", authResult='" + authResult + '\'' +
                ", infobankTrId='" + infobankTrId + '\'' +
                '}';
    }
}
