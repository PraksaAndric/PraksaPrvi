package rs.in.andric.demo.PraksaPrvi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepRepository extends JpaRepository<rs.in.andric.demo.PraksaPrvi.model.Repository, Integer> {
}
