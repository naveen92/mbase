package com.naveen.mbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    private String area;
    private String datapoint;

    public Subject() {
        // nop
    }
    
	public Subject(String content, String area, String datapoint) {
		this.content = content;
		this.area = area;
		this.datapoint = datapoint;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDatapoint() {
		return datapoint;
	}

	public void setDatapoint(String datapoint) {
		this.datapoint = datapoint;
	}

	@Override
    public String toString() {
        return String.format("Subject[id=%d, content='%s', area='%s', datapoint='%s']", id, content, area, datapoint);
    }
}
