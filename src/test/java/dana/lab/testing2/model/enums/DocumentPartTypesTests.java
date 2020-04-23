package dana.lab.testing2.model.enums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentPartTypesTests {
    @Test
    public void documentPartTypes_All_Test() {
        assertEquals(DocumentPartTypes.ALL, DocumentPartTypes.valueOf("ALL"));
    }

    @Test
    public void documentPartTypes_Head_Test() {
        assertEquals(DocumentPartTypes.HEAD, DocumentPartTypes.valueOf("HEAD"));
    }

    @Test
    public void documentPartTypes_Body_Test() {
        assertEquals(DocumentPartTypes.BODY, DocumentPartTypes.valueOf("BODY"));
    }

    @Test
    public void documentPartTypes_Text_Test() {
        assertEquals(DocumentPartTypes.TEXT, DocumentPartTypes.valueOf("TEXT"));
    }

    @Test
    public void getTitle_All_Test() {
        assertEquals(DocumentPartTypes.ALL.getTitle(), "-all");
    }

    @Test
    public void getTitle_Head_Test() {
        assertEquals(DocumentPartTypes.HEAD.getTitle(), "-head");
    }

    @Test
    public void getTitle_Body_Test() {
        assertEquals(DocumentPartTypes.BODY.getTitle(), "-body");
    }

    @Test
    public void getTitle_Text_Test() {
        assertEquals(DocumentPartTypes.TEXT.getTitle(), "-text");
    }

    @Test
    public void getByTitle_All_Test() {
        assertEquals(DocumentPartTypes.ALL, DocumentPartTypes.getByTitle("-all"));
    }

    @Test
    public void getByTitle_All_Null_Test() {
        assertEquals(DocumentPartTypes.ALL, DocumentPartTypes.getByTitle(null));
    }

    @Test
    public void getByTitle_All_Empty_Test() {
        assertEquals(DocumentPartTypes.ALL, DocumentPartTypes.getByTitle(""));
    }

    @Test
    public void getByTitle_Head_Test() {
        assertEquals(DocumentPartTypes.HEAD, DocumentPartTypes.getByTitle("-head"));
    }

    @Test
    public void getByTitle_Body_Test() {
        assertEquals(DocumentPartTypes.BODY, DocumentPartTypes.getByTitle("-body"));
    }

    @Test
    public void getByTitle_Text_Test() {
        assertEquals(DocumentPartTypes.TEXT, DocumentPartTypes.getByTitle("-text"));
    }

    @Test
    public void getAllTest() {
        assertEquals(DocumentPartTypes.getAll(), new ArrayList<>(Arrays.asList("-all", "-head", "-body", "-text")));
    }
}
