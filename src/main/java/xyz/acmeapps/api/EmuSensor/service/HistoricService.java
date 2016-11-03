package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.DataHistoric2;
import xyz.acmeapps.api.EmuSensor.model.SensorData;

public class HistoricService {
	
	public List<SensorData> getHistoricData(){
		DataHistoric2 data = new DataHistoric2();
		return data.getAllData();
		
		
	}

}
