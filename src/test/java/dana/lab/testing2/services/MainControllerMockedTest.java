package dana.lab.testing2.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerMockedTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getShow_Test() throws Exception {
        String requestBody = "{\n" +
                "\"documentPartType\": \"%s\",\n" +
                "\"url\": \"%s\"\n" +
                "}";
        String documentPartType = "-text";
        String url = "http://www.example.org/";
        mvc.perform(MockMvcRequestBuilders.post("/testing-lab2/show")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.format(requestBody, documentPartType, url)))
                .andExpect(status().isOk());
    }

    @Test
    public void getDownload_Test() throws Exception {
        String requestBody = "{\n" +
                "\"documentPartType\": \"%s\",\n" +
                "\"outputFileType\": \"%s\",\n" +
                "\"filename\": \"%s\",\n" +
                "\"url\": \"%s\"\n" +
                "}";
        String documentPartType = "-text";
        String outputFileType = "-txt";
        String filename = "file.txt";
        String url = "http://www.example.org/";
        mvc.perform(MockMvcRequestBuilders.post("/testing-lab2/download")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.format(requestBody, documentPartType, outputFileType, filename, url)))
                .andExpect(status().isOk());
    }
}
