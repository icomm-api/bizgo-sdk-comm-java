// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

/**
 * 알림톡 템플릿 관리: {@code client.alimtalk()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: alimtalk}).
 */
public final class AlimtalkService {

    private final Transport transport;
    private final AlimtalkTemplatesService templates;
    private final AlimtalkTemplateCategoriesService templateCategories;
    private final AlimtalkPublicTemplatesService publicTemplates;

    AlimtalkService(Transport transport) {
        this.transport = transport;
        this.templates = new AlimtalkTemplatesService(transport);
        this.templateCategories = new AlimtalkTemplateCategoriesService(transport);
        this.publicTemplates = new AlimtalkPublicTemplatesService(transport);
    }

    /**
     * 알림톡 템플릿 관리: {@code client.alimtalk().templates()}.
     *
     * @return the {@code alimtalk.templates} resource
     */
    public AlimtalkTemplatesService templates() {
        return templates;
    }

    /**
     * 알림톡 템플릿 관리: {@code client.alimtalk().templateCategories()}.
     *
     * @return the {@code alimtalk.templateCategories} resource
     */
    public AlimtalkTemplateCategoriesService templateCategories() {
        return templateCategories;
    }

    /**
     * 알림톡 템플릿 관리: {@code client.alimtalk().publicTemplates()}.
     *
     * @return the {@code alimtalk.publicTemplates} resource
     */
    public AlimtalkPublicTemplatesService publicTemplates() {
        return publicTemplates;
    }

    @Override
    public String toString() {
        return "AlimtalkService";
    }
}
