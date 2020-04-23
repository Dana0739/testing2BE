package dana.lab.testing2.services.rest;

import dana.lab.testing2.model.ScrappedPage;
import dana.lab.testing2.model.WebScrapperState;
import dana.lab.testing2.services.WebScrappingService;
import dana.lab.testing2.services.rest.pojo.DownloadPojo;
import dana.lab.testing2.services.rest.pojo.ShowPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/testing-lab2")
@RestController
public class MainController {

    private final WebScrappingService scrapper;

    @Autowired
    public MainController(WebScrappingService service) {
        this.scrapper = service;
    }

    @GetMapping("/download")
    public ScrappedPage scrapIntoFile(@RequestBody DownloadPojo pojo) {
        WebScrapperState state = new WebScrapperState(pojo);
        return scrapper.scrap(state);//make file
    }

    @GetMapping("/show")
    public ScrappedPage scrapIntoView(@RequestBody ShowPojo pojo) {
        WebScrapperState state = new WebScrapperState(pojo);
        return scrapper.scrap(state);
    }
}