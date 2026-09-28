package net.bizgo.client.data.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static net.bizgo.client.data.code.MsgType.*;

import java.util.EnumSet;
import java.util.Set;

/**
 * Represents the services available for sending messages.
 */
public enum ServiceType {

    /**
     * SMS Simple Send Service.
	 * <p>
	 * Included message types: SM
     */
    SMS (SM),

	/**
     * MMS Simple Send Service.
	 * <p>
	 * Included message types: LM, MM
     */
    MMS (LM, MM),

	/**
     * International Simple Send Service.
	 * <p>
	 * Included message types: IM
     */
    INTERNATIONAL (IM),

	/**
     * RCS Simple Send Service.
	 * <p>
	 * Included message types: RS,RL,RM,RF,RD,RC,RI
     */
    RCS(RS,RL,RM,RF,RD,RC,RI),

	/**
     * KAKAO ALIMTALK Simple Send Service.
	 * <p>
	 * Included message types: AT,AI
     */
    ALIMTALK(AT,AI),

	/**
	 * KAKAO BRAMDMESSAGE Simple Send Service.
	 * <p>
	 * Included message types: FT,FI,FW,FL,FC,FM,FA,FP, DEFAULT, WIDE, WIDE_ITEM_LIST, CAROUSEL_COMMERCE, CAROUSEL_FEED
	 */
	BRANDMESSAGE(FT,FI,FW,FL,FC,FM,FA,FP, DEFAULT, WIDE, WIDE_ITEM_LIST, CAROUSEL_COMMERCE, CAROUSEL_FEED),


	/**
     * OMNI Send Service.
	 * <p>
	 * Included message types: ALL
     */
    OMNI (SM,LM,MM,IM,RS,RL,RM,RF,RD,RC,RI,AT,AI,FT,FI,FW,FL,FC,FM,FA,FP, DEFAULT, WIDE, WIDE_ITEM_LIST, CAROUSEL_COMMERCE, CAROUSEL_FEED);

    private final Set<MsgType> supportedTypes;

	ServiceType(MsgType type1, MsgType... additionalTypes) {
		this.supportedTypes = EnumSet.of(type1, additionalTypes);
	}

	public Set<MsgType> getSupportedMessageTypes() {
		return supportedTypes;
	}

	public boolean supports(MsgType msgType) {
        return supportedTypes.contains(msgType);
    }

    @JsonCreator
	public static ServiceType fromString(String value) {
		if (value == null) return null;
		return ServiceType.valueOf(value.toUpperCase());
	}

	@JsonValue
	@Override
	public String toString() {
		return name();
	}
}
