package com.naveen.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.naveen.mbase.entity.Area;

public interface IAreaRepository extends CrudRepository<Area, Long> {
	List<Area> findByParent(String parent);
	List<Area> findAll();
}
