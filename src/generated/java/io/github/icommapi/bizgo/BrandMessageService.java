// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

/**
 * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: brandMessage}).
 */
public final class BrandMessageService {

    private final Transport transport;
    private final BrandMessageGroupSendsService groupSends;
    private final BrandMessageAudienceService audience;
    private final BrandMessagePermissionsService permissions;
    private final BrandMessageVideosService videos;
    private final BrandMessageTemplatesService templates;
    private final BrandMessageGroupTagsService groupTags;
    private final BrandMessageFriendGroupsService friendGroups;
    private final BrandMessageMarketingAgreementsService marketingAgreements;
    private final BrandMessageUnsubscribeContentsService unsubscribeContents;

    BrandMessageService(Transport transport) {
        this.transport = transport;
        this.groupSends = new BrandMessageGroupSendsService(transport);
        this.audience = new BrandMessageAudienceService(transport);
        this.permissions = new BrandMessagePermissionsService(transport);
        this.videos = new BrandMessageVideosService(transport);
        this.templates = new BrandMessageTemplatesService(transport);
        this.groupTags = new BrandMessageGroupTagsService(transport);
        this.friendGroups = new BrandMessageFriendGroupsService(transport);
        this.marketingAgreements = new BrandMessageMarketingAgreementsService(transport);
        this.unsubscribeContents = new BrandMessageUnsubscribeContentsService(transport);
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().groupSends()}.
     *
     * @return the {@code brandMessage.groupSends} resource
     */
    public BrandMessageGroupSendsService groupSends() {
        return groupSends;
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().audience()}.
     *
     * @return the {@code brandMessage.audience} resource
     */
    public BrandMessageAudienceService audience() {
        return audience;
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().permissions()}.
     *
     * @return the {@code brandMessage.permissions} resource
     */
    public BrandMessagePermissionsService permissions() {
        return permissions;
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().videos()}.
     *
     * @return the {@code brandMessage.videos} resource
     */
    public BrandMessageVideosService videos() {
        return videos;
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().templates()}.
     *
     * @return the {@code brandMessage.templates} resource
     */
    public BrandMessageTemplatesService templates() {
        return templates;
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().groupTags()}.
     *
     * @return the {@code brandMessage.groupTags} resource
     */
    public BrandMessageGroupTagsService groupTags() {
        return groupTags;
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().friendGroups()}.
     *
     * @return the {@code brandMessage.friendGroups} resource
     */
    public BrandMessageFriendGroupsService friendGroups() {
        return friendGroups;
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().marketingAgreements()}.
     *
     * @return the {@code brandMessage.marketingAgreements} resource
     */
    public BrandMessageMarketingAgreementsService marketingAgreements() {
        return marketingAgreements;
    }

    /**
     * 브랜드메시지 동보 발송·템플릿·친구 그룹 관리: {@code client.brandMessage().unsubscribeContents()}.
     *
     * @return the {@code brandMessage.unsubscribeContents} resource
     */
    public BrandMessageUnsubscribeContentsService unsubscribeContents() {
        return unsubscribeContents;
    }

    @Override
    public String toString() {
        return "BrandMessageService";
    }
}
