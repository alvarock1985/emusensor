package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.model.Station;

public class StationData {
	public Statement statement;
	
	public List<Station> getStationData(){
		DataBase db = new DataBase();
		
		try{
			List<Station> stations = new ArrayList<Station>();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery("Select * from station");
			while(rs.next()){
				Station station = new Station();
				station.setId(rs.getInt("stationid"));
				station.setName(rs.getString("name"));
				station.setDescription(rs.getString("description"));
				station.setLatitude(rs.getFloat("latitude"));
				station.setLongitude(rs.getFloat("longitude"));
				stations.add(station);
			}
			System.out.println(stations);
			return stations;
			
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	public void insertStationData(Station station){
		
		List<Station> data = this.getStationData();
		int id;
		id = data.size()+1;
		System.out.println(id);
		
		try{
			DataBase db = new DataBase();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String insert = "insert into station (stationid, name, description, status, latitude, longitude) \n"
							+"values ('"+id+"','"+station.getName()+"','"+station.getDescription()+"','"+station.getStatus()+"','"+station.getLatitude()+"','"+station.getLongitude()+"')";
			statement.executeUpdate(insert);
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
	}
	
}