package rs.in.andric.demo.PraksaPrvi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import rs.in.andric.demo.PraksaPrvi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
