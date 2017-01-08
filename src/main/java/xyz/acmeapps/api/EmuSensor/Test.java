package xyz.acmeapps.api.EmuSensor;

import xyz.acmeapps.api.EmuSensor.calc.QuartileCalc;
import xyz.acmeapps.api.EmuSensor.data.HistoricData;
import xyz.acmeapps.api.EmuSensor.data.HistoricStationData;

public class Test {

	public static void main(String[] args) {
		
		QuartileCalc qc = new QuartileCalc();
		System.out.println(qc.quartileCalc());
		
	}

}
