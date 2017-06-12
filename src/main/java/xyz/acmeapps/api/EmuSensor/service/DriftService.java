package xyz.acmeapps.api.EmuSensor.service;


import xyz.acmeapps.api.EmuSensor.calc.QuartileCalc;
import xyz.acmeapps.api.EmuSensor.fuzzy.DriftSympthom;
import xyz.acmeapps.api.EmuSensor.fuzzy.Methods;
import xyz.acmeapps.api.EmuSensor.model.DriftModel;

public class DriftService {
	
	QuartileCalc data = new QuartileCalc();
	
	public DriftSympthom getDriftObj(int sensorId){
        double rho = 0.05;
        int tolerance =3;
		Methods met = new Methods();
		DriftModel triangs = new DriftModel();
		
		DriftSympthom results = met.driftSympthomSimple(triangs.getlV(), rho, tolerance);
		
		return results;
		
	}

}
