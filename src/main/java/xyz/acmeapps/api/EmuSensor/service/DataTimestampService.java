package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp;
import xyz.acmeapps.api.EmuSensor.model.*;


public class DataTimestampService {
	
	public List<SensorDataTimestamp> getDataTs(int num, int riverId){
		
		DataTimeStmp data = new DataTimeStmp();
		return data.getDataTimestamp(num, riverId);
		
		
		
	}
	
	public SensorDataTimestamp getStationTs(int id, int num, int riverId){
		DataTimeStmp data = new DataTimeStmp();
		return data.getDataTimestamp(num, riverId).get(id-1);
		
		
	}
	
	public SensorDataTimestamp getDataArray(int id, int num, int riverId){
		DataTimeStmp data = new DataTimeStmp();
		return data.getDataArrayTimestamp(num, riverId).get(id-1);
		
		
	}

}
