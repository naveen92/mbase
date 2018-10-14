package com.naveen.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.naveen.mbase.entity.Birthday;

public interface IBirthdayRepository extends CrudRepository<Birthday, Long> {
	List<Birthday> findByName(String name);
	List<Birthday> findAll();
}
