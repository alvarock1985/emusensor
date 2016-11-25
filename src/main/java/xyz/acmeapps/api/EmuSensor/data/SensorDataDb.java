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
	
	
	public void insertSensorData(Sensor sensor){
		List<Sensor> data = this.getSensorData();
		int id;
		id = data.size()+1;
		
		try{
			DataBase db = new DataBase();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String insert = "insert into sensor (sensorid, station_stationid, name, type, status) \n"
							+"values ('"+id+"','"+sensor.getStationid()+"','"+sensor.getName()+"','"+sensor.getType()+"','"+sensor.getStatus()+"')";
			statement.executeUpdate(insert);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}
