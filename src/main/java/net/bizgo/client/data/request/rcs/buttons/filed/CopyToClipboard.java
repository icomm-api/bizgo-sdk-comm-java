package net.bizgo.client.data.request.rcs.buttons.filed;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;

public final class CopyToClipboard {

    @JsonProperty("text")
    private final String text;

    public CopyToClipboard(String text) {
        if (text == null)
            throw new MissingFieldException("text must not be null");
        this.text = text;
    }
}
