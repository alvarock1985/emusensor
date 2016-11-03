package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.model.*;
//Extracts data from DATASENSOR table
public class SenDataDB {
	
	public Statement statement;
	
	public List<SensorData> getDataSensor(){
		DataBase db = new DataBase();
		
		try{
			List<SensorData> datasensor = new ArrayList<SensorData>();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select station.name,station.latitude, station.longitude, sensor.name, sensor.type, datasensor.data, datasensor.timestamp "
					+ "from sensor "
					+ "join STATION on sensor.STATION_STATIONID = STATION.STATIONID "
					+ "join datasensor on datasensor.SENSOR_SENSORID = sensor.SENSORID "
					+ "order by station.name";
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()){
				DataSensor data = new DataSensor();
				SensorData sensordata = new SensorData();
				sensordata.setName(rs.getString(1));
				sensordata.setLatitude(rs.getFloat(2));
				sensordata.setLongitude(rs.getFloat(3));
				data.setSensorName(rs.getString(4));
				data.setSensorType(rs.getString(5));
				data.setSensorData(rs.getInt(6));
				data.setSensorTimestamp(rs.getDate(7));
				sensordata.data.add(data);
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
