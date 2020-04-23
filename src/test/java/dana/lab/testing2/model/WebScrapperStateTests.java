package dana.lab.testing2.model;

import dana.lab.testing2.model.enums.DocumentPartTypes;
import dana.lab.testing2.model.enums.OutputFileTypes;
import dana.lab.testing2.model.enums.OutputTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebScrapperStateTests {

    private static final WebScrapperState webScrapperState = new WebScrapperState(DocumentPartTypes.ALL,
            OutputTypes.FILE, OutputFileTypes.HTML, "myFile.html", "https://myUrl.com");

    @Test
    public void getUrlTest() {
        assertEquals(webScrapperState.getUrl(), "https://myUrl.com");
    }

    @Test
    public void getFilenameTest() {
        assertEquals(webScrapperState.getFilename(), "myFile.html");
    }

    @Test
    public void getDocumentPartTypeTest() {
        assertEquals(webScrapperState.getDocumentPartType(), DocumentPartTypes.ALL);
    }

    @Test
    public void getOutputTypeTest() {
        assertEquals(webScrapperState.getOutputType(), OutputTypes.FILE);
    }

    @Test
    public void getOutputFileTypeTest() {
        assertEquals(webScrapperState.getOutputFileType(), OutputFileTypes.HTML);
    }
}