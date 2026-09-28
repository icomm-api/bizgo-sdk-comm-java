package net.bizgo.client.data.request.rcs.buttons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;
import net.bizgo.client.data.request.rcs.buttons.filed.ShowLocation;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class MapAction {

	@JsonProperty("showLocation")
	private final ShowLocation showLocation;

	private MapAction(Builder b) {
		this.showLocation = b.showLocation;
	}

	public static class Builder {
		private ShowLocation showLocation;

		public Builder showLocation(ShowLocation showLocation) {
			this.showLocation = showLocation;
			return this;
		}

		public MapAction build() {
			if (showLocation == null)
				throw new MissingFieldException("showLocation must not be null");
			return new MapAction(this);
		}
	}

	public static Builder builder() {
		return new Builder();
	}
}
