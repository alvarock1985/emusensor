package xyz.acmeapps.api.EmuSensor.model;

import java.sql.Timestamp;
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
	private Timestamp sensorTimestamp;
	
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
	public Timestamp getSensorTimestamp() {
		return sensorTimestamp;
	}
	public void setSensorTimestamp(Timestamp sensorTimestamp) {
		this.sensorTimestamp = sensorTimestamp;
	}
	
	
	
	

}
