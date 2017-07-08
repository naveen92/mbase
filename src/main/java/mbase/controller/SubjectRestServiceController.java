package main.java.mbase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.mbase.model.Subject;

@EntityScan("main.java.mbase")
@CrossOrigin(origins = "*")
@RestController
public class SubjectRestServiceController {
	
	@Autowired
	private ISubjectRepository repo;
	
    // CREATE
    @RequestMapping("/myblogger/subject/create")
    @ResponseBody
    public String createSubject(String _content, String _area, String _datapoint) {
    	Subject subject = new Subject(_content, _area, _datapoint);
        try {
            repo.save(subject);
        } catch (Exception e) {
            return e.getMessage();
        }
        return String.valueOf(subject.getId());
    }
     
    // READ
    @RequestMapping("/myblogger/subject/read")
    @ResponseBody
    public Subject readSubject(long id) {
    	Subject subject = null;
        try {
        	subject = repo.findOne(id);
        } catch (Exception e) {
        }
        return subject;
    }

    // UPDATE
    @RequestMapping("/myblogger/subject/update")
    @ResponseBody
    public String updateSubject(long id, String _content, String _area, String _datapoint) {
    	Subject subject = null;
        try {
        	subject = repo.findOne(id);
        	subject.setContent(_content);
        	subject.setArea(_area);
        	subject.setDatapoint(_datapoint);
            repo.save(subject);
        } catch (Exception e) {
            return e.getMessage();
        }
        return subject.toString();
    }
 
    // UPDATE content
    @RequestMapping("/myblogger/subject/updateContent")
    @ResponseBody
    public String updateSubjectContent(long id, String _content) {
    	Subject subject = null;
        try {
        	subject = repo.findOne(id);
        	subject.setContent(_content);
            repo.save(subject);
        } catch (Exception e) {
            return e.getMessage();
        }
        return subject.toString();
    }
 
    // UPDATE area
    @RequestMapping("/myblogger/subject/updateArea")
    @ResponseBody
    public String updateSubjectArea(long id, String _area) {
    	Subject subject = null;
        try {
        	subject = repo.findOne(id);
        	subject.setArea(_area);
            repo.save(subject);
        } catch (Exception e) {
            return e.getMessage();
        }
        return subject.toString();
    }
 
    // UPDATE datapoint
    @RequestMapping("/myblogger/subject/updateDatapoint")
    @ResponseBody
    public String updateSubjectDatapoint(long id, String _datapoint) {
    	Subject subject = null;
        try {
        	subject = repo.findOne(id);
        	subject.setDatapoint(_datapoint);
            repo.save(subject);
        } catch (Exception e) {
            return e.getMessage();
        }
        return subject.toString();
    }
 
    // DELETE
    @RequestMapping("/myblogger/subject/delete")
    @ResponseBody
    public String deleteSubject(long id) {
        try {
            repo.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "deletion successful";
    }
 
    @RequestMapping("/myblogger/subject/readAll")
    public List<Subject> readAll() {
        List<Subject> __subject = repo.findAll();
        return __subject;
    }
}
