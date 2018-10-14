package com.naveen.mbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "birthday")
public class Birthday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String date;

    public Birthday() {
        // nop
    }
 
    public Birthday(String name, String date) {
        this.name = name;
        this.date = date;
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

    public String getDate() {
        return date;
    }
 
    public void setDate(String date) {
        this.date = date;
    }
 
    @Override
    public String toString() {
        return String.format("Birthday[id=%d, name='%s', date='%s']", id, name, date);
    }
}
