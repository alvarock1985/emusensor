package xyz.acmeapps.api.EmuSensor.client;

import xyz.acmeapps.api.EmuSensor.data.StationData;

public class Client {
	
	
	public void insertData(String name, String description, String status, double lat, double lon){
		
		StationData data = new StationData();
		
		data.insertStationData(name, description, status, lat, lon);
		
		
		
		
	}
	

}
