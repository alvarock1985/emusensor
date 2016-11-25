package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.SenDataDB;
import xyz.acmeapps.api.EmuSensor.model.DataSensorDb;
import xyz.acmeapps.api.EmuSensor.model.SensorData;

public class DataSensorService {
	
	public List<SensorData> getDataSensor(){
		SenDataDB data = new SenDataDB();
		return data.getDataSensor();
	}
	
	public void addDataSensor(DataSensorDb dataSensor){
		
		SenDataDB data = new SenDataDB();
		data.insertDataSensor(dataSensor);
		
		
		
	}

}
