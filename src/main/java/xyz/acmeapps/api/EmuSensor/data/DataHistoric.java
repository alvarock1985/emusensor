package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.model.DataSensor;
import xyz.acmeapps.api.EmuSensor.model.SensorData;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;
import xyz.acmeapps.api.EmuSensor.model.Station;
import xyz.acmeapps.api.EmuSensor.service.StationService;

public class DataHistoric {
	
	public Statement statement;
	public DataBase db = new DataBase();
	
	public List<SensorData> getStations(){
		
		List<SensorData> dataStations = new ArrayList<SensorData>();
		try{
			
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select * from station";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				SensorData sensordata = new SensorData();
				
				sensordata.setId(rs.getInt("stationid"));
				sensordata.setName(rs.getString("name"));
				sensordata.setLatitude(rs.getFloat("latitude"));
				sensordata.setLongitude(rs.getFloat("longitude"));
				dataStations.add(sensordata);	
			}
			rs.close();
			statement.close();
			con.close();
			System.out.println(dataStations);
			return dataStations;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<SensorData> getAllData(){
		List<SensorData> dataSensor = this.getStations();
		try{
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select sensor.sensorid, sensor.station_stationid, sensor.name, sensor.type, datasensor.data, datasensor.timestamp "
					+ "from sensor join DATASENSOR on sensor.SENSORID = DATASENSOR.SENSOR_SENSORID";

			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				for(int i=0;i<dataSensor.size();i++){
					if(dataSensor.get(i).getId()==rs.getInt("station_stationid")){
						DataSensor data = new DataSensor();
						data.setSensorId(rs.getInt("sensorid"));
						data.setSensorName(rs.getString("name"));
						data.setSensorType(rs.getString("type"));
						data.setSensorData(rs.getInt("data"));
						data.setSensorTimestamp(rs.getTimestamp("timestamp"));
						dataSensor.get(i).data.add(data);
					}	
				}		
			}
			statement.close();
			rs.close();
			con.close();
			
			return dataSensor;
		}
		catch(Exception e){
			return null;
		}	
	}
}
