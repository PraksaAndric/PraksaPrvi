package rs.in.andric.demo.PraksaPrvi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.in.andric.demo.PraksaPrvi.model.Employee;
import rs.in.andric.demo.PraksaPrvi.service.EmployeeService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmpl(@PathVariable Integer id){
        return employeeService.getEmpl(id);
    }

    @PostMapping("/add")
    public Employee addEmpl(@RequestBody Employee employee){
        return employeeService.addEmpl(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmpl(@PathVariable Integer id, @RequestBody Employee employee){
        return employeeService.updateEmpl(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmpl(@PathVariable Integer id){
        employeeService.deleteEmpl(id);
    }
}
