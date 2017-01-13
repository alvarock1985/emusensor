package xyz.acmeapps.api.EmuSensor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xyz.acmeapps.api.EmuSensor.model.Station;

public class StationData {
	public Statement statement;
	public DataBase db = new DataBase();
	public List<Station> getStationData(int watershedId){

		try{
			List<Station> stations = new ArrayList<Station>();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select station.stationid, station.name, station.description, station.status, \n"
						+"station.latitude, station.longitude, station.type, watershed.id as watershedid, watershed.name as river \n"
						+"from station join watershed on station.watershedid = watershed.id \n"
						+"where watershed.id = "+watershedId;
			
			ResultSet rs = statement.executeQuery(query);
			
			
			
			while(rs.next()){
				Station station = new Station();
				station.setId(rs.getInt("stationid"));
				station.setName(rs.getString("name"));
				station.setDescription(rs.getString("description"));
				station.setLatitude(rs.getFloat("latitude"));
				station.setLongitude(rs.getFloat("longitude"));
				station.setWatershedId(rs.getInt("watershedid"));
				station.setType(rs.getString("type"));
				station.setWatershedName(rs.getString("river"));
				stations.add(station);
			}
			rs.close();
			statement.close();
			con.close();
			System.out.println(stations);
			return stations;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public List<Station> getAllStationsData(){
		try{
			List<Station> stations = new ArrayList<Station>();
			Connection con = db.connectToDb();
			statement = con.createStatement();
			String query = "select * from station";
			
			ResultSet rs = statement.executeQuery(query);
			
			
			
			while(rs.next()){
				Station station = new Station();
				station.setId(rs.getInt("stationid"));
				station.setName(rs.getString("name"));
				station.setDescription(rs.getString("description"));
				station.setLatitude(rs.getFloat("latitude"));
				station.setLongitude(rs.getFloat("longitude"));
				station.setWatershedId(rs.getInt("watershedid"));
				station.setType(rs.getString("type"));
				//station.setWatershedName(rs.getString("river"));
				stations.add(station);
			}
			rs.close();
			statement.close();
			con.close();
			System.out.println(stations);
			return stations;
		}
		catch(Exception e){
			return null;
		}
		
		
		
	}
	
	public void insertStationData(Station station){
		
		List<Station> data = this.getAllStationsData();
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
			statement.close();
			con.close();
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
}