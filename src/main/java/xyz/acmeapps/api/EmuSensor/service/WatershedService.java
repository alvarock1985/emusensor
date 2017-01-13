package xyz.acmeapps.api.EmuSensor.service;

import java.util.List;

import xyz.acmeapps.api.EmuSensor.data.WatershedData;
import xyz.acmeapps.api.EmuSensor.model.Watershed;

public class WatershedService {
	public WatershedData data = new WatershedData();
	
	
	public List<Watershed> getAllRivers(){
		return data.getAllRivers();
	}

}
