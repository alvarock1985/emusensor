package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.SenDataDB;
import xyz.acmeapps.api.EmuSensor.model.DataSensorDb;
import xyz.acmeapps.api.EmuSensor.model.DataSensorProto;
import xyz.acmeapps.api.EmuSensor.model.SensorData;

public class DataSensorService {
	
	public List<DataSensorDb> getDataSensor(){
		SenDataDB data = new SenDataDB();
		return data.getDataSensorDb();
	}
	
	public void addDataSensor(DataSensorDb dataSensor){
		
		SenDataDB data = new SenDataDB();
		data.insertDataSensor(dataSensor);
		
		
		
	}
	
	public void addDataSensorProto(DataSensorProto dataSensorProto){
		SenDataDB data = new SenDataDB();
		data.insertDataSensorProto(dataSensorProto);
	}

}
