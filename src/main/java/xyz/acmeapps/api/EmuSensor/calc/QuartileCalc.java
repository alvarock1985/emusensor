package xyz.acmeapps.api.EmuSensor.calc;

import xyz.acmeapps.api.EmuSensor.data.HistoricStationData;
import xyz.acmeapps.api.EmuSensor.model.HistoricDataModel;
import xyz.acmeapps.api.EmuSensor.model.HistoricStationModel;
import xyz.acmeapps.api.EmuSensor.model.QuartileDataModel;

public class QuartileCalc {
	
	public HistoricStationData historicData = new HistoricStationData();

	public QuartileDataModel quartileCalc(){
		
		QuartileDataModel quartileModel = new QuartileDataModel();
		HistoricStationModel hModel = historicData.getHistoricStationData();
		double[] tempDataValues = new double[hModel.dataTemperature.size()];
		for(int i=0; i<tempDataValues.length;i++){
			tempDataValues[i] = hModel.dataTemperature.get(i); 
		}
		
		double[] humDataValues = new double[hModel.dataHumidity.size()];
		for(int i=0;i<humDataValues.length;i++){
			humDataValues[i] = hModel.dataHumidity.get(i);
		}
		
		double[] prepDataValues = new double[hModel.dataPrecipitation.size()];
		for(int i=0; i<prepDataValues.length;i++){
			prepDataValues[i] = hModel.dataPrecipitation.get(i);
		}
		
		double[] cauDataValues = new double[hModel.dataFlow.size()];
		for(int i=0;i<cauDataValues.length;i++){
			cauDataValues[i] = hModel.dataFlow.get(i);
		}
		
		double[] otherDataValues = new double[hModel.dataOthers.size()];
		for(int i=0;i<otherDataValues.length;i++){
			otherDataValues[i] = hModel.dataOthers.get(i);
		}
		
		
		quartileModel.setStationName(hModel.getStationName());
		if(tempDataValues.length !=0){
			quartileModel.setTempMin(Quartile.min(tempDataValues));
			quartileModel.setTempLow(Quartile.quartile(tempDataValues, 25));
			quartileModel.setTempMid(Quartile.quartile(tempDataValues, 50));
			quartileModel.setTempHigh(Quartile.quartile(tempDataValues, 75));
			quartileModel.setTempMax(Quartile.max(tempDataValues));
			
		}else{
			System.out.println("Temp list is empty");
		}
		
		if(humDataValues.length !=0){
			quartileModel.setHumMin(Quartile.min(humDataValues));
			quartileModel.setHumLow(Quartile.quartile(humDataValues, 25));
			quartileModel.setHumMid(Quartile.quartile(humDataValues, 50));
			quartileModel.setHumHigh(Quartile.quartile(humDataValues, 75));
			quartileModel.setHumMax(Quartile.max(humDataValues));
			
		}else{
			System.out.println("Hum list is empty");
		}
		
		if(cauDataValues.length !=0){
			quartileModel.setCauMin(Quartile.min(cauDataValues));
			quartileModel.setCauLow(Quartile.quartile(cauDataValues, 25));
			quartileModel.setCauMid(Quartile.quartile(cauDataValues, 50));
			quartileModel.setCauHigh(Quartile.quartile(cauDataValues, 75));
			quartileModel.setCauMax(Quartile.max(cauDataValues));
			
		}else{
			System.out.println("cau list is empty");
		}
		
		if(prepDataValues.length !=0){
			quartileModel.setPrepMin(Quartile.min(prepDataValues));
			quartileModel.setPrepLow(Quartile.quartile(prepDataValues, 25));
			quartileModel.setPrepMid(Quartile.quartile(prepDataValues, 50));
			quartileModel.setPrepHigh(Quartile.quartile(prepDataValues, 75));
			quartileModel.setPrepMax(Quartile.max(prepDataValues));
			
		}else{
			System.out.println("prep list is empty");
		}
		
		if(otherDataValues.length !=0){
			
			quartileModel.setOtherMin(Quartile.min(otherDataValues));
			quartileModel.setOtherLow(Quartile.quartile(otherDataValues, 25));
			quartileModel.setOtherMid(Quartile.quartile(otherDataValues, 50));
			quartileModel.setOtherHigh(Quartile.quartile(otherDataValues, 75));
			quartileModel.setOtherMax(Quartile.max(otherDataValues));
			
		}else{
			System.out.println("other list is empty");
		}

		

		

		


		
		
		return quartileModel;
	}
}
