package rs.in.andric.demo.PraksaPrvi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.in.andric.demo.PraksaPrvi.model.Domain;

import java.util.Optional;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer> {

    public Optional<Domain> findByName(String name);
}
