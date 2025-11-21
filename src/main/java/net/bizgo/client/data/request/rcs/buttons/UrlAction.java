package net.bizgo.client.data.request.rcs.buttons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.bizgo.client.core.exception.MissingFieldException;
import net.bizgo.client.data.request.rcs.buttons.filed.OpenUrl;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class UrlAction {

	@JsonProperty("openUrl")
	private final OpenUrl openUrl;

	private UrlAction(Builder builder) {
		this.openUrl = builder.openUrl;
	}

	public static class Builder {
		private OpenUrl openUrl;

		public Builder openUrl(OpenUrl openUrl) {
			this.openUrl = openUrl;
			return this;
		}

		public UrlAction build() {
			if (openUrl == null) {
				throw new MissingFieldException("openUrl must not be null");
			}
			return new UrlAction(this);
		}
	}

	public static Builder builder() { return new Builder(); }
}
