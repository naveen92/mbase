package main.java.mbase.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.mbase.core.myblogger.DatapointVO;
import main.java.mbase.model.Area;
import main.java.mbase.model.Datapoint;

@EntityScan("main.java.mbase")
@CrossOrigin(origins = "*")
@RestController
public class DatapointRestServiceController {
	
	@Autowired
	private IDatapointRepository repo;
	
	@Autowired
	private IAreaRepository areaRepo;
	
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
        return String.valueOf(datapoint.getId());
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

    // READ_FROM
    @RequestMapping("/myblogger/datapoint/readFrom")
    @ResponseBody
    public List<DatapointVO> readDatapointFrom(long id) {
    	List<DatapointVO> datapointList = new ArrayList<DatapointVO>();
    	Datapoint datapoint = null;
    	Area area = null;
    	boolean exit = false;
    	String link;
        try {
        	while(!exit) {
            	datapoint = repo.findOne(id);
            	area = areaRepo.findOne(Long.parseLong(datapoint.getArea()));
            	datapointList.add(new DatapointVO(datapoint, area));
            	link = datapoint.getLink();
            	if("".equals(link)) {
            		exit = true;
            	} else {
            		id = Long.parseLong(link);
            	}
        	}
        } catch (Exception e) {
        }
        return datapointList;
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
 
    // UPDATE data
    @RequestMapping("/myblogger/datapoint/updateData")
    @ResponseBody
    public String updateDatapointData(long id, String _data) {
    	Datapoint datapoint = null;
        try {
        	datapoint = repo.findOne(id);
        	datapoint.setData(_data);
            repo.save(datapoint);
        } catch (Exception e) {
            return e.getMessage();
        }
        return datapoint.toString();
    }
 
    // UPDATE link
    @RequestMapping("/myblogger/datapoint/updateLink")
    @ResponseBody
    public String updateDatapointLink(long id, String _link) {
    	Datapoint datapoint = null;
        try {
        	datapoint = repo.findOne(id);
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
 
    @RequestMapping("/myblogger/datapoint/findByArea")
    public List<Datapoint> findByArea(String _area) {
        List<Datapoint> __datapoint = repo.findByArea(_area);
        return __datapoint;
    }
}
