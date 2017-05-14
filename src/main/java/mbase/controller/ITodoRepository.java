package main.java.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import main.java.mbase.model.Todo;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
	List<Todo> findByPriorityLessThan(int priority);
}
