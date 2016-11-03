package xyz.acmeapps.api.EmuSensor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

public class SensorData {
	
	private int id;
	private String name;
	private float latitude;
	private float longitude;
	public List<DataSensor> data = new ArrayList<DataSensor>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public List<DataSensor> getData() {
		return data;
	}
	public void setData(List<DataSensor> data) {
		this.data = data;
	}
	
	
	
	
}
	
	