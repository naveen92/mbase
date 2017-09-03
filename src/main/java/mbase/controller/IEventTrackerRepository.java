package main.java.mbase.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import main.java.mbase.model.EventTracker;

public interface IEventTrackerRepository extends CrudRepository<EventTracker, Long> {

	List<EventTracker> findByEventid(String _eventid);

	List<EventTracker> findByCountGreaterThanEqual(int i);
}
