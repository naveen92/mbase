package com.naveen.mbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.mbase.entity.EventTracker;

@CrossOrigin(origins = "*")
@RestController
public class EventTrackerRestServiceController {
	
	@Autowired
	private IEventTrackerRepository repo;
	
    // CREATE
    @RequestMapping("/evttracker/create")
    @ResponseBody
    public String createEvent(String _eventid) {
    	EventTracker evttracker = new EventTracker(_eventid, 0);
        try {
            repo.save(evttracker);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "creation successful: " + String.valueOf(evttracker.getId());
    }
     
    // READ
    @RequestMapping("/evttracker/read")
    @ResponseBody
    public EventTracker readEventTracker(long id) {
    	EventTracker evttracker = null;
        try {
        	evttracker = repo.findOne(id);
        } catch (Exception e) {
        }
        return evttracker;
    }

    // INCREMENT
    @RequestMapping("/evttracker/inc")
    @ResponseBody
    public String increaseCount(String _eventid) {
    	EventTracker evttracker = null;
    	int count = 0;
        try {
        	evttracker = repo.findByEventid(_eventid).get(0);
        	count = evttracker.getCount() + 1;
        	evttracker.setCount(count);
        	repo.save(evttracker);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "{'message':'success'}";
    }
 
    // DECREMENT
    @RequestMapping("/evttracker/dec")
    @ResponseBody
    public String decreaseCount(String _eventid) {
    	EventTracker evttracker = null;
    	int count = 0;
        try {
        	evttracker = repo.findByEventid(_eventid).get(0);
        	count = evttracker.getCount() - 1;
        	evttracker.setCount(count);
        	repo.save(evttracker);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "{'message':'success'}";
    }
 
    // DELETE
    @RequestMapping("/evttracker/delete")
    @ResponseBody
    public String deleteEvttracker(long id) {
        try {
            repo.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "deletion successful";
    }
    
    // READ.ALL
    @RequestMapping("/evttracker/readAll")
    public List<EventTracker> readAll() {
        List<EventTracker> __evttracker = repo.findByCountGreaterThanEqual(0);
        return __evttracker;
    }
}
