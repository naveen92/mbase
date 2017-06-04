package main.java.mbase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.mbase.model.Birthday;

@EntityScan("main.java.mbase")
@CrossOrigin(origins = "*")
@RestController
public class BirthdayRestServiceController {
	@Autowired
	private IBirthdayRepository repo;
    // CREATE
    @RequestMapping("/birthday/create")
    @ResponseBody
    public String createBirthday(String _name, String _date) {
    	Birthday birthday = new Birthday(_name, _date);
        try {
            repo.save(birthday);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "creation successful: " + String.valueOf(birthday.getId());
    }
     
    // READ
    @RequestMapping("/birthday/read")
    @ResponseBody
    public Birthday readBirthday(long id) {
    	Birthday birthday = null;
        try {
        	birthday = repo.findOne(id);
        } catch (Exception e) {
        }
        return birthday;
    }

    // UPDATE
    @RequestMapping("/birthday/update")
    @ResponseBody
    public String updateTodo(long id, String _name, String _date) {
    	Birthday birthday;
        try {
            birthday = repo.findOne(id);
            birthday.setName(_name);
            birthday.setDate(_date);
            repo.save(birthday);
        } catch (Exception e) {
            return e.getMessage();
        }
        return birthday.getName() + " : " + birthday.getDate();
    }
 
    // DELETE
    @RequestMapping("/birthday/delete")
    @ResponseBody
    public String deleteTodo(long id) {
        try {
            repo.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "deletion successful";
    }
 
    @RequestMapping("/birthday/readRecent")
    public List<Birthday> readRecent() {
        List<Birthday> __birthday = repo.findAll();
        return __birthday;
    }
}
