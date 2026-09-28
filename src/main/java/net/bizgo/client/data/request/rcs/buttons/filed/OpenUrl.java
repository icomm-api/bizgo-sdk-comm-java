package net.bizgo.client.data.request.rcs.buttons.filed;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;

public final class OpenUrl {

    @JsonProperty("url")
    private final String url;

    public OpenUrl(String url) {
        if (url == null)
            throw new MissingFieldException("url must not be null");
        this.url = url;
    }

    public String getUrl() { return url; }
}
