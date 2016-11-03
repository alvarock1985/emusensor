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

}
