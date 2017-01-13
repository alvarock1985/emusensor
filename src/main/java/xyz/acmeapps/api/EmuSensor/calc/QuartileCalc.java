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
			quartileModel.tempArray.add(quartileModel.getTempMin());
			quartileModel.tempArray.add(quartileModel.getTempLow());
			quartileModel.tempArray.add(quartileModel.getTempMid());
			quartileModel.tempArray.add(quartileModel.getTempHigh());
			quartileModel.tempArray.add(quartileModel.getTempMax());
			
		}else{
			System.out.println("Temp list is empty");
		}
		
		if(humDataValues.length !=0){
			quartileModel.setHumMin(Quartile.min(humDataValues));
			quartileModel.setHumLow(Quartile.quartile(humDataValues, 25));
			quartileModel.setHumMid(Quartile.quartile(humDataValues, 50));
			quartileModel.setHumHigh(Quartile.quartile(humDataValues, 75));
			quartileModel.setHumMax(Quartile.max(humDataValues));
			quartileModel.humArray.add(quartileModel.getHumMin());
			quartileModel.humArray.add(quartileModel.getHumLow());
			quartileModel.humArray.add(quartileModel.getHumMid());
			quartileModel.humArray.add(quartileModel.getHumHigh());
			quartileModel.humArray.add(quartileModel.getHumMax());
		}else{
			System.out.println("Hum list is empty");
		}
		
		if(cauDataValues.length !=0){
			quartileModel.setCauMin(Quartile.min(cauDataValues));
			quartileModel.setCauLow(Quartile.quartile(cauDataValues, 25));
			quartileModel.setCauMid(Quartile.quartile(cauDataValues, 50));
			quartileModel.setCauHigh(Quartile.quartile(cauDataValues, 75));
			quartileModel.setCauMax(Quartile.max(cauDataValues));
			quartileModel.cauArray.add(quartileModel.getCauMin());
			quartileModel.cauArray.add(quartileModel.getCauLow());
			quartileModel.cauArray.add(quartileModel.getCauMid());
			quartileModel.cauArray.add(quartileModel.getCauHigh());
			quartileModel.cauArray.add(quartileModel.getCauMax());
			
		}else{
			System.out.println("cau list is empty");
		}
		
		if(prepDataValues.length !=0){
			quartileModel.setPrepMin(Quartile.min(prepDataValues));
			quartileModel.setPrepLow(Quartile.quartile(prepDataValues, 25));
			quartileModel.setPrepMid(Quartile.quartile(prepDataValues, 50));
			quartileModel.setPrepHigh(Quartile.quartile(prepDataValues, 75));
			quartileModel.setPrepMax(Quartile.max(prepDataValues));
			quartileModel.prepArray.add(quartileModel.getPrepMin());
			quartileModel.prepArray.add(quartileModel.getPrepLow());
			quartileModel.prepArray.add(quartileModel.getPrepMid());
			quartileModel.prepArray.add(quartileModel.getPrepHigh());
			quartileModel.prepArray.add(quartileModel.getPrepMax());
		}else{
			System.out.println("prep list is empty");
		}
		
		if(otherDataValues.length !=0){
			
			quartileModel.setOtherMin(Quartile.min(otherDataValues));
			quartileModel.setOtherLow(Quartile.quartile(otherDataValues, 25));
			quartileModel.setOtherMid(Quartile.quartile(otherDataValues, 50));
			quartileModel.setOtherHigh(Quartile.quartile(otherDataValues, 75));
			quartileModel.setOtherMax(Quartile.max(otherDataValues));
			quartileModel.otherArray.add(quartileModel.getOtherMin());
			quartileModel.otherArray.add(quartileModel.getOtherLow());
			quartileModel.otherArray.add(quartileModel.getOtherMid());
			quartileModel.otherArray.add(quartileModel.getOtherHigh());
			quartileModel.otherArray.add(quartileModel.getOtherMax());
			
		}else{
			System.out.println("other list is empty");
		}
		return quartileModel;
	}
	
	public QuartileDataModel quartileCalcLastData(int riverId){
		
		
		QuartileDataModel quartileModel = new QuartileDataModel();
		HistoricStationModel hModel = historicData.getLastDataRiver(riverId);
		
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
			quartileModel.tempArray.add(quartileModel.getTempMin());
			quartileModel.tempArray.add(quartileModel.getTempLow());
			quartileModel.tempArray.add(quartileModel.getTempMid());
			quartileModel.tempArray.add(quartileModel.getTempHigh());
			quartileModel.tempArray.add(quartileModel.getTempMax());
			
		}else{
			for(int i=1;i<=5;i++){
				quartileModel.tempArray.add(0.0);
			}
			System.out.println("Temp list is empty");
		}
		
		if(humDataValues.length !=0){
			quartileModel.setHumMin(Quartile.min(humDataValues));
			quartileModel.setHumLow(Quartile.quartile(humDataValues, 25));
			quartileModel.setHumMid(Quartile.quartile(humDataValues, 50));
			quartileModel.setHumHigh(Quartile.quartile(humDataValues, 75));
			quartileModel.setHumMax(Quartile.max(humDataValues));
			quartileModel.humArray.add(quartileModel.getHumMin());
			quartileModel.humArray.add(quartileModel.getHumLow());
			quartileModel.humArray.add(quartileModel.getHumMid());
			quartileModel.humArray.add(quartileModel.getHumHigh());
			quartileModel.humArray.add(quartileModel.getHumMax());
		}else{
			for(int i=1;i<=5;i++){
				quartileModel.humArray.add(0.0);
			}
			System.out.println("Hum list is empty");
		}
		
		if(cauDataValues.length !=0){
			quartileModel.setCauMin(Quartile.min(cauDataValues));
			quartileModel.setCauLow(Quartile.quartile(cauDataValues, 25));
			quartileModel.setCauMid(Quartile.quartile(cauDataValues, 50));
			quartileModel.setCauHigh(Quartile.quartile(cauDataValues, 75));
			quartileModel.setCauMax(Quartile.max(cauDataValues));
			quartileModel.cauArray.add(quartileModel.getCauMin());
			quartileModel.cauArray.add(quartileModel.getCauLow());
			quartileModel.cauArray.add(quartileModel.getCauMid());
			quartileModel.cauArray.add(quartileModel.getCauHigh());
			quartileModel.cauArray.add(quartileModel.getCauMax());
			
		}else{
			for(int i=1;i<=5;i++){
				quartileModel.cauArray.add(0.0);
			}
			System.out.println("cau list is empty");
		}
		
		if(prepDataValues.length !=0){
			quartileModel.setPrepMin(Quartile.min(prepDataValues));
			quartileModel.setPrepLow(Quartile.quartile(prepDataValues, 25));
			quartileModel.setPrepMid(Quartile.quartile(prepDataValues, 50));
			quartileModel.setPrepHigh(Quartile.quartile(prepDataValues, 75));
			quartileModel.setPrepMax(Quartile.max(prepDataValues));
			quartileModel.prepArray.add(quartileModel.getPrepMin());
			quartileModel.prepArray.add(quartileModel.getPrepLow());
			quartileModel.prepArray.add(quartileModel.getPrepMid());
			quartileModel.prepArray.add(quartileModel.getPrepHigh());
			quartileModel.prepArray.add(quartileModel.getPrepMax());
		}else{
			for(int i=1;i<=5;i++){
				quartileModel.prepArray.add(0.0);
			}
			System.out.println("prep list is empty");
		}
		
		if(otherDataValues.length !=0){
			
			quartileModel.setOtherMin(Quartile.min(otherDataValues));
			quartileModel.setOtherLow(Quartile.quartile(otherDataValues, 25));
			quartileModel.setOtherMid(Quartile.quartile(otherDataValues, 50));
			quartileModel.setOtherHigh(Quartile.quartile(otherDataValues, 75));
			quartileModel.setOtherMax(Quartile.max(otherDataValues));
			quartileModel.otherArray.add(quartileModel.getOtherMin());
			quartileModel.otherArray.add(quartileModel.getOtherLow());
			quartileModel.otherArray.add(quartileModel.getOtherMid());
			quartileModel.otherArray.add(quartileModel.getOtherHigh());
			quartileModel.otherArray.add(quartileModel.getOtherMax());
			
		}else{
			for(int i=1;i<=5;i++){
				quartileModel.otherArray.add(0.0);
			}
			System.out.println("other list is empty");
		}
		return quartileModel;
	}
	
}
