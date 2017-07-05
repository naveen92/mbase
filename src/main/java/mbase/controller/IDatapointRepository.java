package main.java.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import main.java.mbase.model.Datapoint;

public interface IDatapointRepository extends CrudRepository<Datapoint, Long> {
	List<Datapoint> findByArea(String area);
	List<Datapoint> findAll();
}
