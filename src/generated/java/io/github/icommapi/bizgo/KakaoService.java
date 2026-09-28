// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

/**
 * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: kakao}).
 */
public final class KakaoService {

    private final Transport transport;
    private final KakaoSendersService senders;
    private final KakaoCategoriesService categories;
    private final KakaoGroupsService groups;
    private final KakaoSanctionsService sanctions;

    KakaoService(Transport transport) {
        this.transport = transport;
        this.senders = new KakaoSendersService(transport);
        this.categories = new KakaoCategoriesService(transport);
        this.groups = new KakaoGroupsService(transport);
        this.sanctions = new KakaoSanctionsService(transport);
    }

    /**
     * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao().senders()}.
     *
     * @return the {@code kakao.senders} resource
     */
    public KakaoSendersService senders() {
        return senders;
    }

    /**
     * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao().categories()}.
     *
     * @return the {@code kakao.categories} resource
     */
    public KakaoCategoriesService categories() {
        return categories;
    }

    /**
     * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao().groups()}.
     *
     * @return the {@code kakao.groups} resource
     */
    public KakaoGroupsService groups() {
        return groups;
    }

    /**
     * 카카오 발신프로필·카테고리·그룹·제재 관리: {@code client.kakao().sanctions()}.
     *
     * @return the {@code kakao.sanctions} resource
     */
    public KakaoSanctionsService sanctions() {
        return sanctions;
    }

    @Override
    public String toString() {
        return "KakaoService";
    }
}
