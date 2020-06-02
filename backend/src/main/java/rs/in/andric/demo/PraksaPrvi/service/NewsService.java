package rs.in.andric.demo.PraksaPrvi.service;

import rs.in.andric.demo.PraksaPrvi.model.Domain;
import rs.in.andric.demo.PraksaPrvi.model.News;

import java.util.List;

public interface NewsService {

    public List<News> getAll();

    public News getNewsById(Integer id);

    public boolean hasNewsWithUrl(String url);

    public String getDomainName(String url);

    public News scrap1(String url, Domain domain);

    public News obrada(String url);

//    public void callVoice(String content);
}
