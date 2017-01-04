package xyz.acmeapps.api.EmuSensor.calc;

import xyz.acmeapps.api.EmuSensor.data.HistoricStationData;
import xyz.acmeapps.api.EmuSensor.model.HistoricDataModel;
import xyz.acmeapps.api.EmuSensor.model.HistoricStationModel;

public class QuartileCalc {
	
	public HistoricStationData historicData = new HistoricStationData();

	public void quartileCalc(){
		
		
		HistoricStationModel hModel = historicData.getHistoricStationData();
		double[] tempDataValues = new double[hModel.dataTemperature.size()];
		for(int i=0; i<tempDataValues.length;i++){
			tempDataValues[i] = hModel.dataTemperature.get(i); 
		}
		
		double min = Quartile.min(tempDataValues);
		double medianLow = Quartile.quartile(tempDataValues, 25);
		double medianMid = Quartile.quartile(tempDataValues, 50);
		double medianHigh = Quartile.quartile(tempDataValues, 75);
		double max = Quartile.max(tempDataValues);
		
		System.out.println(min);
		System.out.println(medianLow);
		System.out.println(medianMid);
		System.out.println(medianHigh);
		System.out.println(max);
		
		
	}



}
