package com.naveen.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.naveen.mbase.entity.Domain;

public interface IDomainRepository extends CrudRepository<Domain, Long> {
	List<Domain> findByName(String name);
	List<Domain> findAll();
}
