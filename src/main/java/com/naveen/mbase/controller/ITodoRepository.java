package com.naveen.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.naveen.mbase.entity.Todo;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
	List<Todo> findByPriorityLessThan(int priority);
}
