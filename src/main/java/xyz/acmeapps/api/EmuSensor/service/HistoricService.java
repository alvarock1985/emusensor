package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.DataHistoric;

import xyz.acmeapps.api.EmuSensor.model.SensorData;

public class HistoricService {
	
	public List<SensorData> getHistoricData(){
		DataHistoric data = new DataHistoric();
		return data.getAllData();
		
		
	}

}


