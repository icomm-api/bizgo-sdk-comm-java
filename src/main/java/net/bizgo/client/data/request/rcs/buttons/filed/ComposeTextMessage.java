package net.bizgo.client.data.request.rcs.buttons.filed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ComposeTextMessage {

    @JsonProperty("phoneNumber")
    private final String phoneNumber;

    @JsonProperty("text")
    private final String text;

    public ComposeTextMessage(String phoneNumber, String text) {
        if (phoneNumber == null)
            throw new MissingFieldException("phoneNumber must not be null");
        this.phoneNumber = phoneNumber;
        this.text = text;
    }
}
