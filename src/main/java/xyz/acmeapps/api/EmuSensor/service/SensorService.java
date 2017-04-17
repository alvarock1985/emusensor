package xyz.acmeapps.api.EmuSensor.service;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.*;
import xyz.acmeapps.api.EmuSensor.data.SensorDataDb;
import xyz.acmeapps.api.EmuSensor.model.Sensor;

public class SensorService {
	
	public List<Sensor> getAllSensors(){
		SensorDataDb data = new SensorDataDb();
		return data.getSensorData();
		
	}
	
	public void addSensor(Sensor sensor){
		SensorDataDb data = new SensorDataDb();
		data.insertSensorData(sensor);
		
	}
	
	public void updateSensorStatus(Sensor sensor){
		SensorDataDb data = new SensorDataDb();
		data.updateSensorStatus(sensor);
	}

	
	public List<Sensor> getSensor(int sensorId){
		SensorDataDb data = new SensorDataDb();
		return data.getSensor(sensorId);
	}
}
