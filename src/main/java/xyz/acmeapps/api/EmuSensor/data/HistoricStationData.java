package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import xyz.acmeapps.api.EmuSensor.model.HistoricStationModel;

public class HistoricStationData {
	
	public DataBase db = new DataBase();
	public Statement statement;
	
	public HistoricStationModel getHistoricStationData(){
		HistoricStationModel historicData = new HistoricStationModel();
		ArrayList<Double> tempData = historicData.dataTemperature;
		ArrayList<Double> humData = historicData.dataHumidity;
		ArrayList<Double> prepData = historicData.dataPrecipitation;
		ArrayList<Double> cauData = historicData.dataFlow;
		ArrayList<Double> otherData = historicData.dataOthers;
		
		try{
			double dataTempValue;
			double dataHumValue;
			double dataPrepValue;
			double dataCauValue;
			double dataOtherValue;
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select station.description as name, sensor.station_stationid as stationid, datasensor.sensor_sensorid sensorid, sensor.name as sensorName, datasensor.DATA, datasensor.timestamp \n"
							+"from datasensor join sensor on datasensor.SENSOR_SENSORID = sensor.SENSORID \n"
							+"join station on SENSOR.STATION_STATIONID = station.STATIONID \n"
							+"where sensor.station_stationid =1 \n"
							+"order by datasensor.sensor_sensorid asc";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				historicData.setStationId(rs.getInt("stationid"));
				historicData.setStationName(rs.getString("name"));
				if(rs.getString("sensorname").equals("temp")){
					dataTempValue = rs.getDouble("data");
					tempData.add(dataTempValue);
				}else if(rs.getString("sensorname").equals("hum")){
					dataHumValue = rs.getDouble("data");
					humData.add(dataHumValue);
				}else if(rs.getString("sensorname").equals("precip")){
					dataPrepValue = rs.getDouble("data");
					prepData.add(dataPrepValue);
				}else if(rs.getString("sensorname").equals("caudal")){
					dataCauValue = rs.getDouble("data");
					cauData.add(dataCauValue);
				}
				else{
					dataOtherValue = rs.getDouble("data");
					otherData.add(dataOtherValue);
				}
				
				
			}
			con.close();
			rs.close();
			statement.close();
			return historicData;				
			
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		
		
	}
	

}
