// Generated from spec/openapi.yaml by buildSrc/.../ResourceGenerator.java. Do not edit.
// Regenerate with: ./gradlew generateModels
package io.github.icommapi.bizgo;

/**
 * 카카오 상담톡: {@code client.counsel()}.
 *
 * <p>Generated from the spec ({@code x-sdk-resource: counsel}).
 */
public final class CounselService {

    private final Transport transport;
    private final CounselMessagesService messages;
    private final CounselSessionsService sessions;
    private final CounselUsersService users;
    private final CounselCertsService certs;
    private final CounselFilesService files;
    private final CounselChannelsService channels;
    private final CounselConsultTimeService consultTime;
    private final CounselSystemMessagesService systemMessages;

    CounselService(Transport transport) {
        this.transport = transport;
        this.messages = new CounselMessagesService(transport);
        this.sessions = new CounselSessionsService(transport);
        this.users = new CounselUsersService(transport);
        this.certs = new CounselCertsService(transport);
        this.files = new CounselFilesService(transport);
        this.channels = new CounselChannelsService(transport);
        this.consultTime = new CounselConsultTimeService(transport);
        this.systemMessages = new CounselSystemMessagesService(transport);
    }

    /**
     * 카카오 상담톡: {@code client.counsel().messages()}.
     *
     * @return the {@code counsel.messages} resource
     */
    public CounselMessagesService messages() {
        return messages;
    }

    /**
     * 카카오 상담톡: {@code client.counsel().sessions()}.
     *
     * @return the {@code counsel.sessions} resource
     */
    public CounselSessionsService sessions() {
        return sessions;
    }

    /**
     * 카카오 상담톡: {@code client.counsel().users()}.
     *
     * @return the {@code counsel.users} resource
     */
    public CounselUsersService users() {
        return users;
    }

    /**
     * 카카오 상담톡: {@code client.counsel().certs()}.
     *
     * @return the {@code counsel.certs} resource
     */
    public CounselCertsService certs() {
        return certs;
    }

    /**
     * 카카오 상담톡: {@code client.counsel().files()}.
     *
     * @return the {@code counsel.files} resource
     */
    public CounselFilesService files() {
        return files;
    }

    /**
     * 카카오 상담톡: {@code client.counsel().channels()}.
     *
     * @return the {@code counsel.channels} resource
     */
    public CounselChannelsService channels() {
        return channels;
    }

    /**
     * 카카오 상담톡: {@code client.counsel().consultTime()}.
     *
     * @return the {@code counsel.consultTime} resource
     */
    public CounselConsultTimeService consultTime() {
        return consultTime;
    }

    /**
     * 카카오 상담톡: {@code client.counsel().systemMessages()}.
     *
     * @return the {@code counsel.systemMessages} resource
     */
    public CounselSystemMessagesService systemMessages() {
        return systemMessages;
    }

    @Override
    public String toString() {
        return "CounselService";
    }
}
