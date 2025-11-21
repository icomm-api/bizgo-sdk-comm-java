package net.bizgo.client.data.request.rcs.buttons.filed;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Location {

    @JsonProperty("latitude")
    private final Double latitude;

    @JsonProperty("longitude")
    private final Double longitude;

    @JsonProperty("label")
    private final String label;

    @JsonProperty("query")
    private final String query;

    public Location(Double latitude, Double longitude, String query, String label) {
        if (latitude == null)
            throw new MissingFieldException("latitude must not be null");
        if (longitude == null)
            throw new MissingFieldException("longitude must not be null");
        if (query == null)
            throw new MissingFieldException("query must not be null");

        this.latitude = latitude;
        this.longitude = longitude;
        this.query = query;
        this.label = label;
    }
}
