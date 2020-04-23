package dana.lab.testing2.model;

import dana.lab.testing2.model.enums.DocumentPartTypes;
import dana.lab.testing2.model.enums.OutputFileTypes;
import dana.lab.testing2.model.enums.OutputTypes;
import dana.lab.testing2.services.rest.pojo.DownloadPojo;
import dana.lab.testing2.services.rest.pojo.ShowPojo;
import lombok.Data;


@Data
public class WebScrapperState {

    private final DocumentPartTypes documentPartType;

    private final OutputTypes outputType;

    private final OutputFileTypes outputFileType;

    private final String filename;

    private final String url;

    public WebScrapperState(DocumentPartTypes documentPartType, OutputTypes outputType, OutputFileTypes outputFileType, String filename, String url) {
        this.documentPartType = documentPartType;
        this.outputType = outputType;
        this.outputFileType = outputFileType;
        this.filename = filename;
        this.url = url;
    }

    public WebScrapperState(DownloadPojo pojo) {
        this.documentPartType = DocumentPartTypes.getByTitle(pojo.getDocumentPartType());
        this.outputType = OutputTypes.getByTitle("-f");
        this.outputFileType = OutputFileTypes.getByTitle(pojo.getOutputFileType());
        this.filename = pojo.getFilename();
        this.url = pojo.getUrl();
    }

    public WebScrapperState(ShowPojo pojo) {
        this.documentPartType = DocumentPartTypes.getByTitle(pojo.getDocumentPartType());
        this.outputType = OutputTypes.getByTitle("-c");
        this.outputFileType = OutputFileTypes.getByTitle("");
        this.filename = "";
        this.url = pojo.getUrl();
    }
}
