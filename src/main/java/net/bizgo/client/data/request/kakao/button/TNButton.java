package net.bizgo.client.data.request.kakao.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bizgo.client.data.code.KakaoButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class TNButton implements Button{

	final String type = KakaoButtonType.TN.toString();
	final String name;
	final String telNumber;

	public TNButton(Builder builder) {
		this.name = builder.name;
		this.telNumber = builder.telNumber;
	}


	public static class Builder {

		private String name;
		private String telNumber;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder telNumber(String telNumber) {
			this.telNumber = telNumber;
			return this;
		}


		public TNButton build() {
            return new TNButton(this);
        }
    }

	public static Builder builder() {
		return new Builder();
	}

	@Override
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@Override
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@Override
	@JsonProperty("urlPc")
	public String getUrlPc() {
		return null;
	}

	@Override
	@JsonProperty("urlMobile")
	public String getUrlMobile() {
		return null;
	}

	@Override
	@JsonProperty("schemeIos")
	public String getSchemeIos() {
		return null;
	}

	@Override
	@JsonProperty("schemeAndroid")
	public String getSchemeAndroid() {
		return null;
	}

	@Override
	@JsonProperty("target")
	public String getTarget() {
		return null;
	}

	@Override
	@JsonProperty("chatExtra")
	public String getChatExtra() {
		return null;
	}

	@Override
	@JsonProperty("chatEvent")
	public String getChatEvent() {
		return null;
	}

	@Override
	@JsonProperty("bizFormKey")
	public String getBizFormKey() {
		return null;
	}

	@Override
	@JsonProperty("bizFormId")
	public String getBizFormId() {
		return null;
	}

	@Override
	@JsonProperty("telNumber")
	public String getTelNumber() {
		return null;
	}
}
