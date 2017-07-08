package main.java.mbase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.mbase.model.Datapoint;

@EntityScan("main.java.mbase")
@CrossOrigin(origins = "*")
@RestController
public class DatapointRestServiceController {
	
	@Autowired
	private IDatapointRepository repo;
	
    // CREATE
    @RequestMapping("/myblogger/datapoint/create")
    @ResponseBody
    public String createDatapoint(String _data, String _area, String _link) {
    	Datapoint datapoint = new Datapoint(_data, _area, _link);
        try {
            repo.save(datapoint);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "creation successful: " + String.valueOf(datapoint.getId());
    }
     
    // READ
    @RequestMapping("/myblogger/datapoint/read")
    @ResponseBody
    public Datapoint readDatapoint(long id) {
    	Datapoint datapoint = null;
        try {
        	datapoint = repo.findOne(id);
        } catch (Exception e) {
        }
        return datapoint;
    }

    // UPDATE
    @RequestMapping("/myblogger/datapoint/update")
    @ResponseBody
    public String updateDatapoint(long id, String _data, String _area, String _link) {
    	Datapoint datapoint = null;
        try {
        	datapoint = repo.findOne(id);
        	datapoint.setData(_data);
        	datapoint.setArea(_area);
        	datapoint.setLink(_link);
            repo.save(datapoint);
        } catch (Exception e) {
            return e.getMessage();
        }
        return datapoint.toString();
    }
 
    // DELETE
    @RequestMapping("/myblogger/datapoint/delete")
    @ResponseBody
    public String deleteDatapoint(long id) {
        try {
            repo.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "deletion successful";
    }
 
    @RequestMapping("/myblogger/datapoint/readAll")
    public List<Datapoint> readAll() {
        List<Datapoint> __datapoint = repo.findAll();
        return __datapoint;
    }
}