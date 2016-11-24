package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.DataTimeStmp2;
import xyz.acmeapps.api.EmuSensor.model.*;


public class DataTimestampService {
	
	public List<SensorDataTimestamp> getDataTs(int num){
		
		DataTimeStmp2 data = new DataTimeStmp2();
		return data.getDataTs(num);
		
		
		
	}
	
	public SensorDataTimestamp getStationTs(int id, int num){
		DataTimeStmp2 data = new DataTimeStmp2();
		return data.getDataTs(num).get(id-1);
		
		
	}

}
