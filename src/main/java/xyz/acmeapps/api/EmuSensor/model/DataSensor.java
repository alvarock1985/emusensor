package xyz.acmeapps.api.EmuSensor.model;

import java.util.Date;

public class DataSensor {
	
	private int sensorId;
	public int getSensorId() {
		return sensorId;
	}
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	private String sensorName;
	private String sensorType;
	private int sensorData;
	private Date sensorTimestamp;
	
	public String getSensorName() {
		return sensorName;
	}
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public int getSensorData() {
		return sensorData;
	}
	public void setSensorData(int sensorData) {
		this.sensorData = sensorData;
	}
	public Date getSensorTimestamp() {
		return sensorTimestamp;
	}
	public void setSensorTimestamp(Date sensorTimestamp) {
		this.sensorTimestamp = sensorTimestamp;
	}
	
	
	
	

}
