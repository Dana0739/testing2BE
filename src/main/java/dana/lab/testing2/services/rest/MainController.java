package dana.lab.testing2.services.rest;

import dana.lab.testing2.model.ScrappedPage;
import dana.lab.testing2.model.WebScrapperState;
import dana.lab.testing2.services.WebScrappingService;
import dana.lab.testing2.services.rest.pojo.DownloadPojo;
import dana.lab.testing2.services.rest.pojo.ShowPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //(origins = "http://localhost:4200")
@RequestMapping("/testing-lab2")
@RestController
public class MainController {

    private final WebScrappingService scrapper;

    @Autowired
    public MainController(WebScrappingService service) {
        this.scrapper = service;
    }

    @PostMapping("/download")
    public ScrappedPage scrapIntoFile(@RequestBody DownloadPojo pojo) {
        WebScrapperState state = new WebScrapperState(pojo);
        return scrapper.scrap(state);//make file
    }

    @PostMapping("/show")
    public String scrapIntoView(@RequestBody ShowPojo pojo) {
        WebScrapperState state = new WebScrapperState(pojo);
        return scrapper.scrap(state).getContent();
    }

    @GetMapping("/version")
    public int getVersion() {
        return 3;
    }
}
