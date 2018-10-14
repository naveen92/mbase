package com.naveen.mbase.controller;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.naveen.mbase.entity.Datapoint;

public interface IDatapointRepository extends CrudRepository<Datapoint, Long> {
	List<Datapoint> findByArea(String area);
	List<Datapoint> findAll();
}
