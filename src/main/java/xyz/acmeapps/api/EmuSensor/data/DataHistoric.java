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

	
	public List<SensorData> getStations(){
		DataBase db = new DataBase();
		List<SensorData> datasensor = new ArrayList<SensorData>();
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
				datasensor.add(sensordata);

						
			}
			System.out.println(datasensor);
			return datasensor;
				
			
		}
		catch(Exception e){
			return null;
			
		}
		
		

		
		
	}
	 
	 

}
