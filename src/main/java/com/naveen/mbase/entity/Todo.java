package com.naveen.mbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String todo;
    private int priority;

    public Todo() {
        // nop
    }
 
    public Todo(String todo, int priority) {
        this.todo = todo;
        this.priority = priority;
    }
    
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getTodo() {
        return todo;
    }
 
    public void setTodo(String todo) {
        this.todo = todo;
    }

    public int getPriority() {
        return priority;
    }
 
    public void setPriority(int priority) {
        this.priority = priority;
    }
 
    @Override
    public String toString() {
        return String.format("Todo[id=%d, todo='%s', priority='%d']", id, todo, priority);
    }
}
