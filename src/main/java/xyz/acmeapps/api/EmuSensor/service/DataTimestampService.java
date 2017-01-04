package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp;
import xyz.acmeapps.api.EmuSensor.model.*;


public class DataTimestampService {
	
	public List<SensorDataTimestamp> getDataTs(int num){
		
		DataTimeStmp data = new DataTimeStmp();
		return data.getDataTimestamp(num);
		
		
		
	}
	
	public SensorDataTimestamp getStationTs(int id, int num){
		DataTimeStmp data = new DataTimeStmp();
		return data.getDataTimestamp(num).get(id-1);
		
		
	}
	
	public SensorDataTimestamp getDataArray(int id, int num){
		DataTimeStmp data = new DataTimeStmp();
		return data.getDataArrayTimestamp(num).get(id-1);
		
		
	}

}
