package main.java.mbase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.mbase.model.Todo;

@EntityScan("main.java.mbase")
@CrossOrigin(origins = "*")
@RestController
public class TodoRestServiceController {
	
	@Autowired
	private ITodoRepository repo;
	
    // CREATE
    @RequestMapping("/todo/create")
    @ResponseBody
    public String createTodo(String _todo, int _priority) {
        Todo todo = new Todo(_todo, _priority);
        try {
            repo.save(todo);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "creation successful: " + String.valueOf(todo.getId());
    }
     
    // READ
    @RequestMapping("/todo/read")
    @ResponseBody
    public Todo readTodo(long id) {
    	Todo todo = null;
        try {
        	todo = repo.findOne(id);
        } catch (Exception e) {
        }
        return todo;
    }

    // UPDATE
    @RequestMapping("/todo/update")
    @ResponseBody
    public String updateTodo(long id, String _todo, int _priority) {
    	Todo todo;
        try {
            todo = repo.findOne(id);
            todo.setTodo(_todo);
            todo.setPriority(_priority);
            repo.save(todo);
        } catch (Exception e) {
            return e.getMessage();
        }
        return todo.getTodo() + " : " + todo.getPriority();
    }
 
    // DELETE
    @RequestMapping("/todo/delete")
    @ResponseBody
    public String deleteTodo(long id) {
        try {
            repo.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "deletion successful";
    }
 
    @RequestMapping("/todo/readRecent")
    public List<Todo> readRecent() {
        List<Todo> __todo = repo.findByPriorityLessThan(2);
        return __todo;
    }
}
