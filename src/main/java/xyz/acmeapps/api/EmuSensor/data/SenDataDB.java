package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
				data.setSensorTimestamp(rs.getTimestamp(7));
				sensordata.data.add(data);
				datasensor.add(sensordata);
				
			}
			rs.close();
			statement.close();
			con.close();
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
				dataSensorDb.setTimestamp(rs.getTimestamp("timestamp"));
				data.add(dataSensorDb);
			}
			rs.close();
			statement.close();
			con.close();
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
			String query = "select max(dataid) as data from datasensor";
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				value = rs.getInt("data");
			}
			rs.close();
			statement.close();
			con.close();
			
			return value;
		}
		catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}
	
	
	
	
	
	
	public void insertDataSensor(DataSensorDb dataSensor){
		
		int id;
		id = this.getMaxSensorId()+1;
		try{
			DataBase db = new DataBase();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			Date timeValue = dataSensor.getTimestamp();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss");
			
			System.out.println(sdf.format(timeValue));
			String insert = "insert into datasensor (dataid, sensor_sensorid, data, timestamp) \n "
				+"values ('"+id+"','"+dataSensor.getSensorid()+"','"+dataSensor.getData()+"',to_timestamp('"+sdf.format(timeValue)+"','YYYY/MM/DD HH24:MI:SS.FF'))";

			System.out.println(insert);
			statement.executeUpdate(insert);
			
			statement.close();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
