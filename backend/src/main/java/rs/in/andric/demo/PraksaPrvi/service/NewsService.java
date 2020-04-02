package rs.in.andric.demo.PraksaPrvi.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.in.andric.demo.PraksaPrvi.model.Domain;
import rs.in.andric.demo.PraksaPrvi.model.Employee;
import rs.in.andric.demo.PraksaPrvi.model.News;
import rs.in.andric.demo.PraksaPrvi.model.Repository;
import rs.in.andric.demo.PraksaPrvi.repository.DomainRepository;
import rs.in.andric.demo.PraksaPrvi.repository.NewsRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private DomainRepository domainRepository;


    public List<News> getAll(){
        return newsRepository.findAll();
    }

    public News getNewsById(Integer id){
        Optional<News> news = newsRepository.findById(id);
        if(!news.isPresent()){
            return new News();
        }
        return news.get();
    }

    public boolean hasNewsWithUrl(String url){
        Optional<News> news = newsRepository.findByUrl(url);
        if(!news.isPresent()){
            return false;
        }

        return true;

    }


    public String getDomainName(String url){
        if(!url.startsWith("http") && !url.startsWith("https")){
            url = "http://" + url;
        }
        URL netUrl = null;
        try {
            netUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String host = netUrl.getHost();
        if(host.startsWith("www")){
            host = host.substring("www".length()+1);
        }
        return host;
    }



    public News scrap1(String url, Domain domain){
        final Document document;
        try {

            document = Jsoup.connect(url).get();

            Elements repositories= document.getElementsByClass("l-container");

            Element repository =  repositories.get(0);

            News news = new News();
            news.setUrl(url);
            news.setTitle(repository.getElementsByClass(domain.getParam_title()).text());
            news.setDate(repository.getElementsByClass(domain.getParam_date()).text());
            String content = repository.getElementsByClass(domain.getParam_content()).text();
            news.setContent(content);
            news.setDomain(domain);

            return newsRepository.save(news);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public News obrada(String url){
        boolean hasNews= hasNewsWithUrl(url);
        if(hasNews){
            Optional<News> news = newsRepository.findByUrl(url);
            return news.get();
        }

        String domainName = getDomainName(url);
        Optional<Domain> domain = domainRepository.findByName(domainName);

        if(!domain.isPresent()) {
            return new News();
        }

        return  scrap1(url,domain.get());

    }


}
