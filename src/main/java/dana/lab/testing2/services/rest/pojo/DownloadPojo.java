package dana.lab.testing2.services.rest.pojo;

import lombok.Data;

@Data
public class DownloadPojo {

    private String documentPartType;

    private String outputFileType;

    private String filename;

    private String url;

    public DownloadPojo() {
    }

    public DownloadPojo(String documentPartType, String outputFileType, String filename, String url) {
        this.documentPartType = documentPartType;
        this.outputFileType = outputFileType;
        this.filename = filename;
        this.url = url;
    }
}