package xyz.acmeapps.api.EmuSensor.model;

import java.util.ArrayList;

/**
 * Created by alvaro on 21-11-16.
 */
public class SensorDataTimestamp {

    private int id;
    private String name;
    private float humData;
    private float caudalData;
    private float tempData;
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
	public float getHumData() {
		return humData;
	}
	public void setHumData(float humData) {
		this.humData = humData;
	}
	public float getCaudalData() {
		return caudalData;
	}
	public void setCaudalData(float caudalData) {
		this.caudalData = caudalData;
	}
	public float getTempData() {
		return tempData;
	}
	public void setTempData(float tempData) {
		this.tempData = tempData;
	}
	
	public ArrayList<Integer> dataArrayTemp = new ArrayList<>();
	public ArrayList<Integer> dataArrayHum = new ArrayList<>();
	public ArrayList<Integer> dataArrayCau = new ArrayList<>();
    
    

}
