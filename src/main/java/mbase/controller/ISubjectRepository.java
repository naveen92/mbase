package main.java.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import main.java.mbase.model.Subject;

public interface ISubjectRepository extends CrudRepository<Subject, Long> {
	List<Subject> findByArea(String area);
	List<Subject> findAll();
}
