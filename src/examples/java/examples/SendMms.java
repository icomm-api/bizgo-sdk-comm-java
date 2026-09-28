package examples;

import io.github.icommapi.bizgo.Bizgo;
import io.github.icommapi.bizgo.Environment;
import io.github.icommapi.bizgo.FileUpload;
import io.github.icommapi.bizgo.models.FileUploadResult;
import io.github.icommapi.bizgo.models.SendResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Uploads an image, then sends an MMS with it. */
public final class SendMms {

    private SendMms() {
    }

    public static SendResult run(Bizgo client, String from, String to, byte[] image) {
        FileUploadResult uploaded = client.files().uploadMms(FileUpload.of(image, "banner.jpg")); // jpg, max 300KB
        if (uploaded.getFileKey() == null) {
            throw new IllegalStateException("업로드 응답에 fileKey가 없습니다");
        }
        SendResult result = client.send().mms(to, from, "첨부 이미지를 확인해 주세요.", List.of(uploaded.getFileKey()),
                "이벤트 안내", null);
        System.out.println("접수: " + result.getMsgKeys() + " 파일 키 만료: " + uploaded.getExpired());
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (Bizgo client = Bizgo.builder().environment(Environment.SANDBOX).build()) {
            run(client, Env.get("BIZGO_FROM"), Env.get("BIZGO_TO"), Files.readAllBytes(Path.of(Env.get("BIZGO_IMAGE"))));
        }
    }
}
