package main.java.mbase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.mbase.model.Area;

@EntityScan("main.java.mbase")
@CrossOrigin(origins = "*")
@RestController
public class AreaRestServiceController {
	
	@Autowired
	private IAreaRepository repo;
	
    // CREATE
    @RequestMapping("/myblogger/area/create")
    @ResponseBody
    public String createArea(String _name, String _parent, int _count) {
    	Area area = new Area(_name, _parent, _count);
        try {
            repo.save(area);
        } catch (Exception e) {
            return e.getMessage();
        }
        return String.valueOf(area.getId());
    }
     
    // READ
    @RequestMapping("/myblogger/area/read")
    @ResponseBody
    public Area readArea(long id) {
    	Area area = null;
        try {
        	area = repo.findOne(id);
        } catch (Exception e) {
        }
        return area;
    }

    // UPDATE
    @RequestMapping("/myblogger/area/update")
    @ResponseBody
    public String updateArea(long id, String _name, String _parent, int _count) {
    	Area area = null;
        try {
        	area = repo.findOne(id);
        	area.setName(_name);
        	area.setParent(_parent);
        	area.setCount(_count);
            repo.save(area);
        } catch (Exception e) {
            return e.getMessage();
        }
        return area.toString();
    }
 
    // DELETE
    @RequestMapping("/myblogger/area/delete")
    @ResponseBody
    public String deleteArea(long id) {
        try {
            repo.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "deletion successful";
    }
 
    @RequestMapping("/myblogger/datapoint/readByParent")
    public List<Area> readByParent(String parent) {
        List<Area> __area = repo.findByParent(parent);
        return __area;
    }
}
