package net.bizgo.client.data.request.rcs.buttons.filed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class CreateCalendarEvent {

    @JsonProperty("startTime")
    private final String startTime;

    @JsonProperty("endTime")
    private final String endTime;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("description")
    private final String description;

    public CreateCalendarEvent(String startTime, String endTime, String title, String description) {

        if (startTime == null)
            throw new MissingFieldException("startTime must not be null");
        if (endTime == null)
            throw new MissingFieldException("endTime must not be null");
        if (title == null)
            throw new MissingFieldException("title must not be null");

        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.description = description;
    }
}
