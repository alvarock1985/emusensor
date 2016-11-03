package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.model.Sensor;
//Extracts data from SENSOR table
public class SensorDataDb {
	
	public Statement statement;
	
	public List<Sensor> getSensorData(){
		DataBase db = new DataBase();
		
		try{
			Connection con = db.connectToDb();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery("Select * from sensor");
			List<Sensor> sensors = new ArrayList<Sensor>();
			while(rs.next()){
				Sensor sensor = new Sensor();
				sensor.setId(rs.getInt("sensorid"));
				sensor.setStationid(rs.getInt("station_stationid"));
				sensor.setName(rs.getString("name"));
				sensor.setType(rs.getString("type"));
				sensors.add(sensor);
			}return sensors;
			
			
		}
		catch(Exception e){
			return null;
		}
	}

}
