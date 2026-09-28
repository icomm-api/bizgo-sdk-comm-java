// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

/**
 * Accessors of the resources generated from the spec. {@link Bizgo} extends this class; use it through
 * a {@link Bizgo} instance.
 */
public abstract class BizgoResources {

    private final ReservationsService reservations;
    private final InsightsService insights;
    private final KakaoService kakao;
    private final AlimtalkService alimtalk;
    private final BrandMessageService brandMessage;
    private final RcsService rcs;
    private final CounselService counsel;

    BizgoResources(Transport transport) {
        this.reservations = new ReservationsService(transport);
        this.insights = new InsightsService(transport);
        this.kakao = new KakaoService(transport);
        this.alimtalk = new AlimtalkService(transport);
        this.brandMessage = new BrandMessageService(transport);
        this.rcs = new RcsService(transport);
        this.counsel = new CounselService(transport);
    }

    /**
     * 예약 발송과 예약 관리: {@code client.reservations()}.
     *
     * @return the {@code reservations} resource
     */
    public ReservationsService reservations() {
        return reservations;
    }

    /**
     * 채널별 인사이트(알림톡·브랜드메시지·RCS): {@code client.insights()}.
     *
     * @return the {@code insights} resource
     */
    public InsightsService insights() {
        return insights;
    }

    /**
     * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao()}.
     *
     * @return the {@code kakao} resource
     */
    public KakaoService kakao() {
        return kakao;
    }

    /**
     * 알림톡 템플릿 관리: {@code client.alimtalk()}.
     *
     * @return the {@code alimtalk} resource
     */
    public AlimtalkService alimtalk() {
        return alimtalk;
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage()}.
     *
     * @return the {@code brandMessage} resource
     */
    public BrandMessageService brandMessage() {
        return brandMessage;
    }

    /**
     * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs()}.
     *
     * @return the {@code rcs} resource
     */
    public RcsService rcs() {
        return rcs;
    }

    /**
     * 카카오 상담톡: {@code client.counsel()}.
     *
     * @return the {@code counsel} resource
     */
    public CounselService counsel() {
        return counsel;
    }
}
