package rs.in.andric.demo.PraksaPrvi.service;

import rs.in.andric.demo.PraksaPrvi.model.Domain;

import java.util.List;


public interface DomainService {


    List<Domain> getAll();

    Domain getDomainById(Integer id);

    boolean hasDomainWithName(String name);

    Domain getDomainByName(String name);

    Domain addDomain(Domain domain);

    Domain updateDomain(Integer id, Domain domain);

    void deleteDomain(Integer id);

}
