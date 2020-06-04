package rs.in.andric.demo.PraksaPrvi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import rs.in.andric.demo.PraksaPrvi.model.News;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    public Optional<News> findByUrl(String url);


}
