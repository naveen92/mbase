package main.java.mbase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datapoint")
public class Datapoint {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String data;
    private String area;
    private String link;

    public Datapoint() {
        // nop
    }
    
	public Datapoint(String data, String area, String link) {
		this.data = data;
		this.area = area;
		this.link = link;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
    public String toString() {
        return String.format("Datapoint[id=%d, data='%s', area='%s', link='%s']", id, data, area, link);
    }
}
