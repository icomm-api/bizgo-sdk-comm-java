package net.bizgo.client.data.request.rcs.buttons.filed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ComposeRecordingMessage {

    @JsonProperty("phoneNumber")
    private final String phoneNumber;

    @JsonProperty("type")
    private final String type; // VIDEO or AUDIO

    public ComposeRecordingMessage(String phoneNumber, String type) {

        if (phoneNumber == null)
            throw new MissingFieldException("phoneNumber must not be null");

        if (type == null)
            throw new MissingFieldException("type must not be null");

        this.phoneNumber = phoneNumber;
        this.type = type;
    }
}
