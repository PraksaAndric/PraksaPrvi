package rs.in.andric.demo.PraksaPrvi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import rs.in.andric.demo.PraksaPrvi.model.Domain;
import rs.in.andric.demo.PraksaPrvi.service.DomainService;

import java.util.List;

@RestController
@RequestMapping("/domains")
@CrossOrigin("http://localhost:4200")
public class DomainController {


    @Autowired
    private DomainService domainService;

    @RequestMapping("/accessdenied")
    public String accessdenied(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User '" + auth.getName() + "' attempted to access the protected URL: ");
        System.out.println("auth : "+auth.isAuthenticated());
        System.out.println("Role : "+auth.getAuthorities().toString());
        return auth.getAuthorities().toString();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<Domain> getAll() {
        return domainService.getAll();
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/name/{name}")
    public Domain getDomainByName(@PathVariable String name) {

        return domainService.getDomainByName(name);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/id/{id}")
    public Domain getDomainById(@PathVariable Integer id) {
        return domainService.getDomainById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/add")
    public Domain addDomain(@RequestBody Domain domain) {
        return domainService.addDomain(domain);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public Domain updateDomain(@PathVariable Integer id, @RequestBody Domain domain) {
        return domainService.updateDomain(id, domain);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteDomain(@PathVariable Integer id) {
        domainService.deleteDomain(id);
    }


}
