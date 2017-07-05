package main.java.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import main.java.mbase.model.Domain;

public interface IDomainRepository extends CrudRepository<Domain, Long> {
	List<Domain> findByName(String name);
	List<Domain> findAll();
}
