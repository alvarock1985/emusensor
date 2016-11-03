package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.StationData;
import xyz.acmeapps.api.EmuSensor.model.Station;

public class StationService {
	
	public List<Station> getAllStations(){
		StationData sd = new StationData();
		return sd.getStationData();
	}

}
