package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.StationData;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;
import xyz.acmeapps.api.EmuSensor.model.Station;

public class StationService {
	public StationData sd = new StationData();
	
	public List<Station> getAllStations(){
		return sd.getAllStationsData();
	}
	
	public List<Station> getStations(int riverId){
		return sd.getStationData(riverId);
	}
	
	public void addStation(Station station){
		sd.insertStationData(station);
	}
	
	public List<SensorDataTimestamp> getStationData(int stationId){
		return sd.getDataArrayTime(stationId);
	}
	
	public List<SensorDataTimestamp> getStationDataTimeRange(int stationId, int timeRange){
		return sd.getDataArrayTimeRange(stationId, timeRange);
	}
	
	public void updateStationStatus(Station station){
		sd.updateStationStatus(station);
	}

}
