package com.naveen.mbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String parent;
	private int count;

    public Area() {
        // nop
    }
    
	public Area(String name, String parent, int count) {
		this.name = name;
		this.parent = parent;
		this.count = count;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
    public String toString() {
        return String.format("Area[id=%d, name='%s', parent='%s', count='%d']", id, name, parent, count);
    }
}
