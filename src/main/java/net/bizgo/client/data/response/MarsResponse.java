package net.bizgo.client.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bizgo.client.core.exception.ResponseParseException;
import net.bizgo.client.data.response.common.CommResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarsResponse {

    private CommResponse common;
    private OmniResponse data;


    public CommResponse getCommon() {
        return common;
    }

    public void setCommon(CommResponse common) {
        this.common = common;
    }

    public OmniResponse getData() {
        return data;
    }

    public void setData(OmniResponse data) {
        this.data = data;
    }

    public static MarsResponse fromJson(String s) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(s, MarsResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce MarsResponse from json.", e);
        }
    }

}
