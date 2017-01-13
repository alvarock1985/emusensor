package xyz.acmeapps.api.EmuSensor.service;

import xyz.acmeapps.api.EmuSensor.calc.QuartileCalc;
import xyz.acmeapps.api.EmuSensor.model.QuartileDataModel;

public class QuartileService {
	public QuartileCalc data = new QuartileCalc();
	
	public QuartileDataModel getQuartileCalc(){
		return data.quartileCalc();
	}
	
	public QuartileDataModel getQuartileLastData(int riverId){
		return data.quartileCalcLastData(riverId);
		
	}
	
}
