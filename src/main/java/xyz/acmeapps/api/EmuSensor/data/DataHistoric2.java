package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.model.DataSensor;
import xyz.acmeapps.api.EmuSensor.model.SensorData;

public class DataHistoric2 {
	public Statement statement;
	DataHistoric datah = new DataHistoric();
	public List<SensorData> datasensor = datah.getStations();
	
	
	public List<SensorData> getAllData(){
		DataBase db = new DataBase();

		try{
			
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select sensor.sensorid, sensor.station_stationid, sensor.name, sensor.type, datasensor.data, datasensor.timestamp "
					+ "from sensor join DATASENSOR on sensor.SENSORID = DATASENSOR.SENSOR_SENSORID";

			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				for(int i=0;i<datasensor.size();i++){
					if(datasensor.get(i).getId()==rs.getInt("station_stationid")){
						DataSensor data = new DataSensor();
						data.setSensorId(rs.getInt("sensorid"));
						data.setSensorName(rs.getString("name"));
						data.setSensorType(rs.getString("type"));
						data.setSensorData(rs.getInt("data"));
						data.setSensorTimestamp(rs.getDate("timestamp"));
						datasensor.get(i).data.add(data);
					}
					
				}
				
			}return datasensor;
			
			
		}catch(Exception e){
			return null;
		}
		
	}
	
	

}
