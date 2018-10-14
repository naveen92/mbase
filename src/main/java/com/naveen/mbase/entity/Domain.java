package com.naveen.mbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String subjectid;

    public Domain() {
        // nop
    }
 
    public Domain(String name, String subjectid) {
        this.name = name;
        this.subjectid = subjectid;
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

    public String getSubjectID() {
        return subjectid;
    }
 
    public void setSubjectID(String subjectid) {
        this.subjectid = subjectid;
    }
 
    @Override
    public String toString() {
        return String.format("Domain[id=%d, name='%s', subjectId='%s']", id, name, subjectid);
    }
}
