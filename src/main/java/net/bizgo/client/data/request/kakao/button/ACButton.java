package net.bizgo.client.data.request.kakao.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.bizgo.client.data.code.KakaoButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class ACButton implements Button{

	final String type = KakaoButtonType.AC.toString();
	final String name = "채널 추가";

	public ACButton(Builder builder) {
	}

    public static class Builder {

        public Builder() {}

        public ACButton build() {
            return new ACButton(this);
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
