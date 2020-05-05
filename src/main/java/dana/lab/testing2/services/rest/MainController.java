package dana.lab.testing2.services.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import dana.lab.testing2.model.ScrappedPage;
import dana.lab.testing2.model.WebScrapperState;
import dana.lab.testing2.services.WebScrappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@CrossOrigin
@RequestMapping("/testing-lab2")
@RestController
public class MainController {

    private final WebScrappingService scrapper;

    @Autowired
    public MainController(WebScrappingService service) {
        this.scrapper = service;
    }

    @GetMapping("/show")
    public ResponseEntity scrapIntoView(@RequestParam(name = "documentPartType") String documentPartType,
                                        @RequestParam(name = "url") String url) {
        if (!parseUrl(url)) return ResponseEntity.badRequest().build();
        WebScrapperState state = new WebScrapperState(documentPartType, url);
        return ResponseEntity.ok().body(new ShowDTO(scrapper.scrap(state).getContent(), url));
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> scrapIntoFile(@RequestParam(name = "documentPartType") String documentPartType,
                                                @RequestParam(name = "outputFileType") String outputFileType,
                                                @RequestParam(name = "filename") String filename,
                                                @RequestParam(name = "url") String url)  throws Exception {
        if (!parseUrl(url)) return ResponseEntity.badRequest().build();

        WebScrapperState state = new WebScrapperState(documentPartType, outputFileType, filename, url);
        ScrappedPage page = scrapper.scrap(state);

        //todo delete all \n symbols and start and end " symbols

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(page.getContent());
        byte[] isr = json.getBytes();
        String fileName = page.getFilename();

        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentLength(isr.length);
        respHeaders.setContentType(new MediaType("text", "json"));
        respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

        return new ResponseEntity<>(isr, respHeaders, HttpStatus.OK);
    }

    private static boolean parseUrl(String url) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        return Pattern.matches(regex, url);
    }
}
