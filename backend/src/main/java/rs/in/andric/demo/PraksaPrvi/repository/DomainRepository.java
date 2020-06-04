package rs.in.andric.demo.PraksaPrvi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import rs.in.andric.demo.PraksaPrvi.model.Domain;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer> {

    public Optional<Domain> findByName(String name);
}
