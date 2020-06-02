package rs.in.andric.demo.PraksaPrvi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import rs.in.andric.demo.PraksaPrvi.model.News;
import rs.in.andric.demo.PraksaPrvi.service.impl.NewsServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin("http://localhost:4200")
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

//    @GetMapping("/audio/{id}")
//    public void getAudio(@PathVariable Integer id){
//        News news = newsService.getNewsById(id);
//        newsService.callVoice(news.getContent());
//    }

    @GetMapping("/details")
    public News myNews(@RequestParam String url) {
        // String link = "https://edition.cnn.com/2020/04/02/economy/unemployment-benefits-coronavirus/index.html";
        //  String link = "https://edition.cnn.com/2020/03/31/politics/donald-trump-coronavirus-politics-2020-election/index.html";
        // String link = "https://edition.cnn.com/2020/04/02/uk/uk-coronavirus-testing-criticism-intl-gbr/index.html";
        //String link = "https://www.cnet.com/features/coronavirus-ventilators-why-one-machine-is-pivotal-in-the-battle-against-covid-19/";
        //String link = "https://www.straitstimes.com/world/united-states/hes-a-total-disgrace-trump-defends-firing-us-intel-watchdog-atkinson?cx_testId=20&cx_testVariant=cx_4&cx_artPos=0#cxrecs_s";
        //String link = "https://www.foxnews.com/media/karen-whitsett-trump-hydroxychloroquine-saved-my-life";

        News news = newsService.obrada(url);
        //newsService.callVoice(news.getContent());
        return news;

    }
}
