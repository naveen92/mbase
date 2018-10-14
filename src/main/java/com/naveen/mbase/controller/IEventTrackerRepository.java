package com.naveen.mbase.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.naveen.mbase.entity.EventTracker;

public interface IEventTrackerRepository extends CrudRepository<EventTracker, Long> {

	List<EventTracker> findByEventid(String _eventid);

	List<EventTracker> findByCountGreaterThanEqual(int i);
}
