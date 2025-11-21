package net.bizgo.client.data.request.rcs.buttons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.bizgo.client.core.exception.MissingFieldException;
import net.bizgo.client.data.request.rcs.buttons.filed.CopyToClipboard;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ClipboardAction {

	@JsonProperty("copyToClipboard")
	private final CopyToClipboard copyToClipboard;

	private ClipboardAction(Builder b) {
		this.copyToClipboard = b.copyToClipboard;
	}

	public static class Builder {
		private CopyToClipboard copyToClipboard;

		public Builder copyToClipboard(CopyToClipboard c) {
			this.copyToClipboard = c;
			return this;
		}

		public ClipboardAction build() {
			if (copyToClipboard == null)
				throw new MissingFieldException("copyToClipboard must not be null");
			return new ClipboardAction(this);
		}
	}
}
