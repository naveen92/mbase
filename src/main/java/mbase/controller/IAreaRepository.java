package main.java.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import main.java.mbase.model.Area;

public interface IAreaRepository extends CrudRepository<Area, Long> {
	List<Area> findByParent(String parent);
	List<Area> findAll();
}
