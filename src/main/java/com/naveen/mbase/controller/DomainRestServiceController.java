package com.naveen.mbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.mbase.entity.Domain;

@CrossOrigin(origins = "*")
@RestController
public class DomainRestServiceController {
	
	@Autowired
	private IDomainRepository repo;
	
    // CREATE
    @RequestMapping("/myblogger/domain/create")
    @ResponseBody
    public String createDomain(String _name, String _subjectid) {
    	Domain domain = new Domain(_name, _subjectid);
        try {
            repo.save(domain);
        } catch (Exception e) {
            return e.getMessage();
        }
        return String.valueOf(domain.getId());
    }
     
    // READ
    @RequestMapping("/myblogger/domain/read")
    @ResponseBody
    public Domain readDomain(long id) {
    	Domain domain = null;
        try {
        	domain = repo.findOne(id);
        } catch (Exception e) {
        }
        return domain;
    }

    // UPDATE
    @RequestMapping("/myblogger/domain/update")
    @ResponseBody
    public String updateDomain(long id, String _name, String _subjectid) {
    	Domain domain = null;
        try {
            domain = repo.findOne(id);
            domain.setName(_name);
            domain.setSubjectID(_subjectid);
            repo.save(domain);
        } catch (Exception e) {
            return e.getMessage();
        }
        return domain.getName() + " : " + domain.getSubjectID();
    }
 
    // DELETE
    @RequestMapping("/myblogger/domain/delete")
    @ResponseBody
    public String deleteDomain(long id) {
        try {
            repo.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "deletion successful";
    }
 
    @RequestMapping("/myblogger/domain/readAll")
    public List<Domain> readAll() {
        List<Domain> __domain = repo.findAll();
        return __domain;
    }
}
