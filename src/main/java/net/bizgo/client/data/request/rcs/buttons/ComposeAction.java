package net.bizgo.client.data.request.rcs.buttons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.data.request.rcs.buttons.filed.ComposeRecordingMessage;
import net.bizgo.client.data.request.rcs.buttons.filed.ComposeTextMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ComposeAction {

	@JsonProperty("composeTextMessage")
	private final ComposeTextMessage composeTextMessage;

	@JsonProperty("composeRecordingMessage")
	private final ComposeRecordingMessage composeRecordingMessage;

	private ComposeAction(Builder b) {
		this.composeTextMessage = b.composeTextMessage;
		this.composeRecordingMessage = b.composeRecordingMessage;
	}

	public static class Builder {

		private ComposeTextMessage composeTextMessage;
		private ComposeRecordingMessage composeRecordingMessage;

		public Builder composeTextMessage(ComposeTextMessage textMsg) {
			this.composeTextMessage = textMsg;
			return this;
		}

		public Builder composeRecordingMessage(ComposeRecordingMessage recMsg) {
			this.composeRecordingMessage = recMsg;
			return this;
		}

		public ComposeAction build() {
			if (composeTextMessage == null && composeRecordingMessage == null)
				throw new IllegalArgumentException("composeTextMessage or composeRecordingMessage must be provided");

			return new ComposeAction(this);
		}
	}

	public static Builder builder() {
		return new Builder();
	}
}
