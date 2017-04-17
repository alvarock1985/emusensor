package xyz.acmeapps.api.EmuSensor;

import xyz.acmeapps.api.EmuSensor.calc.QuartileCalc;

import java.util.ArrayList;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.model.Sensor;
import xyz.acmeapps.api.EmuSensor.data.HistoricData;
import xyz.acmeapps.api.EmuSensor.data.HistoricStationData;
import xyz.acmeapps.api.EmuSensor.data.SensorDataDb;

public class Test {

	public static void main(String[] args) {
		
		SensorDataDb hola = new SensorDataDb();
		
		List<Sensor> uno = new ArrayList<Sensor>();
		
		uno = hola.getSensor(1);
		
		for(int i =0;i<uno.size();i++){
			
			System.out.println(uno.get(i).getName());
			
		}
		
		
		
		
		
		
	}

}
