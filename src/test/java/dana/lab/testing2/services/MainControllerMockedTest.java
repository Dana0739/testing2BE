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
        mvc.perform(MockMvcRequestBuilders.get("/testing-lab2/show?documentPartType=-text&url=http://www.example.org/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getDownload_Test() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/testing-lab2/download?documentPartType=-all&outputFileType=-html&filename=&url=http://www.example.org/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
