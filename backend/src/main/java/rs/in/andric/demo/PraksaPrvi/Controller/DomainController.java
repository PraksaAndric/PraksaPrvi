package rs.in.andric.demo.PraksaPrvi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.in.andric.demo.PraksaPrvi.model.Domain;
import rs.in.andric.demo.PraksaPrvi.service.DomainService;

import java.util.List;

@RestController
@RequestMapping("/domain")
public class DomainController {


    @Autowired
    private DomainService domainService;

    @GetMapping("/all")
    public List<Domain> getAll(){
        return  domainService.getAll();
    }

    @GetMapping("/get/{name}")
    public Domain getDomainByName(@PathVariable String name){
        return domainService.getDomainByName(name);
    }

    @GetMapping("/get1/{id}")
    public Domain getDomainById(@PathVariable Integer id){
        return domainService.getDomainById(id);
    }

    @PostMapping("/add")
    public Domain addDomain(@RequestBody Domain domain){
        return domainService.addDomain(domain);
    }

    @PutMapping("/update/{id}")
    public Domain updateDomain(@PathVariable Integer id, @RequestBody Domain domain){
        return domainService.updateDomain(id, domain);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDomain(@PathVariable Integer id){
        domainService.deleteDomain(id);
    }



}
