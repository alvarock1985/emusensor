package xyz.acmeapps.api.EmuSensor.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class HistoricDataModel {
	private int sensorId;
	
	
	
	
	public int getSensorId() {
		return sensorId;
	}
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	public ArrayList<Double> dataList = new ArrayList<>();
	public ArrayList<Timestamp> timeStampList = new ArrayList<>();

	

}
