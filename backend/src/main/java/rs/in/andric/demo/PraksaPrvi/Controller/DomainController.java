package rs.in.andric.demo.PraksaPrvi.Controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static Logger logger = LogManager.getLogger();

    @RequestMapping("/accessdenied")
    public String accessdenied() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("User '" + auth.getName() + "' attempted to access the protected URL: ");
        logger.info("auth : " + auth.isAuthenticated());
        logger.info("Role : " + auth.getAuthorities().toString());
        return auth.getAuthorities().toString();
    }


    @GetMapping
    public List<Domain> getAll() {
        return domainService.getAll();
    }


    @GetMapping("/name/{name}")
    public Domain getDomainByName(@PathVariable String name) {
        return domainService.getDomainByName(name);
    }


    @GetMapping("/id/{id}")
    public Domain getDomainById(@PathVariable Integer id) {
        return domainService.getDomainById(id);
    }


    @PostMapping("/add")
    public Domain addDomain(@RequestBody Domain domain) {
        logger.info("Added domain with name: "+domain.getName());
        return domainService.addDomain(domain);
    }


    @PutMapping("/{id}")
    public Domain updateDomain(@PathVariable Integer id, @RequestBody Domain domain) {
        logger.info("Updated domain with name: "+domain.getName());
        return domainService.updateDomain(id, domain);
    }


    @DeleteMapping("/{id}")
    public void deleteDomain(@PathVariable Integer id)  {
        logger.info("Deleted domain with id: "+id);
        domainService.deleteDomain(id);
    }


}
