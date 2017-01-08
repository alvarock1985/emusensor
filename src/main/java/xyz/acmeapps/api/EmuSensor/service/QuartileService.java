package xyz.acmeapps.api.EmuSensor.service;

import xyz.acmeapps.api.EmuSensor.calc.QuartileCalc;
import xyz.acmeapps.api.EmuSensor.model.QuartileDataModel;

public class QuartileService {
	
	public QuartileDataModel getQuartileCalc(){
		
		QuartileCalc data = new QuartileCalc();
		return data.quartileCalc();
		
		
	}
	
}
