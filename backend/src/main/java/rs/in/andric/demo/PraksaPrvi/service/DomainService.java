package rs.in.andric.demo.PraksaPrvi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.in.andric.demo.PraksaPrvi.model.Domain;
import rs.in.andric.demo.PraksaPrvi.model.News;
import rs.in.andric.demo.PraksaPrvi.repository.DomainRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DomainService {

    @Autowired
    private DomainRepository domainRepository;

    public List<Domain> getAll(){
        return domainRepository.findAll();
    }

    public Domain getDomainById(Integer id){
        Optional<Domain> domain = domainRepository.findById(id);
        if(!domain.isPresent()){
            return new Domain();
        }
        return domain.get();
    }

    public boolean hasDomainWithName(String name){
        Optional<Domain> domain = domainRepository.findByName(name);
        if(!domain.isPresent()){
            return false;
        }
        return true;
    }

    public Domain getDomainByName(String name){
        Optional<Domain> domain = domainRepository.findByName(name);
        if(!domain.isPresent()){
            return new Domain();
        }
        return domain.get();
    }

    public Domain addDomain(Domain domain){
        return domainRepository.save(domain);
    }

    public Domain updateDomain(Integer id, Domain domain){
        domain.setId(id);
        return domainRepository.save(domain);
    }

    public void deleteDomain(Integer id){
        domainRepository.deleteById(id);
    }

}
