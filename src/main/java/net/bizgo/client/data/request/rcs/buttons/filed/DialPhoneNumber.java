package net.bizgo.client.data.request.rcs.buttons.filed;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;

public final class DialPhoneNumber {

    @JsonProperty("phoneNumber")
    private final String phoneNumber;

    public DialPhoneNumber(String phoneNumber) {
        if (phoneNumber == null)
            throw new MissingFieldException("phoneNumber must not be null");
        this.phoneNumber = phoneNumber;
    }
}