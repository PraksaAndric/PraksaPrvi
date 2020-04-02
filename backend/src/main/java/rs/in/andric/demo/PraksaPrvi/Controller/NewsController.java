package rs.in.andric.demo.PraksaPrvi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.in.andric.demo.PraksaPrvi.model.News;
import rs.in.andric.demo.PraksaPrvi.service.NewsService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/all")
    public List<News> scrapNews() {
        return newsService.getAll();
    }

    @GetMapping("/nekilink")
    public News myNews(){
//      String link = "https://edition.cnn.com/2020/04/02/economy/unemployment-benefits-coronavirus/index.html";
        String link = "https://edition.cnn.com/2020/03/31/politics/donald-trump-coronavirus-politics-2020-election/index.html";
        return newsService.obrada(link);

    }
}
