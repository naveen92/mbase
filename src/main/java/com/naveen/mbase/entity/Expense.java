package com.naveen.mbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int disporder;
    private String title;
    private int amount;
    private String parent;
    
    public long getId() {
    	return id;
    }

    public int getDisporder() {
		return disporder;
	}

	public void setDisporder(int disporder) {
		this.disporder = disporder;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Expense() {
        // nop
    }
 
    @Override
    public String toString() {
        return String.format("Todo[id=%d, disporder=%d, title='%s', amount=%d, parent='%s']", id, disporder, title, amount, parent);
    }
}
