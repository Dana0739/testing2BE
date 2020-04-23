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
public class OutputTypesTests {
    @Test
    public void OutputTypes_File_Test() {
        assertEquals(OutputTypes.FILE, OutputTypes.valueOf("FILE"));
    }

    @Test
    public void OutputTypes_Console_Test() {
        assertEquals(OutputTypes.CONSOLE, OutputTypes.valueOf("CONSOLE"));
    }

    @Test
    public void getTitle_File_Test() {
        assertEquals(OutputTypes.FILE.getTitle(), "-f");
    }

    @Test
    public void getTitle_Console_Test() {
        assertEquals(OutputTypes.CONSOLE.getTitle(), "-c");
    }

    @Test
    public void getByTitle_Console_Test() {
        assertEquals(OutputTypes.CONSOLE, OutputTypes.getByTitle("-c"));
    }

    @Test
    public void getByTitle_Console_Null_Test() {
        assertEquals(OutputTypes.CONSOLE, OutputTypes.getByTitle(null));
    }

    @Test
    public void getByTitle_Console_Empty_Test() {
        assertEquals(OutputTypes.CONSOLE, OutputTypes.getByTitle(""));
    }

    @Test
    public void getByTitle_File_Test() {
        assertEquals(OutputTypes.FILE, OutputTypes.getByTitle("-f"));
    }

    @Test
    public void getAllTest() {
        assertEquals(OutputTypes.getAll(), new ArrayList<>(Arrays.asList("-f", "-c")));
    }
}

