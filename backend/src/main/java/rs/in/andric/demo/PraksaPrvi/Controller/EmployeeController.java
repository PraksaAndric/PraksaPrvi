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

    @PostMapping(value = "/add")
    public void addEmpl(@RequestBody Employee employee){
        employeeService.addEmpl(employee);
    }
}
