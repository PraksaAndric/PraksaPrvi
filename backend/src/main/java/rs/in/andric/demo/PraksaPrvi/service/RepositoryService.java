package rs.in.andric.demo.PraksaPrvi.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.in.andric.demo.PraksaPrvi.model.Employee;
import rs.in.andric.demo.PraksaPrvi.model.Repository;
import rs.in.andric.demo.PraksaPrvi.repository.RepRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RepositoryService {

    @Autowired
    RepRepository repRepository;



    public List<Repository> getAll(){
        return repRepository.findAll();
    }

    public Repository getRep(Integer id){
        Optional<Repository> rep = repRepository.findById(id);
        if(!rep.isPresent()){
            return new Repository();
        }
        return rep.get();
    }

    public Repository addRep(Repository rep){
        return repRepository.save(rep);
    }

    public Repository updateRep(Integer id, Repository repository){
        repository.setId(id);
        return repRepository.save(repository);
    }

    public void deleteRep(Integer id){
        repRepository.deleteById(id);
    }

    public void scrap(){

            try {
                final Document document;
                document = Jsoup.connect("https://www.codetriage.com/?language=Java").get();

                System.out.printf("Title: %s/n", document.title());


                Elements repositories= document.getElementsByClass("repo-item");

                for(Element repository : repositories){
                    Repository rep = new Repository();
                    rep.setRepositoryTitle(repository.getElementsByClass("repo-item-title").text());
                    rep.setRepositoryIssues(repository.getElementsByClass("repo-item-issues").text());
                    rep.setRepositoryDescription(repository.getElementsByClass("repo-item-description").text());
                    rep.setRepositoryGithubName(repository.getElementsByClass("repo-item-full-name").text());

                    repRepository.save(rep);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }


}
