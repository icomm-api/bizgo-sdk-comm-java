// Generated from spec/openapi.yaml by buildSrc/.../ModelGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * 예약 발송할 채널 메시지 1개입니다. 객체에는 채널 키(<code>sms</code>, <code>mms</code>, <code>international</code>, <code>rcs</code>, <code>alimtalk</code>, <code>brandmessage</code>) 중 <b>정확히 하나</b>를 넣습니다. 채널별 필드는 통합 발송(<code>POST /api/comm/v1/send/omni</code>) 규격과 같습니다. <code>messageFlow</code> 배열의 앞 메시지가 실패하면 다음 메시지가 자동으로 대체발송(Fallback)됩니다.
 * <p>네이버 톡톡(<code>navertalk</code>)은 예약 발송 문서에 없으므로 넣지 않았습니다.
 *
 * <p>Usually you do not create this yourself: {@code client.send().omni(...)} wraps each
 * {@link ChannelMessage} with {@link #of(ChannelMessage)}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE)
@JsonDeserialize(builder = ReservationMessageFlowItem.Builder.class)
public final class ReservationMessageFlowItem {

    static final String EXACTLY_ONE = "messageFlow 항목에는 채널 키(sms, mms, international, rcs, alimtalk, brandmessage) 중 정확히 하나가 있어야 합니다";

    private final SmsMessage sms;
    private final MmsMessage mms;
    private final InternationalMessage international;
    private final RcsMessage rcs;
    private final AlimtalkMessage alimtalk;
    private final BrandMessage brandmessage;

    private ReservationMessageFlowItem(Builder builder) {
        this.sms = builder.sms;
        this.mms = builder.mms;
        this.international = builder.international;
        this.rcs = builder.rcs;
        this.alimtalk = builder.alimtalk;
        this.brandmessage = builder.brandmessage;
    }

    /**
     * Wraps a channel message into its {@code messageFlow} item ({@code {"sms": {...}}} etc.).
     *
     * @param message channel message
     * @return the flow item
     * @throws io.github.icommapi.bizgo.errors.ValidationException if {@code message} is null
     */
    public static ReservationMessageFlowItem of(ChannelMessage message) {
        Builder builder = new Builder();
        if (message instanceof SmsMessage) {
            builder.sms((SmsMessage) message);
        } else if (message instanceof MmsMessage) {
            builder.mms((MmsMessage) message);
        } else if (message instanceof InternationalMessage) {
            builder.international((InternationalMessage) message);
        } else if (message instanceof RcsMessage) {
            builder.rcs((RcsMessage) message);
        } else if (message instanceof AlimtalkMessage) {
            builder.alimtalk((AlimtalkMessage) message);
        } else if (message instanceof BrandMessage) {
            builder.brandmessage((BrandMessage) message);
        }
        return builder.build();
    }

    /** Returns a new, empty builder. */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The channel message in this item.
     *
     * @return the only channel message that is set
     */
    public ChannelMessage getMessage() {
        return Stream.<ChannelMessage>of(sms, mms, international, rcs, alimtalk, brandmessage)
                .filter(Objects::nonNull).findFirst().orElseThrow();
    }

    /**
     * {@code sms} channel message.
     *
     * @return the message, or null
     */
    @JsonProperty("sms")
    public SmsMessage getSms() {
        return sms;
    }

    /**
     * {@code mms} channel message.
     *
     * @return the message, or null
     */
    @JsonProperty("mms")
    public MmsMessage getMms() {
        return mms;
    }

    /**
     * {@code international} channel message.
     *
     * @return the message, or null
     */
    @JsonProperty("international")
    public InternationalMessage getInternational() {
        return international;
    }

    /**
     * {@code rcs} channel message.
     *
     * @return the message, or null
     */
    @JsonProperty("rcs")
    public RcsMessage getRcs() {
        return rcs;
    }

    /**
     * {@code alimtalk} channel message.
     *
     * @return the message, or null
     */
    @JsonProperty("alimtalk")
    public AlimtalkMessage getAlimtalk() {
        return alimtalk;
    }

    /**
     * {@code brandmessage} channel message.
     *
     * @return the message, or null
     */
    @JsonProperty("brandmessage")
    public BrandMessage getBrandmessage() {
        return brandmessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReservationMessageFlowItem)) {
            return false;
        }
        ReservationMessageFlowItem other = (ReservationMessageFlowItem) o;
        return Objects.equals(sms, other.sms)
                && Objects.equals(mms, other.mms)
                && Objects.equals(international, other.international)
                && Objects.equals(rcs, other.rcs)
                && Objects.equals(alimtalk, other.alimtalk)
                && Objects.equals(brandmessage, other.brandmessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sms, mms, international, rcs, alimtalk, brandmessage);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "ReservationMessageFlowItem{", "}");
        if (sms != null) {
            joiner.add("sms=" + sms);
        }
        if (mms != null) {
            joiner.add("mms=" + mms);
        }
        if (international != null) {
            joiner.add("international=" + international);
        }
        if (rcs != null) {
            joiner.add("rcs=" + rcs);
        }
        if (alimtalk != null) {
            joiner.add("alimtalk=" + alimtalk);
        }
        if (brandmessage != null) {
            joiner.add("brandmessage=" + brandmessage);
        }
        return joiner.toString();
    }

    /** Builder for {@link ReservationMessageFlowItem}. Set exactly one channel. */
    @JsonPOJOBuilder(withPrefix = "")
    @JsonAutoDetect(
            fieldVisibility = JsonAutoDetect.Visibility.NONE,
            getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE,
            setterVisibility = JsonAutoDetect.Visibility.NONE,
            creatorVisibility = JsonAutoDetect.Visibility.NONE)
    public static final class Builder {
        private SmsMessage sms;
        private MmsMessage mms;
        private InternationalMessage international;
        private RcsMessage rcs;
        private AlimtalkMessage alimtalk;
        private BrandMessage brandmessage;

        /** Creates an empty builder. */
        public Builder() {
        }

        /**
         * Sets the {@code sms} channel message.
         *
         * @param sms message
         * @return this builder
         */
        @JsonProperty("sms")
        public Builder sms(SmsMessage sms) {
            this.sms = sms;
            return this;
        }

        /**
         * Sets the {@code mms} channel message.
         *
         * @param mms message
         * @return this builder
         */
        @JsonProperty("mms")
        public Builder mms(MmsMessage mms) {
            this.mms = mms;
            return this;
        }

        /**
         * Sets the {@code international} channel message.
         *
         * @param international message
         * @return this builder
         */
        @JsonProperty("international")
        public Builder international(InternationalMessage international) {
            this.international = international;
            return this;
        }

        /**
         * Sets the {@code rcs} channel message.
         *
         * @param rcs message
         * @return this builder
         */
        @JsonProperty("rcs")
        public Builder rcs(RcsMessage rcs) {
            this.rcs = rcs;
            return this;
        }

        /**
         * Sets the {@code alimtalk} channel message.
         *
         * @param alimtalk message
         * @return this builder
         */
        @JsonProperty("alimtalk")
        public Builder alimtalk(AlimtalkMessage alimtalk) {
            this.alimtalk = alimtalk;
            return this;
        }

        /**
         * Sets the {@code brandmessage} channel message.
         *
         * @param brandmessage message
         * @return this builder
         */
        @JsonProperty("brandmessage")
        public Builder brandmessage(BrandMessage brandmessage) {
            this.brandmessage = brandmessage;
            return this;
        }

        /**
         * Builds the item.
         *
         * @return the item
         * @throws io.github.icommapi.bizgo.errors.ValidationException unless exactly one channel is set
         */
        public ReservationMessageFlowItem build() {
            long set = Stream.of(sms, mms, international, rcs, alimtalk, brandmessage).filter(Objects::nonNull).count();
            ModelValidator v = new ModelValidator("ReservationMessageFlowItem");
            v.exactlyOne(set == 1, EXACTLY_ONE);
            v.check();
            return new ReservationMessageFlowItem(this);
        }

        /** Used when this item appears in a response: no request validation. */
        ReservationMessageFlowItem buildUnvalidated() {
            return new ReservationMessageFlowItem(this);
        }
    }
}
