package net.bizgo.client.data.request.rcs.buttons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.bizgo.client.core.exception.MissingFieldException;
import net.bizgo.client.data.request.rcs.buttons.filed.DialPhoneNumber;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class DialerAction {

	@JsonProperty("dialPhoneNumber")
	private final DialPhoneNumber dialPhoneNumber;

	private DialerAction(Builder b) {
		this.dialPhoneNumber = b.dialPhoneNumber;
	}

	public static class Builder {
		private DialPhoneNumber dialPhoneNumber;

		public Builder dialPhoneNumber(DialPhoneNumber d) {
			this.dialPhoneNumber = d;
			return this;
		}

		public DialerAction build() {
			if (dialPhoneNumber == null)
				throw new MissingFieldException("dialPhoneNumber must not be null");
			return new DialerAction(this);
		}
	}
}

