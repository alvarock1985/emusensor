package xyz.acmeapps.api.EmuSensor.model;

import java.sql.Timestamp;
import java.util.Date;


public class DataSensorDb {
	
	private int id;
	private int sensorid;
	private int data;
	private Timestamp timestamp;
	//private String timestampString;
	
	
	/*public String getTimestampString() {
		return timestampString;
	}
	public void setTimestampString(String timestampString) {
		this.timestampString = timestampString;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSensorid() {
		return sensorid;
	}
	public void setSensorid(int sensorid) {
		this.sensorid = sensorid;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
