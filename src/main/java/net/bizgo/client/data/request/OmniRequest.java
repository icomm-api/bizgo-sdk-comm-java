package net.bizgo.client.data.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bizgo.client.core.exception.MissingFieldException;
import net.bizgo.client.core.exception.UnexpectedException;
import net.bizgo.client.data.request.common.Destination;
import net.bizgo.client.data.request.message.*;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public final class OmniRequest {
	
	final List<Destination> destinations;
	final List<Object> messageFlow;
	final String paymentCode;
	final String groupKey;
	final String idempotencyKey;
	final String idempotencyTtl;
	final String ref;

	OmniRequest(Builder builder) {

		this.destinations = builder.destinations;
		this.messageFlow = builder.messageFlow;
		this.paymentCode = builder.paymentCode;
		this.groupKey = builder().groupKey;
		this.idempotencyKey = builder.idempotencyKey;
		this.idempotencyTtl = builder.idempotencyTtl;
		this.ref = builder.ref;
	}

	@JsonProperty("destinations")
	public List<Destination> getDestinations() {
		return destinations;
	}

	@JsonProperty("messageFlow")
	public List<Object> getMessageFlow() {
		return messageFlow;
	}

	@JsonProperty("paymentCode")
	public String getPaymentCode() {
		return paymentCode;
	}

	@JsonProperty("groupKey")
	public String getGroupKey() {
		return paymentCode;
	}

	@JsonProperty("idempotencyKey")
	public String getIdempotencyKey() {
		return paymentCode;
	}

	@JsonProperty("idempotencyTtl")
	public String getIdempotencyTtl() {
		return paymentCode;
	}

	@JsonProperty("ref")
	public String getRef() {
		return ref;
	}

	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private List<Destination> destinations = new ArrayList<>();
		private List<Object> messageFlow = new ArrayList<>();
		private String paymentCode;
		private String groupKey;
		private String idempotencyKey;
		private String idempotencyTtl;
		private String ref;

		Builder() {}

		public Builder addDestination(Destination destination) {
            destinations.add(destination);
            return this;
        }

		public Builder addMessage(SmsMessage sms) {
            messageFlow.add(sms);
            return this;
        }

		public Builder addMessage(MmsMessage mms) {
            messageFlow.add(mms);
            return this;
        }

		public Builder addMessage(InternationalMessage international) {
			messageFlow.add(international);
			return this;
		}

		public Builder addMessage(RcsMessage rcs) {
            messageFlow.add(rcs);
            return this;
        }

		public Builder addMessage(AlimtalkMessage alimtalk) {
            messageFlow.add(alimtalk);
            return this;
        }

		public Builder addMessage(BrandMessage brandmessage) {
			messageFlow.add(brandmessage);
			return this;
		}

		public Builder paymentCode(String paymentCode) {
            this.paymentCode = paymentCode;
            return this;
        }

		public Builder groupKey(String groupKey) {
			this.groupKey = groupKey;
			return this;
		}

		public Builder idempotencyKey(String idempotencyKey) {
			this.idempotencyKey = idempotencyKey;
			return this;
		}

		public Builder idempotencyTtl(String idempotencyTtl) {
			this.idempotencyTtl = idempotencyTtl;
			return this;
		}

		public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

		public OmniRequest build() {

			if(destinations.size()==0){
				throw new MissingFieldException("destinations field must not be null");
			}

			return new OmniRequest(this);
		}
	}

	public String toJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		}
		catch (JsonProcessingException jpe) {
			throw new UnexpectedException("Failed to produce JSON from "+getClass().getSimpleName()+" object.", jpe);
		}
	}

}
