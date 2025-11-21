package net.bizgo.client.data.request.rcs.buttons.filed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ShowLocation {

    @JsonProperty("location")
    private final Location location;

    @JsonProperty("fallbackUrl")
    private final String fallbackUrl;

    @JsonProperty("requestLocationPush")
    private final Object requestLocationPush; // optional

    private ShowLocation(Builder b) {
        this.location = b.location;
        this.fallbackUrl = b.fallbackUrl;
        this.requestLocationPush = b.requestLocationPush;
    }

    public static class Builder {
        private Location location;
        private String fallbackUrl;
        private Object requestLocationPush;

        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        public Builder fallbackUrl(String fallbackUrl) {
            this.fallbackUrl = fallbackUrl;
            return this;
        }

        public Builder requestLocationPush(Object requestLocationPush) {
            this.requestLocationPush = requestLocationPush;
            return this;
        }

        public ShowLocation build() {
            if (location == null)
                throw new MissingFieldException("location must not be null");
            return new ShowLocation(this);
        }
    }
}
