package rs.in.andric.demo.PraksaPrvi.service.impl;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.in.andric.demo.PraksaPrvi.model.Domain;
import rs.in.andric.demo.PraksaPrvi.model.News;
import rs.in.andric.demo.PraksaPrvi.repository.DomainRepository;
import rs.in.andric.demo.PraksaPrvi.repository.NewsRepository;
import rs.in.andric.demo.PraksaPrvi.service.NewsService;

import javax.speech.Central;
import javax.speech.EngineException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private DomainRepository domainRepository;


    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News getNewsById(Integer id) {
        Optional<News> news = newsRepository.findById(id);
        if (!news.isPresent()) {
            return new News();
        }
        return news.get();
    }

    public boolean hasNewsWithUrl(String url) {
        Optional<News> news = newsRepository.findByUrl(url);
        if (!news.isPresent()) {
            return false;
        }

        return true;

    }


    public String getDomainName(String url) {
        if (!url.startsWith("http") && !url.startsWith("https")) {
            url = "http://" + url;
        }
        URL netUrl = null;
        try {
            netUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String host = netUrl.getHost();
        if (host.startsWith("www")) {
            host = host.substring("www".length() + 1);
        }
        return host;
    }


    public News scrap1(String url, Domain domain) {
        final Document document;
        try {

            document = Jsoup.connect(url).get();

            Elements repositories = document.getElementsByClass(domain.getContainer());

            Element repository = repositories.get(0);

            News news = new News();
            news.setUrl(url);
            news.setTitle(repository.getElementsByClass(domain.getTitle()).text());
            news.setDate(repository.getElementsByClass(domain.getDate()).text());
            String content = "";

            if (domain.getContent().length() == 1) {
                content = repository.getElementsByTag(domain.getContent()).text();
            } else {
                content = repository.getElementsByClass(domain.getContent()).text();
            }

            if (content.length() > 15000) {
                String strOut = content.substring(0, 14999);
                news.setContent(strOut);
            } else {
                news.setContent(content);
            }

            news.setDomain(domain);

            return newsRepository.save(news);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public News obrada(String url) {
        boolean hasNews = hasNewsWithUrl(url);
        if (hasNews) {
            Optional<News> news = newsRepository.findByUrl(url);
            return news.get();
        }

        String domainName = getDomainName(url);
        Optional<Domain> domain = domainRepository.findByName(domainName);

        if (!domain.isPresent()) {
            return new News();
        }

        return scrap1(url, domain.get());

    }

    public void callVoice(String content) {
        try {
            System.setProperty("logLevel", "OFF"); // INFO or WARN are also valid
            System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            // FixMe: Get Arctic voices working.
            //System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_slt_arctic.ArcticVoiceDirectory");
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
        } catch (EngineException e) {
            System.out.println("Unable to provide speech synthesis: " + e);
            System.exit(1);
        }

        VoiceManager vm = VoiceManager.getInstance();
        Voice voice = vm.getVoice("kevin16");

        voice.allocate();
        voice.speak(content);
        voice.deallocate();

    }


}
