package main.java.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import main.java.mbase.model.Birthday;

public interface IBirthdayRepository extends CrudRepository<Birthday, Long> {
	List<Birthday> findByName(String name);
	List<Birthday> findAll();
}
