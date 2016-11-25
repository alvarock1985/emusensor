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
	
	
	public List<DataSensorDb> getDataSensorDb(){
		DataBase db = new DataBase();
		try{
			List<DataSensorDb> data = new ArrayList<>();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select * from datasensor";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				DataSensorDb dataSensorDb = new DataSensorDb();
				dataSensorDb.setId(rs.getInt("dataid"));
				dataSensorDb.setSensorid(rs.getInt("sensor_sensorid"));
				dataSensorDb.setData(rs.getInt("data"));
				dataSensorDb.setTimestamp(rs.getDate("timestamp"));
				data.add(dataSensorDb);
			}
			return data;
			
		}
		catch(Exception e){
			System.out.print(e);
			return null;
		}
	}
	
	public int getMaxSensorId(){
		int value = 0;
		try{
			DataBase db = new DataBase();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select max(sensor_sensorid) as data from datasensor";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				value = rs.getInt("data");
			}return value;
		}
		catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}
	
	
	
	
	
	
	public void insertDataSensor(DataSensorDb dataSensor){
		List<DataSensorDb> data = this.getDataSensorDb();
		int id;
		id = data.size()+1;
		try{
			DataBase db = new DataBase();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String insert = "insert into datasensor (dataid, sensor_sensorid, data, timestamp) \n "
							+"values ('"+id+"','"+dataSensor.getSensorid()+"','"+dataSensor.getData()+"','"+dataSensor.getTimestamp()+"')";
			statement.executeUpdate(insert);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
