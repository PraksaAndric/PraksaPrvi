package rs.in.andric.demo.PraksaPrvi.Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.in.andric.demo.PraksaPrvi.model.Repository;
import rs.in.andric.demo.PraksaPrvi.service.RepositoryService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mapi")
public class RepositoryController {

    @Autowired
    private RepositoryService repositoryService;


    @GetMapping("/repositories")
    public List<Repository> scrapRepositories() {
        repositoryService.scrap();
        return repositoryService.getAll();
    }



}
