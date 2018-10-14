package com.naveen.mbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth")
public class Account {
	
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String password;
	  
	public Account(){}
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public long getId() {
        return id;
    }
	
    public void setId(long id) {
        this.id = id;
    }
 
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}