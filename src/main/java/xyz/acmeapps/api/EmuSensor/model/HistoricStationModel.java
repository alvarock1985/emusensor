package xyz.acmeapps.api.EmuSensor.model;

import java.util.ArrayList;

public class HistoricStationModel {
	
	private int stationId;
	private String stationName;
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	
	
	public ArrayList<Double> dataTemperature = new ArrayList<>();
	public ArrayList<Double> dataHumidity = new ArrayList<>();
	public ArrayList<Double> dataPrecipitation = new ArrayList<>();
	public ArrayList<Double> dataFlow = new ArrayList<>();
	public ArrayList<Double> dataOthers = new ArrayList<>();

}
