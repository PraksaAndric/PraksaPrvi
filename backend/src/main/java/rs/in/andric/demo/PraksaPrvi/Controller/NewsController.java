package rs.in.andric.demo.PraksaPrvi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.in.andric.demo.PraksaPrvi.model.News;
import rs.in.andric.demo.PraksaPrvi.service.impl.NewsServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsServiceImpl newsService;

    @GetMapping("/all")
    public List<News> scrapNews() {
        return newsService.getAll();
    }

    @GetMapping("/name/{id}")
    public News getNews(@PathVariable Integer id) {
        return newsService.getNewsById(id);
    }

    @GetMapping("/nekilink")
    public News myNews() {
        // String link = "https://edition.cnn.com/2020/04/02/economy/unemployment-benefits-coronavirus/index.html";
        //  String link = "https://edition.cnn.com/2020/03/31/politics/donald-trump-coronavirus-politics-2020-election/index.html";
        // String link = "https://edition.cnn.com/2020/04/02/uk/uk-coronavirus-testing-criticism-intl-gbr/index.html";
        //String link = "https://www.cnet.com/features/coronavirus-ventilators-why-one-machine-is-pivotal-in-the-battle-against-covid-19/";
        String link = "https://www.straitstimes.com/world/united-states/hes-a-total-disgrace-trump-defends-firing-us-intel-watchdog-atkinson?cx_testId=20&cx_testVariant=cx_4&cx_artPos=0#cxrecs_s";

        News news = newsService.obrada(link);
        newsService.callVoice(news.getContent());
        return news;

    }
}
