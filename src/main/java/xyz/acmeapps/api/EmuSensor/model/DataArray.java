package xyz.acmeapps.api.EmuSensor.model;

import java.util.ArrayList;
import java.util.Date;

public class DataArray {
	
	private Date timestamp;
	public ArrayList<Integer> data = new ArrayList<>();
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	} 
	

}
