package main.java.mbase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evttracker")
public class EventTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String eventid;
    private int count;

    public EventTracker() {
        // nop
    }
 
    public EventTracker(String eventid, int count) {
        this.eventid = eventid;
        this.count = count;
    }
    
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
    public String toString() {
        return String.format("EventTracker[id=%d, eventid='%s', count='%d']", id, eventid, count);
    }
}
