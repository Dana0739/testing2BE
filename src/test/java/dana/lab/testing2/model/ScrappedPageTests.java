package dana.lab.testing2.model;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScrappedPageTests {
    private static final ScrappedPage scrapedPage = new ScrappedPage("content", "filename.txt");

    private static final ScrappedPage emptyScrapedPage = new ScrappedPage("");

    @Test
    public void getFilenameTest() {
        assertEquals(scrapedPage.getFilename(), "filename.txt");
    }

    @Test
    public void getContentTest() {
        assertEquals(scrapedPage.getContent(), "content");
    }

    @Test
    public void getEmptyFilenameTest() {
        assertNull(emptyScrapedPage.getFilename());
    }

    @Test
    public void getEmptyContentTest() {
        assertEquals(emptyScrapedPage.getContent(), "");
    }
}
