package net.bizgo.client.data.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the type of the message.
 */
public enum MsgType {
    /**
     * SMS(Short Message)
     */
    SM,

	/**
	 * LMS(Long Message)
	 */
	LM,

	/**
	 * MMS(Multimedia Message)
	 */
	MM,

	/**
	 * International Message
	 */
	IM,

	/**
	 * RCS SMS
	 * (Rich Commnuication,
	 *  Short Message)
	 */
	RS,

	/**
	 * RCS LMS
	 * (Rich Commnuication,
	 *  Long Message)
	 */
	RL,

	/**
	 * RCS MMS
	 * (Rich Commnuication,
	 *  Multimedia Message)
	 */
	RM,

	/**
	 * RCS Free Template
	 */
	RF,

	/**
	 * RCS Description Template
	 */
	RD,

	/**
	 * RCS Cell Template
	 */
	RC,

	/**
	 * RCS Image Template
	 */
	RI,

	/**
	 * Kakao Alimtalk Text
	 */
	AT,

	/**
	 * Kakao Alimtalk Image
	 */
	AI,

	/**
	 * Kakao Friendtalk Text
	 */
	FT,

	/**
	 * Kakao Friendtalk Image
	 */
	FI,

	/**
	 * Kakao Friendtalk Wideimage
	 */
	FW,

	/**
	 * Kakao Friendtalk Wideimage Itemlist
	 */
	FL,

	/**
	 * Kakao Friendtalk Carousel
	 */
	FC,

	/**
	 * Kakao Friendtalk Commerce
	 */
	FM,

	/**
	 * Kakao Friendtalk Carousel Commerce
	 */
	FA,

	/**
	 * Kakao Friendtalk Video
	 */
	FP,


	// 변환된 이름
	DEFAULT("default"),
	WIDE("wide"),
	ITEM_LIST("itemList"),
	WIDE_ITEM_LIST("wideItemList"),
	CAROUSEL_FEED("carouselFeed"),
	CAROUSEL_COMMERCE("carouselCommerce")
	;

	private final String jsonValue;

	// 기본 생성자: enum 이름을 그대로 사용 (SM → "SM")
	MsgType() {
		this.jsonValue = name();
	}

	// 소문자 등 커스텀 값 지정용 생성자
	MsgType(String jsonValue) {
		this.jsonValue = jsonValue;
	}

	@JsonValue
	public String toJson() {
		return jsonValue;
	}

	@JsonCreator
	public static MsgType fromJson(String value) {
		for (MsgType type : values()) {
			if (type.jsonValue.equalsIgnoreCase(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Unknown MessageType: " + value);
	}
	@Override
	public String toString() {
		return jsonValue;
	}
}

