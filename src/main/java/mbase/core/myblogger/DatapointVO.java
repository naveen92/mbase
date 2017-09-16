package main.java.mbase.core.myblogger;

import main.java.mbase.model.Area;
import main.java.mbase.model.Datapoint;

public class DatapointVO {

	Datapoint dp;
	Area area;
	
	public DatapointVO(Datapoint dp, Area area) {
		this.dp = dp;
		this.area = area;
	}

	public Datapoint getDp() {
		return dp;
	}

	public void setDp(Datapoint dp) {
		this.dp = dp;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}
