// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

/**
 * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: rcs}).
 */
public final class RcsService {

    private final Transport transport;
    private final RcsBrandsService brands;
    private final RcsChatbotsService chatbots;
    private final RcsCommonFormatsService commonFormats;
    private final RcsTemplateFormsService templateForms;
    private final RcsTemplatesService templates;
    private final RcsTemplateImagesService templateImages;

    RcsService(Transport transport) {
        this.transport = transport;
        this.brands = new RcsBrandsService(transport);
        this.chatbots = new RcsChatbotsService(transport);
        this.commonFormats = new RcsCommonFormatsService(transport);
        this.templateForms = new RcsTemplateFormsService(transport);
        this.templates = new RcsTemplatesService(transport);
        this.templateImages = new RcsTemplateImagesService(transport);
    }

    /**
     * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().brands()}.
     *
     * @return the {@code rcs.brands} resource
     */
    public RcsBrandsService brands() {
        return brands;
    }

    /**
     * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().chatbots()}.
     *
     * @return the {@code rcs.chatbots} resource
     */
    public RcsChatbotsService chatbots() {
        return chatbots;
    }

    /**
     * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().commonFormats()}.
     *
     * @return the {@code rcs.commonFormats} resource
     */
    public RcsCommonFormatsService commonFormats() {
        return commonFormats;
    }

    /**
     * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().templateForms()}.
     *
     * @return the {@code rcs.templateForms} resource
     */
    public RcsTemplateFormsService templateForms() {
        return templateForms;
    }

    /**
     * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().templates()}.
     *
     * @return the {@code rcs.templates} resource
     */
    public RcsTemplatesService templates() {
        return templates;
    }

    /**
     * RCS 브랜드·챗봇·템플릿 관리: {@code client.rcs().templateImages()}.
     *
     * @return the {@code rcs.templateImages} resource
     */
    public RcsTemplateImagesService templateImages() {
        return templateImages;
    }

    @Override
    public String toString() {
        return "RcsService";
    }
}
