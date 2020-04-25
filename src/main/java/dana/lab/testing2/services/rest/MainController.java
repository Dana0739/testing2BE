package dana.lab.testing2.services.rest;

import dana.lab.testing2.model.ScrappedPage;
import dana.lab.testing2.model.WebScrapperState;
import dana.lab.testing2.services.WebScrappingService;
import dana.lab.testing2.services.rest.pojo.ShowPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ShowPojo scrapIntoView(@RequestParam(name = "documentPartType") String documentPartType,
                                        @RequestParam(name = "url") String url) {
        WebScrapperState state = new WebScrapperState(documentPartType, url);
        return new ShowPojo(scrapper.scrap(state).getContent(), url);
    }

    @GetMapping("/download")
    public ScrappedPage scrapIntoFile(@RequestParam(name = "documentPartType") String documentPartType,
                                      @RequestParam(name = "outputFileType") String outputFileType,
                                      @RequestParam(name = "filename") String filename,
                                      @RequestParam(name = "url") String url) {
        WebScrapperState state = new WebScrapperState(documentPartType, outputFileType, filename, url);
        return scrapper.scrap(state); // todo make file
    }
}
