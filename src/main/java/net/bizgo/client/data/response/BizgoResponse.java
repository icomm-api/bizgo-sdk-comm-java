package net.bizgo.client.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bizgo.client.core.exception.ResponseParseException;
import net.bizgo.client.data.response.common.CommResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BizgoResponse {

    private CommResponse common;
    private DataResponse data;


    public CommResponse getCommon() {
        return common;
    }

    public void setCommon(CommResponse common) {
        this.common = common;
    }

    public DataResponse getData() {
        return data;
    }

    public void setData(DataResponse data) {
        this.data = data;
    }

    public static BizgoResponse fromJson(String s) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(s, BizgoResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce MarsResponse from json.", e);
        }
    }

}
