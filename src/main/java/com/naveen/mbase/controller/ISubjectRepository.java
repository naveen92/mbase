package com.naveen.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.naveen.mbase.entity.Subject;

public interface ISubjectRepository extends CrudRepository<Subject, Long> {
	List<Subject> findByArea(String area);
	List<Subject> findAll();
}
