package net.bizgo.client.data.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.core.exception.MissingFieldException;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY )
public class InternationalMessage {

    final InternationalData international;

    @JsonProperty("international")
    public InternationalData getInternationalData() {
        return international;
    }

    InternationalMessage(Builder builder) {
        international = new InternationalData(builder);
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY )
    private class InternationalData {
        String from;
        String text;
        String ttl;

        InternationalData(Builder builder) {
            from = builder.from;
            text = builder.text;
            ttl = builder.ttl;
        }

        @JsonProperty("from")
        public String getFrom() {
            return from;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("ttl")
        public String getTtl() {
            return ttl;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        String from;
        String text;
        String ttl;

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder ttl(String ttl) {
            this.ttl = ttl;
            return this;
        }

        public InternationalMessage build() {

            if(from==null){
				throw new MissingFieldException("from field must not be null");
			}
            if(text==null){
				throw new MissingFieldException("text field must not be null");
			}

            return new InternationalMessage(this);
        }
    }
}