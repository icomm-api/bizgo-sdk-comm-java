package net.bizgo.client.data.request.rcs.buttons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;
import net.bizgo.client.data.request.rcs.buttons.filed.CreateCalendarEvent;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class CalendarAction {

	@JsonProperty("createCalendarEvent")
	private final CreateCalendarEvent createCalendarEvent;

	private CalendarAction(Builder b) {
		this.createCalendarEvent = b.createCalendarEvent;
	}

	public static class Builder {

		private CreateCalendarEvent createCalendarEvent;

		public Builder createCalendarEvent(CreateCalendarEvent event) {
			this.createCalendarEvent = event;
			return this;
		}

		public CalendarAction build() {
			if (createCalendarEvent == null)
				throw new MissingFieldException("createCalendarEvent must not be null");
			return new CalendarAction(this);
		}
	}

	public static Builder builder() {
		return new Builder();
	}
}
