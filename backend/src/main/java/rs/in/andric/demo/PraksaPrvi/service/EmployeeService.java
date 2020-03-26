package rs.in.andric.demo.PraksaPrvi.service;

import rs.in.andric.demo.PraksaPrvi.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.in.andric.demo.PraksaPrvi.repository.EmployeeRepository;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee getEmpl(Integer id){
        return employeeRepository.getOne(id);
    }

    public void addEmpl(Employee e){
        employeeRepository.save(e);
    }



}
