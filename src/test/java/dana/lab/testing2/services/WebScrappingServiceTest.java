package dana.lab.testing2.services;

import dana.lab.testing2.model.ScrappedPage;
import dana.lab.testing2.model.WebScrapperState;
import dana.lab.testing2.model.enums.DocumentPartTypes;
import dana.lab.testing2.model.enums.OutputFileTypes;
import dana.lab.testing2.model.enums.OutputTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebScrappingServiceTest {

    @Autowired
    private WebScrappingService scrapper;

    @Test
    public void scrapTest_All_Console() {
        assertEquals(scrapper.scrap(new WebScrapperState(DocumentPartTypes.ALL, OutputTypes.CONSOLE, OutputFileTypes.TXT, null, "http://www.example.org/")),
                new ScrappedPage("<!doctype html>\n" +
                        "<html> \n" +
                        " <head> \n" +
                        "  <title>Example Domain</title> \n" +
                        "  <meta charset=\"utf-8\"> \n" +
                        "  <meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\"> \n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \n" +
                        "  <style type=\"text/css\">\n" +
                        "    body {\n" +
                        "        background-color: #f0f0f2;\n" +
                        "        margin: 0;\n" +
                        "        padding: 0;\n" +
                        "        font-family: -apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", \"Open Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;\n" +
                        "        \n" +
                        "    }\n" +
                        "    div {\n" +
                        "        width: 600px;\n" +
                        "        margin: 5em auto;\n" +
                        "        padding: 2em;\n" +
                        "        background-color: #fdfdff;\n" +
                        "        border-radius: 0.5em;\n" +
                        "        box-shadow: 2px 3px 7px 2px rgba(0,0,0,0.02);\n" +
                        "    }\n" +
                        "    a:link, a:visited {\n" +
                        "        color: #38488f;\n" +
                        "        text-decoration: none;\n" +
                        "    }\n" +
                        "    @media (max-width: 700px) {\n" +
                        "        div {\n" +
                        "            margin: 0 auto;\n" +
                        "            width: auto;\n" +
                        "        }\n" +
                        "    }\n" +
                        "    </style> \n" +
                        " </head> \n" +
                        " <body> \n" +
                        "  <div> \n" +
                        "   <h1>Example Domain</h1> \n" +
                        "   <p>This domain is for use in illustrative examples in documents. You may use this domain in literature without prior coordination or asking for permission.</p> \n" +
                        "   <p><a href=\"https://www.iana.org/domains/example\">More information...</a></p> \n" +
                        "  </div>  \n" +
                        " </body>\n" +
                        "</html>", "http:www.example.org.txt"));
    }

    @Test
    public void scrapTest_Head_Console() {
        assertEquals(scrapper.scrap(new WebScrapperState(DocumentPartTypes.HEAD, OutputTypes.CONSOLE, OutputFileTypes.TXT, null, "http://www.example.org/")),
                new ScrappedPage("<title>Example Domain</title> \n" +
                        "<meta charset=\"utf-8\"> \n" +
                        "<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\"> \n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \n" +
                        "<style type=\"text/css\">\n" +
                        "    body {\n" +
                        "        background-color: #f0f0f2;\n" +
                        "        margin: 0;\n" +
                        "        padding: 0;\n" +
                        "        font-family: -apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", \"Open Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;\n" +
                        "        \n" +
                        "    }\n" +
                        "    div {\n" +
                        "        width: 600px;\n" +
                        "        margin: 5em auto;\n" +
                        "        padding: 2em;\n" +
                        "        background-color: #fdfdff;\n" +
                        "        border-radius: 0.5em;\n" +
                        "        box-shadow: 2px 3px 7px 2px rgba(0,0,0,0.02);\n" +
                        "    }\n" +
                        "    a:link, a:visited {\n" +
                        "        color: #38488f;\n" +
                        "        text-decoration: none;\n" +
                        "    }\n" +
                        "    @media (max-width: 700px) {\n" +
                        "        div {\n" +
                        "            margin: 0 auto;\n" +
                        "            width: auto;\n" +
                        "        }\n" +
                        "    }\n" +
                        "    </style>", "http:www.example.org.txt"));
    }

    @Test
    public void scrapTest_Body_Console() {
        assertEquals(scrapper.scrap(new WebScrapperState(DocumentPartTypes.BODY, OutputTypes.CONSOLE, OutputFileTypes.TXT, null, "http://www.example.org/")),
                new ScrappedPage("<div> \n" +
                        " <h1>Example Domain</h1> \n" +
                        " <p>This domain is for use in illustrative examples in documents. You may use this domain in literature without prior coordination or asking for permission.</p> \n" +
                        " <p><a href=\"https://www.iana.org/domains/example\">More information...</a></p> \n" +
                        "</div>", "http:www.example.org.txt"));
    }

    @Test
    public void scrapTest_Text_Console() {
        assertEquals(scrapper.scrap(new WebScrapperState(DocumentPartTypes.TEXT, OutputTypes.CONSOLE, OutputFileTypes.TXT, null, "http://www.example.org/")),
                new ScrappedPage("Example Domain Example Domain This domain is for use in " +
                        "illustrative examples in documents. You may use this domain in literature without prior " +
                        "coordination or asking for permission. More information...", "http:www.example.org.txt"));
    }

    @Test
    public void scrapTest_Text_File() {
        assertEquals(scrapper.scrap(new WebScrapperState(DocumentPartTypes.TEXT, OutputTypes.FILE, OutputFileTypes.TXT, "filename.txt", "http://www.example.org/")),
                new ScrappedPage("Example Domain Example Domain This domain is for use in " +
                        "illustrative examples in documents. You may use this domain in literature without prior " +
                        "coordination or asking for permission. More information...", "filename.txt"));
    }

    @Test
    public void scrapTest_negative_url() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> scrapper.scrap(new WebScrapperState(DocumentPartTypes.TEXT, OutputTypes.FILE, OutputFileTypes.TXT, "filename.txt", "http://www.exampler.org/")));
        assertEquals(exception.getMessage(), "This URL address doesn't exist!");
    }
}
