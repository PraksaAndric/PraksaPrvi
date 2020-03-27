package rs.in.andric.demo.PraksaPrvi.service;

import rs.in.andric.demo.PraksaPrvi.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.in.andric.demo.PraksaPrvi.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee getEmpl(Integer id){
        Optional<Employee> empl = employeeRepository.findById(id);
        if(!empl.isPresent()){
            return new Employee();
        }
        return empl.get();
    }

    public Employee addEmpl(Employee e){
        return employeeRepository.save(e);
    }

    public Employee updateEmpl(Integer id, Employee employee){
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmpl(Integer id){
        employeeRepository.deleteById(id);
    }



}
