package dana.lab.testing2.model;

import dana.lab.testing2.model.enums.DocumentPartTypes;
import dana.lab.testing2.model.enums.OutputFileTypes;
import dana.lab.testing2.model.enums.OutputTypes;
import lombok.Data;

import java.util.regex.Pattern;


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
        this.filename = parseFilename(filename, url, this.outputFileType);
        this.url = url;
    }

    public WebScrapperState(String documentPartType, String outputFileType, String filename, String url) {
        this.documentPartType = DocumentPartTypes.getByTitle(documentPartType);
        this.outputType = OutputTypes.getByTitle("-f");
        this.outputFileType = OutputFileTypes.getByTitle(outputFileType);
        this.filename = parseFilename(filename, url, this.outputFileType);
        this.url = url;
    }

    public WebScrapperState(String documentPartType, String url) {
        this.documentPartType = DocumentPartTypes.getByTitle(documentPartType);
        this.outputType = OutputTypes.getByTitle("-c");
        this.outputFileType = OutputFileTypes.getByTitle("");
        this.filename = "";
        this.url = url;
    }

    private static String parseFilename(String filename, String url, OutputFileTypes outputFileType) {
        if (filename == null) {
            filename = url.replace("\\", "").replace("/", "");
        }
        String regex = ".*\\." + outputFileType.getType().replace(".", "") + "$";
        if (Pattern.matches(regex, filename)) {
            return filename;
        } else {
            return filename + outputFileType.getType();
        }
    }
}
